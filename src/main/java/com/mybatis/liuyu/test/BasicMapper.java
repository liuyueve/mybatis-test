package com.mybatis.liuyu.test;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * Create by liuyu
 * Date is 2019-11-26
 * Description is : mapper
 */
@CacheNamespace
public interface BasicMapper {

    @Select("select `value` from `demo` where id = #{id}")
    String queryName(@Param("id") int id);

    @Update("update `demo` set `value` = `value` where id = #{id}")
    int updateName(@Param("id") int id);

}
