package com.ipl2019;

import com.opencsv.bean.CsvBindByName;

public class IPLRunsCSV
{

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;
    @CsvBindByName(column = "Runs", required = true)
    public String runs;
    @CsvBindByName(column = "100", required = true)
    public String century;
    @CsvBindByName(column = "50", required = true)
    public String fifty;
    @CsvBindByName(column = "4s", required = true)
    public String noOffours;
    @CsvBindByName(column = "6s", required = true)
    public String noOfSixs;
    @CsvBindByName(column = "Avg", required = true)
    public String battingAverage;
    @CsvBindByName(column = "SR", required = true)
    public String strikingRate;
    @CsvBindByName(column = "Mat", required = true)
    public String match;

    public IPLRunsCSV() {

    }

    public IPLRunsCSV(IPLDao iplRunsDao) {

    }

    public IPLRunsCSV(String player, String match, String runs, String battingAverage, String strikingRate, String century, String fifty, String noOfFours, String noOfSix) {
        this.player=player;
        this.match=match;
        this.century=century;
        this.fifty=fifty;
        this.strikingRate=strikingRate;
        this.runs=runs;
        this.noOffours=noOfFours;
        this.noOfSixs=noOfSix;
        this.battingAverage=battingAverage;

    }
}
