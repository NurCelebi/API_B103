package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

//popjoi icinde olmayan deger icin onu ignore et diyoruz boyle yaparak
public class JsonPlaceHolderPojo {

    private Integer userId;
    private String title;
    private Boolean completed;

    public JsonPlaceHolderPojo() { //bununla De-serialization yapicaz


    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() { //toString sayesinde okuyoruz olmasa farkli okuyamadigimiz bir kod gelir
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

/*
     {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
 */
