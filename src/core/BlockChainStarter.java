package core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ReadFile;
import util.SQL;

public class BlockChainStarter {	//블록체인이 실질적으로 동작하는 메인함수가 포함되어있는 함수
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		Origin_BlockChain();
		Hacked_BlockChain();
		Check();
	}//main ends

	public static void Origin_BlockChain() throws IOException, SQLException, ClassNotFoundException {
		boolean Auth = true;
		ArrayList<String> key = ReadFile.read("Origin"); //Data_Origin.txt

		System.out.println("\n<List>");
		int n = key.size();	//블록 갯수 (n+1)
		Block[] block = new Block[n+1];
		Connection conn = SQL.getConnection(); //DB연결
		for (int i=1; i <block.length; i++){
			if(i==1){
				block[i] = new Block (i, null, 0, new ArrayList());
				block[i].addTransaction(new Transaction(key.get(i-1)));
				block[i].mine();
				block[i].getInformation();
				SQL.init(conn, Auth);
				block[i].Record(Auth);
			}
			else{
				block[i] = new Block (i, block[i-1].getBlockHash(), 0, new ArrayList());
				block[i].addTransaction(new Transaction(key.get(i-1)));
				block[i].mine();
				block[i].getInformation();
				block[i].Record(Auth);
			}

		}
	}

	public static void Hacked_BlockChain() throws IOException, SQLException, ClassNotFoundException {
		boolean Auth = false;
		ArrayList<String> key = ReadFile.read("Hack");	//Data_Hack.txt

		System.out.println("\n<List>");
		int n = key.size();	//블록 갯수 (n+1)
		Block[] block = new Block[n+1];
		Connection conn = SQL.getConnection(); //DB연결
		for (int i=1; i <block.length; i++){
			if(i==1){
				block[i] = new Block (i, null, 0, new ArrayList());
				block[i].addTransaction(new Transaction(key.get(i-1)));
				block[i].mine();
				block[i].getInformation();
				SQL.init(conn, Auth);
				block[i].Record(Auth);
			}
			else{
				block[i] = new Block (i, block[i-1].getBlockHash(), 0, new ArrayList());
				block[i].addTransaction(new Transaction(key.get(i-1)));
				block[i].mine();
				block[i].getInformation();
				block[i].Record(Auth);
			}

		}
	}

	public static void Check() throws SQLException, ClassNotFoundException {
		Connection conn = SQL.getConnection();
		int state = SQL.compare(conn);
		System.out.println("\n[Check]");
		if(state == 0){
			System.out.println("변경된 데이터는 없습니다");
		}
		else {
			System.out.println(state + "번 Block에 변경된 데이터가 존재합니다");
		}

	}



}
