<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name				Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           											created
-------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
<STYLE>
	td.errorEvents
	{
		background-color: BROWN;
		border-style: dashed;
	}
	FONT.DELTAFAIL{
		background-color:#FFE4E1;
	}
	.ColorTab
	{
		width:55px;
		font-family: Verdana;
		font-size: 7pt;
		color: #000000;
		font-weight:normal;
		text-align:left;
		padding-right:5px;
		vertical-align:middle;
	}
</STYLE>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/FlowSheet.js'></script>
<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>


</HEAD>
<%		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtDt = null;

		ResultSet rsDt = null;
		ResultSet rs = null;

	String low_value_color ="";
    String high_value_color ="";
	String abnml_value_color ="";
	String crtcl_value_color ="";
	String crtcl_low_value_color ="";
	String crtcl_high_value_color ="";
	String high_value_desc ="";
	String low_value_desc ="";
	String abnml_value_desc	= "";
	String crtcl_value_desc	= "";
	String crtcl_low_value_desc	= "";
	String crtcl_high_value_desc	= "";
	String delta_fail_str = "";
	String disabled ="";
	String disablePrev = " disabled ";
	String disableNext = "";
	String birth="";
	String called_from ="";
	String enc_called_from ="";
	String strFromDate  = "";
	String strToDate = "";
	String strPatientId = "";
	String strHistRecType = "";
	String strEventClass ="";
	String strEventGroup = "";
	String strEventCode  = "";
	String strFacilityId ="";
	String strEncounterId ="";
	String strEncId ="";
	String strEpisodeType ="";
	String strNormalcyInd ="";
	String strAbnormal ="";
	String strFlowSheetId ="";
	String strViewConfRes ="";
	String strGraphOrder ="";
	String strErrorEvent ="";
	String legend_type = "";
	HashMap mapDescColor = new HashMap();
	ArrayList listDesc = new ArrayList();

	StringBuffer sbQryCriteria = new StringBuffer();
	StringBuffer	strBuffDates	= new StringBuffer();

	String emailDisp = "style='display'";
	String defPrevStatus = "";
	String defPrevStatusForPrint = "";
	String printDisp = "style='display'";
	String enctr_id = "";
	String fac_id="";
	String resp_id = (String)session.getValue("responsibility_id");

	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); 

	int nKey = 0;
	int nIndex =1;

  strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");
  strNormalcyInd	= request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
System.out.println("strNormalcyInd"+strNormalcyInd);

  if(strGraphOrder.equals("D"))
		strGraphOrder = "desc";
  else if(strGraphOrder.equals("A"))
		strGraphOrder = "asc";

  strViewConfRes	= request.getParameter("viewConfRes")==null?"":request.getParameter("viewConfRes");
  strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
  strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");	strFlowSheetId	= request.getParameter("cboFlowSheetComp")==null?"":request.getParameter("cboFlowSheetComp");
  strEventCode		= request.getParameter("eventitem")==null?"":request.getParameter("eventitem");
  strErrorEvent		= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
  strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
  strPatientId		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
  strEventGroup		= request.getParameter("p_event_group")==null?"":request.getParameter("p_event_group");
  strEventClass		= request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");
  strHistRecType	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
  called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
  enc_called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");
  strFacilityId		= request.getParameter("c_facility_id")==null?"":request.getParameter("c_facility_id");
  strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
  strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
  //IN035950 Starts
  String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");
String p_hist_type		= request.getParameter("p_hist_type")==null?"":request.getParameter("p_hist_type");
String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]
String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T"); //Added for IN066218
if("CA_RESULTS_WIDGET".equals(called_from_widget))
strHistRecType=p_hist_type;

  strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");

  if(strEncId.equals("")) strEncId = "0";

  strFromDate		= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
  strToDate			= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");

