<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
String sql=	" Select pat_name_as_multipart_yn from mp_param";
String pat_name_as_multipart_yn=""; 	
  Connection con	= null;
 java.sql.Statement stmt	= null;
 ResultSet rset	=null; 	
	try{
		con = ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

	 	rset = stmt.executeQuery(sql);	
 
		if(rset.next())
 		{
 		
		pat_name_as_multipart_yn=rset.getString("pat_name_as_multipart_yn");
		if(pat_name_as_multipart_yn == null || pat_name_as_multipart_yn.equals("null")) pat_name_as_multipart_yn="Y"; 	
		
		}
	}catch(Exception e) {/* out.println(e.toString()); */ e.printStackTrace();}
	finally
	{
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
		
%>
<script>
var temparr = new Array();
var count = 0;
var prev=0;
var prevcol='MENUSUBLEVELCOLOR';
var sec_hdg_cd=new Array();
var logic_seq_no=new Array();

function goHomePage()
{
	parent.location.href='../../eCommon/jsp/dmenu.jsp';
}

function chcol(ro)
{
	document.getElementById("t").rows(prev).cells(0).className=prevcol;
	prevcol=ro.cells(0).className;
	ro.cells(0).className="MENUSELECTEDCOLOR";
	prev=ro.rowIndex;
}

function callJSPs(val)
{
	/*
		Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
	*/
	if(val == 'NatureofDelivery')
		parent.frames[1].location.href = '../../eMP/jsp/NatureOfDelivary.jsp?module_id=MP&function_id=NODTYPE&function_name= '+encodeURIComponent(getLabel('eMP.DeliveryType.label','MP'))+'&function_type=F&access=YYYNN';
	if(val == 'CongenitalAnomalies')
		parent.frames[1].location.href = '../../eMP/jsp/addCongenitalAnomalies.jsp?module_id=MP&function_id=CONGENITALANOMALIES&function_name='+encodeURIComponent(getLabel('eMP.CongenitalAnomalies.label','MP'))+'&function_type=F&access=YYYNN';
	if(val == 'ComplicationsofDelivery')
		parent.frames[1].location.href = '../../eMP/jsp/addComplicationsofDelivery.jsp?module_id=MP&function_id=COMPLICATIONSOFDELIVERY&function_name='+encodeURIComponent(getLabel('eMP.CompofDelivery.label','MP'))+'&function_type=F&access=YYYNN';				
	if(val == 'DeliveryIndication')
		parent.frames[1].location.href = '../../eMP/jsp/addDeliveryIndication.jsp?module_id=MP&function_id=DELIVERYINDICATION&function_name='+encodeURIComponent(getLabel('eMP.DeliveryIndication.label','MP'))+'&function_type=F&access=YYYNN';
		
	if(val == 'ProcedureClassification')			
		parent.frames[1].location.href =
		'../../eMP/jsp/ProcedureClassification.jsp?module_id=MP&function_id=PROCEDURECLASSIFICATION&function_name='+encodeURIComponent(getLabel('eMP.ProcedureClassification.label','MP'))+'&function_type=F&access=YYYNN';

	if(val == 'DeliverySurgicalClassification')
	parent.frames[1].location.href =
	'../../eMP/jsp/DeliverySurgicalClassification.jsp?module_id=MP&function_id=DELIVERYSURGICALCLASSIFICATION&function_name= '+encodeURIComponent(getLabel('eMP.DeliverySurgicalClassification.label','MP')) +'&function_type=F&access=YYYNN';

	// Added by Inayath on 10 Mar 2004 4:24 pm

	if(val == 'VaginalDeliveryType')			
		parent.frames[1].location.href =
	 	'../../eMP/jsp/VaginalDeliveryType.jsp?module_id=MP&function_id=VAGINALTYPE&function_name='+encodeURIComponent(getLabel('eMP.VaginalDeliveryType.label','MP'))+'&function_type=F&access=YYYNN';

}
</script>
</head>
<body onKeyDown = 'lockKey()' style="background-color:dimgray;" >
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>			
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NatureofDelivery')"><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CongenitalAnomalies')"><fmt:message key="eMP.CongenitalAnomalies.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ComplicationsofDelivery')"><fmt:message key="eMP.CompofDelivery.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DeliveryIndication')"><fmt:message key="eMP.DeliveryIndication.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR'			onClick="javascript:callJSPs('ProcedureClassification')"><fmt:message key="eMP.ProcedureClassification.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
		<td class='MENUSUBLEVELCOLOR'
		onClick="javascript:callJSPs('DeliverySurgicalClassification')"><fmt:message key="eMP.DeliverySurgicalClassification.label" bundle="${mp_labels}"/></td>
		</tr>
		<!--Added by Inayath on 10 march 2004 4:21 pm-->
				

		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR'			onClick="javascript:callJSPs('VaginalDeliveryType')"><fmt:message key="eMP.VaginalDeliveryType.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr> 
</table>
</body>
</form>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

