package atcsim.part2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import atcsim.datatype.*;


class DatatypeTester {

	@Test
	void testAltitude() {
		Altitude a1 = new Altitude(1000);
		Altitude a2 = new Altitude(200);
		assertEquals(1200, a1.add_(a2).getValue_());
		
		assertEquals(1200, a2.add_(a1).getValue_());
		
		assertEquals(800, a1.subtract_(a2).getValue_());
		
		assertEquals(800, a1.subtract_(a2).getValue_());
		assertEquals(0, a1.compareTo(a1));
		assertEquals(1, a1.compareTo(a2));
		assertEquals(-1, a2.compareTo(a1));
		
		
	}
	
	@Test
	void testAngleNavigational() {
		AngleNavigational a1 = new AngleNavigational(90);
		AngleNavigational a2 = new AngleNavigational(180);
		assertEquals(270, a1.reciprocate().getValue_());
		assertEquals(0, a2.reciprocate().getValue_());
		assertEquals(135, a1.interpolate(a2, new Scaler(0.5)).getValue_());
		assertEquals(315,a2.interpolate(a1, new Scaler(0.5)).getValue_());
		
		
		
		
		
		
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
		
		
	}
	
	@Test
	void testCorrdinateWorld3D() {
		
	}
}
