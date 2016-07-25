package name.az170.resmgr.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.az170.resmgr.core.domain.Resource;
import name.az170.resmgr.core.service.ResourceService;
import name.az170.resmgr.dao.ResourceDao;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public void add(Resource resource) {
        resourceDao.create(resource);
    }

    @Override
    public void remove(String id) {
        resourceDao.delete(id);
    }

    @Override
    public void modify(Resource resource) {
        resourceDao.update(resource);
    }

    @Override
    public Resource get(String id) {
        return resourceDao.read(id);
    }

}
