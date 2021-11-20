package atcsim.loader;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.navaid.LoaderAirway;
import atcsim.loader.navaid.LoaderFix;
import atcsim.loader.navaid.LoaderILS;
import atcsim.loader.navaid.LoaderNDB;
import atcsim.loader.navaid.LoaderVOR;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidFix;
import atcsim.world.navigation.ComponentNavaidNDB;

public class NavigationOverlayBuilder {
	public NavigationOverlayBuilder() {
	
	}
	public OverlayNavigation loadDefinition(java.lang.String filespec) throws java.io.IOException {
		File fin = new File(filespec);
		Scanner input = new Scanner(fin);
		Map<String, A_ComponentNavaid<?>> navaids = null;
		OverlayNavigation overlay = new OverlayNavigation("overlay");
		
		System.out.println(input.nextLine());

		LoaderFix fix = new LoaderFix(navaids,overlay);
		fix.load(input);
		
		nextCatagory(input);
		LoaderNDB ndb = new LoaderNDB(navaids, overlay);
		ndb.load(input);
		
		nextCatagory(input);
		LoaderVOR vor= new LoaderVOR(navaids, overlay);
		vor.load(input);
		
		nextCatagory(input);
		LoaderILS ils = new LoaderILS(navaids, overlay);
		ils.load(input);
		
		nextCatagory(input);
		LoaderAirway airway = new LoaderAirway(navaids, overlay);
		airway.load(input);


		return overlay;
	}
	
	private void nextCatagory(Scanner input) {
		System.out.println(input.nextLine());
		System.out.println(input.nextLine());
	}
	
	//testing
}
