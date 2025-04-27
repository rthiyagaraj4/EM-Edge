<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	request.setCharacterEncoding("UTF-8");

%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	 <script language="JavaScript" src="../../ePH/js/TDMAttributes.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%

      String	bean_id			=	"TDMAttributes" ;
      String	bean_name		=	"ePH.TDMAttributesBean";

   	TDMAttributesBean bean				=  (TDMAttributesBean)getBeanObject( bean_id,bean_name, request);	
	
	String rflag           = request.getParameter("reflag");
/*
	String peak           = request.getParameter("peak");
	String Trough           = request.getParameter("Trough");
	String Extend           = request.getParameter("Extend");
	String random           = request.getParameter("random");

   
*/
	StringBuffer peak_rmrks = new StringBuffer();
	StringBuffer trough_rmrks = new StringBuffer();
	StringBuffer extn_rmrks  = new StringBuffer();
    StringBuffer random_rmrks = new StringBuffer();
	
     if(rflag.equals("P"))
	 {
     if(bean.getPeakRemarks().length() > 0 )
     peak_rmrks.append(bean.getPeakRemarks());
    // peak_rmrks.append(peak);
     }else if(rflag.equals("T"))
	 {
	 if(bean.getTroughRemarks().length() > 0 )
     trough_rmrks.append(bean.getTroughRemarks());
     //trough_rmrks.append(Trough);
	 }else if(rflag.equals("E"))
     { 
   	 if(bean.getExtendRemarks().length() > 0 )
     extn_rmrks.append(bean.getExtendRemarks());
     //extn_rmrks.append(Extend);
	 }
	 else if(rflag.equals("R"))
	 {
	 if(bean.getRandomRemarks().length() > 0 )
     random_rmrks.append(bean.getRandomRemarks());
     //random_rmrks.append(random);
	 }
	 
	%>  
</head>
<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<body style="background-color:#E2E3F0;" OnMouseDown="CodeArrest()";onKeyDown="lockKey()">
<FORM name="formTDMAtrributesRemarks" id="formTDMAtrributesRemarks">
 <table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>
	<tr>
		<td align='left' class='label' width='10%'></td>
	</tr>

<% 
	    if(rflag.equals("P")){
	
		  %>
     <tr>
	<td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea name="tdm_remarks" id="tdm_remarks" rows="5"         cols="60"onBlur="makeValidString(this);return(ChkMaxLen(this,2000));"><%=peak_rmrks%></textarea>
	</td>
		
	  </tr>
	  <%  }else if(rflag.equals("T")){ 
		
		  %>
		  
	<tr>
	 <td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea name="tdm_remarks" id="tdm_remarks" rows="5" cols="60" onBlur="makeValidString(this);return(ChkMaxLen(this,2000));"><%=trough_rmrks%></textarea></td>
		
	  </tr>
     <%  }  else if(rflag.equals("E")){
		
		  %>
		  
	  <tr>
		<td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea name="tdm_remarks" id="tdm_remarks" rows="5" cols="60" onBlur="makeValidString(this);return(ChkMaxLen(this,2000));"><%=extn_rmrks%></textarea></td>
		
	  </tr>
      <%  } else if(rflag.equals("R")) {  
      
		 %>
		  
	  <tr>
		<td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea name="tdm_remarks"  id="tdm_remarks" rows="5" cols="60" onBlur="makeValidString(this);return(ChkMaxLen(this,2000));"><%=random_rmrks%></textarea></td>
		
	  </tr>
	  <%  } 
	   %>
	<TR>
		<td class='label'>
			<center><input type='Button' class='Button' name='Ok' id='Ok' value='OK' onclick="doAmendClose('<%=rflag%>')"></center>
		</TD>
	</TR>
</table>




</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

