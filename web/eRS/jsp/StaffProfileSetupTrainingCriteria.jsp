<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupSkillsRecord.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	26 Nov 2004.
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
	ResultSet rs_currdate   = null;
	ResultSet rslRst		= null;

	String role_type	= request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id		= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String staff_type	=	request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String db_action	= request.getParameter("db_action")==null?"":request.getParameter("db_action");
	String funcValue	= request.getParameter("funcValue")==null?"": request.getParameter("funcValue");
	String frm_dt = request.getParameter("frm_dt")==null?"":request.getParameter("frm_dt");
	String to_dt = request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String trng_des = request.getParameter("trng_desc")==null?"":request.getParameter("trng_desc");
	String trng_cod = request.getParameter("trng_code")==null?"":request.getParameter("trng_code");
	String trng_typ = request.getParameter("trng_type")==null?"":request.getParameter("trng_type");
	String faci_id = request.getParameter("fac_id")==null?"":request.getParameter("fac_id");
	String orgn = request.getParameter("orgn")==null?"":request.getParameter("orgn");
	String certi = request.getParameter("cert")==null?"":request.getParameter("cert");

	ArrayList  Facility_Data	 =	 new ArrayList();
	String record[] = null;
	String select		="";
	String readonly	="";
	String disabled	="";
	String OrgSql		="";
	String sqlRemarks	="";
	String chkVal		="";
	String org_desc		="";
	String remarks		="";
	String currentdate="";
	try{
		Con = ConnectionManager.getConnection(request);

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
			sqlRemarks="SELECT remarks FROM rs_staff_training WHERE role_type= ? AND staff_id= ? AND training_code=?";

			pstmt=Con.prepareStatement(sqlRemarks);
			pstmt.setString( 1,role_type.trim());
			pstmt.setString( 2,staff_id.trim());
			pstmt.setString( 3,trng_cod.trim());
			rslRst = pstmt.executeQuery();

			while(rslRst.next()){
				remarks=rslRst.getString("remarks");
			}
			if(pstmt != null)
				pstmt.close();
			if(rslRst != null)
				rslRst.close();
		}
		//OrgSql="select facility_id, facility_name from sm_facility_param order by facility_name ";
		OrgSql="select facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? order by facility_name ";

		pstmt=Con.prepareStatement(OrgSql);
		pstmt.setString(1,locale);
		rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			record = new String[2];
			record[0] = rslRst.getString("facility_id");
			record[1] = rslRst.getString("facility_name");
			Facility_Data.add(record);
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();

		if(remarks == null) 
			remarks =" "; 
		else 
			remarks = remarks.trim();
		if(db_action.equalsIgnoreCase("I")){
				readonly="";
				disabled="";
		}else{
			readonly="readOnly";
			disabled="disabled";
		}
		if(certi.equals("Y"))
			chkVal="checked";
		else
			chkVal="";
%>
<body  onload='onLoadChk()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
 <form name='form_profileSetupRecord' id='form_profileSetupRecord' action='../../servlet/eRS.StaffProfileSetupServlet' method='POST'
target='frameError'> 
	<table cellpadding=0 cellspacing=0 border='0' width="100%" height="100%" align="center">
	<tr>
		<td class="label" align='right'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td colspan='3'class='label' >&nbsp;<input type=text name="frm_dt" id="frm_dt" id='id_frm_dt' value="<%=frm_dt%>" size="9" maxlength='10' onBlur="CheckDate(this);checkFromDate(this,sys_date,to_dt);" onKeyPress='return AllowDateFormat()' <%=readonly%> ><img name = 'frm_dt_lookup' id='frm_dt_lookup_id' src="../../eCommon/images/CommonCalendar.gif"
		onclick="return showCal(frm_dt,'id_frm_dt');" <%=disabled%> >&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type=text name="to_dt" id="to_dt" id='id_to_dt' value="<%=to_dt%>" size="9" maxlength='10' onblur="CheckDate(this);checkToDate(this,sys_date);checkDateRange(this,frm_dt);" onKeyPress='return AllowDateFormat()' <%=readonly%> ><img name='to_dt_lookup' src="../../eCommon/images/CommonCalendar.gif"
		onclick="return showCal(to_dt,'id_to_dt');" <%=disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	<tr>
		<td class="label" align='right'><fmt:message key="eRS.TrainingProgram.label" bundle="${rs_labels}"/></td>
		<td >&nbsp;<input type=text name="training_text" id="training_text" value="<%=trng_des%>" size="15" <%=readonly%> onblur='callTraininglkup("T",training_text);'><input class='button' type=button name="training_lookup" id="training_lookup" value="?"  onClick='callTraininglkup("B",training_text);' <%=disabled%> >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<input type='hidden' name='training_id' id='training_id' value='<%=trng_cod%>'>

		<td width=""  align=right class="label" ><fmt:message key="eRS.TrainingType.label" bundle="${rs_labels}"/>&nbsp;</td>
		<td>&nbsp;<SELECT name="training_type" id="training_type" onChange='chkOrgType()' <%=disabled%>>
		<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<% 
			if(trng_typ.equals("I"))
				select="selected";
			else
				select="";
%>
			<option value="I" <%=select%>><fmt:message key="eRS.In-house.label" bundle="${rs_labels}"/></option>
<% 
			if(trng_typ.equals("L"))
				select="selected";
			else
				select="";
%>
			<option value="L" <%=select%>><fmt:message key="eRS.Local.label" bundle="${rs_labels}"/></option>
<% 
			if(trng_typ.equals("O"))
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
			if(faci_id.equals(record[0])){
				select="selected";
				org_desc=record[1];
			}else{
				select="";
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
			<td width=""  align=right class="label"><fmt:message key="eRS.Certified.label" bundle="${rs_labels}"/>&nbsp;</td>
			<td colspan='3'>&nbsp;<input type=checkbox name="chk" id="chk" value="N"onClick='checkVal(this)' <%=chkVal%> ></td>
		</tr>
		<tr>
		<td width=""  align=right class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan='2' ><TEXTAREA NAME="remarks" ROWS="3" COLS="40"  ALIGN='ABSMIDDLE' onkeypress='return SPCheckMaxLen("Remarks", this, 4000);' onblur='return SPCheckMaxLen("Remarks", this, 4000);' ><%=remarks%></TEXTAREA></td>
		<td align='right' valign='bottom'>&nbsp;<input class='button' type=button name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'onClick='clearTraining();'>&nbsp;<input class='button' type=button name="Record" id="Record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'onClick='recordTraining()'><input class='button' type=button name="delete_btn" id="delete_btn" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onClick='deleteTraining()' style="visibility:hidden"></td>
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
<input type='hidden' name='staff_id' id='staff_id' value='<%=staff_id%>'>
<input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
<input type='hidden' name='funcVal' id='funcVal' value='<%=funcValue%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input type='hidden' name='task' id='task' value=''>
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
</form>
</body>
</html>

