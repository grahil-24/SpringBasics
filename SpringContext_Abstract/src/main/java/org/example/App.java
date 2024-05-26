package org.example;

import config.ProjConf;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.CommentNotificationProxy;
import proxies.EmailNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        //spring uses eager instantiation by default, which means all the beans are
        //created and stored in context when spring context is created. We can change
        //it to lazy by using the @lazy annotation. Lazy means that the bean is created
        //only when needed.
        var context = new AnnotationConfigApplicationContext(ProjConf.class);

//        Comment cm = new Comment();
//        cm.setAuthor("dfs");
//        cm.setText("dfs");
//
//        var commentService = context.getBean(CommentService.class);
//        commentService.publishComment(cm);
    }
}
