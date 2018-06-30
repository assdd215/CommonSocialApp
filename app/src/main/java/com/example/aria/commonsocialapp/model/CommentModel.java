package com.example.aria.commonsocialapp.model;

public class CommentModel {
    int id;
    User user;
    String commentContent;
    String time;

    public CommentModel(User user, String commentContent, String time) {
        this.user = user;
        this.commentContent = commentContent;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public String getTime() {
        return time;
    }
}
