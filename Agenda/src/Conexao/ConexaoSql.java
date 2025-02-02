package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class ConexaoSql {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3360/agenda_db";
    private final String USER = "root";
    private final String PASS = "admin";

    private Connection conn;
    
    public ConexaoSql() throws ClassNotFoundException, SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(false);
            //System.out.println("Conexão criada com SGBD com sucesso!");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ClassNotFoundException("O Driver não foi localizado e adicionado. Talvez a biblioteca JDBC não foi adicionada ao projeto.\n" + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Deu erro na conexão com a fonte de dados.\n" + e.getMessage());
        }
    }

    public Connection getConexao() {
        return conn;
    }

    public void confirmar() throws SQLException {
        try {
            conn.commit();
        } catch (SQLException e) {

            throw new SQLException("Não foi possível executar o comando SQL.\n" + e.getMessage());
            
            
        } finally {

            conn.close();
        }
    }
}
