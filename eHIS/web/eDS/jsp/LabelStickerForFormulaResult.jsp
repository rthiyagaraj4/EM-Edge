<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0687 -->
<%@  page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eDS.Common.JSONObject,java.net.URLEncoder,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean" />
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='Javascript' src='../../eDS/js/LabelStickerForFormula.js'></script>
<script language="Javascript" src="../../eDS/js/json.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script  src="../../eCommon/js/jquery-ui.js" language="JavaScript"></script>  

<script type="text/javascript">
	var OrderIDString = "";
	function bulkOrder(OrderID, obj) {
		OrderID = "'" + OrderID + "'";
		if (obj.checked) {
			if (OrderIDString == null || OrderIDString == "") {
				OrderIDString = OrderID;
			} else {
				OrderIDString = OrderIDString + "," + OrderID;
			}

		} else {
			var arrayRemove = new Array();
			arrayRemove = OrderIDString.split(',');
			var index = 0;
			var countRemove = 0;
			for (var j = 0; j < arrayRemove.length; j++) {
				if (arrayRemove[j] == OrderID) {
					countRemove++;
					index = j;
				}
			}
			if (countRemove > 0) {
				arrayRemove.splice(index, 1);
				OrderIDString = arrayRemove.toString();
			}

		}
		
		var View_label = parent.label_query.document.getElementById("View_label");
		var Print_label = parent.label_query.document.getElementById("Print_label");
		if(OrderIDString == null || OrderIDString == ""){
			$(View_label).prop('disabled', true);
			$(Print_label).prop('disabled', true);
		} else {
			$(View_label).prop('disabled', false);
			$(Print_label).prop('disabled', false);
		}
		parent.label_query.document.getElementById("OrderID_param").value = OrderIDString;
	}
</script>
<html>
<head>
<!-- Heading Static - Scrolling -->
<style>
TD.OTMENULAYER {
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 10PT;
	BACKGROUND-COLOR: #D8BFD8;
	COLOR: WHITE;
}

TD.OTMENU {
	BACKGROUND-COLOR: #C0C0C0;
	FONT-SIZE: 9PT;
	BORDER-STYLE: DASHED;
	BORDER-LEFT-COLOR: #FFA500;
	BORDER-RIGHT-COLOR: #FFA500;
	BORDER-TOP-COLOR: #FFFACD;
	BORDER-BOTTOM-COLOR: #FFFACD;
}

TD.OTCLASS {
	FONT-SIZE: 9pt;
	BORDER-STYLE: SOLID;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height: 30;
}

.menu {
	text-align: left;
	position: absolute;
	width: '1300px'
}

div.tableContainer {
	width: 100%; /* table width will be 99% of this*/
	height: 400px; /* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}

table {
	/*width: 100%; 100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
}

table>tbody {
	/* child selector syntax which IE6 and older do not support*/
	overflow: auto;
	height: 250px;
	overflow-x: hidden;
}

thead tr {
	position: relative;
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
}
</style>
<!-- Heading Static - Scrolling -->
<%System.err.println("====LabelStickerForFormulaQuery.jsp called====");
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip		= "";
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";

	String authorizedFromDateTime = checkForNull(request.getParameter("authorizedFromDateTime"));
	String authorizedToDateTime = checkForNull(request.getParameter("authorizedToDateTime"));
	String nursingUnit = checkForNull(request.getParameter("nursingUnit"));
	String PatientId = checkForNull(request.getParameter("patientId"));
	
	String PatientName = "";
	String EncounterID = "";
	String Age = "";
	String Ward = "";
	String Specialty = "";
	String Room = "";
	String Bed = "";
	String OrderType = "";
	String OrderCatalog = "";
	String Quantity = "";
	String OrderedDate = "";
	String AuthorizedDate  = "";
	String OrderPlacedBy  = "";
	String OrderID="";
	String OrderLineNum="";
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	
	int maxRecord=0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int records_to_show=20;
	String from = request.getParameter("from");
	String to = request.getParameter("to");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
	scrolling="no">

	<form name='QueryResult' id='QueryResult'>

		<fmt:setLocale value="<%=locale %>" />
		<%
