<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList"  %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>

<head>                  
<%! public String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:""; 
	}
%>
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- Added against MMS-QH-CRF-0199-->
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="RecordAnesthesiaPatientDetailsForm" id="RecordAnesthesiaPatientDetailsForm" >
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="1">
	<tr>
		<th  class="columnHeader" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="eOT.SurgeryDate.Label" bundle="${common_labels}"/></th><!-- FD-GHL-CRF-0357 -->
		<th  class="columnHeader" nowrap><fmt:message key="eOT.AnaesthesiaOrderedDate.Label" bundle="${ot_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="Common.speciality.label"  bundle="${common_labels}"/></th>
	</tr>
<%
	String locale = (String)session.getAttribute("LOCALE");	
	String facility_id=request.getParameter("facility_id");
	String patient_id1= checkForNull(request.getParameter("patient_id"));
	String patient_name1= checkForNull(request.getParameter("patient_name"));
	String surgery_date1=checkForNull(request.getParameter("surgery_date"));
	String surgery_date2=checkForNull(request.getParameter("surgery_date2"));//AAKH CRF-0069
	
	String surgeryDate=checkForNull(request.getParameter("surgeryDate")); //FD-GHL-CRF-0357
	String surgeryDate2=checkForNull(request.getParameter("surgeryDate2")); //AAKH CRF-0069	
	
	String surgeon_code1= checkForNull(request.getParameter("surgeon_code"));
	String speciality_code1= checkForNull(request.getParameter("speciality_code"));
	String patient_id="",patient_name="",sex="",surgery_date="",surgeon_code="",surgeon_name="",request_source_type="",source_id="",parent_source_id="",anathestist_code="",patient_class="",episode_id="",encounter_id="",speciality_desc="",order_catalog_desc="",classValue="",anesthesia_srl_no="",proc_module_id="",date_of_birth="";
	String bookingDate = "";
	String patientNameMenu = ""; //IN049942

	Connection connection		= null ;
	PreparedStatement pstmt		= null ;
	ResultSet resultSet			= null ;
	PreparedStatement pstmt1	= null ;
	ResultSet resultSet1		= null ;
	//FD-GHL-CRF-0357 start & 50529/50585
	StringBuffer sql_pending_orders = new StringBuffer();

	sql_pending_orders.append(" SELECT DECODE (b.booking_status,	");
    sql_pending_orders.append("	'9', DECODE ((SELECT contr_sys_id	"); //050585
	sql_pending_orders.append(" FROM or_order o	");
	sql_pending_orders.append(" WHERE o.order_id = a.source_order_id),	");
	sql_pending_orders.append(" 'OT', TO_CHAR (c.order_date_time, 'dd/mm/yyyy'),	");
	sql_pending_orders.append(" TO_CHAR (c.pref_surg_date, 'dd/mm/yyyy')),	");
    sql_pending_orders.append("	NVL (TO_CHAR (b.booking_date, 'dd/mm/yyyy'),	");
    sql_pending_orders.append("	TO_CHAR (c.pref_surg_date, 'dd/mm/yyyy'))) bookingdate,	");
    sql_pending_orders.append(" a.patient_id,	");
	sql_pending_orders.append(" a.patient_name patient_name1, a.sex,	");
	sql_pending_orders.append(" TO_CHAR (a.request_date, 'dd/mm/yyyy') request_date, "); // 050556 start
	sql_pending_orders.append(" NVL (b.team_doctor_code, c.performing_team_surgeon) surgeon_code, ");
	sql_pending_orders.append(" (SELECT d.short_name ");
	sql_pending_orders.append(" FROM am_practitioner_lang_vw d ");
	sql_pending_orders.append(" WHERE d.practitioner_id(+) = NVL (b.team_doctor_code, c.performing_team_surgeon) ");
	sql_pending_orders.append(" AND d.language_id = ?) surgeon_name, ");
	sql_pending_orders.append(" a.status, a.request_source_type, a.order_id,");  // 050556 end
	sql_pending_orders.append(" a.source_order_id, a.anaesthetist_code, a.patient_class, a.episode_id,	");
	sql_pending_orders.append(" a.encounter_id, TO_CHAR (a.date_of_birth, 'DD/MM/YYYY') date_of_birth,	");
	//sql_pending_orders.append(" a.speciality_code, a.speciality_desc, a.order_catalog_desc,	");//Commented  against MMS-QH-CRF-0199
	sql_pending_orders.append(" a.speciality_code, a.speciality_desc,d.long_desc oper_desc,	");//Added  against MMS-QH-CRF-0199
	sql_pending_orders.append(" a.order_catalog_code	");
	//sql_pending_orders.append(" FROM at_pending_orders_vw a, ot_booking_hdr b, ot_pending_order c	");//Commented against MMS-QH-CRF-0199
	sql_pending_orders.append(" FROM at_pending_orders_vw a, ot_booking_hdr b, ot_pending_order c,OT_OPER_MAST_LANG_VW d");//Added  against MMS-QH-CRF-0199
	sql_pending_orders.append(" WHERE a.operating_facility_id = ?	");
	sql_pending_orders.append(" AND a.language_id = ?	");
	sql_pending_orders.append(" AND a.source_order_id = b.order_id(+)	");
	sql_pending_orders.append(" AND a.source_order_id = c.order_id	");
	sql_pending_orders.append(" AND a.ORDER_CATALOG_CODE = d.ORDER_CATALOG_CODE");//Added against MMS-QH-CRF-0199
	sql_pending_orders.append(" AND d.LANGUAGE_ID = ?");//Added against MMS-QH-CRF-0199
	sql_pending_orders.append(" AND NVL (b.booking_num, 'X') = NVL ((SELECT MAX (booking_num)");//50585
	sql_pending_orders.append("	FROM ot_booking_hdr WHERE order_id = a.source_order_id), 'X')");//50585
	if(patient_id1.intern() != "")
		sql_pending_orders.append(" AND a.PATIENT_ID = ? ");
	if(patient_name1.intern() != "")
		sql_pending_orders.append(" AND a.PATIENT_NAME LIKE ? ");
	if(surgeon_code1.intern() != "")
		sql_pending_orders.append(" AND NVL (b.team_doctor_code, c.performing_team_surgeon) = ? 	"); //051169
	if(speciality_code1.intern() != "")
		sql_pending_orders.append(" AND a.SPECIALITY_CODE = ? ");
	if(surgeryDate.intern() != "")
	{
		sql_pending_orders.append(" AND DECODE (b.booking_status, '9', DECODE ((SELECT contr_sys_id  "); //050585
		sql_pending_orders.append(" FROM or_order o  ");
		sql_pending_orders.append(" WHERE o.order_id = a.source_order_id),  ");
		sql_pending_orders.append(" 'OT', c.order_date_time,  ");
		sql_pending_orders.append(" c.pref_surg_date),  ");
		sql_pending_orders.append(" NVL (b.booking_date, c.pref_surg_date))  ");
		sql_pending_orders.append(" BETWEEN TO_DATE (? || ' 00:00', 'dd/mm/yyyy hh24:mi') AND TO_DATE (? || ' 23:59', 'dd/mm/yyyy hh24:mi') ");
	}
	if(surgery_date1.intern() != "")
		sql_pending_orders.append(" AND a.request_date BETWEEN TO_DATE(?||' 00:00','dd/mm/yyyy hh24:mi') AND TO_DATE(?||' 23:59','dd/mm/yyyy hh24:mi') ");

		//AAKH-CRF-0069		
		sql_pending_orders.append("	order by NVL (b.booking_date, c.pref_surg_date) desc,a.request_date,a.patient_id");
