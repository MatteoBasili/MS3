package org.cswteams.ms3.control.medicalService;

import org.cswteams.ms3.dto.medicalservice.AvailableTasksTypesDTO;
import org.cswteams.ms3.dto.medicalservice.MedicalServiceDTO;
import org.cswteams.ms3.dto.medicalservice.MedicalServiceCreationDTO;
import org.cswteams.ms3.entity.MedicalService;
import org.cswteams.ms3.entity.Task;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public interface IMedicalServiceController {

    MedicalService createService(@NotNull MedicalServiceCreationDTO medicalServiceDTO);

    //MedicalService createService(@NotNull MedicalServiceDTO medicalServiceDTO);

    MedicalService createService(List<Task> taskList, String label);

    Set<MedicalServiceDTO> getAllMedicalServices();

    MedicalServiceDTO getServiceByName(@NotNull String serviceName);

    AvailableTasksTypesDTO getAvailableTaskTypes();

}
