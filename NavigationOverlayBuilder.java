package atcsim.loader;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JSpinner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.navaid.LoaderAirway;
import atcsim.loader.navaid.LoaderFix;
import atcsim.loader.navaid.LoaderILS;
import atcsim.loader.navaid.LoaderNDB;
import atcsim.loader.navaid.LoaderVOR;
import atcsim.world.navigation.A_ComponentNavaid;

public class NavigationOverlayBuilder {
	public NavigationOverlayBuilder() {
		
	}
	public OverlayNavigation loadDefinition(java.lang.String filespec) throws java.io.IOException {
		OverlayNavigation on = new OverlayNavigation("NAV");
		Scanner S = new Scanner(filespec);
		HashMap hm = new HashMap();
		LoaderFix lf = new LoaderFix(hm, on);
		lf.load(S);
		LoaderNDB ln = new LoaderNDB(hm, on);
		ln.load(S);
		LoaderVOR gn = new LoaderVOR(hm, on);
		gn.load(S);
		LoaderILS tn = new LoaderILS(hm, on);
		tn.load(S);
		LoaderAirway kn = new LoaderAirway(hm, on);
		kn.load(S);
		
		
	           
	        return on;
		
	}
		
		
}

