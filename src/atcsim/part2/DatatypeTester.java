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
		assertEquals(10, c.getValue_());
		
		c = c.add_(new Course(355));
		assertEquals(5, c.getValue_());
		
		c = c.subtract_(new Course(0));
		assertEquals(5, c.getValue_());
		
		c = c.subtract_(new Course(355));
		assertEquals(10, c.getValue_());
	}
	
	// Course is the campus degrees while attitude yaw is the direction in degrees in relation to the current attitude.

	@Test
	void testCoordinateWorld() {
		
		CoordinateWorld p1 = CoordinateWorld.KSFF;
		CoordinateWorld p2 = new CoordinateWorld(new Latitude(1, 2, 3), new Longitude(3 ,2 ,1 ));
		
		int c;
		double t;
		
		//p1 == p1
		c = p1.getLatitude().compareTo(p1.getLatitude());
		assertEquals(0, c);
		
		c = p1.getLongitude().compareTo(p1.getLongitude());
		assertEquals(0, c);
		
		//testing p1 + p2
		CoordinateWorld test = p1.add_(p2);
		
		//testing Latitude add
		Latitude testLa = new Latitude(50, 41, 35.0); //expected
		
		c = test.getLatitude().getDegrees();
		assertEquals(testLa.getDegrees(), c);
		
		t = test.getLatitude().getMinutesAndSeconds();
		assertEquals(testLa.getMinutesAndSeconds(), t, .001);
		
		//testing Longitude add
		Longitude testLo = new Longitude(120, 27, 31.0); //expected
		
		c = test.getLongitude().getDegrees();
		assertEquals(testLo.getDegrees(), c);
		
		t = test.getLongitude().getMinutesAndSeconds();
		assertEquals(testLo.getMinutesAndSeconds(), t, .001);
		
		//testing p2 + p1
		test = p2.add_(p1);
		
		//testing Latitude add
		testLa = new Latitude(50, 41, 35.0); //expected
		
		c = test.getLatitude().getDegrees();
		assertEquals(testLa.getDegrees(), c);
		
		t = test.getLatitude().getMinutesAndSeconds();
		assertEquals(testLa.getMinutesAndSeconds(), t, .001);
		
		//testing Longitude add
		testLo = new Longitude(120, 27, 31.0); //expected
		
		c = test.getLongitude().getDegrees();
		assertEquals(testLo.getDegrees(), c);
		
		t = test.getLongitude().getMinutesAndSeconds();
		assertEquals(testLo.getMinutesAndSeconds(), t, .001);
	}
	
	@Test
	void testCorrdinateWorld3D() {
		Altitude zero = new Altitude(0);
		CoordinateWorld3D p = new CoordinateWorld3D(CoordinateWorld.KSFF, zero);
		CoordinateWorld3D test;
		
		//testing that p == p with angle and radius
		assertEquals(90, p.calculateBearing3D(p).getAngle().getValue_());
		assertEquals(0, p.calculateBearing3D(p).getRadiusNauticalMiles().getValue_());
		
		//testing that p to KSFF_N with angle and radius is correct
		test = new CoordinateWorld3D(CoordinateWorld.KSFF_N, zero);
		assertEquals(0, p.calculateBearing3D(test).getAngle().getValue_(), .0001);
		assertEquals(794.0382, p.calculateBearing3D(test).getRadiusNauticalMiles().getValue_(), .0001);
		
		//testing that p to KSFF_S with angle and radius is correct
		test = new CoordinateWorld3D(CoordinateWorld.KSFF_S, zero);
		assertEquals(180, p.calculateBearing3D(test).getAngle().getValue_(), .0001);
		assertEquals(794.0382, p.calculateBearing3D(test).getRadiusNauticalMiles().getValue_(), .0001);
		
		//testing that p to KSFF_E with angle and radius is correct
		test = new CoordinateWorld3D(CoordinateWorld.KSFF_E, zero);
		assertEquals(90, p.calculateBearing3D(test).getAngle().getValue_(), .0001);
		assertEquals(794.0382, p.calculateBearing3D(test).getRadiusNauticalMiles().getValue_(), .0001);
		
		//testing that p to KSFF_W with angle and radius is correct
		test = new CoordinateWorld3D(CoordinateWorld.KSFF_W, zero);
		assertEquals(270, p.calculateBearing3D(test).getAngle().getValue_(), .0001);
		assertEquals(794.0382, p.calculateBearing3D(test).getRadiusNauticalMiles().getValue_(), .0001);
		
	}
}
