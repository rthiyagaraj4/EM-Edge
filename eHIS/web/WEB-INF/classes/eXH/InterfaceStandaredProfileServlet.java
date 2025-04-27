/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
import eXH.XHTYPE;
import java.util.regex.*;
/**
 *  Class used to update InterfaceStandard setup
 *
 */
public class InterfaceStandaredProfileServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for InterfaceStandard setup
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
						//ConnectionMethod(request,response);
    	PrintWriter out;
		out=response.getWriter();
		String Application_Specific_txt="";
		//req=request;
		 String sStyle = "";
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
    	request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
        Connection connection = null;
	    CallableStatement  oraclecallablestatement = null;
		MessageManager mm=new MessageManager();
	    String p_mode=request.getParameter("act_mode");	
		String standard_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
		String ProfileId=XHDBAdapter.checkNull(request.getParameter("profile_id"));
		String Short_desc=XHDBAdapter.checkNull(request.getParameter("short_desc"));
		String Long_desc=request.getParameter("Long_desc");	
		String version_spcific=XHDBAdapter.checkNull(request.getParameter("Version_Specific"));
		String Geography_specific=XHDBAdapter.checkNull(request.getParameter("Geography_Specific"));
		String Site_Specific=XHDBAdapter.checkNull(request.getParameter("Site_Specific"));
		String Application_specific=XHDBAdapter.checkNull(request.getParameter("Application_Specific"));
		String Version_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Version_Specific_txt"));	
        String Geography_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Geography_Specific_txt"));

		
		 Application_Specific_txt=XHDBAdapter.checkNull(request.getParameter("application_id1"));
				
        String Site_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Site_Specific_txt"));



		ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
		String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1);
        
