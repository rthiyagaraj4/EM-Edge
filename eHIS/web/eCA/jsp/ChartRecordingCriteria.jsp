<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
11/05/2015		IN054842		Vijayakumar K		11/05/2015		Dinesh T		ML-BRU-SCF-1586 [IN:054842
23/11/2017		IN061897		Raja S				23/11/2017		Ramesh G		ML-MMOH-CRF-0549
21/01/2019      IN067541        Sivabagyam M       21/01/2019       Ramesh G        ML-MMOH-CRF-1159
12/06/2020		IN073152		Durga Natarajan		12/06/2020		Ramesh G  		SKR-SCF-1332
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String function_from= request.getParameter("function_from") == null ? "" : request.getParameter("function_from");
String modifyYN= request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");

String textReadOnly = "";
String imageDisabled = "";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
//IN054842 starts
/*if(function_from.equals("CP")) //ML-BRU-SCF-1586 starts
{
	textReadOnly = " readOnly ";
	imageDisabled = " disabled ";
}
else
{
	textReadOnly = "";
	imageDisabled = "";
}*/ //ML-BRU-SCF-1586 ends
//IN054842 ends

String chartRef= request.getParameter("chartRef")==null?"":request.getParameter("chartRef");
String chtId = request.getParameter("Chart_Id")==null?"":request.getParameter("Chart_Id");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String adm_date = request.getParameter("visit_adm_date1")==null?"":request.getParameter("visit_adm_date1");//IN073152
String facility_id = session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
String sysdate = "";
String encounterId = request.getParameter("encounter_id")==null ? "0" : request.getParameter("encounter_id");
String module_id = request.getParameter("module_id")==null ? "" : request.getParameter("module_id");
//String scope = request.getParameter("scope")==null ? "" : request.getParameter("scope");
String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN061897
String clientIpAddress = "";//IN061897
clientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");//IN061897
String defaultflag = "";//IN061897
String admDtChk = "";
if(!adm_date.equals(""))
	admDtChk = "Y";
else
	admDtChk = "N";

if(encounterId.equals("")) encounterId = "0";

String fromDateForExt = "";
String toDateForExt = "";
String displayMandatory = " style = display:none";

if(encounterId.equals("0"))
	displayMandatory = " style = display";
else
	displayMandatory = " style = display:none";

%>
<html>
<head>
	<%

	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 27/11/2009  */
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" OnLoad='defaultValue()'>
<form name ="ChartLayoutCriteriaForm"  >
<table border="0" cellpadding="3" cellspacing="0"  width="100%"  >
<tr><td colspan='2'  width='43%'>
<table border="0" cellpadding="3" cellspacing="0" id='tbId' width="100%" valign='bottom'>
<tr><td width='25%' class='label' ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/>
</td><td width='25%' class='fields'  nowrap >
		<select name='chart_id' id='chart_id' onchange="loadChart(this);" >
			<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
<%
			Connection con = null;
			PreparedStatement pstmt =null;
			ResultSet rs= null;
			String systime ="";
			String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
			String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
			String Sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
			String pract_type =(String) session.getValue("practitioner_type")==null ? "" : (String) session.getValue("practitioner_type");
			String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
			String respId = (String)	session.getValue("responsibility_id")==null ? "" :(String)	session.getValue("responsibility_id") ;
			//String relnId = (String)session.getValue("relationship_id")==null ? "" :(String)	session.getValue("relationship_id") ;
			String relnId = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id") ;
			String sqlAuth = "";
			String errorAuth = "";
			try
			{
				con = ConnectionManager.getConnection(request);
			try
			{
				PreparedStatement pstmtAuth = null;
				ResultSet resAuth = null;
				sqlAuth = "SELECT GET_TASK_APPLICABILITY('MARK_CHART_ERROR',NULL,?,?,?,?,?), 'Y' ERR_EXIST   FROM DUAL";

				
				pstmtAuth = con.prepareStatement(sqlAuth);
				pstmtAuth.setString(1,respId);
				pstmtAuth.setString(2,relnId);
				pstmtAuth.setString(3,facility_id);
				pstmtAuth.setString(4,encounterId);
				pstmtAuth.setString(5,patient_id);

				resAuth = pstmtAuth.executeQuery();
	
				if (resAuth.next())
					errorAuth =resAuth.getString(1);
				
				if(pstmtAuth != null) pstmtAuth.close();
				if(resAuth != null) resAuth.close();
			}
			catch(Exception e)
			{
				//out.println("Exception in try-Auth of ChartRecordingCriteria.jsp ="+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}

			String location_type="";

			if ((patient_class.equals("OP")) ||(patient_class.equals("EM")))
			   location_type="C";
			else
			   location_type="N";
			StringBuffer sql = new StringBuffer();
		/*	sql.append("select a.CHART_ID,a.SHORT_DESC   from ca_chart a where a.eff_status='E'   and ");
			if(encounterId.equals("0"))
			{
				sql.append(" a.CONFIG_TYPE = 'N' and ");
			}			
			sql.append(" EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id)  AND  EXISTS (select 1 from ca_chart_applicablity	 where       (PATIENT_CLASS='*A' or PATIENT_CLASS=?)  AND (SPECIALITY_CODE='*ALL' or SPECIALITY_CODE=NVL((SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?),'*ALL') ) and (PRACT_TYPE='*A' or PRACT_TYPE=?) AND (LOCN_TYPE_IND='*' OR LOCN_TYPE_IND=?) and (LOCN_CODE='*ALL' OR LOCN_CODE=?) AND (AGE_GROUP_CODE='*ALL'  OR  EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN               DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX))  AND CHART_ID =A.CHART_ID)  "); 

			//try
			//{
				String chart_Default="";
			
				if(!chartRef.equals(""))
				{ 
					 sql.append("  and  chart_id  in (select chart_id from ca_custom_chart  where CUST_CHART_REF=? )  ");
					chart_Default=" selected ";
				}
				if(!chtId.equals(""))
				{ 
					 sql.append("  and  chart_id =?  ");
					chart_Default=" selected ";
				}
				
				sql.append(" ORDER BY 2");
			*/
				//sql.append("select a.CHART_ID,A.SHORT_DESC  from ca_chart_LANG_VW a where a.eff_status='E'   and language_id = ? and ");//Commented for IN061897
				sql.append("select a.CHART_ID,A.SHORT_DESC,(SELECT 'Y' FROM CA_PRAC_DEFAULT_CHART WHERE PRACTITIONER_ID = ? AND FACILITY_ID = ? AND CHART_ID = a.CHART_ID) DEFAULT_FLAG  from ca_chart_LANG_VW a where a.eff_status='E'   and language_id = ? and ");//Modified for IN061897
				if(encounterId.equals("0"))

					sql.append(" a.CONFIG_TYPE = 'N' and ");

					/*Modified by Maheshwaran.K for the Issue No:27796 as on 05/07/2011*/
					/*Decode function is modified w.r.t New Born Baby*/
					/*sql.append(" EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id)  AND  EXISTS (select 1 from ca_chart_applicablity	 where       (PATIENT_CLASS='*A' or PATIENT_CLASS=?)  AND (SPECIALITY_CODE='*ALL' or SPECIALITY_CODE=NVL((SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?),'*ALL') ) and (PRACT_TYPE='*A' or PRACT_TYPE=?) AND (LOCN_TYPE_IND='*' OR LOCN_TYPE_IND=?) and (LOCN_CODE='*ALL' OR LOCN_CODE=?) AND (AGE_GROUP_CODE='*ALL'  OR  EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN  DECODE(IA.AGE_UNIT,'H', CASE WHEN (TRUNC(SYSDATE)-IB.DATE_OF_BIRTH)=0 THEN 0*IA.MIN_AGE ELSE IA.MIN_AGE END ,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE) and DECODE(IA.AGE_UNIT,'H',IA.MAX_AGE,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX))  AND CHART_ID =A.CHART_ID)  "); */
					/*sql.append(" EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id)  AND  EXISTS (select 1 from ca_chart_applicablity	 where       (PATIENT_CLASS='*A' or PATIENT_CLASS=?)  AND (SPECIALITY_CODE='*ALL' or SPECIALITY_CODE=NVL((SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?),'*ALL') ) and (PRACT_TYPE='*A' or PRACT_TYPE=?) AND (LOCN_TYPE_IND='*' OR LOCN_TYPE_IND=?) and (LOCN_CODE='*ALL' OR LOCN_CODE=?) AND (AGE_GROUP_CODE='*ALL'  OR  EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN  DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE) and DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX))  AND CHART_ID =A.CHART_ID)  "); */
					sql.append(" EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id)  AND  EXISTS (select 1 from ca_chart_applicablity	 where       (PATIENT_CLASS='*A' or PATIENT_CLASS=?)  AND (SPECIALITY_CODE='*ALL' or SPECIALITY_CODE=NVL((SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?),'*ALL') ) and (PRACT_TYPE='*A' or PRACT_TYPE=?) AND (LOCN_TYPE_IND='*' OR LOCN_TYPE_IND=?) and (LOCN_CODE='*ALL' OR LOCN_CODE=?) AND (AGE_GROUP_CODE='*ALL'  OR  EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-TRUNC(IB.DATE_OF_BIRTH) BETWEEN  DECODE(IA.AGE_UNIT,'H', CASE WHEN (TRUNC(SYSDATE)-TRUNC(IB.DATE_OF_BIRTH))=0 THEN 0*IA.MIN_AGE WHEN ((TRUNC(SYSDATE)-TRUNC(IB.DATE_OF_BIRTH))*24) between IA.MIN_AGE and IA.MAX_AGE   THEN IA.MIN_AGE	END ,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE) and DECODE(IA.AGE_UNIT,'H',IA.MAX_AGE,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX))  AND CHART_ID =A.CHART_ID)  ");
				String chart_Default="";
			
				if(!chartRef.equals(""))
				{ 
					 sql.append("  and  chart_id  in (select chart_id from ca_custom_chart  where CUST_CHART_REF=? )  ");
					 chart_Default=" selected ";
				}
				if(!chtId.equals(""))
				{ 
					 sql.append("  and  chart_id =?  ");
					 chart_Default=" selected ";
				}

			     sql.append(" ORDER BY 2");
				int index=0;
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(++index,clinician_id);//IN061897
				pstmt.setString(++index,facilityId);//IN061897
				pstmt.setString(++index,locale);
				pstmt.setString(++index,patient_class);
				pstmt.setString(++index,facilityId);
				pstmt.setString(++index,encounterId);
				pstmt.setString(++index,pract_type);
				pstmt.setString(++index,location_type);
				pstmt.setString(++index,location_code);
				pstmt.setString(++index,patient_id);
				if(!chartRef.equals(""))
				{ 
					pstmt.setString(++index,chartRef);
				}
				if(!chtId.equals(""))
				{ 
					pstmt.setString(++index,chtId);
				} 
				rs = pstmt.executeQuery();
				String chartId = "";
				String chartDesc = "";
				while(rs.next())
				{
					chartId = rs.getString(1);
					chartDesc = rs.getString(2);
					//IN061897 changes starts
					defaultflag = rs.getString(3) ==null ? "N" : rs.getString(3) ;
					if(defaultflag.equals("Y")){
						chart_Default=" selected ";
					}
					else{
						defaultflag="N";
						chart_Default="";
					}
					//IN061897 changes ends
					
					%>
					<option value="<%=chartId%>" <%=chart_Default%> ><%=chartDesc%> </option>
					<%
				
				}

				/*if(!rs.next())
				{
					out.println("<script>alert('no discrete measures for this chart');</script>");
					out.println("<script>if(top.content == null) window.close();</script>");					
				}*/

				if (pstmt!=null) pstmt.close();
				if( rs!=null) rs.close();

				if(function_from.equals("") || modifyYN.equals("N") || (function_from.equals("CP") && module_id.equals("OR")))
				{
					systime		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					sysdate		=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
				
					if(encounterId.equals("0"))
					{
						fromDateForExt = sysdate + " 00:00";
						toDateForExt = sysdate + " 23:59";
					}
					else if(!encounterId.equals("0"))
					{
						fromDateForExt = "";
						toDateForExt = "";
					}
				}
				else
				{
					systime = 	request.getParameter("p_start_date_time")==null ? "" : request.getParameter("p_start_date_time");
					if (systime.equals(""))
					{
							systime		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					}
				/*	else 
					{
							systime	=	com.ehis.util.DateUtils.convertDate(systime,"DMYHM","en",locale);
					} */
				}
			}
			catch(Exception e)
			{
				//out.println(e.toString());//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
			}
%>
	</select>
	<img align=center src='../../eCommon/images/mandatory.gif'></img>
	<img align=center title='Add to Default Chart' onclick="addChartToDefault()" src='../../eCA/images/FavChart.png'></img></td> <!--IN061897-->
</tr>
<%
	if(modifyYN.equals("Y"))
	{
%>
<tr>
<td width='25%' class='label' nowrap>
<fmt:message key="Common.datetime.label" bundle="${common_labels}"/>
</td>
<td  width='25%' class='fields' colspan='2'>
	<input  type='text' size='14'  id=rec_time name=rec_time value="<%=systime%>" OnBlur='CheckDateTime(this,"<%=admDtChk%>")' OnKeyPress="return CheckForNumsAndColon(event)" maxlength='16' <%=textReadOnly%>>
	<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('rec_time')" <%=imageDisabled%>>
	<img align=center src='../../eCommon/images/mandatory.gif'></img>
</td>
</tr>
<!--<tr>
<td colspan='3'  width='100%' class='label'>
<input type='button' class='button' name='buttonAddItem' id='buttonAddItem'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ModifyScope.label","ca_labels")%>' OnClick='loadPanels()' style='visibility:hidden'>
<input type='button' class='button' name='buttonShowRec' id='buttonShowRec'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PastRecords.label","ca_labels")%>' OnClick='openWiinForRecording()' style='display:none'>
</td> 
</tr> -->
<tr><td colspan=1></td></tr>
<tr><td colspan=1></td></tr>
</table>
</td>
<td colspan='2' width='57%'>
<table border="0" cellpadding="3" cellspacing="0" id='tableId2' width="100%" >
<!-- <tr>
<td colspan='3' class='label' align='left'>
<B>Previous Recording</B>
</td>
</tr>
 -->
<%
	}
%>
 <tr>
<td  colspan='2' class='label'  width='25%'>
<fmt:message key="Common.view.label" bundle="${common_labels}"/>
<fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp;<input type='checkbox' name='detailYN' id='detailYN'  OnClick='filterToSummary()' checked></td>
<td class=label width='25%' id='labelSummary'>
<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>&nbsp<input type='checkbox' name='summaryYN' id='summaryYN'  OnClick='filterToSummary()' checked></td>
</tr>
<tr>
<td class=label width='25%'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/>
</td>
<td width='25%' class='fields' colspan=2>
	<select name='sort_by_asc_desc' id='sort_by_asc_desc' onchange='valForSort(this)'>
		<option value = 'D'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
		<option value = 'A'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
	</select>
<!-- Grand Summary&nbsp;<input type='checkbox' name='grandsummaryYN' id='grandsummaryYN'  OnClick='' checked style='display:none'> -->
</td>
</tr>
<tr>
<td  class='label' width='25%'>
<fmt:message key="Common.Period.label" bundle="${common_labels}"/>
</td><td width='25%' class='fields' colspan=2>
<input type='textbox' id='fromDate' name='fromDate' id='fromDate' value='<%=fromDateForExt%>' size='14' maxlength='16' onblur="ValidateDateTimeOfPeriod(this,toDate)"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDate')"></img>-<input type='textbox' id='toDate' name='toDate' id='toDate' value='<%=toDateForExt%>' size='14' maxlength='16' onblur="ValidateDateTimeOfPeriod(fromDate,this)"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDate')"></img><img <%=displayMandatory%> id = 'forExtPat' align=center src='../../eCommon/images/mandatory.gif'></img>

</td>
</tr>
<!-- <tr>
<td   width='25%' class='label'>
<label id='labelScope' class='label'><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></label></td>
<td class='fields' width='25%' style='display:none'><input type=hidden name='past_scope' id='past_scope' value=''>
<input type='text' name='summaryText' id='summaryText' size='4' maxlength='2' OnKeyPress='return allowValidNumber(this, event,2,0)' value='1' Onchange='' OnBlur="resetValuesForCriteria(this,past_scope);checkSequence(this);"><label id='labelScope' class='label'><fmt:message key="Common.days.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
</tr> -->
<tr><td class='label' width='25%' ></td><td width='25%' align='right'colspan=2>
<!-- <input type='button' class='button' name='buttonAddItem' id='buttonAddItem'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ModifyScope.label","ca_labels")%>' OnClick='loadPanels()' style='visibility:hidden'>IN067541-->
<input type='button' class='button' name='buttonAddItem' id='buttonAddItem'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SelectCategory.label","ca_labels")%>' OnClick='loadPanels()' style='visibility:hidden'><!-- IN067541 -->
<input type='button' class='button' name='buttonShowRec' id='buttonShowRec'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PastRecords.label","ca_labels")%>' OnClick='openWiinForRecording()' style='display:none'>
<input type='button' name='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class=button onclick="SearchChart('jsp')">
<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")
%>' class=button onclick="resetCriteria();">
</td>
</tr>
</table>
</td>
</tr>
</table>
<!--<table border="0" cellpadding="3" cellspacing="0"  id='tableId1' width="100%">
<tr>
<td colspan='3'  id ='tdIdForClassCriteria'  align='right' width='100%' class='label'>
<label id='label' style='display:none'></label>
 <input type='button' class='button' name='buttonFirst' id='buttonFirst'  value='<<' OnClick='getRecords(this)' style='visibility:hidden'> 


<input type='button' class='button' name='buttonPrev' id='buttonPrev'  value='<' OnClick='getRecords(this)' style='visibility:hidden'>


<label id='dayView' style='display:none'></label>
<a href='javascript:' OnClick='getDay()'  title='Click here for other Day Record'><img src='../../eCommon/images/CommonCalendar.gif' id='imgDate' border='0' style='display:none'></img>
</a>

<input type='button' class='button' name='buttonNext' id='buttonNext'  value='>' OnClick='getRecords(this)' style='visibility:hidden'>
 <input type='button' class='button' name='buttonLast' id='buttonLast'  value='>>' OnClick='getRecords(this)' style='visibility:hidden'>

</td>
</tr>
</table> -->
<!-- added by kishore kumar n on 27/11/2009  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
<script language=javascript>
 /*var date = new Date();
 var hr = date.getHours(); if ( hr >=0 && hr <=9 ) hr='0'+hr ;
  var min = date.getMinutes(); if ( min >=0 && min <=9) min='0'+min ;

 var currdatetime = date.getDate()+'/'+((date.getMonth())+1)+'/'+date.getYear()+' '+hr+':'+min;
document.forms[0].rec_time.value = 	currdatetime
*/
setTimeout("loadChart();",500);
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<input type=hidden name=qs value='<%=request.getQueryString()%>'>
<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounterId%>'>
<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type=hidden name='Sex' id='Sex' value='<%=Sex%>'>
<input type=hidden name='adm_date' id='adm_date' value='<%=adm_date%>'>
<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type=hidden name='detailDate' id='detailDate' value='<%=sysdate%>'>
<input type=hidden name='sysdate' id='sysdate' value='<%=sysdate%>'>
<input type=hidden name='systime' id='systime' value='<%=systime%>'>
<input type=hidden name='toDateForExt' id='toDateForExt' value='<%=toDateForExt%>'>
<input type=hidden name='fromDateForExt' id='fromDateForExt' value='<%=fromDateForExt%>'>
<input type=hidden name='fromDateExcludingTime' id='fromDateExcludingTime' value=''>
<input type=hidden name='detailSelectHidden' id='detailSelectHidden' value=''>
<input type=hidden name='start' id='start' value=''>
<input type=hidden name='end' id='end' value=''>

<input type=hidden name='toolTipForLast' id='toolTipForLast' value=''>
<input type=hidden name='toolTipForFirst' id='toolTipForFirst' value=''>
<input type=hidden name='toolTipForNext' id='toolTipForNext' value=''>
<input type=hidden name='toolTipForPrev' id='toolTipForPrev' value=''>

<input type=hidden name='maxRecord' id='maxRecord' value=''>
<input type=hidden name='sortValue' id='sortValue' value='D'>
<input type=hidden name='errorAuth' id='errorAuth' value='<%=errorAuth%>'>
<input type=hidden name='flagStringValue' id='flagStringValue' value=''>
<input type=hidden name='function_from' id='function_from' value='<%=function_from%>'>
<input type=hidden name='detDate' id='detDate' value='<%=request.getParameter("p_start_date_time")%>'>
<input type=hidden name='locale' id='locale' value='<%=locale%>'>

<input type=hidden name='splChartType' id='splChartType' value=''>
<input type=hidden name='DEFINE_MODIFIABLE_AT_TRN_YN' id='DEFINE_MODIFIABLE_AT_TRN_YN' value=''>
<!-- <input type=hidden name='scope' id='scope' value=''> -->
<input type=hidden name='modifyYN' id='modifyYN' value='<%=modifyYN%>'>
<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>
<input type=hidden name='clinician_id' id='clinician_id' value='<%=clinician_id%>'><!--IN061897-->
<input type=hidden name='clientIpAddress' id='clientIpAddress' value='<%=clientIpAddress%>'><!--IN061897-->

<script>
if('<%=modifyYN%>' == 'Y')
	alignHeightWidth();
</script>
</form>
</body>
</html>

