package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class zz {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
PrintWriter pw = new PrintWriter(System.out);
		
		String str = "Hello";
		
		pw.print(str);
		pw.println();  // 줄바꿈
		pw.println(str);
		pw.printf("%.2f", Math.PI);   // Math.PI : 3.141592...
		
		pw.flush();  // 메모리 내부의 잔류 바이트 버퍼를 비움
		pw.close();  // flush + close
		
		
//		PrintWriter pw1 = new PrintWriter("test2.txt");
//		
//		for(int i=0; i<=10; i++) {
//			String data = i+ " Test2입니다.";
//			pw1.println(data);
//			
//		}
//		pw1.close();
		
//		
//		// 추가모드로 파일에 데이터 추가
//		// PrintWriter는 추가모드가 없음 => 파일 객체로 생성해서 추가
//		PrintWriter pw2 = new PrintWriter(new FileWriter("test2.txt", true));
//		
//		for(int i=11; i<=20; i++) {
//			String data = i+ " Test2입니다.";
//			pw2.println(data);
//		}
//		pw2.append('+');
//		pw2.append("Hello");
//		pw2.close();
	}

}
