/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.NewHibernateUtil;
import DAO.Operaciones;
import POJO.Partido;
import POJO.Votante;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Ruben
 */
public class VotarPartidoController extends SimpleFormController {
    
    SessionFactory sessionBuilder;
    public void init() {
        sessionBuilder = NewHibernateUtil.getSessionFactory();//Conexion
    }

    public VotarPartidoController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Partido.class);
        setCommandName("partido");
        setSuccessView("partidoVotado");
        setFormView("votarPartido");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Partido OPartido = (Partido) command;
        HttpSession httpsession = request.getSession(true);
        Votante OVotante = (Votante) httpsession.getAttribute("votante");
        ModelAndView mv = new ModelAndView(getSuccessView());
        sessionBuilder = NewHibernateUtil.getSessionFactory();//Conexion
        Operaciones operaciones = new Operaciones();
        operaciones.grabarVoto(OVotante, OPartido, sessionBuilder);
        return mv;
    }

}
