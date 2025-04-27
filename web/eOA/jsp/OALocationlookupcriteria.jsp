<!DOCTYPE html>
<html>
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* ,eCommon.XSSRequestWrapper " %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	//String queryString=request.getQueryString();
	//String locale =((String)session.getAttribute("LOCALE"));
	String locn_type=request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String care_locn_ind=request.getParameter("care_locn_ind")==null?"":request.getParameter("care_locn_ind");
	String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String location_val=request.getParameter("location_val")==null?"":request.getParameter("location_val");
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String tab_Selected=request.getParameter("tab_Selected")==null?"":request.getParameter("tab_Selected");
	String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	String displayAll=request.getParameter("displayAll")==null?"N":request.getParameter("displayAll");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eOA/js/OALocationlookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='disable_code_desc();call_result_page("N");' onKeyDown = 'lockKey()'>
<form name="loc_form" id="loc_form">
<table   border="0" width='100% 'cellspacing='0' cellpadding='0'>
 <tr width="100">
 <td  class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
 <td colspan=2  class="label">
 <input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick="change_val(this)"><fmt:message key="Common.description.label"  bundle="${common_labels}"/>
 <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="change_val(this)"><fmt:message key="Common.code.label"  bundle="${common_labels}"/>
         <td>&nbsp<select name="start_ends_contains" id="start_ends_contains">
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				</select></td>
 </tr>
 <tr width='100'>
 <td colspan=1  class="label" nowrap ><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
 <td align='left'>&nbsp;<input type='text'  name='loc_id' id='loc_id' maxlength='15' value="" onkeypress=''></td>
 <td/><td/>
 </tr>
  <tr width='100'>
 <td colspan=1  class="label" nowrap ><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></td>
 <td align='left'>&nbsp;<input type='text'  name='loc_desc' id='loc_desc' maxlength='15' value="<%=location_val%>" onkeypress=''></td>
 <td/><td/>
 </tr>
 <tr width="100">
 <td/><td/><td/>
 <td ><input type="button" class='button' align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="call_result_page('Y')">&nbsp;&nbsp;
<input type="button"  align="left" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button'  onClick="clear_result_page()">
		</td>
 </tr>
 </table>
 <input type='hidden' name="locn_type" id="locn_type" value="<%=locn_type%>">
 <input type='hidden' name="search_click" id="search_click" value="N">
 <input type='hidden' name="care_locn_ind" id="care_locn_ind" value="<%=care_locn_ind%>">
 <input type='hidden' name="speciality_code" id="speciality_code" value="<%=speciality_code%>">
 <input type='hidden' name="function_id" id="function_id" value="<%=function_id%>">
 <input type='hidden' name="tab_Selected" id="tab_Selected" value="<%=tab_Selected%>">
 <input type='hidden' name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id%>">
 <input type='hidden' name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">
 <input type='hidden' name="rd_appt_yn" id="rd_appt_yn" value="<%=rd_appt_yn%>">
 <input type='hidden' name="displayAll" id="displayAll" value="<%=displayAll%>">
</form>
</body>
</html>

