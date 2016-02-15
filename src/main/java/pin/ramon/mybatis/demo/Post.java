package pin.ramon.mybatis.demo;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Post
 * Created by ramon on 10/02/16.
 */
public class Post {

    public static final String BLOG_BY_ID       = "org.mybatis.demo.post.byId";
    public static final String BLOG_BY_AUTOR    = "org.mybatis.demo.post.byAutor";
    public static final String BLOG_BY_ID_AUTOR = "org.mybatis.demo.post.byIdAutor";

    private int    id;
    private String autor;
    private String texto;

    @SuppressWarnings("unused")
    public Post(Integer id, String autor, String texto) {
        this.id = id;
        this.autor = autor;
        this.texto = texto;
    }

    @SuppressWarnings("unused")
    public Post(String texto) {
        this.texto = texto;
    }

    public static Optional<Post> byId(int id, SqlSession session) {
        Post post = session.selectOne(BLOG_BY_ID, id);
        return Optional.fromNullable(post);
    }

    public static List<Post> byAutor(String autor, SqlSession session) {
        return session.selectList(BLOG_BY_AUTOR, autor);
    }

    public static Optional<Post> byIdAutor(int id, String autor, SqlSession session) {
        Post post = session.selectOne(BLOG_BY_ID_AUTOR, ImmutableMap.of("id", id, "autor", autor));
        if(post != null) { post.id = id; post.autor = autor; }
        return Optional.fromNullable(post);
    }

    public String toString() {
        return String.format("Post{id: %d, autor: %s, texto: %s}", id, autor, texto);
    }

}
