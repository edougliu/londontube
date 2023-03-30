package uk.co.emma.londontube.builder;

import uk.co.emma.londontube.pojo.Station;
import uk.co.emma.londontube.pojo.Tube;

public class TubeBuilder {
	private Tube theTube = null;
	
	public TubeBuilder() {
		theTube = new Tube();
		//here's where we could put some code to retrieve the stations from the database
		//and then use the data to populate all these objects
		//select station_name from station
		Station stationA = new Station("A");
		Station stationB = new Station("B");
        Station stationC = new Station("C");
        Station stationD = new Station("D");
        Station stationE = new Station("E");
        Station stationF = new Station("F");
        //select name, distance from adjacent_station as
        //join station s on a.name = as.name
        //where s.name = "<station name from the records above>"
        stationA.addAdjacentStation(stationB, 10);
        stationA.addAdjacentStation(stationC, 15);
        stationB.addAdjacentStation(stationD, 12);
        stationB.addAdjacentStation(stationF, 15);
        stationC.addAdjacentStation(stationE, 10);
        stationD.addAdjacentStation(stationE, 2);
        stationD.addAdjacentStation(stationF, 1);
        stationF.addAdjacentStation(stationE, 5);

        theTube.addStation(stationA);
        theTube.addStation(stationB);
        theTube.addStation(stationC);
        theTube.addStation(stationD);
        theTube.addStation(stationE);
        theTube.addStation(stationF);

	}
	
	public Tube build() {
		return theTube;
	}
}
