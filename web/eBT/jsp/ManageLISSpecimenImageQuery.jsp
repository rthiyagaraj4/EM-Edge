<!DOCTYPE html>
<%@ page import="java.sql.*,java.io.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" contentType=" text/html;charset=UTF-8"%>

<html>
		<head>
			
			<% String locale = (String)session.getAttribute("LOCALE"); %>
			<% request.setCharacterEncoding("UTF-8");%>
			<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
			
		<%			
			//String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String sStyle = "IeStyle.css";//Sanjay
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!-- <script src="../../eCA/js/CAMessages.js" language="javascript"></script>  -->
		<script src="../../eBT/js/ManageLISSpecimenImage.js" language="javascript"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script type='text/javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		//String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		//String userId = (String) session.getValue("login_user") == null ? "" : (String) session.getValue("login_user");
		String facilityId = "HS";//Sanjay
		String userId = "NAREN";//Sanjay

		String sectionCode = "";
		String sectionName = "";
		String sysDate = "";
		String sysYear = "";

		try
		{
			con = ConnectionManager.getConnection(request);
			//pstmt = con.prepareStatement("SELECT A.short_name short_name, B.section_code section_code FROM RL_SECTION_CODE A, RL_USER_DEPT B WHERE OPERATING_FACILITY_ID = ? AND B.user_id = ? AND A.section_code = B.section_code AND NVL(A.USE_SAMPLE_ANATOMY_IND, '!!') IN ('SA', 'AT') ORDER BY 1 ");
			//pstmt = con.prepareStatement("SELECT A.short_name short_name, B.section_code section_code FROM RL_SECTION_CODE_LANG_VW A, RL_USER_DEPT B WHERE OPERATING_FACILITY_ID = ? AND B.user_id = ? AND A.section_code = B.section_code AND NVL(A.USE_SAMPLE_ANATOMY_IND, '!!') IN ('SA', 'AT') AND A.LANGUAGE_ID = ? ORDER BY 1");
			//Query to display all Departments
			pstmt = con.prepareStatement("SELECT A.short_name short_name, B.section_code section_code FROM RL_SECTION_CODE_LANG_VW A, RL_USER_DEPT B WHERE OPERATING_FACILITY_ID = ? AND B.user_id = ? AND A.section_code = B.section_code AND A.LANGUAGE_ID = ? ORDER BY 1");
			pstmt.setString(1,facilityId);
			pstmt.setString(2,userId);
			pstmt.setString(3,locale);
			res = pstmt.executeQuery();
	%>
	<body>
		<form name='LISSpecQueryForm' id='LISSpecQueryForm'>
			<table border='0' width='100%' cellpadding='1' cellspacing='0' align='center'>
				<tr>
					<td class='label' align='right' width='18%'><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
					<td align='left' width='25%'>
						<select name='deptLISImg' id='deptLISImg' onchange='populatecatNum(this)'>
						<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%
						while(res.next())
						{
							sectionCode = res.getString("section_code") == null ? "" : res.getString("section_code");
							sectionName = res.getString("short_name") == null ? "" : res.getString("short_name");
							out.println("<option value='"+sectionCode+"'>"+sectionName+"</option>");
						}
						if(res != null) res.close();
						if(pstmt != null) pstmt.close();

						pstmt = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy HH24:MI') ,to_char(sysdate,'dd/mm/yyyy'), to_char(sysdate,'yyyy') from dual");
						res = pstmt.executeQuery();
						while(res.next())
						{
							sysDate =  res.getString(2);//Commented by Sanjay
							//sysDate =  res.getString(1);
							//System.out.println("Inside ManageLISSpecimenImageQuery.jsp before conversion sysDate:" + sysDate+":locale" + locale);//Sanjay
							sysDate=DateUtils.convertDate(sysDate,"DMY","en",locale);
							//System.out.println("Inside ManageLISSpecimenImageQuery.jsp after conversion sysDate:" + sysDate);//Sanjay
							sysYear =  res.getString(3);
						}
						if(res != null) res.close();
						if(pstmt != null) pstmt.close();

					%>
						</select> <img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td class='label' width='13%' align='right' ><fmt:message key="Common.from.label" bundle="${common_labels}"/> <fmt:message key="eBT.SpecimenNo.label" bundle="${bt_labels}"/></td>
					<td><input type='text' name='fromSpecNum' id='fromSpecNum' maxlength='15' size='15' onkeypress='return chkForNums(event)'></td>
					<td class='label' align='right' width='5%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td><input type='text' name='toSpecNum' id='toSpecNum' maxlength='15' size='15' onkeypress='return chkForNums(event)'></td>
				</tr>
				<tr>
					<!-- Commented by Sanjay for 10.x conversion -->
					<!-- <td class='label' width='18%' align='right'> From Specimen Regd. Date&nbsp;</td><td width='25%'><input type='text' name='fromSpecRegdDate' id='fromSpecRegdDate' size='15' onblur="checkForCurrentDate(this);CheckDateTime(this)"><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick=" alert ('Hi'); return showCalendarValidate('fromSpecRegdDate')"></td> -->
					<td class='label' width='18%' align='right'><fmt:message key="Common.from.label" bundle="${common_labels}"/> <fmt:message key="eBT.SpecregDate.label" bundle="${bt_labels}"/></td><td width='25%'><input type='text' name='fromSpecRegdDate' id='fromSpecRegdDate' size='15' onblur="checkForCurrentDate(this);CheckDateTime(this)"><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick=" return showCalendar('fromSpecRegdDate','DD/MM/YYYY HH24:MI')"></td>

					<td class='label' width='13%' align='right' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<!-- Commented by Sanjay for 10.x conversion -->
					<!--<td width='25%'><input type='text' name='toSpecRegdDate' id='toSpecRegdDate' size='15' onblur="checkForCurrentDate(this);CheckDateTime(this);ValidateDateTimeOfPeriod(document.forms[0].fromSpecRegdDate,document.forms[0].toSpecRegdDate)"><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toSpecRegdDate')" ></td> -->
					<td width='25%'><input type='text' name='toSpecRegdDate' id='toSpecRegdDate' size='15' onblur="checkForCurrentDate(this);CheckDateTime(this);ValidateDateTimeOfPeriod(document.forms[0].fromSpecRegdDate,document.forms[0].toSpecRegdDate)"><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('toSpecRegdDate','DD/MM/YYYY HH24:MI')" ></td>
					<td class='label' align='right'  width='5%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
					<td>	<select name='priority' id='priority'>
							<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
							<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
							<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
							<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class='label' align='right' width='18%'><fmt:message key="Common.from.label" bundle="${common_labels}"/> <fmt:message key="eCA.CategoryId.label" bundle="${ca_labels}"/></td>
					<td width='25%'>
						<select name='fromCatNum' id='fromCatNum' onchange="populateCatYear(this,'<%=sysYear%>')">
							<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						</select>
						<input type='text' size='4' maxlength='4' name='frmCatYr' id='frmCatYr' onkeypress='return chkForNums(event)'>
						<input type='text' size='10' maxlength='10' name='frmCatNoPart' id='frmCatNoPart'>
					</td>
					<td class='label' width='13%' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td width='25%'>
						<select name='toCatNum' id='toCatNum' onchange="populateCatYear(this,'<%=sysYear%>')">
							<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						</select>
						<input type='text' size='4' maxlength='4' name='toCatYr' id='toCatYr' onkeypress='return chkForNums(event)'>
						<input type='text' size='10' maxlength='10' name='toCatNoPart' id='toCatNoPart' >
					</td>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>	
					<td align='right' colspan='5'>&nbsp;</td>
					<td align='right' >
						<input type='button' name='searchBtn' id='searchBtn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='populateDetailBlock()' class='button' >	
						<input type='button' name='cancelBtn' id='cancelBtn' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='backtoMenu()' class='button'>
					</td>
				</tr>
			</table>
			<input type='hidden' name='sysDate' id='sysDate' value='<%=sysDate%>'>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>"> 
		</form>
	</body>
	<%
		}
		catch(Exception e)
		{
			//System.out.println("Exception in try-dept of ManageLISSpecimenImageQuery.jsp--"+e.toString());
			e.printStackTrace(System.err);
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	%>
</html>

