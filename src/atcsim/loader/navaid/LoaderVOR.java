package atcsim.loader.navaid;

import java.util.Map;

import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.VHFFrequency;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidVOR;

public class LoaderVOR extends A_Loader{
	public LoaderVOR(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();
		while(line.isBlank() == false)  { 
			String[] fields = line.split(", ");
			String id = fields[0];
			String[] lat = fields[2].split(",");
			String[] lon = fields[3].split(",");
			String[] frequency = fields[1].split(",");
			
			CoordinateWorld3D coor3D = pars3D(lat, lon, fields[4]);
			VHFFrequency vhf = parsVHF(frequency);
			
			ComponentNavaidVOR vdr = new ComponentNavaidVOR(id, coor3D, vhf);
			
			overlay.addNavaid(vdr);
			navaids.put(id, vdr);
			
			line = scanner.nextLine();
		}
	}
}
