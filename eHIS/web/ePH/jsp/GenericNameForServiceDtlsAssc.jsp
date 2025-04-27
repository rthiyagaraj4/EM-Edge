<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!--
Developed by	: P.Sudhakaran.
Module/Function : Generic Name for Service (Master)
-->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%!
	int maxRec=0;
%>
<html>
<head>
	<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/GenericNameForService.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="genericnameforservice_dtls" id="genericnameforservice_dtls">
<%
	//set mode always as INSERT.
	String mode=CommonRepository.getCommonKeyValue("MODE_INSERT");
	String bean_id		= "genericnameforservice" ;
	String bean_name	= "ePH.GenericNameforServiceBean";
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	String dispMode     = request.getParameter( "dispMode" ) ;
	boolean database_rec=false;
	if(dispMode==null) dispMode="";
	StringBuffer initString	=new StringBuffer();
	String classvalue	= "";
	int start=0;
	int end  =0;
	int displaySize = 0;
	int count = 0;
	HashMap dataList=null;

	

		/* Initialize Function specific start */
		GenericNameforServiceBean bean = (GenericNameforServiceBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);

		bean.setMode( mode ) ;

		try{
		ArrayList result=null;
		result=bean.getDBResult();
		result=bean.sortList(result,"GENERIC_NAME");
		maxRec=  result.size();
		displaySize = 13;
		if ( from == null )
			start = 0 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null ){
			end = displaySize ;
		}
		else{
		end = Integer.parseInt( to ) ;
		}
	%>
	<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
	<tr align='right' width='10%'>
		<td class='WHITE'>
			<p align="right">
			<a href="javascript:goPrev('association');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNext('association');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>
	<%
	if( result.size()>0  ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	<%
		count=start;
		int chkCount=0;
//		initString="";
		while ( count < maxRec && count < end)
		{

		dataList = (HashMap)result.get(count);
		if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	if(chkCount==0){
     initString=initString.append((String)dataList.get("EFF_STATUS")).append("|").append(((String)dataList.get("OPER_MODE"))).append("|").append((String)dataList.get("GENERIC_ID")).append("|").append((String)dataList.get("GENERIC_NAME"));
		//initString=((String)dataList.get("EFF_STATUS"))+"|"+((String)dataList.get("OPER_MODE"))+"|"+(String)dataList.get("GENERIC_ID")+"|"+(String)dataList.get("GENERIC_NAME");
	}
	else{
initString=initString.append("~").append((String)dataList.get("EFF_STATUS")).append("|").append(((String)dataList.get("OPER_MODE"))).append("|").append((String)dataList.get("GENERIC_ID")).append("|").append((String)dataList.get("GENERIC_NAME"));	//initString+="~"+((String)dataList.get("EFF_STATUS"))+"|"+((String)dataList.get("OPER_MODE"))+"|"+(String)dataList.get("GENERIC_ID")+"|"+(String)dataList.get("GENERIC_NAME");
	}

	String disp_effstatus="";
	String associate_yn="";
	String disable_eff ="";
	String disable_proces ="";
	if( ((String)dataList.get("SOURCE")).equals("FB") ){
		database_rec=false;
		disable_proces="";
		if(!(((String)dataList.get("OPER_MODE")).equals("DN") || ((String)dataList.get("OPER_MODE")).equals("U")) ){
			associate_yn="checked";
		}
		else{
			associate_yn="";
		}

		if(((String)dataList.get("EFF_STATUS")).equals("E")){
			disp_effstatus="checked";
		}
		else{
			disp_effstatus="";
		}

	}
	else{
		database_rec=true;
		associate_yn="checked";
		disable_proces="disabled";
		
		if(((String)dataList.get("EFF_STATUS")).equals("E")){
			disp_effstatus="checked";
			disable_eff="";
		}
		else{
			disp_effstatus="";
			disable_eff="";
		}
	}
%>
		<tr>
			<td class="<%=classvalue%>" >
	<%
			if(database_rec){
	%>
			<font class="DATAHIGHLIGHT"><%=((String)dataList.get("GENERIC_NAME"))%></font>
	<%
		}
		else{
	%>
			<%=((String)dataList.get("GENERIC_NAME"))%>
	<%
		}
	%>
			<input type="hidden" name="generic_name<%=count%>" id="generic_name<%=count%>" value="<%= (String)dataList.get("GENERIC_NAME") %>"></input>
			<input type="hidden" name="generic_id<%=count%>" id="generic_id<%=count%>" value="<%= (String)dataList.get("GENERIC_ID") %>"></input></td>
			<td class="<%=classvalue%>" align="center" width="10%"><input type="checkbox" <%=disp_effstatus%>  name="eff_status<%=count%>" value="<%=(String)dataList.get("EFF_STATUS")%>" onclick="assignEffStatusAssociation(this);" <%=disable_eff%> ></input></td>
			<td class="<%=classvalue%>" align="center" width="10%">

	<%
		if(database_rec){
	%>
			<input type="hidden"  align="center" name="oper_mode<%=count%>" id="oper_mode<%=count%>" value="<%=(String)dataList.get("OPER_MODE")%>" ></input>
	<%
		}else{
	%>
			<input type="checkbox"  align="center" name="oper_mode<%=count%>" id="oper_mode<%=count%>" value="<%=(String)dataList.get("OPER_MODE")%>" onclick="assignValueAssociation(this);"  <%=associate_yn%> <%=disable_proces%> ></input>
	<%
		}
	%>
			</td>
		</tr>

	<%
		count++;
		chkCount++;

	}
	}else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<%

	}
	}
	catch(Exception es){
	out.println(es);
	}
%>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="initString" id="initString" value="<%=java.net.URLEncoder.encode(initString.toString())%>">
<%
if(dispMode.equals("")){
%>
	<script>
	maxRec = <%=maxRec%> ;
	displaySize = <%=displaySize%> ;
	end = displaySize ;
	activeLink();
	</script>
<%
}
	else{
	%>
	<script>
	maxRec = <%=maxRec%> ;
	displaySize = <%=displaySize%> ;
	end = <%=end%> ;
	start=<%=start%>;
	activeLink();
	</script>
<%
	}
%>
<input type="hidden" value="<%=end%>" name="end">
<input type="hidden" value="<%=start%>" name="start">
<input type="hidden" value="<%=count%>" name="count">
<input type="hidden" value="association" name="choosen_link" id="choosen_link">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="location_ref" id="location_ref" value="byservice">
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