try
	{
	out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
     out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
     out.println("<body class='MESSAGE'>"); 
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of InterfaceStandardAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }

	  try
		{
	//	  System.out.println(p_mode+"ProfileId"+ProfileId+"Short_desc"+Short_desc+"LONG"+Long_desc+"S_code"+standard_code+"Specific_txt_v"+version_spcific+"TXT"+Version_Specific_txt+"Specific_txt1_g"+Geography_specific+"TXT"+Geography_Specific_txt+"Specific_txt_A"+Application_specific+"TXT"+Application_Specific_txt+"Site_Specific_txt"+Site_Specific+"TXT"+Site_Specific_txt+""+usr_added_by_id+""+usr_added_at_ws_no);
        oraclecallablestatement = connection.prepareCall("{ call Xg_prc.xh_standard_profile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
    //    System.out.println("p_mode"+p_mode);
		
		oraclecallablestatement.setString(1,p_mode);

  // System.out.println("ProfileId"+ProfileId);
		oraclecallablestatement.setString(2,ProfileId);
 //System.out.println("Short_desc"+Short_desc);
		oraclecallablestatement.setString(3,Short_desc);

//		System.out.println("LONG"+Long_desc);
	    oraclecallablestatement.setString(4,Long_desc);
//System.out.println("standard_code"+standard_code);
        oraclecallablestatement.setString(5,standard_code);
//System.out.println("version_spcific"+version_spcific);
        oraclecallablestatement.setString(6,version_spcific);
//System.out.println("Version_Specific_txt"+Version_Specific_txt);
	    oraclecallablestatement.setString(7,Version_Specific_txt);
//System.out.println("Geography_specific"+Geography_specific);
		oraclecallablestatement.setString(8,Geography_specific);
//System.out.println("Geography_Specific_txt"+Geography_Specific_txt);
		oraclecallablestatement.setString(9,Geography_Specific_txt);
//		System.out.println("Application_specific"+Application_specific);
        oraclecallablestatement.setString(10,Application_specific);
//		System.out.println("Application_Specific_txt"+Application_Specific_txt);
        oraclecallablestatement.setString(11,Application_Specific_txt);
//		System.out.println("Site_Specific"+Site_Specific);
		oraclecallablestatement.setString(12,Site_Specific);
//		System.out.println("Site_Specific_txt"+Site_Specific_txt);
	    oraclecallablestatement.setString(13,Site_Specific_txt);
	
        oraclecallablestatement.setString(14,usr_added_by_id);	
		
        oraclecallablestatement.setString(15,usr_added_at_ws_no);	
	
	    oraclecallablestatement.registerOutParameter(16,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(17,java.sql.Types.VARCHAR);
	    oraclecallablestatement.execute();
        String status2 = oraclecallablestatement.getString(16);
		String status="";
//        System.out.println("Status2"+status2);

	if(oraclecallablestatement!=null) oraclecallablestatement.close();
	  
	   if(status2.equals("0"))
		{
		connection.commit();

		
		if(p_mode.equals("D"))
			{
final java.util.Hashtable mesg = mm.getMessage(locale, "XH1036", "XH") ;
		status = ((String) mesg.get("message"));

			}
			else
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		status = ((String) mesg.get("message"));


			}
		
		
		
//out.println("<script>parent.frames(2).document.forms(0).reset(); parent.frames(1).refresh();</script>");


		}
		else if(status2.equals("2"))
		{
		 connection.rollback();
		final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
		status = ((String) mesg.get("message"));
			
			}
	    else
		{
		 connection.rollback();
		 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
 		 status = ((String) mesg.get("message"));
		 out.println("<script> </script>");
		}
       out.println("");
       out.println(status);
       out.println("");

       out.println("</body>");  

out.println("<script> </script>");
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceStandardAddModifyServlett  :"+ex.toString());
		//exceptions=exceptions+"3"+"*"+ex.toString();
		//ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of InterfaceStandardAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
	 //System.out.println("status "+status2);  
	 

//RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
       // reqDis.forward(request,response);
		
		

	/*	arrColumn.add(p_mode);
		arrColumn.add(standard_code);
		arrColumn.add(standard_desc);
		arrColumn.add(standard_type);
		arrColumn.add(msg_start);		
		arrColumn.add(msg_end);
		arrColumn.add(seg_start);
		arrColumn.add(seg_end);
		arrColumn.add(fld_separator);
		arrColumn.add(elmnt_separator);
  //	arrColumn.add(lang_id);*/
		   
				
        //RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
        //reqDis.forward(request,response);		


	}// end of do post

 /**
	 * callEJB method is used to call InterfaceStandardAddModifyServlet setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	/*public HashMap callEJB(HashMap details_hm,String locale )
   {
    

	Connection connection = null;
	CallableStatement ostmt = null;
	String message_text2 = "";
	String status="";
	String exceptions="";
	HashMap result_hm=new HashMap();
		
	ArrayList row_arr = (ArrayList) details_hm.get("row_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");
	
	  
    
 
	
	try
	

	 

		  String  p_mode=(String)row_arr.get(0);
   	      String  standard_code=(String)row_arr.get(1);
		  String  standard_desc=(String)row_arr.get(2);
		  String  standard_type=(String)row_arr.get(3);
		  String  msg_start=(String)row_arr.get(4);
		  String  msg_end=(String)row_arr.get(5);
		  String  seg_start=(String)row_arr.get(6);
		  String  seg_end=(String)row_arr.get(7);
   	      String  fld_separator=(String)row_arr.get(8);
		  String  elmnt_separator=(String)row_arr.get(9);
 //       String  lang_id=(String)row_arr.get(23);
   
		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

		 ostmt.setString(1,p_mode);
			 System.out.println("Call EJB p_mode : "+p_mode);
		 ostmt.setString(2,standard_code);
  	 		 System.out.println("Call EJB standard_code : "+standard_code);
	     ostmt.setString(3,standard_desc);
		 ostmt.setString(4,standard_type);
 	 		 System.out.println("Call EJB standard_type : "+standard_type);
		 ostmt.setString(5,msg_start);
  	 		 System.out.println("Call EJB msg_start : "+msg_start);
		 ostmt.setString(6,msg_end);
		 ostmt.setString(7,seg_start);
		 ostmt.setString(8,seg_end);
   	 		 System.out.println("Call EJB seg_end : "+seg_end);
		 ostmt.setString(9,fld_separator);
	     ostmt.setString(10,elmnt_separator);
   	 		 System.out.println("Call EJB elmnt_separator : "+elmnt_separator);
	//	 ostmt.setString(23,lang_id);
		 		 		  
		 ostmt.setString(11,usr_added_by_id);
		 ostmt.setString(12,usr_added_at_ws_no);
	 
	     ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(14,java.sql.Types.VARCHAR);
	     ostmt.execute();
	
	     String status2= ostmt.getString(13);
	 		 System.out.println("Call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(14);

	     ostmt.close();
	    
//	     if(message_text2.equals("0"))
	    
	    
	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}*/// end of callEJB function

public void ConnectionMethod(HttpServletRequest request, HttpServletResponse response)
	{

  	

	}//end of ConnectionMethod














}// end of class
