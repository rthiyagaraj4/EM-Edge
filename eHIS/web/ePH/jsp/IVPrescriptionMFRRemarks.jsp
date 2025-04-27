<!DOCTYPE html>
<%@page  import="eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	try{
%>
		<html>
			<head>
				<script language="JavaScript" src="../../eCommon/js/common.js"></script>
				<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
				<script language="Javascript" src="../../ePH/js/IVPrescriptionWithAdditives.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<script>
				function savedetails(){
					var frmobjRem=document.IVPrescriptionMFRRemarks;
					var rem=frmobjRem.mfr_remarks.value;
					if(rem!="")
								rem=encodeURIComponent(rem,"UTF-8");
					var retVal=new Array();
					retVal[0]=rem;	
					window.returnValue = retVal;
					window.close();
				}
				</script>
<%
				request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
				String sStyle =
				(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
				String mfr_remarks		=	request.getParameter("mfr_remarks")==null?"":request.getParameter("mfr_remarks");
				if(mfr_remarks.equals("null")) 	mfr_remarks="";
				String mfr_yn			=	request.getParameter("mfr_yn")==null?"Y":request.getParameter("mfr_yn");
				String read_property	=	request.getParameter("read_property")==null?"":request.getParameter("read_property");
%>
				<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
				if(mfr_yn.equals("Y")){
%>
					<title><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></title>
<%
				}
				else{
%>
					<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<%
				}
%>
			</head>
			<body onMouseDown="CodeArrest();" onKeyDown="lockKey();">
				<form name="IVPrescriptionMFRRemarks" id="IVPrescriptionMFRRemarks">
					<br>
					<table cellpadding="0" cellspacing="0" width="100%" align="left" border="0">
						<tr><td width='95%'>&nbsp;&nbsp;<textarea rows="8" cols="50" name="mfr_remarks" onKeyPress="return(checkMaxLimit(this,255));" onBlur="callCheckMaxLen(this,255,' Remarks ')" <%=read_property%>><%=mfr_remarks%></textarea></td>
						<td width='5%'>&nbsp;</td>
						</tr>
						<br>
						<tr>
							<td style="text-align:center;" class='button'><input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='savedetails()'>&nbsp;&nbsp;</td>
							<td >&nbsp;</td>
						</tr>
					</table>
				</form>
			</body>
		</html>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>		

