<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, java.sql.*, webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String facility_id="", user_id="", fs_locn_code="", fs_locn_desc="", user_security_yn="";
	String user_name="";
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;	
	
	String sys_date = "";
	String user_security_yn_old="";
	String sys_date_old="";
	String user_name_old="";
	
	
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");	
		user_id		=	(String)session.getValue("login_user");
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
		stmt		=	con.createStatement();

		user_security_yn_old=(String)session.getAttribute("user_security_yn");
		sys_date_old         = (String)session.getAttribute("sys_date");
		
		
		if(user_security_yn_old == null || user_security_yn_old.equals("null"))user_security_yn_old="";
		
		if(sys_date_old == null || sys_date_old.equals("null")) sys_date_old="";
		
		
		if(sys_date_old.equals("") || user_security_yn_old.equals("") )
		{
	String fm_param_query="select user_security_yn, to_char(SYSDATE+nvl(NO_DAYS_CHECK_BOOK_INQUIRY,1),'DD/MM/YYYY') SYDATE from fm_parameter where facility_id='"+facility_id+"'";
 
		rs = stmt.executeQuery(fm_param_query);
		if(rs.next())
		{
			user_security_yn = rs.getString("user_security_yn");
			sys_date		 = rs.getString("SYDATE");
		}
		sys_date=DateUtils.convertDate(sys_date,"DMY","en",localeName);
		if(rs != null)		rs.close();
		if(stmt != null)	stmt.close();

		if(user_security_yn == null || user_security_yn.equals("null"))user_security_yn="N";
       session.setAttribute("user_security_yn",user_security_yn);
		session.setAttribute("sys_date",sys_date);
		}else{

           user_security_yn=user_security_yn_old;
             sys_date=sys_date_old;
		}
		
		
		
		
		
		String fs_locn_query = "";
		if(user_security_yn.equals("Y"))
		{			
			if (access_all.equals("*ALL"))
			{
				//fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
				fs_locn_query="SELECT   fs_Locn_Code, fm_Get_desc.Fm_storage_locn(FACILITY_ID,fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc FROM FM_STORAGE_LOCN WHERE    Facility_Id = '"+facility_id+"'  AND eff_Status = 'E'   AND PERMANENT_FILE_AREA_YN = 'Y' ORDER BY 2";
			}
			else
			{
				//fs_locn_query="SELECT fs_locn_code, fs_locn_short_desc fs_locn_desc FROM fm_user_access_rights_vw WHERE facility_id = '"+facility_id+"' AND appl_user_id='"+user_id+"'  AND TRACK_OUT_TO_OPD='Y' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
				/*fs_locn_query = "SELECT"
								  +"  a.fs_Locn_Code"
								  +"  , ("
								  +"  CASE "
								  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
								  +"  THEN"
								  +"    '*ALL' "
								  +"  ELSE B.SHORT_DESC "
								  +"  END) fs_Locn_desc "
								  +"FROM"
								  +"  FM_USER_ACCESS_RIGHTS_VW A"
								  +"  , FM_STORAGE_LOCN_LANG_VW B "
								  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
								  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
								  +"  AND a.Facility_Id = '"+facility_id+"' "
								  +"  AND a.apPl_User_Id = '"+user_id+"' "
								  +"  AND a.TRACK_OUT_TO_OPD = 'Y' "
								  +"  AND a.PERMANENT_FILE_AREA_YN = 'Y' "
								  +"  AND B.LANGUAGE_ID='"+localeName+"' "
								  +"ORDER BY 2";*/

				fs_locn_query ="SELECT"
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
		else
		{
			//fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
			fs_locn_query="SELECT   fs_Locn_Code, fm_Get_desc.Fm_storage_locn(FACILITY_ID,fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc FROM FM_STORAGE_LOCN WHERE    Facility_Id = '"+facility_id+"'  AND eff_Status = 'E'  AND PERMANENT_FILE_AREA_YN = 'Y' ORDER BY 2";
		}
	%>
<html>
<head>
	<title></title>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
		
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMIPConfirmPullingList.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>

	<form name='ConfirmPullingListForm' id='ConfirmPullingListForm' action='../../servlet/eFM.FMIPConfirmPullingListServlet' method='post' target='messageFrame'>
		<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
		<td class='label' width= '25%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields'  width= '25%' ><select name='fs_locn_code' id='fs_locn_code'  onchange='clearpatid();'><option value=''>------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
		<%
	        if(stmt != null) stmt=null;
			stmt =	con.createStatement();
            //String sql1 ="select appl_user_name from sm_appl_user where appl_user_id = '"+user_id+"'";
            user_name_old=(String)session.getAttribute("user_name");
	    	if(user_name_old == null || user_name_old.equals("null")) user_name_old="";
			
			if(user_name_old.equals(""))
		  {
			String sql1 ="select appl_user_name from sm_appl_user_LANG_VW where appl_user_id = '"+user_id+"' AND LANGUAGE_ID='"+localeName+"'";
            rs=stmt.executeQuery(sql1);
			while(rs!=null&&rs.next())
			{
             user_name = rs.getString(1);
			}
          session.setAttribute("user_name",user_name);
		   }else{
           user_name=user_name_old;
	         }
			
			if(rs!=null) rs.close();
			rs = stmt.executeQuery(fs_locn_query);
			int count=0;
			String selected="";
			while(rs.next())
			{
				count++;
				fs_locn_code	=	rs.getString(1);
				fs_locn_desc	=	rs.getString(2);

				if(fs_locn_code == null)fs_locn_code="";
				if(fs_locn_desc == null)fs_locn_desc="";

				if(count==1)selected="";
				else selected="";

				out.println("<option value="+fs_locn_code+" "+selected+" >"+fs_locn_desc+"</option>");
			}
		%>
		</select><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' width= '25%' nowrap> <fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td>
		<td class='fields' width= '25%'><input type='text' id='confirmpulldate' name='preferred_date' id='preferred_date' value='<%=sys_date%>' size='10' maxlength='10'  onBlur='validDateObj(this,"DMY","<%=localeName%>");chkdate(this)'><input type="image" src="../../eCommon/images/CommonCalendar.gif" tabindex=-1 onClick="return showCalendar('confirmpulldate');"><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>

		</tr>
			<tr>		
		<td class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='fm_nursing_unit_code' id='fm_nursing_unit_code' ><option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option><%
              if(rs!=null) rs.close();
			
			//String c_query = "select nursing_unit_code, long_desc short_desc from IP_nursing_unit_lang_vw where facility_id='"+facility_id+"' and  eff_status = 'E'  AND language_id='"+localeName+"' order by 2";
     		
			String c_query = "select nursing_unit_code, ip_get_desc.IP_NURSING_UNIT(facility_id,nursing_unit_code,'"+localeName+"',1) short_desc from IP_nursing_unit where facility_id='"+facility_id+"' and  eff_status = 'E'  order by 2";
			
			rs = stmt.executeQuery(c_query);
			while(rs.next())
			{
				String nursing_unit_code	=	rs.getString("nursing_unit_CODE");
				String nursing_unit_desc	=	rs.getString("short_desc");
				if(nursing_unit_code == null)nursing_unit_code="";
				if(nursing_unit_desc == null)nursing_unit_desc="";
				out.println("<option value="+nursing_unit_code+" >"+nursing_unit_desc+"</option>");
			}
		%>	
	</select><!-- <img align='center' src='../../eCommon/images/mandatory.gif'></img> --></td>	
			<td class='label'  nowrap><fmt:message key="Common.display.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="confirm_yn" id="confirm_yn" tabindex=2>
			<option value='N'><fmt:message key="Common.NotConfirmed.label" bundle="${common_labels}"/></option>
			<option value='Y'><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eFM.CancelledBooking.label" bundle="${fm_labels}"/></option>
			<option value='T'><fmt:message key="Common.revisebooking.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="eFM.FileOutsideMRD.label" bundle="${fm_labels}"/></option>
			</select>
			</td>
		
		</tr>
		<tr>
		<td class='label' nowrap><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='fm_pract_id' id='fm_pract_id' size='15' maxlength='15' value='' onBlur="changeUpperCase(this);if(this.value != '' ) {searchCode2(this,'<%=facility_id%>');}" onKeyPress='return CheckForSpecChars(event)' tabindex=5><input type='button' class='button' name='pract_id' id='pract_id' value='?'  onClick="searchCode2(fm_pract_id,'<%=facility_id%>');">
		<td class='label'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type='text' name='to_pract_id' id='to_pract_id' size='15' maxlength='15' value='' onBlur="changeUpperCase(this);if(this.value != '' ) { searchCode2(this,'<%=facility_id%>');}" onKeyPress='return CheckForSpecChars(event)' tabindex=6><input type='button' class='button' name='pract_id' id='pract_id' value='?'  onClick="searchCode2(to_pract_id,'<%=facility_id%>');">			
		</td>
		</tr>

		<tr>

		<td class='label' nowrap><fmt:message key="eFM.PullingListType.label" bundle="${fm_labels}"/></td>
		<td class='fields'><select name="pull_type" id="pull_type"  >
			<option value='A'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.main.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="eFM.Supplementary.label" bundle="${fm_labels}"/></option>
		</select>&nbsp;
		
	<%--	<input type='button' name='subBotton' id='subBotton' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='fetchResults(preferred_date,fs_locn_code,p_gender,fm_nursing_unit_code,fm_pract_id,to_pract_id,confirm_yn,appl_user_id,pull_type);'>
	--%>
	</td>
		
		<td class='label'><fmt:message key="eFM.GeneratedBy.label" bundle="${fm_labels}"/></td>
		<td class='fields' >
		<%
			if(user_security_yn.equals("Y"))
		{
		%>
			<input type='text' name='appl_user_name' id='appl_user_name' value="<%=user_name%>" size='30' disabled maxlength=60 ><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=user_id%>' size='40' disabled maxlength=30 ><input type=button name=searchcode id=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facility_id%>',appl_user_name)" disabled></td>
		<%
		}
		else
		{
		%>
			<input type='text' name='appl_user_name' id='appl_user_name' value="<%=user_name%>" size='30' disabled maxlength=60 ><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=user_id%>' size='40' readonly maxlength=30 ><input type=button name=searchcode id=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facility_id%>',appl_user_name)"></td>
		<%
		}
		%>
	</tr>

	<tr>
		
		<td  class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td  class='fields' colspan='3'><select name="p_gender" id="p_gender" tabindex=2>
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select></td>
		</tr>
	<tr>
			<td colspan='4'>
			<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="frame_name" value="parent.frames[1].FMConfirmPullingListCriteriaFrame"/>
				<jsp:param name="form_name" value="ConfirmPullingListForm"/>
				<jsp:param name="messageframe_name" value="parent.parent.messageFrame"/>
				<jsp:param name="patientid_name" value="patient_id"/>
				<jsp:param name="fileno_name" value="p_file_no"/>
				<jsp:param name="filetype_name" value="file_type"/>
				<jsp:param name="volumeno_name" value="volume_no"/>
				<jsp:param name="doctype_appl_yn" value="Y"/>
				<jsp:param name="table_width" value="100"/>
				<jsp:param name="locn_code" value="f_curr_fs_locn"/>
			</jsp:include>
			
			</td>
		</tr>
	
	 <TR> <td>&nbsp;</td> </TR>
      <TR>
		<td  colspan="4" align='right'>
		<input  type="button" name="Add" id="Add" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick="addFiles_confirm()">
		<input  type="button" name="subBotton" id="subBotton" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ShowAllFiles.label","fm_labels")%>'onClick='fetchResults(preferred_date,fs_locn_code,p_gender,fm_nursing_unit_code,fm_pract_id,to_pract_id,confirm_yn,appl_user_id,pull_type);'>
		<input  type="button" name="Clear" id="Clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'onClick="ClearAllval()">
		</td>
		</TR>

		</table>
		<script>
			if ('<%=count%>'==1)
			{
				document.forms[0].fs_locn_code.value = '<%=fs_locn_code%>';
			}
		</script>
		<input type='hidden' name='CBValStr' id='CBValStr' value=''>
		<input type='hidden' name='print_only_report' id='print_only_report' value=''>
		<input type='hidden' name='access_all' id='access_all' value='<%=access_all%>'>
      <input type='hidden' name='flag' id='flag' value=''>
	<input type="hidden" name="status" id="status" value=''>
	<input type="hidden" name="patid" id="patid" value=''>
	<input type="hidden" name="volumeno" id="volumeno" value=''>
	<input type="hidden" name="flno" id="flno" value=''>

			<input type='hidden' name='added_rem_remarks' id='added_rem_remarks' value=''>
			<input type='hidden' name='added_rem_remarks_values' id='added_rem_remarks_values' value=''>
			<input type='hidden' name='pat_file_vol' id='pat_file_vol' value=''>
		</form>
</body>
</html>
			<%
	if(rs != null)		rs.close();
	if(stmt != null)	stmt.close();		
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{			
		ConnectionManager.returnConnection(con,request);		
	}
%>

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

