<!DOCTYPE html>
<%--
Filename		: VisitStatByAgeRangeNationality.jsp
Modified On		: 1-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String p_resp_id				= (String)session.getValue("responsibility_id");
	String locale=(String)session.getAttribute("LOCALE");
	Connection con = null;
	PreparedStatement pstmt  = null;
	ResultSet rs=null;
	ResultSet rset = null;
%>
<html>
<HEAD>
<SCRIPT>


<%-- Code added/modified by Tushar .T. Bhat on 09-Feb-04 for incorporating enterable look-ups --%>


async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = document.forms[0].P_facilityid.value;
	var tit="";
	var locale="<%=locale%>";
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	if(obj.name=="tolocn" || obj.name=="fromlocn")
    {
        tit=getLabel("Common.Location.label","Common");

		//SQL

        //argumentArray[0]="select clinic_code code, short_desc description from op_clinic where facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

                
    }	
	else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
    {
				
                tit=getLabel("Common.speciality.label","Common");

				//SQL

                //argumentArray[0]="select speciality_code code, short_desc description from am_speciality where '1' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

   }
	
	else if(obj.name=="agegroup")
	{
		tit=getLabel("Common.agegroup.label","Common");

		//SQL


		//argumentArray[0]="select age_group_code code, short_desc description from am_age_group where '1' like ? and upper(age_group_code) like upper(nvl(?,age_group_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0]="select age_group_code code, short_desc description from am_age_group_lang_vw where '1' like ? and language_id='"+locale+"' and upper(age_group_code) like upper(nvl(?,age_group_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
		
		
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
               
	}
	else	 if (obj.name=="race")
	{
		tit=getLabel("Common.race.label","Common")+getLabel("Common.Group.label","Common");
		//argumentArray[0]="select race_code code, short_desc description from mp_race where '1' like ? and upper(race_code) like upper(nvl(?,race_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2  ";

		argumentArray[0]="select race_code code, short_desc description from mp_race_lang_vw where '1' like ? and language_id='"+locale+"' and upper(race_code) like upper(nvl(?,race_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2  ";
				
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
           
	}	
	else			
	{
		tit=getLabel("Common.nationality.label","Common");

		//SQL


		//argumentArray[0]="select country_code code, long_desc description from mp_country where '1' like ? and upper(country_code) like upper(nvl(?,country_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";

		argumentArray[0]="select country_code code, long_desc description from mp_country_lang_vw where '1' like ? and language_id='"+locale+"' and upper(country_code) like upper(nvl(?,country_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
		
		
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
               
	}			
	
	var retVal=await CommonLookup(tit,argumentArray);

	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];
	}

<%-- Code added/modified by Tushar .T. Bhat on 09-Feb-04 ends --%>


</SCRIPT>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eOP/js/repOPVisitStatByAgeRangeNationality_SRR.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="VisitByStatus_form" id="VisitByStatus_form"  action="../../eCommon/jsp/report_options.jsp" 		target="messageFrame">
<br><br><br><br>

<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
	<td class='columnheader' width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='2' border = '0' cellspacing='0' width='80%'>
