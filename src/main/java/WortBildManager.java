import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Die Klasse WortBildManager speichert ein Wort und ein Bild zu diesem Wort.
 * @author Felix
 * @version 1-10-2023
 */
public class WortBildManager {
    private String wort;
    private String bildURL;

    /**
     * Konstruktor der Klasse WortBildManager.
     * @param wort
     * @param bildURL
     */
    public WortBildManager(String wort, String bildURL) throws IOException {
        setWort(wort);
        setBildURL(bildURL);
    }
    // Getter und Setter
    public String getWort() {
        return wort;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }

    public String getBildURL() {
        return bildURL;
    }

    public void setBildURL(String url) throws IllegalArgumentException, IOException {

        Image image = ImageIO.read(new URL(url));
        if(image != null){
            this.bildURL = url;
        }else{
            throw new IllegalArgumentException("URL is not an image!");
        }
    }
}
