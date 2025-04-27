<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
    String sql = "";
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
	String checked = "";
	String bio_hazard_yn	= "";
	String facility_id	= (String)session.getValue("facility_id");
	String oper_num	= checkForNull(request.getParameter("oper_num"));	
	try{
		connection	= ConnectionManager.getConnection(request);
		sql		= "SELECT NVL(BIO_HAZARD_YN,'N') BIO_HAZARD_YN FROM OT_STORE_ISSUE_HDR WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM=?";
		pstmt	= connection.prepareStatement(sql) ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
	
		rs		= pstmt.executeQuery();
		while(rs!=null && rs.next()){
			bio_hazard_yn = rs.getString("BIO_HAZARD_YN");
		}
	}catch ( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountHdr: "+e);
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception es){es.printStackTrace();}
	}
	
	bio_hazard_yn=bio_hazard_yn==null?"N":bio_hazard_yn;
	bio_hazard_yn=bio_hazard_yn.equals("null")?"N":bio_hazard_yn;
	if(bio_hazard_yn.equals("Y"))
		checked = "checked";
%>


	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eOT/js/InstrumentCount.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head> 
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="BiohazardForm" id="BiohazardForm">
	<table align="right" >
	<td width="25%" class="label">
	<fmt:message key="eOT.BioHazard.Label" bundle="${ot_labels}"/>?
	</td>
	<td width="25%" class="field">
	<input type="checkbox" class="checkbox"  <%=checked%> name="bio_hazard_yn" value="<%=bio_hazard_yn%>" onClick="assignCheckboxValue1(this)" >
	</td>
	</table>
	<input type="hidden" name="flag_confirmed_yn" id="flag_confirmed_yn"  value="">	
	</form>
	</body>
	</html>
	
 

