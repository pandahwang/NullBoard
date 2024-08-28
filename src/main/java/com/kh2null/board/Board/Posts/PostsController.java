package com.kh2null.board.Board.Posts;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostsController {

    private final PostsRepository postsRepository;
    private final PostsService postsService;
    
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
    
    // 게시글 페이지 이동
    // pathvariable로 조회
    @GetMapping("/post/{post_id}")
    @ResponseBody
    public Posts readPostById(@PathVariable int post_id){
        Posts result = postsService.getPostById(post_id);
        return result;
    }

//    // queryparameter로 조회
//    @GetMapping("/post")
//    @ResponseBody
//    public Posts readPost(@RequestParam int post_id){
//        Posts result = postsService.getPostById(post_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
//        return result;
//    }
    
    // 게시글 수정 페이지 이동
    @GetMapping("/board/post/{post_id}/edit")
    public String editPostPage(@PathVariable int post_id, Model model){
        Posts result = postsService.getPostById(post_id);
        return "editPost";
    }
    
    // 게시글 수정
    @PostMapping("/board/post/{post_id}/edit")
    public String editPost(@PathVariable int post_id, Posts posts){
        postsService.editPostById(post_id, posts);
        return "redirect:/board";
    }

    @GetMapping("/posts/update")
    public String postsUpdate() {
        return "posts-update";
    }

    @GetMapping("/posts")
    public String posts() {
        return "posts";
    }


}
