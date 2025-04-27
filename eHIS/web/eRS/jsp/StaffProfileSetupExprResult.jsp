<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	2nd Dec 2004.
* --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	System.err.println("ctrl cmoes to rsultpage");
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null; 

	String role_type	= request.getParameter("role_type");
	String staff_id		= request.getParameter("staff_id");
	String db_action	= request.getParameter("db_action");
	String funcValue	= request.getParameter("funcValue");


	String Sql					="";
	String slClassValue			="";
	ArrayList ExprDetails		= new ArrayList() ;
	String[] record				= null;
	String type_desc			="";

	if(role_type == null || role_type.equals("null")) role_type =" "; else role_type = role_type.trim();
	if(staff_id == null || staff_id.equals("null")) staff_id =" "; else staff_id = staff_id.trim();
	if(db_action == null || db_action.equals("null")) db_action =" "; else db_action = db_action.trim();
	if(funcValue == null || funcValue.equals("null")) funcValue =" "; else funcValue = funcValue.trim();

	try{
		//ConnectionManager.getConnection(request);
		Con = ConnectionManager.getConnection(request);
		//Sql	= "SELECT a.serial_no serial_no,TO_CHAR(a.from_date,'DD/MM/YYYY')frm_dt,TO_CHAR(a.TO_DATE,'DD/MM/YYYY')to_dt, b.position_desc position_desc,a.position_code position_code,a.facility_type facility_type,a.facility_id facilty_id,a.facility_name facility_name,a.locn_type locn_type,d.short_desc workplace_type,a.workplace_code workplace_code,a.workplace_name workplace_name,a.grade_code grade_code,c.grade_desc grade_desc,a.fte fte FROM rs_staff_experience a,am_position b,rs_grade c,am_care_locn_type d WHERE a.role_type = (?) AND a.staff_id = (?) AND b.position_code = a.position_code AND c.grade_code=a.grade_code and d.locn_type=a.locn_type ORDER BY b.position_desc";
		Sql	= "SELECT a.serial_no serial_no,TO_CHAR(a.from_date,'DD/MM/YYYY')frm_dt,TO_CHAR(a.TO_DATE,'DD/MM/YYYY')to_dt, b.position_desc position_desc,a.position_code position_code,a.facility_type facility_type,a.facility_id facilty_id,a.facility_name facility_name,a.locn_type locn_type,d.short_desc workplace_type,a.workplace_code workplace_code,a.workplace_name workplace_name,a.grade_code grade_code,c.grade_desc grade_desc,a.fte fte FROM rs_staff_experience a,am_position_lang_vw b,rs_grade_lang_vw c,am_care_locn_type_lang_vw d WHERE a.role_type = (?) AND a.staff_id = (?) AND b.position_code = a.position_code AND c.grade_code=a.grade_code and d.locn_type=a.locn_type AND b.language_id = ? and c.language_id = b.language_id and d.language_id = b.language_id ORDER BY b.position_desc";

		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);

		rslRst = pstmt.executeQuery();
			
		while(rslRst.next()){
			record = new String[15];
			record[0] = rslRst.getString( "frm_dt");
			record[1] = rslRst.getString( "to_dt");
			record[2] = rslRst.getString( "position_desc");
			record[3] = rslRst.getString( "facility_type");
			record[4] = rslRst.getString( "facilty_id");
			record[5] = rslRst.getString( "facility_name");
			record[6] = rslRst.getString( "workplace_type");
			record[7] = rslRst.getString( "workplace_code");
			record[8] = rslRst.getString( "workplace_name");
			record[9] = rslRst.getString( "grade_code");
			record[10] = rslRst.getString( "grade_desc");
			record[11] = rslRst.getString( "fte");
			record[12] = rslRst.getString( "position_code");
			record[13] = rslRst.getString( "locn_type");
			record[14] = rslRst.getString( "serial_no");
			ExprDetails.add(record) ;
		}

		//System.err.println("ExprDetails---------->"+ExprDetails);
		//System.err.println("ExprDetails-----size----->"+ExprDetails.size());

