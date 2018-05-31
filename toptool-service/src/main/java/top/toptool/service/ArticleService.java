package top.toptool.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.toptool.constant.StatusEnum;
import top.toptool.dao.ArticleDao;
import top.toptool.entity.Article;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public PageInfo<Article> pageNormal(int page, int size) {
        Article articleQuery = new Article();
        articleQuery.setStatus(StatusEnum.NORMAL.getKey());
        return articleDao.page(page, 10, "create_time desc", articleQuery);
    }

}
