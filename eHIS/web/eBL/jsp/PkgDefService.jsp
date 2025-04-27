<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
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
<script language="javascript" src='../js/PkgDef.js'></script>
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

		//String packageCode		=	"";//unused variable
		//ArrayList priceFromDate	=	new ArrayList();//unused variable
		//ArrayList priceToDate	=	new ArrayList();//unused variable
		//String strAllParam		= request.getQueryString();
		//System.err.println("strAllParam in ClassDetails.jsp:"+strAllParam);
		//String bean_id		= "PkgDefBean"+packageCode ;
	//	String bean_name	= "eBL.PkgDefBean";
		//PkgDefBean bean			= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
		//String strAllParamprice		= request.getQueryString();//unused variable
		//System.out.println("strAllParamprice from Base Price"+strAllParamprice);

	
		
		String mode				= "";
		if(mode == "modify")
		{
		}
   %>
<script>



</script>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	
	<form name='frmPkgDefService' id='frmPkgDefService'>	
		<div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 355px;   padding:3px; margin: 0px">
		<table border='0' cellpadding='1' cellspacing='1' align='center' width='100%' id="pkgPrice">
			<td  class='fields' width="15%"><input type='text' name='chk' id='chk' id='chk'size='10' maxlength="10"  value="" onBlur="temp(1);">
		<!-- 	<tr >
			<td  class='COLUMNHEADER' width="25%"><b><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></b></td>
			<td  class='COLUMNHEADER' width="25%"><b><fmt:message key="Common.todate.label" bundle="${common_labels}"/></b></td>	
			<td  class='COLUMNHEADER' width="25%"><b><fmt:message key="Common.Price.label" bundle="${common_labels}"/></b></td>
			</tr>


			<tr >
			<td  class='fields' width="15%"><input type='text' name='fromDate_1' id='fromDate_1' id='fromDate_1'size='10' maxlength="10"  value="" onBlur="temp(1);"><img id = 'fromDate_img_1' name="fromDate_img_1" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromDate_1');" ><img src='../../eCommon/images/mandatory.gif'></td>
			<td  class='fields' width="15%"><input type='text' name='toDate_1' id='toDate_1'  id='toDate_1' size='10' maxlength="10"  value="" onBlur="temp(1);"><img id = 'toDate_img_1' name="toDate_img_1" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('toDate_1');" ></td>	
			<td  class='fields' width="15%"><input type='text' name='price_1' id='price_1' size='15' maxlength="15"  value="" onBlur=""></td>
			</tr> -->
		</table>		
			</div>		
<!-- 		<input type='hidden' name='total_records' id='total_records' value="">
 	 <TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	  <tr>
		  <td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'><INPUT type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add/New.label","common_labels")%>" onclick="addRow('pkgPrice')" /></td> 
   </tr> 
			</table> -->
<script>parent.updateCurrentForm("PACKAGE_SERVICE","PkgDefTabFrame.document.frmPkgDefService","PkgDefHeader.document.frmPkgDefHeader");</script>

</form>
</body>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from Package defintion header :"+e);
	e.printStackTrace();
}
%>

