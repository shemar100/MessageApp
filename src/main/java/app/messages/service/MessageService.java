package app.messages.service;

import app.messages.model.Message;
import app.messages.repository.MessageRepository;
import app.messages.security.SecurityCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class MessageService {
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);
    private MessageRepository repository;


    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @SecurityCheck
    @Transactional(noRollbackFor = {UnsupportedOperationException.class})
    public Message save(String text) {
        Message message = repository.saveMessage(new Message(text));
        log.debug("New message[id={}] saved", message.getId());
        return message;
    }

    @Transactional(readOnly = true)
    public List<Message> getMessages() {
        return repository.getMessages();
    }

    private void updateStatistics() {
        throw new UnsupportedOperationException("This method is implemented yet");
    }


}
