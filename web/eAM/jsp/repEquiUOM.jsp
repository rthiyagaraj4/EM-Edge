<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBEQUOM" ;
	String p_passing_local_date="";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}

%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
/*function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale=document.forms[0].locale.value;
			
			if(obj.name=="ambstatus")
			{
				tit=encodeURIComponent(getLabel("eAM.UnitofMeasure.label","am"));

				sql="SELECT UOM_CODE, short_desc FROM am_uom_lang_vw where language_id=`"+locale+"` ";
				search_code="UOM_CODE";
				search_desc= "short_desc";
			}
			if(obj.name=="OBJequiUOM")
			{
				tit=encodeURIComponent(getLabel("eAM.EquivalentUnitofMeasure.label","am"));
				sql=" SELECT eqvl_uom_code, am_get_desc.am_uom(eqvl_uom_code,`"+locale+"`,2) short_desc FROM am_uom_eqvl ";
				search_code="EQVL_UOM_CODE";
				search_desc= "2";
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}*/


	async function searchCode(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";


				if(obj.name=="ambstatus")
			{
				tit=getLabel("Common.UnitofMeasure.label","common");

				sql="SELECT UOM_CODE code, short_desc description FROM am_uom where upper(UOM_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
				
				
			}
			if(obj.name=="OBJequiUOM")
			{
				tit=getLabel("eAM.EquivalentUnitofMeasure.label","am");
				
				sql="SELECT eqvl_uom_code code, short_desc description FROM am_uom_eqvl a,am_uom b where a.eqvl_uom_code = b.uom_code and upper(eqvl_uom_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
				
								
			}

			
				
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}


			async function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";


				if(obj.name=="p_fm_status" || obj.name=="p_to_status")
			{
				tit=getLabel("Common.UnitofMeasure.label","common");

				sql="SELECT UOM_CODE code, short_desc description FROM am_uom where upper(UOM_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
			}
			if(obj.name=="p_fm_status_equiUOM" || obj.name=="p_to_status_equiUOM")
			{
				tit=getLabel("eAM.EquivalentUnitofMeasure.label","am");
				sql="SELECT eqvl_uom_code code, short_desc description FROM am_uom_eqvl a,am_uom b where a.eqvl_uom_code = b.uom_code and upper(eqvl_uom_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
				
			}

				
				
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}

</script>
</HEAD>

<BODY onLoad="Focusing('p_fm_status')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repEquiUOMForm" id="repEquiUOMForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
</th>

<tr>
<td width="100%" class="Border" align='center'>
<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

<tr>
<td align="center" width="35%">&nbsp;</td>
<td class="fields" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
<td class="fields" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
<td align='right' width='30%' class="label"><fmt:message key="Common.uom.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
<td width='20%'  >
<input type=text  name='p_fm_status' id='p_fm_status' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_status,p_fm_status_desc)'><input type="hidden" name="p_fm_status_desc" id="p_fm_status_desc"><input type='button' name='ambstatus' id='ambstatus' value='?' class='button' onclick='searchCode(this,p_fm_status,p_fm_status_desc)'></td>
<td width='40%'>
<input type=text  name='p_to_status' id='p_to_status' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode1(this,p_to_status,p_to_status_desc)'><input type="hidden" name="p_to_status_desc" id="p_to_status_desc"><input type='button' name='ambstatus' id='ambstatus' value='?' class='button' onclick='searchCode(this,p_to_status,p_to_status_desc)'></td>
</tr>

<tr>
<td>&nbsp;</td>
<Td>&nbsp;</td>
</tr>

<tr>
<td align='right' width='30%' class="label"><fmt:message key="Common.EquivalentUOM.label" bundle="${common_labels}"/>&nbsp;</td>
<td width='20%'  >
<input type=text  name='p_fm_status_equiUOM' id='p_fm_status_equiUOM' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_status_equiUOM,p_fm_status_equiUOM_desc)'><input type="hidden" name="p_fm_status_equiUOM_desc" id="p_fm_status_equiUOM_desc"><input type='button' name='OBJequiUOM' id='OBJequiUOM' value='?' class='button' onclick='searchCode(this,p_fm_status_equiUOM,p_fm_status_equiUOM_desc)'></td>
<td width='40%'>
<input type=text  name='p_to_status_equiUOM' id='p_to_status_equiUOM' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode1(this,p_to_status_equiUOM,p_to_status_equiUOM_desc)'><input type="hidden" name="p_to_status_equiUOM_desc" id="p_to_status_equiUOM_desc"><input type='button' name='OBJequiUOM' id='OBJequiUOM' value='?' class='button' onclick='searchCode(this,p_to_status_equiUOM,p_to_status_equiUOM_desc)'></td>
</tr>
<tr>
<td>&nbsp;</td>
<Td>&nbsp;</td>
</tr>
<tr>
<td align='right' width='30%' class="label">
		<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
</td>
<td  width='20%' align="left">
	<select name='p_order_by' id='p_order_by'>
		<option value='1'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
		<option value='2'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</select>
</td>
</tr>

<tr>
	<td>&nbsp;</td>
	<Td>&nbsp;</td>
</tr>



</table>
</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type='hidden' name='locale' id='locale'				value='<%=locale%>'>

</form>
</BODY>
</HTML>

