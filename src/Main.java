import cr.ac.cenfotec.rojas.jandier.TL.Controller;

import java.io.IOException;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.start();
    }
}
