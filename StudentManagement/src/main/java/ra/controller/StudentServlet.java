package ra.controller;

import ra.model.enity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static List<Student> listStudents = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        Student st1 = new Student("SV001", "Nguyễn Văn A", 20);
        Student st2 = new Student("SV002", "Nguyễn Văn B", 22);
        listStudents.add(st1);
        listStudents.add(st2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Nhận request có methode là GET
        String action = request.getParameter("action");
        if (action != null && action.equals("update")) {
            //-Thuc hien lay thong tin sinh vien tu studentId va hien thi len tran jsp de cap nhat
            String studentIdUpdate = request.getParameter("studentId");
            for (Student st : listStudents) {
                if (st.getStudentId().equals(studentIdUpdate)) {
                    request.setAttribute("studentUpdate", st);
                    request.getRequestDispatcher("views/updateStudent.jsp").forward(request, response);
                    break;
                }
            }
        } else if (action != null && action.equals("delete")) {
            String studentId = request.getParameter("studentId");
            for (Student st : listStudents) {
                if (st.getStudentId().equals(studentId)){
                    listStudents.remove(st);
                    break;
                }
            }
            getAllStudent(request,response);

        } else {
            getAllStudent(request, response);
        }

    }

    public void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //-Trả về response có đầy đủ thông tin sinh viên
        //--Set listStudents vào request
        request.setAttribute("listStudent", listStudents);
        //--Sử dụng RequestDispatcher chuyển dữ liệu sang trang jsp
//        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/students.jsp");
//        rd.forward(request,response);
        request.getRequestDispatcher("views/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Xử lý request có method = POST
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            //--Lay thong tin tu request
            String studentId = request.getParameter("studentId");
            String studentName = request.getParameter("studentName");
            int age = Integer.parseInt(request.getParameter("age"));
            //--add new Student to listStudent
            Student st = new Student(studentId, studentName, age);
            listStudents.add(st);
        } else if (action.equals("Update")) {
            //Thực hiện update
            String studentId = request.getParameter("studentId");
            String studentName = request.getParameter("studentName");
            int age = Integer.parseInt(request.getParameter("age"));
            for (Student st : listStudents) {
                if (st.getStudentId().equals(studentId)) {
                    st.setStudentName(studentName);
                    st.setAge(age);
                    break;
                }
            }
        }
        //--Thuc hien lay lai danh sinh vien va hien thi tren trang students.jsp
        getAllStudent(request, response);
    }
}
