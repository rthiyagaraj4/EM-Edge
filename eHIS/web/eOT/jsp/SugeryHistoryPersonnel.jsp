<!DOCTYPE html>
<% //"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.*,eOT.*,eOT.Common.*, java.io.*" 
%>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.Common.*,webbeans.eCommon.*,eOT.*,eOT.Common.*" contentType=" text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<% request.setCharacterEncoding("UTF-8"); %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SurgeryHistoryPersonnelForm" id="SurgeryHistoryPersonnelForm">
<table border='1' cellpadding='3' cellspacing='0' width='100%' align="center"> 
<th class="ColumnHeaderCenter"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>               
<th class="ColumnHeaderCenter"> <fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>                                  
<th class="ColumnHeaderCenter"><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>                                   
<% 

	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String qryVal="";
	String speciality_desc="";
	String role_desc="";
	String practitioner_name="";
	String[] sqlArr = new String[2];//Added Against ML-MMOH-SCF-3020
	try{
		con = ConnectionManager.getConnection(request);
		sqlArr =  (OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")).split("##");//Added Against ML-MMOH-SCF-3020
		pstmt = con.prepareStatement(sqlArr[0]);//Modified Against ML-MMOH-SCF-3020
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,oper_num);
		rst = pstmt.executeQuery();
		int index=0;
		while(rst.next()){
			++index;
		   speciality_desc = CommonBean.checkForNull(rst.getString("SPECIALITY_DESC"));
		   role_desc =    CommonBean.checkForNull(rst.getString("ROLE_DESC"));
		   practitioner_name= CommonBean.checkForNull(rst.getString("PRACTITIONER_NAME"));
		   qryVal=(index%2==0)?"QRYEVEN":"QRYODD";	
				
		%>
		<tr>
			<td class="<%=qryVal%>" > <%=speciality_desc%> </td>
			<td class="<%=qryVal%>" > <%=role_desc%> </td>
			<td class="<%=qryVal%>" > <%=practitioner_name%> </td>
		</tr>
	<%	
		}
	}catch(Exception e){
		 System.err.println("Err Msg in SurgeryHistoryPersonnel.jsp"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>

