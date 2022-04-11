import javax.swing.FocusManager;
import java.awt.*;

public class Main {
    public static void main(String args[]) {
        int x = 1;
        while (x != 2) {
            String activeWindow = FocusManager.getCurrentManager().getActiveWindow().getName();

            if (!activeWindow.contains("Watch") || !activeWindow.contains("Dogs") || !activeWindow.contains("2"))
                return;
        }
    }
}
