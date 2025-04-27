<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale					=		(String)session.getAttribute("LOCALE");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String user_name				=		(String) session.getValue( "login_user" ) ;
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!--<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>
		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language='javascript' src="../../eST/js/SuspendOrReinstateBatch.js"></script>
	<!--<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
   <!-- Added by Rabbani #Bru-HIMS-CRF-111[INC NO:30070] -->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	//java.util.HashMap defaultParameter	=		null;
	String bean_id							=		"SuspendOrReinstateBatchBean";
	String bean_name						=		"eST.SuspendOrReinstateBatchBean";
	String disable							=		"";

	SuspendOrReinstateBatchBean bean		=		(SuspendOrReinstateBatchBean) getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
    bean.initialize();
	String stFunctionId						=		(String)request.getParameter("function_id") ;
  	String stDisable_hide					=		"" ;

 if(stFunctionId.equals("ST_RECORD_COMPLAINT_BATCH")){
 //     bean.setExternal_YN("Y");
      stDisable_hide						=		"disabled" ; 
	}

	//String index							=		bean.checkForNull(request.getParameter("index"),"-1");
	
	String mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	//ArrayList dataList=new ArrayList();
	//ArrayList recordSet=new ArrayList();
	 ArrayList	arrTrnfacility				=	null;
	 arrTrnfacility   =	 bean.getFacility_names();

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
			disable						=		"disabled";
	}
	
	//String trn_across_facility_yn  = bean.checkForNull((String)bean.fetchRecord("select  trn_across_facility_yn  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("TRN_ACROSS_FACILITY_YN"),"N");

	%>

<body >
<form name="SuspendReinstate_form" id="SuspendReinstate_form" onload='FocusFirstElement();'>

<div >

<table border="0" cellpadding="0" cellspacing="0" width='100%'>

<!-- Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  01-AUG-2013 Starts -->
        <tr>
         <td class=label  colspan = 0 nowrap><fmt:message key="eST.Facility.label" bundle="${st_labels}"/> </td><td   class=fields><select name='dflt_facility_id' id='dflt_facility_id' >
			<%if(arrTrnfacility.size() > 1){%>
		  <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
		   <% }%> 
		  <%=bean.getFacilitynames()%>
			</select></td>
			
			 <!--<td nowrap colspan = 0 class= "label" >&nbsp;<input type="checkbox" value="N" name="selectAll" id="selectAll"   onClick="return toggleCheck(this);">&nbsp;&nbsp;<fmt:message key="eST.AllStores.label" bundle="${st_labels}"/></td> -->
             <td  class="label" colspan = 7 nowrap  ><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<input maxLength=8 size=8 name="store_code" id="store_code" value="" onBlur="ChangeUpperCase(this);" disabled><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeStore(store_code);" type="button" value="?" disabled >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" value="Y" name="selectAll" id="selectAll"  checked  onClick="return toggleCheck(this);">&nbsp;&nbsp;<fmt:message key="eST.AllStores.label" bundle="${st_labels}"/> </td>			 
		</tr>
		
		<tr></tr><tr></tr><tr></tr>
		<!-- ends -->
  <tr>
	<td   class="label" nowrap>
    <fmt:message key="Common.item.label" bundle="${common_labels}"/></td><td  class="fields"  >
	<input type='text' size='60'  maxlength='60' name='item_desc' id='item_desc'  value=""  onBlur="ChangeUpperCase(this)" <%=disable%>><input class='button' type='button' name='searchItem' id='searchItem' value='?' <%=disable%> onClick="callItemSearchScreen(item_desc,document.forms[0])" class="label">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'>&nbsp;&nbsp;<span align='center' nowrap><b id="uom" align='center'>&nbsp;</b></span></td>
	<td  class="label" id ="exp_id" nowrap>&nbsp;</td>
	<td  class="label"  colspan='6'width='30%'>
	<span id ="exp_data"></span></td>
	
<!-- 
</table>

<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>
	<td colspan=1 width="13%">&nbsp;</td>
	<td colspan=7 >&nbsp;</td> -->
	<tr></tr><tr></tr><tr></tr>
<tr>
	<td   class="label" colspan = 0 >
	<fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
	<td   class=fields colspan = 0>
	<select name='manufacturer' id='manufacturer'  <%=disable%> >
	<option>&nbsp;&nbsp;&nbsp;&nbsp;--- --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---	---&nbsp;&nbsp;&nbsp;&nbsp;</option></select></td>
	<td   class="label" colspan='3'>
	<!--  /** @ 
						 CRF_SRR20056-CRF-0537.1 
						change the batch width 10 to 20

		**/  -->
	<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>
	<input  type=text  size=20 maxlength=20  name ="batch_id" onBlur="ChangeUpperCase(this);"></td>
	<% if( ! stDisable_hide.equals("disabled")) {%> 
	<td    class="label" nowrap>
	<fmt:message key="eST.SelectBatchFor.label" bundle="${st_labels}"/></td>
	<td    class=fields>
	<select   name ="Batch"  onBlur="loadBlank();" onChange="ChangeLabel(this)" ><%=bean.getBatchStatus()%></select></td>
   	<td   class="label" id ="label_complained" nowrap>
	<fmt:message key="eST.IncludeNotifiedBatches.label" bundle="${st_labels}"/></td>
    <td  class="fields"   >&nbsp;<input  type=checkbox  id="tb1" name ="include_complained_items" value="Y" onClick="setValue();" checked></td>
	<% } else { %>
	<td    class="NODISPLAY" nowrap>
	<fmt:message key="eST.SelectBatchFor.label" bundle="${st_labels}"/></td>
	<td  class="NODISPLAY"  class=feilds>&nbsp;
	<select   name ="Batch"  onBlur="loadBlank();" onChange="ChangeLabel(this)" >
		<option value="C">
		<fmt:message key="eST.Notify.label" bundle="${st_labels}"/></option>
		<option value="S">
		<fmt:message key="Common.Suspend.label" bundle="${common_labels}"/></option>
		<option value="R">
		<fmt:message key="Common.Reinstate.label" bundle="${common_labels}"/></option>
		</select></td>
   	<td  class="NODISPLAY" id ="label_complained" nowrap><fmt:message key="eST.IncludeNotifiedBatches.label" bundle="${st_labels}"/></td>
    <td  class="NODISPLAY"  class=fields>&nbsp;<input  type=checkbox  id="tb1" name ="include_complained_items" value="Y" onClick="setValue();" checked></td>
<% } %>


</tr>

<tr>
	<td align="right" colspan=9 ><input type=button name='select' id='select' disabled value='<fmt:message key="eST.ShowBatchInfo.label" bundle="${st_labels}"/>' class='Button'  onClick="displayResult();"></td>
</tr>
</table>
</div>
	<input type='hidden' name='mode' id='mode'				value='<%=mode%>'>
	<input type='hidden' name='checkBoxVals' id='checkBoxVals' >
	<input type='hidden' name='bean_id' id='bean_id'				value="<%=bean_id%>" >
	<input type='hidden' name='bean_name' id='bean_name'			value="<%=bean_name%>" >
	<input type='hidden' name='item_code' id='item_code'			value="<%=bean.getItem_code()%>" >
	<input type='hidden' name='uom_desc' id='uom_desc'			value="" >
	
	
	<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_SUSPEND_BATCH")%>">
	<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
	<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
	 

</form>
<%
putObjectInBean(bean_id,bean,request);

%>


</body>
</html>

