<!DOCTYPE html>
<!--/**** Master for entering the Level Of Care ******/-->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eAM/js/LevelofCare.js' language='javascript'></script>

<script>

function changeStatus()
{
    if (LevelOfCare_form.eff_status.checked == true)
        LevelOfCare_form.eff_status.value = "E" ;
    else
        LevelOfCare_form.eff_status.value = "D" ;
}

</script>

</head>

<body onLoad = 'FocusFirstElement();' onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String Mode = request.getParameter("Mod");
if(Mode == null) Mode = "";
	 
	 Connection conn = null ;
     //Statement  stmt = null ;
	 PreparedStatement pstmt = null;
     ResultSet  rs = null ;
     
     //String facilityId = (String)session.getValue("facility_id") ;
    
     String level_of_care_code = "" ;
     String level_of_care_desc = "" ;
     String level_of_care_indicator = "" ;
     String eff_status = "" ;
     String codeTextAttribute = "" ;
     String otherTextAttribute = "" ;
     String checkBoxAttribute = "" ;
     String eventFunctionForCase = "" ;
     String sql = "" ;
     
     boolean newSpeciality = false ;

     try
     {
         level_of_care_code = request.getParameter("level_of_care_code");
	
		 conn = ConnectionManager.getConnection(request);
        //stmt = conn.createStatement();
         if(level_of_care_code == null)
         {
            level_of_care_code = "" ;
            level_of_care_desc = "" ;
            level_of_care_indicator = "" ;
            eff_status = "E" ;
            codeTextAttribute= "";
            otherTextAttribute= "";
            checkBoxAttribute= "CHECKED";
            newSpeciality = true ;
            eventFunctionForCase = "OnBlur='ChangeUpperCase(this)'" ;
         }
         else
         {
            try
            {
                sql =  "Select level_of_care_desc, level_of_care_indicator, eff_status From AM_LEVEL_OF_CARE Where level_of_care_code =?" ;
        
                //rs = stmt.executeQuery(sql);
				
				
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	level_of_care_code		);

				rs		 = pstmt.executeQuery();

                if (rs.next())
                {
                    level_of_care_desc = rs.getString("level_of_care_desc") ;
                    level_of_care_indicator = rs.getString("level_of_care_indicator") ;
					if(level_of_care_indicator == null) level_of_care_indicator = "";
                    eff_status = rs.getString("eff_status") ;
                }
                if(eff_status.equals("D"))
                {
                    otherTextAttribute = "READONLY" ;
                    checkBoxAttribute = "" ;
                }
                else
                {
                    otherTextAttribute = "" ;
                    checkBoxAttribute = "CHECKED" ;
                }
            }catch(Exception e){e.printStackTrace();}

            codeTextAttribute="READONLY" ;
            newSpeciality = false ;
            eventFunctionForCase = "" ;
         }
      }catch(Exception e) {e.printStackTrace();}
       finally
       {
           if(rs != null)   rs.close();           
		   if(pstmt != null) pstmt.close();
           ConnectionManager.returnConnection(conn,request);
       }
%>

<form name='LevelOfCare_form' id='LevelOfCare_form' action='../../servlet/eAM.LevelofCareServlet' method='post' target='messageFrame'>
<div>
<br><br><br><br><br><br><br><br><br><br>
<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
<tr>
        <td class='label' width='20%'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
        <td  class='label'width='20%'>&nbsp;</td>
</tr>
<tr>
        <td class='label'>&nbsp;</td>
        <td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='text' name='level_of_care_code' id='level_of_care_code' value="<%=level_of_care_code%>" size='10' maxlength='10' <%=codeTextAttribute%> <%=eventFunctionForCase%> onKeyPress="return CheckForSpecChars(event)">
        <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
        <td class='label'>&nbsp;</td>
</tr>
<tr>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
</tr>
<tr>
        <td class='label'>&nbsp;</td>
        <td    class=label><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='text' name='level_of_care_desc' id='level_of_care_desc' size='30' maxlength='30' value="<%=level_of_care_desc%>" <%=otherTextAttribute%> onblur="return makeValidString(this);" >
        <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
        <td class='label'>&nbsp;</td>
</tr>
<tr>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
</tr>

<%
if(!Mode.equals("Modify"))
{
%>
<tr>
	<td class='label'>&nbsp;</td>
	<td  class=label><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<select name="level_of_care_indicator" id="level_of_care_indicator">
		<option value="A"><fmt:message key="Common.Ambulatory.label" bundle="${common_labels}"/></option>
		<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
		<option value="I"><fmt:message key="Common.Isolation.label" bundle="${common_labels}"/></option>
		<option value="N"><fmt:message key="eAM.IntensiveCare.label" bundle="${am_labels}"/></option>
		<option value="C"><fmt:message key="eAM.CriticalCare.label" bundle="${am_labels}"/></option>
		<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
		<option value="S"><fmt:message key="Common.Surgery.label" bundle="${common_labels}"/></option>
	</select>
	<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	<td class='label'>&nbsp;</td>
	</tr>
<%	}
	else
	{
%>
	<tr>
	<td class='label'>&nbsp;</td>
	<td  class=label><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<select name="level_of_care_indicator" id="level_of_care_indicator">
		<option value="A"><fmt:message key="Common.Ambulatory.label" bundle="${common_labels}"/></option>
		<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
		<option value="I"><fmt:message key="Common.Isolation.label" bundle="${common_labels}"/></option>
		<option value="N"><fmt:message key="eAM.IntensiveCare.label" bundle="${am_labels}"/></option>
		<option value="C"><fmt:message key="eAM.CriticalCare.label" bundle="${am_labels}"/></option>
		<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
		<option value="S"><fmt:message key="Common.Surgery.label" bundle="${common_labels}"/></option> 
	</select>
	<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	<td class='label'>&nbsp;</td>
	</tr>
   <input type='hidden' name='hddLOC' id='hddLOC' value="<%=level_of_care_indicator%>">
		<input type="hidden" name="status" id="status" value="<%=eff_status%>" >
<%}%>
<tr>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
</tr>
<tr>
        <td class='label'>&nbsp;</td>
        <td   class='label'> <fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
        <td  align='left' class='fields'> <input type='checkbox' name='eff_status' id='eff_status' value="<%=eff_status%>" <%=checkBoxAttribute%> onClick="changeStatus()"></td>
        <td class='label'>&nbsp;</td>
</tr>
<tr>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
        <td class='label'>&nbsp;</td>
</tr>
</table>
</div>

<%
    if(newSpeciality)
    {
%>
        <input type='hidden' name='function' id='function' value='insert'>
        <input type='hidden' name='function_name' id='function_name' value='insert'>
<%  }
    else
    {
%>
        <input type='hidden' name='function' id='function' value='modify'>
        <input type='hidden' name='function_name' id='function_name' value='modify'>
<%
    }
%>
</form>

<% 
if(!level_of_care_indicator.equals(""))
{
%>
<script>
document.LevelOfCare_form.level_of_care_indicator.value = "<%=level_of_care_indicator%>" ;
</script>
<%	}

if(eff_status.equals("D"))
{ %>
<script>
document.LevelOfCare_form.level_of_care_indicator.disabled = true ;
</script>
<%	}	%>

</body>
</html>

