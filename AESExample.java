import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Scanner;


public class AESExample {
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
        
}
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the plane text: ");
        String plaintext = sc.nextLine(); // Plaintext to be encrypted
       
        // Generate a 128-bit AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit AES key
        SecretKey secretKey = keyGen.generateKey();

        // Create cipher object and initialize with the key
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

        // Print the encrypted data
        System.out.println("Encrypted: " + bytesToHex(encryptedBytes));

        // Initialize the cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decrypt the encrypted data
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Print the decrypted plaintext
        System.out.println("Decrypted: " + new String(decryptedBytes));
        sc.close();
    }
    
}
