<!DOCTYPE html>
<%@page import="org.apache.derby.tools.sysinfo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,eBL.BLReportIdMapper,webbeans.op.CurrencyFormat,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript' src='../../eBL/js/BLEClaim.js'></script>
<script language='javascript' src='../../eBL/js/RCMTransactions.js'></script>

<style type="text/css">
span.a
{
	background: #ffffff;
	border: solid 1px #CCCCCC;
	height: 150px;
	display:inline-block;
    margin:10px 0;
    border-radius:5px;
	cursor: pointer;
}
.box_title2
{
	width: 220px;
	height: 35px;
    font-size: 12px;
    font-weight: normal;
    padding-left: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 10px;
    color: #ffffff;
    <%if(sStyle.equals("IeStyle.css")){%>
    background-color: #83AAB4;
    <%}
    else if(sStyle.equals("IeStyleLime.css")){%>
    background-color: #A3BF8A;
    <%}
    else if(sStyle.equals("IeStyleOrange.css")){%>
    background-color: #DDC68E;
    <%}
    else if(sStyle.equals("IeStyleBlue.css")){%>
    background-color: #B2B6D7;
    <%}
    else if(sStyle.equals("IeStyleVoilet.css")){%>
    background-color: #D696D0;
    <%}%>
    line-height: 10px;
    font-family: verdana;
	text-align: center;
	white-space: nowrap;
	
}
.box_text
{
	padding-left: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 10px;
	font-family: verdana;
	text-align: center;
	vertical-align: middle;

}
.txt
{
	font-family: verdana;
	font-size: 30pt;
	font-weight: bold;
}
.text
{
	padding-left: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 10px;
	font-family: verdana;
	text-align: center;
	vertical-align: middle;

}	
</style>
</head>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
%>

<%!	
	private String checkForNull(String inputString, String dfltVal)
	{
		return (inputString == null) ? dfltVal : inputString;
	}
%>

<%
	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rst=null;
	String sql = "";
	int row_count = 0;
	int column_count = 1;
	int totalBillServices = 0;
	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_user = (String) p.getProperty("login_user");
	System.err.println("login_user in BLEClaimsStatusWiseDashboard.jsp:"+login_user);
	
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("locale");
	if(locale == null) locale = "en";
	String qry_patient_id = checkForNull(request.getParameter("patient_id"));
	String qry_encounter_id = checkForNull(request.getParameter("encounter_id"));
	String qry_episode_type = checkForNull(request.getParameter("episode_type"));
	String qry_payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String qry_payer_code = checkForNull(request.getParameter("payer_code"));
	String qry_policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String qry_State_dur_from_date = checkForNull(request.getParameter("State_dur_from_date"));
	String qry_State_dur_to_date = checkForNull(request.getParameter("State_dur_to_date"));
	String qry_insurance_Status = checkForNull(request.getParameter("insurance_Status"));	
	String qry_approval_doc_ref_no = checkForNull(request.getParameter("approval_doc_ref_no"));
	String qry_claim_id = checkForNull(request.getParameter("claim_id"));
	String qry_cusName = checkForNull(request.getParameter("cusName"));
	String qry_claims_services_level = checkForNull(request.getParameter("claims_services_level"));
	//String prevActionID = checkForNull(request.getParameter("prevActionID"));
	
	System.err.println("URL Parameters :- Payer Name= "+qry_cusName+", Patient_id= "+qry_patient_id+", Episode_type="+qry_episode_type+" , Encounter_id="+qry_encounter_id+", Statement_duration_from_date="+qry_State_dur_from_date+", Statement_duration_to_date="+qry_State_dur_to_date+", Insurance_Status="+qry_insurance_Status+", Payer_grp_code="+qry_payer_grp_code+", Payer_code="+qry_payer_code+", Policy_type_code="+qry_policy_type_code+", Approval_doc_ref_no="+qry_approval_doc_ref_no+", Claim_id="+qry_claim_id+", facilityId = "+facilityId+", Claims_services_level = "+qry_claims_services_level);
