package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;



    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR , flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        boolean b = book != null;
        Integer code = b ? Code.GET_OK : Code.GET_ERR;
        String message = b ? "查询成功" : "数据查询失败请重试";
        return new Result(code, message,book );
    }

    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        boolean b = bookList != null;
        Integer code = b ? Code.GET_OK : Code.GET_ERR;
        String message = b ? "查询成功" : "数据查询失败请重试";
        return new Result(code,  message,bookList);
    }
}
