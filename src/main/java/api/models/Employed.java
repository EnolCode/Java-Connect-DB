package api.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import api.repositories.mysql.MysqlConnexion;

public class Employed {
    private Long id;
    private String name;
    private String surname;
    private String typeRequest;
    private String descripcion;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTypeRequest() {
        return typeRequest;
    }

    public void setTypeRequest(String typeRequest) {
        this.typeRequest = typeRequest;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    MysqlConnexion repository = new MysqlConnexion();
    String table =  "requests";
    public Employed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // @Override
    // public String toString() { // Esto vale para poder imprimir en terminal
    //     return "employed [id=" + id + ", name=" + name + "]";
    // }

        

    public List<Employed>index() { // Este metodo nos devuevle todos los empleados

        try {
            Statement statement = repository.conn.createStatement(); // Con esta linea y la creaccion de arriba tengo acceso a la conexion
            String sql = String.format("SELECT * FROM %s", table); // Le mandamos a la base d edatos esta consulta
            ResultSet rs = statement.executeQuery(sql); // Hacemos una consulta sql, aqui ya tenemos las filas

            List<Employed> employeds = new ArrayList<>();

            while(rs.next()) { // Un bucle que si hay siguiente elemento haga algo
                this.id = rs.getLong("id");
                this.name = rs.getString("nameEmployed");
                this.surname = rs.getString("surname");
                this.typeRequest = rs.getString("typeRequest");
                this.descripcion = rs.getString("descripcion");
                employeds.add(this);
            }

            System.out.println(employeds);
            return employeds;

        } catch (Exception ex) {
            System.out.println("Exception" + ex.getMessage());
            return null;
        }
    
    }

    @Override
    public String toString() {
        return "Employed [id=" + id + ", name=" + name + ", surname=" + surname + ", typeRequest=" + typeRequest
                + ", descripcion=" + descripcion + ", repository=" + repository + ", table=" + table + "]";
    }
}