String clinician_id			= (String) session.getValue("ca_practitioner_id");


	try
	{
		con = ConnectionManager.getConnection(request);
		/*
		pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'EMAIL_DATA' ");
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatus = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//IN057797 starts
		//pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'PRINT_CLIN_DATA' ");
		pstmt = con.prepareStatement("select GET_TASK_APPLICABILITY('PRINT_CLIN_DATA',NULL,?,NULL) DFLT_PRIVILEGE_STATUS from dual");
		pstmt.setString(1,resp_id);
		//IN057797 ends
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatusForPrint = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
*/
		if(called_from.equals("OR"))
		{
			pstmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
			rs = pstmt.executeQuery();

			if(rs.next())
			{
				legend_type = rs.getString("LEGEND_TYPE") == null ? "S" : rs.getString("LEGEND_TYPE");
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
/*
		if(defPrevStatus.equals("A")) emailDisp = "style='display'";
		else emailDisp = "style='display:none'";

		if(defPrevStatusForPrint.equals("A")) printDisp = "style='display'";
		else printDisp = "style='display:none'";


		int nCtr = 0;
*/
		
		%>

<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="button_form" id="button_form">
		<%
		pstmt = con.prepareStatement("SELECT high_str_desc,high_color_code,HIGH_SYMBOL_ICON,low_str_desc,low_color_code,LOW_SYMBOL_ICON,abn_str_desc,abn_color_code,ABN_SYMBOL_ICON,crit_str_desc,crit_color_code,CRIT_SYMBOL_ICON,crit_high_str_desc,crit_high_color_code,CRIT_HIGH_SYMBOL_ICON,crit_low_str_desc,crit_low_color_code,CRIT_LOW_SYMBOL_ICON,DELTA_FAIL_STR,nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth FROM CR_CLIN_EVENT_PARAM");

		pstmt.setString(1,strPatientId);

		rs = pstmt.executeQuery();
		
		if(rs.next())			
		{
			high_value_desc = rs.getString("high_str_desc") == null ? "" : rs.getString("high_str_desc");
			
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				high_value_color = rs.getString("HIGH_SYMBOL_ICON") == null ? "" : rs.getString("HIGH_SYMBOL_ICON");
			else
				high_value_color = rs.getString("high_color_code") == null ? "" : rs.getString("high_color_code");
		   
			mapDescColor.put(high_value_desc,high_value_color);
		    listDesc.add(high_value_desc);

		    low_value_desc = rs.getString("low_str_desc") == null ? "" : rs.getString("low_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				low_value_color = rs.getString("LOW_SYMBOL_ICON") == null ? "" : rs.getString("LOW_SYMBOL_ICON");
			else
				low_value_color = rs.getString("low_color_code") == null ? "" : rs.getString("low_color_code");
			if(!(mapDescColor.containsKey(low_value_desc)))
			{
				mapDescColor.put(low_value_desc,low_value_color);
				listDesc.add(low_value_desc);
			}

		    abnml_value_desc = rs.getString("abn_str_desc") == null ? "" : rs.getString("abn_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				abnml_value_color = rs.getString("ABN_SYMBOL_ICON") == null ? "" : rs.getString("ABN_SYMBOL_ICON");
			else
				abnml_value_color = rs.getString("abn_color_code") == null ? "" : rs.getString("abn_color_code");
			if(!(mapDescColor.containsKey(abnml_value_desc)))
			{
				mapDescColor.put(abnml_value_desc,abnml_value_color);
				listDesc.add(abnml_value_desc);
			}

		    crtcl_value_desc = rs.getString("crit_str_desc") == null ? "" : rs.getString("crit_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				crtcl_value_color = rs.getString("CRIT_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_SYMBOL_ICON");
			else
				crtcl_value_color = rs.getString("crit_color_code") == null ? "" : rs.getString("crit_color_code");
			if(!(mapDescColor.containsKey(crtcl_value_desc)))
			{
				mapDescColor.put(crtcl_value_desc,crtcl_value_color);
				listDesc.add(crtcl_value_desc);
			}

		    crtcl_high_value_desc = rs.getString("crit_high_str_desc") == null ? "" : rs.getString("crit_high_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				crtcl_high_value_color = rs.getString("CRIT_HIGH_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_HIGH_SYMBOL_ICON");
			else
				crtcl_high_value_color = rs.getString("crit_high_color_code") == null ? "" : rs.getString("crit_high_color_code");
			if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
			{
				mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
				listDesc.add(crtcl_high_value_desc);
			}

		    crtcl_low_value_desc = rs.getString("crit_low_str_desc") == null ? "" : rs.getString("crit_low_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				crtcl_low_value_color = rs.getString("CRIT_LOW_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_LOW_SYMBOL_ICON");
			else
				crtcl_low_value_color = rs.getString("crit_low_color_code") == null ? "" : rs.getString("crit_low_color_code");
			if(!(mapDescColor.containsKey(crtcl_low_value_desc)))
			{
				mapDescColor.put(crtcl_low_value_desc,crtcl_low_value_color);
				listDesc.add(crtcl_low_value_desc);
			}
			delta_fail_str  = rs.getString("DELTA_FAIL_STR") == null ? "" : rs.getString("DELTA_FAIL_STR");

			birth = rs.getString("birth");		
		
			out.println("<input type=hidden name='mode' id='mode' value='update'>");
		}
		
		else
	{
		out.println("<input type=hidden name='mode' id='mode' value='insert'>");
	}	
%>

<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<BODY  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='controlsForm' id='controlsForm' >
<input type = hidden  name = idx_value		value = <%=nKey%> - 1>
<input type = hidden  name = cur_idx_value	value = "0">
<input type = hidden  name = called_from	value =<%=called_from%> >
<input type = hidden  name = enc_called_from	value =<%=enc_called_from%> >
<input type = hidden  name = strFromDate	value =<%=strFromDate%> >
<input type = hidden  name = strToDate		value =<%=strToDate%> >
<input type = hidden  name = strPatientId	value =<%=strPatientId%> >
<input type = hidden  name = strHistRecType value =<%=strHistRecType%> >
<input type = hidden  name = strEventClass	value =<%=strEventClass%> >
<input type = hidden  name = strEventGroup	value =<%=strEventGroup%> >
<input type = hidden  name = strEventCode	value =<%=strEventCode%> >
<input type = hidden  name = strFacilityId	value =<%=strFacilityId%> >
<input type = hidden  name = strEncounterId value =<%=strEncounterId%> >
<input type = hidden  name = enc_id value =<%=strEncId%> >
<input type = hidden  name = strEpisodeType	value =<%=strEpisodeType%> >
<input type = hidden  name = strNormalcyInd	value =<%=strNormalcyInd%> >
<input type = hidden  name = strAbnormal	value =<%=strAbnormal%> >
<input type = hidden  name = strFlowSheetId value =<%=strFlowSheetId%> >
<input type = hidden  name = strViewConfRes	value =<%=strViewConfRes%> >
<input type = hidden  name = strGraphOrder	value =<%=strGraphOrder%> >
<input type = hidden  name = strErrorEvent	value =<%=strErrorEvent%> >
<input type = hidden  name = patient_id    	value =<%=strPatientId%> >
<input type = hidden  name = fac_id value =<%=fac_id%> ><!-- IN033489-->
<input type = hidden  name = enctr_id value =<%=enctr_id%> ><!-- IN033489-->
<input type = hidden  name = l_conf_pin_req_yn value=<%= conf_pin_req_yn %>> <!-- ML-MMOH-CRF-0335 - IN057113 -->
<input type = hidden  name = speciality_code	value =<%=speciality_code%> > <!-- IN064106 -->
<input type = hidden  name = attend_pract_code	value =<%=attend_pract_code%> > <!-- IN064106 -->
<table border=0 cellpadding=0 cellspacing=3 width="100%">
<!--
<tr>
<td>
	<table border=1 cellpadding=0 cellspacing=0 width="100%">
	<tr>
		<td align='right'>
			<TABLE width='100%' border=0 cellpadding=0 cellspacing=0>
				<tr>
					<td  class='label'>&nbsp;<fmt:message key="eCA.ClickOnValueCell.label" bundle="${ca_labels}"/></td>
					<td width='2%'><INPUT TYPE="button" value='<fmt:message key="eCA.Manage.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='manageText()' title='Click to manage the events'></td>		
					<%if(birth.equals("Y")){%><TD align='right' width="5%"><input type="button"  name="birth" id="birth"  class="button" value="Birth Register" onClick="modalForBirth('<%=strPatientId%>')">&nbsp;</td><%}%>
					<td width='2%'><INPUT TYPE="button" width='3%' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")%>" class='BUTTON' onClick="if(parent.dataFrame.document.getElementById("length")>5)parent.dataFrame.enterQuickText()" <%=disabled%> title='Click to enter comments'></td>
					<td width='1%'><input type="button"  name="print" id="print"  class="button" <%=printDisp%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick="valsForPrint()" title='Click to print the events'></td>
					<td width='2%'><INPUT TYPE="button" value='<fmt:message key="eCA.Email.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='emailText()' title='Click to email the events' <%=emailDisp%>></td>
				</tr>
			</table>
		</td>
		
	</tr>
	</table>
</td>
</tr>
-->
<tr>
<td nowrap>
<TABLE width='100%' border=0 cellpadding=0 cellspacing=0>
	<tr>
		<%
			String listValues = "";
			String listValuesdisp = "";
			String mapValues = "";
		%>
		<%

			for(int i=0;i<listDesc.size();i++)
			{
				listValues = (String) listDesc.get(i);
				if(listValues.length()>15)
					listValuesdisp=listValues.substring(0,16);
				else
					listValuesdisp=listValues;
				mapValues = (String) mapDescColor.get(listValues);
				if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				{
		%>
					 <td nowrap onMouseOut='clearLayer()' onMouseOver="showToolTip(this,'<%=i%>','<%=listValues%>')">
        <span style='background:url("../../eCA/images/<%=mapValues%>"); width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><%=listValuesdisp%></span>
		<%
				}
				else{

					%>
					
					<td nowrap onMouseOut='clearLayer()' onMouseOver="showToolTip(this,'<%=i%>','<%=listValues%>')">
        <span style='background-color:<%=mapValues%>; width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><%=listValuesdisp%></span>
    </td>
			<%}}
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
			{
		%>
			 <td nowrap>
        <span style='background:url("../../eCA/images/NI_Normal.gif"); width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></span>
    </td>
		<%
			}
			else
			{
		%>
			   <td nowrap>
        <span style='background-color:#32CD32; width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></span>
    </td>
		<%
			}
			%>

		
	</TR>
</TABLE>
</td>
</tr>
</table>
<div id='descLink' style='position:absolute; visibility:hidden;overflow:overflow' ></div>
</form>
<%
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	
	}
	catch(Exception e)
	{
		//out.println(e.toString());//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}


%>
</BODY>
</HTML>

