package org.java.io.charset;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ����ļ���д������
 * @author VIC
 *
 */
public class RandomAccessFileDemo {
	
	public static void main(String[] args) {
		
		// �����ȡд�����ݵ��ļ�
		//readwriterContent();
		// ����������ݵ��ļ���
		insertContent();
		
	}

	private static void insertContent() {
		
		RandomAccessFile randomAccessFile = null;
		BufferedOutputStream bufferedOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		try {
			// 1. ������������ļ�����
			randomAccessFile = new RandomAccessFile("random.data", "rw");
			
			// 2. ������ʱ�ļ�����
			File tmpFile = File.createTempFile("tmp", null);
			tmpFile.deleteOnExit();// ����������Զ�ɾ����ʱ�ļ�
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tmpFile));
			bufferedInputStream = new BufferedInputStream(new FileInputStream(tmpFile));
			
			// 3. ������λ�ú�����ݷ�����ʱ�ļ�
			randomAccessFile.seek(22);// ������ƶ�������λ��
			// ��ȡ����λ�ú�������ݵ���ʱ�ļ�
			byte[] buf = new byte[24];
			int flag = -1;
			while ((flag = randomAccessFile.read(buf)) != -1) {
				bufferedOutputStream.write(buf, 0, flag);
				bufferedOutputStream.flush();
			}
			
			// 4. ����������
			randomAccessFile.seek(22);// ������ƶ�������λ��
			randomAccessFile.write("\n�������ƿƼ�".getBytes());
			
			// 5. ����ʱ�ļ��ڵ�����׷�ӵ��ļ���
			//randomAccessFile.seek(randomAccessFile.length());// ������ƶ�����β
			while ((flag = bufferedInputStream.read(buf)) != -1) {
				randomAccessFile.write(buf, 0, flag);
			}
			System.out.println("��������������.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 6. �ر������������
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
	 * �����ȡд�����ݵ��ļ�
	 */
	private static void readwriterContent() {
		RandomAccessFile randomAccessFile = null;
		try{
			// 1. ������������ļ�����
			randomAccessFile = new RandomAccessFile(new File("random.data"), "rw");
			// 2. ���ö�ȡλ�ò���ȡ����(Ĭ�ϴ�ͷ��ʼ��ȡ)
//			String line = randomAccessFile.readLine();
//			System.out.println("��ȡһ��: " + line);
			
			// ��ָ��λ�ÿ�ʼ��ȡָ���������ֽ�
			randomAccessFile.seek(8);// ����ȡ�Ĺ���ƶ���7��λ��
			byte[] buf = new byte[2];
			randomAccessFile.read(buf);
			System.out.println("��ȡ2���ֽ�: " + new String(buf));
			
			randomAccessFile.seek(2);// ����ȡ�Ĺ���ƶ���7��λ��
			randomAccessFile.read(buf);
			System.out.println("��ȡ2���ֽ�: " + new String(buf));
			
			//randomAccessFile.seek(0);// ����궨λ����ʼλ��
			randomAccessFile.seek(randomAccessFile.length());// ����궨λ����βλ��
			randomAccessFile.write("\nJava����������õı������.".getBytes());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 3. �ر������������
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
