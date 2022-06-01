package io.springapplication.ratingdataservice.models;

public class Meta {
    int code;
    String status;
    int description;

    public Meta(int code, String status, int description) {
        this.code = code;
        this.status = status;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
