<!DOCTYPE html>
<%--
Filename		: repPractSeenTime.jsp
Modified On		: 1-3-2005
Version			: 3
--%>
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale=(String)session.getAttribute("LOCALE");
%>
<html>
<HEAD>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eOP/js/repPractSeenTime.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<SCRIPT>
	async function searchCode(obj,target,Ar_installed)
	{
			var retVal = 	new String();
			var locale="<%=locale%>";
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			if(obj.name=="fromlocn")
			{
				tit=encodeURIComponent(getLabel("Common.Location.label","Common"));
				//sql="select clinic_code, short_desc from op_clinic";
				sql="select clinic_code, long_desc from op_clinic_lang_vw where language_id=`"+locale+"`";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			if(obj.name=="pract")
			{
				tit=encodeURIComponent(getLabel("Common.practitionername.label","Common"));
				//sql="select Practitioner_id, Practitioner_name from am_Practitioner";
				sql="select Practitioner_id, Practitioner_name from am_Practitioner_lang_vw where language_id=`"+locale+"`"; 
				search_code="Practitioner_id";
				search_desc= "Practitioner_name";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=retVal;
	}
function validno()
{
	if((event.keyCode>=48)&& (event.keyCode<=57))
		return true;
	else
		return false
}
function applyclick(e)
{
  if(e.keyCode ==13)
		return false;

}
</script>
</HEAD>
<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();' onKeypress='return(applyclick(event));'>
<form name="practseentime" id="practseentime"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  = null;
    Statement stmt = null;
	ResultSet rset =null;
    String sql = "" ;
    StringBuffer StrVal =new StringBuffer();
	try
    {
		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement(); 
	//sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" ;
	sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+locale+"' order by 2" ;
    rset = stmt.executeQuery(sql);
	
	StrVal.setLength(0);
    
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
		if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
	 }
	 catch(Exception e){out.println(e);}
	 finally
	 {
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

%>
<BR><BR><BR><BR><BR><BR>
<CENTER><table cellpadding='2' border = '0' cellspacing='0' width='80%'>

		<tr>
                <td width='33%'>&nbsp;</td>
				<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>  
		</tr>		
		<tr>
	<td class="label"><fmt:message key="eOP.StatisticsDate.label" bundle="${op_labels}"/></td>
	<td class='fields'><input type=text  id='mdsfrom' name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom');" style="cursor='hand'"></img>
	<img src='../../eCommon/images/mandatory.gif'></img></td>	
	<td class='fields'><input type=text id='mdsto'  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" ><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" ><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name="fm_pract_type" id="fm_pract_type">
		<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
		<%=StrVal.toString()%>
		</select>
	</td>	
	<td class='fields'><select name="to_pract_type" id="to_pract_type">
		<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
		<%=StrVal.toString()%>
		</select>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
	
	<td class='fields'><input type="text" name="p_fm_pract_id" id="p_fm_pract_id" size="15" maxlength="15" ><input type='button' name='pract' id='pract' value='?' class='button' onclick='searchCode(this, p_fm_pract_id)'>
	</td>	
	<td class='fields'><input type="text" name="p_to_pract_id" id="p_to_pract_id" size="15" maxlength="15" ><input type='button' name='pract' id='pract' value='?' class='button' onclick='searchCode(this, p_to_pract_id)'>
	</td>
</tr>
<tr>	
	<td class="label"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='2'><INPUT TYPE="text" name="p_duration" id="p_duration" value="" size='4' maxlength='3' onkeypress='return validno();'>&nbsp;<fmt:message key="Common.Minute.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>	
</tr>
</table>
</CENTER>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		    value="<%=p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"		    value="<%=p_resp_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="OP">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="OPBNOPPR"> 

<input type="hidden" name="p_clinic_from" id="p_clinic_from"		value="">
<input type="hidden" name="p_clinic_to" id="p_clinic_to" 		value="">

<input type="hidden" name="p_pract_id_from" id="p_pract_id_from"		value="">
<input type="hidden" name="p_pract_id_to" id="p_pract_id_to" 		value="">

<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

<%
StrVal.setLength(0);
%>

</form>
</body>
</html>

