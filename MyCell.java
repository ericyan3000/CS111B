// 1. Any live cell will die in the next generation
// 2. Any dead cell with more than 2 live adjecent cell will be alive in the next generation


public class MyCell extends AbstractCell {
  
  public MyCell (int r, int c, ConwayWorld w) {
    super(r, c, w);
  }

  public boolean willBeAliveInNextGeneration() {
    int nc = neighborCount();
    
    if (getIsAlive()) {
      return false;
    } else {
      return nc >= 2;
    }
  }

  public AbstractCell cellForNextGeneration() {
    MyCell next = new MyCell(getRow(), getColumn(), world);
    next.setIsAlive(willBeAliveInNextGeneration());
    
    return next;
  }

  public int neighborCount() {
    int count = 0;
    
    int row = getRow();
    int column = getColumn();
    
    for (int dr = -1; dr <= 1; dr++) {
      for (int dc = -1; dc <= 1; dc++) {
        if (world.isAlive(row + dr, column + dc) && !(dr == 0 && dc == 0)) {
          count++;
        }
      }
    }
    
    return count;
  }
}