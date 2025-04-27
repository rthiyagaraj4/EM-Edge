/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
 *  The XHFilterRuleRecordServlet class used to  implements the functionalities for filtering rules and scheduling 
 *
 */
public class XHDataElementRefProfileServlet extends HttpServlet 
{
    
	/**
	 * Do post method which implements the functionalities for filtering rules and scheduling 
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @throws IOException
	 * @throws ServletException
	 */
 
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
	  
    Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "",status="0";
     String sStyle = "";
    String exceptions="";
    String mode="";
	String applicationid="";
	 String elementid="";
	 String derivation_type="";
	   String cond_exprsn="";
	   String expected_value="";
	    String execution_order="";
		  String expected_value2="";
		  String position_value="";
    HttpSession session = request.getSession(false);
	MessageManager mm=new MessageManager();
PrintWriter out;
		out=response.getWriter();
		//req=request;
		 Properties p;
	
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
    	request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
  
    try
    { 
		out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
     out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
     out.println("<body class='MESSAGE'>"); 
		 mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
//			System.out.println("mode : "+mode);
	  
	  applicationid=XHDBAdapter.checkNull(request.getParameter("application_id"));
//	        System.out.println("applicationid : "+applicationid);
     
       elementid=XHDBAdapter.checkNull(request.getParameter("element_id"));
//	        System.out.println("elementid : "+elementid);
	
      derivation_type=XHDBAdapter.checkNull(request.getParameter("derivation_type"));
//	        System.out.println("derivation_type : "+derivation_type);

       cond_exprsn=XHDBAdapter.checkNull(request.getParameter("cond_exprsn"));
//	        System.out.println("cond_exprsn : "+cond_exprsn);
		     
       expected_value=XHDBAdapter.checkNull(request.getParameter("expected_value"));
//	  System.out.println("expected_value : "+expected_value);
	
       execution_order=XHDBAdapter.checkNull(request.getParameter("execution_order"));
//	  System.out.println("execution_order : "+execution_order);

       expected_value2=XHDBAdapter.checkNull(request.getParameter("expected_value2"));
//	  System.out.println("expected_value : "+expected_value2);
	
	   position_value=XHDBAdapter.checkNull(request.getParameter("Position_value"));
//	  System.out.println("Position_value : "+position_value);
 
     // System.out.println("arrFilterInfo : "+arrFilterInfo);
//	  request.getParameter("jspmode");
     // arrAudit = AuditInfo.getArrayAuditInfo(session);
	  // System.out.println("arrAudit : "+arrAudit);
    }
	catch(Exception exp)
    {
       System.out.println("Error in dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {
      ostmt = connection.prepareCall("{ CALL xg_prc.xh_profile_derivation_rules(?,?,?,?,?,?,?,?,?,?,?) }" ); 
//		System.out.println("prepareCall xg_prc.xh_profile_derivation_rules");
/*
      arrFilterInfo.add(mode);
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("rowid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("applicationid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("elementid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("derivation_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("cond_exprsn")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("expected_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("execution_order")));
*/
    	
//		 System.out.println("values"+mode+"applicationid,"+applicationid+"elementid,"+elementid+"derivation_type,"+derivation_type+"cond_exprsn,"+cond_exprsn+"expected_value,"+expected_value+"execution_order,"+execution_order+"position,"+position_value);
		  ostmt.setString(1,mode);
		   ostmt.setString(2,execution_order);
		  ostmt.setString(3,applicationid);
		  ostmt.setString(4,elementid);
		  ostmt.setString(5,derivation_type);
		  ostmt.setString(6,cond_exprsn);
		  ostmt.setString(7,expected_value);
		      ostmt.setString(8,position_value);
		  ostmt.setString(9,expected_value2);
	 
		 
		//  ostmt.setString(11,usr_facility_by_id);
		  ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);

        ostmt.execute();
        status = ostmt.getString(10);
//		System.out.println("status"+status);
        message_text = ostmt.getString(11);

        if (status.equals("0"))
        {
          connection.commit(); 
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		  status = ((String) mesg.get("message"));
//         System.out.println("status12"+status);
        }
        else
        {
          boolean chkStat=false;
          connection.rollback();
		  chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
//		        System.out.println("status123"+status);
		  if(chkStat)
		  {
			   final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
		       status = ((String) mesg.get("message"));
		  }
		  else 
		  {
               final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	           status = ((String) mesg.get("message"));
	
		  }
        }


		out.println("");
       out.println(status);
       out.println("");
       out.println("</body>");  
       if(ostmt!=null)ostmt.close();
                   
      }
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());
	     exp.printStackTrace(System.err);
		
        
      }
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in dooperate method of XHDataElementCrossRefElementIDServlet :"+e.toString());
	      e.printStackTrace(System.err);
	  }
 /*  // HttpSession session = request.getSession(false);
	//Properties p;		
	//p = (Properties) session.getValue("jdbc");	
	/String locale  = p.getProperty("LOCALE");
	String mode="";
	mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
	request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    String msgStatus=doOperate(request,response,locale);
   
	RequestDispatcher reqDis=null;

	if((mode.equals("M"))||(mode.equals("U"))||(mode.equals("D")))
	{
	 reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayFilterResult.jsp?message="+msgStatus+"");
    }
	else
	{
		System.out.println("Req Dsptchr mode othr thn M,U,D");
		reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+msgStatus+"");
	 }
	reqDis.forward(request,response);*/	

  }

  /**
	 * Do operate method is used to filter data manipulation
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @param  String locale
	 * @throws IOException
	 * @throws ServletException
	 */
 
