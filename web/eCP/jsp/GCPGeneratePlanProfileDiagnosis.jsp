<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
05/06/2024   60772      Twinkle Shah    05/06/2024	    Ramesh Goli      MMS-JU-SCF-0267
--------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>

<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	

<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
	<Script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
	
<SCRIPT LANGUAGE="JavaScript">
<!--
 var tmp_count = new Array();
var xx=0;
var term_code_arr		= new Array();
var termset_id_arr		= new Array();
var tmp_termset_id		= new Array();
var tmp_term_code		= new Array();
var tmp_man_yn			= new Array();

 function scrollTitle()
{
	var scrollXY = document.body.scrollTop;
	if(scrollXY == 0)
	{
		document.getElementById('DiagnosisTitle').style.position = 'static';
		document.getElementById('DiagnosisTitle').style.posTop  = 0;
	}else{
		document.getElementById('DiagnosisTitle').style.position = 'relative';
		document.getElementById('DiagnosisTitle').style.posTop  = scrollXY;
	}
}

//-->
</SCRIPT>
</head>
<%@page import="java.sql.*, java.io.*,java.util.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" Onload='' onscroll='scrollTitle()'>
<script language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="generate_diagnosis" id="generate_diagnosis"  method ='post' target='' action=''>
<div id='DiagnosisTitle' style='postion:relative'>	
<table border='1' cellspacing='0' cellpadding='0' width='100%' align='center'>
	<tr>
		<th colspan='7' align='left' class='PLANHEAD'><font size="1.5"><fmt:message key="eCP.SelectDiagnosistoGenerateCareplan.label" bundle="${cp_labels}"/></font></th>
	</tr>
	<tr>
		<th colspan='' align='left' class='PLANSUBHEAD' width='52.9%' height='1'><font size="1"><fmt:message key="eCP.EligibleDiagnosisforCarePlan.label" bundle="${cp_labels}"/></font></th>
		<th colspan='' class='PLANSUBHEAD' width='7.2%' height='1'><font size="1"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></font></th>
		<th colspan='' class='PLANSUBHEAD' width='8.2%' height='1'><font size="1"><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></font></th>
		<th colspan='' class='PLANSUBHEAD' width='5%' height='1'><font size="1"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></font></th>	
		<th colspan='' class='PLANSUBHEAD' width='9%' height='1'><font size="1"><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></font></th>
		<th colspan='' class='PLANSUBHEAD' width='2%' height='1'><font size="1"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></font></th> 
	</tr>
</table>
</div>
<%
//String p_called_from_ca		= (String)request.getParameter("p_called_from_ca ");
String patient_id			= (String)request.getParameter("patient_id");
String encounter_id			= (String)request.getParameter("episode_id");
String encounterId		= request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
//String facility_id			= (String) session.getAttribute("facility_id") == null?"" :(String) session.getAttribute("facility_id");

String patient_class			= (String)request.getParameter("patient_class");
//String case_type_code			= (String)request.getParameter("casetype_code");
if(patient_id ==null)
	patient_id = "";
if(encounter_id ==null)
	encounter_id = "";

Connection con = null;
PreparedStatement pstmt = null,pstmt1 = null;
ResultSet rs = null,rs1 = null;

