package com.clathrop.infographyl.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by clathrop on 4/1/15.
 */
@Entity
@Table(name = "infographics")
public class Infographic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String url;
    @Column
    private String category;
    @Column
    private String tags;

    public Infographic(){

    }

    public Infographic(int id){
        this.id = id;
    }

    public Infographic(String name, String url){
        setName(name);
        setUrl(url);
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString(){
        return "{id: " + id + ", name: " + name + ", " + url + "}";
    }

}
