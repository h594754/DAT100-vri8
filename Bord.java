package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Klasse som implementerer bordet som spilles p�. 
 * 
 * Klassen har objektvariablene bunkeTil og bunkeFra som skal brukes til � representere 
 * kortene som er i de to bunker p� border. 
 */
public class Bord {

	private KortSamling bunkeFra;
	private KortSamling bunkeTil;
	
	/**
	 * Metoden oppretter to bunker, til- og fra-bunken
	 * Alle kortene legges til fra-bunken. 
	 */
	public Bord() {
		bunkeFra = new KortSamling();
		bunkeTil = new KortSamling();
		bunkeFra.leggTilAlle();
		KortUtils.stokk(bunkeFra);
	
		
		
	}
	
	/**
	 * Gir peker/referanse til til-bunken.
	 * 
	 * @return referanse/peker til til-bunken.
	 */
	public KortSamling getBunkeTil() {
		return bunkeTil;
		
	}

	/**
	 * Gir peker/referanse til fra-bunken.
	 * 
	 * @return referanse/peker til fra-bunken.
	 */
	public KortSamling getBunkeFra() {
		return bunkeFra;
		
	}
	
	/**
	 * Sjekker om til-bunken er tom.
	 * 
	 * @return true om til-bunken er tom, false ellers.
	 */
	public boolean bunketilTom() {
		return bunkeTil.erTom();
	}
	/**
	 * Sjekker om fra-bunken er tom.
	 * 
	 * @return true om fra-bunken er tom, false ellers.
	 */
	public boolean bunkefraTom() {
		
		return bunkeFra.erTom();
		
	}
	
	/**
	 * Gir antall kort i fra-bunken.
	 * 
	 * @return antall kort i fra-bunken.
	 */
	public int antallBunkeFra() {
		return bunkeFra.getAntalKort();
	}

	/**
	 * Gir antall kort i til-bunken.
	 * 
	 * @return antall kort i til-bunken.
	 */
	public int antallBunkeTil() {
		return bunkeTil.getAntalKort();
	}
	
	/**
	 * Tar øverste kortet fra fra-bunken og legger dettte til til-bunken (med
	 * billedsiden opp, men det trenger ikke gruppen tenke p�).
	 */
	public void vendOversteFraBunke() {
		bunkeTil.leggTil(bunkeFra.taSiste());	
	}
		
	/**
	 * Tar øverste kortet fra fra-bunken.
	 * 
	 * @return peker/referanse til det kort som blev tatt fra fra-bunken
	 */
	
	public Kort taOversteFraBunke() {
		return bunkeFra.taSiste();
	}
	
	/**
	 * Metode som leser øverste kortet i til-bunken. Kortet vil fremdeles v�re
	 * øverst i til-bunken etter at metoden er utf�rt.
	 * 
	 * @return peker/referanse til øverste kortet i til-bunken.
	 */
	public Kort seOversteBunkeTil() {
		
		return bunkeTil.seSiste();
	}
	
	/**
	 * N�r fra-bunken blir tom, tar man vare p� kortet pÂ toppen av til-bunken.
	 * Deretter legges alle den andre kortene i til-bunken over i fra-bunken.
	 * Denne stokkes og kortet som man har tatt vare pÂ legges tilbake i
	 * til-bunken. Det vil n� v�re det eneste kortet i til-bunken.
	 */
	public void snuTilBunken() {
		Kort siste = bunkeTil.taSiste();
		for(int i = 0; i < 4 * Regler.MAKS_KORT_FARGE; i++) {
			if(bunkeTil.seSiste() != null) {
				bunkeFra.leggTil(bunkeTil.taSiste());	
			}
		}
		KortUtils.stokk(bunkeFra);
		bunkeTil.leggTil(siste);
		
	}
		
	/**
	 * Metode som legger et kort i til-bunken. 
	 * 
	 * @param k
	 * 			kort som skal legges ned. 
	 * 	
	 */
	public void leggNedBunkeTil(Kort k) {
		
		bunkeTil.leggTil(k);
		KortUtils.stokk(bunkeFra);
				
	}
}
