<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	25 Oct 2004
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language='javascript' src='../../eRS/js/StaffLicenseExpiry.js'></script>
<!-- <script language='javascript' src='../../eRS/js/RSMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
    String r_type="";
	String SQL_RESULT="";
	String role_type="";
	String staff_id = "";
	String staff_type="";
	String expiring_within="";
	String classValue = "";
	String[] record	= null;
	String flag = "";

	role_type = request.getParameter("role_type")== null ? "":request.getParameter("role_type");
	staff_type = request.getParameter("staff_type") == null ? "":request.getParameter("staff_type");
	staff_id = request.getParameter("staff_id") == null? "":request.getParameter("staff_id");
	expiring_within=request.getParameter("expiring_within")== null ? "":request.getParameter("expiring_within");
			
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList ExpiringData	= new ArrayList() ;
	
			
if(role_type.equals(""))
		flag = "BOTH";

if(role_type.equals("P") || flag.equals("BOTH"))
		{
		   //SQL_RESULT = "Select	a.role_type role_type, c.desc_userdef staff_type_desc, a.staff_id staff_id, b.short_name staff_name, a.license_id license_id, d.license_desc license_desc, to_char(a.issue_date,'dd/mm/yyyy') issue_date,to_char(a.valid_until,'dd/mm/yyyy') expiry_date from	rs_staff_licensure a, am_practitioner b, am_pract_type c, rs_licensure d where	a.role_type = 'P' and	a.staff_id = nvl('"+staff_id+"',a.staff_id) and	nvl(a.valid_until,to_date('31/12/2100','dd/mm/yyyy')) between trunc(sysdate) and (trunc(sysdate) + "+expiring_within+") and	b.pract_type = nvl('"+staff_type+"',b.pract_type) and	b.practitioner_id = a.staff_id and	c.pract_type = b.pract_type and	d.license_code = a.license_code";
		   SQL_RESULT = "select a.role_type role_type, c.desc_userdef staff_type_desc, a.staff_id staff_id, b.short_name staff_name, a.license_id license_id, d.license_desc license_desc, to_char(a.issue_date,'dd/mm/yyyy') issue_date,to_char(a.valid_until,'dd/mm/yyyy') expiry_date from rs_staff_licensure a, am_practitioner_lang_vw b, am_pract_type_lang_vw c, rs_licensure_lang_vw d where a.role_type = 'P' and a.staff_id = nvl('"+staff_id+"',a.staff_id) and nvl(a.valid_until,to_date('31/12/2100','dd/mm/yyyy')) between trunc(sysdate) and (trunc(sysdate) + "+expiring_within+") and b.pract_type = nvl('"+staff_type+"',b.pract_type) and b.practitioner_id = a.staff_id and c.pract_type = b.pract_type and d.license_code = a.license_code and b.language_id = ? and c.language_id = b.language_id and d.language_id = b.language_id";
		}
		

 if (flag.equals("BOTH"))
		{
	       SQL_RESULT = SQL_RESULT + " Union All ";
		}
		

 if(role_type.equals("O") || flag.equals("BOTH"))
		{
		   //SQL_RESULT=SQL_RESULT + "Select	a.role_type role_type, c.short_desc staff_type_desc, a.staff_id staff_id, b.short_name staff_name, a.license_id license_id, d.license_desc license_desc, to_char(a.issue_date,'dd/mm/yyyy') issue_date,to_char(a.valid_until,'dd/mm/yyyy') expiry_date from	rs_staff_licensure a, am_other_staff b, am_other_staff_type c, rs_licensure d where	a.role_type = 'O' and	a.staff_id = nvl('"+staff_id+"',a.staff_id) and	nvl(a.valid_until,to_date('31/12/2100','dd/mm/yyyy')) between trunc(sysdate) and (trunc(sysdate) + "+expiring_within+") and	b.other_staff_type = nvl('"+staff_type+"',b.other_staff_type) and	b.other_staff_id = a.staff_id and	c.other_staff_type = b.other_staff_type and	d.license_code = a.license_code";
		   SQL_RESULT=SQL_RESULT + "Select a.role_type role_type, c.short_desc staff_type_desc, a.staff_id staff_id, b.short_name staff_name, a.license_id license_id, d.license_desc license_desc, to_char(a.issue_date,'dd/mm/yyyy') issue_date,to_char(a.valid_until,'dd/mm/yyyy') expiry_date from rs_staff_licensure a, am_other_staff_lang_vw b, am_other_staff_type_lang_vw c, rs_licensure_lang_vw d where a.role_type = 'O' and a.staff_id = nvl('"+staff_id+"',a.staff_id) and nvl(a.valid_until,to_date('31/12/2100','dd/mm/yyyy')) between trunc(sysdate) and (trunc(sysdate) + "+expiring_within+") and b.other_staff_type = nvl('"+staff_type+"',b.other_staff_type) and b.other_staff_id = a.staff_id and c.other_staff_type = b.other_staff_type and d.license_code = a.license_code and b.language_id = '"+locale+"' and c.language_id = b.language_id and d.language_id = b.language_id";
		}

	SQL_RESULT = SQL_RESULT + " order by role_type,staff_type_desc";
	
	
	//out.println(SQL_RESULT);

	try {
			
		conn = ConnectionManager.getConnection();
		pstmt = conn.prepareStatement(SQL_RESULT);
		pstmt.setString(1,locale);
		
		rs = pstmt.executeQuery();	
		while (rs != null && rs.next()) 
			{
				record = new String[8];				
				record[0] = rs.getString("role_type");
				record[1] = rs.getString("staff_type_desc");
				record[2] = rs.getString("staff_id");
				record[3] = rs.getString("staff_name");
				record[4] = rs.getString("license_id");
				record[5] = rs.getString("license_desc");
				record[6] = rs.getString("issue_date");
				record[7] = rs.getString("expiry_date");
			
				ExpiringData.add(record) ;
				
			}
		} catch ( Exception e )	
			{
				e.printStackTrace() ;
				throw e ;
			} finally 
				{
					//conn.close();
					//rs.close() ;
					//pstmt.close() ;
					ConnectionManager.returnConnection(conn,request);
					if (pstmt != null) pstmt.close();
					if (rs != null) rs.close();
					ConnectionManager.returnConnection(conn,request);




				}
	
	int totalRecords=ExpiringData.size();
