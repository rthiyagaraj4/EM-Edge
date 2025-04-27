<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	
//	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"SpecialityStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>

<html>
<title><fmt:message key="eCA.RecMaternityDeleiverView.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCA/html/SpecialityStyle.css' type='text/css'></link> 
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body class='MCCONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<form name = "RecMaternityDeliveryViewForm" >
<%

	//out.println(request.getQueryString());
	java.sql.Connection			con		=	null;
	java.sql.PreparedStatement	pstmt	=	null;
	java.sql.ResultSet			rs		=	null;
	String query_section_details		=	"";
	
	String facility_id       = (String) session.getValue("facility_id");
	String encounter_id						="";	
	String mother_patient_id						="";	
	String cycle_no						="";	
	
	encounter_id	=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	mother_patient_id	=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	cycle_no	=	request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");
	
	
	con = ConnectionManager.getConnection();

	try
	{		
			//query_section_details="SELECT mp_get_desc.MP_NOD_TYPE(DELIVERY_TYPE,?,2) DELIVERY_TYPE, am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,?,1) ATTEND_PRACT_ID, am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,?,1) ATTEND_NURSE_ID,mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,?,2)  PROC_CLASSIFICATION, mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,?,2) DEL_SURG_CLASSIFICATION, mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,?,2) VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_1ST_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = A.COMP_IN_DEL_STAGE1 ) COMP_IN_DEL_STAGE1_DESC, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_2ND_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = A.COMP_IN_DEL_STAGE2) COMP_IN_DEL_STAGE2_DESC, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_3RD_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = A.COMP_IN_DEL_STAGE3) COMP_IN_DEL_STAGE3_DESC, mp_get_desc.MP_COMPLN_DELIVERY(COMP_OF_DELIVERY,?,2) COMP_OF_DELIVERY, mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,?,2) FOETUS_COMP_OF_DELIVERY,to_char(LMP,'dd/mm/yyyy') LMP FROM CA_SPL_DELIVERY_RECORD A WHERE A.FACILITY_ID = ?  AND A.MOTHER_PATIENT_ID = ? AND CYCLE_NO = ?";		

			query_section_details="SELECT mp_get_desc.MP_NOD_TYPE(DELIVERY_TYPE,?,2) DELIVERY_TYPE, am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,?,1) ATTEND_PRACT_ID, am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,?,1) ATTEND_NURSE_ID,mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,?,2)  PROC_CLASSIFICATION, mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,?,2) DEL_SURG_CLASSIFICATION, mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,?,2) VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_1ST_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = A.COMP_IN_DEL_STAGE1 ) COMP_IN_DEL_STAGE1_DESC, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_2ND_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = A.COMP_IN_DEL_STAGE2) COMP_IN_DEL_STAGE2_DESC, (SELECT SHORT_DESC FROM MP_COMPLN_DELIVERY_LANG_VW WHERE LANGUAGE_ID = ? AND COMPLNS_IN_3RD_STAGE_LABOUR_YN = 'Y' AND COMPLN_DELY_TYPE='M' AND COMPLN_DELY_CODE = A.COMP_IN_DEL_STAGE3) COMP_IN_DEL_STAGE3_DESC, mp_get_desc.MP_COMPLN_DELIVERY(COMP_OF_DELIVERY,?,2) COMP_OF_DELIVERY, mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,?,2) FOETUS_COMP_OF_DELIVERY,to_char(LMP,'dd/mm/yyyy') LMP FROM CA_SPL_DELIVERY_RECORD A WHERE A.MOTHER_PATIENT_ID = ? AND CYCLE_NO = ?";		
		
			pstmt		=	con.prepareStatement(query_section_details);
							
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
			//pstmt.setString(12,facility_id);
			//pstmt.setString(13,encounter_id);
			pstmt.setString(12,mother_patient_id);
			pstmt.setString(13,cycle_no);
			
			rs	 =	pstmt.executeQuery();		
	%>		
	<table width='100%' class='MCSUBHEADER'>
		<tr>
			<td align='left' colspan='3'>
				<fmt:message key="eCA.DeliveryRecord.label" bundle="${ca_labels}"/>
			</td>
		</tr>
	</table>
		<table cellspacing="5" cellpadding="0">
	<%	if(rs.next())
			{ 
	%>			<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.DeliveryType.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("DELIVERY_TYPE")==null?"":rs.getString("DELIVERY_TYPE")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("LMP")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("LMP"),"DMY","en",locale)%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("ATTEND_PRACT_ID")==null?"":rs.getString("ATTEND_PRACT_ID")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.AttendingNurse.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("ATTEND_NURSE_ID")==null?"":rs.getString("ATTEND_NURSE_ID")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.ProcedureClassification.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("PROC_CLASSIFICATION")==null?"":rs.getString("PROC_CLASSIFICATION")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.DeliverySurgicalClassification.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("DEL_SURG_CLASSIFICATION")==null?"":rs.getString("DEL_SURG_CLASSIFICATION")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.VaginalDeliveryType.label" bundle="${ca_labels}"/></td>&nbsp;&nbsp;&nbsp;
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("VAGINAL_DELIVERY_TYPE")==null?"":rs.getString("VAGINAL_DELIVERY_TYPE")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.NoofBirth.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("NO_OF_BIRTH")==null?"":rs.getString("NO_OF_BIRTH")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.ComplicationinStage1ofDelivery.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("COMP_IN_DEL_STAGE1_DESC")==null?"":rs.getString("COMP_IN_DEL_STAGE1_DESC")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.ComplicationinStage2ofDelivery.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("COMP_IN_DEL_STAGE2_DESC")==null?"":rs.getString("COMP_IN_DEL_STAGE2_DESC")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.ComplicationinStage3ofDelivery.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("COMP_IN_DEL_STAGE3_DESC")==null?"":rs.getString("COMP_IN_DEL_STAGE3_DESC")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.ComplicationofDelivery.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("COMP_OF_DELIVERY")==null?"":rs.getString("COMP_OF_DELIVERY")%>
						</td>
					</tr>
					<tr>
						<td align="left" width="20%" class="MCLABEL" nowrap>
							<fmt:message key="eCA.FoetusComplicationofDelivery.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left" class="MCDATA">
							<b>:</b>&nbsp;&nbsp;&nbsp;<%=rs.getString("FOETUS_COMP_OF_DELIVERY")==null?"":rs.getString("FOETUS_COMP_OF_DELIVERY")%>
						</td>
					</tr>
				
				
	<%		 }				 
			 if(rs!=null) rs.close();
			 if(pstmt!=null) pstmt.close();  
	%>
			</table>
		
<%	}
	catch(Exception e)
	{
		out.println("Exception @ RecMaternityDeliveryView.jsp"+e.toString());
	}
	finally
	{	
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

