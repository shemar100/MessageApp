package app.messages;



import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.jdbc.support.GeneratedKeyHolder;

import org.springframework.stereotype.Component;



import javax.sql.DataSource;



@Component

public class MessageRepository {



    private static final Log logger = LogFactory.getLog(MessageRepository.class);



    private SessionFactory sessionFactory;


    @Autowired
    public MessageRepository(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;

    }


    public Message saveMessage(Message message) {
        Session session = sessionFactory.openSession();
        session.save(message);
        return message;

    }

}