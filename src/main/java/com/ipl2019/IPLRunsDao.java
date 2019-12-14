package com.ipl2019;

public class IPLRunsDao
{
    public String player;
    public int match;
    public int century;
    public int fifty;
    public double average;
    public int noOfFours;
    public int noOfSixs;
    public int strikingRate;

    public IPLRunsDao(IPLRunsCSV iplRunsCsv) {
        this.player = iplRunsCsv.player;
        if (iplRunsCsv.average.contains("-")) {
            this.average = 0;
        }
        if (!iplRunsCsv.average.contains("-")) {
            this.average = Double.parseDouble(iplRunsCsv.average);
        }
        this.strikingRate = iplRunsCsv.strikingRate;
        this.century = iplRunsCsv.century;
        this.fifty = iplRunsCsv.fifty;
        this.noOfSixs = iplRunsCsv.noOfSixs;
        this.noOfFours = iplRunsCsv.noOffours;
    }
   }

