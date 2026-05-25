/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luiznicolau
 */


public class ClienteDAO {

    public void cadastrar(Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();

        PreparedStatement comando = con.prepareStatement(
            "insert into clientes (nome, cpf, email, telefone, endereco, cidade, estado, data_nascimento, status, cep) values (?,?,?,?,?,?,?,?,?,?)"
        );

        comando.setString(1, c.getNome());
        comando.setString(2, c.getCpf());
        comando.setString(3, c.getEmail());
        comando.setString(4, c.getTelefone());
        comando.setString(5, c.getEndereco());
        comando.setString(6, c.getCidade());
        comando.setString(7, c.getEstado());
        comando.setString(8, c.getDataNascimento());
        comando.setString(9, c.getStatus());
        comando.setString(10, c.getCep());

        comando.execute();
        con.close();
    }
    
    public void deletar(Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();

        PreparedStatement comando = con.prepareStatement(
            "delete from clientes where id = ?"
        );

        comando.setInt(1, c.getId());

        comando.execute();
        con.close();
    }
    public void atualizar(Cliente c) throws ClassNotFoundException, SQLException {
    Connection con = Conexao.getConexao();

    PreparedStatement comando = con.prepareStatement(
        "update clientes set nome = ?, cpf = ?, email = ?, telefone = ?, endereco = ?, cidade = ?, estado = ?, data_nascimento = ?, status = ?, cep = ? where id = ?"
    );

    comando.setString(1, c.getNome());
    comando.setString(2, c.getCpf());
    comando.setString(3, c.getEmail());
    comando.setString(4, c.getTelefone());
    comando.setString(5, c.getEndereco());
    comando.setString(6, c.getCidade());
    comando.setString(7, c.getEstado());
    comando.setString(8, c.getDataNascimento());
    comando.setString(9, c.getStatus());
    comando.setString(10, c.getCep());
    comando.setInt(11, c.getId());

    comando.execute();
    con.close();
    }
    
    public Cliente consultarById(Cliente c) throws ClassNotFoundException, SQLException {
    Connection con = Conexao.getConexao();

    PreparedStatement comando = con.prepareStatement(
        "select * from clientes where id = ?"
    );

    comando.setInt(1, c.getId());

    ResultSet rs = comando.executeQuery();

    Cliente cli = new Cliente();

    if (rs.next()) {
        cli.setId(rs.getInt("id"));
        cli.setNome(rs.getString("nome"));
        cli.setCpf(rs.getString("cpf"));
        cli.setEmail(rs.getString("email"));
        cli.setTelefone(rs.getString("telefone"));
        cli.setEndereco(rs.getString("endereco"));
        cli.setCidade(rs.getString("cidade"));
        cli.setEstado(rs.getString("estado"));
        cli.setDataNascimento(rs.getString("data_nascimento"));
        cli.setStatus(rs.getString("status"));
        cli.setCep(rs.getString("cep"));
    }

    con.close();

    return cli;
    }
    
    public List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {
    Connection con = Conexao.getConexao();

    PreparedStatement comando = con.prepareStatement(
        "select * from clientes"
    );

    ResultSet rs = comando.executeQuery();

    List<Cliente> lcli = new ArrayList<Cliente>();

    while (rs.next()) {
        Cliente cli = new Cliente();

        cli.setId(rs.getInt("id"));
        cli.setNome(rs.getString("nome"));
        cli.setCpf(rs.getString("cpf"));
        cli.setEmail(rs.getString("email"));
        cli.setTelefone(rs.getString("telefone"));
        cli.setEndereco(rs.getString("endereco"));
        cli.setCidade(rs.getString("cidade"));
        cli.setEstado(rs.getString("estado"));
        cli.setDataNascimento(rs.getString("data_nascimento"));
        cli.setStatus(rs.getString("status"));
        cli.setCep(rs.getString("cep"));

        lcli.add(cli);
    }

    con.close();

    return lcli;
    
    }
}