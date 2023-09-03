//////////////////////////////////////////////////
////          author: Nour
////          filename: MySqlBaseServiceImpl.java
////          2023
//////////////////////////////////////////////////
package ps.exalt.shopping.app.common.service.impl;

import lombok.SneakyThrows;
import org.springframework.data.jpa.repository.JpaRepository;
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
public abstract class MySqlBaseServiceImpl<RQ extends BaseRequest<K>,
        M extends BaseModel<K>, RS extends BaseResponse, K>
        implements BaseService<RQ, M, RS, K> {

    public abstract M requestToModel(RQ rq);

    private List<RS> modelToResponse(List<M> mList) {
        return mList.stream().map(this::modelToResponse).collect(Collectors.toList());
    }

    public abstract RS modelToResponse(M m);

    public abstract JpaRepository<M, K> getJpaRepository();

    @SneakyThrows
    public RS create(RQ rq) {
        Optional<M> m = getJpaRepository().findById(rq.getId());
        if (m.isEmpty()) {
            M model = requestToModel(rq);
            return modelToResponse(getJpaRepository().save(model));
        } else {
            throw OperationFailedException.createOperationFailedException(getResourceBundle(), "COMMON_00001", rq.getId());
        }
    }

    @SneakyThrows
    public void delete(K k) {
        Optional<M> m = getJpaRepository().findById(k);
        if (m.isPresent()) {

            getJpaRepository().deleteById(k);
        } else {
            throw OperationFailedException.createOperationFailedException(getResourceBundle(), "COMMON_00002", k);
        }
    }

    @Override
    public List<RS> read() {

        List<M> baseModels = getJpaRepository().findAll();
        return modelToResponse(baseModels);
    }

    @SneakyThrows
    @Override
    public RS read(K k) {

        Optional<M> m = getJpaRepository().findById(k);
        if (m.isPresent()) {
            return modelToResponse(getJpaRepository().findById(k).get());
        } else {
            throw OperationFailedException.createOperationFailedException(getResourceBundle(), "COMMON_00002", k);
        }
    }

    @SneakyThrows
    @Override
    public void update(RQ rq) {
        if (getJpaRepository().existsById(rq.getId())) {
            M oldModel = getJpaRepository().findById(rq.getId()).orElseThrow();
            M newModel = requestToModel(rq);
            newModel.setCreationTime(oldModel.getCreationTime());
            getJpaRepository().save(newModel);
        } else {
            throw OperationFailedException.createOperationFailedException(getResourceBundle(), "COMMON_00002", rq.getId());

        }

    }

    @Override
    public boolean idExists(K k) {
        return getJpaRepository().existsById(k);
    }
}
