package controller;

import entity.Student;
import service.StudentService;
import studentDTO.StudentDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
public class StudentController {
    StudentService studentService = new StudentService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent() {
        return studentService.getListStudent();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewSubject(StudentDTO studentDTO) {
        return studentService.insert(studentDTO) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeStudent(@PathParam("id") int id) {
        return studentService.removeStudent(id) ? "Xóa thành công" : "Xóa thất bại";
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String UpdateSubject(Student student) {
        return studentService.update(student) ? "Update thành công" : "Update thất bại";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/birthday")
    public List<Student> getAllBirthdayPeople(){
        return studentService.getListStudentBirthday();
    }
}
