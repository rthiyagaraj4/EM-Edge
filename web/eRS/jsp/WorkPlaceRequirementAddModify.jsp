<!DOCTYPE html>
<!-- /**
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	16 October 2004.
*/ -->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.*,java.text.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/WorkplaceRequirement.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload= 'FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

	String appl_user_id	=(String)session.getValue("login_user");
	String facility_id	=(String)session.getValue( "facility_id" ) ;
	String facility_name=(String)session.getValue( "facility_name" ) ;
	String mode			= request.getParameter("mode");
	ArrayList Locn_Data = new ArrayList();
	String[] record=null;
	
	String chkSql		="";
	String sql			="";
	String count		="";

	String wrkplace_code = "";
	String wrkplace_desc = "";
	String loc_type		 = "";
	String frm_dt		 = "";
	String to_dt		 = "";
	String reqd_desc	 = "";
	String readonly		 = "";
	String disabled		 = "";
	String select="";
	String currentdate="";
	//out.println("mode--->" +mode);
	if(mode.equals("2")){
		readonly="readOnly";
		disabled="disabled";

		 wrkplace_code = request.getParameter("wrkplace_code")==null?"": request.getParameter("wrkplace_code");
		 wrkplace_desc = request.getParameter("wrkplace_desc")==null?"": request.getParameter("wrkplace_desc");
		 loc_type = request.getParameter("loc_type")==null?"": request.getParameter("loc_type");
		 frm_dt = request.getParameter("frm_dt")==null?"": com.ehis.util.DateUtils.convertDate(request.getParameter("frm_dt"),"DMY","en",locale);
		 to_dt = request.getParameter("to_dt")==null?"": com.ehis.util.DateUtils.convertDate(request.getParameter("to_dt"),"DMY","en",locale);
		 reqd_desc = request.getParameter("reqd_desc")==null?"": request.getParameter("reqd_desc");
	}
	
	try{
		Con=ConnectionManager.getConnection(request);
		
		chkSql="SELECT 	COUNT(*) COUNT  FROM rs_access_rights WHERE appl_user_id = (?) AND facility_id = (?) AND	setup_requirement_yn = 'Y'";
		
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
%>
		<script>alert(getMessage("NO_AXS_FOR_WP_REQ_SETUP","RS"));history.go(-1);</script>
	<%
			//out.println("<script>alert(getRsMessage('NO_AXS_FOR_WP_REQ_SETUP')); parent.document.location.href='../../eCommon/html/blank.html' </script>");
			//<script>alert(getRsMessage("NO_AXS_FOR_WP_REQ_SETUP","RS"));history.go(-1);
	//</script>
		}

		pstmt=Con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
		rslRst=pstmt.executeQuery();
		rslRst.next();
		currentdate = rslRst.getString("d");
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();
		
		//sql="SELECT distinct a.locn_type locn_type,b.short_desc locn_desc FROM rs_workplace a, am_care_locn_type b WHERE a.locn_type = b.locn_type AND a.eff_status = 'E' AND a.workplace_code IN (SELECT workplace_code FROM	rs_access_rights WHERE 	appl_user_id = (?) AND	facility_id = (?) AND setup_requirement_yn = 'Y')ORDER BY locn_desc";
		sql="SELECT distinct a.locn_type locn_type,b.short_desc locn_desc FROM rs_workplace a, am_care_locn_type_lang_vw b WHERE a.locn_type = b.locn_type AND a.eff_status = 'E' AND a.workplace_code IN (SELECT workplace_code FROM rs_access_rights WHERE  appl_user_id = (?) AND facility_id = (?) AND setup_requirement_yn = 'Y') and b.language_id = ? ORDER BY locn_desc";

		pstmt=Con.prepareStatement(sql);
		pstmt.setString(1,appl_user_id);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,locale);
		rslRst = pstmt.executeQuery();
		
		while(rslRst.next()){
			record=new String[2];
			record[0]=rslRst.getString("locn_type");
			record[1]=rslRst.getString("locn_desc");
			Locn_Data.add(record);
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();

%>
		<form name='formWorkplaceReqdSearch' id='formWorkplaceReqdSearch' method='post' target="messageFrame">
		<table cellpadding=0 cellspacing=0 border=0 width="98%" align=center>
			<tr>
			<td width="30%" align=right class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>

			<td><SELECT name="locn" id="locn" <%=disabled%>>
				<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
<%
				for(int i=0; i<Locn_Data.size(); i++){
					record=(String[])Locn_Data.get(i);
					if(loc_type.equals(record[0]))
						select="selected";
					else
						select="";
%>
					<option value='<%=record[0]%>' <%=select%>><%=record[1]%></option>
<% 
				}
%>

				</SELECT></td>
				<td width="5%"  align=center class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
				<td><input type=text name="work_text" id="work_text" value="<%=wrkplace_desc%>" size="35"  maxlength='30'
<%
				if(mode.equals("1")){
%>
					onBlur='showWrkplace("T",this)'
<%
				}
%>
				<%=readonly%>><input class='button' type=button name="wrklookup_button" id="wrklookup_button" value="?"  onClick='showWrkplace("B",work_text)' <%=disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif">
				<input type="hidden" name="wrk_code" id="wrk_code" value="<%=wrkplace_code%>" ></td>
				</tr>
				 <tr>
					<td>&nbsp;</td>
					<td  align=left class="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td  align=left class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td>&nbsp;</td>
				</tr> 
				<tr>
					<td width="30%"  align=right class="label"><fmt:message key="eRS.RequirementPeriod.label" bundle="${rs_labels}"/>&nbsp;</td>
					<td><input type=text name="frm_date" id="frm_date" id='id_frm_date' value="<%=frm_dt%>" size="10" maxlength='10' <%if(mode.equals("1")){%>onBlur="CheckDate(this);checkFromDate(this,sys_date,to_date);" onKeyPress='return AllowDateFormat()'<%}%> <%=readonly%> ><img <%=disabled%> name='frm_date_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(frm_date,'id_frm_date');"></td>

					<td><input type=text name="to_date" id="to_date" id='id_to_date' value="<%=to_dt%>" size="10" maxlength='10' <%if(mode.equals("1")){%>onBlur="CheckDate(this);checkDateRange(this,frm_date);" onKeyPress='return AllowDateFormat()' <%}%><%=readonly%> ><img <%=disabled%> name='to_date_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(to_date,'id_to_date');"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="30%"   align=right class="label"><fmt:message key="eRS.RequirementDescription.label" bundle="${rs_labels}"/>&nbsp;</td>
					<td colspan="3" align=left ><input type=text name="reqd_desc_text" id="reqd_desc_text" value="<%=reqd_desc%>" size="60" <%=readonly%> >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
				</tr>
				<tr>
					
					<td colspan='4' align='right'><input class='button' type=button name="setup_reqd" id="setup_reqd" value='<fmt:message key="eRS.SetupRequirement.label" bundle="${rs_labels}"/>'onClick="showDetails()" <%=disabled%>></td>
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
<input type='hidden' name='user_id' id='user_id' value='<%=appl_user_id%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='facility_name' id='facility_name' value='<%=facility_name%>'>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='reqd_id' id='reqd_id' value=''>
<input type='hidden' name='reqd_frm' id='reqd_frm' value=''>
<input type='hidden' name='reqd_to' id='reqd_to' value=''>
<input type='hidden' name='reqd_desc' id='reqd_desc' value=''>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input type="hidden" name="constCount" id="constCount" value='' > 		
<input type="hidden" name="locale" id="locale" value='<%=locale%>' > 		
</form>
</body>
</html>

