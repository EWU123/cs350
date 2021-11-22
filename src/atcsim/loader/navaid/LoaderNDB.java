package atcsim.loader.navaid;

import java.util.Map;

import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.UHFFrequency;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidNDB;

public class LoaderNDB extends A_Loader{
	public LoaderNDB(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();
		
		while(line.isBlank() == false) {
			String[] fields = line.split(", ");
			String[] lat = fields[2].split(",");
			String[] lon = fields[3].split(",");
			
			CoordinateWorld3D coor3D = pars3D(lat, lon, fields[4]);	
			UHFFrequency uhf = parsUHF(fields[1]);
			ComponentNavaidNDB ndb = new ComponentNavaidNDB(fields[0], coor3D, uhf);
			
			overlay.addNavaid(ndb);
			navaids.put(fields[0], ndb);
			
			line = scanner.nextLine();
		}
	}
}
