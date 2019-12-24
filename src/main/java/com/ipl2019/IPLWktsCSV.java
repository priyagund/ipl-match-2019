package com.ipl2019;

import com.opencsv.bean.CsvBindByName;

public class IPLWktsCSV {
    @CsvBindByName(column = "PLAYER")
    public String player;
    @CsvBindByName(column = "Mat")
    public String match;
    @CsvBindByName(column = "4s")
    public String noOffours;
    @CsvBindByName(column = "6s")
    public String noOfSixs;
    @CsvBindByName(column = "Avg")
    public String bowlingAverage;
    @CsvBindByName(column = "SR")
    public String strikingRate;
    @CsvBindByName(column = "Wkts")
    public String wickets;
    @CsvBindByName(column = "4w")
    public String fourWkts;
    @CsvBindByName(column = "5w")
    public String fiveWkts;
    @CsvBindByName(column = "Runs")
    public String runs;
    @CsvBindByName(column = "Ov")
    public String overs;
    @CsvBindByName(column = "Econ")
    public String economy;


    public IPLWktsCSV(String player, String match, String overs, String runs, String wicket, String bowlingAverage, String strikingRate, String fourWkts, String fiveWkts,String economy) {
        this.player = player;
        this.match = match;
        this.overs=overs;
        this.bowlingAverage = bowlingAverage;
        this.strikingRate = strikingRate;
        this.wickets = wicket;
        this.fourWkts = fourWkts;
        this.fiveWkts = fiveWkts;
        this.runs = runs;
        this.economy=economy;
    }



}
