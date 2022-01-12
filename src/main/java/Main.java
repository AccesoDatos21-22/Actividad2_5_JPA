import Entidades.Vuelo;

import javax.persistence.EntityManager;
import java.util.Date;

public class Main {

    static EntityManager man ;

    /**
     * Metodo para actualizar un autor
     *
     * @param vuelo
     */
    public static void creaActualizaVuelo(Vuelo vuelo) {
        // Conseguimos un objeto EntityManager para comunicarnos con la BD
        // abrimos una transaccion
        man.getTransaction().begin();
        // Actualizamos
        man.persist(vuelo);
        // Commit de la transaccion
        man.getTransaction().commit();


    }

    /**
     * Metodo para recuperar un vuelo
     *
     * @param id
     * @return
     */
    public static Vuelo recuperaVuelo(int id) {
        // Conseguimos un objeto EntityManager para comunicarnos con la BD
        Vuelo vuelo = new Vuelo();

        // abrimos una transaccion
        man.getTransaction().begin();
        // Recuperamos el seguro
        vuelo = man.find(Vuelo.class, id);
        // Commit de la transaccion
        man.getTransaction().commit();

        man.close();

        return vuelo;
    }

    public static void main(String[] args) {
        man = Utilidades.getEntityManagerFactory().createEntityManager();

        Vuelo vue = new Vuelo();

        Vuelo vueR;

        vue.setHoraSalida(new Date());
        char[] codigo={'A','0','2','3',};
        vue.setCodigo(codigo);
        vue.setLongitud(5);
        vue.setNumero(333);
        vue.setTexto("Vuelo de prueba");
        vue.setTipo(Vuelo.TipoVuelo.ASIA);



        creaActualizaVuelo(vue);
        // Hibernate sincroniza el estado del objeto para que tenga el id
        // autogenerado de BD
        System.out.println("Vuelo almacenado:" + vue.getId());
        vueR = recuperaVuelo(vue.getId());
        System.out.println("Vuelo recuperado:" + vueR.toString());

        man.close();

        // Cerramos la factoria de sesiones, sino el programa no finalizar
        Utilidades.getEntityManagerFactory().close();
    }

}
