package atcsim.loader;

import java.util.Map;
import java.util.Scanner;

import atcsim.datatype.Altitude;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Distance;
import atcsim.datatype.Latitude;
import atcsim.datatype.Longitude;
import atcsim.datatype.UHFFrequency;
import atcsim.datatype.VHFFrequency;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidILSBeacon;
import atcsim.world.navigation.NavaidILSBeaconDescriptor;

public abstract class A_Loader {
	protected Map<String, A_ComponentNavaid<?>> navaids;
	protected OverlayNavigation overlay;
	public A_Loader(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		this.navaids = navaids;
		this.overlay = overlay;
	}
	
	protected CoordinateWorld3D pars3D(String[] lat, String[] lon, String alt) {
		return  new CoordinateWorld3D(	new Latitude(Integer.valueOf(lat[0]), Integer.valueOf(lat[1]), Double.valueOf(lat[2])), 
										new Longitude(Integer.valueOf(lon[0]), Integer.valueOf(lon[1]), Double.valueOf(lon[2])),
										new Altitude(Double.valueOf(alt)));
	}
	
	protected UHFFrequency parsUHF(String frequency) {
		return new UHFFrequency(Integer.parseInt(frequency));	
	}
	
	protected VHFFrequency parsVHF(String[] frequency) {
		return new VHFFrequency(Integer.parseInt(frequency[0]), Integer.parseInt(frequency[1]));	
	}
	
	protected NavaidILSBeaconDescriptor parsBeacon(String beacon) {
		String[] split = beacon.split(",");
		Distance distance = new Distance(Double.parseDouble(split[0]));
		Altitude altitude = new Altitude(Double.parseDouble(split[1]));
				
		return new NavaidILSBeaconDescriptor(distance, altitude);
	}
}
