<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet QuickLinkResp = (webbeans.eCommon.RecordSet)getObjectFromBean("QuickLinkResp","webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet QuickLinkResp1 = (webbeans.eCommon.RecordSet)getObjectFromBean("QuickLinkResp1","webbeans.eCommon.RecordSet",session);
%>
<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../js/QuickLinksForResp.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='' onKeyDown="lockKey()">
<form name="QuickLinkResp_Form" id="QuickLinkResp_Form" action="QuickLinksForRespResult.jsp?<%=request.getQueryString()%>" method="post">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	StringBuffer sql = new StringBuffer();
	String checkStatus = "";
	String ql_ref = "";
	String default_yn = "";

	String occurance = request.getParameter("occurance");

	if(occurance == null)
	{
		occurance = "";
		QuickLinkResp.clearAll();
		QuickLinkResp1.clearAll();
	}
	
	String ql_type = request.getParameter("ql_type") == null ? "" : request.getParameter("ql_type");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String resp_id = request.getParameter("resp") == null ? "" : request.getParameter("resp");

	try
	{
		con = ConnectionManager.getConnection(request);

		sql.append("SELECT QUICK_LINK_REF, NVL((SELECT 'Y' FROM SM_QUICK_LINK_RESP WHERE RESP_ID=? AND LINK_TYPE =? AND QUICK_LINK_REF = a. QUICK_LINK_REF ),'N') checked, (SELECT DEFAULT_YN FROM SM_QUICK_LINK_RESP WHERE RESP_ID=? AND LINK_TYPE =? AND QUICK_LINK_REF = a. QUICK_LINK_REF) DEFAULT_YN FROM SM_QUICK_LINK_LIST a where a.eff_status='E' ");
		if(ql_type.equals("Q"))
			sql.append(" and a.GLOBAL_YN='Y'  ");
		else if(ql_type.equals("F"))
		{
			sql.append(" and a.OPTION_ID = ? ");
			sql.append(" and a.FUNCTION_SPEC_YN ='Y' ");
		}
		
		pstmt = con.prepareStatement(sql.toString());
		int counter = 0;
		pstmt.setString(++counter,resp_id);
		pstmt.setString(++counter,ql_type);
		pstmt.setString(++counter,resp_id);
		pstmt.setString(++counter,ql_type);
		if(ql_type.equals("F"))
			pstmt.setString(++counter,function_id);
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			ql_ref = rs.getString("QUICK_LINK_REF") == null ? "" : rs.getString("QUICK_LINK_REF");
			checkStatus = rs.getString("checked") == null ? "" : rs.getString("checked");
			default_yn = rs.getString("DEFAULT_YN") == null ? "" : rs.getString("DEFAULT_YN");
			if(checkStatus.equals("Y"))
			{
				if(!(QuickLinkResp.containsObject(ql_ref))){
					QuickLinkResp.putObject(ql_ref);
				}
			}
			if(default_yn.equals("Y"))
			{
				if(QuickLinkResp1.getSize() > 0)
				{
					QuickLinkResp1.removeObject(0);
					QuickLinkResp1.putObject(ql_ref);
				}
				else
					QuickLinkResp1.putObject(ql_ref);
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		putObjectInBean("QuickLinkResp", QuickLinkResp,session);
		putObjectInBean("QuickLinkResp1", QuickLinkResp1,session);
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally 
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
<script>
	parent.resultFrame.location.href = '../../eCA/jsp/QuickLinksForRespResult.jsp?ql_type=<%=ql_type%>&function_id=<%=function_id%>&resp_id=<%=resp_id%>';
</script>
</html>

