<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>			
		<script language='javascript' src="../js/MedRecRequestMain.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	<body onKeyDown='lockKey()'>
	<% //out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
		request.setCharacterEncoding("UTF-8"); 
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String PatientId		=	checkForNull(request.getParameter("PatientId") );
		String from		        =	checkForNull(request.getParameter("from") );
		String to				=	checkForNull(request.getParameter("to") );
		String finalSelect		=	checkForNull(request.getParameter("finalSelect") );
		String selitem   		=	checkForNull(request.getParameter("selitem") );
		String disable="";
		int count_req=0;
		Connection con               = null;
   	    PreparedStatement pst		 = null;
        ResultSet rset               = null ;
		try{
			
		
		con                  = ConnectionManager.getConnection(request);
		StringBuffer sqlPr = new StringBuffer();
		sqlPr.append("SELECT  count(*) count  FROM mr_report_request_hdr_vw where patient_id='"+PatientId+"'  AND request_status='6' ");//Modified by Thamizh selvi for ML-MMOH-SCF-0666 on 8th Mar 2017
		pst = con.prepareStatement(sqlPr.toString());
		rset=pst.executeQuery();
		 while(rset!=null && rset.next()){
			 
			 count_req=rset.getInt(1);
			 
		 }
		}
		catch(Exception ex){

			//out.println(ex);
			ex.printStackTrace();
		}
		finally{
			con.close();
			pst.close();
			rset.close();
			
		}
		
		if(count_req==0)
		disable="disabled";
	%>
		<form name="frmButton" id="frmButton">
			<table cellspacing=0 cellpadding=0 width=100%>
				<tr>
					<td width="75%" class="label">&nbsp;</td>
					<td width="25%" class='button'><input type='button' name='showPrevDtls' id='showPrevDtls' <%=disable%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PrevDelMedReport.label","mr_labels")%>' class='button' onclick='showPrevDelReports()' ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReport.label","mr_labels")%>' class='button' onclick='showModalCurEnc()' disabled></td>
				</tr>
			</table>
			<input type="hidden" name="selitem" id="selitem" value=<%=selitem%>>
			<input type="hidden" name="PatientId" id="PatientId" value=<%=PatientId%>>
			<input type="hidden" name="from" id="from" value=<%=from%>>
			<input type="hidden" name="to" id="to" value=<%=to%>>
			<input type=hidden name='finalSelect' id='finalSelect' value=<%=finalSelect%>>
		</form>
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

