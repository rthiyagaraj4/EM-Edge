<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.SupplierListForTender.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/Tender.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body> 
<%

	
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	
	String supp_code = "";
	String contact_person ="";
	String contact_number = "";
	String email_id = "";
	
	TenderBean bean					=				(TenderBean) getBeanObject( bean_id,bean_name,request);
	
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	
	String mode_modify = bean.checkForNull(request.getParameter("mode_modify"));
	String req_facility_id = bean.checkForNull(request.getParameter("facility_id"));
	
	int max_rows = 5;

	ArrayList hmExpRecords		= new ArrayList();
	int y=0;
	ArrayList alDelvRecords		= new ArrayList();

	String item_code = "";	
	
	if(bean.getSupplierDtlData(bean.getDoc_no()) != null && bean.getSupplierDtlData(bean.getDoc_no()).size()>0){
		hmExpRecords = (ArrayList)bean.getSupplierDtlData(bean.getDoc_no());
		max_rows  = hmExpRecords.size();		
	}
	
	if(bean.getSuppRecords() != null && bean.getSuppRecords().size() > 0 ){
		ArrayList bDArrayList	=	(ArrayList)bean.getSuppRecords().get(0);
		max_rows = bDArrayList.size() ; 
	}			
	//Added by Rabbani For Supplier Check box  validation on 21/06/2013
	String checked = "checked";
	String Select_dflt_Supp = "Y";
	//ends
	String Supplierdisable	= "";
%>
<form name="TndrSupplierDetailsForm" id="TndrSupplierDetailsForm">
	
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes id='myTable'>
		<tr>
			<th width='20%' ><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/></th>
			<th width='20%' ><fmt:message key="ePO.ContactPerson.label" bundle="${po_labels}"/></th>
			<th width='20%' ><fmt:message key="ePO.ContactNumber.label" bundle="${po_labels}"/></th>
			<th width='20%'><fmt:message key="ePO.EmailId.label" bundle="${po_labels}"/></th>
			<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
			<input type="checkbox" value="Y" name="SelectAll" id="SelectAll"   onClick="return toggleCheck(TndrSupplierDetailsForm);" checked></th>
						
		</tr>
		
<%			
	int cnt,z;
