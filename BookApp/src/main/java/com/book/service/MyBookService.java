
package com.book.service;

import com.book.model.MyBook;
import com.book.repository.MyBookRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepo repo;
    public void addMyBook(MyBook book){
        repo.save(book);
    }

    public List<MyBook> getAllMyBooks() {
        List<MyBook> list=new ArrayList();
        repo.findAll().forEach(b->{
            list.add(b);
        });
        return list;
    }
    public void deleteById(Integer id){
       repo.deleteById(id);
    }
    
}
