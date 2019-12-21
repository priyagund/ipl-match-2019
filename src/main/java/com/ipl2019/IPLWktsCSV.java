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
    public String average;
    @CsvBindByName(column = "SR")
    public String strikingRate;
    @CsvBindByName(column = "Wkts")
    public String wkts;
    @CsvBindByName(column = "4w")
    public String fourWkts;
    @CsvBindByName(column = "5w")
    public String fiveWkts;
    @CsvBindByName(column = "Runs")
    public String runs;
    @CsvBindByName(column = "Ov")
    public String overs;

    public IPLWktsCSV() {
    }

    public IPLWktsCSV(String player, String match, String noOffours, String noOfSixs, String average, String strikingRate, String wkts, String fourWkts, String fiveWkts, String runs) {
        this.player = player;
        this.match = match;
        this.noOffours = noOffours;
        this.noOfSixs = noOfSixs;
        this.average = average;
        this.strikingRate = strikingRate;
        this.wkts = wkts;
        this.fourWkts = fourWkts;
        this.fiveWkts = fiveWkts;
        this.runs = runs;
    }
}