for (cnt=0; cnt<max_rows; cnt++ ) {
			if(bean.getSuppRecords() != null && bean.getSuppRecords().size() > 0 ){
			 if(cnt>0) break;
				ArrayList bDArrayList	=	(ArrayList)bean.getSuppRecords().get(0);
				if(bDArrayList.size()>0){
					for(int j=0;j<bDArrayList.size();j++){
						HashMap hm = (HashMap)bDArrayList.get(j);
						checked = "checked";
						//if(bean.checkForNull((String)hm.get("SUPP_CODE")) != null && bean.checkForNull((String)hm.get("SUPP_CODE")) != ""){
							supp_code = bean.checkForNull((String)hm.get("SUPP_CODE"));
							contact_person = bean.checkForNull((String)hm.get("CONTACT_PERSON"));
							contact_number  = bean.checkForNull((String)hm.get("CONTACT_NUMBER"));
							email_id  = bean.checkForNull((String)hm.get("EMAIL_ID"));
							Supplierdisable = bean.checkForNull((String)hm.get("MODE_DISABLED"));							

							Select_dflt_Supp  = bean.checkForNull((String)hm.get("SELECT_DATA"));
							if(Select_dflt_Supp.equals("N"))
								checked = "";							
							
							cnt=j;	 
%>				
		<tr>			
			<td align="left"><select name="supp_code_<%=j%>" id="supp_code_<%=j%>" onchange="getContactDetails(this,'<%=j%>');" width="300" style="width: 300px" <%=Supplierdisable%>>
<%
if(!Supplierdisable.equals("")){
%>
		<%=bean.getSupp_code_ListForAll(supp_code)%>		
<%
}else{
%>
		<%=bean.getSupp_code_List(supp_code)%>
<%
}
%>
				</select></td>
			<td  align="right"><input type="text" name="contact_person_<%=j%>" id="contact_person_<%=j%>"  size="30" maxlength="40"  value="<%=bean.checkForNull(contact_person)%>" onKeyPress=" " onBlur="" readonly></td>
			<td  align="right"><input type="text" name="contact_number_<%=j%>" id="contact_number_<%=j%>"  size="30" maxlength="30"  value="<%=bean.checkForNull(contact_number)%>" onKeyPress=" " onBlur="" readonly></td>
			<td  align="center"><input type="text"  name="email_id_<%=j%>" id="email_id_<%=j%>"  size="30" maxlength="30"  value="<%=bean.checkForNull(email_id)%>"  onKeyPress=" " onBlur="" readonly></td>
			<td align="left"> <input type="checkbox" name="Select_supp_<%=j%>" id="Select_supp_<%=j%>" value="Y" <%=checked%>  onclick = "setstatus(this,'<%=j%>');"> </td>
			<td><input type="hidden" name="mode_disabled_<%=j%>" id="mode_disabled_<%=j%>" value=<%=Supplierdisable%> ></td>			
		</tr>
				
<%					
						//}
				}
					
			}	
				
		}			
		else if(bean.getSupplierDtlData(bean.getDoc_no()) != null && bean.getSupplierDtlData(bean.getDoc_no()).size() > 0) {
			
			for(int j=0;j<bean.getSupplierDtlData(bean.getDoc_no()).size();j++){
						
						HashMap hm = (HashMap)hmExpRecords.get(j);
						supp_code = bean.checkForNull((String)hm.get("SUPP_CODE"));
						contact_person = bean.checkForNull((String)hm.get("CONTACT_NAME"));
						contact_number = bean.checkForNull((String)hm.get("TEL_NUM"));
						email_id = bean.checkForNull((String)hm.get("EMAIL_ID"));
						Select_dflt_Supp  = bean.checkForNull((String)hm.get("SELECT_DATA"));
						Supplierdisable = bean.checkForNull((String)hm.get("MODE_DISABLED"));						
						
 						checked = "checked";
						if(Select_dflt_Supp.equals("N"))
							checked = "";
						
						cnt=j;
		%>				
		<tr>
			
			<td align="left"><select name="supp_code_<%=cnt%>" id="supp_code_<%=cnt%>" onchange="getContactDetails(this,'<%=cnt%>');" width="300" style="width: 300px" disabled <%=Supplierdisable%>>
					<%=bean.getSupp_code_ListForAll(supp_code)%> 	</select></td>
			<td  align="right"><input type="text" name="contact_person_<%=cnt%>" id="contact_person_<%=cnt%>"  size="30" maxlength="40"  value="<%=bean.checkForNull(contact_person)%>" onKeyPress=" " onBlur="" readonly></td>
			<td  align="right"><input type="text" name="contact_number_<%=cnt%>" id="contact_number_<%=cnt%>"  size="30" maxlength="30"  value="<%=bean.checkForNull(contact_number)%>" onKeyPress=" " onBlur="" readonly></td>
			<td  align="center"><input type="text"  name="email_id_<%=cnt%>" id="email_id_<%=cnt%>"  size="30" maxlength="30"  value="<%=bean.checkForNull(email_id)%>"  onKeyPress=" " onBlur="" readonly></td>
			<td align="left"> <input type="checkbox" name="Select_supp_<%=cnt%>" id="Select_supp_<%=cnt%>" value="Y" <%=checked%>  onclick = "setstatus(this,'<%=cnt%>');"> </td>
			<td><input type="hidden" name="mode_disabled_<%=cnt%>" id="mode_disabled_<%=cnt%>" value=<%=Supplierdisable%> ></td>			
		</tr>
<%	
			}
		}
		else{
%>				
		<tr>			
			<td align="left"><select name="supp_code_<%=cnt%>" id="supp_code_<%=cnt%>" onchange="getContactDetails(this,'<%=cnt%>');" width="300" style="width: 300px">
					<%=bean.getSupp_code_List(supp_code)%></select></td>			
			<td  align="right"><input type="text" name="contact_person_<%=cnt%>" id="contact_person_<%=cnt%>"  size="30" maxlength="40"  value="<%=bean.checkForNull(contact_person)%>" onKeyPress=" " onBlur="" readonly></td>
			<td  align="right"><input type="text" name="contact_number_<%=cnt%>" id="contact_number_<%=cnt%>"  size="30" maxlength="30"  value="<%=bean.checkForNull(contact_number)%>" onKeyPress=" " onBlur="" readonly></td>
			<td  align="center"><input type="text"  name="email_id_<%=cnt%>" id="email_id_<%=cnt%>"  size="30" maxlength="30"  value="<%=bean.checkForNull(email_id)%>"  onKeyPress=" " onBlur="" readonly></td>
			<td align="left"><input type="checkbox" name="Select_supp_<%=cnt%>" id="Select_supp_<%=cnt%>" value="Y" <%=checked%>  onclick = "setstatus(this,'<%=cnt%>');"> </td>
			<td><input type="hidden" name="mode_disabled_<%=cnt%>" id="mode_disabled_<%=cnt%>" value="" ></td>
		</tr>
<%	
			}
	}
			y =  cnt;
	
	for (z=y ; z<5; z++ ) {
		if(z!=0){
					supp_code = "";
					contact_person ="";
					contact_number = "";
					email_id = "";			
%>				
		<tr>			
			<td align="left"><select name="supp_code_<%=z%>" id="supp_code_<%=z%>" onchange="getContactDetails(this,'<%=z%>');" width="300" style="width: 300px">
					<%=bean.getSupp_code_List(supp_code)%></select>	</td>
			<td  align="right"><input type="text" name="contact_person_<%=z%>" id="contact_person_<%=z%>"  size="30" maxlength="40"  value="<%=bean.checkForNull(contact_person)%>" onKeyPress=" " onBlur="" readonly>	</td>
			<td  align="right"><input type="text" name="contact_number_<%=z%>" id="contact_number_<%=z%>"  size="30" maxlength="30"  value="<%=bean.checkForNull(contact_number)%>" onKeyPress=" " onBlur="" readonly></td>
			<td  align="center"><input type="text"  name="email_id_<%=z%>" id="email_id_<%=z%>"  size="30" maxlength="30"  value="<%=bean.checkForNull(email_id)%>"  onKeyPress=" " onBlur="" readonly>	</td>
			<td align="left"> <input type="checkbox" name="Select_supp_<%=z%>" id="Select_supp_<%=z%>" value="Y" <%=checked%>  onclick = "setstatus(this,'<%=z%>');"> </td>
			<td><input type="hidden" name="mode_disabled_<%=z%>" id="mode_disabled_<%=z%>" value="" ></td>			
		</tr>				
<%
		}		
	}
		max_rows = z;
		%>
		</table>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes >
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
		
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td align="right"><input type="button" align="right" class="button" name="add" id="add" value="Add Row"  onClick="addRow('myTable');"></td>
			<td align="right"><input type="button" align="right" class="button" name="Ok" id="Ok" value="  Ok  "  onClick="AddSupplierDetails();" ></td>
		</tr>
	</table>
		
	<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
	<input type="hidden" 	name="total_Records" id="total_Records"        	value="<%=max_rows%>">
	<input type="hidden" 	name="req_facility_id" id="req_facility_id"		value="<%=req_facility_id%>">
	<input type="hidden" 	name="language_id" id="language_id" 			value="<%=locale%>">
	
	
<script>
setstatusforSelectAll();
</script>
	
	
	
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

