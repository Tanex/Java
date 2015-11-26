package dataobjects;

public class HexGrid {
   /* //private int[][] grid;
    private int width;
    private int height;

    public HexGrid(int width, int height){
        this.width = width;
        this.height = height;
        //grid = new int[this.width][this.height];
    }*/

    public static void calcGridValues(int width, int height, int hex){
        System.out.printf("\t\t%d\n", hex + 1);
        System.out.printf("\t%d\t\t%d\n", hex - height + (hex/height) % 2, hex + height + (hex/height) % 2);
        System.out.printf("\t\t%d\n", hex);
        System.out.printf("\t%d\t\t%d\n", hex - height - 1 + (hex/height) % 2, hex + height - 1 + (hex/height) % 2);
        System.out.printf("\t\t%d\n", hex - 1);
    }
}
