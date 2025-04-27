<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupCriteria.jsp
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
<body>
<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null; 

	String role_type	= request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String funcValue = request.getParameter("funcValue")==null?"":request.getParameter("funcValue");

	String Sql					="";
	String slClassValue			="";
	ArrayList LicenseDetails	= new ArrayList() ;
	String[] record				= null;
	try{
		Con=ConnectionManager.getConnection(request);
		//Sql="SELECT b.license_desc license_desc,a.license_id license_id,a.license_code license_code,TO_CHAR(a.issue_date,'DD/MM/YYYY') issue_dt,TO_CHAR(a.valid_until,'DD/MM/YYYY') valid_dt,a.FACILITY_TYPE facility_type,a.FACILITY_ID	facitility_id,a.FACILITY_NAME facility_name FROM rs_staff_licensure a,rs_licensure b WHERE a.role_type = (?) AND a.staff_id = (?) AND  b.license_code = a.license_code ORDER BY b.license_desc";
		Sql="SELECT b.license_desc license_desc,a.license_id license_id,a.license_code license_code,TO_CHAR(a.issue_date,'DD/MM/YYYY') issue_dt,TO_CHAR(a.valid_until,'DD/MM/YYYY') valid_dt,a.FACILITY_TYPE facility_type,a.FACILITY_ID facitility_id,a.FACILITY_NAME facility_name FROM rs_staff_licensure a,rs_licensure_lang_vw b WHERE a.role_type = (?) AND a.staff_id = (?) AND  b.license_code = a.license_code and b.language_id = ? ORDER BY b.license_desc";
		
		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);

		rslRst = pstmt.executeQuery();
			
		while(rslRst.next()){
			record = new String[8];
			record[0] = rslRst.getString( "license_desc");
			record[1] = rslRst.getString( "license_id");
			record[2] = rslRst.getString( "license_code");
			record[3] = rslRst.getString( "issue_dt");
			record[4] = rslRst.getString( "valid_dt");
			record[5] = rslRst.getString( "facility_type");
			record[6] = rslRst.getString( "facitility_id");
			record[7] = rslRst.getString( "facility_name");				
			
			LicenseDetails.add(record) ;

		}

		//System.err.println("LicenseDetails.size()"+LicenseDetails.size());
		//System.err.println("LicenseDetails-------------->"+LicenseDetails);

%>

		<form name='formStaffProfileSetupTrainingResult' id='formStaffProfileSetupTrainingResult'>
		<table cellpadding=0 cellspacing=0 border=1 width="100%" id='detailTab'>
<%

		 if(LicenseDetails.size()!=0)
		{
		for( int i=0 ; i< LicenseDetails.size() ; i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}
			record = (String[])LicenseDetails.get(i);
			
			String lic_desc			=record[0]==null?"":record[0];
			String lic_id			=record[1]==null?"":record[1];
			String lic_code			=record[2]==null?"":record[2];
			String issue_dt			=record[3]==null?"":com.ehis.util.DateUtils.convertDate(record[3],"DMY","en",locale);
			String valid_dt			=record[4]==null?"":com.ehis.util.DateUtils.convertDate(record[4],"DMY","en",locale);
			String fac_type			=record[5]==null?"":record[5];
			String fac_id			=record[6]==null?"":record[6];
			String orng				=record[7]==null?"":record[7];
%>
			<tr>
				<td  Align='left' class ='<%=slClassValue%>' width='24%'><A  id='title' HREF="javascript:license_details('<%=role_type%>','<%=staff_id%>','<%=funcValue%>','<%=lic_code%>',  '<%=lic_desc%>','<%=lic_id%>','<%=issue_dt%>','<%=valid_dt%>','<%=fac_type%>','<%=fac_id%>',
			'<%=orng%>')"><%=lic_desc%></A></td> 
				<td  Align='left' class ='<%=slClassValue%>' width='20%'><%=lic_id%></td> 
				<td  Align='CENTER' class ='<%=slClassValue%>' width='13%'><%=issue_dt%></td> 
				<td  Align='CENTER' class ='<%=slClassValue%>' width='13%'><%=valid_dt%></td> 
				<td  Align='left' class ='<%=slClassValue%>' width='19%'><%=orng%></td> 
				<td  Align='CENTER' class ='<%=slClassValue%>' width='8%'><A  id='remarks' HREF="javascript:remarks_license('<%=role_type%>','<%=staff_id%>','<%=lic_code%>')">R</A></td>
				<input type='hidden' name='fac_id<%=i%>' id='fac_id<%=i%>' value='<%=fac_id%>'>
				<input type='hidden' name='fac_type<%=i%>' id='fac_type<%=i%>' value='<%=fac_type%>'>
			</tr>	
<%
		}
		}
	}
	catch(Exception e)
	{
			out.println("Exception in try of StaffProfileSetUpLicenseResult.jsp : "+e);
			//System.err.println("LicenseDetails.size()"+LicenseDetails.size());
		//System.err.println("LicenseDetails-------------->"+LicenseDetails);

	}
	finally 
	{
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}
%>
</form>
</body>
</html>	

