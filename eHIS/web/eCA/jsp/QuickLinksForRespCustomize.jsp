<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	webbeans.eCommon.RecordSet CustomizeResp = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeResp"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet CustomizeRespDef = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeRespDef"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session); 


%>


<html>
<head>
<title><fmt:message key="eCA.QuickLinkForResponsibility.label" bundle="${ca_labels}"/></title>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script src='../js/CAMenu.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
</head>
	
<%	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");

	//String practitioner_id	= (String) session.getValue("ca_practitioner_id");
	String respid = (String) session.getValue("responsibility_id");
	String userId=((String) session.getValue("login_user")).trim();

	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");

	String prev_notes_called_from = request.getParameter("prev_notes_called_from") == null ? "" : request.getParameter("prev_notes_called_from");

	if(!prev_notes_called_from.equals("") && prev_notes_called_from.equals("PREVIOUS_NOTES"))
		function_id = prev_notes_called_from;

	

	String link_type = request.getParameter("link_type") == null ? "" : request.getParameter("link_type");
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;

	String occurance = request.getParameter("occurance");

	
	if(occurance == null) {
			occurance = "";
			CustomizeResp.clearAll();
			CustomizeRespDef.clearAll();
		}

	try
	{
		con = ConnectionManager.getConnection(request);
		String ql_ref	= "";
		String checkStatus  = "";
		String default_yn  = "";
		StringBuffer sql = new StringBuffer();
		
		//sql.append("select a.QUICK_LINK_REF, NVL((select 'Y' from SM_QUICK_LINK_RESP where QUICK_LINK_REF = a.QUICK_LINK_REF and RESP_ID = ?),'N') checked  from SM_QUICK_LINK_LIST a where a.EFF_STATUS = 'E' ");
		
		/*sql.append("select a.QUICK_LINK_REF, NVL((select 'Y' from SM_QUICK_LINK_FOR_USER where QUICK_LINK_REF = a.QUICK_LINK_REF and LINK_TYPE = ? and APPL_USER_ID =?),'N') checked from SM_QUICK_LINK_LIST a where a.EFF_STATUS = 'E' ");
						
		if(!link_type.equals("F"))
			sql.append(" and a.FUNCTION_SPEC_YN='Y' ");
		else if(!link_type.equals("Q"))
			sql.append(" and a.GLOBAL_YN = 'Y' ");
		
		

		*/

		sql.append("SELECT A.QUICK_LINK_REF , nvl2(c.QUICK_LINK_REF,'Y','N') checked_yn,NVL(C.DEFAULT_YN,'N') DEFAULT_YN");

		sql.append(" FROM SM_QUICK_LINK_LIST_LANG_VW A,SM_QUICK_LINK_RESP B,SM_QUICK_LINK_FOR_USER c WHERE  a.LANGUAGE_ID = '"+locale+"' and B.RESP_ID=? AND A.QUICK_LINK_REF =B.QUICK_LINK_REF and c.APPL_USER_ID(+)=? AND c.LINK_TYPE(+) =?  AND c.QUICK_LINK_REF(+) =A.QUICK_LINK_REF "); // AND c.QUICK_LINK_REF(+) =A.QUICK_LINK_REF

		if(link_type.equals("Q"))
			sql.append(" AND A.GLOBAL_YN='Y'");
		else if(link_type.equals("F"))
			sql.append(" AND A.FUNCTION_SPEC_YN ='Y' AND A.OPTION_ID=?");

		


		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,respid);
		pstmt.setString(2,userId);
		pstmt.setString(3,link_type);
		if(link_type.equals("F"))
		pstmt.setString(4,function_id);
		
		
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			ql_ref = rs.getString("QUICK_LINK_REF")==null?"":rs.getString("QUICK_LINK_REF");
			
			checkStatus = rs.getString("checked_yn")==null?"":rs.getString("checked_yn");
			default_yn = rs.getString("DEFAULT_YN")==null?"":rs.getString("DEFAULT_YN");
			
						
			if(checkStatus.equals("Y"))
			{
				if(!(CustomizeResp.containsObject(ql_ref))){
					CustomizeResp.putObject(ql_ref);
				}
			}

			if(default_yn.equals("Y"))
			{
				if(!(CustomizeRespDef.containsObject(ql_ref))){
					CustomizeRespDef.putObject(ql_ref);
				}
			}

		}
		
		putObjectInBean("CustomizeResp"+patient_id+encounterId, CustomizeResp,session);
		putObjectInBean("CustomizeRespDef"+patient_id+encounterId, CustomizeRespDef,session);
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}finally{
		try {
			if (con !=null)ConnectionManager.returnConnection(con,request);
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}
%>
	<iframe name="detailFrame" id="detailFrame" SRC="../../eCA/jsp/QuickLinksForRespCustomizeDtl.jsp?<%=request.getQueryString()%>" scrolling="no" frameborder="no"  noresize style="height:90vh;width:100vw"></iframe>
		<iframe name="messageFrame" id="messageFrame" frameborder="no" scrolling="no" noresize src="../../eCommon/jsp/error.jsp" style="height:10vh;width:100vw"></iframe> 
		

</html>

