<!DOCTYPE html>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList,java.util.Properties, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>

<%
Connection con = null;
PreparedStatement pstmt = null ;
Statement stmt			= null;
ResultSet rs = null;
String patientId=request.getParameter("patient_id");
System.out.println("patientId             "+patientId);
String pat_regn_date_time="";
String billing_grp_id="";
Properties p = null ;
String pat_regn_date_time_date="";
String called_from=request.getParameter("calledFrom");
String blng_grp=request.getParameter("blng_group");
String locale	= (String)session.getAttribute("LOCALE");
String login_user=(String)session.getAttribute("login_user");
String client_ip_address=(String)session.getValue("client_ip_address");
String facility_id="";
	try
	{
		
con=ConnectionManager.getConnection(request);
HttpSession httpSession = request.getSession(false);
p = (Properties)httpSession.getValue("jdbc");
String modifiedAtWsNo = p.getProperty("client_ip_address");
facility_id=(String)httpSession.getValue("facility_id");
	if("modify_fin".equals(called_from)){
		String pat_regn_date= "select REGN_DATE from mp_patient where patient_id='"+patientId+"'";
		
		 stmt = con.createStatement();
		 rs = stmt.executeQuery(pat_regn_date);	

			if(rs.next())
			{
				pat_regn_date_time  =  rs.getString(1);	
			}
		out.println(pat_regn_date_time);
		
		
		if(rs!=null)   rs.close();
		
		}

		
		if("modify_fin1".equals(called_from)){
		 HashMap insert_values	= new HashMap() ;
	     HashMap fin_dtls= new HashMap();
	     Hashtable blTabdata = new Hashtable();

	
		 blTabdata.put("calling_function_id","CHG_PAT_DTLS");
		 blTabdata.put("credit_auth_user_id","");
		 blTabdata.put("locale",locale);
		 blTabdata.put("patient_id_new", patientId);
		 blTabdata.put("facility_id",facility_id);
		 blTabdata.put("operation_mode","U");
		 blTabdata.put("added_at_ws_no",modifiedAtWsNo);
		 blTabdata.put("added_by_id",login_user);
		 blTabdata.put("billing_group","");
		 blTabdata.put("dflt_pat_regn_blng_class","EX");
		 blTabdata.put("pat_ser_grp_code",facility_id);
		 blTabdata.put("pat_regn_date_time",pat_regn_date_time); 
       	 blTabdata.put("pat_regn_prev_date",pat_regn_date_time); 
		 blTabdata.put("apptrefno","");
		 blTabdata.put("bookingrefno","");
			try
			{
			
				  fin_dtls=(HashMap)session.getAttribute("financial_details");
				if ( fin_dtls!=null )
				{
		 			blTabdata.put("fin_dtls",fin_dtls);
		 			 
				}
			}
			catch (Exception e)
			{

				e.printStackTrace();
			}
			
			blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
			Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
			boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

if(boolRes==true)
{
		con.commit();
		blTabdata.clear();
		resultsBL.clear();
		
	}

		}

	
	}
catch(Exception e)
{
	System.out.println("Exception from modify :"+e);
	e.printStackTrace();
}
	finally
	{
		if(con!=null) 
		{
			if(con!=null) ConnectionManager.returnConnection(con);
		}
	}
	%>
	<script language='javascript'>
	<jsp:include page="../../eBL/jsp/BLSessionValuesReset.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name="fin_dtls_reset" value="Y" />
	</jsp:include>

	</script>



