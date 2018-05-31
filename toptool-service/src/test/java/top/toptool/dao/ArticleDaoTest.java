package top.toptool.dao;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.toptool.constant.CategoryEnum;
import top.toptool.entity.Article;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-base.xml", "classpath:spring/spring-dao.xml"})
public class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDao;

    @Test
    public void get() throws Exception {
        Article article = articleDao.get(1L);
        System.out.println(JSONObject.toJSON(article));
    }

    @Test
    public void get1() throws Exception {
        Article articleQuery = new Article();
        articleQuery.setTitle("测试标题");
        Article article = articleDao.get(articleQuery);
        System.out.println(JSONObject.toJSON(article));
    }

    @Test
    public void insert() throws Exception {
        Article entity = new Article();
        entity.setTitle("测试标题");
        entity.setContent("这是测试的内容Hello~");
        entity.setGeneral("这是摘要");
        entity.setStatus("0");
        entity.setCategory(CategoryEnum.NOTICE.getKey());
        entity.setCover("https://image.png");
        entity.setSource("https//:www.yuyufeng.top");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        articleDao.insert(entity);
    }

    @Test
    public void delete() throws Exception {
        articleDao.delete(3L);
    }

    @Test
    public void update() throws Exception {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("修改标题");
        article.setUpdateTime(new Date());
        articleDao.update(article);
    }

    @Test
    public void list() throws Exception {
        List<Article> list =  articleDao.list();
        for (Article article : list) {
            System.out.println(JSONObject.toJSON(article));
        }
    }

    @Test
    public void list1() throws Exception {
        Article articleQuery = new Article();
        articleQuery.setTitle("测试标题");
        List<Article> list = articleDao.list(articleQuery);
        for (Article article : list) {
            System.out.println(JSONObject.toJSON(article));
        }
    }

    @Test
    public void page() throws Exception {
        PageInfo<Article> pageInfo = articleDao.page(1,10,"create_time desc");
        for (Article article : pageInfo.getList()) {
            System.out.println(JSONObject.toJSON(article));
        }
    }

    @Test
    public void page1() throws Exception {
        Article articleQuery = new Article();
        articleQuery.setTitle("测试标题");
        PageInfo<Article> pageInfo = articleDao.page(2,10,"create_time desc",articleQuery);
        for (Article article : pageInfo.getList()) {
            System.out.println(JSONObject.toJSON(article));
        }
    }

}