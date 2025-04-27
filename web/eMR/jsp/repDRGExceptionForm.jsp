<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<head>
  <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language='javascript' src="../../eMR/js/MRReports.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
</head>
<%

request.setCharacterEncoding("UTF-8");

	String facility_id = (String) session.getValue("facility_id");
	String resp_id     = (String) session.getValue("responsibility_id");
	//String user_id = (String) session.getValue("login_user");
	//String p_user_name		= (String) session.getValue( "login_user" ) ;


  Connection con=null;
  ResultSet rs   = null;
  PreparedStatement pstmt = null ;
String sys_date	 ="";

  try{
  con  =  ConnectionManager.getConnection(request);

%>
<%
					try 
					{
					String sql1 = "select to_char(sysdate,'dd/mm/yyyy') from dual ";
					pstmt = con.prepareStatement(sql1);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						sys_date = rs.getString(1);
					}
					if (rs!=null) rs.close();
					if (pstmt!=null)pstmt.close();

					}
					catch (Exception e)
					{
						//out.println(e.toString());
						e.printStackTrace();

					}
	%>
<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'DRG_expForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
   <table border="0" width='70%' cellpadding="3" cellspacing="0"  align='center'>
	<BR><BR><BR><BR>
		<tr>
            <td class='label'>&nbsp;</td>
            <td class='querydata'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
            <td class='querydata'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
        </tr>

		<tr>
		<td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		 <input type='text'  name='from_speciality' id='from_speciality' size='15'  maxLength='10' OnBlur="BeforesearchCodeDRG1(fromSpecialty,this)"><input type='button' name='fromSpecialty' id='fromSpecialty' value='?' class='button' onclick="searchCodeDRG(this, from_speciality)" >
		<input type="hidden" name="p_fr_specialty_code" id="p_fr_specialty_code"  ><img src="../../eCommon/images/mandatory.gif"></img></td>
		
		<td class='fields'><input type='text'  name='to_speciality' id='to_speciality' size='15'  maxLength='10' OnBlur="BeforesearchCodeDRG2(toSpecialty,this)"><input type='button' name='toSpecialty' id='toSpecialty' value='?' class='button' onclick='searchCodeDRG(this, to_speciality)'  >
		<input type="hidden" name="p_to_specialty_code" id="p_to_specialty_code"  ><img src="../../eCommon/images/mandatory.gif"></img></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.admission.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td>
		<input type='text'  name='p_fr_adm_date' id='p_fr_adm_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validateAdmin_From(this);;" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_adm_date');"/></td>
		<td class='fields'><input type='text'  name='p_to_adm_date' id='p_to_adm_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validateAdmin_To(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_adm_date');"/>
		</td>
	</tr>

	<tr>
		<td class="label"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td>
		<input type='text'  name='p_fr_dis_date' id='p_fr_dis_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validateDisch_From(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_dis_date');"/></td>
		<td class='fields'><input type='text'  name='p_to_dis_date' id='p_to_dis_date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validateDisch_To(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_dis_date');"/>
		</td>
	</tr>

	<!-- <tr>
		<td class="label"><fmt:message key="eMR.RW.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type='text' name='rw' id='rw'  value="" size='4' maxlength='3'  onKeyPress="return allowPositiveNumber();"></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eMR.MDC.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type='text' name='mdc' id='mdc'  value="" size='15' maxlength='12'></td>
	</tr> -->
  
  
   </table>

<%
	}
	catch(Exception e)
	{}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}

	%>
   	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%=sys_date%>">
	<input type="hidden" name="p_module_id" id="p_module_id"	  value="MR">
	<input type="hidden" name="p_report_id" id="p_report_id"   value="MRDRGEXC">
	<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"	  value="<%=resp_id%>">




  </form>
</body>

</html>

