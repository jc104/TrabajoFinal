/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.controlador;

import com.upc.dao.UsuarioDao;
import com.upc.dao.UsuarioImpl;
import com.upc.entidades.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String accionservletpost = req.getParameter("accion");
      if (accionservletpost.equalsIgnoreCase("login")) {
            
            UsuarioDao usuariodao = new UsuarioImpl();
            String nombreusuario = req.getParameter("txtloginusuario");
            String clave = req.getParameter("txtloginpassword");
            Usuario var = usuariodao.login(nombreusuario, clave);
            if (var.getNombreusuario() != null) {
                HttpSession sesion = req.getSession();
                sesion.setAttribute("usuariologeado", var);
                doGet(req, resp);
            } else {
                RequestDispatcher redireccionar = req.getRequestDispatcher("/index.jsp");
                req.setAttribute("mensaje", "Usuario o Password incorrecto");
                redireccionar.forward(req, resp);
            }
        }
    }
    
}
