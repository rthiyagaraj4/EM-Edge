<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML> 
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
ResultSet rs1  = null;
String selected = "selected";
String defaultval = "";
String code_yn="";
String element_id="";   
String params="";
params=(String)session.getAttribute("params");
element_id=request.getParameter("element_id");
String rule=(String)session.getAttribute("Rule");
//System.out.println("rule28"+rule);

String sourcedata=request.getParameter("source");

%>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReference1.js'></script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReference.js'></script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReferencebasicelement.js'></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReferenceElementIDtab.js'></script>
<script language="JavaScript">
//function funAdd

</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>

<BODY  leftmargin=0 topmargin=0   onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="application_element_setup_form" id="application_element_setup_form">

<table cellspacing=0 cellpadding=4 width='100%' align=center >

<tr><td class=label><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td class='fields'>
<%
try
{
	con=ConnectionManager.getConnection();
	String qry = "SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW where IN_USE_YN='Y' and   LANGUAGE_ID='"+locale+"'";
	stmt = con.createStatement();
	rs = stmt.executeQuery(qry);
%>

<!-- onChange='onSelectAppliction()' -->
<select class='select' name='application_id' id='application_id'  >
            <option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
	while(rs.next())
            {
              if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
                selected = "selected";
              }
              else
              {
                selected = " ";
              }
//			  
%>
	<option value='<%=rs.getString(1)%>'  "+selected+" ><%=rs.getString(2)%></option>
            
		<% 	}%>

            </select><img src='../../eCommon/images/mandatory.gif' align=middle> </td>

 <%

rs1 = stmt.executeQuery("select MASTER_CODE_MAP_YN from  xh_param ");
while(rs1.next())
{

 code_yn=rs1.getString(1);
}

}catch(Exception e1)
{
	System.out.println("(DataElementCrossRefElementIDTab.jsp:Exception):"+e1.toString());   
}

%>


<td class=label ><fmt:message key="Common.Element.label" bundle="${common_labels}"/></td>
<td align=left><input type=text id="datainput_api"  name =element_desc size=25 value='' > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=elementIDSearch value='?'    onClick="searchElementID()"><input  type="hidden" name=Action_code value='afsa'/>
<input type="hidden" name="element_id" id="element_id" value="<%=element_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>

</tr>

<tr><td colspan=6 class='BUTTON'>
<input class='button' type="button"  name='add' id='add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick='funAdd("A")'>
<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch("U")'>
</td>
</tr>


</table>

<%		if(rs!=null)rs.close();
		if(rs1!=null)rs1.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(con);
%>
<input  type="hidden" name=code value='<%=code_yn%>'/>
<input  type="hidden" name=Rule value='<%=rule%>'/>
<input  type="hidden" name=sourcedata value='<%=sourcedata%>'/>

</form>
</BODY>
</HTML>

