
package Aplication;

public class App {
    public static void main(String[] args) {
        PresentationI.View v1 = new PresentationI.View();
        PresentationI.Model m1 = new PresentationI.Model();
        PresentationI.Control c1 = new PresentationI.Control(v1,m1);
        v1.setVisible(true);
    }
    
}
