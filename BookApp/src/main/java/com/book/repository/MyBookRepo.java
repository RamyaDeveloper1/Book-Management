
package com.book.repository;

import com.book.model.MyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MyBookRepo extends CrudRepository<MyBook, Integer> {
    
}
