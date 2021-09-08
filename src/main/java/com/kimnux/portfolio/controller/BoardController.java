package com.kimnux.portfolio.controller;

import com.kimnux.portfolio.model.Board;
import com.kimnux.portfolio.repository.BoardRepository;
import com.kimnux.portfolio.validator.BoardValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardValidator boardValidator;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> list = boardRepository.findAll();
        model.addAttribute("list", list);

        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        System.out.println("id===> "+ id);
        if(id == null) {
            model.addAttribute("board", new Board());
        } else {
            Board board = boardRepository.findById(id).orElse(null); // orElse(null)은 없으면 null을 반환하겠다는 의미
            model.addAttribute("board", board);
        }
        return "board/form";
    }

    @PostMapping("/formOk")
    public String formOk(@Valid Board board, BindingResult bindingResult) {
        log.info("bindingResult ==========> {}", bindingResult);

        boardValidator.validate(board, bindingResult);
        if (bindingResult.hasErrors()) {
            return "board/form";
        }

        board.setWriter("kimdw");
        boardRepository.save(board);
        System.out.println("board ====> " + board);
        return "redirect:/board/list";
    }


}
