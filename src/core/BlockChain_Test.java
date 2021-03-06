package core;

import util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/*
public class BlockChain_Test {
    public static void main(String[] args) {
//		one();
//		two();
//		three();
//		four();
//		five();
//		six();
    }

    public static void one() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Key 입력 : ");
        System.out.println(Util.getHash( sc.next() ));	//Util패키지의 getHash함수 실행
    }

    public static void two() {
        int nonce = 0;
        while(true) {
            if(Util.getHash(nonce + "").substring(0,6).equals("000000")) {	//앞의 여섯자리가 모두 0인 경우의 수 == (1/2^24) == 천만번 이상
                System.out.println("정답: " + nonce);
                System.out.println("해시 값: " + Util.getHash(nonce + ""));
                break;
            }
            nonce++;
        }
    }

    public static void three() {
        // data -> Transaction
//		Block block1 = new Block (1, null, 0, "데이터");					//블록 번호:1 , nonce:0
//		block1.mine();
//		block1.getInformation();
//
//		Block block2 = new Block (2, block1.getBlockHash(), 0, "데이터");	//블록 번호:2 , nonce:0
//		block2.mine();
//		block2.getInformation();
//
//		Block block3 = new Block (3, block2.getBlockHash(), 0, "데이터");	//블록 번호:3 , nonce:0
//		block3.mine();
//		block3.getInformation();
//
//		Block block4 = new Block (4, block3.getBlockHash(), 0, "데이터");	//블록 번호:4 , nonce:0
//		block4.mine();
//		block4.getInformation();
    }

    public static void four() {
        Transaction transaction = new Transaction("고현욱", "김수진", 15);
        System.out.println(transaction.getInformation());
    }

    public static void five() {
        Block block1 = new Block (1, null, 0, new ArrayList());
        block1.mine();
        block1.getInformation();

        Block block2 = new Block (2, block1.getBlockHash(), 0, new ArrayList());
        block2.addTransaction(new Transaction("고현욱", "김수진", 15));
        block2.addTransaction(new Transaction("마크애니", "김수진", 07));
        block2.mine();
        block2.getInformation();

        Block block3 = new Block (3, block2.getBlockHash(), 0, new ArrayList());
        block3.addTransaction(new Transaction("최수현", "김찬호", 82));
        block3.addTransaction(new Transaction("김수진", "고현욱", 4));
//		block3.addTransaction(new Transaction("김수진", "고현욱", 99));	//고현욱을 해커로 가정했을 때 block3이후의 Hash값이 바뀜
        block3.mine();
        block3.getInformation();

        Block block4 = new Block (4, block3.getBlockHash(), 0, new ArrayList());
        block4.addTransaction(new Transaction("김찬호", "최수현", 1));
        block4.mine();
        block4.getInformation();

    }

    public static void six() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./resources/Data_Origin.txt"));
        String str;
        ArrayList<String> key = new ArrayList<>();
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
            key.add(str);
        }
        reader.close();

        System.out.println("\n<List>");
        int n = key.size();	//블록 갯수 (n+1)
        Block[] block = new Block[n+1];
        for (int i=1; i <block.length; i++){
            if(i==1){
                block[i] = new Block (i, null, 0, new ArrayList());
                block[i].addTransaction(new Transaction(key.get(i-1).split(" ")[0], key.get(i-1).split(" ")[1],Integer.parseInt(key.get(i-1).split(" ")[2])));
                block[i].mine();
                block[i].getInformation();
            }
            else{
                block[i] = new Block (i, block[i-1].getBlockHash(), 0, new ArrayList());
                block[i].addTransaction(new Transaction(key.get(i-1).split(" ")[0], key.get(i-1).split(" ")[1],Integer.parseInt(key.get(i-1).split(" ")[2])));
                block[i].mine();
                block[i].getInformation();
            }

        }
    }
}

*/