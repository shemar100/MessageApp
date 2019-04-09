package app.messages.repository;


import app.messages.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MessageRepository {

    private SessionFactory sessionFactory;


    public MessageRepository(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;

    }


    public Message saveMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
        return message;
    }

    public List<Message> getMessages() {

        Session session = sessionFactory.openSession();
        String hql = "from Message";
        Query<Message> query = session.createQuery(hql, Message.class);
        return query.list();

    }

}