package org.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ļ���������ֽ���ʾ��
 * 
 * @author VIC
 *
 */
public class FileInputStreamFileOutputStreamDemo {
	
	public static void main(String[] args) {
		
		//ʹ���ļ���������������ļ�
		copyFile();
		// ʹ���ļ���������ļ���д����������
		//writerFile();
		// ʹ���ļ����������ļ��ж�ȡ��������
		//readFile();
		// ʹ���ļ��������Ӵ��ļ��ж�ȡ��������
		//readBigFile();
	}

	/**
	 * ʹ��FileInputStream FileOutputStream�����ļ�
	 */
	private static void copyFile() {
		System.out.println("��ʼ�����ļ�.");
		// 1. �����ļ�����
		File sourceFile = new File("img0.jpg"); // ����Դ�ļ�(�����ļ�)
		File targetFile = new File("newimg.jpg");// ����Ŀ���ļ�(����ļ�)
		
		InputStream inputStream = null;
		OutputStream outputStream = null; 
		try{
		// 2. �����ļ��������������
		inputStream = new FileInputStream(sourceFile);
		outputStream = new FileOutputStream(targetFile);
		// 3. �����ļ�
		// ѭ�����ļ���������ÿ�ζ�ȡ10���ֽڵ������ֽ�������,Ȼ��д�뵽�ļ��������
		byte[] buf = new byte[10];
		int flag = -1;
		while ((flag = inputStream.read(buf)) != -1) {
			outputStream.write(buf, 0, flag);
			outputStream.flush();// ˢ���ֽڵ��ļ�
		}
		System.out.println("�����ļ����.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر����������
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
	 * ʹ��FileOutputStream���ļ���д����������
	 */
	private static void writerFile() {
		// 1. ����д�����ݵ��ļ�
		File targetFile = new File("data.txt");
		FileOutputStream fileOutputStream = null;
		try {
			// 2. �����ļ����������
			fileOutputStream = new FileOutputStream(targetFile,true);
			// 3. д������
			fileOutputStream.write("\r\nʹ��FileInputStream��ȡ�ļ�,ѧϰJava��ǰ;.".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر��ļ������
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
		// 1. �����ļ�����
		File sourceFile =  new File("bigdata.txt");
		InputStream fileInputStream = null;
		try{
		// 2. �����ļ�����������
		fileInputStream = new FileInputStream(sourceFile);
		// 3. ��ȡ�ļ�����(ѭ����ȡ)
		byte[] buf = new byte[27];// ���������ж�ȡ�ֽ����ݲ�����λ��(���û���ֽ����ݻ��ֽ����ݶ�ȡ���򷵻�-1)
		int flag = -1;// ��¼��ǰ�ֽ�ȥȡλ��
		while ((flag = fileInputStream.read(buf)) != -1) {
			System.out.println("�ֽ�����: " + new String(buf));
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر�������
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
	 * ʹ��FileInputStream��ȡ�ļ�
	 * @throws Exception 
	 */
	private static void readFile() {
		
		// 1. �����ļ�����
		File sourceFile = new File("data.txt");
		FileInputStream fileInputStream = null;
		try{
		// 2. �����ļ�����������
		fileInputStream = new FileInputStream(sourceFile); 
		// 3. ��ȡ�ļ�����
		byte[] buf = new byte[1024];//����һ���ֽ��������ڴ洢���������ж�ȡ���ֽ�
		int flag = fileInputStream.read(buf);// ���������ж�ȡ�ֽ����ݲ�����λ��(���û���ֽ����ݻ��ֽ����ݶ�ȡ���򷵻�-1)
		System.out.println("�ֽ�����: " + new String(buf));
		System.out.println("��ȡ״̬: " + flag);
		flag = fileInputStream.read(buf);
		System.out.println("���ζ�ȡ״̬: " + flag);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر�������
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
