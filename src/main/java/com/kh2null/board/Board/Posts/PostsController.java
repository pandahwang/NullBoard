package com.kh2null.board.Board.Posts;

import com.kh2null.board.Board.Comments.Comments;
import com.kh2null.board.Board.Comments.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostsController {

    private final PostsRepository postsRepository;
    private final CommentsRepository commentsRepository;
    private final PostsService postsService;
    
    // 게시글 페이지 이동 + 댓글 조회
    @GetMapping("/post/{postId}")
    @ResponseBody
    public List<Object> readPostById(@PathVariable int postId){
        Posts resultPost = postsService.getPostById(postId);
        List<Comments> resultComments = commentsRepository.findCommentsByPostId(postId);

        List<Object> result = new ArrayList<>();
        result.add(resultPost);
        if(resultComments.isEmpty()){
            result.add("댓글이 없습니다.");
        } else{
            resultComments.forEach(comment ->{
                result.add(comment);
            } );
        }
        return result;
    }

//    // 게시글 페이지 이동
//    // pathvariable로 조회
//    @GetMapping("/post/{postId}")
//    @ResponseBody
//    public Posts readPostById(@PathVariable int postId){
//        Posts result = postsService.getPostById(postId);
//        System.out.println(result.getClass());
//        return result;
//    }

//    // queryparameter로 조회
//    @GetMapping("/post")
//    @ResponseBody
//    public Posts readPost(@RequestParam int post_id){
//        Posts result = postsService.getPostById(post_id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
//        return result;
//    }
    
    // 게시글 수정 페이지 이동
    @GetMapping("/post/{postId}/edit")
    public String editPostPage(@PathVariable int postId, Model model){
        Posts result = postsService.getPostById(postId);
        return "editPost";
    }
    
    // 게시글 수정
    @PostMapping("/post/{postId}/edit")
    public String editPost(@PathVariable int postId, Posts posts){
        postsService.editPostById(postId, posts);
        return "redirect:/board";
    }

    // 게시글 삭제 페이지 이동
    @GetMapping("/post/{postId}/delete")
    public String deletePostPage(@PathVariable int postId){
        Posts result = postsService.getPostById(postId);
        return "deletePost";
    }

    // 게시글 삭제
    @PostMapping("/post/{postId}/delete")
    public String deletePost(@PathVariable int postId){
        postsService.deletePostById(postId);
        return "redirect:/board";
    }




}
