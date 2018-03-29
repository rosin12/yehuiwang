package zxtest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
public class HMACSHAHelper {
private static final String HMAC_SHA1 = "HmacSHA1";
/**
*生成签名数据
*
* @param data待加密的数据  这里为  api_key
* @param key加密使用的    key这里为     secret_key
* @return生成十六进制字符串
* @throws InvalidKeyException
* @throws NoSuchAlgorithmException
*/
	public static String getSHA1Signature(byte[] data, byte[] key) throws 
										InvalidKeyException, NoSuchAlgorithmException {
		SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);
		Mac mac = Mac.getInstance(HMAC_SHA1);
		mac.init(signingKey);
		byte[] rawHmac = mac.doFinal(data);
		return CommonUtil.bytesToHexString(rawHmac);
		}
	public static void main(String[] args) {
		String api_key="de3edf6c7da94f04ab00191b5dd66b12";
		String secret_key="c6b89bb7094940b495331882d6dcfaa4";
		try {
			System.out.println(getSHA1Signature(api_key.getBytes(), secret_key.getBytes()));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

