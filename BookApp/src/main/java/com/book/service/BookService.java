
package com.book.service;

import com.book.model.Book;
import com.book.repository.BookRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepo repo;
    public void addBook(Book b){
      repo.save(b);
    }
    public List<Book> getAllBooks(){
      List<Book> all=new ArrayList();
      repo.findAll().forEach((b)->{
          all.add(b);
      });
      return all;
    }
    public Book getBookById(Integer id){
        return repo.findById(id).get();
    }
    public void deleteById(Integer id){
       repo.deleteById(id);
    }
}
