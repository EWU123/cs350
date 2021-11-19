package atcsim.loader;

import java.util.Scanner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.navaid.LoaderFix;
import atcsim.loader.navaid.LoaderNDB;
import atcsim.loader.navaid.LoaderVOR;

public class NavigationOverlayBuilder {
	public NavigationOverlayBuilder() {
		
	}
	public OverlayNavigation loadDefinition(java.lang.String filespec) throws java.io.IOException {
		Scanner input = new Scanner(filespec);
		
		OverlayNavigation overlay = new OverlayNavigation("overlay");
		
		overlay.addNavaid(new LoaderFix(null, overlay)); 
		return overlay;
		
		
	}
	
	//testing
}
