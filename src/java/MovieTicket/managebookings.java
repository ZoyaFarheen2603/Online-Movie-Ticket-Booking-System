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
import java.sql.ResultSet;
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
@WebServlet(name = "managebookings", urlPatterns = {"/managebookings"})
public class managebookings extends HttpServlet {

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
        
                 Connection con=dbconnection.getConnectTomovieticket();
        String sql = "SELECT * FROM bookings";
        PreparedStatement ps = con.prepareStatement(sql);
       
        ResultSet rs = ps.executeQuery();
        PrintWriter out = response.getWriter(); {
            /* TODO output your page here. You may use following sample code. */
               out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Flight Search Results</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f5f5f5; }");
        out.println("h1 { text-align: center; margin-top: 20px; color: #333; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { padding: 8px; border: 1px solid #ddd; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println(".book-button { display: block; width: 80px; padding: 8px; text-align: center; background-color: #4caf50; color: #fff; text-decoration: none; border-radius: 5px; margin: auto; }");
        out.println(".book-button:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Movie Details</h1>");
        out.println("<table>");
        out.println("<tr><th>Booking ID</th><th>Movie </th><th>Theatre</th><th>Date</th><th>Timings</th><th>seat type</th> <th> Name</th> <th> Price</th></tr>");

        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getLong(1) + "</td>");
        out.println("<td>" + rs.getString(2) + "</td>");
        out.println("<td>" + rs.getString(3) + "</td>");
        out.println("<td>" + rs.getString(4) + "</td>");
        out.println("<td>" + rs.getString(5) + "</td>");
        out.println("<td>" + rs.getString(6) + "</td>");
        out.println("<td>" + rs.getString(7) + "</td>");
        out.println("<td>" + rs.getLong(8) + "</td>");
           

            out.println("</tr>");
        }
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
            Logger.getLogger(managebookings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(managebookings.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(managebookings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(managebookings.class.getName()).log(Level.SEVERE, null, ex);
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
