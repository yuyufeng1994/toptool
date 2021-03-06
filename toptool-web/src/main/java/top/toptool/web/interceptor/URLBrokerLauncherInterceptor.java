package top.toptool.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author yuyufeng
 * @date 2017/4/20
 * request中获取绝对url
 */
public class URLBrokerLauncherInterceptor implements HandlerInterceptor {

    @Resource(name = "urlMap")
    private Map<String, String> urlMap;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        for (String s : urlMap.keySet()) {
            Object attr = httpServletRequest.getAttribute(s);
            if (attr == null) {
                httpServletRequest.setAttribute(s, urlMap.get(s));
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
