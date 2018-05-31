package top.toptool.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.toptool.web.vo.JsonResult;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/ping",method = RequestMethod.GET)
    public @ResponseBody
    JsonResult ping() {
        return new JsonResult(true, "pong");
    }
}
