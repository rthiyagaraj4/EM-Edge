<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 

<%-- Mandatory declarations end --%>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js' ></script>	
<!-- <script language='javascript' src='../../eCommon/js/messages.js' ></script -->
<script language='javascript' src='../../eRS/js/SearchStaff.js'></script>
<!-- <script language='javascript' src='../../eRS/js/RSMessages.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
String p_mode="";
String p_role_type="";
String p_pract_type="";
String p_primary_speciality_code="";
String p_staff_id="";
String p_staff_name="";
String p_gender="";
String p_age="";
String p_empl_status="";
String p_facility_id="";
String p_position_code="";
String p_skill_code="";
String p_license_code="";
String p_training_code="";
String SQL_RESULT="";
String[] record	= null;
String classValue = "";
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;

int start=0,end=0;
p_mode=request.getParameter("p_mode")== null ? "":request.getParameter("p_mode");
p_role_type=request.getParameter("p_role_type")== null ? "":request.getParameter("p_role_type");
p_pract_type=request.getParameter("p_pract_type")== null ? "":request.getParameter("p_pract_type");
p_primary_speciality_code=request.getParameter("p_primary_speciality_code")== null ? "":request.getParameter("p_primary_speciality_code");
p_staff_id=request.getParameter("p_staff_id")== null ? "":request.getParameter("p_staff_id");
p_staff_name=request.getParameter("p_staff_name")== null ? "":request.getParameter("p_staff_name");
p_gender=request.getParameter("p_gender")== null ? "":request.getParameter("p_gender");
p_age=request.getParameter("p_age")==null ? "":request.getParameter("p_age");
p_empl_status=request.getParameter("p_empl_status")== null ? "":request.getParameter("p_empl_status");
p_facility_id=request.getParameter("p_facility_id")==null ? "":request.getParameter("p_facility_id");
p_position_code=request.getParameter("p_position_code")== null ? "":request.getParameter("p_position_code");
p_skill_code=request.getParameter("p_skill_code")== null ? "":request.getParameter("p_skill_code");
p_license_code=request.getParameter("p_license_code")== null ? "":request.getParameter("p_license_code");
p_training_code=request.getParameter("p_training_code")== null ? "":request.getParameter("p_training_code");
//System.err.println("PARAMS==>"+request.getQueryString());
p_staff_id=p_staff_id+"%";
p_staff_name=p_staff_name+"%";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
ArrayList ExpiringData	= new ArrayList() ;
		

	//SQL_RESULT = "select '+' pract_dtl,b.desc_userdef pract_type_desc, a.PRACTITIONER_NAME, a.PRACTITIONER_ID, c.short_desc splty_desc,a.OFF_TEL_NUM||'-'||a.OFF_TEL_EXT off_tel_num, a.RES_TEL_NUM, a.MOBILE_NUM, a.pract_type, a.position_code from  am_practitioner a, am_pract_type b, am_speciality c where	a.practitioner_id like nvl(?,'%') and	a.practitioner_name like nvl(?,'%') and	a.pract_type = nvl(?,a.pract_type) and	a.primary_speciality_code = nvl(?,a.primary_speciality_code) and	a.gender = nvl(?,a.gender) and	to_number(to_char(sysdate,'yyyy'))-to_number(to_char(a.date_of_birth,'yyyy'))	>= nvl(?,0) and  a.empl_status = nvl(?,a.empl_status) and	nvl(a.reporting_facility_id,'x') = nvl(?,nvl(a.reporting_facility_id,'x')) and	b.pract_type = a.pract_type and	c.speciality_code = a.primary_speciality_code ";
	SQL_RESULT = "select '+' pract_dtl,b.desc_userdef pract_type_desc, a.PRACTITIONER_NAME, a.PRACTITIONER_ID, c.short_desc splty_desc,a.OFF_TEL_NUM||'-'||a.OFF_TEL_EXT off_tel_num, a.RES_TEL_NUM, a.MOBILE_NUM, a.pract_type, a.position_code from  am_practitioner_lang_vw a, am_pract_type_lang_vw b, am_speciality_lang_vw c where a.practitioner_id like nvl(?,'%') and a.practitioner_name like nvl(?,'%') and a.pract_type = nvl(?,a.pract_type) and a.primary_speciality_code = nvl(?,a.primary_speciality_code) and a.gender = nvl(?,a.gender) and to_number(to_char(sysdate,'yyyy'))-to_number(to_char(a.date_of_birth,'yyyy')) >= nvl(?,0) and  a.empl_status = nvl(?,a.empl_status) and nvl(a.reporting_facility_id,'x') = nvl(?,nvl(a.reporting_facility_id,'x')) and b.pract_type = a.pract_type and c.speciality_code = a.primary_speciality_code and a.language_id = ? and b.language_id = a.language_id and c.language_id = a.language_id ";

	if(!(p_skill_code.equals(""))) 
		SQL_RESULT =SQL_RESULT + " and exists (select staff_id from rs_Staff_skillset where role_type = '"+p_role_type+"' and staff_id like '"+p_staff_id+"' and skill_code = '"+p_skill_code+"') ";
	
	if(!(p_training_code.equals("")))
		SQL_RESULT = SQL_RESULT +" and exists(select staff_id from rs_staff_training where role_type =  '"+p_role_type+"' and staff_id like '"+p_staff_id+"' and training_code = '"+p_training_code+"')  ";

	if(!(p_license_code.equals("")))
		SQL_RESULT =SQL_RESULT + " and exists (select staff_id from rs_staff_licensure where role_type = '"+p_role_type+"' and staff_id like '"+p_staff_id+"' and license_code =  '"+p_license_code+"')";
	
    if(!(p_position_code.equals("")))
		SQL_RESULT =SQL_RESULT + " and exists(select staff_id from rs_staff_experience where role_type = '"+p_role_type+"' and staff_id like '"+p_staff_id+"' and position_code = '"+p_position_code+"') ";


	SQL_RESULT =SQL_RESULT + " order by b.desc_userdef, a.practitioner_name";
