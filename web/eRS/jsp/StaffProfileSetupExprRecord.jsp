<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupTrainingRecord.jsp
*	Purpose 		:
*	Modified By		:	Suresh.S
*	Modified On		:	2 Dec 2004.
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
	String staff_id		= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String staff_type		= request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String db_action	= request.getParameter("db_action")==null?"":request.getParameter("db_action");
	String funcValue	= request.getParameter("funcValue")==null?"":request.getParameter("funcValue");

	String position_code	= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String position_desc	= request.getParameter("position_desc")==null?"":request.getParameter("position_desc");
	String facility_type	= request.getParameter("facility_type")==null?"":request.getParameter("facility_type");
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String facility_name	= request.getParameter("facility_name")==null?"":request.getParameter("facility_name");
	String workplace_type	= request.getParameter("workplace_type")==null?"":request.getParameter("workplace_type");
	String workplace_code	= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String workplace_name	= request.getParameter("workplace_name")==null?"":request.getParameter("workplace_name");
	String grade_code		= request.getParameter("grade_code")==null?"":request.getParameter("grade_code");
	String grade_desc		= request.getParameter("grade_desc")==null?"":request.getParameter("grade_desc");
	String fte				= request.getParameter("fte")==null?"":request.getParameter("fte");
	String frm_dt			= request.getParameter("frm_dt")==null?"":request.getParameter("frm_dt");
	String to_dt			= request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String locn_type_code	= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String serial_no		= request.getParameter("serial_no")==null?"":request.getParameter("serial_no");

	String OrgSql		="";
	String locn_desc	="";
	String locn_type	="";
	String wrkplace_desc="";
	String WrkSql		="";
	String readOnly		="";
	String disabled		="";
	String readOnly_dt		="";
	String disabled_dt		="";
	String remarks		="";
	String select="";
	String record[]=null;
	String currentdate="";
	ArrayList Facility_Data=new ArrayList();
	String facility_name1="";
	if(facility_id.equals(""))
		facility_name1=facility_name;
	else
		facility_name="";
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
			readOnly="readonly";
			disabled="disabled";

			String RemarksSql="SELECT remarks FROM rs_staff_experience WHERE role_type=? AND staff_id=? AND serial_no=?";
			pstmt=Con.prepareStatement(RemarksSql);
			pstmt.setString( 1,role_type.trim());
			pstmt.setString( 2,staff_id.trim());
			pstmt.setString( 3,serial_no.trim());
			rslRst = pstmt.executeQuery();

			while(rslRst.next()){
				remarks=rslRst.getString("remarks");
			}
			if(pstmt != null)
				pstmt.close();
			if(rslRst != null)
				rslRst.close();
		}
		//OrgSql="SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM ORDER BY FACILITY_NAME";
		OrgSql="SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID like ? ORDER BY FACILITY_NAME";

		pstmt=Con.prepareStatement(OrgSql);
		pstmt.setString(1,locale);

		rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			record=new String[2];
			record[0]=rslRst.getString("FACILITY_ID");
			record[1]=rslRst.getString("FACILITY_NAME");
			Facility_Data.add(record);
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();

	if(remarks == null) remarks =""; else remarks = remarks.trim();
	if(db_action.equalsIgnoreCase("U")){
		disabled="disabled";
		readOnly="readonly";
	}else{
		disabled="";
		readOnly="";
	}	
%>
 <body  onload='onLoadChk_Expr()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
 <form name='form_ExprRecord' id='form_ExprRecord' action='../../servlet/eRS.StaffProfileSetupServlet' method='POST'
 target='frameError'>
	<table cellpadding=0 cellspacing=0 border='0' width="100%" height="100%" align="center">
	<tr>
		<td class="label" align='right'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
		<td >&nbsp;<input type=text name="position_txt" id="position_txt" value="<%=position_desc%>" size="20"
  <%=readOnly%> onClick='positionLkup("T",position_txt);'><input class='button' type=button name="position_btn" id="position_btn" value="?"  onClick='positionLkup("B",position_txt);' <%=disabled%> >&nbsp;<img src="../../eCommon/images/mandatory.gif">
		<input type='hidden' name='position_id' id='position_id' value='<%=position_code%>'></td>
		<input type='hidden' name='serial_no' id='serial_no' value='<%=serial_no%>'></td>
	</tr>

	<tr>
		<td width=""  align=right class="label"><fmt:message key="eRS.FacilityType.label" bundle="${rs_labels}"/>&nbsp;</td>
		<td>&nbsp;<SELECT name="fac_type" id="fac_type" onChange='chkForFac()' <%=disabled%>>
		<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<%
			if(facility_type.equals("E"))
				select="selected";
			else
				select="";
