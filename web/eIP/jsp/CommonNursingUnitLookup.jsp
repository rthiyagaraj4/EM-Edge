<!DOCTYPE html>
<!--This page is used as intermediate page for common Nursing Unit Lookup    -->


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facilityID	= (String) session.getValue( "facility_id" ) ;
	String locale	  = (String)session.getAttribute("LOCALE");
	String nursing_unit_code_Appl;
	String nursing_unit_to_code_Appl;
	nursing_unit_code_Appl=request.getParameter("nursing_unit_code_Appl");
	nursing_unit_to_code_Appl=request.getParameter("nursing_unit_to_code_Appl");
	nursing_unit_to_code_Appl=nursing_unit_to_code_Appl==null?"nursing_unit_to_code":request.getParameter("nursing_unit_to_code_Appl");

%>

<html>	
<HEAD>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function CommonsearchCode(target_code,target,target_to_code)
	{		
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var dispDescFirst="";
			
				tit=getLabel('Common.nursingUnit.label','common');
				
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= facilityID%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
				dispDescFirst="dispDescFirst";
			

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&dispDescFirst="+dispDescFirst+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				
				retVal=retVal.split("::");
				target.value=retVal[0];
				target_code.value=retVal[1];
				target_to_code.value=retVal[1];
			}
			else{
				target.focus();
				}
	}
function chkNursUnitValue(target_code,target,target_to_code){
	if(target.value==""){
	target_code.value="";
	target_to_code.value="";
	}
}	
</script>
</HEAD>
<body>

	<td align='right' width='30%' class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> &nbsp;</td>
	<td width='40%'><input type='text' name='nursing_unit_desc' id='nursing_unit_desc' size="15" value="" maxlength="15" align="center" onblur='chkNursUnitValue(<%=nursing_unit_code_Appl%>,nursing_unit_desc,<%=nursing_unit_to_code_Appl%>)'><input type='button'  name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='CommonsearchCode(<%=nursing_unit_code_Appl%>,nursing_unit_desc,<%=nursing_unit_to_code_Appl%>)'>
	</td>
	<input type="hidden" name="<%=nursing_unit_code_Appl%>" id="<%=nursing_unit_code_Appl%>" value="">
	<input type="hidden" name="<%=nursing_unit_to_code_Appl%>" id="<%=nursing_unit_to_code_Appl%>" value="">


<input type="hidden" name="facilityID" id="facilityID"	value="<%= facilityID %>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</body>
</HTML>

