<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
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
%>

<link rel='styleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCA/html/CAHomeIeStyle.css'></link> -->
<script language=javascript src='../../eCA/js/CAMainMyTasks.js'></script>

</HEAD>
<BODY OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<!--<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
<STYLE TYPE="text/css">
	TABLE.HOMETAB 
	{
		width : 100%;
		border : 1;
		border-spacing : 0px;
		padding : 3px;
	}
</STYLE>
<form name="patientnewform" id="patientnewform">
<!-- <b><font color='red'>Common Tasks List</font></b> -->
<!--<table border='0' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
<tr><td  colspan='5' class='COMMONTOOLBARFUNCTION' style='border:0'><b><fmt:message key="Common.Patients.label" bundle="${common_labels}"/></b>
</td></tr>
</table> -->

<table cellspacing='0' cellpadding=3  border=1 width=100% align='center'> 
<% 
	Connection con = null;

	int count =0;
	int totCount = 0;
	String classValue = "WHITEROW";
	String order_category="";
	
	String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String) session.getValue("practitioner_type");
	String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" : (String)request.getParameter("practitioner_id");
	String Clin_id=(String)session.getValue("ca_practitioner_id");
	String facility_id=(String)session.getValue("facility_id");
	String sql1="";
	//String applicable_yn="";
	StringBuffer str = new StringBuffer();
	String comp_desc = "";
	int i = 0;
	try
	{
		
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	PreparedStatement pstmtComp = null;
	ResultSet rsComp = null;
		con=ConnectionManager.getConnection(request);
		String s1="";
		//s1="SELECT COMP_ID, NVL((SELECT 'Y' FROM ca_personalized_home_page WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID=CA_HOME_PAGE_COMP.COMP_ID  AND ROWNUM=1), 'N') applicable_yn FROM CA_HOME_PAGE_COMP where  COMP_ID in ('OUTPATIENT','EMPATIENTS' ,'INPATIENTS','DCPATIENTS','REFERRALRQ','CONSULTS')";

		s1="SELECT COMP_ID, (select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = A.COMP_ID) COMP_DESC FROM ca_personalized_home_page A WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID in ('OUTPATIENT','EMPATIENTS' ,'INPATIENTS','DCPATIENTS','REFERRALRQ','CONSULTS')";
	
		pstmtComp = con.prepareStatement(s1);
		pstmtComp.setString(1,pract_type);
		pstmtComp.setString(2,practitioner_id);
			
		rsComp = pstmtComp.executeQuery();
		while(rsComp.next())
		{
			i = i+1;
			//if ( i % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
			comp_desc = rsComp.getString("COMP_DESC");
			if(rsComp.getString("COMP_ID").equals("OUTPATIENT"))
			{
				//classValue = "CAQUERYODD";
			
			//referral 
			%>

			<%
			//Outpatients 
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="select count(*) from PR_ENCOUNTER Where facility_id =? and ATTEND_PRACTITIONER_ID = ? and VISIT_STATUS in ('01','02','03','04','05','06') and VISIT_ADM_DATE_TIME between trunc(sysdate) and trunc(sysdate)+1  and PATIENT_CLASS=? ";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,"OP");
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}

			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			%>
			<tr>
				<td class='<%=classValue%>' nowrap>
				<% if (totCount!=0) { %>
					<a class='gridLink'  href='javascript:callPatientList("OP");'><%=comp_desc%>(<%=totCount%>)
					</a>
				<% }else{%>
						<%=comp_desc%>(0) 
				<% } %>
				
				</td>
				</tr>
		<%
			}
			else if(rsComp.getString("COMP_ID").equals("EMPATIENTS"))
			{
				//classValue = "CAQUERYODD";
				
			//referral 
			
			%>

			<%
			//Outpatients 
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="select count(*) from PR_ENCOUNTER Where facility_id =? and ATTEND_PRACTITIONER_ID = ? and VISIT_STATUS in ('01','02','03','04','05','06') and VISIT_ADM_DATE_TIME between trunc(sysdate) and trunc(sysdate)+1  and PATIENT_CLASS=? ";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,"EM");
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}

			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			%>
			<tr>
				<td class='<%=classValue%>' nowrap>
				<% if (totCount!=0) { %>
					<a class='gridLink'  href='javascript:callPatientList("EM");'><%=comp_desc%>(<%=totCount%>)
					</a>
				<% }else{%>
						<%=comp_desc%>(0)
				<% } %>
				
				</td>
				</tr>

		<%
			}
			else if(rsComp.getString("COMP_ID").equals("INPATIENTS"))
			{
				//classValue = "CAQUERYEVEN";
				
		//Outpatients 
			
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="select count(*) from IP_OPEN_ENCOUNTER a Where a.facility_id =? AND  ATTEND_PRACTITIONER_ID=? AND PATIENT_CLASS=? AND ADT_STATUS IN ('00','01')";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,"IP");
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}

			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			%>
			<tr>
				<td class='<%=classValue%>' nowrap>
				<% if (totCount!=0) { %>
					<a class='gridLink'  href='javascript:callPatientList("IP");'><%=comp_desc%>(<%=totCount%>)</a>
				<% }else{%>
						<%=comp_desc%>(0) 
				<% } %>
				
				</td>
				</tr>
		<%
			}	else if(rsComp.getString("COMP_ID").equals("DCPATIENTS")){
				//classValue = "CAQUERYEVEN";
				
		//Outpatients 
			
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="select count(*) from IP_OPEN_ENCOUNTER a Where a.facility_id =? AND ATTEND_PRACTITIONER_ID=? AND PATIENT_CLASS=? AND ADT_STATUS IN ('00','01')";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,"DC");
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}
			%>
			<tr>
				<td class='<%=classValue%>' nowrap>
				<% if (totCount!=0) { %>
					<a class='gridLink'  href='javascript:callPatientList("DC");'><%=comp_desc%>(<%=totCount%>)</a>
				<% }else{%>
						<%=comp_desc%>(0) 
				<% } %>
				
				</td>
				</tr>
		<%
			}else if(rsComp.getString("COMP_ID").equals("REFERRALRQ")){
				//classValue = "CAQUERYEVEN";
				
		//Outpatients 
			
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="SELECT count(*) FROM ip_open_encounter a, pr_referral_register b WHERE a.facility_id = ? AND b.preferred_treatment_date <= SYSDATE AND b.bedside_referral_yn = 'Y' AND b.bedside_ref_seen_date IS NULL AND a.facility_id = b.from_facility_id AND a.encounter_id = b.from_encounter_id AND b.to_pract_id=? ORDER BY encounter_id, preferred_treatment_date ";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}
			%>
			<tr>
				<td class='<%=classValue%>' nowrap>
				<% if (totCount!=0) { %>
					<a class='gridLink' href='javascript:callReferralRequest("<%=practitioner_id%>");'><%=comp_desc%>(<%=totCount%>)</a>
				<% }else{%>
						<%=comp_desc%>(0)
				<% } %>
				
				</td>
				</tr>
		<%
			}
			else if(rsComp.getString("COMP_ID").equals("MEDREPREQ"))
			{
				//classValue = "CAQUERYODD";
				
					order_category="";
					str = new StringBuffer();
					count=0; totCount=0;
					sql1="select count(*) from mr_report_request_hdr where facility_id = ? and ( forwarded_pract_id = ? or forwarded_hod_cord_id = ?) and request_status in ('03','06','05')";

					pstmt=con.prepareStatement(sql1);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,Clin_id);
					pstmt.setString(3,Clin_id);
					rset=pstmt.executeQuery();
					if (rset!=null) str = new StringBuffer();
					while (rset.next())
					{
						totCount=rset.getInt(1);
					}
					%>
					<tr>
						<td class='<%=classValue%>' nowrap>
						<% if (totCount!=0) { %>
							<a class='gridLink' href='javascript:callReportRequest();'><%=comp_desc%>(<%=totCount%>)</a>
						<% }else{%>
								<%=comp_desc%>(0) 
						<% } %>
						
						</td>
						</tr>
				<%
			}
			else if(rsComp.getString("COMP_ID").equals("CONSULTS"))
			{
				//classValue = "CAQUERYODD";
				
					int totCountUnAsgn = 0;
					int totCountSelf = 0;
					String anchorObjStart = "";
					String anchorObjEnd = "";

					StringBuffer sqlUnAssigned = new StringBuffer("SELECT count(*)   FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID=?  and status='O' and TO_PRACT_ID IS NULL  and TO_SPECIALITY_CODE in (SELECT pRIMARY_SPECIALITY_CODE from am_practitioner where PRACTITIONER_ID=?  union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES  WHERE FACILITY_ID=? AND PRACTITIONER_ID=?)");

					pstmt=con.prepareStatement(sqlUnAssigned.toString());
					pstmt.setString(1,facility_id);
					pstmt.setString(2,Clin_id);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,Clin_id);

					rset=pstmt.executeQuery();

					while (rset.next())
					{
						totCountUnAsgn = rset.getInt(1);
					}

					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					sqlUnAssigned.setLength(0);

					sqlUnAssigned = new StringBuffer("SELECT count(*)   FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID=?  and status='O' and TO_PRACT_ID = ? and ((BEDSIDE_REFERRAL_YN='Y' AND BEDSIDE_REF_SEEN_DATE is null) OR BEDSIDE_REFERRAL_YN='N') ");

					pstmt=con.prepareStatement(sqlUnAssigned.toString());
					pstmt.setString(1,facility_id);
					pstmt.setString(2,Clin_id);
					rset=pstmt.executeQuery();

					while (rset.next())
					{
						totCountSelf = rset.getInt(1);
					}

					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					sqlUnAssigned.setLength(0);
				
				%>
					<tr>
						<td class='<%=classValue%>'>
								<b><%=comp_desc%></b>
						</td>
					</tr>
					<tr>
						<td class='<%=classValue%>'>
							
								<%
										if(totCountSelf != 0)
										{
											anchorObjStart = "<a  class='gridLink' href='javascript:callConsults(\"SE\");'>";
											anchorObjEnd = "</a>";
										}
										else
										{
											anchorObjStart = "";
											anchorObjEnd = "";
										}
								%>
							&nbsp;&nbsp;&nbsp;&nbsp;<%=anchorObjStart%><fmt:message key="Common.self.label" bundle="${ca_labels}"/> (<%=totCountSelf%>)<%=anchorObjEnd%>
							<%
									if(totCountUnAsgn != 0)
									{
										anchorObjStart = "<a class='gridLink' href='javascript:callConsults(\"SP\");'>";
										anchorObjEnd = "</a>";
									}
									else
									{
										anchorObjStart = "";
										anchorObjEnd = "";
									}
							%>
						&nbsp;&nbsp;<%=anchorObjStart%><fmt:message key="Common.speciality.label" bundle="${ca_labels}"/> (<%=totCountUnAsgn%>)<%=anchorObjEnd%>						
						</td>
					</tr>
				<%
				
			}
		}
		for(int j=i+1;j<=5;j++)
		{
			//if ( j % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		%>
			<tr>
				<td class='<%=classValue%>' >&nbsp;</td>
			</tr>
		<%
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();
		
	}
	catch(Exception e)
	{
		//out.println("Exception in CAHomePagePatientsNew.jsp: "+e.toString());//COMMON-ICN-0181
               e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>

</table>
<input type='hidden' name="queryString" id="queryString" value="<%=request.getQueryString()%>"></input>
<input type='hidden' name="pract_id" id="pract_id" value="<%=practitioner_id%>"></input>
<input type='hidden' name="facility_id" id="facility_id" value="<%=facility_id%>"></input>
<form>
</BODY>
</HTML>

