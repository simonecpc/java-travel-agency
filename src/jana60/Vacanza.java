package jana60;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Vacanza {

	private String destinazione;
	private LocalDate inizio ;
	private LocalDate fine ;
	private LocalDate oggi = LocalDate.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Vacanza(String destinazione,LocalDate inizio,LocalDate fine) throws Exception{
		super();
		this.destinazione = destinazione;
		this.inizio = inizio;
		this.fine = fine;
		this.validaVacanza();
		this.validaFine();
		this.validaInizio();	
	}
	
	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
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

	public LocalDate getOggi() {
		return oggi;
	}

	public void setOggi(LocalDate oggi) {
		this.oggi = oggi;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
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
	
	public Period pp() {
		Period vacanzaPeriod = Period.between(inizio, fine);
		return vacanzaPeriod;
	}
	
	
	
}
