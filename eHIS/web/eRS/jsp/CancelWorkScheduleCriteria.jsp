<!DOCTYPE html>
<!-- /**
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Modified By		:	Sreenivasulu.Y
*	Modified On		:	16 November 2004.
*/ -->
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" 	src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>-->
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/CancelWorkSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_currdate 	= null;
	ResultSet rslRst		= null;
	ResultSet rs_currdate 		= null;

	String appl_user_id	=(String)session.getValue("login_user");
	String facility_id	=(String)session.getValue( "facility_id" ) ;
	String chkSql		="";
	String count		="";
	String locnSql		="";
	String reanSql		="";
	String locn_type	="";
	String locn_desc	="";
	String reason_code	="";
	String reason_desc	="";
	String currentdate  ="";

	try{
		Con=ConnectionManager.getConnection(request);
				
		chkSql="SELECT COUNT(*) COUNT FROM rs_access_rights WHERE appl_user_id = (?) AND facility_id = (?) AND CANCEL_SCHEDULE_YN = 'Y'";
				
		pstmt=Con.prepareStatement(chkSql);
		pstmt.setString(1,appl_user_id);
		pstmt.setString(2,facility_id);
		rslRst = pstmt.executeQuery();
		
		while(rslRst.next()){
			count=rslRst.getString("COUNT");
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();
		 int cnt=Integer.parseInt(count);
		if(cnt<=0){
			out.println("<script>alert(getMessage('NO_AXS_FOR_CAN_SCH','RS')); parent.parent.document.location.href='../../eCommon/jsp/home.jsp' </script>");
		}else{
			pstmt_currdate=Con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
			rs_currdate=pstmt_currdate.executeQuery();
			rs_currdate.next();
			currentdate = rs_currdate.getString("d");
			if(pstmt_currdate != null)
				pstmt_currdate.close();
			if(rs_currdate != null)
				rs_currdate.close();
%>

			<form name='formCanWrkSchCriteria' id='formCanWrkSchCriteria' method='post' target="messageFrame">
			<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>

			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td width="15%"  align=right class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
				<td>&nbsp;<SELECT name="locan_type" id="locan_type" onchange='locnchange();'>
					<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<%
			//locnSql="SELECT short_desc, locn_type FROM am_Care_locn_type ORDER BY short_desc";
			locnSql="SELECT short_desc, locn_type FROM am_Care_locn_type_lang_vw where language_id = ? ORDER BY short_desc";

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
				<td width="12%"  align=right class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td>&nbsp;<input type=text name="work_text" id="work_text" value="" size="35" maxlength='30' onBlur='viewWorkPlace("T", work_text);'><input class='button' type=button name="wrklookup_button" id="wrklookup_button" value="?"  onClick='viewWorkPlace("B",work_text)'>
				<input type="hidden" name="wrk_code" id="wrk_code" value="" ></td>
			</tr>
			<tr>
				<td width="15%"  align=right class="label"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/>&nbsp;</td>
				<td>&nbsp;<SELECT name="role_type" id="role_type" onChange='rolechange()'>
					<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
					<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
				</SELECT></td>
				<td width="8%"  align=right class="label"><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td>&nbsp;<SELECT name="staff_type" id="staff_type" onchange='stafftypechange();'>
					<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
				</SELECT></td>
			</tr>
			<tr>
				<td width="15%"  align=right class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/>&nbsp;</td>
				<td>&nbsp;<input type=text name="position_text" id="position_text" value="" size="35" maxlength='30' onBlur='viewPosition("T",position_text)'><input class='button' type=button name="position_button" id="position_button" value="?"  onClick='viewPosition("B",position_text)'>
				<input type='hidden' name='position_code' id='position_code' value=''>
				<td width="12%"  align=right class="label"><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td>&nbsp;<input type=text name="staff_text" id="staff_text" value='' size="25" readonly onBlur=''><input class='button' type=button name="stafflookup_button" id="stafflookup_button" value="?"  onClick='populateStaff(staff_text)'>
				<input type='hidden' name='staff_id' id='staff_id' value="" ></td>
			</tr>
			<tr>
				<td width="25%"  align=right class="label"><fmt:message key="eRS.CancelSchedule.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td class="label" align='left' colspan='3'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type=text name="frm_dt" id="frm_dt" id='id_frm_dt' value="" size="9" maxlength='10'  onBlur="CheckDate(this),checkSysFromDateRange(this),checkDateRange1(this,'formCanWrkSchCriteria')" onKeyPress='return AllowDateFormat()'><img name="frm_cal" src="../../eCommon/images/CommonCalendar.gif"
					onclick="return showCal(frm_dt,'id_frm_dt');" >&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;<class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type=text name="to_dt" id="to_dt" id='id_to_dt' value="" size="9" maxlength='10'  onBlur="CheckDate(this),checkDateRange(this,'formCanWrkSchCriteria')" onKeyPress='return AllowDateFormat()'><img name="to_cal" type="image" src="../../eCommon/images/CommonCalendar.gif"
					onclick="return showCal(to_dt,'id_to_dt');">&nbsp;<img src="../../eCommon/images/mandatory.gif">
				<input type='hidden' name='sysdate' id='sysdate' value=''>
				</td>
			</tr>
			</table>
			<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
			<tr>
				<td width="25%"  align=right class="label"><fmt:message key="eRS.ReasonforCancellation.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td>&nbsp;<SELECT name="reason" id="reason">
					<option value="">&nbsp;&nbsp;-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------&nbsp;&nbsp;</option>
	<%		
					 //reanSql="SELECT reason_code,reason_desc FROM rs_reason WHERE eff_status = 'E'  and activity_type_code = 'CS' ORDER BY reason_desc";
					 reanSql="SELECT reason_code,reason_desc FROM rs_reason_lang_Vw WHERE eff_status = 'E'  and activity_type_code = 'CS' and language_id = ? ORDER BY reason_desc";

					pstmt=Con.prepareStatement(reanSql);
					pstmt.setString(1,locale);
					rslRst = pstmt.executeQuery();
					//System.out.println("locale 158----->"+locale);
					
					while(rslRst.next()){
						reason_code=rslRst.getString("reason_code");
						reason_desc=rslRst.getString("reason_desc");
						out.println("<option value="+reason_code+'>'+reason_desc+"</option>");
					}
					if(pstmt != null)
						pstmt.close();
					if(rslRst != null)
						rslRst.close();
	%>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
				<td align='right' colspan='3'>&nbsp;<input class='button' type=button name="wrk_shw_button" id="wrk_shw_button" value='<fmt:message key="eRS.ShowDetails.label" bundle="${rs_labels}"/>'onClick='ShowDetails()'>&nbsp;&nbsp;
					<input class='button' type=button name="wrk_clr_button" id="wrk_clr_button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'onClick='clearAll();'>
					</td>
			</tr>
			<input type='hidden'  name='appl_user_id' id='appl_user_id' value='<%=appl_user_id%>'>
			<input type='hidden'  name='facility_id' id='facility_id' value='<%=facility_id%>'>
			<input type='hidden'  name='locale' id='locale' value='<%=locale%>'>
			<input type='hidden'   name ='sys_dt'  value='<%=currentdate%>'> 
			</form>
			</table>
<%
		}
	}catch(Exception e){
			out.println("Exception in try of CancelWorkScheduleCriteria.jsp : "+e);
		}finally {
			if (pstmt != null) pstmt.close();
			if(pstmt_currdate != null)pstmt.close();
			if (rslRst != null) rslRst.close();
			if(rs_currdate != null)rs_currdate.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}
%>
</body>
</html>

