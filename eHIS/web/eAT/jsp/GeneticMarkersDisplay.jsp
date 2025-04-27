<!DOCTYPE html>
<%@ page language="java" import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function ImmunizationDetails(){
		var queryString = "<%=request.getQueryString()%>";//document.refForm.queryString.value;
		var dialogHeight= "17" ;
		var dialogWidth	= "60" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;
		window.showModalDialog("../../eCA/jsp/Immunization.jsp?"+queryString,arguments,features);
		return false;
	}

	function researchPatient(){
		var queryString = "<%=request.getQueryString()%>";//document.refForm.queryString.value;
		var dialogHeight= "17" ;
		var dialogWidth	= "60" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;
		window.showModalDialog("../../eCA/jsp/ResearchPatient.jsp?"+queryString,arguments,features);
		return false;
	}

	function growthChart(chart_id,P_patient_id,sex){
		var queryString = "<%=request.getQueryString()%>";//document.refForm.queryString.value;
		var dialogHeight= "100" ;
		var dialogWidth	= "80" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;
		window.showModalDialog("../../eAT/jsp/ChartRecordingGroupGraphMain.jsp?splChartType=GR&chart_id="+chart_id+"&patient_id="+P_patient_id+"&Sex="+sex,arguments,features);
		return false;
	}
/*	function TriageDetail(){
		var queryString = "<%=request.getQueryString()%>";
		var dialogHeight= "26" ;
		var dialogWidth	= "60" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
		window.showModalDialog("../../eCA/jsp/TriageDetail.jsp?"+queryString,arguments,features);
		return false;
	}*/
	function TriageDetail(patient_id,encounter_id,visit_adm_date_time)
	{
	     var retVal = "";
			var function_id ="query";
			var dialogHeight= "32" ;
			var dialogWidth	= "50" ;
			var dialogTop ="58";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id="+patient_id+"&episode_id="+encounter_id+"&visit_adm_date_time="+visit_adm_date_time+"&function_id="+function_id;
			retVal = window.showModalDialog(action_url,arguments,features);
	}
	
</script>	
</head>

<body class='CONTENT'  OnMouseDown="CodeArrest()" onLoad="">
<form name='' id='' method=post target="messageFrame">
</form>
<%
	
	String P_patient_id = request.getParameter("patient_id");
	String sex = request.getParameter("Sex");
	String encounter_id = request.getParameter("encounter_id");
	if (encounter_id==null) encounter_id="";
	String visit_adm_date = request.getParameter("visit_adm_date");
	if (visit_adm_date==null) visit_adm_date="";
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	StringBuffer strBuff_display = new StringBuffer();
	strBuff_display.append("&nbsp;");
	//String display = "&nbsp;"; 
	String blood_grp ="";
	String rh_factor ="";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");



	String research_pat_sql ="";
	String display_mode = "";
	String triage_display_mode = "display:none";
	int count = 0 ;

	String grChSql ="";
	String chart_id ="";
	String grChart_display_mode = "display:none";

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null ;


	PreparedStatement res_pstmt=null;
	ResultSet res_rset=null ;
	if (patient_class.equals("EM") )
			triage_display_mode ="display:inline";
