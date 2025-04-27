<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../../eOR/js/SpecimenOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="specimenDispatchDetail" id="specimenDispatchDetail">
<%

	String bean_id				= request.getParameter("bean_id");
	String bean_name			= request.getParameter("bean_name");
	String dispatch_date_time 	= request.getParameter("dispatch_date_time");
	String dispatch_mode		= request.getParameter("dispatch_mode");
	String curr_sys_date 		= request.getParameter("curr_sys_date");

	if (bean_id==null)	bean_id 					= "";
	if (bean_name==null) bean_name 					= "";
	if(dispatch_date_time==null) dispatch_date_time	= "";
	if(curr_sys_date==null) curr_sys_date 			= "";
	if(dispatch_mode==null) dispatch_mode			= "";

	SpecimenOrder bean 	= (SpecimenOrder)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);

	ArrayList DispatchModeData = bean.getDispatchMode();
	ArrayList sysdate 	= (ArrayList)bean.getSysDateTime();
	if (sysdate.size() == 3)
		curr_sys_date 	=  (String)sysdate.get(2);//bean.getSysDate();
	if ( !localeName.equals("en") )
	{ 

		if (curr_sys_date.equals("null")|| curr_sys_date.equals(" "))curr_sys_date="";
		curr_sys_date=com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);
	//if (specimen_date_time.equals("null")|| specimen_date_time=="")specimen_date_time="";
		//specimen_date_time=com.ehis.util.DateUtils.convertDate(specimen_date_time,"DMYHM","en",localeName);
	}

	if(dispatch_date_time.equals("")) 
	{
		dispatch_date_time = curr_sys_date;
	} 
	else 
	{
		StringTokenizer stoken = new StringTokenizer(dispatch_date_time,"~");
		while(stoken.hasMoreTokens())
		{
			dispatch_date_time = stoken.nextToken();
		}
	}

	if (!dispatch_mode.equals("")) 
	{
		StringTokenizer stoken = new StringTokenizer(dispatch_mode,"~");
		while(stoken.hasMoreTokens()) 
		{
			dispatch_mode	= stoken.nextToken();
		}
	}

%>
	<table cellpadding=2 cellspacing=0 border='0' width='100%' align=center>
    <%--<th>Dispatch Date Time</th><th>Dispatch Mode</th>--%>
	<%//String slClassValue = "";
	int size = 1;

	for (int i=0; i < size;i++) 
	{
%>
		<TR>
			<TD class='label' width='48%'><fmt:message key="eOR.DispatchDateTime.label" bundle="${or_labels}"/></TD>
			<TD class='fields' width='52%'><input type="text" name="dispatch_date_time<%=i%>" id="dispatch_date_time<%=i%>" value="<%=dispatch_date_time%>" size="16" maxLength="16"  onKeyPress="enterCheck();"><img src="../../eCommon/images/mandatory.gif" align=center/></TD>
		</TR>
		<TR>
			<TD class='label' width='48%'><fmt:message key="eOR.DispatchMode.label" bundle="${or_labels}"/></TD>
			<TD class='fields' width='52%' ><Select width='20' name="dispatch_mode<%=i%>" id="dispatch_mode<%=i%>"><Option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</Option>
				<%for (int j = 0; j < DispatchModeData.size(); j++) {String [] record = (String [])DispatchModeData.get(j);%>
					<option value="<%=record[1]%>" <%=(record[1].equals(dispatch_mode))?"selected":""%>><%=record[0]%></option>
				<%}%>
				</Select><img src="../../eCommon/images/mandatory.gif" align=center/>
			</TD>  
		</TR>
		
<%
	}
%>

	<input type="hidden" name="curr_sys_date0" id="curr_sys_date0" value="<%=curr_sys_date%>">
	<Input type='hidden' name='specimen_date_time0' id='specimen_date_time0' value='<%=request.getParameter("specimen_date_time")%>'>
	<Input type='hidden' name='size' id='size' value="<%=size%>"></Input>
	<Input type='hidden' name='localeName' id='localeName' value="<%=localeName%>"></Input>
</table>
<script>
/*Added by Uma on 1/5/2011 for IN025732*/
if (parent.SpecimenDispatchDetailButton.SpecimenDispatchButton)
{
	parent.SpecimenDispatchDetailButton.document.getElementById("dispatchBtn").disabled = false;
}
/*Ends Here*/
</script>
</FORM>
</body>
</html> 
<%
		//putObjectInBean(bean_id,bean,request);
%>

