package org.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * �ֽ��������������ʾ��
 * 
 * @author VIC
 *
 */
public class BuffredInputStreamBufferOutputStreamDemo {
	
	
	public static void main(String[] args) {
		
		// ʹ�û�����������������ļ�
		//copyBuffredFile();
		// ʹ����������������ļ�
		copyFile();
	}

	private static void copyBuffredFile() {
		
		long startTime = System.currentTimeMillis();// ��ȡ��ǰʱ�������
		// 1. �����ļ�����
		File sourceFile = new File("Java�����ŵ���ͨ����3�棩.rar");
		File targetFile = new File("copy_Java�����ŵ���ͨ����3�棩.rar");
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try{
		// 2. �����ļ��������������
		fileInputStream = new FileInputStream(sourceFile);
		fileOutputStream = new FileOutputStream(targetFile);
		// 3. �����ļ������������������
		bufferedInputStream = new BufferedInputStream(fileInputStream);
		bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		// 4. �����ļ�
		int flag = -1;
		while ((flag = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(flag);
			bufferedOutputStream.flush();
		}
		long endTime = System.currentTimeMillis();// ��ȡ��ǰʱ�������
		System.out.println("�����ļ���ɣ���ʱ: " + (endTime - startTime));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. �ر����������	
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
		
		long startTime = System.currentTimeMillis();// ��ȡ��ǰʱ�������
		// 1. �����ļ�����
		File sourceFile = new File("Java�����ŵ���ͨ����3�棩.rar");
		File targetFile = new File("copy_Java�����ŵ���ͨ����3�棩.rar");
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
//		BufferedInputStream bufferedInputStream = null;
//		BufferedOutputStream bufferedOutputStream = null;
		try{
		// 2. �����ļ��������������
		fileInputStream = new FileInputStream(sourceFile);
		fileOutputStream = new FileOutputStream(targetFile);
		// 3. �����ļ������������������
//		bufferedInputStream = new BufferedInputStream(fileInputStream);
//		bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		// 4. �����ļ�
		int flag = -1;
//		while ((flag = bufferedInputStream.read()) != -1) {
//			bufferedOutputStream.write(flag);
//			bufferedOutputStream.flush();
//		}
		while ((flag = fileInputStream.read()) != -1) {
			fileOutputStream.write(flag);
			fileOutputStream.flush();
	}
		long endTime = System.currentTimeMillis();// ��ȡ��ǰʱ�������
		System.out.println("�����ļ���ɣ���ʱ: " + (endTime - startTime));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. �ر����������	
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
