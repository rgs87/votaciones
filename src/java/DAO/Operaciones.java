/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Partido;
import POJO.Votante;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ruben
 */
public class Operaciones {
    
     

    public void insertarVotante(Votante _objVotante, SessionFactory _sessionBuilder) {
        Session session = _sessionBuilder.openSession();//statement
        Transaction tx = null;
        try {
            _objVotante.setVotado("N");
            tx = session.beginTransaction();
            //HQL
            session.save(_objVotante);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            he.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List consultarCenso(SessionFactory _sessionBuilder) {
        Session session = _sessionBuilder.openSession();//statement
        List censo = new ArrayList();
        censo = session.createQuery("FROM Votante").list();
        return censo;
    }

    public void bajaVotante(Votante _objVotante, SessionFactory _sessionBuilder) {
        Session session = _sessionBuilder.openSession();//statement
        //Buscar el objeto con los parametros introducidos
        Query q = session.createQuery("FROM Votantes WHERE nif= :_vnif AND password= :_vpassword");
        q.setParameter("_vnif", _objVotante.getNif());
        q.setParameter("_vpassword", _objVotante.getPassword());
        List list_Votante = q.list();
        
        //Guardamos en un objeto Votantes el objeto que nos devuelve el list para despues borrarlo de la tabla
        Votante _Votante = new Votante();
        if (!list_Votante.isEmpty()) {
            _Votante= (Votante) list_Votante.get(0);
        }
        
        
        
        //BORRAR VOTANTE
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //HQL
            session.delete(_Votante);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            he.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public boolean puedeVotar(Votante _objVotante, SessionFactory _sessionBuilder){
        Session session = _sessionBuilder.openSession();//statement
        //Buscar el objeto con los parametros introducidos
        Query q = session.createQuery("FROM Votantes WHERE nif= :_vnif AND password= :_vpassword AND votado='N'" );
        q.setParameter("_vnif", _objVotante.getNif());
        q.setParameter("_vpassword", _objVotante.getPassword());
        List list_Votante = q.list();
        
        //Si encuentra al votante, es que no ha  votado
        if (!list_Votante.isEmpty()) {
            return true;
        }
        else return false;
    }
    
    public void grabarVoto(Votante _objVotante, Partido _objPartido,SessionFactory _sessionBuilder){
        Session session = _sessionBuilder.openSession();//statement
        //Buscar al votante
        Query q = session.createQuery("FROM Votantes WHERE nif= :_vnif AND password= :_vpassword");
        q.setParameter("_vnif", _objVotante.getNif());
        q.setParameter("_vpassword", _objVotante.getPassword());
        List list_Votante = q.list();
        
        Votante _Votante = new Votante();
        if (!list_Votante.isEmpty()) {
            _Votante= (Votante) list_Votante.get(0);
        }
        
        //Actualizar
        _Votante.setVotado("S");
        
        //Buscar al partido
        Query q2 = session.createQuery("FROM Partido WHERE nombre= :_vnombre");
        q2.setParameter("_vnombre", _objPartido.getNombre());
        List list_Partido = q2.list();
        
        Partido _Partido = new Partido();
        if (!list_Partido.isEmpty()) {
            _Partido= (Partido) list_Partido.get(0);
        }
        
        //Actualizar
        _Partido.setVotos(_Partido.getVotos()+1);
        
        
        
        //ACTUALIZAR VOTANTE Y PARTIDO
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //HQL
            session.update(_Votante);
            session.update(_Partido);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        
    }
    
    public List cierreEscrutinio(SessionFactory _sessionBuilder){
        Session session = _sessionBuilder.openSession();//statement
        List partidos = new ArrayList();
        partidos = session.createQuery("FROM Partido").list();
        return partidos;
    }

}

