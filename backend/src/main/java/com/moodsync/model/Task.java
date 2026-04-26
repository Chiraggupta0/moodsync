package com.moodsync.model;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String mood;
    private boolean completed;

    public Long getId(){return id;}
    public String getTitle(){return title;}
    public void setTitle(String t){this.title=t;}
    public String getMood(){return mood;}
    public void setMood(String m){this.mood=m;}
    public boolean isCompleted(){return completed;}
    public void setCompleted(boolean c){this.completed=c;}
}
