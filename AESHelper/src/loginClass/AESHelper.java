package loginClass;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESHelper {
	
    /**
     * 加密
     * @param content 被加密的内容
     * @param secret 密钥
     * @return 加密后的内容
     * @throws Exception
     */
    public static String encrypt(String content, String secret) throws Exception {
        if (secret == null) {
            System.out.print("密钥为空");
            return null;
        }
        // 判断Key是否为16位
        if (secret.length() != 16) {
            System.out.print("密钥长度不是16位");
            return null;
        }
        byte[] raw = secret.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(content.getBytes("utf-8"));
 
        return parseByte2HexStr(encrypted);
    }
 
    /**
     * 解密
     * @param content 已加密的内容
     * @param secret 密钥
     * @return 解密后的内容
     * @throws Exception
     */
    public static String decrypt(String content, String secret) throws Exception {
        try {
            // 判断Key是否正确
            if (secret == null) {
                System.out.print("密钥为空");
                return null;
            }
            // 判断Key是否为16位
            if (secret.length() != 16) {
                System.out.print("密钥长度不是16位");
                return null;
            }
            byte[] raw = secret.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = parseHexStr2Byte(content);//
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    /**
	 * 将字节数组转换成16进制字符串
	 * @param buf 字节数组
	 * @return 16进制字符串
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}
	
	/**
	 * 将16进制转换为字节数组
	 * @param hexStr 16进制字符串
	 * @return 字节数组
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
   /* public static void main(String[] args) throws Exception {
        
         //* 此处使用AES-128-ECB加密模式，key需要为16位。
         
    	String content = "2018-03-11 20:15:40|hgt|hgt"; 
		String secret = "iotcommiotcommio"; 
        System.out.println(content);
        // 加密
        String enString = AESHelper.encrypt(content, secret);
        System.out.println("加密后的字串是：" + enString);
 
        // 解密
        String DeString = AESHelper.decrypt(enString, secret);
        System.out.println("解密后的字串是：" + DeString);
    }
*/
	
}