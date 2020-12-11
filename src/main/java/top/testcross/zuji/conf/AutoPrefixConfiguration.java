package top.testcross.zuji.conf;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;


public class AutoPrefixConfiguration implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new AutoPrefixUrlMapping();
    }
}


class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    private final   String apiPackagePath="/api";

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
        if(null != requestMappingInfo){
            //获取url前缀
            String prefix = getPrefix(handlerType);
            //根据url前缀生成RequestMappingInfo并与原有的RequestMappingInfo合并
            RequestMappingInfo mappingInfo = RequestMappingInfo.paths(prefix).build().combine(requestMappingInfo);
            return mappingInfo;
        }
        return requestMappingInfo;
    }

    private String getPrefix(Class<?> handlerType){
        String packageName = handlerType.getPackage().getName();	//获取控制器所在包路径
        String dotPath = packageName.replaceAll(this.apiPackagePath,"");	//将包路径中多于的部分截取掉
        return dotPath.replace(".","/");		//将包路径中的.替换成/
    }
}