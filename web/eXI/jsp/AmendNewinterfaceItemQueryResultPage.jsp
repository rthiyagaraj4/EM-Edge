<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,java.io.*,java.util.regex.*,java.lang.*,java.lang.String,webbeans.eCommon.ConnectionManager,eXI.XIDBAdapter,eXI.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>

<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eXI/js/AmendNewInterfaced.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<script> 
function formload()
{

}

</script> 
</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad='formload()' >
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" method="post" target='messageFrame' action='../../servlet/eXI.AmendNewinterfaceItemServlet'> 
<%
int count=0;
boolean boolToggle =  true;	 
String strTDClass = ""; 
String strBeanName = XIItemcodeElementControllerBean.strBeanName;
Connection conn = null;
ArrayList arrRow = null;
ArrayList arrCol = null;
HashMap resultsQry=null;
String strPrevious = "";  
String strNext  = "";
Statement stmt=null;
ResultSet rs=null; 
String selectQuery="";
Statement stmt1=null; 

 
String item_code=request.getParameter("item_code");
String search_criteria=request.getParameter("search_criteria"); 


try  
{
	request.setAttribute("item_code",item_code); 
    request.setAttribute("search_criteria",search_criteria);  
	conn = ConnectionManager.getConnection(request);
	XIItemcodeElementControllerBean	xhBean = XIItemcodeElementControllerBean.getBean(strBeanName,request,session);
	xhBean.action(request,conn);
	resultsQry = xhBean.getResultSet();
	arrRow = (ArrayList)resultsQry.get("qry_result");  
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = "Previous";
	strNext  = "Next";
	if (boolPrevious == true)
	{
		strPrevious ="Previous";
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  ="Next";
	}
	else
	{
		strNext  = " ";
	}

	
	%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>

<%
if(arrRow.size()==0)
{
%>
<script>
alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
</script>
<% } else { %>

	<tr>
	
	<td colspan="8" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
	</tr>

<tr> 


<td class='COLUMNHEADER' width='40%' nowrap><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='25%' nowrap><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'width='40%' nowrap ><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'width='30%' nowrap><fmt:message key="eXI.Genuom.Label" bundle="${xi_labels}"/></td> 
<td class='COLUMNHEADER' width='10%' nowrap><fmt:message key="eXI.Saleuom.Label" bundle="${xi_labels}"/></td>
<td class='COLUMNHEADER' width='10%' nowrap><fmt:message key="Common.ItemClassCode.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='10%' nowrap><fmt:message key="eXI.MaterialGroupCode.Label" bundle="${xi_labels}"/> </td>  
<td class='COLUMNHEADER' width='10%' nowrap><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='10%' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
    
</tr>
	<%
 
	stmt= conn.createStatement();
stmt1= conn.createStatement();
	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j); 
        if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}

	%>
	<tr>
	<td <%=strTDClass%> align="left" nowrap ><%=arrCol.get(0)+""%>&nbsp;</td>
	<input type=hidden id='<%="item"+j%>' name='<%=arrCol.get(0)+"code"%>' value='<%=arrCol.get(0)+""%>'> 
    <td <%=strTDClass%> align="left" nowrap ><%=arrCol.get(1)+""%>&nbsp;</td>
    <td <%=strTDClass%> align="left" nowrap ><%=arrCol.get(2)+""%>&nbsp;</td>
    <td <%=strTDClass%> align="left" nowrap>
	 <table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
	 <tr>
	 <td align="left" nowrap>
     <select name='<%=arrCol.get(0)+"_genuomcode"%>' id='<%=arrCol.get(0)+"_genuomcode"%>' id='<%="_genuomcode"+j%>' style="width:150" >
	<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	 <%
		try
		{
		selectQuery="select UOM_CODE, LONG_DESC from AM_UOM where STOCK_UOM_YN='Y' order by LONG_DESC"; 

		rs = stmt.executeQuery(selectQuery) ;
        while(rs.next())
		{
			if(XIDBAdapter.checkNull(arrCol.get(5).toString().trim()).equals(XIDBAdapter.checkNull(rs.getString(1).toString().trim())))
			{

			%>
				<option value="<%=XIDBAdapter.checkNull(rs.getString(1).toString().trim())%>" selected><%=XIDBAdapter.checkNull(rs.getString(2).toString().trim())%></option>
		   <%
			}
			else
			{
			%>
				<option value="<%=XIDBAdapter.checkNull(rs.getString(1).toString().trim())%>" ><%=XIDBAdapter.checkNull(rs.getString(2).toString().trim())%></option>
			<%
			}
		}
		}catch(Exception e)
		{
			System.out.println("exception in jsp :"+e);
		}
			%>

     </select>
	 </td>
	 <td align="left" nowrap>
	 <div id='<%="gen"+j%>' style="display:none"> <img id='<%="genimg"+j%>' src='../../eCommon/images/mandatory.gif' align=middle>
	 </div>
   <div id='<%="gendummy"+j%>' ><img id='<%="genimg"+j%>' src='../../eCommon/images/empty.gif' align=middle>
	 </div>
