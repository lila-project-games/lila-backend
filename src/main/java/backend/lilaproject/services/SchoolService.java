package backend.lilaproject.services;

import backend.lilaproject.models.School;
import backend.lilaproject.repositories.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    SchoolRepo schoolRepo;

    public School saveSchool(School school){
        return schoolRepo.save(school);
    }

    public ArrayList<School> getSchools(){
        return (ArrayList<School>) schoolRepo.findAll();
    }

    public Optional<School> getById(Long id){
        return schoolRepo.findById(id);
    }

    public boolean eraserSchool(Long id) {
        try{
            schoolRepo.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public List<School> listCategory(){
        return schoolRepo.findAll();
    }

    public void editSchool(Long Id, School updateSchool) {
        School school=schoolRepo.getReferenceById(Id);
        //school.setSchoolName(updateSchool.getSchoolName());
        schoolRepo.save(school);

    }

}
