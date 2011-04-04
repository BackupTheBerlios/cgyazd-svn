package slowconvexhull;
import java.awt.*;
import java.awt.event.*;

class Grids extends Canvas {
  int width, height, rows, columns;

  Grids(int w, int h, int r, int c) {
    setSize(width = w, height = h);
    rows = r;
    columns = c;
  }
    public void paint(Graphics g) {
    int k;
    width = getSize().width;
    height = getSize().height;

    int htOfRow = height / (rows);
    for (k = 0; k < rows; k++){
            g.setColor( Color.LIGHT_GRAY );
        if(k==rows/2){
            g.setColor( Color.BLACK );
            g.drawLine(0, k * htOfRow , width+10, k * htOfRow );
            continue;
        }

      g.drawLine(0, k * htOfRow , width, k * htOfRow );

    }

    int wdOfRow = width / (columns);
    for (k = 0; k < columns; k++){
        g.setColor( Color.LIGHT_GRAY );
        if(k==rows/2){
            g.setColor( Color.BLACK );
            g.drawLine(0, k * htOfRow , width+10, k * htOfRow );
            continue;
        }
      g.drawLine(k*wdOfRow , 0, k*wdOfRow , height);}

  }
}
public class grid extends Frame {
  grid(String title, int w, int h, int rows, int columns) {
    setTitle(title);
    Grids grid = new Grids(w, h, rows, columns);
    add(grid);
}
  public void setPoint(){
      
  }
public static void main(String[] args) {
    new grid("Draw Grids", 300, 200, 20, 20).setVisible(true);
  }
}