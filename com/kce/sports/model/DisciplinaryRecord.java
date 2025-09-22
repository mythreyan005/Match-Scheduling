package com.kce.sports.model;

public class DisciplinaryRecord {
    private Player player;
    private Team team;
    private String penalty;

    public DisciplinaryRecord(Player player, String penalty) {
        this.player = player;
        this.team = player.getTeam();
        this.penalty = penalty;
    }

    public void displayRecord() {
        System.out.println("Player: " + player.getName() + " Team: " + team.getTeamName() + " Penalty: " + penalty);
    }
}
