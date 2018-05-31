package top.toptool.web.action;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.toptool.entity.Article;
import top.toptool.service.ArticleService;
import top.toptool.web.vo.JsonResult;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/page/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody
    JsonResult<PageInfo<Article>> page(@PathVariable("pageNo") Integer pageNo) {
        JsonResult<PageInfo<Article>> jsonResult;
        try {
            PageInfo<Article> pageInfo = articleService.pageNormal(pageNo, 10);
            jsonResult = new JsonResult<>(true, pageInfo);
        } catch (Exception e) {
            jsonResult = new JsonResult<>(false, e.getMessage());
        }
        return jsonResult;
    }
}
