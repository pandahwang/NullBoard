package com.kh2null.board.Board.Comments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping("/board/post/{postId}/comment")
    public String writeComment(Comments comments) {
        commentsService.writeComment(comments);
        return "redirect:/board/post/{postId}";
    }

}