%>
<form name='formStaffProfileExprResult' id='formStaffProfileExprResult'>
<table cellpadding=0 cellspacing=0 border=1 width="100%" id='detailTab'>
 <%
     if(ExprDetails.size()!=0)  {      		
    for( int i=0 ; i< ExprDetails.size() ; i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}
			String[] record1 = (String[])ExprDetails.get(i);
			
			String frm_dt			=record1[0]==null?"":com.ehis.util.DateUtils.convertDate(record1[0],"DMY","en",locale);
			String to_dt			=record1[1]==null?"":com.ehis.util.DateUtils.convertDate(record1[1],"DMY","en",locale);
			String position_desc	=record1[2]==null?"":record1[2];
			String facility_type	=record1[3]==null?"":record1[3];
			String facilty_id		=record1[4]==null?"":record1[4];
			String facility_name	=record1[5]==null?"":record1[5];
			String workplace_type	=record1[6]==null?"":record1[6];
			String workplace_code	=record1[7]==null?"":record1[7];
			String workplace_name	=record1[8]==null?"":record1[8];
			String grade_code		=record1[9]==null?"":record1[9];
			String grade_desc		=record1[10]==null?"":record1[10];
			String fte				=record1[11]==null?"":record1[11];
			String position_code	=record1[12]==null?"":record1[12];
			String locn_type		=record1[13]==null?"":record1[13];
			String serial_no		=record1[14]==null?"":record1[14];

			if(facility_type.equalsIgnoreCase("E")){
				type_desc="Enterprise";
			}else if(facility_type.equalsIgnoreCase("X"))
				type_desc="External";
%>

			<tr>
				<td  Align='CENTER' class ='<%=slClassValue%>' width='10%'><%=frm_dt%></td> 
<% 
				if(to_dt.equals("")||to_dt==null){
%>
					<td  Align='CENTER' class ='<%=slClassValue%>' width='10%'>&nbsp;</td> 
<% 
				}
				else{
%>
					<td  Align='CENTER' class ='<%=slClassValue%>' width='10%'><%=to_dt%></td> 
<%
				}
%>
				<td  Align='left' class ='<%=slClassValue%>' width='16%'><A  id='remarks' HREF="javascript:expr_edit('<%=role_type%>','<%=staff_id%>','<%=funcValue%>','<%=position_code%>','<%=position_desc%>','<%=facility_type%>','<%=type_desc%>','<%=facilty_id%>','<%=facility_name%>','<%=workplace_type%>','<%=workplace_code%>','<%=workplace_name%>','<%=grade_code%>','<%=grade_desc%>','<%=fte%>','<%=frm_dt%>','<%=to_dt%>','<%=locn_type%>','<%=serial_no%>')"><%=position_desc%></A></td> 
				<td  Align='left' class ='<%=slClassValue%>' width='11%'><%=type_desc%></td> 
				<input type='hidden' name='facility_id' id='facility_id' value='<%=facilty_id%>'>
				<td  Align='left' class ='<%=slClassValue%>' width='13%'><%=facility_name%></td> 
				<td  Align='left' class ='<%=slClassValue%>' width='10%'><%=workplace_type%></td> 
				<input type='hidden' name='locn_type' id='locn_type' value='<%=locn_type%>'>	
				<td  Align='left' class ='<%=slClassValue%>' width='11%'><%=workplace_name%></td> 
				<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
				<td  Align='left' class ='<%=slClassValue%>' width='7%'><%=grade_desc%></td> 
				<input type='hidden' name='grade_code' id='grade_code' value='<%=grade_code%>'>
				<td  Align='CENTER' class ='<%=slClassValue%>' width='5%'><%=fte%></td> 
				<td  Align='CENTER' class ='<%=slClassValue%>' width='7%'><A  id='remarks' HREF="javascript:remarks_Expr('<%=role_type%>','<%=staff_id%>','<%=serial_no%>')">R</A></td>
			</tr>
<%
		}// end for loop
}//end if
	}catch(Exception e){
			out.println("Exception in try of StaffProfileSetUpLicenseResult.jsp : "+e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}
%>
</form>
</body>
</html>

