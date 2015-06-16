/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.NewHibernateUtil;
import DAO.Operaciones;
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
        setFormView("gestionVotaciones");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Votante OVotante = (Votante) command;
        ModelAndView mv;
        String accion = "No seleccionada ";
        int opcionSeleccionada = verificaAccion(request);
//        try {
        sessionBuilder = NewHibernateUtil.getSessionFactory();//Conexion
        Operaciones operaciones = new Operaciones();

        switch (opcionSeleccionada) {
            case 0: {
                operaciones.insertarVotante(OVotante, sessionBuilder);
                setSuccessView("altaVotante");
                mv = new ModelAndView(getSuccessView());
                break;
            }

//            case 1: {
//                break;
//            }
            case 2: {
                if (operaciones.puedeVotar(OVotante, sessionBuilder)) {
                    setSuccessView("votarPartido");  
                    HttpSession httpsession = request.getSession(true);
                    httpsession.setAttribute("votante", OVotante);
                    mv = new ModelAndView("redirect:votarPartido.htm");
                }
                else{
                    setSuccessView("noVotar");
                    mv = new ModelAndView(getSuccessView());
                }
                break;
            }
//            case 3: {
//                break;
//            }
//            case 4: {
//                break;
//            }
            default:
                mv = new ModelAndView("altaVotante");
            case 1: {
                operaciones.bajaVotante(OVotante, sessionBuilder);
                setSuccessView("bajaVotante");
                mv = new ModelAndView(getSuccessView());
                break;
            }
            //case 2: {modificar(persona);accion = "Modificado";break;}
            //case 3: {persona=buscar(persona);accion = "Consultado";break;}
            //case 4: {listado=listar();accion = "Listado";break;}
        }

        return mv;
    }

    private int verificaAccion(HttpServletRequest request) {
        if (request.getParameter("insertar") != null) {
            return 0;
        } else if (request.getParameter("baja") != null) {
            return 1;
        } else if (request.getParameter("votar") != null) {
            return 2;
        } else if (request.getParameter("escrutar") != null) {
            return 3;
        } else if (request.getParameter("censo") != null) {
            return 4;
        }
        return -1;
    }

}
