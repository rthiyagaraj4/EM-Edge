<!DOCTYPE html>
<!--Created by Ashwini on 07-Jul-2017 for ML-MMOH-CRF-0702-->
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
    Boolean isGSTCodeApplicable = false; 

try {
	con = ConnectionManager.getConnection(request);
	//isGSTCodeApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "GST_CODE");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/MedRecRequestId.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('req_year')">
<form name="request_id_form" id="request_id_form" action="../../servlet/eMR.RequestIdServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div align="left">
<table border="0" cellpadding="3" cellspacing="0" width="50%" align='center'>

  <tr>
  	<td width='40%'>&nbsp;</td>
  	<td width='50%' colspan='2'>&nbsp;</td>
  </tr>

  <tr>
    <td width="40%" class="label"><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
    <td width="50%" colspan="2" class='fields'><input type="text" name="req_year" id="req_year" size="4" maxlength="4" OnBlur="ZeroChkForReqId(this);YearLenforReqId(this);" onKeyPress="return NumChkForReqId(event);"><img src="../../eCommon/images/mandatory.gif"></img>
    </td>
  </tr>

  <tr>
    <td width="40%" class="label"><fmt:message key="Common.StartSerialNo.label" bundle="${common_labels}"/></td>
    <td width="50%" colspan="2" class='fields'><input type="text" name="start_no" id="start_no" size="8" maxlength="8" onBlur='ZeroChkForReqId(this);SerialNumCheck(this,max_no);setNextSrlNo(this);' onKeyPress="return NumChkForReqId(event);"><img src="../../eCommon/images/mandatory.gif"></img></td>
  </tr>

  <tr>
    <td width="40%" class="label"><fmt:message key="Common.maxserialno.label" bundle="${common_labels}"/></td>
    <td width="50%" colspan="2" class='fields'><input type="text" name="max_no" id="max_no" size="8" maxlength="8" onBlur='ZeroChkForReqId(this);SerialNumCheck(start_no,this);' onKeyPress="return NumChkForReqId(event);"><img src="../../eCommon/images/mandatory.gif"></img></td>
  </tr>

  <tr>
    <td width="40%" class="label"><fmt:message key="Common.nextsrlno.label" bundle="${common_labels}"/></td>
    <td width="50%" colspan="2" class='fields'><input type="text" name="next_no" id="next_no" size="8" maxlength="8" disabled></td>
  </tr>

  <tr>
  	<td width='40%'>&nbsp;</td>
  	<td width='50%' colspan='2'>&nbsp;</td>
  </tr>

<%
} catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace();
}finally{
 	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</table>
</div>
<input type="hidden" name="next_serl_no" id="next_serl_no">
</form>
</body>
</html>

