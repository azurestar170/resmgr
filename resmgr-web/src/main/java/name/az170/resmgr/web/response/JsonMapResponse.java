package name.az170.resmgr.web.response;

import java.util.HashMap;
import java.util.Map;

public class JsonMapResponse<T> extends JsonObjectResponse<Map<String, T>>{

    public JsonMapResponse() {
        data = new HashMap<>();
    }
    
}
