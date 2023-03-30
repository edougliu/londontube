package uk.co.emma.londontube.pojo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Tube {
	private Set<Station> stations = new HashSet<>();
	public void addStation(Station station) {
		stations.add(station);
	}
	public Set<Station> getStations() {
		return stations;
	}
	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}
	
	//this could be a sql query...
	public Station getStation(String name) {
		Iterator<Station> itr = getStations().iterator();
		Station thisStation = null;
		while(itr.hasNext()) {
			thisStation = itr.next();
			if (thisStation.getName().equals(name)) {
				return thisStation;
			}
		}
		return null; //couldn't find it
	}
}
