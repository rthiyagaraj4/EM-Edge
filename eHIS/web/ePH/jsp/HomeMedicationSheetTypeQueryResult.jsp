<!DOCTYPE html>
 <%-- Author : ArunKumar M
 	  Form Name : Home Medication Sheet Query Result 
 	  Created on 29/01/2014 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute		("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/HomeMedicationSheetType.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String med_type_ind		= request.getParameter( "home_medn_sheet_type" ) ;
		String sql_ph_home_med_type_lookup = request.getParameter("sql_ph_home_med_type_lookup");
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			= "";
			med_type_ind = CommonBean.checkForNull( med_type_ind );
			
			HashMap sqlMap = new HashMap();
			sqlMap.put( "sqlData", sql_ph_home_med_type_lookup);
			HashMap funcMap = new HashMap();

			ArrayList displayFields = new ArrayList();
			
			displayFields.add( "FORM_CODE" );
			displayFields.add( "FORM_DESC" );
			displayFields.add( "MED_TYPE_IND" );//Added for RUT-SCF-0358[IN46714]
			displayFields.add( "EFF_STATUS" );
			
			ArrayList chkFields = new ArrayList();
			
			chkFields.add( med_type_ind.trim() );
			chkFields.add(locale);

			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
			
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<form name="queryResultForm" id="queryResultForm">
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
							 out.println(result.get(1));// For display the previous/next link
%>
						</td>
					</tr>
				</table>

				<table  border="1" cellpadding="0" cellspacing="0" width="98%" align="center">
					<th style="width:15%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
					<th style="width:30%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th style="width:20%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
					<th style="width:10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%
					ArrayList records=new ArrayList();
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
%>
					<tr>
<%
					records=(ArrayList) result.get( recCount );
					for(int colCount=0; colCount<records.size(); colCount++){
						if(colCount==0){
%>
							<td class="<%=classvalue%>"  ><%=records.get(0).toString()%></td>
<%
						}
						if(colCount==1){
%>
							<td class="<%=classvalue%>"  ><%=records.get(1)%></td>
<%
						}
							if(colCount==2){//Added for RUT-SCF-0358[IN46714] - Start
					if(records.get(2).equals("I")){%>
						<td class="<%=classvalue%>"  ><fmt:message key="ePH.Include.label" bundle="${ph_labels}"/></td>
				<%	}else if(records.get(2).equals("S")){%>
						<td class="<%=classvalue%>"  ><fmt:message key="ePH.Separate.label" bundle="${ph_labels}"/></td>
				<%	}else if(records.get(2).equals("O")){%>
						<td class="<%=classvalue%>"  ><fmt:message key="ePH.Only.label" bundle="${common_labels}"/></td>
				<% }//Added for RUT-SCF-0358[IN46714] - End
					}
					if(colCount==3){
%>
							<td class="<%=classvalue%>"  ><img src='../../eCommon/images/enabled.gif'></td>
<%
						}
					}
%>		
					</tr>
<%
				}
%>
				</table>
<%
				out.flush();
			}
			else{
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script> 
<%
			}
%>
			</form>
<%
			//it is important to close the form above cause we are opening another form here
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/HomeMedicationSheetTypeQueryResult.jsp", searched) );
		}
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
	</body>
</html>

