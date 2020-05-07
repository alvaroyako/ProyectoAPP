package Controlador;

import java.io.IOException;

import Vista.ControladoraAnadirDonacion;
import Vista.ControladoraAnadirDonante;
import Vista.ControladoraDonaciones;
import Vista.ControladoraDonantes;
import Vista.ControladoraEstadisticas;
import Vista.ControladoraFormulario;
import Vista.ControladoraMenu;
import Vista.ControladoraModificarDonacion;
import Vista.ControladoraModificarDonante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {

    private static Stage stagePrincipal;
    private AnchorPane rootPane;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        Main.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();

    }

    /* En un proyecto JavaFX el main llama al launch que a su vez llama a start */
    public static void main(String[] args) {
        launch(args);
    }

    /*
     * cargamos la ventana principal
     */
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/Menu.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Menu");
            stagePrincipal.setScene(scene);
            /*
             * Añadidos las llamadas del main al Controlador y del controlador al main ***/
            ControladoraMenu controller = loader.getController();
            controller.setProgramaPrincipal(this);

            stagePrincipal.show();
        } catch (IOException e) {
            //tratar la excepción.
        }
   }


    /* Este método es llamado cuando se presiona el botón de la ventana principal
     * Lo llama el controlador de la vista principal
     */
    public void mostrarDonantes() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/PantallaDonantes.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventana = new Stage();
            ventana.setTitle("Donantes");
            /* Le decimos a la ventana quién es la ventana original */
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);

            ControladoraDonantes controller2 = loader.getController();
            controller2.setStagePrincipal(ventana);
            controller2.setProgramaPrincipal(this);

            ventana.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    
    public void mostrarDonaciones() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/PantallaDonaciones.fxml"));
            AnchorPane ventanaTres = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventana3 = new Stage();
            ventana3.setTitle("Donaciones");
            /* Le decimos a la ventana quién es la ventana original */
            ventana3.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaTres);
            ventana3.setScene(scene);

            ControladoraDonaciones controller3 = loader.getController();
            controller3.setStagePrincipal(ventana3);
            controller3.setProgramaPrincipal(this);

            ventana3.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    
    public void mostrarEstadisticas() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/Estadisticas.fxml"));
            AnchorPane ventanaCuatro = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventana4 = new Stage();
            ventana4.setTitle("Estadisticas");
            /* Le decimos a la ventana quién es la ventana original */
            ventana4.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaCuatro);
            ventana4.setScene(scene);

            ControladoraEstadisticas controller4 = loader.getController();
            controller4.setStagePrincipal(ventana4);

            ventana4.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    
    public void mostrarFormulario() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/Formulario.fxml"));
            AnchorPane ventanaForm = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventanaF = new Stage();
            ventanaF.setTitle("Formulario");
            /* Le decimos a la ventana quién es la ventana original */
            ventanaF.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaForm);
            ventanaF.setScene(scene);

            ControladoraFormulario controllerF = loader.getController();
            controllerF.setStagePrincipal(ventanaF);
            controllerF.setProgramaPrincipal(this);

            ventanaF.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    
    public void mostrarAnadirDonante() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/AnadirDonante.fxml"));
            AnchorPane ventanaDonante = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventanaD = new Stage();
            ventanaD.setTitle("Añadir Donante");
            /* Le decimos a la ventana quién es la ventana original */
            ventanaD.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDonante);
            ventanaD.setScene(scene);

            ControladoraAnadirDonante controllerAD = loader.getController();
            controllerAD.setStagePrincipal(ventanaD);
            

            ventanaD.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    
    public void mostrarModificarDonante() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/ModificarDonante.fxml"));
            AnchorPane ventanaMod = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventanaM = new Stage();
            ventanaM.setTitle("Modificar Donante");
            /* Le decimos a la ventana quién es la ventana original */
            ventanaM.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaMod);
            ventanaM.setScene(scene);

            ControladoraModificarDonante controllerM = loader.getController();
            controllerM.setStagePrincipal(ventanaM);

            ventanaM.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    
    public void mostrarAnadirDonacion() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/AnadirDonacion.fxml"));
            AnchorPane ventanaDonacion = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventanaDo = new Stage();
            ventanaDo.setTitle("Añadir Donacion");
            /* Le decimos a la ventana quién es la ventana original */
            ventanaDo.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDonacion);
            ventanaDo.setScene(scene);

            ControladoraAnadirDonacion controllerAD = loader.getController();
            controllerAD.setStagePrincipal(ventanaDo);
            

            ventanaDo.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    
    public void mostrarModDonacion() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/ModificarDonacion.fxml"));
            AnchorPane ventanaModDonacion = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventanaMDo = new Stage();
            ventanaMDo.setTitle("Modificar Donacion");
            /* Le decimos a la ventana quién es la ventana original */
            ventanaMDo.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaModDonacion);
            ventanaMDo.setScene(scene);

            ControladoraModificarDonacion controllerMD = loader.getController();
            controllerMD.setStagePrincipal(ventanaMDo);
            

            ventanaMDo.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
}

