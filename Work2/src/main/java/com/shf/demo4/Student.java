package com.shf.demo4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Student {
    private String studentId; // 学号
    private String name;  // 姓名
    private boolean gender; // 性别
    private boolean isClassLeader;  // 是否班干部
    private double chineseScore;
    private double mathScore;
    private double englishScore;

    public Student() {
    }

    public Student(String studentId, String name, boolean gender, boolean isClassLeader, double chineseScore, double mathScore, double englishScore) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.isClassLeader = isClassLeader;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isClassLeader() {
        return isClassLeader;
    }

    public void setClassLeader(boolean classLeader) {
        isClassLeader = classLeader;
    }

    public double getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(double chineseScore) {
        this.chineseScore = chineseScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getSum(){
        return chineseScore + mathScore + englishScore;
    }

    public double getAvg(){
        return new BigDecimal(getSum() / 3).setScale(2, RoundingMode.UP).doubleValue();
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", isClassLeader=" + isClassLeader +
                ", chineseScore=" + chineseScore +
                ", mathScore=" + mathScore +
                ", englishScore=" + englishScore +
                '}';
    }
}
