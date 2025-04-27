<!DOCTYPE html>
<!--
	Developed by 	:	Smita Unnikrishnan
	Created on 	:	12/05/2004
	Module		:	Out Patient Management
	Function	:	This file is used for displaying results for the criteria search for Patient movement records.
-->
	 <%@ page import="java.sql.*, java.util.*, java.text.*,java.net.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
	 <%	request.setCharacterEncoding("UTF-8");	%>
	 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	 
<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eOP/js/ArrivedDeparted.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	<%

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Connection con=null;	
	%>
	<body OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'>
	<%

try {
	String facilityid=(String)session.getValue("facility_id");
	String locale=(String)session.getAttribute("LOCALE"); 
	String Pageval=request.getParameter("Pageval");
	if(Pageval == null) Pageval="A";
	String objname=request.getParameter("callfrom");
	if(objname == null) objname="";
	String patientid=request.getParameter("patientid");
	if(patientid==null) patientid="";
	String encounterid=request.getParameter("encounterid");
	if(encounterid == null) encounterid="";
	String patientclass=request.getParameter("patientclass");
	if(patientclass==null) patientclass="";
		
	String locntype=request.getParameter("locntype");
	if(locntype == null) locntype="";
	String locntypedesc=request.getParameter("");
	if(locntypedesc == null) locntypedesc="";
	
	String locncode =request.getParameter("locncode");
	if(locncode==null) locncode="";
	String locndesc=request.getParameter("");
	if(locndesc==null) locndesc="";
	
	String encounterdatetime=request.getParameter("encounterdate");
	if(encounterdatetime==null) encounterdatetime="";
	
	String allencounters=request.getParameter("allencounters");
	if(allencounters==null) allencounters="";
	
	String orderby=request.getParameter("orderby");
	if(orderby == null) orderby="";
	
	StringBuffer sql1=new StringBuffer();
	String locn_type="";
	String locn_type_desc="";
	String locn="";
	String locn_desc="";
	String pat_id="";
	String pat_name="";
	String enc_id="";
	String enc_dt_time="";
	String enc_dt_time_display="";
	String pat_trn_time="";
	String enc_type="";
	String enc_type_desc="";

	String enc_locn_type="";
	String enc_locn_code="";
	String reason_desc="";
    String classValue=""; 
	String current_locn_type="";
	String current_locn="";
	
	int i=0;
	int cnt=0;
 
    con=ConnectionManager.getConnection(request);
	%>
	<form name="ArrivedDepartedResult_form" id="ArrivedDepartedResult_form" >

	<% 

	sql1.append("SELECT a.patient_id patient_id , decode('"+locale+"', 'en', c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) patient_name ,a.encounter_id encounter_id , a.patient_class encounter_type , TO_CHAR(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date_time  , TO_CHAR(a.pat_trn_time,'dd/mm/yyyy hh24:mi') pat_trn_time , a.pat_curr_locn_type pat_curr_locn_type,  b.to_locn_type  pat_curr_locn_type_desc ,b.to_locn_type current_locn_type,b.to_locn_code current_locn,a.pat_curr_locn_code , DECODE(b.to_locn_type,'W', get_desc ('"+locale+"', 'rd_clinic_lang_vw', 'SHORT_DESC', 'CLINIC_CODE', b.to_locn_code),'O', get_desc ('"+locale+"', 'ot_oper_room_lang_vw', 'SHORT_DESC', 'OPER_ROOM_CODE', b.to_locn_code),'N',IP_GET_DESC.IP_NURSING_UNIT(b.facility_id,b.to_locn_code,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(b.facility_id,b.to_locn_code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(b.facility_id,b.to_locn_code,'"+locale+"','1')) pat_curr_locn_desc  ,DECODE(a.movement_reason_code,NULL,'',AM_GET_DESC.am_contact_reason(a.movement_reason_code,'"+locale+"','1')) reason_desc  ,a.ASSIGN_CARE_LOCN_TYPE ASSIGN_CARE_LOCN_TYPE ,a.ASSIGN_CARE_LOCN_CODE ASSIGN_CARE_LOCN_CODE FROM  pr_encounter a , pr_patient_movement b , mp_patient c WHERE a.facility_id='"+facilityid+"' AND a.facility_id = b.facility_id AND a.encounter_id=b.encounter_id ");

	//sql1.append("FROM  pr_encounter a , pr_patient_movement b , mp_patient c  ");	
	
	//sql1.append(" WHERE a.facility_id='"+facilityid+"' AND a.facility_id = b.facility_id AND a.encounter_id=b.encounter_id ");	 
	
	if(Pageval.equals("A")) {
		sql1.append(" and (b.movement_type='D') ");
	} else if(Pageval.equals("D")) {
		sql1.append(" and b.movement_type='A' ");
	}

	if((allencounters.equals("N") && Pageval.equals("A")) || Pageval.equals("D")) {
		sql1.append("and b.to_locn_code='"+locncode+"' and b.to_locn_type='"+locntype+"'");
	}

	if(!patientid.equals("")) {
		sql1.append(" and a.patient_id='"+patientid+"'");
	}

	if(!encounterid.equals("")) {
		sql1.append(" and a.encounter_id='"+encounterid+"'");
	}

	if(!encounterdatetime.equals("")) {
		sql1.append(" and trunc(a.visit_adm_date_time)=nvl(to_date('"+encounterdatetime+"','dd/mm/yyyy'),trunc(sysdate))");
	}
 	if(!patientclass.equals("")) {
		sql1.append(" and a.patient_class='"+patientclass+"'");
	   if(patientclass.equals("OP")) {
         sql1.append("and (a.visit_status >'01' and a.visit_status < '07')");
       } else if(patientclass.equals("EM")) {
	        sql1.append("and a.visit_status < '07' ");
       } else if(patientclass.equals("IP") || patientclass.equals("DC")) {
	        sql1.append("and a.adt_status < '08' ");
	   }
	} else {
		 sql1.append(" and (( a.patient_class = 'OP' and a.visit_status in ('02','03','04','05','06')) Or ( a.patient_class = 'EM' and a.visit_status < '07') OR (( a.patient_class in ('IP','DC') and a.ADT_STATUS  < '08')))");
	}
	
	sql1.append(" and  a.patient_id=c.patient_id and b.srl_no =(SELECT MAX(to_number(SRL_NO)) FROM PR_PATIENT_MOVEMENT d WHERE A.PATIENT_ID = d.PATIENT_ID AND  a.encounter_id=d.encounter_id and  "); 
	sql1.append(" d.FACILITY_ID ='"+facilityid+"') ");

	if(!orderby.equals(""))	{
		if(orderby.equals("T"))	{
			sql1.append(" order by a.patient_class");
		}
		else if(orderby.equals("D")) {
			sql1.append(" order by a.visit_adm_date_time");
		}
	}
		
		
		if(Pageval.equals("A"))
			{
			 
			pstmt=con.prepareStatement(sql1.toString());			
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				if( cnt==0 )
				{
				%>
				 <table cellpadding=0 cellspacing=0 border=0 width='100%' align='center'>
					<tr>
					<td>
					<table cellpadding=0 cellspacing=0 width='100%' border='1' align='center'>
						<th class='columnheader' nowrap><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></th>
						<th class='columnheader' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
						<th class='columnheader' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
						<th class='columnheader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
						<th class='columnheader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>	
						<th class='columnheader' nowrap><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/></th>
						<th class='columnheader' nowrap><fmt:message key="eOP.ReasonForMovement.label" bundle="${op_labels}"/></th>				
					<%
					}
					
						if ( i % 2 == 0 )
					        classValue = "QRYEVEN" ;
					    else
				            classValue = "QRYODD" ;

						locn_type=rs.getString("pat_curr_locn_type");
						if(locn_type == null) locn_type="";
						
						locn_type_desc=rs.getString("pat_curr_locn_type_desc");

						if(locn_type_desc.equals("N")) {						
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
						}else if(locn_type_desc.equals("C")){					
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
						}else if(locn_type_desc.equals("E")) {
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
						}else if(locn_type_desc.equals("Y")){			
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
						}else if(locn_type_desc.equals("R")){			
							locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(locn_type_desc.equals("W")){			
							locn_type_desc=
								com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels");
						}else if(locn_type_desc.equals("O")){					
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.OTSpecific.label","op_labels");
						}

						if(locn_type_desc == null)
							locn_type_desc="";

						pat_id=rs.getString("patient_id");
							if(pat_id == null) pat_id = "";
						pat_name=rs.getString("patient_name");
						if(pat_name == null) pat_name="";
						
						enc_id=rs.getString("encounter_id");
						if(enc_id == null) enc_id="";
						enc_type=rs.getString("encounter_type");
						if(enc_type== null) enc_type="";
						current_locn_type = rs.getString("current_locn_type")==null?"":rs.getString("current_locn_type");
						current_locn = rs.getString("current_locn")==null?"":rs.getString("current_locn");

						if(enc_type.equals("IP"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
						else if(enc_type.equals("OP"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
						else if(enc_type.equals("EM"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
						else if(enc_type.equals("DC"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

						enc_dt_time=rs.getString("encounter_date_time");
							if(enc_dt_time == null) enc_dt_time = "";

						enc_dt_time_display=DateUtils.convertDate(enc_dt_time,"DMYHM","en",locale);

						locn=rs.getString("pat_curr_locn_code");
						if(locn == null) locn="";

						locn_desc=rs.getString("pat_curr_locn_desc");						
						if(locn_desc == null) 
							locn_desc="";
						pat_trn_time=rs.getString("pat_trn_time");
						if(pat_trn_time == null) pat_trn_time="";

						enc_locn_type=rs.getString("ASSIGN_CARE_LOCN_TYPE");
						if(enc_locn_type == null) enc_locn_type="";
						enc_locn_code=rs.getString("ASSIGN_CARE_LOCN_CODE");
						if(enc_locn_code == null) enc_locn_code="";

						reason_desc=rs.getString("reason_desc");
						if(reason_desc == null) reason_desc="&nbsp;";
					%>
					<tr>
						<td class='<%=classValue%>' width='15%'><%=enc_dt_time_display%>
						</td>
							<td class='<%=classValue%>' width='15%'><%=enc_type_desc%></td>
					<%
						if(!sStyle.equals("IeStyle.css"))
						{
						%>	
						
					<td class='<%=classValue%>' width='10%' onMouseOver='style.cursor="hand";' onClick="ShowModal('A','<%=Pageval%>','<%=pat_id%>','<%=locn_type%>','<%=locn_type_desc%>','<%=locn%>','<%=java.net.URLEncoder.encode(locn_desc)%>','<%=current_locn%>','<%=locndesc%>','<%=current_locn_type%>','<%=locntypedesc%>','<%=enc_id%>','<%=enc_dt_time%>','<%=enc_type%>','<%=pat_trn_time%>','<%=enc_locn_type%>','<%=enc_locn_code%>');" ><a><FONT SIZE="2" COLOR="BLUE"><%=enc_id%></FONT><!-- Wednesday, March 24, 2010  20215 venkat S --></a></td>
						<%}else{%>
						<td class='<%=classValue%>' width='10%' onMouseOver='style.cursor="hand";' onClick="ShowModal('A','<%=Pageval%>','<%=pat_id%>','<%=locn_type%>','<%=locn_type_desc%>','<%=locn%>','<%=locn_desc%>','<%=current_locn%>','<%=locndesc%>','<%=current_locn_type%>','<%=locntypedesc%>','<%=enc_id%>','<%=enc_dt_time%>','<%=enc_type%>','<%=pat_trn_time%>','<%=enc_locn_type%>','<%=enc_locn_code%>');" ><FONT SIZE="2" COLOR="BLUE"><%=enc_id%></FONT></td>
						<%}%>
							<td class='<%=classValue%>' width='15%'><%=pat_id%></td>
							<td class='<%=classValue%>' width='15%'><%=pat_name%></td>
							<%
					if(locn_type.equals(""))
						{%>
							<td class='<%=classValue%>' width='15%'>&nbsp;</td>
						<%
						}
						else
						{%>
						<!--Below line was added by venkatesh.s on 16-Nov-2012 against SS-CRF-010 -->
						<%if(locn_type_desc.equals("Room")){%>
						<td width='15%' class='<%=classValue%>' ><%=locn_type_desc%>/<%=current_locn%> <%=locn_desc%></td>
						<%}else{%>
						<td width='15%' class='<%=classValue%>' ><%=locn_type_desc%>/<%=locn_desc%></td>
						<%}%>
	  				   <%}%>
					<td width='15%' class='<%=classValue%>' nowrap><%=reason_desc%></td>
					</tr>
					<%
					i++;
					cnt++;
				}
				if( cnt == 0) {																					        out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			%>		
			</table>
			</td>
		</tr>
	</table>
	<%	
	}
	else if(Pageval.equals("D"))
	{		
		 
		pstmt=con.prepareStatement(sql1.toString());
		rs=pstmt.executeQuery();

		while(rs.next())
		{
			if( cnt==0 )
			{
			%>
				<table cellpadding=0 cellspacing=0 border=0 width='100%' align='center'>
					<tr>
						<td>
							<table cellpadding=0 cellspacing=0 width='100%' border='1' align='center'>
								<th class='columnheader' nowrap><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></th>
								<th class='columnheader' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
								<th class='columnheader' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
								<th class='columnheader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
								<th class='columnheader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<%
			}

						if ( i % 2 == 0 )
					        classValue = "QRYEVEN" ;
					    else
				            classValue = "QRYODD" ;
						
						pat_id=rs.getString("patient_id");
						if(pat_id == null) pat_id = "";
						pat_name=rs.getString("patient_name");
						if(pat_name == null) pat_name="";
						
						enc_id=rs.getString("encounter_id");
						if(enc_id == null) enc_id="";
						enc_type=rs.getString("encounter_type");
						if(enc_type== null) enc_type="";
						
						if(enc_type.equals("IP"))
							enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
						else if(enc_type.equals("OP"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
						else if(enc_type.equals("EM"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
						else if(enc_type.equals("DC"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");							 
						enc_dt_time=rs.getString("encounter_date_time");
							if(enc_dt_time == null) enc_dt_time = "";
						enc_dt_time_display=DateUtils.convertDate(enc_dt_time,"DMYHM","en",locale);				
							pat_trn_time=rs.getString("pat_trn_time");
						if(pat_trn_time == null) pat_trn_time="";
						enc_locn_type=rs.getString("ASSIGN_CARE_LOCN_TYPE");
						if(enc_locn_type == null) enc_locn_type="";
						enc_locn_code=rs.getString("ASSIGN_CARE_LOCN_CODE");
						if(enc_locn_code == null) enc_locn_code="";
					%>
						<tr>
						<td class='<%=classValue%>' width='25%' ><%=enc_dt_time_display%>
						</td>
						<td class='<%=classValue%>' width='17%'><%=enc_type_desc%></td>
						<%
						if(!sStyle.equals("IeStyle.css"))
						{
						%>	
					<td class='<%=classValue%>' width='13%'  onMouseOver='style.cursor="pointer";' onClick="ShowModal('D','<%=Pageval%>','<%=pat_id%>','<%=locn_type%>','<%=locn_type_desc%>','<%=locn%>','<%=java.net.URLEncoder.encode(locn_desc)%>','<%=locncode%>','<%=locndesc%>','<%=locntype%>','<%=locntypedesc%>','<%=enc_id%>','<%=enc_dt_time%>','<%=enc_type%>','<%=pat_trn_time%>','<%=enc_locn_type%>','<%=enc_locn_code%>');"><a><FONT SIZE="2" COLOR="BLUE"><%=enc_id%></FONT><!-- Wednesday, March 24, 2010  20215 venkat S --></a></td>
					<%}else{%>
						<td class='<%=classValue%>' width='13%'  onMouseOver='style.cursor="pointer";' onClick="ShowModal('D','<%=Pageval%>','<%=pat_id%>','<%=locn_type%>','<%=locn_type_desc%>','<%=locn%>','<%=java.net.URLEncoder.encode(locn_desc)%>','<%=locncode%>','<%=locndesc%>','<%=locntype%>','<%=locntypedesc%>','<%=enc_id%>','<%=enc_dt_time%>','<%=enc_type%>','<%=pat_trn_time%>','<%=enc_locn_type%>','<%=enc_locn_code%>');"><FONT SIZE="2" COLOR="BLUE"><%=enc_id%></FONT></td>
					<%}%>
						<td width='20%' class='<%=classValue%>' ><%=pat_id%></td>
						<td width='25%' class='<%=classValue%>' ><%=pat_name%></td>
					</tr>
						<%
						i++;
						cnt++;
				}
				if( cnt == 0 )
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");			
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			%>
					</table>
				</td>
			</tr>
		</table>
		<%
		}%>
	</form>
	<%
   sql1.setLength(0);

 }catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{
		if(con != null )
			 ConnectionManager.returnConnection(con,request);
	}
	%>
</body>
</html>

