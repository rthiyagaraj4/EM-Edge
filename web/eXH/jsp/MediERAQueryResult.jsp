<!DOCTYPE html>
<HTML>
<%@ page import= "java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter,java.text.SimpleDateFormat" %>

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
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>

<script language="javascript">

function funSubmit()
{
	parent.resultFrame.ERA_QUERY_FORM.action = '../../eXH/jsp/MediERAQueryResult.jsp';
	parent.resultFrame.ERA_QUERY_FORM.target="resultFrame";
	parent.resultFrame.ERA_QUERY_FORM.submit();
}

	function funAction(typ)
	{  
		parent.resultFrame.ERA_QUERY_FORM.action_type.value = typ;
		funSubmit();
	}

	//function callForOrderBy
	function callForOrderBy(obj,order)
	{	
		if(order == 'A') obj = obj + ' asc';
		if(order == 'D') obj = obj + ' desc';
		var url = '&orderBy=' + obj + '&order=' + order;

	this.document.forms[0].action_type.value = "";
	this.document.forms[0].action = "../../eXH/jsp/MediERAQueryResult.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
}

	async function checkEligibility(obj)
	{	
		var checkType = "";
		
		var checkTypeButtons = document.getElementsByName('CheckType');

		var trans_num = obj.getAttribute('trans_num');
		var event_type = obj.getAttribute('event_type');
		var era_id = obj.getAttribute('era_id');

		if ((trans_num == "") || (trans_num == "0"))
		{
			alert("Claim ID is not available for the ERA transaction selected, no details can be displayed.");
			return;
		}

		
		var dialogHeight = "45vh";    // have to remove 
		var dialogWidth  = "80vw";
		var dialogTop    = "50";

		var title="ERA Response Details ";
		title=encodeURIComponent(title);
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

		var params= "trans_num="+trans_num+"&era_id="+era_id;

	var arguments = new Array();
	var url = "../../eXH/jsp/MediERAQueryResponsePopUp.jsp?" +params;
	
	var retVal = await window.showModalDialog(url,arguments,features);
      
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
	function toggle(doc_num)
	{
		 if( document.getElementById("hidethis"+doc_num).style.display=='none' ){
		   document.getElementById("hidethis"+doc_num).style.display = 'table'; // set to table-row instead of an empty string
		 }else{
		   document.getElementById("hidethis"+doc_num).style.display = 'none';
		 }
	}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >
	<form name="ERA_QUERY_FORM" id="ERA_QUERY_FORM" method="POST" action=''  >
	<%
		String order = "";
		String orderBy = "";
		String action_type=null;
		Connection conn = null;
		Statement stmt=null;
		ResultSet rset=null ;
		String event_type = "";
		String dest_code = "";


		String era_from_dt="",era_to_dt = "", from_era_id = "", to_era_id = "", to_claim_id = "", from_claim_id = "", claim_status_type = "";
        String rs_mk_era_no = "" ,rs_mk_era_date = "",rs_scheme_name = "",rs_era_trans_no = "",rs_trans_date = "", rs_era_type = "",rs_prov_paid_amount = "", rs_pat_paid_amount = ""; String rs_actual_amount_paid = "", rs_process_statu =  "",rs_claim_id  = "",rs_prov_claim_no = "",rs_sheme_claim_no = "",rs_mem_plicy_num = "",rs_patient_initials = "";	String rs_patient_first_name = "",rs_surname = "",rs_patient_dob = "",rs_claim_patient_deptcode = "",rs_claimed_by_provider = "",rs_paid_to_provider = "";			
		String rs_paid_to_member = "",rs_not_paid = "",	rs_claim_status = "",rs_process_ack_message = "",rs_process_error_message ="",rs_bill_doc_type_code = "",rs_era_date="";		String rs_bill_doc_number = "",rs_process_status = "",rs_claim_status_desc = "", rs_process_status_desc = "", rs_era_status_desc = "";

		String rs_patient_id = "", rs_patient_name = "", rs_claimed_amount = "", rs_approved_amount = "", rs_event_type = "";

		String l_adj_query = "";

		String l_mk_era_no = "",l_prov_claim_id =  "",l_adj_date = "",l_adj_amount = "", l_adj_desc = ""; 

		String l_adj_image_str = "";

		String rs_era_date_desc = "";

		String checkboxvalue = "",rs_trans_Id = "";
         

		String  currentSubGroup = "",prevSubGroup = "";
		HttpSession httpSession = request.getSession(false);
		era_from_dt = XHDBAdapter.checkNull(request.getParameter("era_from_dt"));
		era_to_dt= XHDBAdapter.checkNull(request.getParameter("era_to_dt"));
		from_era_id = XHDBAdapter.checkNull(request.getParameter("from_era_id"));
		to_era_id = XHDBAdapter.checkNull(request.getParameter("to_era_id"));
		to_claim_id = XHDBAdapter.checkNull(request.getParameter("to_claim_id"));
		from_claim_id = XHDBAdapter.checkNull(request.getParameter("from_claim_id"));
		claim_status_type = XHDBAdapter.checkNull(request.getParameter("claim_status_type"));

		if(era_from_dt!="" && era_from_dt!=null && era_from_dt!=" ")
		{
		   era_from_dt = era_from_dt+ " 00:00:00";
		}

		//String trans_to_dt = XHDBAdapter.checkNull(request.getParameter("trans_to_dt"));
		if(era_to_dt!="" && era_to_dt!=null && era_to_dt!=" ")
		{
		   era_to_dt =era_to_dt + " 23:59:59";
		}	

		String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

		if(isDebugYN.equals("Y")){
			System.out.println("MediERAQueryResult.jsp:::claim_status_type....."+claim_status_type);
			System.out.println("MediERAQueryResult.jsp:::era_from_dt....."+era_from_dt+" era_to_dt :::: "+era_to_dt );
			System.out.println("MediERAQueryResult.jsp:::from_era_id....."+from_era_id +"::: to_era_id ::: "+to_era_id);
			System.out.println("MediERAQueryResult.jsp:::from_claim_id....."+from_claim_id +"::: to_claim_id ::: "+to_claim_id);
		}
		/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

		boolean  boolToggle = true;
		String strTDClass = "";
		String whereClause = "";
		int totalRecords=0;

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		ArrayList arrRows = new ArrayList();
        ArrayList arrColumns = new ArrayList();

		try
		{ 
			conn = ConnectionManager.getConnection(request);

			whereClause = " ";
			int count = 0;
			if(era_from_dt!="" && era_from_dt!=null && era_to_dt!="" && era_to_dt!=null)
			{	
				if(count == 0){
					whereClause = whereClause + " where TO_Date(ERA_TRANS_DATE ,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+era_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+era_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
				}
				else{
                    whereClause = whereClause + " And TO_Date(ERA_TRANS_DATE ,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+era_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+era_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
				}
				count++;
			}

			if(from_era_id != null && from_era_id != "" && from_era_id != " " && to_era_id != null && to_era_id != "" && to_era_id != " ")
			{
				if(count ==0){
                   whereClause = whereClause + " where MK_ERA_NO BETWEEN '#from_era_id' AND '#to_era_id' ";
				}
				else{
				 whereClause = whereClause + " AND MK_ERA_NO BETWEEN '#from_era_id' AND '#to_era_id' ";
				}
				count++;
			}
			if(from_claim_id != null && from_claim_id != "" && from_claim_id != " " && to_claim_id != null && to_claim_id != "" && to_claim_id != " ")
			{
				if(count ==0){
				whereClause = whereClause + " where  PROV_CLAIM_NO BETWEEN '#from_claim_id' AND '#to_claim_id' ";
				}
                else{
                     whereClause = whereClause + " AND PROV_CLAIM_NO BETWEEN '#from_claim_id' AND '#to_claim_id' ";
				 }
				 count++;
			}
			if(claim_status_type != null && claim_status_type != "" && claim_status_type != " " )
			{ 
				if(count ==0){
					whereClause = whereClause + " where CLAIM_STATUS =  '#claim_status_type' ";  
				}
				else{
                    whereClause = whereClause + " AND CLAIM_STATUS =  '#claim_status_type' "; 
				}
			}
			whereClause = whereClause + " order by MK_ERA_NO, PROV_CLAIM_NO ";

			request.setAttribute(XHQueryRender.strQueryId,"MEDICLAIMSERAPROCESS");

			if(isDebugYN.equals("Y")){
				System.out.println("MediERAQueryResult.jsp :: whereClause....."+whereClause);
			}
			request.setAttribute(XHQueryRender.col,"35"); 
			request.setAttribute(XHQueryRender.maxRec,"6");
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
			String strPrevious = "Previous";
			String strNext  = "Next";
			if (boolPrevious == true)
			{
				strPrevious = "Previous";
			}
			else
			{
				strPrevious = " ";
			}
			if (boolNext== true)
			{
				strNext  = "Next";
			}
			else
			{
				strNext  = " ";
			}
			if(isDebugYN.equals("Y")){
				System.out.println("MediERAQueryResult.jsp :: action_type in jsp...."+action_type);
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
						<td colspan="27" class="COLUMNHEADER" align='center'>ERA Query Result</td>
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
								<font color=white><fmt:message key="eXH.ERANumber.label" bundle="${xh_labels}"/></font>
							</td>
							<td class='COLUMNHEADER' width='8%'>
								<font color=white><fmt:message key="eXH.ERADate.label" bundle="${xh_labels}"/></font>
							</td>
                            <td class='COLUMNHEADER' width='15%'>
								<font color=white ><fmt:message key="eXH.schemecode.label" bundle="${xh_labels}"/></font>
							</td>
					        <td class='COLUMNHEADER' width='5%'>
								<font color=white><fmt:message key="eXH.ERAtype.label" bundle="${xh_labels}"/></font>
							</td>
					        <td class='COLUMNHEADER' width='8%'>
								<font color=white> <fmt:message key="Common.Transaction.label" bundle="${common_labels}"/><fmt:message key="eBL.NUM.label" bundle="${bl_labels}"/></font>
							</td>
					
							<td class='COLUMNHEADER' width='10%' align = "right">
								<font color=white><fmt:message key="eBL.PAID_AMT.label" bundle="${bl_labels}"/></font>
							</td>	
							<td class='COLUMNHEADER' width='15%'>
								<font color=white ><fmt:message key="Common.status.label" bundle="${common_labels}"/></font>
							</td>
						</tr>
					    <input type='hidden' name='action_type' id='action_type' value='<%=action_type%>'>		     

						<%
						System.out.println("MediERAQueryResult.jsp :: Before getting details....."+arrRow.size());
						Map cmp = new HashMap();
                        int j=0;
						totalRecords=0;
						for (j=0; j<arrRow.size();j++)
						{
							rs_mk_era_no = ""; rs_mk_era_date = ""; rs_scheme_name = ""; rs_era_trans_no = ""; rs_trans_date = "";  rs_era_type = ""; rs_prov_paid_amount = "";  rs_pat_paid_amount = ""; rs_actual_amount_paid = "";  rs_process_status =  ""; rs_claim_id  = ""; rs_prov_claim_no = ""; rs_sheme_claim_no = ""; rs_mem_plicy_num = ""; 
							
							rs_patient_initials = "";	rs_patient_first_name = ""; rs_surname = ""; rs_patient_dob = ""; rs_claim_patient_deptcode = ""; rs_claimed_by_provider = ""; rs_paid_to_provider = "";			
							rs_paid_to_member = ""; rs_not_paid = ""; 	rs_claim_status = ""; rs_process_ack_message = ""; rs_process_error_message =""; rs_bill_doc_type_code = ""; rs_era_date="";	rs_bill_doc_number = ""; rs_process_status = ""; rs_claim_status_desc = ""; rs_era_status_desc = "";

							rs_patient_id = "";  rs_patient_name = "";  rs_claimed_amount = "";  rs_approved_amount = ""; rs_event_type = "";
 
							rs_era_date_desc = "";

							arrCol = (ArrayList)arrRow.get(j);
							rs_mk_era_no = arrCol.get(0).equals("null")?"":(String)arrCol.get(0);
							rs_mk_era_date = arrCol.get(1).equals("null")?"":(String)arrCol.get(1);
							rs_scheme_name = arrCol.get(2).equals("null")?"":(String)arrCol.get(2);
							rs_era_trans_no = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);
							rs_era_date = arrCol.get(4).equals("null")?"":(String)arrCol.get(4);
							rs_era_type = arrCol.get(5).equals("null")?"":(String)arrCol.get(5);
							rs_prov_paid_amount = arrCol.get(6).equals("null")?"":(String)arrCol.get(6);
							rs_pat_paid_amount = arrCol.get(7).equals("null")?"":(String)arrCol.get(7);
							rs_actual_amount_paid = arrCol.get(8).equals("null")?"":(String)arrCol.get(8);
							rs_process_status= arrCol.get(9).equals("null")?"":(String)arrCol.get(9);
							rs_claim_id = arrCol.get(10).equals("null")?"":(String)arrCol.get(10);
							rs_prov_claim_no = arrCol.get(11).equals("null")?"":(String)arrCol.get(11);
							rs_sheme_claim_no = arrCol.get(12).equals("null")?"":(String)arrCol.get(12);
							rs_mem_plicy_num = arrCol.get(13).equals("null")?"":(String)arrCol.get(13);
							rs_patient_initials = arrCol.get(14).equals("null")?"":(String)arrCol.get(14);
							rs_patient_first_name = arrCol.get(15).equals("null")?"":(String)arrCol.get(15);
							rs_surname = arrCol.get(16).equals("null")?"":(String)arrCol.get(16);
							rs_patient_dob = arrCol.get(17).equals("null")?"":(String)arrCol.get(17);
							rs_claim_patient_deptcode = arrCol.get(18).equals("null")?"":(String)arrCol.get(18);
							rs_claimed_by_provider = arrCol.get(19).equals("null")?"":(String)arrCol.get(19);
							rs_paid_to_provider = arrCol.get(20).equals("null")?"":(String)arrCol.get(20);
							rs_paid_to_member= arrCol.get(21).equals("null")?"":(String)arrCol.get(21);
							rs_not_paid = arrCol.get(22).equals("null")?"":(String)arrCol.get(22);
							rs_claim_status = arrCol.get(23).equals("null")?"":(String)arrCol.get(23);
							rs_process_ack_message = arrCol.get(24).equals("null")?"":(String)arrCol.get(24);
							rs_process_error_message = arrCol.get(25).equals("null")?"":(String)arrCol.get(25);
							rs_bill_doc_type_code = arrCol.get(26).equals("null")?"":(String)arrCol.get(26);
							rs_bill_doc_number = arrCol.get(27).equals("null")?"":(String)arrCol.get(27);

							rs_patient_id = arrCol.get(28).equals("null")?"":(String)arrCol.get(28);
							rs_patient_name = arrCol.get(29).equals("null")?"":(String)arrCol.get(29);
							rs_claimed_amount = arrCol.get(30).equals("null")?"":(String)arrCol.get(30);
							rs_approved_amount = arrCol.get(31).equals("null")?"":(String)arrCol.get(31);

							rs_event_type = arrCol.get(32).equals("null")?"":(String)arrCol.get(32);

							rs_claim_status_desc = arrCol.get(33).equals("null")?"":(String)arrCol.get(33);

							rs_era_status_desc = arrCol.get(34).equals("null")?"":(String)arrCol.get(34);

							/*

							if (rs_claim_status.equals("2") || rs_claim_status.equals("3") || rs_claim_status.equals("4"))
								rs_claim_status_desc = rs_process_error_message;

								*/

							if (rs_claim_id.equals("0"))
								rs_claim_id = "";

                            String result = "";
							SimpleDateFormat sdf;
							SimpleDateFormat sdf1;
                            System.out.println(":: rs_mk_era_date :: "+rs_mk_era_date);

							String hideTable = "style='display:none;'";

							/*try {
								//sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
								//sdf1 = new SimpleDateFormat("dd/MM/yyyy");
								//rs_era_date = sdf1.format(sdf.parse(rs_era_date));
								SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
								Date dateObj = sourceDateFormat.parse(rs_trans_date);
								SimpleDateFormat desiredDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
								rs_trans_date = desiredDateFormat.format(dateObj).toString();

								SimpleDateFormat sourceDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
								Date dateObj1 = sourceDateFormat1.parse(rs_mk_era_date);
								SimpleDateFormat desiredDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
								rs_mk_era_date = desiredDateFormat1.format(dateObj1).toString();


								 System.out.println(":: rs_mk_era_date :: "+rs_mk_era_date);
							}
							catch(Exception e) {
								e.printStackTrace();
							}*/
							l_adj_query = "Select CLAIM_ID, PROV_CLAIM_NO,TO_CHAR (ADJUSTMENT_DATE,'DD/MM/YYYY') ADJUSTMENT_DATE,TO_CHAR (ADJUSTMENT_AMOUNT, 9999990.99) ADJUSTMENT_AMOUNT, ADJUSTMENT_DESC" 
												+" from XF_ERA_ADJ a, XF_ERA_CLAIM b"
												+"		where A.MK_ERA_NO = B.MK_ERA_NO"
												+"				and A.BILL_DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE"
												+"				and A.BILL_DOC_NUMBER = B.BILL_DOC_NUMBER "
												+"				and A.MK_ERA_NO = ? AND B.PROV_CLAIM_NO = ? ";

							System.out.println("l_adj_query...."+l_adj_query);

							pstmt = conn.prepareStatement(l_adj_query);
							pstmt.setString(1, rs_mk_era_no);
							pstmt.setString(2, rs_claim_id);

							rs = pstmt.executeQuery();

							while(rs.next())
							{
								l_mk_era_no = rs.getString("CLAIM_ID")==null?"":rs.getString("CLAIM_ID"); 
								l_prov_claim_id =  rs.getString("PROV_CLAIM_NO")==null?"":rs.getString("PROV_CLAIM_NO");
								l_adj_amount = rs.getString("ADJUSTMENT_AMOUNT")==null?"":rs.getString("ADJUSTMENT_AMOUNT"); 
								l_adj_desc = rs.getString("ADJUSTMENT_DESC")==null?"":rs.getString("ADJUSTMENT_DESC"); 
								l_adj_date = rs.getString("ADJUSTMENT_DATE")==null?"":rs.getString("ADJUSTMENT_DATE"); 

								arrColumns.add(l_mk_era_no);
								arrColumns.add(l_prov_claim_id);
								arrColumns.add(l_adj_amount);
								arrColumns.add(l_adj_desc);
								arrColumns.add(l_adj_date);

								arrRows.add(arrColumns);
								arrColumns = new ArrayList();
								arrColumns.clear();
							}
    						currentSubGroup = rs_mk_era_no+"@"+rs_mk_era_date+"@"+rs_scheme_name+"@"+rs_era_type+"@"+rs_prov_paid_amount;
							System.out.println("currentSubGroup...."+currentSubGroup);			
									
							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup))
							{
								if (j>0) {
									out.println("</table>");
									out.println("</td>");
									out.println("</tr>");
								}
								String str="";							
								out.println("<tr width='100%' id = 'trGrpHeader"+j+"' >");								
								out.println("<td width='300' style='display:block' class='CAGROUP' >"+rs_mk_era_no+"&nbsp;</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP'>"+rs_mk_era_date+"&nbsp;</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP'>"+rs_scheme_name+"&nbsp;</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP'>"+rs_era_type+"&nbsp;</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP'>"+rs_era_trans_no+"&nbsp;</td>");
								out.println("<td width='300' class='CAGROUP' align = \"right\" >&nbsp;"+rs_prov_paid_amount+"</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP' align = \"right\" >"+rs_era_status_desc+"&nbsp; </td>");
								out.println("</tr>");
								out.println("<tr>");
								out.println("<td colspan = \"7\">");
								out.println("<table  cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"1\" align=\"center\">");
								out.println("<tr>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='3%'>");
									out.println("<font color=white >View</font>");
								out.println("</td>	");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='5%'>");
									out.println("<font color=white >Claim Id</font>");
								out.println("</td>	");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='8%'>");
									out.println("<font color=white>Bill Doc. Type  Bill No.</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='7%'>");
									out.println("<font color=white>Patient ID</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='15%'>");
									out.println("<font color=white><fmt:message key=\"Common.PatientName.label\" bundle=\"${common_labels}\"/></font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='7%'>");
									out.println("<font color=white>Policy No</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='8%' align = \"right\">");
									out.println("<font color=white>Claimed Amount</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='8%' align = \"right\">");
									out.println("<font color=white>Approved Amount</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='8%' align = \"right\">");
									out.println("<font color=white >Received Amount</font>");
								out.println("</td>	");								
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='15%'>");
									out.println("<font color=white><fmt:message key=\"eXH.claimstatus.label\" bundle=\"${xh_labels}\"/>Claim Status</font>");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='15%'>");
									out.println("<font color=white>Status Description</font>");
								out.println("</td>");															
								out.println("</tr>");
								out.println("<tr>");
							}
							else
							{
								out.println("<tr>");
							}

                            checkboxvalue = "<img src='../../eXH/images/ViewDetails.gif' style='width:20px; height: 20px;' alt='Check Details' align='middle'   onClick='checkEligibility(this)'  trans_num='"+rs_claim_id+"' event_type='"+rs_event_type+"'  era_id='"+rs_mk_era_no+"'>";
							//checkboxvalue =rs_patient_id+"$!^"+rs_sex+"$!^"+rs_family_name+"$!^"+rs_episode_id+"$!^"+rs_encounter_id+"$!^"+rs_patient_class+"$!^"+rs_visit_adm_date_time+"$!^"+rs_visit_adm_type+"$!^"+rs_service_code+"$!^"+rs_discharge_date_time+"$!^"+rs_operating_facility_id+"$!^"+rs_doc_type_code+"$!^"+rs_doc_num+"$!^"+rs_doc_date+"$!^"+rs_bill_from_date+"$!^"+rs_bill_to_date+"$!^"+rs_visit_id+"$!^"+rs_cust_code+"$!^"+rs_blng_grp_id+"$!^";		
							if(arrRows.size()>0)
							{
								l_adj_image_str = "<img src='../../eXH/images/ViewDetails.gif' style='width:15px; height: 15px;margin-top :-15px;' alt='View Adjustment Details' align='right' onClick=\"toggle('"+rs_mk_era_no+""+rs_claim_id+"')\"/>";
							}
							else
								l_adj_image_str = "";

							out.println("<td class='gridData' align='center'>"+checkboxvalue+"</td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_claim_id+" "+l_adj_image_str+"&nbsp;</td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_bill_doc_type_code+"/"+rs_bill_doc_number+"&nbsp; </td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_patient_id+"&nbsp; </td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_patient_name+" &nbsp;</td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_mem_plicy_num+"&nbsp; </td>");
							out.println("<td  class='gridNumericData' style=\"font-size:11px;\" align = \"right\" > &nbsp; "+rs_claimed_amount+"</td>");
							out.println("<td  class='gridNumericData' style=\"font-size:11px;\" align = \"right\" > &nbsp; "+rs_approved_amount+"</td>");
							out.println("<td  class='gridNumericData' style=\"font-size:11px;\" align = \"right\" > &nbsp;"+rs_paid_to_provider+" </td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_claim_status_desc+"&nbsp; </td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_process_error_message+"&nbsp; </td>");
							out.println("</tr>");

							String id="hidethis"+rs_mk_era_no+""+rs_claim_id;
                            if(arrRows.size()>0)
							{
								%><tr id = "<%=id%>" <%=hideTable%>><%
								out.println("<td colspan = \"10\">");
								out.println("<table  cellspacing=\"0\" cellpadding=\"3\" width=\"95%\" border=\"1\" align=\"right\" border=\"1\" align=\"center\">");
								out.println("<tr>");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='8%'>");
									out.println("<font color=white ><fmt:message key=\"eXH.ClaimNumber.label\" bundle=\"${xh_labels}\"/></font>");
								out.println("</td>	");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='8%'>");
									out.println("<font color=white ><fmt:message key=\"eBL.ADJUSTMENT_AMT.label\" bundle=\"${bl_labels}\"/></font>");
								out.println("</td>	");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='20%'>");
									out.println("<font color=white><fmt:message key=\"eXH.adjDesc.label\" bundle=\"${xh_labels}\"/></font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='14%'>");
									out.println("<font color=white><fmt:message key=\"eXH.adjDate.label\" bundle=\"${xh_labels}\"/></font>");
								out.println("</td>");
								out.println("</tr>");
								
								for (int k=0; k<arrRows.size();k++)
								 {
									arrColumns = (ArrayList)arrRows.get(k);
									out.println("<tr>");
									out.println("<td  class='gridData' style=\"font-size:11px;\"> "+arrColumns.get(1)+"&nbsp; </td>");
									out.println("<td  class='gridNumericData' style=\"font-size:11px;\"align = \"right\">&nbsp; "+arrColumns.get(2)+" </td>");
									out.println("<td  class='gridData' style=\"font-size:11px;\"> "+arrColumns.get(3)+"&nbsp; </td>");
									out.println("<td  class='gridData' style=\"font-size:11px;\"> "+arrColumns.get(4)+"&nbsp; </td>");
									out.println("</tr>");
									arrColumns.clear();
								}
								
								out.println("</table>");
								out.println("</td>");
								out.println("</tr>");
								
							}
                            if(arrRows!=null) arrRows.clear();

							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){

							}
							prevSubGroup = currentSubGroup; 
							System.out.println("prevSubGroup...."+prevSubGroup);
							}
							if ((j>0) ){
								out.println("</table>");
								out.println("</td>");
								out.println("</tr>");			
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
				 out.println("(MediERAQueryResult.jsp:Exception) "+e1);
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

