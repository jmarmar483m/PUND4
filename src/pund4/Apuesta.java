
package pund4;
/**
 * 
 * @author Juan Martinez
 */

public class Apuesta {
/**
 * Devuelve los goles del equipo local
 * @return cantidad de goles marcados por el equipo local.
 */
   
    public int getGoles_local() {
        return goles_local;
    }
/**
 * Adjudica el numero de goles que ha marcado el equipo local
 * @param goles_local cantidad de goles marcados por el equipo local.
 */
    
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }
/**
 * Devuelve los goles del equipo visitante
 * @return cantidad de goles marcados por el equipo visitante.
 */
   
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
 * Adjudica el numero de goles que ha marcado el equipo visitante
 * @param goles_visitante cantidad de goles marcados por el equipo visitante.
 */
    
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

/**
 * 
 * @return cuanto se ha apostado
 */    
    public int getApostado() {
        return apostado;
    }
/**
 *  
 * @param apostado cuanto se ha apostado
 */
    
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    protected int dinero_disp;
    protected int goles_local;
    protected int goles_visitante;
    protected int apostado;

    /*Contructor por defecto*/
    /**
     * Constructor por defecto sin parametros
     */
    public Apuesta() {
    }

    /*Contructor con parámetros*/
    /**
     * Constructor con parametros 
     * @param dinero_disp dinero disponible
     * @param goles_local goles del equipo local
     * @param goles_visitante  goles del equipo visitante
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    /*Método para obtener el valor del atributo dinero_disp*/

    /**
     *  Devuelve el dinero disonible
     * @return dinsero disponible
     */
    public int getDinero_disp() {
        return dinero_disp;
    }
    /*Método para modificar el valor del atributo dinero_disp*/

    /**
     *  adjudica una cantidad de dinero disponible
     * @param dinero_disp  dinero disponible
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /*Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     */
    /**
     * Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     * @param dinero dinero que se apuesta
     * @throws Exception en caso de que la cantiad sea inferior a 1 o al dinero disponible
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
    /*Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * 
     */
    
    /**
     * Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true.
     * Chequea que no se metan menos de 0 goles
     * @param local goles locales
     * @param visitante goles visitante
     * @return si se ha acertado o no el resultado del partido
     * @throws Exception en caso de que se introduzcan menos de 0 goles
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
    /* Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     */
    /**
     *  Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     * @param cantidad_goles_local goles del equipo local
     * @param cantidad_goles_visit goles del equipo visitante
     * @throws Exception  en caso de no poder cobrar la apuesta
     */

    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}