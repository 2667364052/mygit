package org.java.io.charset;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机文件读写操作类
 * @author VIC
 *
 */
public class RandomAccessFileDemo {
	
	public static void main(String[] args) {
		
		// 随机读取写入内容到文件
		//readwriterContent();
		// 随机插入内容到文件中
		insertContent();
		
	}

	private static void insertContent() {
		
		RandomAccessFile randomAccessFile = null;
		BufferedOutputStream bufferedOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		try {
			// 1. 创建随机操作文件对象
			randomAccessFile = new RandomAccessFile("random.data", "rw");
			
			// 2. 创建临时文件对象
			File tmpFile = File.createTempFile("tmp", null);
			tmpFile.deleteOnExit();// 程序结束后自动删除临时文件
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tmpFile));
			bufferedInputStream = new BufferedInputStream(new FileInputStream(tmpFile));
			
			// 3. 将插入位置后的内容放入临时文件
			randomAccessFile.seek(22);// 将光标移动到插入位置
			// 读取插入位置后面的内容到临时文件
			byte[] buf = new byte[24];
			int flag = -1;
			while ((flag = randomAccessFile.read(buf)) != -1) {
				bufferedOutputStream.write(buf, 0, flag);
				bufferedOutputStream.flush();
			}
			
			// 4. 插入新内容
			randomAccessFile.seek(22);// 将光标移动到插入位置
			randomAccessFile.write("\n广州易唐科技".getBytes());
			
			// 5. 将临时文件内的内容追加到文件中
			//randomAccessFile.seek(randomAccessFile.length());// 将光标移动到结尾
			while ((flag = bufferedInputStream.read(buf)) != -1) {
				randomAccessFile.write(buf, 0, flag);
			}
			System.out.println("随机插入内容完成.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 6. 关闭随机操作对象
			try {
				if(null != bufferedInputStream){
					bufferedInputStream.close();
				}
				if(null != bufferedOutputStream){
					bufferedOutputStream.close();
				}
				if(null != randomAccessFile){
					randomAccessFile.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 随机读取写入内容到文件
	 */
	private static void readwriterContent() {
		RandomAccessFile randomAccessFile = null;
		try{
			// 1. 创建随机操作文件对象
			randomAccessFile = new RandomAccessFile(new File("random.data"), "rw");
			// 2. 设置读取位置并读取内容(默认从头开始读取)
//			String line = randomAccessFile.readLine();
//			System.out.println("读取一行: " + line);
			
			// 从指定位置开始读取指定数量的字节
			randomAccessFile.seek(8);// 将读取的光标移动到7的位置
			byte[] buf = new byte[2];
			randomAccessFile.read(buf);
			System.out.println("读取2个字节: " + new String(buf));
			
			randomAccessFile.seek(2);// 将读取的光标移动到7的位置
			randomAccessFile.read(buf);
			System.out.println("读取2个字节: " + new String(buf));
			
			//randomAccessFile.seek(0);// 将光标定位到开始位置
			randomAccessFile.seek(randomAccessFile.length());// 将光标定位到结尾位置
			randomAccessFile.write("\nJava是世界上最好的编程语言.".getBytes());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 3. 关闭随机操作对象
			try {
				if(null != randomAccessFile){
					randomAccessFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