/*  public String doOperate(HttpServletRequest request, HttpServletResponse response,String locale) throws ServletException, IOException
  {
  
    Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "",status="0";
    
    String exceptions="";
    ArrayList arrFilterInfo = new ArrayList(23);
    ArrayList arrAudit = new ArrayList();
    HttpSession session = request.getSession(false);
	MessageManager mm=new MessageManager();

    try
    { 
		String mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
			System.out.println("mode : "+mode);
	  
	  String applicationid=XHDBAdapter.checkNull(request.getParameter("application_id"));
	        System.out.println("applicationid : "+applicationid);
     
      String elementid=XHDBAdapter.checkNull(request.getParameter("element_id"));
	        System.out.println("elementid : "+elementid);
	
      String derivation_type=XHDBAdapter.checkNull(request.getParameter("derivation_type"));
	        System.out.println("derivation_type : "+derivation_type);

      String cond_exprsn=XHDBAdapter.checkNull(request.getParameter("cond_exprsn"));
	        System.out.println("cond_exprsn : "+cond_exprsn);
		     
      String expected_value=XHDBAdapter.checkNull(request.getParameter("expected_value"));
	  System.out.println("expected_value : "+expected_value);
	
      String execution_order=XHDBAdapter.checkNull(request.getParameter("execution_order"));
	  System.out.println("execution_order : "+execution_order);

      String expected_value2=XHDBAdapter.checkNull(request.getParameter("expected_value2"));
	  System.out.println("expected_value : "+expected_value2);
	
	  String position_value=XHDBAdapter.checkNull(request.getParameter("Position_value"));
	  System.out.println("Position_value : "+position_value);
 
      System.out.println("arrFilterInfo : "+arrFilterInfo);
//	  request.getParameter("jspmode");
      arrAudit = AuditInfo.getArrayAuditInfo(session);
	   System.out.println("arrAudit : "+arrAudit);
    }
	catch(Exception exp)
    {
       System.out.println("Error in dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {
       connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {
      ostmt = connection.prepareCall("{ CALL xg_prc.xh_profile_derivation_rules(?,?,?,?,?,?,?,?,?,?,?) }" ); 
		System.out.println("prepareCall xg_prc.xh_profile_derivation_rules");
/*
      arrFilterInfo.add(mode);
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("rowid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("applicationid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("elementid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("derivation_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("cond_exprsn")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("expected_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("execution_order")));

    	
		  System.out.println("values"+mode1+"applicationid,"+applicationid+"elementid,"+elementid+"derivation_type,"+derivation_type+"cond_exprsn,"+cond_exprsn+"expected_value,"+expected_value+"execution_order,"+execution_order+"position,"+position+"usr_added_by_id,"+usr_added_by_id+"usr_added_at_ws_no,"+usr_added_at_ws_no);
		  ostmt.setString(1,mode);
		  ostmt.setString(3,applicationid);
		  ostmt.setString(4,elementid);
		  ostmt.setString(5,derivation_type);
		  ostmt.setString(6,cond_exprsn);
		  ostmt.setString(7,expected_value);
		  ostmt.setString(2,execution_order);
		  ostmt.setString(9,expected_value2);
	      ostmt.setString(8,position);
		 
		//  ostmt.setString(11,usr_facility_by_id);
		  ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);

        ostmt.execute();
        status = ostmt.getString(10);
		System.out.println("status"+status);
        message_text = ostmt.getString(11);

        if (status.equals("0"))
        {
          connection.commit(); 
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		  status = ((String) mesg.get("message"));
         System.out.println("status12"+status);
        }
        else
        {
          boolean chkStat=false;
          connection.rollback();
		  chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		        System.out.println("status123"+status);
		  if(chkStat)
		  {
			   final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
		       status = ((String) mesg.get("message"));
		  }
		  else 
		  {
               final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	           status = ((String) mesg.get("message"));
	
		  }
        }
       if(ostmt!=null)ostmt.close();
                   
      }
      catch(Exception exp)
      {
         System.out.println("Error in calling dbrealted statements in dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());
	     exp.printStackTrace(System.err);
		
        
      }
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in dooperate method of XHDataElementCrossRefElementIDServlet :"+e.toString());
	      e.printStackTrace(System.err);
	  }
	 // status=message_text;
	 
  }*/

 /**
	 * containsSubstring method which finds the sub string exists in main strinng 
	 * @param  String mainString
	 * @param  String subString
	 */
 
  public boolean  containsSubstring(String mainString, String subString)
  {
     boolean status = false; 
     Pattern pattern = Pattern.compile(subString);
	 Matcher matcher = pattern.matcher(mainString); 
	 status = matcher.find();
	 return status; 
  }


}//end of class 
