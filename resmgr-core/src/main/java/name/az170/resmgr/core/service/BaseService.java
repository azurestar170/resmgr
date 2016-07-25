package name.az170.resmgr.core.service;

public interface BaseService<T> {

    void add(T t);
    
    void remove(String id);
    
    void modify(T t);
    
    T get(String id);
    
}
