package com.book.controller;

import com.book.model.Book;
import com.book.model.MyBook;
import com.book.service.BookService;
import com.book.service.MyBookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    BookService service;
    @Autowired
    MyBookService serv;
    @GetMapping("/")
    public String index(){
       return "index";
    }
    @GetMapping("/bookRegister")
    public String bookRegister(){
       return "bookRegister";
    }
    @GetMapping("/availBooks")
    public ModelAndView getAllBooks(){
       List<Book> list= service.getAllBooks();
        return new ModelAndView("bookList", "books",list);
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book b){
        service.addBook(b);
    return "redirect:/availBooks";
    }
    @GetMapping("/myBooks")
    public String getMyBooks(Model model){
        List<MyBook> list=serv.getAllMyBooks();
        model.addAttribute("books",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") Integer id){
        Book b=service.getBookById(id);
        MyBook my=new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        serv.addMyBook(my);
        return "redirect:/myBooks";
    }
  
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model){
      Book book=  service.getBookById(id);
      model.addAttribute("book", book);
      return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id){
            service.deleteById(id);
          return "redirect:/availBooks";
    }
}

