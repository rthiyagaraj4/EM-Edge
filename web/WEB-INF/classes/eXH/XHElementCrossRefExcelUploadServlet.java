/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;															   
import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.*;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;																			 	  
import org.apache.poi.hssf.model.*;
import org.apache.poi.hssf.usermodel.*;
import java.util.regex.Pattern;

//import eCA.DCRDMLTable.DCRColumn;														 




public class XHElementCrossRefExcelUploadServlet  extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet
{

	private String incdNo = "";
	private String loginUser = "";
	private String baseModule = "";
	private String actionKey = "";
	private String tblName = "";
	private String dataOwnerModule = "";
	private File newFile = null;
	private ServletContext sc = null;
	private HttpSession session = null;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		sc = config.getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		
			doPost(request,response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			session = request.getSession();
				  newFile=new File(request.getParameter("upload_text"));
			System.out.println("newFile :"+newFile);

			
		//	session.removeAttribute("dcrTblUpload");	 
			//readBook(request, response);
			read(request, response);
		}
		catch (Exception e)
		{
			//session.removeAttribute("dcrTblUpload");
			session.setAttribute("DFLT_XLS_ERROR","DCR00025 - Invalid file");
			e.printStackTrace();
		}
		finally
		{
			if(newFile != null &&  newFile.exists())
			{
				newFile.delete();
			}
		}
	}
	public void read(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

	 	  HttpSession session = request.getSession(false);
		  String Messagetext="";
		  Pattern Regex = null;
		  Properties p;
		  p = (Properties) session.getValue("jdbc");	
		  String locale  = p.getProperty("LOCALE");
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out=response.getWriter();
		  ResultSet reset  = null;
		  String cross_type="U";
		  Connection con = null;			 
		  String Messageerror="";
		  String element_separetor="";
		  String system_defind_orginal="";
		  String standardcode="";
		  String sys_element_desc="";
		  HashMap resultsQry = null;
		  ArrayList stndcode=new ArrayList();
		  String status="";
		  String field_sepereator="";
		  String symbol="";
		  String sStyle = "";
		  String original="";		    
		  String funtion_id=XHDBAdapter.checkNull(request.getParameter("function_id")); 	    
		  String fieldsymbol="";
		  String elementsymbol="";
		  String elementDescValue="";
		  String mode="U";
		  Connection connection = null;
		  Statement stmt = null;
		  ResultSet rs=null;
		  Statement stmtUpdate = null;
		  ArrayList addfun=new ArrayList();
		  MessageManager mm=new MessageManager();
		 CallableStatement oraclecallablestatement = null;
			Statement statment = null;	
			int g=0;
		   
    try
	{
			if(connection==null) connection = ConnectionManager.getConnection();
			int result=0;
			int colCount=0;
			int rowcount=6;
			String message="";
			HSSFCell cell   =null;
			HSSFRow row  =null;		
			ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
			String  usr_added_by_id=(String)arrAudit.get(0);	
			String usr_added_at_ws_no=(String)arrAudit.get(1);

			System.out.println("checking ");
			String standard_code=XHDBAdapter.checkNull(request.getParameter("Standardcode_combo"));
			String segment_type=XHDBAdapter.checkNull(request.getParameter("segment_type"));
	       	InputStream  inp = new FileInputStream(newFile);
			HSSFWorkbook wb     = new HSSFWorkbook(new POIFSFileSystem(inp));
			HSSFSheet sheet = wb.getSheetAt(0);
			int totalRow= sheet.getLastRowNum();        
			stmtUpdate=connection.createStatement();
		   	String in_use="N";
			String faclity="N";
			String Nature="Y";
		for(int i=1;i<=totalRow;i++)
		{
			HSSFRow rowSK1  =sheet.getRow(i); 
			oraclecallablestatement = connection.prepareCall("{ call XHMAST.element_code_usage(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
			oraclecallablestatement.setString(1,"U");
			oraclecallablestatement.setString(2,XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount)).getStringCellValue()));
			System.out.println("(XHElementCrossRefExcelUploadServlet call) element code :"+XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount)).getStringCellValue()));
			oraclecallablestatement.setString(3,XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+1)).getStringCellValue()));
			System.out.println("(XHElementCrossRefExcelUploadServlet call) element name :"+XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+1)).getStringCellValue()));
			oraclecallablestatement.setString(4,"U");
			System.out.println("(XHElementCrossRefExcelUploadServlet call) cross type :U");
		
			if(XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+9)).getStringCellValue()).equals("Yes"))
			{
			 in_use="Y";
			}
			oraclecallablestatement.setString(5,in_use);


			System.out.println("(XHElementCrossRefExcelUploadServlet call) In_use :"+in_use);  
			if(XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+6)).getStringCellValue()).equals("Y"))
			{
			  faclity="Y";
			}
			oraclecallablestatement.setString(6,faclity);
			System.out.println("(XHElementCrossRefExcelUploadServlet call)facility :"+faclity);


			if(XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+5)).getStringCellValue()).equals("Control"))
			{
			  Nature="Y";
			} 
			else if(XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+5)).getStringCellValue()).equals("Data"))
			{
			  Nature="N";
			}
			else
			{
			   Nature="X";
			}
			oraclecallablestatement.setString(7,Nature);
			System.out.println("(XHElementCrossRefExcelUploadServlet call) Control_YN :"+Nature);			
			oraclecallablestatement.setString(8,XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+3)).getStringCellValue()));
			System.out.println("(XHElementCrossRefExcelUploadServlet call)Standard_type :"+XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+3)).getStringCellValue().trim()));
			
			if(XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+2)).getStringCellValue().trim()).equals("")||XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+2)).getStringCellValue().trim()).equals("null")||XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+2)).getStringCellValue().trim())==null)
			{

			}
			else
			{
			  elementDescValue=XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+2)).getStringCellValue().trim());
			}
			 oraclecallablestatement.setString(9,elementDescValue);
		    System.out.println("(XHElementCrossRefExcelUploadServlet call)element :"+elementDescValue);
		  	oraclecallablestatement.setString(10,XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+7)).getStringCellValue()));	
			System.out.println("(XHElementCrossRefExcelUploadServlet call)Segemnt_type :"+XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+7)).getStringCellValue().trim()));
			oraclecallablestatement.setString(11,usr_added_by_id);		
			System.out.println("(XHElementCrossRefExcelUploadServlet call)usr_added_by_id :"+usr_added_by_id);
			oraclecallablestatement.setString(12,usr_added_at_ws_no);
			System.out.println("(XHElementCrossRefExcelUploadServlet call) usr_added_at_ws_no :"+usr_added_at_ws_no);
			oraclecallablestatement.registerOutParameter(13,java.sql.Types.VARCHAR);
			oraclecallablestatement.registerOutParameter(14,java.sql.Types.VARCHAR);		   
			oraclecallablestatement.executeUpdate(); 	
		     if(addfun.contains(rowSK1.getCell((short)(colCount+7)).getStringCellValue().toString().trim()+"!"+rowSK1.getCell((short)(colCount+8)).getStringCellValue()))
		 {
			
		 }																							  
		 else
		 {
			  String emptycheck=XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+8)).getStringCellValue());			   
			  String configempty=XHDBAdapter.checkNull(rowSK1.getCell((short)(colCount+7)).getStringCellValue().toString().trim());
			  if(emptycheck.equals(""))
			  {
				  emptycheck=",";
			  }

			  if(configempty.equals(""))											   
			  {
				configempty=","; 
			  }
			 	addfun.add(configempty+"!"+emptycheck);
				System.out.println(addfun.get(g)+"count :"+g);
				g++;
		  }							   
					 status = oraclecallablestatement.getString(13);
					 Messageerror=oraclecallablestatement.getString(14);

					 System.out.println("Messagetext status: "+status);
				
		}
	 
		System.out.println(Messagetext);																									 
		  resultsQry=XHIdentify.treeHashMap(connection,locale);				
		  for(int k=0;k<addfun.size();k++)
		  {

			   String[] stndcnfig=((String)addfun.get(k)).split("!");
			   String confi=stndcnfig[0];
			   String stdc=stndcnfig[1];
			   if(stdc.equals(","))
			  {
					stdc="";
			  }
				
				if(confi.equals(","))
			  {
					confi="";
			  }
			String querydetails="select a.SYSTEM_DEFINED_STRING,b.FILED_SEPARATOR,b.ELEMENT_SEPARATOR,a.STANDARD_CODE from xh_event_segment_config a,xh_standard b where b.STANDARD_CODE=a.STANDARD_CODE and a.CONFIG_NAME='"+confi+"' and a.STANDARD_CODE='"+stdc+"' ";
			System.out.println("DataElementCrossRefElementSetupServlet.java querydetails:"+querydetails);
			try{														 						 
				statment= connection.createStatement();
				reset = statment.executeQuery(querydetails);
				while(reset.next()) 
				{
		 			sys_element_desc=XHDBAdapter.checkNull(reset.getString(1).toString().trim());
				    sys_element_desc=sys_element_desc.substring(1,sys_element_desc.length());
					field_sepereator=XHDBAdapter.checkNull(reset.getString(2).toString().trim());
					element_separetor=XHDBAdapter.checkNull(reset.getString(3).toString().trim());
					standardcode=XHDBAdapter.checkNull(reset.getString(4).toString().trim());
					 if(field_sepereator.equals(""))
					{
						 fieldsymbol="|";
						 field_sepereator="|";
					}
					else
					{	
						int fldsepra=Integer.parseInt(field_sepereator);		  
						char fld=(char)fldsepra;
						field_sepereator=fld+"";
						fieldsymbol=field_sepereator;
					}
					 if(element_separetor.equals(""))
					{
						 element_separetor="^";
						 elementsymbol="^";
				}
				else
				{			 
					
					int elemepra=Integer.parseInt(element_separetor);
					char ele=(char)elemepra;
				    element_separetor=ele+"";
					elementsymbol=element_separetor;
				}

			

				try{
                     Regex = Pattern.compile("\\"+field_sepereator,Pattern.MULTILINE);
                   }
				   catch(Exception e)
				  {
						System.out.println("erorr in caps symbol"+e);
				  } 
				   String[] array=Regex.split(sys_element_desc);
				  for(int check=0;check<array.length;check++)
				  {
					  if(check==0)
					  {
						 symbol=fieldsymbol;  
						 system_defind_orginal=((String)resultsQry.get(array[check]))==null?array[check]:(String)resultsQry.get(array[check]);
						 original= original+system_defind_orginal+symbol;
					  }
					  else
					  {

					  if(array[check].indexOf(element_separetor)!=-1)						   
					  {
						 try{
								Regex = Pattern.compile("\\"+element_separetor,Pattern.MULTILINE);
							}
							catch(Exception e)
							{
								System.out.println("erorr in caps symbol"+e);
							} 
							String[] arraycap=Regex.split(array[check]);
							for(int cap=0;cap<arraycap.length;cap++)
							{										 
							  symbol=elementsymbol;
							  String system_defind_orginalcap=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:((String)resultsQry.get(arraycap[cap]));  	 
							
							  original= original+system_defind_orginalcap+symbol;
							}
					  }
					  else
						  {
						  symbol=fieldsymbol;
					 	  system_defind_orginal=((String)resultsQry.get(array[check]))==null?array[check]:(String)resultsQry.get(array[check]);
						
							if((array.length-1)==check)
							  {
							    original= original+system_defind_orginal;
							  }
							  else
							  {
								 original= original+system_defind_orginal+symbol;
							  }
						  }
						 
					  }

				      
					
				  }
						int exe_query=0;
						PreparedStatement pstmt=null;
						String  Update_query="Update xh_event_segment_config set SYSTEM_DEFINED_STRING_ELE_DESC=? where CONFIG_NAME='"+confi+"' and STANDARD_CODE=? ";
						System.out.println(" system_defind_orginal update Query :"+Update_query);

					    pstmt=connection.prepareStatement(Update_query);
						pstmt.setString(1,original);
						pstmt.setString(2,standardcode);
						System.out.println(" system_defind_orginal :"+original);
						exe_query=pstmt.executeUpdate();
						System.out.println("exe_query  "+exe_query);
						if(exe_query==1)
						{
							connection.commit();
						}
						else
						{
							connection.rollback();
						}
						pstmt.close();				

			}		
		 
			  
		 //out.println("<body CLASS='MESSAGE'>");									    
	
		 //out.println("</body>");

									    

		}catch(Exception ex)
		{
			System.out.println("Error in calling db related statements in dopost method of dataelementcrossrefelementsetupservlet :"+ex.toString());
			ex.printStackTrace(System.err); 
		}

		statment.close();
		reset.close();

	  }			

									   
				
		if("0".equals(status))
	 {
          connection.commit();
	      final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		  Messagetext = ((String) mesg.get("message"));
		
     }
	 else
	 {
         connection.rollback();
         final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
 		 Messagetext = ((String) mesg.get("message"));
	 }		
	 out.println("<body class='MESSAGE' BGCOLOR='#83AAB4'>");		  
	 out.println(Messagetext);			
 	 out.println("</body>");
	/*			 RequestDispatcher reqDis =	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayTransSettingExcelResult.jsp?&message="+message+"&module_id="+module_id+"&master_name="+masterName+"&language="+language+"&language_direction="+language_direction+"&application="+appl+"&display="+display+"&searchText="+searchText+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3);
			     reqDis.forward(request,response);*/
				 }
      catch(Exception exp)
      {																																																																																																																												 

		System.out.println("Error in calling getconnection method of XHTranslationSettingExcelUploadServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		
        
      }
		finally																  
		{
		  if(stmtUpdate != null) stmtUpdate.close();
		  if(oraclecallablestatement != null) oraclecallablestatement.close();
		  if(connection!=null) ConnectionManager.returnConnection(connection);	  
		  if(stmt != null)stmt.close();		  
		  if(rs!=null)rs.close();
	
		}


		
	}

	/*public boolean isRowEmpty(CommonCollectionUtils<String, String> rowMap, ArrayList<String> pkCols)
	{
		if(rowMap != null  && pkCols != null)
		{
			String val = "";
			for(String colName : pkCols)
			{
				val = rowMap.get(colName);
			}
			if(val!= null)
			{
				return (val.equals("")?true:false);
			}
		}
		return  true;
	}  */
}														  
