package com.hoopshe.tests;

import java.io.FileInputStream;
import java.io.IOException;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Readdata {
	 static String[][] data = null;
	public static String[][] data(String sheet) throws BiffException, IOException{
		
		FileInputStream f = new FileInputStream("D:\\hoopshe_workspace\\first\\src\\first\\hoopshenormal2.xls");
		System.out.println(f+"...x..l"+sheet);
		 Workbook wb = Workbook.getWorkbook(f);
			Sheet sh=wb.getSheet(sheet);
			
		    int row = sh.getRows();	
		    int col = sh.getColumns();
		    int ruumode_row=0;
		    for(int i=0;i<row;i++)
		    {
		      String runmode= sh.getCell(0, i).getContents();
		      System.out.println("runmode===> "+runmode);
	          if(runmode.equalsIgnoreCase("yes"))
	       	    {   
	        	  ruumode_row++;
	       	    }
		    }
		    System.out.println("runmodes"+ruumode_row);
		    data= new String[ruumode_row][col-1];
		    System.out.println(col);
		    for(int i=0;i<row;i++)
		    {
		      String runmode= sh.getCell(0, i).getContents();
	          if(runmode.equalsIgnoreCase("yes"))
	       	    {  
		          for(int j=1;j<col;j++)
	    	        {
	    		
	    		   data[i][j-1]=sh.getCell(j, i).getContents();
	    		   System.out.println(sh.getCell(j, i).getContents());
	    		  
	    	        }
	       	    }
		    }
		    System.out.println(data);
			return data;
		
		
	}
	
	
}
