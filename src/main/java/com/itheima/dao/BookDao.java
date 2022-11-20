package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {

//    @Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    @Insert("insert into book (type,name,description) values(#{type},#{name},#{description})")
    public void save(Book book);

    @Update("update book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    public void update(Book book);

    @Delete("delete from book where id = #{id}")
    public void delete(Integer id);

    @Select("select * from book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from book")
    public List<Book> getAll();
}
