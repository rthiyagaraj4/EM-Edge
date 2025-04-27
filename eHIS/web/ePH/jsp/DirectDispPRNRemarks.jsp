<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	String drug_code					= request.getParameter("drug_code");
	String drug							= request.getParameter("drug");
	String called_from					= request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String man_rem_on_prn_freq_yn		= request.getParameter("man_rem_on_prn_freq_yn")==null?"N":request.getParameter("man_rem_on_prn_freq_yn");
	
	String max_length_prn_reason		= request.getParameter("max_length_prn_reason").equals("")?"400":request.getParameter("max_length_prn_reason");

	String bean_id						= "DirectDispensingBean";
	String bean_name					= "ePH.DirectDispensingBean";
	DirectDispensingBean bean			= (DirectDispensingBean)getBeanObject( bean_id,bean_name,request);
	HashMap remarks						= (HashMap)bean.getPRNRemarks(drug_code);
	String remarks_text				    = "";
	String remarks_code				    = "";
	 if(remarks!=null){
		if(remarks.containsKey("remarks_dtl"))
			remarks_text				    = (String)remarks.get("remarks_dtl")==null?"":(String)remarks.get("remarks_dtl");
		if(remarks.containsKey("remarks_code"))
		   remarks_code					    = (String)remarks.get("remarks_code")==null?"":(String)remarks.get("remarks_code");
	 }

	ArrayList prnRemarkForDrug	=	bean.getPrnRemarkForDrug(drug_code);
	//out.println("prnRemarkForDrug---->"+prnRemarkForDrug);
	remarks_text				=	remarks_text.replaceAll(" ","%20");
	remarks_text				=	java.net.URLEncoder.encode(remarks_text,"UTF-8");
	remarks_text				=	remarks_text.replaceAll("%2520","%20");
	String flag                 =	"N";
	String disable_list         =	"";
	String disable_text_area    =	"";
	String free_text_checked    =	"";
	if((remarks_code.equals("")&& !remarks_text.equals(""))||(prnRemarkForDrug.size()==0)){
		disable_list ="disabled";
		free_text_checked ="checked";

	}
	if(!remarks_code.equals("")&& !remarks_text.equals("")){
		disable_text_area ="disabled";

	}
	
%>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>






<title><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/></title>

</head>
	<body >
		<form name="PrescriptionPRNRemarksForm" id="PrescriptionPRNRemarksForm" >
			<table cellpadding="0" cellspacing="0" width="103%" align="center" border="0">
				<tr> 
				<td class="label"><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/></td>
				 <td  class="label" >
					<select name='prnRemCode' id='prnRemCode' onchange='displayRemarks(this)'<%=disable_list%>>
						<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<%
						HashMap temp = new HashMap();

						for(int i=0; i<prnRemarkForDrug.size(); i++){
							temp = (HashMap)prnRemarkForDrug.get(i);
							if(((String)temp.get("DEFAULT_REASON_YN")).equals("Y")&& remarks_code.equals("")&& remarks_text.equals("")){
				%>
								<option value='<%=(String)temp.get("REASON_CODE")%>' selected><%=(String)temp.get("REASON_DESC")%></option>
				<%		        flag ="Y";
								remarks_text =(String)temp.get("REMARKS")==null?"":(String)temp.get("REMARKS");
								remarks_text=remarks_text.replaceAll(" ","%20");
								//remarks_text=java.net.URLEncoder.encode(remarks_text,"UTF-8");
								remarks_text=remarks_text.replaceAll("%2520"," ");
							}else if(temp.get("REASON_CODE").equals(remarks_code)){
				%>
								<option value='<%=(String)temp.get("REASON_CODE")%>' selected><%=(String)temp.get("REASON_DESC")%></option>

				<%       	
							}else{
				%>
								<option value='<%=(String)temp.get("REASON_CODE")%>' ><%=(String)temp.get("REASON_DESC")%></option>
				<%			}
						}
				%>
					</select>
				 </td>
				</tr>
				<tr> 
				<td>&nbsp;</td>
					 <td  class="label" ><fmt:message key="ePH.PRNFreeTextRemarks.label" bundle="${ph_labels}"/> &nbsp;&nbsp;<input type='checkbox' name='prnFreeTextYN' id='prnFreeTextYN' onclick='changeRemType()' <%=free_text_checked%>></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td class='label' >&nbsp;&nbsp;<textarea rows="8" cols="45" name="remarks" onKeyPress="return(ChkMaxLen('Remarks',this,'<%=max_length_prn_reason%>'));" <%=disable_text_area%>></textarea>
				<%
					if(man_rem_on_prn_freq_yn.equals("Y")){
				%>
						<img src="../../eCommon/images/mandatory.gif" align="center"></td>
				<%
					}
				%>
				</tr>
				<tr>
					<td class="white" align='right' colspan=2> 
							<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button"  onClick="validatePRNRemark()">
					</td>
				</tr>
			</table>

		<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
		<input type="hidden" name="drug" id="drug" value="<%=drug%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="man_rem_on_prn_freq_yn" id="man_rem_on_prn_freq_yn"		 value="<%=man_rem_on_prn_freq_yn%>" >
		<input type="hidden" name="max_length_prn_reason" id="max_length_prn_reason"		 value="<%=max_length_prn_reason%>" >

		<script>
			var prn_rem = decodeURIComponent('<%=remarks_text%>');
			document.PrescriptionPRNRemarksForm.remarks.value=prn_rem;
		<% if(flag.equals("Y")){
		%>
			   document.PrescriptionPRNRemarksForm.remarks.disabled=true;
		 <%	}
		 %>
		</script>
		<% putObjectInBean(bean_id,bean,request); %>
		</form>
	</body>
</html>

