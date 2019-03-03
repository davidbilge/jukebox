package de.davidbilge.jukebox.nfc;

import com.diozero.devices.MFRC522;
import com.diozero.devices.MFRC522.UID;
import org.junit.jupiter.api.Test;

public class Mfrc522BasicConnectionCheckTest {

    @Test
    public void testSetup() {
        MFRC522 mfrc522 = new MFRC522(0,1);

        mfrc522.init();

        if (mfrc522.isNewCardPresent()) {
            UID uid = mfrc522.readCardSerial();
            System.out.println("Found card with serial " + uid);
        }
    }

}
