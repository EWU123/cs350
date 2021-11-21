import java.io.IOException;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.NavigationOverlayBuilder;

public class Tester {

	public static void main(String[] args) throws IOException {
		NavigationOverlayBuilder builder = new NavigationOverlayBuilder();
		OverlayNavigation overlay = builder.loadDefinition("./definition1.txt");
		System.out.print(overlay.toXML_());
	}

}
