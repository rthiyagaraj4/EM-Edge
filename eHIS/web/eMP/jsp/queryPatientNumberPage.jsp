<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
	out.println("<html><head>");
	out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+"</title>");
	out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
	out.println("<script  language='javascript'>	function addOrderByCol()	{ 		var from = document.getElementById('item')('orderbycols'); if ( from.options.length > 0 ) { var to = document.getElementById('item')('orderbycolumns'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element); 			from.remove(from.selectedIndex); } } function removeOrderByCol()	{ var from = document.getElementById('item')('orderbycolumns'); if ( from.options.length > 0 ){ var to = document.getElementById('item')('orderbycols');		var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);			from.remove(from.selectedIndex); } }	function SelectAll(){var i = 0; document.getElementById('orderbycolumns').selectedIndex=0; while ( i < document.getElementById('orderbycolumns').length) { 	document.getElementById('orderbycolumns').options[i].selected=true; i++; }} function execQuery(){  SelectAll(); document.query_form.submit();}</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
	out.println("</head><body onKeyDown='lockKey()'><form name='query_form' id='query_form' method='post' action='../jsp/queryPatientNumber.jsp' onsubmit='SelectAll()'>");

	out.println("<table width='80%' align='center'><tr><td>&nbsp;</td></tr><th align='left' width='20%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")+"</th><tr><td width='60%' ><p class='BOX' title='Query Criteria'><table width='100%'>");


	out.println("<tr><td align='right' width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</td>");
	out.println("<td  align ='left' width='60%'>&nbsp;&nbsp;<input name ='pat_ser_grp_code' size='2' maxlength='2'></td></tr>");

	out.println("<tr><td align='right' width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</td>");
	out.println("<td  align ='left' width='60%'>&nbsp;&nbsp;<input name ='long_desc' size='30' maxlength='30'></td></tr>");


	out.println("</table></td></tr></table></p>");


	out.println("<table width='80%' align='center'><th width='20%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")+"</th><tr><td width='60%'> <p class='BOX' title='Sort Order'><table width='100%'><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</th><th>&nbsp;</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels")+"</th><tr><td width='45%' align='center'><select name='orderbycols' id='orderbycols' size='5' >");
	out.println("<option value='long_desc'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</option>");
	out.println("</select></td>");

	out.println("<td align='center' width='10%'><img src='../../eCommon/images/add.gif' onclick='addOrderByCol()'></img><img src='../../eCommon/images/remove.gif' onclick='removeOrderByCol()'></img></td>");
	out.println("<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>");
	out.println("<option value='pat_ser_grp_code'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</option></select></td></tr></table></p></td></tr></table>");
	out.println("<br><table border='0' width='100%' align='center'><tr><td width='100%' align='center' ><a href='javascript:execQuery()'><img src='../../eCommon/images/RRexecuteQuery.gif' border='0'></a></td></tr></table> ");
	out.println("</form></body></html>");

%>
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

