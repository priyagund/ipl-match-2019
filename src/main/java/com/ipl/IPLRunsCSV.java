package com.ipl;

import com.opencsv.bean.CsvBindByName;

public class IPLRunsCSV
{
    @CsvBindByName(column = "POS")
    private int position;
    @CsvBindByName(column = "PLAYER", required = true)
    private String player;
    @CsvBindByName(column = "Runs", required = true)
    private int runs;
    @CsvBindByName(column = "100", required = true)
    private int century;
    @CsvBindByName(column = "50", required = true)
    private int fifty;
    @CsvBindByName(column = "4s", required = true)
    private int noOffours;
    @CsvBindByName(column = "6s", required = true)
    private int noOfSixs;

}
