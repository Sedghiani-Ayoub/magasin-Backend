package com.funsot.magasin.controller;

import com.funsot.magasin.entities.Comment;
import com.funsot.magasin.exeptions.ResourceNotFound;
import com.funsot.magasin.magasin.entities.CommentDto;
import com.funsot.magasin.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping
    public Comment addComment(@RequestBody CommentDto commentDto) throws ResourceNotFound{
        return  commentService.addComment(commentDto);

    }
    @GetMapping
    public List<Comment> getComment(Long idProduct) throws ResourceNotFound {

        return  commentService.getComment(idProduct);
    }
@DeleteMapping
    public Map<String,Boolean> deleteComment(long idComment) throws ResourceNotFound {

        commentService.deleteComment(idComment);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted ",true);
        return  response;
    }
  //  @PutMapping // TB continue
  //  public Comment updateComment(long idComment,String)
}
