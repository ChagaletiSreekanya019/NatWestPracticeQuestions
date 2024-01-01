package org.uplift.libraryproject.model;

import java.util.Arrays;

public class HolidayApiResponse {
    private int status;
    private Holiday[] holidays;
    private String error;



    public int getStatus() {
        return status;
    }

    public Holiday[] getHolidays() {
        return holidays;
    }

    public String getError() {
        return  error;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "HolidayApiResponse{" +
                "status=" + status +
                ", holidays=" + Arrays.toString(holidays) +
                ", error='" + error + '\'' +
                '}';
    }
}
