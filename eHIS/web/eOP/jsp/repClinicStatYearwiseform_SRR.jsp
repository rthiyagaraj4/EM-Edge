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
function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	//var facilityid = "<%=p_facility_id%>";
	var facilityid = document.forms[0].p_for_facility_id.value;
	var tit="";	
	var locale = "<%= localeName %>";
		
	target.value=trimString(target.value);

	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	if(obj.name=="tolocn" || obj.name=="fromlocn")
    {
        tit=getLabel("Common.Location.label","Common");

		//SQL

        //argumentArray[0]="select clinic_code code, short_desc description from op_clinic where facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

                
    }	
	else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
    {
				
                tit=getLabel("Common.speciality.label","Common");

				//SQL

                //argumentArray[0]="select speciality_code code, short_desc description from am_speciality where '1' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

      }	
	
	var retVal=CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];
		            
}
function setDate(Object)    { 

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
    <form name="repClinicStatYearwise" id="repClinicStatYearwise" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
<table width='80%' align='center' valign='top'>
<tr>
<td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
</tr>
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
    <td class='fields'><input type=text id='mdsfrom' name='p_fm_yr' id='p_fm_yr' size="4" maxlength="4"  onBlur="if(validateYear(this)){setDate(this)};"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom','y', null);" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
    </td>        
    <td class='fields'><input type=text id='mdsto' name='p_to_yr' id='p_to_yr' size="4" maxlength="4"  onBlur="if(validateYear(this)){setDate(this)};"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto','y', null);" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
    </td>
</tr>

<tr class='fields'>
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_specialty_from" id="p_specialty_from" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_specialty_from)'>
	</td>
	<td class='fields'><input type="text" name="p_specialty_to" id="p_specialty_to" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_specialty_to)'>
	</td>
</tr>
 <tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_loc_from" id="p_loc_from" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_loc_from)'>
	</td>
	<td class='fields'><input type="text" name="p_loc_to" id="p_loc_to" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_loc_to)'>
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

