package aufgabe7;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Event_main {
	public static Calendar getRandomDate() {
       
     
        //Das zufällige Eventdatum sollte in der Zukunft liegen
        final long MIN = System.currentTimeMillis();		
      /*
       * 2038-01-19 - Das magische Datum, an dem wir die Sekunden, die seit beginn der Unix-Epoche vergangen sind,
       * nicht mehr in 32 bit speichern können. 
       * 
       */
        
        final long  MAX = 2147483647000L;					
        Calendar calendar = Calendar.getInstance();
        long dateMillis = ThreadLocalRandom.current().nextLong(MIN, MAX);
        Date date = new Date(dateMillis);
      
        calendar.setTime(date);
        
        return calendar;
        
    }

	public static void main(String[] args) {
		/*
		 * In der Aufgabe steht, dass auch gleiche Events zum Set hinzugefügt werden sollen,
		 * aber geht es nicht in Sets genau darum, das zu vermeiden? 
		 * Ich bin daher jetzt ersatzweise auf eine LinkedList umgestiegen. 
		 * Zumal ich mir auch nicht im klaren darüber bin, wie man das realisieren sollte.
		 * 
		 */
		Random rand = new Random();
		LinkedList<Event> events = new LinkedList<Event>();
		
		String[] eventnames = {"Klaus Geburtstag", "Abschlussgrillen", "WG-Einweihung", "Junggesellenabschied", "Hochzeit von Horst und Hugo", "Bertas Beerdigung", "OE-Party"};
		String[] locations = {"zuhause", "im Garten", "irgendwo", "Hamburg", "Atlantis", "auf den Malediven", "am Nordpol", "auf dem Bett von Tante Helga"};

		for (int i = 0; i < eventnames.length;i++) {
			Event event = new Event(eventnames[i], locations[rand.nextInt(locations.length)],getRandomDate());
			events.add(event);
			
		}	
		System.out.format("%-30s | %-30s | %-30s\n", "WAS?", "WANN?", "WO?");
		System.out.println("------------------------------------------------------------------------------------");
		for (Event event : events) {
			String[] eventDetails = {event.getEventname(),event.getFormatedStartTime(),event.getLocation()};
			System.out.format("%-30s | %-30s | %-30s\n", eventDetails);
		}
	}

}
