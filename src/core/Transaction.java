package core;

import util.Util;

import java.security.PrivateKey;
import java.security.PublicKey;

//코인 거래에 대한 정보를 처리
//A라는 사람이 B라는 사람에게 코인을 얼마나 보냈는지 저장하는 함수
public class Transaction {
	public String Str;


    public Transaction(String str) {
        Str = str;
    }

    public String getInformation() {
		return Str;
	}
}
