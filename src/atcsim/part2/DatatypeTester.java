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
		p = p.add_(new AttitudePitch(0));
		assertEquals(10, p.getValue_());
		
		p = p.add_(new AttitudePitch(90));
		assertEquals(100, p.getValue_());
		
		p = p.add_(new AttitudePitch(175));
		assertEquals(-85, p.getValue_());
	}
	
	@Test
	void testAltitudeYaw() {
		AttitudeYaw y = new AttitudeYaw(10);
		y = y.add_(new AttitudeYaw(0));
		assertEquals(10, y.getValue_());
		
		y = y.add_(new AttitudeYaw(355));
		assertEquals(5, y.getValue_());
		
		y = y.subtract_(new AttitudeYaw(0));
		assertEquals(5, y.getValue_());
		
		y = y.subtract_(new AttitudeYaw(355));
		assertEquals(10, y.getValue_());
	}
	
	@Test
	void testCourse() {
		Course c = new Course(10);
		c = c.add_(new Course(0));
		assertEquals(10,c.getValue_());
		
		c = c.add_(new Course(355));
		assertEquals(5,c.getValue_());
		
		c = c.subtract_(new Course(0));
		assertEquals(5,c.getValue_());
		
		c = c.subtract_(new Course(355));
		assertEquals(10,c.getValue_());
	}
	
	// Course is the campus degrees while attitude yaw is the direction in degrees in relation to the current attitude.

	@Test
	void testCoordinateWorld() {
		fail("Not yet implemented");
		
	}
	
	@Test
	void testCorrdinateWorld3D() {
		fail("Not yet implemented");
	}
}
