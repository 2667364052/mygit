package org.java.io.charset;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * �ַ��ļ����������ʾ��: ��Ҫ���ڲ����ַ��ļ�
 * 
 * @author VIC
 *
 */
public class FileReaderFileWriterDemo {
	
	public static void main(String[] args) {
		// ��ȡ�ַ��ļ�
		readerCharFile();
		// д���ַ��ļ�
		//writerCharFile();
	}

	/**
	 * д���ַ��ļ�
	 */
	private static void writerCharFile() {
		FileWriter fileWriter = null;
		try {
			// 1. �����ַ��ļ����������
			fileWriter = new FileWriter("data.txt",true);
			// 2. ���ַ�д���ļ�
			fileWriter.write(",����д����");
			System.out.println("д���ַ��ļ����.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 3. �ر���
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
	 * ��ȡ�ַ��ļ�
	 */
	private static void readerCharFile() {
		// 1. �����ַ�����������
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("data.txt");
			// 2. ��ȡ�ļ�����
//			char ch = (char)fileReader.read();//���ַ��ļ���������ÿ�ζ�ȡһ���ַ�
//			System.out.println("��ȡ�ַ�: " + ch);
			char[] cbuf = new char[10];
			int flag = fileReader.read(cbuf);
			System.out.println("��ȡ�ַ�����: " + Arrays.toString(cbuf));
			System.out.println("��ǰ��ȡλ��: " + flag);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر���
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
