package br.ufu.facom.persim.config;


/*
 * Este gerador de caminhos eh um singleton;
 */
public class Path {

    private static Path instance;
    private String imagePath;
    private String audioPath;
    private String databasePath;

    private Path() {
        String udir = System.getProperty("user.dir");       //diretorio da app.
        String fsep = System.getProperty("file.separator"); //separador de diretorios do SO de uso

        this.imagePath = udir + fsep + "images" + fsep;
        this.audioPath = udir + fsep + "audios" + fsep;
        this.databasePath = udir + fsep + "database" + fsep;
    }

    private static Path getInstance() {
        if (instance == null) {
            instance = new Path();
        }
        return instance;
    }

    public static String getImagePath(String filename) {
        return Path.getInstance().imagePath + filename;
    }

    public static String getAudioPath(String filename) {
        return Path.getInstance().audioPath + filename;
    }

    public static String getDatabasePath(String filename) {
        return Path.getInstance().databasePath + filename;
    }
}
