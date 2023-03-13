package sn.esmt.Cv.ws;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.Cv.dao.CvRepository;
import sn.esmt.Cv.entities.CvEntity;

import java.util.List;
@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor

public class CvController {
    private CvRepository cvRepository;
    @PostMapping(path="/save")
    public CvEntity save(@RequestBody CvEntity cvEntity){
        return cvRepository.save(cvEntity);
    }
    @GetMapping(path="/all")
    public List<CvEntity> getAll(){
        return cvRepository.findAll();
    }
}
