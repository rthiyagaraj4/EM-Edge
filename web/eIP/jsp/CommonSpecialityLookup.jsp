<!DOCTYPE html>
<!--This page is used as intermediate page for common Speciality Lookup    --> 
 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>

 
<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facilityID	= (String) session.getValue( "facility_id" ) ;
	String locale	  = (String)session.getAttribute("LOCALE");
	String speciality_code_Appl;
	String speciality_to_code_Appl="";
	speciality_code_Appl=request.getParameter("speciality_code_Appl");
	speciality_to_code_Appl=request.getParameter("speciality_to_code_Appl");
	speciality_to_code_Appl=speciality_to_code_Appl==null?"speciality_to_code":request.getParameter("speciality_to_code_Appl");

%>

<html>	
<HEAD>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 
<script>
async function CommonSpecsearchDesc(target_code,target,target_to_code)
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
			
				var tit=getLabel('Common.speciality.label','common');
				
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`  ";
				search_code="speciality_code";
				search_desc= "short_desc";
				dispDescFirst="dispDescFirst";

			
			

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = async window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&dispDescFirst="+dispDescFirst+"&title="+encodeURIComponent(tit),arguments,features);

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
function chkSpecValue(target_code,target,target_to_code){
	if(target.value==""){
		target_code.value="";
	target_to_code.value="";}
}	
	
</script>
</HEAD>
<body>


		<td  class='label'  width='30%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='40%'><input type="text" name="specialty_desc" id="specialty_desc" onBlur="chkSpecValue(<%=speciality_code_Appl%>,specialty_desc,<%=speciality_to_code_Appl%>);" value="" size="15" ><input type="button"  name='specialty_lookup' id='specialty_lookup' value='?' onClick="CommonSpecsearchDesc(<%=speciality_code_Appl%>,specialty_desc,<%=speciality_to_code_Appl%>)"></td>
		<input type="hidden"  name="<%=speciality_code_Appl%>" id="<%=speciality_code_Appl%>" value="">
		<input type="hidden"  name="<%=speciality_to_code_Appl%>" id="<%=speciality_to_code_Appl%>" value="">
		



<input type="hidden" name="facilityID" id="facilityID"	value="<%= facilityID %>">
<!--<input type="hidden" name="locale" id="locale" value="<%=locale%>"> --> <!--commented by mujafar for IN69942 -->
</body>
</HTML>

