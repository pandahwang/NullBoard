package com.kh2null.board.Board.Comments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping("/board/post/{postId}/comment")
    public String writeComment(@PathVariable int postId, Comments comments) {
        commentsService.writeComment(comments);
        return "redirect:/board/post/{postId}";
    }

    @GetMapping("/board/post/{postId}/comment/{commentId}/edit")
    public String editCommentForm(@PathVariable int postId, @PathVariable int commentId) {
        commentsService.getCommentById(postId, commentId);
        return "editComment";
    }

    @PostMapping("/board/post/{postId}/comment/{commentId}/edit")
    public String editComment(@PathVariable int postId, @PathVariable int commentId, Comments comments) {
        commentsService.editComment(postId, commentId, comments);
        return "redirect:/board/post/{postId}";
    }
}
