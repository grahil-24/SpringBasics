package org.example;

import config.ProjConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import model.Comment;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var context = new AnnotationConfigApplicationContext(ProjConf.class);
        CommentService cs = context.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setAuthor("rahil");
        comment.setText("bruh");
        String value= cs.publishComment(comment);
        System.out.println(value);

    }
}
