package dd.aspect;

import com.mongodb.BasicDBObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huaaijia on 2016/11/22.
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger("mongodb");

//    @Pointcut("execution(public * com.didispace.web..*.*(..))")
    @Pointcut("execution(public * dd.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 获取HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取要记录的日志内容
        BasicDBObject logInfo = getBasicDBObject(request, joinPoint);
        logger.info(logInfo);
    }

    private BasicDBObject getBasicDBObject(HttpServletRequest request, JoinPoint joinPoint) {
        // 基本信息
        BasicDBObject r = new BasicDBObject();
        r.append("requestURL", request.getRequestURL().toString());
        r.append("requestURI", request.getRequestURI());
        r.append("queryString", request.getQueryString());
        r.append("remoteAddr", request.getRemoteAddr());
        r.append("remoteHost", request.getRemoteHost());
        r.append("remotePort", request.getRemotePort());
        r.append("localAddr", request.getLocalAddr());
        r.append("localName", request.getLocalName());
        r.append("method", request.getMethod());
        r.append("headers", getHeadersInfo(request));
        r.append("parameters", request.getParameterMap());
        r.append("classMethod", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        r.append("args", Arrays.toString(joinPoint.getArgs()));
        return r;
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

//    Mongo存储数据
//    {
//        "_id" : ObjectId("58340a26aa9c8b10f675414e"),
//            "requestURL" : "http://localhost:8091/hello",
//            "requestURI" : "/hello",
//            "queryString" : null,
//            "remoteAddr" : "0:0:0:0:0:0:0:1",
//            "remoteHost" : "0:0:0:0:0:0:0:1",
//            "remotePort" : 57600,
//            "localAddr" : "0:0:0:0:0:0:0:1",
//            "localName" : "0:0:0:0:0:0:0:1",
//            "method" : "GET",
//            "headers" : {
//        "accept-language" : "zh-CN,zh;q=0.8",
//                "cookie" : "tencentSig=4856145920",
//                "host" : "localhost:8091",
//                "upgrade-insecure-requests" : "1",
//                "connection" : "keep-alive",
//                "cache-control" : "max-age=0",
//                "accept-encoding" : "gzip, deflate, sdch, br",
//                "user-agent" : "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36",
//                "accept" : "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"
//    },
//        "parameters" : {
//
//    },
//        "classMethod" : "dd.web.HelloController.index",
//            "args" : "[]"
//    }
}
