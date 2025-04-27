<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>Data Source Mapping ? Configname</title>
<script language="javascript">

function getTables() 
{
//	alert("getTables");
//	alert("getTables() Modl Val : "+document.forms[0].module_name.value);
	var m_name = document.forms[0].module_name.value;	document.queryInfo.action='../../eXH/jsp/ShowElementSegmentQueryInfo.jsp?mdl_name="'+m_name+'"';
	document.queryInfo.submit();
}

function getColumns()
{
//	alert("getColumns");
//	alert("getCols() tabl Val : "+document.forms[0].table_name.value);
	var t_name = document.forms[0].table_name.value;	document.queryInfo.action='../../eXH/jsp/ShowElementSegmentQueryInfo.jsp?tabl_name="'+t_name+'"';
	document.queryInfo.submit();
}										    

var flag = 0;
var sgmnt1 = "";
var colTxt = "";
var qryText = "";
var colcount =0;

function addColumn()
{
//     alert(document.forms[0].segment_type.value);
//	 var sgmnt_type = document.forms[0].segment_type.value;
//	 sgmnt1 = "SELECT '"+sgmnt_type+"'#";
	 var slctd_Col  = document.forms[0].column_name.value;
	 var slctd_Cols = document.forms[0].selectedCols.value;
	 colTxt = colTxt+"#"+slctd_Col;
	 colcount++;
//	 alert("slctd_Cols : "+slctd_Cols);     
	 document.forms[0].selectedCols.value = slctd_Cols+","+slctd_Col;
}

function slctColumn()
{
 //	 alert(document.forms[0].column_name.value);
	 if(flag!=1){
		 var slctd_Col  = document.forms[0].column_name.value;
		 var slctd_Cols = document.forms[0].selectedCols.value;
//		 alert("slctd_Cols : "+slctd_Cols);
		 flag = 1;
	     colcount++;
		 document.forms[0].selectedCols.value = slctd_Col;
		 colTxt = slctd_Col;
	 }
	 else{
		 document.forms[0].add.disabled = false;
	 }
}

function getQuery()
{
//	alert("getQuery");
	var slctdColumns  = document.forms[0].selectedCols.value;
//	alert("slctdColumns : "+slctdColumns);
	var slctdtbl_name = document.forms[0].table_name.value;
//	alert("slctdtbl_name : "+slctdtbl_name);
	var slctdwhrcol   = document.forms[0].whrcolumn_name.value;
	var slctdwhrcond  = document.forms[0].where_cond.value;
	var slctdwhrtxt   = document.forms[0].whr_text.value;
	var whrclause	  = " \nWHERE "+slctdwhrcol+slctdwhrcond+"'"+slctdwhrtxt+"'";
	var qryResult = "SELECT "+slctdColumns+" \nFROM "+slctdtbl_name+whrclause;
	alert("getQuery qryResult :"+qryResult);
	document.forms[0].QueryResult.value = qryResult;
    var sgmnt_type = document.forms[0].segment_type.value;
	sgmnt1 = "SELECT '"+sgmnt_type+"'#";
	qryText = sgmnt1+colTxt+"\nFROM "+slctdtbl_name+whrclause;	
	alert("getQuery qryText : "+qryText);
}

function validateQry()
{  
//	return qryText;
	alert("qryText : "+qryText);
	alert("selected Col Count : "+colcount);
	var begnStr = ":PID[";
	var endStr1 = "]";
	var endStr2 = "|";
	var SystDefStructure = "";
	var sgmnt  = "";

	for(var i=1;i<=colcount;i++){
		if(i==1){
			sgmnt = begnStr+i+endStr1;
		}
		else{
			sgmnt = endStr2+begnStr+i+endStr1;
		}
		SystDefStructure = SystDefStructure+sgmnt;
	}

	var qResult =  document.forms[0].QueryResult.value;
	alert("qResult : "+qResult);
	
	alert("SystDefStructure : "+SystDefStructure);

/*
	document.forms[0].qryText.value = qryText;
	document.forms[0].SystDefStructure.value = SystDefStructure;
	document.queryInfo.submit();

	*/

	//document.queryInfo.action=
	location.href = '../../eXH/jsp/ElementSegmentValidateQry.jsp?qResult='+qResult;
		
	//document.queryInfo.submit();


//	parent.Element_Segment_Configuaration.query_text.value = qryText;
//	window.close();
}

