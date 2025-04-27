<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name				Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           											created
13/12/2012		IN035950		Nijitha													CHL Hospital suggested that 
																						the presentation of the Clinician desktop be changed and more appealing. 
																						Keeping the display of information more clear and visible.
27/12/2013		IN046075		Ramesh G												Bru-HIMS-CRF-391/20
10/06/2015		IN057797		Vijayakumar K											GHL-SCF-976 [IN:057797]
18/11/2015		IN057113		Karthi L									 			ML-MMOH-CRF-0335 - IN057113
12/10/2016		IN047572		Karthi L												[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
07/03/2017		IN063542		Raja S				10/03/2017		Ramesh G			GHL-CRF-0460
02/05/2017		IN064106		Raja S				03/05/2017		Ramesh G			AAKH-SCF-0323
19/01/2018		IN066218  		PRATHYUSHA P		28/1/2018		Ramesh G			ML-MMOH-CRF-0985.1
02/01/2019 		 IN066453		Kamalakannan G  02/01/2019		Ramesh G		ML-BRU-CRF-0491
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
03/02/2020		39052			Ramesh											ML-BRU-CRF-0634
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
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
 <%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String login_user = (String)session.getValue("login_user");//IN071561

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/common.js"			language="javascript"></script>
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
<script src='../../eCA/js/ViewClinicalDocument.js' language='javascript'></script>

</HEAD>
<%		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtDt = null;

		ResultSet rsDt = null;
		ResultSet rs = null;

		//out.println("<script>alert('"+request.getQueryString()+"');</script>");
	

	//String strQueryString = request.getQueryString();
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
	String disablePrev = "disabled";
	String disableNext = "disabled";
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
	String enctr_id = "";//IN031989
	String fac_id="";//IN033489
	String resp_id = (String)session.getValue("responsibility_id"); //IN057797
	//ML-MMOH-CRF-0335 - IN057113 - Start
	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
	//ML-MMOH-CRF-0335 - IN057113 - End
	int nKey = 0;
	int nIndex =1;

  strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");
  strNormalcyInd	= request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");

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
String isSiteSpecificForLabPrint	= request.getParameter("isSiteSpecificForLabPrint")==null?"":request.getParameter("isSiteSpecificForLabPrint");//IN066453
String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");

String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052

boolean restrict_rd	=false;	//IN071561
if("CA_RESULTS_WIDGET".equals(called_from_widget))
strHistRecType=p_hist_type;
//IN035950 Ends
  strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");

  if(strEncId.equals("")) strEncId = "0";

  strFromDate		= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
  strToDate			= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");
    
//	if(called_from.equals("OR"))
//		disabled = "disabled";

	try
	{
		con = ConnectionManager.getConnection(request);
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
  sbQryCriteria.append(" a.patient_id = ? ");

	if(!strHistRecType.equals(""))
		sbQryCriteria.append(" and a.hist_rec_type = ? ");

	if(!strEventClass.equals(""))
		sbQryCriteria.append(" and a.event_class = ? ");

	if(!strEventGroup.equals(""))
		sbQryCriteria.append(" and a.event_group = ? ");

	if(!strEventCode.equals(""))
		sbQryCriteria.append(" and a.event_code = ? ");

	if(!strFromDate.equals(""))
		sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

	if(!strToDate.equals(""))
		sbQryCriteria.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')"); 

	if(!strFacilityId.equals(""))
		sbQryCriteria.append(" and a.facility_id = ? ");
	//IN071561 STARTS
	 if(restrict_rd)
		   sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");
	//IN071561 ENDS
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && "".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class=? ");
		}
		//IN035950 End
	if(!strEncounterId.equals("")&&!strEncounterId.equals("0"))
		sbQryCriteria.append(" and a.encounter_id = ? ");

	if (!strEpisodeType.equals("") )
		sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

	if(strAbnormal.equals("Y"))
	{
		//Modified the following condition by Archana  on 9/16/2010 related to the incident IN023804.
		sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
	}

	if(strViewConfRes.equals("X"))
		//sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");
		//sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z' ");//VICHAYUT DEMO Issue
		sbQryCriteria.append("and nvl(a.PROTECTION_IND,'N')!='Z' ");//VICHAYUT DEMO Issue

   if(strErrorEvent.equals("Y"))//dont'include error events
		sbQryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
   else 
	   sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')"); 

	//strBuffDates.append("Select distinct to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date 	From 	cr_encounter_detail a ");//Menaka
	strBuffDates.append("Select distinct to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date, a.encounter_ID, a.FACILITY_ID 	From 	cr_encounter_detail a, PR_ENCOUNTER g  ");//Menaka -- // added PR_ENCOUNTER g for  MMS-QH-CRF-0177 [IN047572] 
	strBuffDates.append("where  "+sbQryCriteria.toString());
	//IN046075 Start.
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	//String resp_id = (String)session.getValue("responsibility_id"); 
    strBuffDates.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.EVENT_CODE_TYPE,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); 
	//IN046075 End.
	strBuffDates.append(" and g.FACILITY_ID(+) = a.FACILITY_ID AND g.ENCOUNTER_ID(+) = a.ENCOUNTER_ID "); // MMS-QH-CRF-0177 [IN047572]
	if(!strFlowSheetId.equals("")){
		//strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ; // Commented for IN063542
		strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE AND (f.event_code = a.event_code OR f.event_code = a.EVENT_GROUP)) ") ; // Added for IN063542
	}			
	if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
		if(!speciality_code.equals("")){
			strBuffDates.append(" and g.SPECIALTY_CODE = ? ");
		}
	} else {
		strBuffDates.append(" and g.ATTEND_PRACTITIONER_ID = ? ");
	} // MMS-QH-CRF-0177 [IN047572] - End
	//IN066218 starts
	if("Y".equals(calling_from_2T))
		strBuffDates.append(" and a.Added_BY_ID ='DM'");
	//IN066218 Ends
	strBuffDates.append(" Order by to_date(event_date,'dd/mm/yyyy hh24:mi')  "+strGraphOrder);

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

		if(defPrevStatus.equals("A")) emailDisp = "style='display'";
		else emailDisp = "style='display:none'";

		if(defPrevStatusForPrint.equals("A")) printDisp = "style='display'";
		else printDisp = "style='display:none'";

		pstmtDt = con.prepareStatement(strBuffDates.toString());
		
		pstmtDt.setString(nIndex++,strPatientId);
		
		if(!strHistRecType.equals(""))
		{
			pstmtDt.setString(nIndex++,strHistRecType);
			
		}

		if(!strEventClass.equals(""))
		{
			pstmtDt.setString(nIndex++,strEventClass);
			
		}
		if(!strEventGroup.equals(""))
		{
			pstmtDt.setString(nIndex++,strEventGroup);
			
		}

		if(!strEventCode.equals(""))
		{
			pstmtDt.setString(nIndex++,strEventCode);
			
		}	

		//if(!strGraphOrder.equals("desc"))
		{
			if(!strFromDate.equals(""))
			{
				pstmtDt.setString(nIndex++,strFromDate);
				
			}	

			if(!strToDate.equals(""))
			{
				pstmtDt.setString(nIndex++,strToDate);
				
			}
		}
		//else
		/*{
			if(!strFromDate.equals(""))
				pstmtDt.setString(nIndex++,strToDate);

			if(!strToDate.equals(""))
				pstmtDt.setString(nIndex++,strFromDate);
		}
		*/

		if(!strFacilityId.equals(""))
		{
			pstmtDt.setString(nIndex++,strFacilityId);
			
		}	

		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			pstmtDt.setString(nIndex++,eventClasswidget);
		}
		//IN035950 Ends
		if(!strEncounterId.equals("")&&!strEncounterId.equals("0"))
		{
			pstmtDt.setString(nIndex++,strEncounterId);
			
		}	
	
		if(!strEpisodeType.equals("") )
		{
			if(strEpisodeType.equals("I"))
			{
				pstmtDt.setString(nIndex++,"IP");
				
			}	
			else if(strEpisodeType.equals("O"))
			{
				pstmtDt.setString(nIndex++,"OP");
				
			}	
			else if(strEpisodeType.equals("D"))
			{
				pstmtDt.setString(nIndex++,"DC");
				
			}	
			else if(strEpisodeType.equals("E"))
			{
				pstmtDt.setString(nIndex++,"EM");
				
			}	
			else if(strEpisodeType.equals("X"))
			{
				pstmtDt.setString(nIndex++,"XT");
				
			}	
		}
		
		if(!strFlowSheetId.equals(""))
		{
			pstmtDt.setString(nIndex++,strFlowSheetId);
			
		}	
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				pstmtDt.setString(nIndex++, speciality_code);
			}
		} else {
			pstmtDt.setString(nIndex++, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End
		int nCtr = 0;

		try
		{
			rsDt = pstmtDt.executeQuery();
	
			String strDateRecd = "";
			while (rsDt.next())
			{
				strDateRecd = rsDt.getString(1);
				enctr_id = rsDt.getString("encounter_ID") == null ? "" : rsDt.getString("encounter_ID");//Menaka
				fac_id = rsDt.getString("FACILITY_ID") == null ? "" : rsDt.getString("FACILITY_ID");//Menaka
				if (nCtr == 0 || nCtr == 10)
				{
					%>
						<script>
						dtArr[<%=nKey%>] = "<%=strDateRecd%>";</script>

					<%
					nKey++;
					nCtr =0;

				}
				
				nCtr++;
			}

			if(nCtr >= 1)
			{
				%>
				<script>dtArr[<%=nKey%>] = "<%=strDateRecd%>";</script>
				<%
			}
			
			if(nKey == 0)
			{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
				if(called_from.equals("OR"))
					out.println("parent.window.close();</script>");
				else
					out.println("clearForm('FS');</script>");
			}


		}
		catch (Exception ee1)
		{
			out.println("Dates -"+strBuffDates.toString()+"-");
			//out.println("exception at try 2 of FlowSheetControls.jsp -"+ee1.toString());//COMMON-ICN-0181
			ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rsDt != null) rsDt.close();
			if(pstmtDt != null) pstmtDt.close();
		}
		%>
<!--			<script>alert(dtArr)</script> -->

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
<input type=hidden name=p_review_rad_yn id=p_review_rad_yn value=<%=p_review_rad_yn %>><!-- IN071561-->
<input type=hidden name=order_type_3T id=order_type_3T value=<%=order_type_3T %>> <!-- 39052 -->

<table border=0 cellpadding=0 cellspacing=3 width="100%">
<tr>
<td>
	<table border=1 cellpadding=0 cellspacing=0 width="100%">
	<tr>
		<td width='25%' align='right'>
			<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")%>' class='BUTTON' onClick='openGraph1()' title='Click here to view the graph'>&nbsp;
		</td>
	
		<td align='right'>
			<TABLE width='100%' border=0 cellpadding=0 cellspacing=0>
			<!--IN066453 diable condition added for print,comments,manage button-->
				<tr>
					<td  class='label'>&nbsp;<fmt:message key="eCA.ClickOnValueCell.label" bundle="${ca_labels}"/></td>
					<td width='2%'><INPUT TYPE="button" name="manage" id="manage" <%if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){%>disabled<%}%> value='<fmt:message key="eCA.Manage.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='manageText()' title='Click to manage the events'></td>		
					<%if(birth.equals("Y")){%><TD align='right' width="5%"><input type="button"  name="birth" id="birth"  class="button" value="Birth Register" onClick="modalForBirth('<%=strPatientId%>')">&nbsp;</td><%}%>
					<td width='2%'><INPUT TYPE="button" name="comments" id="comments" <%if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){%>disabled<%}%> width='3%' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")%>" class='BUTTON' onClick="if(parent.dataFrame.document.getElementById('length')>5)parent.dataFrame.enterQuickText()" <%=disabled%> title='Click to enter comments'></td>
					<td width='1%'><input type="button"  name="print" id="print" <%if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){%>disabled<%}%> class="button" <%=printDisp%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick="valsForPrint()" title='Click to print the events'></td>
					<td width='2%'><INPUT TYPE="button" value='<fmt:message key="eCA.Email.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='emailText()' title='Click to email the events' <%=emailDisp%>></td>

					<!-- Added BY Arvind For CRF 043   -->
				<td width='2%'>
					<INPUT TYPE="button" value='<fmt:message key="eCA.View.label" bundle="${ca_labels}"/>' class='BUTTON' title='Click to view' name='emailBtn' onclick='loadViewPage()'>
				</td>
				<!-- End Here -->

					<td align=right>
					<!-- <table border=0 cellpadding=0 cellspacing=0 width="100%" align='right' id='tablePrevNext' style='display:inline'>
					<tr>
					<td  width='85%'>&nbsp;</td>
					<td align='right' width='5%' ><input type='button' id='prev' name='prev' id='prev' value='<' <%=disablePrev%> class='button' onclick='loadPrevNext(this)' align='right'></td>
					<td  align ='center' class = 'QRYEVEN'>
					<input type ='label' class="LABEL" name = 'label_cap'> 
					</td>
					<td align='left' width='5%'><input type='button' id='next' name='next' id='next' value='>' <%=disableNext%> class='button' onclick='loadPrevNext(this)' ></td>
					</tr>
					</table> -->
					<table border=1 cellpadding=0 cellspacing=0 width="80%" id='tablePrevNext' style='border-color:#CFCFCD;display:inline'>
					<tr>
					<td width='2%' nowrap><img src='../../eCommon/images/iGridSPreviousNOR16.gif' id='first' onclick='loadPrevNext(this)' <%=disablePrev%> /><img src='../../eCommon/images/iGridPreviousNOR16.gif' id='prev' onclick='loadPrevNext(this)' <%=disablePrev%> /></td>
					<td id='label_cap' class='Pagination'>&nbsp;</td>
					<td width='2%' nowrap><img src='../../eCommon/images/iGridNextNOR16.gif' id='next' onclick='loadPrevNext(this)' <%=disableNext%> /><img src='../../eCommon/images/iGridSNextNOR16.gif' id='last' onclick='loadPrevNext(this)' <%=disableNext%> /></td>
					</tr>
					</table>&nbsp;
					</td>
				</tr>
			</table>
		</td>
		
	</tr>
	</table>
