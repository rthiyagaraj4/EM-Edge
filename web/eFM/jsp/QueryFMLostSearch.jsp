<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	\FM\File Lost-Archeived File status
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eFM/js/QueryFMLostSearch.js'></script>
<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <head>

 <body OnMouseDown="CodeArrest();" onLoad='document.forms[0].from.focus();' onKeyDown = 'lockKey();'>
 <form name="QuerySearch" id="QuerySearch" action="../../eFM/jsp/QueryFMLostSearchResult.jsp" method="post"    			target="messageFrame">
 <%
	Connection conn = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rset=null;
	String today ="";
	String sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
	String doc_or_file = "";
	String file_type_appl_yn = "";
	//Block to obtain mp_param value
	try {
			stmt = conn.createStatement();
			if(rset!=null)rset.close();
			rset = stmt.executeQuery("Select MAINTAIN_DOC_OR_FILE, file_type_appl_yn from MP_PARAM ");
			if(rset.next()) {
				 doc_or_file = rset.getString("MAINTAIN_DOC_OR_FILE")==null?"":rset.getString("MAINTAIN_DOC_OR_FILE");	
				 file_type_appl_yn = rset.getString("file_type_appl_yn")==null?"":rset.getString("file_type_appl_yn");	
			}
		if(stmt!=null) stmt.close();
 		if(rset!=null) rset.close();
		}
		catch(Exception e)
			{
				out.println("Exception in obtaining MP Parameter::"+e);
			}		
	//Block ends
 
 try
 {		
	stmt = conn.createStatement();
	rset = stmt.executeQuery(sql);
	if (rset.next())
	{
	today = rset.getString("today");
	}
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
 }
 	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
 <table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>
		<tr> 
		<td colspan='4'>&nbsp;</td>
		</tr>
		
		<tr>	
				<td class='label' width='25%'  maxlength="10" ><fmt:message key="eFM.ReportedDateFrom.label" bundle="${fm_labels}"/></td>
				<td	class='fields' width='25%'><input type='text' id="date_from" name='from' id='from' value=''	 size="10"	maxlength="10"	
			onBlur='validDateObj(this,"DMY","<%=localeName%>");clearResultFrame();'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');">
				</td>
				<td class='label' width='25%' maxlength="10" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td	class='fields' width='25%'><input type='text' id="date_to" name='to' id='to' value=''  size="10"	maxlength="10" 
			 onBlur='validDateObj(this,"DMY","<%=localeName%>");clearResultFrame();'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');">
				</td>	
		</tr>
		
	<!--comment
	1)---from doDateCheckFrom(to,this);CheckSystemDateLesser(this,'<%=today%>'); 
	2)---doDateCheckto(this,from);CheckSystemDateLesser(this,'<%=today%>');
	-->			
		<tr>	
		<% if(doc_or_file.equals("D")){ %>
				<td	class='label' ><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></td>
		<% } else { %>
				<td	class='label' ><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></td>
		<% } %>				
				<td class='fields' ><input type='Radio' name='criteria' id='criteria' value='L'  checked onclick="clearResultFrame();">&nbsp;<fmt:message key="Common.Lost.label" bundle="${common_labels}"/>&nbsp;<input type='Radio' name='criteria' id='criteria' 
				onclick="clearResultFrame();" value='A'>&nbsp;<fmt:message key="Common.Archived.label" bundle="${common_labels}"/></td>
				<td class='label' ></td>
				<td	class='fields'></td>	
		</tr>

		<tr>
		<td class='button'  align="right" colspan='4'><input type='button' onclick="search();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='Search' width="30"class='BUTTON'></input>&nbsp;</td>
		</tr>
    </table>
    <input type='hidden' name='today' id='today' value='<%=today%>'>	 
    <input type='hidden' name='doc_or_file' id='doc_or_file' value='<%=doc_or_file%>'>	
    <input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
  </form>
  </body>
 </html>