String  classValue = "",priorValue="";
//String readOnly = "readOnly";
//String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
String sql = "",sql1 = "";
String term_set_id1="";String term_set_id ="";//String  term_code = "";
String checked="",disabled="";String Priority="",tmp_priority="";
String build_dc="",build_rs="";String factTree="";
int i=0;
try
{    
	//eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	
	con = ConnectionManager.getConnection(request);
//	sql = "SELECT A.OCCUR_SRL_NO, A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE, C.SHORT_DESC TERM_SHORT_DESC, DECODE(A.CURR_NATURE,'A' ,'Actual','P','Potential','W','Wellness') NATURE, A.CURR_ACCURACY_CODE, D.SHORT_DESC ACCURACY_SHORT_DESC, A.CURR_PRIORITY,  TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE_STR FROM PR_DIAGNOSIS A, MR_TERM_SET B, MR_TERM_CODE C, MR_ACCURACY D WHERE A.PATIENT_ID = ? AND A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B' ) AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE  =A.TERM_CODE AND D.ACCURACY_CODE=A.CURR_ACCURACY_CODE AND NOT EXISTS (SELECT 1 FROM PR_DIFFERENTIAL_DIAGNOSIS WHERE PATIENT_ID=A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE=A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO AND FINALIZED_YN='N') AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O' ) ORDER BY 2 ";
//	sql = "SELECT A.OCCUR_SRL_NO, A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE, C.SHORT_DESC TERM_SHORT_DESC, DECODE(A.CURR_NATURE,'A' ,'Actual','P','Potential','W','Wellness') NATURE, A.CURR_ACCURACY_CODE, D.SHORT_DESC ACCURACY_SHORT_DESC, A.CURR_PRIORITY,  TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE_STR FROM PR_DIAGNOSIS A, MR_TERM_SET B, MR_TERM_CODE C, MR_ACCURACY D WHERE A.PATIENT_ID = ? AND A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B' ) AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE  =A.TERM_CODE AND D.ACCURACY_CODE=A.CURR_ACCURACY_CODE AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O' ) ORDER BY 2 ";
	//sql = "SELECT A.OCCUR_SRL_NO, A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE, C.SHORT_DESC TERM_SHORT_DESC, A.CURR_NATURE NATURE, A.CURR_ACCURACY_CODE, D.SHORT_DESC ACCURACY_SHORT_DESC, A.CURR_PRIORITY,  TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE_STR FROM PR_DIAGNOSIS A, MR_TERM_SET B, MR_TERM_CODE C, MR_ACCURACY_LANG_VW D WHERE A.PATIENT_ID = ? AND A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B' ) AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE  =A.TERM_CODE AND D.ACCURACY_CODE=A.CURR_ACCURACY_CODE AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O' ) AND D.LANGUAGE_ID = ? ORDER BY 2 "; //60772
	sql = "SELECT A.OCCUR_SRL_NO, A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE, C.SHORT_DESC TERM_SHORT_DESC, A.CURR_NATURE NATURE, A.CURR_ACCURACY_CODE, D.SHORT_DESC ACCURACY_SHORT_DESC, A.CURR_PRIORITY,  TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE_STR , a.onset_encounter_id FROM PR_DIAGNOSIS A, MR_TERM_SET B, MR_TERM_CODE C, MR_ACCURACY_LANG_VW D WHERE A.PATIENT_ID = ? AND A.CURR_STATUS  ='A' AND  A.OCCUR_SRL_NO=( Select Max(e.occur_srl_no)  from pr_diagnosis e where e.TERM_SET_ID=a.term_set_id AND e.TERM_CODE=a.term_code AND e.patient_id = a.patient_id AND e.curr_status = a.curr_status) AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B' ) AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE  =A.TERM_CODE AND D.ACCURACY_CODE=A.CURR_ACCURACY_CODE AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O' ) AND D.LANGUAGE_ID = ? ORDER BY 2 ";  //60772

	sql1 = "SELECT A.FACTOR_CODE,  A.FACTOR_TYPE,  B.SHORT_DESC FACTOR_SHORT_DESC FROM PR_DIAGNOSIS_EVIDENCE A,MR_FACTOR B WHERE A.PATIENT_ID=? AND A.TERM_SET_ID=? AND A.TERM_CODE=? AND A.OCCUR_SRL_NO=? AND A.STATUS_SRL_NO=(SELECT MAX(STATUS_SRL_NO) FROM PR_DIAGNOSIS_EVIDENCE WHERE PATIENT_ID=A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE=A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO ) AND B.FACTOR_CODE=A.FACTOR_CODE ORDER BY  A.FACTOR_TYPE , B.SHORT_DESC ";

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, patient_id.trim());
	pstmt.setString(2, locale);

	rs = pstmt.executeQuery();

	pstmt1 = con.prepareStatement(sql1);
	
%>
	
