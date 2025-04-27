<!DOCTYPE html>
 <%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


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
		//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
		String patient_id=request.getParameter("patient_id");
		//out.println("patient_id :"+patient_id);
				
		//con = (Connection) session.getValue("connection" );
		//try
		//{

		con = ConnectionManager.getConnection(request);

		String blng_grp_id="", blng_class_code="", employer_code="", settlement_ind=""; 
		String credit_doc_ref_desc="", credit_doc_ref_date="", cust_code="", slmt_type_code=""; 
		String slmt_doc_remarks="", remarks="", policy_type_code="", policy_number="",slmt_doc_ref_date="";
		String policy_expiry_date="", non_ins_blng_grp_id="",non_ins_cust_code="",slmt_doc_ref_desc="";
		
		//out.println("blng_grp_id : "+blng_grp_id);
		//String sql="select blng_grp_id, blng_class_code, employer_code, settlement_ind, credit_doc_ref_desc, to_char(credit_doc_ref_date,'dd/mm/yyyy')credit_doc_ref_date, cust_code, slmt_type_code, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks, remarks, policy_type_code, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_id, non_ins_cust_code from bl_patient_fin_dtls where patient_id='"+patient_id+"'";


		String sql="select blng_grp_desc, blng_class_desc, employer_name, settlement_ind, credit_doc_ref_desc, to_char(credit_doc_ref_date,'dd/mm/yyyy')credit_doc_ref_date, cust_name, slmt_type_desc, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks, remarks, policy_type_desc, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_desc, non_ins_cust_name from bl_patient_fin_dtls_vw where patient_id='"+patient_id+"'";

		//out.println("sql :"+sql);
	 
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				//nd_settlement_ind = rs.getString("settlement_ind");
				blng_grp_id = rs.getString("blng_grp_desc");
				blng_class_code = rs.getString("blng_class_desc");
				employer_code = rs.getString("employer_name");
				settlement_ind = rs.getString("settlement_ind");
				credit_doc_ref_desc = rs.getString("credit_doc_ref_desc");
				credit_doc_ref_date = rs.getString("credit_doc_ref_date");
				cust_code = rs.getString("cust_name");
				slmt_type_code = rs.getString("slmt_type_desc");
				slmt_doc_ref_desc =rs.getString("slmt_doc_ref_desc");
				slmt_doc_ref_date =rs.getString("slmt_doc_ref_date");
				slmt_doc_remarks = rs.getString("slmt_doc_remarks");
				remarks = rs.getString("remarks");
				policy_type_code = rs.getString("policy_type_desc");
				policy_number = rs.getString("policy_number");
				policy_expiry_date = rs.getString("policy_expiry_date");
				non_ins_blng_grp_id = rs.getString("non_ins_blng_grp_desc");
				non_ins_cust_code  = rs.getString("non_ins_cust_name");				
			}
		}

		if (rs != null)   rs.close();
		pstmt.close();

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

	%>

		
  <html>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



  	</head>
  <body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='PatFinQryForm' id='PatFinQryForm' method='post' action=''  scrolling=no >

<table width='100%' cellpadding='3' cellspacing='0' border='0' align="center" >
	  <br>
<td class="COLUMNHEADER" ><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></td>
<!-- 
	<tr>
	  <td colspan='6'></td>
	</tr>
-->
<tr>
	<td class='label' width="25%" ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
	<td class='data'  width="25%" ><b><%=blng_grp_id%></b></td>
	<td class='label' width="25%" ><fmt:message key="eBL.NON_INS_BILLING_GROUP.label" bundle="${bl_labels}"/></td>
	<td class='data'  width="25%" ><b><%=non_ins_blng_grp_id%></b></td>
	<!--<td width="15%" >&nbsp;</td>
	<td width="15%" >&nbsp;</td>-->
</tr>
<tr>
	<td class='label' width="25%"><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td class='data'  width="25%" ><b><%=blng_class_code%></b></td>
	<td width="25%" ></td>
	<td width="25%" ></td>
	<!--<td width="15%" >&nbsp;</td>-->
