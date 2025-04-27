<!DOCTYPE html>
<html>
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* " %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locn_type="";
	//String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	//String addtl_splty="";
%>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>	
	function call_result_page(){
		var search_by="";
		var addtl_splty=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value;
		for (var i=0; i < 2; i++){
			if (parent.criteria_frame.addtl_splty_criteria_form.search_by[i].checked){
				search_by = parent.criteria_frame.addtl_splty_criteria_form.search_by[i].value;
			}
		}
		var start_ends_contains=parent.criteria_frame.addtl_splty_criteria_form.start_ends_contains.value;
		var search_text=parent.criteria_frame.addtl_splty_criteria_form.search_text.value;
		var url="../../eOA/jsp/OAAdditionalSpecialtyResult.jsp?search_by="+search_by+"&start_ends_contains="+start_ends_contains+"&search_text="+search_text+"&addtl_splty="+addtl_splty;
		parent.result_frame.location.href=url;
	}
	function reSet(){
		parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value="";
		parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value="";
		parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_cnt.value="0";
		parent.criteria_frame.addtl_splty_criteria_form.search_by[0].checked=true;
		parent.criteria_frame.addtl_splty_criteria_form.start_ends_contains.value="S";
		parent.criteria_frame.addtl_splty_criteria_form.search_text.value="";
		parent.result_frame.location.href='../../eCommon/html/blank.html';
		parent.button_frame.location.href='../../eOA/jsp/OAAdditionalSpecialtyButton.jsp';
	}
	function close(){
		if(parent.result_frame.addtl_splty_result_form){
			var recordCount=parent.result_frame.addtl_splty_result_form.recordCount.value;
			var codeStr="";
			var descStr="";
			var retun_value="";
			var j=0;
			/*for(i=0;i<recordCount;i++){ 
				var check=eval("parent.result_frame.addtl_splty_result_form.check"+i)
				if(check.checked){
					if(j==0){
						codeStr=eval("parent.result_frame.addtl_splty_result_form.code"+i).value;
						descStr=eval("parent.result_frame.addtl_splty_result_form.desc"+i).value;
					}else{
						codeStr=codeStr+","+eval("parent.result_frame.addtl_splty_result_form.code"+i).value;
						descStr=descStr+"^"+eval("parent.result_frame.addtl_splty_result_form.desc"+i).value;
					}
					j++;
				}
			}
			if(j==0){
			}else{
				retun_value=codeStr+"~"+descStr;
			}*/
			//alert(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value)
			//alert(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value)
			retun_value=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value+"~"+parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value;
			top.window.returnValue =retun_value;
			top.window.close();
		}else{
			top.window.returnValue="";
			parent.window.close();
		}
	}
</script>
</head>
<body onload='call_result_page()' onKeyDown = 'lockKey()'>
<form name="addtl_splty_criteria_form" id="addtl_splty_criteria_form">
<table   border="0" width='100% 'cellspacing='0' cellpadding='0'>
 <tr width="100">
 <td  class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
 <td  class="label">
 <input type="radio" name="search_by" id="search_by" class="label" value="D" checked ><fmt:message key="Common.description.label"  bundle="${common_labels}"/>
 <input type="radio" name="search_by" id="search_by" class="label" value="C"><fmt:message key="Common.code.label"  bundle="${common_labels}"/></td>
         <td class='label'><fmt:message key="Common.search.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td><td><select name="start_ends_contains" id="start_ends_contains">
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				</select></td>
 </tr>
 <tr >
 <td class="label" nowrap ><fmt:message key="Common.search.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
 <td align='left'>&nbsp;<input type='text'  name='search_text' id='search_text' size='30' maxlength='50' value="" onkeypress=''></td>
 <td>&nbsp;</td>
 <td ><input type="button" class='button' align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="call_result_page()">&nbsp;
	  <input type="button"  align="left" name="clear" id="clear" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class='button'  onClick="reSet()">
 </td>
 </tr>
 </table>
 <input type='hidden' name="addtl_splty" id="addtl_splty" value="">
 <input type='hidden' name="addtl_splty_desc" id="addtl_splty_desc" value="">
 <input type='hidden' name="addtl_splty_cnt" id="addtl_splty_cnt" value="0">
 <input type='hidden' name="search_click" id="search_click" value="N">

</form>
</body>
</html>

