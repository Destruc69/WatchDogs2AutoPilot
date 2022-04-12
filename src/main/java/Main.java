import utils.TimerUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;

public class Main extends KeyAdapter {

    public static void main(String args[]) throws AWTException {
        double centerX = 928;
        double centerY = 545;

        Robot robot = new Robot();

        if (isCenterArrow()) {
            robot.keyPress('w');
            robot.keyRelease('s');
        } else {
            robot.keyRelease('w');
            robot.keyPress('s');
        }

        if (arrowX() > centerX && arrowY() > centerY) {
            robot.keyPress('d');
        } else {
            robot.keyRelease('d');
        }
        if (arrowX() < centerX && arrowY() < centerY) {
            robot.keyPress('a');
        } else {
            robot.keyRelease('a');
        }
    }

    private static boolean isCenterArrow() throws AWTException {
        Robot robot = new Robot();

        double red = 47;
        double green = 163;
        double blue = 204;

        Color pixel = robot.getPixelColor(928, 545);

        return pixel.getRed() == red && pixel.getGreen() == green && pixel.getBlue() == blue;
    }

    private static int arrowX() throws AWTException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);

        double red = 47;
        double green = 163;
        double blue = 204;

        for (int x = -image.getWidth(); x <= image.getWidth(); x++) {
            for (int y = -image.getHeight(); y <= image.getHeight(); y++) {
                Color color = robot.getPixelColor(x, y);

                if (color.getRed() == red && color.getGreen() == green && color.getBlue() == blue) {
                    return x;
                }
            }
        }
        return 0;
    }

    private static int arrowY() throws AWTException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);

        double red = 47;
        double green = 163;
        double blue = 204;

        for (int x = -image.getWidth(); x <= image.getWidth(); x++) {
            for (int y = -image.getHeight(); y <= image.getHeight(); y++) {
                Color color = robot.getPixelColor(x, y);

                if (color.getRed() == red && color.getGreen() == green && color.getBlue() == blue) {
                    return y;
                }
            }
        }
        return 0;
    }
}