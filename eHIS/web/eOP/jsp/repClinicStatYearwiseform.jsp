<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8"); 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

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
    String p_module_id      = "OP" ;
    String p_report_id      = "OPBYRCST" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;

    Connection con = null;

    Statement stmt=null;
    ResultSet rset=null ;
    String ID="";
    String dat="";
    String en="";

    try{
		con = ConnectionManager.getConnection(request);
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
    <form name="repClinicStatYearwise" id="repClinicStatYearwise" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
<table width='80%' align='center' valign='top'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table width='80%' cellPadding="2" cellSpacing="0" align='center' border='0'>
<tr>
<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields' colspan='2'><select name='p_for_facility_id' id='p_for_facility_id' >
<%
    stmt=con.createStatement();
    //rset=stmt.executeQuery("select facility_id,facility_name from  SM_FACILITY_FOR_USER_VW where appl_user_id='"+p_user_name+"' order by facility_name ");
	rset=stmt.executeQuery("SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name ");
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
	<td width='33%'>&nbsp;</td>
	<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
    <td class="label"><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
    <td class='fields'><input type=text  name='p_fm_yr' id='p_fm_yr' size="4" maxlength="4"  onBlur="validateYear(this);" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'></img>
    </td>        
    <td class='fields'><input type=text  name='p_to_yr' id='p_to_yr' size="4" maxlength="4"  onBlur="validateYear(this);" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'></img>
    </td>
</tr>
</table>
		<br>
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
        <input type="hidden" name="p_fr_year" id="p_fr_year"           value="">
        <input type="hidden" name="p_to_year" id="p_to_year"           value="">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

    </form>
<%}
        
        catch(Exception e) {out.println(e.toString());}
        finally{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
if( con !=null ) ConnectionManager.returnConnection(con,request);
}

        %>
</center>
</body>
</html>

