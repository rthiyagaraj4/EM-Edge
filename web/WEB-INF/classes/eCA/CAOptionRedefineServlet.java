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
21/11/2012	IN035914		Nijitha	   		CHL Hospital suggested that the presentation of the Clinician desktop be 
										    changed and more appealing. Keeping the display of information more clear and visible.
10/03/2022   29024          K.Pranay         unsed local variable[Common-ICN-0092]
-----------------------------------------------------------------------
*/
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

public class CAOptionRedefineServlet extends javax.servlet.http.HttpServlet
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
		String user_ldesc="";
		String userDefShtDescLeg="";//IN035914
		String user_style_codes="";//IN035914
		//String optionValStr1 = "",optionValStr2="",optionValStr3="";//IN035914
		String optionValStr1 = "",optionValStr2="",optionValStr3="", optionValStr5=""; //IN035914
		boolean bUpdated = true;

		optionValStr1= request.getParameter("optionValStr1");
		
		if(optionValStr1 == null || optionValStr1.equals(""))
			optionValStr1="";
		
		optionValStr2= request.getParameter("optionValStr2");
		
		if(optionValStr2 == null || optionValStr2.equals(""))
			optionValStr2="";
		
		optionValStr3= request.getParameter("optionValStr3");
		
		if(optionValStr3 == null || optionValStr3.equals(""))
			optionValStr3="";
		//IN035914 Start
		optionValStr5= request.getParameter("optionValStr5");
		
		if(optionValStr5 == null || optionValStr5.equals(""))
			optionValStr5="";
		//IN035914 End
		HashMap hMapAlter1 = new HashMap();
		HashMap hMapAlter2 = new HashMap();
		HashMap hMapAlter3 = new HashMap();
		HashMap hMapAlter4 = new HashMap(); //IN035914
		HashMap hMapAlter5 = new HashMap(); //IN035914
	//	HashMap hMapAlter6 = new HashMap(); //IN035914//Common-ICN-0092  
		HashMap htNameVal1	= new HashMap();
		HashMap htNameVal2	= new HashMap();
		HashMap htNameVal3	= new HashMap();
		//HashMap hm=new HashMap();//IN035914
		HashMap htNameVal4	= new HashMap();
		HashMap htNameVal5	= new HashMap();//IN035914
	//	HashMap htNameVal6	= new HashMap();//IN035914//Common-ICN-0092  
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
						hMapAlter1.put("OPTION_ID", value1);
						recordSet.setObject(index1, hMapAlter1); 
					}
					catch(Exception ex)
					{
						//out.println("Util Exception in CAOptionRedefineServlet.java ="+ex.toString());//common-icn-0181
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
						index_val2=name2.substring(3);
						index2	=Integer.parseInt(index_val2);
						hMapAlter2 = (java.util.HashMap)recordSet.getObject(index2);
						hMapAlter2.put("USER_DEF_SHORT_DESC", value2);
						recordSet.setObject(index2, hMapAlter2); 
					}
				    catch(Exception ex)
					{
						//out.println("Util Exception at CAOptionRedefineServlet.java 2 ="+ex.toString());//common-icn-0181
						ex.printStackTrace();
				    }
 				}
			}

			if(!optionValStr3.equals(""))
			{
				StringTokenizer stoken_code3 = new StringTokenizer(optionValStr3,"~");
				int count_code3=stoken_code3.countTokens();
				
				String name_value3		=	"";
				String name3			=	"";
				String value3			=	"";	
				String index_val3		=	"";

				int index3				=	0;

				for(int i=0;i<count_code3;i++)
				{
					name_value3 =	stoken_code3.nextToken();
            		htNameVal3.put("name_value3"+i,name_value3);
				}
			
				for(int j=0; j<htNameVal3.size(); j++)
				{
					name_value3=(String)htNameVal3.get("name_value3"+j);
					StringTokenizer split_value3	=	new StringTokenizer(name_value3,"||");
					name3=split_value3.nextToken();
					value3=split_value3.nextToken();
	
					if(value3.equals("0"))
						value3="";
			
					try
					{
						index_val3=name3.substring(3);
						index3	=Integer.parseInt(index_val3);

						hMapAlter3= (java.util.HashMap)recordSet.getObject(index3);
						hMapAlter3.put("USER_DEF_LONG_DESC", value3);
						recordSet.setObject(index3, hMapAlter3); 
					}
					catch(Exception ex)
					{
						//out.println("Util Exception at CAOptionRedefineServlet.java 3 == "+ex.toString());//common-icn-0181
						ex.printStackTrace();
					}
 				}
			}

			//IN035914 Starts
			if(!optionValStr5.equals(""))
			{
               	StringTokenizer stoken_code5 = new StringTokenizer(optionValStr5,"~");
				int count_code4=stoken_code5.countTokens();
			
				String userDefStyles		= ""; 
				String boldTrigger			= "";
				String colorPallete		= "";
				String bgColorPallete		= "";
				String index_val5		= "";
			//	String index_val6		= "";//Common-ICN-0092  
				
				String style ="";
			//	String styles="";//Common-ICN-0092  
				int index				=	0;
			  //int styleindex				=	0;//Common-ICN-0092  
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
					if( colorPallete.equals("0")){
						colorPallete="000000";
						styleCodes=styleCodes+"||"+"000000";
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
					if( shortDesc.equals("0"))
						shortDesc="";
					index_val5 = split_value5.nextToken();
					}
					style = "<font style=background-color:"+bgColorPallete+" color="+colorPallete+">"+boldTriggerst+""+shortDesc+""+boldTriggeret+"</font>";
					//styleCodes=boldTrigger+"||"+colorPallete+"||"+bgColorPallete;
					try
					{
						
						index	=Integer.parseInt(index_val5);
						hMapAlter5 = (java.util.HashMap)recordSet.getObject(index);
						hMapAlter5.put("USER_DEF_COLOR_CODE", styleCodes);
						hMapAlter5.put("USER_DEF_SHORT_DESC_LEGEND", style);
						recordSet.setObject(index, hMapAlter5); 
						
					}
					catch(Exception ex)
					{
						//out.println("Util Exception in CAOptionRedefineServlet.java ="+ex.toString());//common-icn-0181
						ex.printStackTrace();
					}
						boldTriggerst="";
						boldTriggeret="";
 				}
				
			
				}
			
			
			//IN035914 Ends
			con = ConnectionManager.getConnection(request);
			int row_count=recordSet.getSize();

			StringBuffer sql= new StringBuffer();
			String error="";//IN035914
			if(sql.length() > 0) 
				sql.delete(0,sql.length());
		
			//sql.append("UPDATE CA_OPTION SET USER_DEF_SHORT_DESC=?,"); sql.append("USER_DEF_LONG_DESC=? WHERE OPTION_ID=? ");//IN035914
			sql.append("UPDATE CA_OPTION SET USER_DEF_SHORT_DESC=?,"); sql.append("USER_DEF_LONG_DESC=?, USER_DEF_SHORT_DESC_LEGEND=? ,USER_DEF_COLOR_CODE=? WHERE OPTION_ID=? ");//IN035914
			pst= con.prepareStatement(sql.toString());
	
			int rt= 0;
			int [] updCount=null;
			for(int k=0; k<row_count; k++)
			{	HashMap hm=new HashMap();
				hm=(java.util.HashMap)recordSet.getObject(k);
				opt_id=(String)hm.get("OPTION_ID");
				user_sdesc= (String) hm.get("USER_DEF_SHORT_DESC");
				user_ldesc=(String) hm.get("USER_DEF_LONG_DESC");
				//IN035914 Starts
				user_style_codes=(String) hm.get("USER_DEF_COLOR_CODE");
				userDefShtDescLeg=(String) hm.get("USER_DEF_SHORT_DESC_LEGEND");
				//IN035914 Ends
				if(null!=user_sdesc && !"".equals(user_sdesc.trim()))
				{
				pst.setString(1,user_sdesc);
				pst.setString(2,user_ldesc);
				//IN035914 Starts
				pst.setString(3,userDefShtDescLeg);
				pst.setString(4,user_style_codes);
				//IN035914 Ends
				//pst.setString(3,opt_id);//IN035914
				pst.setString(5,opt_id);
				pst.addBatch();
				rt++;
			}
				else
				{
				error=" - User Defined Short Description Cannot Be Empty";
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
			//String error = getMessage(locale, "FAILED_TRANSACTION","CA");//IN035914
			error = getMessage(locale, "FAILED_TRANSACTION","CA")+error;
		
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
			//out.println("Update Exception from CAOptionRedefineServlet.java = "+e.toString());//common-icn-0181
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
				//hm.clear();
		//IN035914 Starts
				hMapAlter4.clear();
				htNameVal4.clear();
				hMapAlter5.clear();
				htNameVal5.clear();
		//IN035914 Ends
				if(con!=null) ConnectionManager.returnConnection(con,request);
		 }
	}
}
