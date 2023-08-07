/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd;

import java.sql.*;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CadastroBDTeste {

    public static void main(String[] args) throws SQLException {
        PessoaFisicaDAO PFisicaDao = new PessoaFisicaDAO();
        
        //Instanciar uma pessoa física e persistir no banco de dados.
        PessoaFisica PessoaF = new PessoaFisica("99911122200", null, "Joselito da Silveira",
                "Rua Americano do Brasil", "Campinas", "SP", "1137968555", "josesilva@jose.com.br");
        PFisicaDao.incluir(PessoaF);

        //Instanciar uma pessoa física e persistir no banco de dados.
        /*PessoaFisica PessoaF = new PessoaFisica("00011122299", 1, "Jose da Silva",
                "Rua Americano do Brasil", "Campinas", "SP", "1137968555", "josesilva@jose.com.br");
        PFisicaDao.incluir(PessoaF);

        //Alterar os dados da pessoa física no banco.
        PessoaF.setEmail("jose.silva@jose.com");
        PFisicaDao.alterar(PessoaF);

        //Consultar todas as pessoas físicas do banco de dados e listar no console.
        ArrayList<PessoaFisica> resultadoP = PFisicaDao.getPessoas();
        resultadoP.forEach(item -> item.exibir());

        //Excluir a pessoa física criada anteriormente no banco.
        PFisicaDao.excluir(PessoaF);
        
        PessoaJuridicaDAO PJuridicaDao = new PessoaJuridicaDAO();

        //Instanciar uma pessoa jurídica e persistir no banco de dados.
        PessoaJuridica PessoaJ = new PessoaJuridica("00111222000199", 1, "Jose Enterprise ltda", "Avenida Paulista n950",
                "São Paulo", "SP", "1140552525", "jose@jose.com");
        PJuridicaDao.incluir(PessoaJ);
        
        //Alterar os dados da pessoa jurídica no banco.
        PessoaJ.setLogradouro("Avenida Paulista, Itaimbibi nº 1985");
        PJuridicaDao.alterar(PessoaJ);
        
        //Consultar todas as pessoas jurídicas do banco e listar no console.
        ArrayList<PessoaJuridica> resultadoJ = PJuridicaDao.getPessoas();
        resultadoJ.forEach(item -> item.exibir());
        
        //Excluir a pessoa jurídica criada anteriormente no banco.
        PJuridicaDao.excluir(PessoaJ);
        */
        
        
    }
}
