package com.shf.mvc.beans;

public class ScoreClass {
    private String bjbn;
    private String bjmc;

    public ScoreClass() {
    }

    public ScoreClass(String bjbn, String bjmc) {
        this.bjbn = bjbn;
        this.bjmc = bjmc;
    }

    public String getBjbn() {
        return bjbn;
    }

    public void setBjbn(String bjbn) {
        this.bjbn = bjbn;
    }

    public String getBjmc() {
        return bjmc;
    }

    public void setBjmc(String bjmc) {
        this.bjmc = bjmc;
    }

    @Override
    public String toString() {
        return "ScoreClass{" +
                "bjbn='" + bjbn + '\'' +
                ", bjmc='" + bjmc + '\'' +
                '}';
    }
}
