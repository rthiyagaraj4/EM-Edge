<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>

<script language="javascript">

var flag = 0;
var sgmnt1 = "";
var colTxt = "";
var qryText = "";
var colcount =0;
var whrFlag = 0;


function addField()
{
     var sgmnt_type = document.forms[0].config_type.value;
 	 sgmnt1 = "SELECT '"+sgmnt_type+"'#";

	 var index		= document.forms[0].column_name.options.selectedIndex;
	 var slctd_Col	= document.forms[0].column_name.options[index].text;

	 var slctd_Cols = document.forms[0].selectedCols.value;
	 colTxt = colTxt+"#"+slctd_Col;
	 colcount++;
	 document.forms[0].selectedCols.value = slctd_Cols+","+slctd_Col;
}

function slctColumn()
{
	 if(this.document.forms[0].resetflag.value=='0'){
		 flag = 0;
	 }
	 if(flag!=1){
 		 var index		= document.forms[0].column_name.options.selectedIndex;
 		 var slctd_Col	= document.forms[0].column_name.options[index].text;

		 var slctd_Cols = document.forms[0].selectedCols.value;
		 flag = 1;
		 document.forms[0].resetflag.value="";
	     colcount++;
		 document.forms[0].selectedCols.value = slctd_Col;
		 colTxt = slctd_Col;
	 }
	 else{
		 document.forms[0].add.disabled = false;
	 }
}

function enblWhrCondTxtFlds(){
 		 document.forms[0].whr_text.disabled	  = false;
  		 document.forms[0].where_cond.disabled	  = false;

  		 document.forms[0].whr_text.value="";
// 		 document.forms[0].whr_text.disabled	  = false;
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
<script language='javascript' src='../../eXH/js/ElementSegmentConfiguaration.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eXH.DataSourceMapping.Label" bundle="${xh_labels}"/> - <fmt:message key="eXH.ConfigName.Label" bundle="${xh_labels}"/></title>

</head>
<body>
<%
String qryError = "";
String qryResult= "";

String mod_name = "";

Connection connection = null;
connection = ConnectionManager.getConnection(); 

String config_type = XHDBAdapter.checkNull(request.getParameter("config_type"));
	//System.out.println("ElementSegmentQueryInfoN segment_type : "+config_type);
String config_id = XHDBAdapter.checkNull(request.getParameter("config_id"));
	//System.out.println("ElementSegmentQueryInfoN config_id : "+config_id);
String strBeanName    = ElementSegmentConfBean.strBeanName;
//System.out.println("ElementSegmentQueryInfoN strBeanName : "+strBeanName);

ArrayList modulenames = null;

ElementSegmentConfBean	xhBean = (ElementSegmentConfBean)ElementSegmentConfBean.getBean(strBeanName,request,session);
//System.out.println("ElementSegmentQueryInfo : "+xhBean);
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
	
			modulenames = (ArrayList)xhBean.getModules();
			for (int j=0; j<modulenames.size();j++){
				mod_name = (String)modulenames.get(j);
//				System.out.println("Mod Name : "+mod_name);
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
		<td class=label><fmt:message key="eXH.Entity.Label" bundle="${xh_labels}"/></td>
		<td colspan=3 class='fields'>
			<SELECT name="table_name" id="table_name" onChange='setValues(this);' >
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
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

	<td colspan=2 class='BUTTON'>
		<input class='button' type="button" disabled name='add' id='add' value='<fmt:message key="eXH.AddField.Label" bundle="${xh_labels}"/>' onclick='addField();' > 
	</td>

	</tr>

	<tr>
	<td></td>
	<td colspan=3>
	<textarea name='selectedCols' rows=5 cols=60 > </textarea>
	</td>	
	</tr>

	<tr>
		<td class=label><fmt:message key="eXH.Input.Label" bundle="${xh_labels}"/></td>
		<td class='fields' colspan=2>
			<SELECT name="whrcolumn_name" id="whrcolumn_name" onchange='enblWhrCondTxtFlds();'>
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			</SELECT>

			<select class='select' name=where_cond onChange='' disabled >
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
				<option value='=' ><fmt:message key="eXH.=.Label" bundle="${xh_labels}"/></option>
				<option value='<>' ><fmt:message key="eXH.<>.Label" bundle="${xh_labels}"/></option>
				<option value='LIKE' ><fmt:message key="eXH.Like.Label" bundle="${xh_labels}"/></option>
			</select>	

			<input type=text name=whr_text size=20 value='' disabled onChange='slctWhrClsVal();'  >
		</td>
		
		<td class='BUTTON'>
			<input class='button' type="button" disabled name='addWhrCls' id='addWhrCls' value='<fmt:message key="eXH.AddWhrClause.Label" bundle="${xh_labels}"/>' onclick='addWhrClause();' >
		</td>
	</tr> 

	<tr>
		<td> </td>		
		<td colspan=3 class='fields'>
			<textarea name='whrClauseTxt' rows=5 cols=60 > </textarea>
		</td>	
	</tr>

	<tr>
	<td colspan=3> </td>
	<td class='BUTTON'>
	<input class='button' type="button"  name='Query' id='Query' value='<fmt:message key="Common.query.label" bundle="${common_labels}"/>' onclick='getQuery();' >
	</td>
	</tr>

	<tr>
	<td></td>
	<td colspan=3>
	<textarea name='QueryResult' rows=8 cols=80 ><%=qryResult%> </textarea>
	</td>	
	</tr>


	<tr>
	<td colspan=3> </td>
	<td class='BUTTON'>
		<input class='button' type="button"  name='Validate' id='Validate' value='<fmt:message key="eXH.Validate.Label" bundle="${xh_labels}"/>' onclick='validateQry();' >
	</td>
	</tr>

	<tr>
		<td class=label><fmt:message key="eXH.QueryError.Label" bundle="${xh_labels}"/></td>
		<td>
			<textarea name='qryError' rows=4 cols=80 ><%=qryError%> </textarea>
		</td>	
		<td colspan=2 class='BUTTON'>
			<input class='button' type="button"  name='Reset' id='Reset' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick='resetQryInfo();' > 
		</td>
	</tr>
</table>

	<%

	ConnectionManager.returnConnection(connection);
	
	%>

	<input type="hidden" name="config_type" id="config_type" value='<%=config_type%>'>
	<input type="hidden" name="config_id" id="config_id"   value='<%=config_id%>'>
	<input type="hidden" name="strBeanName" id="strBeanName" value='<%=strBeanName%>'>
	<input type="hidden" name="resetflag" id="resetflag"   value=''>

</form>

</body>
</html>

