package com.kh2null.board.Board.Board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String board(){
        return "board";
    }

}
