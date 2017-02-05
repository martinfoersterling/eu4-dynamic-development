import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * Deployed den Mod ins lokale mod Verzeichnis.
 */
public class Deployer {

    private static final String MOD_VERZEICHNIS = "C:\\Users\\Martin\\Documents\\Paradox Interactive\\Europa Universalis IV\\mod";

    public static void main(String[] args) throws IOException {

        //alten mod löschen
        Files.deleteIfExists(Paths.get(MOD_VERZEICHNIS, "mafoe-dyde.mod"));
        Path modDirectory = Paths.get(MOD_VERZEICHNIS, "mafoe-dyde");
        FileUtils.deleteDirectory(new File(MOD_VERZEICHNIS, "mafoe-dyde"));

        //neuen mod kopieren
        FileUtils.copyFile(new File("./src/main/resources/mafoe-dyde.mod"), new File(MOD_VERZEICHNIS, "mafoe-dyde.mod"));
        FileUtils.copyDirectory(new File("./src/main/resources/mod"), new File(MOD_VERZEICHNIS, "mafoe-dyde"));
    }
}
