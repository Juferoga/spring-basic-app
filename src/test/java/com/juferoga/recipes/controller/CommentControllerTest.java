package com.juferoga.recipes.controller;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.juferoga.recipes.models.CommentModel;
import com.juferoga.recipes.services.CommentService;

public class CommentControllerTest {

    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentController commentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllComments() {
        CommentModel comment1 = new CommentModel();
        comment1.setId(1L);
        comment1.setComment("comment1");

        CommentModel comment2 = new CommentModel();
        comment2.setId(2L);
        comment2.setComment("comment2");

        List<CommentModel> commentList = Arrays.asList(comment1, comment2);

        when(commentService.getAllComments()).thenReturn(commentList);

        ResponseEntity<List<CommentModel>> response = commentController.getAllComments();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(commentService, times(1)).getAllComments();
    }

    @Test
    public void testGetCommentById() {
        CommentModel comment = new CommentModel();
        comment.setId(1L);
        comment.setComment("comment1");

        when(commentService.getCommentById(1L)).thenReturn(comment);

        ResponseEntity<CommentModel> response = commentController.getCommentById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("comment1", response.getBody().getComment());
        verify(commentService, times(1)).getCommentById(1L);
    }

    @Test
    public void testSaveComment() {
        CommentModel comment = new CommentModel();
        comment.setId(1L);
        comment.setComment("comment1");

        when(commentService.saveComment(comment)).thenReturn(comment);

        ResponseEntity<CommentModel> response = commentController.saveComment(comment);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("comment1", response.getBody().getComment());
        verify(commentService, times(1)).saveComment(comment);
    }

    @Test
    public void testUpdateComment() {
        CommentModel comment = new CommentModel();
        comment.setId(1L);
        comment.setComment("comment1");

        when(commentService.updateComment(comment)).thenReturn(comment);

        ResponseEntity<CommentModel> response = commentController.updateComment(comment);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("comment1", response.getBody().getComment());
        verify(commentService, times(1)).updateComment(comment);
    }

    @Test
    public void testDeleteComment() {
        doNothing().when(commentService).deleteComment(1L);

        ResponseEntity<String> response = commentController.deleteComment(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Comment deleted successfully", response.getBody());
        verify(commentService, times(1)).deleteComment(1L);
    }
}