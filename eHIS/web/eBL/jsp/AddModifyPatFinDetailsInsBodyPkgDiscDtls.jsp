<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.*,eBL.Common.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src='../js/AddModifyPatFinDetailsInsBodyPkgApprvDtls.js'></script> 
<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<style>
	thead td, thead td.locked	{
	background-color: navy;
	color: white;
	position:relative;}	
	thead td {
	top: expression(document.getElementById("tbl-container").scrollTop-4); 
	z-index: 20;}
	thead td.locked {z-index: 30;}
	td.locked,  th.locked{
	left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
	position: relative;
	z-index: 10;}
	td.locked,  th.locked{
	left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
	position: relative;
	z-index: 10;}
</style>

<% 
	try
	{
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			= (String)session.getAttribute("facility_id");
		CurrencyFormat cf = new CurrencyFormat();
		int totRec=1;
		String appr_seq_no = request.getParameter("appr_seq_no") == null ? "" :request.getParameter("appr_seq_no") ;// IN 20964
		String credit_auth_ref = request.getParameter("credit_auth_ref") == null ? "" :request.getParameter("credit_auth_ref") ;
		String noofdecimal = request.getParameter("noofdecimal") == null ? "" :request.getParameter("noofdecimal") ;
		String payer_grp_code = request.getParameter("payer_grp_code") == null ? "" :request.getParameter("payer_grp_code") ;
		String payer_code = request.getParameter("payer_code") == null ? "" :request.getParameter("payer_code") ;
		String parent_index = request.getParameter("parent_index") == null ? "" :request.getParameter("parent_index") ;
		String patient_id = request.getParameter("patient_id") == null ? "" :request.getParameter("patient_id") ;
		String encounter_date_aft_trunc = request.getParameter("encounter_date_aft_trunc") == null ? "" :request.getParameter("encounter_date_aft_trunc") ;	
		String blng_grp_code= request.getParameter("blng_grp_code") == null ? "" :request.getParameter("blng_grp_code") ;	
		String policy_type_code= request.getParameter("policy_type_code") == null ? "" :request.getParameter("policy_type_code") ;	
		String policy_no= request.getParameter("policy_no") == null ? "" :request.getParameter("policy_no") ;	
		String priority= request.getParameter("priority") == null ? "" :request.getParameter("priority") ;	
		String policy_eff_frm_date= request.getParameter("policy_eff_frm_date") == null ? "" :request.getParameter("policy_eff_frm_date") ;	

		String bean_id		= "PkgApprovalBean" ;
		String bean_name	= "eBL.PkgApprovalBean";
		PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		
		String bean_id1		= "PkgAssociateBean" ;
		String bean_name1	= "eBL.PkgAssociateBean";
		PkgAssociateBean bean1			= (PkgAssociateBean)getBeanObject( bean_id1, bean_name1, request ) ;
		
		String bean_id2		= "PkgSubsBean" ;
		String bean_name2	= "eBL.PkgSubsBean";
		PkgSubsBean bean2			= (PkgSubsBean)getBeanObject( bean_id2, bean_name2, request ) ;
		
	//	String pkg_seq_no="";//checklist
//		String pkg_code="";
	//	String pkg_desc="";//checklist
		//String aprv_amt="";//checklist
		//String bean_pkg_seq_no="";//checklist
		//String bean_pkg_code="";//checklist
		//String bean_pkg_desc="";//checklist
		String pkgDtlsVals="";
		String pkg_disc_type="",pkg_disc_amt="",pkg_disc_reason="",pkg_disc_reason_desc="";	

		pkg_disc_type = request.getParameter("pkg_disc_type");
		if(pkg_disc_type == null) pkg_disc_type="";

		pkg_disc_amt = request.getParameter("pkg_disc_amt");
		if(pkg_disc_amt == null) pkg_disc_amt="";
		if(!pkg_disc_amt.equals(""))
			pkg_disc_amt = cf.formatCurrency(pkg_disc_amt,Integer.parseInt(noofdecimal));

		pkg_disc_reason = request.getParameter("pkg_disc_reason");
		if(pkg_disc_reason == null) pkg_disc_reason="";

		pkg_disc_reason_desc = request.getParameter("pkg_disc_reason_desc");
		if(pkg_disc_reason_desc == null) pkg_disc_reason_desc="";

		String pkg_code = request.getParameter("pkg_code");
		if(pkg_code == null) pkg_code="";

/*		String pkg_disc_res_sql = "select a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,'X') <> 'S' and NVL(b.active_yn, 'N') = 'Y' and upper(language_id) = upper('"+locale+"') AND ACTION_TYPE='PD' and a.action_reason_code='"+pkg_disc_reason+"'";
		System.err.println(pkg_disc_res_sql);
		Connection con	=	ConnectionManager.getConnection(request);
		PreparedStatement pstmt = con.prepareStatement(pkg_disc_res_sql);
		ResultSet rs=pstmt.executeQuery();
				
		if( rs != null ) 
		{
			while(rs.next())
			{
				pkg_disc_reason_desc=rs.getString("description");
			}
		}
	
		if(rs != null) rs.close();
		pstmt.close();	
*/
%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="disableitems()" onSelect="codeArrestThruSelect();" >
	<form name='PkgDiscDtls' id='PkgDiscDtls' action="" method="post" target="messageFrame" >	
	<table class='grid' width='100%' id="PkgDtls_tbl">
		<tr>
			<td class='columnheader' ><fmt:message key="eBL.discountType.label" bundle="${bl_labels}"/></td>			
			<td class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
			<td class='columnheader'><fmt:message key="eBL.ADHOC_DISC_REASON.label" bundle="${bl_labels}"/></td>
			<td class='columnheader'><fmt:message key="Common.Options.label" bundle="${common_labels}"/></td>
		</tr>

		<tr>
			<td  nowrap> 
				<select name='type' id='type' onChange='validateInd(this)'>
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value='A' <%=(pkg_disc_type.equals("A")?"selected":"") %>><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
					<option value='R' <%=(pkg_disc_type.equals("R")?"selected":"") %>><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td nowrap><input type='text' name='adhocDiscount' id='adhocDiscount' value='<%=pkg_disc_amt%>' size='13'  maxlength='13' style='text-align:right' onBlur="chkAmtPer(this,'<%=noofdecimal%>');"  onKeyPress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")' /></td>

			<td nowrap><input type='text' name='reason_desc' id='reason_desc' value='<%=pkg_disc_reason_desc%>' size='13'  maxlength='13' onBlur="searchReason('B')" /><input type='button' class='button' name="reasonbut" id="reasonbut" value='?' onClick="searchReason('C')"><img src='../../eCommon/images/mandatory.gif'></img><input type="hidden" name='reason_code' id='reason_code' value='<%=pkg_disc_reason%>' ></td>

			<td>
<!--				<input type='button' class='button' onclick="callAuth('A')" name="auth_btn" id="auth_btn"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorization.label","common_labels")%>" >
-->
				<input type="button" name="add_button" id="add_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" class="button" onClick='AddPkgDiscDtls()' >
				<input type="button" name="modify_button" id="modify_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" class="button" onClick='ModifyPkgDiscDtls()' >
				<input type="button" name="remove_button" id="remove_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>" class="button" onClick='RemovePkgDiscDtls()' >
			</td>
		</tr>
	</table>		
	<input type='hidden' name='total_records' id='total_records' value="<%=totRec%>" >
	<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
	<input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value="<%=credit_auth_ref%>" >
	<input type='hidden' name='appr_seq_no' id='appr_seq_no' value="<%=appr_seq_no%>" >
	<input type='hidden' name='payer_grp_code' id='payer_grp_code' value="<%=payer_grp_code%>" >
	<input type='hidden' name='payer_code' id='payer_code' value="<%=payer_code%>" >
	<input type='hidden' name='form_name' id='form_name' value="PkgDiscDtls" >
	<input type='hidden' name='parent_index' id='parent_index' value="<%=parent_index%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
	<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value="<%=encounter_date_aft_trunc%>" >
	<input type='hidden' name='blng_grp_code' id='blng_grp_code' value="<%=blng_grp_code%>" >
	<input type='hidden' name='policy_type_code' id='policy_type_code' value="<%=policy_type_code%>" >
	<input type='hidden' name='policy_no' id='policy_no' value="<%=policy_no%>" >
	<input type='hidden' name='policy_eff_frm_date' id='policy_eff_frm_date' value="<%=policy_eff_frm_date%>" >
	<input type='hidden' name='pkgDtlsVals' id='pkgDtlsVals' value="<%=pkgDtlsVals%>" >
	<input type='hidden' name='priority' id='priority' value="<%=priority%>" >
	<input type='hidden' name='pkg_code' id='pkg_code' value="<%=pkg_code%>" >
	<input type='hidden' name='disc_auth_YN' id='disc_auth_YN' value="" >	
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id1,bean1,request);
		putObjectInBean(bean_id2,bean2,request);
	}
	catch(Exception e)
	{
		System.out.println("Exception from AddModifyPatFinDetailsInsBodyPkgDiscDtls.jsp:"+e);
		e.printStackTrace();
	}
	/*finally {
		System.out.println("Exception from AddModifyPatFinDetailsInsBodyPkgDiscDtls.jsp:");
		//if(con!=null) ConnectionManager.returnConnection(con); //checklist
	}*/
%>

