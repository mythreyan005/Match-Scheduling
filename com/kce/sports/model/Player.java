package com.kce.sports.model;

public class Player extends Person {
    private int playerId;
    private String position;
    private Team team;

    public Player(int playerId, String name, int age, String position, Team team) {
        super(name, age);
        this.playerId = playerId;
        this.position = position;
        this.team = team;
    }

    public void displayPlayer() {
        System.out.println("ID: " + playerId + " Name: " + getName() + " Age: " + getAge() + " Position: " + position + " Team: " + team.getTeamName());
    }

    public Team getTeam() {
        return team;
    }
}
