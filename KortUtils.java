package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.modell.*;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		Kort[] holdAv = new Kort[samling.getAntalKort()];
		for(int i = 0; i < holdAv.length; i++) {
			holdAv[i] = samling.taSiste();
		}
		for(int i = 0;i < holdAv.length;i++) {
			for(int j = 0; j < holdAv.length; j++) {
				
				if (holdAv[i].compareTo(holdAv[j]) > 0) {
					Kort holdAvkort = holdAv[j];
					holdAv[j] = holdAv[i];
					holdAv[i] = holdAvkort;
				}
			}
		}
		for(int i = 0; i < holdAv.length;) {
			samling.leggTil(holdAv[i]);
		}
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
        Random random = new Random();
        Kort[] holdAv = new Kort[samling.getAntalKort()];
        
        for (int i = 0; i < holdAv.length;) {
            
        	int r = random.nextInt(holdAv.length);
            
        	if (holdAv[r] == null) {
                holdAv[r] = samling.taSiste();
                i++;
            }
        }
        for (int i = 0; i < holdAv.length; i++) {
            samling.leggTil(holdAv[i]);
        }
    }
}
	
