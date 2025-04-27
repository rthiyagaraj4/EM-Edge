<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
Properties p=(java.util.Properties) session.getValue("jdbc");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eIP.*,eCommon.Common.*"%>
      
<html>  
<title><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/> &nbsp;</title>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<script src='../../eMP/js/ReferralDtls.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!--Added for this CRF ML-MMOH-CRF-0566-->
	<script>
	window.onload=function(){
			if(document.getElementById("Tabledata")!=null)			
				fxheaderInit('Tabledata',370);
			else
				document.getElementById("reqfileheader").style.display='none';
		}
		
function onMMove(obj,e,diagTemp) {
		var treat1=unescape(document.getElementById('rejectcancel'+diagTemp).value);
		//var Totalcount=document.getElementById('Totalcount').value;
		//var diagcode =code;
		if(treat=!""){
		obj.style.left=e.x;	
        obj.style.top=e.y-10;		
		obj.style.borderColor='pink';
		obj.style.borderWidth='thin';
		obj.style.borderStyle='groove';
		obj.style.width=300;
		obj.innerHTML="<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td class='ordata' valign='top' style='word-wrap: break-word;width:300px'>"+treat1+"</td></tr></table>";
		}
		else
			return false;
			
}

function onMOut(obj){

		if(treat=!""){
		obj.innerHTML='';
		obj.style.width=0;
		obj.style.borderColor='';
		obj.style.borderWidth='';
		obj.style.borderStyle='';
		}
		else
			return false;
}
</script>
	</head>
<% 
//String params = request.getQueryString() ;
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
String referral_id=request.getParameter("referral_id");

try{
con	= ConnectionManager.getConnection(request);
ArrayList List=(ArrayList)ReferralRegisterAuditDetails.getAuditTrail(con,referral_id,p); //Type casting into the ArrayList 

%>
<body onKeyDown = 'lockKey()'>
<form name='' id=''  method='post'>
       <table border='1' cellpadding='1' cellspacing='0' align='left' width='100%' id='TableData'>
	   
        <% //Below line added for this CRF ML-MMOH-CRF-0566
	   	Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");	
		if(referralRegister){
		%>		
		<tr>
		<td  width='14%' class='columnheader' style="word-wrap: break-word;width:100px"><fmt:message key="Common.referredby.label" bundle="${common_labels}"/></td>
		<td  width='14%' class='columnheader' style="word-wrap: break-word;width:100px"><fmt:message key="Common.referredby.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.DateTime.label" bundle="${common_labels}"/></td>
		<td  width='14%' class='columnheader' style="word-wrap: break-word;width:100px"><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></td>
		<td  width='14%' class='columnheader' style="word-wrap: break-word;width:100px"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td  width='6%' class='columnheader' style="word-wrap: break-word;width:140px"><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>/<fmt:message key="Common.Reject.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
		<td  width='14%' class='columnheader' style="word-wrap: break-word;width:100px"><fmt:message key="eIP.PerformedBy.label" bundle="${ip_labels}"/></td>
		<td  width='14%' class='columnheader' style="word-wrap: break-word;width:100px"><fmt:message key="eIP.Performed.label" bundle="${ip_labels}"/>&nbsp;</td>				
	    </tr>	
		<%for(int i=0; i<List.size(); i++){
		String status_desc="";
	    ReferralRegisterAuditBean refauditDetails=(ReferralRegisterAuditBean)List.get(i); 
		//Type casting ArrayList into JavaBean Object, The JavaBean getter method return the value
	    String status=checkForNull(refauditDetails.getReviewStatus());
		if(status.equals("")){ 
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");	
		}else if(status.equals("P")){
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
		}else if(status.equals("C")){
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
		}else if(status.equals("S")){
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
		}else if(status.equals("X")){
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
		}else if(status.equals("N")){
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");
		}
		
		
		
		String Remarksdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels"); 
		//Above line modified for this CRF ML-MMOH-CRF-0566 US3
		
	%>	
	<tr>
	    <td  width='14%' class="QRYODDSMALL" style="word-wrap: break-word;width:100px"><%=checkForNull(refauditDetails.getReffrompractitioner())%>&nbsp;</td>
		<td  width='14%' class="QRYODDSMALL" style="word-wrap: break-word;width:100px"><%=checkForNull(refauditDetails.getCancelrejectdatetime())%>&nbsp;</td>
		<td  width='14%' class="QRYODDSMALL" style="word-wrap: break-word;width:100px"><%=checkForNull(refauditDetails.getReftopractitioner())%>&nbsp;</td>
	    <td  width='14%' class="QRYODDSMALL" style="word-wrap: break-word;width:100px"><%=status_desc%>&nbsp;</td>
		<td  width='10%'  class="QRYODDSMALL" style="word-wrap: break-word;width:130px" align="center"><%if(status.equals("S") || status.equals("X")){%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
		<a href="#" onClick="callCancelRejectRemarks('<%=status%>','<%=checkForNull(refauditDetails.getCancelrejectreason())%>');" onMouseover="javascript:onMMove(msg,event,'<%=i%>');" onMouseout="javascript:onMOut(msg);"><b><%=Remarksdesc%></b></a>
		<%}else{%>&nbsp;<%}%></td>
		<td  width='14%' class="QRYODDSMALL" style="word-wrap: break-word;width:100px"><%=checkForNull(refauditDetails.getUserName())%>&nbsp;</td>
		<td  width='14%' class="QRYODDSMALL" style="word-wrap: break-word;width:100px"><%=checkForNull(refauditDetails.getPerformedDate())%>&nbsp;</td>
	</tr>
	   <input type="hidden" name="rejectcancel<%=i%>" id="rejectcancel<%=i%>" id="rejectcancel<%=i%>" value="<%=checkForNull(refauditDetails.getCancelrejectreasondesc())%>">
	<%}	
	}else{%>
	<tr>
		<td  width='40%' class='columnheader'><fmt:message key="eIP.PerformedBy.label" bundle="${ip_labels}"/></td>
		<td  width='30%' class='columnheader' ><fmt:message key="eIP.Performed.label" bundle="${ip_labels}"/> &nbsp; </td>
		<td  width='30%' class='columnheader'><fmt:message key="Common.status.label" bundle="${ip_labels}"/></td>		
	    </tr>	
		<%for(int i=0; i<List.size(); i++){
		String status_desc="";
	    ReferralRegisterAuditBean refauditDetails=(ReferralRegisterAuditBean)List.get(i); 
		//Type casting ArrayList into JavaBean Object, The JavaBean getter method return the value
	    String status=checkForNull(refauditDetails.getReviewStatus());
		if(status.equals("")){ 
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");	
		}else if(status.equals("P")){
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
		}else if(status.equals("C")){
		status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
		}
		
	%>
	
	<tr>
		<td  width='40%'  class="QRYODDSMALL" style="word-wrap: break-word;width:200px"><%=checkForNull(refauditDetails.getUserName())%>&nbsp;</td>
		<td  width='30%' class="QRYODDSMALL" style="word-wrap: break-word;width:200px"><%=checkForNull(refauditDetails.getPerformedDate())%>&nbsp;</td>
		<td  width='30%' class="QRYODDSMALL" style="word-wrap: break-word;width:200px"><%=status_desc%>&nbsp;</td>		
	</tr>
	<%}
	}%>
	</table>
<!--Below line added for this CRF ML-MMOH-CRF-0566 US3-->
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 100; top: 50">
</div>
<!--End this CRF ML-MMOH-CRF-0566 US3-->
		
</form>
</body>
<%}catch(Exception e){
	e.printStackTrace() ;
} finally{
	   	if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }
%>
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

