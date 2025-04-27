<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<style>
	.container {
		width:1330px;
	}
	.container table {
		width: 1330px;
		table-layout: fixed;
	}
	.inner_table_site { 
		width:100%;  
		height:450px;
		overflow-y: auto;	
	} 	
</style>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >
<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue	
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" );
	String function_id="";
	function_id = request.getParameter("function_id");
	if ( (function_id == null || function_id.equals(""))) function_id="";
	//String sqlstr="";
	String sqlstr1="";
	Connection conn = null;
	java.sql.Statement stmt = null;
	ResultSet rs = null;
	
	//Below line added for this CRF ML-MMOH-CRF-0862
	 boolean isCernerpractitioner = false; 

	boolean isFPPPractApplicable = false;//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
	
	try{

	String sql = "where a.pract_type = b.pract_type";
	if ( (whereClause == null || whereClause.equals("")) )
	{

	String cd = request.getParameter("practitioner_id");
	String ccd = request.getParameter("pract_type");
	if(ccd.equals("All")) ccd ="";
	String practitionername = request.getParameter("practitioner_name");
	String enabled = request.getParameter("eff_status");
	String primary_speciality_code = request.getParameter("primary_speciality_code");
	String primary_speciality_desc = request.getParameter("primary_speciality_desc");
	String Employee_Id = request.getParameter("Employee_Id");
	String job_title = request.getParameter("POSITION_CODE");
	String empl_status = request.getParameter("empl_status");
	String all_facilities_yn = request.getParameter("all_facilities_yn");
	String reporting_facility_id = request.getParameter("reporting_facility_id");
	String NATIONAL_ID_NUM = request.getParameter("National_ID");
	String OTH_ALT_ID_NO = request.getParameter("OTHER_ALT_NO");
	String fppPractYn = checkForNull(request.getParameter("FPP_Pract"));//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184

	if ( !(cd == null || cd.equals("")) )
		{
		cd=cd.toUpperCase();
		sql=sql+" and upper(a.practitioner_id) like upper('"+cd+"%')";

		}
	if ( !(ccd == null || ccd.equals("")) )
	{
		sql=sql+" and a.pract_type like  '"+ccd+"%'" ;

	}
	if ( !(job_title == null || job_title.equals("")) )
	{
			sql=sql+" and upper(a.POSITION_CODE)  like  upper('"+job_title+"%') " ;
	}

	if ( !(empl_status == null || empl_status.equals("")) )
	{
			sql=sql+" and upper(a.empl_status)  like  upper('"+empl_status+"%') " ;
	}

	if ( !(all_facilities_yn == null || all_facilities_yn.equals("")) )
	{
			sql=sql+" and upper(a.all_facilities_yn)  like  upper('"+all_facilities_yn+"%') " ;
	}

	if ( !(reporting_facility_id == null || reporting_facility_id.equals("")) )
	{
			sql=sql+" and upper(a.reporting_facility_id)  like  upper('"+reporting_facility_id+"%') " ;
	}

	if ( !(practitionername == null || practitionername.equals("")) )
	{

			sql=sql+" and upper(a.practitioner_name)  like  upper('"+practitionername+"%') " ;

	}
	
	if ( !(primary_speciality_code == null || primary_speciality_code.equals("")) )
	{

			sql=sql+" and c.SPECIALITY_CODE like  '"+primary_speciality_code.toUpperCase()+"%' and c.SPECIALITY_CODE = a.PRIMARY_SPECIALITY_CODE " ;

	}

	if ( !(primary_speciality_desc == null || primary_speciality_desc.equals("")) )
	{

			sql=sql+" and upper(c.long_desc)   like  upper('"+primary_speciality_desc+"%') " ;

	}

	if ( !(Employee_Id == null || Employee_Id.equals("")) )
	{

			sql=sql+" and upper(a.EMPLOYEE_ID)   like  upper('"+Employee_Id+"%') " ;

	}


	if ( !(enabled == null || enabled.equals("")) )
	{
	     if( enabled.equals("E") )
	     {
	          sql=sql+" and a.eff_status='E'";
	     }
	     if ( enabled.equals("D") )
	     {
	          sql=sql+" and a.eff_status='D'";
	     }
	     if ( enabled.equals("B") )
	     {
	     }
	}

	/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
	if (!(fppPractYn == null || fppPractYn.equals("")))
	{
	     if(fppPractYn.equals("Y"))
	          sql=sql+" and a.fpp_pract_yn='Y'";
	     else if(fppPractYn.equals("N"))
	          sql=sql+" and a.fpp_pract_yn='N'";
	}
	/*End*/
	
	/*Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020*/
		if ( !(NATIONAL_ID_NUM == null || NATIONAL_ID_NUM.equals("")) )
		{
		NATIONAL_ID_NUM=NATIONAL_ID_NUM.toUpperCase();
		sql=sql+" and upper(a.NATIONAL_ID_NUM) like upper('"+NATIONAL_ID_NUM+"%')";

		}

		if ( !(OTH_ALT_ID_NO == null || OTH_ALT_ID_NO.equals("")) )
		{
		OTH_ALT_ID_NO=OTH_ALT_ID_NO.toUpperCase();
		sql=sql+" and upper(a.OTH_ALT_ID_NO) like upper('"+OTH_ALT_ID_NO+"%')";

		}
	/*End for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020*/

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql=sql+" and a.primary_speciality_code = c.speciality_code order by ";
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql=sql+ord[i];
		else
			sql=sql+ord[i]+",";
		}
	}
	} //end of where clause IF
	else
		sql = whereClause;

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	conn = ConnectionManager.getConnection(request);
	
	//Below line added for this CRF ML-MMOH-CRF-0862
    //String fullname_width="";
    String full_short_width="";	
	String migid_other_width="";
	String full_short_wordwrap="";	
	String migid_other_wordwrap="";
	String migid_practid="";
	String migid_practid_wordwrap="";
	
	String pract_id="";
	String pract_id_wordwrap="";
	String migration_pract_id="";
	String migration_pract_id_wordwrap="";
	String full_name="";
	String full_name_wordwrap="";
    String short_name="";
	String short_name_wordwrap="";
    String pract_type="";
	String pract_type_wordwrap="";
    String specialty_code="";
	String specialty_code_wordwrap="";
    String speciality_desc="";
	String speciality_desc_wordwrap="";
    String pract_enabled="";
	String pract_enabled_wordwrap="";
	
	String tab_width="100%";
	isCernerpractitioner=CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
	if(isCernerpractitioner){
	 /*tab_width="1296px";
	 full_short_width="192px";	
	 migid_other_width="144px";
	 full_short_wordwrap="word-wrap: break-word;width:190px";	
	 migid_other_wordwrap="word-wrap: break-word;width:144px";
     migid_practid="232px";
	 migid_practid_wordwrap="word-wrap: break-word;width:232px"; 
	 */
	 
	
	/*tab_width="1260px";
	 
	 pract_id="120px";
	 pract_id_wordwrap="word-wrap: break-word;width:120px";
	 migration_pract_id="200px";
	 migration_pract_id_wordwrap="word-wrap: break-word;width:200px";
	 full_name="150px";
	 full_name_wordwrap="word-wrap: break-word;width:150px";
    // short_name="260px";
	 //short_name_wordwrap="word-wrap: break-word;width:260px";
	 short_name="255px";
	 short_name_wordwrap="word-wrap: break-word;width:255px";
     pract_type="120px";
	 pract_type_wordwrap="word-wrap: break-word;width:120px";
     specialty_code="120px";
	 specialty_code_wordwrap="word-wrap: break-word;width:120px";
     speciality_desc="150px";
	 speciality_desc_wordwrap="word-wrap: break-word;width:150px";
     pract_enabled="120px";
	 pract_enabled_wordwrap="word-wrap: break-word;width:120px";*/
	 
	 //Above lines commented and below lines added on 9th July 2018 by Thamizh selvi against ML-MMOH-CRF-1184
	 pract_id_wordwrap="word-wrap: break-word;";
	 migration_pract_id="15%";
	 migration_pract_id_wordwrap="word-wrap: break-word;width:15%";
	 full_name_wordwrap="word-wrap: break-word;";
	 short_name_wordwrap="word-wrap: break-word;";
	 pract_type_wordwrap="word-wrap: break-word;";
	 specialty_code_wordwrap="word-wrap: break-word;";
	 speciality_desc_wordwrap="word-wrap: break-word;";
	 pract_enabled_wordwrap="word-wrap: break-word;";
	 //End
     
 	 
	}	
	//End ML-MMOH-CRF-0862

	int maxRecord = 0;

	isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","FULL_PAYING_PATIENT_PRACT");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
      
