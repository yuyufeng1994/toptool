package top.toptool.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
@Controller
@RequestMapping("/tool")
public class ToolController {

    /**
     * Json格式转化工具
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String toToolJson() {
        return "tool/tool_json";
    }

}
