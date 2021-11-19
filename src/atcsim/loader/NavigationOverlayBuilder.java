package atcsim.loader;

import java.util.Map;
import java.util.Scanner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.navaid.LoaderFix;
import atcsim.loader.navaid.LoaderNDB;
import atcsim.loader.navaid.LoaderVOR;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidFix;
import atcsim.world.navigation.ComponentNavaidNDB;

public class NavigationOverlayBuilder {
	public NavigationOverlayBuilder() {
	
	}
	public OverlayNavigation loadDefinition(java.lang.String filespec) throws java.io.IOException {
		Scanner input = new Scanner(filespec);
		Map<String, A_ComponentNavaid<?>> navaids = null;
		OverlayNavigation overlay = new OverlayNavigation("overlay");
		
		input.next();

			LoaderFix fix = new LoaderFix(navaids,overlay);
			fix.load(input);

		return overlay;
		
		
	}
	
	//testing
}
