<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
30/12/2012		IN035928		Nijitha			New widget Refferal Summary.
06/03/2013		IN038340  		Nijitha			CRF-CA- CHL-CRF-0015/03- Referral Summary Widget->External Practitioner Name is not displayed					 
--------------------------------------------------------------------------------------------------------------
Date     	Edit History   	Name        	Rev.date	Rev.Name 	Description
-------------------------------------------------------------------------------------------------------------------------------------------------
28/05/2018	IN065341	Prakash C	29/05/2018	Ramesh G 	MMS-DM-CRF-0115
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String title = request.getParameter("title")==null?"":request.getParameter("title");
%>
<TITLE><%=title%></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}

/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />

<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function scrollTitleBar()	//function to make the heading of the table static
{
	var scrollXY = document.body.scrollTop;
		document.getElementById("divTitleTable").style.position = 'relative';
		document.getElementById("divTitleTable").style.posTop  = scrollXY-1;
		
}
</script>
</HEAD>
<BODY onScroll='scrollTitleBar()'>
<table border='1' width='100%' id='dataTable' class='grid' align='center'>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	//String referral_priority=""; checkstyle
	ResultSet rs = null;
	StringBuffer strSql = new StringBuffer();
	String modal_yn=request.getParameter("modal_yn");
			if (modal_yn==null) modal_yn="N";

	java.util.Properties p = (java.util.Properties) session.getValue("jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//IN065341 starts
		String bean_id = "ca_CentralizedBean" ;
		String bean_name = "eCA.CentralizedBean";
		CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		String encounter_id="";
		String facilityid="";
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
		String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
		
		if(called_from.equals("CDR")){
			encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
			facilityid = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
		}else{//IN065341 ends
			facilityid= (String) session.getValue("facility_id");
		}//IN065341 starts
		
		
	//IN065341 ends

	/*
		strSql.append("SELECT referral_id, decode(from_ref_type, 'X', am_get_desc.AM_REFERRAL (FROM_REF_CODE, ?,1), sm_get_desc.SM_FACILITY_PARAM  (FROM_FACILITY_ID,?,1)) Ref_source,");
	strSql.append(" am_get_desc.AM_SPECIALITY (FROM_SPECIALITY_CODE,?,2) FROM_SPLTY_DESC,");
	strSql.append(" decode(from_locn_type,'N', ip_get_desc.IP_NURSING_UNIT (FROM_FACILITY_ID,FROM_LOCN_CODE,?,1), op_get_desc.OP_CLINIC (FROM_FACILITY_ID,FROM_LOCN_CODE,?,1)) from_ref_locn_desc,");
	strSql.append(" DECODE(TO_LOCN_TYPE,'N', ip_get_desc.ip_nursing_unit (TO_FACILITY_ID,TO_LOCN_CODE,?,1),op_get_desc.op_clinic (TO_FACILITY_ID, TO_LOCN_CODE, ?, 1)) to_ref_locn_desc,");
	strSql.append(" decode(from_ref_type,'X',FROM_PRACT_NAME, am_get_desc.AM_PRACTITIONER (FROM_PRACT_ID,?,1)) from_ref_pract_name, ");
	strSql.append(" am_get_desc.AM_CONTACT_REASON (REFERRAL_REASON_CODE,?,1) referral_reason, ");
	//strSql.append(" ref_notes, decode(to_ref_type,'X', TO_PRACT_NAME,am_get_desc.AM_PRACTITIONER (TO_PRACT_ID,?,1)) to_ref_pract_name, ");//IN038340
	strSql.append(" ref_notes, decode(to_ref_type,'X', NVL(TO_PRACT_NAME,am_get_desc.AM_EXT_PRACTITIONER (TO_PRACT_ID,?,1)),am_get_desc.AM_PRACTITIONER (TO_PRACT_ID,?,1)) to_ref_pract_name, ");//IN038340
	strSql.append(" am_get_desc.AM_SPECIALITY (TO_SPECIALITY_CODE,?,2) to_speciality_desc,");
	strSql.append(" referral_priority, TO_CHAR(referral_date,'dd/mm/yyyy') referral_date ");
	commented for IN065341*/
	
	strSql.append("SELECT referral_id, decode(from_ref_type, 'X', am_get_desc.AM_REFERRAL ##REPDB##(FROM_REF_CODE, ?,1), sm_get_desc.SM_FACILITY_PARAM ##REPDB## (FROM_FACILITY_ID,?,1)) Ref_source,");
	strSql.append(" am_get_desc.AM_SPECIALITY ##REPDB##(FROM_SPECIALITY_CODE,?,2) FROM_SPLTY_DESC,");
	strSql.append(" decode(from_locn_type,'N', ip_get_desc.IP_NURSING_UNIT ##REPDB##(FROM_FACILITY_ID,FROM_LOCN_CODE,?,1), op_get_desc.OP_CLINIC ##REPDB##(FROM_FACILITY_ID,FROM_LOCN_CODE,?,1)) from_ref_locn_desc,");
	strSql.append(" DECODE(TO_LOCN_TYPE,'N', ip_get_desc.ip_nursing_unit ##REPDB##(TO_FACILITY_ID,TO_LOCN_CODE,?,1),op_get_desc.op_clinic ##REPDB##(TO_FACILITY_ID, TO_LOCN_CODE, ?, 1)) to_ref_locn_desc,");
	strSql.append(" decode(from_ref_type,'X',FROM_PRACT_NAME, am_get_desc.AM_PRACTITIONER ##REPDB##(FROM_PRACT_ID,?,1)) from_ref_pract_name, ");
	strSql.append(" am_get_desc.AM_CONTACT_REASON ##REPDB##(REFERRAL_REASON_CODE,?,1) referral_reason, ");
	//strSql.append(" ref_notes, decode(to_ref_type,'X', TO_PRACT_NAME,am_get_desc.AM_PRACTITIONER ##REPDB##(TO_PRACT_ID,?,1)) to_ref_pract_name, ");//IN038340
	strSql.append(" ref_notes, decode(to_ref_type,'X', NVL(TO_PRACT_NAME,am_get_desc.AM_EXT_PRACTITIONER ##REPDB##(TO_PRACT_ID,?,1)),am_get_desc.AM_PRACTITIONER ##REPDB##(TO_PRACT_ID,?,1)) to_ref_pract_name, ");
	strSql.append(" am_get_desc.AM_SPECIALITY ##REPDB##(TO_SPECIALITY_CODE,?,2) to_speciality_desc,");
	strSql.append(" referral_priority, TO_CHAR(referral_date,'dd/mm/yyyy') referral_date ");

	if (modal_yn.equals("N"))
		//strSql.append(" ,(select count(*) from pr_referral_register a where A.patient_id= pr_referral_register.patient_id) tot_ref ");
		strSql.append(" ,(select count(*) from pr_referral_register##CLOB## a where A.patient_id= pr_referral_register##CLOB##.patient_id) tot_ref ");//IN065341
	
		//strSql.append("FROM pr_referral_register WHERE 	patient_id=? order by referral_date desc ");
		strSql.append("FROM pr_referral_register##CLOB## WHERE 	patient_id=? order by referral_date desc ");//IN065341
	
	
	try
	{
		
	/*String facilityid = (String) session.getValue("facility_id");
	if(facilityid == null) facilityid="";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");commented for IN065341*/

	//String classValue = "";checkstyle
	//int tot_ref = 0;checkstyle
	//StringBuffer displaydata = new StringBuffer();checkstyle
	//java.io.BufferedReader r = null;checkstyle
	//String currentDate="";checkstyle
	//String date ="";checkstyle
	int recCount =0;
	//Clob note = null;checkstyle
		con =ConnectionManager.getConnection(request);
		
	//IN065341 starts	
	if(called_from.equals("CDR")){
		bean.executeCDR(con,patient_id,encounter_id,RepDb,"PR_REFERRAL_REGISTER");
	}
		//pstmt = con.prepareStatement(strSql.toString());
		String result=strSql.toString();
		result=result.replaceAll("##REPDB##",RepDb);
		result=result.replaceAll("##CLOB##",clob_data);
		pstmt = con.prepareStatement(result);
	//IN065341 ends
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,locale);
		pstmt.setString(7,locale);
		pstmt.setString(8,locale);
		pstmt.setString(9,locale);
		pstmt.setString(10,locale);
		pstmt.setString(11,locale);
		pstmt.setString(12,locale);//IN038340
		//pstmt.setString(12,patient_id);//IN038340
		pstmt.setString(13,patient_id);//IN038340

		rs = pstmt.executeQuery();
		//String line = null;checkstyle
		//String strReferralDt = "";checkstyle
		%>
		<table class='grid' width='100%' id='tb1' align='center'>
		<%
			%>
		
			<%if(sStyle.equals(prefStyleSheet) )
			{%>
			<tr id= 'divTitleTable' >
				<!--<th><div class='COLUMNHEADERCENTER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></div></th>
				<th><div class='COLUMNHEADERCENTER'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></div></th>
				<th><div class='COLUMNHEADERCENTER'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></div></th>
				<th><div class='COLUMNHEADERCENTER'><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></div></th>
				<th><div class='COLUMNHEADERCENTER'><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></div></th>-->
				
				<td  class='COLUMNHEADERCENTER' COLSPAN='2'><div nowrap><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></div></td>
			<!--	<td  class='COLUMNHEADERCENTER<%=content_ID%>'><div  nowrap></div></td>-->
				<td  class='COLUMNHEADERCENTER' COLSPAN='2'><div  nowrap><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></div></td>
				<!--<td  class='COLUMNHEADERCENTER<%=content_ID%>'><div nowrap></div></td>-->
				<td  class='COLUMNHEADERCENTER'> <div nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/></div></td>
			</tr>
			
			<%}else{%>
				<tr id= 'divTitleTable' >
				<!--<th><div class='COLUMNHEADERCENTER<%=content_ID%>'><fmt:message key="Common.date.label" bundle="${common_labels}"/></div></th>
				<th><div class='COLUMNHEADERCENTER<%=content_ID%>'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></div></th>
				<th><div class='COLUMNHEADERCENTER<%=content_ID%>'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></div></th>
				<th><div class='COLUMNHEADERCENTER<%=content_ID%>'><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></div></th>
				<th><div class='COLUMNHEADERCENTER<%=content_ID%>'><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></div></th>-->
				
				
				<td  class='COLUMNHEADERCENTER<%=content_ID%>' COLSPAN='2'><div nowrap><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></div></td>
			<!--	<td  class='COLUMNHEADERCENTER<%=content_ID%>'><div  nowrap></div></td>-->
				<td  class='COLUMNHEADERCENTER<%=content_ID%>' COLSPAN='2'><div  nowrap><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></div></td>
				<!--<td  class='COLUMNHEADERCENTER<%=content_ID%>'><div nowrap></div></td>-->
				<td  class='COLUMNHEADERCENTER<%=content_ID%>'> <div nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/></div></td>
			</tr>
			<%}
		while(rs.next())
		{
		recCount++;
		%>
			
			<tr>
				
				<td class='gridData'><%=((rs.getString("FROM_SPLTY_DESC")==null)?"&nbsp;":rs.getString("FROM_SPLTY_DESC"))%></td>
				<td class="gridData"><%=((rs.getString("from_ref_pract_name")==null)?"&nbsp;":"("+rs.getString("from_ref_pract_name")+")")%></td>
				<td class='gridData'><%=((rs.getString("to_speciality_desc")==null)?"&nbsp;":rs.getString("to_speciality_desc"))%></td>
				<td class='gridData'><%=((rs.getString("to_ref_pract_name")==null)?"&nbsp;":"("+rs.getString("to_ref_pract_name")+")")%></td>	
				<td class='gridData'><%=((rs.getString("referral_date")==null)?"&nbsp;":rs.getString("referral_date"))%></td>
			</tr>
			
			
<%
			
			
		}
	
		if(recCount==0)
		out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception:"+e);//COMMON-ICN-0181
		e.printStackTrace();
	}

	finally{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</BODY>
</HTML>