if(function_id.equals("PRACTITIONER"))
		{
	 sqlstr1="select a.practitioner_id, a.practitioner_name,a.short_name, a.pract_type, b.desc_sysdef,b.DESC_USERDEF, a.eff_date_from, a.eff_date_to, a.eff_status,a.EMPLOYEE_ID,c.SPECIALITY_CODE,c.long_desc, a.practitioner_long_id practitioner_long_id, a.fpp_pract_yn from am_practitioner a, am_pract_type b ,am_speciality c   "+ sql +"  ";//Modified by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
		} else
		{
			if(function_id.equals("EXT_PRACT"))
			{
				sqlstr1="select a.practitioner_id, a.practitioner_name,a.short_name, a.pract_type, b.desc_sysdef,b.DESC_USERDEF, a.eff_date_from, a.eff_date_to, a.eff_status,a.EMPLOYEE_ID,c.SPECIALITY_CODE,c.long_desc, a.practitioner_long_id practitioner_long_id, a.fpp_pract_yn  from am_ext_practitioner a, am_pract_type b ,am_speciality c   "+ sql +"  ";//Modified by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
			}
		}
        stmt = conn.createStatement();
	
		rs = stmt.executeQuery(sqlstr1); 

		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ )
			  rs.next() ;

		while( i<=end && rs.next()  )
		{ 
		   boolean isSiteSpecific=eOP.QMSInterface.isSiteSpecific(conn,"AM","AM_PRACT_EMP"); //Added by N Munisekhar for MMS-QH-CRF-0104 [IN:039242]
			if(maxRecord==0)
			{
%>

		<p>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/PractitionerQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&function_id="+function_id+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/PractitionerQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&function_id="+function_id+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>
		
		</tr>
		</table>
		</p>
<br><br>
		<!--Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1184 Start-->
		<%
		if(isCernerpractitioner){
		%>	
			<table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>
			<tr>
			<td colspan=4 class=label height=5>	
			<div class="container">
		<% }%><!--End-->
		<table border="1" width="<%=tab_width%>" cellspacing='0' cellpadding='0'>
		<th width="<%=pract_id%>" ><%if(isCernerpractitioner){%><fmt:message key="Common.EmId.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/><%}%></<th>
		<%if(isCernerpractitioner){%>
		<th width="<%=migration_pract_id%>"><fmt:message key="Common.CernerId.label" bundle="${common_labels}"/>&nbsp;</<th>
		<%}%>		
		<th width="<%=full_name%>"><fmt:message key="Common.FullName.label" bundle="${common_labels}"/></th>
		<th width="<%=short_name%>"><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></th>
		<th width="<%=pract_type%>"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
		<th width="<%=specialty_code%>"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width="<%=speciality_desc%>"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<!--Added by N Munisekhar on 25-July-2013 against MMS-QH-CRF-0104 [IN:039242] -->
		<% if (isSiteSpecific){ %>
		<th width=""><fmt:message key="Common.EmployeeID.label" bundle="${common_labels}"/></th>
		<%} %>
		<!--Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start-->
		<% if(isFPPPractApplicable){ %>
			<th width="<%=pract_enabled%>"><fmt:message key="Common.FPP.label" bundle="${common_labels}"/></th>
		<% } %>
		<!--End-->
		<th width="<%=pract_enabled%>"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<%if(function_id.equals("")){
			%>
        <th width=""><fmt:message key="Common.ExternalPractitioner.label" bundle="${common_labels}"/></th>
		<% }
		  //Below line added for this CRF ML-MMOH-CRF-0862
		  if(isCernerpractitioner){
		%>		
		</table>
		  <div class="inner_table_site">
		  <table class="head" width="<%=tab_width%>"  border="1" cellpadding="0" cellspacing="0">	
		
		<% }//End this  CRF ML-MMOH-CRF-0862
		
		}
			
			  String classValue = "" ;
			  
			if ( i % 2 == 0 )
					classValue = "QRYEVENSCROLL" ;
				  else
					classValue = "QRYODDSCROLL" ;
				  

			out.println("<tr><td align='left' class='" + classValue + "' width ='"+pract_id+"' style='"+pract_id_wordwrap+"' >");
			String code = rs.getString(1);
			out.println("<a href='../../eAM/jsp/PractitionerMain.jsp?practitioner_id="+ code + "&mode12=update&function_id="+function_id+"'>");
				out.println(code+"</a></td><td class='" + classValue + "' width ='"+migration_pract_id+"' style='"+migration_pract_id_wordwrap+"'>");
            //Below line added for this CRF ML-MMOH-CRF-0862
            if(isCernerpractitioner){ 
              String cerner_pract_id = rs.getString("practitioner_long_id")==null?"&nbsp;":rs.getString("practitioner_long_id"); 			
			  out.println("<a href='../../eAM/jsp/PractitionerMain.jsp?practitioner_id="+ code + "&mode12=update&function_id="+function_id+"'>");
			  out.println(cerner_pract_id+"</a></td><td class='" + classValue + "' width ='"+full_name+"' style='"+full_name_wordwrap+"'>");
			}
            //End this CRF ML-MMOH-CRF-0862	
			
			out.println( rs.getString(2) );
			out.println("</td><td class='" + classValue + "' width ='"+short_name+"' style='"+short_name_wordwrap+"'>");
			out.println(rs.getString("short_name"));
			out.println("</td><td class='" + classValue + "' width ='"+pract_type+"' style='"+pract_type_wordwrap+"'>");
			out.println(rs.getString("DESC_USERDEF") );
			out.println("</td><td class='" + classValue + "' width ='"+specialty_code+"' style='"+specialty_code_wordwrap+"'>");
			out.println(rs.getString("SPECIALITY_CODE"));
			out.println("</td><td class='" + classValue + "' width ='"+speciality_desc+"' style='"+speciality_desc_wordwrap+"'>");
			out.println(rs.getString("long_desc"));
			//Added by N Munisekhar on 25-July-2013 against MMS-QH-CRF-0104 [IN:039242] 
            if (isSiteSpecific){ 
			out.println("</td><td class='" + classValue + "'><table border='1'><td></td></table>");
			out.println((rs.getString("EMPLOYEE_ID") == null)?"":rs.getString("EMPLOYEE_ID"));
			}
			/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
			if(isFPPPractApplicable){
				out.println("</td><td align='center' class='" + classValue + "' width ='"+pract_enabled+"' style='"+pract_enabled_wordwrap+"'>");
				if (rs.getString("fpp_pract_yn").equals("Y"))
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			}
			/*End*/
			out.println("</td><td align='center' class='" + classValue + "' width ='"+pract_enabled+"' style='"+pract_enabled_wordwrap+"'>");
			if ( rs.getString("eff_status").equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			i++;
			maxRecord++;
		} // end of while

		if(maxRecord == 0)
		{ %>
			 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<% }

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<%
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

		 if (rs != null)   rs.close();
		 if (stmt != null) stmt.close();
	} // end of try
		catch(Exception e) {
			
			out.println(e.toString());
			e.printStackTrace();
			}

		finally {
		  if (stmt != null) stmt.close();
		  if (rs != null)   rs.close();
		  	ConnectionManager.returnConnection(conn,request);
		}

 //Below line added for this CRF ML-MMOH-CRF-0862
if(isCernerpractitioner){		
	%>
	</td></tr>
</table>
</div>
</div>
</td>
</tr>
</table>
<%}else{%>
</td></tr>
</table>
<%}%>
</center>

<br><center>

</center>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (("").equals(inputString)) || (("null").equals(inputString)) ) ? "" : inputString );
	}
%>

