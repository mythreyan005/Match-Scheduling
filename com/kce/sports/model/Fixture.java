package com.kce.sports.model;

public class Fixture {
    private int fixtureId;
    private Team team1;
    private Team team2;
    private String date;

    public Fixture(int fixtureId, Team team1, Team team2, String date) {
        this.fixtureId = fixtureId;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
    }

    public void displayFixture() {
        System.out.println("Fixture " + fixtureId + ": " + team1.getTeamName() + " vs " + team2.getTeamName() + " on " + date);
    }

    public Team getTeam1() { return team1; }
    public Team getTeam2() { return team2; }
}
