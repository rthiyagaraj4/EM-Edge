<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
30/12/2012		IN035950		Nijitha			Patient Chart Summary Changes.
20/02/2013 	 	IN037950		Nijitha			CRF-CA- CHL-CRF-0015/01- Referral Summary Widget->Referral Notes containing special characters cannot be viewed
-------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------
24/05/2018		IN065341	Prakash C	25/05/2018		Ramesh G		ML-MMOH-CRF-0115
-------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//IN035950 Starts
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
//String content_ID = request.getParameter("content_ID"); checkstyle
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
//IN035950 Ends
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<table border='1' width='100%' id='dataTable' class='grid' align='center'>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	String referral_priority="";
	ResultSet rs = null;
	//IN065341 starts
		String bean_id = "ca_CentralizedBean" ;
		String bean_name = "eCA.CentralizedBean";
		CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		java.util.Properties p = (java.util.Properties) session.getValue("jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
		String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
		
		String encounter_id="";
		String facilityid     =  "";
		
		if(called_from.equals("CDR")){
			encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
			facilityid=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
		}else{
			encounter_id = request.getParameter("encounter_id");//IN035924
			facilityid     =  (String)session.getValue("facility_id");
		}	
	//IN065341 ends
	StringBuffer strSql = new StringBuffer();
	String modal_yn=request.getParameter("modal_yn");
			if (modal_yn==null) modal_yn="N";
 
	//java.util.Properties p = (java.util.Properties) session.getValue("jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");commented for IN065341

	//strSql.append("select referral_id ,decode(from_ref_type,'X',from_ref_desc,from_facility_name) Ref_source,FROM_SPLTY_DESC,nvl(decode(from_ref_type,'X',from_ref_locn_desc,decode(from_locn_type,'C',from_clinic_desc,from_nurs_unit_desc)),'&nbsp;') from_ref_locn_desc,decode(from_ref_type,'X',from_ref_pract_name,from_fcy_pract_name)from_ref_pract_name,nvl(referral_reason,'&nbsp;') referral_reason,ref_notes,decode(to_ref_type,'X',to_ref_pract_name,to_fcy_pract_name) to_ref_pract_name, to_speciality_desc,decode(referral_priority,'E','Emergency','R','Referral for Admission','U','Semi Emergency','L','Elective')referral_priority, to_char(referral_date,'dd/mm/yyyy') referral_date ");
/*
	strSql.append("select referral_id ,decode(from_ref_type,'X',from_ref_desc,from_facility_name) Ref_source,FROM_SPLTY_DESC,nvl(decode(from_ref_type,'X',from_ref_locn_desc,decode(from_locn_type,'C',from_clinic_desc,from_nurs_unit_desc)),'&nbsp;') from_ref_locn_desc,decode(from_ref_type,'X',from_ref_pract_name,from_fcy_pract_name)from_ref_pract_name,nvl(referral_reason,'&nbsp;') referral_reason,ref_notes,decode(to_ref_type,'X',to_ref_pract_name,to_fcy_pract_name) to_ref_pract_name, to_speciality_desc,referral_priority, to_char(referral_date,'dd/mm/yyyy') referral_date ");
	strSql.append("SELECT referral_id, decode(from_ref_type, 'X', am_get_desc.AM_REFERRAL (FROM_REF_CODE, ?,1), sm_get_desc.SM_FACILITY_PARAM (FROM_FACILITY_ID,?,1)) Ref_source,");
	strSql.append(" am_get_desc.AM_SPECIALITY (FROM_SPECIALITY_CODE,?,2) FROM_SPLTY_DESC,");
	strSql.append(" decode(from_locn_type,'N', ip_get_desc.IP_NURSING_UNIT (FROM_FACILITY_ID,FROM_LOCN_CODE,?,1), op_get_desc.OP_CLINIC (FROM_FACILITY_ID,FROM_LOCN_CODE,?,1)) from_ref_locn_desc,");
	strSql.append(" decode(from_ref_type,'X',FROM_PRACT_NAME, am_get_desc.AM_PRACTITIONER (FROM_PRACT_ID,?,1)) from_ref_pract_name, ");
	strSql.append(" am_get_desc.AM_CONTACT_REASON (REFERRAL_REASON_CODE,?,1) referral_reason, ");
	strSql.append(" ref_notes, decode(to_ref_type,'X', TO_PRACT_NAME,am_get_desc.AM_PRACTITIONER (TO_PRACT_ID,?,1)) to_ref_pract_name, ");
	strSql.append(" am_get_desc.AM_SPECIALITY (TO_SPECIALITY_CODE,?,2) to_speciality_desc,");
	strSql.append(" referral_priority, TO_CHAR(referral_date,'dd/mm/yyyy') referral_date ");
*/

	strSql.append("SELECT referral_id, decode(from_ref_type, 'X', am_get_desc.AM_REFERRAL ##REPDB##(FROM_REF_CODE, ?,1), sm_get_desc.SM_FACILITY_PARAM ##REPDB##(FROM_FACILITY_ID,?,1)) Ref_source,");
	strSql.append(" am_get_desc.AM_SPECIALITY ##REPDB##(FROM_SPECIALITY_CODE,?,2) FROM_SPLTY_DESC,");
	strSql.append(" decode(from_locn_type,'N', ip_get_desc.IP_NURSING_UNIT ##REPDB##(FROM_FACILITY_ID,FROM_LOCN_CODE,?,1), op_get_desc.OP_CLINIC ##REPDB##(FROM_FACILITY_ID,FROM_LOCN_CODE,?,1)) from_ref_locn_desc,");
	strSql.append(" decode(from_ref_type,'X',FROM_PRACT_NAME, am_get_desc.AM_PRACTITIONER ##REPDB##(FROM_PRACT_ID,?,1)) from_ref_pract_name, ");
	strSql.append(" am_get_desc.AM_CONTACT_REASON ##REPDB##(REFERRAL_REASON_CODE,?,1) referral_reason, ");
	strSql.append(" ref_notes, decode(to_ref_type,'X', TO_PRACT_NAME,am_get_desc.AM_PRACTITIONER ##REPDB##(TO_PRACT_ID,?,1)) to_ref_pract_name, ");
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
	//IN065341 starst
	con = ConnectionManager.getConnection(request);
	if(called_from.equals("CDR")){
		bean.executeCDR(con,patient_id,encounter_id,RepDb,"PR_REFERRAL_REGISTER");
	}
	//IN065341 ends		
	String called_from_widget=request.getParameter("called_from_widget")==null?"":request.getParameter("called_from_widget");//IN035928
	String classValue = "";
	int tot_ref = 0;
	StringBuffer displaydata = new StringBuffer();
	java.io.BufferedReader r = null;
	Clob note = null;
	int counter = 0;
		//con =ConnectionManager.getConnection(request);IN065341
	
	//IN065341 starts	
		//pstmt = con.prepareStatement(strSql.toString());
		String result=strSql.toString();
		result=result.replaceAll("##CLOB##",clob_data);
		result=result.replaceAll("##REPDB##",RepDb);
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
		pstmt.setString(10,patient_id);

		rs = pstmt.executeQuery();
		String line = null;
		String strReferralDt = "";
		while(rs.next())
		{
			displaydata = new StringBuffer();
			if (modal_yn.equals("N"))
				tot_ref = rs.getInt("tot_ref");
			note=rs.getClob("REF_NOTES");
			if(note!=null)
			{
				r = new java.io.BufferedReader(note.getCharacterStream());
				line = null;
				while((line=r.readLine()) != null) 
					//displaydata.append(displaydata+line+"~");
					displaydata.append(line+"~");
			}
			if(counter%2 == 0)
			{
				classValue = "QRYEVEN";
			}
			else
			{
				classValue = "QRYODD";			
			}

			referral_priority=((rs.getString("referral_priority")==null)?"&nbsp;":rs.getString("referral_priority"));
			strReferralDt = ((rs.getString("referral_date")==null)?"&nbsp;":rs.getString("referral_date"));
			String displaydata_encode = URLEncoder.encode(displaydata.toString(),"UTF-8");//IN037950

			if(!strReferralDt.equals("&nbsp;") )
				strReferralDt = com.ehis.util.DateUtils.convertDate(strReferralDt,"DMY","en",locale);

				if(referral_priority.equals("E"))
					referral_priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");

				if(referral_priority.equals("R"))
					referral_priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Referral for Admission.label","ca_labels");

				if(referral_priority.equals("U"))
					referral_priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels");

				if(referral_priority.equals("L"))
					referral_priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels");
			if(tot_ref > 1){
				%>
					<tr>
					<td class='gridData'><a class='gridLink' href='javascript:;' onClick='showAllChartSummaryReferralInfo("<%=patient_id%>","<%=title%>","<%=called_from%>","<%=clob_data%>","<%=RepDb%>")'><b><fmt:message key="eCA.ViewAll.label" bundle="${ca_labels}"/></b></a></td>
					</tr>
				<%
			}	
			%>
			<tr>
			<td colspan = 2 class='gridData'><b><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></b></td>
			</tr>

			<tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.source.label" bundle="${common_labels}"/></td>
			<td class='gridData'><b><%=((rs.getString("Ref_source")==null)?"&nbsp;":rs.getString("Ref_source"))%></b></td>
			</tr>
			<tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='gridData'><b><%=((rs.getString("FROM_SPLTY_DESC")==null)?"&nbsp;":rs.getString("FROM_SPLTY_DESC"))%></b></td>
			</tr>
			<tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='gridData'><b><%=((rs.getString("from_ref_locn_desc")==null)?"&nbsp;":rs.getString("from_ref_locn_desc"))%></b></td>
			</tr>
			<tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class="gridData"><b><%=((rs.getString("from_ref_pract_name")==null)?"&nbsp;":rs.getString("from_ref_pract_name"))%></b></td>
			</tr>
			<tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.notes.label" bundle="${common_labels}"/></td>
			<!--<td class='gridData'><a><input type='image' src='../../eCA/images/flow_text.gif' onClick="ref_notes('<%=displaydata%>')"></a></td>IN037950-->
			<td class='gridData'><a><input type='image' src='../../eCA/images/flow_text.gif' onClick="ref_notes('<%=displaydata_encode%>')"></a></td><!--IN037950-->
			</tr>
			</tr>
			<tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td class='gridData'><b><%=strReferralDt%></b></td>
			</tr>
			<tr>
			
			<td colspan = 2 class='gridData'><b><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></b></td>
			</tr>
			<tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='gridData'><b><%=((rs.getString("to_ref_pract_name")==null)?"&nbsp;":rs.getString("to_ref_pract_name"))%></b></td>
			</tr><tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='gridData'><b><%=((rs.getString("to_speciality_desc")==null)?"&nbsp;":rs.getString("to_speciality_desc"))%></b></td>
			</tr>
			<tr>
			<td class='gridData'>&nbsp;&nbsp;<fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='gridData'><b><%=referral_priority %></b></td>
			</tr>
			<tr>
			
			<!--<td colspan='2' class='gridData'>&nbsp;&nbsp;<a class='gridLink' href='javascript:;' onClick='return viewReferral("<%=((rs.getString("referral_id")==null)?"":rs.getString("referral_id"))%>,")'><fmt:message key="Common.details.label" bundle="${common_labels}"/>...</a></td>IN065341-->
			<td colspan='2' class='gridData'>&nbsp;&nbsp;<a class='gridLink' href='javascript:;' onClick='return viewReferral("<%=((rs.getString("referral_id")==null)?"":rs.getString("referral_id"))%>","<%=RepDb%>","<%=called_from%>","<%=clob_data%>","<%=facilityid%>","<%=patient_id%>","<%=encounter_id%>")'><fmt:message key="Common.details.label" bundle="${common_labels}"/>...</a></td>
			</tr>
<%
			counter++;
			//if(tot_ref >= 1)//IN035928
			if(tot_ref >= 1 && !"REFFERAL_SUMMARY".equals(called_from_widget))//IN035928
			{
				break;
			}
		}
		if(counter == 0)
		{
			//out.println("<tr><td class='label'>getMessage('ENCTR_NOT_REF','CA')</td></tr>");
//			out.println("<script>alert(getMessage('ENCTR_NOT_REF','CA'));</script>");
			//IN035950  Starts
			out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
			//IN035950  Ends
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception:"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</BODY>
</HTML>

