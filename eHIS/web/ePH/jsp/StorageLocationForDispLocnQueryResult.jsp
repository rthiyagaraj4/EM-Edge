<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/StorageLocationForDispLocn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmStorageLocnForDispLocnQuerytResult" id="frmStorageLocnForDispLocnQuerytResult" >
<%
try{
	//Search Criteria's from Query Criteria page
	String	bean_id			=	"StorageLocationForDispLocnBean" ;
	String	bean_name		=	"ePH.StorageLocationForDispLocnBean";
	StorageLocationForDispLocnBean bean = (StorageLocationForDispLocnBean)getBeanObject(bean_id,bean_name,request) ;
	String disp_locn_code	= request.getParameter( "disp_locn_code" );
	 if(disp_locn_code == null) disp_locn_code = "";
	String short_desc		= request.getParameter( "short_desc" ) ;
      if(short_desc == null) short_desc = "";
	String disp_locn_storage= request.getParameter( "storage_bin_code" ) ;
        if(disp_locn_storage == null) disp_locn_storage = "%";
	String description		= request.getParameter( "storage_name" ) ;
      if(description == null) description = "";
	String eff_status     	= request.getParameter( "eff_status" ) ;
         if(eff_status == null) eff_status = "";
	String facility_id=(String) session.getValue( "facility_id" );
        if(facility_id == null) facility_id = "";
	String classValue			= "";
	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));
    
  
	if (eff_status.equals("B")){
		eff_status="";
	}

    ArrayList records =  bean.getStorageQueryData(disp_locn_code,short_desc,disp_locn_storage,description,eff_status,facility_id,from,to);
	
   if( (records.size()>=2) && ( !( ((String) records.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(records.get(0));
	%>
		</td></tr>
          </table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<TH><fmt:message key="ePH.DispenseLocationCode.label" bundle="${ph_labels}"/></TH>
		<TH><fmt:message key="ePH.DispenseLocationDescription.label" bundle="${ph_labels}"/></TH>
		<TH><fmt:message key="ePH.DispenseLocationStoragecode.label" bundle="${ph_labels}"/></TH>
		<TH><fmt:message key="ePH.DispenseLocationStorageDescription.label" bundle="${ph_labels}"/></TH>
	    <TH><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
		<%
		//Retriving the records from result arraylist
	   String dispcode    ="";
	   String shrtdesc    ="";
	   String dispstgcode ="";
	   String dispstgdesc ="";
       String effst       ="";

	 int  recCount	=0;

	 for(int i=1; i<records.size(); i+=5)	{	
		if(recCount%2==0)
			classValue	=	"QRYEVEN";
		else
			classValue	=	"QRYODD";

	dispcode		=	(String)records.get(i+0);
	shrtdesc		=	(String)records.get(i+1);
	dispstgcode     =   (String)records.get(i+2);
	dispstgdesc  	=	(String)records.get(i+3);
	effst		    =	(String)records.get(i+4);
		
	%>
			<tr onClick="Modify(this);" >
	
	<td align="left" class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick=""><%=dispcode%></label></td>
	<td align="left" class="<%=classValue%>"><label  onClick="">&nbsp;<%=shrtdesc%>&nbsp;</label></td>
    <td align="left" class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick=""><%=dispstgcode%></label></td>
	<td align="left" class="<%=classValue%>"><label onClick="">&nbsp;<%=dispstgdesc%>&nbsp;</label></td>
    <%if(effst.equals("E")){%>
   
	<td align="left" class="<%=classValue%>"><label >&nbsp;<img src="../../eCommon/images/enabled.gif">&nbsp;</label></td>

	<% } else if(effst.equals("D")){%>
	<td align="left" class="<%=classValue%>"><label >&nbsp;<img src="../../eCommon/images/disabled.gif">&nbsp;</label></td><tr>

    <% }
	    recCount++;
	 }
   }
	else {
		%>
 <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<% } 	
	
%>

    <input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">

	<%putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	
	
	%>

	
</table>
</form>
</body>
</html>

