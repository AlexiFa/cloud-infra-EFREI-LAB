package com.example.CM_lab1.data;

import java.util.Objects;

public class Dates {
    String begin;
    String end;

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dates dates = (Dates) o;
        return Objects.equals(begin, dates.begin) && Objects.equals(end, dates.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end);
    }
}
