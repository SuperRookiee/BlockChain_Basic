package core;

//코인 거래에 대한 정보를 처리
//A라는 사람이 B라는 사람에게 코인을 얼마나 보냈는지 저장하는 함수
public class Transaction {
	String sender;
	String receiver;
	int amount;

	public Transaction(String sender, String receiver, int amount) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getInformation() {
		return sender + "님이 " + receiver + "에게 " + amount + "원을 보냈습니다.";
	}

}
