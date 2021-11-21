package atcsim.loader.navaid;

import java.util.Map;

import atcsim.datatype.AngleNavigational;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.VHFFrequency;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidILS;
import atcsim.world.navigation.NavaidILSBeaconDescriptor;

public class LoaderILS extends A_Loader{
	public LoaderILS(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();
		while(line.isBlank() == false)  { 
			String[] fields = line.split(", ");
			String id = fields[0];
			String azimuth = fields[5];
			String[] lat = fields[2].split(",");
			String[] lon = fields[3].split(",");
			String[] frequency = fields[1].split(",");
			
			CoordinateWorld3D coor3D = pars3D(lat, lon, fields[4]);
			VHFFrequency vhf = parsVHF(frequency);
			AngleNavigational angle = new AngleNavigational(Double.parseDouble(azimuth));
			NavaidILSBeaconDescriptor outer = parsBeacon(fields[6]);
			NavaidILSBeaconDescriptor middle = parsBeacon(fields[7]);
			NavaidILSBeaconDescriptor inner = parsBeacon(fields[8]);
			
			ComponentNavaidILS ils = new ComponentNavaidILS(id, coor3D, angle, vhf, outer, middle, inner);
			
			overlay.addNavaid(ils);
			
			line = scanner.nextLine();
		}
	}
}
