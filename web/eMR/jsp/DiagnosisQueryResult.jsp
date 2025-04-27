<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
/*
 Function Name	:	Diagnosis Recoding
 Developer		:	SRIDHAR R
 Created On		:	27 JULY 2004
 Function 		:   Used to define the result page of recode diagnosis
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
   // String facilityId		= (String) session.getValue("facility_id");

   
   
   
	String locale			= (String) session.getAttribute("LOCALE"); 
	String PatientId		= request.getParameter("PatientId");
    String Encounter_Id     = request.getParameter("Encounter_Id");
	
    //added forBru-HIMS-CRF-380 Start
	String facilityId	= request.getParameter("facility_id");
	if(facilityId==null)
		facilityId = (String) session.getValue("facility_id");
	//added forBru-HIMS-CRF-380 End
	int j=1;
	String call_function	= request.getParameter("call_function");	
    String scheme       ="";
    String scheme_desc  ="";
	String significant_yn = request.getParameter("significant_yn");
	if(significant_yn==null) significant_yn = "N";
    int k=1;
    int aname=2;
    String classValue = "";
	String diag_type="", temp="";

	String sql_1="select diag_code_scheme scheme,decode(diag_code_scheme,'1','ICD 10','2','ICD 9CM','5','READ')scheme_desc from mr_parameter";

%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src='../../eCommon/js/rowcolor.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function chkMax(Obj)
{
	if(Obj.value.length >75)
	{
		var error = getMessage('REMARKS_XCEED_2000_CHARS','MR');
		error	= error.replace('2000','75');
		alert(error)
		Obj.focus();
	}
}

function Proceed()
{
	var j = document.forms[0].NumRecords.value;
	var formFields ="";
	for(var m=1; m<j; m++)
	{
		formFields += (eval("document.forms[0].recodedCode"+m).name)+"/"+(eval("document.forms[0].recodedCode"+m).value)+"";
	}
		document.forms[0].formFields.value = formFields;

		document.forms[0].action="../../servlet/eMR.DiagnosisRecodeServlet";
		document.forms[0].submit();
}

function getDiagnosis(obj,j)	
{ 	
	var DiagCode = obj.value;
	if(DiagCode != '')
	{
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='diag_form' id='diag_form' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp?'><input type='hidden' name='DiagCode' id='DiagCode' value='"+DiagCode+"'><input type='hidden' name='j' id='j' value='"+j+"'><input type='hidden' name='Criteria' id='Criteria' value='getDiagnosis'></form></body></html>";
		parent.frames[2].document.write(HTMLVal)
		parent.frames[2].document.diag_form.submit();
	}
	else if(DiagCode == '')
	{
		eval(document.getElementById("Description"+j)).innerText="         ";
	}
}

async function show_window(j)
{
	var scheme = document.forms[0].scheme.value;
	var scheme_desc	= document.forms[0].scheme_desc.value;
	var Encounter_Id= document.forms[0].Encounter_Id.value;
	var p_auth_yn="N";

	if (scheme == 5)
	{
		var retVal = "test Value";
		var dialogHeight= "28vh" ;
		var dialogWidth = "43vw" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments   = "" ;
		retVal = await window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);

		var arr = new Array();
		arr = retVal.split("|");
		var stra = arr[0];
		var strc = arr[1];
		var strb = arr[2];

		eval("document.forms[0].recodedCode"+j).value=stra;
		eval("document.forms[0].Description"+j).value=strb;
	}

	if (scheme == 1 || scheme == 2)
	{
		var retVal =    new String();
		var dialogHeight= "27.22vh" ;
		var dialogWidth = "44vw" ;
		var status = "no";

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
		var cause_ind='';
		if(scheme=="2")
			cause_ind=document.forms[0].cause_ind.value

		retVal = await window.showModalDialog("PaintConsultationFrame.jsp?title="+scheme_desc+"&CodeList&p_diag_code="+scheme+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=",arguments,features);
		
		if (!(retVal == null))
		{
			var retdata;
			if(scheme=="2")
			{
				retdata	= retVal.split("/") ;
				retVal	= retdata[0];
			}

			eval("document.forms[0].recodedCode"+j).value=retVal;
		}
		eval("document.forms[0].recodedCode"+j).focus();
	}
}

srl_no_array = new Array();
var prev=1;
var i=0;
var prev1=0;
var j=0;

function refer(ro,numofcols)
{
	prev1	=ro.rowIndex
	for (var i=0;i<numofcols;i++)
	{
	document.forms[0].all.dataTable.rows[prev].cells[i].style.backgroundColor=ro.bgColor;
	}
	for (var i=0;i<numofcols;i++)
	{
		ro.cells(i).style.backgroundColor="#B2B6D7";
	}
	prev = ro.rowIndex ;
}

function RecodeDiagDetail(obj)
{
	var srl_no_val = obj.value;
	var pat_id = document.forms[0].PatientId.value;
	var Encounter_Id = document.forms[0].Encounter_Id.value;

	parent.frames[1].document.location.href ="../../eMR/jsp/DiagnosisQueryDetail.jsp?srl_no="+srl_no_val+"&patient_id="+pat_id+"&Encounter_Id="+Encounter_Id+" ";
}

function RecodeTransDetail(term_set,term_code,occur_srl_no)
{
	
	var call_function = 'TRANSMIT_NOTIFY_REP';
	//var srl_no_val = obj.value;
	var pat_id = document.forms[0].PatientId.value;
	var Encounter_Id = document.forms[0].Encounter_Id.value;
	var diag_code = document.forms[0].diag_code.value;
	var diag_code_scheme_desc = document.forms[0].diag_code_scheme_desc.value;
	var DIAG_CODE_SCHEME = document.forms[0].DIAG_CODE_SCHEME.value;
//alert(diag_code_scheme_desc);
	//parent.frames[1].document.location.href ="../../eMR/jsp/DiagnosisTransmissionDetails.jsp?srl_no="+srl_no_val+"&patient_id="+pat_id+"&diag_code="+diag_code+"&diag_code_scheme="+DIAG_CODE_SCHEME+"&diag_code_scheme_desc="+diag_code_scheme_desc+"&Encounter_Id="+Encounter_Id+"&call_function="+call_function+"&recorded_date="+obj2+" ";
	parent.frames[1].document.location.href ="../../eMR/jsp/DiagnosisTransmissionDetails.jsp?term_set_id="+term_set+"&term_code="+term_code+"&occur_srl_no="+occur_srl_no+"&patient_id="+pat_id+"&diag_code="+diag_code+"&diag_code_scheme="+DIAG_CODE_SCHEME+"&diag_code_scheme_desc="+diag_code_scheme_desc+"&Encounter_Id="+Encounter_Id+"&call_function="+call_function+" ";
}

function RecodeConfDetail(term_set,term_code,occur_srl_no)
{
	
	var call_function = 'CONF_TRANSMIT_NOTIFY_REP';
	
	//var srl_no_val = obj.value;
	var pat_id = document.forms[0].PatientId.value;
	var Encounter_Id = document.forms[0].Encounter_Id.value;
	var diag_code = document.forms[0].diag_code.value;
	var diag_code_scheme_desc = document.forms[0].diag_code_scheme_desc.value;
	var DIAG_CODE_SCHEME = document.forms[0].DIAG_CODE_SCHEME.value;

	//parent.frames[1].document.location.href ="../../eMR/jsp/DiagnosisTransmissionDetails.jsp?patient_id="+pat_id+"&diag_code="+diag_code+"&diag_code_scheme="+DIAG_CODE_SCHEME+"&diag_code_scheme_desc="+diag_code_scheme_desc+"&Encounter_Id="+Encounter_Id+"&call_function="+call_function+" ";
	parent.frames[1].document.location.href ="../../eMR/jsp/DiagnosisTransmissionDetails.jsp?term_set_id="+term_set+"&term_code="+term_code+"&occur_srl_no="+occur_srl_no+"&patient_id="+pat_id+"&diag_code="+diag_code+"&diag_code_scheme="+DIAG_CODE_SCHEME+"&diag_code_scheme_desc="+diag_code_scheme_desc+"&Encounter_Id="+Encounter_Id+"&call_function="+call_function+" ";
}


function scrollTitle()
{
  var y = parent.PatProblemQueryResult.document.body.scrollTop;

  if(y == 0){
	parent.PatProblemQueryResult.document.getElementById("divDataTitle").style.position = 'static';
	parent.PatProblemQueryResult.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.PatProblemQueryResult.document.getElementById("divDataTitle").style.position = 'relative';
	parent.PatProblemQueryResult.document.getElementById("divDataTitle").style.posTop  = y-2;
  }
}

function alignWidth()
{
	var totalRows =  parent.PatProblemQueryResult.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.PatProblemQueryResult.document.getElementById("dataTitleTable").rows(1).cells.length;
	for(var i=0;i<temp;i++) 
	{
	parent.PatProblemQueryResult.document.getElementById("dataTitleTable").rows(1).cells(i).width=parent.PatProblemQueryResult.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
	}
}

</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name='query_form' id='query_form' method='post' target='messageFrame' action='../../servlet/eMR.DiagnosisRecodeServlet'>
<%
        Connection conn 	= null; 
        PreparedStatement  pstmt = null;
        ResultSet  rs		= null;
        Statement  stmt_1	= null;
        ResultSet  rs_1		= null;
		Statement  recode_count_stmt	= null;
        ResultSet  recode_count_rs		= null;
		Statement  recode_stmt	= null;

		int recode_count	= 0;
        int maxRecord 		= 0;
		String diag_code			= "";
		String diag_code_scheme_desc= "";
		String DIAG_CODE_SCHEME		= "";


/// Added by SRIDHAR R on 8 Oct 2004...
/// This will execute if the function is Diagnosis Recoding & will display the values to the user in the update mode.. if records already exists in mr_diag_recoding...
		String recodeCode			= "";
		String recodeDesc			= "";
		String remark				= "";
		String modified_date			= "";
		String modified_by_id			= "";

try
{
	conn = ConnectionManager.getConnection(request);
	
	if(call_function.equals("DIAG_RECODE"))
	{
		/*String recode_count_sql = " SELECT COUNT (*) FROM mr_diag_recoding WHERE onset_facility_id = '"+facilityId+"' AND onset_encounter_id = '"+Encounter_Id+"' ";*/
	/*Below line added for this SCF ML-MMOH-SCF-0360*/
	String recode_count_sql = " SELECT COUNT (*) FROM mr_diagnosis_recoding_dtl WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+Encounter_Id+"'";
		
		recode_count_stmt	= conn.createStatement();
		recode_count_rs		= recode_count_stmt.executeQuery(recode_count_sql);
		if(recode_count_rs.next())
		{
			recode_count = recode_count_rs.getInt(1);
		}
	}
