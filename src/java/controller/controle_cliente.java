/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author luiznicolau
 */
@WebServlet(name = "controle_cliente", urlPatterns = {"/controle_cliente"})
public class controle_cliente extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
           

            String op = request.getParameter("op");
            ClienteDAO cdao = new ClienteDAO();
            Cliente c = new Cliente();

            if (op.equals("CADASTRAR")) {
                
                String nome = request.getParameter("txtnome");
                String cpf = request.getParameter("txtcpf");
                String email = request.getParameter("txtemail");
                String telefone = request.getParameter("txttelefone");
                String endereco = request.getParameter("txtendereco");
                String cidade = request.getParameter("txtcidade");
                String estado = request.getParameter("txtestado");
                String dataNascimento = request.getParameter("txtdataNascimento");
                String status = request.getParameter("txtstatus");
                String cep = request.getParameter("txtcep");

                c.setNome(nome);
                c.setCpf(cpf);
                c.setEmail(email);
                c.setTelefone(telefone);
                c.setEndereco(endereco);
                c.setCidade(cidade);
                c.setEstado(estado);
                c.setDataNascimento(dataNascimento);
                c.setStatus(status);
                c.setCep(cep);

                String msg = "Cadastrar";

                try {
                    cdao.cadastrar(c);
                    System.out.println("Cadastrado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            } else if (op.equals("DELETAR")) {
                
                int id = Integer.parseInt(request.getParameter("txtid"));
                c.setId(id);

                String msg = "Deletar";

                try {
                    cdao.deletar(c);
                    List<Cliente> lcli = cdao.consultarTodos();
                    request.setAttribute("lcli", lcli);
                    request.getRequestDispatcher("resultadoconsultartodoscliente.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            } else if (op.equals("CONSULTAR PELO ID")) {
                
                int id = Integer.parseInt(request.getParameter("txtid"));
                c.setId(id);

                try {
                    c = cdao.consultarById(c);
                    request.setAttribute("c", c);
                    request.getRequestDispatcher("resultadoconsultarbyidcliente.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }

            } else if (op.equals("CONSULTAR TODOS")) {
                
                try {
                    List<Cliente> lcli = cdao.consultarTodos();
                    request.setAttribute("lcli", lcli);
                    request.getRequestDispatcher("resultadoconsultartodoscliente.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }

            } else if (op.equals("ATUALIZAR")) {
                
                int id = Integer.parseInt(request.getParameter("txtid"));
                c.setId(id);

                try {
                    c = cdao.consultarById(c);
                    request.setAttribute("c", c);
                    request.getRequestDispatcher("resultadoconsultaratualizarcliente.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }

            } else if (op.equals("EFETIVAR ATUALIZAÇÃO")) {
                
                int id = Integer.parseInt(request.getParameter("txtid"));
                String nome = request.getParameter("txtnome");
                String cpf = request.getParameter("txtcpf");
                String email = request.getParameter("txtemail");
                String telefone = request.getParameter("txttelefone");
                String endereco = request.getParameter("txtendereco");
                String cidade = request.getParameter("txtcidade");
                String estado = request.getParameter("txtestado");
                String dataNascimento = request.getParameter("txtdataNascimento");
                String status = request.getParameter("txtstatus");
                String cep = request.getParameter("txtcep");

                c.setId(id);
                c.setNome(nome);
                c.setCpf(cpf);
                c.setEmail(email);
                c.setTelefone(telefone);
                c.setEndereco(endereco);
                c.setCidade(cidade);
                c.setEstado(estado);
                c.setDataNascimento(dataNascimento);
                c.setStatus(status);
                c.setCep(cep);

                String msg = "Atualizar";

                try {
                    cdao.atualizar(c);
                    System.out.println("Atualizado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controle Cliente";
    }// </editor-fold>

}