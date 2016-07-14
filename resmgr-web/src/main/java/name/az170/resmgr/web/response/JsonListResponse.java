package name.az170.resmgr.web.response;

import java.util.ArrayList;
import java.util.List;

public class JsonListResponse<T> extends JsonObjectResponse<List<T>> {

    public JsonListResponse() {
        data = new ArrayList<T>();
    }

}
