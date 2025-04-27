<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
Properties p=(java.util.Properties) session.getValue("jdbc");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eFM.*" %>
      
<html>  
<title><fmt:message key="eFM.FileMovement.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.History.label" bundle="${common_labels}"/></title>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eFM/js/QueryFMFileMovementHistroy.js'></script>
	<script language='javascript' src='../../eCommon/js/tabmultirowheaderscroll.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Supporting Js File For Fixed Header with scroll.... -->
	<script>
	window.onload=function(){ 
		fxheaderInit('Tabledata',400,2,0);
		fxheader();		
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
String issued_no="";
String issued_fs_locn="";
String received_fs_locn="";
String req_remarks="";
String issue_remarks="";
String received_no="";
String return_remarks="";
String received_by="";

String srclocnidentity="";
String destlocnidentity="";

String class_value="QRYEVEN";

try{
con	= ConnectionManager.getConnection(request);
ArrayList List=(ArrayList)FMCurrentEncounterDetails.getFileMovementHistory(con,patientId,fileNo,volumeNo,p); //Type casting into the ArrayList 

%>
<body onKeyDown = 'lockKey()'>
<form name='' id=''  method='post'>
	
		<table border='1' style='border-spacing:0px ;border-collapse: collapse;'   width='100%' class='mt'id='TableData'>
		<tr>
		<th  class='columnheader' align="left" rowspan="2"><fmt:message key="eFM.Issuedon.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' align="center" colspan="2"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></th>
		<th  class='columnheader' align="left" rowspan="2" width="14%"><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></th>
		<th  class='columnheader' align="left" rowspan="2" width="14%"><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></th>
		<th  class='columnheader' align="left" rowspan="2"><fmt:message key="eFM.Receivedon.label" bundle="${fm_labels}"/></th> 
		<th  class='columnheader' align="left" rowspan="2" width="14%"><fmt:message key="eFM.ReturnRemarks.label" bundle="${fm_labels}"/></th> 
		<th  class='columnheader' align="left" rowspan="2"><fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/></th> 
        </tr>	
		<tr>
		<th  class='columnheader' align="left"><fmt:message key="Common.Issued.label" bundle="${common_labels}"/></th>
		<th  class='columnheader' align="left"><fmt:message key="Common.received.label" bundle="${common_labels}"/></th>
		</tr>
		<% 
		int j=1;
		for(int i=0; i<List.size(); i++){ 
		   if(class_value.equals("QRYEVEN"))
				   class_value = "QRYODD";
	     else
					class_value = "QRYEVEN";
		
		FMCurrentEncounterDetailsBean MovementHist=(FMCurrentEncounterDetailsBean)List.get(i);
		   issued_no=checkForNull(MovementHist.getIssuedDatetime());
           issued_fs_locn=checkForNull(MovementHist.getIssuedFsLocation());
		   received_fs_locn=checkForNull(MovementHist.getReceivedFsLocation());
		   req_remarks=checkForNull(MovementHist.getRequestRemarks());
		   issue_remarks=checkForNull(MovementHist.getIssueRemarks());
		   received_no=checkForNull(MovementHist.getReceivedDatetime());
		   return_remarks=checkForNull(MovementHist.getReturnRemarks());
		   received_by=checkForNull(MovementHist.getBy());		   
           srclocnidentity=checkForNull(MovementHist.getSourcelocnidentity());	
		   destlocnidentity=checkForNull(MovementHist.getDestlocnidentity());


		   
		   String srcidentity = "";

			if("D".equals(srclocnidentity) || "d".equals(srclocnidentity))
				  srcidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
			if("T".equals(srclocnidentity) || "t".equals(srclocnidentity))
				  srcidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			if("C".equals(srclocnidentity) || "c".equals(srclocnidentity))
				  srcidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			if("N".equals(srclocnidentity) || "n".equals(srclocnidentity))
				  srcidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			if("Y".equals(srclocnidentity) || "y".equals(srclocnidentity))
				  srcidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
			if("E".equals(srclocnidentity) || "e".equals(srclocnidentity))
				  srcidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
				  
            String destidentity = "";	
           
		    if( "D".equals(destlocnidentity) || "d".equals(destlocnidentity))
				  destidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
				if( "T".equals(destlocnidentity) || "t".equals(destlocnidentity))
				  destidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				if( "C".equals(destlocnidentity) || "c".equals(destlocnidentity))
					destidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
				if( "N".equals(destlocnidentity) || "n".equals(destlocnidentity))
				    destidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
				if( "Y".equals(destlocnidentity) || "y".equals(destlocnidentity))
				    destidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
				if( "E".equals(destlocnidentity) || "e".equals(destlocnidentity))
				    destidentity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			
			
		   
           %>
	<tr>
		<td  class="<%=class_value%>" align='left' style="word-wrap: break-word;width:245px"><FONT size=1><%=issued_no%>&nbsp;</font></td>
		<td  class="<%=class_value%>" align='left' style="word-wrap: break-word;width:200px"><FONT size=1><%=issued_fs_locn%>&nbsp;(<%=srcidentity%>)</font></td>
		<td  class="<%=class_value%>" align='left' style="word-wrap: break-word;width:200px"><FONT size=1><%=received_fs_locn%>&nbsp;(<%=destidentity%>)</font></td>
		<td  class="<%=class_value%>" align='left' style="word-wrap: break-word;width:200px"><FONT size=1>&nbsp;
		<%if(req_remarks=="")
				{
				out.println("&nbsp;");
				}
		else {
			%>
			<A href='javascript:GetShowRemarks("ReqComm<%=j%>","<%=req_remarks%>","R")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
			<INPUT type='hidden' name="ReqComm<%=j%>" id="ReqComm<%=j%>" value='<%=req_remarks%>' >
			<%}%>
		</font></td>
		<td  class="<%=class_value%>" align='left' style="word-wrap: break-word;width:200px"><FONT size=1>&nbsp;
		<%if(issue_remarks=="")
				{
				out.println("&nbsp;");
				}
		else {
			%>
			<A href='javascript:GetShowRemarks("txtComm<%=j%>","<%=issue_remarks%>","IR")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
			 <INPUT type='hidden' name="txtComm<%=j%>" id="txtComm<%=j%>" value='<%=issue_remarks%>' >   
			<%}%>
		</font></td>
		<td  class="<%=class_value%>" align='left' style="word-wrap: break-word;width:245px"><FONT size=1><%=received_no%>&nbsp;</font></td>
		<td  class="<%=class_value%>" align='left' style="word-wrap: break-word;width:200px"><FONT size=1>&nbsp;
		
		<%
		if(return_remarks=="")
				{
				out.println("&nbsp;");
				}
		else {
			%>
			<A href='javascript:GetReturnRemarks("RetComm<%=j%>","<%=return_remarks%>","RR")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
			<INPUT type='hidden' name="RetComm<%=j%>" id="RetComm<%=j%>" value='<%=return_remarks%>'>   
			<%}%>
		</font></td>
		<td  class="<%=class_value%>" align='left' style="word-wrap: break-word;width:200px"><FONT size=1><%=received_by%>&nbsp;</font></td>
	</tr>
	<%
	j++;
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

