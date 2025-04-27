<!DOCTYPE html>
<!-- MOD#0A -->
<%@ page   contentType="text/html;charset=UTF-8"  import="webbeans.eCommon.*,java.sql.*,blipin.*,java.util.*"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rsetBL = null;
	String bl_operational =	(String)session.getValue("bl_operational");
	con = ConnectionManager.getConnection(request);		
	String err_mesg = "";
	String disc_bill_exists = "";
	String disch_yn = "";
	String mode = request.getParameter("mode");
	if (mode==null) mode = "";

	String patient_id = request.getParameter("patient_Id");
	if (patient_id==null) patient_id = "";
	
	String encid		= request.getParameter("encounter_Id");
	if (encid==null) encid = "";

	String practitioner_id = request.getParameter("practitioner_Id");
	if (practitioner_id==null) practitioner_id ="";
	
	String call_function = request.getParameter("call_function");		
	if (call_function==null) call_function ="";
	

	String sex = request.getParameter("Sex");		
	if (sex==null) sex ="";
	
	String IPval = request.getParameter("IPval");		
	if (IPval==null) IPval ="";
	
	String p_service_type = request.getParameter("p_service_type");	
	if (p_service_type==null) p_service_type =""; 
String function_id    = checkForNull(request.getParameter("function_id"));
String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
	CallableStatement cstmt = null;
	try 
	{
			// MOD#01 Billing starts here

			HttpSession httpSession = request.getSession(false);
			String facility_id = (String)httpSession.getValue("facility_id");
		 	
			stmt = con.createStatement();
		 	if ( bl_operational.equals("Y")) 
		 	{
		 		
		 		String episode_id = encid;
				rsetBL = stmt.executeQuery("SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST('"+facility_id+"',"+episode_id+") disc_bill_exists FROM dual");
				while(rsetBL.next())
				{
					disc_bill_exists = rsetBL.getString("disc_bill_exists");
					if(disc_bill_exists == null) disc_bill_exists = "";
				}
				if(rsetBL!=null) rsetBL.close();
				if(stmt!=null) stmt.close();
				if(disc_bill_exists.equals("Y"))
					err_mesg = "BL9311";

				if(err_mesg.equals("0"))
				{stmt = con.createStatement() ;
					rsetBL = stmt.executeQuery("SELECT BL_IP_DETAILS.GET_EPISODE_DISCHARGE_FLAG('"+facility_id+"',"+episode_id+") disch_yn FROM dual");
					while(rsetBL.next())
					{
						disch_yn = rsetBL.getString("disch_yn");
						if(disch_yn == null) disch_yn = "";
					}
					
					if(disch_yn.equals("Y"))
						err_mesg = "CANC_DISC_ADV_NOT_ALLOWED";
				}
				if(rsetBL!=null)rsetBL.close();
				if(stmt!=null)stmt.close();
		 		if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";				

				if(err_mesg.equals("0") || err_mesg.equals(""))
				{
					String billinSql =  "{call BL_IP_DETAILS.CHECK_FIN_CLEAR_DUR_IP_TRX(?,?,?,?)}";
					CallableStatement fileCreateCS = con.prepareCall(billinSql);
					fileCreateCS.setString(1, function_id);
					fileCreateCS.setString(2, facility_id);
					fileCreateCS.setString(3, episode_id);
					fileCreateCS.registerOutParameter( 4,java.sql.Types.VARCHAR);

					try{
						fileCreateCS.execute();
						err_mesg = fileCreateCS.getString(4);
						if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";

						

					 fileCreateCS.close();
					} catch(Exception e1) {
						e1.printStackTrace();
						
					} 
                }
			}

		   
	/* END MODIFICATION BY ARUN */
	
	if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
	if(!(err_mesg.equals("0")))
	{
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
			
		out.println("</head><body class='message' onMouseDown='CodeArrest()' onKeyDown='lockKey()'></body></html>");
		
		if (!err_mesg.substring(0,2).equals("**")) 
		 {
			%>
			<script>
						//alert(getMessage('<%=err_mesg%>'));
						alert(getMessage('<%=err_mesg%>','BL'));
			</script>
			<%
		 }
		 else		
			out.println("<script>alert('"+err_mesg+"');</script>");			
	}
else
{ 
	out.println("<html><head>");
	out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>");
	
	out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script> <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> </head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' class='message'></body></html>");
	%>
<script> 

async function findCancelDischargeAdvise(){
		var frames_list = parent.frames[2].document.forms[0];
		 if( frames_list.modal.value != 'yes')
		    {   
				var jsp_name1=frames_list.jsp_name.value;
				var patient_id	= "<%=patient_id%>";	
				var encid		= "<%=encid%>";
				var practitioner_id = "<%=practitioner_id%>";	
				var call_function = "<%=call_function%>";
				var sex = "<%=sex%>";			
				var IPval = "<%=IPval%>";		
				var p_service_type = "<%=p_service_type%>"; 				
				var function_id = "<%=function_id%>"; 	
				var enable_height_bmi_pat_cls = "<%=enable_height_bmi_pat_cls%>"; 	
			
				var win_height=frames_list.win_height.value;
				if(win_height == "") win_height="70vh";
				
				var dialogTop=frames_list.dialogTop.value;
				if(dialogTop == "") dialogTop="80";				
				
				var win_width=frames_list.win_width.value;
				if(win_width == "") win_width="40vw";
				
				var module1=frames_list.module.value;
				if(module1 == "") module1="eIP";
				
				var model_window=frames_list.model_window.value;
				if( model_window == "") model_window ="";
						
				if( model_window == 'NO')
				{
				parent.parent.frames[1].document.location.href="../../"+module1+"/jsp/"+jsp_name1+"?encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_d+"&callfrom=IP&call_function="+call_function+"&Sex="+sex+"&function_id="+function_id+"&enable_height_bmi_pat_cls="+enable_height_bmi_pat_cls;
				}
				else
				if( model_window == 'N')
				{
				parent.frames[3].document.location.href="../../"+module1+"/jsp/"+jsp_name1+"?encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_id+"&callfrom=IP&call_function="+call_function+"&Sex="+sex+"&function_id="+function_id+"&enable_height_bmi_pat_cls="+enable_height_bmi_pat_cls;
				}			
				else
				{
					
					var retVal = 	new String();
					var dialogHeight= "500px";
					var dialogWidth = "700px";
					var dialogTop	= "72";
					var center = "1" ;
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;
					retVal = await window.showModalDialog("../../"+module1+"/jsp/"+jsp_name1+"?location_code="+IPval+"&encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_id+"&callfrom=IP&call_function="+call_function+"&p_service_type="+p_service_type.value+"&Sex="+sex+"&enable_height_bmi_pat_cls="+enable_height_bmi_pat_cls+"&mode=modal&function_id="+function_id,arguments,features);
					parent.frames[2].document.location.reload();	
				}
		}
		else
		{
			window.parent.returnValue=enc;
			window.parent.close();
		}
}
findCancelDischargeAdvise();
	</script> 
<%
}
		if (rs!=null) rs.close();
		if (cstmt!=null) cstmt.close();

	}catch (Exception e)
	{
		out.println("Exception "+e);
	}
	finally
	{	ConnectionManager.returnConnection(con,request);
	}
%>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

