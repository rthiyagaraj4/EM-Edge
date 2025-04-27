<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!--
Developed by	: P.Sudhakaran.
Module/Function : Generic Name for Service (Master)
-->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%!
	int maxRec=0;
	int count = 0;
%>
<html>
<head>
	<%
    request.setCharacterEncoding("UTF-8");
	//Added  for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/GenericNameForService.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="" onKeyDown="lockKey()">
<form name="genericnameforservice_dtls" id="genericnameforservice_dtls">
<%

	//set mode always as INSERT.
	String mode=CommonRepository.getCommonKeyValue("MODE_INSERT");
	String generic_id	= request.getParameter( "generic_id" ) ;
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	String dispMode     = request.getParameter( "dispMode" ) ;
	StringBuffer initString	=new StringBuffer();
	if(dispMode==null) dispMode="";
	int start=0;
	int end  =0;
	int displaySize = 0;
	String classvalue	= "";
	String classvalueChange="";
	String bean_id		= "genericnameforservice" ;
	String bean_name	= "ePH.GenericNameforServiceBean";
	HashMap dataList=null;
	
	/* Initialize Function specific start */
	GenericNameforServiceBean bean = (GenericNameforServiceBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);

	ArrayList result=null;
	try{

	//Clear the Duplicates in DB
	bean.emptyDupRecords();


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

	result=(ArrayList)bean.getGenericCodeResultPage(generic_id,start,end,locale);
	maxRec=bean.getmaxCount();
	%>
	<table cellpadding='0' cellspacing='0' width='100%' align='center'>
	<tr>
	<td width="80%" class="white">&nbsp;</td>
	<td width="20%" class="white">&nbsp;
		<td align="right">
			<a href="javascript:goPrev('select');" id="prev"  style="visibility:hidden;" >
			<fmt:message key="Common.previous.label" bundle="${common_labels}"/>&nbsp;&nbsp;</a></td>
		<td align="right"><a href="javascript:goNext('select');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		</td>
	</td>
	</tr>
	</table>

	<%
	if(result.size() > 0 ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th>&nbsp;</th><th><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<%
	count=start;
	int chkCount=0;
//	initString="";
	String str_process="";
	String eff_status="";
	for(int j=0;j<result.size();j++)
	{

	dataList = (HashMap)result.get(j);
			if ( j % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	str_process=(String)dataList.get("PROCESS");
	eff_status=(String)dataList.get("EFF_STATUS");
	String disp_effstatus="";
	String associate_yn="";
	String disabled ="";
	boolean database_rec=false;
	ArrayList key=bean.chkGenericCodeDB((String)dataList.get("GENERIC_ID"));
	if(key.size()==3){

		if( ((String)key.get(2)).equals("FB") ){
			classvalueChange=classvalue;
			disabled="";
			database_rec=false;
				if(!key.get(0).equals("DN") ){
					associate_yn="checked";
					str_process="Y";
				}
				else{
					associate_yn="";
				}
				if(((String)key.get(1)).equals("E")){
					disp_effstatus="checked";
				}
				else{
					disp_effstatus="";
					eff_status="D";
				}
		}
		else{

			if(key.get(0).equals("U")){
			classvalueChange="DATACHANGE";
			}
			else{
			classvalueChange=classvalue;
			}
			disabled="";
			associate_yn="checked";
			database_rec=true;
				if(((String)key.get(1)).equals("E")){
					disp_effstatus="checked";
				}
				else{
					disp_effstatus="";
					eff_status="D";
				}
		}
	}
	else{
			classvalueChange=classvalue;
			database_rec=false;
			if(((String)dataList.get("EFF_STATUS")).equals("D")){
			disp_effstatus="";
			}
			else{
			disp_effstatus="checked";
			}

			if(   ((String)dataList.get("PROCESS")).equals("Y")){
			associate_yn="checked";
			}
			else{
			associate_yn="";
			}

	}
	if(chkCount==0){
	 initString=initString.append(eff_status).append("|").append(str_process).append("|").append((String)dataList.get("GENERIC_ID")).append("|").append((String)dataList.get("GENERIC_NAME")); //initString=eff_status+"|"+str_process+"|"+(String)dataList.get("GENERIC_ID")+"|"+(String)dataList.get("GENERIC_NAME");
	}
	else{
initString=initString.append("~").append(eff_status).append("|").append(str_process).append("|").append((String)dataList.get("GENERIC_ID")).append("|").append((String)dataList.get("GENERIC_NAME"));	//initString="~"+eff_status+"|"+str_process+"|"+(String)dataList.get("GENERIC_ID")+"|"+(String)dataList.get("GENERIC_NAME");
	}
	%>
		<tr>
			<td class="<%=classvalue%>" width="1%" onmouseover="changeCursor(this);" onClick="populate_generic_details('<%=(String)dataList.get("GENERIC_ID")%>');"><a href>+</a></td>
			<%
				if(database_rec){
			%>
			<td class="<%=classvalue%>" ><font class="DATAHIGHLIGHT"><%= (String)dataList.get("GENERIC_NAME") %></font>
			<% }else{
			%>
				<td class="<%=classvalue%>" ><%= (String)dataList.get("GENERIC_NAME") %>
			<%
			}
			%>
			<input type="hidden" name="generic_name<%=count%>" id="generic_name<%=count%>" value="<%= (String)dataList.get("GENERIC_NAME") %>"></input><input type="hidden" name="generic_id<%=count%>" id="generic_id<%=count%>" value="<%= (String)dataList.get("GENERIC_ID") %>"></input></td>
			<td class="<%=classvalueChange%>" align="center" width="10%" onMouseOver="displayToolTipDataChange('<%=classvalueChange%>','Record has been Modified');" onMouseOut="disasbleToolTipDataChange('<%=classvalueChange%>');"><input type="checkbox" <%=disp_effstatus%>  name="eff_status<%=count%>" value="<%=eff_status%>" onclick="assignEffStatus(this);" <%=disabled%> ></input></td>
			<td class="<%=classvalue%>" align="center" width="10%">
	<%
		if(database_rec){
	%>
			<input type="hidden"  align="center" name="process<%=count%>" id="process<%=count%>" value="<%=str_process%>" ></input>
	<%
		}else{
	%>
		<input type="checkbox"  align="center" name="process<%=count%>" id="process<%=count%>" value="<%=str_process%>" onclick="assignValue(this);"  <%=associate_yn%>  <%=disabled%> ></input>
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
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
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
<input type="hidden" value="<%=generic_id%>" name="generic_id">
<input type="hidden" value="<%=end%>" name="end">
<input type="hidden" value="<%=start%>" name="start">
<input type="hidden" value="<%=count%>" name="count">
<input type="hidden" value="select" name="choosen_link" id="choosen_link">
<input type="hidden" name="location_ref" id="location_ref" value="byservice">
<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
	<tr><td width="100%" id="t"></td></tr>
</table>
</div>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