%>
		<option value="E" <%=select%>><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
<%
			if(facility_type.equals("X"))
				select="selected";
			else
				select="";
%>
		<option value="X" <%=select%>><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td>
	</tr>

	<tr>
		<td width="" align=right class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan='3'>&nbsp;<SELECT name="org_type" id="org_type" onChange=''>
		<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<%
	   try {		
	for(int i=0; i< Facility_Data.size(); i++){
				record = (String[]) Facility_Data.get(i);
				if(facility_id.equals(record[0])){
					select="selected";
					facility_name=record[1];
				}else{
					select="";
					facility_name="";
				}
%>
				<option value='<%=record[0]%>' <%=select%> ><%=record[1]%> </option>
<%
			}}catch(Exception e)
		{
	       e.printStackTrace();
           }
%>
			</SELECT>&nbsp;<input type='text' name="org_txt" id="org_txt" value="<%=facility_name1%>" maxlength='60' size='40'>&nbsp;<img src="../../eCommon/images/mandatory.gif">
			<input type='hidden' name="org_txt1" id="org_txt1" value="<%=facility_name%>" maxlength='60' size='40'></td>
			</td>
	</tr>

	<tr>
		<td class="label" align='right'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='label' >&nbsp;<input type=text name="frm_dt" id="frm_dt" id='id_frm_dt' value="<%=frm_dt%>" size="9" maxlength='10' onBlur="CheckDate(this);checkFromDate(this,sys_date, to_dt);" onKeyPress='return AllowDateFormat()' <%=readOnly%>><img name='frm_dt_lookup' src="../../eCommon/images/CommonCalendar.gif"
		onclick="return showCal(frm_dt, 'id_frm_dt');" <%=disabled%> >&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
<%
		if(to_dt.equals("")||(to_dt==null)){
			disabled_dt="";
			readOnly_dt="";
		}else{
			disabled_dt="disabled";
			readOnly_dt="readonly";
		}
%>
		<input type=text name="to_dt" id="to_dt" id='id_to_dt' value="<%=to_dt%>" size="9" maxlength='10' onBlur="CheckDate(this);checkDateRange(this,frm_dt);checkToDate(this,sys_date);" onKeyPress='return AllowDateFormat()' <%=readOnly_dt%> ><img name='to_dt_lookup' src="../../eCommon/images/CommonCalendar.gif"
		onclick="return showCal(to_dt,'id_to_dt');" <%=disabled_dt%>></td>
	</tr>

	<tr>
<%
		if (db_action.equalsIgnoreCase("I")){
%>
			<td width=""  align=right class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
			<td>&nbsp;<SELECT name="locn_type" id="locn_type" onChange='loadWrkPlace()'>
			<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<%
			//String locnSql="SELECT locn_type,short_desc FROM am_care_locn_type order by short_desc";
			String locnSql="SELECT locn_type,short_desc FROM am_care_locn_type_LANG_VW WHERE LANGUAGE_ID like ? ORDER BY short_desc";
			pstmt=Con.prepareStatement(locnSql);
			pstmt.setString(1,locale);

			rslRst = pstmt.executeQuery();

			while(rslRst.next()){
				locn_type=rslRst.getString("locn_type");
				locn_desc=rslRst.getString("short_desc");
				out.println("<option value="+locn_type+'>'+locn_desc+"</option>");
			}
			if(pstmt != null)
				pstmt.close();
			if(rslRst != null)
				rslRst.close();
%>
			</SELECT></td>
<%
		}else if(db_action.equalsIgnoreCase("U")){
%>
			<td width=""  align=right class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
			<td>&nbsp;<SELECT name="locn_type" id="locn_type" onChange=''>
			<option value="<%=locn_type_code%>"><%=workplace_type%></option>
			</SELECT></td>
<%
		}
%>
		</tr>
		<tr>
