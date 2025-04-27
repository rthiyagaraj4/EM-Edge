<!DOCTYPE html>

<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<head><title></title>
<%
		request.setCharacterEncoding("UTF-8");	
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		Connection con = null;
		Statement stmt=null;
 		ResultSet rs=null;
		String ca_mode="";
		String s=request.getQueryString();
		String is_ca=request.getParameter("CA");
		if(is_ca!=null && is_ca.equals("Y")){
		ca_mode="ca_mode";
		}
		
		
		String facilityid=(String)session.getValue("facility_id");
		boolean practitioner_yn=false;
		int no_record=0;
		String practitioner_id=(String)session.getValue("ca_practitioner_id");
		String calling_mode=(String)session.getValue("calling_mode");
		
		try{
			con = ConnectionManager.getConnection(request);
					stmt=con.createStatement();

		if(practitioner_id!=null && !(practitioner_id.equals(""))){
			String pract_str="select Count(*) from oa_clinic_time_table where facility_id ='"+facilityid+"' and PRACTITIONER_ID='"+practitioner_id+"' ";
			rs = stmt.executeQuery(pract_str);
			if(rs !=null)
			{
				while ( rs.next() )
					{
						no_record=rs.getInt(1);	
					}
			}

		}
		if(no_record!=0){
			practitioner_yn=true;
		}else{
		practitioner_yn=false;
		}
		String patient_id_temp	= checkForNull(request.getParameter("patient_id_temp"));
		String first_name_temp	= checkForNull(request.getParameter("first_name_temp"));
		String second_name_temp	= checkForNull(request.getParameter("second_name_temp"));
		String third_name_temp	= checkForNull(request.getParameter("third_name_temp"));
		String family_name_temp	= checkForNull(request.getParameter("family_name_temp"));
		String gender_temp		= checkForNull(request.getParameter("gender_temp"));
		String contact_no_temp	= checkForNull(request.getParameter("contact_no_temp"));
		String rd_appt_yn	= checkForNull(request.getParameter("rd_appt_yn"));
		/*System.out.println("patient_id_temp Appointment==>"+patient_id_temp);
		System.out.println("first_name_temp Appointment==>"+first_name_temp);
		System.out.println("second_name_temp Appointment==>"+second_name_temp);
		System.out.println("third_name_temp Appointment==>"+third_name_temp);
		System.out.println("family_name_temp Appointment==>"+family_name_temp);
		System.out.println("gender_temp Appointment==>"+gender_temp);
		System.out.println("contact_no_temp Appointment==>"+contact_no_temp);*/

	if(practitioner_yn && ca_mode.equals("ca_mode"))
	{
		%>
		<!-- <frameset id='AppointmentFrame' rows='*,8%' frameborder=0>
				<frameset cols='30%,*'>
				<frame name='apptdairy' src='../../eOA/jsp/CAOAApptDairy.jsp?<%=s%>' noresize frameborder=0 scrolling='no'>
				<frame name='dummy' src='../../eCommon/html/blank.html' noresize frameborder=0 scrolling='yes'>
				</frameset>
			<frame name='DispOAResultCB' src='../../eOA/jsp/CheckBoxDisplay.jsp' noresize frameborder='0' scrolling='no'>				
		</frameset> -->
		<iframe name='apptdairy' src='../../eOA/jsp/CAOAApptDairy.jsp?<%=s%>' noresize frameborder=0 scrolling='no' style="height:100vh;width:30vw"></iframe>
		<iframe name='dummy' src='../../eCommon/html/blank.html' noresize frameborder=0 scrolling='yes' style="height:100vh;width:70vw"></iframe>
		<iframe name='DispOAResultCB' src='../../eOA/jsp/CheckBoxDisplay.jsp' noresize frameborder='0' scrolling='no' style="height:8vh;width:100vw"></iframe>
		<%
	}else{
		%>
		<iframe name='image' src='../../eOA/jsp/DisplayImage.jsp?calling_mode=<%=calling_mode%>&<%=s%>' frameborder="0" scrolling=no noresize style="height:4vh;width:100vw;border:'5'"></iframe>
		<iframe name='querying'src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&patient_id_temp=<%=patient_id_temp%>&first_name_temp=<%=first_name_temp%>&second_name_temp=<%=second_name_temp%>&third_name_temp=<%=third_name_temp%>&family_name_temp=<%=family_name_temp%>&gender_temp=<%=gender_temp%>&contact_no_temp=<%=contact_no_temp%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder="0" scrolling=no noresize style="height:29vh;width:99vw;border:'5'"></iframe>
		<iframe name='dummy' src='../../eCommon/html/blank.html' frameborder="0" noresize scrolling=no style="height:0vh;width:100vw;border:'5'"></iframe>
		<iframe name='result' src='../../eCommon/html/blank.html' frameborder="0" noresize scrolling=auto style="height:60vh;width:99vw;border:'5'"></iframe>
		<%
	}
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
}
catch(Exception es)
{
	//out.println("Exception :"+es);
	es.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
	%>
</head>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

