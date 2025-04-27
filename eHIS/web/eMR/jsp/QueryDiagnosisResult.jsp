<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>

<head>
	
	<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script language='javascript' src='../../eMR/js/QueryDiagnosis.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8"); 
Connection con					=	null;
PreparedStatement pstmt			=	null;
//PreparedStatement pstmt1		=	null;

ResultSet rset					=	null;
//ResultSet rset1					=	null;

String patient_id				=	"";
String patient_name				=	"";
String date_of_birth			=	"";
String date_of_birth_display	=	"";
String gender					=	"";
String onset_date				=	"";
String onset_date_display		=	"";
String practitioner_name		=	"";
String Onset_Locn_Desc			=	"";
String status					=	"";
String sql =				"";
String class_value				=   "QRYEVEN";
StringBuffer whereclause = new StringBuffer("");
StringBuffer dateclause	= new StringBuffer("");
//String and_or_or = "";
int maxRecord			= 0;

//int count				= 0;

	String mr_diagnosis_code = request.getParameter("mr_diagnosis_code")==null?"":request.getParameter("mr_diagnosis_code");
//	String mr_diagnosis_desc = request.getParameter("mr_diagnosis_desc")==null?"":request.getParameter("mr_diagnosis_desc");
//	String mr_diagnosis_type = request.getParameter("mr_diagnosis_type")==null?"":request.getParameter("mr_diagnosis_type");
	String mr_display_active = request.getParameter("mr_display_active")==null?"":request.getParameter("mr_display_active");
	
	String mr_date_from = request.getParameter("mr_date_from")==null?"":request.getParameter("mr_date_from");
	String mr_date_to = request.getParameter("mr_date_to")==null?"":request.getParameter("mr_date_to");
	
