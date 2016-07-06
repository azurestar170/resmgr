package name.az170.resmgr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import name.az170.resmgr.core.service.ResourceService;

@RestController
public class TestController {
    
    @Autowired
    private ResourceService resourceSrv;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        resourceSrv.test();
        return "Ok.";
    }
    
}