<%
	while(rs.next())
	{	
		term_set_id =rs.getString(2);
		
		out.println("<script>termset_id_arr["+i+"]='"+rs.getString(2)+"';</script>");	
		out.println("<script>term_code_arr["+i+"]='"+rs.getString(4)+"';</script>");	
		if(!term_set_id.equals(term_set_id1)){

			%><table border='0' cellspacing='0' cellpadding='0' width='100%' align='center' >
				<tr>
					<td colspan='' class='CAGROUPHEADING' height='1%' width='2%' onClick='showTermCode(<%=i%>)' id='trmCode_tree<%=i%>' align='center'><font size="1" color='#6633FF'><B>--</B></font></td>
					<td colspan='7' class='CAGROUPHEADING' height='1%' width='99%'><font size="1" >&nbsp;<%out.println(rs.getString(3));%></font></td>
				</tr>
			</table> 
			<table border='0' cellspacing='0' cellpadding='0' width='100%' align='center' id='term_cd<%=i%>' style='display:inline' >
		<%
			term_set_id1=term_set_id;	
		}

		if ( i % 2 == 0 )
			classValue = "GRPEVEN" ;
		else
			classValue = "GRPEVEN" ;

		tmp_priority = rs.getString(9)== null?"":rs.getString(9);
		if(tmp_priority.equals("C")){
			priorValue	= "PRIORCRIC";
			//fontClass	= "CRITICAL";//PRIORCRIC
			Priority	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
		}else if(tmp_priority.equals("H")){
			priorValue	= "PRIORHIGH";
			//fontClass	= "CRITICALHIGH";//PRIORHIGH
			Priority	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
		}else if(tmp_priority.equals("N")){
			priorValue	= "PRIORNORM";
			//fontClass	= "NORMAL";//PRIORNORM
			Priority	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
		}else if(tmp_priority == "" ){
			priorValue	= "GRPEVEN";
			//fontClass	= "";
			Priority	= "&nbsp;";
		}
		
		
		pstmt1.setString(1, patient_id.trim());
		pstmt1.setString(2, rs.getString(2).trim());
		pstmt1.setString(3, rs.getString(4).trim());
		pstmt1.setInt(4, rs.getInt(1));
		rs1 = pstmt1.executeQuery();
		build_dc = "";build_rs="";
		while(rs1.next()){
			if(rs1.getString(2).equals("DC")){
				build_dc =build_dc + rs1.getString(3)+",";
			}else if(rs1.getString(2).equals("RS")){
				build_rs = build_rs +rs1.getString(3)+",";
			}
		}

		if(rs1 != null) rs1.close();

		if(!build_dc.equals(""))
			build_dc=build_dc.substring(0,build_dc.length()-1);
		if(!build_rs.equals(""))
			build_rs=build_rs.substring(0,build_rs.length()-1);
		if(!build_dc.equals("") || !build_rs.equals(""))
			factTree="+";
		else
			factTree="";
	%>	
		<tr >
			<td height='1%' width='2%' class='<%=classValue%>'  onClick='showFactor(<%=i%>)' id='factCode_tree<%=i%>' align='center'><font size="1" color='#6633FF'><B><%=factTree%></B></font></td>
			<td height='1'  width='52.9%'class='<%=classValue%>'><font size="1" color="" ><%=rs.getString(5)%></font></td>
			<%
				String tempNature="";
				if(rs.getString(6)==null)
				{
					tempNature="&nbsp;";
				}
				else
				{
					tempNature=rs.getString(6);
				}
				if(tempNature.equals("W"))
					tempNature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
				if(tempNature.equals("P"))
					tempNature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
				if(tempNature.equals("A"))
					tempNature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
			%>
			<td height='1'  width='7%' class='<%=classValue%>' align='left'><font size="1" color="" ><%out.println(tempNature);%></font></td>
			<td height='1'  width='8.2%' class='<%=classValue%>' align='left'><font size="1" color="" ><%out.println(rs.getString(8)==null?"&nbsp;":rs.getString(8));%></font></td>
			<td height='1'  width='4%' class='<%=priorValue%>' align='left'><font size="1" color="" ><%out.println(Priority);%></font></td>
			<td height='1'  width='9%' class='<%=classValue%>' align='center'><font size="1" color="" ><%out.println(rs.getString(10)==null?"&nbsp;":com.ehis.util.DateUtils.convertDate(rs.getString(10),"DMY","en",locale));%></font></td>
			<td height='1' width='3.8%' class='<%=classValue%>' align='center'><input type="checkbox" name='chk_diag<%=i%>' id='chk_diag<%=i%>' onClick='populateLibrary1(<%=i%>)' <%=disabled%> <%=checked%>></td>
		</tr>
		<input type ='hidden' name='termset_id<%=i%>' id='termset_id<%=i%>' value='<%=rs.getString(2)%>'>
		<input type ='hidden' name='term_code<%=i%>' id='term_code<%=i%>' value='<%=rs.getString(4)%>'>
		<input type ='hidden' name='term_code_desc<%=i%>' id='term_code_desc<%=i%>' value='<%=rs.getString(5)%>'>
		<input type ='hidden' name='encounterId<%=i%>' id='encounterId<%=i%>' value='<%=rs.getString(11)%>'>
	<%	if(!build_dc.equals("") || !build_rs.equals("")){ %>
			
		<tr>
			<td colspan='7' class='<%=classValue%>' >
				<table border='0' cellspacing='0' cellpadding='0' width='100%' align='center'  id='factor<%=i%>' style='display:none' >
					<tr>
						<td colspan='2' class='<%=classValue%>' width='3%'>&nbsp;</td>
						
						<td colspan='5' class='<%=classValue%>' width='70%'><font size="1" ><B><fmt:message key="eCP.AsEvidencedByFactors.label" bundle="${cp_labels}"/><font size="1" color='navy'>&nbsp;<%=build_dc%></font></B></td>
					</tr>
					<tr>
						<td colspan='4' class='<%=classValue%>' width='10%'>&nbsp;</td>
						<td class='<%=classValue%>' colspan='3' width='70%'><font size="1"><B><fmt:message key="eCP.DefiningCharacteristics.label" bundle="${cp_labels}"/>&nbsp;<font size="1" color='navy'><%=build_rs%></font></B></td>
					</tr>
					</table>
			</td>
		</tr>
	<%	}
	i++;	}	

	if(pstmt1 != null) pstmt1.close();
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

%>
</table>
<input type ='hidden' name='i' id='i' value='<%=i%>'>
<input type ='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
<input type ='hidden' name='queryStr' id='queryStr' value='<%=request.getQueryString()%>'>
<input type ='checkbox' name='chk_diag' id='chk_diag' style='display:none'>
</form>
<%
}
catch(Exception ee)
{
	//out.println("Exception in Diagnosis Profile "+ee.toString());//COMMON-ICN-0181
          ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	try{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
}

%>
</body>
</html>

