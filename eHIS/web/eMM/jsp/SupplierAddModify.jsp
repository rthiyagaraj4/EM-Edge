<!DOCTYPE html>
<%@ page import=" eMM.*, eMM.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../eMM/js/MmMessages.js"></script>  -->
	<script language="JavaScript" src="../../eMM/js/Supplier.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "SupplierBean" ;
	String bean_name = "eMM.SupplierBean";
	String codeDisabled =	"";
	String checked	= "";
	String disable = "";
	SupplierBean bean = (SupplierBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
		bean.clear() ;
	/*if ( mode == null || mode.equals("") )
		return ;
		
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")) )
		return ;
	*/

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		bean.setSupplier_Code(request.getParameter("supplier_code")) ;

		bean.loadData() ;
		if(bean.getStatus().equals("S"))
		{
			checked		= "CHECKED";
		}
		else
		{
			checked		=	"";
			//readOnly	=	" readOnly " ;
			disable		=	"disabled";
		}

	
	}

%>
<body onload='FocusFirstElement();'>

	<form name="SupplierAddQueryCriteriaform" id="SupplierAddQueryCriteriaform" onreset="FocusFirstElement()">
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align=center>
	<tr>
	<td width='100%'  class="WHITE" align='center'>
	<table border="0" cellpadding="0" cellspacing="0" width='80%' align=center>

	<tr>
		<td  class="label"><fmt:message key="Common.SupplierCode.label" bundle="${common_labels}"/></td>
		<td class="fields" colSpan="3">&nbsp;&nbsp;<input type="text"  value="<%=bean.getSupplier_Code()%>" name="supplier_code" size='8' maxLength='8' class='UPPER' onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);"  <%=codeDisabled%>> <%=bean.getImage("M")%>
		</td>
		
	</tr>

	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	
		<td  class="label"><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
		<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getAlpha_Code()%>" name="alpha_code" size='10' maxLength='10' onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" <%=disable%> > <%=bean.getImage("M")%>
		</td>
		<td class="label" ><fmt:message key="eMM.Currency.label" bundle="${mm_labels}"/></td>
	<td  class='fields' width='30%' nowrap>&nbsp;<select name="currency" id="currency" <%=disable%>>	<%=bean.getCurrencyList()%>
			</select>  </td>
			
	</tr>

	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getShort_Desc()%>" name="short_desc" id="short_desc" size='15' maxLength='15'  <%=disable%> >
	<%=bean.getImage("M")%></td>
	<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
	<td class="label" ><fmt:message key="eMM.ContactPerson.label" bundle="${mm_labels}"/></td>
	<td  class='fields'>&nbsp;<input type= "text" value = "<%=bean.getContactperson()%>" name="cntct_person" id="cntct_person" size=40 maxlength=40 class="UPPER"  <%=disable%>> </td>
	<%}else{%>
	<td class="label" ><fmt:message key="eMM.ContactPerson.label" bundle="${mm_labels}"/></td>
	<td  class='fields'>&nbsp;<input type= "text" value = "" name="cntct_person" id="cntct_person" size=40 maxlength=40 class="UPPER" > </td>
	<%}%>
			
	</tr>

	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getLong_Desc()%>" name="long_desc" id="long_desc" size='10' maxLength='40' <%=disable%> ><%=bean.getImage("M")%></td>
	<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
	<td class="label" ><fmt:message key="eMM.TitleOfTheContactPerson.label" bundle="${mm_labels}"/></td>
	<td  class='fields' >&nbsp;<input type= "text" value = "<%=bean.getTitleofcontactperson()%>" name="title_of_cntct_person" id="title_of_cntct_person" size=40 maxlength=40  <%=disable%>> </td>
	<%}else {%>
	<td class="label" ><fmt:message key="eMM.TitleOfTheContactPerson.label" bundle="${mm_labels}"/></td>
	<td  class='fields' >&nbsp;<input type= "text" value = "" name="title_of_cntct_person" id="title_of_cntct_person" size=40 maxlength=40  > </td>
	<%}%>
	</tr>
	
	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td  class="label"><fmt:message key="eMM.SupplierAddress1.label" bundle="${mm_labels}"/></td>
	<td class="fields">&nbsp;&nbsp;<input type="text" value = "<%=bean.getSupp_Address_1()%>" name="supp_address_1" size='30' maxLength='30'  <%=disable%> >
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
%>
		<td class="fields">&nbsp;<input type="checkbox" name="status" id="status" value="S" checked>
	<%}else{
	%>
		<td class="fields">&nbsp;<input type="checkbox" name="status" id="status" <%=checked%> value="S" >
<%}%>
		</td>
	</td>
	<!--<td class="label" ><fmt:message key="eMM.PaymentTerms.label" bundle="${mm_labels}"/></td>
	<td class="fields">&nbsp;&nbsp;<input type="text" value = "" name="pmnt_term" id="pmnt_term" size='2' maxLength='2'  <%=disable%> >
	</td> -->
			
	</tr>
