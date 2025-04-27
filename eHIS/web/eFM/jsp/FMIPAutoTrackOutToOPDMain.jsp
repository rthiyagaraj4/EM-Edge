<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMIPAutoTrackOutToOPD.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head> 
<%
		Connection conn = ConnectionManager.getConnection(request);
		String facility_id = (String) session.getValue("facility_id");
		String user_id = (String) session.getValue("login_user");
		String userSecurity  = request.getParameter("userSecurity")==null?"N":request.getParameter("userSecurity");
		String access_all  = request.getParameter("access_all")==null?"N":request.getParameter("access_all");
%>
<body OnMouseDown='CodeArrest()' onLoad="document.AutoTrackToOPD_Form.iss_locn_code.focus();" onKeyDown = 'lockKey();'>
<form name='AutoTrackToOPD_Form' id='AutoTrackToOPD_Form' action='../../servlet/eFM.FMAutoTrackOutToIPWServlet' method='post' target='messageFrame'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<td colspan='4' class='columnheader'><fmt:message key="eFM.AutoTrackouttoIPW.label" bundle="${fm_labels}"/></td>
<%
		Statement stmt=null;
		ResultSet rs=null;
		String sql = "";			

		String curr_date = "";		
		String syDate = "";	
		String attButtStatus = "";
		String issue_user_name="";
		String curr_date_old = "";		
		String syDate_old = "";	
		String value="";
		
		int x = 0;

	try
	{
		
		value =(String)session.getAttribute("issue_user_name");
		syDate_old =(String)session.getAttribute("syDate");
		curr_date_old =(String)session.getAttribute("curr_date");
		
		if(value==null || value.equals("null")) value="";
		if(syDate_old==null || syDate_old.equals("null")) syDate_old="";
		if(curr_date_old==null || curr_date_old.equals("null")) curr_date_old="";
	
		if(value.equals("") || syDate_old.equals("") || curr_date_old.equals(""))
		{
		stmt =conn.createStatement();			
		
		//rs = stmt.executeQuery("Select appl_user_name,to_char(SYSDATE+1,'DD/MM/YYYY') SYDATE,to_char(SYSDATE,'DD/MM/YYYY') curdate from sm_appl_user where appl_user_id = '"+user_id+"' ");

		
		rs = stmt.executeQuery("Select appl_user_name from sm_appl_user_LANG_VW where appl_user_id = '"+user_id+"' AND LANGUAGE_ID='"+localeName+"'");
		if(rs.next())
		{
			issue_user_name = rs.getString(1);		
		}

		//syDate=DateUtils.convertDate(syDate,"DMY","en",localeName);
		if(rs!=null)	rs.close();
		//if(stmt!=null) stmt.close(); 


		rs = stmt.executeQuery("Select to_char(sysdate+nvl(NO_DAYS_CHECK_BOOK_INQUIRY,0), 'dd/mm/YYYY') SYDATE, to_char(SYSDATE,'DD/MM/YYYY') curdate from fm_parameter where facility_id = '"+facility_id+"'");
		if(rs.next())
		{		
			syDate = rs.getString(1);
			curr_date = rs.getString(2);
		}

		syDate=DateUtils.convertDate(syDate,"DMY","en",localeName);
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
		} else{

     syDate=syDate_old;
    curr_date=curr_date_old;
	issue_user_name	=value;
   }
	
	
	/*	if(userSecurity.equals("Y"))
		{		
			attButtStatus = "disabled";			

			if (access_all.equals("*ALL"))
			{
				sql=" Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_STORAGE_LOCN where FACILITY_ID = '"+facility_id+"'  and EFF_STATUS = 'E' and PERMANENT_FILE_AREA_YN = 'Y' order by 2";
			}
			else
			{
				sql=" Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_USER_ACCESS_RIGHTS_VW where FACILITY_ID = '"+facility_id+"' and APPL_USER_ID = '"+user_id+"' AND TRACK_OUT_TO_OPD = 'Y' AND PERMANENT_FILE_AREA_YN = 'Y' order by 2";
			}
		}
		else
		{
			sql=" Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_STORAGE_LOCN where FACILITY_ID = '"+facility_id+"'  and EFF_STATUS = 'E' and PERMANENT_FILE_AREA_YN = 'Y'  order by 2";
		}*/
		//sql=" Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_STORAGE_LOCN where FACILITY_ID = '"+facility_id+"'  and EFF_STATUS = 'E' and PERMANENT_FILE_AREA_YN = 'Y'  order by 2";
		sql = "SELECT"
			  +"  FS_LOCN_CODE"
			  +"  ,fm_Get_desc.Fm_storage_locn(FACILITY_ID,FS_LOCN_CODE,'"+localeName+"',2) SHORT_DESC"
			  +"  , LOCN_IDENTITY"
			  +"  , MR_LOCN_YN "
			  +"FROM"
			  +"  FM_STORAGE_LOCN "
			  +"WHERE FACILITY_ID = '"+facility_id+"' "
			  +"  AND EFF_STATUS = 'E' "
			 // +"  AND LANGUAGE_ID='"+localeName+"'"
			  +"  AND PERMANENT_FILE_AREA_YN = 'Y' "
			  +"ORDER BY 2";

		if(userSecurity.equals("Y"))
		{		
			attButtStatus = "disabled";			

			if (!access_all.equals("*ALL"))
			{
				//sql=" Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_USER_ACCESS_RIGHTS_VW where FACILITY_ID = '"+facility_id+"' and APPL_USER_ID = '"+user_id+"' AND TRACK_OUT_TO_OPD = 'Y' AND PERMANENT_FILE_AREA_YN = 'Y' order by 2";
				/*sql = "SELECT"
						  +"  A.FS_LOCN_CODE"
						  +"  , ("
						  +"  CASE "
						  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
						  +"  THEN"
						  +"    '*ALL' "
						  +"  ELSE B.SHORT_DESC "
						  +"  END) FS_LOCN_SHORT_DESC"
						  +"  , A.LOCN_IDENTITY"
						  +"  , A.MR_LOCN_YN "
						  +"FROM"
						  +"  FM_USER_ACCESS_RIGHTS_VW A"
						  +"  , FM_STORAGE_LOCN_LANG_VW B "
						  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
						  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
						  +"  AND A.FACILITY_ID = '"+facility_id+"' "
						  +"  AND A.APPL_USER_ID = '"+user_id+"' "
						  +"  AND A.TRACK_OUT_TO_IPW = 'Y' "
						  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
						  +"ORDER BY"
						  +"  2 ";*/


						  sql = "SELECT"
						  +"  A.FS_LOCN_CODE,"
						  +"  DECODE"
						  +"  (a.fs_locn_code,"
						  +"   '*ALL', '*ALL',"
						  +"  fm_get_desc.fm_storage_locn(a.facility_id, "
						  +"   a.fs_locn_code, "
						  +" '"+localeName+"', "
						  +"  '2') ) fs_locn_short_desc, "
						  +"   A.LOCN_IDENTITY"
						  +"  , A.MR_LOCN_YN "
						  +"  FROM"
						  +"  FM_USER_ACCESS_RIGHTS_VW A"			
						  +"  WHERE A.FACILITY_ID = '"+facility_id+"' "
						  +"  AND A.APPL_USER_ID = '"+user_id+"' "
						  +"  AND A.TRACK_OUT_TO_IPW = 'Y' "
						  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
						  +"ORDER BY"
						  +"  2 ";

			}
		}
	
		
%>
		<tr>
			<td class='label' width='25%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
			<td class='fields' width='25%'>
			<select name='iss_locn_code' id='iss_locn_code' onBlur='refresh(this.value);' tabindex=1>
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option> 
<%
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null)
			{
			   while(rs.next())
			   {
					x++;
					String ID	= rs.getString(1);
					String desc	= rs.getString(2);
				//	String Iden	= rs.getString(3);
				//	String mrlocn = rs.getString(4);

					out.println("<option value='"+ID+"'>"+desc+"</option>");
			   }
			   if(rs!=null)	rs.close();
			}
