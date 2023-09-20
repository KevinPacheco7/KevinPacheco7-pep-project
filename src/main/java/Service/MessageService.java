package Service;

import java.util.List;
import DAO.MessageDAO;
import Model.Message;

public class MessageService {
    MessageDAO messagedao;

    public MessageService(){
        messagedao = new MessageDAO();
    }
    
    public Message addMessage(Message message){
        if(messagedao.getMessagebyPostBy(message.getPosted_by())==null){
            return null;
        }
        if(message.getMessage_text().length()>=255){
            return null;
        }
        if(message.getMessage_text().equals("")){
            return null;
        }
        return messagedao.insertMessage(message);
    }

    public Message updateMessage(int message_id,Message message){
        Message newMessage = messagedao.getMessagebyMessageId(message_id);
        if(message.getMessage_text().length()>=255){
            return null;
        }
        if(message.getMessage_text().equals("")){
            return null;
        }
        if(newMessage!=null){
            messagedao.updateMessage(message_id, message);
            return messagedao.getMessagebyMessageId(message_id);
        }
        return null;
    }
    public List<Message> getAllMessages(){
        return messagedao.getAllMessages();
    }

    public List<Message> getAllMessagesbyPostBy(int posted_by){
        return messagedao.getAllMessagesById(posted_by);
    }

    public Message getMessageById(int message_id){
        if(messagedao.getMessagebyMessageId(message_id)==null){
            return null;
        }
        return messagedao.getMessagebyMessageId(message_id);
    }

    public Message deleteMessageById(int message_id){
        if(messagedao.getMessagebyMessageId(message_id)==null){
            return null;
        }
        Message message= getMessageById(message_id);
        messagedao.deleteMessage(message_id);
        return message;
    }
}