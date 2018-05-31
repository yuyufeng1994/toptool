package top.toptool.dao;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
public interface IBaseDao {
    /**
     * 获取Mapper
     * @return
     */
    Mapper getMapper();

}
