package org.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性配置文件: Properties,该类底层使用哈希表存储数据,即键值对。做为系统配置文件使用
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
		// 读取属性配置文件
		Properties serverConfig = new Properties();
		InputStream inputStream = null;
		try {
			// 加载文件输入流
			inputStream = new FileInputStream("server_config.properties");
			// 将文件流中的数据转换成Properties对象
			serverConfig.load(inputStream);
			// 修改属性配置文件
			serverConfig.put("serverUrl", "http://192.168.88.189");
			// 保存修改文件
			serverConfig.store(new FileOutputStream("server_config.properties"), "修改了serverUrl");
			System.out.println("修改属性配置文件成功.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			serverConfig.clone();
		}
	}

	private static void readAndGetProperties() {
		// 读取属性配置文件
		Properties serverConfig = new Properties();
		InputStream inputStream = null;
		try {
			// 加载文件输入流
			inputStream = new FileInputStream("server_config.properties");
			// 将文件流中的数据转换成Properties对象
			serverConfig.load(inputStream);
			// 使用属性名称获取属性值(HashMap方式)
//			for(Entry entry : serverConfig.entrySet()){
//				System.out.println("属性名: " + entry.getKey() + " 属性值: " + entry.getValue());
//			}
			
			// 使用属性名获取指定的属性值
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
		// 创建一个属性列表默认为空的Properties对象
		Properties serverConfig = new Properties();
		// 添加属性配置
		serverConfig.setProperty("serverName", "1号铁路调度系统");
		serverConfig.setProperty("serverUrl", "http://192.168.88.89");
		try{
			// 保存属性文件
			serverConfig.store(new FileOutputStream("server_config.properties"), "1号铁路调度系统核心配置文件");
			System.out.println("保存属性配置文件完成.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 关闭
			serverConfig.clone();
		}
	}

}
