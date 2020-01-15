package com.best_aid.proloy.lifesaver.Model;

public class Question {

    String description , comment  ;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question(String description , String comment) {
        this.description = description;
        this.comment = comment ;
    }
}