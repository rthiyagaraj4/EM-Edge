<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	StringBuffer seqList = new StringBuffer();
//	String spec_no_format = request.getParameter("spec_no_format") == null ? "" : request.getParameter("spec_no_format");
%>        
        <!--<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css' />-->
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../../eOR/js/ORSpecimenFmt.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%ResultSet rs = null;
PreparedStatement pstmt = null;
Connection con = null;
	try {
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement("SELECT SEQ_CODE||'~'||SEQ_DESCRIPTION||'~'||SEQ_FORMAT FROM OR_DEFINE_RUNNING_SEQ ORDER BY SEQ_CODE");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				seqList.append(rs.getString(1));				
				seqList.append("|");				
			}			
			seqList.delete(seqList.length()-1,seqList.length());
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();				

			pstmt = con.prepareStatement("SELECT CRIT_REF, CRIT_DESC, CRIT_SIZE FROM OR_SPEC_FORMAT_CRIT_LIST ORDER BY CRIT_DESC");
			rs = pstmt.executeQuery();													
%>
<form name="speciFmtLst" id="speciFmtLst">
 <table class='grid' width="50%" align="center" style="margin-top: 9px;">		
		<tr>
			<th><fmt:message key="Common.Components.label" bundle="${common_labels}"/></th>
		</tr>
<%		while(rs.next())
			{%>
				<tr><td class='gridData'>
				<a class='gridLink' href='javascript:onClickOfDoc("<%=rs.getString("CRIT_REF")%>","<%=rs.getString("CRIT_DESC")%>","<%=rs.getString("CRIT_SIZE")%>")'><%=rs.getString("CRIT_DESC")%></a></td></tr>
<%			}
%>
		
		<!-- <tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("eOR.DateDDMMYY.label","eOR"))'><fmt:message key="eOR.DateDDMMYY.label" bundle="${or_labels}"/></a></td></tr>
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("eOR.DateDDMMYYYY.label","eOR"))'><fmt:message key="eOR.DateDDMMYYYY.label" bundle="${or_labels}"/></a></td></tr>
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("eOR.RunningSerialNo.label","eOR"))'><fmt:message key="eOR.RunningSerialNo.label" bundle="${or_labels}"/></a>&nbsp;&nbsp;</td></tr>		
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("eOR.ByYear.label","eOR"))'><fmt:message key="eOR.ByYear.label" bundle="${or_labels}"/></a>&nbsp;&nbsp;</td></tr>
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("eOR.ByYearandJulianDate.label","eOR"))'><fmt:message key="eOR.ByYearandJulianDate.label" bundle="${or_labels}"/></a>&nbsp;&nbsp;</td></tr>
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("Common.OrderType.label","common"))'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;</td></tr> -->
		
	</table>
	<input type='hidden' name='seqList' id='seqList' value = '<%=seqList.toString()%>'>
</form>
<%
		if(rs != null)rs.close();
		if(pstmt != null)pstmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(con != null)con.close();
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}%>
</body>
</html>

