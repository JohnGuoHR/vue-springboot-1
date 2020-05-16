package com.john.vuespringboot1.controller;

import com.john.vuespringboot1.pojo.Book;
import com.john.vuespringboot1.pojo.Search;
import com.john.vuespringboot1.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    private static final Logger logger= LoggerFactory.getLogger(LibraryController.class);
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    @CrossOrigin
    public List<Book> list() throws Exception {
        logger.info("查询全部书籍");
        List list=bookService.list();
        logger.info("查询全部书籍:\t"+list);
        return list;
    }

    @GetMapping("/api/cccc")
    @CrossOrigin
    public String list2() throws Exception {
        logger.info("查询全部书籍");
        String str="sdfjifnksdfmsdkfsdf";
        logger.info("查询全部书籍:\t"+str);
        return str;
    }

    @PostMapping("/api/books")
    @CrossOrigin
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        logger.info("新增/更新书籍：\t"+book);
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    @CrossOrigin
    public void delete(@RequestBody Book book) throws Exception {
        logger.info("删除书籍：\t"+book);
        bookService.deleteById(book.getId());
    }


    @GetMapping("/api/categories/{cid}/books")
    @CrossOrigin
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        logger.info("种类为"+cid+"的书籍：\t");
        if (0 != cid) {
            logger.info("种类为"+cid+"的书籍：\t"+bookService.listByCategory(cid));
            return bookService.listByCategory(cid);
        } else {
            logger.info("没有种类为"+cid+"的书籍：\t");
            return list();
        }
    }


    @CrossOrigin
    @PostMapping("/api/search")
    public List<Book> searchResult(@RequestBody Search s) throws Exception {
        logger.info("搜索"+s);
        // 关键字为空时查询所有书籍
        if ("".equals(s.getKeywords())) {
            return bookService.list();
        } else {
            logger.info("搜索\t"+bookService.Search(s.getKeywords()));
            return bookService.Search(s.getKeywords());
        }
    }

}
