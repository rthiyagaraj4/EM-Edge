<!--
CRF Reference No     :  NMC-JD-CRF-102.18
Detected Release  No      :  MARCH 2024 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  13-03-2024
Purpose of the Change   :  As a PAS user I should be able to record external referrals as well as display "Nphies orders" lookup field to select Nphies orders a multi-selection of orders and thus the selected orders will be displayed in referral screen. 
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All Sites    
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*,java.text.SimpleDateFormat,java.util.Date"%>
<%
	String sStyle = checkForNull((String) session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>
<html>
<head>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	Statement stmt = null;
	ResultSet rs = null;
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	String locale = (String) session.getAttribute("LOCALE");
	String facility_id = (String) session.getValue("facility_id");
	
	String searchText=request.getParameter("searchText");
	String searchCriteria=request.getParameter("searchCriteria");
	String radioval=request.getParameter("radioval");
	String selectedCodeDtl=request.getParameter("selectedCodeDtl");
	
	String[] checkedNPHCode=null;
	if(selectedCodeDtl!=null){
		checkedNPHCode = selectedCodeDtl.split("~");
	}
	
	String NPMType = "";
	String NPHCode = "";
	String longDesc = "";
	String shortDesc = "";
	String effStatus = "";
	String checked="";
	String quantity="";
	
	int maxRecord=0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int records_to_show=10;
	String from = request.getParameter("from");
	String to = request.getParameter("to");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src="../js/RecordProcedure.js" language="javascript"></script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="RecProcedureResult" id="RecProcedureResult">
<%
	try {
		StringBuffer sql			= new StringBuffer();
		sql.append("SELECT NPH_TYPE, NPH_CODE, LONG_DESC, SHORT_DESC from MR_NPH_CODE where EFF_STATUS='E' ");
		
		if(!checkForNull(searchText).equals("")){
			if(radioval.equals("C")){
				if(searchCriteria.equals("S")){
					sql.append("and UPPER (NPH_CODE) like UPPER ('"+searchText+"%')");	
				} else if(searchCriteria.equals("E")){
					sql.append("and UPPER (NPH_CODE) like UPPER ('%"+searchText+"')");	
				} else if(searchCriteria.equals("C")){
					sql.append("and UPPER (NPH_CODE) like UPPER ('%"+searchText+"%')");	
				}
				
			}else if(radioval.equals("D")){
				if(searchCriteria.equals("S")){
					sql.append("and UPPER (LONG_DESC) like UPPER ('"+searchText+"%')");	
				} else if(searchCriteria.equals("E")){
					sql.append("and UPPER (LONG_DESC) like UPPER ('%"+searchText+"')");	
				} else if(searchCriteria.equals("C")){
					sql.append("and UPPER (LONG_DESC) like UPPER ('%"+searchText+"%')");	
				}
			}
		}
		
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql.toString());
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
				
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		
		//con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql.toString());
		rst = pstmt.executeQuery();
		if ( from == null )
		start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = records_to_show ;
		else
			end = Integer.parseInt( to ) ;	
		
		%>
		<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rst.next() ;
	  	  String classValue = "" ;
		  int cnt=0;
		  %>
		  <table align='right'>
		<tr>
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right'><font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font></td>");

		%>	
			<td align ='right' id='next' style='visibility:hidden'>
		<%
			out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
			
		<table class='grid' id='PatResultTbl' border="1" cellpadding="1" cellspacing="0" width="100%">
			<th align="center" nowrap><fmt:message
						key="Common.nphiesDesc.label" bundle="${common_labels}" /></th>
				<th align="center" nowrap><fmt:message
						key="Common.nphiescode.label" bundle="${common_labels}" /></th>
				<th align="center" nowrap><fmt:message
						key="Common.defaultSelect.label" bundle="${common_labels}" /></th>
			  <%
				
		while (i<=end  && rst.next()) {
				if(cnt==0)
		{		
			%>
			
			<%
	}
			NPMType = checkForNull(rst.getString(1));
			NPHCode = checkForNull(rst.getString(2));
			longDesc = checkForNull(rst.getString(3));
			shortDesc = checkForNull(rst.getString(4));
			checked="";
			quantity="1";
			if(checkedNPHCode!=null){
				for (int j = 0; j < checkedNPHCode.length; j++) {
					if(checkedNPHCode[j].contains("*")){
						String[] nphCodeQuantity = checkedNPHCode[j].split("\\*");
						if(nphCodeQuantity[0].equals(NPHCode)){
							checked="checked";
							quantity=nphCodeQuantity[2];
							break;
						}
					} else {
						if(checkedNPHCode[j].equals(NPHCode)){
							checked="checked";
							break;
						}
					}
				}
			}
%>
			<tr>
				<td nowrap style='word-wrap: break-word; width: 550px;'><%=longDesc%></td>
				<!-- <td nowrap style='word-wrap: break-word; width: 200px;'></td> -->
				<td nowrap><%=NPHCode%></td>
				<td nowrap><input type="checkbox" name="chk<%=NPHCode%>" id='chk<%=NPHCode%>' <%=checked%> onclick="bulkOrder('<%=NPHCode%>','<%=longDesc%>','<%=quantity%>',this)"> 
	<%
				i++;
	cnt++;
	}

 		if (cnt==0){	
 				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));"+
 				"parent.RecProcedure_result.location.href = '../../eCommon/html/blank.html';</script>");
 			}
 			boolean flag = false;

 			if (cnt < 10 || (!rst.next())) {
 	%>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
	<%}%>

</td></tr>
</table>

<% 
if (cnt > 0){ %>
<input style="float: right;" type="button" class="button"
			name="okBtn" id="okBtn" value='ok' onClick="submitCode()">

<%} %>		
	
<input type="hidden" id="start" name="start" id="start" value="<%=start%>">
<input type="hidden" id="records_to_show" name="records_to_show" id="records_to_show" value="<%=records_to_show%>">
<input type="hidden" id="end" name="end" id="end" value="<%=end%>">
<input type="hidden" id="searchText" name="searchText" id="searchText" value="<%=searchText%>">
<input type="hidden" id="searchCriteria" name="searchCriteria" id="searchCriteria" value="<%=searchCriteria%>">
<input type="hidden" id="radioval" name="radioval" id="radioval" value="<%=radioval%>">
<input type="hidden" id="selectedCodeDtl" name="selectedCodeDtl" id="selectedCodeDtl" value="<%=selectedCodeDtl%>">


<%
		if (pstmt != null)
			pstmt.close();
		if (rst != null)
			rst.close();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con, request);
	}
%>

</form>
</body>
</html>
<%!public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}%>

