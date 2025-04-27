<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date				Edit History     Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
15/04/2014		IN047647.1		Chowminya												Reopen Thai Login screen, Page of chart details disappear and unable to click in next page button
24/08/2015		IN057123		Karthi														In Thai screen Date 29/02/2559 when we open Chart screen, the system displays Script Error Message.
22/06/2020		IN073163 		SIVABAGYAM													EM version 12.12.1_CA_Record Chart_System does not display page number and select page button.Occurred in Log in Thai, English working fine.

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartRecordingControls.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
	<body onKeyDown="lockKey()">
	<form name='chartRecordingControlsForm' id='chartRecordingControlsForm'>
	<%
		int nKey = 0;
		Connection con = null;
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String summaryYN = request.getParameter("summaryYN")==null?"":request.getParameter("summaryYN");
		String detailYN = request.getParameter("detailYN")==null?"Y":request.getParameter("detailYN");
		String width = "";
		try{
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs = null; 

		String encounterId		=	request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String module_id		=	request.getParameter("module_id")==null?"":request.getParameter("module_id");
		if(module_id.equals("MC"))
			width = "25%";
		else
			width = "50%";
		if(encounterId.equals("")) encounterId = "0";

		String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String errorAuth	=  request.getParameter("errorAuth")==null?"":request.getParameter("errorAuth");
		String sort_by		= request.getParameter("sort_by")==null?"D":request.getParameter("sort_by");
		String contr_mod_accession_num	= request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num");
		String adm_date		= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
		String facilityId = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
		String patientId = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String chartId = request.getParameter("Chart_Id")==null?"":request.getParameter("Chart_Id");
		String fromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String toDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
		//converstion is done IN047647.1
		if(!locale.equals("en")){//IN073163 STARTS
			fromDate =	com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM", locale,"en"); //- commented for SRR20056-SCF-9434- IN057123 [IN037552]
			toDate	=	com.ehis.util.DateUtils.convertDate(toDate,"DMYHM",  locale,"en"); //- commented for SRR20056-SCF-9434-IN057123 [IN037552]
		}//IN073163 ENDS

		String defaultYN = request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN")==null?"":request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN");
		
		if(summaryYN.equals("N") && detailYN.equals("N"))
		{
			out.println("<script>");	
			out.println("parent.ChartRecordingControlsFrame.location.href='../../eCommon/html/blank.html'</script>");
	
		}
		else
		{

		pstmt = con.prepareStatement("select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') from pr_encounter where facility_id = ? and encounter_id = ? ");
		pstmt.setString(1,facilityId);
		pstmt.setString(2,encounterId);
		rs  = pstmt.executeQuery();
		if(rs.next())
		{
			adm_date = rs.getString(1) == null ? "" :  rs.getString(1);
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		int daySummary = 0;
	
		if(function_from.equals("SECONDARY_TRIAGE"))
			daySummary = 1;

		int count = 0;
		StringBuffer sqlDates = new StringBuffer();
		String tempString = "";
		if(defaultYN.equals("Y"))
		{
			tempString = " CA_ENCNTR_CHART_DRAFT B ";
		}
		else
		{
			tempString = "  CA_CHART_SECTION_COMP B ";
		}
		
		if(detailYN.equals("Y"))
		{
			sqlDates.append("SELECT  distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,decode(discr_msr_result_type,'S',4,'S1',3,'S2',2,'S3',1,0) RANK,'N' DISCR_MSR_RESULT_TYPE  from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
			
			if(defaultYN.equals("Y"))
			{
				sqlDates.append("AND B.FACILITY_ID = A.FACILITY_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID  ");
			}

			sqlDates.append("and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.discr_msr_id and a.facility_id=? and a.patient_id=?  and a.DISCR_MSR_RESULT_TYPE in('C','D','E','N','A','I','L','F','H','T') ");
			
			
				if(fromDate.equals("") && toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi')+0.00068287 ");
				}
				else
				{
					if(!fromDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");	
					}
					if(!toDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
					}
				}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				sqlDates.append(" and CONTR_MODULE_TRANS_REF=?");
			}
		}
	
		if(detailYN.equals("Y") && summaryYN.equals("Y"))
		   sqlDates.append(" UNION ALL");

		if(summaryYN.equals("Y"))
		{
			//sqlDates.append(" SELECT distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,a.DISCR_MSR_RESULT_TYPE from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
			sqlDates.append(" SELECT distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,decode(discr_msr_result_type,'S',4,'S1',3,'S2',2,'S3',1,0) RANK,a.DISCR_MSR_RESULT_TYPE from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");

			if(defaultYN.equals("Y"))
			{
				sqlDates.append("AND B.FACILITY_ID = A.FACILITY_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID  ");
			}

			sqlDates.append("and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN and a.facility_id=? and a.patient_id=? and a.DISCR_MSR_RESULT_TYPE IN ('S','S1','S2','S3')   ");
		 			
				if(fromDate.equals("") && toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");		
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi')+0.00068287");
				}
				else
				{
					if(!fromDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");		
					}
					if(!toDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
					}
				}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				sqlDates.append(" and CONTR_MODULE_TRANS_REF=?");
			}
		}
	 
		if(sort_by.equals("D"))
		{
			//sqlDates.append(" order by 2 Desc");
			sqlDates.append(" order by 2 Desc, 3 ASC");
		}
		else
		{
			sqlDates.append(" order by 2");
		}

		pstmt =	con.prepareStatement(sqlDates.toString());

		if(detailYN.equals("Y"))
		{
			pstmt.setString(++count,chartId);		
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,patientId);
			
			
				if(fromDate.equals("") && toDate.equals(""))
				{
					
						pstmt.setString(++count,adm_date);
					
				}
				if(!fromDate.equals("") && !toDate.equals("")) 
				{
					
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,toDate);
					
				}
				else
				{	
					
						 if(!fromDate.equals(""))
						{
							 pstmt.setString(++count,fromDate);
						}
						 if(!toDate.equals(""))
						{
							pstmt.setString(++count,adm_date);
							pstmt.setString(++count,toDate);
						}
					
				}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
					pstmt.setString(++count,contr_mod_accession_num);
			}
		 }
		 
		 if(summaryYN.equals("Y"))
		 {
			pstmt.setString(++count,chartId);		
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,patientId);

				if(fromDate.equals("") && toDate.equals(""))
				{
					pstmt.setString(++count,adm_date);
				}
				if(!fromDate.equals("") && !toDate.equals("")) 
				{
					pstmt.setString(++count,fromDate);
					pstmt.setString(++count,toDate);
				}
				else
				{	
					if(!fromDate.equals(""))
					{
						 pstmt.setString(++count,fromDate);
					}
					 if(!toDate.equals(""))
					{
						pstmt.setString(++count,adm_date);
						pstmt.setString(++count,toDate);
					}
				}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				pstmt.setString(++count,contr_mod_accession_num);
			}
		}

		rs = pstmt.executeQuery();	
		
		int nCtr = 0;
		String strDateRecd = "";

		while (rs.next())
		{
			strDateRecd = rs.getString(1);
			strDateRecd =	com.ehis.util.DateUtils.convertDate(strDateRecd,"DMYHM", "en",locale); //IN047647.1

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
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	%>
			<input type = 'hidden'  name = 'idx_value'		value = <%=nKey%> - 1>
			<input type = 'hidden'  name = 'cur_idx_value'	value = "0">
			<input type = 'hidden'  name = 'sort_by'	value = "<%=sort_by%>">
			<input type='hidden' value='<%=encounterId%>' name='encounter_id'>
			<input type='hidden' value='<%=chartId%>' name='chartId'>
	
			
			<table cellpadding=0 cellspacing='0' border='1' width='100%' height='100%'>
			<tr><td>
			<table cellpadding=0 cellspacing='0' border=0 width='100%'>
			<tr>
			
			<td width='<%=width%>' align='right'><input class='button' type='button' name='print' id='print' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onclick='PrintData()'>&nbsp;</td>
			<%if(errorAuth.equals("A")){%>
			<td align='right'><input type='button' id='errorBtn' name='showErrors' id='showErrors' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ErrorDetails.label","ca_labels")%>' onclick='showErrosOnClick()'  class='button'>&nbsp;&nbsp;</td> 
			<%}%>
			<td>
			<table cellpadding=0 cellspacing='0' border='1' width='100%'>
				<tr id='buttonVisible' style='visibility:visible' align='right'>
					
					<td  width='2%' nowrap><img src='../../eCommon/images/iGridSPreviousNOR16.gif' id='first' onclick='loadPrevNextTen(this)' disabled /><img src='../../eCommon/images/iGridPreviousNOR16.gif' id='prevTenRecs' onclick='loadPrevNextTen(this)' disabled /></td>
					<td  id='labelCaption' class='Pagination'>&nbsp;</td>
					<td  width='2%' nowrap><img src='../../eCommon/images/iGridNextNOR16.gif' id='nextTenRecs' onclick='loadPrevNextTen(this)' /><img src='../../eCommon/images/iGridSNextNOR16.gif' id='last' onclick='loadPrevNextTen(this)' /></td>
				</tr>
			</table>
			</td></tr></table>
			</td></tr></table>
	<%
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	%>
<script> 

function defaultPage()
{
	if('<%=summaryYN%>' == 'Y' || '<%=detailYN%>' == 'Y')
	{
		var idx_value	= document.forms[0].idx_value.value;
		var sort_by = document.forms[0].sort_by.value;
		var cur_idx_value = document.forms[0].cur_idx_value.value;

		var fromDateTime ="";
		var toDateTime ="";
		var displend = "";
		var displstart = 1;

		if(idx_value > 0)
		{
			fromDateTime	= dtArr[0];
			toDateTime		= dtArr[0];

			if (idx_value >= 1)
			{
				if(sort_by == "A")
					toDateTime = dtArr[1];
				else 
					fromDateTime	= dtArr[1];

				displend = eval(idx_value) ;
			}
			else
				displend = 1;

			document.forms[0].cur_idx_value.value = 0;
			document.getElementById("labelCaption").innerText = "Page "+ displstart + " of " + displend;

			if(idx_value == 1)
			{
				document.forms[0].nextTenRecs.disabled = true;
				document.forms[0].prevTenRecs.disabled = true;
				document.forms[0].first.disabled = true;
				document.forms[0].last.disabled = true;

			}
		}
		else
		{
			document.forms[0].nextTenRecs.disabled = true;
			document.forms[0].prevTenRecs.disabled = true;
			document.forms[0].first.disabled = true;
			document.forms[0].last.disabled = true;
		}
	}
}

defaultPage();
</script>
		</form>
	</body>
</html>

