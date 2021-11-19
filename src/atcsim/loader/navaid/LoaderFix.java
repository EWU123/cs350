package atcsim.loader.navaid;

import java.util.ArrayList;
import java.util.Map;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;

public class LoaderFix extends A_Loader{
	Map<String, A_ComponentNavaid<?>> navaids;
	OverlayNavigation overlay;
	
	public LoaderFix(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
		this.navaids = navaids;
		this.overlay = overlay;
	}

	public void load(java.util.Scanner scanner) throws java.io.IOException {
		String line = scanner.nextLine();
		String[] values;
		values = line.split(", ");

	}
}
