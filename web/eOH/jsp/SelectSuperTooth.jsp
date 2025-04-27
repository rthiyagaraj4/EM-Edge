<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	Connection con=null;
	PreparedStatement pstmt=null;

	ResultSet rst=null;
	String super_key_val = "";

	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
	String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
	String disply_tooth_no = checkForNull(request.getParameter( "disply_tooth_no" )) ;

	//out.println("disply_tooth_no:=="+disply_tooth_no);
	String RD_Normal_yn = checkForNull(request.getParameter( "RD_Normal_yn" )) ;

try{
	con=ConnectionManager.getConnection(request);
	
%>

<html>
<head>
	<title>Tooth No Details</title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>
		function setValue(obj){
			//var super_tooth = document.forms[0].super_tooth.value;
			var tooth =  obj.value;
			//window.returnValue=super_tooth;
			window.returnValue=tooth;
			window.close();
		}
	</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
	<form name="OHSelectSuperTooth" id="OHSelectSuperTooth">
		<table width="100%" cellpadding =2 cellspacing='2' border='1' align="center" valign="center">
			<tr valign="center">
				<td width="25%" class="CAGROUP" nowrap><fmt:message key="eOH.ToothNo.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="CAGROUP" nowrap>Select</td>
			</tr>
			<tr valign="center">
				<td width="25%" class='LABEL' nowrap><%=disply_tooth_no%></td>
					  <!-- <select name="super_tooth" id="super_tooth" onChange="" >  
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<option value='<%=tooth_no%>'><%=disply_tooth_no%></option> -->
				<td width="25%" class='LABEL' nowrap>
						<INPUT TYPE="radio" name="tooth_no" id="tooth_no"  value="<%=disply_tooth_no%>" onclick="setValue(this);" />
				</td>
			</tr>
						 <%
								if(rst != null) rst.close();
								if(pstmt != null) pstmt.close();
								if(!RD_Normal_yn.equals("D") && !RD_Normal_yn.equals("MR") && !RD_Normal_yn.equals("M") && !RD_Normal_yn.equals("MRP") && !RD_Normal_yn.equals("RD")){
									pstmt = con.prepareStatement("SELECT SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'D' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'M' ORDER BY SUPER_KEY_NUM");
								}
								else{
									pstmt = con.prepareStatement("SELECT SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E' ORDER BY SUPER_KEY_NUM");
								}
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,tooth_no);
								rst = pstmt.executeQuery();
								while(rst.next()){
									super_key_val = checkForNull(rst.getString("SUPER_KEY_NUM"));
						%>
									<tr valign="center">
										<td width="25%" class='LABEL' nowrap><%=super_key_val%></td>
										<td width="25%" class='LABEL' nowrap><INPUT TYPE="radio" name="tooth_no" id="tooth_no"  value="<%=super_key_val%>" onclick="setValue(this);" /></td>
										<!-- <option value='<%=super_key_val%>'><%=super_key_val%></option> -->
									</tr>
						<%
								}
						%>
					<!-- </select> -->
				</td>
			</tr>
			<!-- <tr>
				<td class='MESSAGE' align='center'>
					<input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='windowClosing();'>
					<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="setValue()">
			</td> -->
		</tr>
		</table>
	</form>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

