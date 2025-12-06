package cr.ac.cenfotec.rojas.jandier.TL;

import cr.ac.cenfotec.rojas.jandier.UI.UI;
import cr.ac.cenfotec.rojas.jandier.bl.entities.Producto;
import cr.ac.cenfotec.rojas.jandier.bl.logic.GestionCarrito;
import cr.ac.cenfotec.rojas.jandier.bl.logic.GestionStockTienda;
import cr.ac.cenfotec.rojas.jandier.dl.Data;

import java.io.IOException;

/**
 * The type Controller.
 */
public class Controller {
    private UI interfaz = new UI();
    private Data data = new Data();
    private GestionStockTienda gestionStockTienda = new GestionStockTienda(data);
    private GestionCarrito carrito = new GestionCarrito(data, gestionStockTienda);


    /**
     * Instantiates a new Controller.
     */
    public Controller() {
    }

    /**
     * Start.
     *
     * @throws IOException the io exception
     */
    public void start() throws IOException {
        int opcion;

        do {
            interfaz.imprimirMenu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);

        } while (opcion != 0);
    }

    /**
     * Procesar opcion.
     *
     * @param opcion the opcion
     * @throws IOException the io exception
     */
    public void procesarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1 -> mostrarStock();
            case 2 -> elegirProducto();
            case 3 -> devolverProducto();
            case 4 -> imprimirCarrito();
            case 5 -> imprimirFactura();
            case 0 -> interfaz.imprimirMensajeLn("Saliendo del programa...");
        }
    }


    /**
     * Mostrar stock.
     */
    public void mostrarStock() {
        for (Producto producto : data.getProductosStock()) {
            interfaz.imprimirMensajeLn("[" + producto.getNombre() + " (#" + producto.getId() + ")] cantidad -> " + producto.getCantidad() + " -> precio -> $" + producto.getPrecio());
        }
    }

    /**
     * Imprimir carrito.
     */
    public void imprimirCarrito() {

        //Tengo que buscar una manera de agregar la cantidad de tal producto en mi carrito
//        System.out.println("Productos de mi carrito -->");
        interfaz.imprimirMensajeLn("Productos de mi carrito -->");
        for (Producto producto : data.getMiCarrito()) {
            if (producto.tieneDescuento()) {
                interfaz.imprimirMensajeLn("Producto: " + producto.getNombre() + " --> Precio: $" + producto.getPrecio() + " (Se aplican descuentos al producto)");
            } else {
                interfaz.imprimirMensajeLn("Producto: " + producto.getNombre() + " --> Precio: $" + producto.getPrecio());
            }

        }
    }

    /**
     * Imprimir factura.
     */
    public void imprimirFactura() {
        if (data.getMiCarrito().isEmpty()) {
            interfaz.imprimirMensajeLn("El carrito está vacío. No se puede generar factura.");
            return;
        }

        interfaz.imprimirMensajeLn("-".repeat(35));
        interfaz.imprimirMensajeLn("---Factura---");
        interfaz.imprimirMensajeLn("-".repeat(35));
        imprimirCarrito();
        interfaz.imprimirMensajeLn("-".repeat(35));
        interfaz.imprimirMensajeLn(("Total --> " + gestionStockTienda.escanearProductos()));
        interfaz.imprimirMensajeLn("-".repeat(35));
    }

    /**
     * Elegir producto.
     *
     * @throws IOException the io exception
     */
    public void elegirProducto() throws IOException {

        interfaz.imprimirMensajeLn("Ingrese el ID del producto que desea agregar: ");
        int id = Integer.parseInt(interfaz.leerTexto());

        Producto producto = gestionStockTienda.buscarProducto(id);

        interfaz.imprimirMensajeLn(carrito.agregarProducto(producto, id));
    }

    /**
     * Devolver producto.
     *
     * @throws IOException the io exception
     */
    public void devolverProducto() throws IOException {

        //Se solicita al usuario el ID del producto
        interfaz.imprimirMensajeLn("Ingrese el ID del producto dentro de su carrito que desea eliminar: ");

        //Se lee el ID del producto ingresado por el usuario y se almacena en la variable id
        int id = Integer.parseInt(interfaz.leerTexto());

        //Se obtiene una referencia al producto con el producto que retorna la metodo de buscarProductoId(id)
        //Con el anterior id como argumento
        Producto producto = gestionStockTienda.buscarProducto(id);

        interfaz.imprimirMensajeLn(carrito.eliminarProducto(producto, id));

    }
}
