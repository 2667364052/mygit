package org.java.io.charset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * �ַ��������������: ��Ҫ������߲����ַ���Ч��
 * 
 * @author VIC
 *
 */
public class BufferedReaderBufferedWriterDemo {
	
	public static void main(String[] args) {
		//ʹ�û����ַ���������ȡ�ļ�����
		//readerBufferChar();
		//ʹ�û����ַ������д���ļ�����
		writerBufferChar();
		
	}

	/**
	 * ʹ�û����ַ������д���ļ�����
	 */
	private static void writerBufferChar() {
		// 1. ����д���ļ�
		File sourceFiel = new File("bigdata.txt");
		BufferedWriter bufferedWriter = null;
		try{
		// 2. �����ַ����������
			bufferedWriter = new BufferedWriter(new FileWriter(sourceFiel, true));
		// 3. д�ַ����ļ�
			bufferedWriter.newLine();//д��һ�����з�
			bufferedWriter.write("�ú�ѧϰ,���ϳԼ�.");
			bufferedWriter.newLine();//д��һ�����з�
			bufferedWriter.write("��ϲ����", 0, 2);
			System.out.println("д���ַ��ļ����.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر���	
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
	 * ʹ�û����ַ���������ȡ�ļ�����
	 */
	private static void readerBufferChar() {
		// 1. ����Դ�ļ�
		File sourceFiel = new File("bigdata.txt");
		BufferedReader bufferedReader = null;
		try {
			// 2. �����ַ�����������
			bufferedReader = new BufferedReader(new FileReader(sourceFiel));
			// 3. �ӻ����������ж�ȡ����
			// ready()�ж��Ƿ���Կ�ʼ��ȡ
			while (bufferedReader.ready()) {
				// ÿ�ζ�ȡһ���ַ�
				//System.out.println(bufferedReader.readLine());
				
				// ����һ���ַ��������ڴ洢���ж�ȡ�������ַ�
				char[] cbuf = new char[20];
				// �����ж�ȡ15���ַ�
				bufferedReader.read(cbuf, 0, 15);
				System.out.println(new String(cbuf));
			}
			System.out.println("��ȡ�ַ��ļ����.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر���
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
