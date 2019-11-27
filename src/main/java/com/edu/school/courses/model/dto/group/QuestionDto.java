package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuestionDto {

    private Long uidPk;
    private Group group;
    private Author author;
    private String content;
    private LocalDate createdDate;
    private int ask;
    private List<Comment> comments;
    private List<Answer> answers;

    public static Question QuestionDtoToQuestionMapper(QuestionDto questionDto) {
        Question question = new Question();
        if (questionDto != null) {
            question.setUidPk(questionDto.getUidPk());
            question.setGroup(questionDto.getGroup());
            question.setContent(questionDto.getContent());
            question.setAnswers(questionDto.getAnswers());
            question.setComments(questionDto.getComments());
            question.setAsk(questionDto.getAsk());
            question.setCreatedDate(questionDto.getCreatedDate());
            question.setAuthor(questionDto.getAuthor());
        }
        return question;
    }

    public static QuestionDto QuestionToQuestionDtoMapper(Question question) {
        QuestionDto questionDto = new QuestionDto();
        if (question != null) {
            questionDto.setUidPk(question.getUidPk());
            questionDto.setGroup(question.getGroup());
            questionDto.setContent(question.getContent());
            questionDto.setAnswers(question.getAnswers());
            questionDto.setComments(question.getComments());
            questionDto.setAsk(question.getAsk());
            questionDto.setCreatedDate(question.getCreatedDate());
            questionDto.setAuthor(question.getAuthor());
        }
        return questionDto;
    }

    public static List<QuestionDto> QuestionToQuestionDtoMapper(List<Question> questionList) {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questionList) {
            QuestionDto questionDto = new QuestionDto();
            questionDto.setUidPk(question.getUidPk());
            questionDto.setGroup(question.getGroup());
            questionDto.setContent(question.getContent());
            questionDto.setAnswers(question.getAnswers());
            questionDto.setComments(question.getComments());
            questionDto.setAsk(question.getAsk());
            questionDto.setCreatedDate(question.getCreatedDate());
            questionDto.setAuthor(question.getAuthor());
            questionDtoList.add(questionDto);
        }
        return questionDtoList;
    }

    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public int getAsk() {
        return ask;
    }

    public void setAsk(int ask) {
        this.ask = ask;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
