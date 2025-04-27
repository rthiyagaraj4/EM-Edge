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
public class XHFilterRuleRecordServlet extends HttpServlet 
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

    String mode="";
  
    try
    {  mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
     
	  arrFilterInfo.add(mode);
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("rowid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("applicationid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("facilityid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("message_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filter_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filter_sub_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filter_sub1_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filter_sub2_type")));
      arrFilterInfo.add(XHDBAdapter.checkNullForCheckBox(request.getParameter("scheduling_rule")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("scheduling_time")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub1_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub1_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub2_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub2_value")));
      arrFilterInfo.add("");
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("segment_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("segment_class")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("segment_element")));
	  request.getParameter("jspmode");
      arrAudit = AuditInfo.getArrayAuditInfo(session);
    }
    catch(Exception exp)
    {
       System.out.println("Error in dooperate method of xhfilterrulerecordservlet :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }

    try
    {
       connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of xhfilterrulerecordservlet :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
		 
     }    
    	
     try
     {
        ostmt = connection.prepareCall("{ CALL XHMAST.filter_rule_setup(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
       
      arrFilterInfo.add(mode);
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("rowid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("applicationid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("facilityid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("message_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filter_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filter_sub_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filter_sub1_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filter_sub2_type")));
      arrFilterInfo.add(XHDBAdapter.checkNullForCheckBox(request.getParameter("scheduling_rule")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("scheduling_time")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub1_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub1_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub2_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("filterelement_sub2_value")));
      arrFilterInfo.add("");
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("segment_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("segment_class")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("segment_element")));


          

		  String  mode1=(String)arrFilterInfo.get(0);
   	      String  rowid=(String)arrFilterInfo.get(1);
		  String  applicationid=(String)arrFilterInfo.get(2);
          String  facilityid=(String)arrFilterInfo.get(3);
   	      String  message_type=(String)arrFilterInfo.get(4);
		  String  filter_type=(String)arrFilterInfo.get(5);
		  String  filter_sub_type=(String)arrFilterInfo.get(6);
          String  filter_sub1_type=(String)arrFilterInfo.get(7);
   	      String  filter_sub2_type=(String)arrFilterInfo.get(8);
		  String  scheduling_rule=(String)arrFilterInfo.get(9);
		  String  scheduling_time=(String)arrFilterInfo.get(10);
          String  filterelement_type=(String)arrFilterInfo.get(11);
   	      String  filterelement_value=(String)arrFilterInfo.get(12);
		  String  filterelement_sub_type=(String)arrFilterInfo.get(13);
   	      String  filterelement_sub_value=(String)arrFilterInfo.get(14);
		  String  filterelement_sub1_type=(String)arrFilterInfo.get(15);
   	      String  filterelement_sub1_value=(String)arrFilterInfo.get(16);
		  String  filterelement_sub2_type=(String)arrFilterInfo.get(17);
   	      String  filterelement_sub2_value=(String)arrFilterInfo.get(18);
		  String  segment_type=(String)arrFilterInfo.get(20);
   	      String  segment_class=(String)arrFilterInfo.get(21);
		  String  segment_element=(String)arrFilterInfo.get(22);
		  String  eventType="";
		
		  String  usr_added_by_id=(String)arrAudit.get(0);
		  String  usr_added_at_ws_no=(String)arrAudit.get(1);
		  String  usr_facility_by_id=(String)arrAudit.get(2);

		 		 
		  ostmt.setString(1,mode1);
		  ostmt.setString(2,rowid);
		  ostmt.setString(3,applicationid);
		  ostmt.setString(4,facilityid);
		  ostmt.setString(5,message_type);
		  ostmt.setString(6,filter_type);
		  ostmt.setString(7,filter_sub_type);
		  ostmt.setString(8,filter_sub1_type);
		  ostmt.setString(9,filter_sub2_type);
		  ostmt.setString(10,scheduling_rule);
		  ostmt.setString(11,scheduling_time);
		  ostmt.setString(12,filterelement_type);
		  ostmt.setString(13,filterelement_value);
		  ostmt.setString(14,filterelement_sub_type);
		  ostmt.setString(15,filterelement_sub_value);
		  ostmt.setString(16,filterelement_sub1_type);
		  ostmt.setString(17,filterelement_sub1_value);
		  ostmt.setString(18,filterelement_sub2_type);
		  ostmt.setString(19,filterelement_sub2_value);
		  ostmt.setString(20,eventType);
		  ostmt.setString(21,segment_type);
		  ostmt.setString(22,segment_class);
		  ostmt.setString(23,segment_element);
			  
		  ostmt.setString(24,usr_added_by_id);
		  ostmt.setString(25,usr_added_at_ws_no);
		  ostmt.setString(26,usr_facility_by_id);
		
        ostmt.registerOutParameter(27,java.sql.Types.VARCHAR);
        ostmt.registerOutParameter(28,java.sql.Types.VARCHAR);

        ostmt.execute();
        status = ostmt.getString(27);
        message_text = ostmt.getString(28);

        if (status.equals("0"))
        {
          connection.commit(); 
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		  status = ((String) mesg.get("message"));
		  
        }
        else
        {
          boolean chkStat=false;
          connection.rollback();
		  chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		 
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
         System.out.println("Error in calling dbrealted statements in dooperate method of xhfilterrulerecordservlet :"+exp.toString());
	     exp.printStackTrace(System.err);
		
        
      }
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in dooperate method of xhfilterrulerecordservlet :"+e.toString());
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
