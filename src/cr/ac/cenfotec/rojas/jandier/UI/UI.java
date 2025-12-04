package cr.ac.cenfotec.rojas.jandier.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    private BufferedReader in;

    public UI() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void imprimirMensajeLn(String mensaje) {
        System.out.println(mensaje);
    }
    public void imprimirMensaje(String mensaje) {
        System.out.print(mensaje);
    }

    public int leerOpcion() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public String leerTexto() throws IOException {
        return in.readLine();
    }

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
