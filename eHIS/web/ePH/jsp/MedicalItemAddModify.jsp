<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
 
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String sql_ph_drug_select25			=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT25");
	String sql_ph_drug_select14			=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT14");
	String sql_ph_drug_search_select21	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT21");
	String sql_ph_drug_search_select22	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT22");
	String sql_ph_drug_search_select23	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT23");
	String sql_or_ph_select1			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT1");
	String sql_or_ph_select2			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT2");
	String sql_or_ph_select3			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT3");
	String sql_ph_drug_medical_item_select4			=PhRepository.getPhKeyValue("SQL_PH_DRUG_MEDICAL_ITEM_SELECT4");

	
	String bean_id	="MedicalItemBean";
	String bean_name	="ePH.MedicalItemBean";
    String code="";	
    String code1="";	
	String desc="";
	String desc1="";

    String in_formulary_yn="";
	String drug_code="";	
	String item_code="";	
	String drug_desc="";	
	String generic_id="";
	String generic_name="";	
	String discontinued_yn="";	
	String disp_alt_form_yn="";
	String stock_uom="";	
	String pres_base_uom="";	
	String in_formulary_chk="";	
	 String disp_alt_form_chk="";
     String discontinued_chk=""; 
     String disp_multi_strength_yn=""; 
     String disp_multi_strength_chk=""; 
     String content_in_pres_base_uom=""; 
   //  String or_yn=""; 
   //  String ModuleId=""; 
    boolean		or_status			=   false;
	MedicalItemBean bean = (MedicalItemBean)getBeanObject(bean_id,bean_name ,request);
	bean.clear();
	String mode=request.getParameter("mode");
	String Drug_code_value=request.getParameter("Drug_code_value");
	ArrayList termlist=new ArrayList(); 
	ArrayList DispensingUnitlist=new ArrayList(); 
	ArrayList AllRecords=new ArrayList(); 
    HashMap termlistvalues=new HashMap();
    HashMap AllRecordsValues=new HashMap();
    HashMap DispensingUnitValues=new HashMap();
	termlist=bean.getPrescribingUnit(locale);
		
	if(mode.equals("2"))
	{
			
	if(Drug_code_value!=null)
	{
	ArrayList Result=new ArrayList();
	Result=bean.getTradeResult(Drug_code_value,locale);
	or_status=bean.getDrugStatusInOR(Drug_code_value);
	bean.setResult(Result);
	}
	
	AllRecords=bean.getResult(Drug_code_value,locale);
	
	
	for(int k=0; k<AllRecords.size(); k++)
		{
		  AllRecordsValues			=	(HashMap) AllRecords.get(k);
		  in_formulary_yn	=	(String)AllRecordsValues.get("in_formulary_yn");
		  drug_code	=	(String)AllRecordsValues.get("drug_code");
		  item_code		            = (String)AllRecordsValues.get("item_code")==null?"":(String)AllRecordsValues.get("item_code");
		  drug_desc	=	(String)AllRecordsValues.get("drug_desc");
		  generic_id	=	(String)AllRecordsValues.get("generic_id");
		  generic_name	=	(String)AllRecordsValues.get("generic_name");
		  discontinued_yn	=	(String)AllRecordsValues.get("discontinued_yn");
		  disp_multi_strength_yn	=	(String)AllRecordsValues.get("disp_multi_strength_yn");
		  disp_alt_form_yn	=	(String)AllRecordsValues.get("disp_alt_form_yn");
		  stock_uom	=	(String)AllRecordsValues.get("stock_uom");
		  pres_base_uom	=	(String)AllRecordsValues.get("pres_base_uom");
		  content_in_pres_base_uom	=	(String)AllRecordsValues.get("content_in_pres_base_uom");
		  DispensingUnitlist=bean.getDispensingUnitrelated(pres_base_uom,locale);
	   }
 }
 if(in_formulary_yn.equals("Y"))
	 {
      in_formulary_chk="checked";
 	 }
	 else
	 {
      in_formulary_chk="";
     }
