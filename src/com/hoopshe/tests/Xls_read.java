package com.hoopshe.tests;
	


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

	public class Xls_read {
		 static String[][] s= null;
	
		static List<java.lang.Object[]> Object = new ArrayList<Object[]>();
		
	public static String[] getdata(String sheet) throws BiffException, IOException{
	
		 String data_array[] = null;
	  FileInputStream fis = new FileInputStream("D:\\hoopshe_workspace\\first\\src\\first\\hoopshedata.xls");
	
			Workbook wb = Workbook.getWorkbook(fis);
			
			jxl.Sheet sh=wb.getSheet("Sheet1");
			
		    int row = sh.getRows();
		    System.out.println("row_count ===>"+row);
			int col = sh.getColumns();
			System.out.println("col_count ===>"+col);
		//	s= new String[][];
		  
			
			
			int ci=0;
    		int cj=0;
			//int rowcell = 1;
			//int k =0;
	        for(int r=0; r<row; r++)
		     { 
	            String runmode= sh.getCell(8, r).getContents();
	          	if(runmode.equalsIgnoreCase("yes"))
	       	     {  
	          		System.out.println("if block");
	          		
				     String data  = sh.getCell(4, r).getContents();
				     System.out.println("data ==>"+data);
				      data_array =data.split(",");
				      for(int j=0;j<data_array.length;j++)
				    	  {
				    	  System.err.println("..."+j+"..final..."+data_array[j]);
				    	  s=new String[row][data_array.length];
				    		 s[r][1]=sh.getCell(4,r).getContents();
				    		
				    		Collections.addAll(Object, data_array);
				    		
/*				    		 System.out.println("s arry"+s[ci][cj]);*/
				    		System.err.println("..."+j+"..final..."+data_array[j]);
							
				    	  }
				    
				     System.out.println("matched");
	       	      }
	         	 else
	         	  {
	       		
	       		    System.out.println("run not Match..."+r);
	       		   continue;
		          }
	          	
	          	
	          	
		      }
	
	        System.out.println("total objectvalues..."+Object);
	      System.out.println("final leangth===>"+data_array.length);
	       return data_array;
	    }
	public static void setdata(String sheet,String value) throws IOException, RowsExceededException, WriteException, BiffException{
		 System.out.println("write enter");
		FileOutputStream fio = new FileOutputStream("‪‪D:\\hoopshedata.xls");
		    WritableWorkbook workbook = Workbook.createWorkbook(fio);
		     WritableSheet wshTemp = workbook.getSheet(sheet);
		  
		  InputStream fin = new FileInputStream("‪‪D:\\hoopshedata.xls");
			Workbook wb = Workbook.getWorkbook(fin);
			
			jxl.Sheet sh=wb.getSheet("Sheet1");
			
		    int row = sh.getRows();
			int col = sh.getColumns();
			 
		  
			int rowcell = 1;
			int k =0;
	        for(int r=1; r<row; r++)
		     { 
	            String runmode= sh.getCell(8, r).getContents();
	          	if(runmode.equalsIgnoreCase("yes"))
	       	     {  
		
	               Label labTemp = new Label(9,r,value );
	               wshTemp.addCell(labTemp);
	               workbook.write();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	            }
		     }
	   	 System.out.println("write done");
	        workbook.close();
	    
	}
	
	
	} 
	