//System.err.println("SQL_RESULT==>"+SQL_RESULT);
	try {
		conn = ConnectionManager.getConnection();
		pstmt = conn.prepareStatement(SQL_RESULT);
		pstmt.setString(1,p_staff_id);
		pstmt.setString(2,p_staff_name);
		pstmt.setString(3,p_pract_type);
		pstmt.setString(4,p_primary_speciality_code);
		pstmt.setString(5,p_gender);
		pstmt.setString(6,p_age);
		pstmt.setString(7,p_empl_status);
		pstmt.setString(8,p_facility_id);
		pstmt.setString(9,locale);
//System.err.println("LOCALE ==>"+locale);

		rs = pstmt.executeQuery();
		while (rs != null && rs.next()) 
			{
				record = new String[10];				
				record[0] = rs.getString("pract_dtl");
				record[1] = rs.getString("pract_type_desc");
				record[2] = rs.getString("PRACTITIONER_NAME");
				record[3] = rs.getString("PRACTITIONER_ID");
				record[4] = rs.getString("splty_desc");
				record[5] = rs.getString("off_tel_num");
				record[6] = rs.getString("RES_TEL_NUM");
				record[7] = rs.getString("MOBILE_NUM");
				record[8] = rs.getString("pract_type");
				record[9] = rs.getString("position_code");
				ExpiringData.add(record) ;
			}
			if(pstmt != null)
				pstmt.close();
			if(rs != null)
				rs.close();
		} catch ( Exception e )	
			{
				e.printStackTrace();
				throw e ;
			} finally 
				{
					if(pstmt != null)
						pstmt.close();
					if(rs != null)
						rs.close();
					ConnectionManager.returnConnection(conn,request);
				}

int totalRecords=ExpiringData.size();
if(totalRecords == 0)
		{
			%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}
