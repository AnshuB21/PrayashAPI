package com.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class FirebaseApplication{
public static void main(String[] args) throws IOException {
	//Given by firebase while building connection
	ClassLoader classloader =  FirebaseApplication.class.getClassLoader();
	File file = new File(Objects.requireNonNull(classloader.getResource("serviceAccountKey.json")).getFile());
	FileInputStream serviceAccount= new FileInputStream(file.getAbsolutePath());



	FirebaseOptions options = new FirebaseOptions.Builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.build();

	FirebaseApp.initializeApp(options);


	SpringApplication.run(FirebaseApplication.class, args);
	}

}
