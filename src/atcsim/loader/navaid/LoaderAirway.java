package atcsim.loader.navaid;

import java.util.Map;

import atcsim.datatype.CoordinateWorld3D;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.manager.NavaidManager;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidAirway;

public class LoaderAirway extends A_Loader{
	public LoaderAirway(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();

		while(line.isBlank() == false) {
			String[] fields = line.split(", ");
			CoordinateWorld3D coor3D0 = null;
			CoordinateWorld3D coor3D1 = null;
			ComponentNavaidAirway airway;
			
			switch (fields[1]) {
				
				case "CC":	String[] lat0 = fields[2].split(",");
							String[] lon0 = fields[3].split(",");
							coor3D0 = pars3D(lat0, lon0, fields[4]);
							String[] lat1 = fields[5].split(",");
							String[] lon1 = fields[6].split(",");
							coor3D1 = pars3D(lat1, lon1, fields[7]);
							airway = new ComponentNavaidAirway(fields[0], coor3D0, coor3D1);
							overlay.addNavaid(airway);
							navaids.put(fields[0], airway);
							break;
							
				case "NC": 	coor3D0 = NavaidManager.getInstance().getNavaid(fields[2]).getPosition();
							String[] lat2 = fields[3].split(",");
							String[] lon2 = fields[4].split(",");
							coor3D1 = pars3D(lat2, lon2, fields[5]);
							airway = new ComponentNavaidAirway(fields[0], coor3D0, coor3D1);
							overlay.addNavaid(airway);
							navaids.put(fields[0], airway);
							break;
							
				case "NN": 	coor3D0 = NavaidManager.getInstance().getNavaid(fields[2]).getPosition();
							coor3D1 = NavaidManager.getInstance().getNavaid(fields[3]).getPosition();
							airway = new ComponentNavaidAirway(fields[0], coor3D0, coor3D1);
							overlay.addNavaid(airway);
							navaids.put(fields[0], airway);
							break;
							
				default:	break; //maybe should throw an error
			}
			if(scanner.hasNextLine())
				line = scanner.nextLine();
			else
				line = "\n";
		}
	}
}
