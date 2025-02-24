package br.com.ronald.glucose.service;

import br.com.ronald.glucose.model.FastingOrPostprandial;
import br.com.ronald.glucose.model.Glucose;
import br.com.ronald.glucose.model.dto.PacientGlucoseMeasureDTO;
import br.com.ronald.glucose.repository.GlucoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlucoseService {

    @Autowired
    private GlucoseRepository glucoseRepository;

    public Glucose glucoseMeasure(PacientGlucoseMeasureDTO dto){
        var glucose = new Glucose(dto);
        String state = dto.fastingOrPostprandial();
        Integer glucoseLevel = dto.glucoseLevel();

        if(FastingOrPostprandial.valueOf(state).equals(FastingOrPostprandial.IN_FASTING)){
            if(glucoseLevel < 70){
                glucose.setGlucoseType("Hypoglycemia");
                glucose.setObservations("It can cause symptoms such as dizziness, cold sweats and fainting.");
            } else if(glucoseLevel <= 99){
                glucose.setGlucoseType("Normal");
                glucose.setObservations("No observations");
            } else if(glucoseLevel > 125){
                glucose.setGlucoseType("Hyperglycemia");
                glucose.setObservations("May cause increased appetite, excessive thirst, blurred vision, weight loss, and increased urine output");
            }
        } else if(FastingOrPostprandial.valueOf(state).equals(FastingOrPostprandial.POSTPRANDIAL)) {
            if(glucoseLevel < 140){
                glucose.setGlucoseType("Normal");
                glucose.setObservations("No observations");
            } else if(glucoseLevel > 200){
                glucose.setGlucoseType("Hyperglycemia");
                glucose.setObservations("May cause increased appetite, excessive thirst, blurred vision, weight loss, and increased urine output");
            }
        }

        return glucoseRepository.save(glucose);
    }
}

