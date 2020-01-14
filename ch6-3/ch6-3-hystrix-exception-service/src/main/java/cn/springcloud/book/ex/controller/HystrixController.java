package cn.springcloud.book.ex.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//
//import cn.springcloud.book.ex.service.dataservice.PSFallbackBadRequestExpcetion;
//import cn.springcloud.book.ex.service.dataservice.PSFallbackOtherExpcetion;
//import cn.springcloud.book.ex.service.dataservice.ProviderServiceCommand;

/**
 * 
 */
@RestController
public class HystrixController {
    private static Logger log = LoggerFactory.getLogger(HystrixController.class);
//
//    @GetMapping("/getProviderServiceCommand")
//    public String providerServiceCommand(){
//    	String result = new ProviderServiceCommand("World").execute();
//    	return result;
//    }
//
//
//    @GetMapping("/getPSFallbackBadRequestExpcetion")
//    public String providerServiceFallback(){
//    	String result = new PSFallbackBadRequestExpcetion().execute();
//    	return result;
//    }
//
//
//    @GetMapping("/getPSFallbackOtherExpcetion")
//    public String pSFallbackOtherExpcetion(){
//    	String result = new PSFallbackOtherExpcetion().execute();
//    	return result;
//    }
    
    @GetMapping("/hystrixMethod")
    @HystrixCommand(fallbackMethod = "fallback")
    public String hystrixMethod(String id) {
        if (id != null) {
            return id + " resp";
        }
    	throw new RuntimeException("hystrixMethod failed");
    }

    @GetMapping("/hystrixMethod2")
    @HystrixCommand(fallbackMethod = "fallback")
    public String hystrixMethod2(String id) {
        if (id != null) {
            return id + " resp";
        }
    	throw new RuntimeException("hystrixMethod failed");
    }

    @GetMapping("/hystrixMethod3")
    @HystrixCommand(fallbackMethod = "fallback", threadPoolKey = "tpool-3")
    public String hystrixMethod3(String id) {
        if (id != null) {
            return id + " resp";
        }
    	throw new RuntimeException("hystrixMethod failed");
    }

    public String fallback(String id, Throwable throwable) {
    	log.error(throwable.getMessage());
        return "this is fallback message";
    }
 
}
