package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START

		min = da[0];
		
		for(double d : da) {
			if(d < min) {
				min = d;
			}
		}

		return min;
		
		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] latitudes = new double[gpspoints.length];
		
		for(int i = 0; i < latitudes.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] longitudes = new double[gpspoints.length];
		
		for(int i = 0; i < longitudes.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();
		double deltaLatitude = toRadians(latitude2) - toRadians(latitude1);
		double deltaLongitude = toRadians(longitude2) - toRadians(longitude1);
		double a = pow((sin(deltaLatitude/2)),2) + (cos(toRadians(latitude1)) * cos(toRadians(latitude2)) * pow(sin(deltaLongitude/2),2));
		double c = 2 * atan2(sqrt(a), sqrt(1-a));
		d = R * c;
		
		return d;
		

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		double distance = distance(gpspoint1, gpspoint2);
		
		speed = (distance / secs) * 3.6;
		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		int hh = secs / 3600;
		secs = secs % 3600;
		int mm = secs / 60;
		secs = secs % 60;
		int ss = secs;
		
		timestr = String.format("%02d:%02d:%02d",hh,mm,ss);
		timestr = String.format("%10s", timestr);

		return timestr;
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		double rounded = (double) Math.round(d * 100) / 100;
		str = "" + rounded;
		str = String.format("%10s", str);
		return str;

		// TODO - SLUTT
		
	}
}
