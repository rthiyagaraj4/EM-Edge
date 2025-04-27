<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.* , eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
	<html>
	<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//String locale			= (String)session.getAttribute("LOCALE");
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String version_no	=	"";
	version_no	= (String) PhVersionNo.getVersion();
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
   <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href="../../eCommon/jsp/CommonClearObjects.jsp";
		}

		async function showFunctionality(){
		var retVal = new Array();

		var features	= 'dialogHeight:33vh;dialogWidth:40vw;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';
		var arguments	= '' ;

		var vals = parent.parent.header.document.header_form.menu_values.value;
		PHMasterMenu_form.menu_values.value = vals;

		arguments = vals

		//retVal = window.showModalDialog('change_functionality.jsp',arguments,features);

		retVal	= await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol
				prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
;
			if(val == 'DispLocation')
				parent.frames[1].location.href = '../../ePH/jsp/DispenseLocation.jsp?module_id=ePH&function_id=PH_DISP_LOCN&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.DispenseLocation.label","PH"));

			if(val == 'DispLocationTimeTable')
				parent.frames[1].location.href = '../../ePH/jsp/DispLocnTimeTable.jsp?module_id=ePH&function_id=PH_DISP_LOCN_TABLE&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.DispLocationTimeTable.label","PH"));			

			if(val == 'TokenSeries')
				parent.frames[1].location.href = '../../ePH/jsp/TokenSeries.jsp?module_id=ePH&function_id=PH_TOKEN_SERIES&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.TokenSeries.label","PH"));

			if(val == 'DispenseRights')
				parent.frames[1].location.href = '../../ePH/jsp/DispenseRights.jsp?module_id=ePH&function_id=PH_DISP_RIGHTS&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("ePH.DispensingRights.label","PH"));

		/*	if(val == 'DispenseRules')
				parent.frames[1].location.href = '../../ePH/jsp/DispenseRules.jsp?module_id=ePH&function_id=PH_DISP_RULES&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("ePH.DispensingRules.label","PH"));*/

			if(val == 'OrderRouting')
				parent.frames[1].location.href = '../../ePH/jsp/OrderRouting.jsp?module_id=ePH&function_id=PH_ORDER_ROUTING&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("ePH.OrderRouting.label","PH"));

		/*	if(val == 'DrugItemLink')
				parent.frames[1].location.href = '../../ePH/jsp/DrugItemLink.jsp?module_id=ePH&function_id=PH_DRUG_ITEM_LINK&function_type=F&access=NYNNN&function_name='+encodeURIComponent(getLabel("ePH.DrugToItemLink.label","PH"));*/

			if(val == 'TransType')
				parent.frames[1].location.href = '../../ePH/jsp/TransType.jsp?module_id=ePH&function_id=PH_TRANS_TYPE&function_type=F&access=NNYNN&function_name='+encodeURIComponent(getLabel("Common.transactiontype.label","Common"));

			if(val == 'DocumentType')
				parent.frames[1].location.href = '../../ePH/jsp/DocumentType.jsp?module_id=ePH&function_id=PH_TRN_DOC_TYPE&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("Common.documenttype.label","Common"));

			if(val == 'ReconstituentFluid')
				parent.frames[1].location.href = '../../ePH/jsp/ReconstituentFluid.jsp?module_id=ePH&function_id=PH_RECONST_FLUID&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.ReconstituentFluid.label","PH"));

			if(val == 'AlternateDispLocn')
				parent.frames[1].location.href = '../../ePH/jsp/AltDispLocn.jsp?module_id=ePH&function_id=PH_ALT_DISP_LOCN1&function_type=F&access=YYNNN&function_name='+encodeURIComponent(getLabel("ePH.AlternateDispensingLocation.label","PH"));

			if(val == 'WsDispLocn')
				parent.frames[1].location.href = '../../ePH/jsp/WsDispLocn.jsp?module_id=ePH&function_id=PH_WS_DISP_LOCN&function_type=F&access=YNYYN&function_name='+encodeURIComponent(getLabel("ePH.WorkstationforDispenseLocation.label","PH"));

			if(val == 'WsTokenSeries')
				parent.frames[1].location.href = '../../ePH/jsp/WsTokenSeries.jsp?module_id=ePH&function_id=PH_WS_TOKEN_SERIES&function_type=F&access=YNYNN&function_name='+encodeURIComponent(getLabel("ePH.WorkstationsforTokenSeries.label","PH"));

			if(val == 'ReconstituentFluidForDrug')
				parent.frames[1].location.href = '../../ePH/jsp/RFDFrames.jsp?module_id=ePH&function_id=PH_RECONST_FLUID_FOR_DRUG&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.ReconstituentFluidforDrug.label","PH"));
            if(val == 'PINAuthorizedRights')
				parent.frames[1].location.href = '../../ePH/jsp/PINAuthorizedRights.jsp?module_id=ePH&function_id=PIN_AUTHORIZED_RIGHTS&function_type=F&access=YYYYY&function_name='+encodeURIComponent(getLabel("ePH.PINAuthorizationRights.label","PH")); 
			if(val == 'DrugInformationRequest')
				parent.frames[1].location.href = '../../ePH/jsp/DrugInformationRequest.jsp?module_id=ePH&function_id=DRUG_INFO_REQUEST&function_type=F&access=YYYNY&function_name='+encodeURIComponent(getLabel("ePH.DrugInformationRequest.label","PH"));  
            if(val == 'DrugInformationSource')
				parent.frames[1].location.href = '../../ePH/jsp/DrugInformationSource.jsp?module_id=ePH&function_id=DRUG_INFO_SOURCE&function_type=F&access=YYYNY&function_name='+encodeURIComponent(getLabel("ePH.DrugInformationSource.label","PH"));
            if(val == 'Holiday')
				parent.frames[1].location.href = '../../ePH/jsp/Holiday.jsp?module_id=ePH&function_id=PH_HOLIDAY&function_type=F&access=YYNYY&function_name='+encodeURIComponent(getLabel("Common.Holidays.label","Common"));  
            if(val == 'StoreForLocation')
				parent.frames[1].location.href = '../../ePH/jsp/StoreForLocation.jsp?module_id=ePH&function_id=PH_STOREFORLOCN&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.StoreForLocation.label","PH"));  
            if(val == 'LocationStoreItems')
				parent.frames[1].location.href = '../../ePH/jsp/LocationStoreItems.jsp?module_id=ePH&function_id=PH_LOCNSTOREITEMS&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.LocationStoreItems.label","PH"));  		}

	</script>
     
	</head>

	<!-- <body style="background-color:dimgray;"  > -->
	<body style="background-color:dimgray;" onMouseDown="" onKeyDown="lockKey()" >
	<form name="PHMasterMenu_form" id="PHMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DispLocation')" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		</tr>

 		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DispLocationTimeTable')" ><fmt:message key="ePH.DispLocationTimeTable.label" bundle="${ph_labels}"/></td>
		</tr> -->

		<tr onclick='chcol(this)'>
             <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AlternateDispLocn')" ><fmt:message key="ePH.AlternateDispensingLocation.label" bundle="${ph_labels}"/></td>
		</tr>

<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DispenseRules')" ><fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></td>
		</tr> -->

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DispenseRights')" ><fmt:message key="ePH.DispensingRights.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('WsDispLocn')" ><fmt:message key="ePH.WorkstationforDispenseLocation.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TokenSeries')" ><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('WsTokenSeries')" ><fmt:message key="ePH.WorkstationsforTokenSeries.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OrderRouting')" ><fmt:message key="ePH.OrderRouting.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TransType')" ><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DocumentType')" ><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
		</tr>

