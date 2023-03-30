package uk.co.emma.londontube.pojo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Station {
	private String name;
	private Integer id;
	private String line; //dunno if we need this
	private List<Station> shortestPath = new LinkedList<>();
	//distance from previous station?   initialize to something really big
	private Integer distance = Integer.MAX_VALUE; 
	 //all the immediately adjacent stations to this one with the distance between
	private Map<Station, Integer> adjacentStations = new HashMap<>();
	
	//constructor
	public Station(String name) {
		this.name = name;
	}
	
	public void addAdjacentStation(Station station, Integer distance) {
		adjacentStations.put(station,  distance); //distance from starting station
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public List<Station> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Station> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<Station, Integer> getAdjacentStations() {
		return adjacentStations;
	}

	public void setAdjacentStations(Map<Station, Integer> adjacentStations) {
		this.adjacentStations = adjacentStations;
	}
	
}
