package com.kce.sports.model;

public class Result {
    private int team1Score;
    private int team2Score;

    public Result(int team1Score, int team2Score) {
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    public void displayResult() {
        System.out.println("Result: " + team1Score + " - " + team2Score);
    }
}
