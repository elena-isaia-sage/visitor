import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        GenericBlock plants = new GenericBlock("plants");

        GenericBlock flowers = new GenericBlock("flowers");

        GenericItem rose = new GenericItem("rose", "rose");
        rose.setAttribute("color", "red");
        rose.setAttribute("size", "medium");
        flowers.addItem(rose);

        GenericItem tulip = new GenericItem("tulip", "tulip");
        tulip.setAttribute("color", "orange");
        tulip.setAttribute("size", "medium");
        flowers.addItem(tulip);

        GenericItem sunflower = new GenericItem("sunflower", "sunflower");
        sunflower.setAttribute("color", "yellow");
        sunflower.setAttribute("size", "medium");
        flowers.addItem(sunflower);

        GenericItem snowdrop = new GenericItem("snowdrop", "snowdrop");
        snowdrop.setAttribute("color", "white");
        snowdrop.setAttribute("size", "small");
        flowers.addItem(snowdrop);

        plants.addItem(flowers);

        GenericBlock trees = new GenericBlock("trees");

        GenericItem fir = new GenericItem("fir", "fir");
        fir.setAttribute("color", "dark green");
        fir.setAttribute("size", "big");
        trees.addItem(fir);

        GenericItem spruce = new GenericItem("spruce", "spruce");
        spruce.setAttribute("color", "dark green");
        spruce.setAttribute("size", "big");
        trees.addItem(spruce);

        GenericItem willow = new GenericItem("willow", "willow");
        willow.setAttribute("color", "light green");
        willow.setAttribute("size", "big");
        trees.addItem(willow);

        GenericItem thuja = new GenericItem("thuja", "thuja");
        thuja.setAttribute("color", "dark green");
        thuja.setAttribute("size", "medium");
        trees.addItem(thuja);

        plants.addItem(trees);

        GenericItem grass = new GenericItem("grass", "grass");
        grass.setAttribute("color", "green");
        grass.setAttribute("size", "small");

        plants.addItem(grass);

        Visitor visitor = new XmlVisitor();
        plants.accept(visitor);
        System.out.println(visitor.toString());

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("plants.xml"));
            writer.write(visitor.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: couldn't create the file!\n" + e.getMessage());
        }
    }
}