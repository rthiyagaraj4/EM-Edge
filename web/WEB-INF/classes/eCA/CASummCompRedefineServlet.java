/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
27/11/2012    101          Nijitha S    	Incident No: IN035914 -  Master Setup for Summary Component.
19/04/2013	 IN039243		Nijitha     Alpha-CA-Redefine Summary Component->System is displaying different Font color when select the Bold option											
20/05/2013   IN039811	  Nijitha S		CA-Redefine Summary Component->System is displaying Blue Font color when select the Bold option								
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178
-----------------------------------------------------------------------
*/
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class CASummCompRedefineServlet extends javax.servlet.http.HttpServlet
{
   	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out;
		PreparedStatement pst= null;
		Connection con= null;
		
		out=response.getWriter();
		
		String opt_id = "";
		String user_sdesc="";
		//String user_ldesc="";//51003
		String userDefShtDescLeg="";
		String user_style_codes="";
		String optionValStr1 = "",optionValStr2="", optionValStr5="";
		boolean bUpdated = true;

		optionValStr1= request.getParameter("optionValStr1");
		
		if(optionValStr1 == null || optionValStr1.equals(""))
			optionValStr1="";
		
		optionValStr2= request.getParameter("optionValStr2");
		
		if(optionValStr2 == null || optionValStr2.equals(""))
			optionValStr2="";
		
		optionValStr5= request.getParameter("optionValStr5");
		
		if(optionValStr5 == null || optionValStr5.equals(""))
			optionValStr5="";

		HashMap hMapAlter1 = new HashMap();
		HashMap hMapAlter2 = new HashMap();
		HashMap hMapAlter3 = new HashMap();
		HashMap hMapAlter4 = new HashMap();
		HashMap hMapAlter5 = new HashMap();
		HashMap htNameVal1	= new HashMap();
		HashMap htNameVal2	= new HashMap();
		HashMap htNameVal3	= new HashMap();
		HashMap htNameVal4	= new HashMap();
		HashMap htNameVal5	= new HashMap();
		
		
		HttpSession hs		= request.getSession(false);
		Properties p;
		p = (java.util.Properties) hs.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		webbeans.eCommon.RecordSet recordSet= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("SubSecRecordSet","webbeans.eCommon.RecordSet",hs);

		try
		{
		
			if(!optionValStr1.equals(""))
			{
               	StringTokenizer stoken_code1 = new StringTokenizer(optionValStr1,"~");
				int count_code1=stoken_code1.countTokens();
			
				String name_value1		= "";
				String name1			= "";
				String value1			= "";
				String index_val1		= "";

				int index1				=	0;

				for(int i=0;i<count_code1;i++)
				{
					name_value1 =	stoken_code1.nextToken();
                    htNameVal1.put("name_value1"+i,name_value1);
				}
				
				for(int j=0; j<htNameVal1.size(); j++)
				{
					name_value1						=	(String)htNameVal1.get("name_value1"+j);
					StringTokenizer split_value1	=	new StringTokenizer(name_value1,"||");

					name1				=	split_value1.nextToken();
					value1				=	split_value1.nextToken();

					try
					{
						index_val1=name1.substring(6);
						index1	=Integer.parseInt(index_val1);
						hMapAlter1 = (java.util.HashMap)recordSet.getObject(index1);
						hMapAlter1.put("SUMMARY_COMP_ID", value1);
						recordSet.setObject(index1, hMapAlter1); 
					}
					catch(Exception ex)
					{
						//out.println("Util Exception in CAOptionRedefineServlet.java ="+ex.toString());common-icn-0181
						ex.printStackTrace();
					}
 				}
			}

			if(!optionValStr2.equals(""))
			{
              	StringTokenizer stoken_code2 = new StringTokenizer(optionValStr2,"~");
				int count_code2=stoken_code2.countTokens();
				
				String name_value2	=	"";
				String name2		=	"";	
				String value2		=	"";
				String index_val2	=	"";
				
				int index2			=	0;

				for(int i=0;i<count_code2;i++)
				{
					name_value2 =	stoken_code2.nextToken();
                	htNameVal2.put("name_value2"+i,name_value2);
				}
				
				for(int j=0; j<htNameVal2.size(); j++)
				{
					name_value2=(String)htNameVal2.get("name_value2"+j);
					
					StringTokenizer split_value2	=	new StringTokenizer(name_value2,"||");
					
					name2=split_value2.nextToken();
					value2=	split_value2.nextToken();
					
					if(value2.equals("0"))
						value2="";

					try
					{
						//index_val2=name2.substring(3);
						index_val2=name2.substring(9);
						index2	=Integer.parseInt(index_val2);						
						hMapAlter2 = (java.util.HashMap)recordSet.getObject(index2);
						hMapAlter2.put("SUMMARY_COMP_DESC_USER", value2);
						recordSet.setObject(index2, hMapAlter2); 
					}
				    catch(Exception ex)
					{
						//out.println("Util Exception at CAOptionRedefineServlet.java 2 ="+ex.toString());common-icn-0181
						ex.printStackTrace();
				    }
 				}
			}
			
			if(!optionValStr5.equals(""))
			{
               	StringTokenizer stoken_code5 = new StringTokenizer(optionValStr5,"~");
				int count_code4=stoken_code5.countTokens();
			
				String userDefStyles		= ""; 
				String boldTrigger			= "";
				String colorPallete		= "";
				String bgColorPallete		= "";
				String index_val5		= "";
				String style ="";
				int index				=	0;
				String shortDesc ="";
				String styleCodes="";
				String boldTriggerst ="";
				String boldTriggeret ="";
				for(int i=0;i<count_code4;i++)
				{
					userDefStyles =	stoken_code5.nextToken();
                    htNameVal5.put("userDefStyles"+i,userDefStyles);
				}
				
				for(int j=0; j<htNameVal5.size(); j++)
				{
					userDefStyles						=	(String)htNameVal5.get("userDefStyles"+j);
					if(null!=userDefStyles && !"null".equals(userDefStyles) && !"".equals(userDefStyles)){
						StringTokenizer split_value5	=	new StringTokenizer(userDefStyles,"||");

						boldTrigger				=	split_value5.nextToken();
						colorPallete				=	split_value5.nextToken();
						bgColorPallete				=	split_value5.nextToken();
						shortDesc				=	split_value5.nextToken();
						
						
						if(boldTrigger.equals("0") ){
							boldTrigger="";
							styleCodes="0";
						}else
						{
							styleCodes = boldTrigger;
							boldTriggerst="<b>";
							boldTriggeret="</b>";
						}
						if( colorPallete.equals("000000")){
							colorPallete="000000";
							styleCodes=styleCodes+"||"+"000000";
						}
						else if(colorPallete.equals("0"))
						{
							styleCodes=styleCodes+"||"+colorPallete;
							colorPallete="";
						}
						else
						{
						styleCodes=styleCodes+"||"+colorPallete;
						}
						if( bgColorPallete.equals("0")){
							bgColorPallete="";
							styleCodes=styleCodes+"||"+"0";
						}
						else
						{
							styleCodes=styleCodes+"||"+bgColorPallete;
						}
						//IN039243 Starts
						if(!"".equals(bgColorPallete) && !"".equals(boldTrigger) && "".equals(colorPallete))
						{
							System.out.println("CASummCompRedefineServlet.java:Line:254");
							colorPallete="000000";
							styleCodes=boldTrigger+"||"+colorPallete+"||"+bgColorPallete;
						}
						//IN039243 Ends
						//IN039811 Starts
						if(!"".equals(boldTrigger) && "".equals(colorPallete))
						{
							colorPallete="000000";
							if("".equals(bgColorPallete))
							bgColorPallete="0";
							styleCodes=boldTrigger+"||"+colorPallete+"||"+bgColorPallete;
						}	
						//IN039811 Ends
						if( shortDesc.equals("0"))
							shortDesc="";
					index_val5 = split_value5.nextToken();
					
					}
					style = "<font style=background-color:"+bgColorPallete+" color="+colorPallete+">"+boldTriggerst+""+shortDesc+""+boldTriggeret+"</font>";
					try
					{
						
						index	=Integer.parseInt(index_val5);

						hMapAlter5 = (java.util.HashMap)recordSet.getObject(index);
						hMapAlter5.put("SUMCOMP_USER_DEF_COLOR_CODE", styleCodes);
						hMapAlter5.put("SUMMARY_COMP_DESC_LEGEND", style);
						recordSet.setObject(index, hMapAlter5); 
					}
					catch(Exception ex)
					{
						//out.println("Util Exception in CASummaryCompRedefineServlet.java ="+ex.toString());common-icn-0181
						ex.printStackTrace();
					}
					boldTriggerst="";
					boldTriggeret="";
 				}
			}
			
			con = ConnectionManager.getConnection(request);
			int row_count=recordSet.getSize();

			StringBuffer sql= new StringBuffer();
			String error="";//NIJI
			if(sql.length() > 0) 
				sql.delete(0,sql.length());
		
			sql.append("UPDATE sm_desktop_sum_comp SET SUMMARY_COMP_DESC_USER=?,"); 
			sql.append("SUMMARY_COMP_DESC_LEGEND=? ,SUMCOMP_USER_DEF_COLOR_CODE=? WHERE SUMMARY_COMP_ID=? ");//IN035914
			pst= con.prepareStatement(sql.toString());
			int rt= 0;
			int [] updCount=null;
			for(int k=0; k<row_count; k++)
			{
				HashMap hm=new HashMap();
				hm=(java.util.HashMap)recordSet.getObject(k);
				opt_id=(String)hm.get("SUMMARY_COMP_ID");
				user_sdesc= (String) hm.get("SUMMARY_COMP_DESC_USER");
				if(null!=user_sdesc && !"".equals(user_sdesc.trim())){
				user_style_codes=(String) hm.get("SUMCOMP_USER_DEF_COLOR_CODE");
				userDefShtDescLeg=(String) hm.get("SUMMARY_COMP_DESC_LEGEND");
				pst.setString(1,user_sdesc);
				pst.setString(2,userDefShtDescLeg);
				pst.setString(3,user_style_codes);
				pst.setString(4,opt_id);
				pst.addBatch();
				rt++;
				}else{
				error=" - User Defined Summary Description Cannot Be Empty";
				}
				
			}
			
			if(rt==row_count){
				updCount = pst.executeBatch();
				
				if(updCount.length == -3 || updCount.length < row_count)
					bUpdated = false;
			}else{
				bUpdated = false;
			}
			

			String error_value	= "0" ;
			//String error = getMessage(locale, "FAILED_TRANSACTION","CA");//Niji
			error = getMessage(locale, "FAILED_TRANSACTION","CA")+error;//Niji
			if(bUpdated)
			{
				con.commit();
				error_value	= "1" ;
				error = getMessage(locale, "RECORD_INSERTED","CA");
			}
			else 
				con.rollback();

	response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
	
			if(pst!=null) pst.close();
		}//try
		catch(Exception e)
		{
			//out.println("Update Exception from CAOptionRedefineServlet.java = "+e.toString());common-icn-0181
			e.printStackTrace();
		}
		finally
		{					
				hMapAlter1.clear();
				htNameVal1.clear();
				hMapAlter2.clear();
				htNameVal2.clear();
				hMapAlter3.clear();
				htNameVal2.clear();
				htNameVal3.clear();
				hMapAlter4.clear();
				htNameVal4.clear();
				hMapAlter5.clear();
				htNameVal5.clear();
				
				if(con!=null) ConnectionManager.returnConnection(con,request);
		 }
	}
}
