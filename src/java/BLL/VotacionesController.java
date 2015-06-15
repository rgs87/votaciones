/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.NewHibernateUtil;
import DAO.Operaciones;
import POJO.Votante;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Ruben
 */
public class VotacionesController extends SimpleFormController {

    
    SessionFactory sessionBuilder;
    
    public void init() {
        sessionBuilder = NewHibernateUtil.getSessionFactory();//Conexion
    }

    public VotacionesController() {

        //Initialize controller properties here or 
        //in the Web Application Context
        setCommandClass(Votante.class);
        setCommandName("votante");
        setSuccessView("altaVotante");
        setFormView("gestionVotaciones");
    }

    

    

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Votante OVotante = (Votante) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        try {
            sessionBuilder = NewHibernateUtil.getSessionFactory();//Conexion
            Operaciones operaciones = new Operaciones();
            operaciones.insertarVotante(OVotante, sessionBuilder);

            //mv.addObject("censo", censo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
