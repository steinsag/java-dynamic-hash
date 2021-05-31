package de.hpfsc.java.dynamichash;

import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) {
        final String message = "Hello World!";
        System.out.println(getHash(message, 64));
        System.out.println(getHash(message, 30));
        System.out.println(getHash(message, 20));
    }

    static String getHash(final String message, final int lengthInCharacters) {
        if (lengthInCharacters % 2 != 0 || lengthInCharacters <= 0) {
            throw new IllegalArgumentException("lengthInCharacters must be an even positive number");
        }

        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("message shall not be blank");
        }

        final byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);

        final SHAKEDigest digest = new SHAKEDigest(128);

        final byte[] hashBytes = new byte[lengthInCharacters / 2];
        digest.update(messageBytes, 0, messageBytes.length);
        digest.doOutput(hashBytes, 0, hashBytes.length);

        return Hex.toHexString(hashBytes);
    }
}
