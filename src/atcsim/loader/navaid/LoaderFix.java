package atcsim.loader.navaid;

import java.util.Map;

import atcsim.datatype.Altitude;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Latitude;
import atcsim.datatype.Longitude;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;

public class LoaderFix extends A_Loader{
	Map<String, A_ComponentNavaid<?>> navaids;
	OverlayNavigation overlay;
	
	public LoaderFix(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
		this.navaids = navaids;
		this.overlay = overlay;
	}

	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();
		String[] fields = line.split(", ");
		String[] lat = fields[1].split(",");
		String[] lon = fields[2].split(",");
		
		new CoordinateWorld3D(	new Latitude(Integer.valueOf(lat[0]), Integer.valueOf(lat[1]), Double.valueOf(lat[2])), 
								new Longitude(Integer.valueOf(lon[0]), Integer.valueOf(lon[1]), Double.valueOf(lon[2])),
								new Altitude(Double.valueOf(fields[3])));
		
	}
}
