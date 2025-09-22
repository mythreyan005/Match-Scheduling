package com.kce.sports.model;

public class Match {
    private int matchId;
    private Fixture fixture;
    private Result result;

    public Match(int matchId, Fixture fixture) {
        this.matchId = matchId;
        this.fixture = fixture;
    }

    public void recordResult(int team1Score, int team2Score) {
        this.result = new Result(team1Score, team2Score);
    }

    public void displayMatch() {
        fixture.displayFixture();
        if(result != null)
            result.displayResult();
        else
            System.out.println("Result not recorded yet.");
    }
}
