package atcsim.loader.navaid;

import java.util.Map;

import atcsim.datatype.CoordinateWorld3D;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;

public class LoaderNDB extends A_Loader{
	public LoaderNDB(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();
		String[] fields = line.split(", ");
		String[] lat = fields[2].split(",");
		String[] lon = fields[3].split(",");
		
		CoordinateWorld3D coor3D = pars3D(lat, lon, fields[4]);		
	}
}
