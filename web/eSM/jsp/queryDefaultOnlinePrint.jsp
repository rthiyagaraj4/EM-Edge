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
	//alert("1");
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
		//if(document.forms[0].Module.value =="")
		//{
       //     alert(getMessage('MODULE_CANT_BE_BLANK','SM'));
		//	focusObject();
		//}
		//else
		//{
	     var module=document.forms[0].Module.value;
		 var name=document.forms[0].Module.options(document.forms[0].Module.selectedIndex).text;
		 
		
		 var repdesc=document.forms[0].Report_Desc.value;
		 var funcname=document.forms[0].func_name.value;
		 var orderby="";
		 // Condition Added Aginst Incident 40427
		 if(document.getElementById('OrderbyColumns').options.length==0)
		 {
		 alert(getMessage('ORDERBY_NOT_BLANK','Common'))
		 }
		 else
		 {
		 for(var i=0;i<document.getElementById('OrderbyColumns').options.length;i++){
				orderby=orderby+document.getElementById('OrderbyColumns').options[i].value+", "
		 }
		orderby = orderby.substring(0,orderby.length-2)
        document.location.href="../../eSM/jsp/queryResultDefaultOnlinePrint.jsp?module_id="+module+"&name="+name+"&Report_Desc="+encodeURIComponent(repdesc)+"&func_name="+encodeURIComponent(funcname)+"&orderbycolumns="+encodeURIComponent(orderby);
		
		}		
	}
	function focusObject()
		{
		document.forms[0].elements(0).focus();
		}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()" onLoad="focusObject()">
<form name="query_dflt_online_prnt_form" id="query_dflt_online_prnt_form" action="../eSM/jsp/queryResultDefaultOnlinePrint.jsp" method="post">
<table width="100%" align="center">
		<th align="left" width="20%"><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" ><p class=label title="Query Criteria">
			<table width="100%">
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
					<td  class='fields' width="60%"><Select name ="Module" id ="Module"><Option value="" Selected>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------
					<%
						rs = stmt.executeQuery("Select distinct a.Module_Id,b.Module_Name from sm_dflt_online_print a, Sm_Module b where a.module_id=b.module_id");
						if(rs !=null) {
							while(rs.next()) {
								out.println("<Option Value='" + rs.getString("Module_Id") + "'>" + rs.getString("Module_Name"));
							}
						}
					%></Select></td>
				</tr>
									
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/>&nbsp;</td> 
					<td class='fields' width="60%"><input type="text" name ="func_name" maxlength="60" size="60" value=""></td>					
				</tr>

				<tr>
					<td width="40%" class="label"><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/>&nbsp;</td> 
					<td class='fields' width="60%"><input type="text" name ="Report_Desc" maxlength="60" size="60" value=""></td>					
				</tr>
			</table>
		</td>
	</tr>
				<table  width='100%' align='center'><th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/><tr><td nowrap  width='60%' >  <p  title='Sort Order'>
				<table width='50%' align="center" border='0'><td  nowrap align='left'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td><td>&nbsp;</td><td nowrap align='left' ><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td><tr><td nowrap width='60%'  >
				<tr>
					<td width="45%" align="right" class='fields'><Select name="OrderbyCols" id="OrderbyCols" size="3"><Option value="c.FUNCTION_NAME"><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></option><Option value="d.report_desc"><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></option></Select></td>
					<td align='center' width='50%' class='fields'><input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->' title="Sort Order"><br> <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()' title="Sort Order"></td>
					<td width="60%" align="right" class='fields'><Select name="OrderbyColumns" id="OrderbyColumns" size="3" multiple="true"><Option value="a.Module_Id"><fmt:message key="Common.ModuleId.label" bundle="${common_labels}"/> </option></Select></td>
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