<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugItemLink')" ><fmt:message key="ePH.DrugToItemLink.label" bundle="${ph_labels}"/></td>
		</tr> -->
		<%if(!version_no.equals("1")){%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ReconstituentFluid')" ><fmt:message key="ePH.ReconstituentFluid.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ReconstituentFluidForDrug')" ><fmt:message key="ePH.ReconstituentFluidforDrug.label" bundle="${ph_labels}"/></td>
		</tr>
		<%}%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PINAuthorizedRights')" ><fmt:message key="ePH.PINAuthorizationRights.label" bundle="${ph_labels}"/></td>
		</tr>
		 <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugInformationRequest')" ><fmt:message key="ePH.DrugInformationRequest.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugInformationSource')" ><fmt:message key="ePH.DrugInformationSource.label" bundle="${ph_labels}"/></td>
		</tr>
        <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('StoreForLocation')" ><fmt:message key="ePH.StoreForLocation.label" bundle="${ph_labels}"/></td>
		</tr>
        <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('LocationStoreItems')" ><fmt:message key="ePH.LocationStoreItems.label" bundle="${ph_labels}"/></td>
		</tr>
        <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Holiday')" ><fmt:message key="Common.Holidays.label" bundle="${common_labels}"/></td>
		</tr>
		<tr >
			<td class='MENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>

		<input type=hidden name='menu_values' id='menu_values'>

	</table>

	</body>
	</form>
</html>

