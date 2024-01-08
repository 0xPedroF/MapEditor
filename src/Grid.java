import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Grid implements KeyboardHandler{
    private int col;
    private int row;
    private Rectangle window;
    private int cellSize;
    private final int PADDING=10;
    private GridPosition[][] layout;
    boolean spaceActive = false;

    public Grid(int colNum, int rowNum, int cellSize) {

        this.cellSize = cellSize;
        layout = new GridPosition[colNum][rowNum]; // maybe to save data?
    }

    public void brushPaint(){
        /** Draw at the window's position */
        int x = window.getX() + cellSize / 2; // Calculate the center of the window
        int y = window.getY() + cellSize / 2;
        Rectangle paint = new Rectangle(x, y, 7, 7); // Create paint spot
        paint.setColor(Color.RED);
        paint.fill();
    }



    public void init() {

        /** Grid constructor */
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                Rectangle cell = new Rectangle(PADDING + i * cellSize, PADDING + j * cellSize, cellSize, cellSize);
                //cell.setColor(Color.BLACK);
                cell.draw();
            }
        }

        /** Brush constructor */
            window = new Rectangle(PADDING, PADDING, cellSize, cellSize);
            window.setColor(Color.BLUE);
            window.fill();

        /** Keyboard inputs for brush */
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent leftArrow = new KeyboardEvent();
        leftArrow.setKey(KeyboardEvent.KEY_LEFT);
        leftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightArrow = new KeyboardEvent();

        rightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent upArrow = new KeyboardEvent();
        upArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upArrow.setKey(KeyboardEvent.KEY_UP);


        KeyboardEvent downArrow = new KeyboardEvent();
        downArrow.setKey(KeyboardEvent.KEY_DOWN);
        downArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            // Add keyboard events to the keyboard
        keyboard.addEventListener(leftArrow);
        keyboard.addEventListener(rightArrow);
        keyboard.addEventListener(upArrow);
        keyboard.addEventListener(downArrow);
        keyboard.addEventListener(space);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            window.translate(-cellSize, 0);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            window.translate(cellSize, 0);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            window.translate(0, -cellSize);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            window.translate(0, cellSize);
        }
        if(keyboardEvent.getKey()== KeyboardEvent.KEY_SPACE){
                spaceActive = !spaceActive;

        }


        if(spaceActive==true) {
            brushPaint();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}





