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
    public Comments findCommentById(int post_id, int comment_id) {
        Comments result = commentsRepository.findByPostCommentId(post_id, comment_id);
        System.out.println("comment_id : " + result.getComment_id());
        System.out.println("post_id : " + result.getPost_id());
        System.out.println("user_id : " + result.getUser_id());
        System.out.println("content : " + result.getContent());
        return result;
    }

    // 댓글 수정
    public void editComment(int post_id, int comment_id,Comments comments) {
        Comments result = findCommentById(post_id, comment_id);
        result.setContent(comments.getContent());
        commentsRepository.save(result);
    }

    // 댓글 삭제
    public void deleteComment(int post_id, int comment_id) {
        Comments result = findCommentById(post_id, comment_id);
        commentsRepository.delete(result);
    }
}
