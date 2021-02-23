package test.GGDrive;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow.Builder;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Quickstart {
    private static final String APPLICATION_NAME = "Drive API Java Quickstart";
    private static final File DATA_STORE_DIR = new File(System.getProperty("user.home"), ".credentials/2/drive-java-quickstart.json");
    private static FileDataStoreFactory DATA_STORE_FACTORY;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static final List<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/drive");

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable var1) {
            var1.printStackTrace();
            System.exit(1);
        }

    }

    public Quickstart() {
    }

    public static Credential authorize() throws IOException {
        InputStream in = Quickstart.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        GoogleAuthorizationCodeFlow flow = (new Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
        Credential credential = (new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())).authorize("user");
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    public static Drive getDriveService() throws IOException {
        Credential credential = authorize();
        return (new com.google.api.services.drive.Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)).setApplicationName("Drive API Java Quickstart").build();
    }
}
