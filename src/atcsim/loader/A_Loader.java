package atcsim.loader;

import java.util.Map;
import java.util.Scanner;

import atcsim.datatype.Altitude;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Latitude;
import atcsim.datatype.Longitude;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.world.navigation.A_ComponentNavaid;

public abstract class A_Loader {
	
	public A_Loader(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		
	}
	
	protected CoordinateWorld3D pars3D(String[] lat, String[] lon, String alt) {
		return  new CoordinateWorld3D(	new Latitude(Integer.valueOf(lat[0]), Integer.valueOf(lat[1]), Double.valueOf(lat[2])), 
										new Longitude(Integer.valueOf(lon[0]), Integer.valueOf(lon[1]), Double.valueOf(lon[2])),
										new Altitude(Double.valueOf(alt)));
	}
	
}
