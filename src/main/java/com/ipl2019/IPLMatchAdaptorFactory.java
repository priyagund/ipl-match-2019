package com.ipl2019;

public class IPLMatchAdaptorFactory {
    public static IPLMatchAdaptor getCensusData(IPLMatch2019.Player player) throws IPLMatchException {
        if(player.equals(IPLMatch2019.Player.BATSMAN))
            return new IPLBowlerAdaptor();
        if(player.equals(IPLMatch2019.Player.BOWLWER))
            return new IPLBowlersAdaptor();
        throw new IPLMatchException("unknown Player",IPLMatchException.ExceptionType.INVALID_PLAYER);
    }
}
