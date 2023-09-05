//////////////////////////////////////////////////
////          author: Nour
////          filename: BaseService.java
////          2023
//////////////////////////////////////////////////
package ps.exalt.shopping.app.common.service;

import ps.exalt.shopping.app.common.dto.BaseRequest;
import ps.exalt.shopping.app.common.dto.BaseResponse;
import ps.exalt.shopping.app.common.model.BaseModel;
import ps.exalt.shopping.app.common.service.impl.MySqlBaseServiceImpl;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public interface BaseService<RQ extends BaseRequest<K>, M extends BaseModel<K>,
        RS extends BaseResponse, K> {
    default ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle(
                "error.commonErrors", Locale.getDefault(),
                MySqlBaseServiceImpl.class.getClassLoader());
    }
    public RS create(RQ rq);

    public List<RS> read();

    public RS read(K k);

    public void update(RQ rq);

    public boolean idExists(K k);
    public void delete(K k);
}
