<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
%>

<html>
<title><fmt:message key="eCA.ViewSpecialtyEventHistory.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCA/js/SpltyHomePage.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	
	Connection con = null;
	PreparedStatement pstmtDt = null;
	ResultSet rsDt = null;

	String high_str = "",low_str="",abn_str="",crit_str="",crit_high_str="",crit_low_str="",delta_fail_str="";
	
//	String disabled ="";
	String disablePrev = " disabled ";
	String disableNext = "";
	String birth="";
	String called_from ="";
	String strFromDate  = "";
	String strToDate = "";
	String strPatientId = "";
	String strHistRecType = "";
	String strEventClass ="";
	String strEventGroup = "";
	String strEventCode  = "";
	String strFacilityId ="";
	String strEncounterId ="";
	String strEpisodeType ="";
	String strNormalcyInd ="";
	String strAbnormal ="";
	String strFlowSheetId ="";
	String strViewConfRes ="";
	String strGraphOrder ="";
	String strErrorEvent ="";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");

	strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");

  if(strGraphOrder.equals("D"))
		strGraphOrder = "desc";
  else if(strGraphOrder.equals("A"))
		strGraphOrder = "asc";

  strViewConfRes	= request.getParameter("viewConfRes")==null?"":request.getParameter("viewConfRes");
  strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
  strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");
  strFlowSheetId	= request.getParameter("cboFlowSheetComp")==null?"":request.getParameter("cboFlowSheetComp");
  strEventCode		= request.getParameter("eventitem")==null?"":request.getParameter("eventitem");
  strErrorEvent		= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
  strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
  strPatientId		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
  strEventGroup		= request.getParameter("p_event_group")==null?"":request.getParameter("p_event_group");
  strEventClass		= request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");
  strHistRecType	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
  called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
  strFacilityId		= request.getParameter("c_facility_id")==null?"":request.getParameter("c_facility_id");
  strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
  strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

 // strFromDate		= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
  //strToDate			= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");

	int nKey = 0;
	try
	{
		con = ConnectionManager.getConnection(request);
	//	pstmtDt = con.prepareStatement("SELECT DISTINCT TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi') trans_date 	FROM CA_SPLTY_DISCR_MSR WHERE patient_id=? AND module_id=? AND cycle_no=? ORDER BY TO_DATE(trans_date,'dd/mm/yyyy hh24:mi') desc");
		
		pstmtDt = con.prepareStatement("Select distinct KEY_REF	From CA_PAT_SPLTY_HIST_REF a WHERE a.PATIENT_ID =? AND a.MODULE_ID  =? AND a.CYLE_NO   =? ORDER BY KEY_REF");
		int nCtr = 0;
		try
		{
			pstmtDt.setString(1,patient_id);
			pstmtDt.setString(2,module_id);
			pstmtDt.setString(3,cycle_no);
			rsDt = pstmtDt.executeQuery();
	
			String strDateRecd = "";
			
			while (rsDt.next())
			{
				strDateRecd = rsDt.getString(1);

				if (nCtr%10 == 0)
				{
					%>
						<script>
						dtArr[<%=nKey%>] = "<%=strDateRecd%>";</script>
					<%

						nKey++;
				}
				nCtr++;
			}

			if(nCtr%10!=0)
			{%>
				<script>dtArr[<%=nKey%>] = "<%=strDateRecd%>";</script>
			<%}
			if(nKey == 0)
			{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//common-icn-0181
		   	ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rsDt != null) rsDt.close();
			if(pstmtDt != null) pstmtDt.close();
		}

		pstmtDt = con.prepareStatement("SELECT HIGH_STR,LOW_STR, ABN_STR,CRIT_STR, CRIT_HIGH_STR, CRIT_LOW_STR, DELTA_FAIL_STR, nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth FROM CR_CLIN_EVENT_PARAM");

		pstmtDt.setString(1,strPatientId);

		rsDt = pstmtDt.executeQuery();
		
		while(rsDt.next())
		{
			high_str		= rsDt.getString("HIGH_STR");
			low_str			= rsDt.getString("LOW_STR");
			abn_str			= rsDt.getString("ABN_STR");
			crit_str		= rsDt.getString("CRIT_STR");
			crit_high_str	= rsDt.getString("CRIT_HIGH_STR");
			crit_low_str	= rsDt.getString("CRIT_LOW_STR");
			delta_fail_str	= rsDt.getString("DELTA_FAIL_STR");
			birth			= rsDt.getString("birth");
		}
		
		if(delta_fail_str == null) delta_fail_str="";
	
		if(rsDt != null) rsDt.close();
		if(pstmtDt != null) pstmtDt.close();

	}
	catch(Exception e)
	{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='controlsForm' id='controlsForm' >
<input type = hidden  name = idx_value		value = <%=nKey%> - 1>
<input type = hidden  name = cur_idx_value	value = "0">
<input type = hidden  name = queryString	value = "<%=request.getQueryString()%>">
<input type = hidden  name = called_from	value =<%=called_from%> >
<input type = hidden  name = strFromDate	value =<%=strFromDate%> >
<input type = hidden  name = strToDate		value =<%=strToDate%> >
<input type = hidden  name = strPatientId	value =<%=strPatientId%> >
<input type = hidden  name = strHistRecType value =<%=strHistRecType%> >
<input type = hidden  name = strEventClass	value =<%=strEventClass%> >
<input type = hidden  name = strEventGroup	value =<%=strEventGroup%> >
<input type = hidden  name = strEventCode	value =<%=strEventCode%> >
<input type = hidden  name = strFacilityId	value =<%=strFacilityId%> >
<input type = hidden  name = strEncounterId value =<%=strEncounterId%> >
<input type = hidden  name = strEpisodeType	value =<%=strEpisodeType%> >
<input type = hidden  name = strNormalcyInd	value =<%=strNormalcyInd%> >
<input type = hidden  name = strAbnormal	value =<%=strAbnormal%> >
<input type = hidden  name = strFlowSheetId value =<%=strFlowSheetId%> >
<input type = hidden  name = strViewConfRes	value =<%=strViewConfRes%> >
<input type = hidden  name = strGraphOrder	value =<%=strGraphOrder%> >
<input type = hidden  name = strErrorEvent	value =<%=strErrorEvent%> >
<TABLE width='100%'>
<TR> 
		<td width="73%" align='left' class='oalabel'><font CLASS='HIGH' size='1' >&nbsp;&nbsp;</font><B><font color='BLACK' size='1'>&nbsp;[<%=high_str%>]</font><font size='1'>-<fmt:message key="Common.High.label" bundle="${common_labels}"/></font>&nbsp;<font CLASS='LOW' size='1' >&nbsp;&nbsp;</font>&nbsp;<font color='BLACK' size='1'>[<%=low_str%>]</font><font size='1'>-<fmt:message key="Common.Low.label" bundle="${common_labels}"/></font>&nbsp;&nbsp;&nbsp;<font CLASS='CRITICALLOW' size='1' >&nbsp;&nbsp;</font>&nbsp;<font color='BLACK' size='1'>[<%=crit_low_str%>]</font><font size='1'>-<fmt:message key="Common.CriticalLowValue.label" bundle="${common_labels}"/></font>&nbsp;<font CLASS='CRITICALHIGH' size='1' >&nbsp;&nbsp;</font>
		<font color='BLACK' size='1'>[<%=crit_high_str%>]</font><font size='1'>-<fmt:message key="Common.CriticalHighValue.label" bundle="${common_labels}"/></font>&nbsp;&nbsp;&nbsp;
		<font CLASS='ABNORMAL' size='1' >&nbsp;&nbsp;</font>&nbsp;<font color='BLACK' size='1'>[<%=abn_str%>]</font><font size='1'>-<fmt:message key="Common.Abnormal.label" bundle="${common_labels}"/></font>&nbsp;<font CLASS='CRITICAL' size='1' >&nbsp;&nbsp;</font>&nbsp;<font color='BLACK' size='1'>[<%=crit_str%>]</font><font size='1'>-<fmt:message key="Common.Critical.label" bundle="${common_labels}"/></font>&nbsp;<!-- <%//if(!delta_fail_str.equals("")){%>&nbsp;&nbsp;<font color='red' size='1'> [<%//=delta_fail_str%>]</font><font size='1'>-Delta Check</font><%//}%> --></B></td>	
	
</TR>
</TABLE>
<table border=0 cellpadding=0 cellspacing=0 width="100%" align='right' id='tablePrevNext' style='display'>
	<tr>
		<td  width='85%'>&nbsp;</td>
		<td align='left' width='5%'><input type='button' id='prev' name='prev' id='prev' value='<' <%=disablePrev%> class='button' onclick='loadPrevNext(this)' align='right'></td>
		<td  align ='center' class = 'QRYEVEN'>
				<input type ='label' class="LABEL" name = 'label_cap'> 
		</td>
		<td align='left' width='5%'><input type='button' id='next' name='next' id='next' value='>' <%=disableNext%> class='button' onclick='loadPrevNext(this)' ></td>
	</tr>
</table>
<script>
function defaultPage()
{
	var idx_value	= document.forms[0].idx_value.value;
	var cur_idx_value = document.forms[0].cur_idx_value.value;

	var fromDateTime ="";
	var toDateTime ="";
	var displend = "";
	var displstart = 1;

	if(idx_value > 0)
	{
		fromDateTime	= dtArr[0];
		toDateTime		= dtArr[1];
		displend = eval(idx_value) ;
		parent.controlsFrame.document.forms[0].cur_idx_value.value = 0;
		parent.controlsFrame.document.forms[0].label_cap.value = displstart + " of " + displend;

		if(idx_value == 1)
		{
			parent.controlsFrame.document.forms[0].next.disabled = true;
			parent.controlsFrame.document.forms[0].prev.disabled = true;

		}
		populateControl();
		
	}
}
defaultPage();
</script>
</form>
</body>
</html>

