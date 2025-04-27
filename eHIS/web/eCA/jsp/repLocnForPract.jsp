<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>

<%
	request.setCharacterEncoding("UTF-8");	
	String p_module_id		= "CA" ;
	String p_report_id		= "CABLCFPR" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;

%>
<html>
<HEAD>
<TITLE></TITLE>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCA/js/repResetRunList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function search_Code(obj,target)
{	
	var p_facility_id=document.repLocnForPract.p_facility_id.value;
	if(obj.name=='p_fr_practitioner_id1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{			
		
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

	        var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='practitioner_id' id='practitioner_id' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='PageName' id='PageName' value='repLocnForPract'><input type=hidden name='selFunVal' id='selFunVal' value='Fr_Practitioner'></form></body></html>";
			//alert(HTMLVal);
			parent.f_query_intermediate.document.write(HTMLVal);
				if(parent.f_query_intermediate.document.tempform1)
						parent.f_query_intermediate.document.tempform1.submit(); 
			
		}
	}
	else if(obj.name=='p_to_practitioner_id1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{			
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='practitioner_id' id='practitioner_id' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='PageName' id='PageName' value='repLocnForPract'><input type=hidden name='selFunVal' id='selFunVal' value='To_Practitioner'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='pract' || obj.name=='pract1')
	{		
		searchCode(obj,target);
	}
	
}
async function searchCode(obj,target)
{
			var p_facility_id=document.repLocnForPract.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";		
			var  fac_id='';
			if(obj.name=="pract" || obj.name=="p_fr_practitioner_id1" || obj.name=="pract1" || obj.name=="p_to_practitioner_id1")
			{
				
				title=getLabel('Common.practitioner.label','common');
				sql=" select distinct b.practitioner_id code, b.practitioner_name description ";
				sql+=" from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where ";
				sql+=" b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2" ;
				search_code="practitioner_id";
				search_desc= "practitioner_name";
						
			}
				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();
				
				argArray[0] = sql;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = CODE_DESC;
				retArray = await CommonLookup( title,argArray );
				if(retArray != null && retArray !="")	
				{
					var str =unescape(retArray);
				 	var arr = str.split(",");
					if(obj.name=="pract1") //|| obj.name=="p_to_practitioner_id1")
					{							
						document.repLocnForPract.p_to_practitioner_id1.value= arr[1];						
						document.repLocnForPract.p_to_practitioner_id.value= arr[0];						
					}
					else if(obj.name=="pract")// || obj.name=="p_fr_practitioner_id1")
					{
						document.repLocnForPract.p_fr_practitioner_id1.value= arr[1];
						document.repLocnForPract.p_fr_practitioner_id.value= arr[0];
					}
				}
				else
				{
					if(obj.name=="pract1")// || obj.name=="p_to_practitioner_id1")
					{							
						document.repLocnForPract.p_to_practitioner_id1.value= "";
						document.repLocnForPract.p_to_practitioner_id.value= "";
					}
					else if(obj.name=="pract")// || obj.name=="p_fr_practitioner_id1")
					{
						document.repLocnForPract.p_fr_practitioner_id1.value= "";
						document.repLocnForPract.p_fr_practitioner_id.value= "";
					}			
				}
}


</script>

</HEAD>

<BODY onload='FocusFirstElement()' onKeyDown="lockKey()">
<br>
<br>
<form name="repLocnForPract" id="repLocnForPract" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' cellpadding=3 >
<tr>
		<td class='COLUMNHEADERCENTER'  ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> 
		</td>
		</tr>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="3" cellSpacing="0"  align='center' >
					<tr>
						<td align="center" width="35%"></td>
						<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td  width='30%' class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
						<td class='fields' width='30%'  ><input type=text onblur='search_Code(this, p_fr_practitioner_id1)'  name='p_fr_practitioner_id1' id='p_fr_practitioner_id1' size="25" maxlength="20" align="center"><input type='hidden'  name='p_fr_practitioner_id' id='p_fr_practitioner_id' value=''><input type='button' name='pract' id='pract' value='?' class='button' onclick='search_Code(this, p_fr_practitioner_id1)'>
						</td>
						<td  class='fields' width='20%'><input type=text  name='p_to_practitioner_id1' id='p_to_practitioner_id1' onblur='search_Code(this, p_to_practitioner_id1)' size="25" maxlength="20" align="center"><input type='hidden'  name='p_to_practitioner_id' id='p_to_practitioner_id' value=''><input type='button' name='pract1' id='pract1' value='?' class='button' onclick='search_Code(this, p_to_practitioner_id1)'>
						</td>
				</tr>			
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">

</form>
</BODY>
</HTML>

