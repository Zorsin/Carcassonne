package ui;

import javafx.scene.image.Image;

import java.io.File;
import java.util.HashMap;

/**
 * @author Micha Heiß
 */
public class Images {

    HashMap<String, Image> images;

    public Images(String folder){
        // TODO load images dynamically
//        System.out.println((Images.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"images/").substring(1));
//        File f = new File(Images.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//        File[] list = f.listFiles();
//
//        for (File file : list) {
//            images.put(file.getName().substring(0, file.getName().length()-3), new Image(file.getPath()));
//        }

        // Hashmap erzeugt Nullpointer
//        images.put("A", new Image("images/A.png"));
//        images.put("D", new Image("images/D.png"));
    }

    public Image getImage(String d) {
        return new Image("images/D.png");
        //return images.getOrDefault(d, new Image("images/D.png"));
        //return images.get(d);
    }
}