</td>
</tr>
<tr>
<td nowrap>
<TABLE width='100%' border=0 cellpadding=0 cellspacing=0>
	<tr>
	<!--<td width='26%'>&nbsp;</td>-->
		<%
			String listValues = "";
			String listValuesdisp = "";
			String mapValues = "";
	//		int tdWidth = 100/listDesc.size();
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
					 <td nowrap onMouseOut='clearLayer()' onMouseOver="showToolTip(this, '<%= i %>', '<%= listValues %>')">
        <span style='background:url(../../eCA/images/<%= mapValues %>); width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><%= listValuesdisp %></span>&nbsp;
    </td>
		<%
				}
				else{
					//out.println("<td nowrap><font style='background-color:"+mapValues+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+listValues+"</font>&nbsp;</td>");
					%>
				<td nowrap onMouseOut='clearLayer()' onMouseOver="showToolTip(this, '<%= i %>', '<%= listValues %>')">
        <span style='background-color:<%= mapValues %>; width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><%= listValuesdisp %></span>
    </td>
			<%}}
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
			{
		%>
			 <td nowrap>
        <span style='background:url("../../eCA/images/NI_Normal.gif"); width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></span>&nbsp;
    </td>
		<%
			}
			else
			{
		%>
				 <td nowrap>
        <span style='background-color:#32CD32; width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></span>&nbsp;
    </td>
		<%
			}
			%>
		<!--<td colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td  class='label'>&nbsp;<fmt:message key="eCA.ClickOnValueCell.label" bundle="${ca_labels}"/></td>
		<td width='2%'><INPUT TYPE="button" value='<fmt:message key="eCA.Manage.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='manageText()' title='Click to manage the events'></td>		
		<%if(birth.equals("Y")){%><TD align='right' width="5%"><input type="button"  name="birth" id="birth"  class="button" value="Birth Register" onClick="modalForBirth('<%=strPatientId%>')">&nbsp;</td><%}%>
		<td width='2%'><INPUT TYPE="button" width='3%' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")%>" class='BUTTON' onClick="if(parent.dataFrame.document.getElementById('length')>5)parent.dataFrame.enterQuickText()" <%=disabled%> title='Click to enter comments'></td>
		<td width='1%'><input type="button"  name="print" id="print"  class="button" <%=printDisp%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick="valsForPrint()" title='Click to print the events'></td>
		<td width='2%'><INPUT TYPE="button" value='<fmt:message key="eCA.Email.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='emailText()' title='Click to email the events' <%=emailDisp%>></td> -->
		
		
	</TR>