//FD-GHL-CRF-0357 end & 50529/50585
	int i=0;
	int index = 0; //FD-GHL-CRF-0357
	try{
			connection = ConnectionManager.getConnection(request);
			//FD-GHL-CRF-0357 start
			pstmt = connection.prepareStatement(sql_pending_orders.toString());
			pstmt.setString(++index, locale);
			pstmt.setString(++index, facility_id);
			pstmt.setString(++index, locale);
			pstmt.setString(++index, locale);//Added against MMS-QH-CRF-0199
			if(patient_id1.intern() != "")
				pstmt.setString(++index, patient_id1);
			if(patient_name1.intern() != "")
				pstmt.setString(++index, patient_name1);
			if(surgeon_code1.intern() != "")
				pstmt.setString(++index, surgeon_code1);
			if(speciality_code1.intern() != "")
				pstmt.setString(++index, speciality_code1);
				//AAKH CRF-0069 START
			if(surgeryDate.intern() != "")
			{
				pstmt.setString(++index, surgeryDate);
			
				if(surgeryDate2.intern() != ""){
					pstmt.setString(++index, surgeryDate2);
				}
				else
				{
				pstmt.setString(++index, "31/12/9999");
				}
			}
			if(surgery_date1.intern() != "")
			{
				pstmt.setString(++index, surgery_date1);
				if(surgery_date2.intern() != ""){
					pstmt.setString(++index, surgery_date2);
				}
				else
				{
				pstmt.setString(++index, "31/12/9999");
				}
			}
			//AAKH CRF-0069 END
			//FD-GHL-CRF-0357 end
/*
			if(pstmt_params.size()>0)
			{
				int size = pstmt_params.size();
				for(int j=0;j<size;j++){
					pstmt.setString(j+1,""+pstmt_params.get(j));
				}
			}
*/
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				i++;
				patient_id = checkForNull(resultSet.getString("PATIENT_ID"));
				patient_name = checkForNull(resultSet.getString("PATIENT_NAME1"));
				sex = checkForNull(resultSet.getString("SEX"));
				surgery_date = com.ehis.util.DateUtils.convertDate(resultSet.getString("REQUEST_DATE"),"DMY","en",locale);
				surgeon_code = checkForNull(resultSet.getString("SURGEON_CODE"));
				surgeon_name = checkForNull(resultSet.getString("SURGEON_NAME"));
				request_source_type = checkForNull(resultSet.getString("REQUEST_SOURCE_TYPE"));
				source_id = checkForNull(resultSet.getString("ORDER_ID"));
				parent_source_id = checkForNull(resultSet.getString("SOURCE_ORDER_ID"));
				anathestist_code = checkForNull(resultSet.getString("ANAESTHETIST_CODE"));
				patient_class = checkForNull(resultSet.getString("PATIENT_CLASS"));
				episode_id = checkForNull(resultSet.getString("EPISODE_ID"));
				encounter_id = checkForNull(resultSet.getString("ENCOUNTER_ID"));
				date_of_birth = com.ehis.util.DateUtils.convertDate(resultSet.getString("DATE_OF_BIRTH"),"DMY","en",locale);
				speciality_desc = checkForNull(resultSet.getString("SPECIALITY_DESC"));
				//order_catalog_desc = checkForNull(resultSet.getString("ORDER_CATALOG_DESC"));//Commented Against MMS-QH-CRF-0199
				order_catalog_desc = checkForNull(resultSet.getString("oper_desc"));//Commented Against MMS-QH-CRF-0199
				bookingDate = checkForNull(resultSet.getString("bookingDate")); //FD-GHL-CRF-0357

		classValue = (i%2==0)?"gridData":"gridData"; 
		// By DIlip
		ResultSet rs=null;
		String sql="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1         FROM MP_PATIENT  WHERE PATIENT_ID =? "; //Changed against 50529/50585
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);
			rs=pstmt.executeQuery();
			if(rs.next())
			patient_name=checkForNull(rs.getString("SHORT_NAME1"));
			rs.close();
			pstmt.close();
	  // End by Dilip
	  	patientNameMenu = patient_name.replace("'",""); //IN049942
