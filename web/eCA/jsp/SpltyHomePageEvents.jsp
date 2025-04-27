<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	//	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//		String locale = (String) p.getProperty("LOCALE");

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<style>
A:active{
	color:white;
}
A:visited{
	color:white;
}
A:link {
	COLOR:white;
}

</style>

<script src='../../eCA/js/SpltyHomePage.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY   class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='flowSheetEventsForm' id='flowSheetEventsForm'>

		<div id='divUnitTitle' style='postion:relative'>
			<table border='1' width='100%' id='unitTitleTable' cellpadding='0' cellspacing='0' align='center' >
				<TR><TH><fmt:message key="Common.Event.label" bundle="${common_labels}"/></TH><TH><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></TH><TH><!-- <input type='image' src='../../eCA/images/graph.gif' title='Click on the image to view the Graph' onClick='openGraph()'></input> --><a href="javascript:;" onClick='openGraph()'><img title='Click here to view the Graph' src='../../eCA/images/graph.gif'></img></a></TH></TR>
			</TABLE>
		</div>
		<table border='1' width='100%' id='unitTable' cellpadding='0' cellspacing='0' align='center' style="border-bottom:#ffffff">
	<%
		  ArrayList dateList			= new ArrayList();
		  ArrayList tempDateList		= new ArrayList();
		  StringBuffer strBuffDates		= new StringBuffer();
		  StringBuffer sbQryCriteria	= new StringBuffer();
		  HashMap tempSessionMap		= null;

		  Connection con = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
 		  
		  StringBuffer 	sqlData = new StringBuffer();
		  
		  String strFromDate	= "";
		  String strToDate		= "";
		  String strPatientId	= "";

		  String strHistRecType = "";
		  String strEventClass	= "";

		  String strEventGroup	= "";
		  String strEventCode	= "";
		  String strFacilityId	= "";
		  String strEncounterId = "";
		  String strEpisodeType = "";
		  String strNormalcyInd = "";
		  String strAbnormal	= "";
		  String strFlowSheetId = "";
		  String strViewConfRes = "";
		  String strGraphOrder	= "";
		  String called_from	= "";
		  String strErrorEvent	= "";
		  
		  //ArrayList eventList = new ArrayList();		  
		  
		  strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");
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
		  String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
		String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");
		strToDate = request.getParameter("to_date")==null?"":request.getParameter("to_date");
		strFromDate = request.getParameter("from_date")==null?"":request.getParameter("from_date");

