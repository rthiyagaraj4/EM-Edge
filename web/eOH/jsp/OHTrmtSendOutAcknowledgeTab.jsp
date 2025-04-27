<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

	<script language="javascript">
		function changeTab(objStr){
			var frmObj=document.forms[0];
			var param=frmObj.param.value;
			if(document.getElementById("tablist").disabled == false){
				
				selectTab(objStr);
				switch(objStr){
					
					case "TrmtSendOut": 
						parent.frames[1].location.href="../../eOH/jsp/OHTrmtSendOut.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;
					case "TrmtAcknowledge": 
						parent.frames[1].location.href="../../eOH/jsp/OHTrmtAcknowledge.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;
					case "TrmtRecieve": 
						parent.frames[1].location.href="../../eOH/jsp/OHTrmtRecieveDetails.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;
					case "TrmtResultEntry": 
						parent.frames[1].location.href="../../eOH/jsp/DentalTreatment.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;
				}
			}
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String params = request.getQueryString();
		String facility_id = (String)session.getValue("facility_id") ;
		String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
		String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
		String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
		String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
		String task_code = checkForNull(request.getParameter( "task_code" )) ;
		String task_seq_no = checkForNull(request.getParameter( "task_seq_no" )) ;
		String ext_perm_loc_param = checkForNull(request.getParameter( "ext_perm_loc_param" )) ;
		String ext_perform_dtls_reqd_yn = checkForNull(request.getParameter( "ext_perform_dtls_reqd_yn" )) ;

		String acknowledged_yn = "";
		String received_yn = "";
		String sendout_yn = "";
		String acknowledged_disable = "";
		String received_disable = "";
		String resultentry_disable = "";
		
		try{
			con=ConnectionManager.getConnection(request);
			
			if(ext_perm_loc_param.equals("Y") && ext_perform_dtls_reqd_yn.equals("Y")){
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				pstmt=con.prepareStatement("SELECT ACKNOWLEDGED_YN, RECEIVED_YN, SENDOUT_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,task_code);
				pstmt.setString(6,task_seq_no);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					acknowledged_yn = checkForNull(rs.getString("ACKNOWLEDGED_YN"));
					received_yn = checkForNull(rs.getString("RECEIVED_YN"));
					sendout_yn = checkForNull(rs.getString("SENDOUT_YN"));
				}

				if(!sendout_yn.equals("Y")){
					acknowledged_disable = "disabled";
					received_disable = "disabled";
					resultentry_disable = "disabled";
				}
				else if(sendout_yn.equals("Y") && !acknowledged_yn.equals("Y")){
					resultentry_disable = "disabled";
					received_disable = "disabled";
					acknowledged_disable = "";
				}
				else if(acknowledged_yn.equals("Y") && !received_yn.equals("Y")){
					resultentry_disable = "disabled";
					received_disable = "";
					acknowledged_disable = "";
				}
				else{
					received_disable = "";
					acknowledged_disable = "";
					resultentry_disable = "";
				}
			}

			

	%>
			<form name="OHSendOutAcknowledgeForm" id="OHSendOutAcknowledgeForm">
				<table id="tab" cellspacing=0 cellpadding=3 border="0" width='93%'>
					<tr>
						<td width= "100%" class="white">
							<ul id="tablist" class="tablist">
							<%
								if(ext_perm_loc_param.equals("Y")){
							%>
									<li class="tablistitem" title='TrmtSendOut' >
										<a  class="tabClicked"  onclick="changeTab('TrmtSendOut');" id="TrmtSendOut"> 
											<span class="tabSpanclicked" id="TrmtSendOutspan"><fmt:message key="eOR.SendOut.label" bundle="${or_labels}"/></span>
										</a>
									</li>
									 <li class="tablistitem" title='TrmtAcknowledge'>
										<a  class="tabA"  onclick="changeTab('TrmtAcknowledge');" id="TrmtAcknowledge" <%=acknowledged_disable%>> 
											<span class="tabAspan" id="TrmtAcknowledgespan"><fmt:message key="eOH.Acknowledge.Label" bundle="${oh_labels}"/></span>
										</a>
									</li>
									<li class="tablistitem" title='TrmtRecieve'>
										<a  class="tabA"  onclick="changeTab('TrmtRecieve');" id="TrmtRecieve" <%=received_disable%>> 
											<span class="tabAspan" id="TrmtRecievespan"><fmt:message key="eOH.RecieveDetails.Label" bundle="${oh_labels}"/></span>
										</a>
									</li>
									<li class="tablistitem" title='TrmtResultEntry'>
										<a  class="tabA"  onclick="changeTab('TrmtResultEntry');" id="TrmtResultEntry" <%=resultentry_disable%>> 
											<span class="tabAspan" id="TrmtResultEntryspan"><fmt:message key="eOH.ResultEntry.Label" bundle="${oh_labels}"/></span>
										</a>
									</li>
							<%
								}
								else{
							%>
									<li class="tablistitem" title='TrmtResultEntry'>
									<a  class="tabClicked"  onclick="changeTab('TrmtResultEntry');" id="TrmtResultEntry" <%=resultentry_disable%>> 
										<span class="tabSpanclicked" id="TrmtResultEntryspan"><fmt:message key="eOH.ResultEntry.Label" bundle="${oh_labels}"/></span>
									</a>
								</li>
							<%
								}
							%>
							</ul>
						</td>
					</tr>
				</table>
<input type="hidden" name="param" id="param" value="<%=params%>">
<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
<input type = "hidden" name= "facility_id" value = "<%=facility_id%>"> 
<input type = "hidden" name= "ext_perm_loc_param" value = "<%=ext_perm_loc_param%>"> 

</form>

	

	<!-- The below line is required to change the select state of Initial tab selected -->
	<script>
		var ext_perm_loc_param = document.forms[0].ext_perm_loc_param.value;
		if(ext_perm_loc_param=="Y"){
			prevTabObj='TrmtSendOut';
		}
		else{
			prevTabObj='TrmtResultEntry';
		}
	</script>
	
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>





