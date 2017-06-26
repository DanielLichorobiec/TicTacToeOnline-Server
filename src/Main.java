
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Thread t = new Server(6666);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
