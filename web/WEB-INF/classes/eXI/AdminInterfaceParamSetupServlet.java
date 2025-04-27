/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXI.XIDBAdapter;
import eXH.ArrayAuditInfo;
//import eXH.XHTYPE;
/**
 *  Class used to update interface parameter  setup
 *
 */

public class AdminInterfaceParamSetupServlet extends HttpServlet
{
    HttpSession session=null;
   /**
	 * Do post method which implements the functionalities for interface parameter  setup
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        PrintWriter out;
		out=response.getWriter();
		req=request;
		
        session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");

        
        ResultSet resultset = null;
        Statement statement = null;
        Connection connection = null;
        
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist3 = null;

        try
        {
            arraylist.add(XIDBAdapter.checkNullForCheckBox(request.getParameter("enable_interface")));
            arraylist.add(XIDBAdapter.checkNullForCheckBox(request.getParameter("setup_master_code")));
            arraylist.add(XIDBAdapter.checkNullForCheckBox(request.getParameter("enable_event_filtering")));
           // arraylist.add(request.getParameter("db_conn_string1") + ":" + request.getParameter("db_conn_string2") + ":" + request.getParameter("db_conn_string3"));
            
			arraylist.add(request.getParameter("db_conn_string_txt"));
			arraylist.add(XIDBAdapter.checkNull(request.getParameter("idle_time")));
			arraylist.add(XIDBAdapter.checkNull(request.getParameter("temp_purge_interval")));
            arraylist.add(XIDBAdapter.checkNull(request.getParameter("permanent_purge_interval")));
			arraylist.add(XIDBAdapter.checkNull(request.getParameter("Application_type_id")));
arraylist.add(XIDBAdapter.checkNull(request.getParameter("Itemclass_txt")));
arraylist.add(XIDBAdapter.checkNull(request.getParameter("ItemType_txt")));
String rec=XIDBAdapter.checkNull(request.getParameter("rac_cluster"));
//System.out.println("rec"+rec);

if(rec.equals("N") || rec.equals(""))
			{
//	System.out.println("rec2"+rec);
arraylist.add("N");
			}
			else
			{
				arraylist.add("Y");
			}

			connection = ConnectionManager.getConnection();
            String s8="SELECT X.FACILITY_ID,X.FACILITY_NAME,Y.AUDIT_YN,Y.DEBUG_YN,Y.OUTBOUND_LOG_YN,Y.INBOUND_LOG_YN,Z.OPERATIONAL_YN FROM SM_FACILITY_PARAM X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  Z.MODULE_ID='XH' AND     X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID UNION SELECT X.FACILITY_ID,X.FACILITY_NAME,'N','N','N','N',Z.OPERATIONAL_YN FROM SM_FACILITY_PARAM X,SM_MODULES_FACILITY Z WHERE Z.MODULE_ID='XH' AND X.FACILITY_ID=Z.FACILITY_ID AND X.FACILITY_ID NOT IN (SELECT FACILITY_ID  FROM XH_PARAM_FOR_FACILITY)";
			statement = connection.createStatement();
			resultset = statement.executeQuery(s8);
            
			ArrayList arraylist2;
            while( resultset.next())
            {
                String s1 = resultset.getString(1);
                arraylist2 = new ArrayList();
                arraylist2.add(s1);
                arraylist2.add(XIDBAdapter.checkNullForCheckBox(request.getParameter(s1 + "_AUDIT")));
                arraylist2.add(XIDBAdapter.checkNullForCheckBox(request.getParameter(s1 + "_DEBUG")));
                arraylist2.add(XIDBAdapter.checkNullForCheckBox(request.getParameter(s1 + "_OUTBOUND")));
                arraylist2.add(XIDBAdapter.checkNullForCheckBox(request.getParameter(s1 + "_INBOUND")));
				arraylist1.add(arraylist2);
            }

        }
        catch(Exception exception)
        {
            System.out.println("Error in dopost method of admininterfaceservlet :"+exception.toString());
			exception.printStackTrace(System.err);

			
        }
        finally
        {
            try
            {
                if(resultset != null)resultset.close();
				if(statement != null)statement.close();
                connection.close();
            }
            catch(Exception exception2) 
				{
					 System.out.println("Error in closing statement of admininterfaceservlet :"+exception2.toString());
					exception2.printStackTrace(System.err);

				}
        }
        
        arraylist3 = new ArrayList();
        arraylist3 = ArrayAuditInfo.getArrayAuditInfo(session);
        
		HashMap hashmap = new HashMap();
        hashmap.put("top_details", arraylist);
        hashmap.put("row_details", arraylist1);
        hashmap.put("gen_details", arraylist3);
        HashMap hashmap1 = new HashMap();
        hashmap1 = callEJB(hashmap,locale);
//        System.out.println("(String)hashmap1.get(status)"+(String)hashmap1.get("status"));
		
	    RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)hashmap1.get("status"));
        reqDis.forward(request,response);
        
        arraylist.clear();
        arraylist1.clear();
        arraylist3.clear();
        hashmap.clear();
        hashmap1.clear();
        
	
    }// end of dopost
 /**
	 * callEJB method is used to call interface parameter setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
    public HashMap callEJB(HashMap hashmap,String locale)
    {
        Connection oracleconnection = null;
        CallableStatement oraclecallablestatement1 = null;
        	
        String s = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        HashMap hashmap1 = new HashMap();
             
		ArrayList arraylist = (ArrayList)hashmap.get("top_details");
        ArrayList arraylist1 = (ArrayList)hashmap.get("row_details");
        ArrayList arraylist2 = (ArrayList)hashmap.get("gen_details");
        java.util.Date d=new java.util.Date();
String User_date=d.getDate()+"/"+d.getMonth()+"/"+d.getYear();
		try
        {
            oracleconnection = ConnectionManager.getConnection();
                   }
        catch(Exception exception)
        {
             System.out.println("Error in calling getconnection method in callejb method of admininterfaceservlet :"+exception.toString());
			exception.printStackTrace(System.err);
        }
        
		CallableStatement oraclecallablestatement = null;
		MessageManager mm=new MessageManager();

        try
        {
            oraclecallablestatement = oracleconnection.prepareCall("{ call XIGUI.interface_param(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
//ostmt = connection.prepareCall("{ CALL XIGUI.interface_param(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" );
		   
		  String  enable_interface=(String)arraylist.get(0);
   	      String  setup_master_code=(String)arraylist.get(1);
		  String  enable_event_filtering=(String)arraylist.get(2);
		  String  db_conn_string1=(String)arraylist.get(3);
		  String  idle_time=(String)arraylist.get(4);
		  String  temp_purge_interval=(String)arraylist.get(5);
		  String  permanent_purge_interval=(String)arraylist.get(6);
		  String Application_type_id=(String)arraylist.get(7);
          String Item_class=(String)arraylist.get(8);
String Item_type=(String)arraylist.get(9);
String rec_culster=(String)arraylist.get(10);
		  String  usr_added_by_id=(String)arraylist2.get(0);
		  String  usr_added_at_ws_no=(String)arraylist2.get(1);

//		  System.out.println("enable_interface "+enable_interface);
//		  System.out.println("setup_master_code "+setup_master_code);
//		  System.out.println("enable_event_filtering "+enable_event_filtering);
//		  System.out.println("db_conn_string1 "+db_conn_string1);
//		  System.out.println("idle_time "+idle_time);
//		  System.out.println("temp_purge_interval "+temp_purge_interval);
//		  System.out.println("permanent_purge_interval "+permanent_purge_interval);
//System.out.println("Application_type_id "+Application_type_id);
//System.out.println("rec_culster "+rec_culster);
//System.out.println("Item_type "+Item_type);
//System.out.println("Item_class "+Item_class);

//		  System.out.println("usr_added_by_id "+usr_added_by_id);
//		  System.out.println("usr_added_at_ws_no "+usr_added_at_ws_no); 
		  	 
		 oraclecallablestatement.setString(1,enable_interface);
		 oraclecallablestatement.setString(2,setup_master_code);
		 oraclecallablestatement.setString(3,enable_event_filtering);
		 oraclecallablestatement.setString(4,db_conn_string1);
		 oraclecallablestatement.setString(5,idle_time);

         oraclecallablestatement.setString(6,"Y");
		 oraclecallablestatement.setString(7,Application_type_id);
         oraclecallablestatement.setString(8,Item_class);
		 oraclecallablestatement.setString(9,Item_type);
//		 System.out.println("Item_type206 "+Item_type);
		 oraclecallablestatement.setString(10,temp_purge_interval);
		 oraclecallablestatement.setString(11,permanent_purge_interval);
		 oraclecallablestatement.setString(12,rec_culster);
		 oraclecallablestatement.setString(13,"Y"); 
		 oraclecallablestatement.setString(14,usr_added_by_id);
         oraclecallablestatement.setString(15,User_date);
		 oraclecallablestatement.setString(16,usr_added_by_id);
         oraclecallablestatement.setString(17,User_date);
		 oraclecallablestatement.setString(18,usr_added_at_ws_no);
		  oraclecallablestatement.setString(19,usr_added_at_ws_no);
         oraclecallablestatement.registerOutParameter(20, java.sql.Types.VARCHAR);
         oraclecallablestatement.registerOutParameter(21, java.sql.Types.VARCHAR);
         oraclecallablestatement.execute();
         
		 s = oraclecallablestatement.getString(20);
		 
		 
    //     System.out.println(" s :"+s );
	//	 System.out.println("Message "+message_text);

         if(s.equals("0"))
		 {
            oracleconnection.commit();
			session.putValue("dbString",db_conn_string1);
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		    s = ((String) mesg.get("message"));
		    mesg.clear();
//		 System.out.println("s232"+s);
		 }
         else
		{
                oracleconnection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				s = ((String) mesg.get("message"));
				mesg.clear();
//		System.out.println("s239"+s);
		}
        
        if(oraclecallablestatement!=null) oraclecallablestatement.close();
        }
        catch(Exception exception1)
        {
           System.out.println("Error(1) in calling dbrelated statements in callejb method of admininterfaceservlet  :"+exception1.toString());
		   exception1.printStackTrace(System.err);
        }
        ArrayList arraylist3=null;
        for(int i = 0; i < arraylist1.size();i++)
        {
            if(arraylist3!=null && !arraylist3.isEmpty()) arraylist3.clear();
            arraylist3 = (ArrayList)arraylist1.get(i);
            try
            {
                s2 = s2 + "***" + arraylist3;
                oraclecallablestatement1 = oracleconnection.prepareCall("{ call xhmast.interface_param_for_facility(?,?,?,?,?,?,?,?,?,?) }");


               
		  String  facility=(String)arraylist3.get(0);
		  String  audit=(String)arraylist3.get(1);
   	      String  debug=(String)arraylist3.get(2);
		  String  outbound=(String)arraylist3.get(3);
		  String  inbound=(String)arraylist3.get(4);
		
		  String  usr_added_by_id=(String)arraylist2.get(0);
		  String  usr_added_at_ws_no=(String)arraylist2.get(1);
		  String  usr_added_facility_id=(String)arraylist2.get(2);
		 
		 oraclecallablestatement1.setString(1,facility);
		 oraclecallablestatement1.setString(2,audit);
		 oraclecallablestatement1.setString(3,debug);
		 oraclecallablestatement1.setString(4,outbound);
		 oraclecallablestatement1.setString(5,inbound);

		 oraclecallablestatement1.setString(6,usr_added_by_id);
		 oraclecallablestatement1.setString(7,usr_added_at_ws_no);
		 oraclecallablestatement1.setString(8,usr_added_facility_id);
		 		
		 oraclecallablestatement1.registerOutParameter(9, java.sql.Types.VARCHAR);
         oraclecallablestatement1.registerOutParameter(10, java.sql.Types.VARCHAR);
         oraclecallablestatement1.execute();
                
		s1 = oraclecallablestatement1.getString(9);
        
		if(s1.equals("0"))
		{
                oracleconnection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			    s1 = ((String) mesg.get("message"));
			    mesg.clear();
		}
        else
		{
                    oracleconnection.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
					s1 = ((String) mesg.get("message"));
					mesg.clear();
		
		}
        
        if(oraclecallablestatement1!=null) oraclecallablestatement1.close();
        }
         catch(Exception exception3)
            {
                System.out.println("Error(2) in calling dbrelated statements in callejb method of admininterfaceservlet :"+exception3.toString());
		       exception3.printStackTrace(System.err);
               s3 = s3 + "4" + "*" + exception3.toString();
               exception3.printStackTrace(System.err);
            }
        }
		try{
		ConnectionManager.returnConnection(oracleconnection);
		}catch(Exception e){ System.out.println("Error in closing connection in callejb method of admininterfaceservlet  :"+e.toString());
		   e.printStackTrace(System.err);}
       
		s2=s1;
		hashmap1.put("exceptions", s3);
        hashmap1.put("status", s2);
        
        arraylist2.clear();
        
        return hashmap1;
       
    }

    HttpServletRequest req;
}//end of class
