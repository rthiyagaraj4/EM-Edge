/***************************************************************************************************************
* Author   :   Srinivasa.N
* Desc     :	Class used to update the interface parameter setup
***************************************************************************************************************/
package eXH;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
/**
*  Class used to update interface parameter setup
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
			arraylist.add(XHDBAdapter.checkNullForCheckBox(request.getParameter("enable_interface")));
			arraylist.add(XHDBAdapter.checkNullForCheckBox(request.getParameter("setup_master_code")));
			arraylist.add(XHDBAdapter.checkNullForCheckBox(request.getParameter("enable_event_filtering")));
			arraylist.add(request.getParameter("dbConnStr"));
			arraylist.add(XHDBAdapter.checkNull(request.getParameter("idle_time")));
			arraylist.add(XHDBAdapter.checkNull(request.getParameter("temp_purge_interval")));
			arraylist.add(XHDBAdapter.checkNull(request.getParameter("permanent_purge_interval")));
			arraylist.add(XHDBAdapter.checkNullForCheckBox(request.getParameter("offlinePurgeYN")));
			arraylist.add(XHDBAdapter.checkNull(request.getParameter("rec2PurgeIteration")));
			arraylist.add(XHDBAdapter.checkNull(request.getParameter("auto_disp_stage")));
			System.out.println("AdminIntrfaceParamSetupServlet arraylist ::: "+arraylist);

			connection = ConnectionManager.getConnection();
			String s8 = "SELECT X.FACILITY_ID,X.FACILITY_NAME,Y.AUDIT_YN,Y.DEBUG_YN,Y.OUTBOUND_LOG_YN,Y.INBOUND_LOG_YN,Z.OPERATIONAL_YN FROM SM_FACILITY_PARAM X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  Z.MODULE_ID='XH' AND     X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID UNION SELECT X.FACILITY_ID,X.FACILITY_NAME,'N','N','N','N',Z.OPERATIONAL_YN FROM SM_FACILITY_PARAM X,SM_MODULES_FACILITY Z WHERE Z.MODULE_ID='XH' AND X.FACILITY_ID=Z.FACILITY_ID AND X.FACILITY_ID NOT IN (SELECT FACILITY_ID  FROM XH_PARAM_FOR_FACILITY)";
			statement = connection.createStatement();
			resultset = statement.executeQuery(s8);

			ArrayList arraylist2 = null;
			while( resultset.next())
			{
				String s1 = resultset.getString(1);
				arraylist2 = new ArrayList();
				arraylist2.add(s1);
				arraylist2.add(XHDBAdapter.checkNullForCheckBox(request.getParameter(s1 + "_AUDIT")));
				arraylist2.add(XHDBAdapter.checkNullForCheckBox(request.getParameter(s1 + "_DEBUG")));
				arraylist2.add(XHDBAdapter.checkNullForCheckBox(request.getParameter(s1 + "_OUTBOUND")));
				arraylist2.add(XHDBAdapter.checkNullForCheckBox(request.getParameter(s1 + "_INBOUND")));
				arraylist1.add(arraylist2);
			}
			//arraylist2.clear();
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
				if(resultset != null) System.out.println("ResultSet Obj :"+resultset.toString());
				if(resultset != null) resultset.close();
				if(statement != null) System.out.println("Statement Obj :"+statement.toString());
				if(statement != null) statement.close();
				if(connection != null) System.out.println("connection Obj :"+connection.toString());
				if(connection != null) connection.close();
				System.out.println("Connection Close :");
				//arraylist.clear();
				//arraylist1.clear();
				//arraylist3.clear();
				System.out.println("After Array List Cleared :");
			}
			catch(Exception exception2) 
			{
				System.out.println("Error in closing statement of admininterfaceservlet :"+exception2.toString());
				exception2.printStackTrace(System.err);
			}
		}

		arraylist3 = new ArrayList();
		arraylist3 = ArrayAuditInfo.getArrayAuditInfo(session);
		try
			{
		
			System.out.println("1.. " + arraylist3.get(1));
			System.out.println("2.. " + XHUtil.getIPByHostname((String)arraylist3.get(1)));
			}
			catch(Exception exception3) 
			{
				System.out.println("Error in SOP XHUtil.getIPByHostname((String)arraylist3.get(1)) :"+exception3.toString());
				exception3.printStackTrace(System.err);
			}

		HashMap hashmap = new HashMap();
		hashmap.put("top_details", arraylist);
		hashmap.put("row_details", arraylist1);
		hashmap.put("gen_details", arraylist3);
		HashMap hashmap1 = new HashMap();
		hashmap1 = callEJB(hashmap,locale);

		String queryString = "message="+(String)hashmap1.get("status");

		out.println("parent.f_query_add_mod.location.href='../../eXH/jsp/InterfaceParamSetupAdmin.jsp'");
		RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/RefreshPage.jsp?action=InterfaceParamSetupAdmin.jsp&"+queryString);
		reqDis.forward(request,response);
		
		//hashmap.clear();
		//hashmap1.clear();

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
		String statusMsg = "";
		boolean isSettingsUpdated = false;

		HashMap hashmap1 = new HashMap();

		ArrayList arraylist = (ArrayList)hashmap.get("top_details");
		ArrayList arraylist1 = (ArrayList)hashmap.get("row_details");
		ArrayList arraylist2 = (ArrayList)hashmap.get("gen_details");

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
			oraclecallablestatement = oracleconnection.prepareCall("{ call xhmast.interface_param(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

			String  enable_interface=(String)arraylist.get(0);
			String  setup_master_code=(String)arraylist.get(1);
			String  enable_event_filtering=(String)arraylist.get(2);
			String  db_conn_string1=(String)arraylist.get(3);
			String  idle_time=(String)arraylist.get(4);
			String  temp_purge_interval=(String)arraylist.get(5);
			String  permanent_purge_interval=(String)arraylist.get(6);
			String  offlinePurgeYN = (String)arraylist.get(7);
			String  usr_added_by_id=(String)arraylist2.get(0);
			String  usr_added_at_ws_no=(String)arraylist2.get(1);
			String rec2PurgeIteration = (String)arraylist.get(8);
			String autoDispensorStage = (String)arraylist.get(9);
			System.out.println("autoDispensorStage ::: "+autoDispensorStage+" :: rec2PurgeIteration :: "+rec2PurgeIteration);

		/*	System.out.println("enable_interface "+enable_interface);
			System.out.println("setup_master_code "+setup_master_code);
			System.out.println("enable_event_filtering "+enable_event_filtering);
			System.out.println("db_conn_string1 "+db_conn_string1);
			System.out.println("idle_time "+idle_time);
			System.out.println("temp_purge_interval "+temp_purge_interval);
			System.out.println("permanent_purge_interval "+permanent_purge_interval);
			System.out.println("offlinePurgeYN "+offlinePurgeYN);
			System.out.println("usr_added_by_id "+usr_added_by_id);
			System.out.println("usr_added_at_ws_no "+usr_added_at_ws_no);
		*/		
			oraclecallablestatement.setString(1,enable_interface);
			oraclecallablestatement.setString(2,setup_master_code);
			oraclecallablestatement.setString(3,enable_event_filtering);
			oraclecallablestatement.setString(4,db_conn_string1);
			oraclecallablestatement.setString(5,idle_time);
			oraclecallablestatement.setString(6,temp_purge_interval);
			oraclecallablestatement.setString(7,permanent_purge_interval);		 		 		  
			oraclecallablestatement.setString(8,usr_added_by_id);
			oraclecallablestatement.setString(9,usr_added_at_ws_no);
			oraclecallablestatement.setString(10,offlinePurgeYN);
			oraclecallablestatement.setString(11,rec2PurgeIteration);
			oraclecallablestatement.setString(12,autoDispensorStage);
			
			oraclecallablestatement.registerOutParameter(13, java.sql.Types.VARCHAR);
			oraclecallablestatement.registerOutParameter(14, java.sql.Types.VARCHAR);
			oraclecallablestatement.execute();

			s = oraclecallablestatement.getString(13);
			//String message_text = oraclecallablestatement.getString(14);

		//	System.out.println(" s :"+s );
		//	System.out.println("(AdminInterfaceParamSetupServlet:callEJB)Message: "+message_text);

			if(s.equals("0"))
			{
				oracleconnection.commit();
				session.putValue("dbString",db_conn_string1);
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				s = ((String) mesg.get("message"));
				statusMsg = ((String) mesg.get("message"));
				isSettingsUpdated = true;
				mesg.clear();
			}
			else
			{
				oracleconnection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				s = ((String) mesg.get("message"));
				statusMsg = ((String) mesg.get("message"));
				mesg.clear();
			}

			if(oraclecallablestatement!=null) oraclecallablestatement.close();
		}
		catch(Exception exception1)
		{
			System.out.println("Error(1) in calling dbrelated statements in callejb method of admininterfaceservlet  :"+exception1.toString());
			exception1.printStackTrace(System.err);
		}

		ArrayList arraylist3=null;
		if(isSettingsUpdated)
		{
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
						statusMsg = ((String) mesg.get("message"));
						mesg.clear();
					}
					else
					{
						oracleconnection.rollback();
						final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
						s1 = ((String) mesg.get("message"));
						statusMsg = ((String) mesg.get("message"));
						mesg.clear();
					}

					if(oraclecallablestatement1!=null) oraclecallablestatement1.close();
				}
				catch(Exception exception3)
				{
					System.out.println("Error(2) in calling dbrelated statements in callejb method of admininterfaceservlet :"+exception3.toString());
					exception3.printStackTrace(System.err);
					s3 = s3 + "4" + "*" + exception3.toString();				
				}
			}
		}

		try
		{
			ConnectionManager.returnConnection(oracleconnection);
		}
		catch(Exception e)
		{ 
			System.out.println("Error in closing connection in callejb method of admininterfaceservlet  :"+e.toString());
			e.printStackTrace(System.err);
		}

		s2=s1;
		if(arraylist1.size() == 0)
		{
			s2 = s;
		}
		hashmap1.put("exceptions", s3);
		hashmap1.put("status", statusMsg);
		
		arraylist.clear();
		arraylist1.clear();
		arraylist2.clear();
		arraylist3.clear();
		return hashmap1;
	}

	HttpServletRequest req;
}//end of class