package org.cswteams.ms3.dto;

import lombok.Data;
import org.cswteams.ms3.enums.TipologiaTurno;

import java.time.LocalDate;
import java.util.Set;

@Data
public class RegistraAssegnazioneTurnoDTO {

    private int giorno;
    private int mese;
    private int anno;

    private TipologiaTurno tipologiaTurno;
    private Set<UtenteDTO> utentiDiGuardia;
    private Set<UtenteDTO> utentiReperibili;
    private ServizioDTO servizio;

    public RegistraAssegnazioneTurnoDTO(){}


}