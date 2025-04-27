<!DOCTYPE html>
<HTML>
<%@ page import= "java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter" %>

<%@ page import="eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	    
<style>
.left_child{
	overflow-y:auto;
 }
</style>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>

<script language="javascript">

function funSubmit()
{
	parent.resultFrame.PAYER_CHECK_QUERY_FORM.action = '../../eXH/jsp/MediMembershipQueryResult.jsp';
	parent.resultFrame.PAYER_CHECK_QUERY_FORM.target="resultFrame";
	parent.resultFrame.PAYER_CHECK_QUERY_FORM.submit();
}

function funAction(typ)
{  
	parent.resultFrame.PAYER_CHECK_QUERY_FORM.action_type.value = typ;
	funSubmit();
}

//function callForOrderBy
function callForOrderBy(obj,order)
{	
	if(order == 'A') obj = obj + ' asc';
	if(order == 'D') obj = obj + ' desc';
	var url = '&orderBy=' + obj + '&order=' + order;

	this.document.forms[0].action_type.value = "";
	this.document.forms[0].action = "../../eXH/jsp/MediMembershipQueryResult.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
}

async function checkEligibility(obj)
{	
	var checkType = "";
	
	var checkTypeButtons = document.getElementsByName('CheckType');


	//var request_status = obj.getAttribute('request_status');
    var trans_num = obj.getAttribute('trans_num');
	var event_type = obj.getAttribute('event_type');

	//var event_type = document.forms[0].event_type.value;
	//var check_type = obj.getAttribute('check_type');
	//var eligibility_status_type = obj.getAttribute('request_status');
	var dialogHeight = "30vh";    // have to remove 
	var dialogWidth  = "55vw";
	var dialogTop    = "50";

    if(!(event_type !="CLA") || !(event_type !="CLE")){
		dialogHeight = "40vh";    // have to remove 
		dialogWidth  = "75vw";
		dialogTop    = "50";
	}
	title="Patient Claims Response Details ";
	title=encodeURIComponent(title);
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var params= "trans_num="+trans_num;

	var arguments = new Array();
	var url = "../../eXH/jsp/MediQueryResponsePopUp.jsp?" +params;
	
	var retVal =await window.showModalDialog(url,arguments,features);
      
}

