<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
String facilityid	=(String)session.getValue("facility_id");
String IPval		= request.getParameter("IPval");
String fromServlet	= checkForNull(request.getParameter("fromServlet"));
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script Language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script Language='javascript' src='../../eCommon/js/dchk.js' ></script>
 
<script language ='javascript' src='../../eIP/js/PractInComplete.js'></script> 
<script language ='javascript' src='../../eIP/js/IPPractitionerComponent.js'></script> 
<script Language='javascript' src='../../eCommon/js/rowcolor.js' ></SCRIPT>
<script Language='javascript' src='../../eCommon/js/DateUtils.js' ></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection conn		= null;	
	Statement stmt		= null;
	ResultSet rs		= null;

    try
	{
		request.setCharacterEncoding("UTF-8");
        conn						= ConnectionManager.getConnection(request);	
		String P_patient_id			= checkForNull(request.getParameter("Patient_Id"));	
		String encounterid			= checkForNull(request.getParameter("Encounter_Id"));
		String P_practitioner_id	= checkForNull(request.getParameter("Practitioner_Id"));
		String P_specialtycode		= checkForNull(request.getParameter("specialtycode"));
		String P_practitioner_role	= checkForNull(request.getParameter("practitioner_role"));
		String Role_Start_Date		= checkForNull(request.getParameter("roleStartTime"));
		String Role_End_Date		= checkForNull(request.getParameter("roleEndTime"));
		String recd_srl_no			= checkForNull(request.getParameter("srl_no"));
		String P_role				= checkForNull(request.getParameter("role"));
		String P_Modval				= checkForNull(request.getParameter("Modval"));
		String locale			= (String)session.getAttribute("LOCALE");
	    String Role_End_Date_Converted	= "";
		
		if(!(Role_End_Date.equals("") || Role_End_Date == null))
					Role_End_Date_Converted = DateUtils.convertDate(Role_End_Date,"DMYHM","en",locale); 
	
		if(!P_role.equals(""))
			P_role = java.net.URLDecoder.decode(P_role);
		
		StringBuffer sqlQuery		= new StringBuffer();
		
		sqlQuery.append("SELECT a.srl_no, TO_CHAR(SYSDATE, 'dd/mm/rrrr hh24:mi') sdate, TO_CHAR(a.ROLE_START_TIME, 'dd/mm/rrrr hh24:mi') ROLE_START_TIME, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name,  a.remarks, AM_GET_DESC.AM_SPECIALITY(a.specialty_code, '"+locale+"','2') short_desc, b.NURSING_UNIT_CODE, to_char(b.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,AM_GET_DESC.AM_SPECIALITY('"+P_specialtycode+"', '"+locale+"','2')speciality_short_desc FROM pr_encounter_pract a, ip_open_encounter b WHERE a.operating_facility_id='"+facilityid+"' and a.encounter_id='"+encounterid+"' and a.practitioner_id='"+P_practitioner_id+"' and a.specialty_code='"+P_specialtycode+"' and a.srl_no='"+recd_srl_no+"' and a.PRACTITIONER_ROLE ='"+P_practitioner_role+"' and a.operating_facility_id= b.facility_id and a.encounter_id= b.encounter_id");
		

		String practitioner_name	= "";
		String nursing_unit_code	= "";
		String P_Remarks			= "";
		String systemDate			= "";
		String admission_date_time	= "";
		String srl_no				= "";
		String speciality_short_desc= "";

		stmt = conn.createStatement(); 
		rs   = stmt.executeQuery(sqlQuery.toString());
			
		if (rs.next())
		{
			practitioner_name	= checkForNull(rs.getString("practitioner_name"));
			P_Remarks			= checkForNull(rs.getString("remarks"));
			srl_no				= checkForNull(rs.getString("srl_no"));
			systemDate			= checkForNull(rs.getString("sdate"));
			admission_date_time	= checkForNull(rs.getString("admission_date_time"));
			nursing_unit_code	= checkForNull(rs.getString("NURSING_UNIT_CODE"));
			/*Friday, July 23, 2010 , added for 22878*/
			speciality_short_desc= checkForNull(rs.getString("speciality_short_desc"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		/* Merged with ip_open_encounter query for PE - 11/05/2010
		if (sqlQuery.length() > 0) sqlQuery.delete(0, sqlQuery.length());
		sqlQuery.append("Select NURSING_UNIT_CODE,  to_char(admission_date_time,'dd/mm/rrrr hh24:mi')admission_date_time, to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from ip_open_encounter where facility_id='"+facilityid+"'  and encounter_id='"+encounterid+"'");
		
		stmt=conn.createStatement();
		rs = stmt.executeQuery(sqlQuery.toString());
		
		if(rs.next())
		{
			systemDate			= checkForNull(rs.getString("sdate"));
			admission_date_time	= checkForNull(rs.getString("admission_date_time"));
			nursing_unit_code	= checkForNull(rs.getString("NURSING_UNIT_CODE"));
		}
		
		if(rs!=null)   rs.close();
		if(stmt!=null) stmt.close();
		*/
		String functionval="";
		String str1 = "";
		String str2 = "";
		if (sqlQuery.length() > 0) sqlQuery.delete(0, sqlQuery.length());
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="CompleteVisit_form" id="CompleteVisit_form" >
<center>
<br>

<table width='100%' border='0' cellspacing='0' cellpadding='0'>
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td class="label" >
	    <font class='label'><fmt:message key="Common.Role.label" bundle="${common_labels}"/>
	</td>
<%
	if (!(P_Modval.equals("")))
	{
		
	    if ((P_practitioner_role.equals("2"))||(P_practitioner_role.equals("3")))
	    {
	       if (P_practitioner_role.equals("2"))
	       {	       
%>	        <td colspan='4' class="fields"><input type='radio' name='practitioner_role1' id='practitioner_role1'  value='2'  onClick="chkVal(this)" checked disabled><font class='label'><fmt:message key="Common.consultant.label" bundle="${common_labels}"/>
		   <input type='radio' name='practitioner_role2' id='practitioner_role2'  value='3' onClick="chkVal2(this)"  disabled><font class='label'><fmt:message key="eIP.Assisting.label" bundle="${ip_labels}"/>
			   
	      
		   </td>
<%	       }	        

		   if (P_practitioner_role.equals("3"))
	       {
%>	        <td class="fields" colspan='4'>
		   <input type='radio' name='practitioner_role1' id='practitioner_role1'  value='2'  onClick="chkVal(this)" disabled><font class='label'><fmt:message key="Common.consultant.label" bundle="${common_labels}"/>
	    	   <input type='radio' name='practitioner_role2' id='practitioner_role2'  value='3' onClick="chkVal2(this)" checked disabled><font class='label'><fmt:message key="eIP.Assisting.label" bundle="${ip_labels}"/>
	        </td>
<%	       }
	    }
	    else if((P_practitioner_role.equals("1"))||(P_practitioner_role.equals("4")))
	    {    
%>	       <td class="fields" colspan='4'>
	  	   <input type='radio' name='practitioner_role1' id='practitioner_role1'  value='2'  onClick="chkVal(this)" disabled><font class='label'><fmt:message key="Common.consultant.label" bundle="${common_labels}"/>
	  	   <input type='radio' name='practitioner_role2' id='practitioner_role2'  value='3' onClick="chkVal2(this)" disabled><font class='label'><fmt:message key="eIP.Assisting.label" bundle="${ip_labels}"/>
	       </td>
<%
		out.println("<script> document.forms[0].practitioner_role1.checked=false;</script>");
	    }
      }
      else
      { 
	
%>		<td class="fields" colspan='4'>
		<input type='radio' name='practitioner_role1' id='practitioner_role1'  value='2'  onClick="chkVal(this)" checked><font class='label'><fmt:message key="Common.consultant.label" bundle="${common_labels}"/>
		<input type='radio' name='practitioner_role2' id='practitioner_role2'  value='3' onClick="chkVal2(this)"><font class='label'><fmt:message key="eIP.Assisting.label" bundle="${ip_labels}"/>
		</td>
<%	  }
%>

</tr>
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
	<td class="label" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td>
<%	if (!(P_Modval.equals("")))
  	{	functionval="modify";
  		out.println("<input type='text' size='30' maxlength='30' value=\""+practitioner_name+"\" name='practitioner_name' id='practitioner_name' readonly>")	;
  		out.println("<input type='hidden' value=\""+P_practitioner_id+"\" name='practitioner_id' id='practitioner_id'>")	;
  	}
  	else
  	{
  		if(IPval.equals("ip"))
			out.println("<input type='text' name='practid_desc' id='practid_desc' value='' size='30' maxlength='30' onChange='getPractID();' ><input type='hidden' name='practitioner_id' id='practitioner_id' value='' size='15' maxlength='15' ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick='getPractID();'>");
  		else 		
  		functionval="insert";
%><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
<%	}	%>

<%	
    	/** IN MODIFY MODE **/	
    if (!(P_Modval.equals("")))
	{
%>
	 <td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	 <td class="fields">
<%
  	 /**** ADDED ON 27 MAY 2001 TO MAKE THE SPECIALITY VALUE A TEXT ITEM ****/ 
  	 /** PRACTITIONER IS ASSISTING TYPE**/


	  if (P_practitioner_role.equals("3"))
	  {	  
		   String practitionerid = checkForNull(request.getParameter("Practitioner_Id"));
		   out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			/*Friday, July 23, 2010 , commented for 22878*/
			/*
			 stmt = conn.createStatement() ;
			StringBuffer sql2 = new StringBuffer();
			
			sql2.append("Select speciality_code,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE, '"+locale+"','2') speciality_short_desc  from AM_PRACT_SPECIALITIES where facility_id ='"+facilityid+"' and practitioner_id='"+practitionerid+"' union  Select primary_speciality_code speciality_code, AM_GET_DESC.AM_SPECIALITY(primary_speciality_code, '"+locale+"','2') speciality_short_desc from AM_PRACT_FOR_FACILITY_VW where operating_facility_id ='"+facilityid+"' and practitioner_id='"+practitionerid+"' order by 2");
			
			rs = stmt.executeQuery(sql2.toString()) ;
			
			if( rs != null )
			 {
				while(rs.next())
				{ 
					//str1 = rs.getString( "specialty_code" ) ;
					str1 = rs.getString( "speciality_code" ) ;
					if (str1==null) str1="";
					
					//str2 = rs.getString( "short_desc" );
					str2 = rs.getString( "speciality_short_desc" );
					
					if (str2==null) str2="";
				}
			}	
				if(rs!=null)   rs.close();
				if(stmt!=null) stmt.close();
		    if (sql2.length() > 0) sql2.delete(0, sql2.length());
					
			functionval="modify";
			out.println("<input type='text' maxsize='15' value=\""+str2+"\" name='spec_code' id='spec_code' readonly>")	;
			out.println("<input type='hidden' value=\""+str1+"\" name='speciality_code' id='speciality_code'>")	;
			*/
			/*Friday, July 23, 2010 , added for 22878*/
			functionval="modify";
			out.println("<input type='text' maxsize='15' value=\""+speciality_short_desc+"\" name='spec_code' id='spec_code' readonly>")	;
			out.println("<input type='hidden' value=\""+P_specialtycode+"\" name='speciality_code' id='speciality_code'>")	;
		}
		else
		{
	
	   /***PRACT IS OF TYPE CONSULTING OR ATTENDING***/

		   String practitionerid = request.getParameter("Practitioner_Id");
		   if (practitionerid==null) practitionerid="";
		   out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");

		   stmt = conn.createStatement() ;
		   if (sqlQuery.length() > 0) sqlQuery.delete(0, sqlQuery.length());
		   sqlQuery.append("Select speciality_code,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE, '"+locale+"','2') speciality_short_desc  from AM_PRACT_FOR_SPECIALITY_VW where facility_id ='"+facilityid+"' and ");
		   
		   sqlQuery.append(" practitioner_id='"+practitionerid+"' union  Select a.primary_speciality_code speciality_code, b.short_desc speciality_short_desc ");
		   sqlQuery.append(" from AM_PRACT_FOR_FACILITY_VW a,am_speciality_lang_vw b where b.speciality_code = a.primary_speciality_code and a.operating_facility_id ");
		   sqlQuery.append(" ='"+facilityid+"' and a.practitioner_id='"+practitionerid+"' AND b.language_id='"+locale+"' order by 2 ");
			
			rs = stmt.executeQuery(sqlQuery.toString()) ;
		 
		   if( rs != null )
		   {%>
             
			<select name='speciality_code' id='speciality_code' ><option value='' > ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
			<%String sel="";
			while( rs.next() )
			{ 
				str1 = checkForNull(rs.getString( "speciality_code" ));
				str2 = checkForNull(rs.getString( "speciality_short_desc" ));
				if(str1.equals(P_specialtycode))
				{	sel="selected";
					out.println("<option value=\""+str1+"\" "+sel+">"+str2+"</option>");
				}
				else
					out.println("<option value=\""+str1+"\">"+str2+"</option>");

			}
			out.print("</select>");
			}	
				if(rs!=null)	 rs.close();
				if(stmt!=null)   stmt.close();
			    if (sqlQuery.length() > 0) sqlQuery.delete(0, sqlQuery.length());

	  }
		 %>
		 <img src='../../eCommon/images/mandatory.gif'align='center'></img>
		  
		  </td>
		  <%
	}
	else
	{	%>
		<td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class="fields"><select name='speciality_code' id='speciality_code' ><option value='' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</select><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	<%
		}	%>
        </td>
	<!-- Added By Sridhar R on 1 July 2004 -->
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<td class="label"  nowrap><fmt:message key="eIP.RoleStartDate.label" bundle="${ip_labels}"/></td>
		<td nowrap class='QUERYDATA' ><input type="text" id='roleStartDate' name="role_Start_Date" id="role_Start_Date" maxlength=16 size=16 value='' onblur="validateStartDate(this,'<%=systemDate%>');" ><img id="startCalObj" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].role_Start_Date.focus();return showCalendar('roleStartDate',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif'align='center' id='mandGIF'></img></td>
		<td class="label"  nowrap><fmt:message key="eIP.RoleEndDate.label" bundle="${ip_labels}"/></td><td  nowrap class="fields"><input type="text"  id="roleEndDate" name="role_End_Date"  maxlength=16 size=16 value="<%=Role_End_Date_Converted%>" onblur="validateEndDate(this,'<%=systemDate%>');"><img id="endCalObj" src="../../eCommon/images/CommonCalendar.gif" onclick="if (document.getElementById('roleEndDate').disabled) return false; document.forms[0].role_End_Date.focus(); return showCalendar('roleEndDate', null, 'hh:mm');"></td>
	</tr>
	<tr><td colspan='4'><br></td></tr>
	<tr>
		<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<%
		if (!(P_Modval.equals("")))
		 {	%>
			<td class='fields' colspan='4'>
			<textarea name='Remarks' rows=3 cols='60' style="resize:none;" onkeypress="checkMaxLimit1(this,200)" onBlur='makeValidString(this);chklim(this,200)'><%=P_Remarks%></textarea>
			</td>
	<%	}
		 else
		{	%>
			<td class='fields' colspan='4'>
			<textarea name='Remarks' rows=3 cols='60' style="resize:none;" onkeypress="checkMaxLimit1(this,200)" onblur = "makeValidString(this);chklim(this,200)"></textarea>
			</td>
	<%	}	%>

	</tr>
	<tr><td colspan='4'class='label'>&nbsp;</td></tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
	<tr><td colspan='4' class='label'>&nbsp;</td></tr>
   
</table>
<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'>
<input type='hidden' name='P_patient_id' id='P_patient_id' value='<%=P_patient_id%>'>
<input type='hidden' name='encounterid' id='encounterid' value='<%=encounterid%>'>
<input type='hidden' name='practitioner_role3' id='practitioner_role3' value='<%=P_practitioner_role%>'>
<input type='hidden' name='functionval' id='functionval' value='<%=functionval%>'>
<input type='hidden' name='functionmod' id='functionmod' value='<%=P_Modval%>'>
<input type='hidden' name='Modval' id='Modval' value='<%=P_Modval%>'>
<input type='hidden' name='fromServlet' id='fromServlet' value='<%=fromServlet%>'>
<input type='hidden' name='hdd_admn_time' id='hdd_admn_time' value='<%=admission_date_time%>'>
<input type='hidden' name='hdd_sys_date' id='hdd_sys_date' value='<%=systemDate%>'>
<input type='hidden' name='hdd_Role_Start_Date' id='hdd_Role_Start_Date' value='<%=Role_Start_Date%>'>
<input type='hidden' name='hdd_srl_no' id='hdd_srl_no' value='<%=srl_no%>'>
<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>'>
	<input type='hidden' name='locale1' id='locale1' value='<%=locale%>'>
	
<script>
	if('<%=P_Modval%>'!="modify")
		loadChkVal()

	disFields('<%=P_Modval%>')
</script>
<%	
	if (rs!=null) rs.close();
	if (stmt!=null) stmt.close();
}catch(Exception e){
	//out.println(e);
	e.printStackTrace();}
finally
{
		ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

