/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.NewHibernateUtil;
import DAO.Operaciones;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Ruben
 */
public class CensoController implements Controller {

    SessionFactory sessionBuilder;

    public void init() {
        sessionBuilder = NewHibernateUtil.getSessionFactory();//Conexion
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("censo");

        try {
            sessionBuilder = NewHibernateUtil.getSessionFactory();//Conexion
            HttpSession httpsession = hsr.getSession(true);
            Operaciones _Operacion = new Operaciones();

            List censo = _Operacion.consultarCenso(sessionBuilder);
            mv.addObject("censo", censo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

}
