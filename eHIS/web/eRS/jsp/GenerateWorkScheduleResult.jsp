<!DOCTYPE html>
<!-- /**
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	14 December 2004.
*/ -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/GenerateWorkSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
     request.setCharacterEncoding("UTF-8");
    String locale			= (String)session.getAttribute("LOCALE");
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	ArrayList ResultData	= new ArrayList();

	String facility_id		= request.getParameter("facility_id");
	String locn_type		= request.getParameter("locn_type");
	String wrkplace_code	= request.getParameter("wrkplace_code");
	String role_type		= request.getParameter("role_type");
	String position_code	= request.getParameter("position_code");
	String staff_type		= request.getParameter("staff_type");
	String staff_id			= request.getParameter("staff_id");
	String frm_dt			= request.getParameter("frm_dt");
	String to_dt			= request.getParameter("to_dt");

//out.println("=================facility_id->"+facility_id+"wrkplace_code--"+wrkplace_code+"role_type--"+role_type+"staff_id---"+staff_id+"position_code--->"+position_code+"frm_dt--->"+frm_dt);

	String slClassValue		 ="";
	String Sql				 ="";
	String[] record			 =null;
	String chk_position_flag ="";

	if(facility_id == null || facility_id.equals("null")) facility_id =" "; else facility_id = facility_id.trim();
	if(locn_type == null || locn_type.equals("null")) locn_type =" "; else locn_type = locn_type.trim();
	if(wrkplace_code == null || wrkplace_code.equals("null")) wrkplace_code =" "; else wrkplace_code = wrkplace_code.trim();
	if(role_type == null || role_type.equals("null")) role_type =" "; else role_type = role_type.trim();
	if(frm_dt == null || frm_dt.equals("null")) frm_dt =" "; else frm_dt = frm_dt.trim();
	if(to_dt == null || to_dt.equals("null")) to_dt =" "; else to_dt = to_dt.trim();
	if(position_code == null || position_code.equals("null")) position_code =" "; else position_code = position_code.trim();
	if(staff_type == null || staff_type.equals("null")) staff_type =" "; else staff_type = staff_type.trim();
	if(staff_id == null || staff_id.equals("null")) staff_id =" "; else staff_id = staff_id.trim();

	try{
		
		Con=ConnectionManager.getConnection(request);

		//Sql="SELECT b.position_code position_code,c.position_desc position_desc,b.staff_type staff_type,a.role_type role_type,a.staff_id staff_id,b.staff_name staff_name, TO_CHAR(a.eff_date_from,'dd/mm/yyyy') eff_date_from,TO_CHAR(a.eff_date_to,'dd/mm/yyyy') eff_date_to FROM rs_staff_for_workplace a, am_staff_vw b , am_position c WHERE a.facility_id = ? AND a.workplace_code = ? AND (? IS NULL OR a.role_type = ?) AND (? IS NULL OR a.staff_id = ?) AND (a.role_type,a.staff_id) IN (SELECT role_type,staff_id FROM rs_master_schedule WHERE facility_id = ? AND workplace_code = ? AND requirement_id IN (SELECT requirement_id FROM rs_workplace_requirement WHERE facility_id = ? AND workplace_code = ? AND ( ( requirement_type = 'C' and requirement_date_fm IS NULL AND requirement_date_to IS NULL) OR  (requirement_type = 'V' and requirement_date_to > SYSDATE))) AND (? IS NULL OR role_type = ?) AND (? IS NULL OR staff_id = ?) AND (? IS NULL OR position_code = ?))  AND ( a.eff_date_to is null or a.eff_date_to >= to_date(?,'dd/mm/yyyy') ) AND b.role_type = a.role_type AND b.staff_id = a.staff_id AND c.position_code = b.position_code ORDER BY c.position_desc,b.staff_name";
		
		Sql="SELECT b.position_code position_code,c.position_desc position_desc,b.staff_type staff_type,a.role_type role_type,a.staff_id staff_id,b.staff_name staff_name, TO_CHAR(a.eff_date_from,'dd/mm/yyyy') eff_date_from,TO_CHAR(a.eff_date_to,'dd/mm/yyyy') eff_date_to FROM rs_staff_for_workplace a, am_staff_vw b , am_position_lang_vw c WHERE a.facility_id = ? AND a.workplace_code = ? AND (? IS NULL OR a.role_type = ?) AND (? IS NULL OR a.staff_id = ?) AND (a.role_type,a.staff_id) IN (SELECT role_type,staff_id FROM rs_master_schedule WHERE facility_id = ? AND workplace_code = ? AND requirement_id IN (SELECT requirement_id FROM rs_workplace_requirement WHERE facility_id = ? AND workplace_code = ? AND ( ( requirement_type = 'C' and requirement_date_fm IS NULL AND requirement_date_to IS NULL) OR  (requirement_type = 'V' and requirement_date_to > SYSDATE))) AND (? IS NULL OR role_type = ?) AND (? IS NULL OR staff_id = ?) AND (? IS NULL OR position_code = ?))  AND ( a.eff_date_to is null or a.eff_date_to >= to_date(?,'dd/mm/yyyy') ) AND b.role_type = a.role_type AND b.staff_id = a.staff_id AND c.position_code = b.position_code and b.language_id = ? and c.language_id = b.language_id ORDER BY c.position_desc,b.staff_name";
		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,wrkplace_code);
		pstmt.setString(3,role_type);
		pstmt.setString(4,role_type);
		pstmt.setString(5,staff_id);
		pstmt.setString(6,staff_id);
		pstmt.setString(7,facility_id);
		pstmt.setString(8,wrkplace_code);
		pstmt.setString(9,facility_id);
		pstmt.setString(10,wrkplace_code);
		pstmt.setString(11,role_type);
		pstmt.setString(12,role_type);
		pstmt.setString(13,staff_id);
		pstmt.setString(14,staff_id);
		pstmt.setString(15,position_code);
		pstmt.setString(16,position_code);
		pstmt.setString(17,frm_dt);
		pstmt.setString(18,locale);

		rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			record = new String[8];
			record[0]			=rslRst.getString("position_code");
			record[1]			=rslRst.getString("position_desc");
			record[2]			=rslRst.getString("staff_type");
			record[3]			=rslRst.getString("role_type");
			record[4]			=rslRst.getString("staff_id");
			record[5]			=rslRst.getString("staff_name");
			record[6]			=rslRst.getString("eff_date_from");
			record[7]			=rslRst.getString("eff_date_to");

			ResultData.add(record) ;
		}


		
		if(ResultData.size()<= 0){
			{%><script>
			parent.frameGenWrkSchHdr.document.location.href="../../eCommon/html/blank.html"
			parent.frameset_GenerateWorkSchedule.rows='100%,0%,0%';
			</script><%}
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); location.href='../../eCommon/html/blank.html' </script>");		
		 }
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='form_GenWrkSchResult' id='form_GenWrkSchResult' action='../../servlet/eRS.GenerateWorkScheduleServlet' method='POST' target='messageFrame'> 
<table cellpadding=0 cellspacing=0 border=1 align=center width="100%" id=''>
<%
	for( int i=0 ; i<ResultData.size(); i++ ) {
		if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}

		String[] record1 = (String[])ResultData.get(i);
		String posi_code = record1[0]==null?"":record1[0];
		String posi_desc = record1[1]==null?"":record1[1];
		String stafftype    = record1[2]==null?"":record1[2];
		String roletype     = record1[3]==null?"":record1[3];
		String staffid      = record1[4]==null?"":record1[4];
		String staffname    = record1[5]==null?"":record1[5];
		String eff_date_from = record1[6]==null?"":record1[6];
		String eff_date_to   = record1[7]==null?"":record1[7];

		posi_code = posi_code.trim();
		posi_desc = posi_desc.trim();
		stafftype = stafftype.trim();
		roletype = roletype.trim();
		staffid = staffid.trim();
		staffname = staffname.trim();
		eff_date_from = eff_date_from.trim();
		eff_date_to = eff_date_to.trim();

		if((chk_position_flag.equals("")) || !(chk_position_flag.equals(posi_desc))){
%>
			<tr>
				<td  colspan='6' align=left  valign='top' class='CAGROUPHEADING' width='20%' ><%=posi_desc%></td>
			</tr>
<%
			chk_position_flag=posi_desc;
		}
