package org.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * ���������ļ�: Properties,����ײ�ʹ�ù�ϣ��洢����,����ֵ�ԡ���Ϊϵͳ�����ļ�ʹ��
 * 
 * @author VIC
 *
 */
public class PropertiesDemo {
	
	public static void main(String[] args) {
//		writerAndSetProperties();
//		readAndGetProperties();
		updateProperties();
	}

	private static void updateProperties() {
		// ��ȡ���������ļ�
		Properties serverConfig = new Properties();
		InputStream inputStream = null;
		try {
			// �����ļ�������
			inputStream = new FileInputStream("server_config.properties");
			// ���ļ����е�����ת����Properties����
			serverConfig.load(inputStream);
			// �޸����������ļ�
			serverConfig.put("serverUrl", "http://192.168.88.189");
			// �����޸��ļ�
			serverConfig.store(new FileOutputStream("server_config.properties"), "�޸���serverUrl");
			System.out.println("�޸����������ļ��ɹ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			serverConfig.clone();
		}
	}

	private static void readAndGetProperties() {
		// ��ȡ���������ļ�
		Properties serverConfig = new Properties();
		InputStream inputStream = null;
		try {
			// �����ļ�������
			inputStream = new FileInputStream("server_config.properties");
			// ���ļ����е�����ת����Properties����
			serverConfig.load(inputStream);
			// ʹ���������ƻ�ȡ����ֵ(HashMap��ʽ)
//			for(Entry entry : serverConfig.entrySet()){
//				System.out.println("������: " + entry.getKey() + " ����ֵ: " + entry.getValue());
//			}
			
			// ʹ����������ȡָ��������ֵ
			String serverUrlValue = serverConfig.getProperty("serverUrl");
			String serverNameValue = serverConfig.getProperty("serverName");
			
			System.out.println("serverName=" + serverNameValue);
			System.out.println("serverUrl=" + serverUrlValue);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			serverConfig.clone();
		}
	}

	private static void writerAndSetProperties() {
		// ����һ�������б�Ĭ��Ϊ�յ�Properties����
		Properties serverConfig = new Properties();
		// �����������
		serverConfig.setProperty("serverName", "1����·����ϵͳ");
		serverConfig.setProperty("serverUrl", "http://192.168.88.89");
		try{
			// ���������ļ�
			serverConfig.store(new FileOutputStream("server_config.properties"), "1����·����ϵͳ���������ļ�");
			System.out.println("�������������ļ����.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// �ر�
			serverConfig.clone();
		}
	}

}