<%
		if (db_action.equalsIgnoreCase("I")){
%>
			<td width="" align=right class="label">
			<fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
			<td colspan='3'>&nbsp;<SELECT name="wrkPlace_type" id="wrkPlace_type" onChange=''>
			<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
			</SELECT>&nbsp;<input type=text name="wrkPlace_txt" id="wrkPlace_txt" size="25"  onBlur="" onKeyPress='' value="" <%=readOnly%> >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
<%
		}
		else if(db_action.equalsIgnoreCase("U")){
			if(!(workplace_code.equals("")) || (workplace_code==null)){ 
%>
				<td width="" align=right class="label">
				<fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td colspan='3'>&nbsp;<SELECT name="wrkPlace_type" id="wrkPlace_type" onChange=''>
				<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<%
				//WrkSql="SELECT workplace_desc FROM rs_workplace WHERE workplace_code=?";
				WrkSql="SELECT workplace_desc FROM rs_workplace_LANG_vW WHERE workplace_code=? AND LANGUAGE_ID like ?";
				pstmt=Con.prepareStatement(WrkSql);
				pstmt.setString( 1,workplace_code.trim());
				pstmt.setString( 2,locale);
				rslRst = pstmt.executeQuery();
				
				while(rslRst.next()){
					wrkplace_desc=rslRst.getString("workplace_desc");
					out.println("<option selected value="+workplace_code+'>'+wrkplace_desc+"</option>");
				}
				if(pstmt != null)
					pstmt.close();
				if(rslRst != null)
					rslRst.close();
%>
		</SELECT>&nbsp;<input type=text name="wrkPlace_txt" id="wrkPlace_txt" size="25"  onBlur="" onKeyPress='' value="" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
<%
			}else if(workplace_code.equals("")|| workplace_code==null){
%>
				<td width="" align=right class="label">
				<fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td colspan='3'>&nbsp;<SELECT name="wrkPlace_type" id="wrkPlace_type" onChange=''>
				<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
				</SELECT>&nbsp;<input type=text name="wrkPlace_txt" id="wrkPlace_txt" size="25"  onBlur="" onKeyPress='' value="<%=workplace_name%>"  <%=readOnly%> >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
<%
			}
		}
%>
		</tr>
		<tr>
			<td class="label" align='right'><fmt:message key="eRS.Grade.label" bundle="${rs_labels}"/></td>
			<td class="label" >&nbsp;<input type=text name="Grade_txt" id="Grade_txt" value="<%=grade_desc%>" size="20" <%=readOnly%> onblur='gradeLkup("T", Grade_txt);'><input class='button' type=button name="grade_btn" id="grade_btn" value="?"  onClick='gradeLkup("B",Grade_txt);' <%=disabled%> >&nbsp;<img src="../../eCommon/images/mandatory.gif">
			<input type='hidden' name='grade_id' id='grade_id' value='<%=grade_code%>'>&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.FTE.label" bundle="${rs_labels}"/>&nbsp;<input type=text name="fte" id="fte" size="3"  maxlength='3' onBlur="" onKeyPress='' value="<%=fte%>" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>

		<tr>
			<td width=""  align=right class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
			<td><TEXTAREA NAME="remarks" ROWS="3" COLS="50"  ALIGN='ABSMIDDLE' onkeypress='return SPCheckMaxLen("Remarks", this, 4000);' onblur='return SPCheckMaxLen("Remarks", this, 4000);'><%=remarks%></TEXTAREA>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='button' type=button name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'onClick='clearExpr()'>&nbsp;<input class='button' type=button name="Record" id="Record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick='recordExpr()' valign='bottom'>&nbsp;<input class='button' type=button name="del" id="del" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>'onClick='deleteExpr()' style="visibility:hidden" valign='bottom'></td>
		</tr>
	</table>
<%
	}catch(Exception e){
		out.println("Exception in try of WrkPlaceReqdSrch.jsp : "+e);
	}finally {
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(Con!=null) 
			ConnectionManager.returnConnection(Con,request);
	}
%>
<input type='hidden' name='db_action' id='db_action' value='<%=db_action%>'>
<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
<input type='hidden' name='staff_id' id='staff_id' value='<%=staff_id%>'>
<input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
<input type='hidden' name='funcVal' id='funcVal' value='<%=funcValue%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input type='hidden' name='facility' id='facility' value=''>
<input type='hidden' name='facility_id' id='facility_id' value=''>
<input type='hidden' name='wrkplace_id' id='wrkplace_id' value=''>
<input type='hidden' name='wrkplace' id='wrkplace' value=''>
<input type='hidden' name='task' id='task' value=''>
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
</form>
</body>
</html>

