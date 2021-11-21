import java.io.IOException;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.NavigationOverlayBuilder;

public class Tester {

	public static void main(String[] args) throws IOException {
		NavigationOverlayBuilder builder = new NavigationOverlayBuilder();
		OverlayNavigation overlay = builder.loadDefinition("./definition1.txt");
		String[] results = overlay.getNavaids().toString().split(", ");
		System.out.println(results.length);
		for(String i:results) {
			System.out.println(i);
		}
	}

}
