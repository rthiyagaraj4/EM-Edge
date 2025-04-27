
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
    
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eOA/js/BulkTransferAppointment.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>



	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css'  href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function ValidateDate1(obj)
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


function DateCompare_from1(obj2,obj,Sys_date)
{
	

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		var obj1=convertDate(obj.value,"DMY",localeName,"en");

		
if(obj2 =="from")
			{
			if(isBefore(Sys_date,obj1,'DMY',"en")==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;

			}else
			{
				if(isBefore(Sys_date,obj1,'DMY',"en")==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
			}
		}
}

}

</script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con=null;
Statement stmt   	= null ;
//Statement stmtlen   =null;
//Statement stmt1 = null;
//Statement stmt5 = null;
//ResultSet rs2	   	= null;
ResultSet rs5	   	= null;
//ResultSet rslen	   	= null;
ResultSet rs_spec	   	= null;

boolean allow_inside=true;

String fac_id    	= (String) session.getValue( "facility_id" ) ;
String locale=(String)session.getAttribute("LOCALE");
//String pat_name_as_multipart_yn = "";
//String pat_name_length = "";
//String sys_date="";
String oper_stn_id=request.getParameter("oper_stn_id");
String currentdate=request.getParameter("currentdate");
/*
String canc_appt_yn=request.getParameter("canc_appt_yn");
if(canc_appt_yn.equals("") ) canc_appt_yn="N";
*/
String tfr_appt_yn=request.getParameter("tfr_appt_yn");
if(tfr_appt_yn.equals("") ) tfr_appt_yn="N";
//CheckStyle Violation Commented by Munisekhar
//String shortdesc="";
//String specialitycode="";
PreparedStatement pstmt1=null;
String b_loc1_value= "";
String b_loc1_name = "";
String visit_limit_rule = request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
%>
<%
try{
		con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;
		 //stmtlen   = con.createStatement() ;
		 //stmt1 = con.createStatement();
		 //stmt5 = con.createStatement();
	
			
if(allow_inside){
		 tfr_appt_yn =request.getParameter("book_appt_yn"); 
			 if(tfr_appt_yn.equals("") ) tfr_appt_yn="N";

		if(tfr_appt_yn.equals("N")){%>
			<script>alert(getMessage('SCH_NOT_ALLOW','OA'));
		parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp';
			</script>
<%}
	/*
	int pat_id_len=0;

	rslen=stmtlen.executeQuery("Select Patient_Id_Length,Nat_Id_Length,alt_id1_length, pat_name_as_multipart_yn,to_char(sysdate,'dd/mm/yyyy') sys_date from mp_param");
	
	if( rslen !=null && rslen.next())
	{
	
	 pat_id_len=rslen.getInt("Patient_Id_Length");
	sys_date=rslen.getString("sys_date");
	pat_name_as_multipart_yn = rslen.getString("pat_name_as_multipart_yn");
	}

	if (pat_name_as_multipart_yn.equals("N"))
	{
		pat_name_length = "60";
	}
	else
	{
		pat_name_length = "40";
	}
	*/
	/*
	String sql_oa_param="select visit_limit_rule from oa_param where module_id='OA'";
	rs2=stmt.executeQuery(sql_oa_param);
	if(rs2 !=null && rs2.next())
	{
		visit_limit_rule=rs2.getString("visit_limit_rule");
		if(visit_limit_rule ==null) visit_limit_rule="N";
	}
	*/
%>

</head>
<body onload= 'Disable_loctype()' OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' >
<form name="bulktransferapptcriteria" id="bulktransferapptcriteria">
<table width='100%' cellspacing='0' cellpadding='2' border='0'>




<tr>
		<td  class=LABELCENTER colspan='2'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>

		<td  class=LABELCENTER colspan='2'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		

</tr>
<!--added on 04/06/2010-->
<%
	String sql1="";	
	sql1= "select short_desc, speciality_code from am_speciality_lang_vw where eff_status='E' and speciality_code  in (select speciality_code FROM op_clinic a, am_locn_for_oper_stn b where a.facility_id='"+fac_id+"' and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E') and language_id='"+locale+"' order by short_desc";
//	sql1= "select short_desc, speciality_code from am_speciality_lang_vw where eff_status='E' and speciality_code  in (select speciality_code FROM op_clinic a, am_locn_for_oper_stn b where a.facility_id=? and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=? and b.eff_status='E') and language_id=? order by short_desc";
	StringBuffer sb=new StringBuffer();
	
	//PreparedStatement pstmt1=null;
	pstmt1=con.prepareStatement(sql1);
	//pstmt1.setString(1,fac_id);
	//pstmt1.setString(2,oper_stn_id);
	//pstmt1.setString(3,locale);
	rs5=pstmt1.executeQuery(sql1);
while(rs5.next()) 
	{
	
	sb.append("<option value='"+rs5.getString("speciality_code")+"'>"+rs5.getString("short_desc")+"</option>");

    } 
//CheckStyle correction added by Munisekhar
//if(rs5!=null) rs5.close();
	%>

<tr>
			<td  class='label' width='23%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>

			<td  class=fields nowrap >
					<select name='speciality_from' id='speciality_from' onchange='enable_fromloc(this); populatepract_from_Spty(this);' tabindex=0><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
				<%
						out.println(sb.toString());
				
				//if(rs_spec !=null) rs_spec.close();
				%>
					</select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>


					<td  class='label' width='23%'>&nbsp;</td>

			<td  class=fields nowrap >
					<select name='speciality_to' id='speciality_to' onchange='populatepract_to_Spty(this); clearvalue(this);' tabindex=0><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
				   <%
				   out.println(sb.toString());
                   if((sb != null) && (sb.length() > 0))
		            {
			        sb.delete(0,sb.length());
		            }
				   %>
					</select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>

</tr>

<tr>
		

	<td nowrap class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

	<td class='fields'>
			<select name='b_loc1' id='b_loc1' onchange="clear_locations(this); populatepract_from(this);  populatepract_to(this);"  nowrap>
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>

				<%
				rs5=stmt.executeQuery("select locn_type, short_desc, CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id = '"+locale+"' order by short_desc");
				while(rs5.next()) {

					 b_loc1_value= rs5.getString("CARE_LOCN_TYPE_IND");
					 b_loc1_name = rs5.getString("short_desc");
				%>
					<option value='<%=b_loc1_value%>'><%=b_loc1_name%>
				<%}%>		
			</select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>

			<td  class=label nowrap >&nbsp;</td>
			
			<td class='fields'>
			<select name='b_loc2' id='b_loc2' onchange='clear_locations(this);'  nowrap>
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>

						
			</select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>

</tr>

<tr>
	<td nowrap class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

	<td class='fields'><!--<select name='from_locn' id='from_locn' onChange = 'enablepract_from(this)' >
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------->
	<input type='text' size='25' maxlength='25' name='b_loc_val_from' id='b_loc_val_from' value='' onblur="ena_loc_lookup_from(this);"><input type="hidden" name="from_locn" id="from_locn" ><input type='button' name="b_loc_search_from" id="b_loc_search_from" value="?" onClick="open_loc_lookup_from();" class='button'></select><img src="../../eCommon/images/mandatory.gif" align='center'></img>		
	</td>

	<td nowrap class=label >&nbsp;</td>

	<td class='fields'><!--<select name='to_locn' id='to_locn' onChange = 'enablepract_to(this)' >
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----->
	<input type='text' size='25' maxlength='25' name='b_loc_val_to' id='b_loc_val_to' value='' onblur="ena_loc_lookup_to(this);">
	<input type="hidden" name="to_locn" id="to_locn" >
	<input type='button' name="b_loc_search_to" id="b_loc_search_to" value="?" onClick="open_loc_lookup_to();" class='button'>
	</select><img src="../../eCommon/images/mandatory.gif" align='center'></img>		
	</td>

</tr>		
<tr>	

		<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "bulk" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>

		
</tr>

<tr>
		<td  nowrap class=label ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
<input type='hidden' name='Sys_date' id='Sys_date' value='<%=currentdate%>'>

		<td  class=fields nowrap>
		<input type='text'  name='b_from_date' id='b_from_date' size='8' maxlength='10' Onblur="ValidateDate1(this);DateCompare_from1('from',this,'<%=currentdate%>');"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_from_date.select();return showCalendar('b_from_date');" tabindex=-1><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>

		<td  nowrap class=label >&nbsp;</td>

		<td  class=fields nowrap><input type='text'  name='b_to_date' id='b_to_date' size='8' maxlength='10' Onblur="ValidateDate1(this);DateCompare_from1('to',this,'<%=currentdate%>');"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_to_date.select();return showCalendar('b_to_date');" tabindex=-1><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</tr>

<tr>
	<td  class='label'nowrap width='23%'><fmt:message key="Common.ReasonforRevision.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<input type='text' name='reason_for_revision' id='reason_for_revision' value='' onblur='if(this.value !="") reasonlookup_revise();' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup_revise();' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img>
		<input type='hidden' name='reason_code_revision' id='reason_code_revision' value=''>
	</td>
			
			<td class='button' colspan='2'><input type="button" class='button' name="select" id="select" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='callResult();'>
	<input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='clearResult();'></td>
</tr>
				
				
	       
</table>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'></input>
<input type='hidden' name='oper_stn' id='oper_stn' value='<%=oper_stn_id%>'>
<input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='time_table_type' id='time_table_type' value=''>
<input type='hidden' name='max_from_slot' id='max_from_slot' value=''>
<input type='hidden' name='max_to_slot' id='max_to_slot' value=''>
<input type='hidden' name='total_first_visit_slots_booked_from1' id='total_first_visit_slots_booked_from1' value=''>
<input type='hidden' name='total_other_visit_slots_booked_from1' id='total_other_visit_slots_booked_from1' value=''>
<input type='hidden' name='total_first_visit_slots_booked_to1' id='total_first_visit_slots_booked_to1' value=''>
<input type='hidden' name='total_other_visit_slots_booked_to1' id='total_other_visit_slots_booked_to1' value=''>
<input type='hidden' name='total_from_over_booked' id='total_from_over_booked' value=''>
<input type='hidden' name='total_to_over_booked' id='total_to_over_booked' value=''>
<input type='hidden' name='sec_values' id='sec_values' value=''>
<input type='hidden' name='prev_values' id='prev_values' value=''>
<input type='hidden' name='b_loc1_name' id='b_loc1_name' value='<%=b_loc1_name%>'>
<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>'>
<input type='hidden' name='max_first_visits_from' id='max_first_visits_from' value=''>
<input type='hidden' name='max_other_visits_from' id='max_other_visits_from' value=''>
<input type='hidden' name='is_group_location' id='is_group_location' id="is_group_location" value='N'>

</form>
<%
}   //CheckStyle correction added by Munisekhar
    if(pstmt1 !=null) pstmt1.close();
	if(stmt !=null) stmt.close();
	//if(rs2 !=null) rs2.close();
	if(rs5 !=null) rs5.close();
	if(rs_spec !=null) rs_spec.close();
	//if(stmt1 !=null) stmt1.close();
	//if(stmt5 !=null) stmt5.close();
	//if(rslen !=null) rslen.close();
	//if(stmtlen !=null) stmtlen.close();

}catch(Exception es){
	//out.println("Exception in querycriteria"+ es.toString());
	es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 

	ConnectionManager.returnConnection(con,request);
}		
%>
</body>
</html>

