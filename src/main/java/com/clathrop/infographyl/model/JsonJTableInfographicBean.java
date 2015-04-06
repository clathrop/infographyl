package com.clathrop.infographyl.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by clathrop on 4/4/15.
 */
public class JsonJTableInfographicBean {



    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String tags;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString(){
        return "{id: " + id + ", name: " + name + ", description: " + description + ", url: " + url + "}";
    }


}
