package cn.apeius.book_store.service;

import cn.apeius.book_store.domain.Book;
import cn.apeius.book_store.domain.Category;

import java.util.List;


public interface BookService {

    //获得书本目录
    List<Category> getAllCategories();
    //通过id获得书本目录
    Category getCategory(int id);
    ///获得所有书
    List<Book> getAllBooks();
    //保存书本
    Book save(Book book);
    //更新书本
    Book update(Book book);
    //根据id获得书本
    Book get(long id);
    //获得下一个id
    long getNextId();

}