try{
		StringBuffer sql			= new StringBuffer();
		sql.append("SELECT PATIENT_ID, PATIENT_NAME, ENCOUNTER_ID, AGE, NURSING_UNIT, SPECIALITY, ROOM_NUM, BED_NUM, ORDER_TYPE, ORDER_CATALOG, to_char(ORD_DATE_TIME,'dd/mm/yyyy hh24:mi'),  to_char(ORD_AUTH_DATE_TIME,'dd/mm/yyyy hh24:mi'), ADDED_BY_ID,QUANTITY,ORDER_ID,ORDER_LINE_NUM FROM DS_LABEL_STICKER_VW WHERE ORD_AUTH_DATE_TIME BETWEEN to_date('" + authorizedFromDateTime + "','dd/mm/yyyy hh24:mi') and to_date('" + authorizedToDateTime + "','dd/mm/yyyy hh24:mi')"); //ORDER_LINE_NUM added against ML-MMOH-SCF-2488
		
		if(!PatientId.equals("") || PatientId != null)
		{
		sql.append(" AND PATIENT_ID=NVL('"+PatientId+"',PATIENT_ID)");
		}
			 
		if(!nursingUnit.equals("") || nursingUnit != null)
		{
		sql.append(" AND NURSING_UNIT_CODE=NVL('"+nursingUnit+"',NURSING_UNIT_CODE)");
		}
		
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
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
		con = ConnectionManager.getConnection(request);
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
					key="Common.patientId.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="Common.PatientName.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="Common.encounterid.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.age.label"
					bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.Ward.label"
					bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="Common.Specialty.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.room.label"
					bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message key="Common.Bed.label"
					bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="Common.OrderType.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="Common.ordercatalog.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="Common.Quantity.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="eDS.OrderedDate.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="eDS.AuthorizedDate.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="eDS.OrderPlacedBy.label" bundle="${common_labels}" /></th>
			<th align="center" nowrap><fmt:message
					key="Common.defaultSelect.label" bundle="${common_labels}" /></th>
		  <%
		    
	while (i<=end  && rst.next()) {
			if(cnt==0)
	{		
		%>
		
		
		<%
	}
			PatientId = checkForNull(rst.getString(1));
			PatientName = checkForNull(rst.getString(2));
			EncounterID = checkForNull(rst.getString(3));
			Age = checkForNull(rst.getString(4));
			Ward = checkForNull(rst.getString(5));
			Specialty = checkForNull(rst.getString(6));
			Room = checkForNull(rst.getString(7));
			Bed = checkForNull(rst.getString(8));
			OrderType = checkForNull(rst.getString(9));
			OrderCatalog = checkForNull(rst.getString(10));
			OrderedDate = checkForNull(rst.getString(11));
			AuthorizedDate  = checkForNull(rst.getString(12));
			OrderPlacedBy  = checkForNull(rst.getString(13));
			Quantity = checkForNull(rst.getString(14));
			OrderID = checkForNull(rst.getString(15));
			//Added Against ML-MMOH-SCF-2488
			OrderLineNum = checkForNull(rst.getString(16));
			OrderID = "" + OrderID + OrderLineNum;
			 
%>
			<tr>
				<td nowrap><%=PatientId%></td>
				<td nowrap style='word-wrap: break-word; width: 200px;'><%=PatientName%></td>
				<td nowrap><%=EncounterID%></td>
				<td nowrap><%=Age%></td>
				<td nowrap><%=Ward%></td>
				<td nowrap><%=Specialty%></td>
				<td nowrap><%=Room%></td>
				<td nowrap><%=Bed%></td>
				<td nowrap><%=OrderType%></td>
				<td nowrap><%=OrderCatalog%></td>
				<td nowrap><%=Quantity%></td>
				<td nowrap><%=OrderedDate%></td>
				<td nowrap><%=AuthorizedDate%></td>
				<td nowrap><%=OrderPlacedBy%></td>
				<td nowrap><input type="checkbox" name="chk<%=OrderID%>" id="chk<%=OrderID%>" id='chk<%=OrderID%>' onclick="bulkOrder('<%=OrderID%>',this)"> 
	<%
				i++;
	cnt++;
	}

	if (cnt==0){	
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}
	boolean flag = false;
	 
	if ( cnt < 20 || (!rst.next()) ) { %>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}%>

</td></tr>
</table>

<%
	if(pstmt!=null)	pstmt.close();
	if(rst!=null)	rst.close();
	}catch(Exception e){
	   e.printStackTrace();		
	}finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
<input type="hidden" id="start" name="start" id="start" value=<%=start%>>
<input type="hidden" id="records_to_show" name="records_to_show" id="records_to_show" value=<%=records_to_show%>>
<input type="hidden" id="end" name="end" id="end" value=<%=end%>>
<input type="hidden" id="authorizedFromDateTime" name="authorizedFromDateTime" id="authorizedFromDateTime" value=<%=authorizedFromDateTime%>>
<input type="hidden" id="authorizedToDateTime" name="authorizedToDateTime" id="authorizedToDateTime" value=<%=authorizedToDateTime%>>
<input type="hidden" id="nursingUnit" name="nursingUnit" id="nursingUnit" value=<%=nursingUnit%>>
<input type="hidden" id="PatientId" name="PatientId" id="PatientId" value=<%=PatientId%>>
		</table>
		<br>
	</form>

</body>
<script>
function clearCheckedData(){
	parent.label_query.document.getElementById("OrderID_param").value="";
}
</script>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>

