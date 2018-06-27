package top.toptool.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.toptool.dto.KeywordScoreDTO;
import top.toptool.exception.BaseException;
import top.toptool.service.TextHandleService;
import top.toptool.web.req.ExtractKeywordsReq;
import top.toptool.web.vo.JsonResult;

import java.util.List;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
@Controller
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private TextHandleService textHandleService;


    /**
     * Json格式转化工具
     *
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String toToolJson() {
        return "tool/tool_json";
    }

    /**
     * 提取关键词
     *
     * @return
     */
    @RequestMapping(value = "/extract-keywords")
    public @ResponseBody
    JsonResult extractKeywords(@RequestBody ExtractKeywordsReq extractKeywordsReq) {
        List<KeywordScoreDTO> resultList = null;
        JsonResult jr;
        try {
            resultList = textHandleService.extractKeywords(extractKeywordsReq.getText(), extractKeywordsReq.getK(), extractKeywordsReq.getStopWords());
            jr = new JsonResult(true, resultList);
        } catch (BaseException e) {
            jr = new JsonResult(false, e.getMessage());
        }
        return jr;
    }


}