function retVal(){
	alert("Ret Val : ");
}

//function setValues
function setValues()
{    
	alert("setValues");
	var qryResult = document.forms[0].qryResult.value;
	alert("qryResult : "+qryResult);

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<body>
<!-- onLoad="setValues();" -->

<%
String qryError=XHDBAdapter.checkNull(request.getParameter("message"));
String qryResult=XHDBAdapter.checkNull(request.getParameter("QueryResult"));

Connection connection = null;
ResultSet resultSet = null;
ResultSet resultSet1 = null;
ResultSet resultSet2 = null;
//ResultSet resultSet3 = null;
Statement statement = null;
//ResultSet rs = null;
connection = ConnectionManager.getConnection(); 
String qryModules = "select 'CR' from dual union SELECT distinct module_id FROM sm_function";
String segment_type = XHDBAdapter.checkNull(request.getParameter("segment_type"));
statement = connection.createStatement();
//resultSet = statement.executeQuery(query);
resultSet1 = statement.executeQuery(qryModules);

%>		
<form name="queryInfo" id="queryInfo" >
<table cellspacing=0 cellpadding=1 width='100%' align=center>
	<tr>
		<td class=label>Domain Name </td>
		<td colspan=3 class='fields'>
			<SELECT name="module_name" id="module_name" onChange='getTables();' >
			<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option>
			<% 
			String mdl_name = XHDBAdapter.checkNull(request.getParameter("module_name"));
			while(resultSet1.next())
			{
				String mod_name = (resultSet1.getString(1));
		//		System.out.println("Mod Name : "+mod_name);
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
		<td class=label>Entity Name </td>
		<td colspan=3 class='fields'>
			<SELECT name="table_name" id="table_name" onChange='getColumns();'>
			<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option>
			<% 
			
			String modParam = mdl_name+"%";
	//		System.out.println("Selected modParam Value "+modParam);

			if(mdl_name.equals("")){
					//System.out.println("Selected Mod_Name "+mdl_name);
				%>
	<!--				<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option> -->
			   <%
			   }
			   else{

String query = "select object_name from user_objects where object_type='Table'";
//System.out.println("modParam : "+modParam);
//String query = "select OBJECT_NAME from user_objects where object_name LIKE '"+modParam+"' and (object_type='TABLE' OR object_type='VIEW')";

//System.out.println("query : "+query);


  DatabaseMetaData dbmd = connection.getMetaData();
  //    resultSet2 = dbmd.getTables(null, null,"XH%", new String[]{"TABLE"});
  resultSet2 = dbmd.getTables(null, null,modParam, new String[]{"TABLE"});

  statement = connection.createStatement();
  resultSet = statement.executeQuery(query);
 
 // resultSet3 = statement.executeQuery(queryCols);

			while(resultSet2.next())
			{
				String tbl_name = (resultSet2.getObject(3)).toString();
		//		String tbl_name = resultSet2.getString(1);
		//		System.out.println("qry rslt tbl_name : "+tbl_name);
				String selected = (String)(request.getParameter("table_name"));
				out.println("SELECTED "+selected);
				if(selected != null && selected.equalsIgnoreCase(tbl_name))
					selected = "selected";
				else
					selected = "";
			%>
			<option value="<%=tbl_name%>" <%= selected %> > <%=tbl_name%> </option>
			<%}
			   }%>
			</SELECT>
		</td>
	</tr>

	<tr>
		<td class=label>Field  </td>
		<td class='fields'>
			<SELECT name="column_name" id="column_name" onchange='slctColumn();'>
				<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option>
	<!-- 		<option value=''>ROWNUM</option> -->
			<% 
			String tabl_name = XHDBAdapter.checkNull(request.getParameter("table_name"));
	//			List columnNames = null;
	//		    System.out.println("Selected Table_Name "+tabl_name);
			   if(tabl_name.equals("")){
	//				System.out.println("Selected Table_Name "+tabl_name);
				%>
	<!--				<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option> -->
			   <%
			   }
			   else{
			   String queryCols="SELECT * from "+tabl_name;
			
			   resultSet=statement.executeQuery(queryCols);

			   ResultSetMetaData rsmd = resultSet.getMetaData();
	           int col = rsmd.getColumnCount();
	
		    for (int i=1; i <= col; i++){
			  String col_name = rsmd.getColumnName(i);
			
			%>
				<option value="<%=col_name%>" > <%=col_name%> </option>
			<%}
			
			   }
		
			%>
			</SELECT>

		</td>

	<td colspan=2 class='BUTTON'>
		<input class='button' type="button" disabled name='add' id='add' value='Add Field' onclick='addColumn();' >
	</td>

	</tr>

	<tr>
	<td></td>
	<td colspan=3>
	<textarea name='selectedCols' rows=5 cols=60 > </textarea>
	</td>	
	</tr>

	<tr>
		<td class=label>Input </td>
		<td class='fields'>
			<SELECT name="whrcolumn_name" id="whrcolumn_name" onchange=''>
				<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option>
			<% 
				String tabl_name2 = XHDBAdapter.checkNull(request.getParameter("table_name"));
			   if(tabl_name2.equals("")){
			
			   }
			   else{
			   String queryCols="SELECT * from "+tabl_name;
			
			   resultSet=statement.executeQuery(queryCols);

			   ResultSetMetaData rsmd = resultSet.getMetaData();
	           int col = rsmd.getColumnCount();
	
		    for (int i=1; i <= col; i++){
			  String col_name = rsmd.getColumnName(i);
	
			%>
				<option value="<%=col_name%>" > <%=col_name%> </option>
			<%}
			
			   }
		
			%>
			</SELECT>

		</td>

<td class='fields'>
<select class='select' name=where_cond onChange='' >
	<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option>
	<option value='=' >Equal To</option>
	<option value='<>' >Not Equal To</option>
	<option value='LIKE' >Like</option>
	<option value='BETWEEN' >Between</option>
</select>	
</td>

<td class='fields'>
<input type=text name=whr_text size=20 value='' >
</td>

	</tr>

	<tr>
	<td colspan=3> </td>
	<td class='BUTTON'>
		<input class='button' type="button"  name='Query' id='Query' value='Query' onclick='getQuery();' >
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
		<input class='button' type="button"  name='Validate' id='Validate' value='Validate' onclick='validateQry();' >
	</td>
	</tr>

	<tr>
	<td class=label>Query Error </td>
	<td colspan=3>
	<textarea name='qryError' rows=4 cols=80 ><%=qryError%> </textarea>
	</td>	
	</tr>

	<%

	ConnectionManager.returnConnection(connection);
	if(statement != null) statement.close();
	if(resultSet1 != null) resultSet1.close();
	response.getWriter().write("Test Success");
	
	%>

	<input type="hidden" name="tabl_name" id="tabl_name" value='<%=tabl_name%>'>
	<input type="hidden" name="mdl_name" id="mdl_name" value='<%=mdl_name%>'>
	<input type="hidden" name="segment_type" id="segment_type" value='<%=segment_type%>'>
	<input type="hidden" name="qryText" id="qryText" value=''>
	<input type="hidden" name="SystDefStructure" id="SystDefStructure" value=''>
	<input type="hidden" name="qryResult" id="qryResult" value='<%=qryResult%>'>

</form>

</body>
</html>

