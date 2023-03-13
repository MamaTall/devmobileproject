package sn.esmt.Cv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.Cv.entities.CvEntity;
@Repository
public interface CvRepository extends JpaRepository<CvEntity,Integer> {
    CvEntity findById(int id);
    CvEntity findBySpecialite(String specialite);
}
