<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBESTYP" ;
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
			
			if(obj.name=="escort")
			{
				tit=encodeURIComponent(getLabel("eAM.EscortType.label","am"));
				sql="select escort_type_code,short_desc from AM_ESCORT_TYPE_LANG_VW where language_id=`"+locale+"` ";
				search_code="escort_type_code";
				search_desc= "short_desc";
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
				var tit=getLabel("eAM.EscortType.label","am");
				var sql="";
				
				sql="select escort_type_code code,short_desc description from AM_ESCORT_TYPE where upper(escort_type_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
						
							
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

<BODY onLoad="Focusing('p_fm_escort_code')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repEscortType" id="repEscortType" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
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
						<td align='right' width='30%' class="label"><fmt:message key="eAM.EscortType.label" bundle="${am_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_escort_code' id='p_fm_escort_code' size="2" maxlength="2" align="center" onblur='if(this.value !="") searchCode(this,p_fm_escort_code,p_fm_escort)'><input type="hidden" name="p_fm_escort" id="p_fm_escort"><input type='button' name='escort' id='escort' value='?' class='button' onclick='searchCode(this,p_fm_escort_code,p_fm_escort)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_escort_code' id='p_to_escort_code' size="2" maxlength="2" align="center"  onblur='if(this.value !="") searchCode(this,p_to_escort_code,p_to_escort)'><input type="hidden" name="p_to_escort" id="p_to_escort"><input type='button' name='escort' id='escort' value='?' class='button' onclick='searchCode(this,p_to_escort_code,p_to_escort)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
												
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_nature' id='p_nature'>
						<option value=''><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
						</select>
					</td>
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
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	

</form>
</BODY>
</HTML>

