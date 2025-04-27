<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
Properties p=(java.util.Properties) session.getValue("jdbc");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale		= (String)session.getAttribute("LOCALE");
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eFM.*" %>
      
<html>  
<title><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/> &nbsp;</title>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eFM/js/QueryFMCurrentFileStatus.js'></script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Supporting Js File For Fixed Header with scroll.... -->
	<script>
	window.onload=function(){ 
			if(document.getElementById("Tabledata")!=null)	{		
				fxheaderInit('Tabledata',350);
			}else{ 
				document.getElementById("reqfileheader").style.display='none';
			}	
		}
	</script>
	</head>
<% 
//String params = request.getQueryString() ;
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
String patientId=checkForNull(request.getParameter("patientId")); 
String fileNo=checkForNull(request.getParameter("fileNo"));
String volumeNo=checkForNull(request.getParameter("volumeNo"));
String transaction="",datetime="",fsLocation="",by="",reason="",remarks="",forwhom="",modeoftransfer="",carriedbyname="",returnRemarks="";
String class_value="QRYEVEN";

try{
con	= ConnectionManager.getConnection(request);
ArrayList List=(ArrayList)FMCurrentEncounterDetails.getAuditTrailDetails(con,patientId,fileNo,volumeNo,p); //Type casting into the ArrayList 

%>
<body onKeyDown = 'lockKey()'>
<form name='' id=''  method='post'>
	
		<table border='1' cellpadding='0' cellspacing='0' align='left' width='100%' id='TableData'>
		<tr>
		<td  class='columnheader'  align="left" height="30"><fmt:message key="eFM.Transaction.label" bundle="${fm_labels}"/></td>
		<td  class='columnheader'  align="left" height="30"><fmt:message key="eFM.DateTime.label" bundle="${fm_labels}"/> </td>
		<td  class='columnheader'  align="left" height="30"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
        <td  class='columnheader'  align="left" height="30"><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
        <td  class='columnheader'  align="left" height="30"><fmt:message key="eFM.Reason.label" bundle="${fm_labels}"/></td>
        <td  class='columnheader'  align="left" height="30"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td> 	
        <td  class='columnheader'  align="left" height="30"><fmt:message key="eFM.ForWhom.label" bundle="${fm_labels}"/></td> 
        <td  class='columnheader'  align="left" width="15%" height="30"><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></td> 			
	    </tr>	
		<% 
		int j=1; int k=1;
		for(int i=0; i<List.size(); i++){ 
	     if(class_value.equals("QRYEVEN"))
				   class_value = "QRYODD";
	     else
					class_value = "QRYEVEN";
		
		 

		
		FMCurrentEncounterDetailsBean AuditTrails=(FMCurrentEncounterDetailsBean)List.get(i);
		   transaction=checkForNull(AuditTrails.getTransaction()); 
           datetime=checkForNull(AuditTrails.getDatetime());
		   if(!datetime.equals("")){
			       datetime=DateUtils.convertDate(datetime,"DMYHM","en",locale);
		    }else{
			       datetime = "&nbsp;";
			}
           fsLocation=checkForNull(AuditTrails.getFsLocation());
           by=checkForNull(AuditTrails.getBy());
           reason=checkForNull(AuditTrails.getReason());
           remarks=checkForNull(AuditTrails.getRemarks());
           forwhom=checkForNull(AuditTrails.getForwhom());
           modeoftransfer=checkForNull(AuditTrails.getModeoftransfer());
           carriedbyname=checkForNull(AuditTrails.getCarriedByName());	
		   returnRemarks=checkForNull(AuditTrails.getReturnRemarks());
		   
		   String remarksCheck="";
           if(transaction.equals("Request File")) remarksCheck="R";
		   if(transaction.equals("Issue File")) remarksCheck="IRS";
		   if(transaction.equals("Confirm Issue File Receipt")) remarksCheck="CR";
		   if(transaction.equals("Transfer File")) remarksCheck="TR";
		   if(transaction.equals("Receive File at MRD")){ 
		   remarks=returnRemarks;
		   remarksCheck="RCR";}
		   if(transaction.equals("Return to MRD")){
		    remarks=returnRemarks;
			remarksCheck="RTR";
		   }
		   
           		   
		   
		   String transferbyname="", modeoftrsremarks="";
		   if(!modeoftransfer.equals("")){
		   transferbyname=modeoftransfer+" / "+carriedbyname;
		   modeoftrsremarks="MOT";
		   }
		%>
	<tr>
		<td  class="<%=class_value%>" style="word-wrap: break-word;width:200px"><FONT size=1><%=transaction%>&nbsp;</font></td>
		<td  class="<%=class_value%>" style="word-wrap: break-word;width:150px" nowrap><FONT size=1><%=datetime%>&nbsp;</font></td>
		<td  class="<%=class_value%>" style="word-wrap: break-word;width:180px"><FONT size=1><%=fsLocation%>&nbsp;</font></td>	
		<td  class="<%=class_value%>" style="word-wrap: break-word;width:180px"><FONT size=1><%=by%>&nbsp;</font></td>
		<td  class="<%=class_value%>" style="word-wrap: break-word;width:200px"><FONT size=1><%=reason%>&nbsp;</font></td>
		<td  class="<%=class_value%>" style="word-wrap: break-word;width:190px"><FONT size=1><%if(!remarks.equals("")){%><A href='javascript:GetShowRemarks("remarksText<%=j%>","<%=remarks%>","<%=remarksCheck%>")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A><%}else{%>&nbsp;<%}%></font></td>
		 <INPUT type='hidden' name="remarksText<%=j%>" id="remarksText<%=j%>" value="<%=remarks%>" >  
		<td  class="<%=class_value%>" style="word-wrap: break-word;width:180px"><FONT size=1><%=forwhom%>&nbsp;</font></td>
		<td  class="<%=class_value%>" style="word-wrap: break-word;width:180px"><FONT size=1><%=transferbyname%>&nbsp;</font></td>
		<INPUT type='hidden' name="modeofText<%=j%>" id="modeofText<%=j%>" value="<%=transferbyname%>" > 
	</tr>
	<%j++;
	  k++;
	 }%>
	</table>
	
		

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

