package io.springapplication.ratingdataservice.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Meta {
    private String status;

    private List<Rating> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Rating> getData() {
        return data;
    }

    public void setData(List<Rating> data) {
        this.data = data;
    }
}
