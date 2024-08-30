package com.kh2null.board.Board.Posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;
    
    // 게시글 저장
    public void save(Posts posts) {
        postsRepository.save(posts);
    }
    
    // ID로 게시글 찾기
    public Posts getPostById(int postId) {
        Posts result = postsRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        System.out.println("post_id : " + result.getPostId());
        System.out.println("user_id : " + result.getUserId());
        System.out.println("title : " + result.getTitle());
        return result;
    }

    // 게시글 수정
    public void editPostById(int postId, Posts posts) {
        Posts result = getPostById(postId);
        result.setTitle(posts.getTitle());
        result.setContent(posts.getContent());
        result.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        postsRepository.save(result);
    }
    
    // 게시글 삭제
    public void deletePostById(int postId) {
        Posts result = getPostById(postId);
        postsRepository.delete(result);
    }
}
