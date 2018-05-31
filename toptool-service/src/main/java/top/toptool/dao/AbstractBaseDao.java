package top.toptool.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 1） 获取单个对象的方法用 get 作前缀。
 * 2） 获取多个对象的方法用 list 作前缀。
 * 3） 获取统计值的方法用 count 作前缀。
 * 4） 插入的方法用 save/insert 作前缀。
 * 5） 删除的方法用 remove/delete 作前缀。
 * 6） 修改的方法用 update 作前缀。
 *
 * @author yuyufeng
 * @date 2018/5/31.
 */
public abstract class AbstractBaseDao<T> implements IBaseDao{
    /**
     * 根据ID获取一个实体
     *
     * @param id
     * @return
     */
    public T get(Long id) {
        return (T) getMapper().selectByPrimaryKey(id);
    }

    /**
     * 根据条件获取一个实体
     *
     * @param entity
     * @return
     */
    public T get(T entity) {
        return (T) getMapper().selectOne(entity);
    }

    /**
     * 插入一个实体
     *
     * @param entity
     */
    public void insert(T entity) {
        getMapper().insertSelective(entity);
    }

    /**
     * 删除一个实体
     *
     * @param id
     */
    public void delete(Long id) {
        getMapper().deleteByPrimaryKey(id);
    }

    /**
     * 更新一个实体
     *
     * @param entity
     */
    public void update(T entity) {
        getMapper().updateByPrimaryKeySelective(entity);
    }

    /**
     * 列出多个对象
     *
     * @return
     */
    public List<T> list() {
        return getMapper().selectAll();
    }

    /**
     * 根据条件列出多个对象
     *
     * @param entity
     * @return
     */
    public List<T> list(T entity) {
        return getMapper().select(entity);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @param order
     * @return
     */
    public PageInfo<T> page(int page, int size, String order) {
        PageHelper.startPage(page, size, order);
        List<T> list = getMapper().selectAll();
        return new PageInfo<>(list, 7);
    }

    /**
     * 按条件分页查询
     * @param page
     * @param size
     * @param order
     * @param entity
     * @return
     */
    public PageInfo<T> page(int page, int size, String order,T entity) {
        PageHelper.startPage(page, size, order);
        List<T> list = getMapper().select(entity);
        return new PageInfo<>(list, 7);
    }

}
