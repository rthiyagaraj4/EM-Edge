/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;

/**
 *  The XHViewEventsOutboundServlet class used to implement the functionalities of  
 *  Administered events and view events(0utbound).
 *
 */

public class XHViewEventsInteractiveServlet extends HttpServlet
{
	
	HttpServletRequest req=null;

    /**
	 * Do post method which implements the functionalities for Replay and Rebuild 
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @throws IOException
	 * @throws ServletException
	 */
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		Clob c1=null;
		PrintWriter out;
		Connection con= null;
		CallableStatement cs = null;
		Properties p;	
		HttpSession session=request.getSession(false);
		p = (Properties) session.getValue("jdbc");	
        String locale  = p.getProperty("LOCALE");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
	 	MessageManager mm=new MessageManager();

		out=response.getWriter();
		req=request;
		
		if(con==null)con =ConnectionManager.getConnection();
		
		try{
		String Processid= XHDBAdapter.checkNull(request.getParameter("Process_Id"));
		String  facilityId		  = XHDBAdapter.checkNull(request.getParameter("facilityId"));
		String  applicationId = XHDBAdapter.checkNull(request.getParameter("applicationId"));
		String  messageId   = XHDBAdapter.checkNull(request.getParameter("messageId"));
		String  buttonInvoked = request.getParameter("buttonInvoked");
		String  msg_id1,msg_dt1,msg_id2,msg_dt2,msg_status,facility,orderBy,order,reason,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,purge_status;
		String  message_text2="";
		//String purge_status="";
	
       Statement st=null;
	      ResultSet r;
String Update_query="";
  
	

      
		msg_id1=null;
		msg_dt1=null;
		msg_id2=null;
		msg_dt2=null;
		msg_status=null;
		facility=null;
		reason=null;
		pat_id=null;
		merg_pat_id=null;
		episode_type=null;
		episode_id=null;
		visit_id=null;
		action_typ=null;
		last_processed_date=null;
		not_req_rsn=null;
		addid=null;
		addeddate=null;
		addedwsno=null;
		modfid=null;
		modifieddate=null;
		modifiedwsno=null;
	 	msg_date=null;
		orderBy=null;
		order=null;
		applnname=null;
		eventtype=null;
		purge_status=null;
String excute_query="";
int excute_qry=0;
int excute_qry1=0;
	eventtype=XHDBAdapter.checkNull(request.getParameter("Event_type"));
				msg_status=XHDBAdapter.checkNull(request.getParameter("msg_status"));
		last_processed_date=XHDBAdapter.checkNull(request.getParameter("last_processed_date"));
	addedwsno=XHDBAdapter.checkNull(request.getParameter("addedwsno"));
       modifiedwsno=XHDBAdapter.checkNull(request.getParameter("modifiedwsno"));

		/*pat_id=XHDBAdapter.checkNull(request.getParameter("pat_id"));
		merg_pat_id=XHDBAdapter.checkNull(request.getParameter("merg_pat_id"));
		episode_type=XHDBAdapter.checkNull(request.getParameter("episode_type"));
		episode_id=XHDBAdapter.checkNull(request.getParameter("episode_id"));
		visit_id=XHDBAdapter.checkNull(request.getParameter("visit_id"));
		action_typ=XHDBAdapter.checkNull(request.getParameter("action_typ"));
	
		not_req_rsn=XHDBAdapter.checkNull(request.getParameter("not_req_rsn"));
		addid=XHDBAdapter.checkNull(request.getParameter("addid"));
		addeddate=XHDBAdapter.checkNull(request.getParameter("addeddate"));
		
		modfid=XHDBAdapter.checkNull(request.getParameter("modfid"));
		modifieddate=XHDBAdapter.checkNull(request.getParameter("modifieddate"));
		
	 	msg_date=XHDBAdapter.checkNull(request.getParameter("msg_date"));
		orderBy =XHDBAdapter.checkNull(request.getParameter("orderBy"));
		order=XHDBAdapter.checkNull(request.getParameter("order"));
		
		applnname=XHDBAdapter.checkNull(request.getParameter("applnname"));*/
	//	purge_status=XHDBAdapter.checkNull(request.getParameter("purge_status"));
       

String message_text="";
	//  System.out.println("buttonInvoked"+buttonInvoked+"messageId"+messageId);


        if(buttonInvoked.equals("reload"))
		{
		//	System.out.println("select REQUEST_TEXT from XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+messageId+"'");
			st= con.createStatement();
r = st.executeQuery("select REQUEST_TEXT from XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+messageId+"'");
//System.out.println("ReqText135");
 while(r.next())
	{

	
message_text=returnvalue(r.getClob(1));
	}
//System.out.println("ReqText63"+message_text);
r.close() ;
 st.close();

Update_query="Update XH_INTERACTIVE_INTEGRATION set RESPONSE_TEXT=? where MESSAGE_ID=? ";
PreparedStatement pstmt=con.prepareStatement(Update_query);
//defined a null clob to set
Clob nullClob=null;
pstmt.setClob(1,nullClob);
pstmt.setString(2,messageId);
int exe_query=pstmt.executeUpdate();


//System.out.println("exe_query  "+exe_query);

if(exe_query==1)
			{
	con.commit();
			}
			else
			{
				 con.rollback();
			}

pstmt.close();


 
 excute_query="insert into XH_APPLICATION_MESSAGE_AUDIT(APPLICATION_ID, MESSAGE_ID, FACILITY_ID, PROCESS_DATE_TIME, EVENT_TYPE, PROCESS_ID, PROCESSED_BY, END_DATE_TIME, COMM_RETRIES, STATUS, STATUS_TEXT, MESSAGE_TEXT, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)  values('"+applicationId+"','"+messageId+"','"+facilityId+"',SYSDATE,'"+eventtype+"','"+Processid+"','',SYSDATE,'','"+msg_status+"','',?,'"+addedwsno+"','"+facilityId+"','"+addedwsno+"','"+facilityId+"')";
PreparedStatement pstmt1=con.prepareStatement(excute_query);
pstmt1.setClob(1,c1);
//System.out.println(excute_query);
 excute_qry = pstmt1.executeUpdate();

 pstmt1.close();




		  cs = con.prepareCall("{ call XHMSG.Proc_REBUILD(?,?,?,?,?,?) }" ); 
			 cs.setString(1,facilityId);
			 cs.setString(2,locale);
		     cs.setString(3,applicationId );
		     cs.setString(4,messageId );
  		     cs.registerOutParameter(5,java.sql.Types.VARCHAR);
		     cs.registerOutParameter(6,java.sql.Types.VARCHAR);
			 cs.execute();
		     message_text2 = cs.getString(5);	

		}
		if(cs!=null) cs.close();   
		if(buttonInvoked.equals("rebuild"))
		{
//		System.out.println("select RESPONSE_TEXT from XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+messageId+"'");
			st= con.createStatement();
r = st.executeQuery("select RESPONSE_TEXT from XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+messageId+"'");
//System.out.println("ReqText198");
 while(r.next())
	{

	
message_text=returnvalue(r.getClob(1));
c1=r.getClob(1);
	}
//System.out.println("ReqText207"+message_text);
r.close() ;
 st.close();

Update_query="Update XH_INTERACTIVE_INTEGRATION set RESPONSE_TEXT=? where MESSAGE_ID=? ";
PreparedStatement pstmt=con.prepareStatement(Update_query);
//defined a null clob to set
Clob nullClob=null;
pstmt.setClob(1,nullClob);
pstmt.setString(2,messageId);
int exe_query=pstmt.executeUpdate();
//System.out.println("exe_query  "+exe_query);
if(exe_query==1)
			{
	con.commit();
			}
			else
			{
				 con.rollback();
			}

pstmt.close();


 
 excute_query="insert into XH_APPLICATION_MESSAGE_AUDIT(APPLICATION_ID, MESSAGE_ID, FACILITY_ID, PROCESS_DATE_TIME, EVENT_TYPE, PROCESS_ID, PROCESSED_BY, END_DATE_TIME, COMM_RETRIES, STATUS, STATUS_TEXT, MESSAGE_TEXT, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values('"+applicationId+"','"+messageId+"','"+facilityId+"',SYSDATE,'"+eventtype+"','"+Processid+"','',SYSDATE,'','"+msg_status+"','',?,'"+addedwsno+"','"+facilityId+"','"+addedwsno+"','"+facilityId+"')";
PreparedStatement pstmt1=con.prepareStatement(excute_query);
pstmt1.setClob(1,c1);
//System.out.println(excute_query);
 excute_qry1 = pstmt1.executeUpdate();


 pstmt1.close();


			 cs = con.prepareCall("{ call XHMSG.Proc_REBUILD(?,?,?,?,?,?) }" ); 
			 cs.setString(1,facilityId);
			 cs.setString(2,locale);
		     cs.setString(3,applicationId );
		     cs.setString(4,messageId );
  		     cs.registerOutParameter(5,java.sql.Types.VARCHAR);
		     cs.registerOutParameter(6,java.sql.Types.VARCHAR);
			 cs.execute();
		     message_text2 = cs.getString(5);	
		}
		 
		if(message_text2.equals("0"))
	    {
		     con.commit();
		     final java.util.Hashtable mesg = mm.getMessage(locale,"XH1001", "XH") ;
  	         message_text2 = ((String) mesg.get("message"));
	    }
	    else
	    {
		      con.rollback();
		      final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
		      message_text2 = ((String) mesg.get("message"));
	     }
         if(cs!=null) cs.close();    
	     String status=message_text2;
	     String urlParameters="&msg_id1="+msg_id1+"&msg_dt1="+msg_dt1+"&msg_id2="+msg_id2+"&msg_dt2="+msg_dt2+"&msg_status="+msg_status+"&facility="+facility+"&orderBy="+orderBy+"&order="+order+"&reason="+reason+"&pat_id="+pat_id+"&merg_pat_id="+merg_pat_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&action_typ="+action_typ+"&last_processed_date="+last_processed_date+"&not_req_rsn="+not_req_rsn+"&addid="+addid+"&addeddate="+addeddate+"&addedwsno="+addedwsno+"&modfid="+modfid+"&modifieddate="+modifieddate+"&modifiedwsno="+modifiedwsno+"&msg_date="+msg_date+"&eventtype="+eventtype+"&applnname="+applnname+"&purge_status="+purge_status;
	     
		 RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/ViewInteractiveDisplyResult.jsp?&message="+status+urlParameters);
         reqDis.forward(request,response);
		 
	    }catch(Exception ex)
	     { 
		       System.out.println("Error in dopost method of xhvieweventsInteractiveservlet "+ex.toString());
		       ex.printStackTrace(System.err);
	     }
	     finally{
		         try{
	                  if(con!=null) ConnectionManager.returnConnection(con);
		            }catch(Exception ex){}
	     }
	
	}// end of do post



 public String returnvalue(Clob c)
    {
      
        String Request_text="";
        
        
                   if (c == null) 
           {
           
           } 
          else {


try {
    
    String aux;
//	System.out.println("is coming");
 BufferedReader br = new BufferedReader(c.getCharacterStream());
while ((aux=br.readLine())!=null)
{
     //StringBuffer strOut = new StringBuffer();
//strOut.append(aux.toString().trim());
    Request_text=aux.toString().trim(); 

}
 br.close();
//row.setNote(strOut.toString());
} catch (java.sql.SQLException e1) {
//row.setNote(e1.toString());
} catch (java.io.IOException e2) {
//row.setNote(e2.toString());
}

          }
       
return Request_text;       
    }

}// end of class
