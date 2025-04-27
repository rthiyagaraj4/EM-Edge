<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<head>
<html>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript'>	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%
request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE"); 
String strFacilityId=(String)session.getValue("facility_id");
String strBookingNum=checkForNull(request.getParameter("booking_no"));
String sql="";
String SQL1="SELECT RESCHEDULED_COUNT FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM=?";
String scheduled_count="";
String strPatientId="";
String strPatientName="";
String strDOB="";
String strSex="";
String male =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+",";
String female=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+",";
String unknown =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+",";



		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;		
		conn = ConnectionManager.getConnection(request);


	try{
		sql=OTRepository.getOTKeyValue("SQL_OT_PRERESCHEDULE_SELECT2");

		/*sql="SELECT PATIENT_ID PATIENT_ID1,PATIENT_NAME PATIENT_NAME1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, SEX  SEX1 FROM	  OT_BOOKING_RESCHD_DTLS_VW WHERE OPERATING_FACILITY_ID	= ? AND	  BOOKING_NUM		= ?";
		*/

		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strBookingNum);
		rs=pstmt.executeQuery();


		while(rs.next()){
		 strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		 strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));	
		 strDOB=com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale);		 
		
		 strSex=checkForNull(rs.getString("SEX1"),"U");		 	 	 		
		}

	   if(strSex.length()>0){
		   if(strSex.charAt(0)=='F')		    
			   strSex=female;
		   else  if(strSex.charAt(0)=='M') 	    
			   strSex=male;
		   else  strSex=unknown;
	   }
        pstmt=conn.prepareCall(SQL1);
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strBookingNum);
		rs=pstmt.executeQuery();
		while(rs.next()){
			scheduled_count=CommonBean.checkForNull(rs.getString(1));
		}
	}catch(Exception ee){
		ee.printStackTrace();
		 System.err.println("Err Msg in PreReScheduleSearch.jsp"+ee.getMessage());
		//eOT.LogFile.log("OTDebugger","Exception  "+ee,this);
	} finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)
			ConnectionManager.returnConnection(conn,request);
		 }catch(Exception e){}
	}
		

%>
<form name="PreRescheduleFrm" id="PreRescheduleFrm" >

<table cellpadding=3 cellspacing="0" width="100%" align="center" border="0">
<tr>
	<td class="label" WIDTH="25%" >
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields" WIDTH="25%" nowrap>
		<input type='text' name='patientid' id='patientid' maxlength='20' size='20' value= "<%=strPatientId%>" disabled>
		<input type='text' name='patientname' id='patientname' maxlength='60' size='40' value= "<%=strPatientName%>" disabled>
	</td>
	<td class='label' width="25%" nowrap>
		<fmt:message key="Common.gender.label" bundle="${common_labels}"/>	
	</td>
	<td class='fields' width="25%" >
		<input type='text' name='booking_no' id='booking_no' maxlength='10' size='10' value= "<%=strSex%>"  disabled>
	</td>
</tr>
<tr>
	<td class="label" width="25%" nowrap >
	<fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields"  width="25%" >
		<input type='text' name='dob' id='dob' maxlength='15' size='15' value= "<%=strDOB%>" disabled>
		<fmt:message key="eOT.BookingNO.Label" bundle="${ot_labels}"/>
		<input type='text' name='booking_no' id='booking_no' maxlength='15' size='15' value= "<%=strBookingNum%>"  disabled>
	</td>
	<td class='label' width="25%"  nowrap>
		<fmt:message key="eOT.NoofTimesRescheduled.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields"  width="25%" >
		<input type='text' name='rescheduled_count' id='rescheduled_count' maxlength='3' size='3' value= "<%=scheduled_count%>"  disabled>
	</td>

</tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

