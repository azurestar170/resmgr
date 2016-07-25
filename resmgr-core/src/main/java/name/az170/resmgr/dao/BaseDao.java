package name.az170.resmgr.dao;

public interface BaseDao<T> {
    
    public static final String BASE_ID = "id";
    public static final String BASE_CREATE_TIME = "create_time";
    public static final String BASE_UPDATE_TIME = "update_time";
    public static final String BASE_COMMENT = "comment";

    int create(T t);

    int delete(String id);

    int update(T t);

    T read(String id);

}
