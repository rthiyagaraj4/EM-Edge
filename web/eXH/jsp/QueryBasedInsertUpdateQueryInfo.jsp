<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>Data Source Mapping ? Configname</title>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript">

var flag = 0;
var sgmnt1 = "";
var colTxt = "";
var qryText = "";
var colcount =0;
var flag1 = 0;
var whrFlag = 0;
 
function CheckDate(obj){
	Object2 = obj.value;
	datefield = obj;
    if (ChkDate(Object2)) {
	    return true;
	}
	else{
//		alert("Invalid Date Format(DD/MM/YYYY) ");
        alert(getMessage("XH1045", "XH"));
        if (datefield.value != undefined)
        {
            datefield.select();
            datefield.focus();
        }
    }
 }

function CheckForNumber(obj){
	var colfield = obj;
	var col_val  = obj.value;
	if ( trimCheck(col_val) && isNaN(col_val) == false && col_val >=0){
		return true;
	}
	else{
//		alert("Not a Valid Number ");
	    alert(getMessage("XH1028", "XH")); 
		colfield.select();
		colfield.focus();
	}

}


function slctColumn(){
		 document.forms[0].col_val.value="";
		 if(this.document.forms[0].resetflag.value=='0'){
			 flag1 = 0;
		 }
	 	 if(flag1==1){
		 	 document.forms[0].add.disabled = false;
		 }	
}

function slctWhrClause(){
  		 document.forms[0].where_cond.disabled	  = false;
  		 document.forms[0].whr_text.value="";
 		 document.forms[0].whr_text.disabled	  = false;
	 	 if(whrFlag==1){
		 	 document.forms[0].addWhrCls.disabled = false;
		 }
}



</script>
<%
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/QueryBasedInbound.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
String qryError = "";
String qryResult= "";

String mod_name = "";
String tbl_name = "";

Connection connection = null;
connection = ConnectionManager.getConnection(); 

String qryType = XHDBAdapter.checkNull(request.getParameter("qryType"));
//	//System.out.println("QueryBasedInsertUpdateQueryInfo qryType : "+qryType);

String strBeanName    = QueryBasedInboundBean.strBeanName;
	//System.out.println("QueryBasedInsertUpdateQueryInfo strBeanName : "+strBeanName);


ArrayList modulenames = null;

QueryBasedInboundBean	xhBean = (QueryBasedInboundBean)QueryBasedInboundBean.getBean(strBeanName,request,session);
session.setAttribute("strBeanName",xhBean);
%>	

<form name="queryInfo" id="queryInfo" >
<table cellspacing=0 cellpadding=1 width='100%' align=center>
	<tr>
		<td class=label><fmt:message key="eXH.Domain.Label" bundle="${xh_labels}"/></td>
		<td colspan=3 class='fields'>
			<SELECT name="module_name" id="module_name" onChange='setValues(this);'  >
<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<% 

			String mdl_name = XHDBAdapter.checkNull(request.getParameter("module_name"));
//			modulenames = (ArrayList)xhBean.getModules(connection);
			modulenames = (ArrayList)xhBean.getModules();
			for (int j=0; j<modulenames.size();j++){
				mod_name = (String)modulenames.get(j);
	//			System.out.println("Mod Name : "+mod_name);
				String selected = (String)(request.getParameter("module_name"));
				out.println("SELECTED "+selected);
				if(selected != null && selected.equalsIgnoreCase(mod_name))
					selected = "selected";
				else
					selected = ""; 	
			%>

			<option value="<%=mod_name%>" <%= selected %> > <%=mod_name%> </option>
			<%}%>
			</SELECT>
		</td>
	</tr>

	<tr>
		<td class=label><fmt:message key="eXH.Entity.Label" bundle="${xh_labels}"/> </td>
		<td colspan=3 class='fields'>
			<SELECT name="table_name" id="table_name" onChange='setValues(this);' >
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>		
			</SELECT>
		</td>
	</tr>

	<tr>
		<td class=label><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<td colspan=3 class='fields'>
			<SELECT name="insert_type" id="insert_type" onchange='dispAllCols();'>
				<option value='S'><fmt:message key="eXH.SelectedCols.Label" bundle="${xh_labels}"/> </option>
				<option value='A'><fmt:message key="eXH.AllCols.Label" bundle="${xh_labels}"/> </option>
			</SELECT>
		</td>
	</tr>

	<tr>
		<td class=label><fmt:message key="Common.Field.label" bundle="${common_labels}"/></td>
		<td class='fields'>

			<SELECT name="column_name" id="column_name" onchange='slctColumn();'>
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>		
			</SELECT>
		</td>
		<td>
			<input type=text name=col_val size=20 value='' onblur='chkForNotNull();' onchange='slctColumnVal();' >
		</td>
		<td class='BUTTON'>
			<input class='button' type="button" disabled name='add' id='add' value='<fmt:message key="eXH.AddField.Label" bundle="${xh_labels}"/>' onclick='addField();' >
		</td>
	</tr>

	<tr>
	<td></td>
	<td >
	<textarea name='selectedCols' rows=8 cols=50 > </textarea>
	</td>	
	<td colspan=2>
	<textarea name='selectedColVals' rows=8 cols=50 > </textarea>
	</td>	
	</tr> 
