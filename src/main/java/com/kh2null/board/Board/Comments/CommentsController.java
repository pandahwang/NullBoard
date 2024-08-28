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
    
    // 댓글 작성
    @PostMapping("/board/post/{postId}/comment")
    public String writeComment(@PathVariable int postId, Comments comments) {
        commentsService.writeComment(comments);
        return "redirect:/board/post/{postId}";
    }
    
    // 댓글 수정 페이지 이동
    @GetMapping("/board/post/{postId}/comment/{commentId}/edit")
    public String editCommentForm(@PathVariable int postId, @PathVariable int commentId) {
        commentsService.findCommentById(postId, commentId);
        return "editComment";
    }

    // 댓글 수정
    @PostMapping("/board/post/{postId}/comment/{commentId}/edit")
    public String editComment(@PathVariable int postId, @PathVariable int commentId, Comments comments) {
        commentsService.editComment(postId, commentId, comments);
        return "redirect:/board/post/{postId}";
    }
    
    // 댓글 삭제 페이지 이동
    @GetMapping("/board/post/{postId}/comment/{commentId}/delete")
    public String deleteCommentPage(@PathVariable int postId, @PathVariable int commentId) {
        commentsService.findCommentById(postId, commentId);
        return "deleteComment";
    }
    
    // 댓글 삭제
    @PostMapping("/board/post/{postId}/comment/{commentId}/delete")
    public String deleteComment(@PathVariable int postId, @PathVariable int commentId) {
        commentsService.deleteComment(postId, commentId);
        return "redirect:/board/post/{postId}";
    }
}
