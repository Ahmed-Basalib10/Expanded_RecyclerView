package com.e.expandedrecyclerview;

public class movie {
    private String title;
    private String rating;
    private String year;
    private String plot;
    private boolean expand;

    public movie(String title, String rating, String year, String plot) {
        this.title = title;
        this.rating = rating;
        this.year = year;
        this.plot = plot;
        this.expand=false;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
