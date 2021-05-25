package DNA3.resolver;

import DNA3.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 11:26
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        if (exception instanceof MyException) {
            modelAndView.addObject("info", "自定义异常");
        } else if (exception instanceof ClassCastException) {
            modelAndView.addObject("info", "类转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