//		  strFromDate	= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
//		  strToDate		= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");

		  sbQryCriteria.append("g.patient_id = ?  and g.MODULE_ID=? and g.CYLE_NO=? and a.HIST_REC_TYPE=g.HIST_REC_TYPE and a.CONTR_SYS_ID=g.CONTR_SYS_ID and a.ACCESSION_NUM =g.ACCESSION_NUM	 and a.CONTR_SYS_EVENT_CODE	=g.CONTR_SYS_EVENT_CODE");

			if(!strHistRecType.equals(""))
				sbQryCriteria.append(" and a.hist_rec_type = ? ");

			if(!strEventClass.equals(""))
				sbQryCriteria.append(" and a.event_class = ? ");

			if(!strEventGroup.equals(""))
				sbQryCriteria.append(" and a.event_group = ? ");

			if(!strEventCode.equals(""))
				sbQryCriteria.append(" and a.event_code = ? ");

			if(!strFromDate.equals(""))
				sbQryCriteria.append(" and g.KEY_REF >= ?");

			if(!strToDate.equals(""))
				sbQryCriteria.append(" and g.KEY_REF <= ?"); 

			if(!strFacilityId.equals(""))
				sbQryCriteria.append(" and a.facility_id = ? ");

			if(!strEncounterId.equals(""))
				sbQryCriteria.append(" and a.encounter_id = ? ");

			if (!strEpisodeType.equals("") )
				sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

			if(strAbnormal.equals("Y"))
				sbQryCriteria.append(" and a.normalcy_ind is not null");

			if(strViewConfRes.equals("X"))
				sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");

		  

			sqlData.append( " Select a.event_date dummydate, g.KEY_REF event_date_time, a.hist_rec_type hist_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,d.long_desc  event_desc,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.hist_data_type hist_data_type From cr_encounter_detail a ,cr_hist_rec_type b, cr_event_class   c ,cr_clin_event_mast d ,cr_clin_event_group e,CA_PAT_SPLTY_HIST_REF g ");

			if (!strFlowSheetId.equals(""))
				sqlData.append(" ,ca_flow_sheet_item f ");

			sqlData.append(" where b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and  c.event_class= a.event_class and   d.hist_rec_type=a.hist_rec_type and  d.event_code=a.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE ");
			
			if(!strFlowSheetId.equals(""))
			{
				sqlData.append(" and  f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  ") ;
			}

			sqlData.append( " AND " + sbQryCriteria.toString());

		   if (!strFlowSheetId.equals(""))
			sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type,c.long_desc  ,a.event_class, a.event_group,e.long_desc  ,nvl(a.request_num_seq,d.long_desc),a.event_code, event_date_time "+strGraphOrder+" " );
		   else 
			 sqlData.append( " ORDER BY  a.hist_rec_type,c.long_desc  ,a.event_class, a.event_group,e.long_desc  ,nvl(a.request_num_seq,d.long_desc),a.event_code, event_date_time  "+strGraphOrder+" " );

			


			strBuffDates.append("Select g.KEY_REF event_date	From 	cr_encounter_detail a, CA_PAT_SPLTY_HIST_REF g ");

			strBuffDates.append("where  "+sbQryCriteria.toString());


			if(!strFlowSheetId.equals(""))
				strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ;
			
			strBuffDates.append(" Order by g.KEY_REF  "+strGraphOrder);




			int i = 0;
			String classValue = "";
			String histRecType = "";
			String eventDummyDate = "";
			String prevHistRecType = "";
			String histRecTypeDesc = "";
			String eventClass = "";
			String prevEventClass = "";
			String eventClassDesc = "";
			String eventGroup = "";
			String prevEventGroup = "";
			String eventGroupDesc = "";
			String eventCode = "";
			String prevEventCode = "";
			String eventDesc = "";
			String histDataType = "";
			String resultNumUOM = "";
			String resultNum = "";

			PreparedStatement pstmtDate = null;
			ResultSet resDate = null;

			int nIndex =1;
			
			try
			{				
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sqlData.toString());				
				
				if (!strFlowSheetId.equals(""))
					pstmt.setString(nIndex++,strFlowSheetId);

				pstmt.setString(nIndex++,patient_id);
				pstmt.setString(nIndex++,module_id);
				pstmt.setString(nIndex++,cycle_no);

				if(!strHistRecType.equals(""))
					pstmt.setString(nIndex++,strHistRecType);

				if(!strEventClass.equals(""))
					pstmt.setString(nIndex++,strEventClass);

				if(!strEventGroup.equals(""))
					pstmt.setString(nIndex++,strEventGroup);

				if(!strEventCode.equals(""))
					pstmt.setString(nIndex++,strEventCode);

				if(!strFromDate.equals(""))
					pstmt.setString(nIndex++,strFromDate);

				if(!strToDate.equals(""))
					pstmt.setString(nIndex++,strToDate);
				
				if(!strFacilityId.equals(""))
					pstmt.setString(nIndex++,strFacilityId);

				if(!strEncounterId.equals(""))
					pstmt.setString(nIndex++,strEncounterId);
			
				if(!strEpisodeType.equals("") )
				{
					if(strEpisodeType.equals("I"))
						pstmt.setString(nIndex++,"IP");
					else if(strEpisodeType.equals("O"))
						pstmt.setString(nIndex++,"OP");
					else if(strEpisodeType.equals("D"))
						pstmt.setString(nIndex++,"DC");
					else if(strEpisodeType.equals("E"))
						pstmt.setString(nIndex++,"EM");
					else if(strEpisodeType.equals("X"))
						pstmt.setString(nIndex++,"XT");
				}

				nIndex =1;

				pstmtDate = con.prepareStatement(strBuffDates.toString());

				pstmtDate.setString(nIndex++,patient_id);
				pstmtDate.setString(nIndex++,module_id);
				pstmtDate.setString(nIndex++,cycle_no);

				if(!strHistRecType.equals(""))
					pstmtDate.setString(nIndex++,strHistRecType);

				if(!strEventClass.equals(""))
					pstmtDate.setString(nIndex++,strEventClass);

				if(!strEventGroup.equals(""))
					pstmtDate.setString(nIndex++,strEventGroup);

				if(!strEventCode.equals(""))
					pstmtDate.setString(nIndex++,strEventCode);

				if(!strFromDate.equals(""))
					pstmtDate.setString(nIndex++,strFromDate);

				if(!strToDate.equals(""))
					pstmtDate.setString(nIndex++,strToDate);

				if(!strFacilityId.equals(""))
					pstmtDate.setString(nIndex++,strFacilityId);

				if(!strEncounterId.equals(""))
					pstmtDate.setString(nIndex++,strEncounterId);
			
				if(!strEpisodeType.equals("") )
				{
					if(strEpisodeType.equals("I"))
						pstmtDate.setString(nIndex++,"IP");
					else if(strEpisodeType.equals("O"))
						pstmtDate.setString(nIndex++,"OP");
					else if(strEpisodeType.equals("D"))
						pstmtDate.setString(nIndex++,"DC");
					else if(strEpisodeType.equals("E"))
						pstmtDate.setString(nIndex++,"EM");
					else if(strEpisodeType.equals("X"))
						pstmtDate.setString(nIndex++,"XT");
				}
				
				if(!strFlowSheetId.equals(""))
					pstmtDate.setString(nIndex++,strFlowSheetId);

				int tempInt = 0;

				try
				{
					rs = pstmt.executeQuery();
				}
				catch (Exception eeee)
				{
					//out.println("Exception in Query 1 try of SpltyHomePageEvents.jsp--"+eeee.toString());//COMMON-ICN-0181
					eeee.printStackTrace();//COMMON-ICN-0181

				}
		
				try
				{
					resDate = pstmtDate.executeQuery();
				}
				catch (Exception eee2)
				{
					//out.println("Exception in Query 2 try of SpltyHomePageEvents.jsp--"+eee2.toString());//common-icn-0181
				}
				
				while(resDate.next())
				{
					if(dateList.size() < 10)
					{
						if(!dateList.contains(resDate.getString(1)))
						{
						   dateList.add(resDate.getString(1));
						}
					   tempDateList.add(resDate.getString(1));
					}
					else if(dateList.size() == 10)
					{
						if(dateList.contains(resDate.getString(1)))
						{
							tempDateList.add(resDate.getString(1));
						}
						else
						{
							break;
						}
					}
				}
				if (resDate!=null) resDate.close();
				if (pstmtDate!=null) pstmtDate.close();
				tempSessionMap = new HashMap();

				while(rs.next())
				{
					eventDummyDate = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
					histRecType = rs.getString("hist_type") == null ? "" : rs.getString("hist_type");
					histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? "" : rs.getString("hist_rec_type_desc");
					eventClass = rs.getString("eve_class") == null ? "" : rs.getString("eve_class");
					eventClassDesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
					eventGroup = rs.getString("event_group") == null ? "" : rs.getString("event_group");
					eventGroupDesc = rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
					eventCode = rs.getString("eve_code") == null ? "" : rs.getString("eve_code");
					eventDesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
					resultNumUOM = rs.getString("uom") == null ? "" : rs.getString("uom");
					histDataType = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");
					resultNum = rs.getString("RESULT_NUM") == null ? "" : rs.getString("RESULT_NUM");

					if(dateList.contains(eventDummyDate))
					{
						tempSessionMap.put("histRecType"+tempInt,histRecType);
						tempSessionMap.put("eventDummyDate"+tempInt,eventDummyDate);
						tempSessionMap.put("histRecTypeDesc"+tempInt,histRecTypeDesc);
						tempSessionMap.put("eventClass"+tempInt,eventClass);
						tempSessionMap.put("eventClassDesc"+tempInt,eventClassDesc);
						tempSessionMap.put("eventGroup"+tempInt,eventGroup);
						tempSessionMap.put("eventGroupDesc"+tempInt,eventGroupDesc);
						tempSessionMap.put("eventCode"+tempInt,eventCode);
						tempSessionMap.put("eventDesc"+tempInt,eventDesc);
						tempSessionMap.put("resultNumUOM"+tempInt,resultNumUOM);
						tempSessionMap.put("histDataType"+tempInt,histDataType);
						tempSessionMap.put("resultNum"+tempInt,resultNum);
						tempInt++;
					}
				}//end of while


				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				int tempGrafSeq = 0;

				for(i=0;i<tempInt;i++)
				{
					histRecType = (String) tempSessionMap.get("histRecType"+i);
					eventDummyDate = (String) tempSessionMap.get("eventDummyDate"+i);
					histRecTypeDesc = (String) tempSessionMap.get("histRecTypeDesc"+i);
					eventClass = (String) tempSessionMap.get("eventClass"+i);
					eventClassDesc = (String) tempSessionMap.get("eventClassDesc"+i);
					eventGroup = (String) tempSessionMap.get("eventGroup"+i);
					//out.println(eventGroup);
					eventGroupDesc = (String) tempSessionMap.get("eventGroupDesc"+i);
					eventCode = (String) tempSessionMap.get("eventCode"+i);
					eventDesc = (String) tempSessionMap.get("eventDesc"+i);
					resultNumUOM = (String) tempSessionMap.get("resultNumUOM"+i);
					histDataType = (String) tempSessionMap.get("histDataType"+i);
					resultNum = (String) tempSessionMap.get("resultNum"+i);

					if(i % 2 == 0)
						classValue = "CACHARTQRYEVEN";
					else
						classValue = "CACHARTQRYEVEN";

					if(!prevHistRecType.equals(histRecType))
					{
						out.println("<TR>");
						out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL1'>"+histRecTypeDesc+"</TD>");
						out.println("</TR>");
						out.println("<TR>");
						out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL2'>"+eventClassDesc+"</TD>");
						out.println("</TR>");

						if(!eventGroup.equals("*ALL"))
						{
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='"+classValue+"'>&nbsp;"+eventDesc+"</TD>");
						out.println("<TD class='"+classValue+"'>"+resultNumUOM+"&nbsp;</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='"+classValue+"' align=center><input type='checkbox' id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM' id='UOM' value='"+resultNumUOM+"'><input type='hidden' name='desc' id='desc' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
						}
						out.println("</TR>");
						tempGrafSeq++;
						prevHistRecType = histRecType;
						prevEventClass = eventClass ;
						prevEventGroup = eventGroup;
						prevEventCode = eventCode;
					}
					else if(!prevEventClass.equals(eventClass))
					{
						out.println("<TR>");
						out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL2'>"+eventClassDesc+"</TD>");
						out.println("</TR>");
						if(!eventGroup.equals("*ALL"))
						{//event group is empty
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='"+classValue+"'>&nbsp;"+eventDesc+"</TD>");
						out.println("<TD class='"+classValue+"'>"+resultNumUOM+"&nbsp;</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='"+classValue+"' align=center><input type='checkbox' id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM' id='UOM' value='"+resultNumUOM+"'><input type='hidden' name='desc' id='desc' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventClass = eventClass;
						prevEventGroup = eventGroup;
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
					else if(!prevEventGroup.equals(eventGroup))
					{
						if(!eventGroup.equals("*ALL"))
						{
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='"+classValue+"'>&nbsp;"+eventDesc+"</TD>");
						out.println("<TD class='"+classValue+"'>"+resultNumUOM+"&nbsp;</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='"+classValue+"' align=center><input type='checkbox'  id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM' id='UOM' value='"+resultNumUOM+"'><input type='hidden' name='desc' id='desc' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventGroup = eventGroup;
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
					else if(!prevEventCode.equals(eventCode))
					{
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='"+classValue+"'>&nbsp;"+eventDesc+"</TD>");
						out.println("<TD class='"+classValue+"'>"+resultNumUOM+"&nbsp;</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='"+classValue+"' align=center><input type='checkbox'  id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM' id='UOM' value='"+resultNumUOM+"'><input type='hidden' name='desc' id='desc' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
				}//end of for
				//out.println("<script>alert('"+i+"')</script>");
				%>
					<TR style='visibility:hidden'><TH class='WHITE' ><fmt:message key="Common.Event.label" bundle="${common_labels}"/></TH><TH class='WHITE' ><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></TH><TH class='WHITE'><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/></TH> </TR>
					<TR style='visibility:hidden'><TH class='WHITE' ><fmt:message key="Common.Event.label" bundle="${common_labels}"/></TH><TH class='WHITE' ><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></TH><TH class='WHITE'><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/></TH> </TR>
					</Table>
				<%
					if(i != 0)
					{
				%>
					<script>
							setTimeout("alignUnitsAndTitle()",100);							
						
						parent.dataFrame.location.href="../../eCA/jsp/SpltyHomePageEventDetails.jsp?p_patient_id=<%=patient_id%>&p_module_id=<%=module_id%>&p_cycle_no=<%=cycle_no%>&episode_type=<%=strEpisodeType%>&p_hist_rec_type=<%=strHistRecType%>&p_event_class=<%=strEventClass%>&p_event_group=<%=strEventGroup%>&eventitem=<%=strEventCode%>&c_from_date=<%=strFromDate%>&c_to_date=<%=strToDate%>&episode_wise=N&c_facility_id=<%=strFacilityId%>&encounter_id=<%=strEncounterId%>&performed_by=&errorEvent=<%=strErrorEvent%>&abnormal=<%=strAbnormal%>&normalcy=<%=strNormalcyInd%>&viewConfRes=<%=strViewConfRes%>&&cboFlowSheetComp=<%=strFlowSheetId%>&graphorder=<%=strGraphOrder%>";
					</script>
				<%
					}
					else
					{
				%>
					<script>
						parent.dataFrame.location.href="../../eCommon/html/blank.html";
						<%
							if(called_from.equals("OR"))
							{
						%>
							parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.";
						<%
							}
							else
							{
						%>
								if(top.content!=null)
								{
									top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.";	
								}else
								{
									parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.";	
								}
					</script>
						<%
							}
				}
			}//end of try---main
			catch(Exception exception)
			{
				//out.println("Exception in main try of SpltyHomePageEvents.jsp--"+exception.toString());//COMMON-ICN-0181
				exception.printStackTrace();
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			//session.setAttribute("eventList",eventList);
		%>
			<input type=hidden name='rowsForGraph' id='rowsForGraph' value='<%=i%>'>
		</form>
	</BODY>
</html>

