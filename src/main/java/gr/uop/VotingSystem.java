package gr.uop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VotingSystem {
        private final String[] votingCountriesNames = {
                        "Albania",
                        "Armenia",
                        "Australia",
                        "Austria",
                        "Azerbaijan",
                        "Belgium",
                        "Croatia",
                        "Cyprus",
                        "Czechia",
                        "Denmark",
                        "Estonia",
                        "Finland",
                        "France",
                        "Germany",
                        "Georgia",
                        "Greece",
                        "Iceland",
                        "Ireland",
                        "Israel",
                        "Italy",
                        "Latvia",
                        "Lithuania",
                        "Luxembourg",
                        "Malta",
                        "Moldova",
                        "Netherlands",
                        "Norway",
                        "Poland",
                        "Portugal",
                        "San Marino",
                        "Serbia",
                        "Slovenia",
                        "Spain",
                        "Sweden",
                        "Switzerland",
                        "Ukraine",
                        "United Kingdom"
        };

        private final String[] countriesInFinalNames = {
                        "Armenia",
                        "Austria",
                        "Croatia",
                        "Cyprus",
                        "Estonia",
                        "Finland",
                        "France",
                        "Georgia",
                        "Germany",
                        "Greece",
                        "Ireland",
                        "Israel",
                        "Italy",
                        "Latvia",
                        "Lithuania",
                        "Luxembourg",
                        "Netherlands",
                        "Norway",
                        "Portugal",
                        "Serbia",
                        "Slovenia",
                        "Spain",
                        "Sweden",
                        "Switzerland",
                        "Ukraine",
                        "United Kingdom",
        };

        private final int[] points = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 12 };

        public void start() {
                Scanner input = new Scanner(System.in);

                ArrayList<CountryInFinal> countriesInFinal = new ArrayList<>();
                ArrayList<VotingCountry> countriesVote = new ArrayList<>();

                ArrayList<Integer> vote = new ArrayList<>();
                Map<String, Integer> pointsTo = new LinkedHashMap<>();
                for (int i = 0; i < 37; i++) {
                        vote.add(i);
                }
                Collections.shuffle(vote);

                for (int i = 0; i < 37; i++) {
                        String voteCountry = votingCountriesNames[vote.get(i)];
                        System.out.println(voteCountry + " is voting");

                        for (int j = 1; j < 14; j++) {
                                int num = j, num2 = num + 13;
                                System.out.println(
                                                num + ". " + countriesInFinalNames[num - 1] + "\t\t\t" + num2 + ". "
                                                                + countriesInFinalNames[num2 - 1]);
                        }

                        Map<Integer, Integer> selectHistory = new HashMap<>();
                        // First int for Country, second int for Points
                        int country = 0;
                        int points;
                        VotingCountry vc = new VotingCountry(voteCountry, pointsTo);
                        CountryInFinal cif;
                        for (points = 1; points < 13; points++) {
                                if (points == 9 || points == 11)
                                        points++;

                                System.out.print("Select country for " + points + " point(s):");
                                country = input.nextInt();
                                while (country < 1 || country > 26) {
                                        System.out.println("Incorrect country index!");
                                        System.out.print("Select country for " + points + " point(s):");
                                        country = input.nextInt();
                                }
                                while (voteCountry.equals(countriesInFinalNames[country - 1])) {
                                        System.out.println("*** You cannot vote yourself!");
                                        System.out.print("Select country for " + points + " point(s):");
                                        country = input.nextInt();
                                }
                                while (selectHistory.containsKey(country)) {
                                        int existingPoints = selectHistory.get(country);
                                        System.out.println("*** You have already assigned " + existingPoints
                                                        + " points to "
                                                        + countriesInFinalNames[country - 1]);
                                        System.out.print("Select country for " + points + " point(s):");
                                        country = input.nextInt();
                                }
                                selectHistory.put(country, points);
                                cif = new CountryInFinal(countriesInFinalNames[country - 1], points);
                                countriesInFinal.add(cif);

                                pointsTo.put(countriesInFinalNames[country - 1], points);
                                vc = new VotingCountry(voteCountry, pointsTo);
                                countriesVote.add(vc);

                        }
                        System.out.println("\nThe points from " + voteCountry + " are:");
                        vc.printAllPoints();

                        System.out.println("\nResults:");
                        Map<String, Integer> res = new TreeMap<>();
                        for (Map.Entry<String, Integer> e : pointsTo.entrySet()) {
                                res.put(e.getKey(), e.getValue());
                                System.out.println(e.getKey() + "\t\t" + e.getValue());
                        }
                        // System.out.println(res);
                }

        }
}
