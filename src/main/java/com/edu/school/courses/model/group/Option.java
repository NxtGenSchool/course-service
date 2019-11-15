package com.edu.school.courses.model.group;

import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class Option {

    private String uidPk;
    private String content;
    private int counter;

    public Option() {
        this.setUidPk(UUID.randomUUID().toString());
    }

    public String getUidPk() {
        return uidPk;
    }

    public void setUidPk(String uidPk) {
        this.uidPk = uidPk;
    }

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