function includeBoxChecked() {

	if (document.forms[0].includeMastercheckbox.checked == true) {
		if (document.forms[0].includeCheckbox.length != undefined) {
			for ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {
				document.forms[0].includeCheckbox[a].checked = true;
			}
		} else if (document.forms[0].gatewayservers.length == undefined) {
			document.forms[0].includeCheckbox.checked = true;
		}
	}
	else {
		if (document.forms[0].includeCheckbox.length != undefined) {
			for ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {
				document.forms[0].includeCheckbox[a].checked = false;
			}
		} else if (document.forms[0].includeCheckbox.length == undefined) {
			document.forms[0].includeCheckbox.checked = false;
		}
	}
	return true;
}
async function ViewTransDetails(obj){

		var Patient_id = obj.getAttribute('patient_id');
	    var Episode_id = obj.getAttribute('episode_id');
		var Visit_id = obj.getAttribute('visit_id');
		var doc_num = obj.getAttribute('doc_num');
		var bill_doc_code = obj.getAttribute('bill_doc_code');
		var trans_type = obj.getAttribute('trans_type');

		dialogHeight = "35vh";    // have to remove 
		dialogWidth  = "55vw";
		dialogTop    = "50";	
		
		var title="Previous Transaction Details ";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:yes" ;

		// we need to send required values which is need to be compared from existing and responseMsg
		if(Patient_id != null && Patient_id != "" && Patient_id != " ")
		{
			var arguments = new Array();
			var url = "../../eXH/jsp/MediClaimsTransDetailsPopup.jsp?Patient_id="+Patient_id+"&Episode_id="+Episode_id+"&Visit_id="+Visit_id+"&doc_num="+doc_num+"&bill_doc_code="+bill_doc_code+"&trans_type="+trans_type;
			var retVal =await window.showModalDialog(url,arguments,features);
		}
		else
		{
			alert("APP-XH0070 Response is not available");
		}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >
	<form name="PAYER_CHECK_QUERY_FORM" id="PAYER_CHECK_QUERY_FORM" method="POST" action=''  >
	<%
		String order = "";
		String orderBy = "";
		String action_type=null;
		Connection conn = null;
		Statement stmt=null;
		ResultSet rset=null ;
		ResultSet rsevent=null;

		String event_type = "";
		String dest_code = "";

		String rs_operating_facility_id = "", rs_patientId="",rs_encounterId = "", rs_billNumber = "", rs_sex = "", rs_nationalId = "", rs_transDate = "", rs_patientName = "",rs_episode_id ="";
		String rs_memberId = "", rs_serviceCode = "", rs_specialityCode = "", rs_custCode = "", rs_patientClass = "", rs_locationType = "", rs_destCode = "";
		String rs_firstName = "", rs_secondName = "", rs_intial = "", rs_dob = "",rs_familyName="",rs_approval_status = "",rs_request_status = "",rs_trans_Id = "",rs_user_name ="",rs_visit_id ="", rs_event_type = "",rs_trans_type = "",rs_doc_num = "",rs_doc_type = "",	rs_amount = "", rs_adm_date = "";

		String currentSubGroup = "",prevSubGroup = "",checkboxvalue = "",Checkboxname = "",l_img_vw_dtl_str = "";
		int billDetailsRowCount = 0;

		int l_srl_trans_no = 0;

		String rs_patientClass_desc = "",rs_approval_status_desc = "",rs_event_type_desc = "";

		String l_event_trans_query = "",l_event_trans_type = "", l_case_trans_no = "", l_approval_trans_status = "", l_current_status = "";

		HttpSession httpSession = request.getSession(false);
		String customer_id = XHDBAdapter.checkNull(request.getParameter("customer_id"));
		String patient_id= XHDBAdapter.checkNull(request.getParameter("patient_id"));
		String patient_class_episode = XHDBAdapter.checkNull(request.getParameter("patient_class_episode"));
		String episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
		String customer_group = XHDBAdapter.checkNull(request.getParameter("customer_group"));
		String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
		String trans_from_dt = XHDBAdapter.checkNull(request.getParameter("trans_from_dt"));

		String bill_from = XHDBAdapter.checkNull(request.getParameter("bill_from"));
		String bill_to= XHDBAdapter.checkNull(request.getParameter("bill_to"));

		if(trans_from_dt!="" && trans_from_dt!=null)
		{
		   trans_from_dt = trans_from_dt+ " 00:00:00";
		}

		String trans_to_dt = XHDBAdapter.checkNull(request.getParameter("trans_to_dt"));
		if(trans_to_dt!="" && trans_to_dt!=null)
		{
		   trans_to_dt =trans_to_dt + " 23:59:59";
		}

		event_type = XHDBAdapter.checkNull(request.getParameter("event_type"));
		if(event_type.equals("ELC"))
		{
		   event_type ="ELCREQ";
		}
		if(event_type.equals("ECL"))
		{
		   event_type ="ECLREQ";
		}
		String check_type = XHDBAdapter.checkNull(request.getParameter("check_type"));
		String eligibility_status_type = XHDBAdapter.checkNull(request.getParameter("eligibility_status_type"));

		String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

		if(isDebugYN.equals("Y")){
			System.out.println("MediMembershipQueryResult.jsp:::customer_id....."+customer_id);
			System.out.println("MediMembershipQueryResult.jsp:::patient_id....."+patient_id);
			System.out.println("MediMembershipQueryResult.jsp:::trans_from_dt....."+trans_from_dt+" trans_to_dt :::: "+trans_to_dt );
			System.out.println("MediMembershipQueryResult.jsp:::event_type....."+event_type +"::: check_type ::: "+check_type+" ::: eligibility_status_type ::: "+eligibility_status_type);
		}
		/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

		boolean  boolToggle = true;
		String strTDClass = "";
		String whereClause = "";
		int totalRecords=0;

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		try
		{ 
			conn = ConnectionManager.getConnection(request);

			/*

			whereClause = " where a.PATIENT_ID = b.PATIENT_ID AND b.patient_id = d.patient_id AND b.episode_id = d.episode_id and d.EVENT_TYPE = e.TRANS_TYPE AND d.APPROVAL_STATUS = e.STATUS_CODE(+) ";

			*/

			if(isDebugYN.equals("Y"))
			{
				System.out.println("on admission.. patient id..."+patient_id);
			}
			if(patient_id != null && patient_id != "" && patient_id != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND PATIENT_ID =  '#patient_id'";
				else
					whereClause = whereClause + " where PATIENT_ID =  '#patient_id'";
			}
			if(customer_id != null && customer_id != "" && customer_id != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND CUST_CODE =  '#customer_id'";
				else	
					whereClause = whereClause + " where CUST_CODE =  '#customer_id'";
			}
			if(customer_group != null && customer_group != "" && customer_group != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND CUST_GROUP_CODE = '#customer_group'";
				else
					whereClause = whereClause + " where CUST_GROUP_CODE =  '#customer_group'";
			}
			if(episode_id != null && episode_id != "" && episode_id != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND episode_id = '#episode_id'";
				else
					whereClause = whereClause + " where episode_id = '#episode_id'";
			}

			if(trans_from_dt!="" && trans_from_dt!=null && trans_to_dt!="" && trans_to_dt!=null)
			{		
				if (whereClause.length()>0)
					whereClause = whereClause + " And TO_Date(modified_date ,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+trans_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+trans_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
				else
					whereClause = whereClause + " where TO_Date(modified_date ,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+trans_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+trans_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
			}
			if(event_type != null && event_type != "" && event_type != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND TRANS_TYPE = '"+event_type+"'";
				else
					whereClause = whereClause + " where TRANS_TYPE =  '"+event_type+"' ";
			}

			if(check_type != null && check_type != "" && check_type != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND EVENT_TYPE = '"+check_type+"'";
				else
					whereClause = whereClause + " where EVENT_TYPE =  '"+check_type+"'";
			}
			if(bill_from != null && bill_from != "" && bill_from != " " && bill_to != null && bill_to != "" && bill_to != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND DOC_NUM BETWEEN '#bill_from' AND '#bill_to'";
				else
					whereClause = whereClause + " where DOC_NUM BETWEEN '#bill_from' AND '#bill_to' ";
			}
			if(eligibility_status_type != null && eligibility_status_type != "" && eligibility_status_type != " " )
			{ 
				if (whereClause.length()>0)
					whereClause = whereClause + " AND APPROVAL_STATUS =  '#eligibility_status_type'";  
				else
					whereClause = whereClause + " where APPROVAL_STATUS =  '#eligibility_status_type'";
			}
	

			whereClause = whereClause + " order by patient_id, patient_name, sex, patient_class, episode_id, srl_no desc";

			request.setAttribute(XHQueryRender.strQueryId,"ELIGIBILITYCHECKQUERY");

			if(isDebugYN.equals("Y")){
				System.out.println("MediMembershipQueryResult :: whereClause....."+whereClause);
			}
			request.setAttribute(XHQueryRender.col,"36"); 
			request.setAttribute(XHQueryRender.maxRec,"7");
			request.setAttribute(XHQueryRender.whereClause,whereClause);
			HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");	
			//String sqlQuery= XHQueryRender.sqlQuery;	
			//System.out.println("sqlQuery... "+sqlQuery);
			ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 

			ArrayList arrCol = null;
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
			//if(isDebugYN)System.out.println("boolPrevious...."+boolPrevious);
			//if(isDebugYN)System.out.println("boolNext...."+boolNext);
			String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			if (boolPrevious == true)
			{
				strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			}
			else
			{
				strPrevious = " ";
			}
			if (boolNext== true)
			{
				strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			}
			else
			{
				strNext  = " ";
			}
			if(isDebugYN.equals("Y")){
				System.out.println("MediMembershipQueryResult :: action_type in jsp...."+action_type);
			}

			if(arrRow.size()==0)
			{
				%>	
				<script>
				alert('APP-002415 Query caused no records to be retrieved');
				history.go(-1);
				parent.resultFrame.location.href='../../eCommon/html/blank.html';
				</script>
				<%
			}
			else
			{
				%> 
				<table cellspacing=0 cellpadding=3 width='100%' align=center border=1>
					<tr>
						<td colspan="27" class="COLUMNHEADER" align='center'>Eclaims Query Result</td>
					</tr>
					<tr>	   
						<td align="right" class="CAGROUP" > 
						<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
						<A class='label' onClick="funAction('N')" style='cursor:pointer'><%= strNext %></A>
					</td>
					</tr>
				</table>

				<div id="left_child" class="left_child">
					<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' border=1 align=center>	
						<tr>
							<td class='COLUMNHEADER' width='6%'>
								<font color=white><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></font>
							</td>
							<td class='COLUMNHEADER' width='13%'>
								<font color=white><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></font>
							</td>
                            <td class='COLUMNHEADER' width='6%'>
								<font color=white ><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></font>
							</td>
					        <td class='COLUMNHEADER' width='15%'>
								<font color=white><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></font>
							</td>
					        <td class='COLUMNHEADER' width='8%'>
								<font color=white><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></font>
							</td>
					
							<td class='COLUMNHEADER' width='15%'>
								<font color=white><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></font>
							</td>	
							<td class='COLUMNHEADER' width='6%'>
								<font color=white ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></font>
							</td>
						</tr>
					    <input type='hidden' name='action_type' id='action_type' value='<%=action_type%>'>		     

						<%
						System.out.println("MediMembershipQueryResult :: Before getting details....."+arrRow.size());
						Map cmp = new HashMap();

						totalRecords=0;

						billDetailsRowCount = arrRow.size();
						int j = 0;

						dbConn = ConnectionManager.getConnection();
						
						System.out.println("MediMembershipQueryResult :: dbConn...."+dbConn);

						for (j=0; j<arrRow.size();j++)
						{
							arrCol = (ArrayList)arrRow.get(j);
							rs_operating_facility_id = arrCol.get(0).equals("null")?"":(String)arrCol.get(0);
							rs_patientId = arrCol.get(1).equals("null")?"":(String)arrCol.get(1);
							rs_patientName = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);
							rs_firstName = arrCol.get(12).equals("null")?"":(String)arrCol.get(12);
							rs_secondName = arrCol.get(13).equals("null")?"":(String)arrCol.get(13);
							rs_dob = arrCol.get(15).equals("null")?"":(String)arrCol.get(15);
							rs_familyName = arrCol.get(20).equals("null")?"":(String)arrCol.get(20);
							rs_encounterId = arrCol.get(26).equals("null")?"":(String)arrCol.get(26);
							rs_episode_id = arrCol.get(2).equals("null")?"":(String)arrCol.get(2);
							rs_sex = arrCol.get(4).equals("null")?"":(String)arrCol.get(4);
							rs_patientClass = arrCol.get(6).equals("null")?"":(String)arrCol.get(6);
							rs_custCode = arrCol.get(29).equals("null")?"":(String)arrCol.get(29);
							rs_transDate = arrCol.get(7).equals("null")?"":(String)arrCol.get(7);
							rs_trans_Id = arrCol.get(23).equals("null")?"":(String)arrCol.get(23);
							rs_user_name = arrCol.get(25).equals("null")?"":(String)arrCol.get(25);
							rs_visit_id = arrCol.get(24).equals("null")?"":(String)arrCol.get(24);
							rs_approval_status = arrCol.get(22).equals("null")?"":(String)arrCol.get(22);
							rs_request_status = arrCol.get(27).equals("null")?"":(String)arrCol.get(27);
							rs_event_type = arrCol.get(28).equals("null")?"":(String)arrCol.get(28);
							rs_trans_type = arrCol.get(30).equals("null")?"":(String)arrCol.get(30);
							rs_doc_num = arrCol.get(31).equals("null")?"":(String)arrCol.get(31);
							rs_doc_type = arrCol.get(32).equals("null")?"":(String)arrCol.get(32);
							rs_amount = arrCol.get(33).equals("null")?"":(String)arrCol.get(33);
							rs_adm_date = arrCol.get(34).equals("null")?"":(String)arrCol.get(34);
							rs_approval_status_desc = arrCol.get(35).equals("null")?"":(String)arrCol.get(35);

							System.out.println("MediMembershipQueryResult :: rs_event_type...."+rs_event_type+"rs_approval_status...."+rs_approval_status);	

							rs_event_type_desc = "";

							if(rs_patientClass.equals("OP")){
								rs_patientClass_desc = "Out Patient";
							}
							if(rs_patientClass.equals("IP")){
								rs_patientClass_desc = "In Patient";
							}
							if(rs_patientClass.equals("EM")){
								rs_patientClass_desc = "Emergency Patient";
							}
							if(rs_patientClass.equals("DC")){
								rs_patientClass_desc = "Day Care";
							}

							if(rs_approval_status.equals("") || rs_approval_status.equals(" ") ){
								rs_approval_status_desc = "-";
							}
							if(rs_event_type.equals("IDC")){
								rs_event_type_desc = "ID Check";
							}
							if(rs_event_type.equals("FAM")){
								rs_event_type_desc = "FAM Check";
							}
							if(rs_event_type.equals("IEC")){
								rs_event_type_desc = "Insured Eligiblity Check";
							}
							if(rs_event_type.equals("UEC")){
								rs_event_type_desc = "UnInsured Eligiblity Check";
							}
							
							if(rs_event_type.equals("CLA") || rs_event_type.equals("CLE")){
								rs_event_type_desc = "Claims";
							}
							if(rs_event_type.equals("REV")){
								rs_event_type_desc = "Reversal";
							}
							if(rs_event_type.equals("EOC")){
								rs_event_type_desc = "End Of Case";
							}

							rs_event_type_desc = rs_event_type_desc + " - " + rs_approval_status_desc;

							currentSubGroup =rs_patientId+"@"+rs_patientName+"@"+rs_sex+"@"+rs_patientClass+"@"+rs_episode_id;
							System.out.println("MediMembershipQueryResult :: currentSubGroup...."+currentSubGroup);	
							
							l_img_vw_dtl_str = "<input type='image' id='claims_img' src='../../eXH/images/blist.gif' alt='View History' style='width:20px; height: 20px;' onClick='ViewTransDetails(this)'   patient_id='"+rs_patientId+"' episode_id='"+rs_episode_id+"'  visit_id='"+rs_visit_id+"' doc_num='"+rs_doc_num+"'  bill_doc_code='"+rs_doc_type+"' trans_type='"+rs_trans_type+"' > ";

							if (rs_trans_type.equals("ECLREQ"))
							{

								l_event_trans_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, TRANS_TYPE, EVENT_TYPE, SRL_NO, CASE_NUM, "
											+"  nvl(APPROVAL_STATUS,'N') APPROVAL_STATUS "
											+"  from xf_eclaims_trx_hdr "
											+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
											+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
											+"								and DOC_TYPE_CODE = ? and DOC_NUM = ?) ";
											
								System.out.println("MediMembershipQueryResult :: l_event_trans_query...."+l_event_trans_query);								
								
								System.out.println("MediMembershipQueryResult :: dbConn...."+dbConn);

								pstmt = dbConn.prepareStatement(l_event_trans_query);
								
								pstmt.setString(1, rs_operating_facility_id);
								pstmt.setString(2, rs_patientId);
								pstmt.setString(3, rs_episode_id);
								pstmt.setString(4, rs_visit_id);
								pstmt.setString(5, rs_doc_type);
								pstmt.setInt(6, Integer.parseInt(rs_doc_num));
								
								rsevent = pstmt.executeQuery();

								l_event_trans_type = ""; l_srl_trans_no = 0; l_case_trans_no = ""; l_approval_trans_status =""; l_current_status = "";
								
								while(rsevent.next())
								{
								   l_event_trans_type = rsevent.getString("EVENT_TYPE")==null?"":rsevent.getString("EVENT_TYPE");  
								   l_srl_trans_no = rsevent.getInt("SRL_NO");
								   l_case_trans_no = rsevent.getString("CASE_NUM")==null?"":rsevent.getString("CASE_NUM"); 
								   l_approval_trans_status = rsevent.getString("APPROVAL_STATUS")==null?"":rsevent.getString("APPROVAL_STATUS"); 
								}
								
								String l_status_code = "N", l_status_type = "CLA", l_trans_event = "ECL";

								if (l_event_trans_type.equals("CLA"))
								{
									if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F"))
									{
										l_status_code = "N";
										l_status_type = "CLA";
									}
									
									if (l_approval_trans_status.equals("99"))
									{
										l_status_code = "S";
										l_status_type = "CLA";
									}
									
									if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P") || l_approval_trans_status.equals("W"))
									{
										l_status_code = "P";
										l_status_type = "CLA";
									}

									if (l_approval_trans_status.equals("0") || l_approval_trans_status.equals("1") || l_approval_trans_status.equals("2") || l_approval_trans_status.equals("3") || l_approval_trans_status.equals("4"))
									{
										l_status_code = l_approval_trans_status;
										l_status_type = "CLA";
										l_trans_event = "ERA";
									}
								}

								if (l_event_trans_type.equals("REV"))
								{
									if (l_approval_trans_status.equals("99"))
									{
										l_status_code = "S";
										l_status_type = "CLA";
									}

									if (l_approval_trans_status.equals("A"))
									{
										l_status_code = "N";
										l_status_type = "CLA";
									}
									
									if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F"))
									{
										l_status_code = "P";
										l_status_type = "CLA";
									}
								}

								if (l_event_trans_type.equals("EOC"))
								{
									if (l_approval_trans_status.equals("99"))
									{
										l_status_code = "S";
										l_status_type = "EOC";
									}

									if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P"))
									{
										l_status_code = "P";
										l_status_type = "EOC";
									}
									
									if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F"))
									{
										l_status_code = "P";
										l_status_type = "CLA";
									}
								}

								if (l_event_trans_type.equals("CLE"))
								{
									if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F"))
									{
										l_status_code = "N";
										l_status_type = "CLA";
									}
									
									if (l_approval_trans_status.equals("99"))
									{
										l_status_code = "S";
										l_status_type = "EOC";
									}
									
									if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P") || l_approval_trans_status.equals("W"))
									{
										l_status_code = "P";
										l_status_type = "EOC";
									}

									if (l_approval_trans_status.equals("0") || l_approval_trans_status.equals("1") || l_approval_trans_status.equals("2") || l_approval_trans_status.equals("3") || l_approval_trans_status.equals("4"))
									{
										l_status_code = l_approval_trans_status;
										l_status_type = "CLA";
										l_trans_event = "ERA";
									}
								}

								rsevent = null;
								
								String l_status_query = "";

								l_status_query = "Select STATUS_DESC from  XH_TRANS_STATUS "										
														+"	where TRANS_EVENT = ? AND TRANS_TYPE = ? AND STATUS_CODE = ? ";
														
								System.out.println("l_event_trans_query...."+l_event_trans_query);

								pstmt = dbConn.prepareStatement(l_status_query);
								pstmt.setString(1, l_trans_event);
								pstmt.setString(2, l_status_type);
								pstmt.setString(3, l_status_code);				

								rsevent = pstmt.executeQuery();

								rs_approval_status_desc ="";

								while(rsevent.next())
								{				   
								   l_current_status = rsevent.getString("STATUS_DESC")==null?"":rsevent.getString("STATUS_DESC"); 
								} 
							}

									
							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup))
							{
								if (j>0) {
								%>
									</table>
									</td>
									</tr>
								<%
								}
								String str="";	
								%>
								<tr width='100%' id = 'trGrpHeader<%=j%>' >								
								<td width='300' style='display:block' class='CAGROUP' ><%=rs_patientId%></td>
								<td width='300' style='display:block' class='CAGROUP'><%=rs_patientName%></td>
								<td width='300' style='display:block' class='CAGROUP'><%=rs_sex%></td>
								<td width='300' style='display:block' class='CAGROUP'><%=rs_dob%></td>
								<td width='300' style='display:block' class='CAGROUP'><%=rs_patientClass_desc%></td>
								<td width='300' style='display:block' class='CAGROUP'><%=rs_adm_date%></td>
								<td width='300' style='display:block' class='CAGROUP'><%=rs_episode_id%> </td>
								</tr>
								<tr>
								<td colspan = "8">
								<table  cellspacing="0" cellpadding="3" width="100%" border="1" align="center">
								<tr>
								<td class='COLUMNSUBHEADER' style="font-size:11px;" width='8%' align="center">
									<font color=white><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></font>
								</td>
								<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='12%'>
									<font color=white ><fmt:message key="Common.username.label" bundle="${common_labels}"/></font>
								</td>	
								<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='10%'>
									<font color=white><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}"/></font>
								</td>
								<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='10%'>
									<font color=white><fmt:message key="eBL.BILL_DOC_TYPE.label" bundle="${bl_labels}"/></font>
								</td>
								<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='10%'>
									<font color=white ><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></font>
								</td>			
								<td class='COLUMNSUBHEADER' style="font-size:11px;" width='8%'>
									<font color=white><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></font>
								</td>
								<td class='COLUMNSUBHEADER' style="font-size:11px;" width='12%'>
									<font color=white><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/></font>
								</td>
								<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
									<font color=white><fmt:message key="Common.Last.label" bundle="${common_labels}"/> <fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></font>
								</td>
								<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
									<font color=white ><fmt:message key="Common.current.label" bundle="${common_labels}"/> <fmt:message key="Common.status.label" bundle="${common_labels}"/></font>
								</td>		
								<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
									<font color=white ><fmt:message key="Common.view.label" bundle="${common_labels}"/> <fmt:message key="Common.History.label" bundle="${common_labels}"/></font>
								</td>	
								</tr>
								<tr>
							<%
							}
							else
							{
								%>
								<tr>
								<%
							}

							checkboxvalue = "<img src='../../eXH/images/ViewDetails.gif' style='width:20px; height: 20px;' alt='Check Details' align='middle' onClick='checkEligibility(this)'   trans_num='"+rs_trans_Id+"' event_type='"+rs_event_type+"' >";
							   
						
							if (!(rs_doc_num.length()>0))
								rs_doc_num = "-";

							if (!(rs_doc_type.length()>0))
								rs_doc_type = "-";

							if (!(rs_amount.length()>0))
								rs_amount = "-";

							Checkboxname = "Check-"+j;
							%>
							<td class='gridData' align='center'><%=checkboxvalue%></td>
							<td  class='gridData' style="font-size:11px;"> <%=rs_user_name%> </td>
							<td  class='gridData' style="font-size:11px;"> <%=rs_doc_num%> </td>
							<td  class='gridData' style="font-size:11px;"> <%=rs_doc_type%> </td>
							<td  class='gridNumericData' style="font-size:11px;"> <%=rs_amount%> </td>
							<td  class='gridData' style="font-size:11px;"> <%=rs_trans_Id%> </td>
							<td  class='gridData' style="font-size:11px;"> <%=rs_transDate%> </td>
							<td  class='gridData' style="font-size:11px;"> <%=rs_event_type_desc%> </td>
							<td  class='gridData' style="font-size:11px;"> <%=l_current_status%></td>
							<td  class='gridData' style="font-size:11px;"> <%=l_img_vw_dtl_str%></td>
							</tr>
							<%
							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){

							}
							prevSubGroup = currentSubGroup; 
							System.out.println("prevSubGroup...."+prevSubGroup);
							}
							if ((j>0) && (j==billDetailsRowCount)){
							%>
								</table>
								</td>
								</tr>	
							<%
							}
						%>
						</table>
						</div>
		
			<%
				}
				if(arrRow!=null) arrRow.clear();
				if(arrCol!=null) arrCol.clear();
				if(resultsQry!=null) resultsQry.clear();

			}catch(Exception e1)
				{
				 System.out.println("(MediMembershipQueryResult.jsp:Exception)"+e1);
				 e1.printStackTrace(System.err);
				}
				finally
				{
				ConnectionManager.returnConnection(conn);
				}
	%>
	</table>
	</form>
</body>
</html>

