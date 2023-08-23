//////////////////////////////////////////////////
////          author: Nour
////          filename: BaseService.java
////          2023
//////////////////////////////////////////////////
package ps.exalt.shopping.app.common.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
import ps.exalt.shopping.app.common.dto.BaseRequest;
import ps.exalt.shopping.app.common.dto.BaseResponse;
import ps.exalt.shopping.app.common.model.BaseModel;

public abstract class BaseService<RQ extends BaseRequest, M extends BaseModel<K>
        , RS extends BaseResponse, K> {

    public abstract M requestToModel(RQ rq);
    public abstract RS modelToResponse(M m);

    public abstract JpaRepository<M , K> getRepository();
    public RS create(RQ rq) {
        M m = requestToModel(rq);
        return modelToResponse(getRepository().save(m));
    }
    public void delete(K k) {
        getRepository().deleteById(k);
    }



}
