package util;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Util {

	public static String getHash(String input) { //어떤 입력값이 들어왔을때 Hash값을 구해주는 함수
		StringBuffer result = new StringBuffer();	//문자열 생성하는 객체
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");	//암호화 같은경우 MessageDigest를 자주 이용
			md.update(input.getBytes());								//사용자가 입력하는 Byte값을 가져와서 업데이트 (SHA-256로 해시시키기 위한 준비)
			byte bytes[] = md.digest();									//해시 결과값을 digest함수를 이용해서 byte스트림으로 받아옴
			for(int i=0; i<bytes.length; i++) {
				result.append(
						Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)	//문자열 형태로 변환
				);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static String getStringFromKey(Key key) {
		return Base64.getEncoder().encodeToString(key.getEncoded());
	}



}
