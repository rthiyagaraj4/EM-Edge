<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eMR/js/SSOrderCatalog.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<form name='ssordercatalog_form' id='ssordercatalog_form'  action=''  method='post' target='messageFrame'>

<%
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rs				= null;

	String report_gr_id			= "";
    //String str					= "";
	String str1					= "";
	
	try
	{
	con				= ConnectionManager.getConnection(request);
	stmt			= con.createStatement();
	
%>
  <input type=hidden name="report_gr_id" id="report_gr_id" value='<%=report_gr_id%>'>
  <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
    <tr>
	   <td colspan=4>&nbsp;</td>
    </tr>
    <tr>
       <td align=right class='label' width=15%>
           Report&nbsp;&nbsp;
       </td> 
       <td align=left width=35%> <SELECT name="Report" id="Report" onchange="callReport(this);"><option>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------- </option>
 <% 
	       str1="select report_id,report_desc from sm_report where report_id in ('MRBRADEX','MRBLABWL','MRBLABRG') order by report_desc";
		   rs	= stmt.executeQuery(str1);
	 
	while(rs.next())
	 {
        report_gr_id=rs.getString("report_id");
%>
        <option value="<%=rs.getString("report_id")%>"><%=rs.getString("report_desc")%></option>
<%  }
%>
	
         </select> <img src='../../eMP/images/mandatory.gif'>
	 </td>
     <td align=right class='label'  width=15%>
         Master&nbsp;&nbsp;
     </td> 
     <td align=left width=35%> <select name="Master" id="Master"><option value="OC"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></option></SELECT> <img src='../../eMP/images/mandatory.gif'>
	 </td>
  </tr>
  <tr>
      <td colspan=4>&nbsp;</td>
  </tr>
  <tr>
     <td align=right class='label' >
          <fmt:message key="eMR.MainGroup.label" bundle="${mr_labels}"/>&nbsp;&nbsp;
    </td> 
    <td align=left > <SELECT name="Main_group" id="Main_group" onChange="subGroup(this)"> <option>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------- </option>
 
   </SELECT> <img src='../../eMP/images/mandatory.gif'></td>
   <td align=right class='label'>
     <fmt:message key="eMR.SubGroup.label" bundle="${mr_labels}"/>&nbsp;&nbsp;
   </td> 
   <td align=left > <select name="sub_group" id="sub_group" disabled  onChange="subGroup1()"><option>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------- </option></SELECT> <label class='label' id='madatory_image'></label></td>
</tr>
<tr>
	  <td colspan=4>&nbsp;</td>
</tr>
<tr>
  <td colspan=3>&nbsp;</td><td colspan=1 class='button'>&nbsp;&nbsp;&nbsp;<INPUT TYPE="button" class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' Onclick="FetchValues()"><INPUT TYPE="button" class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' Onclick="clearValues()">
  </td>
</tr>
</table>
<% 
 if(stmt!=null) stmt.close();
   if(rs!=null) rs.close();
   }
 catch(Exception e)
 {
	//out.println("Exception in File SSOrderCatalogLinkCriteria"+e.toString());
	e.printStackTrace();
 }
 finally
 {
    ConnectionManager.returnConnection(con,request);
 }
%>
  </form>
  </body>
  </html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

