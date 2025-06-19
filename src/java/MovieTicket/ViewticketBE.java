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
@WebServlet(name = "ViewticketBE", urlPatterns = {"/ViewticketBE"})
public class ViewticketBE extends HttpServlet {

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
        
         Connection con = dbconnection.getConnectTomovieticket();
        String sql = "SELECT * FROM bookings ORDER BY bid DESC LIMIT 1;";
        PreparedStatement ps = con.prepareStatement(sql);
     
        ResultSet rs = ps.executeQuery();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewticketBE</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet ViewticketBE at " + request.getContextPath() + "</h1>");
              out.println("<style>");
    out.println("body {");
    out.println("    font-family: Arial, sans-serif;");
    out.println("    background-color: #f5f5f5;");
    out.println("}");

    out.println(".ticket {");
    out.println("    background-color: #e6e6e6;");
    out.println("    border-radius: 10px;");
    out.println("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
    out.println("    max-width: 90%;"); // Adjusted size to fit content
    out.println("    margin: 50px auto;");
    out.println("    padding: 20px;");
    out.println("}");

    out.println("h1 {");
    out.println("    text-align: center;");
    out.println("    margin-bottom: 20px;");
    out.println("    color: #333;"); // Darker text color
    out.println("}");

    out.println("table {");
    out.println("    width: 100%;");
    out.println("    border-collapse: collapse;");
    out.println("    margin-bottom: 20px;");
    out.println("}");

    out.println("th, td {");
    out.println("    padding: 10px;");
    out.println("    text-align: center;");
    out.println("}");

    out.println(".ticket th {");
    out.println("    background-color: #f2f2f2;");
    out.println("}");

    out.println(".ticket td {");
    out.println("    background-color: #fff;");
    out.println("    color: #333;"); // Darker text color
    out.println("}");

    out.println(".cancel-button {");
    out.println("    display: block;");
    out.println("    width: 100%;");
    out.println("    text-align: center;");
    out.println("}");

    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class=\"ticket\">");
    out.println("<h1>Movie Ticket</h1>");
    out.println("<table>");
    out.println("<tr><th>Booking ID</th><th>Movie</th><th>Theatre</th><th>Date</th><th>Showtime</th><th>Seat</th><th>Customer name</th><th>Price</th></tr>");

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
    out.println("</table>");
    // Add Cancel Ticket button
    out.println("<div class=\"cancel-button\">");
 out.println("<form action=\"CancelTicketBE\" method=\"post\">");

    out.println("<button type=\"submit\">Cancel Ticket</button>");
    out.println("</form>");
    out.println("</div>");
    out.println("</div>");

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
            Logger.getLogger(ViewticketBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewticketBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewticketBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewticketBE.class.getName()).log(Level.SEVERE, null, ex);
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
