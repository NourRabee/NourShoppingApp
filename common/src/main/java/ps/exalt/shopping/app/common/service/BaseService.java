//////////////////////////////////////////////////
////          author: Nour
////          filename: BaseService.java
////          2023
//////////////////////////////////////////////////
package ps.exalt.shopping.app.common.service;

import ps.exalt.shopping.app.common.dto.BaseRequest;
import ps.exalt.shopping.app.common.dto.BaseResponse;
import ps.exalt.shopping.app.common.model.BaseModel;

import java.util.List;

public interface BaseService<RQ extends BaseRequest<K>, M extends BaseModel<K>,
        RS extends BaseResponse, K> {
    public RS create(RQ rq);

    public List<RS> read();

    public RS read(K k);

    public void update(RQ rq);

    public boolean idExists(K k);
    public void delete(K k);
}
