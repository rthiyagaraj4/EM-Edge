<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	//Connection con=(Connection) session.getValue("connection");

	Connection con= null;
try{
	    request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);

	Statement stmt =con.createStatement();
	ResultSet rs=null;
	ResultSet rs1=null;

%>
<html>
<head>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<script  language="javascript">
	function addOrderByCol() { 
	//alert("3");
		var from = document.getElementById("OrderbyCols"); 
		if ( from.options.length > 0 ) { 
			var to = document.getElementById("OrderbyColumns"); 
			var element = document.createElement("OPTION"); 
			element.text = from.options[from.selectedIndex].text; 
			element.value= from.options[from.selectedIndex].value; 
			to.add(element); 			
			from.remove(from.selectedIndex); 
		}
	} 
	
	function removeOrderByCol()	{ 
		var from = document.getElementById("OrderbyColumns"); 
		if ( from.options.length > 0 ) { 
			var to = document.getElementById("OrderbyCols");
			var element = document.createElement("OPTION"); 
			element.text = from.options[from.selectedIndex].text; 
			element.value = from.options[from.selectedIndex].value; to.add(element);			
			from.remove(from.selectedIndex); 
		} 
	}	
	
	function SelectAll() {
		var i = 0; document.getElementById('OrderbyColumns').selectedIndex=0; 
		while ( i < document.getElementById('OrderbyColumns').length) { 	
			document.getElementById('OrderbyColumns').options[i].selected=true; 
			i++; 
		}
	} 
	
	function execQuery() {  
		SelectAll();
		if(document.forms[0].Module.value =="")
		{
            alert(getMessage('MODULE_CANT_BE_BLANK','SM'));
			focusObject();
		}
		else
		{
	     var module=document.forms[0].Module.value;
		 var name=document.forms[0].Module.options[document.forms[0].Module.selectedIndex].text;
		 
		 var repid=document.forms[0].Report_Id.value;
		 var repdesc=document.forms[0].Report_Desc.value;
		 var repclass=document.forms[0].Report_Class.value;
		 var transyn=document.forms[0].Transaction_Based_Yn.value;
		 var intreqyn=document.forms[0].Internal_Request_Yn.value;
		 var repgrp=document.forms[0].Report_Group_Id.value;

        document.location.href="../../eSM/jsp/queryReportTable.jsp?module_name="+module+"&name="+name+"&Report_Id="+repid+"&Report_Desc="+repdesc+"&Report_Class="+repclass+"&Transaction_Based_Yn="+transyn+"&Internal_Request_Yn="+intreqyn+"&Report_Group_Id="+repgrp
		
		}
		//report_query_form.submit();
	}
	function focusObject()
		{
		document.forms[0].elements[0].focus();
		}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()" onLoad="focusObject()">
<form name="query_form" id="query_form" action="../../eSM/jsp/queryReportTable.jsp" method="post" onSubmit="SelectAll()">
<table width="100%" align="center">
		<th align="left" width="20%"><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" ><p class=label title="Query Criteria">
			<table width="100%">
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
					<td  class='fields' width="60%"><Select name ="Module" id ="Module"><Option value="" Selected>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------
					<%
						rs = stmt.executeQuery("Select Module_Id,Module_Name from Sm_Module order by Module_Name");
						if(rs !=null) {
							while(rs.next()) {
								out.println("<Option Value='" + rs.getString("Module_Id") + "'>" + rs.getString("Module_Name"));
							}
						}
					%></Select> &nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
				</tr>
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></td>
					<td class='fields' width="60%"><input type="text" name ="Report_Id" maxlength="30" size="30" value=""></td>					
				</tr>
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/>&nbsp;</td> 
					<td class='fields' width="60%"><input type="text" name ="Report_Desc" maxlength="60" size="60" value=""></td>					
				</tr>
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Class.label" bundle="${common_labels}"/></td>
					<td class='fields' width="60%"><Select name ="Report_Class" id ="Report_Class"><Option value="" Selected>------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------<Option value="R"><fmt:message key="Common.report.label" bundle="${common_labels}"/><Option value="L"><fmt:message key="Common.Label.label" bundle="${common_labels}"/></Select></td>
				</tr>	
				<tr>
					<td nowrap width="40%" class="label"><fmt:message key="eSM.TransactionBased.label" bundle="${sm_labels}"/></td>
					<td  class='fields' width="60%"><Select name ="Transaction_Based_Yn" id ="Transaction_Based_Yn"><Option value="" Selected>----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------<Option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/><Option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></Select></td>
				</tr>	
				<tr>
					<td width="40%" class="label"><fmt:message key="eSM.InternalRequest.label" bundle="${sm_labels}"/></td>
					<td class='fields' width="60%"><Select name ="Internal_Request_Yn" id ="Internal_Request_Yn"><Option value="" Selected>----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------<Option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/><Option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></Select></td>
				</tr>	
				<tr>
					<td width="40%" class="label"><fmt:message key="eSM.ReportGroup.label" bundle="${sm_labels}"/></td>
					<td class='fields' width="60%"><Select name ="Report_Group_Id" id ="Report_Group_Id"><Option value="" Selected>------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------
					<%						
						String sql="Select Report_Group_Id,Short_Desc from Sm_Report_Group where eff_status='E' and ( (eff_date_from <= sysdate and eff_date_to >= sysdate ) or (eff_date_from <= sysdate and eff_date_to is null ) or (eff_date_to >= sysdate and eff_date_from is null) or (eff_date_from is null and eff_date_to is null ) )";
						rs1 = stmt.executeQuery(sql);
						if(rs1 !=null) {
							while(rs1.next()) {
								out.println("<Option Value='" + rs1.getString("Report_Group_Id") + "'>" + rs1.getString("Short_Desc"));
							}
						}
					%></Select></td>
				</tr>
			</table>
		</td>
	</tr>
				<table  width='100%' align='center'><th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/><tr><td nowrap  width='60%' >  <p  title='Sort Order'>
				<table width='50%' align="center" border='0'><td  nowrap align='left'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td><td>&nbsp;</td><td nowrap align='left' ><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td><tr><td nowrap width='60%'  >
				<tr>
					<td width="45%" align="right" class='fields'><Select name="OrderbyCols" id="OrderbyCols" size="3"><Option value="Report_Id"><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/><Option value="Report_Desc"><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></Select></td>
					<td align='center' width='50%' class='fields' title="Sort Order"><input type='button' name='add' id='add' title="Sort Order" class='button' onclick='addOrderByCol()' value='---->'><br> <input type='button' name='add' id='add' title="Sort Order" class='button'  value='<----' onclick='removeOrderByCol()'></img></td>
					<td width="60%" align="right" class='fields'><Select name="OrderbyColumns" id="OrderbyColumns" size="3" multiple="true"><Option value="Module_Id"><fmt:message key="Common.ModuleId.label" bundle="${common_labels}"/>  <!-- <Option value="Report_Id">Report ID --> </Select></td>
				</tr>
			</table>
</table><br>
<br><table border='0' width='100%' align='center'><tr><td nowrap width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()' Value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels")%>'></td></tr></table> 
</form>
<%
	if(stmt !=null) stmt.close();
	if(rs != null) rs.close();
	if(rs1 != null) rs1.close();
%>
</body>
</html>
 <%
} catch (Exception e) {}
finally{
 ConnectionManager.returnConnection(con,request);
}

%>

