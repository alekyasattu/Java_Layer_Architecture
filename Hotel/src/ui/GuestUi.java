package ui;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import dao.GuestDaoImpl;
import entities.Guest;
import service.GuestServiceImpl;
import service.IGuestService;
import util.GuestComparator;

public class GuestUi {

	private IGuestService service = new GuestServiceImpl(new GuestDaoImpl());
	
	GuestComparator comparator = new GuestComparator();

	public static void main(String[] args) {

		GuestUi ui = new GuestUi();
		ui.runUi();
	}

	void runUi() {
		try {
			Guest g1 = new Guest(100, "alekya");
			Guest g2 = new Guest(2, "joe");
			Guest g3 = new Guest(43, "sam");
			Guest g4 = new Guest(36, "riya");

			service.addGuest(g1);
			service.addGuest(g2);
			service.addGuest(g3);
			service.addGuest(g4);

			Guest fetched1 = service.findGuestById(g1.getId());

			System.out.println("fetched value"+fetched1.getName());

			System.out.println("-----ALL GUESTS in desc order------");
			
			Set<Guest> result = service.allGuestsInorder(false);
			
			printIn(result);
			
			System.out.println("-----ALL GUESTS in asc order------");
			
			Set<Guest> result1 = service.allGuestsInorder(true);
			
			printIn(result1);
			
			System.out.println("----------------using tress set directly in ui---------------");
			Set<Guest> guests = service.allGuests();
			
			print(guests);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("somethimg went wrong");
		}
	}

	void print(Collection<Guest> guests) {
		Set<Guest> guestset = new TreeSet<>(comparator);
		guestset.addAll(guests);
		for(Guest g:guestset) {
			System.out.println(g.getId()+" "+g.getName());	
		}
	
		
	}
	
	void printIn(Collection<Guest> guests) {
		for(Guest g :guests) {
			System.out.println(g.getId()+" "+g.getName());	
		}
	}

}
