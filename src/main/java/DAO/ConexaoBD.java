package DAO;

import Model.Rua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static String status = "N�o conectou...";

    private Connection connection;

    public Connection getConexaoMySQL() {


        try {

            // Carregando o JDBC Driver padr�o

            String driverName = "org.mariadb.jdbc.Driver";

            Class.forName(driverName);

            String url = "jdbc:mariadb://c9cujduvu830eexs.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/drohro3nltd4slqs";
            String user = "bgk5jw196n05j02u";
            String password = "euja2x58otnh9p4a";

            String jawsdbURL = "mysql://bgk5jw196n05j02u:euja2x58otnh9p4a@c9cujduvu830eexs.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/drohro3nltd4slqs";


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

    public String statusConection() {

        return status;

    }

    public boolean FecharConexao() {

        try {

            this.connection.close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }


}
