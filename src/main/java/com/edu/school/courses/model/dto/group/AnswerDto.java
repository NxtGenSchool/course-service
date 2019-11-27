package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.Answer;
import com.edu.school.courses.model.group.Author;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnswerDto {

    private String uidPk;
    private Author author;
    private String content;
    private LocalDate createdDate;
    private int likes;

    public static Answer AnswerDtoToAnswerMapper(AnswerDto answerDto) {
        Answer answer = new Answer();
        if (answerDto != null) {
            answer.setUidPk(answerDto.getUidPk());
            answer.setContent(answerDto.getContent());
            answer.setLikes(answerDto.getLikes());
            answer.setAuthor(answerDto.getAuthor());
            answer.setCreatedDate(answerDto.getCreatedDate());
        }
        return answer;
    }

    public static AnswerDto AnswerToAnswerDtoMapper(Answer answer) {
        AnswerDto answerDto = new AnswerDto();
        if (answer != null) {
            answerDto.setUidPk(answerDto.getUidPk());
            answerDto.setContent(answerDto.getContent());
            answerDto.setLikes(answerDto.getLikes());
            answerDto.setAuthor(answerDto.getAuthor());
            answerDto.setCreatedDate(answerDto.getCreatedDate());
        }
        return answerDto;
    }

    public static List<AnswerDto> AnswerToAnswerDtoMapper(List<Answer> answerList) {
        List<AnswerDto> answerDtoList = new ArrayList<>();
        if (answerList != null) {
            for (Answer answer : answerList) {
                AnswerDto answerDto = new AnswerDto();
                answerDto.setUidPk(answerDto.getUidPk());
                answerDto.setContent(answerDto.getContent());
                answerDto.setLikes(answerDto.getLikes());
                answerDto.setAuthor(answerDto.getAuthor());
                answerDto.setCreatedDate(answerDto.getCreatedDate());
                answerDtoList.add(answerDto);
            }
        }
        return answerDtoList;
    }


    public String getUidPk() {
        return uidPk;
    }

    public void setUidPk(String uidPk) {
        this.uidPk = uidPk;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
