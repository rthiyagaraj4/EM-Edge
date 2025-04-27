<!DOCTYPE html>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="../../eMP/IRISMyKad/jquery-3.2.1.min.js"></script>
<script src="../../eMP/js/CardReaderMyKad.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>

<%@ page import="java.sql.*, java.util.HashMap, java.util.ArrayList, eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,java.util.*,com.ehis.util.*,eCommon.Common.*,eXH.InterfaceUtil,eXH.XHUtil,org.json.simple.*,eMP.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%request.setCharacterEncoding("UTF-8");
 
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <%
		Connection con=null ;
	    PreparedStatement pstmt=null ;
	    ResultSet rs=null ;
		String step1=request.getParameter("step");
		String fingerIndex=request.getParameter("fingerIndex");		 
	%>		
 	<title><fmt:message key="eMP.FingerAuth.label" bundle="${mp_labels}"/></title>	 
	<body>
	<%if(step1.equals("01")) {%>
	<form name='Biometric_Authentication_form' id='Biometric_Authentication_form' action='../jsp/BiometricAuthenticationPopup.jsp?step=02' method='post'  target='messageFrame'>
	<%
			try{
			String fun_id=request.getParameter("fun_id");
			String finger_type="1";//request.getParameter("finger_type");//according to emraites ID
			String imagecount="";
			con = ConnectionManager.getConnection(request);
			ArrayList reasoncode = new ArrayList();
			ArrayList reasons = new ArrayList();
			String sql ="select CONTACT_REASON_CODE,CONTACT_REASON from am_contact_reason where REASON_BIOMETRIC_REJECTION_YN='Y'";
			pstmt = con.prepareStatement(sql) ;
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					reasoncode.add(rs.getString("CONTACT_REASON_CODE")) ;
					reasons.add(rs.getString("CONTACT_REASON")) ;
				}
			 }				
			HashMap<Integer, String> fingerMap = new HashMap<Integer, String>();	
			fingerMap.put(1, "Scan Right Thumb");
			fingerMap.put(2, "Scan Right Index Finger");
			fingerMap.put(3, "Scan Right Middle Finger");
			fingerMap.put(4, "Scan Right Ring Finger");
			fingerMap.put(5, "Scan Right Little Finger");
			fingerMap.put(6, "Scan Left Thumb");
			fingerMap.put(7, "Scan Left Index Finger");
			fingerMap.put(8, "Scan Left Middle Finger");
			fingerMap.put(9, "Scan Left Ring Finger");
			fingerMap.put(10, "Scan Left Little Finger");
							
		 %>
			<table border='0' cellpadding='2' cellspacing='0' width='70%'>
			<tr>
			<table id="fingerScanId">
			<td   align='left' width='50%' nowrap style=" height:100px;">
			<img src="../images/finger_scan_<%=fingerIndex%>.png"  style="width:200px; height:200px;">
			</td>
			<td style="width:30%;"><button type="button"   onClick="ScanWithBiometric()">&nbsp;&nbsp;&nbsp;&nbsp;<%=fingerMap.get(Integer.parseInt(fingerIndex))%>&nbsp;&nbsp;&nbsp;&nbsp;</button></td>
			</table>
			<table id="failureMsg"  style="visibility:hidden;margin-top:10px;margin-left:130px;width:400px;height:140px;text-align:center;">
			<tr>
			<td><h4><fmt:message key="Common.UnsuccessfulAuthentication.label" bundle="${common_labels}"/></h4></td>
			</tr>
			</table>
			<table id="successMsg"  style="visibility:hidden; margin-top:10px;width:500px;height:100px;text-align:center;margin-top:0px;">
			<tr>
			<td><h4><fmt:message key="Common.SuccessfulAuthentication.label" bundle="${common_labels}"/></h4></td>
			</tr>
			</table>
			</tr> 
		<table  id="reasonnId">
		<tr  >
			<td class='LABEL' align='RIGHT' width='20%' nowrap' nowrap><fmt:message key="eMP.Reason.label" bundle="${mp_labels}"/></td>     
		</tr>	
			<tr>
				<td	class='LABEL' align='left' width='20%' nowrap>
					<select name='biometric_reason' id='biometric_reason' width='20%' id='biometric_reason' onchange="enablereasonsubmitbutton()">
					<option value='' >----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					for(int i=0;i<reasoncode.size();i++){out.println( "<option value='"+reasoncode.get(i)+"'>"+reasons.get(i)+"</option>" ) ;}%>
					</select>
			</td>
		 <td class='LABEL' align='left' width='10%' nowrap"><button type="button" id="SubmitReasonButton" disabled onClick="SaveBiometricReason()"> &nbsp;&nbsp;&nbsp;<fmt:message key="Common.Submit.label" bundle="${mp_labels}"/>&nbsp;&nbsp;&nbsp;</button></td> 
			</tr>
			</table> 
		</table>
		<input type='hidden' name='fun_id' id='fun_id' value='<%=fun_id%>'>
		<input type='hidden' name='patient_id' id='patient_id' value='66'> 
		<input type='hidden' name='step' id='step' value='02'> 
		<input type='hidden' name='fingerIndex' id='fingerIndex' id='fingerIndex' value='<%=fingerIndex%>'>
		<%
		 }catch(Exception e){
			 e.printStackTrace();
			 }finally{
			 if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con,request);
		 }	%>   
</form>  
<%}
else if(step1.equals("02")) {
	String biometric_reason=request.getParameter("biometric_reason");
	session.setAttribute("biometric_reason", biometric_reason);
}
%>  
</body>
<script>
document.getElementById("failureMsg").style.display = "none"; 
document.getElementById("successMsg").style.display = "none"; 
</script>
</html>

