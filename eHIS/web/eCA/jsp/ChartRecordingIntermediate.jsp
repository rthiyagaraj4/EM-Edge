<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String encounterId =  request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_id =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.ChartRecordingAddGroupBean chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounterId,"eCA.ChartRecordingAddGroupBean",session);		
	chartingBean.clearBean();
%>
<html>
<head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name ="chartRecordingIntermediateForm">
<%
	String splChartType = "";

	session.removeAttribute("tempDateArray"+encounterId);
	session.removeAttribute("arrayNext"+encounterId);
	String sysdate = "";
	String summaryText = request.getParameter("summaryText")==null?"":request.getParameter("summaryText");
	String chtId= request.getParameter("chartId")==null?"":request.getParameter("chartId");
//	String result= request.getParameter("result")==null?"":request.getParameter("result");
	String errorAuth= request.getParameter("errorAuth")==null?"":request.getParameter("errorAuth");
	String dateDefault = request.getParameter("dateDefault")==null?"":request.getParameter("dateDefault");
	int recordCount=0;
	String summaryYN = request.getParameter("summaryYN")==null?"N":request.getParameter("summaryYN");
	String detailYN = request.getParameter("detailYN")==null?"Y":request.getParameter("detailYN");
	String queryString =  request.getParameter("qs")==null?"":request.getParameter("qs");
	String sort_by =  request.getParameter("sort_by")==null?"":request.getParameter("sort_by");
	String function_from=  request.getParameter("function_from")==null?"":request.getParameter("function_from");
	String facilityId = (String) session.getValue( "facility_id" )==null ? "" :(String) session.getValue( "facility_id" );			
	String modifyYN = request.getParameter("modifyYN")==null?"Y":request.getParameter("modifyYN");
	String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
