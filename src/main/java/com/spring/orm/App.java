package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
       


        	
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	boolean flag = true;
        	while(flag == true) {
        		Scanner sc = new Scanner(System.in);
        		System.out.println("1)Add New Student");
            	System.out.println("2)Display All Student");
            	System.out.println("3)Get Single Details");
            	System.out.println("4)Delete Students");
            	System.out.println("5)Update Student");
            	System.out.println("6)exit");
            	
            	try {
            		int choice = Integer.parseInt(br.readLine());
            		switch(choice) {
            			case 1:{
            				Student student  = new Student();
            				System.out.println("Enter Id : ");
            				int id = sc.nextInt();
            		        student.setStudentId(id);
            		        sc.nextLine();
            		        System.out.println("Enter Name :");
            		        String name = sc.nextLine();   
            		        student.setStudentName(name);
            		        
            		        System.out.println("Enter City :");
            		        String city = sc.nextLine();          		      
            		        student.setStudentCity(city);
            		        
            		        int r = studentDao.insert(student);
            		        System.out.println("Inserted Successfully : "+r);
            		        sc.nextLine();
            				break;
            			}
            			case 2:{
            		          List<Student> list  = studentDao.getAllStudent();
            		          for(Student s :list) 
            		        	  System.out.println(s);
            				break;
            			}
            			case 3:{
            				 System.out.println("Enter Id To fetch record: ");
            				 int id = sc.nextInt();
            		         Student s = (Student)studentDao.getStudent(id);
            		         System.out.println(s);
            				break;
            			}
            			case 4:{
            				 System.out.println("Enter Id To Delete record: ");
            				 int id = sc.nextInt();
            				
            				 studentDao.deleteStudent(id);
            				break;
            			}
            			case 5:{
            				
            				break;
            			}
            			case 6:{
            				flag = false;
            				break;
            			}
            			default:{
            				System.out.println("Wrong Input TRu Again");
            			}
   
            		}
            	}catch(Exception e) {
            		System.out.println("Invalid Input");
            		System.out.println(e.getMessage());
            	}
        	
        }
    }
}
