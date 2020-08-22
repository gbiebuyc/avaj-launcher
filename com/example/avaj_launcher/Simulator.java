package com.example.avaj_launcher;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
	static void p(String l) {System.out.println(l);} // println shortcut

	public static void main(String [] args) {
		WeatherTower weatherTower = new WeatherTower();
		AircraftFactory aircraftFactory = new AircraftFactory();
		File file = new File(args[0]);
		int numSimulations;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
		    String line = reader.readLine();
		    if (line == null) {
		    	System.out.println("Error: file is empty");
		    	return;
		    }
		    numSimulations = Integer.parseInt(line);
		    while ((line = reader.readLine()) != null) {
		    	System.out.println(line);
		    	String[] splited = line.split(" ");
		    	if (splited.length != 5) {
			    	System.out.println("Error: wrong line format");
			    	return;
		    	}
				String type = splited[0];
				String name = splited[1];
				Flyable x = aircraftFactory.newAircraft(type, name,
					Integer.parseInt(splited[2]),
					Integer.parseInt(splited[3]),
					Integer.parseInt(splited[4]));
				if (x == null) {
			    	System.out.println("Error: bad aircraft type");
			    	return;
		    	}
		    	weatherTower.register(x);
		    	x.registerTower(weatherTower);
		    }
		} catch (IOException e) {
            e.printStackTrace();
        }


		/*
		*/
	}
}