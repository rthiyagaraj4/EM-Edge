<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

var prevClassName = "";
var prevRowObject = "";

function changeRowColor(obj, changeClassName)
{
	if( changeClassName==null )	changeClassName = "ITEMSELECT";
	if(	prevClassName != "" )
		for(i=0; i<prevRowObject.cells.length; i++)
			if(prevRowObject.cells(i).className==changeClassName)
				prevRowObject.cells(i).className = prevClassName;

	prevRowObject	=	obj;
	prevClassName	=	obj.cells(0).className;

    for(i=0; i<obj.cells.length; i++)
		if(obj.cells(i).className=="QRYODD" || obj.cells(i).className == "QRYEVEN" ||  obj.cells(i).className == "" )
			obj.cells(i).className = changeClassName;
}
</script>

</head>
<body onKeyDown='lockKey()'>
<%
request.setCharacterEncoding("UTF-8");
 Connection conn= null;
 PreparedStatement stmt=null;
 ResultSet rset=null;

 String queryString			= request.getQueryString();
 String facility_id			=	(String)session.getValue("facility_id");
 String practitioner_id		=	(String) session.getValue("ca_practitioner_id");
 practitioner_id				=	(practitioner_id==null)	?	""	:	practitioner_id;
 String Encounter_Id		= request.getParameter("Encounter_Id");
 if(Encounter_Id == null) Encounter_Id="0";	
 String Diag_groupcode	="";
 String Diag_groupdesc	="";
 String diagcode				=request.getParameter("p_diag_code");
 String diagdesc				=request.getParameter("p_diag_scheme_desc");
 String authorize			=request.getParameter("p_auth_yn");
 String cause_indicator	= request.getParameter("cause_indicator");
 String term_set_id	= request.getParameter("term_set_id");
 String speciality_code	= checkForNull(request.getParameter("speciality_code"));

StringBuffer sql = new StringBuffer();
 	if(diagcode == null)	diagcode  ="";
	if(diagdesc == null)	diagdesc  ="";
	if(authorize == null)	authorize  ="";
	if(cause_indicator == null)	cause_indicator  ="";

	//out.println("<script>alert(\"option_id 1 :"+speciality_code+"\");</script>");			

try
{

	conn = ConnectionManager.getConnection(request);
	

	sql.append( " select a.term_group_id diag_group_code , a.term_group_desc diag_group_desc from MR_TERM_GROUP_HDR a where a.term_set_id = '"+term_set_id+"' and ( a.index_type_yn = 'N' or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='P' and practitioner_id = '"+practitioner_id+"' ) or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='S' and speciality_code = '"+speciality_code+"' ");
		
		if (!Encounter_Id.equals("0")) 
			sql.append(" AND (speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id = '"+facility_id+"' and encounter_id = '"+Encounter_Id+"')) ");
				
		sql.append(" )) and eff_status='E' order by 2 ");

//out.println("<script>alert(\"option_id 1 :"+sql.toString()+"\");</script>");			
   stmt=conn.prepareStatement(sql.toString());
   //stmt.setString(1,practitioner_id);
   
   rset=stmt.executeQuery();

   //rset.next();
%>
<table  border='1' cellspacing='0' cellpadding='0' id='tb1'>
<tr>
<%  
String classValue="";
int rowCount = 0;
	

	while(rset!=null && rset.next())
	{
			classValue	=	((rowCount%2)==0)	?	"QRYEVEN"	:	"QRYODD";
			Diag_groupcode=rset.getString("diag_group_code");
			Diag_groupdesc=rset.getString("diag_group_desc");
			
			out.println("<tr id=\"tbl_row"+rowCount+"\" style='background-color:;'><td valign='top' class='"+classValue+"'>");
			out.println("<li><a  href=\"TermCodeSearchCLFrames.jsp?"+queryString+"&Diag_code="+Diag_groupcode+"&Diag_desc="+java.net.URLEncoder.encode(Diag_groupdesc)+"\" onClick=\"changeRowColor(tbl_row"+rowCount+")\" target='code_description'>");
			out.println(Diag_groupdesc+"</a></td></tr>");
			
			rowCount++;
		}
		
	if (rset!=null) rset.close();
	if (stmt!=null) stmt.close();

	if(rowCount == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
	}

}
catch  (Exception e) {
	 e.printStackTrace();
}

finally
{
   if(conn!=null)
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