%>

<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
<form id = "statusWiseDashboard" name = "statusWiseDashboard">
<%
	try{
		con	=	ConnectionManager.getConnection(request);
		sql = "SELECT b.claim_status,l.list_elmt_label claim_status_name, COUNT (1) cnt FROM BL_CLAIM_BILL_DTL b, SM_LIST_ITEM l WHERE b.operating_facility_id = ? ";
		if(!"".equals(qry_patient_id)){
			sql = sql + "AND b.patient_id = ? ";
		}	
		if(!"".equals(qry_episode_type)){
			sql = sql + "AND b.EPISODE_TYPE = ? ";
		}
		if(!"".equals(qry_encounter_id)){
			sql = sql + "AND b.encounter_id = ? ";
		}
		if(!"".equals(qry_payer_grp_code)){
			sql = sql + "AND b.cust_group_code = ? ";
		}
		if(!"".equals(qry_payer_code)){
			sql = sql + "AND b.cust_code = ? ";
		}
		if(!"".equals(qry_policy_type_code)){
			sql = sql + "AND b.policy_type_code = ? ";
		}
		if(!"".equals(qry_approval_doc_ref_no)){
			sql = sql + "AND b.appr_doc_ref_number = ? ";
		}
		if(!"".equals(qry_claim_id)){
			sql = sql + "AND b.claim_id = ? ";
		}
		if(!qry_insurance_Status.equals("**")){
	        sql = sql + "AND b.claim_status = ? ";
		}
		if(!"".equals(qry_State_dur_from_date) && !"".equals(qry_State_dur_to_date)){
			sql = sql +"AND (trunc(b.DOC_REF_DATE) between trunc((to_date(?,'dd/MM/YYYY'))) and trunc((to_date(?,'dd/MM/YYYY')))) ";
		}
        sql = sql + "AND ? = 'C' and b.claim_status = l.LIST_ELMT_VALUE and l.module_id = 'BL' and l.list_ref = 'L_INS_CLAIM_STATUS' GROUP BY b.claim_status,l.list_elmt_label ";
		sql = sql + "union ";
		sql = sql + "SELECT  a.claim_status,l.list_elmt_label claim_status_name, COUNT (1) FROM bl_claim_service_dtl a, SM_LIST_ITEM l,(select operating_facility_id,bill_doc_type_code,bill_doc_num,patient_id,encounter_id,cust_code from BL_CLAIM_BILL_DTL where operating_facility_id = ? ";
		if(!"".equals(qry_patient_id)){
			sql = sql + "AND patient_id = ? ";
		}	
		if(!"".equals(qry_episode_type)){
			sql = sql + "AND EPISODE_TYPE = ? ";
		}
		if(!"".equals(qry_encounter_id)){
			sql = sql + "AND encounter_id = ? ";
		}
		if(!"".equals(qry_payer_grp_code)){
			sql = sql + "AND cust_group_code = ? ";
		}
		if(!"".equals(qry_payer_code)){
			sql = sql + "AND cust_code = ? ";
		}
		if(!"".equals(qry_policy_type_code)){
			sql = sql + "AND policy_type_code = ? ";
		}
		if(!"".equals(qry_approval_doc_ref_no)){
			sql = sql + "AND appr_doc_ref_number = ? ";
		}
		if(!"".equals(qry_claim_id)){
			sql = sql + "AND claim_id = ? ";
		}
		if(!"".equals(qry_State_dur_from_date) && !"".equals(qry_State_dur_to_date)){
			sql = sql +"AND (trunc(DOC_REF_DATE) between trunc((to_date(?,'dd/MM/YYYY'))) and trunc((to_date(?,'dd/MM/YYYY')))) ";
		}
		sql = sql + ") b WHERE a.operating_facility_id = b.operating_facility_id AND a.bill_doc_type_code = b.bill_doc_type_code AND a.bill_doc_num = b.bill_doc_num ";
		if(!qry_insurance_Status.equals("**")){
			sql = sql + "AND a.claim_status = ? ";
		}
		sql = sql + "AND ? = 'S' AND a.claim_status = l.LIST_ELMT_VALUE AND l.module_id = 'BL' and l.list_ref = 'L_INS_CLAIM_STATUS' GROUP BY a.claim_status,l.list_elmt_label";
				
		System.err.println("sql to load data : "+sql);
	      	  
       	pstmt = con.prepareStatement(sql);
       	
		pstmt.setString(column_count,facilityId);
		if(!"".equals(qry_patient_id)){
			pstmt.setString(++column_count,qry_patient_id);	
		}
		if(!"".equals(qry_episode_type)){
			pstmt.setString(++column_count,qry_episode_type);
		}
		if(!"".equals(qry_encounter_id)){						
			pstmt.setString(++column_count,qry_encounter_id);
		}
		if(!"".equals(qry_payer_grp_code)){
			pstmt.setString(++column_count,qry_payer_grp_code);	
		}
		if(!"".equals(qry_payer_code)){	
			pstmt.setString(++column_count, qry_payer_code);
		}
		if(!"".equals(qry_policy_type_code)){			
			pstmt.setString(++column_count, qry_policy_type_code);
		}
		if(!"".equals(qry_approval_doc_ref_no)){
			pstmt.setString(++column_count, qry_approval_doc_ref_no);
		}
		if(!"".equals(qry_claim_id)){
			pstmt.setString(++column_count, qry_claim_id);
		}
		if(!"**".equals(qry_insurance_Status)){
			pstmt.setString(++column_count, qry_insurance_Status);	
		}
		if(!"".equals(qry_State_dur_from_date) && !"".equals(qry_State_dur_to_date)){
			pstmt.setString(++column_count,qry_State_dur_from_date);						
			pstmt.setString(++column_count, qry_State_dur_to_date);	  
		}
		pstmt.setString(++column_count, qry_claims_services_level);	  
		pstmt.setString(++column_count,facilityId);
		if(!"".equals(qry_patient_id)){
			pstmt.setString(++column_count,qry_patient_id);	
		}
		if(!"".equals(qry_episode_type)){
			pstmt.setString(++column_count,qry_episode_type);
		}
		if(!"".equals(qry_encounter_id)){						
			pstmt.setString(++column_count,qry_encounter_id);
		}
		if(!"".equals(qry_payer_grp_code)){
			pstmt.setString(++column_count,qry_payer_grp_code);	
		}
		if(!"".equals(qry_payer_code)){	
			pstmt.setString(++column_count, qry_payer_code);
		}
		if(!"".equals(qry_policy_type_code)){			
			pstmt.setString(++column_count, qry_policy_type_code);
		}
		if(!"".equals(qry_approval_doc_ref_no)){
			pstmt.setString(++column_count, qry_approval_doc_ref_no);
		}
		if(!"".equals(qry_claim_id)){
			pstmt.setString(++column_count, qry_claim_id);
		}
		if(!"".equals(qry_State_dur_from_date) && !"".equals(qry_State_dur_to_date)){
			pstmt.setString(++column_count,qry_State_dur_from_date);						
			pstmt.setString(++column_count, qry_State_dur_to_date);	  
		}
		if(!qry_insurance_Status.equals("**")){
			pstmt.setString(++column_count, qry_insurance_Status);	
		}
		pstmt.setString(++column_count, qry_claims_services_level);	  		
		
		System.err.println("sql to load data column_count: "+column_count);
		
		rst = pstmt.executeQuery();
		while ( rst.next() ){
			String insStatus = checkForNull(rst.getString("claim_status"));
			String insStatusName = checkForNull(rst.getString("claim_status_name"));
			int count = rst.getInt(3);
			totalBillServices = totalBillServices + count;
			row_count++;
			//System.out.println("Insurance Status : "+insStatusName+", Payer : "+qry_cusName+", Count : "+count); 
			if(row_count == 1)
			{
			%>	
			<table width="100%">
				<tr>
					<td class="COLUMNHEADER">
						<fmt:message key="eBL.INS_Status_By.label" bundle="${bl_labels}"/> <%= qry_cusName%>
					</td>
				</tr>
			</table>  
			<div>
				<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="a" id ="payer" onclick="onClickStatus('**','<%=qry_payer_code%>');return false">
							<div class="box_title2" ><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></div>
							<div class="box_text txt" id="totalBillServices"><%=totalBillServices%></div>
							<div class="text"><fmt:message key="eBL.ClickDetails.label" bundle="${bl_labels}"/></div>
						</span>
				</label>      
			<%} %>		
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="a" id ="<%=insStatus%>" onclick="onClickStatus('<%=insStatus%>','<%=qry_payer_code%>');return false">
					<div class="box_title2" ><%=insStatusName%></div>
					<div class="box_text txt"><%=count%></div>
					<div class="text"><fmt:message key="eBL.ClickDetails.label" bundle="${bl_labels}"/></div>
				</span>
			</label>        
	<%}%>
	</div>
	<%	
		System.err.println("Result count : "+row_count+", Total Bills/Services: "+totalBillServices); 
		if(row_count > 0 && totalBillServices > 0 ){ %>
		<script type="text/javascript">
			document.getElementById("totalBillServices").innerHTML = <%=totalBillServices%>;</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%  }
		if(row_count == 0){
	%>	
	<Script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
	</script>
	<%
		}
	%>
		
<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		pstmt.close();
		con.close();
	}