try
{

	con	=	ConnectionManager.getConnection(request);

	if(!(mr_date_from == null  || mr_date_from.equals("")))
			{
				dateclause.append(" and  trunc(onset_date) >= to_date('"+mr_date_from+"','dd/mm/yyyy')");
				//and_or_or=" and ";
			}

	if(!(mr_date_to == null  || mr_date_to.equals("")))
		//dateclause.append(and_or_or+"  trunc(onset_date) <= to_date('"+mr_date_to+"','dd/mm/yyyy')   ");
		dateclause.append("  and trunc(onset_date) <= to_date('"+mr_date_to+"','dd/mm/yyyy')   ");




	/*
		Added On :11/30/2010 For:IN025311
		Reason:mr_diagnosis_type is not applicable for 10.x i.e the criteria was commented ,In criteria page(QueryDiagnosisCriteria.jsp) also the drop down list of Diagnosis Type also removed.
	if (!mr_diagnosis_type.equals("")){
		whereclause.append("and a.diag_type = '"+mr_diagnosis_type+"' ");   
		
	}*/
	/*if (!mr_display_active.equals(""))
	{
		whereclause.append("and a.problem_status = 'A' ");   
		
	}*/

	/*String sql_count = "select count(*) count from pr_problem_vw a, mp_patient b where a.patient_id = b.patient_id and a.diag_code = ? "+whereclause.toString()+" "+dateclause.toString()+" ";

	
		
	
	pstmt	=	con.prepareStatement(sql_count);
	
	pstmt.setString(1,mr_diagnosis_code);
	
	rset	=	pstmt.executeQuery();
	if ((rset != null) && (rset.next()))
	{
		count = rset.getInt("count");	

	}
	if (count==0)
	{*/
	%>
		<!--<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		</script>-->
	<%/*
		return;
	}
	else 
	{*/%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="QRY_RESULT_DIAG_FROM" id="QRY_RESULT_DIAG_FROM">
	<table cellpadding="0" cellspacing="0" border="1" width="100%">
	<!--<tr>
		<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="eMR.OnsetLocation.label" bundle="${mr_labels}"/></th>
		<th nowrap><fmt:message key="eMR.OnsetPractitioner.label" bundle="${mr_labels}"/></th>
		<th nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
	</tr>-->
	


	<%
			//if (pstmt!=null) pstmt=null;
			//if (rset!=null) rset=null;
		if (mr_display_active.equals("")){
			//sql = "select A.Patient_ID, B.Patient_Name, to_char(B.Date_of_Birth, 'dd/mm/yyyy') Date_of_Birth,	Decode(B.SEX,'M','Male','F','Female','U','Unknown')gender, A.Onset_Locn_Desc, A.Onset_Practitioner_Name, to_char(a.onset_date, 'dd/mm/yyyy')onset_date,Decode(A.Problem_Status,'A','Active','C','Closed','W','Worse','S','Same')status from pr_problem_vw a, mp_patient b where a.patient_id=b.patient_id and a.diag_code = ? "+dateclause.toString()+"";
			sql ="select A.Patient_ID, decode('"+localeName+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang,b.patient_name)) Patient_Name, to_char(B.Date_of_Birth, 'dd/mm/yyyy') Date_of_Birth,	B.SEX gender, DECODE (A.ONSET_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(ONSET_FACILITY_ID,ONSET_LOCN_CODE,'"+localeName+"','2'), OP_GET_DESC.OP_CLINIC(ONSET_FACILITY_ID,ONSET_LOCN_CODE,'"+localeName+"','2')) Onset_Locn_Desc, AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+localeName+"','1')Onset_Practitioner_Name, to_char(a.onset_date, 'dd/mm/yyyy')onset_date, A.Curr_Status status from pr_diagnosis a, mp_patient b where a.patient_id=b.patient_id and a.term_code = ? "+dateclause.toString()+"";
		}else if (!mr_display_active.equals("")){
		//sql = "select A.Patient_ID, B.Patient_Name, to_char(B.Date_of_Birth, 'dd/mm/yyyy') Date_of_Birth,	Decode(B.SEX,'M','Male','F','Female','U','Unknown')gender, A.Onset_Locn_Desc, A.Onset_Practitioner_Name, to_char(a.onset_date, 'dd/mm/yyyy')onset_date,Decode(A.Problem_Status,'A','Active','C','Closed','W','Worse','S','Same')status from pr_problem_vw a, mp_patient b where a.patient_id=b.patient_id and a.diag_code = ?  and a.diag_type = ? and a.problem_status = 'A' "+dateclause.toString()+" ";	
		sql = "select A.Patient_ID, decode('"+localeName+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang,b.patient_name)) Patient_Name, to_char(B.Date_of_Birth, 'dd/mm/yyyy') Date_of_Birth,	B.SEX gender, DECODE(A.ONSET_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(ONSET_FACILITY_ID,ONSET_LOCN_CODE,'"+localeName+"','2'), OP_GET_DESC.OP_CLINIC(ONSET_FACILITY_ID,ONSET_LOCN_CODE,'"+localeName+"','2')) Onset_Locn_Desc, AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+localeName+"','1')Onset_Practitioner_Name, to_char(a.onset_date, 'dd/mm/yyyy')onset_date,A.Curr_Status status from pr_diagnosis a, mp_patient b where a.patient_id=b.patient_id and a.term_code = ? and a.Curr_Status = 'A' "+dateclause.toString()+" ";	
		}
	//	out.println("sql--->"+sql);
	pstmt	=	con.prepareStatement(sql);
	pstmt.setString(1,mr_diagnosis_code);
	/*if (!mr_diagnosis_type.equals("")) 
		{	
			pstmt.setString(2,mr_diagnosis_type);
		}*/
	rset	=	pstmt.executeQuery();
	if (rset != null){
		while(rset.next()){
			if(maxRecord==0){%>
				<tr>
				<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="eMR.OnsetLocation.label" bundle="${mr_labels}"/></th>
				<th nowrap><fmt:message key="eMR.OnsetPractitioner.label" bundle="${mr_labels}"/></th>
				<th nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
				</tr>
			<%}
			patient_id			= rset.getString("patient_id");
			patient_name		= rset.getString("patient_name");
			date_of_birth		= rset.getString("date_of_birth");
			Onset_Locn_Desc		= rset.getString("Onset_Locn_Desc");
			if(Onset_Locn_Desc==null)
				Onset_Locn_Desc = "";
			gender				= rset.getString("gender");
			onset_date			= rset.getString("onset_date");
			practitioner_name	= rset.getString("Onset_Practitioner_Name");
			status				= rset.getString("status");
			
			date_of_birth_display = DateUtils.convertDate(date_of_birth,"DMY","en",localeName);
			onset_date_display = DateUtils.convertDate(onset_date,"DMY","en",localeName);
			if(gender.equalsIgnoreCase("M"))
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(gender.equalsIgnoreCase("F"))
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(gender.equalsIgnoreCase("U"))
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			if(status.equalsIgnoreCase("A"))
				status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			else if(status.equalsIgnoreCase("B"))
				status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Better.label","ca_labels");
			else if(status.equalsIgnoreCase("C"))
				status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
			else if(status.equalsIgnoreCase("S"))
				status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Same.label","common_labels");
			else if(status.equalsIgnoreCase("W"))
				status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Worse.label","ca_labels");
			/*Added By Dharma on Feb 26th 2015 against HSA-SCF-0216 [IN:053371] Start*/
			else if(status.equalsIgnoreCase("E"))
				status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
			else if(status.equalsIgnoreCase("R"))
				status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
			else if(status.equalsIgnoreCase("X"))
				status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Revoked.label","common_labels");
			/*Added By Dharma on Feb 26th 2015 against HSA-SCF-0216 [IN:053371] End*/
			

			
			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			%>
			<tr>
				<td class="<%=class_value%>" nowrap>
				<a href="#call" onclick = "call_cafunction('<%=patient_id%>');"><%=patient_id%></a></td>
				<td class="<%=class_value%>" nowrap><%=patient_name%></td>
				<td class="<%=class_value%>" nowrap><%=date_of_birth_display%></td>
				<td class="<%=class_value%>" nowrap><%=gender%></td>
				<td class="<%=class_value%>" nowrap><%=onset_date_display%></td>
				<td class="<%=class_value%>" nowrap><%=Onset_Locn_Desc%></td>
				<td class="<%=class_value%>" nowrap><%=practitioner_name%></td>
				<td class="<%=class_value%>" nowrap><%=status%></td>
			</tr>
			<%
				maxRecord++;
		}
	}
			if (maxRecord==0)
			{
			%>
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
			<%
			}
	
%>
</table>
</form>
</body >
	
	<% //} %>
	<%
	}
	catch (Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally {
		try
		{
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		//if(pstmt1!=null) pstmt.close();
		//if(rset1!=null) rset.close();
		}
		catch (Exception e)
	{
		
	}
		ConnectionManager.returnConnection(con,request);
	}

%>

</head>
</html>


