<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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

if(function_from.equals("CP"))
{
	textReadOnly = " readOnly ";
	imageDisabled = " disabled ";
}
else
{
	textReadOnly = "";
	imageDisabled = "";
}

String chartRef= request.getParameter("chartRef")==null?"":request.getParameter("chartRef");
String chtId = request.getParameter("Chart_Id")==null?"":request.getParameter("Chart_Id");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
String facility_id = session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
String sysdate = "";
String encounterId = request.getParameter("encounter_id")==null ? "0" : request.getParameter("encounter_id");
String module_id = request.getParameter("module_id")==null ? "" : request.getParameter("module_id");


if(encounterId.equals("")) encounterId = "0";

String fromDateForExt = "";
String toDateForExt = "";
String displayMandatory = " style = display:none";

if(encounterId.equals("0"))
	displayMandatory = " style = display:inline";
else
	displayMandatory = " style = display:none";

%>
<html>
<head>
	<%

	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
		<select name=chart_id onchange="loadChart(this)" >
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
			String relnId = (String)	session.getValue("relationship_id")==null ? "" :(String)	session.getValue("relationship_id") ;
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
				e.printStackTrace(System.err);
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
				sql.append("select a.CHART_ID,A.SHORT_DESC   from ca_chart_LANG_VW a where a.eff_status='E'   and language_id = ? and ");
	
				if(encounterId.equals("0"))
					sql.append(" a.CONFIG_TYPE = 'N' and ");
		
				    sql.append(" EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id)  AND  EXISTS (select 1 from ca_chart_applicablity	 where       (PATIENT_CLASS='*A' or PATIENT_CLASS=?)  AND (SPECIALITY_CODE='*ALL' or SPECIALITY_CODE=NVL((SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?),'*ALL') ) and (PRACT_TYPE='*A' or PRACT_TYPE=?) AND (LOCN_TYPE_IND='*' OR LOCN_TYPE_IND=?) and (LOCN_CODE='*ALL' OR LOCN_CODE=?) AND (AGE_GROUP_CODE='*ALL'  OR  EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN               DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX))  AND CHART_ID =A.CHART_ID)  "); 

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

				//System.out.println("sql...."+sql.toString());
				int index=0;
				pstmt = con.prepareStatement(sql.toString());
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
				out.println(e.toString());
			}
			finally
			{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
			}
%>
	</select>
<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
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
	<input  type='text' size='14'  name=rec_time value="<%=systime%>" OnBlur='CheckDateTime(this)' OnKeyPress="return CheckForNumsAndColon(event)" maxlength='16' <%=textReadOnly%>>
	<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('rec_time')" <%=imageDisabled%>>
	<img align=center src='../../eCommon/images/mandatory.gif'></img>
</td>
</tr>
<tr>
<td colspan='3'  width='100%' class='label'>
<input type='button' class='button' name='buttonAddItem' id='buttonAddItem'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ModifyScope.label","ca_labels")%>' OnClick='loadPanels()' style='visibility:hidden'>
<input type='button' class='button' name='buttonShowRec' id='buttonShowRec'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PastRecords.label","ca_labels")%>' OnClick='openWiinForRecording()' style='display:none'>
</td>
</tr>
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
<td  colspan='2' class='label'  width='100%'>
<fmt:message key="Common.view.label" bundle="${common_labels}"/>
<fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp;<input type='checkbox' name='detailYN' id='detailYN'  OnClick='filterToSummary()' checked></td>
<td class=label width='25%'>
<label class='label' id='labelSummary'><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></label>&nbsp<input type='checkbox' name='summaryYN' id='summaryYN'  OnClick='filterToSummary()' checked></td>
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
<input type='textbox' id='fromDate' name='fromDate' id='fromDate' value='<%=fromDateForExt%>' size='14' maxlength='16' onblur="CheckDateTime(this)"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDate')"></img>-<input type='textbox' id='toDate' name='toDate' id='toDate' value='<%=toDateForExt%>' size='14' maxlength='16' onblur="CheckDateTime(this);ValidateDateTimeOfPeriod(document.getElementById("fromDate"),document.getElementById("toDate"),'DMYHM')"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDate')"></img><img <%=displayMandatory%> id = 'forExtPat' align=center src='../../eCommon/images/mandatory.gif'></img>

</td>
</tr>
<tr>
<td   width='25%' class='label'>
<label id='labelScope' class='label'><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></label></td>
<td class='fields' width='25%'><input type=hidden name='past_scope' id='past_scope' value=''>
<input type='text' name='summaryText' id='summaryText' size='4' maxlength='2' OnKeyPress='return allowValidNumber(this, event,2,0)' value='1' Onchange='' OnBlur="resetValuesForCriteria(this,past_scope);checkSequence(this);"><label id='labelScope' class='label'><fmt:message key="Common.days.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
</tr>
<tr><td class='label' width='25%' ></td><td width='25%' align='right'colspan=2>
<input type='button' name='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class=button onclick="SearchChart('jsp')"><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")
%>' class=button onclick="resetCriteria();">
</td>
</tr>
</table>
</td>
</tr>
</table>
<table border="0" cellpadding="3" cellspacing="0"  id='tableId1' width="100%">
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
</table>

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
<input type=hidden name='modifyYN' id='modifyYN' value='<%=modifyYN%>'>
<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>

<script>
if('<%=modifyYN%>' == 'Y')
	alignHeightWidth();
</script>
</form>
</body>
</html>

