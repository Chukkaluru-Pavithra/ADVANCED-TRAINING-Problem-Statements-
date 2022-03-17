package com.multithreading;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
class file{
    file()
    {
        try{
        FileReader fr = new FileReader("output.txt");
        String str = "";
        int i;
	    while ((i = fr.read()) != -1)str += (char)i;
	    System.out.println("Data Stored in file : \n"+str);
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
}
public class Main {
	static void solve(){
	    try{
	        System.out.println("\tWELCOME");
	        int option=-1,count=0;
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        FileWriter fw = new FileWriter("output.txt");
	        while(option!=2)
	        {
	            count++;
	            System.out.println("1.Add details\n2.Exit");
	            option=Integer.parseInt(br.readLine());
	               int age,rollNo;
	               String Name,Address;
	            if(option==1)
	            {
	                System.out.println("Enter Name :");
	                Name=br.readLine();
	                System.out.println("Enter Roll Number : ");
	                rollNo=Integer.parseInt(br.readLine());
	                System.out.println("Enter age : ");
	                age=Integer.parseInt(br.readLine());
	                System.out.println("Enter Address : ");
	                Address=br.readLine();
	                String details=String.valueOf(count)+"."+"Name : "+Name+"\n Roll Number : "+rollNo+"\n Age : "+age+"\n Address : "+Address+"\n";
	                System.out.println("Do you want to enter details into file :\n1.Yes\n2.No");
	                String o=br.readLine();
	                if(o.equals("1"))
	                {
	                	fw.write(details);
	                	System.out.println("Data Stored ");
	                }
	                else
	                {
	                    fw.close();
	                    break;
	                }
	            }
	        }
	        System.out.println("Do you want view file data on terminal :\n1.Yes\n2.No");
	        String temp=br.readLine();
	        if(temp.equals("1"))
	        new file();
	    }
	    catch(Exception e){
	        System.out.println(e);
	    }
	    finally{
	        System.out.println("Program Completed");
	    }
	}
	public static void main(String[] args) {
		solve();
	}
}