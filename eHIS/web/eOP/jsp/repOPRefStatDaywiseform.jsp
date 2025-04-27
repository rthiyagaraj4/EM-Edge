<!DOCTYPE html>

<%--
Filename		: repOPRefStatDaywiseform.jsp
Modified On		: 2-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8"); 
    Statement stmt=null;
    ResultSet rset=null ;
    Connection con = null; 

    String p_module_id      = "OP" ;
    String p_report_id      = "OPBDYRFC" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
    String ID="";
    String dat="";
    String en="";
    try{
		con = ConnectionManager.getConnection(request); 
%>
<html>
<HEAD>
<TITLE></TITLE>

<script>
function chmonth(obj)
{
    if(obj.value != "")
	{
		if(validDate(obj.value,'MM',localeName)==false)
		{
			var msg=getMessage("INVALID_MONTH_FMT","SM");
			alert(msg);
			//obj.select();
            obj.value="";
            return false;
		}
          return true;		
	}
}

function validateYear(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'YY',localeName)==false)
				{
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
				//obj.select();
                obj.value="";	
				return false;
			}
			else
				return true;
		}
}
</script>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eOP/js/repResetRunlist.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="repOPRefStatDaywiseform" id="repOPRefStatDaywiseform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
	<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
       
<table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>
      			<tr>
					<td class="label" colspan='2'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
                    <td class='fields' colspan='2'><select name='p_for_facility_id' id='p_for_facility_id' >
                    <%
                    stmt=con.createStatement();
                    //rset=stmt.executeQuery("SELECT FACILITY_NAME,FACILITY_ID from sm_facility_for_user_vw WHERE APPL_USER_ID='"+p_user_name+"' order by FACILITY_NAME ");

					rset=stmt.executeQuery("SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name");

                    if(rset!=null)
                    {
                    while(rset.next())
                    {
                    dat=rset.getString("FACILITY_NAME");
                    ID=rset.getString("FACILITY_ID");

                    out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
                    }%>
                    </select>
                    <%  }

                    %>
                    </td>
                </tr>               
                <tr>
                    <td class="label" colspan='2'><fmt:message key="eOP.ForMonthYear.label" bundle="${op_labels}"/>                  </td>
                    <td class='fields' colspan='2'><input type="text" name="p_p_month" id="p_p_month" size="2" maxlength="2" onBlur="chmonth(this)" onKeyPress='return(ChkNumberInput(this,event,0))'>
                        / <input type="text" name="p_p_year" id="p_p_year" size="4" maxlength="4" onBlur="validateYear(this)" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eMP/images/mandatory.gif' align='center'></img>
                    </td>                   
                </tr>                
            </table>        
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
<input type="hidden" name="p_month" id="p_month"             value="">

<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

</form>

<%}
catch(Exception e) {out.println(e.toString());}
finally{
	try
	{
	if(stmt != null) stmt.close();
	if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
if(con!=null)
    ConnectionManager.returnConnection(con,request);
}  %>
</BODY>
</HTML>

