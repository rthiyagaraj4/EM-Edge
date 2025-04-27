<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>

<html>

<%
	//unused variable, commented on 09/06/05
	//String search_text="";
	request.setCharacterEncoding("UTF-8");
	String column_names = "";
	String column_descriptions = request.getParameter("column_descriptions");
	String column_sizes = request.getParameter("column_sizes");
	String column_types = "";
	String search_by_index = "";
	String target = "";
	target = request.getParameter("target");
	if(target == null) target = "";
	String srch_by_index = request.getParameter("srch_by_clmn_index");
	if(srch_by_index == null) srch_by_index="1";
	int srch_by_clmn_index = Integer.parseInt(srch_by_index);

	String col_show_hide = request.getParameter("col_show_hide");
	if(col_show_hide == null) col_show_hide="";

	ArrayList col_show_hide_lst = new ArrayList();

	
	
	String sql = request.getParameter( "sql");
	String facilityid = request.getParameter( "facilityid");
	String ref_type = request.getParameter( "ref_type");
	String hcareType = request.getParameter( "hcareType");
	String locale = request.getParameter( "locale");

	if(sql !=null){
		sql = java.net.URLDecoder.decode(sql,"UTF-8");
		}
	String strColumnDelimiter = ",";
	String message = request.getParameter("message");
	message = (message == null) ? " ":message;

//	String billing_mode = request.getParameter("billing_mode");
//	String operation = request.getParameter("operation");
%>
<head>
<title> <%= request.getParameter("title")%></title>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<script>

	
function CallDescFrame(){
	var search_by_index = document.forms[0].search_by.value;
	var size = search_by_index.length;

	search_by_index = search_by_index.substring(size-1,size);

	document.forms[0].search_by_index.value = search_by_index;

	document.forms[0].submit();
 }

function valtext(comp) {
	 var txt=comp.value
	CallDescFrame(this);
}
function clear_txt(comp){
    comp.value="";
	parent.frames[1].location.href="../../eCommon/html/blank.html"

	
			
}
function target_click(){
document.getElementById("Search").click();
}
	
</script>
<!-- <body onLoad = "document.getElementById('search_text').focus();<!-- target_click();  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->

<body onLoad = "document.getElementById('search_text').focus();target_click();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form id='frm_search_criteria' name='frm_search_criteria' action='ReferralSourceLookupResult.jsp' method='post' target='code_desc'>

<%
Connection conn = null;
try
	{
		conn = ConnectionManager.getConnection(request);
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		if(ref_type.equals("L")){
			prepareStatement.setString(1,facilityid);
			prepareStatement.setString(2,locale);
			prepareStatement.setString(3,locale);
			prepareStatement.setString(4,facilityid);
		}else if (ref_type.equals("X")){
			prepareStatement.setString(1,hcareType);
			prepareStatement.setString(2,locale);
			prepareStatement.setString(3,locale);
		}else if (ref_type.equals("E")){
			prepareStatement.setString(1,facilityid);
			prepareStatement.setString(2,hcareType);
			prepareStatement.setString(3,locale);
			prepareStatement.setString(4,locale);
		}
		prepareStatement.execute();

		ResultSetMetaData rmeta = prepareStatement.getMetaData();
		int intCount = rmeta.getColumnCount() ;
		String strTempColumnTypeName = "";

		for (int i=1;i<=intCount ;i++ ){
			column_names =  column_names + rmeta.getColumnName(i) + strColumnDelimiter;
			strTempColumnTypeName = rmeta.getColumnTypeName(i);
			if (strTempColumnTypeName.equalsIgnoreCase("VARCHAR2") || strTempColumnTypeName.equalsIgnoreCase("VARCHAR") || strTempColumnTypeName.equalsIgnoreCase("CHAR"))
			{
				strTempColumnTypeName = "VARCHAR2";
			}
			column_types = column_types + strTempColumnTypeName + strColumnDelimiter;
		}
		prepareStatement.close();

		if( col_show_hide.length() != intCount && col_show_hide.length() < intCount){
			int diff = intCount - col_show_hide.length();

			for(int i=0;i<diff;i++){
				col_show_hide=col_show_hide+"N";
			}
		}

		for(int i=0;i<intCount;i++){
			String temp_str = col_show_hide.substring(i,i+1);
			if(temp_str == null) temp_str="N";
			col_show_hide_lst.add(i,temp_str);
		}
		%>

		<table align='center'  border="0" width=100% cellspacing='0' cellpadding='3'>
		<tr >

			<td width="25%"  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/> </td>
			<td width="25%" class="fields">
			<%
			//out.println("column_names" + column_names);
			//out.println("column_descriptions" + column_descriptions);
			//out.println("strColumnDelimiter" + strColumnDelimiter);
			%>
			<select name="search_by" id="search_by"> 
			<%
			int rec_cnt = 0;
			String strTempSelected = "SELECTED";
			StringTokenizer strColumnTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
			StringTokenizer strColumnDescriptionsTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);

			while(strColumnTokenizer.hasMoreElements()){
				rec_cnt++;

				if(rec_cnt == srch_by_clmn_index){
					strTempSelected = "SELECTED";
				}else{
					strTempSelected = " ";
				}
			
				if((col_show_hide_lst.get(rec_cnt-1)).equals("Y")){
					out.println("<option value='"+(rec_cnt-1)+"'  "+ strTempSelected+"  >"+strColumnDescriptionsTokenizer.nextElement()+"</option>");
					strColumnTokenizer.nextElement();
				}else{
					strColumnTokenizer.nextElement();
					strColumnDescriptionsTokenizer.nextElement();
				}
			}
		%>
		</select>
		<b class='label'><%=message%></b>
		</td>
		<td width="25%" class="label"></td>
		<td width="25%" class="label"></td>
	</tr>
	<tr>

		<td class='label' width="25%" ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%"><input type="text" onBlur='makeValidString(this);'  name="search_text" id="search_text"    size='40' maxlength='100' value="<%=target%>" > </td>
		<td class="fields" width="25%"><select name="search_criteria" id="search_criteria">
		<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
		<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
		</select></td>
		
		<td class="button" width="25%"><input type="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(search_text); " class='button' >
		</td>
		<td class="button" width="25%"><input type="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  onClick="clear_txt(search_text);" class='button' >
		</td>
		
	 </tr>

	 <tr>
		<td width="25%" colspan="4">&nbsp;</td>
	 </tr>
	
</table>



		<%

}catch(Exception ex){
		//commented and added below line in Bangalore on 13/10/2005
		out.println(ex.toString());
		ex.printStackTrace();
		//ConnectionManager.returnConnection(conn, request);
}finally {  // Added on Bangalore on 13/10/2005
	if (conn != null)
	{
		ConnectionManager.returnConnection(conn,request);	
	}
}
%>
<input type='hidden' name='column_names' id='column_names' value="<%=column_names%>">
<input type='hidden' name='column_descriptions' id='column_descriptions' value="<%=column_descriptions%>">
<input type='hidden' name='column_sizes' id='column_sizes' value="<%=column_sizes%>">
<input type='hidden' name='column_types' id='column_types' value="<%=column_types%>">
<input type='hidden' name='search_by_index' id='search_by_index' value="<%=search_by_index%>">
<input type='hidden' name='sql' id='sql' value="<%=sql%>">
<input type='hidden' name='target' id='target' value="<%=target%>">
<input type='hidden' name='col_show_hide' id='col_show_hide' value="<%=col_show_hide%>">
<input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
<input type='hidden' name='ref_type' id='ref_type' value="<%=ref_type%>">
<input type='hidden' name='hcareType' id='hcareType' value="<%=hcareType%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>



