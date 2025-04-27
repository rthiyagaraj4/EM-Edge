<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
24/01/2012	  IN036001		Chowminya 	 Record Diagnosis in Thai language screen.Data lang not changed
06/08/2013	  IN041797		Chowminya 	 SKR-CRF-0020.1 - In Error legend included
25/11/2013	  IN045225		Chowminya    Record Diagnosis OTH Diagnosis desc should display the free text entered	
22/12/2014	  IN053120		Vijayakumar K	22/12/2014		Akbar 			ML-BRU-SCF-1519 [IN:053120]; 
30/01/2019	  IN069327		Prakash C   30/01/2019		Ramesh G 		ML-MMOH-CRF-1281.1
08/01/2020  	   IN071908           SIVABAGYAM M   08/01/2020       Ramesh G     ML-MMOH-SCF-1427
23/03/2023	   38981        Krishna Pranay   23/03/2023     Ramesh G     ML-MMOH-CRF-1986
30/03/2023     42995        Krishna Pranay   30/03/2023     Ramesh G    CA-ML-MMOH-CRF-1986
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection conn 	=	null;
	PreparedStatement stmt_in	=	null;
	PreparedStatement stmt1	=	null;
	PreparedStatement stmt2	=	null;
	PreparedStatement stmt3	=	null;
	PreparedStatement pstmt	=	null;
	ResultSet rs_in		=	null;
	ResultSet rs1		=	null;
	ResultSet rs2		=	null;
	ResultSet rs3		=	null;
	ResultSet res		=	null;
	PreparedStatement  pstmt_1 = null;
    ResultSet  rs_associatecodes = null;
	boolean isSiteSpecific=false;//IN069327
	boolean isDeceasedDiagClassDeathRegAppl = false; //Added by Jeyachitra - ML-MMOH-CRF 1742

