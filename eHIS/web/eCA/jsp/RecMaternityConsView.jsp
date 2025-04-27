<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	
	//String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"SpecialityStyle.css";
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
%>

<html>
<title><fmt:message key="eCA.RecMaternityconsView.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCA/html/SpecialityStyle.css' type='text/css'></link> 
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body class='MCCONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

<form name = "RecMaternityconsViewForm" >
<%

	java.sql.Connection			con		=	null;
	java.sql.PreparedStatement	pstmt	=	null;
	java.sql.ResultSet			rs		=	null;
	String query_section_details		=	"";
	
	StringBuffer htmContent = new StringBuffer();
	String accession_num					="";
	String sec_hdg_code						="";
	String moduleId							="";
	String sectioncode						="";
	String sectiondesc						="";
	String sectionType						="";
	String hrmode							="";
	String modeValue						="";
	String patient_id						="";
	String cycle_no							="";
	String facility_id       = (String) session.getValue("facility_id");
	
	accession_num	=	request.getParameter("accessionNum")==null?"":request.getParameter("accessionNum");
	sec_hdg_code	=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	moduleId	=	request.getParameter("module_id")==null?"":request.getParameter("module_id");
	sectionType	=	request.getParameter("sectionType")==null?"":request.getParameter("sectionType");
	hrmode	=	request.getParameter("HRmode")==null?"":request.getParameter("HRmode");
	modeValue	=	request.getParameter("modeValue")==null?"":request.getParameter("modeValue");
	
	//modeValue	=	request.getParameter("modeValue")==null?"":request.getParameter("modeValue");
	patient_id	=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	cycle_no	=	request.getParameter("cycle_no")==null?"0":request.getParameter("cycle_no");
	//String QueryString	=	request.getQueryString() == null ? "" : request.getQueryString();
	String splt_event_code = request.getParameter("splty_event_code")==null?"":request.getParameter("splty_event_code");
//	String splty_task_code = request.getParameter("splty_task_code")==null?"":request.getParameter("splty_task_code");
	String birth_order = request.getParameter("birth_order")==null?"":request.getParameter("birth_order");
	
	con = ConnectionManager.getConnection(request);

	try
	{
		if(sectionType.equals("TM")||sectionType.equals("OC"))
		{
			query_section_details="SELECT HDR_CODE sectcode , HDR_CODE sectdesc, HTM_CONTENT FROM CA_PAT_SPLTY_TASK_DTL WHERE HDR_CODE=? AND ACCESSION_NUM =?";
		
		}

		else
		{
			if(modeValue.equals("VA"))
				{
					query_section_details = " SELECT  a.CHILD_SEC_HDG_CODE sectcode , a.CHILD_SEC_HDG_DESC sectdesc,  b.HTM_CONTENT FROM  CA_SUBSECTION_LINK_VW a,CA_PAT_SPLTY_TASK_DTL b,CA_PAT_SPLTY_EPISODE_TASK C WHERE b.HDR_CODE = a.HEADER_SEC_HDG_CODE AND SUBHDR_CODE = CHILD_SEC_HDG_CODE AND B.ACCESSION_NUM=C.ACCESSION_NUM AND C.PATIENT_ID = ? AND C.FACILITY_ID= ? AND C.MODULE_ID= ? AND C.CYCLE_NO = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE= 'MCT005' AND BIRTH_ORDER = 1 AND HDR_CODE='MC25' AND CHILD_SEC_HDG_CODE ='MC05' union all SELECT  a.CHILD_SEC_HDG_CODE sectcode , a.CHILD_SEC_HDG_DESC sectdesc,  b.HTM_CONTENT FROM  CA_SUBSECTION_LINK_VW a,CA_PAT_SPLTY_TASK_DTL b,CA_PAT_SPLTY_EPISODE_TASK C WHERE b.HDR_CODE = a.HEADER_SEC_HDG_CODE AND SUBHDR_CODE = CHILD_SEC_HDG_CODE AND B.ACCESSION_NUM=C.ACCESSION_NUM AND C.PATIENT_ID =? /*AND C.FACILITY_ID=?*/ AND C.MODULE_ID= ? AND C.CYCLE_NO = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND BIRTH_ORDER = ? AND   HDR_CODE='MC25' AND CHILD_SEC_HDG_CODE !='MC05' ";

				}
			else if(!hrmode.equals("H"))
			{
				query_section_details = "SELECT  a.CHILD_SEC_HDG_CODE sectcode , a.CHILD_SEC_HDG_DESC sectdesc,  b.HTM_CONTENT FROM  CA_SUBSECTION_LINK_VW a,CA_PAT_SPLTY_TASK_DTL b WHERE b.HDR_CODE = a.HEADER_SEC_HDG_CODE AND SUBHDR_CODE = CHILD_SEC_HDG_CODE AND   HDR_CODE=? AND ACCESSION_NUM = ? ";
			}
			else
			{
				
					query_section_details = "SELECT  a.CHILD_SEC_HDG_CODE sectcode , a.CHILD_SEC_HDG_DESC sectdesc,  b.HTM_CONTENT FROM  CA_SUBSECTION_LINK_VW a,CA_PAT_SPLTY_TASK_DTL b WHERE b.HDR_CODE = a.HEADER_SEC_HDG_CODE AND SUBHDR_CODE = CHILD_SEC_HDG_CODE AND   HDR_CODE=? AND ACCESSION_NUM = ? AND CHILD_SEC_HDG_CODE =? ";
				
			}
		}
			
			pstmt		=	con.prepareStatement(query_section_details);
				
			if(modeValue.equals("VA"))
				{									
					pstmt.setString(1,patient_id);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,moduleId);
					pstmt.setString(4,cycle_no);
					pstmt.setString(5,splt_event_code);
					//pstmt.setString(6,splty_task_code);
					pstmt.setString(6,patient_id);
			//		pstmt.setString(7,facility_id);
					pstmt.setString(7,moduleId);
					pstmt.setString(8,cycle_no);
					pstmt.setString(9,splt_event_code);
					//pstmt.setString(12,splty_task_code);
					pstmt.setString(10,birth_order);

				}
			else if(!hrmode.equals("H"))
			{
				pstmt.setString(1,sec_hdg_code);
				pstmt.setString(2,accession_num);
			}
			else
			{
				
				
					pstmt.setString(1,sec_hdg_code);
					pstmt.setString(2,accession_num);
					pstmt.setString(3,"MC03");
				
			}
			rs			=	pstmt.executeQuery();
	

		while(rs.next())
		{
				
			sectioncode = rs.getString("sectcode");
			sectiondesc = rs.getString("sectdesc");
			if(!sectionType.equals("TM"))
			{
				htmContent.append("<table width='100%' class='MCSUBHEADER'><tr><td align='left' colspan='3'><a name='"+sectiondesc+"'>"+sectiondesc+"</a></td></tr></table>");
			}
			Clob HTM_CONTENT = (Clob) rs.getClob("HTM_CONTENT");
			

			if(HTM_CONTENT !=null)
			{
				java.io.BufferedReader r = new java.io.BufferedReader(HTM_CONTENT.getCharacterStream());
				String line = null;

				while((line=r.readLine()) != null) 
				{
					htmContent.append(line);
				}
			}
			
		 }	
		
	}
	catch(Exception e)
	{
		//out.println("Exception @ RecMaternityConsView.jsp"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>

<%=htmContent.toString()%>

</form>
</body>
</html>

