package com.edu.school.courses.model.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/*To create Post the caller should*/

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;

    //TODO: change Group to groupId
    @ManyToOne(targetEntity = Group.class)
    @JsonIgnore
    private Group group;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private String content;
    private LocalDate createdDate;
    private int likes;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> comments;

    public static Post getInstance(Post userPost) {
        Post newPost = new Post();
        newPost.setContent(userPost.getContent());
        newPost.setAuthor(userPost.getAuthor());
        newPost.setComments(userPost.getComments());
        newPost.setCreatedDate(userPost.getCreatedDate());
        newPost.setLikes(userPost.getLikes());
        return newPost;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
