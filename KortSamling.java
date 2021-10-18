package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for � lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. N�r
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det v�re praktisk � ha denne mindre.
 * 
 */
public class KortSamling {

	public static int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		samling = new Kort[MAKS_KORT];
		 
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke v�re
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan f�
	 * tilgang til antallet ved � bruke metoden getAntallKort(). Metoden er
	 * f�rst og fremst ment � brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		return samling;
		
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		int antall = 0; 
		for(int i=0; i<samling.length;i++) {
			if(samling[i] != null) {
				antall += 1;
			}
		}
		return antall;

	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
						
		boolean tom = false; 
		if(samling[0] == null) {
			tom = true;
		}
		return tom; 
		
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
				
		for(int i=0; i<samling.length;i++) {
			if(samling[i] == null) {
				samling[i] = kort;
				break;
			}
		}		 		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil v�re sortert
	 * slik at de normalt m� stokkes f�r bruk.
	 */
	public void leggTilAlle() {
		// Husk: bruk Regler.MAKS_KORT_FARGE for � f� antall kort per farge			
	for(Kortfarge farge : Kortfarge.values()) {
		for(int i=1; i<=Regler.MAKS_KORT_FARGE; i++) {
			leggTil(new Kort(farge, i));
			
			}
		}
	}


	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		for(int i = 0; i < samling.length; i++) {
			samling[i] = null; 
		}
	}
	
	/**
	 * Ser p� siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		
		Kort siste = samling[samling.length-1];
		if(samling[0] == null) {
			return null;
		}
		
		for(int i = 0; i < samling.length; i++) {
			if(samling[i] == null && i !=0) {
				siste = samling[i-1];
				break;
			}
		}
			return siste; 
		}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
        Kort siste = samling[samling.length - 1];
        if (samling[0] == null) {
            return null;
        }
        if (getAntalKort() != samling.length) {
            for (int i = 0; i < samling.length; i++) {
                if (samling[i] == null && i != 0) {
                    siste = samling[i - 1];
                    samling[i - 1] = null;
                    break;
                }
            }
        } else {
            samling[samling.length-1] = null;
        }
        return siste;
    }
	
	/**
	 * Unders�ker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
        if (kort != null) {
            for (int i = 0; i < samling.length; i++) {
                if (kort.equals(samling[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fjern(Kort kort) {
        if (kort != null) {
            for (int i = 0; i < samling.length; i++) {
                if (kort.equals(samling[i])) {
                    samling[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkef�lge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAlleKort() {
		Kort[] alle = new Kort[getAntalKort()];
		for(int i = 0; i < getAntalKort(); i++) {
			alle[i] = samling[i];
		}
		return alle;
	} 
}
	

