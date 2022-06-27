package jana60;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Vacanza {

	private String destinazione;
	private int giorno, mese, anno;
	
	public Vacanza(String destinazione, int giorno, int mese, int anno) throws Exception{
		super();
		this.destinazione = destinazione;
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		this.validaVacanza();
		this.validaFine();
		this.validaInizio();
	}
	
	LocalDate inizio = LocalDate.of(giorno, mese, anno);
	LocalDate fine = LocalDate.of(giorno, mese, anno);

	LocalDate oggi = LocalDate.now();

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public int getGiorno() {
		return giorno;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

	public int getMese() {
		return mese;
	}

	public void setMese(int mese) {
		this.mese = mese;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public LocalDate getInizio() {
		return inizio;
	}

	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}

	public LocalDate getFine() {
		return fine;
	}

	public void setFine(LocalDate fine) {
		this.fine = fine;
	}
	
	public void validaVacanza() throws Exception {
		if (inizio == null || fine == null || destinazione == null) {
			throw new Exception ("Si prega di inserire dei dati validi per il soggiorno e/o la destinazione");
		}
	}
	
	public void validaInizio() throws Exception {
		if (oggi.isAfter(inizio)) {
			throw new Exception ("Non puoi prenotare una vacanza nel passato, riprova.");
		}
	}
	
	public void validaFine()throws Exception {
		if (inizio.isAfter(fine)) {
			throw new Exception ("Non puoi finire una vacanza prima di averla iniziata, riprova.");
		}
	}
	
	 Period etaPeriod = Period.between(inizio, fine);
}
