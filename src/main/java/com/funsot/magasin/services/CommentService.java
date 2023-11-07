package com.funsot.magasin.services;

import com.funsot.magasin.entities.Comment;
import com.funsot.magasin.exeptions.ResourceNotFound;
import com.funsot.magasin.magasin.entities.CommentDto;

import java.util.List;

public interface CommentService {
    public Comment addComment(CommentDto commentDto) throws ResourceNotFound;
    public Comment updateComment(long idComment,String text) throws ResourceNotFound;
    public void deleteComment(long idComment) throws ResourceNotFound;
    public List<Comment> getComment(long idProduct) throws ResourceNotFound;

}
