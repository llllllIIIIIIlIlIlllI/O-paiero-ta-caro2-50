import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int x;
            try {
                x = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                continue;
            }
            if (x == 0) break;
            if (x % 2 != 0) x++;
            int sum = x + (x + 2) + (x + 4) + (x + 6) + (x + 8);
            System.out.println(sum);
        }
    }
}