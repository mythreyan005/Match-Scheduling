package com.kce.sports.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int teamId;
    private String teamName;
    private List<Player> players;

    public Team(int teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.players = new ArrayList<>();
    }

    public String getTeamName() { return teamName; }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void displayTeam() {
        System.out.println("Team: " + teamName);
        for(Player p : players) {
            p.displayPlayer();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
