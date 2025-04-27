<%-- JSP Page specific attributes start --%>

<%@page import="java.util.*, eST.*, eST.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
	<head> 
		<title></title>
		<%
		
		request.setCharacterEncoding("UTF-8");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/AssemblyInstruction.js"> </script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
<%
		//Search Criteria's from Query Criteria page
		String assm_instrn_code	= request.getParameter( "assm_instrn_code" ) ;
		String description	= request.getParameter( "description" ) ;
		String eff_status	= request.getParameter( "eff_status" ) ;
		 
		boolean searched	=(request.getParameter("searched") == null) ?false:true;
		HashMap sqlMap					=		new HashMap();
		HashMap funcMap					=		new HashMap();
		ArrayList displayFields			=		new ArrayList();
		ArrayList chkFields				=		new ArrayList();
		ArrayList result				=		new ArrayList();
		ArrayList records				=		new ArrayList();
		
		try{
			String classvalue			= "";

			assm_instrn_code = CommonBean.checkForNull( assm_instrn_code )+'%';
			description = CommonBean.checkForNull( description )+'%';
			eff_status = CommonBean.checkForNull( eff_status );
				
			//Common parameters.

			String sql=StRepository.getStKeyValue("SQL_ST_ASSEMBLY_INSTRN_QRY_SELECT");
			sqlMap.put( "sqlData",sql);
			//Function Parameters

			//The fields are going to be display

			displayFields.add( "ASSM_INSTRN_CODE" );
			displayFields.add( "INSTRN_TEXT" );
			displayFields.add( "EFF_STATUS" );
			
			//The fields are going to be in where condition * should match with the query
			chkFields.add(assm_instrn_code);
			chkFields.add(description);
			chkFields.add(eff_status);
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<table cellpadding=0 cellspacing=0 width="100%" align=center>
					<tr>
						<td width="80%" class="white">&nbsp;</td>
						<td width="20%" class="white">&nbsp;
<%
						// For display the previous/next link
						 out.println(result.get(1));
%>
						</td>
					</tr>
				</table>

				<table border="1" cellpadding="0" cellspacing="0" width="100%" align='center'>
					<tr>
						<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					</tr>
<%
					//Retriving the records from result arraylist
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
%>
						<tr onClick="Modify(this);" >
<%

						String link_columns = "1";

						records=(ArrayList) result.get( recCount );
						for(int colCount=0; colCount<records.size(); colCount++){
							if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>
								<td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer'" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
<%
							}
							else{
									if(colCount == 2) {
%>
								<td class='<%=classvalue%>' onclick='disableClick(event);'align='center'>
									<font style='display:none'><%=records.get(colCount)%></font>
<%
										if( ((String)records.get( colCount )).equals("E"))
											out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
										else
											out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
									}
									else {
%>
										<td class='<%=classvalue%>' onclick='disableClick(event);'>
<%
										out.println((String)records.get(colCount ));
									}
%> 
								</td>
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
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%
			}
			out.println(CommonBean.setForm ( request ,"../../eST/jsp/AssemblyInstructionQueryResult.jsp", searched) );
		} catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}finally{
			sqlMap.clear();	
			funcMap.clear();
			displayFields.clear();
			chkFields.clear();		
			result.clear();		
			records.clear();		
		}
%>
	</body>
</html>

