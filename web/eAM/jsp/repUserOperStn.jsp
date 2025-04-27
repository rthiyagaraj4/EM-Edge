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
	String p_report_id		= "AMBUSROS" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue("login_user") ;
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
	//PreparedStatement pstmt = null ;
	//ResultSet rs = null;
	Statement stmt=null;
	ResultSet rset=null;
%>
<html>
<HEAD>
<TITLE></TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eAM/js/SearchPopup.js" language="JavaScript"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function ValidateDate(obj)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
	}
}


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
			
			//alert(obj.name)
			if(obj.name=="operstn_fm" || obj.name=="operstn_to")
			{
				tit="Operator Station"
				sql="select oper_stn_id, short_desc from am_oper_stn where FACILITY_ID =`"+repUserOperStn.p_facility.value+"` ";
				search_code="oper_stn_id";
				search_desc= "short_desc";
			}
			if(obj.name=="user_fm" || obj.name=="user_to")
			{
				tit="Application User"
				sql="select appl_user_id, appl_user_name from SM_FACILITY_FOR_USER_VW where FACILITY_ID =`"+repUserOperStn.p_facility.value+"` ";
				search_code="appl_user_id";
				search_desc= "appl_user_name";
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	function checkVal(Objval)
	{
		if(Objval == "All")
		{
			repUserOperStn.p_fm_oper_stn_id.value = "";
			repUserOperStn.p_to_oper_stn_id.value = "";
			repUserOperStn.p_fm_oper_stn_id.disabled = true;
			repUserOperStn.p_to_oper_stn_id.disabled = true;
			repUserOperStn.operstn_fm.disabled = true;
			repUserOperStn.operstn_to.disabled = true;

			repUserOperStn.p_fm_appl_user_id.value = "";
			repUserOperStn.p_to_appl_user_id.value = "";
			repUserOperStn.p_fm_appl_user_id.disabled = true;
			repUserOperStn.p_to_appl_user_id.disabled = true;
			repUserOperStn.user_fm.disabled = true;
			repUserOperStn.user_to.disabled = true;
		}
		else
		{
			repUserOperStn.p_fm_oper_stn_id.disabled = false;
			repUserOperStn.p_to_oper_stn_id.disabled = false;
			repUserOperStn.operstn_fm.disabled = false;
			repUserOperStn.operstn_to.disabled = false;

			repUserOperStn.p_fm_appl_user_id.disabled = false;
			repUserOperStn.p_to_appl_user_id.disabled = false;
			repUserOperStn.user_fm.disabled = false;
			repUserOperStn.user_to.disabled = false;
		}
	}
*/
</script>
</HEAD>

<BODY onLoad="Focusing('p_facility'); checkVal('All');" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repUserOperStn" id="repUserOperStn" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='100%' cellPadding="0" cellSpacing="0"  align='center'>

		<tr>
			<td align="right" class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td colspan='2'><select name='p_facility' id='p_facility' onChange="checkVal(this.value);">
			
				<%
					try
					{
					con = ConnectionManager.getConnection(request);	
					stmt=con.createStatement();
					String fid;
					String fname;
					StringBuffer sql1 = new StringBuffer("select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='");
					sql1.append(p_user_name);
					sql1.append("' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '");
					sql1.append(p_resp_id);
					sql1.append("') order by 2 ");			

					rset=stmt.executeQuery(sql1.toString());
					sql1.setLength(0);
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

					}catch(Exception e) { 
					//out.println(e);
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
						<td>&nbsp;</td>
						<td class="fields" style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="fields" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td align='right' class="label"><fmt:message key="eAM.OperatorStationID.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
						<td ><input type=text  name='p_fm_oper_stn_id' id='p_fm_oper_stn_id' size="30" maxlength="30" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_oper_stn_id,p_fm_oper_stn)'><input type="hidden" name="p_fm_oper_stn" id="p_fm_oper_stn"><input type='button' name='operstn_fm' id='operstn_fm' value='?' class='button' onclick='open_lookup(this,p_fm_oper_stn_id,p_fm_oper_stn)'>&nbsp;&nbsp;&nbsp;
						</td>
						<td > <input type=text  name='p_to_oper_stn_id' id='p_to_oper_stn_id' size="30" maxlength="30" align="center" onblur='if(this.value !="") open_lookup(this,p_to_oper_stn_id,p_to_oper_stn)'><input type="hidden" name="p_to_oper_stn" id="p_to_oper_stn"><input type='button' name='operstn_to' id='operstn_to' value='?' class='button' onclick='open_lookup(this,p_to_oper_stn_id,p_to_oper_stn)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
					<tr>
						<td align='right' class="label"><fmt:message key="eAM.ApplUserID.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
						<td><input type=text  name='p_fm_appl_user_id' id='p_fm_appl_user_id' size="30" maxlength="30" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_appl_user_id,p_fm_appl_user)'><input type="hidden" name="p_fm_appl_user" id="p_fm_appl_user"><input type='button' name='user_fm' id='user_fm' value='?' class='button' onclick='open_lookup(this,p_fm_appl_user_id,p_fm_appl_user)'>&nbsp;&nbsp;&nbsp;
						</td>
						<td> <input type=text  name='p_to_appl_user_id' id='p_to_appl_user_id' size="30" maxlength="30" align="center" onblur='if(this.value !="") open_lookup(this,p_to_appl_user_id,p_to_appl_user)'><input type="hidden" name="p_to_appl_user" id="p_to_appl_user"><input type='button' name='user_to' id='user_to' value='?' class='button' onclick='open_lookup(this,p_to_appl_user_id,p_to_appl_user)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>			
					

					<tr>
						<td align='right' class="label"><fmt:message key="Common.EffectiveDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td><input type=text name='p_eff_date_fm' id='p_eff_date_fm' size="10" maxlength="10" align="center" onblur="ValidateDate(this);"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_eff_date_fm');">
						</td>
						<td> <input type=text  name='p_eff_date_to' id='p_eff_date_to' size="10" maxlength="10" align="center" onblur="ValidateDate(this);"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_eff_date_to');">
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
					<td align="left">
						<select name='p_order_by' id='p_order_by'>
						<option value='1,2'><fmt:message key="Common.userid.label" bundle="${common_labels}"/>
						<option value='1,3'><fmt:message key="Common.username.label" bundle="${common_labels}"/>
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
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<input type='hidden' name='locale' id='locale'				value='<%=locale%>'>
<!-- <input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
<input type='hidden' name='p_passing_local_date' id='p_passing_local_date' value='<%=p_passing_local_date%>'> -->

</form>
</BODY>
</HTML>	

