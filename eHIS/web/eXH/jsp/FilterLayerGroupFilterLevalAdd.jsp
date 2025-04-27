<!DOCTYPE html>
<html> 
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
try
{
 

String Filter_type_code=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
String level_number1=XHDBAdapter.checkNull(request.getParameter("level_number"));
String filter_element_type1=XHDBAdapter.checkNull(request.getParameter("filter_element_type"));
String filter_element_type_desc1=XHDBAdapter.checkNull(request.getParameter("filter_element_type_desc"));
String filter_subtype_code1=XHDBAdapter.checkNull(request.getParameter("filter_subtype_code"));
String filter_subtype_desc1=XHDBAdapter.checkNull(request.getParameter("filter_subtype_desc"));
String element_code_name1=XHDBAdapter.checkNull(request.getParameter("element_code_name"));
String lookup_query=XHDBAdapter.checkNull(request.getParameter("loockup_query"));
	String type_query=XHDBAdapter.checkNull(request.getParameter("type_query"));
	String subtype_query=XHDBAdapter.checkNull(request.getParameter("subtype_query"));
String Mode=request.getParameter("actualmode");

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script src='../../eXH/js/filterlayerrefrence3.js' language='javascript'></script>
<script src='../../eXH/js/filterlayerrefrence.js' language='javascript'></script>

<script Language="JavaScript" >

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload='hide()' >
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF"  method="POST" target='messageFrame'  > 
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='10%'></td>
	<td width='20%'></td> 
	<td width='10%'></td>
	<td width='20%'></td>
</tr>

<tr>
<td class=label width='10%'><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text id='Filter_group_desc'  name ='Filter_group_desc' size='15' onBlur="if(this.value!='')searchFiltergroupType();else Filter_group_desc_id.value='' " value='<%=Filter_type_code%>'  ><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='FiltergroupTypeSearch' id='FiltergroupTypeSearch' value='?'    onClick="searchFiltergroupType();searchleval()"><img src='../../eCommon/images/mandatory.gif'><input type="hidden" name="Filter_group_desc_id" id="Filter_group_desc_id" value="<%=Filter_type_code%>"></td>

<td class="label"><fmt:message key="eXH.LevelNumber.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text id="Event_type"  name ='Event_type' size='15'  value='<%=level_number1%>' disabled > 

<input type='hidden' name='Level_number' id='Level_number' value='<%=level_number1%>' >
</td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.FilterType.Label" bundle="${xh_labels}"/></td>
<td align=left> 
<input type=text   name ='Filter_Element_Type' size='15'  value='<%=filter_element_type1%>'  > 
<img src='../../eCommon/images/mandatory.gif' align='middle'></td>
<td class="label"><fmt:message key="eXH.FilterTypedesc.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text   name ='Filter_Element_desc' size='15'  value='<%=filter_element_type_desc1%>'  > 
<img src='../../eCommon/images/mandatory.gif' align='middle'></td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.FilterTypeQuery.Label" bundle="${xh_labels}"/></td>
<td>
<textarea name=Element_query rows=4 cols=50 ><%=type_query%>
</textarea>	
</td>
<td>
</td>
<td>
</td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.FilterSubType.Label" bundle="${xh_labels}"/></td> 
<td align=left>
<input type=text   name ='Filter_subtype_Type' size='15' value='<%=filter_subtype_code1%>'  > 
<img src='../../eCommon/images/mandatory.gif' align='middle'></td>
<td class="label"><fmt:message key="eXH.FilterSubDesc.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text   name ='Filter_subtype_desc' size='15' value='<%=filter_subtype_desc1%>'  > 
<img src='../../eCommon/images/mandatory.gif' align='middle'></td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.FiltersubTypeQuery.Label" bundle="${xh_labels}"/></td>
<td>		<textarea name=Element_subtype rows=4 cols=50 ><%=subtype_query%>
		</textarea>	
	</td>
	<td>
</td>
	<td>
</td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.ElementCode.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text   name ='Filter_Element_Code' size='15' value='<%=element_code_name1%>'  > 
<img src='../../eCommon/images/mandatory.gif' align='middle'></td>
<td>
</td>
<td>
</td>
</tr>
<tr>
<td class="label"><fmt:message key="eXH.ElementQuery.Label" bundle="${xh_labels}"/></td>
		<td><textarea name=Filter_Element_Query rows=4 cols=50 ><%=lookup_query%>
		</textarea>	</td><td>
</td><td>
</td>
</tr>
<tr>
<td>
</td>
<td>
</td>
<td>
</td>

<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record()"><input class='button' type='button'  name='deletebutton' id='deletebutton' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onClick="Delete('D')"><input class='button' type='button'  name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='cancel();'></td>
</tr>
</table>
<input type='hidden' name='actualmode' id='actualmode' value='<%=Mode%>'>	
<input type='hidden' name='rowid' id='rowid' value=''>

<%

}
catch(Exception exp){
         System.out.println("Error in calling getconnection method of FilterLayerGroupFilterLevalAdd.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);

     }    
%>
</form>
</body>
</html>

 

