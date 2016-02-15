package pin.ramon.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MainMyBatis demo
 * Created by ramon on 10/02/16.
 */
public class MainMyBatisDemo {

    public static void main(String... args) throws IOException {

        SqlSessionFactory sqlSessionFactory = null;
        SqlSession session = null;

        try {

            String resource = "org/mybatis/demo/mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();

            runProgram(session);

        } finally {

            if(session != null) session.close();

        }


    }

    static Post desconocido = new Post(0, "DESCONOCIDO", "DESCONOCIDO");
    private static void runProgram(SqlSession session) {

        System.out.println(Post.byId(1, session).or(desconocido));
        System.out.println(Post.byId(101, session).or(desconocido));
        System.out.println(Post.byId(2, session).or(desconocido));

        System.out.println(Post.byAutor("ramon", session));
        System.out.println(Post.byAutor("paco", session));

        System.out.println(Post.byIdAutor(1, "ramon", session).or(desconocido));
    }

}
