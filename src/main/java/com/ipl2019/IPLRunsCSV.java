package com.ipl2019;

import com.opencsv.bean.CsvBindByName;

public class IPLRunsCSV
{
    @CsvBindByName(column = "PLAYER", required = true)
    public String player;
    @CsvBindByName(column = "Runs", required = true)
    public int runs;
    @CsvBindByName(column = "100", required = true)
    public int century;
    @CsvBindByName(column = "50", required = true)
    public int fifty;
    @CsvBindByName(column = "4s", required = true)
    public int noOffours;
    @CsvBindByName(column = "6s", required = true)
    public int noOfSixs;
    @CsvBindByName(column = "Avg", required = true)
    public String average;
    @CsvBindByName(column = "SR", required = true)
    public int strikingRate;
    @CsvBindByName(column = "Mat", required = true)
    public int match;

    public IPLRunsCSV() {

    }

    public IPLRunsCSV(IPLRunsDao iplRunsDao) {

    }
}
