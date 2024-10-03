package eksamen.corona;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCoronaData implements ICoronaData {

	@Override
	public List<Integer> cumulativeDeaths(){
		ArrayList<Integer> cumulative = new ArrayList<Integer>();
		int sum=0;
		for(int deaths : getDailyDeaths()) {
			sum += deaths;
			cumulative.add(sum);
		}
		return cumulative;
	}

	@Override
	public List<Double> deathsPerMillion(){
		ArrayList<Double> deathsPerMillion = new ArrayList<Double>();
		for(int deaths : cumulativeDeaths()) {
			deathsPerMillion.add(deaths/(getPopulation()/1000000.0));
		}
		return deathsPerMillion;
	}
}


