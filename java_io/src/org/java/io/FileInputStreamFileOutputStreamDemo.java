package org.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件输入输出字节流示例
 * 
 * @author VIC
 *
 */
public class FileInputStreamFileOutputStreamDemo {
	
	public static void main(String[] args) {
		
		//使用文件输入输出流复制文件
		copyFile();
		// 使用文件输出流向文件中写入数据内容
		//writerFile();
		// 使用文件输入流从文件中读取数据内容
		//readFile();
		// 使用文件输入流从大文件中读取数据内容
		//readBigFile();
	}

	/**
	 * 使用FileInputStream FileOutputStream复制文件
	 */
	private static void copyFile() {
		System.out.println("开始复制文件.");
		// 1. 定义文件对象
		File sourceFile = new File("img0.jpg"); // 定义源文件(输入文件)
		File targetFile = new File("newimg.jpg");// 定义目标文件(输出文件)
		
		InputStream inputStream = null;
		OutputStream outputStream = null; 
		try{
		// 2. 定义文件输入输出流对象
		inputStream = new FileInputStream(sourceFile);
		outputStream = new FileOutputStream(targetFile);
		// 3. 复制文件
		// 循环从文件输入流中每次读取10个字节到缓冲字节数据中,然后写入到文件输出流中
		byte[] buf = new byte[10];
		int flag = -1;
		while ((flag = inputStream.read(buf)) != -1) {
			outputStream.write(buf, 0, flag);
			outputStream.flush();// 刷新字节到文件
		}
		System.out.println("复制文件完成.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭输入输出流
			try {
				if(null != outputStream){
					outputStream.close();
				}
				if(null != inputStream){
					inputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 使用FileOutputStream向文件中写入数据内容
	 */
	private static void writerFile() {
		// 1. 定义写入数据的文件
		File targetFile = new File("data.txt");
		FileOutputStream fileOutputStream = null;
		try {
			// 2. 创建文件输出流对象
			fileOutputStream = new FileOutputStream(targetFile,true);
			// 3. 写入数据
			fileOutputStream.write("\r\n使用FileInputStream读取文件,学习Java有前途.".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭文件输出流
			try {
				if(null != fileOutputStream){
					fileOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void readBigFile() {
		// 1. 定义文件对象
		File sourceFile =  new File("bigdata.txt");
		InputStream fileInputStream = null;
		try{
		// 2. 创建文件输入流对象
		fileInputStream = new FileInputStream(sourceFile);
		// 3. 读取文件内容(循环读取)
		byte[] buf = new byte[27];// 从输入流中读取字节数据并返回位置(如果没有字节数据或字节数据读取完则返回-1)
		int flag = -1;// 记录当前字节去取位置
		while ((flag = fileInputStream.read(buf)) != -1) {
			System.out.println("字节内容: " + new String(buf));
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭输入流
			try {
				if(null != fileInputStream){
					 fileInputStream.close();
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 使用FileInputStream读取文件
	 * @throws Exception 
	 */
	private static void readFile() {
		
		// 1. 定义文件对象
		File sourceFile = new File("data.txt");
		FileInputStream fileInputStream = null;
		try{
		// 2. 创建文件输入流对象
		fileInputStream = new FileInputStream(sourceFile); 
		// 3. 读取文件内容
		byte[] buf = new byte[1024];//声明一个字节数组用于存储从输入流中读取的字节
		int flag = fileInputStream.read(buf);// 从输入流中读取字节数据并返回位置(如果没有字节数据或字节数据读取完则返回-1)
		System.out.println("字节内容: " + new String(buf));
		System.out.println("读取状态: " + flag);
		flag = fileInputStream.read(buf);
		System.out.println("二次读取状态: " + flag);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭输入流
			try {
				if(null != fileInputStream){
					 fileInputStream.close();
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
