package com.juferoga.recipes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juferoga.recipes.models.CommentModel;
import com.juferoga.recipes.services.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@Validated
public class CommentController {
  private final CommentService commentService;

  @GetMapping("")
  public ResponseEntity<List<CommentModel>> getAllComments() {
    return ResponseEntity.ok().body(commentService.getAllComments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommentModel> getCommentById(@PathVariable Long id)
  {
    return ResponseEntity.ok().body(commentService.getCommentById(id));
  }
  
  @PostMapping("/")
  public ResponseEntity<CommentModel> saveComment(@RequestBody CommentModel comment)
  {
    return ResponseEntity.ok().body(commentService.saveComment(comment));
  }

  @PutMapping("/")
  public ResponseEntity<CommentModel> updateComment(@RequestBody CommentModel comment)
  {
    return ResponseEntity.ok().body(commentService.updateComment(comment));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteComment(@PathVariable Long id)
  {
    commentService.deleteComment(id);
    return ResponseEntity.ok().body("Comment deleted successfully");
  }
}
