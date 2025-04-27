<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script> 
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <!-- <script language="Javascript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
   
<title><%=request.getParameter( "title" )%></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="DirectDispFillingRemarks" id="DirectDispFillingRemarks" >
<%
		
	
	String reason_code			=	"";
	String reason_desc			=	"";
	String chk_field			=   "";
	String ext_drug_code		=   "";
	String ext_srl_no		    =   "";
	String fill_remarks			=   "";
	String reason				=   "";
	HashMap ext_drugData	    =   null;
	String recno				=	request.getParameter("recno");
	String drug_code			=	request.getParameter("drug_code");		
	String chk					=	(request.getParameter("chk")).trim();
	String srl_no				=	request.getParameter("srl_no");	
	String called_frm			=   request.getParameter("called_frm");
	if(called_frm==null)called_frm="OK";	
	String	title				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Findings.label","common_labels"); 


	 if(chk.equals("D"))
		chk_field	= "D";
	
	ArrayList fill				=	new ArrayList();
	String bean_id				= "DirectDispensingBean" ;
	String bean_name			= "ePH.DirectDispensingBean";
	DirectDispensingBean bean	= (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
	//bean.setLanguageId(locale);
  
	 if(chk.equals("D"))
	{
		fill			=	bean.loadFillRemarks(chk_field);
	    ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
		 for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	=	(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
				if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
                      if(ext_drugData.containsKey("FILLING_REASON")){
						  reason        =(String)ext_drugData.get("FILLING_REASON");						   
					  }
					  if(ext_drugData.containsKey("FILLING_REMARKS")){
						  fill_remarks  =(String) ext_drugData.get("FILLING_REMARKS");
					  }
				}
		 }		
	}
%>
<table cellpadding="0" cellspacing="0" width="103%" align="center" border="0">
<tr>
	<td  class="label"><%=title%>&nbsp;&nbsp;</td>
	<td >&nbsp;&nbsp;<select name="reason" id="reason" onChange="setFocusRem(DirectDispFillingRemarks);setAmendRemarks(DirectDispFillingRemarks)"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	
	<% for(int i=0; i<fill.size(); i+=2) {
		reason_code	=	(String)fill.get(i);
		reason_desc	=	(String)fill.get(i+1); 
		
	%>		
		<%
		if( (reason_code).equals(reason) )
		{
          %>
           <option value="<%=reason_code%>" selected><%=reason_desc%></option>
          <%
		}
		else
		{
		%>
		<option value="<%=reason_code%>" ><%=reason_desc%></option> 
		<%
		}
		%>
	<%
	}	
	%>
	</select>
	<img src="../../eCommon/images/mandatory.gif" align="center">
	</td>
</tr>

<tr>
    <td  class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td >&nbsp;&nbsp;<textarea rows="7" cols="40" name="remarks" maxLength="500"  onKeyPress="return(ChkMaxLen('Remarks',this,500));" ><%=fill_remarks%></textarea><img src="../../eCommon/images/mandatory.gif" align="center"></td>
</tr>
<tr>


<td  colspan='2' align="right">
<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button"  onClick="callFillVal(DirectDispFillingRemarks);parent.window.retVal='OK'">
<input  type="button" value=' <fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' class="button"  onClick="callCancelFillVal(DirectDispFillingRemarks);">
</td>
</tr>
</table>
<input type="hidden" name="recno" id="recno"		value="<%=recno%>">
<input type="hidden" name="drug_code" id="drug_code"	value="<%=drug_code%>">
<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">
<input type="hidden" name="chk" id="chk"			value="<%=chk%>" >
<input type="hidden" name="srl_no" id="srl_no"		value="<%=srl_no%>">
</form>
<%// putObjectInBean(bean_id,bean,request); %>
</body>
</html>

