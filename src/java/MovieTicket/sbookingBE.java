/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieTicket;

import DbConnection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nithin S R
 */
@WebServlet(name = "sbookingBE", urlPatterns = {"/sbookingBE"})
public class sbookingBE extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sbookingBE</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet sbookingBE at " + request.getContextPath() + "</h1>");
           
            String custName = request.getParameter("cname");
            String movname = request.getParameter("mname");
            String theaname = request.getParameter("tname");
            String movdate = request.getParameter("mdate");
            String movtime = request.getParameter("stime");
            String seatype = request.getParameter("stype");
            String totalPriceStr = request.getParameter("tprice");
totalPriceStr = totalPriceStr.replaceAll("[^\\d]", ""); // Remove non-numeric characters
Long totprice = Long.parseLong(totalPriceStr);

             Connection con=dbconnection.getConnectTomovieticket();
                    String sql = "INSERT INTO bookings (movie,theatre,date,showtime,seattype,cname,totalprice) VALUES (?, ?, ?, ?,?,?,?)";
               PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, movname);
        ps.setString(2, theaname);
        ps.setString(3, movdate);
        ps.setString(4,movtime);
        ps.setString(5,seatype);
        ps.setString(6,custName);
        ps.setLong(7,totprice);
   
        
        
      
       int i = ps.executeUpdate();
        if (i > 0) {
            out.println("<script> alert('ticket booked');</script>");
            request.getRequestDispatcher("viewticket.html").include(request, response);
        } else {
            out.println("<script> alert('ticket not booked');</script>");
            request.getRequestDispatcher("Searbooking.html").include(request, response);
        }
        //Step 5 to terminate the connection
        con.close();
             
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sbookingBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbookingBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sbookingBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbookingBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
