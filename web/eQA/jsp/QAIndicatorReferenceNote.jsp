<!DOCTYPE html>
<html>
<head>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/Common.js" language="javascript"> </script>
<Script src="../../eCommon/js/messages.js" language="JavaScript"></Script>
</head>
<Script src="../../eQA/js/QADirRecordOfClinIndicators.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>
<form name="QAReferrenceNote" id="QAReferrenceNote" method="post" >

<%!
String strQindDesc = "";
String strStandardDesc = "";
String strAreaOfConcern = "";
String QIND_DISCIPLINE_DESC1="";
//QIND_DISCIPLINE_DESC1=request.getParameter("QIND_DISCIPLINE_DESC")==null?"": request.getParameter("QIND_DISCIPLINE_DESC");

int count=0;

 String strClinicalIndicatorId,indicator; 
 int value;

 %>

 <%
 	strClinicalIndicatorId=request.getParameter("QIND_CLIND_ID");
	QIND_DISCIPLINE_DESC1=request.getParameter("QIND_DISCIPLINE_DESC")==null?"": request.getParameter("QIND_DISCIPLINE_DESC");
 %>

 <table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
  <tr>
  	<td width='15%'>&nbsp;</td>
  	<td width='85%'>&nbsp;</td>
  </tr>

	<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuffer sqlBuff = new StringBuffer();
	StringBuffer sql1Buff = new StringBuffer();

	ArrayList htVect = new ArrayList();
	count=0;
    int prevalue=0;
 
    sqlBuff.append("select QIND_CLIND_ID QCLIND,QIND_CLIND_DESC QCLIDES, ");
	sqlBuff.append(" STANDARD_DESC   STDES,AREA_OF_CONCERN AOC ");
	sqlBuff.append(" from QA_QIND_CLIND where QIND_CLIND_ID= ? ");
	try
		{
			conn = ConnectionManager.getConnection(request);
			pstmt=conn.prepareStatement(sqlBuff.toString());
			pstmt.setString(1,strClinicalIndicatorId);
			rs=pstmt.executeQuery();

		while(rs.next())
		{	 
		 strQindDesc = rs.getString("QCLIDES")==null? "":rs.getString("QCLIDES");;
		 strStandardDesc =rs.getString("STDES")==null? "":rs.getString("STDES");
		 strAreaOfConcern = rs.getString("AOC")==null? "":rs.getString("AOC");
		}	
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();

	    out.println("<TITLE align='center'>"+strQindDesc+"</TITLE>");
	    
		htVect.add(count++,"<td class='label' align='left' nowrap><b>Program </b></td>"+"<td class='label' align='left'> <p>&nbsp;PATIENT CARE</p></td>");



		htVect.add(count++,"<td class='label' align='left' nowrap><b>Area of Concern:</b></td>"+"<td class='label' align='left' ><p> &nbsp;"+strAreaOfConcern+"</p></td>");
	
		 htVect.add(count++,"<td class='label' align='left'nowrap><b>Indicator:</b></td>"+"<td class='label' align='left'><p> &nbsp;"+strQindDesc+"</p></td>");
	
        sql1Buff.append("select  NVL(REF_NOTE_TEXT,' ') REF_NOT,SECTION_ID SID from ");
		sql1Buff.append("QA_QIND_CLIND_REF_NOTE  where QIND_CLIND_ID=? order by SECTION_ID ");

		pstmt=conn.prepareStatement(sql1Buff.toString());
		pstmt.setString(1,strClinicalIndicatorId);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
				value=Integer.parseInt(rs.getString("SID"));			
				if(value !=100)
				value=value/10;
				indicator = "";
				switch(value)
				{
					case 3:indicator ="Rationale:";					
					break;
					case 4:indicator ="Definition of Terms:"; break;
					case 5:indicator ="Inclusion Criteria:";break; 
					case 6:indicator ="Exclusion Criteria:"; break;
					case 8:indicator ="Numerator:"; break;
					case 9:indicator ="Denominator:"; break;
					case 100:indicator ="Comments / Review:";break;
				}
		if(value !=prevalue)
		indicator = "<td class='label'  align='left' nowrap><b>"+indicator+"</b></td>	 <td class='label' align='left'> <p > &nbsp;" + 		rs.getString("REF_NOT")+"</p></td>";
		else	 indicator = 
			"<td class='label'  > <b>&nbsp;</b></td>	 <td align='left' class='label'> <p > &nbsp;" + 		rs.getString("REF_NOT")+"</p></td>";	

				htVect.add(indicator);	
				count++;
				prevalue=value;
			}	
			
				indicator = "<td class='label' align='left' nowrap> <b>Standard: </b> </td> <td align='left'> <p class='label'>&nbsp; " + strStandardDesc+"</p></td>";
				htVect.add(count,indicator);
			
				rs.close();
		
		for(count=0;count<htVect.size();count++)
		{
			out.println("<tr>");
			out.println(""+htVect.get(count));
			out.println("</tr> ");
			out.println("<tr><td colspan=4>&nbsp</td></tr>");
		}
		out.println("</table>");
	    if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
	htVect.clear();
	}catch(Exception ee)
	{%>
	Exception Occured <%=ee%>
	<%}
	finally
	{
			ConnectionManager.returnConnection(conn,request);
	}%>
</form>
</body>
</html>