<tr>
	<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name="P_facilityid" id="P_facilityid">
	<%
	   				try
					{
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";
					
					//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";

					String sql1="SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name ";
					
					pstmt=con.prepareStatement(sql1);
					rset=pstmt.executeQuery(sql1);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+ "' >"+fname+"</option>");
					   }
					}

					}catch(Exception e)
					{
						e.printStackTrace();
					}
				 if (rset != null) rset.close();
	 			 if (pstmt != null) pstmt.close();
	%>
	</td>	
	<td>&nbsp;</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>

	<td class='fields' colspan='2'><select name="p_age_range_code" id="p_age_range_code">
	 <option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
	  <%
	     try
		 {
			 
			 //pstmt 	= con.prepareStatement( "select range_id, long_desc from am_summ_range where range_type='A' and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status ='E' order by 2");

			 pstmt 	= con.prepareStatement( "select range_id, long_desc from am_summ_range_lang_vw where range_type='A' and language_id='"+locale+"' and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status ='E' order by 2");
 	      	 rs = pstmt.executeQuery() ;
 			 if( rs != null )
			 {
				while( rs.next() )
				{
					String range_id 	= rs.getString( "range_id" ) ;
					String long_desc 	= rs.getString( "long_desc" ) ;
					out.println( "<option value='"+range_id+"' >"+long_desc+"</option>") ;
				}
			 }
			 if (rs != null) rs.close();
 			 if (pstmt != null) pstmt.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 finally{
			  ConnectionManager.returnConnection(con,request);
		 }
	  %>
	   </select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
</tr>

<tr>
<td width='33%'>&nbsp;</td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td></tr>

<tr>
	<!-- <td class="label"><fmt:message key="eOP.StatisticsDate.label" bundle="${op_labels}"/></td> -->
	<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text  id='mdsfrom' name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom');" style="cursor='hand'"></img>
	<img src='../../eCommon/images/mandatory.gif'></img></td>
	
	<td class='fields'><input type=text id='mdsto'  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto');" style="cursor='hand'"></img>
	<img src='../../eCommon/images/mandatory.gif'></img></td>
	
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.NationalityCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_nation_code" id="p_fm_nation_code" size="4" maxlength="4" onBlur='searchCode(fromnation,this)'><input type='button' name='fromnation' id='fromnation' value='?' class='button' onclick='searchCode(this,p_fm_nation_code)'>
	</td>

	<td class='fields'><input type="text" name="p_to_nation_code" id="p_to_nation_code" size="4" maxlength="4" onBlur='searchCode(tonation,this)'><input type='button' name='tonation' id='tonation' value='?' class='button' onclick='searchCode(this,p_to_nation_code)'>
	</td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.race.label" bundle="${common_labels}"/><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_race_code" id="p_fm_race_code" size="12" maxlength="12" 	onBlur='searchCode(race,this)'><input type='button' name='race' id='race' value='?' class='button' onclick='searchCode(this,p_fm_race_code)'>
	</td>

	<td class='fields'><input type="text" name="p_to_race_code" id="p_to_race_code" size="12" maxlength="12" onBlur='searchCode(race,this)'><input type='button' name='race' id='race' value='?' class='button' onclick='searchCode(this,p_to_race_code)'>
	</td>
</tr>
<tr>
		<td class="label"><fmt:message key="Common.VisitStatus.label" bundle="${common_labels}"/></td>
    <td class='fields'><select name="visit_status" id="visit_status" >
			<option value =''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
			<option value ='C'><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
			<option value ='I'><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
			<option value ='A'><fmt:message key="eOP.AutoComplete.label" bundle="${op_labels}"/></option>
		</select>
		</td>
		<td>&nbsp;</td>		
</tr>
<tr >
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr>

 <tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
	</td>
</tr>
<tr>
    <td class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='checkbox' name="p_group_by_location" id="p_group_by_location" value='' onclick='changerepId(this)'></td>	
</tr>

</table>

	<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id %>">
		<input type="hidden" name="p_facility" id="p_facility"  		value="<%=p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 	value="OP">
		<input type="hidden" name="p_report_id" id="p_report_id" 	value="OPVSAGNT">
		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"	value="<%= p_resp_id %>">
		<input type="hidden" name="p_age_group" id="p_age_group"	value="">
		<!-- <input type="hidden" name="p_fm_nation_code" id="p_fm_nation_code" value="">
		<input type="hidden" name="p_to_nation_code" id="p_to_nation_code" 	 value=""> -->
		<input type="hidden" name="p_visit_status" id="p_visit_status"	 value="">
		<input type="hidden" name="p_fm_visit_date" id="p_fm_visit_date"	value="">
		<input type="hidden" name="p_to_visit_date" id="p_to_visit_date" 		value="">
		<!-- <input type="hidden" name="p_age_range_code" id="p_age_range_code"  value=""> -->
		<input type="hidden" name="p_facilityid" id="p_facilityid" 	  value="">


		<input type="hidden" name="p_fm_nation_code1" id="p_fm_nation_code1"	value="">
		<input type="hidden" name="p_to_nation_code1" id="p_to_nation_code1" 		value="">

		<input type="hidden" name="p_fm_race_code1" id="p_fm_race_code1"	 value="">
		<input type="hidden" name="p_to_race_code1" id="p_to_race_code1"  value="">

		<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

</form>
</body>
</center>

<br>
<br>
</html>

