package test;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.services.drive.Drive;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.UserCredentials;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;
import com.google.photos.types.proto.Album;
import org.apache.commons.fileupload.FileItem;
import org.apache.http.auth.Credentials;
import org.testng.annotations.Test;

import test.GGDrive.APIphoto;
import test.GGDrive.Quickstart;

import java.io.*;
import java.net.URI;
import java.util.logging.Logger;


public class googlephoto {

    @Test
    public static void taoabum() throws IOException {
        InputStream stream = new FileInputStream("C:\\Users\\Admin\\Desktop\\shop\\test\\src\\main\\resources\\client_secret.json");
       AccessToken token =new AccessToken(APIphoto.auth_uri,null);
        UserCredentials credentials = UserCredentials.newBuilder()
          .setClientId(APIphoto.client_id)
                .setClientSecret(APIphoto.client_secret)
                .setTokenServerUri(APIphoto.tokenServer)
                .setRefreshToken(APIphoto.auth_provider_x509_cert_url)
            .build();
        PhotosLibrarySettings settings =
                PhotosLibrarySettings.newBuilder()
                        .setCredentialsProvider(
                                FixedCredentialsProvider.create(credentials))
                        .build();
        try {
            PhotosLibraryClient client =PhotosLibraryClient.initialize(settings);
            Album album =client.createAlbum("haha");
            String id = album.getId();
        }catch (ApiException  e){


        }

    }


}
