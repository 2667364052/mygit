package org.java.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class LoadConfigFileInProject {
	
	public static void main(String[] args) {
		loadConfigFile();
	}
	
	private static void loadConfigFile() {
		try{
			// ��ȡMain��ͬһ����·���µ���Դ�ļ�
//			InputStream inputStream = Main.class.getResourceAsStream("account.data");
			// ��ȡԴ����src·���µ���Դ�ļ�
			InputStream inputStream = LoadConfigFileInProject.class.getResourceAsStream("account.data");
			System.out.println("inputStream: " + inputStream);
			// ���ֽ���ת�����ַ������������
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			System.out.println(bufferedReader.readLine());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
