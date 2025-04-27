<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBLCNOS" ;
	String p_passing_local_date="";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

	if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}

	Connection con = null;

	Statement stmt=null;
	ResultSet rset=null;
%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eAM/js/SearchPopup.js" language="JavaScript"></script>
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
			var facilityid = "<%=p_facility_id%>";
			var locale=document.forms[0].locale.value;
			
			if(obj.name=="operstn_fm" || obj.name=="operstn_to")
			{
				tit=encodeURIComponent(getLabel("Common.operatorstation.label","Common"));

				sql="select oper_stn_id, short_desc from am_oper_stn_lang_vw where facility_id=`"+repLocnForOperStn.p_facility.value+"` and language_id=`"+locale+"` ";
				search_code="oper_stn_id";
				search_desc= "short_desc";
			}
			if(obj.name=="speciality_fm" || obj.name=="speciality_to")
			{
				tit=encodeURIComponent(getLabel("Common.speciality.label","Common"));
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`  ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}
			if(obj.name=="locn_fm" || obj.name=="locn_to")
			{
				tit=encodeURIComponent(getLabel("Common.Location.label","Common"));
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+repLocnForOperStn.p_facility.value+"` and language_id=`"+locale+"` ";
				search_code="clinic_code";
				search_desc= "long_desc";
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

			if(obj.name=="operstn_fm" || obj.name=="operstn_to")
			{
				tit=getLabel("Common.operatorstation.label","Common");

				sql="select oper_stn_id code, short_desc description from am_oper_stn where facility_id='"+repLocnForOperStn.p_facility.value+"' and upper(oper_stn_id) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
			
			}
			if(obj.name=="speciality_fm" || obj.name=="speciality_to")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code, short_desc description from am_speciality where upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
				
				
				
			}
			if(obj.name=="locn_fm" || obj.name=="locn_to")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, short_desc description from op_clinic where facility_id='"+repLocnForOperStn.p_facility.value+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2 ";
				
				
				
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

			if(obj.name=="p_fm_oper_stn_id" || obj.name=="p_to_oper_stn_id")
			{
				tit=getLabel("Common.operatorstation.label","Common");

				sql="select oper_stn_id code, short_desc description from am_oper_stn where facility_id='"+repLocnForOperStn.p_facility.value+"' and upper(oper_stn_id) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
			}
			if(obj.name=="p_fm_speciality" || obj.name=="p_to_speciality")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code, short_desc description from am_speciality where upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
				
			}
			if(obj.name=="p_fm_locn_code" || obj.name=="p_to_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, short_desc description from op_clinic where facility_id='"+repLocnForOperStn.p_facility.value+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2 ";
				
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




	function checkVal(Objval)
	{
		if(Objval == "All")
		{
			repLocnForOperStn.p_fm_oper_stn_id.value = "";
			repLocnForOperStn.p_to_oper_stn_id.value = "";
			repLocnForOperStn.p_fm_oper_stn_id.disabled = true;
			repLocnForOperStn.p_to_oper_stn_id.disabled = true;
			repLocnForOperStn.operstn_fm.disabled = true;
			repLocnForOperStn.operstn_to.disabled = true;

			repLocnForOperStn.p_fm_locn_code.value = "";
			repLocnForOperStn.p_to_locn_code.value = "";
			repLocnForOperStn.p_fm_locn_code.disabled = true;
			repLocnForOperStn.p_to_locn_code.disabled = true;
			repLocnForOperStn.locn_fm.disabled = true;
			repLocnForOperStn.locn_to.disabled = true;
		}
		else
		{
			repLocnForOperStn.p_fm_oper_stn_id.disabled = false;
			repLocnForOperStn.p_to_oper_stn_id.disabled = false;
			repLocnForOperStn.operstn_fm.disabled = false;
			repLocnForOperStn.operstn_to.disabled = false;

			repLocnForOperStn.p_fm_locn_code.disabled = false;
			repLocnForOperStn.p_to_locn_code.disabled = false;
			repLocnForOperStn.locn_fm.disabled = false;
			repLocnForOperStn.locn_to.disabled = false;

		}
	}

</script>
</HEAD>

<BODY onLoad="Focusing('p_facility'); checkVal('All');" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repLocnForOperStn" id="repLocnForOperStn" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='100%' cellPadding="0" cellSpacing="0"  align='center'>
		<tr>
		    <td width='5%'>&nbsp</td>		
			<td align="right" class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;</td>
			<td colspan='2'><select name='p_facility' id='p_facility' onChange="checkVal(this.value);">
			
				<%
					try
					{
						con = ConnectionManager.getConnection(request);
					stmt=con.createStatement();
					String fid;
					String fname;
					String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";	

					rset=stmt.executeQuery(sql1);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='"+fid+"'  selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+"' >"+fname+"</option>");
					   }
					}
						if(rset!=null) rset.close();
						if(stmt!=null) stmt.close();
					}catch(Exception e) { //out.println(e);
						e.printStackTrace();
					}
					finally
					{
						
						ConnectionManager.returnConnection(con,request);
					} %>
				</select>
			</td>
			</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

					<tr>
					    <td width='5%'>&nbsp</td>
						<td align="center" width="30%">&nbsp;</td>
						<td class="fields" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="fields" width="30%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						<td width='5%'>&nbsp</td>
					</tr>
					<tr>
					        <td width='5%'>&nbsp</td>		
						<td  width='30%' class="label"><fmt:message key="eAM.OperatorStationID.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_oper_stn_id' id='p_fm_oper_stn_id' size="30" maxlength="30" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_oper_stn_id,p_fm_oper_stn_id_desc)'><input type="hidden" name="p_fm_oper_stn_id_desc" id="p_fm_oper_stn_id_desc"><input type='button' name='operstn_fm' id='operstn_fm' value='?' class='button' onclick='searchCode(this,p_fm_oper_stn_id,p_fm_oper_stn_id_desc)'>&nbsp;&nbsp;&nbsp;
						</td>
						<td width='40%'> <input type=text  name='p_to_oper_stn_id' id='p_to_oper_stn_id' size="30" maxlength="30" align="center" onblur='if(this.value !="") searchCode1(this,p_to_oper_stn_id,p_to_oper_stn_id_desc)'><input type="hidden" name="p_to_oper_stn_id_desc" id="p_to_oper_stn_id_desc"><input type='button' name='operstn_to' id='operstn_to' value='?' class='button' onclick='searchCode(this,p_to_oper_stn_id,p_to_oper_stn_id_desc)'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td width='5%'>&nbsp</td>
				</tr>
				<tr>
				 	<td width='5%'>&nbsp</td>	
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
					<td width='5%'>&nbsp</td>
				</tr>


					<tr>
					        <td width='5%'>&nbsp</td>		
						<td  width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_speciality' id='p_fm_speciality' size="4" maxlength="4" align="center"  onblur='if(this.value !="") searchCode1(this,p_fm_speciality,p_fm_speciality_desc)'><input type="hidden" name="p_fm_speciality_desc" id="p_fm_speciality_desc"><input type='button' name='speciality_fm' id='speciality_fm' value='?' class='button' onclick='searchCode(this,p_fm_speciality,p_fm_speciality_desc)'>&nbsp;&nbsp;&nbsp;
						</td>
						<td width='40%'> <input type=text  name='p_to_speciality' id='p_to_speciality' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode1(this,p_to_speciality,p_to_speciality_desc)'><input type="hidden" name="p_to_speciality_desc" id="p_to_speciality_desc"><input type='button' name='speciality_to' id='speciality_to' value='?' class='button' onclick='searchCode(this,p_to_speciality,p_to_speciality_desc)'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td width='5%'>&nbsp</td>
				</tr>
				<tr>
				 	<td width='5%'>&nbsp</td>	
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
					<td width='5%'>&nbsp</td>
				</tr>
									<tr>
										<td width='5%'>&nbsp</td>
										<td  class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
										<td width='20%'  ><input type=text  name='p_fm_locn_code' id='p_fm_locn_code' size="8" maxlength="8" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_locn_code,p_fm_locn)'><input type="hidden" name="p_fm_locn" id="p_fm_locn"><input type='button' name='locn_fm' id='locn_fm' value='?' class='button' onclick='searchCode(this,p_fm_locn_code,p_fm_locn)'>
										</td>
										<td width='40%'> <input type=text  name='p_to_locn_code' id='p_to_locn_code' size="8" maxlength="8" align="center" onblur='if(this.value !="") searchCode1(this,p_to_locn_code,p_to_locn)'><input type="hidden" name="p_to_locn" id="p_to_locn"><input type='button' name='locn_to' id='locn_to' value='?' class='button' onclick='searchCode(this,p_to_locn_code,p_to_locn)'>
										</td>
										<td width='5%'>&nbsp</td>
								</tr>
				
								<tr>
									<td width='5%'>&nbsp</td>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
									<td width='5%'>&nbsp</td>
				</tr>
								
				<tr>
					<td width='5%'>&nbsp</td>
					<td  class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_nature' id='p_nature'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td width='5%'>&nbsp</td>
				</tr>

				<tr>
					<td width='5%'>&nbsp</td>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
					<td width='5%'>&nbsp</td>
				</tr>
				<tr>
					<td width='5%'>&nbsp</td>
					<td  class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					</td>
					<td  width='20%' align="left" colspan='2'>
						<select name='p_order_by' id='p_order_by'>
						<option value='1,2'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>
						<option value='1,3'><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/>
						</select>
					</td>
					<td width='5%'>&nbsp</td>
				</tr>
				<tr>
					<td width='5%'>&nbsp</td>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
					<td width='5%'>&nbsp</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<!-- <input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
<input type='hidden' name='p_passing_local_date' id='p_passing_local_date' value='<%=p_passing_local_date%>'> -->
</form>
</BODY>
</HTML>