if(disp_multi_strength_yn !=null)//modified for ghl-crf-0548
	 {
        disp_multi_strength_chk="checked";

	 }
	 else
	 {
         disp_multi_strength_chk="";
		
	 }
    if(discontinued_yn.equals("E"))
	 {
       discontinued_chk="checked";
   	 }
	 else
	 {
         discontinued_chk="";
	 }
	  if(disp_alt_form_yn.equals("Y"))
	 {
        disp_alt_form_chk="checked";
        
	 }
	 else
	 {
         disp_alt_form_chk="";
         
		
	 }

	String req_str			= request.getQueryString();
	bean.setMode(mode);
    bean.setDrugCodeValue(Drug_code_value);
	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="JavaScript" src="../js/MedicalItem.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body  onKeyDown="lockKey()" onload="disableReason();" topmargin="0" >
	<form name="MedicalItemAddModifyForm" id="MedicalItemAddModifyForm" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			<%if(mode.equals("1"))
			{%>
			<tr>
			  <td align="right" class="label"><fmt:message key="ePH.InFormulary.label" bundle="${ph_labels}"/></td>
					<td align="left" colspan="2">&nbsp;<input type="checkbox" name="in_formulary_yn" id="in_formulary_yn" onClick="parent.validateItemCode(this);disableReason(this);"  value="<%=in_formulary_yn%>" checked>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
					 <input type="hidden" name="in_formulary_yn_value" id="in_formulary_yn_value"	value="">
					<td class="label"></td>
					<td class="label"></td>
					<td class="label"></td>
					<td class="label"></td>
			</tr>
				<tr>
				<td align="right" class="label"><fmt:message key="Common.code.label"   bundle="${common_labels}"/></td>
				<td align="left" >&nbsp;&nbsp;<input type="text" name="drug_code" id="drug_code" maxlength="20" size="20"   value="" onKeyPress="return CheckForSpecChars(event)">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
				<td align="right" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="2">&nbsp;&nbsp;<input type="text" name="item_code" id="item_code" maxlength="20" size="20" readonly value="" onblur="sample(this);"><input type="button" class="button"value="?"name="item_code_lookup"onClick="parent.searchItem(document.MedicalItemAddModifyForm.item_code)"onfocus="parent.searchItem(document.MedicalItemAddModifyForm.item_code)"><IMG SRC="../../eCommon/images/mandatory.gif" STYLE="visibility:visible"NAME="mandate_reason">
                   <td class="label"></td>
                   <td class="label"></td>
				</tr>
			
			<tr>
					<td align="right" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
                  <td align="left" colspan="5">&nbsp;&nbsp;<input type="text" name="drug_desc" id="drug_desc" maxlength="60" size="66"  value="" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
                 <td class="label"></td>
         

           </tr>

		   <tr>
				<td align="right"  class="label"  width='20%'><fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label">&nbsp;<select name="pres_base_uom" id="pres_base_uom" onchange="validateCode(this);">
							<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				          <% for(int i=0; i<termlist.size(); i++)
				{
					termlistvalues = (HashMap)termlist.get(i);
					code = (String)termlistvalues.get("code");
					desc = (String)termlistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
							</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" >
						</td>

				<td align="right" class="label" ><fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/></td>
					<td align="left" colspan='3' class="label" >&nbsp;<select name="stock_uom" id="stock_uom" onchange="stock_uom_value(this,pres_base_uom);">
						<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
				<fmt:message key="Common.contains.label" bundle="${common_labels}"/>
						&nbsp;<b><label id='pack_size'></label> &nbsp;<label id='disp_pres_uom'> </b>
						</label>
		            <input type="hidden" name="pack_size" id="pack_size"	value="">
				</td>
				<td class="label"></td>

    		</tr>
			<tr>
			
			<td align="right" class="label"><fmt:message key="ePH.DispenseAlternate.label" bundle="${ph_labels}"/></td>
			<td align="left" >&nbsp;<input type="checkbox" name="DispenseAlternate" id="DispenseAlternate" value="Y" checked></td>
			<td align="right" class="label"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="3">&nbsp;&nbsp;<input type="text" name="generic_name" id="generic_name" maxlength="40" size="40" value=""><input type="button" class="button" name="gnbtn" id="gnbtn" value="?"  onclick="parent.searchGenericName(this);" onfocus="parent.searchGenericName(this);">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" >
			<input type="hidden" name="generic_id" id="generic_id" value=""></td>
			<td class="label"></td>
			</tr>
			<tr>
	        <td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	      <td align="left"colspan="6">&nbsp;<input type="checkbox" name="chk_opt" id="chk_opt" value="E" checked></td>
            </tr>

  <%}
  else if(mode.equals("2"))
  {
 %>
  <tr>
			  <td align="right" class="label"><fmt:message key="ePH.InFormulary.label" bundle="${ph_labels}"/></td>
					<td align="left" colspan="2">&nbsp;<input type="checkbox" name="in_formulary_yn" id="in_formulary_yn" onClick="parent.validateItemCode(this);disableReason(this);"  value="<%=in_formulary_yn%>" <%=in_formulary_chk%> disabled >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
					  <input type="hidden" name="in_formulary_yn_value" id="in_formulary_yn_value"	value="">
					<td class="label"></td>
					<td class="label"></td>
					<td class="label"></td>
					<td class="label"></td>
			</tr>
				<tr>
				<td align="right" class="label"><fmt:message key="Common.code.label"   bundle="${common_labels}"/></td>
				<td align="left" >&nbsp;&nbsp;<input type="text" name="drug_code" id="drug_code" maxlength="20" size="20"  value="<%=drug_code%>" <%=drug_code%>  disabled onKeyPress="return CheckForSpecChars(event)">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
				<td align="right" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
				<td align="left" colspan="2">&nbsp;&nbsp;<input type="text" name="item_code" id="item_code" maxlength="20" size="20" disabled readonly value="<%=item_code%>"><input type="button" class="button" value="?" disabled name="item_code_lookup" id="item_code_lookup"onClick="parent.searchItem(document.MedicalItemAddModifyForm.item_code)" onfocus="parent.searchItem(document.MedicalItemAddModifyForm.item_code)">
				<%if(!item_code.equals("")){%>
				<IMG src="../../eCommon/images/mandatory.gif" style="visibility:visible" name="mandate_reason">
				<%}%>
                   <td class="label"></td>
                   <td class="label"></td>
				</tr>
			
			<tr>
					<td align="right" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
                  <td align="left" colspan="5">&nbsp;&nbsp;<input type="text" name="drug_desc" id="drug_desc" maxlength="60" size="66" disabled  value="<%=drug_desc%>"<%=drug_desc%>  >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
                 <td class="label"></td>
           </tr>
		   <tr>
				<td align="right"  class="label"  width='20%'><fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label">&nbsp;<select name="pres_base_uom" id="pres_base_uom" onchange="validateCode(this);" disabled>
							<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				          <% for(int i=0; i<termlist.size(); i++)
				{
					termlistvalues = (HashMap)termlist.get(i);
					code = (String)termlistvalues.get("code");
					desc = (String)termlistvalues.get("desc");
			  if(pres_base_uom.equals(code)){%>
            <OPTION value="<%=pres_base_uom%>" selected><%=desc%></OPTION>
			<%
			   break;}
			}
		%>
		</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" >
			</td>
				<td align="right" class="label" ><fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/></td>
					<td align="left" colspan='3' class="label" >&nbsp;<select name="stock_uom" id="stock_uom" onchange="stock_uom_value(this,pres_base_uom);" disabled>
					<%
      	   for(int i=0; i<DispensingUnitlist.size(); i++)
				{
					DispensingUnitValues = (HashMap)DispensingUnitlist.get(i);
					code1 = (String)DispensingUnitValues.get("code");
                    desc1 = (String)DispensingUnitValues.get("desc");
				  if(stock_uom.equals(code1)){%>
         
            <OPTION value="<%=stock_uom%>" selected><%=desc1%></OPTION>
			 <%}
			}
			%>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
				<fmt:message key="Common.contains.label" bundle="${common_labels}"/>
						&nbsp;<b><label id='disp_pres_uom'> <%=content_in_pres_base_uom%>&nbsp;<%=desc%></b>
						</label>
		            <input type="hidden" name="pack_size" id="pack_size"	value="">
				</td>
				<td class="label"></td>

    		</tr>
			<tr>
			
			<td align="right" class="label"><fmt:message key="ePH.DispenseAlternate.label" bundle="${ph_labels}"/></td>
			<td align="left" >&nbsp;<input type="checkbox" name="DispenseAlternate" id="DispenseAlternate" value="<%=disp_multi_strength_yn%>"<%=disp_multi_strength_chk%> disabled ></td>
			<td align="right" class="label"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="3">&nbsp;&nbsp;<input type="text" name="generic_name" id="generic_name" maxlength="40" size="40" readonly value="<%=generic_name%>"><input type="button" class="button" name="gnbtn" id="gnbtn" value="?" disabled onclick="parent.searchGenericName(this);" onfocus="parent.searchGenericName(this);">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" >
			<input type="hidden" name="generic_id" id="generic_id" value="<%=generic_id%>"></td>
			<td class="label"></td>
			</tr>
			<tr>
	        <td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	      <td align="left"colspan="6">&nbsp;<input type="checkbox" name="chk_opt" id="chk_opt" value="<%=discontinued_yn%>"<%=discontinued_chk%> disabled></td>
            </tr>
			<%}%>

		<input type="hidden" name="sql_ph_drug_select25" id="sql_ph_drug_select25" value="<%=sql_ph_drug_select25%>">
		<input type="hidden" name="sql_ph_drug_select14" id="sql_ph_drug_select14" value="<%=sql_ph_drug_select14%>">
		<input type="hidden" name="sql_ph_drug_search_select21" id="sql_ph_drug_search_select21" value="<%=sql_ph_drug_search_select21%>">
		<input type="hidden" name="sql_ph_drug_search_select22" id="sql_ph_drug_search_select22" value="<%=sql_ph_drug_search_select22%>">
		<input type="hidden" name="sql_ph_drug_search_select23" id="sql_ph_drug_search_select23" value="<%=sql_ph_drug_search_select23%>">
		<input type="hidden" name="sql_or_ph_select1" id="sql_or_ph_select1" value="<%=sql_or_ph_select1%>">
		<input type="hidden" name="sql_or_ph_select2" id="sql_or_ph_select2" value="<%=sql_or_ph_select2%>">
		<input type="hidden" name="sql_or_ph_select3" id="sql_or_ph_select3" value="<%=sql_or_ph_select3%>">
		<input type="hidden" name="sql_ph_drug_medical_item_select4" id="sql_ph_drug_medical_item_select4" value="<%=sql_ph_drug_medical_item_select4%>">
			
			
			
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
			<input type="hidden" name="bean_id" id="bean_id"		value="<%= bean_id %>">
            <input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
            <input type="hidden" name="mode" id="mode"	value="<%= mode %>">
            <input type="hidden" name="req_str" id="req_str"	value="<%= req_str %>">           
            <input type="hidden" name="Drug_code_value" id="Drug_code_value"	value="<%= Drug_code_value %>">           
            <input type="hidden" name="varY" id="varY"	value="">           
            <input type="hidden" name="disp_pres_uom_Update" id="disp_pres_uom_Update"	value="<%=content_in_pres_base_uom%>">           
            <INPUT TYPE="hidden" name="or_yn" id="or_yn" VALUE="<%=bean.getORModuleYN()%>">  
            <input type="hidden" name="or_status" id="or_status"	value="<%=or_status%>">           
                
            
			</table>
			</form>
			<script>
			parent.loadButtons('<%=mode%>','<%= Drug_code_value %>');
		</script>
</body>
</html>
<% putObjectInBean(bean_id,bean,request); %>