</table>

<div id='update' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center >

	<tr>
		<td class=label width='10%'><fmt:message key="eXH.InputAPI.Label" bundle="${xh_labels}"/> </td>
		<td>
			<SELECT name="whrcolumn_name" id="whrcolumn_name" onchange='slctWhrClause();'>
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>		
 			</SELECT>			
		</td>

		<td>
			<select class='select' name=where_cond onChange='' disabled >
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>		
				<option value='=' ><fmt:message key="eXH.=.Label" bundle="${xh_labels}"/> </option>
				<option value='<>' ><fmt:message key="eXH.<>.Label" bundle="${xh_labels}"/> </option>
				<option value='LIKE' ><fmt:message key="eXH.Like.Label" bundle="${xh_labels}"/> </option>
			</select>	
	
			<input type=text name=whr_text size=20 value='' disabled onChange='slctWhrClsVal();' >
		</td>
		<td class='BUTTON'>
			<input class='button' type="button" disabled name='addWhrCls' id='addWhrCls' value='<fmt:message key="eXH.AddWhrClause.Label" bundle="${xh_labels}"/>' onclick='addWhrClause();' >
		</td>
	</tr>

	<tr>
		<td colspan=2>
		</td>		
		<td class='fields'>
			<textarea name='whrClauseTxt' rows=5 cols=60 > </textarea>
		</td>	
		<td></td>
	</tr>

</table>
</div>	

<table cellspacing=0 cellpadding=1 width='100%' align=center>

	<tr>
		<td colspan=3> </td>
		<td class='BUTTON'>
			<input class='button' type="button"  name='Query' id='Query' value='<fmt:message key="Common.query.label" bundle="${common_labels}"/>' onclick="getQuery('<%=qryType%>');" >
		</td>
	</tr>

	<tr>
		<td></td>
		<td colspan=3>
			<textarea name='QueryResult' rows=8 cols=80 ><%=XHDBAdapter.checkNull(qryResult)%> </textarea>
		</td>	
	</tr>


	<tr>
		<td colspan=3> </td>
		<td class='BUTTON'>
			<input class='button' type="button"  name='Validate' id='Validate' value='<fmt:message key="eXH.Validate.Label" bundle="${xh_labels}"/>' onclick='validateQry();' >
		</td>
	</tr>

	<tr>
		<td class=label><fmt:message key="eXH.QueryError.Label" bundle="${xh_labels}"/> </td>
		<td>
			<textarea name='qryError' rows=4 cols=80 ><%=qryError%> </textarea>
		</td>	
		<td colspan=2 class='BUTTON'>
			<input class='button' type="button"  name='Reset' id='Reset' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick='resetQryInfo();' >
		</td>
	</tr>
</table>

	<%
	if(modulenames!=null) modulenames.clear();
	ConnectionManager.returnConnection(connection);
	
	%>

<!--
	<input type="hidden" name="tabl_name" id="tabl_name" value='<%=tbl_name%>'>
	<input type="hidden" name="mdl_name" id="mdl_name" value='<%=mdl_name%>'>
-->
	<input type="hidden" name="strBeanName" id="strBeanName" value='<%=strBeanName%>'>
	<input type="hidden" name="qryType" id="qryType"     value='<%=qryType%>'>
	<input type="hidden" name="resetflag" id="resetflag"   value='' >

<!--
	<input type="hidden" name="qryText" id="qryText" value=''>
	<input type="hidden" name="SystDefStructure" id="SystDefStructure" value=''>
	<input type="hidden" name="qryResult" id="qryResult" value='<%=qryResult%>'> 
-->

</form>

</body>
</html>

