import java.io.IOException;

import atcsim.loader.NavigationOverlayBuilder;

public class Tester {

	public static void main(String[] args) throws IOException {
		NavigationOverlayBuilder builder = new NavigationOverlayBuilder();
		builder.loadDefinition("./definition1.txt");
	}

}
