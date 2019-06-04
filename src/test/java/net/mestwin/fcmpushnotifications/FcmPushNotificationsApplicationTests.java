package net.mestwin.fcmpushnotifications;

import com.google.firebase.FirebaseApp;
import net.mestwin.fcmpushnotifications.controller.PushNotificationController;
import net.mestwin.fcmpushnotifications.firebase.FCMClient;
import net.mestwin.fcmpushnotifications.firebase.FCMInitializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.MockInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FcmPushNotificationsApplicationTests {

	@Mock
	FCMInitializer fcmInitializer;

	@Mock
	FCMClient fcmClient;

	@Test
	public void contextLoads() {
	}


	@Test
	public void firebaseAppInitializationTest() {
		fcmInitializer.initialize();
		System.out.println(FirebaseApp.getApps());
		assertFalse(FirebaseApp.getApps().isEmpty());
	}

	@Test
	public void sendTestMessage() {
		Map<String, String> pushData = new HashMap<>();
		try {
			fcmClient.sendTest(pushData);
		} catch(Exception e) {
			fail();
		}
	}

}
