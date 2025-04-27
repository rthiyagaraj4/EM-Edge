<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String encounter_id  =	""; 
	String facility_id  =	"";	
	facility_id		=	(String)	session.getValue("facility_id");     
	encounter_id 	=	(request.getParameter("episode_id")==null)	?	""	:	request.getParameter("episode_id");
	
	String strPatientId = request.getParameter("patient_id");
%>
<%
  String qryCount = "SELECT COUNT(*) ae_count FROM AE_PAT_EMERGENCY_DETAIL b WHERE ENCOUNTER_ID='"+encounter_id+"' and facility_id = '"+facility_id+"'"; 
  qryCount=qryCount+" AND B.RECORDED_DATE=(SELECT MAX(RECORDED_DATE) FROM AE_PAT_EMERGENCY_DETAIL WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND rownum < 2)";

%>
<!--
	@Get The Connection
	@Prepare The Statement and Execute The Query
-->
<%
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int intCount = 0;
try{
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(qryCount);
	rs = pstmt.executeQuery();

	 while(rs.next())
	{
			intCount  = rs.getInt("ae_count");
	}
	if(rs!=null)rs.close();
	if(pstmt != null)pstmt.close();
	}catch(Exception e)
	{
		e.printStackTrace();
    }
	finally
	{
		if(rs!=null)rs.close();
		if(pstmt != null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
		if(intCount==1)
		{
	%>

<frameset rows='12%,*'>
	<frame src="../../eAE/jsp/AEEventQueryEncDtls.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facility_id%>" name="PatientLine_frame" scrolling=NO noresize>
		 <frameset cols='20%,*' >
			<frame name='view1' id='view1' src='../../eAE/jsp/AEEventQueryDetails.jsp?Patient_ID=<%=strPatientId%>&EncounterId=<%=encounter_id%>&Facility_Id=<%=facility_id%>' frameborder=0 scrolling='no' noresize>
			<frame name='view2' id='view2' src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' noresize>
		</frameset>
</frameset>
<%
		}
		else
		{
%>
		<script>
			var msg = 	getMessage( "NO_RECORD_FOUND_FOR_CRITERIA",'Common');	
			alert(msg);
	</script>
<%
		}
%>
</html>

