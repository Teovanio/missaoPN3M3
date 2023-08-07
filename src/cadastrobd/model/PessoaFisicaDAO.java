package cadastrobd.model;

import cadastrobd.model.util.ConectorBD;
import java.util.ArrayList;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Usuario
 */
public class PessoaFisicaDAO {

    ConectorBD cnx = new ConectorBD();

    public PessoaFisica getPessoa(Integer id) throws SQLException {
        ResultSet rs = cnx.getSelect("select\n"
                + "	Pessoa_Fisica.idPessoa_Fisica as id,\n"
                + "	Pessoa_Fisica.cpf,\n"
                + "	p.nome,\n"
                + "	p.logradouro,\n"
                + "	p.cidade,\n"
                + "	p.estado,\n"
                + "	p.telefone,\n"
                + "	p.email\n"
                + "from Pessoa_Fisica\n"
                + "INNER JOIN Pessoa as p on Pessoa_Fisica.idPessoa_Fisica = p.id_Pessoa WHERE idPessoa_Fisica = " + id.toString());

        rs.next();
        PessoaFisica p = new PessoaFisica(
                rs.getString("cpf"),
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("logradouro"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("telefone"),
                rs.getString("email")
        );
        cnx.close();
        return p;
    }

    public ArrayList<PessoaFisica> getPessoas() throws SQLException {

        ArrayList<PessoaFisica> listaPessoaF = new ArrayList<PessoaFisica>();
        ResultSet rs = cnx.getSelect("select\n"
                + "	Pessoa_Fisica.idPessoa_Fisica as id,\n"
                + "	Pessoa_Fisica.cpf,\n"
                + "	p.nome,\n"
                + "	p.logradouro,\n"
                + "	p.cidade,\n"
                + "	p.estado,\n"
                + "	p.telefone,\n"
                + "	p.email\n"
                + "from Pessoa_Fisica\n"
                + "INNER JOIN Pessoa as p on Pessoa_Fisica.idPessoa_Fisica = p.id_Pessoa;");
        while (rs.next()) {
            PessoaFisica p = new PessoaFisica(
                    rs.getString("cpf"),
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("logradouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email")
            );
            listaPessoaF.add(p);
        }

        return listaPessoaF;
    }

    public void incluir(PessoaFisica p) throws SQLException {
        String sqlInsertPessoa = String.format(
            "insert into pessoa ( nome, logradouro, cidade, estado, telefone, email ) values (  '%s', '%s', '%s', '%s', '%s',  '%s' );",
            p.getNome(),  p.getLogradouro(), p.getCidade(),  p.getEstado(), p.getTelefone(), p.getEmail());
            System.out.println(sqlInsertPessoa);

        int idNovaPessoa =  cnx.insert(sqlInsertPessoa); 
        if(idNovaPessoa == 0) {
            System.out.println("Erro ao criar pessoa");
        } else {
            String sqlInsertPessoaFisica = String.format("insert into Pessoa_Fisica ( idPessoa_Fisica, cpf, idPessoa ) values (NEXT VALUE FOR CodigoPessoa, '%s', %s);",
             p.getCpf(), idNovaPessoa);
            //System.out.println(sqlInsertPessoaFisica);
            cnx.insert(sqlInsertPessoaFisica); 
        }

    }

    public void alterar(PessoaFisica novaPessoa) {

    }

    public void excluir(Pessoa p) {

    }
}
