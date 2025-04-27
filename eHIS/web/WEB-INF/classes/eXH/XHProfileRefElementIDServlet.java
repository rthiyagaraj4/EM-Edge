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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
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
public class XHProfileRefElementIDServlet extends HttpServlet 
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
    HttpSession session = request.getSession(false);
	Properties p;		
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");
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
	//	System.out.println("Req Dsptchr mode othr thn M,U,D");
		reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+msgStatus+"");
	 }
	reqDis.forward(request,response);	

  }

  /**
	 * Do operate method is used to filter data manipulation
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @param  String locale
	 * @throws IOException
	 * @throws ServletException
	 */
 
  public String doOperate(HttpServletRequest request, HttpServletResponse response,String locale) throws ServletException, IOException
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
    { String mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
	//		System.out.println("mode : "+mode);
	  arrFilterInfo.add(mode);
	  String applicationid=XHDBAdapter.checkNull(request.getParameter("Protocol_linkname"));
	//        System.out.println("applicationid : "+applicationid);
      arrFilterInfo.add(applicationid);
      String elementid=XHDBAdapter.checkNull(request.getParameter("element_id"));
	//        System.out.println("elementid : "+elementid);
	  arrFilterInfo.add(elementid);
      String derivation_type=XHDBAdapter.checkNull(request.getParameter("derivation_type"));
	//        System.out.println("derivation_type : "+derivation_type);
	  arrFilterInfo.add(derivation_type);
      String cond_exprsn=XHDBAdapter.checkNull(request.getParameter("cond_exprsn"));
	//        System.out.println("cond_exprsn : "+cond_exprsn);
	  arrFilterInfo.add(cond_exprsn);	     
      String expected_value=XHDBAdapter.checkNull(request.getParameter("expected_value"));
	//  System.out.println("expected_value : "+expected_value);
	  arrFilterInfo.add(expected_value);
      String execution_order=XHDBAdapter.checkNull(request.getParameter("execution_order"));
	//  System.out.println("execution_order : "+execution_order);
arrFilterInfo.add(execution_order);
      String expected_value2=XHDBAdapter.checkNull(request.getParameter("expected_value2"));
	//  System.out.println("expected_value : "+expected_value2);
	  arrFilterInfo.add(expected_value2);
	  String position_value=XHDBAdapter.checkNull(request.getParameter("Position_value"));
	//  System.out.println("Position_value : "+position_value);
      arrFilterInfo.add(position_value);
   //   System.out.println("arrFilterInfo : "+arrFilterInfo);
//	  request.getParameter("jspmode");
      arrAudit = AuditInfo.getArrayAuditInfo(session);
	//   System.out.println("arrAudit : "+arrAudit);
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
      ostmt = connection.prepareCall("{ CALL Xg_prc.xh_Profile_derivation_rules(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
//		System.out.println("prepareCall Xg_prc.xh_appl_derivation_rules ");
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
    	  String  mode1=(String)arrFilterInfo.get(0);
   	  	  String  Protocolid=(String)arrFilterInfo.get(1);
		  String  elementid=(String)arrFilterInfo.get(2);
          String  derivation_type=(String)arrFilterInfo.get(3);
   	      String  cond_exprsn=(String)arrFilterInfo.get(4);
		  String  expected_value=(String)arrFilterInfo.get(5);
		  String  execution_order=(String)arrFilterInfo.get(6);
		  String  expected_value2=(String)arrFilterInfo.get(7);
	      String  position=(String)arrFilterInfo.get(8);
          String  usr_added_by_id=(String)arrAudit.get(0);
		  String  usr_added_at_ws_no=(String)arrAudit.get(1);
	//	  System.out.println("values"+mode1+"applicationid,"+Protocolid+"elementid,"+elementid+"derivation_type,"+derivation_type+"cond_exprsn,"+cond_exprsn+"expected_value,"+expected_value+"execution_order,"+execution_order+"position,"+position+"usr_added_by_id,"+usr_added_by_id+"usr_added_at_ws_no,"+usr_added_at_ws_no);
		  ostmt.setString(1,mode1);
		  ostmt.setString(2,Protocolid);
		  ostmt.setString(3,elementid);
		  ostmt.setString(4,derivation_type);
		  ostmt.setString(5,cond_exprsn);
		  ostmt.setString(6,expected_value);
		  ostmt.setString(7,execution_order);
		  ostmt.setString(8,expected_value2);
	      ostmt.setString(9,position);
		  ostmt.setString(10,usr_added_by_id);
		  ostmt.setString(11,usr_added_at_ws_no);
		//  ostmt.setString(11,usr_facility_by_id);
		  ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);

        ostmt.execute();
        status = ostmt.getString(12);
	//	System.out.println("status"+status);
        message_text = ostmt.getString(13);

        if (status.equals("0"))
        {
          connection.commit(); 
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		  status = ((String) mesg.get("message"));
   //      System.out.println("status12"+status);
        }
        else
        {
          boolean chkStat=false;
          connection.rollback();
		  chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
	//	        System.out.println("status123"+status);
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
	  return status;
  }

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
