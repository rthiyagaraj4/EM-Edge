<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*,webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
	<script language="JavaScript" src="../js/PatOrderByLocn.js"></script>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
	<Style TYPE="text/css"></style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String bean_id			= request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//PatOrderByLocnBean bean = (PatOrderByLocnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 PatOrderByLocnBean bean = (PatOrderByLocnBean)getBeanObject( bean_id, bean_name, request ) ;
	/* Initialize Function specific end */
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	ArrayList ClinicResult	= null;
	ArrayList NursingResult	= null;
	String record[]			= null;
	int i 					= 0;
	String description 		= "";

%>

<form name="PatOrderByLocnSearchResult" id="PatOrderByLocnSearchResult" >
<table cellpadding=2 cellspacing=0 border=0 width="100%" id="mytable" align="left">
<%
	ClinicResult 	= bean.getClinicResult(practitioner_id);
	NursingResult 	= bean.getNursingUnitResult(practitioner_id);


	if(ClinicResult!=null && ClinicResult.size() > 0)
	{
%>
		<tr>
			<td CLASS="OR_WHITE" id="expandclinic_0" align="left">
			  	<font size="1"><a href="javascript:changeState('0','<%=ClinicResult.size()%>')">+</a>&nbsp;<b>Clinic</b></font>
			</td>
		</tr>
		<tr>

			<td CLASS="OR_WHITE" align="">
				<div id="outerlayerclinic_0" style="visibility:hidden;position:absolute" width="0%">
					<table cellpadding=0 cellspacing=0 border=0 width="100%" align="left">
<%		for(i=0; i<ClinicResult.size(); i++)
		{
			record	= (String[])ClinicResult.get(i);
%>
				<tr>
					<td CLASS="OR_WHITE" width="5%">&nbsp;</td>
					<td CLASS="OR_WHITE" id="changerow_<%=i%>" width="85%">
						<font size="1"><a href="javascript:expandPatient(<%=i%>,'CLINIC','<%=record[1]%>',escape('<%=record[0]%>'))">+&nbsp;<%=record[0]%></a></font>
					</td>

					<td CLASS="OR_WHITE" align="left" width="10%"><font color="black"><b>(<%=record[2]%>)</b></font></td>
				</tr>
<%		}   %>
					</table>
				</div>
			</td>
		</tr>
<%	}



	if(NursingResult!=null && NursingResult.size() > 0)
	{
%>
		<tr>
			<td CLASS="OR_WHITE" id="expandnursing_0" align="left" >
			  	<font size="1"><a href="javascript:changeState('0','<%=NursingResult.size()%>')">+</a>&nbsp;<b>Nursing Unit</b></font>
			</td>
		</tr>
		<tr>
			<td CLASS="OR_WHITE" align="left">
				<div id="outerlayernursing_0" style="visibility:hidden;position:absolute" width="0%">
					<table cellpadding=0 cellspacing=0 border=0 width="100%" align="left" >
<%				for(i=0; i<NursingResult.size(); i++)
				{
					record				= (String[])NursingResult.get(i);
					description			= record[0];
					// Replace the special characters with some special symbol so that they can be replaced  later
					//description	= description.replace(' ','ö');
					//description	= description.replace('>','ø');
					//description	= description.replace('\'','ù');

%>
						<tr>
							<td CLASS="OR_WHITE" width="5%" >&nbsp;</td>
							<td CLASS="OR_WHITE" width="85%" id="changerownursing_<%=i%>"><font size="1"><a href='javascript:expandPatient(<%=i%>,"<%=record[1]%>",escape("<%=description%>"))'>+&nbsp;<%=record[0]%></a></font></td>
							<td CLASS="OR_WHITE" align="left" width="10%"><font color="black"><b>(<%=record[2]%>)</b></font></td>
						</tr>
						<tr>
							<td CLASS="OR_WHITE" colspan="3">
								<div id="innerlayernursing_<%=i%>" style="visibility:hidden;position:absolute" width="0%">
									<table cellpadding=0 cellspacing=0 border=0 width="100%" align="left">
									<tr>
										<td CLASS="OR_WHITE" width="5%" id="secondlevelinner_<%=i%>">&nbsp;</td>
										<td CLASS="OR_WHITE" align="left" width="95%" id="innerrownursing_<%=i%>"></td>
									</tr>
									</table>
								</div>
							</td>
						</tr>
<%				}   %>
					</table>
				</div>
			</td>
		</tr>
<%	} %>
</table>
</body>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

