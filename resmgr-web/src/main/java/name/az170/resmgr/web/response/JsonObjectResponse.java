package name.az170.resmgr.web.response;

public class JsonObjectResponse<T> extends JsonResponse {

    protected T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
