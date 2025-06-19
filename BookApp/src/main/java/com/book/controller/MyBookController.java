
package com.book.controller;

import com.book.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {
    @Autowired
    MyBookService service;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") Integer id){
        service.deleteById(id);
        return "redirect:/myBooks";
    }
}
