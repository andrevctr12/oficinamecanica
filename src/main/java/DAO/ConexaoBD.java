package DAO;

import Model.Rua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static String status = "N�o conectou...";

    private static Connection connection;

    public static Connection getConexaoMySQL() {


        try {

            // Carregando o JDBC Driver padr�o

            String driverName = "org.mariadb.jdbc.Driver";

            Class.forName(driverName);

            String url = "jdbc:mariadb://localhost:3306/oficina?";
            String user = "root";
            String password = "";


            connection = DriverManager.getConnection(url, user, password);




            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->N�o foi possivel realizar conex�o");

            }


            return connection;


        } catch (ClassNotFoundException e) {  //Driver n�o encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;
        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }
    }

    public static String statusConection() {

        return status;

    }

    public static boolean FecharConexao() {

        try {

            ConexaoBD.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }


}
