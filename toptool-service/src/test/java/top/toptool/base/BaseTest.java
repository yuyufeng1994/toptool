package top.toptool.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.toptool.mapper.ArticleMapper;

import javax.sql.DataSource;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BaseTest {
    @Autowired
    private ArticleMapper mapper;
    @Test
    public void test(){
        System.out.println(mapper.selectByPrimaryKey(1L));
    }
}
