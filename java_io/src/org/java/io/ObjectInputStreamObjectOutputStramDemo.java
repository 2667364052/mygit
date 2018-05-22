package org.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * �������������: ���ڱ�������ļ�����ļ���ȡ����
 * ��ʾ: ��Ҫ����Ķ���������ʵ��Serializable���л��ӿ�
 * 
 * @author VIC
 *
 */
public class ObjectInputStreamObjectOutputStramDemo {
	
	
	public static void main(String[] args) {
		// �����󱣴浽�ļ�
		saveObject();
		// �����󼯺ϱ��浽�ļ�
		saveObjects();
		// ���ļ���ȡ����
		readObject();
		// ���ļ��ж�ȡ���󼯺�
		readObjects();
	}
	
	/**
	 * ���ļ��ж�ȡ���󼯺�
	 */
	private static void readObjects() {
		// 1. ���������ļ�����
		File objectFile = new File("students");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			// 2. ������������������
			fileInputStream = new FileInputStream(objectFile);
			objectInputStream = new ObjectInputStream(fileInputStream);
			// 3. ���ļ��ж�ȡ����
			ArrayList<Student> students = (ArrayList<Student>)objectInputStream.readObject();
			System.out.println("��ȡ���󼯺�: " + students);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر���
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
	 * ���ļ��ж�ȡ����
	 */
	private static void readObject() {
		// 1. ���������ļ�����
		File objectFile = new File("student");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			// 2. ������������������
			fileInputStream = new FileInputStream(objectFile);
			objectInputStream = new ObjectInputStream(fileInputStream);
			// 3. ���ļ��ж�ȡ����
			Student student = (Student)objectInputStream.readObject();
			System.out.println("��ȡ����: " + student);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر���
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
	 * ������󼯺ϵ��ļ�
	 * @param student
	 */
	private static void saveObjects() {
		// ��ʼ��Ҫ����Ķ���(����һ��ѧ��)
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"С��"));
		students.add(new Student(2,"����"));
		students.add(new Student(5,"��ͳ�"));
		
		// 1. ��������ļ�����
		File objectFile = new File("students");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			// 2. �������������
			fileOutputStream = new FileOutputStream(objectFile);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			// 3. д������ļ�
			objectOutputStream.writeObject(students);
			objectOutputStream.flush();// ˢ�����е��������ݵ�����
			System.out.println("������󼯺�: " + students);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر���
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
	 * ��������ļ�
	 * @param student
	 */
	private static void saveObject() {
		// ��ʼ��Ҫ����Ķ���(����һ��ѧ��)
		Student student = new Student(2,"С��");
		// 1. ��������ļ�����
		File objectFile = new File("student");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			// 2. �������������
			fileOutputStream = new FileOutputStream(objectFile);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			// 3. д������ļ�
			objectOutputStream.writeObject(student);
			objectOutputStream.flush();// ˢ�����е��������ݵ�����
			System.out.println("�������: " + student);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4. �ر���
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
