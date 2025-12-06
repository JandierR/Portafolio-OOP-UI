package cr.ac.cenfotec.rojas.jandier.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The type Ui.
 */
public class UI {
    private BufferedReader in;

    /**
     * Instantiates a new Ui.
     */
    public UI() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Imprimir mensaje ln.
     *
     * @param mensaje the mensaje
     */
    public void imprimirMensajeLn(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Imprimir mensaje.
     *
     * @param mensaje the mensaje
     */
    public void imprimirMensaje(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Leer opcion int.
     *
     * @return the int
     * @throws IOException the io exception
     */
    public int leerOpcion() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    /**
     * Leer texto string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public String leerTexto() throws IOException {
        return in.readLine();
    }

    /**
     * Imprimir menu.
     */
    public void imprimirMenu() {
        imprimirMensajeLn("-".repeat(50));
        imprimirMensajeLn("""
                    Elija una opción:
                    -1. Mostrar productos de la tienda
                    -2. Agregar producto a mi carrito
                    -3. Eliminar producto de mi carrito
                    -4. Mostrar contenido de mi carrito
                    -5. Pagar productos e imprimir factura
                    -0. Salir""");
        imprimirMensajeLn("-".repeat(50));
    }
}
