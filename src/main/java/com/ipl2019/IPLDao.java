package com.ipl2019;

public class IPLDao
{
    public String player;
    public int match;
    public int century;
    public int fifty;
    public double bowlingAverage;
    public double battingAverage;
    public int noOfFours;
    public int noOfSixs;
    public double strikingRate;
    public int runs;
    public int wickets;
    public int fourWkts;
    public int fiveWkts;
    public double overs;
    public double economy;

    public IPLDao(IPLRunsCSV iplRunsCsv) {
        this.battingAverage=Double.parseDouble(iplRunsCsv.battingAverage);
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
        this.bowlingAverage=Double.parseDouble(iplWktsCSV.bowlingAverage);
        this.player = iplWktsCSV.player;
        this.wickets=Integer.parseInt(iplWktsCSV.wickets);
        this.fourWkts=Integer.parseInt(iplWktsCSV.fourWkts);
        this.fiveWkts=Integer.parseInt(iplWktsCSV.fiveWkts);
        this.strikingRate =Double.parseDouble(iplWktsCSV.strikingRate);
        this.runs=Integer.parseInt(iplWktsCSV.runs);
        this.match=Integer.parseInt(iplWktsCSV.match);
        this.overs=Double.parseDouble(iplWktsCSV.overs);
        this.economy=Double.parseDouble(iplWktsCSV.economy);
    }

}

