package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory(){
        //Criando um pool de conexões
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("bd@Lucas95");

        comboPooledDataSource.setMaxPoolSize(10);

        //atribuindo o pool de conexões ao DataSource
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperaConexao(){
        //recuperando conecão já aberta pelo pool
        try{
            return this.dataSource.getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