<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>
<tr>
	<td  class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMM.SupplierAddress2.label" bundle="${mm_labels}"/></td>
	<td class="fields" colSpan="3">&nbsp;&nbsp;<input type="text" value = "<%=bean.getSupp_Address_2()%>" name="supp_address_2" id="supp_address_2" size='30' maxLength='30'  <%=disable%> >
	</td>
	
	</tr>
<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td  class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMM.SupplierAddress3.label" bundle="${mm_labels}"/></td>
	<td class="fields" colSpan="3">&nbsp;&nbsp;<input type="text" value = "<%=bean.getSupp_Address_3()%>" name="supp_address_3" id="supp_address_3" size='30' maxLength='30'  <%=disable%> >
	</td>
	</tr>

	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td  class="label"><fmt:message key="eMM.ZipCode.label" bundle="${mm_labels}"/></td>
	<td class="fields" colSpan="3">&nbsp;&nbsp;<input type="text" value = "<%=bean.getZip_Code()%>" name="zip_code" id="zip_code" size='30' maxLength='30'  <%=disable%> >
	</td>
	</tr>

	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td  class="label"><fmt:message key="eMM.TelephoneNumber.label" bundle="${mm_labels}"/></td>
	<td class="fields" colSpan="3">&nbsp;&nbsp;<input type="text" value = "<%=bean.getTel_No()%>" name="tel_no" id="tel_no" size='30' maxLength='30'  <%=disable%> >
	</td>
	</tr>
<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td  class="label"><fmt:message key="eMM.FaxNumber.label" bundle="${mm_labels}"/></td>
	<td class="fields" colSpan="3">&nbsp;&nbsp;<input type="text" value = "<%=bean.getFax_No()%>" name="fax_no" id="fax_no" size='30' maxLength='30'  <%=disable%> >
	</td>
	</tr>

	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td  class="label"><fmt:message key="eMM.EmailID.label" bundle="${mm_labels}"/></td>
	<td class="fields" colSpan="3">&nbsp;&nbsp;<input type="text" value = "<%=bean.getEmail_Id()%>" name="email_id" id="email_id" size='30' maxLength='30'  onblur="isvalidemail();"<%=disable%> >
	</td>
	
	</tr>

	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>
	
	<tr>
	<td class="label" ><fmt:message key="eMM.BankNumber.label" bundle="${mm_labels}"/></td>
		<td  class='fields' colSpan="3" width='30%' nowrap>&nbsp;&nbsp;<input type=text value = "<%=bean.getBank_No()%>" name="bank_no" id="bank_no" size=3 maxlength=3 class="NUMBER" onkeypress="return isValidNumber(this,event,7,'');" <%=disable%>> </td>
	</tr>

	<tr>
		<td colSpan="3">&nbsp;</td><td>&nbsp;</td>
	</tr>
	
	<tr>
	<td class="label" ><fmt:message key="eMM.AccountNumber.label" bundle="${mm_labels}"/></td>
		<td  class='fields' width='30%' nowrap>&nbsp;&nbsp;<input type=text value = "<%=bean.getAcc_No()%>" name="acc_no"  id="acc_no" size=16 maxlength=16 class="UPPER" onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" <%=disable%>> </td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	
	<tr>

	<td class="label" ><fmt:message key="eMM.BankAccountName.label" bundle="${mm_labels}"/></td>
	<td  class='fields' width='30%' nowrap>&nbsp;&nbsp;<input type=text value = "<%=bean.getBank_Acc_Name()%>" name="bank_acc_name" id="bank_acc_name" size=20 maxlength=20 class="UPPER" onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" <%=disable%>> </td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
	<td class="label" ><fmt:message key="eMM.BranchNumber.label" bundle="${mm_labels}"/></td>
	<td  class='fields' width='30%' nowrap>&nbsp;&nbsp;<input type=text value = "<%=bean.getBranch_No()%>" name="branch_no" id="branch_no" size=3 maxlength=3 class="NUMBER" onkeypress="return isValidNumber(this,event,7,'');" <%=disable%>> </td>
	</tr>
	
	</table>
	
	</tr>
	</td>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">


	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

