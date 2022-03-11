package com.example.kkdemo_version1.Mappers;

import com.example.kkdemo_version1.Model.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
messages
		long		long			long			int		string		timestamp	timestamp		timestamp
		messages_id	messages_send_users_id	messages_receiver_users_id	message_type	messages_content	messages_set_time	messages_expire_time	message_send_time
				refers to users_id		refers to users_id
* */
public interface MessageMybatisRepository {
    @Select("SELECT * FROM messages")
    public List<Message> findAll();

    @Select("SELECT * FROM messages WHERE messages_id = #{id}")
    public Message findByMessageId(long id);

    @Select("SELECT * FROM messages WHERE messages_send_users_id = #{id}")
    public Message findBySenderId(long id);

    @Select("SELECT * FROM messages WHERE messages_receiver_users_id = #{id}")
    public Message findByReceiverId(long id);

    @Delete("DELETE FROM messages WHERE messages_id = #{id}")
    public int deleteByMessageId(long id);

    @Insert("INSERT INTO messages(messages_id, messages_send_users_id, messages_receiver_users_id,message_type,messages_content, messages_set_time, messages_expire_time, message_send_time) " +
            " VALUES (#{id}, #{senderId}, #{receiverId}, #{type}, #{content}), #{setTime}), #{expireTime}), #{sendTime})")
    public int insert(Message message);

    @Update("UPDATE messages set message_type=#{type} where messages_id=#{id}")
    public int update(Message message);
}
