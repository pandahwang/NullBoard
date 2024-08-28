package com.kh2null.board.Board.Comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    @Query(value = "SELECT * FROM comments WHERE post_id = ?1 AND comment_id = ?2", nativeQuery = true)
    public Comments findByPostCommentId(int post_id, int comment_id);


}
