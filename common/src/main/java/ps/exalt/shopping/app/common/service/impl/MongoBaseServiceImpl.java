//////////////////////////////////////////////////
////          author: Nour
////          filename: MongoBaseServiceImpl.java
////          2023
//////////////////////////////////////////////////
package ps.exalt.shopping.app.common.service.impl;

import lombok.SneakyThrows;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.common.dto.BaseRequest;
import ps.exalt.shopping.app.common.dto.BaseResponse;
import ps.exalt.shopping.app.common.error.exception.OperationFailedException;
import ps.exalt.shopping.app.common.model.BaseModel;
import ps.exalt.shopping.app.common.service.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public abstract class MongoBaseServiceImpl<RQ extends BaseRequest<K>,
        M extends BaseModel<K>, RS extends BaseResponse, K>
        implements BaseService<RQ, M, RS, K> {

    public abstract M requestToModel(RQ rq);

    private List<RS> modelToResponse(List<M> mList) {
        return mList.stream().map(this::modelToResponse).collect(Collectors.toList());
    }

    public abstract RS modelToResponse(M m);

    public abstract MongoRepository<M, K> getMongoRepository();

    @SneakyThrows
    public RS create(RQ rq) {
        M model = requestToModel(rq);
        return modelToResponse(getMongoRepository().save(model));
    }

    @SneakyThrows
    public void delete(K k) {
        Optional<M> m = getMongoRepository().findById(k);
        if (m.isPresent()) {

            getMongoRepository().deleteById(k);
        } else {
            throw OperationFailedException.createOperationFailedException(getResourceBundle(), "COMMON_00002", k);
        }
    }

    @Override
    public List<RS> read() {

        List<M> baseModels = getMongoRepository().findAll();
        return modelToResponse(baseModels);
    }

    @SneakyThrows
    @Override
    public RS read(K k) {

        Optional<M> m = getMongoRepository().findById(k);
        if (m.isPresent()) {
            return modelToResponse(getMongoRepository().findById(k).get());
        } else {
            throw OperationFailedException.createOperationFailedException(getResourceBundle(), "COMMON_00002", k);
        }
    }

    @Override
    public void update(RQ rq) {
        M oldModel = getMongoRepository().findById(rq.getId()).orElseThrow();
        M newModel = requestToModel(rq);
        newModel.setCreationTime(oldModel.getCreationTime());
        getMongoRepository().save(newModel);
    }

    @Override
    public boolean idExists(K k) {
        return getMongoRepository().existsById(k);
    }
}
