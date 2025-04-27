<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_passing_local_date="";
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBPRACT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");

		if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}


	String practtype		=  "";
	StringBuffer fm_strt	=  null;
	StringBuffer to_strt	=  null;
	String practtypedesc	=  "";	
	Statement stmt=null;
	ResultSet rs   =  null;
	Connection con =null;
	try
	{

	con=ConnectionManager.getConnection(request);
	 stmt =  con.createStatement();
	

     fm_strt= new StringBuffer();
	 to_strt= new StringBuffer();
	// out.println("F");
	// String sqlt ="select pract_type,Desc_Userdef  from am_pract_type_lang_vw where language_id='"+locale+"' ";
	String sqlt ="select pract_type,Desc_Userdef  from am_pract_type";
	 rs= stmt.executeQuery(sqlt) ;		
	 fm_strt.append("<select name='p_fm_practitioner_type' id='p_fm_practitioner_type'><option value=''> -------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------");
	 to_strt.append("<select name='p_to_practitioner_type' id='p_to_practitioner_type'><option value=''> -------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------");
	
	 while(rs!=null && rs.next()) 
	 {
		practtype=rs.getString("pract_type");
		practtypedesc=rs.getString("Desc_Userdef");
		if(practtype ==null) practtype="";
		if(practtypedesc ==null) practtypedesc="";
		fm_strt.append("<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc);
		to_strt.append("<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc);
	 }
	 fm_strt.append("</select>");
	 to_strt.append("</select>");
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
			
			//alert(obj.name)
			if(obj.name=="fm_practitioner")
			{
				tit=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
				var fm_pract_type = repPractitionerList.p_fm_practitioner_type.value;
				sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where pract_type = 	nvl(`"+fm_pract_type+"`,pract_type) and language_id=`"+locale+"` ";
				search_code="practitioner_id";
				search_desc= "practitioner_name";
			}
			if(obj.name=="to_practitioner")
			{
				tit=encodeURIComponent(getLabel("Common.practitioner.label","Common"));

				var to_pract_type = repPractitionerList.p_to_practitioner_type.value;
				sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where pract_type = 	nvl(`"+to_pract_type+"`,pract_type) and language_id=`"+locale+"` ";
				search_code="practitioner_id";
				search_desc= "practitioner_name";
			}
			if(obj.name=="speciality")
			{
				tit=encodeURIComponent(getLabel("Common.speciality.label","Common"));

				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}
			if(obj.name=="facility")
			{
				tit=encodeURIComponent(getLabel("Common.facility.label","Common"));

				sql="select facility_id, facility_name from sm_facility_param_lang_vw where language_id=`"+locale+"` ";
				search_code="facility_id";
				search_desc= "facility_name";
			}
			if(obj.name=="practitionerType")
			{
				tit=encodeURIComponent(getLabel("Common.practitionertype.label","Common"));
				sql="select pract_type, desc_userdef from am_pract_type_lang_vw where language_id=`"+locale+"` ";
				search_code="pract_type";
				search_desc= "desc_userdef";
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

				if(obj.name=="fm_practitioner")
			{
				tit=getLabel("Common.practitioner.label","Common");
				var fm_pract_type = repPractitionerList.p_fm_practitioner_type.value;
				sql="select practitioner_id code, practitioner_name description from am_practitioner where pract_type = 	nvl('"+fm_pract_type+"',pract_type) and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
			
				
			}
			if(obj.name=="to_practitioner")
			{
				tit=getLabel("Common.practitioner.label","Common");

				var to_pract_type = repPractitionerList.p_to_practitioner_type.value;
				sql="select practitioner_id code, practitioner_name description from am_practitioner where pract_type = 	nvl('"+to_pract_type+"',pract_type) and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
				
			
			}
			if(obj.name=="speciality")
			{
				tit=getLabel("Common.speciality.label","Common");

				sql="select speciality_code code, short_desc description from am_speciality where upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
			
			}
			if(obj.name=="facility")
			{
				tit=getLabel("Common.facility.label","Common");

				sql="select facility_id code, facility_name description from sm_facility_param where upper(facility_id) like upper(?) and upper(facility_name) like upper(?) order by 2";
			
				
			}
			if(obj.name=="practitionerType")
			{
				tit=getLabel("Common.practitionertype.label","Common");
				sql="select pract_type code, desc_userdef description from am_pract_type where  upper(pract_type) like upper(?) and upper(desc_userdef) like upper(?) order by 2 ";
				
				
				
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

				if(obj.name=="p_fm_practitioner_id")
			{
				tit=getLabel("Common.practitioner.label","Common");
				var fm_pract_type = repPractitionerList.p_fm_practitioner_type.value;
				sql="select practitioner_id code, practitioner_name description from am_practitioner where pract_type = 	nvl('"+fm_pract_type+"',pract_type) and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
			}
			if(obj.name=="p_to_practitioner_id")
			{
				tit=getLabel("Common.practitioner.label","Common");

				var to_pract_type = repPractitionerList.p_to_practitioner_type.value;
				sql="select practitioner_id code, practitioner_name description from am_practitioner where pract_type = 	nvl('"+to_pract_type+"',pract_type) and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
				
			}
			if(obj.name=="p_fm_primary_speciality_code" || obj.name=="p_to_primary_speciality_code" )
			{
				tit=getLabel("Common.speciality.label","Common");

				sql="select speciality_code code, short_desc description from am_speciality where upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
			}
			if(obj.name=="p_fm_rep_facility_id" || obj.name=="p_to_rep_facility_id"  )
			{
				tit=getLabel("Common.facility.label","Common");

				sql="select facility_id code, facility_name description from sm_facility_param where upper(facility_id) like upper(?) and upper(facility_name) like upper(?) order by 2";
				
			}
			if(obj.name=="practitionerType")
			{
				tit=getLabel("Common.practitionertype.label","Common");
				sql="select pract_type code, desc_userdef description from am_pract_type where  upper(pract_type) like upper(?) and upper(desc_userdef) like upper(?) order by 2 ";
				
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

<BODY onLoad="Focusing('p_fm_practitioner_type')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repPractitionerList" id="repPractitionerList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
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
						<td align='right' width='30%' class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td width='20%'  ><%=fm_strt.toString()%>&nbsp;&nbsp;
						</td>
						<td width='40%'> <%=to_strt.toString()%>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>
 					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_practitioner_id' id='p_fm_practitioner_id' size="15" maxlength="15" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_practitioner_id,p_fm_practitioner_id_desc)'><input type="hidden" name="p_fm_practitioner_id_desc" id="p_fm_practitioner_id_desc"><input type='button' name='fm_practitioner' id='fm_practitioner' value='?' class='button' onclick='searchCode(this,p_fm_practitioner_id,p_fm_practitioner_id_desc)'>&nbsp;&nbsp;
						</td>
						<td width='40%'> <input type=text  name='p_to_practitioner_id' id='p_to_practitioner_id' size="15" maxlength="15" align="center" onblur='if(this.value !="") searchCode1(this,p_to_practitioner_id,p_to_practitioner_id_desc)'><input type="hidden" name="p_to_practitioner_id_desc" id="p_to_practitioner_id_desc"><input type='button' name='to_practitioner' id='to_practitioner' value='?' class='button' onclick='searchCode(this,p_to_practitioner_id,p_to_practitioner_id_desc)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_primary_speciality_code' id='p_fm_primary_speciality_code' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_primary_speciality_code,p_fm_primary_speciality)'><input type="hidden" name="p_fm_primary_speciality" id="p_fm_primary_speciality"><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode(this,p_fm_primary_speciality_code,p_fm_primary_speciality)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_primary_speciality_code' id='p_to_primary_speciality_code' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode1(this,p_to_primary_speciality_code,p_to_primary_speciality)'><input type="hidden" name="p_to_primary_speciality" id="p_to_primary_speciality"><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode(this,p_to_primary_speciality_code,p_to_primary_speciality)'>
						</td>
				</tr>
				<tr>
				<td>&nbsp;</td>
				<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="eAM.RepFacilityID.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
					<td width='20%'  ><input type=text  name='p_fm_rep_facility_id' id='p_fm_rep_facility_id' size="2" maxlength="2" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_rep_facility_id,p_fm_rep_facility_id_desc)'><input type="hidden" name="p_fm_rep_facility_id_desc" id="p_fm_rep_facility_id_desc"><input type='button' name='facility' id='facility' value='?' class='button' onclick='searchCode(this,p_fm_rep_facility_id,p_fm_rep_facility_id_desc)'>
					</td>
					<td width='40%'> <input type=text  name='p_to_rep_facility_id' id='p_to_rep_facility_id' size="2" maxlength="2" align="center" onblur='if(this.value !="") searchCode1(this,p_to_rep_facility_id,p_to_rep_facility_id_desc)'><input type="hidden" name="p_to_rep_facility_id_desc" id="p_to_rep_facility_id_desc"><input type='button' name='facility' id='facility' value='?' class='button' onclick='searchCode(this,p_to_rep_facility_id,p_to_rep_facility_id_desc)'>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' align="left">
					<select name='job_title' id='job_title'><option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------
	
					
					<%sqlt    =  "select POSITION_CODE,POSITION_DESC from am_position where role_type = 'P' order by 2 ";
	                 if(rs!=null)rs.close();
					 rs= stmt.executeQuery(sqlt) ;	
					 while (rs.next())
		             {
					 %>	
	 
					<option value='<%=rs.getString(1)%>'><%=rs.getString(2)%>
					<%}%>
					</select>					
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.EmplStatus.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' align="left">
						<select name='empl_status' id='empl_status'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------
					    <option value='F'><fmt:message key="Common.FullTime.label" bundle="${common_labels}"/>
					    <option value='P'><fmt:message key="Common.PartTime.label" bundle="${common_labels}"/>
					    <option value='V'><fmt:message key="Common.Visitor.label" bundle="${common_labels}"/>
					    <option value='S'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/>
					</select>					
					</td>
				</tr>												
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
				<td align='right' width='30%' class="label"><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/> &nbsp;</td>
				<td  width='20%' align="left">
				<select name='all_facility' id='all_facility'>
				<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/>
				<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/>
				</select>					
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
				<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
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
				<option value='1'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>
				<option value='2'><fmt:message key="eAM.PractitionrerName.label" bundle="${am_labels}"/>
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
	<!-- <input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
	<input type='hidden' name='p_passing_local_date' id='p_passing_local_date' value='<%=p_passing_local_date%>' -->
</form>
</BODY>
</HTML>
<%
}catch(Exception e){
	//out.println(e);
	e.printStackTrace();
}
finally { 
    if(rs!=null)	rs.close();
    if(stmt!=null)  stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>

