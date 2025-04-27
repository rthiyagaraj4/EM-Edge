<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!--%@ include file="..\\..\\eCommon\\jsp\\GetPersistenceBean.jsp"%-->


<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%@ page import ="eBL.Common.BlRepository" %>




<%request.setCharacterEncoding("UTF-8");%>


<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
        <script language ="javaScript"    src ='../../eCommon/js/CommonLookup.js'></Script>	
		<script language="javascript"     src="../../eCommon/js/ValidateControl.js"></script> 
		<script language='javascript'     src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eBL/js/BLPrivilege.js"></script> 
		<script language ="javaScript"    src ='../../eCommon/js/common.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>





	   

<BODY onLoad="  "  onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" >

   <FORM method='post' name="report_form" id="report_form"  id="report_form"  action="" onsubmit="return funQry()">
   <TABLE border='0' cellpadding='3' cellspacing='0'>

<!--TABLE border='0' cellpadding='3' cellspacing='0' width='100%' -->

	<br/>
	<tr>
		<td class="label" width="2%"><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></td>	
		<td class="fields" width="20%"><INPUT TYPE="TEXT"  name="patientId" id="patientId" SIZE="17" maxlength='12' VALUE=''  onKeyPress='changeToUpper()' onBlur="callPatValidation(this);" >
		<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="getPatID();callPatValidation(patientId);" tabindex='2'><img src='../../eCommon/images/mandatory.gif'> </td>
		
		</tr>  
  
    </TABLE>   
   </div>   
</form>
</body>	
</html>




