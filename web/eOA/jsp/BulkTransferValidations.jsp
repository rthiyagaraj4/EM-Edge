<!DOCTYPE html>
<%--
Filename			: BulkTransferValidations.jsp
Added On		: 05-03-2010
Created By		: S.Sathish 
Created For		: IN019217
--%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String locale =((String)session.getAttribute("LOCALE"));
 request.setCharacterEncoding("UTF-8");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
</head>
<body class='MESSAGE' onKeyDown = 'lockKey();'>			
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eOA/js/BulkTransferAppointment.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String clinic_code = request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
	String clinic_date = request.getParameter("clinic_date")==null?"":request.getParameter("clinic_date");
	String practitioner_id = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
	Connection con = null;	
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	String loginfacility = (String) session.getValue("facility_id");	
	String sql="";
	//String start_time="";
	//String end_time="";	
	//boolean proceed=false;
	//String datechecksql="";
	String result="";
	try
	{
		con = ConnectionManager.getConnection(request);
		
	//	sql="SELECT CASE WHEN to_date(to_char(clinic_date, 'DD/MM/YYYY ') || to_char(start_time,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS')> SYSDATE THEN 'true' WHEN NOT EXISTS (SELECT 1 FROM oa_appt WHERE facility_id = a.facility_id AND clinic_code = a.clinic_code AND practitioner_id = a.practitioner_id AND appt_date = a.clinic_date AND to_date(to_char(appt_date, 'DD/MM/YYYY ')|| to_char(appt_slab_from_time,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') < SYSDATE )THEN 'true' ELSE 'false' END AS RESULT FROM oa_clinic_schedule a WHERE facility_id = '"+loginfacility+"' AND clinic_code ='"+clinic_code+"' AND clinic_date = TO_DATE ('"+clinic_date+"','dd/mm/yyyy') AND practitioner_id = '"+practitioner_id+"'";
		sql="SELECT CASE WHEN to_date(to_char(clinic_date, 'DD/MM/YYYY ') || to_char(start_time,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS')> SYSDATE THEN 'true' WHEN NOT EXISTS (SELECT 1 FROM oa_appt WHERE facility_id = a.facility_id AND clinic_code = a.clinic_code AND practitioner_id = a.practitioner_id AND appt_date = a.clinic_date AND to_date(to_char(appt_date, 'DD/MM/YYYY ')|| to_char(appt_slab_from_time,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') < SYSDATE )THEN 'true' ELSE 'false' END AS RESULT FROM oa_clinic_schedule a WHERE facility_id = ? AND clinic_code =? AND clinic_date = TO_DATE (?,'dd/mm/yyyy') AND practitioner_id = ?";

		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,loginfacility);
		pstmt.setString(2,clinic_code);
		pstmt.setString(3,clinic_date);
		pstmt.setString(4,practitioner_id);
		rs=pstmt.executeQuery();
		if(rs != null)
		{
			while(rs.next())
			{
				result=rs.getString("RESULT");				
			}			
		}	
		if(rs != null) rs.close();			
		if(pstmt != null) pstmt.close();
		if(result.equals("false")){%>
		<script>
			alert(getMessage("ELAPSED_APPOINTMENTS_EXISTS","OA"));
			parent.frames[2].frames[1].moveforward("<%=result%>");
		</script>
		<%}else{%>
		<script>			
			parent.frames[2].frames[1].moveforward("<%=result%>");
		</script>
		<%}		

	}catch(Exception e){
//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
		finally
		{
			try{
					if(rs != null)		rs.close();			
					if(pstmt != null) pstmt.close();			
			}catch(Exception ee){}
			if(con != null) ConnectionManager.returnConnection(con,request);
		}	
			%>
	</body>
	</html>


