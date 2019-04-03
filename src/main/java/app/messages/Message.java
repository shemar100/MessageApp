package app.messages;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "text", nullable = false, length = 128)
    private String text;
    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Message(String text) {
        this.text = text;
        this.createdDate = new Date();
    }

    public Message(int id, String text, Date createdDate) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
    }

    public Integer getId() {

        return id;

    }


    public String getText() {

        return text;

    }


    public Date getCreatedDate() {

        return createdDate;

    }


    @Override

    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return Objects.equals(id, message.id);

    }


    @Override

    public int hashCode() {

        return Objects.hash(id);

    }

}