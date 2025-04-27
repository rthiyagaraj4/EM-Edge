<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	22 Nov 2004.
* --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
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
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script -->
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
	ArrayList TrainingDetails	= new ArrayList() ;
	String[] record				= null;

	try{
		Con=ConnectionManager.getConnection(request);
	 
		//Sql="SELECT TO_CHAR(a.start_date,'DD/MM/YYYY') Frm_date, TO_CHAR(a.end_date,'DD/MM/YYYY') Todate, b.training_desc trng_desc,a.training_code trng_code, a.facility_type Training_type, a.facility_id facility_id,a.facility_name Organisation,a.certified_yn Certified FROM rs_staff_training a, rs_training b WHERE a.role_type = (?) AND a.staff_id = (?) AND   b.training_code = a.training_code ORDER BY b.training_desc";
		Sql="SELECT TO_CHAR(a.start_date,'DD/MM/YYYY') Frm_date, TO_CHAR(a.end_date,'DD/MM/YYYY') Todate, b.training_desc trng_desc,a.training_code trng_code, a.facility_type Training_type, a.facility_id facility_id,a.facility_name Organisation,a.certified_yn Certified FROM rs_staff_training a, rs_training_lang_vw b WHERE a.role_type = (?) AND a.staff_id = (?) AND   b.training_code = a.training_code and b.language_id = ? ORDER BY b.training_desc";
		
		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);

		rslRst = pstmt.executeQuery();
			
		while(rslRst.next()){
			record = new String[8];			
			record[0] = rslRst.getString( "Frm_date");
			record[1] = rslRst.getString( "Todate");
			record[2] = rslRst.getString( "trng_desc");
			record[3] = rslRst.getString( "Training_type");
			record[4] = rslRst.getString( "facility_id");
			record[5] = rslRst.getString( "Organisation");
			record[6] = rslRst.getString( "Certified");
			record[7] = rslRst.getString( "trng_code");				
			TrainingDetails.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();
%>
		<form name='formStaffProfileSetupTrainingResult' id='formStaffProfileSetupTrainingResult'>
		<table cellpadding=0 cellspacing=0 border=1 width="100%" id='detailTab'>
<%
		for( int i=0 ; i< TrainingDetails.size() ; i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}
			String[] record1 = (String[])TrainingDetails.get(i);
			
			String Frm_date			=record1[0]==null?"":com.ehis.util.DateUtils.convertDate(record1[0],"DMY","en",locale);
			String Todate			=record1[1]==null?"":com.ehis.util.DateUtils.convertDate(record1[1],"DMY","en",locale);
			String trng_desc		=record1[2]==null?"":record1[2];
			String Training_type	=record1[3]==null?"":record1[3];
			String facility_id		=record1[4]==null?"":record1[4];
			String Organisation		=record1[5]==null?"":record1[5];
			String Certified		=record1[6]==null?"":record1[6];
			String trng_code		=record1[7]==null?"":record1[7];
		
			String trng_type="";
			String cert		="";

			if(Training_type.equalsIgnoreCase("I")){
				trng_type="Inhouse";
			}else if(Training_type.equalsIgnoreCase("L")){
				trng_type="Local";
			}else if(Training_type.equalsIgnoreCase("O")){
				trng_type="Overseas";
			}

			if(Certified.equalsIgnoreCase("Y")){
				cert="Yes";
			}else if(Certified.equalsIgnoreCase("N")){
				cert="No";
			}
%>
		 <tr>
			<td  Align='CENTER' class ='<%=slClassValue%>' width='7%'><%=Frm_date%></td> 
			<td  Align='CENTER' class ='<%=slClassValue%>' width='7%'><%=Todate%></td>		
			 <td  Align='left' class ='<%=slClassValue%>' width='15%'><A  id='trng<%=i%>' HREF="javascript:trng_edit('<%=role_type%>','<%=staff_id%>','<%=funcValue%>','<%=Frm_date%>','<%=Todate%>','<%=trng_desc%>','<%=trng_code%>','<%=Training_type%>','<%=facility_id%>','<%=Organisation%>','<%=Certified%>')"><%=trng_desc%></A>
		 <input type="hidden" name="trng_code<%=i%>" id="trng_code<%=i%>" value="<%=trng_code%>" ></td> 
<%
			if(trng_type.equals("")){
%>
				 <td  Align='left' class ='<%=slClassValue%>' width='9%'>&nbsp;</td>
<%
			}
			else { 
%>
				 <td  Align='left' class ='<%=slClassValue%>' width='9%'><%=trng_type%></td>
<%
			}
			if(Organisation.equals("")){
%>
				<td  Align='left' class ='<%=slClassValue%>' width='15%'>&nbsp;</td>	
<%
			}
			else {
%>
				<td  Align='left' class ='<%=slClassValue%>' width='15%'><%=Organisation%></td>
<%
			}
%>
			<td  Align='CENTER' class ='<%=slClassValue%>' width='5%'><%=cert%></td>
			<td  Align='CENTER' class ='<%=slClassValue%>' width='5%'><A  id='remarks<%=i%>' HREF="javascript:remarks('<%=role_type%>','<%=staff_id%>','<%=trng_code%>')">R</A></td>  
		</tr> 
<%
		}
%>
		</table>		
<%
	}catch(Exception e){
			out.println("Exception in try of StaffProfileSetUpTrainingResult.jsp : "+e);
	}finally {
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}
%>
</form>
</body>
</html>	

