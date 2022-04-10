package com.library.web.controllerimpl;

import com.library.domain.books.Book;
import com.library.service.BookService;
import com.library.serviceimpl.BookServiceImpl;
import com.library.web.controller.BookController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/*
 * 책 컨트롤러 레이어 구현체
 */
@RequiredArgsConstructor
@Controller
public class BookControllerImpl implements BookController {
    private final BookService bookServiceImpl;

    @GetMapping("/search")
    @Override
    public String search(HttpServletRequest req, Model model){
        try{
            String title = "가";
            if(req.getParameter("title") != null) title = req.getParameter("title");
            System.out.println(title);
            List<Book> books = bookServiceImpl.searchBookByNaver(title);
            for (Book b : books) System.out.println(b.getTitle());
            model.addAttribute("books", books);

        }catch (NullPointerException e){

        }finally {
            return "search";
        }
    }


}