try
{
        con=ConnectionManager.getConnection(request);

		grChSql = "select CHART_ID from CA_SPL_CHART_PAT_REC_DTL where patient_id=? and rownum=1";
		res_pstmt=con.prepareStatement(grChSql);
		res_pstmt.setString(1,P_patient_id );

		res_rset=res_pstmt.executeQuery();

		while(res_rset.next())
		{
			chart_id = res_rset.getString("CHART_ID");
			grChart_display_mode = "display:inline";
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();	

		research_pat_sql = "SELECT COUNT(*) as total FROM CA_RESEARCH_PATIENT_DETAIL WHERE  PATIENT_ID=?";
		res_pstmt=con.prepareStatement(research_pat_sql);
		res_pstmt.setString(1,P_patient_id );

		res_rset=res_pstmt.executeQuery();

		while(res_rset.next())
		{
			count = res_rset.getInt("total");
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();
		
		if(count>0)
		  {
			display_mode="display:inline";
		  }
		  else
			{
			  display_mode="display:none";
		  }

		
		//String sql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A,     MR_RHESUS_FACTOR B, MR_BLOOD_GRP C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+)" ;

		String sql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A,     MR_RHESUS_FACTOR B, MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+) AND C.LANGUAGE_ID = ?" ;

		

		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, P_patient_id );
		pstmt.setString(2, locale );

		rset=pstmt.executeQuery();

		while(rset.next())
		{
			blood_grp = rset.getString("blood_grp")	;
			rh_factor = rset.getString("rh_factor")	;
			
			
		}

		String space =  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" ;
		
		if(blood_grp != null )
		{	
			strBuff_display.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+": <b>");
			strBuff_display.append(blood_grp);
			strBuff_display.append("</b>");
			
		}
		else
		{
			strBuff_display.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+": ");
			strBuff_display.append(space);
			
		}

		if(rh_factor != null )
		{
			strBuff_display.append("&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RhFactor.label","common_labels")+": <b>");
			strBuff_display.append(rh_factor);
			strBuff_display.append("</b>");
			
		}
		else
		{
			strBuff_display.append("&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RhFactor.label","common_labels")+": ");
			strBuff_display.append(space);
			
		}
		//strBuff_display=null;
		String strsql2="";
		PreparedStatement pstmt1=null;
		ResultSet rs=null ;
		int count1=0;

			try
			{
				strsql2		=	" select  count(*) noofRecords from mr_med_event_log a, mr_med_event_type b where patient_id = ? and a.MED_EVENT_TYPE_CODE=b.MED_EVENT_TYPE_CODE  ";
				pstmt1		=	con.prepareStatement(strsql2);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
						count1=rs.getInt("noofRecords");
				}
			}
			catch(Exception e)
			{		
					out.println("Error in GeneticMarketDisplay"+e.toString());
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
		%>

	<table  width='100%' style="" border=0 valign='top' CELLSPACING=0 CELLPADDING=3 align='center'>
     <tr>
        <td  width='40%' style='CAENCOUNTERLINE'><font size='-1' ><%=strBuff_display.toString()%></td>
<% 	if (count1>0){%>
		<td  width='10%' style='CAENCOUNTERLINE'  style="<%=display_mode%>"><a href='#' onClick='return ImmunizationDetails()'><font size='2'><fmt:message key="eCA.Immunization.label" bundle="${ca_labels}"/></font></a></td>
<%}%>
		<td width='10%' style=CAENCOUNTERLINE' style="<%=display_mode%>"><a href='#' onClick='return researchPatient()'><font size='2'><fmt:message key="eCA.ResearchInfo.label" bundle="${ca_labels}"/></font></a></td>
		<td  width='10%' style=CAENCOUNTERLINE' ALIGN='right' style="<%=grChart_display_mode%>"><a href='#' onClick="return growthChart('<%=chart_id%>','<%=P_patient_id%>','<%=sex%>')"><font size='2'><fmt:message key="eCA.GrowthChart.label" bundle="${ca_labels}"/></font>&nbsp;&nbsp;</font></a></td>
		
		<td  width='10%' style='CAENCOUNTERLINE'  style="<%=triage_display_mode%>"><a href='#' onClick="return TriageDetail('<%=P_patient_id%>','<%=encounter_id%>','<%=visit_adm_date%>')"><font size='2'><fmt:message key="eCA.TriageDetail.label" bundle="${ca_labels}"/></font></a></td>

		<td  width = '10%' style='CAENCOUNTERLINE' >
		<a href='javascript:refresh();'><font size='2'><U><fmt:message key="Common.Refresh.label" bundle="${common_labels}"/></U></font></a></td>
      </tr>
     </table>
<% 
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
		out.println(e.getMessage());
}
finally
{
		if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