%>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>"/>
	<input type="hidden" name="login_user" id="login_user" id="login_user" value="<%=login_user%>"/>
	<input type='hidden' name='click_count' id='click_count' id='click_count' value='0'>
	
	<input type="hidden" id="p_facility_id" name="p_facility_id" id="p_facility_id"	value="<%=facilityId%>">
	<input type="hidden" id="p_patient_id" name="p_patient_id" id="p_patient_id"	value="<%=qry_patient_id%>">
	<input type="hidden" id="p_episode_type" name="p_episode_type" id="p_episode_type"	value="<%=qry_episode_type%>">
	<input type="hidden" id="p_encounter_id" name="p_encounter_id" id="p_encounter_id"	value="<%=qry_encounter_id%>">
	<input type="hidden" id="p_approval_doc_ref_no" name="p_approval_doc_ref_no" id="p_approval_doc_ref_no"	value="<%=qry_approval_doc_ref_no%>">
	<input type="hidden" id="p_claim_id" name="p_claim_id" id="p_claim_id"	value="<%=qry_claim_id%>">
	<input type="hidden" id="p_payer_grp_code" name="p_payer_grp_code" id="p_payer_grp_code"	value="<%=qry_payer_grp_code%>">
	<input type="hidden" id="p_payer_code" name="p_payer_code" id="p_payer_code"	value="<%=qry_payer_code%>">
	<input type="hidden" id="p_policy_type_code" name="p_policy_type_code" id="p_policy_type_code"	value="<%=qry_policy_type_code%>">
	<input type="hidden" id="p_insurance_Status" name="p_insurance_Status" id="p_insurance_Status"	value="<%=qry_insurance_Status%>">
	<input type="hidden" id="p_State_dur_from_date" name="p_State_dur_from_date" id="p_State_dur_from_date" value="<%=qry_State_dur_from_date%>">
	<input type="hidden" id="p_State_dur_to_date" name="p_State_dur_to_date" id="p_State_dur_to_date" value="<%=qry_State_dur_to_date%>">
	<input type="hidden" id="p_claims_services_level" name="p_claims_services_level" id="p_claims_services_level"	value="<%=qry_claims_services_level%>">
	
</form>
</BODY>
</html>

