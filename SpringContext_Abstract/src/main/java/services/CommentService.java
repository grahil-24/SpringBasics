package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Service
@Lazy
//by default the scope is singleton ie only one instance of bean is shared to different
// objects. Singleton beans are usually immutable. If we want beans to be mutable
// it is more preferable to use prototype scope, as mutable singletons might create
//concurrency problem, like when two or more threads try to write to same bean
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    //We would have to use @Autowired if the class had more than one constructor
    //Spring sees the attributes are defined with interface types and is smart enough
    //to search in its context for beans created with classes that implement these interfaces
    public CommentService(@Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        System.out.println("Comment Service instance created");
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

}
