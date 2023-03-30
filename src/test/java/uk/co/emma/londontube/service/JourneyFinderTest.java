package uk.co.emma.londontube.service;


import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import uk.co.emma.londontube.builder.TubeBuilder;
import uk.co.emma.londontube.pojo.Station;
import uk.co.emma.londontube.pojo.Tube;

public class JourneyFinderTest {

	@Test
	public void calculateShortPathFromStart() {

		Tube tube = new TubeBuilder().build();
		
		System.out.println("JourneyFinder test");
		Station nodeA = tube.getStation("A");
		Station nodeB = tube.getStation("B");
        Station nodeC = tube.getStation("C");
        Station nodeD = tube.getStation("D");
        Station nodeE = tube.getStation("E");
        Station nodeF = tube.getStation("F");
		
        JourneyFinder journeyFinder = new JourneyFinder(); 
        journeyFinder.calculateShortPathFromStart(nodeA);

        List<Station> shortestPathForNodeB = Arrays.asList(nodeA);
        List<Station> shortestPathForNodeC = Arrays.asList(nodeA);
        List<Station> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List<Station> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List<Station> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (Station node : tube.getStations()) {
            switch (node.getName()) {
            case "B":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeB));
                break;
            case "C":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeC));
                break;
            case "D":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeD));
                break;
            case "E":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeE));
                break;
            case "F":
                assertTrue(node
                  .getShortestPath()
                  .equals(shortestPathForNodeF));
                break;
            }
        }
	}
}
