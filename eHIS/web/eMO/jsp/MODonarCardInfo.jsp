<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<title><fmt:message key="eMO.PatientDonorCardInfo.label" bundle="${mo_labels}"/></title>
	<%
	//String patient_id="";
     String sStyle	=    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   	 request.setCharacterEncoding("UTF-8");

%>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>    
	  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMO/js/MORegisterAttn.js' language='javascript'></script>
</head>
<%
	//Connection con            = null;
	//PreparedStatement pstmt   = null;
	//ResultSet rs              = null;
		
	//String code = "";
//	String sys_date="";
//	String body_received_date_time="";
///	String conscentgivenby="";
    String donardetails="";
   // String consent_received_by="";
    //String consent_received_date="";
	String donar_card_no="";
   String mode="";
	donar_card_no= request.getParameter("donar_card_no")==null?"":request.getParameter("donar_card_no");
		
	donardetails = request.getParameter("donardetails")==null?"":request.getParameter("donardetails");

    mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	
	if(mode.equals("viewdata"))mode="disabled";				
 
%>

<body OnMouseDown='CodeArrest()' onLoad="FocusFirstElement()"  onUnload='closedonar()'onKeyDown = 'lockKey()'>
 <form name='service_form' id='service_form'  method='post' target='dummyframe'>
 <table border='0' cellpadding='3' cellspacing='0'  width='100%' align='center'>
 
	<tr>
		<td class='label' width='40%'><fmt:message key="eMO.DonorCardNo.label" bundle="${mo_labels}"/></td>
		<td class='fields' width='60%'><INPUT TYPE="text" name="donar_card_no" id="donar_card_no" <%=mode%> maxlength=100     value="<%=donar_card_no%>" ><img id='id1' src='../../eCommon/images/mandatory.gif' align='center'  ></td>
	</tr>
	<tr>
	   <td class="label"><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	   <td class='fields'><TEXTAREA id=TEXTAREA1 cols=40 rows=5 <%=mode%>	 name='donar_details' onKeyPress=""   ><%=donardetails%></TEXTAREA><img id='id3' src='../../eCommon/images/mandatory.gif' align='center'   ></td>
   </tr>	
   <tr>	
		<td class='button' colspan='2' align='right'><input type="button" name="Close" id="Close" class='BUTTON' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="closedonar()"></td>		
	</tr>		
   	</table>
	 
	</form>
   	</body>
   	</html>

