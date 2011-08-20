package javatar;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.GeneralSecurityException;

/**
 * 
 * Generates the MD5 hash of a String (trimmed and lowercased)
 *
 */

public final class Hash {
	
	private static MessageDigest md;
	
	/**
	 * 
	 * @param text The String to generate the MD5 hash for
	 * @return String representation of the md5
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public static String generate(String text) throws GeneralSecurityException, UnsupportedEncodingException {
		String str = text.trim().toLowerCase();
		md = MessageDigest.getInstance("MD5");
		
		byte[] digest = md.digest(str.getBytes("UTF-8"));
		
		return returnHex(digest);
	}
	
	
	private static String returnHex(byte[] inBytes) {
        String hexString = "";
        for (int i=0; i < inBytes.length; i++) { 
            hexString +=
            Integer.toString( ( inBytes[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
    
        return hexString;
  }

}
