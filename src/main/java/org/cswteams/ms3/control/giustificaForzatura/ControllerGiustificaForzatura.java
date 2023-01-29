package org.cswteams.ms3.control.giustificaForzatura;

import org.cswteams.ms3.dao.LiberatoriaDao;
import org.cswteams.ms3.dao.GiustificazioneFozaturaDao;
import org.cswteams.ms3.dao.UtenteDao;
import org.cswteams.ms3.dto.GiustificazioneForzaturaVincoliDTO;
import org.cswteams.ms3.entity.AssegnazioneTurno;
import org.cswteams.ms3.entity.Liberatoria;
import org.cswteams.ms3.entity.GiustificazioneForzaturaVincoli;
import org.cswteams.ms3.entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class ControllerGiustificaForzatura implements IControllerGiustificaForzatura {

    @Autowired
    GiustificazioneFozaturaDao giustificazioneFozaturaDao;

    @Autowired
    LiberatoriaDao liberatoriaDao;

    @Autowired
    UtenteDao utenteDao;

    @Override
    public void saveGiustificazione(GiustificazioneForzaturaVincoliDTO giustificazioneForzaturaVincoliDTO) {
        //giustificazioneFozaturaDao.save(giustificazioneForzaturaVincoli);
        Utente giustificatore = utenteDao.findById(giustificazioneForzaturaVincoliDTO.getUtenteGiustificatoreId());
        GiustificazioneForzaturaVincoli giustificazioneForzaturaVincoli = new GiustificazioneForzaturaVincoli(giustificazioneForzaturaVincoliDTO.getMessage(), giustificatore,new HashSet<>(),new ArrayList<>(), new AssegnazioneTurno());
        //giustificazioneFozaturaDao.save(giustificazioneForzaturaVincoli);
    }


    @Override
    public Liberatoria saveDelibera(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Liberatoria liberatoria = new Liberatoria(fileName, file.getContentType(), file.getBytes());
        return liberatoriaDao.save(liberatoria);
    }

    @Override
    public Liberatoria getDelibera(String filename) {
        return liberatoriaDao.findDeliberaByName(filename);
    }


}