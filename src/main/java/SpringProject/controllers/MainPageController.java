package SpringProject.controllers;


import SpringProject.dao.DepartmentDao;
import SpringProject.dao.EmployeeDao;
import SpringProject.object.Department;
import SpringProject.object.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/MainPage")
public class MainPageController {

    private final DepartmentDao departmentDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public MainPageController(DepartmentDao departmentDao,EmployeeDao employeeDao) {
        this.departmentDao = departmentDao;
        this.employeeDao =employeeDao;
    }


    @GetMapping("{pagD}/{pagE}")
    public String MainPage(@PathVariable(value = "pagD", required = false) int paginationDepartment,
                           @PathVariable(value = "pagE", required = false) int paginationEmployee,
                           Model model) {

        int employeePag = employeeDao.index().size();
        int departmentPag = departmentDao.index().size();

        int a = employeePag /5;
        int b = departmentPag /5;
        if (employeePag % 5 != 0) a++;
        if (departmentPag % 5 != 0) b++;
        employeePag = a;
        departmentPag = b;

        int[] employeePagNumb = new int[employeePag];
        for (int i = 1; i < (employeePag + 1); i++) {
            employeePagNumb[i - 1] = i;
        }

        int[] departmentPagNumb = new int[departmentPag];
        for (int i = 1; i < (departmentPag + 1); i++) {
            departmentPagNumb[i - 1] = i;
        }

        model.addAttribute("EmpPagNum",employeePagNumb);
        model.addAttribute("DepPagNum",departmentPagNumb);


        model.addAttribute("employee", new Employee());
        model.addAttribute("department", new Department());
        model.addAttribute("departmentSelect", departmentDao.index());

        try {
            model.addAttribute("departments", departmentDao.index(paginationDepartment));
        }
        catch (Exception e){
            model.addAttribute("departments", departmentDao.index(1));
        }
        try {
            model.addAttribute("employees", employeeDao.index(paginationEmployee));
        }catch (Exception e){
            model.addAttribute("employees", employeeDao.index(1));
        }

        return "MainPage";
    }


    @PostMapping(value = "/NewEmployee")
    public String SaveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeDao.save(employee);
        return "GoBack";
    }
    @PostMapping(value = "/NewDepartment")
    public String SaveDepartment(@ModelAttribute("department") Department department){
        departmentDao.save(department);
        return "GoBack";
    }
    @PostMapping(value = "/deleteEmployee")
    public String DeleteEmployee(HttpServletResponse resp, HttpServletRequest req){
        employeeDao.delete(Integer.parseInt(req.getParameter("employeeDelete")));
        return "GoBack";
    }
    @PostMapping(value = "/deleteDepartment")
    public String DeleteDepartment(HttpServletResponse resp, HttpServletRequest req){
        departmentDao.delete(Integer.parseInt(req.getParameter("departmentDelete")));
        return "GoBack";
    }
}
