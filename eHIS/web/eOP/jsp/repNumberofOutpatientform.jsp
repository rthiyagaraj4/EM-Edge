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
<%
    String p_module_id      = "OP" ;
    String p_report_id       = "OPNUMPAT" ;   
	String p_facility_id      = (String) session.getValue( "facility_id" ) ;
    String p_user_name    = (String) session.getValue( "login_user" ) ;
	String p_resp_id		  = (String)session.getValue("responsibility_id");

    Connection con = null;
    Statement stmt=null;
    ResultSet rset=null ;
    String fid="";
    String fname="";    

    try{
		con = ConnectionManager.getConnection(request);
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function validateYear(obj)
{
		if(obj.value!="")
		{
			if(validDate(obj.value,'YY',localeName)==false)
			{
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}

function setDate(Object)
{ 
	var currentDate = new Date();
     if(Object.value!="")
	{
		   if (isBeforeNow(Object.value,"YY",localeName))
		  {
			  return true;
		  }
		  else
		  {
			  alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			  Object.value="";
			  Object.focus();           
		   }
    }

}

</script>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
<form name="repNumberofOutpatient" id="repNumberofOutpatient" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR>
<table width='70%' align='center' valign='top'>
<tr>
<th class='columnheader' align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</tr>
</table>
<br>
<table width='35%' cellPadding="2" cellSpacing="0" align='center' border='0'>
<tr>
<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'><select name='p_all_facility_id' id='p_all_facility_id' >
<%
    stmt=con.createStatement();    
	rset=stmt.executeQuery("SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2 ");
    if(rset!=null)
    {
       while(rset.next())
       {
            fid=rset.getString("facility_id");
			fname=rset.getString("facility_name");
			if(fid.equals("All"))
				out.println("<option value='All'  selected>"+fname+"</option>");
			else
				out.println("<option value='"+fid+ "' >"+fname+"</option>");
       }%>
      </select>
<%  }
    
%>
</td>
</tr>
<tr>
    <td class="label"><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
    <td class='fields'><input type=text id='mdsfrom' name='p_year' id='p_year' size="4" maxlength="4"  onBlur="if(validateYear(this)){setDate(this)};"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom','y', null);" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
    </td>  
 </tr>


</table>
		<br>
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">   
		<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> 
 
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