%>

<!-- 	<table border="1" width='125%' id='dataTitleTable' cellpadding='0' cellspacing='0' align='center' >
		<tr>
			<th nowrap align='center' >Onset Date</th>
			<th nowrap align='center' >Code</th>
			<th nowrap align='center' width='25%'>Diagnosis</th>
			<th nowrap	align='center' >Scheme</th>
			<th nowrap align='center' >Primary</th>
			<th nowrap align='center' >Significant</th>
			<th nowrap align='center' >Re-coded Code</th>	
			<th nowrap align='center' width='25%'>Re-coded Diagnosis</th>
			<th nowrap align='center' width='25%'>Remarks</th>
			<th nowrap align='center' >Recorded By</th>
			<th nowrap align='center' >Recorded Date</th>
		</tr> -->
<%
/*
		if(recode_rs != null)
		{
			while(recode_rs.next())
			{
				n++;
				if ( n%2 == 0 )
					classValue = "QRYEVENSMALL" ;
				else
					classValue = "QRYODDSMALL" ;

				groupby_diagtype = checkForNull(recode_rs.getString("diagtype"));

				onsetDate = checkForNull(recode_rs.getString("onset_date"));
				origCode = checkForNull(recode_rs.getString("orig_diag_code"));
				origDesc = checkForNull(recode_rs.getString("DIAG_DESC"));
				OrgScheme = checkForNull(recode_rs.getString("orig_diag_code_scheme"));
				primary = recode_rs.getString("primary_yn");
					if(primary == null) primary = "N";
				significant = recode_rs.getString("significant_yn");
					if(significant == null) significant = "N";
				recodeCode = checkForNull(recode_rs.getString("recoded_diag_code"));
				recodeDesc = checkForNull(recode_rs.getString("recoded_diag_desc"));
				remark = checkForNull(recode_rs.getString("recoded_remarks"));
				recordedby = checkForNull(recode_rs.getString("onset_practitioner_id"));
				recordedDate = checkForNull(recode_rs.getString("onset_date"));

				if((!(groupby_diagtype.equals(new_groupby_diagtype))))
				{
					out.println("<tr><td colspan='14' class='CAGROUPHEADING'>"+groupby_diagtype+"</td></tr>");
				} 
				new_groupby_diagtype = groupby_diagtype;

			out.println(" <tr> ");
			out.println(" <td align='center' class='"+classValue+"'>"+onsetDate+"</td> ");
			out.println(" <td class='"+classValue+"'>"+origCode+"</td> ");
			out.println(" <td wrap class='"+classValue+"'>"+origDesc+"</td> ");
			out.println(" <td align='center' class='"+classValue+"'>"+OrgScheme+"</td> ");

			if(primary.equals("Y"))
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");

			if(significant.equals("Y"))
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
			
			out.println(" <td nowrap class='"+classValue+"'>"+recodeCode+"</td> ");
			out.println(" <td wrap class='"+classValue+"'>"+recodeDesc+"</td> ");
			out.println(" <td wrap class='"+classValue+"'>"+remark+"</td> ");
			out.println(" <td nowrap class='"+classValue+"'>"+recordedby+"</td> ");
			out.println(" <td align='center' nowrap class='"+classValue+"'>"+recordedDate+"</td> ");
			out.println(" </tr> ");
		
			}
		}
	}  /// End of addition ...
	else if(recode_count == 0)
	{
*/		
	
		if(recode_count_stmt!=null)	recode_count_stmt.close();
		if(recode_count_rs!=null)	recode_count_rs.close();
		
		stmt_1=conn.createStatement();
		rs_1=stmt_1.executeQuery(sql_1);
		if(rs_1.next())
		{
			scheme      = rs_1.getString("scheme");
			scheme_desc = rs_1.getString("scheme_desc");
		}

		if(rs_1 !=null) rs_1.close();
		if(stmt_1!=null) stmt_1.close();

		StringBuffer strsql = new StringBuffer();
		if (call_function.equals("VIEW_ENCOUNTER_DTLS")){
			strsql.append("select count(1) from pr_diagnosis_enc_dtl a, mr_term_code b where a.patient_Id = ? and a.encounter_id = ?  AND a.facility_id=? AND a.term_set_id=b.term_set_id AND a.term_code=b.term_code and a.status ='A'  ");
		}else{
			strsql.append("select count(1) from pr_diagnosis_enc_dtl a, mr_term_code b where a.patient_Id = ? and a.encounter_id = ?  AND a.facility_id=? AND a.term_set_id=b.term_set_id AND a.term_code=b.term_code and a.status ='A'  and b.NOTIFIABLE_YN = 'Y'");
		}
		if (call_function.equals("TRANSMIT_NOTIFY_REP") || call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
			strsql.append(" and NOTIFIABLE_YN = 'Y' ");
		}

		pstmt	=	conn.prepareStatement(strsql.toString());
		pstmt.setString(1,PatientId);
		pstmt.setString(2,Encounter_Id);
		pstmt.setString(3,facilityId);
		rs = pstmt.executeQuery();
		if(rs.next()){
		  maxRecord = rs.getInt(1);
		}
		if (maxRecord==0){			
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.window.close();</script>");
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		String sql = "";
		if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
		{
			
			//sql="select DIAG_CODE_SCHEME,srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc,ONSET_PRACTITIONER_NAME, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc, to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date, close_practitioner_name, close_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null  ";
			
			//sql="select DIAG_CODE_SCHEME,srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc,			AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME,significant_yn, diag_type diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc, to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date, AM_GET_DESC.AM_PRACTITIONER(CLOSE_PRACTITIONER_ID,'"+locale+"','1') close_practitioner_name, close_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null "; 




			//sql="select DIAG_CODE_SCHEME, srl_no, to_char(onset_date,'dd/mm/yyyy') onset_date1, sensitive_yn,diag_desc, diag_code, DECODE(DIAG_CODE_SCHEME,'1', 'ICD10','2', 'ICD9-CM','5','READ') DIAG_CODE_SCHEME_DESC ,AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag,diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date,AM_GET_DESC.AM_PRACTITIONER(CLOSE_PRACTITIONER_ID,'"+locale+"','1') close_practitioner_name,close_date from pr_problem where patient_Id = ? and onset_facility_id = '"+facilityId+"' and onset_encounter_id = ?  and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null ";

			/*sql = "SELECT   term_set_id, occur_srl_no,TO_CHAR (onset_date, 'dd/mm/yyyy') onset_date, am_get_desc.am_practitioner (onset_practitioner_id, '"+locale+"','1' ) onset_practitioner_name,term_code diag_code,term_code_short_desc diag_desc FROM pr_diagnosis WHERE patient_id = ? AND onset_facility_id = '"+facilityId+"' AND onset_encounter_id = ? AND term_set_id LIKE '%' AND curr_status !=  'E' ORDER BY onset_date DESC ";*/
			
			/*Below Query Modified for this SCF ML-MMOH-SCF-0360. The pr_diagnosis_enc_dtl table was replaced instead of PR_DIAGNOSIS*/
			
			sql = "SELECT   term_set_id, occur_srl_no,TO_CHAR (RECORDED_DATE_TIME, 'dd/mm/yyyy') onset_date, am_get_desc.am_practitioner (practitioner_id, '"+locale+"','1' ) onset_practitioner_name,term_code diag_code,term_code_short_desc diag_desc FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND facility_id = '"+facilityId+"' AND encounter_id = ? AND term_set_id LIKE '%' AND status != 'E' ORDER BY onset_date DESC ";

		}
		else if(recode_count == 0)
		{
			
			//sql="select DIAG_CODE_SCHEME,srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc,ONSET_PRACTITIONER_NAME, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null  ";

			//sql="select DIAG_CODE_SCHEME, srl_no, to_char(onset_date,'dd/mm/yyyy')onset_date1, sensitive_yn,diag_desc, diag_code,diag_code_scheme_desc, AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME, significant_yn, diag_type diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null  ";


			/*sql="select DIAG_CODE_SCHEME, srl_no, to_char(onset_date,'dd/mm/yyyy') onset_date1, sensitive_yn, diag_desc, diag_code, DECODE(DIAG_CODE_SCHEME,'1', 'ICD10','2', 'ICD9-CM','5','READ') DIAG_CODE_SCHEME_DESC , AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') onset_practitioner_name, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc, to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem where patient_Id = ? and onset_facility_id = '"+facilityId+"' and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null";*/
			if(call_function.equals("TRANSMIT_NOTIFY_REP")||call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){

//			sql="SELECT C.TERM_SET_ID,D.TERM_SET_DESC,C.TERM_CODE, C.SHORT_DESC, TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE1, decode(C.NOTIFIABLE_YN,'Y','Yes','N','No') NOTIFIABLE_YN, AM_GET_DESC.AM_PRACTITIONER (A.ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME,decode(B.NATURE,'A','Actual','P','Potential','W','Wellness')  nature,decode(B.PRIORITY,'N','Normal','H','High','C','Critical') priority , mr_get_desc.mr_accuracy(B.ACCURACY_CODE,'"+locale+"','2') accuracy_short_desc,decode(B.CAUSE_OF_DEATH_YN,'Y','Yes','N','No') CAUSE_OF_DEATH_YN,AM_GET_DESC.AM_PRACTITIONER(B.PRACTITIONER_ID,'"+locale+"','1') RECORDED_BY,to_char( B.RECORDED_DATE_TIME,'dd/mm/yyyy')  RECORDED_DATE, A.OCCUR_SRL_NO FROM PR_DIAGNOSIS A, PR_DIAGNOSIS_ENC_DTL B, MR_TERM_CODE C,MR_TERM_SET D WHERE B.FACILITY_ID = '"+facilityId+"' AND B.ENCOUNTER_ID = '"+Encounter_Id+"' AND A.PATIENT_ID = B.PATIENT_ID AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE AND A.TERM_SET_ID = C.TERM_SET_ID AND A.TERM_CODE = C.TERM_CODE AND C.TERM_SET_ID = D.TERM_SET_ID";
			sql="SELECT C.TERM_SET_ID,D.TERM_SET_DESC,C.TERM_CODE, C.SHORT_DESC, TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE1, decode(C.NOTIFIABLE_YN,'Y','Yes','N','No') NOTIFIABLE_YN, AM_GET_DESC.AM_PRACTITIONER (A.ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME,decode(B.NATURE,'A','Actual','P','Potential','W','Wellness')  nature,decode(B.PRIORITY,'N','Normal','H','High','C','Critical') priority , mr_get_desc.mr_accuracy(B.ACCURACY_CODE,'"+locale+"','2') accuracy_short_desc,AM_GET_DESC.AM_PRACTITIONER(B.PRACTITIONER_ID,'"+locale+"','1') RECORDED_BY,to_char( B.RECORDED_DATE_TIME,'dd/mm/yyyy')  RECORDED_DATE, A.OCCUR_SRL_NO,E.SEQ_NO FROM PR_DIAGNOSIS A, PR_DIAGNOSIS_ENC_DTL B, MR_TERM_CODE C,MR_TERM_SET D,MR_DEATH_REGISTER_DIAG_DTL E WHERE B.FACILITY_ID = '"+facilityId+"' AND B.ENCOUNTER_ID = '"+Encounter_Id+"' AND A.PATIENT_ID = B.PATIENT_ID AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE AND A.TERM_SET_ID = C.TERM_SET_ID AND A.TERM_CODE = C.TERM_CODE AND C.TERM_SET_ID = D.TERM_SET_ID AND B.PATIENT_ID=E.PATIENT_ID (+) AND B.TERM_CODE=E.TERM_CODE (+) AND B.TERM_SET_ID=E.TERM_SET_ID (+)";
			}else{
				sql="select DIAG_CODE_SCHEME, srl_no, to_char(onset_date,'dd/mm/yyyy') onset_date1, sensitive_yn, diag_desc, diag_code, DECODE(DIAG_CODE_SCHEME,'1', 'ICD10','2', 'ICD9-CM','5','READ') DIAG_CODE_SCHEME_DESC , AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') onset_practitioner_name, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc, to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem where patient_Id = ? and onset_facility_id = '"+facilityId+"' and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null";
			}
		}
		

	/*if(/*call_function.equals("TRANSMIT_NOTIFY_REP") || call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{
		sql = sql + " and NOTIFIABLE_YN = 'Y' ";
	}
	*/
	if(recode_count == 0&!call_function.equals("TRANSMIT_NOTIFY_REP")&&!call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{
		//sql = sql + " order by diagtype, onset_date desc ";
	}
	if(recode_count == 0)
	{
		
		pstmt	=	conn.prepareStatement(sql);
		if(!call_function.equals("TRANSMIT_NOTIFY_REP")&&!call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
		pstmt.setString(1,PatientId);
		pstmt.setString(2,Encounter_Id);
		}

		rs = pstmt.executeQuery();
	}

	if(recode_count > 0)
	{
		
		//String recode_sql = " SELECT a.modified_by_id, TO_CHAR (a.modified_date, 'dd/mm/yyyy') modified_date, decode(b.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, TO_CHAR (b.onset_date, 'dd/mm/yyyy') onset_date1, b.DIAG_DESC diag_desc, a.orig_diag_code, b.diag_code diag_code, a.orig_diag_code_scheme DIAG_CODE_SCHEME, b.primary_yn, b.significant_yn significant_yn, TO_CHAR(b.onset_recorded_date, 'dd/mm/yyyy') onset_recorded_date, b.onset_practitioner_id ONSET_PRACTITIONER_NAME, a.recoded_diag_desc , a.recoded_diag_code, a.RECODED_REMARKS recoded_remarks, nvl(b.PRIMARY_YN,'N') primary_diag, b.diag_code||nvl2(b.cause_indicator,'/'||b.CAUSE_INDICATOR,null)diag_code_desc, b.diag_code_scheme_desc, b.srl_no srl_no, b.sensitive_yn sensitive_yn,a.TRN_SRL_NO FROM MR_DIAG_RECODING_VW a, PR_PROBLEM_VW b WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+Encounter_Id+"' AND a.patient_id = b.patient_id AND a.srl_no = b.srl_no ORDER BY b.diag_type " ;


		//String recode_sql = "SELECT a.modified_by_id, TO_CHAR (a.modified_date, 'dd/mm/yyyy') modified_date,b.diag_type diagtype,TO_CHAR (b.onset_date, 'dd/mm/yyyy') onset_date1, b.DIAG_DESC diag_desc,a.orig_diag_code, b.diag_code diag_code, a.orig_diag_code_scheme DIAG_CODE_SCHEME,b.primary_yn, b.significant_yn significant_yn, TO_CHAR(b.onset_recorded_date, 'dd/mm/yyyy') onset_recorded_date, AM_GET_DESC.AM_PRACTITIONER(B.ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME,a.recoded_diag_desc , a.recoded_diag_code, a.RECODED_REMARKS recoded_remarks,nvl(b.PRIMARY_YN,'N') primary_diag,b.diag_code||nvl2(b.cause_indicator,'/'||b.CAUSE_INDICATOR,null)diag_code_desc, b.diag_code_scheme_desc, b.srl_no srl_no,b.sensitive_yn sensitive_yn, a.TRN_SRL_NO FROM MR_DIAG_RECODING_VW a, PR_PROBLEM_VW b WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+Encounter_Id+"' AND a.patient_id = b.patient_id AND a.srl_no = b.srl_no ORDER BY b.diag_type " ;


		String recode_sql = "select a.modified_by_id, TO_CHAR (a.modified_date, 'dd/mm/yyyy') modified_date,decode(b.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype,TO_CHAR (b.onset_date, 'dd/mm/yyyy') onset_date1, b.DIAG_DESC diag_desc,a.orig_diag_code, b.diag_code diag_code, a.orig_diag_code_scheme diag_code_scheme,b.primary_yn, b.significant_yn significant_yn, TO_CHAR(b.onset_recorded_date,'dd/mm/yyyy') onset_recorded_date, AM_GET_DESC.AM_PRACTITIONER(B.ONSET_PRACTITIONER_ID,'"+locale+"','1') onset_practitioner_name,b.diag_desc recoded_diag_desc, a.recoded_diag_code,a.REMARKS recoded_remarks, nvl(b.PRIMARY_YN,'N') primary_diag,b.diag_code||nvl2(b.cause_indicator,'/'||b.CAUSE_INDICATOR,null)diag_code_desc, diag_code_scheme diag_code_scheme_desc, b.srl_no srl_no, b.sensitive_yn sensitive_yn,a.TRN_SRL_NO FROM MR_DIAG_RECODING a, PR_PROBLEM b WHERE a.onset_facility_id = '"+facilityId+"' AND a.onset_encounter_id = '"+Encounter_Id+"' AND a.patient_id = b.patient_id AND  a.srl_no = b.srl_no ORDER BY b.diag_type";

		if(rs != null) rs.close();
		recode_stmt	= conn.createStatement();
		rs	= recode_stmt.executeQuery(recode_sql);
	}
	
%>
<center>
	<%	if (call_function.equals("DIAG_RECODE")){	%>
			<table border="0" width='125%' cellpadding='0' cellspacing='0' align='center'>
				<tr>
					<td colspan='4'><jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" /><jsp:param name="Patient_ID" value="<%=PatientId%>" /></jsp:include></td>
				</tr>
				<tr>
					<td colspan='4' class='label' height="5">&nbsp;</td>
				</tr>
				<tr>
					<td class="button"><input type="button" class='Button' name="Record" id="Record" title='Record' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="Proceed();" ></td>
					<td class="button"><input type="button" class='Button' name="Close" id="Close" title='Close' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="window.close();" ></td>
					<td class='white' width="95%" ></td>
				</tr>
				<tr>
					<td colspan='4' class='label' height="5"></td>
				</tr>
			</table>
	<%	}	%>
	<table border="1" width='125%' id='dataTitleTable' cellpadding='0' cellspacing='0' align='center'>

	<%	if(rs == null)
		{
            for (int x=0; x<6 ; x++)
            {
                if ( k%2 == 0 )
                    classValue = "QRYEVENSMALL" ;
                else
	                classValue = "QRYODDSMALL" ;
				
				%>
                <tr>
					<td class='<%=classValue%>'></td>
					<td class='<%=classValue%>'></td>
					<td class='<%=classValue%>'></td>
					<td class='<%=classValue%>'></td>
				</tr>
				<%
                k++;
            }
        }
        else
        {	%>


	<%	if(call_function.equals("DIAG_RECODE")){	%>	
			<th nowrap align='center'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
	<%	}else if(call_function.equals("TRANSMIT_NOTIFY_REP")||call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){	%>
			<th nowrap align='center'><fmt:message key="Common.TermSetID.label" bundle="${common_labels}"/></th>
			<th nowrap align='center'><fmt:message key="Common.TermSetDescription.label" bundle="${common_labels}"/> </th>
			<th nowrap align='center'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></th>
			<th nowrap align='center' width='30%'><fmt:message key="Common.ShortDesc.label"bundle="${common_labels}"/></th>
			<th nowrap align='center'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
			<th nowrap	align='center' ><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
			<th nowrap align='center' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
			<th nowrap align='center'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
			<th nowrap align='center'><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th nowrap align='center'><fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/> </th>
	<%}else{%>
			<th nowrap align='center'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
			<%}%>
			<%if(!call_function.equals("TRANSMIT_NOTIFY_REP")&!call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){	%>
			<th nowrap align='center'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th nowrap align='center' width='30%'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
			<%}%>

		<%	if(!call_function.equals("DIAG_RECODE")&!call_function.equals("TRANSMIT_NOTIFY_REP")&&!call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
		{	%>
			<th nowrap	align='center' ><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></th>
			<th nowrap align='center' ><fmt:message key="Common.primary.label" bundle="${common_labels}"/></th>
			<th nowrap align='center'><fmt:message key="Common.significant.label" bundle="${common_labels}"/></th>
	<%	}	%>
			<th nowrap align='center'><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></th>
			<%
			if(call_function.equals("TRANSMIT_NOTIFY_REP")||call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){%>
			<th nowrap align='center'><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/></th>

	<%	
		}
		if (call_function.equals("DIAG_RECODE")){%>
			<th nowrap align='center'><fmt:message key="eMR.RecodedCode.label" bundle="${mr_labels}"/></th>
			<th nowrap align='center' width='30%'><fmt:message key="eMR.RecodedDiagnosis.label" bundle="${mr_labels}"/></th>
			<th nowrap align='center' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
			<th nowrap align='center' width='12%'><fmt:message key="eMR.RecodedBy.label" bundle="${mr_labels}"/></th>
			<th nowrap align='center' ><fmt:message key="eMR.RecodedDate.label" bundle="${mr_labels}"/></th>
	<%	}	%>
			
	<%	if (call_function.equals("VIEW_ENCOUNTER_DTLS")){	%>
			<!--<th nowrap align='center'><fmt:message key="eMR.ClosedBy.label" bundle="${mr_labels}"/></th>
			<th nowrap align='center'><fmt:message key="eMR.ClosedDate.label" bundle="${mr_labels}"/></th>-->
	<%	} %>
			

	<%	
		String onset_date		= "";
		String onset_date_display = "";
		String diag_desc		= "";
		String prim_diag		= "";
		String srl_no			= "";
		String sensitive_yn		= "";
		String Recorded_by		= "";
		//String closed_by		= "";
		//String closed_date		= "";
		//String closed_date_display = "";
		String recorded_date	= "";
		String recorded_date_display	= "";
		String trn_srl_no		="";
		String modified_date_display = ""; 
		String term_set      = ""; 
		while(rs.next())
		{
			if(!call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
			if(recode_count > 0)
			{
				modified_by_id = checkForNull(rs.getString("modified_by_id"));
				modified_date	= checkForNull(rs.getString("modified_date"));
				recodeCode	= checkForNull(rs.getString("recoded_diag_code"));
				recodeDesc	= checkForNull(rs.getString("recoded_diag_desc"));
				remark		= checkForNull(rs.getString("recoded_remarks"));
				trn_srl_no	=checkForNull(rs.getString("TRN_SRL_NO"));
			}
			if(!call_function.equals("VIEW_ENCOUNTER_DTLS"))
			{
			modified_date_display = DateUtils.convertDate(modified_date,"DMY","en",locale);
			DIAG_CODE_SCHEME	=	rs.getString("DIAG_CODE_SCHEME");
			onset_date		=	rs.getString("onset_date1");
			onset_date_display = DateUtils.convertDate(onset_date,"DMY","en",locale);
			Recorded_by		=	checkForNull(rs.getString("ONSET_PRACTITIONER_NAME"));
			recorded_date	=	checkForNull(rs.getString("onset_recorded_date"));
			recorded_date_display = DateUtils.convertDate(recorded_date,"DMY","en",locale);
			diag_desc		=	checkForNull(rs.getString("diag_desc"));
			diag_code		=	checkForNull(rs.getString("diag_code"));
			prim_diag		=	rs.getString("primary_diag");
			diag_type		=	rs.getString("diagtype");
				if(diag_type == null)	
					diag_type ="";
				else if(diag_type.equalsIgnoreCase("P"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
				else if(diag_type.equalsIgnoreCase("D"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
				else if(diag_type.equalsIgnoreCase("F"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");

			diag_code_scheme_desc=	rs.getString("diag_code_scheme_desc");
			srl_no 			= 	rs.getString("srl_no");
			
			sensitive_yn	=	rs.getString("sensitive_yn");

			significant_yn	=	rs.getString("significant_yn");	
			if(significant_yn==null)	significant_yn  = "N";
			if(diag_code==null)			diag_code		= "&nbsp;";
				if(sensitive_yn!=null)
				{
				   if(sensitive_yn.equals("Y"))
						classValue="PATQRED";
				}
				if(significant_yn.equals("Y"))
				{
					classValue="SIGNIFICANT";
				}
			}
			if(call_function.equals("VIEW_ENCOUNTER_DTLS"))
			{	
				onset_date		=	rs.getString("onset_date");
				onset_date_display = DateUtils.convertDate(onset_date,"DMY","en",locale);
				diag_code		=	checkForNull(rs.getString("diag_code"));
				diag_desc		=	checkForNull(rs.getString("diag_desc"));
				term_set		=	checkForNull(rs.getString("term_set_id"));
				Recorded_by		=	checkForNull(rs.getString("ONSET_PRACTITIONER_NAME"));
				//recorded_date	=	checkForNull(rs.getString("onset_recorded_date"));
				//recorded_date_display = DateUtils.convertDate(recorded_date,"DMY","en",locale);
			} 				
			
			
			if ((!(diag_type.equals(temp))))
			{
				if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
				{	%>
					<tr>
					<td colspan='14' class='CAGROUPHEADING' ><b><%=diag_type%></b></td>
					</tr>
			<%	}else 
				{	%>
					<tr>
						<td colspan='14' class='CAGROUPHEADING' ><b><%=diag_type%></b></td>
					</tr>
			<% } %>	
				<script>
				srl_no_array[i] = null;
				i++;
				</script>
				<%
			}
			temp=diag_type;

		if ( k%2 == 0 )
			classValue = "QRYEVENSMALL" ;
		 else
			classValue = "QRYODDSMALL" ;					


	if (call_function.equals("TRANSMIT_NOTIFY_REP"))
	{ 	%>
		<tr>
			<td class='<%=classValue%>'><%=onset_date_display%></td>
			<%	out.println("<td nowrap class='"+classValue+"'>" +diag_code+"</td>");	%>
			<td class='<%=classValue%>'><a name='<%=aname%>' href="javascript:RecodeTransDetail(document.forms[0].srl_no<%=k%>,'<%=recorded_date_display%>')">
<%	}
	else if (call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{
		out.println("<tr style='background-color:;'><td class='"+classValue+"'>"+onset_date_display+"</td>");
		out.println("<td nowrap class='"+classValue+"'>" +diag_code+"</td>");
		out.println("<td class='"+classValue+"'><a name='"+aname+"'  href='javascript:RecodeConfDetail(document.forms[0].srl_no"+k+")'>");
	}
	else if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
	{
		out.println("<tr style='background-color:;'><td class='"+classValue+"'>"+onset_date_display+"</td>");
		out.println("<td nowrap class='"+classValue+"'>" +diag_code+"</td>");
		out.println("<td class='"+classValue+"'>");
	}
	else
	{
		out.println("<tr style='background-color:;'><td class='"+classValue+"'>"+onset_date_display+"</td>");
		out.println("<td nowrap class='"+classValue+"'>" +diag_code+"</td><input type='hidden' name='OrgCode"+j+"' id='OrgCode"+j+"' value='"+diag_code+"' >");

		out.println("<td class='"+classValue+"' >");
	}

	if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
		out.println(diag_desc+"</td>");
	else
		out.println(diag_desc+"</a></td>");
	
	out.println("<input type='hidden' name='OrgDesc"+j+"' id='OrgDesc"+j+"' value='"+diag_desc+"' >");
	

	if(!call_function.equals("DIAG_RECODE"))
	{
		
		if(call_function.equals("VIEW_ENCOUNTER_DTLS"))
		out.println("<td nowrap class='"+classValue+"'>" +term_set+"</td>");
		else
		out.println("<td nowrap class='"+classValue+"'>" +diag_code_scheme_desc+"</td>");

		if(prim_diag.equals("Y"))
			out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
		else
			out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");

		if(significant_yn.equals("Y"))
			out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
		else
			out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
	}	


		out.println("<td nowrap class='"+classValue+"'>" +Recorded_by+"</td>");
		//out.println("<td nowrap class='"+classValue+"'>" +recorded_date_display+"</td>");

/// Added by Sridhar R on 6 OCT 2004..
	if(call_function.equals("DIAG_RECODE"))
	{	
		if(recode_count > 0)
		{
			diag_code = recodeCode;
			diag_desc = recodeDesc;
		}

		//	RECODE CODE
		
		out.println("<td class='"+classValue+"'><input type='text' size='10' maxlength='10' name='recodedCode"+j+"' id='recodedCode"+j+"' value='"+diag_code+"'  onblur='getDiagnosis(this,"+j+")'><input type='button' name='code_butt' id='code_butt' value='?' class='button' onClick=show_window("+j+") ></td><input type='hidden' name='trn_srl_no"+j+"' id='trn_srl_no"+j+"' value='"+trn_srl_no+"'>");

		//	RECODE DESC
		out.println("<td class='"+classValue+"' wrap id='Description"+j+"'>"+diag_desc+"</td><input type='hidden' name='reCodedDesc"+j+"' id='reCodedDesc"+j+"' value='"+diag_desc+"'>");

		//	REMARKS 
		out.println("<td class='"+classValue+"'><input type='text' size='20' maxlength='75' name='remarks"+j+"' id='remarks"+j+"' onblur=chkMax(this) value='"+remark+"'></td>");

		out.println("<td nowrap class='"+classValue+"'>" +modified_by_id+"</td>");
		out.println("<td nowrap class='"+classValue+"'>" +modified_date_display+"</td>");	
	
	}

// End of addition
	if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
	{
		//out.println("<td nowrap class='"+classValue+"'>" +closed_by+"</td>");
		//out.println("<td nowrap class='"+classValue+"'>" +closed_date_display+"</td>");
	}

	out.println("<input type='hidden' name='srl_no"+k+"' id='srl_no"+k+"' value='"+srl_no+"'></td>");
	out.println("</tr>");
		
		%>	<script>
				srl_no_array[i] = <%=srl_no%>
				i++;
			</script>
	<%		k++;
	        j++;
		}

		else
			{
			if ( k%2 == 0 ){
				classValue = "QRYEVENSMALL" ;
			}else{
				classValue = "QRYODDSMALL" ;
			}

			String term_set_id			= checkForNull(rs.getString("TERM_SET_ID"));
			String term_set_desc	= checkForNull(rs.getString("TERM_SET_DESC"));
			String term_code			= checkForNull(rs.getString("term_code"));
			String short_desc			= checkForNull(rs.getString("SHORT_DESC"));
			String onset_date1		= checkForNull(rs.getString("ONSET_DATE1"));
			String notifiable_yn		= checkForNull(rs.getString("NOTIFIABLE_YN"));
			String occur_srl_no		= checkForNull(rs.getString("OCCUR_SRL_NO"));
			String nature					= checkForNull(rs.getString("nature"));
			String priority				= checkForNull(rs.getString("priority"));		
			String accuracy_code	= checkForNull(rs.getString("accuracy_short_desc"));
//			String cause_of_death_yn=checkForNull(rs.getString("CAUSE_OF_DEATH_YN"));
			String recorded_by		= checkForNull(rs.getString("RECORDED_BY"));
			String recorded_date1	= checkForNull(rs.getString("RECORDED_DATE"));
			String seq_no				= checkForNull(rs.getString("SEQ_NO"));
			

			%>
			<tr>
			<td class='<%=classValue%>'><%=term_set_id%></td>
			<td class='<%=classValue%>'><%=term_set_desc%></td>
			<td class='<%=classValue%>'><%=term_code%></td>	
			<%
			if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
			{
			%>
				<td class='<%=classValue%>'> <a name='<%=aname%>' href="javascript:RecodeConfDetail('<%=term_set_id%>','<%=term_code%>','<%=occur_srl_no%>')"><%=short_desc%>
			</td>
			<%}else{
			%>
			<td class='<%=classValue%>'> <a name='<%=aname%>' href="javascript:RecodeTransDetail('<%=term_set_id%>','<%=term_code%>','<%=occur_srl_no%>')"><%=short_desc%>
			</td>
			<%}%>
			<td class='<%=classValue%>'><%=onset_date1%></td>
			<%

				if(notifiable_yn.equals("Yes"))
					out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
				else
					out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");		
			%>			
			
			<td class='<%=classValue%>'><%=nature%></td>
			<td class='<%=classValue%>'><%=priority%></td>
			<td class='<%=classValue%>'><%=accuracy_code%></td>

			<%
				if(seq_no.equals("1")){
					out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
			}else{
					out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
			}
				%>
			<td class='<%=classValue%>'><%=recorded_by%></td>
			<td class='<%=classValue%>'><%=recorded_date1%></td>
			</tr>
			<%
				out.println("<input type='hidden' name='srl_no"+k+"' id='srl_no"+k+"' value='"+srl_no+"'></td>");
				k++;
			}
		}
			if(rs!=null)    rs.close();
			if(recode_stmt != null) recode_stmt.close();
	  }
%>
<tr style='visibility:hidden'>
<th nowrap ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></th>
<th nowrap ><fmt:message key="Common.primary.label" bundle="${common_labels}"/></th>
</tr>
</table>
</center>

<input type="hidden" name="formFields" id="formFields" value="">
<input type="hidden" name="help_function_id" id="help_function_id" value="RECORD_DIAGNOSIS">
<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>">
<input type="hidden" name="PatientId" id="PatientId" value="<%=PatientId%>">
<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=Encounter_Id%>">
<input type="hidden" name="diag_code" id="diag_code" value="<%=diag_code%>">
<input type="hidden" name="diag_code_scheme_desc" id="diag_code_scheme_desc" value="<%=diag_code_scheme_desc%>">
<input type="hidden" name="DIAG_CODE_SCHEME" id="DIAG_CODE_SCHEME" value="<%=DIAG_CODE_SCHEME%>">

<input type="hidden" name="scheme" id="scheme" value="<%=scheme%>">
<input type="hidden" name="scheme_desc" id="scheme_desc" value="<%=scheme_desc%>">
<input type="hidden" name="NumRecords" id="NumRecords" value="<%=j%>">
<input type="hidden" name="recode_count" id="recode_count" value="<%=recode_count%>">

<%  
}catch(Exception e)
{
	//out.print("ERROR in DiagnosisQueryResult.jsp : "+e);
	e.printStackTrace();
}
finally
{
	if(pstmt!=null)  pstmt.close();
	ConnectionManager.returnConnection(conn, request);
}
%>
</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

