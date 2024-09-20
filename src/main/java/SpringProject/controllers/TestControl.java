package SpringProject.controllers;


import SpringProject.dao.SimpleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/hello")
public class TestControl {

    private final SimpleDao simpleDao;

    @Autowired
    public TestControl(SimpleDao simpleDao) {
        this.simpleDao = simpleDao;
    }

    @GetMapping()
    public String hello(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("users", simpleDao.index());
        return "hello";
    }

}
