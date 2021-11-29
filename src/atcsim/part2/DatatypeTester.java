package atcsim.part2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import atcsim.datatype.*;


class DatatypeTester {

	@Test
	void testAltitude() {
		fail("Not yet implemented");
	}
	
	@Test
	void testAngleNavigational() {
		fail("Not yet implemented");
	}
	
	@Test
	void testAltitudePitch() {
		AttitudePitch p = new AttitudePitch(10);
		p.add_(new AttitudePitch(0));
		assertEquals(10, p.getValue_());
		
	}
	
	@Test
	void testAltitudeYaw() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCourse() {
		fail("Not yet implemented");
	}

	@Test
	void testCoordinateWorld() {
		fail("Not yet implemented");
		
	}
	
	@Test
	void testCorrdinateWorld3D() {
		fail("Not yet implemented");
	}
}