%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' width='25%'><fmt:message key="eFM.TrackedoutBy.label" bundle="${fm_labels}"/></td>
			<td class='fields' width='25%'><input type=text size=30 maxlength=60 name='issue_user_name' id='issue_user_name' readonly value='<%=issue_user_name%>'><input type=hidden size=40 maxlength=30 name='issue_user' id='issue_user' readonly value='<%=user_id%>'><input type=button name=searchcode value='?' class=button tabindex=2 onClick="searchCode(issue_user,'<%=facility_id%>',issue_user_name)" <%=attButtStatus%> >
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.FromNursingUnit.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='from_nursing_unit' id='from_nursing_unit' maxlength='4' size='4' value='' tabindex=3 onBlur="ChangeUpperCase(this);if(this.value != ''){search(from_nursing_unit,'<%=facility_id%>');}" onKeyPress='return CheckForSpecChars(event)' ><input type='button' class='button' name='nursing_unit1' id='nursing_unit1' value='?' onClick="search(from_nursing_unit,'<%=facility_id%>');">
			</td>
			<td class='label' ><fmt:message key="Common.ToNursingUnit.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='to_nursing_unit' id='to_nursing_unit' maxlength='4' size='4' value='' tabindex=4 onKeyPress='return CheckForSpecChars(event)' onBlur="ChangeUpperCase(this);if(this.value != ''){search(to_nursing_unit,'<%=facility_id%>');}" ><input type='button' class='button' name='nursing_unit2' id='nursing_unit2' value='?' onClick="search(to_nursing_unit,'<%=facility_id%>');">
			</td>
       </tr>
		<tr>
			<td class='label' ><fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' id='autoopddate' name='preferred_date' id='preferred_date' maxlength='10' size='10' value='<%=syDate%>' tabindex=5 onBlur='if(validDateObj(this,"DMY","<%=localeName%>")){ValidateOPDDate(this,"<%=curr_date%>");}'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('autoopddate');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label'><fmt:message key="eFM.PrintTracerCard.label" bundle="${fm_labels}"/></td>
			<td class='fields'><input type='checkbox' name='print_card' id='print_card' value='N' onClick="EnableDisableCheck(this)" tabindex=6>
			</td>
       </tr>
		<tr>
		<td class='button' align="right" colspan='4'>
		<input type='button' class='button' name='trackout' id='trackout' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TrackOut.label","fm_labels")%>  ' tabindex=7 onClick="TrackoutFiles();">
		</td>
		</tr>
<%
	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{					
		ConnectionManager.returnConnection(conn,request);
	}
%>
<table>
<input type='hidden' name='iss_locn_iden' id='iss_locn_iden' value=''>
<input type='hidden' name='iss_locn_mryn' id='iss_locn_mryn' value=''>

<script>
	if(<%=x%> == 1)
	{
		parent.frames[1].document.forms[0].iss_locn_code.options(1).selected = true;
	}
</script>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

