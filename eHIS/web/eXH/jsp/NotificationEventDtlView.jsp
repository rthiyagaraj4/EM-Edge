<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0687 -->
<%@  page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eDS.Common.JSONObject,java.net.URLEncoder,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eXH/js/NotificationEventSetup.js" ></script>


<script type="text/javascript">
var CheckedElementId = "";
function validatecheckbox(obj,ElementID, AppId) {
	CheckedElementId = QueryResult.document.getElementById("checkedEventsId").value;
	
	var checkedElementArray = new Array();
	checkedElementArray = CheckedElementId.split(',');
		
	for (var i = 0; i < checkedElementArray.length; i++) {
			var appElementIdArray = new Array();
			appElementIdArray = checkedElementArray[i].split('$!^');
			var appId = appElementIdArray[0];
			var elementId = appElementIdArray[1];
			if (obj.checked && ElementID == elementId && appId == AppId){
				checkedElementArray[i] = appId+"$!^"+elementId+"$!^Y";
			} else if(ElementID == elementId && appId == AppId) {
				checkedElementArray[i] = appId+"$!^"+elementId+"$!^N";
			}
		}
	
	//alert("CheckedElementId="+CheckedElementId);
	document.getElementById("checkedEventsId").value = checkedElementArray;
	
}

function funAction(typ){
	this.document.forms[0].target = "";
//	alert(parent.parent.frames[3].name);
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	this.document.forms[0].action_type.value = typ;
	this.document.forms[0].action = '../../eXH/jsp/EventTypeMessageTypeDisplay.jsp';
	this.document.forms[0].submit();
}
</script>
<html>
<head>
<!-- Heading Static - Scrolling -->
<style>
</style>
<!-- Heading Static - Scrolling -->
<%
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties) httpSession.getValue("jdbc");

	String strloggeduser = (String) httpSession.getValue("login_user");
	String strclientip = "";
	strclientip = p.getProperty("client_ip_address");
	String facility_id = (String) session.getAttribute("facility_id");
	if (sStyle == null)
		sStyle = "IeStyle.css";

	String strApplicationID = checkForNull(request.getParameter("Application_ID"));

	String Element_Id = "";
	String In_Use_Yn = "";
	String APPLICATION_ID = "";	

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	int maxRecord = 0;
	int start = 0;
	int end = 0;
	int i = 1;
	int records_to_show = 16;
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	String checkedData="";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
	scrolling="no">

	<form name="QueryResult" id="QueryResult" method="post" action='../../servlet/eXH.InvokeEGLapplication' target="messageFrame">

		<fmt:setLocale value="<%=locale %>" />
		<%
			try {
				String sql = "Select ELEMENT_ID, APPLICATION_ID, ELEMENT_VALUE, IN_USE_YN From XH_APPL_ELEMENT Where Application_Id = '"
						+ strApplicationID + "' Order By To_Number(ELE_POS)";

				if (rst != null)
					rst.close();
				if (pstmt != null)
					pstmt.close();
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql);
				rst = pstmt.executeQuery();
				int total = 0;
				while (rst.next()) {
					total++;
				}
				maxRecord = total;

				if (rst != null)
					rst.close();
				if (pstmt != null)
					pstmt.close();
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql.toString());
				rst = pstmt.executeQuery();
				if (from == null)
					start = 1;
				else
					start = Integer.parseInt(from);

				if (to == null)
					end = records_to_show;
				else
					end = Integer.parseInt(to);
		%>
		<%
			if (start != 1)
					for (int j = 1; j < start; i++, j++)
						rst.next();
				String classValue = "";
				int cnt = 0;
		%>
		 <table align='right'>
          <tr>
          <%
            if (!(start <= 1)) {
        %>
            <td align='right'>
                <font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal'
                    onclick='previous()'>
                    <%= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.previous.label", "common_labels") %>
                </font>
            </td>
           <%
            }
           %>  
               <td align='right' id='next' style='visibility:hidden'>
         <%
                out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onclick='next()'>"
                     + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.next.label", "common_labels")
                    + "</font>");
    %>
</td>
</tr>
</table>

			</br></br>
		
			<table class='grid' id='NotifyResultTbl' border="1" cellpadding="1" cellspacing="0" width="100%">
			<tr>
			<th align="center" nowrap><fmt:message key="eXH.NotificationDetails.label" bundle="${xh_labels}"/></th>
			<th align="center" nowrap><fmt:message key="eXH.Select.label" bundle="${xh_labels}"/></th>
			</tr>
			
		  <%
					  	while (i <= end && rst.next()) {
					  			if (cnt == 0) {
					  %>
		<%
							}
					  			Element_Id = checkForNull(rst.getString(1));
								In_Use_Yn = (checkForNull(rst.getString(4)).equals("Y"))?rst.getString(4):"N";
								APPLICATION_ID = checkForNull(rst.getString(2));
								String appElementId = APPLICATION_ID+"$!^"+Element_Id+"$!^"+In_Use_Yn;
								if(checkedData==""){
									checkedData=appElementId;
								} else {
									checkedData=checkedData+","+appElementId;
								}
									//System.err.println("checkedData====== "+checkedData);
						%>
			<tr>
				<td nowrap><%=Element_Id %></td>
				<td nowrap><input type=checkbox id='<%= "_field"+Element_Id %>' name='<%=Element_Id+"_inuse"%>' <%=In_Use_Yn.equals("Y")?"checked":""%> onClick="validatecheckbox(this,'<%=Element_Id%>','<%=APPLICATION_ID%>');" value='<%=In_Use_Yn.equals("Y")?"Y":"N"%>'></td>
			</tr> 
	<%
 		i++;
 				cnt++;
 			}

 			if (cnt == 0) {
 				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
 			}
 			boolean flag = false;

 			if (cnt < 16 || (!rst.next())) {
 	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<%
		flag = true;
			} else {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%
		}
	%>


</table>

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
<input type="hidden" id="start" name="start" id="start" value='<%=start%>'>
<input type="hidden" id="records_to_show" name="records_to_show" id="records_to_show" value='<%=records_to_show%>'>
<input type="hidden" id="strApplicationID"	 name="strApplicationID" id="strApplicationID" value='<%=strApplicationID%>'>
<input type="hidden" id="checkedEventsId" name="checkedEventsId" id="checkedEventsId" value='<%= checkedData%>'>
<input type="hidden" id="end" name="end" id="end" value='<%=end%>'>
<input type="hidden" id="callType" name="callType" id="callType" value="NOTIFYEVENT">

		</table>
		<br>
	</form>

</body>
<script>
function clearCheckedData(){
	parent.label_query.document.getElementById("ElementAppId_param").value="";
}
</script>
</html>
<%!public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? ""
				: inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue
				: inputString);
	}%>

