<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
			request.setCharacterEncoding("UTF-8");
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/Item.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	</head>
	<body onload="formFocus();" onMouseDown="CodeArrest()">
<%
    String disabled					=		"disabled";
	String codeDisabled				=		"";
	String mode						=		"";
	String bean_id					=		"";
	String bean_name				=		"";
	String stDisabled				=		"";
	String stEffstatus				=		"";

	/* Mandatory checks start */
	mode							=		request.getParameter( "mode" ) ;
	bean_id							=		"SSitemBean" ;
	bean_name						=		"eSS.SsItemBean";

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	eSS.SsItemBean bean					=		(eSS.SsItemBean)getBeanObject( bean_id,bean_name, request  ) ;  
	bean.clear() ;
	

	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	bean.setAcc_entity_id( (String) session.getAttribute("ACC_ENTITY_ID")) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	/* Initialize Function specific end */

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	=	"disabled";
		disabled        =	"";
		if (null == request.getParameter( "item_code" ) )
			return;		
        String stItem = request.getParameter( "item_code" ) ;
		bean.setItem_code(stItem) ;

		stEffstatus=bean.getItemEffStatus(stItem);
        
		if(stEffstatus.equals("D"))
          stDisabled="disabled" ;
		else
          stDisabled="enabled" ; 

		bean.loadData() ;
	}

%>
	<form name="formItem" id="formItem"   onreset="formFocus();">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
		<td width='100%' align='center' class="WHITE">
		<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
		<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td class="label">&nbsp;&nbsp;<input type='text' name="item_desc" id="item_desc" value="<%=bean.getShort_desc()%>" maxLength='40' size='20' <%=codeDisabled%> ><input type='button' class='BUTTON' value='?' onClick="searchItem(item_code,item_desc);" <%=codeDisabled%> name="item_search"><%=bean.getMandatoryImageTag()%><input type="hidden" name="item_code" id="item_code" value="<%=bean.getItem_code()%>"></td>
		</tr>

		<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><%=(bean.hasParameter()&&(!(bean.checkForNull((String)bean.getItem_image_path())).equals("")))?"<a href='javascript:displayImage(document.formItem.item_image_file_name);'>":""%><fmt:message key="eSS.ImageFile.label" bundle="${ss_labels}"/></a></td>
			<td class="label">&nbsp;&nbsp;<input type='text' name="item_image_file_name" id="item_image_file_name" maxLength=200 size='50' value="<%=bean.getItem_image_file_name()%>"  <%=stDisabled%> ></td>
		</tr>

		<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="eSS.Consumable.label" bundle="${ss_labels}"/></td>
			<td class="label">&nbsp;<input type='checkbox' name="consumable_yn" id="consumable_yn"  value="Y" <%=bean.getChecked(bean.getConsumable_yn())%>  <%=stDisabled%> onClick="javascript:modifyChrgblChkBox();" ></td>
		</tr>

		<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="eSS.Chargeable.label" bundle="${ss_labels}"/></td>
			<td class="label">&nbsp;<input type='checkbox' name="chargeable_yn" id="chargeable_yn"  value="Y" <%=bean.getChecked(bean.getChargeable_yn())%> <%=disabled%> ></td>
		</tr>

		<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		</table>
		</td>
		</tr>
		</table>
		<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="locale" id="locale"				value="<%=locale%>">
		<input type="hidden" name="SQL_SS_ITEM_LOOKUP" id="SQL_SS_ITEM_LOOKUP"	value="<%= bean.getSsRepositoryValue("SQL_MM_ITEM_LOOKUP_NOT_IN_SS_ITEM")%>">
	</form>	

<%
//Modified on 29th may 2007

String defaultpath=bean.getItem_image_path();
StringBuffer s=new StringBuffer().append("\\\\");

try{
 StringTokenizer st=new StringTokenizer(defaultpath,"\\");
 while (st.hasMoreTokens()){
  s.append("\\\\");
  s.append(st.nextToken());
 }
 defaultpath=s.toString();
}catch(NullPointerException ne){
	System.out.println(ne.toString());
}
%>

	<script language="JavaScript">
	modifyChrgblChkBox();
	//<!--
		async function displayImage(obj){
			var fileName	=	obj.value;
			if(trimCheck(fileName)){
				var defaultPath	= "<%=defaultpath%>";
				var dialogHeight= "70vh" ;
				var dialogWidth	= "80vw" ;
				var dialogTop = "60" ;
				var center = "1" ;
				var status="no";
				var features	= " dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: auto " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				var url = "../../eSS/jsp/SsImagePreview.jsp?item_image_file="+defaultPath+"\\"+fileName;
				
				await window.showModalDialog(url,arguments,features);
			}
		}
	//-->

    function modifyChrgblChkBox(){
	 if(document.formItem.consumable_yn.checked==true){
       document.formItem.chargeable_yn.disabled=false;
	 }else{
       document.formItem.chargeable_yn.checked=false;  
	   document.formItem.chargeable_yn.disabled=true;
	 }
	}

	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%
putObjectInBean("ssItemBean",bean,request);
%>
</body>
</html>

