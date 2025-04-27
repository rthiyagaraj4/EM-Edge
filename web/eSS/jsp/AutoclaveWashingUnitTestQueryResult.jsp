<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* ,eCommon.Common.CommonAdapter" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/AutoclaveWashingUnitTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'>
<%

	String unit_type						=	 request.getParameter("unit_type");
	String autoclave_wash_unit_code			=	request.getParameter("autoclave_wash_unit_code");
	String test_date						=	 request.getParameter("test_date");
	String entry_completed_yn				=	request.getParameter("entry_completed_yn");

	boolean searched						=	(request.getParameter("searched") == null) ?false:true;
	String classvalue						=	"";

	try{

		autoclave_wash_unit_code			=	CommonBean.checkForNull(autoclave_wash_unit_code,"%"		);
		test_date							=	 CommonBean.checkForNull(test_date,""			);
		if(!(locale.equals("en")))
		{
					 test_date		=	com.ehis.util.DateUtils.convertDate(test_date,"DMY",locale,"en");

					 
		}
		HashMap sqlMap						=	new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTOCLAVE_WASH_HDR_QUERY_RESULT") );
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields				=	new ArrayList();

		displayFields.add("unit_type");
		displayFields.add("autoclave_description");
		displayFields.add("test_date");
		displayFields.add("entry_completed_yn");
		displayFields.add("autoclave_wash_unit_code");
		displayFields.add("unit_status");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields					=	 new ArrayList();

		chkFields.add(autoclave_wash_unit_code		);
		chkFields.add(unit_type);
		chkFields.add(test_date			);
		chkFields.add(entry_completed_yn			);
		chkFields.add( locale);

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
		{
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<th><fmt:message key="eSS.UnitType.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.AutoclaveWashUnit.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.TestDate.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.EntryCompleted.label" bundle="${ss_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		%>
				<tr onClick="Modify(this);" >
	<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				String test_date_disp = (String)records.get(2);
				if(test_date_disp==null)test_date_disp="";
				  if(!(locale.equals("en")))
				{
					 test_date_disp=com.ehis.util.DateUtils.convertDate(test_date_disp,"DMY","en",locale);
					 if(test_date_disp==null)test_date_disp="";
					 
				}
				for(int colCount=0; colCount<records.size(); colCount++){
	
					if(colCount==4||colCount==5){
						%>
						<td class='NODISPLAY'><%=(String)records.get( colCount )%></td>	
						<%
						continue;
					}
					else if(colCount==2){
						%>
						<td class="<%=classvalue%>"><%=test_date_disp%></td>	
						<%
						continue;
					}
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);" align="<%=(colCount==3)?"center":(((colCount==1)||(colCount==2)||(colCount==0))?"left":"")%>"
						<%
						 //if gif has to be provided
							if(colCount == 3) {
								if( ((String)records.get( colCount )).equals("Y"))
									out.println("><img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("><img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+(String)records.get( colCount ));
							}
						%></td>
						
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
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				self.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/AutoclaveWashingUnitTestQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html></html>

