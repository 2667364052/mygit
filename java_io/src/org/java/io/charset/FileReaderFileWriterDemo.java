package org.java.io.charset;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * 字符文件输入输出流示例: 主要用于操作字符文件
 * 
 * @author VIC
 *
 */
public class FileReaderFileWriterDemo {
	
	public static void main(String[] args) {
		// 读取字符文件
		readerCharFile();
		// 写入字符文件
		//writerCharFile();
	}

	/**
	 * 写入字符文件
	 */
	private static void writerCharFile() {
		FileWriter fileWriter = null;
		try {
			// 1. 创建字符文件输出流对象
			fileWriter = new FileWriter("data.txt",true);
			// 2. 将字符写入文件
			fileWriter.write(",天天写代码");
			System.out.println("写入字符文件完成.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 3. 关闭流
			try {
				if(null != fileWriter){
					fileWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取字符文件
	 */
	private static void readerCharFile() {
		// 1. 创建字符输入流对象
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("data.txt");
			// 2. 读取文件内容
//			char ch = (char)fileReader.read();//从字符文件输入流中每次读取一个字符
//			System.out.println("读取字符: " + ch);
			char[] cbuf = new char[10];
			int flag = fileReader.read(cbuf);
			System.out.println("读取字符数组: " + Arrays.toString(cbuf));
			System.out.println("当前读取位置: " + flag);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭流
			try {
				if(null != fileReader){
					fileReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
