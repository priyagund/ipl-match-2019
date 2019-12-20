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
    public String average;
    @CsvBindByName(column = "SR", required = true)
    public String strikingRate;
    @CsvBindByName(column = "Mat", required = true)
    public String match;

    public IPLRunsCSV() {

    }

    public IPLRunsCSV(IPLDao iplRunsDao) {

    }
}
