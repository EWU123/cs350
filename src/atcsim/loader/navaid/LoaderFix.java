package atcsim.loader.navaid;

import java.util.ArrayList;
import java.util.Map;

import atcsim.datatype.Altitude;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Latitude;
import atcsim.datatype.Longitude;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidFix;

public class LoaderFix extends A_Loader{
	
	public LoaderFix(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);

	}

	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();
		
		while(line.isBlank() == false) {
		
			String[] fields = line.split(", ");
			String id = fields[0];
			String[] lat = fields[1].split(",");
			String[] lon = fields[2].split(",");
			
			CoordinateWorld3D coor3D = pars3D(lat, lon, fields[3]);	
			ComponentNavaidFix fix = new ComponentNavaidFix(id, coor3D);
			
			overlay.addNavaid(fix);
			navaids.put(id, fix);
			line = scanner.nextLine();
		}
	
	}

}
