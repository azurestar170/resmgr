package name.az170.resmgr.core.service.impl;

import org.springframework.stereotype.Service;

import name.az170.resmgr.core.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Override
    public void test() {
        System.out.println("test");
    }

}
