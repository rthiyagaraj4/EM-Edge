<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.* "  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>
<head>
<%

	request.setCharacterEncoding("UTF-8");
//String complaint_desc = request.getParameter("complaint_desc");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function scrollTitle()
{
	  var y = document.body.scrollTop;

	  if(y == 0){
		document.getElementById("divDataTitle").style.position = 'static';
		document.getElementById("divDataTitle").style.posTop  = 0;
	  }else{
		document.getElementById("divDataTitle").style.position = 'relative';
		document.getElementById("divDataTitle").style.posTop  = y-2;
	  }
}
function alignWidth()
{		
		var totalRows =  document.getElementById("dataTable").rows.length;		
		var counter = totalRows-1;
		var temp = document.getElementById("dataTitleTable").rows[0].cells.length;

		for(var i=0;i<temp;i++) 
		{
			if(document.getElementById("dataTable").rows.length>0)
			{
				document.getElementById("dataTitleTable").rows[0].cells[i].width = document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
			}
		}
	}
</script>
<%

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	String facility_id = "";
	String encounter_id = "";
	String short_desc = "";
	String complaint_id = "";
	//String diag_code = "";
	String term_set_desc = "";
	
	String classValue = "";
	int i = 0;

	facility_id		=	(String) session.getValue("facility_id");
	encounter_id	=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	complaint_id	=	request.getParameter("complaint_id")==null?"":request.getParameter("complaint_id");

	%>
</head>
<body onScroll='scrollTitle()' onKeyDown="lockKey()">
	<form name='RecPatChiefComplaintDiagViewResultForm' id='RecPatChiefComplaintDiagViewResultForm'>
<%
try
{
	String strTitle = "";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	con	= ConnectionManager.getConnection();
	
	sql = "SELECT CA_GET_DESC.CA_CHIEF_COMPLAINT(?,?,'2') complaint_desc FROM DUAL";

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,complaint_id);
	pstmt.setString(2,locale);

	rs = pstmt.executeQuery();

	if(rs.next())
		strTitle = rs.getString("COMPLAINT_DESC");


	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	//sql = "SELECT   c.short_desc short_desc,c.diag_code FROM ca_chief_complaint_diag a,  mr_icd_code c   WHERE a.complaint_id IN (SELECT complaint_id FROM ca_encntr_chief_complaint   WHERE facility_id = ?  AND encounter_id = ? AND a.complaint_id = ?) AND c.diag_srl_no = a.diag_srl_no ORDER BY   c.short_desc";

	sql = " select B.TERM_SET_DESC, C.SHORT_DESC||'('||c.TERM_CODE||')' TERM_DESC from CA_CHIEF_COMP_TERM_CODE a, mr_term_set b, mr_term_code c where a. COMPLAINT_ID  =? and b.term_set_id=a.TERM_SET_ID and c.term_set_id=a.TERM_SET_ID and c.TERM_CODE=A.TERM_CODE";

	
	pstmt = con.prepareStatement(sql);
	//pstmt.setString(1,facility_id);
	//pstmt.setString(2,encounter_id);
	pstmt.setString(1,complaint_id);
	rs = pstmt.executeQuery();
	
%>
 <div id='divDataTitle' style='postion:relative'>
<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
	<tr>
		<td class='COLUMNHEADERCENTER' width='50%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='50%'><fmt:message key="eCA.TermDescription.label" bundle="${ca_labels}"/></td>
	</tr>
</table>
</div>
	<table  width='100%' id='dataTable' class='grid'>
<%
	while(rs.next())
	{
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		term_set_desc = rs.getString("TERM_SET_DESC")==null?"":rs.getString("TERM_SET_DESC");
		short_desc = rs.getString("TERM_DESC")==null?"":rs.getString("TERM_DESC");
		
		out.println("<tr align='left'><td class='gridData' width='50%'>"+term_set_desc+"</td>");
		out.println("<td class='gridData' width='50%'>"+short_desc+"");
		out.println("</td></tr>"); 

		i++;
	}
	
	if(i==0)
	{
		out.println("<script>alert(getMessage('DIAG_NOT_AVAILABLE','CA'));const dialogTag = parent.parent.document.getElementById('dialog_tag').close();;</script>");
	}

%>
	</table>
	</form>
</body>
</html>
<%
	if(pstmt!=null)
		pstmt.close();
	if(rs!=null)
		rs.close();
}
catch(Exception ex)
{
	//out.println("Exception @ try"+ex.toString());//COMMON-ICN-0181
	ex.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>
<script>alignWidth();</script>

