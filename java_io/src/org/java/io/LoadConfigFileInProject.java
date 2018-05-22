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
			// 获取Main类同一个包路径下的资源文件
//			InputStream inputStream = Main.class.getResourceAsStream("account.data");
			// 获取源代码src路径下的资源文件
			InputStream inputStream = LoadConfigFileInProject.class.getResourceAsStream("account.data");
			System.out.println("inputStream: " + inputStream);
			// 将字节流转换成字符流缓冲流输出
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			System.out.println(bufferedReader.readLine());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
