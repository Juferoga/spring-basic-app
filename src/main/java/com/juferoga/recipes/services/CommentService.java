package com.juferoga.recipes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juferoga.recipes.models.CommentModel;
import com.juferoga.recipes.repositories.CommentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
  private final CommentRepository commentRepository;

  @Transactional(readOnly = true)
  public List<CommentModel> getAllComments() {
    List<CommentModel> comments = commentRepository.findAll();
    // Inicializa las colecciones perezosas
    for (CommentModel comment : comments) {
      comment.getRecipeId().getIngredients().size(); // Accede a un campo de CommentModel para inicializar
    }
    return comments;
  }

  @Transactional(readOnly = true)
  public CommentModel getCommentById(Long id) {
    CommentModel comment = commentRepository.findById(id).orElse(null);
    if (comment != null) {
      comment.getRecipeId().getIngredients().size(); // Accede a un campo de CommentModel para inicializar
    }
    return comment;
  }

  public CommentModel saveComment(CommentModel comment) {
    return commentRepository.save(comment);
  }

  public CommentModel updateComment(CommentModel comment) {
    return commentRepository.save(comment);
  }

  public void deleteComment(Long id) {
    commentRepository.deleteById(id);
  }
}
