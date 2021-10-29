package service;

import entity.Student;
import reponsitory.StudentDAO;
import studentDTO.StudentDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class StudentService {
    StudentDAO studentDAO = new StudentDAO();

    public List<Student> getListStudent() {
        return studentDAO.getAllStudent();
    }

    public List<Student> getListStudentBirthday() {
        return studentDAO.getStudentByBirthday();
    }

    public boolean insert(StudentDTO studentDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Student student = new Student();
        try {
            student.setBirthday(sdf.parse(studentDTO.getBirthday()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setAverageMark(studentDTO.getAverageMark());
        student.setGender(studentDTO.getGender());
        student.setClassName(studentDTO.getClassName());
        student.setHometown(studentDTO.getHometown());
        student.setMajor(studentDTO.getMajor());
        student.setFullName(studentDTO.getFullName());
        if (student.getFullName() == null){
            return false;
        }
        if (student.getBirthday() == null){
            return false;
        }else {
            Period period = Period.between(LocalDate.ofEpochDay(student.getBirthday().getDate()), LocalDate.now());
            if(period.getYears() > 100 || period.getYears() < 0){
                return false;
            }
        }
        if (student.getClassName() == null || student.getClassName().length() > 50 || student.getClassName().length() < 1){
            return false;
        }
        if (student.getMajor() == null){
            return false;
        }
        if (student.getHometown() == null){
            return false;
        }
        if (student.getGender() == null){
            return false;
        }
        if (student.getAverageMark() > 10 || student.getAverageMark() < 0){
            return false;
        }
        return studentDAO.insertStudent(student);
    }

    public boolean update(Student student) {
        if(student.getId() <= 0){
            return false;
        }
        if (student.getFullName() == null){
            return false;
        }
        if (student.getBirthday() == null){
            return false;
        }else {
            Period period = Period.between(LocalDate.ofEpochDay(student.getBirthday().getDate()), LocalDate.now());
            if(period.getYears() > 100 || period.getYears() < 0){
                return false;
            }
        }
        if (student.getClassName() == null || student.getClassName().length() > 50 || student.getClassName().length() < 1){
            return false;
        }
        if (student.getMajor() == null){
            return false;
        }
        if (student.getHometown() == null){
            return false;
        }
        if (student.getGender() == null){
            return false;
        }
        if (student.getAverageMark() > 10 || student.getAverageMark() < 0){
            return false;
        }
        return studentDAO.update(student);
    }

    public boolean removeStudent(int id) {
        return studentDAO.removeStudent(id);
    }
}
