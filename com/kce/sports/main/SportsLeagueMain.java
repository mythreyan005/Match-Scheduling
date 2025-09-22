package com.kce.sports.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kce.sports.exceptions.InvalidInputException;
import com.kce.sports.model.DisciplinaryRecord;
import com.kce.sports.model.Fixture;
import com.kce.sports.model.Match;
import com.kce.sports.model.Player;
import com.kce.sports.model.Team;

public class SportsLeagueMain {

    static Scanner sc = new Scanner(System.in);
    static List<Team> teams = new ArrayList<>();
    static List<Player> players = new ArrayList<>();
    static List<Fixture> fixtures = new ArrayList<>();
    static List<Match> matches = new ArrayList<>();
    static List<DisciplinaryRecord> records = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\t ----> Sports League Menu <----");
            System.out.println("1. Add Team");
            System.out.println("2. Add Player");
            System.out.println("3. Create Fixture");
            System.out.println("4. Record Match Result");
            System.out.println("5. View Fixtures");
            System.out.println("6. View Disciplinary Log");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 
            try {
                if (choice < 1 || choice > 7) {
                    throw new InvalidInputException ("Invalid choice! Enter 1-7 only.");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }


            switch (choice) {
                case 1:
                    addTeam();
                    break;

                case 2:
                    addPlayer();
                    break;

                case 3:
                    createFixture();
                    break;

                case 4:
                    recordMatch();
                    break;

                case 5:
                    viewFixtures();
                    break;

                case 6:
                    viewDisciplinary();
                    break;

                case 7:
                    System.out.println("THANK YOU ");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-7.");
            }

        } while (choice != 7);
    }

  
    static void addTeam() {
        System.out.print("Enter Team ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Team Name: ");
        String name = sc.nextLine();

        teams.add(new Team(id, name));
        System.out.println("Team added!");
    }

   
    static void addPlayer() {
        if (teams.isEmpty()) {
            System.out.println("Add teams first!");
            return;
        }

        System.out.print("Enter Player ID: ");
        int pid = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Position: ");
        String pos = sc.nextLine();

        System.out.println("Select Team:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).getTeamName());
        }

        int t = sc.nextInt();
        sc.nextLine();
        Team team = teams.get(t - 1);

        Player p = new Player(pid, name, age, pos, team);
        team.addPlayer(p);
        players.add(p);

        System.out.println("Player added!");
    }


    static void createFixture() {
        if (teams.size() < 2) {
            System.out.println("At least 2 teams required!");
            return;
        }

        System.out.print("Enter Fixture ID: ");
        int fid = sc.nextInt();
        sc.nextLine();

        System.out.println("Select Team 1:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).getTeamName());
        }
        Team t1 = teams.get(sc.nextInt() - 1);
        sc.nextLine();

        System.out.println("Select Team 2:");
        for (int i = 0; i < teams.size(); i++) {
            if (!teams.get(i).equals(t1)) {
                System.out.println((i + 1) + ". " + teams.get(i).getTeamName());
            }
        }
        Team t2 = teams.get(sc.nextInt() - 1);
        sc.nextLine();

        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        fixtures.add(new Fixture(fid, t1, t2, date));
        System.out.println("Fixture created!");
    }


    static void recordMatch() {
        if (fixtures.isEmpty()) {
            System.out.println("No fixtures created!");
            return;
        }

        System.out.println("Select Fixture:");
        for (int i = 0; i < fixtures.size(); i++) {
            System.out.println((i + 1) + ". " 
                    + fixtures.get(i).getTeam1().getTeamName() + " vs " 
                    + fixtures.get(i).getTeam2().getTeamName());
        }

        Fixture f = fixtures.get(sc.nextInt() - 1);
        sc.nextLine();

        System.out.print("Enter Team1 Score: ");
        int s1 = sc.nextInt();

        System.out.print("Enter Team2 Score: ");
        int s2 = sc.nextInt();

        Match m = new Match(matches.size() + 1, f);
        m.recordResult(s1, s2);
        matches.add(m);

        System.out.println("Result recorded!");
    }

    static void viewFixtures() {
        System.out.println("\n=== Fixtures ===");
        for (Match m : matches) {
            m.displayMatch();
            System.out.println("-------------------");
        }
    }

    static void viewDisciplinary() {
        System.out.println("\n=== Disciplinary Records ===");
        if (records.isEmpty()) {
            System.out.println("No records.");
        } else {
            for (DisciplinaryRecord r : records) {
                r.displayRecord();
            }
        }
    }
}
