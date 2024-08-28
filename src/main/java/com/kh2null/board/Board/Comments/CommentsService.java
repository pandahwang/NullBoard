package com.kh2null.board.Board.Comments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public void writeComment(Comments comments) {
        commentsRepository.save(comments);
    }
}
