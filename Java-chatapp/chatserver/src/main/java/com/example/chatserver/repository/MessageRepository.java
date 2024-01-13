package com.example.chatserver.repository;

import com.example.chatserver.model.Message;
import com.example.chatserver.model.MessageStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String>
{
  Long countMessageBySenderNameAndReceiverNameAndMessageStatus(String sender, String receiver, MessageStatus messageStatus);
  Page<Message> findMessageBySenderNameAndReceiverNameOrderByTimeStampDesc(String sender, String receiver, Pageable pageable);
  List<Message> findByIdIn(List<String> messageIds);
}
