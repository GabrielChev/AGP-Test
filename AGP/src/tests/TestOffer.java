package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import buisness.model.Offer;
import buisness.model.Stay;
import buisness.objects.Hotel;
import buisness.objects.TouristicSite;
import buisness.objects.Transport;
import persistance.jdbc.JdbcPersistance;
import buisness.engine.OfferBuilder;
import buisness.engine.QueryBuilder;

public class TestOffer {

	@Test
	public void testOffer() throws Exception {
		OfferBuilder offerBuilder = new OfferBuilder();
		QueryBuilder queryBuilder = new QueryBuilder();
		Offer offer;
		ArrayList<Hotel> listAllHotels = new ArrayList<Hotel>();
		JdbcPersistance jdbc = new JdbcPersistance();
		
	//	System.out.println("Selection de tous les transports");
	//	ArrayList<Transport> transports = jdbc.FetchTransports("");
		
		System.out.println("Selection de tous les Sites Touristiques");
		ArrayList<TouristicSite> listAllSites = jdbc.FetchTourisitcSites("SELECT * from TouristicSite");
		int k,j,l,h;
		for (k = 0; k< listAllSites.size(); k++) {
	//		System.out.println(listAllSites.get(k).getName());
		}
		
		System.out.println("Selection de tous les Hotels");
		listAllHotels = queryBuilder.selectAllHotel();
		for (j = 0; j< listAllHotels.size(); j++) {
	// 		System.out.println(listAllHotels.get(j).getName());
		}
		
		System.out.println("Construction d'une offre");
		offer = offerBuilder.buildOffer(listAllSites, listAllSites, listAllHotels);
		
		for (l = 0; l< 5; l++) {

				System.out.print(offer.getProposedExcursion().get(l).getSites().get(0).getName());
					
				System.out.print(" - " + offer.getProposedExcursion().get(l).getTransports().get(0).getType());
						
				System.out.print(" - " + offer.getProposedExcursion().get(l).getTransports().get(0).getKilometerPrice());
				
				System.out.println(" - " + offer.getProposedExcursion().get(l).getTransports().get(0).getKilometerDuration());
			
		}
		
		
		
	}

}
