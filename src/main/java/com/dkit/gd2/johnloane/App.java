package com.dkit.gd2.johnloane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Collections Recap
 * Given 4 arraylists of players their score in pacman, fortnite, and destiny2
 * Use a map which for each player will calculate the sum of their scores
 * and find the player or players with the highest score
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Best player in the world" );
        ArrayList<String> players = new ArrayList<>();
        populatePlayers(players);
        ArrayList<Integer> pacmanScores = new ArrayList<>();
        populatePacmanScores(players, pacmanScores);
        ArrayList<Integer> fortniteScores = new ArrayList<>();
        populateFortniteScores(players, fortniteScores);
        ArrayList<Integer> destiny2Scores = new ArrayList<>();
        populateDestiny2Scores(players, destiny2Scores);

        findPlayerWithHighestScore(players, pacmanScores, fortniteScores, destiny2Scores);
    }

    //Map Alex->pacmanScore+forniteScore+destiny2Score
    //same for everyone else
    //Look through the map and find the player or players with the highest scores
    //and print
    private static void findPlayerWithHighestScore(ArrayList<String> players, ArrayList<Integer> pacmanScores, ArrayList<Integer> fortniteScores, ArrayList<Integer> destiny2Scores)
    {
        Map<String, Integer> highScores = new HashMap<>();
        for(int i=0; i < players.size(); ++i)
        {
            highScores.put(players.get(i), (pacmanScores.get(i)+fortniteScores.get(i)+destiny2Scores.get(i)));
        }
        int highestScore = findHighestScore(highScores);
        printPlayerWithHighestScore(highestScore, highScores);
    }

    private static void printPlayerWithHighestScore(int highestScore, Map<String, Integer> highScores)
    {
        for(Map.Entry<String, Integer> entry : highScores.entrySet())
        {
            if(entry.getValue() == highestScore)
            {
                System.out.println(entry.getKey() + " has high score " + entry.getValue());
            }
        }
    }


    //Set score = 0, iterate through the map, if the value > score, score = value
    private static int findHighestScore(Map<String, Integer> highScores)
    {
        int highScore = 0;
        for(Map.Entry<String, Integer> entry : highScores.entrySet())
        {
            if(entry.getValue() > highScore)
            {
                highScore = entry.getValue();
            }
        }
        return highScore;
    }

    private static void populateDestiny2Scores(ArrayList<String> players,ArrayList<Integer> destiny2Scores)
    {
        for(int i=0; i < players.size(); ++i)
        {
            int score = ThreadLocalRandom.current().nextInt(300, 301);
            destiny2Scores.add(score);
        }
    }

    private static void populateFortniteScores(ArrayList<String> players,ArrayList<Integer> fortniteScores)
    {
        for(int i=0; i < players.size(); ++i)
        {
            int score = ThreadLocalRandom.current().nextInt(500, 501);
            fortniteScores.add(score);
        }
    }

    private static void populatePacmanScores(ArrayList<String> players, ArrayList<Integer> pacmanScores)
    {
        for(int i=0; i < players.size(); ++i)
        {
            int score = ThreadLocalRandom.current().nextInt(100, 101);
            pacmanScores.add(score);
        }
    }

    private static void populatePlayers(ArrayList<String> players)
    {
        players.add("Alex");
        players.add("Rachel");
        players.add("Cian");
        players.add("Ethan");
        players.add("Berk");
        players.add("Michael");
        players.add("Kevin");
        players.add("Zak");
        players.add("Lee");
        players.add("Emily");
        players.add("Oisin");
    }
}
