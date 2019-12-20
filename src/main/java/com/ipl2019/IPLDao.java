package com.ipl2019;

public class IPLDao
{
    public String player;
    public int match;
    public int century;
    public int fifty;
    public double average;
    public int noOfFours;
    public int noOfSixs;
    public double strikingRate;
    public int runs;
    public int wkts;
    public int fourWkts;
    public int fiveWkts;

    public IPLDao(IPLRunsCSV iplRunsCsv) {
        this.average=Double.parseDouble(iplRunsCsv.average);
        this.player = iplRunsCsv.player;
        this.strikingRate =Double.parseDouble(iplRunsCsv.strikingRate);
        this.century = Integer.parseInt(iplRunsCsv.century);
        this.fifty = Integer.parseInt(iplRunsCsv.fifty);
        this.noOfSixs = Integer.parseInt(iplRunsCsv.noOfSixs);
        this.noOfFours = Integer.parseInt(iplRunsCsv.noOffours);
        this.runs=Integer.parseInt(iplRunsCsv.runs);
        this.match=Integer.parseInt(iplRunsCsv.match);
    }

    public IPLDao(IPLWktsCSV iplWktsCSV) {

        this.player = iplWktsCSV.player;
        this.wkts=Integer.parseInt(iplWktsCSV.wkts);
        this.fourWkts=Integer.parseInt(iplWktsCSV.fourWkts);
        this.fiveWkts=Integer.parseInt(iplWktsCSV.fiveWkts);
    }

}