</td>
</tr>
</table>
	</td>
	<td <%=strTDClass%> align="left" nowrap>
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
	 <tr>
	 <td align="left" nowrap>

<select name='<%=arrCol.get(0)+"_saleuomcode"%>' id='<%=arrCol.get(0)+"_saleuomcode"%>' id='<%="_saleuomcode"+j%>' style="width:150" >
	<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	 <%
	try
		{
		selectQuery="select  UOM_CODE, LONG_DESC from AM_UOM where STOCK_UOM_YN='Y' order by LONG_DESC "; 

		rs = stmt.executeQuery(selectQuery) ;
        while(rs.next())
		{
			if(XIDBAdapter.checkNull(arrCol.get(7).toString().trim()).equals(XIDBAdapter.checkNull(rs.getString(1).toString().trim())))
			{
			%>
				<option value="<%=XIDBAdapter.checkNull(rs.getString(1).toString().trim())%>" selected><%=XIDBAdapter.checkNull(rs.getString(2).toString().trim())%></option>
		   <%
			}
			else
			{
			%>
				<option value="<%=XIDBAdapter.checkNull(rs.getString(1).toString().trim())%>" ><%=XIDBAdapter.checkNull(rs.getString(2).toString().trim())%></option>
			<%
			}
		}
		}
		catch(Exception e)
		{
		}
		finally
		{
			if(rs!=null)
			{
				rs.close();
			}
		}
			%>  

     </select> 
	 </td>
	 <td align="left" nowrap>
     <div id='<%="sale"+j%>' style="display:none"><img id='<%="saleimg"+j%>'  src='../../eCommon/images/mandatory.gif' align=middle>
	 </div>
	 <div id='<%="saledummy"+j%>' ><img id='<%="genimg"+j%>' src='../../eCommon/images/empty.gif' align=middle>
	 </div>
	 </td>
 </tr>
</table>
	</td>
 


	<td <%=strTDClass%> align="left" nowrap ><%=arrCol.get(3)+""%>&nbsp;</td> 
    <td <%=strTDClass%> align="left" nowrap ><%=arrCol.get(4)+""%>&nbsp;</td>
    <td <%=strTDClass%> align="left" nowrap ><%=arrCol.get(6)+""%>&nbsp;</td> 
	<td <%=strTDClass%> align="center" nowrap>
  <input type="checkbox" size="10" id='<%="select"+j%>' name='<%=arrCol.get(0)+"_check"%>' onClick="checkObj(this,'<%=j%>')" >
	 
	</td>
	</tr> 
    
	<%
count++;
	}
	
		
	
	%> 
<input type='hidden' name='count_field' id='count_field' value='<%=count%>' >
<%

if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

if(stmt!=null)
	{
		stmt.close();
		
	}
	if(rs!=null)
	{
		rs.close();
	}
	
}
}
	
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
		
	}
	%>
	</table>
<input type='hidden' name='action_type' id='action_type' value='R' >
<input type='hidden' name='genuomhidden' id='genuomhidden' value='' >
<input type='hidden' name='saleuomhidden' id='saleuomhidden' value='' >
</form>
</html>


