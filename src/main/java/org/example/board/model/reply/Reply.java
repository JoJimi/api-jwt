package org.example.board.model.reply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.example.board.model.entity.PostEntity;
import org.example.board.model.entity.ReplyEntity;
import org.example.board.model.post.Post;
import org.example.board.model.user.User;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Reply(
        Long replyId,
        String body,
        User user,
        Post post,
        ZonedDateTime createdDateTime,
        ZonedDateTime updatedDateTime,
        ZonedDateTime deletedDateTime) {
    public static Reply from(ReplyEntity replyEntity){
        return new Reply(
                replyEntity.getReplyId(),
                replyEntity.getBody(),
                User.from(replyEntity.getUser()),
                Post.from(replyEntity.getPost()),
                replyEntity.getCreatedDateTime(),
                replyEntity.getUpdatedDateTime(),
                replyEntity.getDeletedDateTime()
        );
    }
}