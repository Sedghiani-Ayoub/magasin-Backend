package com.funsot.magasin.services;

import com.funsot.magasin.entities.Comment;
import com.funsot.magasin.entities.Product;
import com.funsot.magasin.exeptions.ResourceNotFound;
import com.funsot.magasin.magasin.entities.CommentDto;
import com.funsot.magasin.repository.CommentRepository;
import com.funsot.magasin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
@Autowired
    CommentRepository commentRepository;
@Autowired
ProductService productService ;
@Autowired
    ProductRepository productRepository;
    @Override
    public Comment addComment(CommentDto commentDto) throws ResourceNotFound {
        Product product = productRepository.findById(Long.parseLong(commentDto.getIdp())).orElseThrow(
        ()-> new ResourceNotFound("Product not found for id :"+commentDto.getIdp())
        //Product product = productRepository.findById(idProduct).orElseThrow(
              //  ()-> new ResourceNotFound("Product not found for id :"+idProduct)
        );

        if(!StringUtils.hasText(commentDto.getText()))
            new ResourceNotFound("Indicate comment");


            Comment comment = new Comment();
            comment.setText(commentDto.getText());
            comment.setProduct(product);
            comment.setCreationTime(LocalDateTime.now());
            comment.setRating(Long.parseLong(commentDto.getRating()));

            return  commentRepository.save(comment);


    }

    @Override
    public Comment updateComment(long idComment, String text) throws ResourceNotFound {
        Comment comment = commentRepository.findById(idComment).orElseThrow(
                ()-> new ResourceNotFound("comment not found for id : "+idComment)
        );
        if(!StringUtils.hasText(text))
            new ResourceNotFound("Indicate comment");
        comment.setText(text);
        return  commentRepository.save(comment);


    }

    @Override
    public void deleteComment(long idComment) throws ResourceNotFound {
        Comment comment = commentRepository.findById(idComment).orElseThrow(
                ()-> new ResourceNotFound(("comment not found for id "+idComment))
        );

    }

    @Override
    public List<Comment> getComment(long idProduct) throws ResourceNotFound {
        Product product = productRepository.findById(idProduct).orElseThrow(
                ()-> new ResourceNotFound(("comment not found for id "+idProduct))
        );
        return  commentRepository.findByProduct(product);
    }
}
