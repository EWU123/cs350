package atcsim.loader.navaid;

import java.util.Map;

import atcsim.datatype.CoordinateWorld3D;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.manager.NavaidManager;
import atcsim.world.navigation.A_ComponentNavaid;

public class LoaderAirway extends A_Loader{
	public LoaderAirway(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();
		String[] fields = line.split(", ");
		CoordinateWorld3D coor3D0 = null;
		CoordinateWorld3D coor3D1 = null;
		switch (fields[1]) {
		case "NN": 	coor3D1 = NavaidManager.getInstance().getNavaid(fields[3]).getPosition();
		case "NC": 	coor3D0 = NavaidManager.getInstance().getNavaid(fields[2]).getPosition();
		default:	break;
		}
		if(coor3D0 == null) {
			String[] lat0 = fields[2].split(",");
			String[] lon0 = fields[3].split(",");
			coor3D0 = pars3D(lat0, lon0, fields[4]);	
		}
			
		if(coor3D1 == null) {
			String[] lat1 = fields[5].split(",");
			String[] lon1 = fields[6].split(",");
			coor3D1 = pars3D(lat1, lon1, fields[7]);
		}
	}
}
