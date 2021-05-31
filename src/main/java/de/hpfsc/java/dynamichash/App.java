package de.hpfsc.java.dynamichash;

import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) {
        System.out.println(getHash("Hello World!"));
    }

    static String getHash(final String message) {
        final byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);

        final SHAKEDigest digest = new SHAKEDigest(128);

        final byte[] hashBytes = new byte[15];
        digest.update(messageBytes, 0, messageBytes.length);
        digest.doFinal(hashBytes, 0, hashBytes.length);

        return Hex.toHexString(hashBytes);
    }
}
