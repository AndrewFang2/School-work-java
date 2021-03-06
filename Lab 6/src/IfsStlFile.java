import ifs.AffineTransform;
import ifs.IfsCreator;
import stl.Solid;
import stl.StlImage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program is printout the program
 * @author Andrew
 * @version 2020-03-28
 */
public class IfsStlFile {
//main class
    public static void main(String[] arg) throws FileNotFoundException {
        PrintWriter printWriter = null;
        Solid solid = null;
        Scanner input = new Scanner(System.in);

        IfsCreator ifscreator = new IfsCreator();
        AffineTransform[] transform =ifscreator.getTransfrom();
        int choice = 0;
        System.out.println("Available fractal images are:\n" +
                "1 Barnsley Fern\n" +
                "2 Maple Leaf\n" +
                "3 Sierpinski Gasket\n" +
                "4 Golden Dragon\n" +
                "What image number do you want? ");
                choice=input.nextInt();
        if(choice > 4 || choice < 0){
            System.out.println("invalid choice");
        }
        else {
            StlImage stl = new StlImage(0.8, 4.0);
            solid = stl.createSolid(ifscreator.generateIfs(transform[choice - 1]));

        }
        try {
            printWriter = new PrintWriter("C:\\temp2020\\"+ transform[choice-1].getName() +".stl");
            solid.print(printWriter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
        printWriter.close();
        input.close();
    }
}
