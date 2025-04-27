<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript">
<!--
function scrollTitle(){
	  var y = document.body.scrollTop;

	  if(y == 0){
		document.getElementById("divDataTitle").style.position = 'static';
		document.getElementById("divDataTitle").style.posTop  = 0;
	  }else{
		document.getElementById("divDataTitle").style.position = 'relative';
		document.getElementById("divDataTitle").style.posTop  = y-2;
	  }
	}
	function alignWidth(){		
		var totalRows =  document.getElementById("dataTable").rows.length;		
		var counter = totalRows-1;
		//alert(document.getElementById("dataTitleTable").rows.length);
		var temp = document.getElementById("dataTitleTable").rows[0].cells.length;
		for(var i=0;i<temp;i++) 
		{
			document.getElementById("dataTitleTable").rows[0].cells[i].width = document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
		}
	}
	function close_window(diag_code)
	{
		window.parent.parent.parent.returnValue=diag_code;
		window.parent.parent.parent.close();
	}
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

        java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	String facility_id = "";
	String encounter_id = "";

	String complaint_desc = "";
	String short_desc = "";
	String complaint_id = "";
	String dup_complaint_desc = "";
	String dup_term_set_desc = "";
	String diag_code = "";
	String term_set_desc = "";
	String mode = "";
	//int diag_repeat_cnt = 0;
	
	String classValue = "";
	int i = 0;
	int count = 0,cnt=0;

	facility_id=(String) session.getValue("facility_id");
	encounter_id = request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
	complaint_id = request.getParameter("complaint_id")==null?"":request.getParameter("complaint_id");
	complaint_id=complaint_id;
	mode = request.getParameter("mode")==null?"":request.getParameter("mode");

	%>
</head>
<body onScroll='scrollTitle()' onKeyDown="lockKey()">
	<form name='RecPatChiefComplaintDiagViewResultForm' id='RecPatChiefComplaintDiagViewResultForm'>
<%
try
{
	con	= ConnectionManager.getConnection();
	
	//sql = " SELECT  c.diag_code,b.complaint_desc, nvl(c.short_desc,'Not Available') short_desc,(select count(*) from ca_chief_complaint_diag ia,ca_encntr_chief_complaint ib where ib.facility_id = ? AND ib.encounter_id = ? and ia.COMPLAINT_ID=ib.complaint_id and ia.diag_srl_no= ia.diag_srl_no and ia.diag_code = ia.diag_code) diag_repeat_cnt FROM ca_chief_complaint_diag a, ca_chief_complaint b, mr_icd_code c   WHERE b.complaint_id IN (SELECT complaint_id FROM ca_encntr_chief_complaint      WHERE facility_id = ? AND encounter_id = ? ) AND c.diag_srl_no(+) = a.diag_srl_no and a.complaint_id(+)=b.complaint_id ORDER BY b.complaint_desc, short_desc";

	sql = "SELECT  d.term_set_desc term_set_desc, a.term_code diag_code,b.complaint_desc, nvl(c.short_desc,'Not Available') short_desc FROM  CA_CHIEF_COMP_TERM_CODE a, ca_chief_complaint_lang_vw b, mr_term_code c,mr_term_set d  WHERE b.language_id = ?  and b.complaint_id IN (SELECT complaint_id FROM ca_encntr_chief_complaint WHERE facility_id = ? AND encounter_id = ? ) and a.complaint_id(+)=b.complaint_id and c.term_set_id(+)=a.term_set_id  and c.term_code(+)=a.term_code  and d.term_set_id(+)=a.term_set_id ORDER BY  b.complaint_desc,d.term_set_desc, c.short_desc ";

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,facility_id);
	pstmt.setString(3,encounter_id);

	
	rs = pstmt.executeQuery();
	
%>
 <div id='divDataTitle' style='postion:relative'>
<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
	<tr>
		<td class='COLUMNHEADERCENTER' width='30%'><fmt:message key="eCA.ComplaintDescription.label" bundle="${ca_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='50%'><fmt:message key="eCA.TermDescription.label" bundle="${ca_labels}"/></td>
	</tr>
</table>
</div>

	<table   width='100%' id='dataTable' class='grid'>
<%
	while(rs.next())
	{
		
		if(!complaint_desc.equals(dup_complaint_desc))
			cnt++;
		
		if(!term_set_desc.equals(dup_term_set_desc))
			cnt++;
		

	/*if(mode.equals("DiagSearch"))
	{
		if (cnt % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
	}
	else
	{
		if ((count-1) % 2 == 0 )
			classValue = "QRYEVEN" ;	
		else
			classValue = "QRYODD" ;		
	} */
	i++;
		complaint_desc = rs.getString("complaint_desc")==null?"":rs.getString("complaint_desc");
		short_desc = rs.getString("short_desc")==null?"":rs.getString("short_desc");
		diag_code = rs.getString("diag_code")==null?"":rs.getString("diag_code");
		term_set_desc = rs.getString("term_set_desc")==null?"":rs.getString("term_set_desc");
		//diag_repeat_cnt = rs.getInt("diag_repeat_cnt");

	out.println("<tr align='left'>");

	if(!(short_desc.equals("Not Available") && mode.equals("DiagSearch")))
	{
		
		if(!complaint_desc.equals(dup_complaint_desc) )
		{
			if (classValue.equals( "QRYODD"))
				classValue = "QRYEVEN";
			else
				classValue = "QRYODD";
		
			out.println("<td class='gridData' width='35%'>"+(count+1)+".  "+complaint_desc+"</td>");
			count++;
			i=0;
			
		}
		else
		{
			out.println("<td class='gridData' width='35%'>&nbsp;</td>");
		}
			
		if(!(short_desc.equals("Not Available") && mode.equals("DiagSearch")))
		{
				if(!(term_set_desc.equals(dup_term_set_desc) && complaint_desc.equals(dup_complaint_desc) ))
	          {
                  out.println("<td class='gridData' width='30%'>"+term_set_desc+"</td>");
			  }
			
		        else
		      {
			     out.println("<td class='gridData' width='30%'>&nbsp;</td>");

		      }
		}
			
		
		if(mode.equals("DiagSearch"))
		{
			out.println("<td class='gridData' width='25%'><a href='javascript:close_window(\""+diag_code+"\")'> "+(i+1)+"."+short_desc+" ("+diag_code+") </a></td>");
		}
		else
		{
				if(short_desc.equals("Not Available"))
						out.println("<td class='gridData' width='25%'>"+(i+1)+"."+short_desc+" </td>");			
				else
						out.println("<td class='gridData' width='25%'>"+(i+1)+"."+short_desc+" ("+diag_code+") </td>");			
			
		}
		
		dup_complaint_desc = complaint_desc;
		dup_term_set_desc = term_set_desc;
		out.println("</tr>");	
	}
}
	
%>
<tr style='visibility:hidden'>
		<td class='COLUMNHEADERCENTER' width='30%'><fmt:message key="eCA.ComplaintDescription.label" bundle="${ca_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='50%'><fmt:message key="eCA.TermDescription.label" bundle="${ca_labels}"/></td>
</tr>	
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
<script>alignWidth()</script>