</tr>
<tr>
	<td class='label' width="25%"><fmt:message key="eBL.EMPLOYER_NAME.label" bundle="${bl_labels}"/></td>
	<td class='data' width="25%" ><b><%=employer_code%></b></td>
	<td width="25%" ></td>
	<td width="25%" ></td>
	<!--<td width="15%" >&nbsp;</td>-->
</tr>
<tr>
	<td class='label' width="25%" ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
	<td class='data'  width="25%" ><b><%=cust_code%></b></td>
	<td class='label' width="25%"><fmt:message key="eBL.NON_INS_CUSTOMER_CODE.label" bundle="${bl_labels}"/></td>
	<td class='data'  width="25%" ><b><%=non_ins_cust_code%></b></td>
	<!--<td width="20%" >&nbsp;</td>
	<td width="15%" >&nbsp;</td>-->
</tr>
<tr>
	<td class='label' width="25%"><fmt:message key="eBL.CASH_SLMT_TYPE.label" bundle="${bl_labels}"/></td>
	<td class='data'  width="25%" c><b><%=slmt_type_code%></b></td>
	<td width="25%" ></td>
	<td width="55%" ></td>
	<!--<td width="15%" >&nbsp;</td>-->
</tr>
<tr>
	<td class='label' width="25%"><fmt:message key="eBL.CASH_INSTR_REF.label" bundle="${bl_labels}"/></td>
	<td class='data'  width="25%" ><b><%=slmt_doc_ref_desc%></b></td>
	<td class='label' width="25%" ><fmt:message key="eBL.CASH_INSTR_DATE.label" bundle="${bl_labels}"/></td>
	<td class='data'  width="25%"><b><%=slmt_doc_ref_date%></b></td>
	<!--<td width="15%" >&nbsp;</td>
	<td width="20%" >&nbsp;</td>-->
	<!--<td align='right' class='label' width="20%" nowrap>Cash Instrument Remarks</td>
	<td class='data' align='left' width="15%" nowrap><b><%=slmt_doc_remarks%></b></td>-->
</tr>
	<tr>
	<td class='label' width="25%" ><fmt:message key="eBL.CASH_INSTR_REMARKS.label" bundle="${bl_labels}"/></td>
	<td class='data'  width="25%" ><b><%=slmt_doc_remarks%></b></td>
	<td width="25%" ></td>
	<td width="55%" ></td>
	<!--<td width="15%" >&nbsp;</td>-->
</tr>
<tr>
	<td class='label' width="25%" ><fmt:message key="eBL.CREDIT_DOC_DESC.label" bundle="${bl_labels}"/></td>
	<td class='data' width="25%" ><b><%=credit_doc_ref_desc%></b></td>
	<td class='label' width="25%" ><fmt:message key="eBL.CREDIT_DOC_DATE.label" bundle="${bl_labels}"/></td>
	<td class='data' width="25%" ><b><%=credit_doc_ref_date%></b></td>
	<!--<td width="15%" >&nbsp;</td>
	<td width="15%" >&nbsp;</td>-->
	 
</tr>
<tr>
	<td class='label' width="25%" ><fmt:message key="eBL.POLICY_TYPE_CODE.label" bundle="${bl_labels}"/></td>
	<td class='data' width="25%" ><b><%=policy_type_code%></b></td>
	<td class='label' width="25%" ><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
	<td class='data' width="25%"  ><b><%=policy_number%></b></td>
	<!--<td width="15%" >&nbsp;</td>
	<td width="20%" >&nbsp;</td>-->
	<!--<td align='right' class='label' width="20%" nowrap>Policy Expiry Date</td>
	<td class='data' align='left' nowrap><b><%=policy_expiry_date%></b></td>-->
	
</tr>
	<tr>
	<td class='label' width="25%" ><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>
	<td class='data'  width="25%" ><b><%=policy_expiry_date%></b></td>
	<td width="25%" ></td>
	<td width="25%" ></td>
	
	<!--<td width="15%" >&nbsp;</td>-->
</tr>
	<!--
	<tr>
	  <td colspan='6'></td>
	</tr>
	-->
	 
</table>

</form>
</body>
</html>
<% } catch(Exception e ){ out.println("ErrorinBilling"+e.toString());} 
finally
{
	if(pstmt != null) pstmt.close() ;
	if(pstmt1 != null) pstmt1.close() ;
	if(stmt != null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%> 

