package org.java.io.charset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符缓冲输入输出流: 主要用于提高操作字符的效率
 * 
 * @author VIC
 *
 */
public class BufferedReaderBufferedWriterDemo {
	
	public static void main(String[] args) {
		//使用缓冲字符输入流读取文件内容
		//readerBufferChar();
		//使用缓冲字符输出流写入文件内容
		writerBufferChar();
		
	}

	/**
	 * 使用缓冲字符输出流写入文件内容
	 */
	private static void writerBufferChar() {
		// 1. 定义写入文件
		File sourceFiel = new File("bigdata.txt");
		BufferedWriter bufferedWriter = null;
		try{
		// 2. 创建字符输出缓冲流
			bufferedWriter = new BufferedWriter(new FileWriter(sourceFiel, true));
		// 3. 写字符到文件
			bufferedWriter.newLine();//写入一个换行符
			bufferedWriter.write("好好学习,晚上吃鸡.");
			bufferedWriter.newLine();//写入一个换行符
			bufferedWriter.write("恭喜发财", 0, 2);
			System.out.println("写入字符文件完成.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭流	
			try {
				if(null != bufferedWriter){
					bufferedWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 使用缓冲字符输入流读取文件内容
	 */
	private static void readerBufferChar() {
		// 1. 定义源文件
		File sourceFiel = new File("bigdata.txt");
		BufferedReader bufferedReader = null;
		try {
			// 2. 创建字符缓冲输入流
			bufferedReader = new BufferedReader(new FileReader(sourceFiel));
			// 3. 从缓冲输入流中读取数据
			// ready()判断是否可以开始读取
			while (bufferedReader.ready()) {
				// 每次读取一行字符
				//System.out.println(bufferedReader.readLine());
				
				// 创建一个字符数组用于存储流中读取出来的字符
				char[] cbuf = new char[20];
				// 从流中读取15个字符
				bufferedReader.read(cbuf, 0, 15);
				System.out.println(new String(cbuf));
			}
			System.out.println("读取字符文件完成.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭流
			try {
				if(null != bufferedReader){
					bufferedReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