%>
	<tr>
		<td width='10%' nowrap id='orderctl<%=i%>' style='cursor:pointer' class='gridDataBlue'  onClick="displayToolTipPendingOrders('<%=facility_id%>','<%=patient_id%>','<%=patientNameMenu%>','<%=sex%>','<%=anesthesia_srl_no%>','<%=proc_module_id%>','<%=request_source_type%>','<%=source_id%>','<%=parent_source_id%>','<%=anathestist_code%>','<%=patient_class%>','<%=episode_id%>','<%=encounter_id%>','<%=surgeon_code%>','<%=surgeon_name%>','<%=date_of_birth%>',this,'imgArrow<%=i%>');"width='9%'  onMouseOver='hideToolTip();'><%=patient_id%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'></td> <!-- IN049942 -->
		<td class='<%=classValue%>' width='18%' nowrap><%=patient_name%></td>
		<td class='<%=classValue%>' width='3%' ><%=sex%></td>
		<!-- Modified against MMS-QH-CRF-0199 -->
		<td class='<%=classValue%>' width='12%' nowrap><img src='../../eOT/images/drugInfo.gif'   OnMouseOver="Tip(reasonToolTip('<%=parent_source_id%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)"  onMouseOut='UnTip();' nowrap>
			<%=order_catalog_desc%></font>
		</td>
		<td class='<%=classValue%>' width='8%' nowrap><%=bookingDate%></td>
		<td class='<%=classValue%>' width='8%' nowrap><%=surgery_date%></td>
		<td class='<%=classValue%>' width='10%' nowrap><%=surgeon_name%></td>
		<td class='<%=classValue%>' width='10%' nowrap><%=speciality_desc%></td>
	</tr>
<%
	}
	if(i==0)
		out.println("<script>callNoRecord();</script>");
	}catch ( Exception e ){
			  e.printStackTrace() ;
	}finally {
				if(resultSet!=null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(resultSet1!=null) resultSet1.close();
				if(pstmt1!=null) pstmt1.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
	}
%>
</table>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>	
	</div>
</form>
</body>
</html>

