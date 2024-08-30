package com.kh2null.board.Board.Comments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;

    // 댓글 작성
    public void writeComment(Comments comments) {
        commentsRepository.save(comments);
    }
    
    // id로 댓글 조회
    public Comments findCommentById(int postId, int commentId) {
        Comments result = commentsRepository.findByCommentIdAndPostId(postId, commentId);
        System.out.println("comment_id : " + result.getCommentId());
        System.out.println("post_id : " + result.getPostId());
        System.out.println("user_id : " + result.getUserId());
        System.out.println("content : " + result.getContent());
        return result;
    }

    // 댓글 수정
    public void editComment(int postId, int commentId,Comments comments) {
        Comments result = findCommentById(postId, commentId);
        result.setContent(comments.getContent());
        commentsRepository.save(result);
    }

    // 댓글 삭제
    public void deleteComment(int postId, int commentId) {
        Comments result = findCommentById(postId, commentId);
        commentsRepository.delete(result);
    }
}