else{

%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=form_SearchStaffPractitioner>		
<%
 	int i=0;

	if ( from == null )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		{
		if(totalRecords<10)
	  		end = totalRecords-1 ;
		else 
			end=9;
		}
	else
		end = Integer.parseInt( to ) ;
	if ( start != 0 )
		 for( int j=0; j<start; i++,j++ )
		 {
			ExpiringData.get(j) ;
		 }
		 %>
		 <P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <=0) )
{
	out.println("<A HREF='SearchStaffPractitionerResult.jsp?p_pract_type="+p_pract_type+"&p_primary_speciality_code="+p_primary_speciality_code+"&p_gender="+p_gender+"&p_age="+p_age+"&p_empl_status="+p_empl_status+"&p_facility_id="+p_facility_id+"&from="+(start-10)+"&to="+(end-10)+"&p_mode="+p_mode+"'"+" text-decoration='none'>Previous</A>");
}
if ( !( (start+10) >= totalRecords ) )
{
	out.println("<A HREF='SearchStaffPractitionerResult.jsp?p_pract_type="+p_pract_type+"&p_primary_speciality_code="+p_primary_speciality_code+"&p_gender="+p_gender+"&p_age="+p_age+"&p_empl_status="+p_empl_status+"&p_facility_id="+p_facility_id+"&from="+(start+10)+"&to="+(end+10)+"&p_mode="+p_mode+"'"+" text-decoration='none'>Next</A>");
}
%>
</td></tr></table>
</p><p>		
<br><br>
<table border='1' cellpadding='0' cellspacing='0' align='center' width='140%' >			
<tr>
<th>+</th>
<th><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eRS.Specialty.label" bundle="${rs_labels}"/></th>
<th><fmt:message key="Common.office.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eRS.Tel.label" bundle="${rs_labels}"/></th>
<th><fmt:message key="Common.residence.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eRS.Tel.label" bundle="${rs_labels}"/></th>
<th><fmt:message key="eRS.Mobile.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.no.label" bundle="${common_labels}"/></th>
</tr>
<%
while ((ExpiringData.get(i)!=null) && i<=end)
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

String[] record1 = (String[])ExpiringData.get(i);
String d_pract_dtl=record1[0];
String d_staff_name=record1[2];
String d_staff_id=record1[3];
String d_splty_desc=record1[4];
String d_off_tel_num=record1[5];
String d_res_tel_num=record1[6];
String d_mobile_num=record1[7];
String d_pract_type=record1[8];
String d_position_code=record1[9]==null?"":record1[9];	
%>
					<tr>
						<td onclick='javascript:ProfileDetails("<%=i%>")' align='left' class=<%=classValue%>><a href='#'><%=d_pract_dtl%></a> 
					   	<input type='hidden' name='d_staff_id<%=i%>' id='d_staff_id<%=i%>' value='<%=d_staff_id%>'></td>
						<td align='left'  class=<%=classValue%>> <%=d_pract_type%></td>
						<%if(p_mode.equals("call"))
						{%>
						<td  align='left' width="230" class="<%=classValue%>" onmouseover="changeCursor(this);" onClick="Modify(this,<%=i%>);"><font class='HYPERLINK'><%=d_staff_name%></font></td>
						<%}else{%>
							<td  align='left' width="230" class="<%=classValue%>"><%=d_staff_name%></td>
						<%}%>
						<td align='left' class=<%=classValue%>> <%=d_staff_id%></td>
						<td align='left' width="110" class=<%=classValue%>> <%=d_splty_desc%></td>
						<td align='left' width="200" class=<%=classValue%>> <%=d_off_tel_num%></td>
						<%if(d_res_tel_num==null){%>
							<td align='left' class=<%=classValue%>>&nbsp;</td>
						<%}else{%>
						<td align='left' class=<%=classValue%>><%=d_res_tel_num%></td>
						<%}%>
						<%if(d_mobile_num==null){%>
							<td align='left' class=<%=classValue%>>&nbsp;</td>
						<%}else{%>
						<td align='left' class=<%=classValue%>><%=d_mobile_num%></td>
						<%}%>
						<input type='hidden' name='p_role_type<%=i%>' id='p_role_type<%=i%>' value='P'>
						<input type='hidden' name='p_staff_type<%=i%>' id='p_staff_type<%=i%>' value='<%=d_pract_type%>'>
						<input type='hidden' name='p_position_code<%=i%>' id='p_position_code<%=i%>' value='<%=d_position_code%>'>
					</tr>
		<%	
			i=i+1;	
						

						if(i>=totalRecords)break;
			}

}%>
</table>
</body>
</html>