%>
	<tr>
		<td class='<%=slClassValue%>'>&nbsp;<input type='hidden' name=position_code<%=i%> value='<%=posi_code%>'></td>
		<td  Align='center'  class='<%=slClassValue%>' width='20%'><%=staffid%></td>
		<input type='hidden' name=staffID<%=i%> value='<%=staffid%>'>
		<td  Align='center'  class='<%=slClassValue%>' width='30%' name=staffname<%=i%>><%=staffname%></td>
		<td  Align='center'  class='<%=slClassValue%>' width='11%' name=''><%=com.ehis.util.DateUtils.convertDate(eff_date_from,"DMY","en",locale)%></td>
		<input type='hidden' name=frm_dt<%=i%> value='<%=eff_date_from%>'>
		<td  Align='center'  class='<%=slClassValue%>' width='11%' name=''><%=com.ehis.util.DateUtils.convertDate(eff_date_to,"DMY","en",locale)%>&nbsp;</td>
		<input type='hidden' name=to_dt<%=i%> value='<%=eff_date_to%>'>
		<td  Align='center' class='<%=slClassValue%>'  width='8%'>&nbsp;&nbsp;<input type=checkbox name='select<%=i%>' id='select<%=i%>'  value=''  onclick='invokeChk(this)'></td>
		<input type='hidden' name=staff_type<%=i%> value='<%=stafftype%>'>
		<input type='hidden' name=role_type<%=i%> value='<%=roletype%>'>
	</tr>
<%
		}
%>
<input type='hidden' name=totalrecs value='<%=ResultData.size()%>'>
<input type='hidden' name=facility_id value='<%=facility_id%>'>
<input type='hidden' name=wrkplace_code value='<%=wrkplace_code%>'>
<input type='hidden' name=frm_dt value='<%=frm_dt%>'>
<input type='hidden' name=to_dt value='<%=to_dt%>'>
<input type='hidden' name=locn_type value='<%=locn_type%>'>
</table>
<%
	}catch(Exception e){
			out.println("Exception in try of GenerateWrkSchedule.jsp : "+e);
	}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}
%>
</body>	
</form>
</html>

 
 
  

