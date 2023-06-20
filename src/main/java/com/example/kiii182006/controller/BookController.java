package com.example.kiii182006.controller;


import com.example.kiii182006.model.Book;
import com.example.kiii182006.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public String viewHomePage(Model model)
    {
 model.addAttribute("allbookList", bookService.getAllBooks());
 return "index";
    }
@GetMapping("/add")
    public String addNewbook(Model model)
{
    Book book = new Book();
    model.addAttribute("book", book);
    return "addBook";
}
@PostMapping("/save")
    public  String saveBook(@ModelAttribute("book") Book book ) {

bookService.save(book);
return "redirect:/";
    }
    @GetMapping("/updateform/{id}")
        public String updateFrom(@PathVariable(value="id") long id, Model model)
    {
        Book book =  bookService.getById(id);
        model.addAttribute("book", book);
        return "update";
    }

@GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value="id") long id)
{
    bookService.deleteById(id);
    return "redirect:/";
}

}
