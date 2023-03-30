package uk.co.emma.londontube.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import uk.co.emma.londontube.pojo.Station;
//import uk.co.emma.londontube.pojo.Tube;

public class JourneyFinder {
	
	public void calculateShortPathFromStart(Station start) {
		start.setDistance(0); //at our starting point, our distance is zero
		
		//to keep track of which stations we have and have not yet evaluated
		Set<Station> unsettledStations = new HashSet<>();
		Set<Station> settledStations = new HashSet<>();
		
		//start the evaluation at the beginning...
		unsettledStations.add(start); 
		
		while (!unsettledStations.isEmpty()) {
			Station currentStation = getStationWithShortestDistance(unsettledStations);
			//this is now the current station that we are evaluating
			unsettledStations.remove(currentStation);
			
			for(Entry<Station, Integer> adjacentStationEntry: currentStation.getAdjacentStations().entrySet()) {
				Station adjacentStation = adjacentStationEntry.getKey();
				Integer edgeWeight = adjacentStationEntry.getValue();
				if (!settledStations.contains(adjacentStation)) {
					calculateMinimumDistance(adjacentStation, edgeWeight, currentStation); //<-not sure what this edgeWeight actually is?  isn't it the same as adjacentStation.getDistance?
					//add this to the set to evaluate next...
					unsettledStations.add(adjacentStation);
				}
			}
			//all done with this one...
			settledStations.add(currentStation); 
			
		}
	}

	//compares the actual distance with the newly calculated one 
	//while following the newly explored path
	//this is a bit confusing but the key piece...
	private void calculateMinimumDistance(Station evaluationStation, Integer edgeWeight, Station sourceStation) {
		Integer sourceStationDistance = sourceStation.getDistance();
		if (sourceStationDistance + edgeWeight < evaluationStation.getDistance()) {
			evaluationStation.setDistance(sourceStationDistance + edgeWeight);
			LinkedList<Station> shortestPath = new LinkedList<>(sourceStation.getShortestPath());
			shortestPath.add(sourceStation);
			evaluationStation.setShortestPath(shortestPath);
		}
	}

	private Station getStationWithShortestDistance(Set<Station> unsettledStations) {
		
		Station smallestDistanceStation = null;
		Integer smallestDistance = Integer.MAX_VALUE;
		
		for (Station station: unsettledStations) {
			Integer stationDistance = station.getDistance();
			if (stationDistance < smallestDistance) {
				//this is the smallest one so far...
				smallestDistance = stationDistance;
				smallestDistanceStation = station;
			}
		}
		return smallestDistanceStation;
	}
	
}
