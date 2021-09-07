package com.kimnux.portfolio.controller;

import com.kimnux.portfolio.model.Board;
import com.kimnux.portfolio.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> list = boardRepository.findAll();
        model.addAttribute("list", list);

        return "board/list";
    }
}
