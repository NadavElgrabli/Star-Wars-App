package com.example.mystartwarsapplication;

public class PeopleResponse {
    private int count;
    private String next;
    private String previous;
    private People[] results;

    public PeopleResponse(int count, String next, String previous, People[] results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public People[] getResults() {
        return results;
    }

    public void setResults(People[] results) {
        this.results = results;
    }
}
