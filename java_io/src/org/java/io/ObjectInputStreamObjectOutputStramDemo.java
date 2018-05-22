package org.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 对象输入输出流: 用于保存对象到文件或从文件读取对象
 * 提示: 需要保存的对象的类必须实现Serializable序列化接口
 * 
 * @author VIC
 *
 */
public class ObjectInputStreamObjectOutputStramDemo {
	
	
	public static void main(String[] args) {
		// 将对象保存到文件
		saveObject();
		// 将对象集合保存到文件
		saveObjects();
		// 从文件读取对象
		readObject();
		// 从文件中读取对象集合
		readObjects();
	}
	
	/**
	 * 从文件中读取对象集合
	 */
	private static void readObjects() {
		// 1. 定义输入文件对象
		File objectFile = new File("students");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			// 2. 创建对象输入流对象
			fileInputStream = new FileInputStream(objectFile);
			objectInputStream = new ObjectInputStream(fileInputStream);
			// 3. 从文件中读取对象
			ArrayList<Student> students = (ArrayList<Student>)objectInputStream.readObject();
			System.out.println("读取对象集合: " + students);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭流
			try {
				if(null != objectInputStream){
					objectInputStream.close();
				}
				if(null != fileInputStream){
					fileInputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * 从文件中读取对象
	 */
	private static void readObject() {
		// 1. 定义输入文件对象
		File objectFile = new File("student");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			// 2. 创建对象输入流对象
			fileInputStream = new FileInputStream(objectFile);
			objectInputStream = new ObjectInputStream(fileInputStream);
			// 3. 从文件中读取对象
			Student student = (Student)objectInputStream.readObject();
			System.out.println("读取对象: " + student);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭流
			try {
				if(null != objectInputStream){
					objectInputStream.close();
				}
				if(null != fileInputStream){
					fileInputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 保存对象集合到文件
	 * @param student
	 */
	private static void saveObjects() {
		// 初始化要保存的对象(创建一个学生)
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"小明"));
		students.add(new Student(2,"马云"));
		students.add(new Student(5,"李纪超"));
		
		// 1. 定义输出文件对象
		File objectFile = new File("students");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			// 2. 创建对象输出流
			fileOutputStream = new FileOutputStream(objectFile);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			// 3. 写入对象到文件
			objectOutputStream.writeObject(students);
			objectOutputStream.flush();// 刷新流中的数据数据到磁盘
			System.out.println("保存对象集合: " + students);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭流
			try {
				if(null != objectOutputStream){
					objectOutputStream.close();
				}
				if(null != fileOutputStream){
					fileOutputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 保存对象到文件
	 * @param student
	 */
	private static void saveObject() {
		// 初始化要保存的对象(创建一个学生)
		Student student = new Student(2,"小明");
		// 1. 定义输出文件对象
		File objectFile = new File("student");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			// 2. 创建对象输出流
			fileOutputStream = new FileOutputStream(objectFile);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			// 3. 写入对象到文件
			objectOutputStream.writeObject(student);
			objectOutputStream.flush();// 刷新流中的数据数据到磁盘
			System.out.println("保存对象: " + student);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. 关闭流
			try {
				if(null != objectOutputStream){
					objectOutputStream.close();
				}
				if(null != fileOutputStream){
					fileOutputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