//	String fromDateForExt = request.getParameter("fromDateForExt")==null?"":request.getParameter("fromDateForExt");
	//String toDateForExt = request.getParameter("toDateForExt")==null?"":request.getParameter("toDateForExt");
	String locale = request.getParameter("locale")==null?"":request.getParameter("locale");
	
	String fromDate =  "";
	String toDate = "";	
	String DEFINE_MODIFIABLE_AT_TRN_YN="";
	String scope = "";
	StringBuffer sql = new StringBuffer();

	if(function_from.equals("SECONDARY_TRIAGE"))
	{
		fromDate = dateDefault;
		toDate = dateDefault;
	}
	else
	{
		fromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		toDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
	}	
	Connection con = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt =null;
		ResultSet rs= null;
				
		
		try
		{
			sql.append("select past_rec_scope_days, SPL_CHART_TYPE spl_chart_type, CONFIG_TYPE DEFINE_MODIFIABLE_AT_TRN_YN, to_char(sysdate,'HH24:MI') from ca_chart where chart_id = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,chtId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				scope = rs.getString("past_rec_scope_days") == null ? "" : rs.getString("past_rec_scope_days");
				splChartType = rs.getString("spl_chart_type") == null ? "" : rs.getString("spl_chart_type");
				DEFINE_MODIFIABLE_AT_TRN_YN = rs.getString("DEFINE_MODIFIABLE_AT_TRN_YN");
				sysdate = rs.getString(4);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}
		//if(!function_from.equals("SECONDARY_TRIAGE"))	
		//{
%>
		<!--	<script>
				var scope1="<%=scope%>";
				parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.past_scope.value=scope1;
				if(scope1 == "")
					parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.summaryText.value="1";
				else
					parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.summaryText.value=scope1;
			</script> -->
<%
			/*if(scope == "")
				summaryText = "1";
			else
				summaryText = scope;
		}*/

		/*sqlSplChart = "select SPL_CHART_TYPE spl_chart_type from CA_Chart where chart_id = ?";
		psSplChart = con.prepareStatement(sqlSplChart);
		psSplChart.setString(1,chtId);
		resSplChart = psSplChart.executeQuery();

		while(resSplChart != null && resSplChart.next())
		{
			splChartType = resSplChart.getString("spl_chart_type") == null ? "" : resSplChart.getString("spl_chart_type");
		}

		if(resSplChart != null) resSplChart.close();
		if(psSplChart != null) psSplChart.close();
				
		StringBuffer sql = new StringBuffer("select CONFIG_TYPE DEFINE_MODIFIABLE_AT_TRN_YN ,to_char(sysdate,'HH24:MI') from ca_chart where chart_id = ? ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,chtId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			DEFINE_MODIFIABLE_AT_TRN_YN = rs.getString("DEFINE_MODIFIABLE_AT_TRN_YN");
			sysdate = rs.getString(2);
		}
		if (pstmt!=null) pstmt.close();
		if( rs!=null) rs.close();*/


/************************************************************************/
		if(!function_from.equals("SECONDARY_TRIAGE"))
		{
			//out.println("<script>alert('scope in side function_from"+scope+"')</script>");
			if(modifyYN.equals("Y"))
			{
				//out.println("<script>alert('scope in side modifyYN"+scope+"')</script>");

				if(DEFINE_MODIFIABLE_AT_TRN_YN.equals("Y"))
				{
					//out.println("<script>alert('scope in side DEFINE_MODIFIABLE_AT_TRN_YN"+scope+"')</script>");
					
					sql = new StringBuffer("select count(*)  from CA_ENCNTR_CHART_DRAFT where encounter_id = ?  and chart_id = ? and FACILITY_ID=? ");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,encounterId);
					pstmt.setString(2,chtId);
					pstmt.setString(3,facilityId);
					rs = pstmt.executeQuery();	
					while(rs.next())
					{
						recordCount = rs.getInt(1);
					}
					if (pstmt!=null) pstmt.close();
					if( rs!=null) rs.close();	
					if(recordCount == 0)	
					{
						//out.println("<script>alert('scope if record count is zero"+scope+"')</script>");
					
%>
						<script>
						async function toLoadChartRecordingFrameSet(){
							
						
							var dialogTop		=	"80" ;	
							var dialogHeight= "80vh" ;
							var dialogWidth = "46vw" ;
							var status			=	"no";
							var arguments		=	"" ;
							var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
							var action_url		=	'../../eCA/jsp/ChartRecordingFrameSet.jsp?chartId='+"<%=chtId%>"+'&encounterId='+"<%=encounterId%>";
							var ret = await window.showModalDialog(action_url,arguments,features);
	
							if(ret != undefined && ret != '')
							{
								parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonAddItem.style.visibility='visible'
								
								var systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;

			                    var parameterDate = minusDate(systemdate,"DMYHM",'<%=locale%>','<%=scope%>',"d");		   
							    var qs="<%=queryString%>";
							
							   if("<%=fromDate%>" !="" || "<%=fromDate%>" !="null" || "<%=fromDate%>" !=null)
							  {
								qs +="&fromDate="+parameterDate;
							  }
							  if("<%=toDate%>"!="" || "<%=toDate%>" !="null" || "<%=toDate%>" !=null)
							  {
								qs +="&toDate="+systemdate;
							  }

								parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";

								parent.ChartRecordingToolBarFrame.location.href = "../jsp/ChartRecordingToolBar.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&errorAuth="+"<%=errorAuth%>";
								parent.ChartRecordingControlsFrame.location.href = "../jsp/ChartRecordingControls.jsp?Chart_Id="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";
								parent.ChartRecordingColorFrame.location.href = "../jsp/ChartRecordingColorBar.jsp?module_id="+"<%=module_id%>";
								//var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById("tdIdForClassCriteria");
								//tableId.className='CACHARTCRITERIA'	
								//parent.ChartRecordingCriteriaFrame.document.getElementById("dayView").style.display='inline';
								//parent.ChartRecordingCriteriaFrame.document.getElementById("imgDate").style.display='inline';
								//parent.ChartRecordingCriteriaFrame.document.getElementById("label").style.display='inline';
								//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.style.visibility='visible'
								//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.style.visibility='visible'
								//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.style.visibility='visible'
								//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.style.visibility='visible'
								//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true
								//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true
								//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''
								//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''
							}
						}
						toLoadChartRecordingFrameSet();
						</script>

<%	
					}
					else
					{
						//out.println("<script>alert('scope in record count is not zero eld"+scope+"')</script>");
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonAddItem.style.visibility='visible' </script>");
%>
						<script>
							/*var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById("tdIdForClassCriteria");
							tableId.className='CACHARTCRITERIA'	
							parent.ChartRecordingCriteriaFrame.document.getElementById("dayView").style.display='inline';
							parent.ChartRecordingCriteriaFrame.document.getElementById("imgDate").style.display='inline';
							parent.ChartRecordingCriteriaFrame.document.getElementById("label").style.display='inline';
							parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.style.visibility='visible'
							parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.style.visibility='visible'
							parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.style.visibility='visible'
							parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.style.visibility='visible'
							parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true
							parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true
							parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''
							parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''*/

							var systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;
						
			                var parameterDate = minusDate(systemdate,"DMYHM",'<%=locale%>','<%=scope%>',"d");		   
							var qs="<%=queryString%>";
							
							if("<%=fromDate%>" !="" || "<%=fromDate%>" !="null" || "<%=fromDate%>" !=null)
							{
								qs +="&fromDate="+parameterDate;
							}
							if("<%=toDate%>"!="" || "<%=toDate%>" !="null" || "<%=toDate%>" !=null)
							{
								qs +="&toDate="+systemdate;
							}
							
						   	parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";

							parent.ChartRecordingToolBarFrame.location.href = "../jsp/ChartRecordingToolBar.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&errorAuth="+"<%=errorAuth%>";
							parent.ChartRecordingControlsFrame.location.href = "../jsp/ChartRecordingControls.jsp?Chart_Id="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";
							parent.ChartRecordingColorFrame.location.href = "../jsp/ChartRecordingColorBar.jsp?module_id="+"<%=module_id%>";
						</script>
<%
					}
				}
				else
				{
					//out.println("<script>alert('scope out side DEFINE_MODIFIABLE_AT_TRN_YN"+scope+"')</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonAddItem.style.visibility='hidden' </script>");
%>
					<script>		
						/*var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById("tdIdForClassCriteria");
						tableId.className='CACHARTCRITERIA'	
						parent.ChartRecordingCriteriaFrame.document.getElementById("label").style.display='inline';
						parent.ChartRecordingCriteriaFrame.document.getElementById("dayView").style.display='inline';
						parent.ChartRecordingCriteriaFrame.document.getElementById("imgDate").style.display='inline';
						parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.style.visibility='visible'
						parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.style.visibility='visible'
						parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.style.visibility='visible'
						parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.style.visibility='visible'
						parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true
						parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true
						parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''
						parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''*/
						var systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;
			            var parameterDate = minusDate(systemdate,"DMYHM",'<%=locale%>','<%=scope%>',"d");

						var qs="<%=queryString%>";

						if("<%=fromDate%>" !="" || "<%=fromDate%>" !="null" || "<%=fromDate%>" !=null)
						{
								qs +="&fromDate="+parameterDate; 
						}
						if("<%=toDate%>" !="" || "<%=toDate%>" !="null" || "<%=toDate%>" !=null)
					   {
						qs +="&toDate="+systemdate;
					   }
						parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";

						parent.ChartRecordingToolBarFrame.location.href = "../jsp/ChartRecordingToolBar.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&errorAuth="+"<%=errorAuth%>";
						parent.ChartRecordingControlsFrame.location.href = "../jsp/ChartRecordingControls.jsp?Chart_Id="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";
						parent.ChartRecordingColorFrame.location.href = "../jsp/ChartRecordingColorBar.jsp?module_id="+"<%=module_id%>";
					</script>
<%				}
			}
			else
			{
				//out.println("<script>alert('scope out side modifyYN"+scope+"')</script>");
%>
				<script>		
					/*var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById("tdIdForClassCriteria");
					tableId.className='CACHARTCRITERIA'	
					parent.ChartRecordingCriteriaFrame.document.getElementById("label").style.display='inline';
					parent.ChartRecordingCriteriaFrame.document.getElementById("dayView").style.display='inline';
					parent.ChartRecordingCriteriaFrame.document.getElementById("imgDate").style.display='inline';
					parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.style.visibility='visible'
					parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.style.visibility='visible'
					parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.style.visibility='visible'
					parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.style.visibility='visible'
					parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true
					parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true
					parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''
					parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''*/

					var systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;

			        var parameterDate = minusDate(systemdate,"DMYHM",'<%=locale%>','<%=scope%>',"d");

				    var qs="<%=queryString%>";

					if("<%=fromDate%>" !="" || "<%=fromDate%>" !="null" || "<%=fromDate%>" !=null)
					{
						qs +="&fromDate="+parameterDate; 
					}
					if("<%=toDate%>" !="" || "<%=toDate%>" !="null" || "<%=toDate%>" !=null)
					 {
					   qs +="&toDate="+systemdate;
					 }
					parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";

					parent.ChartRecordingToolBarFrame.location.href = "../jsp/ChartRecordingToolBar.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&errorAuth="+"<%=errorAuth%>";
					parent.ChartRecordingControlsFrame.location.href = "../jsp/ChartRecordingControls.jsp?Chart_Id="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";
					parent.ChartRecordingColorFrame.location.href = "../jsp/ChartRecordingColorBar.jsp?module_id="+"<%=module_id%>";
				</script>
<%			
					}
				
		}
		else if(function_from.equals("SECONDARY_TRIAGE"))
		{
			//out.println("<script>alert('scope out side SECONDARY_TRIAGE function_from"+scope+"')</script>");
			
			if(modifyYN.equals("Y"))
			{
				if(DEFINE_MODIFIABLE_AT_TRN_YN.equals("Y"))
				{					
					sql = new StringBuffer("select count(*)  from CA_ENCNTR_CHART_DRAFT where encounter_id = ?  and chart_id = ? and FACILITY_ID=? ");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,encounterId);
					pstmt.setString(2,chtId);
					pstmt.setString(3,facilityId);
					rs = pstmt.executeQuery();	
					while(rs.next())
					{
						recordCount = rs.getInt(1);
					}
					if (pstmt!=null) pstmt.close();
					if( rs!=null) rs.close();	
					if(recordCount == 0)	
					{				
%>
						<script>
							var dialogTop		=	"80" ;	
							var dialogHeight= "30" ;
							var dialogWidth = "40" ;
							var status			=	"no";
							var arguments		=	"" ;
							var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
							var action_url		=	'../../eCA/jsp/ChartRecordingFrameSet.jsp?chartId='+"<%=chtId%>"+'&encounterId='+"<%=encounterId%>";
							var ret = window.showModalDialog(action_url,arguments,features);
	
							if(ret != undefined && ret != '')
							{
								var qs="<%=queryString%>";
								if("<%=fromDate%>" !="")
								{
									qs +="&fromDate="+"<%=fromDate%>"; 
								}	
								if("<%=toDate%>"!="")
								{
									qs +="&toDate="+"<%=toDate%>";
								}
								parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";

								parent.ChartRecordingToolBarFrame.location.href = "../jsp/ChartRecordingToolBar.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&errorAuth="+"<%=errorAuth%>";
								parent.ChartRecordingColorFrame.location.href = "../jsp/ChartRecordingColorBar.jsp?module_id="+"<%=module_id%>";
							}
						</script>
<%	
					}
					else
					{
%>
						<script>
							var qs="<%=queryString%>";
							if("<%=fromDate%>" !="")
							{
								qs +="&fromDate="+"<%=fromDate%>"; 
							}
							if("<%=toDate%>"!="")
							{
								qs +="&toDate="+"<%=toDate%>";
							}
							parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";

							parent.ChartRecordingToolBarFrame.location.href = "../jsp/ChartRecordingToolBar.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&errorAuth="+"<%=errorAuth%>";
							parent.ChartRecordingColorFrame.location.href = "../jsp/ChartRecordingColorBar.jsp?module_id="+"<%=module_id%>";
						</script>
<%
					}
				}
				else
				{
%>
					<script>		
						var qs="<%=queryString%>";
						if("<%=fromDate%>" !="")
						{
								qs +="&fromDate="+"<%=fromDate%>"; 
						}
						if("<%=toDate%>"!="")
						qs +="&toDate="+"<%=toDate%>";
						parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";

						parent.ChartRecordingToolBarFrame.location.href = "../jsp/ChartRecordingToolBar.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&errorAuth="+"<%=errorAuth%>";
						parent.ChartRecordingColorFrame.location.href = "../jsp/ChartRecordingColorBar.jsp?module_id="+"<%=module_id%>";
					</script>
<%				}
			}
			else
			{
%>
				<script>		
					var qs="<%=queryString%>";
					if("<%=fromDate%>" !="")
					{
							qs +="&fromDate="+"<%=fromDate%>"; 
					}
					if("<%=toDate%>"!="")
					qs +="&toDate="+"<%=toDate%>";
					parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+"<%=chtId%>"+"&"+qs+"&DEFINE_MODIFIABLE_AT_TRN_YN="+"<%=DEFINE_MODIFIABLE_AT_TRN_YN%>"+"&detailYN="+"<%=detailYN%>"+"&summaryYN="+"<%=summaryYN%>"+"&defaultDate="+"<%=dateDefault%>"+"&summaryText="+"<%=summaryText%>"+"&sysdate="+"<%=sysdate%>"+"&function_from="+"<%=function_from%>"+"&sort_by="+"<%=sort_by%>"+"&errorAuth="+"<%=errorAuth%>"+"&modifyYN="+"<%=modifyYN%>"+"&module_id="+"<%=module_id%>";
				</script>
<%			}
			
		}//end of main else
			
	}
	catch(Exception ee)
	{
	//	out.println("Exception From Chart Recording Intermediate JSP :"+ee.toString());//COMMON-ICN-0181
                   ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)
					ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
<script>
		if(parent.ChartRecordingCriteriaFrame != null)
		{
			parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.splChartType.value = '<%=splChartType%>';			
			
			parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.DEFINE_MODIFIABLE_AT_TRN_YN.value  = '<%=DEFINE_MODIFIABLE_AT_TRN_YN%>';

			var systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;
			var parameterDate = minusDate(systemdate,"DMYHM",'<%=locale%>','<%=scope%>',"d");
        
			parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.fromDate.value  = parameterDate;
			parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.toDate.value  = systemdate;
	

			if('<%=modifyYN%>' == 'Y')
			{
				if('<%=splChartType%>' == 'GR')
				{
					parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonShowRec.style.display  = 'inline';
				}
				else
				{
					parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonShowRec.style.display  = 'none';
				}
			}
		}
	</script>
</html>

