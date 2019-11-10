package com.edu.school.courses.model.Group;

import javax.persistence.Embeddable;

@Embeddable
public class Options {

    private String content;
    private int counter;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
