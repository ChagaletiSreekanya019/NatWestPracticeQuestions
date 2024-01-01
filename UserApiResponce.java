package org.uplift.libraryproject.model;

import java.util.Objects;

public class UserApiResponce {
    private int status;
    private User details;
    private String error;

    public int getStatus() {
        return status;
    }

    public User getDetails() {
        return details;
    }

    public String getError() {
        return error;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserApiResponce that = (UserApiResponce) o;
        return status == that.status && Objects.equals(details, that.details) && Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, details, error);
    }

    @Override
    public String toString() {
        return "UserApiService{" +
                "status=" + status +
                ", details=" + details +
                ", error='" + error + '\'' +
                '}';
    }
}
