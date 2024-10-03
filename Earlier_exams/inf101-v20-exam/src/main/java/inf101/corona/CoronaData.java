package inf101.corona;

import java.util.ArrayList;

public abstract class CoronaData implements ICoronaData{
    
    @Override
    public ArrayList<Integer> cumulativeDeaths() {
        ArrayList<Integer> cumulativeDeaths = new ArrayList<>();
        int sumDeaths = 0;
        for (int dailyDeath : getDailyDeaths()) {
            sumDeaths += dailyDeath;
            cumulativeDeaths.add(sumDeaths);
        }
        return cumulativeDeaths;
    }

    @Override
    public ArrayList<Double> deathsPerMillion() {
        ArrayList<Double> deathsPerMillion = new ArrayList<>();
        for (int cumulativeDeaths : cumulativeDeaths()) {
            double deaths = cumulativeDeaths / (getPopulation() / 1000000);
            deathsPerMillion.add(deaths);
        }
        return deathsPerMillion;
    } 
}
