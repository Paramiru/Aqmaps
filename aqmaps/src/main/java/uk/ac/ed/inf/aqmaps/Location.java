package uk.ac.ed.inf.aqmaps;

import org.locationtech.jts.geom.Coordinate;

import com.mapbox.geojson.Point;


public class Location {

	private double lng;
	private double lat;
	
	/**
	 * Class constructor specifying latitude and longitude
	 * of the point we want to represent.
	 * @param lat the latitude of the point
	 * @param lng the longitude of the point
	 */
	protected Location(double lat, double lng) {
		this.lng = lng;
		this.lat = lat;
	}
	
	/**
	 * Returns a Coordinate object using the class'
	 * fields so that jts-core dependency can be used with it.
	 * @return the coordinate of the point with the specified
	 * 		   latitude and longitude.
	 */
	protected Coordinate getJtsCoordinate() {
		return new Coordinate(this.lat, this.lng);
	}
	
	/**
	 * Returns a JTS point using the coordinates
	 * from the class' fields.
	 * @return the jts point with the specified latitude
	 * 		   and longitude.
	 */
	protected org.locationtech.jts.geom.Point getJtsPoint() {
		var coord = getJtsCoordinate();
		var point = Utils.geometryFactory.createPoint(coord);
		return point;
	}
	
	/**
	 * Returns a GeoJson point using the coordinates
	 * from the class' fields.
	 * @return GeoJson point with the specified latitude
	 * 		   and longitude.
	 */
	protected com.mapbox.geojson.Point getGeojsonPoint() {
		return Point.fromLngLat(this.lng, this.lat);
	}
	
	/** 
	 * @return latitude of the specified point.
	 */
	protected double latitude() {
		return this.lat;
	}
	
	/**
	 * @return longitude of the specified point.
	 */
	protected double longitude() {
		return this.lng;
	}

}