if(totalRecords == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); //location.href='../../eCommon/html/blank.html' </script>");
		}

%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<br>
		<table cellpadding=0 cellspacing=0 border=1 width="100%" >
			 <tr>
				<th><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></th>
				<th><fmt:message key="eRS.StaffId.label" bundle="${rs_labels}"/></th>
				<th><fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/></th>
				<th><fmt:message key="eRS.LicenseID.label" bundle="${rs_labels}"/></th>
				<th><fmt:message key="eRS.LicenseDescription.label" bundle="${rs_labels}"/></th>
				<th><fmt:message key="eRS.IssueDate.label" bundle="${rs_labels}"/></th>
				<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
			</tr>
			<%
			    
			   
				for( int i=0 ; i<totalRecords ; i++ )
					{
						if(i % 2 == 0)
							{
								classValue = "QRYEVEN";
							}
						else
							{
								classValue = "QRYODD";
							}
							
							String[] record1 = (String[])ExpiringData.get(i);
							String d_role_type=record1[0];
						    String d_staff_type_desc=record1[1];
							String d_staff_id=record1[2];
							String d_staff_name=record1[3];
							String d_license_id=record1[4];
							String d_license_desc=record1[5];
							String d_issue_date=record1[6];
							String d_expiry_date=record1[7];

							
					if(d_role_type.equalsIgnoreCase("P"))
							r_type="Practitioner";

					else
							r_type="Other Staff";
	
	
					out.println("<tr><td class='" + classValue + "' align='left'>"+r_type);
					out.println("<td class='" + classValue + "' align='left'>");
					out.println(d_staff_type_desc+"</td><td class='" + classValue + "' align='left'>");
					out.println(d_staff_id +"</td><td class='" + classValue + "' align='left'>");
					out.println(d_staff_name +"</td><td class='" + classValue + "' align='left'>");
					out.println(d_license_id+"</td><td class='" + classValue + "' align='left'>");
					out.println(d_license_desc+"</td><td class='" + classValue + "' align='left'>");
					out.println(com.ehis.util.DateUtils.convertDate(d_issue_date,"DMY","en",locale)+"</td><td class='" + classValue + "' align='left'>");
					out.println(com.ehis.util.DateUtils.convertDate(d_expiry_date,"DMY","en",locale)+"</td><td class='" + classValue + "' align='left'>");
					out.println("</td></tr>");
			} 
%>
</table>
</body>
</html>