</TABLE>
</td>
</tr>
</table>
<script> 

function defaultPage() {
    var idx_value = document.forms[0].idx_value.value;

    var called_from = parent.controlsFrame.document.forms[0].called_from.value;
    var graphorder = parent.controlsFrame.document.forms[0].strGraphOrder.value;
    
    var cur_idx_value = document.forms[0].cur_idx_value.value;

    var fromDateTime = "";
    var toDateTime = "";
    var displend = "";
    var displstart = 1;

    if (idx_value > 0) {
        fromDateTime = dtArr[0];
        toDateTime = dtArr[0];

        if (idx_value >= 1) {
            if (graphorder == "asc")
                toDateTime = dtArr[1];
            else 
                fromDateTime = dtArr[1];

            displend = eval(idx_value);
        } else {
            displend = 1;
        }

        parent.controlsFrame.document.forms[0].cur_idx_value.value = 0;
        parent.controlsFrame.document.getElementById("label_cap").innerText = "Page " + displstart + " of " + displend;

		if(idx_value == 1)
		{
			parent.controlsFrame.document.forms[0].next.disabled = true;
			parent.controlsFrame.document.forms[0].prev.disabled = true;
			parent.controlsFrame.document.forms[0].first.disabled = true;
			parent.controlsFrame.document.forms[0].last.disabled = true;
		}

        if (called_from != 'OR') {
            populateControl(fromDateTime, toDateTime);
        } else {
            populateControlOR(fromDateTime, toDateTime);
        }
    }
}

function disableButtons() {
    var controlsFrame = parent.controlsFrame.document.forms[0];
    
    // Disable buttons
    controlsFrame.next.disabled = true;
    controlsFrame.prev.disabled = true;
    controlsFrame.first.disabled = true;
    controlsFrame.last.disabled = true;

    // Remove onclick handlers to ensure they cannot trigger the function anymore
    controlsFrame.next.onclick = function(event) { event.preventDefault(); return false; };
    controlsFrame.prev.onclick = function(event) { event.preventDefault(); return false; };
    controlsFrame.first.onclick = function(event) { event.preventDefault(); return false; };
    controlsFrame.last.onclick = function(event) { event.preventDefault(); return false; };
}

defaultPage();
</script>
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

