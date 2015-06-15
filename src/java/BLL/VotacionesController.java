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
            default:
                mv = new ModelAndView("altaVotante");
            //case 1: {persona=buscar(persona);eliminar(persona);accion = "Eliminado";break;}
            //case 2: {modificar(persona);accion = "Modificado";break;}
            //case 3: {persona=buscar(persona);accion = "Consultado";break;}
            //case 4: {listado=listar();accion = "Listado";break;}
        }

         return mv;
    }

    private int verificaAccion(HttpServletRequest request) {
        if (request.getParameter("insertar")!=null) {
            return 0;
        } else if ("baja".equals(request.getParameter("baja"))) {
            return 1;
        } else if ("votar".equals(request.getParameter("votar"))) {
            return 2;
        } else if ("escrutar".equals(request.getParameter("escrutar"))) {
            return 3;
        } else if ("censo".equals(request.getParameter("censo"))) {
            return 4;
        }
        return -1;
    }

}
