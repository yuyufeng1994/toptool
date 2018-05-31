package top.toptool.dao;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import top.toptool.entity.Article;
import top.toptool.mapper.ArticleMapper;

import java.util.List;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
@Repository
public class ArticleDao extends AbstractBaseDao<Article> {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Mapper getMapper() {
        return this.articleMapper;
    }


}