try
{
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	conn 	=	ConnectionManager.getConnection(request);
	StringBuffer strBuff_sql = new StringBuffer();
	StringBuffer strsql_in = new StringBuffer();

	String facility_id= (String) session.getValue("facility_id");
	 isSiteSpecific = CommonBean.isSiteSpecific(conn, "MR","ALLOW_MULTI_DESC"); //IN069327
	 isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG"); //Added by Jeyachitra - ML-MMOH-CRF 1742

	int num_of_cols=4;
	//num_of_cols=num_of_cols;
	String diag_type="";
	int view_cnt = 0;
	//String occur_srl_no ="";checkstyle
	//String term_code_short_desc ="";checkstyle
	//String term_code			= ""; checkstyle

	int k=1;
	String prob_status	=	request.getParameter("probstatus");
	String sense_par	=	request.getParameter("pr");
	//String diagtype = request.getParameter("diag_type")==null?"": request.getParameter("diag_type");
	//****added for PH function usage
	String P_function_id=request.getParameter("P_function_id");
	

	//enchanced search
	String p_diag_code =request.getParameter("code")==null?"":request.getParameter("code");
	String encounter_id =request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	if (encounter_id.equals("0"))
			encounter_id="";
	String from_date =request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");

	from_date		=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date			=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
	//ends here

	String P_no_of_items=request.getParameter("P_no_of_items");
	if(P_no_of_items==null) P_no_of_items = "";
	String P_option_type=request.getParameter("P_option_type");
	String diag_stage="";
	//String orderBy=request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	//String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");

	String patientid	   = request.getParameter("Patient_Id");
	String context_value = request.getParameter("PQ");//request.getParameter("Context");
	if (context_value==null) context_value="Y";

	String modal_yn=request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String strOnsetDate = "";

	String term_set_id = request.getParameter("term_set_id");
	if (term_set_id==null) term_set_id="";
	//out.println("<script>alert('@@@ term_set_id="+term_set_id+"@@@@');</script>");
	String support_exisist_yn = ""; //42995
	String short_desc = "";

	String oh_accession_num="";
	String curr_enc_yn="";
	String curr_accuracy_ind="";
	String diag_desc="";
	//String prob_cnt="";
	int prob_cnt=0;
	String complaint_id="";
    String complaint_desc="";
    String onset_datetime="";
	String classValue = "" ;
        String curr_remarks="";//38981
	String complaint_id_lyr ="";
	String complaint_desc_lyr ="";
	String onset_datetime_lyr ="";
	int index=0;
	StringBuffer layer = new StringBuffer();
	String diag_code_disp ="";
	String linkviewcnt_sql = "";
	String short_desc1 = "";//IN045225

%>
<html>
<head>
<%
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- <modifeid by Arvind @03-12-2008> -->

		 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script type="text/javascript" src="../../eCA/js/ProblemList.js"></script>
		<script src='../js/rowcolor.js' language='javascript'></script>
		<script src='../../eMR/js/RecDiagnosis.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



      	<script>

		var srl_no_array = new Array();
		var term_set_id_array = new Array();
		var term_code_array = new Array();

		var detailArray = new Array();

		var prev=1;
		var i=0;
		var prev1=0;
		var j=0;
		var flag=false;
		
		function rfresh(obj)
		{
			var index = eval(obj-1);
			//alert(srl_no_array[prev1]);
		
			if("<%=modal_yn%>" == "Y"){
				//parent.problemsframe2.location.href="problemsframe2.jsp?&srl_no="+srl_no_array[prev1]+"&Patient_Id=<%=patientid%>"
				
				parent.problemsdetails.location.href="ProblemsDetails.jsp?&srl_no="+srl_no_array[index]+"&Patient_Id=<%=patientid%>&term_set_id="+term_set_id_array[index]+"&term_code="+term_code_array[index];
				parent.problemsassessments.location.href="ProblemsAssessment.jsp?&srl_no="+srl_no_array[index]+"&Patient_Id=<%=patientid%>&term_set_id="+term_set_id_array[index]+"&term_code="+term_code_array[index];
			}else{
				//top.content.workAreaFrame.problemsframe2.location.href="problemsframe2.jsp?&srl_no="+srl_no_array[prev1]+"&Patient_Id=<%=patientid%>"
			top.content.workAreaFrame.problemsdetails.location.href="ProblemsDetails.jsp?&srl_no="+srl_no_array[index]+"&Patient_Id=<%=patientid%>&term_set_id="+escape(term_set_id_array[index])+"&term_code="+term_code_array[index];

			top.content.workAreaFrame.problemsassessments.location.href="ProblemsAssessment.jsp?&srl_no="+srl_no_array[index]+"&Patient_Id=<%=patientid%>&term_set_id="+escape(term_set_id_array[index])+"&term_code="+term_code_array[index];
			}
			
		}

	/*function ShowSupportingDiag(associate_codes,title)
	{
		//alert(" ss "+associate_codes);
		var dialogHeight= "10" ;
		var dialogWidth = "35" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;

	window.showModalDialog("../../eCA/jsp/ShowSupportDiagCodeFrames.jsp?associate_codes="+escape(associate_codes)+"&title=" + title,"",features);
	}*/

		function refer(ro,numofcols)
		{
			//prev=ro.rowIndex;
			if(!flag)//checking for whether check box is clicked, as we need not to change the color
			{
				prev1	=ro.rowIndex

				for (var i=0;i<numofcols;i++)
				{
					document.getElementById("tb1").rows[prev].cells[i].style.backgroundColor=ro.bgColor;
				}

				for (var i=0;i<numofcols;i++)
					ro.cells[i].style.backgroundColor="#B2B6D7";

				prev	=ro.rowIndex
			}
			flag=false;
			//alert("retete "+prev);

		}
		function onCheck(obj)
		{
			
			flag=true;
			var count=0;
			var no_of_items = "<%=P_no_of_items%>";
			if(no_of_items==null) no_of_items = 0;
			for(i=1;i<=document.getElementById('tb1').rows.length;i++)
			{
				if(document.getElementById('ch'+i)!=null)
				{
					if(document.getElementById('ch'+i).checked==true)
					{
						count++;
					}
				}
			}
			if(count > no_of_items){
				var msg= getMessage("SEL_MAX_PROB_NA",'CA' );
				msg = msg.replace('$$',no_of_items );
				alert(msg);//yet to b added into messages
				obj.checked=false;
			}
		}

		function alignHeading()
{
	
	if(parent.problemsframe0.document.getElementById('th1') != null) 
	{
											
			parent.problemsframe0.document.getElementById('th1').width =	eval(document.getElementById('tb1').offsetWidth);
				
				for(j=0;j < document.getElementById('tb1').rows(0).cells.length; j++) 
				{
					
					var wid=eval(document.getElementById('tb1').rows(0).cells(j).offsetWidth);
										
					if(parent.problemsframe0.document.getElementById('th1').rows(0).cells(j) != null)
						{
						   parent.problemsframe0.document.getElementById('th1').rows(0).cells(j).width=wid;
						}
				}
	}
}


function callMouseOverDiag(obj,index)
	{
		var tabdata = '<table class="grid" cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/>&nbsp;</td><td class=columnHeadercenter nowrap>&nbsp;<fmt:message key="Common.Complaint.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp;</td><td class=columnHeadercenter nowrap>&nbsp;<fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/>&nbsp;</td></tr>';

			tabdata +=detailArray[index]+"</table>";
			document.getElementById('details').innerHTML = tabdata;

				var wdth 	  = obj.offsetWidth;
				var hght1 	  = obj.offsetHeight;

				var wdth1 = getPos(obj).x - wdth;
				var hght = getPos(obj).y + hght1;
				
				document.getElementById('details').style.posTop  = hght;
				document.getElementById('details').style.posLeft  = wdth1;
				document.getElementById('details').style.visibility = 'visible' ;
					

	}
	function callOnMouseOutDiag(obj)
	{
		document.getElementById('details').style.visibility='hidden' ;
	}

	function getPos(inputElement)
	{
		var coords =  new Object();
		coords.x = 0;
		coords.y = 0;
		try
		{
			targetElement = inputElement;
			if(targetElement.x && targetElement.y)
			{
				coords.x = targetElement.x;
				coords.y = targetElement.y;
			}
			else
			{
				if(targetElement.offsetParent)
				{
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
					while(targetElement = targetElement.offsetParent)
					{
						coords.x += targetElement.offsetLeft;
						coords.y += targetElement.offsetTop;
					}
				}
				else
				{
					//alert("Could not find any reference for coordinate positioning.");
				}
			}
			return coords;
		}
		catch(error)
		{
			return coords;
		}
	}


		
      	</script>
   <!-- IN041797 Start -->   	
   <style type="text/css">
    .slink a:link {color: #0000FF;}
    .slink a:focus {color: #000000}
    .slink {}
   </style>
     <!-- IN041797 End -->  
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollTitle()'>

<form name= "fr" >
<%
try
{

	if(prob_status == null){
		prob_status="A";
	}
	if (prob_status.equalsIgnoreCase("A")){
		strBuff_sql.append(" and A.CURR_STATUS ='A' ");
	}else{
		num_of_cols=5;
	}

	/*if(!diagtype.equals("")){
		strBuff_sql.append(" and DIAG_TYPE = '");
		strBuff_sql.append(diagtype);
		strBuff_sql.append("' ");
	}*/
	
	out.print("<table class='grid' align='center' name='tb1' id='tb1' border='1' width=100% cellspacing='0' cellpadding='3'>");
 
	%>
	<!--	<tr id="divTitleTable">
		<th class='columnHeadercenter' width="10%"  id='x1'><fmt:message key="Common.type.label" bundle="${common_labels}"/></th> 
		<th class='columnHeadercenter' width="10%"  id='x'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th> 
		<th class='columnHeadercenter' width="20%"  id='a'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter' width="10%"  id='a'><fmt:message key="eCA.RecordedDateAndTime.label" bundle="${ca_labels}"/></th>
		<th class='columnHeadercenter' width="10%"  id='b'><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter' width="7%"  id='c'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter' width="10%"  id='d'><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter' width='6%' ID='h'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'   id='z' width="9%"><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/></th>
		<th class='columnHeadercenter'  id='sc' width="6%"><fmt:message key="eCA.SupportingDiagCode.label" bundle="${ca_labels}"/></th> 
		 <%if(P_function_id.equals("PH")){%> 
			 <td class='columnHeader' width=6%  >&nbsp;&nbsp;&nbsp;</td> 
		 <%}%> 
		</tr>  -->
		<tr id="divTitleTable">
				<th align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 >&nbsp;</font></th>
				<th align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 >&nbsp;</font></th>
				<th align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 ><fmt:message key="Common.Set.label" bundle="${common_labels}"/></font></th>
				<th align='center'  wrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>/<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font></th>
				<th align='center'  nowrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.description.label" bundle="${common_labels}"/></font></th>
				<th class='columnHeadercenter' width="10%"  id='x1'><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
				<th class='columnHeadercenter' width="10%"  id='x'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
				<th class='columnHeadercenter' width='6%' ID='h'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
				<th class='columnHeadercenter' width='6%' ID='h'><fmt:message key="eCA.DiagnosisRemarks.label" bundle="${ca_labels}"/></th><!-- 38981--> 
				<th class='columnHeadercenter'   id='z' width="9%"><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/></th>
				<th class='columnHeadercenter'  id='sc' width="6%"><fmt:message key="eCA.SupportingDiagCode.label" bundle="${ca_labels}"/></th> 
				 <%if(P_function_id.equals("PH")){%> 
					 <th class='columnHeader' width=6%  >&nbsp;&nbsp;&nbsp;</th> 
				 <%}%> 
			</tr>


	<%	
		if (sense_par==null){
			sense_par = "N";
		}

	/*	
		strsql_in.append("select srl_no,problem_status,decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') diag_scheme,diag_code_scheme,diag_code,diag_desc,nvl(sensitive_yn,'N') sensitive_yn,decode(DIAG_TYPE,'P','Provisional','D','Differential','F','Final') DIAG_TYPE,PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, to_char(CLOSE_DATE,'dd/mm/yyyy') CLOSE_DATE,DECODE(IP_DIAG_STAGE,'A','Admission','I','Intermediate','D','Discharge') diag_stage from pr_problem where patient_id=? "+strBuff_sql.toString()+" and NVL(error_yn,'N') !='Y' ");
		
		if(!encounter_id.equals(""))
			strsql_in.append(" and onset_encounter_id = ? ");
		strsql_in.append(" and   nvl(sensitive_yn,'N')=decode(?,'Y',nvl(sensitive_yn,'N'),'N') 		 AND DIAG_CODE = nvl(?,diag_code)	AND ONSET_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')  ");
//out.println(strsql_in);
			
			if (orderBy.equals("TYPE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by DIAG_TYPE desc ");
					}else{
							strsql_in.append(" order by DIAG_TYPE ");
					}
			}else if (orderBy.equals("ONDA")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by ONSET_DATE desc ");
					}else{
							strsql_in.append(" order by ONSET_DATE ");
					}
			}else if (orderBy.equals("DESC")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_desc desc ");
					}else{
							strsql_in.append(" order by diag_desc ");
					}
			}else if (orderBy.equals("STAG")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_stage desc ");
					}else{
							strsql_in.append(" order by diag_stage ");
					}
			}else if (orderBy.equals("CODE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_code desc ");
					}else{
							strsql_in.append(" order by diag_code ");
					}
			}else if (orderBy.equals("SCHE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_scheme desc ");
					}else{
							strsql_in.append(" order by diag_scheme ");
					}
			}else if (orderBy.equals("CLDA")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by CLOSE_DATE desc ");
					}else{
							strsql_in.append(" order by CLOSE_DATE ");
					}
			}else{
					strsql_in.append(" order by ONSET_DATE, diag_desc ");
			}
*/
		//strsql_in.append("select srl_no,problem_status,decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') diag_scheme,diag_code_scheme,diag_code,diag_desc,nvl(sensitive_yn,'N') sensitive_yn,DIAG_TYPE,PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, to_char(CLOSE_DATE,'dd/mm/yyyy') CLOSE_DATE,IP_DIAG_STAGE diag_stage from pr_problem where patient_id=? "+strBuff_sql.toString()+" and NVL(error_yn,'N') !='Y' ");
		
		//strsql_in.append("select A.OCCUR_SRL_NO srl_no,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') rec_date,A.CURR_STATUS problem_status,C.TERM_SET_DESC diag_scheme,A.TERM_SET_ID diag_code_scheme,A.TERM_CODE diag_code,D.SHORT_DESC diag_desc1,a.TERM_CODE_SHORT_DESC diag_desc ,D.long_desc term_code_desc,D.sensitive_yn, 'D' DIAG_TYPE,'N' PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, DECODE(A.CURR_STATUS,'R',to_char(CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,");
		//strsql_in.append("select A.OCCUR_SRL_NO srl_no,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') rec_date,A.CURR_STATUS problem_status,C.TERM_SET_DESC diag_scheme,A.TERM_SET_ID diag_code_scheme,A.TERM_CODE diag_code,D.SHORT_DESC diag_desc1,mr_get_desc.mr_term_code (a.term_set_id, a.term_code,'"+locale+"','2' ) diag_desc ,D.long_desc term_code_desc,D.sensitive_yn, 'D' DIAG_TYPE,'N' PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, DECODE(A.CURR_STATUS,'R',to_char(CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE, ");//IN036001 //Commentted IN045225
		//strsql_in.append("select A.OCCUR_SRL_NO srl_no,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') rec_date,A.CURR_STATUS problem_status,C.TERM_SET_DESC diag_scheme,A.TERM_SET_ID diag_code_scheme,A.TERM_CODE diag_code,D.SHORT_DESC diag_desc1,mr_get_desc.mr_term_code (a.term_set_id, a.term_code,'"+locale+"','2' ) diag_desc ,D.long_desc term_code_desc,D.sensitive_yn, 'D' DIAG_TYPE,'N' PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, DECODE(A.CURR_STATUS,'R',to_char(CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,a.TERM_CODE_SHORT_DESC SHORT_DESC1, ");//IN045225
		strsql_in.append("select A.OCCUR_SRL_NO srl_no,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') rec_date,A.CURR_STATUS problem_status,C.TERM_SET_DESC diag_scheme,A.TERM_SET_ID diag_code_scheme,A.TERM_CODE diag_code,D.SHORT_DESC diag_desc1,(case when a.term_code = '*OTH' then a.term_code_short_desc else mr_get_desc.mr_term_code (a.term_set_id, a.term_code,'"+locale+"','2' ) end) diag_desc ,D.long_desc term_code_desc,D.sensitive_yn, 'D' DIAG_TYPE,'N' PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, DECODE(A.CURR_STATUS,'R',to_char(CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,a.TERM_CODE_SHORT_DESC SHORT_DESC1, ");//IN045225//IN071908
		
		strsql_in.append("nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID "); 
		if(!encounter_id.equals(""))
		{
			strsql_in.append(" and encounter_id = ? ");
		}else{
			strsql_in.append(" and encounter_id = a.ONSET_ENCOUNTER_ID ");
		}
		strsql_in.append(" and rownum=1),'') diag_stage ");
		strsql_in.append(" , NVL((select 'Y' from PR_SUPPORT_DIAGNOSIS where patient_id = a.patient_id and term_set_id = a.term_set_id and term_code = a.term_code and occur_srl_no = a.occur_srl_no  and rownum = 1),'N') support_exisist_yn ");
		//added for GHL 41
		
	//	strsql_in.append(" ,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt ,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn ,a.accession_num,a.curr_accuracy_ind ");
		strsql_in.append(" ,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt ,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn ,a.accession_num,a.curr_accuracy_ind,a.curr_remarks");//38981

		//added for GHL 41 ends
		strsql_in.append(" from PR_Diagnosis A ,MR_TERM_CODE D,MR_TERM_SET C  where C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? "+strBuff_sql.toString());
		
		//IN053120 starts
			if(!encounter_id.equals(""))
				strsql_in.append("AND a.curr_encounter_id = ?");
		//IN053120 ends
		if(!encounter_id.equals(""))
			strsql_in.append(" and exists (select 1 from  pr_diagnosis_enc_dtl where PATIENT_ID=a.patient_id and TERM_SET_ID=A.TERM_SET_ID and TERM_CODE =A.TERM_CODE and FACILITY_ID=A.ONSET_FACILITY_ID and ENCOUNTER_ID= ? ) ");

		if(sense_par.equals("N"))
			strsql_in.append(" and nvl(D.sensitive_yn,'N') = 'N' ");

		strsql_in.append(" AND A.TERM_CODE = nvl(?,A.TERM_CODE)	AND A.ONSET_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')+.9999 and A.TERM_SET_ID=nvl(?,A.TERM_SET_ID) order by A.ONSET_DATE desc");

		
		String problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint a where a.facility_id= ? and a.encounter_id= ? and a.complaint_id not in (select b.complaint_id from PR_DIAGNOSIS_COMPL_ENC_DTL b where b.ENCOUNTER_ID= ? AND  b.FACILITY_ID=? ) order by a.onset_datetime";

		String linkDiagQry="select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and ( a.term_code = ? or  a.term_code_short_desc = ?) order by a.onset_date desc";

		stmt2 = conn.prepareStatement(linkDiagQry);

		stmt1 = conn.prepareStatement(problem_qry);
		stmt1.setString(1,facility_id);
		stmt1.setString(2,encounter_id);
		stmt1.setString(3,encounter_id);
		stmt1.setString(4,facility_id);
		/*out.println("facility_id = > "+facility_id);
		out.println("encounter_id = > "+encounter_id);
		out.println("encounter_id = > "+encounter_id);
		out.println("facility_id = > "+facility_id); */
		rs1 = stmt1.executeQuery();
		
		while(rs1.next())
		{

			complaint_id =rs1.getString("complaint_id")==null?"":rs1.getString("complaint_id");
			complaint_desc =rs1.getString("complaint_desc")==null?"":rs1.getString("complaint_desc");
			onset_datetime =rs1.getString("onset_datetime_str")==null?"":rs1.getString("onset_datetime_str");
			//Date Conversion is done by Archana Dhal on 10/7/2010 related to IN024213.
			onset_datetime	= com.ehis.util.DateUtils.convertDate(onset_datetime,"DMY","en",locale);

			classValue="gridData";
		%>
			<tr><td class='<%=classValue%>' >&nbsp;</td><td class='<%=classValue%>'>&nbsp;</td><td class='<%=classValue%>'>&nbsp;</td><td class='<%=classValue%>'><img src='../../eCommon/images/Problems.gif'><%=complaint_id%></td><td class='<%=classValue%>'><%=complaint_desc%></td><td class='<%=classValue%>' >&nbsp;</td><td class='<%=classValue%>' ><%=onset_datetime%></td><td class='<%=classValue%>' >&nbsp;</td><td class='<%=classValue%>' >&nbsp;</td><td class='<%=classValue%>' >&nbsp;</td>

			 <%if(P_function_id.equals("PH")){%> 
					 <td class='<%=classValue%>' width=6%  >&nbsp;</td> 
				 <%}%> 
			
			</tr>
		<%

		}

		if(rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.close();
		
		//out.println(strsql_in);
			
		/*	if (orderBy.equals("TYPE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by DIAG_TYPE desc ");
					}else{
							strsql_in.append(" order by DIAG_TYPE ");
					}
			}else if (orderBy.equals("ONDA")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by ONSET_DATE desc ");
					}else{
							strsql_in.append(" order by ONSET_DATE ");
					}
			}else if (orderBy.equals("DESC")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_desc desc ");
					}else{
							strsql_in.append(" order by diag_desc ");
					}
			}else if (orderBy.equals("STAG")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_stage desc ");
					}else{
							strsql_in.append(" order by diag_stage ");						}
			}else if (orderBy.equals("CODE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_code desc ");
					}else{
							strsql_in.append(" order by diag_code ");
					}
			}else if (orderBy.equals("SCHE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_scheme desc ");
					}else{
							strsql_in.append(" order by diag_scheme ");
					}
			}else if (orderBy.equals("CLDA")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by CLOSE_DATE desc ");
					}else{
							strsql_in.append(" order by CLOSE_DATE ");
					}
			}else{
					strsql_in.append(" order by ONSET_DATE, diag_desc ");
			}*/

		String sense_yn = "N";
		//String srl_no ="";
		StringBuffer associate_codes = new StringBuffer();
		int count=0,i = 1;
		
		stmt_in = conn.prepareStatement(strsql_in.toString());
		if(!encounter_id.equals("")){
			stmt_in.setString(i++,encounter_id);
					//out.println("encounter_id = > "+encounter_id);
		}

		stmt_in.setString(i++,encounter_id);
				//out.println("encounter_id = > "+encounter_id);
		stmt_in.setString(i++,facility_id);
		stmt_in.setString(i++,facility_id);
		//out.println("facility_id = > "+facility_id);
		//out.println("facility_id = > "+facility_id);
		stmt_in.setString(i++,encounter_id);
			//out.println("encounter_id = > "+encounter_id);

		stmt_in.setString(i++,patientid);
		//out.println("patientid = > "+patientid);
		//IN053120 starts
			if(!encounter_id.equals(""))
				stmt_in.setString(i++,encounter_id);
		//IN053120 ends
		if(!encounter_id.equals("")){
			stmt_in.setString(i++,encounter_id);
			//out.println("encounter_id = > "+encounter_id);
		}
		//stmt_in.setString(i++,sense_par);
		stmt_in.setString(i++,p_diag_code);
		//out.println("p_diag_code = > "+p_diag_code);
		stmt_in.setString(i++,from_date);
		stmt_in.setString(i++,to_date);
		stmt_in.setString(i++,term_set_id);
		//out.println("from_date = > "+from_date);
		//out.println("to_date = > "+to_date);
		//out.println("term_set_id = > "+term_set_id);
		rs_in = stmt_in.executeQuery();

		if (rs_in != null)
		{
			while(rs_in.next())
			{
				String srl_no_associate_code = rs_in.getString("srl_no");
				String diag_code = rs_in.getString("diag_code");
				String diag_code_scheme = rs_in.getString("diag_code_scheme");
				String diag_scheme = rs_in.getString("diag_scheme");
//				String rec_date=rs_in.getString("rec_date");
				strOnsetDate	= rs_in.getString("onset_date_str");
				support_exisist_yn	= rs_in.getString("support_exisist_yn");
				short_desc	= rs_in.getString("term_code_desc");
				String stat_temp=rs_in.getString("problem_status");
	
				prob_cnt= rs_in.getInt("prob_cnt");
				curr_enc_yn= rs_in.getString("curr_enc_yn");
				oh_accession_num = rs_in.getString("accession_num")==null?"":rs_in.getString("accession_num");
				curr_accuracy_ind = rs_in.getString("curr_accuracy_ind")==null?"":rs_in.getString("curr_accuracy_ind");
				diag_desc = rs_in.getString("diag_desc")==null?"":rs_in.getString("diag_desc");//Added by Archana Dhal on 10/14/2010 related to incident no. IN024424.
				short_desc1	= rs_in.getString("SHORT_DESC1")==null?"":rs_in.getString("SHORT_DESC1");//IN045225
				
				strOnsetDate	= com.ehis.util.DateUtils.convertDate(strOnsetDate,"DMY","en",locale);
				curr_remarks	= rs_in.getString("curr_remarks")==null?"":rs_in.getString("curr_remarks");//38981

				/*added values */
			
				sense_yn = rs_in.getString("sensitive_yn");
				diag_type = rs_in.getString("DIAG_TYPE") == null ? "&nbsp;" : rs_in.getString("DIAG_TYPE");
	
				//if(diag_type == null || diag_type.equals("null"))diag_type="&nbsp";
				diag_stage = rs_in.getString("diag_stage");
				
				if(diag_stage == null || diag_stage.equals("null") || diag_stage.equals(""))diag_stage="&nbsp";
				if(!isSiteSpecific){//IN069327
					//IN045225 - Start
					if(!diag_code.equals("*OTH"))
						short_desc1 = diag_desc;
					//IN045225 - End
				}//IN069327
				diag_code_disp = diag_code;


				//out.println("<script>alert('"+sense_yn+"');</script>");
				if(diag_stage.equals ("A"))
				{				
				diag_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				}	
				else if(diag_stage.equals("I"))
				{
				diag_stage =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				}	
				else if(diag_stage.equals("D"))
				{
				diag_stage =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
				}

				if(diag_type.equals ("P"))
				{				
				diag_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
				}	
				else if(diag_type.equals("D"))
				{
				diag_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
				}	
				else if(diag_type.equals("F"))
				{
				diag_type =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");
				}

				
				String sql_assosicate_code = "select a.support_diag_code , b.short_desc, b.long_desc from pr_problem_detail a, mr_term_code b where a.patient_id =? and   a.srl_no =? and a.diag_code = ? and b.TERM_SET_ID = ? and b.term_code = a.support_diag_code" ;

				pstmt_1 = conn.prepareStatement(sql_assosicate_code);
				pstmt_1.setString(1, patientid);
				pstmt_1.setString(2, srl_no_associate_code);
				pstmt_1.setString(3, diag_code);
				pstmt_1.setString(4, diag_code_scheme);
				//out.println("<script>alert('"+patientid + "-" + srl_no_associate_code+ "-"+ diag_code+ "-"+diag_code_scheme+"');</script>");

				//out.println(sql_assosicate_code);

				rs_associatecodes = pstmt_1.executeQuery();
				int temp_associate_code = 0;
				while(rs_associatecodes.next())
				{
					String temp_supporting_code = rs_associatecodes.getString("support_diag_code");
					String temp_short_desc = rs_associatecodes.getString("short_desc");
					String long_desc_associatecode = rs_associatecodes.getString("long_desc");
					if(temp_associate_code == 0)
						associate_codes.append(temp_supporting_code + "~" + temp_short_desc+ "~" +long_desc_associatecode);
					else
						associate_codes.append("|" + temp_supporting_code + "~" + temp_short_desc+ "~" +long_desc_associatecode);	
					//out.println("<script>alert('"+associate_codes+"-- "+temp_supporting_code+"');</script>");
					temp_associate_code++;
				}
				
                if(rs_associatecodes!=null)	rs_associatecodes.close();
	            if(pstmt_1!=null) pstmt_1.close();
				
				
				String diagType="";

				String width="";
				if (prob_status.equals("O")) 
					width="28%";
				else 
					width="30%";
				
				if(sense_yn.equals("Y"))
					classValue = "PATQRED";
				else
					classValue = "gridData" ;
				
				diagType= rs_in.getString("DIAG_TYPE") == null ? "&nbsp;" : rs_in.getString("DIAG_TYPE");

				if( diagType.equals("Final"))
						diagType="<b>"+ diagType +"</b>";
				
				
				out.print("<tr>");
				//out.println("<td  class='" + classValue +"' width='10%'> <font size='1'>" + diagType  +"</font> </td>");
				%>
			<!-- Added by Jeyachitra - ML-MMOH-CRF 1742 -->
			<%if(isDeceasedDiagClassDeathRegAppl)
			{
				try
				{
					pstmt = conn.prepareStatement("select * from mr_rec_diag_audit_trial where patient_id=? and encounter_id=? and term_code=? and occur_srl_no=? and facility_id=? and term_Set_id=?");
					pstmt.setString(1, patientid);
					pstmt.setString(2, encounter_id);
					pstmt.setString(3, diag_code);
					pstmt.setString(4, srl_no_associate_code);
					pstmt.setString(5, facility_id);
					pstmt.setString(6, diag_code_scheme);
					
					res= pstmt.executeQuery();
					
					if(res!=null && res.next())
					{
						out.println("<td class='" + classValue + "' nowrap><a href='javascript:displayAuditTrial(\"" + patientid + "\",\"" + diag_code + "\",\"" + diag_code_scheme + "\",\"" + encounter_id + "\",\"" + facility_id + "\",\"" + srl_no_associate_code + "\")'>Audit Trail</a></td>");
					}
					else
					{
						out.println("<td class='"+classValue+"' nowrap>&nbsp;</td>");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(res!=null) res.close();
					if(pstmt!=null) pstmt.close();		
				}
			}
			%>
			<% if(!oh_accession_num.equals("")){ %>
			<td class='<%=classValue%>' ><font color='blue' ><b>C</font></td>
			<%}else{%>
			<td class='<%=classValue%>' >&nbsp;</td>
			<%}%>
			<%if(curr_enc_yn.equals("Y")){%>
			<td class='<%=classValue%>'><img src='../../eCommon/images/CurrentEncounter.gif'></td>
			<%}else{%>
			<td class='<%=classValue%>'>&nbsp;</td>
			<%}%>
			<td class='<%=classValue%>'><%=diag_scheme%></td>
			<td class='<%=classValue%>'>
			<% if(curr_accuracy_ind.equals("U")){%>
			<img src='../../eCommon/images/Differentials.gif'></img>
			<%}%>
			<%=diag_code_disp%>
			<%
			
			if(prob_cnt>0){
				
			stmt2.setString(1,locale);
			stmt2.setString(2,facility_id);
			stmt2.setString(3,encounter_id);
			stmt2.setString(4,diag_code_scheme);
			stmt2.setString(5,diag_code);
			stmt2.setString(6,short_desc);

			rs2 = stmt2.executeQuery();
			layer.setLength(0);
			while(rs2.next())
			{
								
				complaint_id_lyr =rs2.getString("complaint_id")==null?"":rs2.getString("complaint_id");
				complaint_desc_lyr =rs2.getString("complaint_text")==null?"":rs2.getString("complaint_text");
				onset_datetime_lyr =rs2.getString("onset_datetime_str")==null?"":rs2.getString("onset_datetime_str");
				//Date Conversion is done by Archana Dhal on 10/7/2010 related to IN024213.
				onset_datetime_lyr = com.ehis.util.DateUtils.convertDate(onset_datetime_lyr,"DMYHM","en",locale);
				
				layer.append("<tr><td class=gridData nowrap>"+complaint_id_lyr+"</td>"+
							"<td class=gridData>"+complaint_desc_lyr+"</td>"+
							"<td class=gridData>"+onset_datetime_lyr+"</td></tr>");
	

			}
			if(rs2 != null) rs2.close();

			out.println("<script>detailArray["+index+"]='"+layer.toString()+"';</script>");

			//Below if and else condition is added by Archana Dhal on 10/14/2010 related to incident no. IN024424.
			if(!diag_code.equals("*OTH"))
			{
					// linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND  TERM_CODE = '"+diag_code+"' and OCCUR_SRL_NO='"+srl_no_associate_code+"'";//common-icn-0180
					 linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID= ? AND  FACILITY_ID= ? AND  TERM_CODE = ? and OCCUR_SRL_NO=?";//common-icn-0180

					  stmt3=conn.prepareStatement(linkviewcnt_sql);
					//common-icn-0180 starts
					  stmt3.setString(1,encounter_id);
					  stmt3.setString(2,facility_id);
					  stmt3.setString(3,diag_code);
					  stmt3.setString(4,srl_no_associate_code);
					//common-icn-0180 ends
			}
           else
			{

			linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO='"+srl_no_associate_code+"'";//common-icn-0180
			linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID= ? AND  FACILITY_ID= ? AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO= ?";//common-icn-0180
					
			stmt3=conn.prepareStatement(linkviewcnt_sql);
			//common-icn-0180 starts
			stmt3.setString(1,encounter_id);
			stmt3.setString(2,facility_id);
			stmt3.setString(3,diag_desc);
			stmt3.setString(4,srl_no_associate_code);
			//common-icn-0180 ends 
			}
				
			rs3=stmt3.executeQuery();
			if(rs3 != null && rs3.next())
			  {
				view_cnt = rs3.getInt(1);
			  }
			if(stmt3 != null) stmt3.close();//checkstyle
			if(rs3 != null) rs3.close();//checkstyle
			
			if(view_cnt !=0 )
				{


			%>
				<!--<img src='../../eCommon/images/LinkView.gif' align='right' onclick='showProblem("<%=patientid%>","<%=diag_code%>","<%=diag_scheme%>","<%=short_desc%>","<%=encounter_id%>")'> -->
				<img src='../../eCommon/images/LinkView.gif' align='right' onMouseOver='callMouseOverDiag(this,"<%=index%>")' onMouseOut='callOnMouseOutDiag(this);'>
			<%
				}
			 index++;
				}
			%>
			<%
					
				
				if (sense_yn.equalsIgnoreCase("Y"))
				{
					
					count++;
				//	out.print("<td class='PATQRED' class='"+classValue+"'  width='20%'> <a id='"+count+"' class='gridLink'  href='javascript:rfresh(\""+count+"\")'>"); //IN041797 Commented
					out.print("<td class='PATQRED' class='"+classValue+"'  width='20%'> <span class='slink'><a id='"+count+"' class='gridLink'  href='javascript:rfresh(\""+count+"\")'>"); //IN041797 
					//out.print("<font size=1>"+diag_desc);//'diag_desc' is passed instead of 'diag_desc1' modified by Archana Dhal on 10/14/2010 related to incident no. IN024424.//commentted IN045225
					out.print("<font size=1>"+short_desc1);// 'short_desc1' passed instead of diag_desc to handle *OTH value //IN045225
					if(rs_in.getString("PRIMARY_YN").equals("Y"))
					  out.print("&nbsp;&nbsp;<font color=RED><b>*</b></font>");
					
					//out.print("</font></a></td>");
					out.print("</font></a></span></td>"); //IN041797 
					
					//out.print("<td   class='"+classValue+"'  width='10%'>");

					out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>"+diag_stage+"</font> </td>");

					/*if(diagType.equals("A")){
					out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");*/
					%><!--<fmt:message key='Common.admission.label' bundle='${common_labels}'/> --><%//out.println("</font> </td>");
					//}else if (diagType.equals("I")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					%><!--<fmt:message key="Common.Intermediate.label" bundle="${common_labels}"/>--><%//out.println("</font> </td>");
					//}else if (diagType.equals("D")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					%><!--<fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>--><%//out.println("</font> </td>");
					/*}
					else {
					out.println("<td  class='"+classValue+"' width='10%'> &nbsp;</td>");
							}*/
					/***************/
					
					//out.print("<td    class='"+classValue+"' width='10%'>");
					//out.print("<font size=1>"+diag_stage+"</font></td>");

					//out.print("<td   class='"+classValue+"' width='7%'>");
					//out.print("<font size=1>"+diag_code+"</font></td>");
					//out.print("<td  class='"+classValue+"' width='10%'>");
					//out.print("<font size=1>"+diag_scheme+"</font></td>");

					
					out.println("<td  class='"+classValue+"'  width='10%'> <font size='1'>" + strOnsetDate +"</font> </td>");
					if(prob_status.equals("O"))
					{
						out.print("<td class='"+classValue+"' width='6%'>");
						String stat=rs_in.getString("problem_status");

						if(stat.equals("A"))
								stat="Active";
						else if (stat.equals("E"))
							stat="In Error";
						else if (stat.equals("X"))
							stat="Revoked";
						else
								stat="Resolved";
						out.print("<font size=1>"+stat+"</font></td>");						
					}
					else if(prob_status.equals("A"))
					{
						out.print("<td class='"+classValue+"' width='6%'>");
						String stat = "Active";
						out.print("<font size=1>"+stat+"</font></td>");
					}

					//out.print("<font size=1>"+rec_date+"</font></td>");

					//***
					String c_date = rs_in.getString("close_date")==null?"&nbsp;":rs_in.getString("close_date");

					if(!c_date.equals("&nbsp;") )
						c_date = com.ehis.util.DateUtils.convertDate(c_date,"DMY","en",locale);

					out.println("<td  class='"+classValue+"' width='9%'> <font size='1'>" + c_date  +"</font> </td>");
					if(support_exisist_yn.equals("Y"))
					{
						out.println("<td class='"+classValue+"' width='8%'><font size=1>");
						out.println("<a class='gridLink'  href=\"javascript: ShowSupportingDiag('" + diag_code+"','"+srl_no_associate_code+"','"+patientid+"','"+diag_code_scheme+"','"+short_desc+"("+diag_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
						out.println("</font></td>");
					}
					else
					{
						out.print("<td class='"+classValue+"'> &nbsp;</td>");
					}
					//***
					if(P_function_id.equals("PH")){
						if(P_option_type.equals("ALL"))
						{
							out.print("<td class='"+classValue+"' width='6%'>");
							out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+diag_desc+"' > </td>");
						}
						else if(P_option_type.equals("ACTIVE"))
						{
							if(rs_in.getString("problem_status").equals("A"))
							{
								out.print("<td class='"+classValue+"' width='6%' >");
								out.print("<input type='checkbox' id='ch"+count+"' onclick='onCheck(this)'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+diag_desc+"' ></td>");
							}
							else
							{
								out.print("<td class='"+classValue+"' width='6%' >&nbsp;</td>");
							}
						}
					}
					//***
					//aname++;

				}
				else if (sense_yn.equalsIgnoreCase("N"))
				{
					
					//onclick = '' changeRowColor(this,"+num_of_cols+");
					count++;
					//out.print("<td  class='"+classValue+"' width='20%'> <a id='"+count+"'  class='gridLink'  href='javascript:rfresh(\""+count+"\")'><font size='1'>");
					out.print("<td  class='"+classValue+"' width='20%'> <span class='slink'><a id='"+count+"'  class='gridLink'  href='javascript:rfresh(\""+count+"\")'><font size='1'>");//IN041797
					//out.print("<font size=1>"+diag_desc);//Commented IN045225
					out.print("<font size=1>"+short_desc1);//IN045225
					if(rs_in.getString("PRIMARY_YN").equals("Y"))
					  out.print("&nbsp;&nbsp; <font color=RED><b>*</b></font>");
					//out.print("</font></a></td>");
					out.print("</font></a> </span></td>");//IN041797
					out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>"+diag_stage+"</font> </td>");
					//if(diagType.equals("A")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					%><!--<fmt:message key='Common.admission.label' bundle='${common_labels}'/>--><%///out.println("</font> </td>");
					//}else if (diagType.equals("I")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					%><!--<fmt:message key="Common.Intermediate.label" bundle="${common_labels}"/>--><%//out.println("</font> </td>");
					//}else if (diagType.equals("D")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					%><!--<fmt:message key="Common.Discharge.label" bundle="${common_labels}"/> --><%//out.println("</font> </td>");
					/*}
					else {
					out.println("<td  class='"+classValue+"' width='10%'> &nbsp;</td>");
							}*/
					/***************/
					out.println("<td  class='"+classValue+"'  width='10%'> <font size='1'>" + strOnsetDate +"</font> </td>");
					
					//out.print("<td  class='"+classValue+"' width='10%'>");
					//out.print("<font size=1>"+diag_stage+"</font></td>");
					//out.print("<td  class='"+classValue+"' width='7%'>");
					//out.print("<font size=1>"+rs_in.getString("diag_code")+"</font></td>");
					//out.print("<td  class='"+classValue+"' width='10%'>");
					//out.print("<font size=1>"+rs_in.getString("diag_scheme")+"</font></td>");

					if(prob_status.equals("O"))
					{
					String stat=rs_in.getString("problem_status");
						if (stat.equals("C")){		
							classValue="gray";
						}
						out.print("<td class='"+classValue+"' width='6%'>");

					
						if(stat.equals("A"))
								stat="Active";
						else if (stat.equals("B"))
								stat="Better";
						else if (stat.equals("W"))
								stat="Worse";
						else if (stat.equals("S"))
							stat="Same";
						else if (stat.equals("E"))
							stat="In Error";
						else if (stat.equals("X"))
							stat="Revoked";
						else {
							stat="Resolved";

						//classValue="";		//IN041797 commented
						}

					out.print("<font size=1>"+stat+"</font></td>");

					}
					else if(prob_status.equals("A"))
					{
						out.print("<td class='"+classValue+"' width='6%'>");
						String stat = "Active";
						out.print("<font size=1>"+stat+"</font></td>");
					}

				//	out.print("<td  class='"+classValue+"' width='10%'>");					
				//	out.print("<font size=1>"+rec_date+"</font></td>");
					//***
				/*	if(P_function_id.equals("PH")){

						if(P_option_type.equals("ALL"))
						{
							out.print("<td class='" + classValue + "' width='6%'>");
							out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+rs_in.getString("diag_desc")+"' ></td>");
						}
						else if(P_option_type.equals("ACTIVE"))
						{
							//if(rs_in.getString("probem_status").equals("A"))
							if(prob_status.equals("A"))
							{
								out.print("<td class='" + classValue + "' width='6%' >");
								out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+rs_in.getString("diag_desc")+"' ></td>");
							}
							else
							{
								out.print("<td class='" + classValue + "' width='6%' >&nbsp;</td>");
							}
						}
					}*/
					//***
					
				 	//38981 start
                 if(curr_remarks!="")
				  {
					  out.println("<td class='"+classValue+"' width='8%'><font size=1>");
                	//out.println("<a class='gridLink'  href=\"javascript: ShowRemarksDiag('" + curr_remarks+ "')\"             >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			         out.println("<a class='gridLink'  href=\"javascript: ShowRemarksDiag('"+patientid+"','"+diag_code+"','"+diag_code_scheme+"','"+diag_scheme+"','"+srl_no_associate_code+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");//42995
					  out.println("</font></td>");
				  }
				else
				{
					out.print("<td class='"+classValue+"'> &nbsp;</td>");
				}
					//38981 end 
					String c_date = rs_in.getString("close_date")==null?"&nbsp;":rs_in.getString("close_date");
					if(!c_date.equals("&nbsp;") )
						c_date = com.ehis.util.DateUtils.convertDate(c_date,"DMY","en",locale);
				out.println("<td  class='"+classValue+"' width='9%'> <font size='1'>" + c_date  +"</font> </td>");
				//38981 start
				if(support_exisist_yn.equals("Y"))
				{
					out.println("<td class='"+classValue+"' width='8%'><font size=1>");
					out.println("<a href=\"javascript: ShowSupporting('" + diag_code+"','"+srl_no_associate_code+"','"+patientid+"','"+diag_code_scheme+"','"+(java.net.URLEncoder.encode(diag_desc))+"("+diag_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
					out.println("</font></td>");
				}
				else
				{
					out.print("<td class='"+classValue+"'> &nbsp;</td>");
				}
				//38981 end

				// moved to here ---shaiju

				//***
					if(P_function_id.equals("PH")){

						if(P_option_type.equals("ALL"))
						{
							out.print("<td class='"+classValue+"' width='6%'>");
							out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+diag_desc+"' ></td>");
						}
						else if(P_option_type.equals("ACTIVE"))
						{
							
							//if(rs_in.getString("probem_status").equals("A"))
							
							/**Commented by Ambiga on 12/2/2009 at 3:11 PM for IN016795 ****/
							/*if(prob_status.equals("A"))
							{*/
							/***Commented by Ambiga on 12/2/2009 at 3:11 PM for IN016795 ***/
							if(!(stat_temp.equals("E")))//added by Ambiga for IN016795
							{
								out.print("<td class='"+classValue+"' width='6%' >");
								out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+diag_desc+"' ></td>");
							
							/***Commented by Ambiga on 12/2/2009 at 3:11 PM for IN016795 ***/
							}
							else
							{
								out.print("<td class='"+classValue+"' width='6%' >&nbsp;</td>");
							}
							/***Commented by Ambiga on 12/2/2009 at 3:11 PM for IN016795 ***/
						}
					}
					//***




				// shaiju

				out.print("</tr>");
					//out.println("c_date :"+c_date);
					//aname++;

				}

					//out.print("<input type='hidden' name='srl_no' id='srl_no' value='"+rs_in.getString("srl_no")+"'>"+"</td></tr>");
					//srl_no = rs_in.getString("srl_no");
					//out.println("srl_no "+srl_no);
%>
				<script>
				var srl_no = <%=rs_in.getString("srl_no")%>;
				var termSetId = '<%=rs_in.getString("diag_code_scheme")%>';
				var termCode = '<%=rs_in.getString("diag_code")%>';
				srl_no_array[i] = srl_no;
				term_set_id_array[i]= termSetId;
				term_code_array[i]= termCode;
				//alert("QQ"+srl_no_array[i]);
				i++;
				</script>
<%

			k++;
			associate_codes = new StringBuffer();
			}

		}
}catch(Exception e)
{
	//out.print(e.toString());//COMMON-ICN-0181
     e.printStackTrace() ;
		

}

%>

</table>
</form>
<!--<script>
		
		if(parent.problemsframe0.document.getElementById("th1")==null)
		{
			
			setTimeout("alignHeading();",300);
		}
		else 
			alignHeading();
</script> -->
<div name='details' id='details' style='position:absolute; width:60%; visibility:hidden;' bgcolor='blue'>
</body>
</html>
<%
}catch(Exception e){
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();
}finally
{
	if(rs_in!=null)	rs_in.close();
	if(stmt_in!=null) stmt_in.close();
	if(stmt2!=null) stmt2.close();
	
	if(rs1 != null) rs1.close();//IN053120
	if(rs2 != null) rs2.close();//IN053120
	if(rs3 != null) rs3.close();//IN053120
	if(rs_associatecodes != null) rs_associatecodes.close();//IN053120
	if(pstmt_1!=null) pstmt_1.close();//IN053120
	if(stmt1 != null) stmt1.close();//IN053120
	if(stmt3 != null) stmt3.close();//IN053120
	if(conn != null)ConnectionManager.returnConnection(conn,request);
}
%>

