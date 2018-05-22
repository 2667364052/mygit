package org.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 字节输入输出缓存流示例
 * 
 * @author VIC
 *
 */
public class BuffredInputStreamBufferOutputStreamDemo {
	
	
	public static void main(String[] args) {
		
		// 使用缓冲输入输出流复制文件
		//copyBuffredFile();
		// 使用输入输出流复制文件
		copyFile();
	}

	private static void copyBuffredFile() {
		
		long startTime = System.currentTimeMillis();// 获取当前时间毫秒数
		// 1. 定义文件对象
		File sourceFile = new File("Java从入门到精通（第3版）.rar");
		File targetFile = new File("copy_Java从入门到精通（第3版）.rar");
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try{
		// 2. 创建文件输入输出流对象
		fileInputStream = new FileInputStream(sourceFile);
		fileOutputStream = new FileOutputStream(targetFile);
		// 3. 创建文件缓冲输入输出流对象
		bufferedInputStream = new BufferedInputStream(fileInputStream);
		bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		// 4. 复制文件
		int flag = -1;
		while ((flag = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(flag);
			bufferedOutputStream.flush();
		}
		long endTime = System.currentTimeMillis();// 获取当前时间毫秒数
		System.out.println("复制文件完成，耗时: " + (endTime - startTime));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. 关闭输入输出流	
			try {
				if(null != bufferedOutputStream){
					bufferedOutputStream.close();
				}
				if(null != bufferedInputStream){
					bufferedInputStream.close();
				}
				if(null != fileOutputStream){
					fileOutputStream.close();
				}
				if(null != fileInputStream){
					fileInputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void copyFile() {
		
		long startTime = System.currentTimeMillis();// 获取当前时间毫秒数
		// 1. 定义文件对象
		File sourceFile = new File("Java从入门到精通（第3版）.rar");
		File targetFile = new File("copy_Java从入门到精通（第3版）.rar");
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
//		BufferedInputStream bufferedInputStream = null;
//		BufferedOutputStream bufferedOutputStream = null;
		try{
		// 2. 创建文件输入输出流对象
		fileInputStream = new FileInputStream(sourceFile);
		fileOutputStream = new FileOutputStream(targetFile);
		// 3. 创建文件缓冲输入输出流对象
//		bufferedInputStream = new BufferedInputStream(fileInputStream);
//		bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		// 4. 复制文件
		int flag = -1;
//		while ((flag = bufferedInputStream.read()) != -1) {
//			bufferedOutputStream.write(flag);
//			bufferedOutputStream.flush();
//		}
		while ((flag = fileInputStream.read()) != -1) {
			fileOutputStream.write(flag);
			fileOutputStream.flush();
	}
		long endTime = System.currentTimeMillis();// 获取当前时间毫秒数
		System.out.println("复制文件完成，耗时: " + (endTime - startTime));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. 关闭输入输出流	
			try {
//				if(null != bufferedOutputStream){
//					bufferedOutputStream.close();
//				}
//				if(null != bufferedInputStream){
//					bufferedInputStream.close();
//				}
				if(null != fileOutputStream){
					fileOutputStream.close();
				}
				if(null != fileInputStream){
					fileInputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
