public class Main {

    public static void main(String[] args) {
//        Grid grid = new Grid(9);
//
//        grid.setCellValue(0, 5, 5);
//        grid.setCellValue(8, 8, 1);
//
//        // test erase
//        grid.setCellValue(2, 3, 0);
//        grid.setCellValue(2, 3, 0);
//
//        // whole square
//        grid.setCellValue(3, 3, 1);
//        grid.setCellValue(4, 3, 2);
//        grid.setCellValue(5, 3, 3);
//        grid.setCellValue(3, 4, 4);
//        grid.setCellValue(4, 4, 5);
//        grid.setCellValue(5, 4, 6);
//        grid.setCellValue(3, 5, 7);
//        grid.setCellValue(4, 5, 8);
//        grid.setCellValue(5, 5, 9);
//
//        try {
//            grid.display();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Grid grid16 = new Grid(16);

        grid16.setCellValue(12, 0, 11);

        try {
            grid16.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
