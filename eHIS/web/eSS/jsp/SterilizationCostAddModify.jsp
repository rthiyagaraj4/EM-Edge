<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* " %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha Krishnadasar">
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SterilizationCost.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

	<body onMouseDown='CodeArrest();'>

<%
	String codeDisabled				=		"";
	String mode						=		"";
	ArrayList result				=		new ArrayList();

	String bean_id					=		"sterilizationCostBean" ;
	String bean_name				=		"eSS.SterilizationCostBean";

	String group_code				=		request.getParameter( "group_code" ) ==null?"":request.getParameter( "group_code" );
	String sterile_type				=		request.getParameter( "sterile_type" ) ==null?"":request.getParameter( "sterile_type" );
	SterilizationCostBean bean		=		(SterilizationCostBean)getBeanObject( bean_id, bean_name, request ) ;
	int maxRec						=		0; 
	String dispMode					=		request.getParameter( "dispMode" ) ;
	boolean database_rec			=		false;
	String initString				=		"";
	if(dispMode==null) dispMode		=		"";
	int start						=		0;
	int end							=		0;
	int displaySize					=		0;
	int count						=		0;
	String classvalue				=		"";
	String classvalueChange			=		"";	

	String from						=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to						=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String Cost						=		"";
	count							=		start;

	String deleteCheck				=		"";
	String deleteCheckVal			=		"N";
	String costDisable				=		"";
	String dbval					=		"";
	HashMap dataList				=		null;
try{
	/* Mandatory checks start */
	mode							=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setGroup_code(group_code) ;
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	/* Initialize Function specific end */

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	= "disabled";
		if (null == group_code || sterile_type==null)
			return;		
	}
	
	displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
	
	
	result=bean.getDataList();
	
	maxRec=  result.size();
	displaySize =  Integer.parseInt( (String) SsRepository.getSsKeyValue("QUERY_RESULT"));


	if ( from == null || from =="" )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to ==""){
		end = displaySize ;
	}
	else{
		end = Integer.parseInt( to ) ;	
	}
	%>
	<form name="formSterilizationCost" id="formSterilizationCost"  >
	<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
	<tr align='right' width='10%'>
		<td class='WHITE'>
			<p align="right">
			<a href="javascript:goPrev('select');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNext('select');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>

	<%
	if(result.size() > 0 ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th><fmt:message key="eSS.SterileType.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.SterileCost.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.previous.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
<%
	
	count	= start;
	int chkCount = 0;
	initString = "";
	String str_service_code = "";
	String str_short_desc	= "";
	String str_process		= "";
	String eff_status		= "";

	while ( count < maxRec && count < end)
	{
			dataList = (HashMap)result.get(count);
			if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

		eff_status		 = (String)dataList.get("EFF_STATUS");
		str_service_code = (String)dataList.get("STERILE_TYPE");
		str_short_desc	 = (String)dataList.get("SHORT_DESC");
		Cost	         = ((String)dataList.get("STERILE_COST")).equals("0")?"":((String)dataList.get("STERILE_COST"));
		str_process		 = (String)dataList.get("PROCESS");
		dbval		     = (String)dataList.get("DBVAL");

		String disp_effstatus	= "";
		String associate_yn		= "";
		String disabled			= "";
		
		if(str_process.equals("Y")){
			associate_yn		=	"checked";
			costDisable			=	"";
		}
		else
		{
			associate_yn		=	"";
			disabled			=	"";
			costDisable			=	"disabled";
			database_rec		=	false;
		}
		if(dbval.equals("Y")){
			database_rec		=	true;
			disabled			=	"disabled";
			deleteCheck			=	"";
		}
		else{
			database_rec		=	false;
			disabled			=	"";
			deleteCheck			=	"disabled";
		}
	
	if( chkCount==0 )
	{
	  initString=eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+Cost+"|"+dbval;
	}
	else
	{
	  initString=initString+"~"+eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+Cost+"|"+dbval;
	}

	%>
		<tr>
			<td class="<%=classvalue%>" >
			<%
			if(database_rec){
			%>
			<font color=#FF5400 style="font-weight:500"><%= str_short_desc %></font>
			<%
			}else{
			%>
				<%= str_short_desc %>
			<%
			}
			%>
			<input type="hidden" name="sterile_desc<%=count%>" id="sterile_desc<%=count%>" value="<%=str_short_desc%>"></input>
			<input type="hidden" name="sterile_type<%=count%>" id="sterile_type<%=count%>" value="<%=str_service_code%>"></input></td>
			
			<td class="<%=classvalue%>" align="center" width="10%">
			<% 
		if(database_rec){
	%>	
		<input type="hidden"  align="center" name="process<%=count%>" id="process<%=count%>" value="<%=str_process%>"></input>
	<%
		}else{
	%>
		<input type="checkbox"  align="center" name="process<%=count%>" id="process<%=count%>" value="<%=str_process%>" onclick="assignValue(this);makeEnable(this,'sterile_cost<%=count%>')"  <%=associate_yn%>  <%=disabled%> ></input>
	<%
		}
	%>	
		
		</td>
		<td class="<%=classvalueChange%>" align="center" width="10%" ><input type="text" size='16' maxlength='16' <%=disp_effstatus%>  name="sterile_cost<%=count%>" value="<%=Cost%>"  onKeyPress="return isValidNumber(this,event,<%=bean.getCurrencyFormat()%>);" maxLength='<%=bean.getCurrencySize()%>' size='<%=bean.getCurrencySize()%>'    class="NUMBER" onBlur="checkDoubleFormat(this);" <%=costDisable%>  ></input></td>
		<td class="<%=classvalue%>" align="center" width="10%" ><input type="checkbox"  align="center" name="delete_row<%=count%>" id="delete_row<%=count%>" value="<%=deleteCheckVal%>" onclick="assignValue1(this);"   <%=deleteCheck%> ></input></td>
		</tr>
	
	<%
		count++;
		chkCount++;
	}
	}
	else{
	%>
	<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA","Common" ));</script>
	<%
	
	}
	}
	catch(Exception e){
	// out.println(es);
	e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</table>


		<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="group_code" id="group_code"		value="<%=group_code%>">
		<input type="hidden" name="start" id="start"			value="<%=start%>">
		<input type="hidden" name="count" id="count"			value="<%=count%>">
		<input type="hidden" name="displaySize" id="displaySize"		value="<%=displaySize%>">
	
		<input type="hidden" name="totalRecords" id="totalRecords"	value="<%=result.size()%>">
		<input type="hidden" name="end" id="end"				value="<%=end%>">
		<input type="hidden" name="choosen_link" id="choosen_link"	value="select" >
		<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="initString" id="initString"		value="<%=java.net.URLEncoder.encode(initString)%>">
		<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP")%>">
		<input type="hidden" name="locale" id="locale"			value="<%=locale %>">

		<%
		if(dispMode.equals("")){
%>
	<script>
	maxRec			= <%=maxRec%> ;
	displaySize		= <%=displaySize%> ;
	end				= displaySize ;
	activeLink();
	</script>
<%
}
	else{
	%>
	<script>
	maxRec			= <%=maxRec%> ;
	displaySize		= <%=displaySize%> ;
	end				= <%=end%> ;
	start			=<%=start%>;
	activeLink();
	</script>
<%
	
	}
%>
	</form>	
</body>
<% putObjectInBean(bean_id,bean,request);%>
</html>

