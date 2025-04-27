<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/rowcolor.js' language='javascript'></script>
		<script src='../../eMR/js/ICDCodeForDagger.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language=JavaScript src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<script>
	//functions for the file name GroupHeading.jsp-end
var prevClassName = "";
var prevRowObject = "";
function changeRowColor(obj, changeClassName)
{
	if( changeClassName==null )	changeClassName = "ITEMSELECT";
	if(	prevClassName != "" )
		for(i=0; i<prevRowObject.cells.length; i++)
			if(prevRowObject.cells[i].className==changeClassName)
				prevRowObject.cells[i].className = prevClassName;

	prevRowObject	=	obj;
	prevClassName	=	obj.cells[0].className;

    for(i=0; i<obj.cells.length; i++)
		if(obj.cells[i].className=="QRYODD" || obj.cells[i].className == "QRYEVEN" ||  obj.cells[i].className == "" )
			obj.cells[i].className = changeClassName;
}

//functions for the file name GroupHeading.jsp-end
	</script>
<body onKeyDown='lockKey()' >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection conn= null; 
PreparedStatement pstmt = null ;
ResultSet rset=null;

int MaxRecord=0;

String Diag_groupcode		= "";
String Diag_groupdesc		= "";
String classValue				= "";
String Encounter_Id			= checkForNull(request.getParameter("Encounter_Id"));
//String term_set_id		= checkForNull(request.getParameter("term_set_id"));
String authorize					= checkForNull(request.getParameter("p_auth_yn"));
String cause_indicator		= checkForNull(request.getParameter("cause_indicator"));
String code_indicator		= checkForNull(request.getParameter("code_indicator"));
String diagcode					= checkForNull(request.getParameter("p_diag_code"));
String diagdesc					= checkForNull(request.getParameter("p_diag_scheme_desc"));
String dob							= checkForNull(request.getParameter("Dob"));
String facility_id				= (String)session.getValue("facility_id");
String function_id				= checkForNull(request.getParameter("function_id"));
String sex							= checkForNull(request.getParameter("Sex"));
String speciality_code		= checkForNull(request.getParameter("speciality_code"));
String diagnosis_by_long_desc_yn =	checkForNull(request.getParameter("diagnosis_by_long_desc_yn"));//Maheshwaran added for the HSA-CRF-0234
int rowCount = 1;

