//////////////////////////////////////////////////
////          author: Nour
////          filename: BaseServiceImpl.java
////          2023
//////////////////////////////////////////////////
package ps.exalt.shopping.app.common.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ps.exalt.shopping.app.common.dto.BaseRequest;
import ps.exalt.shopping.app.common.dto.BaseResponse;
import ps.exalt.shopping.app.common.model.BaseModel;
import ps.exalt.shopping.app.common.service.BaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class BaseServiceImpl<RQ extends BaseRequest<K>,
        M extends BaseModel<K>, RS extends BaseResponse, K>
        implements BaseService<RQ, M, RS, K> {

    public abstract M requestToModel(RQ rq);

    private List<RS> modelToResponse(List<M> mList) {
        return mList.stream().map(this::modelToResponse).collect(Collectors.toList());
    }

    public abstract RS modelToResponse(M m);

    public abstract JpaRepository<M, K> getRepository();

    public RS create(RQ rq) {
        M m = requestToModel(rq);
        return modelToResponse(getRepository().save(m));
    }

    public void delete(K k) {
        getRepository().deleteById(k);
    }

    @Override
    public List<RS> read() {

        List<M> baseModels = getRepository().findAll();
        return modelToResponse(baseModels);
    }

    @Override
    public RS read(K k) {
        return modelToResponse(getRepository().findById(k).orElseThrow());
    }

    @Override
    public void update(RQ rq) {
        M oldModel = getRepository().findById(rq.getId()).orElseThrow();
        M newModel = requestToModel(rq);
        newModel.setCreationTime(oldModel.getCreationTime());
        getRepository().save(newModel);
    }
    @Override
    public boolean idExists(K k) {
        return getRepository().existsById(k);
    }
}
