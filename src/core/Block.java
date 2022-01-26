package core;

import java.util.ArrayList;

import util.Util;

public class Block {

	private int blockId;
	private String previousBlockHash;
	private int nonce;
	//	private String data;
	private ArrayList<Transaction> transactionList;	//모든 트랜잭션을 담는 ArrayList 생성


	//현재 블록을 Hash화
	//트랜잭션의 정보가 바뀐다면 Hash값 전체가 변경 됨
	//특정한 블록의 Hash값을 구할 때, 해당블록에 포함되어있는 모든 트랜잭션을 포함하도록 만듬
	public String getBlockHash() {
		String transactionInformations = "";
		for(int i=0; i<transactionList.size(); i++) {
			transactionInformations += transactionList.get(i).getInformation();
		}
		return Util.getHash(nonce + transactionInformations + previousBlockHash);
	}


	//새로운 트랜잭션이 발생했을 때 그 트랜잭션을 해당 블록에 넣는 함수
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}

	//채굴을 수행
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 4).equals("0000")) {	//앞에서부터 0이 4자리이면 채굴에 성공했다고 판단
				System.out.println(blockId + "번째 블록의 채굴에 성공했습니다.");
				break;
			}
			nonce++; //채굴에 실패 했다면 nonce값 +1
		}
	}

	//출력
	public void getInformation() {
		System.out.println("--------------------------------------");
		System.out.println("블록 번호: " + getBlockId());
		System.out.println("이전 해시: " + getPreviousBlockHash());
		System.out.println("채굴 변수 값: " + getNonce());
		System.out.println("트랜잭션 개수: " + transactionList.size() + "개");
		for(int i=0; i<transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getInformation());
		}
		System.out.println("블록 해시: " + getBlockHash());
		System.out.println("--------------------------------------");

	}



	//생성자
	public Block(int blockId, String previousBlockHash, int nonce, ArrayList transactionList) {
		super();
		this.blockId = blockId;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.transactionList = transactionList;
	}

	//Getter & Setter
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}


}
