<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupTrainingRecord.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	30 Nov 2004.
* --%>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" 	src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_currdate = null;
	ResultSet rs_currdate = null;
	ResultSet rslRst		= null;

	String role_type	= request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_type		= request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String staff_id		= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String db_action	= request.getParameter("db_action")==null?"":request.getParameter("db_action");
	String funcValue	= request.getParameter("funcValue")==null?"":request.getParameter("funcValue");

	String lic_code	= request.getParameter("lic_code")==null?"":request.getParameter("lic_code");
	String lic_desc	= request.getParameter("lic_desc")==null?"":request.getParameter("lic_desc");
	String lic_id	= request.getParameter("lic_id")==null?"":request.getParameter("lic_id");
	String issue_dt	= request.getParameter("issue_dt")==null?"":request.getParameter("issue_dt");
	String valid_dt	= request.getParameter("valid_dt")==null?"":request.getParameter("valid_dt");
	String license_type	= request.getParameter("fac_type")==null?"":request.getParameter("fac_type");
	String orgn		= request.getParameter("orng")==null?"":request.getParameter("orng");
	String facilityID	= request.getParameter("fac_id")==null?"":request.getParameter("fac_id");

	ArrayList  Facility_Data	 =	 new ArrayList();
	String record[] = null;
	String currentdate="";

	String OrgSql		="";
	String org_desc		="";
	String RemarksSql	="";
	String remarks		="";
	String readonly		="";
	String disable		="";
	String select="";

	try{
		Con=ConnectionManager.getConnection(request);

		pstmt_currdate=Con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
		rs_currdate=pstmt_currdate.executeQuery();
		rs_currdate.next();
		//currentdate = rs_currdate.getString("d");
		currentdate= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		if(pstmt_currdate != null)
			pstmt_currdate.close();
		if(rs_currdate != null)
			rs_currdate.close();

		if(db_action.equalsIgnoreCase("U")){

			RemarksSql="SELECT remarks FROM rs_staff_licensure WHERE role_type=? AND staff_id=? AND license_code=?";
			pstmt=Con.prepareStatement(RemarksSql);
			pstmt.setString( 1,role_type.trim());
			pstmt.setString( 2,staff_id.trim());
			pstmt.setString( 3,lic_code.trim());
			rslRst = pstmt.executeQuery();

			while(rslRst.next()){
				remarks=rslRst.getString("remarks")==null?"":rslRst.getString("remarks");
			}
			if(pstmt != null)
				pstmt.close();
			if(rslRst != null)
				rslRst.close();
		}
		//OrgSql="SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM ORDER BY FACILITY_NAME ";
		OrgSql="SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY FACILITY_NAME ";

		pstmt=Con.prepareStatement(OrgSql);
		pstmt.setString( 1,locale);
		rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			record = new String[2];
			record[0] = rslRst.getString("FACILITY_ID");
			record[1] = rslRst.getString("facility_name");
			Facility_Data.add(record);
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();
		
		if(db_action.equalsIgnoreCase("I")){
			readonly="";
			disable="";
		}else{
			readonly="readOnly";
			disable="disabled";
		}
%>
		<body  onload='onLoadChk_license()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		 <form name='form_licenseRecord' id='form_licenseRecord' action='../../servlet/eRS.StaffProfileSetupServlet' method='POST'
		target='frameError'> 
			<table cellpadding=0 cellspacing=0 border='0' width="100%" height="100%" align="center">
			<tr>
				<td class="label" align='right'><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
				<td >&nbsp;<input type=text name="title_txt" id="title_txt" value="<%=lic_desc%>" size="20" <%=readonly%> onblur='callLicenselkup("T",title_txt);'><input class='button' type=button name="license_lookup" id="license_lookup" value="?"  onClick='callLicenselkup("B",title_txt);'    <%=disable%>>&nbsp;<img src="../../eCommon/images/mandatory.gif">
			<input type='hidden' name='license_id' id='license_id' value='<%=lic_code%>'></td>
			</tr>
			<tr>
				<td class="label" align='right'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
				<td >&nbsp;<input type=text name="id_txt" id="id_txt"  size="20" value='<%=lic_id%>' <%=readonly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
			</tr>

			<tr>
				<td width=""  align=right class="label" ><fmt:message key="eRS.LicenseType.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td>&nbsp;<SELECT name="license_type" id="license_type" onChange='chkOrgType_license()' <%=disable%>>
				<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<%
				if(license_type.equals("I"))
					select="selected";
				else
					select="";
%>
				<option value="I" <%=select%>><fmt:message key="eRS.In-house.label" bundle="${rs_labels}"/></option>
<%
				if(license_type.equals("L"))
					select="selected";
				else
					select="";
%>
				<option value="L" <%=select%>><fmt:message key="eRS.Local.label" bundle="${rs_labels}"/></option>
<%
				if(license_type.equals("O"))
					select="selected";
				else
					select="";
%>
				<option value="O" <%=select%>><fmt:message key="eRS.Overseas.label" bundle="${rs_labels}"/></option>
				</SELECT></td>
			</tr>

			<tr>
				<td width=""  align=right class="label"><fmt:message key="eRS.Organisation.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td colspan='3'>&nbsp;<SELECT name="org_type" id="org_type" onChange='getFacilityType(<%= Facility_Data.size()%>);'>
				<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<%
				for(int i=0; i< Facility_Data.size(); i++){
					record = (String[]) Facility_Data.get(i);
					if(facilityID.equals(record[0])){
						select="selected";
						org_desc=record[1];
					}else{
						select="";
						org_desc="";
					}
%>
					<option value='<%=record[0]%>' <%=select%> ><%=record[1]%> </option>
<% 
				}
%>
				</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">
				<input type='text' name="org_txt" id="org_txt" value="<%=orgn%>" maxlength='60' size='40'>
				<input type='hidden' name="org_txt1" id="org_txt1" value="<%=org_desc%>" maxlength='60' size='40'></td>
				</tr>

				<tr>
					<td class="label" align='right'><fmt:message key="eRS.IssueDate.label" bundle="${rs_labels}"/></td>
					<td class='label' >&nbsp;<input type=text name="issue_dt" id="issue_dt" id='id_issue_dt' value="<%=issue_dt%>" size="9" maxlength='10' onBlur="CheckDate(this);checkFromDate(this,sys_date, valid_dt);" onKeyPress='return AllowDateFormat()' <%=readonly%>><img name='issue_dt_lookup' src="../../eCommon/images/CommonCalendar.gif"
					onclick="return showCal(issue_dt,'id_issue_dt');" <%=disable%>>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.ValidUntill.label" bundle="${rs_labels}"/>&nbsp;<input type=text name="valid_dt" id="valid_dt" id='id_valid_date' value="<%=valid_dt%>" size="9" maxlength='10' onBlur="CheckDate(this);checkDateRangeLicense(this,issue_dt);" onKeyPress='return AllowDateFormat()' <%=readonly%>><img name='valid_dt_lookup' src="../../eCommon/images/CommonCalendar.gif"
					onclick="return showCal(valid_dt,'id_valid_date');" <%=disable%>></td>
				</tr>
	
				<tr>
					<td width=""  align=right class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
					<td><TEXTAREA NAME="remarks" ROWS="3" COLS="50"  ALIGN='ABSMIDDLE' onkeypress='return SPCheckMaxLen("Remarks", this, 4000);' onblur='return SPCheckMaxLen("Remarks", this, 4000);' ><%=remarks%></TEXTAREA>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='button' type=button name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'onClick='clearLicensure();'>&nbsp;<input class='button' type=button name="Record" id="Record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  onClick='recordLicense()'>&nbsp;<input class='button' type=button name="delete_btn" id="delete_btn" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>'onClick='deleteLicense()' style="visibility:hidden"></td>
				</tr>
			</table>
<%
		}catch(Exception e){
			out.println("Exception in try of WrkPlaceReqdSrch.jsp : "+e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}
%>
<input type='hidden' name='db_action' id='db_action' value='<%=db_action%>'>
<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
<input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
<input type='hidden' name='staff_id' id='staff_id' value='<%=staff_id%>'>
<input type='hidden' name='funcVal' id='funcVal' value='<%=funcValue%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input type='hidden' name='task' id='task' value=''>
<input type='hidden' name='orng_name' id='orng_name' value=''>
<input type='hidden' name='facility_id' id='facility_id' value=''>
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
</form>
</body>
</html>

