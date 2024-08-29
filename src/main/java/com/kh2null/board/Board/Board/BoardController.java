package com.kh2null.board.Board.Board;

import com.kh2null.board.Board.Posts.Posts;
import com.kh2null.board.Board.Posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final PostsService postsService;

    @GetMapping("/board")
    public String board(){
        return "board";
    }

    // 글쓰기 페이지 이동
    @GetMapping("/write-form")
    public String writeForm(){
        return "write-form";
    }

    // 글쓰기
    @PostMapping("/write-form")
    public String write(Posts posts){
        postsService.save(posts);
        return "redirect:/board";
    }

}
