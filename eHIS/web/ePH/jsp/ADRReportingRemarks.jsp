<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*," %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
	<%
		request.setCharacterEncoding("UTF-8"); 
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
	%> 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/ADRReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<%		
		try{		
			String	bean_id			=	"ADRReportBean" ;
			String	bean_name		=	"ePH.ADRReportBean";		
			ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
		
			String adrstatus = request.getParameter("adrstatus")==null?"":request.getParameter("adrstatus");
			String listBoxStatus = request.getParameter("listBoxStatus")==null?"":request.getParameter("listBoxStatus");
			String calledfrom = request.getParameter("calledfrom")==null?"":request.getParameter("calledfrom");	
			String patientid 	 = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String adrno 		 = request.getParameter("adrno")==null?"":request.getParameter("adrno");		
			String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
			  
			String canErrorID="" ,canErrorDate="",canRemark="",canErrorIDTemp="", app_trn_type ="", canErrorReason = "",reason_code ="", reason_desc ="", readonly="",disabled="";		
				
			if(calledfrom.equals("QueryRemarks") || listBoxStatus.equals("disabled")){
			   readonly = "readonly"; 
			   disabled = "disabled";	
			}				  
			HashMap	adrRemarksDetail  =(HashMap)bean.getAdrStatusDtl(facility_id+patientid+adrno);
			
			if(adrRemarksDetail.size()>0){
				canErrorIDTemp	 =  (String)adrRemarksDetail.get("CANCEL_ERROR_BY_ID");
				canErrorDate	 =  (String)adrRemarksDetail.get("CANCEL_ERROR_DATE");
				canRemark		 =  (String)adrRemarksDetail.get("CANCEL_ERROR_REMARKS");		 
				canErrorReason	 =  (String)adrRemarksDetail.get("CANCEL_ERR_REASON");				
			}	
		    if(canErrorIDTemp==null || canErrorIDTemp.equals("")){							 
				String p_user_name		= (String) session.getValue( "login_user" ) ;	
				ArrayList result		= bean.checkToProceed(p_user_name.trim());		
				if(result.size()>0)	{			
					canErrorID		=(String) result.get(0);																	
					canErrorIDTemp		=(String) result.get(1);
				}					
		       
				if( bean.getcanErrorDate()!=null && !bean.getcanErrorDate().equals("") )
					canErrorDate = bean.getcanErrorDate();					
				else
					canErrorDate	= bean.getSysdate();
                if( bean.getcanRemarks()!=null && !bean.getcanRemarks().equals("") )
					canRemark = bean.getcanRemarks();
				else  
					canRemark = "";				
				if( bean.getcanReason()!=null && !bean.getcanReason().equals("") )
					canErrorReason = bean.getcanReason();
				else  
					canErrorReason = ""; 				
           }	
		   if(adrstatus.equals("C"))
				app_trn_type ="AC";
		   else
				app_trn_type ="AI"; 
      
			ArrayList reason = bean.loadReasons(app_trn_type);
	  
		if(app_trn_type.equals("AC")){			
%>
			<title>	<fmt:message key="Common.cancel.label" bundle="${common_labels}"/> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </title>
<%
		}
		else if(app_trn_type.equals("AI")){		
%>
			<title>	 <fmt:message key="ePH.InError.label" bundle="${ph_labels}"/> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </title>
<%
		}
%>
		
		</head>
		<style>
textarea {
  resize: none;
}
</style>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="ADRReportingRemarksForm" id="ADRReportingRemarksForm">
			<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<fmt:message key="ePH.By.label" bundle="${ph_labels}"/></td>
					<td align="right" class="label" ><%=canErrorIDTemp%></td>
					
				</tr><tr><td colspan="2">&nbsp;</td></tr>
				<tr>
				<td align="right" class="label" ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="right" class="label" ><%=canErrorDate%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  				
				</tr><tr><td colspan="2">&nbsp;</td></tr>
									
				<tr>
					<td  class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td  class="label"><select name="canReason" id="canReason" <%=disabled%> onchange="getremarks(this)" ><option  value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<% 
					for(int i=0; i<reason.size(); i+=2) {
						reason_code	=	(String)reason.get(i);
						reason_desc	=	(String)reason.get(i+1); 
						if( canErrorReason.equals(reason_code)) {
			%>
							<option value="<%=reason_code%>" selected><%=reason_desc%></option>
			<%	         } else {	
			%>
							<option value="<%=reason_code%>"><%=reason_desc%></option>
			<%           }	
					 }
			%>			
					</select>
					</td>
				</tr>
				</tr><tr><td colspan="2">&nbsp;</td></tr>
				
				<tr> <td align="right" class="label" ><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/> </td>
					 <td  class="label" ><textarea cols="30" rows="5" name="canRemarks" onKeyPress="javascript:if(!document.getElementById('canReason').disabled){checkMaxLimit(this,2000)}" onblur ="if(!document.getElementById('canReason').disabled){CheckRemMaxLen();}" <%=readonly%>  Style="color:#999999" ><%=canRemark%></textarea>&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
					 </td>	 
				</tr>							
				</tr><tr><td colspan="2">&nbsp;</td></tr>							
				<tr>									
					<td class='button' colspan="2" align="right">
					<% if( !calledfrom.equals("QueryRemarks") && !listBoxStatus.equals("disabled")  ){
					%>
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" 
					onClick="javascript:if(checkAdrRremarks(document.ADRReportingRemarksForm.canRemarks)!=false){ setADRremarks('<%=canErrorID%>','<%=canErrorDate%>','<%=canErrorIDTemp%>');}else{document.ADRReportingRemarksForm.canRemarks.focus();}">&nbsp;&nbsp;&nbsp;
					<input type='Button' class='Button'  value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick='parent.document.getElementById("dialog_tag").close();' >
					<% }
                      else {
					%>
					  <input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.document.getElementById('dialog_tag').close();">&nbsp;&nbsp;&nbsp;
					<% }
                      
					%>
					</td>					
				</tr>
			</table>		
			<input type="hidden" name="app_trn_type" id="app_trn_type" value="<%=app_trn_type%>">
		</form>
	</body>
<%
	}
	catch(Exception e)	{		
		e.printStackTrace();
	}
 %>
</html>

