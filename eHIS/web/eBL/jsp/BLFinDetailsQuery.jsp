<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></title>
<head>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script language='javascript' src='../../eBL/js/BLQuery.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con=null ;
	PreparedStatement pstmt=null ;
	PreparedStatement pstmt1=null ;
	Statement stmt = null;
	ResultSet rs=null ;
	//unused variable, commented on 09/06/05
	//ResultSet rs1=null ;

try
{
	//The following changes are done for Internationalisation Process
//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	String facility_id = request.getParameter("facility_id"); 
	String patient_id = request.getParameter("patient_id");
	String episode_id = request.getParameter("episode_id");
	String visit_id = request.getParameter("visit_id");
	String episode_type= request.getParameter("episode_type");
	String strMessage = "Patient : "+patient_id;
	String strSettlementMessage = "";
	if ( patient_id .equals("null")) 	patient_id = "";
	if ( episode_id .equals("null")) episode_id = "";
	if (visit_id .equals("null")) visit_id = "";
	if (episode_type .equals("null")) episode_type="";

	con = ConnectionManager.getConnection(request);

	String blng_grp_id="", blng_class_code="", employer_code="", settlement_ind=""; 
	String gl_holder_name="",pat_reln_with_gl_holder="",credit_doc_ref_desc="",credit_doc_ref_date="", credit_doc_ref_start_date="",cust_code="", slmt_type_code=""; 
	String slmt_doc_remarks="", remarks="", policy_type_code="", policy_number="",slmt_doc_ref_date="";
	String policy_expiry_date="", non_ins_blng_grp_id="",non_ins_cust_code="",slmt_doc_ref_desc="";

	//out.println("blng_grp_id : "+blng_grp_id);
	//String sql="select blng_grp_id, blng_class_code, employer_code, settlement_ind, credit_doc_ref_desc, to_char(credit_doc_ref_date,'dd/mm/yyyy')credit_doc_ref_date, cust_code, slmt_type_code, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks, remarks, policy_type_code, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_id, non_ins_cust_code from bl_patient_fin_dtls where patient_id='"+patient_id+"'";

	String sql="select BLNG_GRP_ID bg_id,cust_code,blng_grp_desc, blng_class_desc, employer_name, settlement_ind, credit_doc_ref_desc, to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date, cust_name, slmt_type_desc, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks remarks, policy_type_desc, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_desc non_ins_cust_name, decode(nvl(SETTLEMENT_IND,'C'),'C','Cash','R','Credit','X','Sponsored','Cash') settlement_ind_msg,gl_holder_name,pat_reln_with_gl_holder,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date from bl_patient_fin_dtls_vw where patient_id='"+patient_id+"'";
	String billing_group = "";
	String customer_code = "";
		if (episode_type.equals("R") )
		{
			sql="select BLNG_GRP_ID bg_id,cust_code,blng_grp_desc,employer_name, settlement_ind, credit_doc_ref_desc, to_char(credit_doc_ref_date,'dd/mm/yyyy')credit_doc_ref_date, cust_name, slmt_type_desc, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks remarks, policy_type_desc, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_desc non_ins_cust_name, decode(nvl(SETTLEMENT_IND,'C'),'C','Cash','R','Credit','X','Sponsored','Cash') settlement_ind_msg,gl_holder_name,pat_reln_with_gl_holder,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date from bl_patient_fin_dtls_vw where patient_id='"+patient_id+"'";
		}
		if ((episode_type.equals("O")) ||(episode_type.equals("E")) )
		{
			strMessage = "Patient "+patient_id+"/Encounter "+episode_id+"&nbsp;"+visit_id;
			sql="select BLNG_GRP_ID bg_id,cust_code,blng_grp_desc,employer_name, settlement_ind, credit_doc_ref_desc, to_char(credit_doc_ref_date,'dd/mm/yyyy')credit_doc_ref_date, cust_name, slmt_type_desc, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks remarks, policy_type_desc, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_desc non_ins_cust_name, decode(nvl(SETTLEMENT_IND,'C'),'C','Cash','R','Credit','X','Sponsored','Cash') settlement_ind_msg,gl_holder_name,pat_reln_with_gl_holder,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date from BL_visit_fin_dtls_vw where patient_id='"+patient_id+"'" + " and episode_id='"+episode_id+"' and visit_id="+visit_id+" and operating_facility_id='"+facility_id+"'";
		}
		if ((episode_type.equals("I") ) ||(episode_type.equals("D")) )
		{
			strMessage = "Patient "+patient_id+"/Encounter "+episode_id;
			strMessage = "Patient Episode Financial Details: "+episode_id;
			sql="select BLNG_GRP_ID bg_id,cust_code,blng_grp_desc, employer_name, settlement_ind, credit_doc_ref_desc, to_char(credit_doc_ref_date,'dd/mm/yyyy')credit_doc_ref_date, cust_name, slmt_type_desc, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks  remarks, policy_type_desc, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_desc non_ins_cust_name, decode(nvl(SETTLEMENT_IND,'C'),'C','Cash','R','Credit','X','Sponsored','Cash') settlement_ind_msg,gl_holder_name,pat_reln_with_gl_holder,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date from bl_episode_fin_dtls_vw where patient_id='"+patient_id+"'" + " and episode_id='"+episode_id+"' and operating_facility_id='"+facility_id+"'";
		}
	pstmt = con.prepareStatement(sql);
	rs = pstmt.executeQuery() ;
	if( rs != null ) 
	{
		while( rs.next() )
		{  
			
			billing_group = rs.getString("bg_id");
			cust_code = rs.getString("cust_code");
			blng_grp_id = rs.getString("blng_grp_desc");
			employer_code = rs.getString("employer_name");
			settlement_ind = rs.getString("settlement_ind");
			credit_doc_ref_desc = rs.getString("credit_doc_ref_desc");			
			credit_doc_ref_date = rs.getString("credit_doc_ref_date");			
			cust_code = rs.getString("cust_name");
			slmt_type_code = rs.getString("slmt_type_desc");
			slmt_doc_ref_desc =rs.getString("slmt_doc_ref_desc");
			slmt_doc_ref_date =rs.getString("slmt_doc_ref_date");
			remarks = rs.getString("remarks");
			policy_type_code = rs.getString("policy_type_desc");
			policy_number = rs.getString("policy_number");
			policy_expiry_date = rs.getString("policy_expiry_date");
			non_ins_cust_code  = rs.getString("non_ins_cust_name");
			strSettlementMessage = rs.getString("settlement_ind_msg");
			customer_code =  rs.getString("cust_code");
			gl_holder_name = rs.getString("gl_holder_name");
			pat_reln_with_gl_holder = rs.getString("pat_reln_with_gl_holder");
			credit_doc_ref_start_date = rs.getString("credit_doc_ref_start_date");
		}
	}	
	
	if(blng_grp_id==null) blng_grp_id="&nbsp;";
	if(blng_class_code==null) blng_class_code="&nbsp;";
	if(employer_code==null) employer_code="&nbsp;";
	if(settlement_ind==null) settlement_ind="&nbsp;";
	if(credit_doc_ref_desc==null) credit_doc_ref_desc="&nbsp;";	
	if(credit_doc_ref_date==null) credit_doc_ref_date="&nbsp;";	
	if(cust_code==null) cust_code="&nbsp;";
	if(slmt_type_code==null) slmt_type_code="&nbsp;";
	if(slmt_doc_ref_desc==null) slmt_doc_ref_desc="&nbsp;";
	if(slmt_doc_ref_date==null) slmt_doc_ref_date="&nbsp;";
	if(slmt_doc_remarks==null) slmt_doc_remarks="&nbsp;";
	if(remarks==null) remarks="&nbsp;";
	if(policy_type_code==null) policy_type_code="&nbsp;";
	if(policy_number==null) policy_number="&nbsp;";
	if(policy_expiry_date==null) policy_expiry_date="&nbsp;";
	if(non_ins_blng_grp_id==null) non_ins_blng_grp_id="&nbsp;";
	if(non_ins_cust_code==null) non_ins_cust_code="&nbsp;";
	if(gl_holder_name==null) gl_holder_name="&nbsp;";
	if(pat_reln_with_gl_holder==null) pat_reln_with_gl_holder="&nbsp;";
	if(credit_doc_ref_start_date==null) credit_doc_ref_start_date="&nbsp;";
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='PatFinQryForm' id='PatFinQryForm' method='post' action=''  scrolling=no >
<table width='100%' cellpadding='3' cellspacing='0' border='0' align="center" >

<td align='left' colspan="5" class="columnHeader"><fmt:message key="Common.financialdetails.label" 
bundle="${common_labels}"/>-<%=strMessage %></td>
<tr>
	<td class='label' width='25%' >
	<a  onClick="getBlngGrpSearch(document.forms[0].billing_group);"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></a></td>
	
	<td class='fields'  width='25%'  ><b><%=blng_grp_id%></b></td>
<td width='25%' ></td>
	<td class='fields' width='25%' ><b><%=strSettlementMessage%></b></td>
	

</tr>
<tr>
	<td class='label' width='25%' ><fmt:message key="eBL.EMPLOYER_NAME.label" bundle="${bl_labels}"/></td>
	<td class='fields'width='25%' ><b><%=employer_code%></b></td>
	<td  class='label' width='25%' >
	<a  onClick="getCustDet(document.forms[0].customer_code);"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
	
	<td class='fields' width='25%'  ><b><%=cust_code%></b></td>
</tr>


<tr>
	<td class='label' width='25%' ><fmt:message key="eBL.GL_HOLDER_NAME_NRIC.label" bundle="${bl_labels}"/></td>
	<td class='fields'  width='25%' ><b><%=gl_holder_name%></b></td>
	<td class='label' width='25%' ><fmt:message key="eBL.RELATIONSHIP_WITH_GL_HOLDER.label" bundle="${bl_labels}"/></td>
	<td class='fields'  width='25%' ><b><%=pat_reln_with_gl_holder%></b></td>	 
</tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr>
	<td class='label' width='25%' ><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
	<td class='fields'  width='25%'  ><b><%=credit_doc_ref_desc%></b></td>
	<td width='25%' ></td>
	<td width='25%'  ><b></b></td>

	<!--
	<td align='right' class='label' width="20%" nowrap>Credit Doc Date</td>
	<td class='' align='left' width="15%" colspan='2' nowrap><b><%=credit_doc_ref_date%></b></td>
	-->


</tr>

<tr>
	<!--
	<td align='right' class='label' width="20%" nowrap>Doc Reference</td>
	<td class='' align='left' width="15%" colspan='2' nowrap><b><%=credit_doc_ref_desc%></b></td>
	-->

	<td  class='label' width='25%' ><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}"/></td>	
	<td class='fields'  width='25%'  ><b><%=credit_doc_ref_start_date%></b></td>

	<td  class='label' width='25%' ><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}"/></td>	
	<td class='fields' width='25%'  ><b><%=credit_doc_ref_date%></b></td>	

	 
</tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>
<tr>
	<td  class='label' width='25%' ><fmt:message key="eBL.CASH_SLMT_TYPE.label" bundle="${bl_labels}"/></td>
	<td class='fields'  width='25%'  ><b><%=slmt_type_code%></b></td>
	<td width='25%' ></td>
	<td width='25%' ></td>
	

</tr>
<tr>
	<td  class='label' width='25%' ><fmt:message key="eBL.CASH_INSTR_REF.label" bundle="${bl_labels}"/></td>
	<td class='fields'  width='25%'  ><b><%=slmt_doc_ref_desc%></b></td>
	<td  class='label' width='25%' ><fmt:message key="eBL.CASH_INSTR_DATE.label" bundle="${bl_labels}"/></td>
	<td class='fields'  width='25%'   ><b><%=slmt_doc_ref_date%></b></td>
	<!--<td align='right' class='label' width="20%" nowrap>Cash Instrument Remarks</td>
	<td class='' align='left' width="15%" nowrap><b><%=slmt_doc_remarks%></b></td>-->
</tr>
<tr>
	<td class='label' width='25%' ><fmt:message key="eBL.CASH_INSTR_REMARKS.label" bundle="${bl_labels}"/></td>
	<td class='fields'  width='25%'><b><%=slmt_doc_remarks%></b></td>
	<td width='25%' ></td>
	<td width='25%' ></td>
	
</tr>
<!--
<tr>
	
	<td align='right' class='label' width="20%" nowrap>Policy Expiry Date</td>
	<td class='' align='left' nowrap><b><%=policy_expiry_date%></b></td>
</tr>
 -->

 <tr><td class='label'></td><td class='label'></td><td class='label'></td><td class='label'></tr>

</table>
<input type='hidden' name='billing_group' id='billing_group' value='<%=billing_group%>'> </input>
<input type='hidden' name='customer_code' id='customer_code' value='<%=customer_code%>'> </input>
</form>
</body>
</html>
<%
	} 
catch(Exception e )
{
	out.println("ErrorinBilling"+e.toString());
} 
finally
{
	if(rs != null) rs.close() ;
	if(pstmt != null) pstmt.close() ;
	if(pstmt1 != null) pstmt1.close() ;
	if(stmt != null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%> 