String practitioner_id			= checkForNull((String)session.getValue("ca_practitioner_id"));
if (practitioner_id.equals("")||practitioner_id==""){ 
	practitioner_id				= checkForNull(request.getParameter("practitioner_id"));
}
String term_set_id="";
String title		= request.getParameter("title")==null?"":request.getParameter("title");


	/*
		Commented On 10/20/2009
		if(title.equals("ICD10 Code List")){
			term_set_id =(request.getParameter("p_diag_scheme_desc")==null)?"":request.getParameter("p_diag_scheme_desc");
		}else{
			term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");
		}
	*/
	if(title.equals("ICD10 Code List")){
			term_set_id =checkForNull(request.getParameter("p_diag_scheme_desc"));
		}else{
			term_set_id =checkForNull(request.getParameter("term_set_id"));
		}
	try{
			conn = ConnectionManager.getConnection(request);
			StringBuffer sql =new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(function_id.equals("ca_diagnosis")){
			/*
					sql.append("SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme=( select DIAG_CODE_SCHEME from mr_parameter)  and  (practitioner_id = ? or practitioner_id is null) ");
					if (!Encounter_Id.equals("0")) 
						sql.append(" AND (speciality_code is null or speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?)) ");
					sql.append(" ORDER BY diag_group_desc ");
			*/
					sql.append( " select a.term_group_id diag_group_code , a.term_group_desc diag_group_desc from MR_TERM_GROUP_HDR a where a.term_set_id = '"+term_set_id+"' and ( a.index_type_yn = 'N' or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='P' and practitioner_id = '"+practitioner_id+"' ) or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='S' and speciality_code = '"+speciality_code+"' ");
					if (!Encounter_Id.equals("0")) {
						sql.append(" AND (speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id = '"+facility_id+"' and encounter_id = '"+Encounter_Id+"')) ");
					}
					sql.append(" )) and eff_status='E' order by 2 ");
					pstmt=conn.prepareStatement(sql.toString());
			}else{
					//sql.append( " SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme= ?  AND speciality_code IS NULL AND facility_id IS NULL AND practitioner_id IS NULL UNION SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme= ? AND facility_id = ? and practitioner_id is null and speciality_code is null UNION select  diag_group_code, diag_group_desc FROM mr_diag_group WHERE practitioner_id = ? AND speciality_code IN ( (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ? UNION SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id= ? ))");

					sql.append( " select a.term_group_id diag_group_code , a.term_group_desc diag_group_desc from MR_TERM_GROUP_HDR a where a.term_set_id = '"+term_set_id+"' and ( a.index_type_yn = 'N' or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='P' and practitioner_id = '"+practitioner_id+"' ) or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='S' and speciality_code = '"+speciality_code+"' )) and eff_status='E' order by 2 ");
					pstmt=conn.prepareStatement(sql.toString());
			/*		pstmt.setString(1,diagcode);
					pstmt.setString(2,diagcode);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,practitioner_id);
					pstmt.setString(5,practitioner_id);
					pstmt.setString(6,facility_id);
					pstmt.setString(7,practitioner_id);
	*/
		}
		rset=pstmt.executeQuery();
		%>
		<table width='100%' border='0' cellspacing='0' cellpadding='0' id='tb' ><%
				while(rset.next()){
						MaxRecord++;
						if(function_id.equals("ca_diagnosis")){
							classValue	=	((rowCount%2)==0)	?	"QRYEVEN"	:	"QRYODD";
							Diag_groupcode=rset.getString("diag_group_code");
							Diag_groupdesc=rset.getString("diag_group_desc");
							//class=\""+classValue+"\"
							out.println("<tr id=\"tbl_row"+rowCount+"\" style='background-color:;'><td valign='top' nowrap class='"+classValue+"'>");
							out.println("<li><a  href=\"CustomICDQueryFrames.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&term_set_id="+term_set_id+"&Diag_code="+Diag_groupcode+"&Diag_desc="+java.net.URLEncoder.encode(Diag_groupdesc)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+java.net.URLEncoder.encode(diagdesc)+"&p_auth_yn="+authorize+"&cause_indicator="+cause_indicator+"&Dob=" + dob + "&Sex=" + sex +"&code_indicator=" +code_indicator+"&function_id="+function_id+"\"   onClick=\"changeRowColor(tbl_row"+rowCount+")\" target='code_description'>");
							out.println(Diag_groupdesc+"</a></td></tr>");
							rowCount++;
						}else{
							classValue	=	((rowCount%2)==0)	?	"QRYEVEN"	:	"QRYODD";
							Diag_groupcode=rset.getString("diag_group_code");
							Diag_groupdesc=rset.getString("diag_group_desc");
							out.println("<tr style='background-color:;'><td valign='top' nowrap class='"+classValue+"'>");
							//out.println("<li><a  href='../../eMR/jsp/CusticdQueryResult.jsp?term_set_id="+term_set_id+"&code_indicator=D&Diag_code="+Diag_groupcode+"&Diag_desc="+Diag_groupdesc+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&cause_indicator="+cause_indicator+"' target='code_description'>"); 
							//Modified for SCR 4833
							out.println("<li><a  href='../../eMR/jsp/CusticdQueryResult.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&term_set_id="+term_set_id+"&code_indicator="+code_indicator+"&Diag_code="+Diag_groupcode+"&Diag_desc="+Diag_groupdesc+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&cause_indicator="+cause_indicator+"&function_id="+function_id+"' target='code_description'>");
							out.println(Diag_groupdesc+"</a></td</tr>>");
							rowCount++;
						}
				}//End Of While
				if(MaxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		try{
			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
		}catch(Exception e) {
			 e.printStackTrace();
			//out.println("BB"+e.toString());
			}
		   ConnectionManager.returnConnection(conn,request);
}
%>
		</table>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

