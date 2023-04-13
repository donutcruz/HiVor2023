import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class LesaInnTextaskra {

    public static void main(String[] args) {
        String urlWarAndPeace = "https://introcs.cs.princeton.edu/java/data/war+peace.txt";
        String urlTaleOfTwoCities = "https://introcs.cs.princeton.edu/java/data/tale.txt";
        ArrayList<String> warAndPeaceWords = new ArrayList<>();
        ArrayList<String> taleOfTwoCitiesWords = new ArrayList<>();

        try {
            // Lesa inn "war+peace.txt"
            URL warAndPeaceUrl = new URL(urlWarAndPeace);
            HttpURLConnection warAndPeaceConnection = (HttpURLConnection) warAndPeaceUrl.openConnection();
            warAndPeaceConnection.setRequestMethod("GET");

            BufferedReader warAndPeaceReader = new BufferedReader(new InputStreamReader(warAndPeaceConnection.getInputStream()));
            String warAndPeaceLine = warAndPeaceReader.readLine();
            while (warAndPeaceLine != null) {
                String[] warAndPeaceLineWords = warAndPeaceLine.split(" ");
                Collections.addAll(warAndPeaceWords, warAndPeaceLineWords);
                warAndPeaceLine = warAndPeaceReader.readLine();
            }
            warAndPeaceReader.close();

            // Lesa inn "tale.txt"
            URL taleOfTwoCitiesUrl = new URL(urlTaleOfTwoCities);
            HttpURLConnection taleOfTwoCitiesConnection = (HttpURLConnection) taleOfTwoCitiesUrl.openConnection();
            taleOfTwoCitiesConnection.setRequestMethod("GET");

            BufferedReader taleOfTwoCitiesReader = new BufferedReader(new InputStreamReader(taleOfTwoCitiesConnection.getInputStream()));
            String taleOfTwoCitiesLine = taleOfTwoCitiesReader.readLine();
            while (taleOfTwoCitiesLine != null) {
                String[] taleOfTwoCitiesLineWords = taleOfTwoCitiesLine.split(" ");
                Collections.addAll(taleOfTwoCitiesWords, taleOfTwoCitiesLineWords);
                taleOfTwoCitiesLine = taleOfTwoCitiesReader.readLine();
            }
            taleOfTwoCitiesReader.close();
        } catch (IOException ex) {
            System.out.println("Villa við að lesa skrá frá URL: " + ex.getMessage());
        }

        System.out.println("Fjöldi orða í skránni " + urlWarAndPeace + ": " + warAndPeaceWords.size());
        System.out.println("Fjöldi orða í skránni " + urlTaleOfTwoCities + ": " + taleOfTwoCitiesWords.size());
    }

}
