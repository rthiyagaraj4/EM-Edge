<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.Common.*, eST.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/Machine.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String machine_code = request.getParameter("machine_code");
	String machine_name = request.getParameter("machine_name");
	String model_no= request.getParameter("model_no");
	String manufacturer_id= request.getParameter("manufacturer_id");
	String eff_status = request.getParameter("eff_status");
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
	HashMap sqlMap				=		new HashMap();
	HashMap funcMap				=		new HashMap();
	ArrayList displayFields		=		new ArrayList();
	ArrayList chkFields			=		new ArrayList();
	ArrayList result			=		new ArrayList();
	ArrayList records			=		new ArrayList();

	try{

		machine_code = CommonBean.checkForNull(machine_code).trim()+"%";
		machine_name = CommonBean.checkForNull(machine_name).trim()+"%";
		model_no = CommonBean.checkForNull(model_no).trim()+"%";
		manufacturer_id = CommonBean.checkForNull(manufacturer_id).trim()+"%";
		eff_status = CommonBean.checkForNull(eff_status);

		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_MACHINE_CODE_QUERY_RESULT"));

		//The fields are going to be display

		displayFields.add("machine_code");
		displayFields.add("machine_name");
		displayFields.add("model_no");
		displayFields.add("short_name");
		displayFields.add("eff_status");

		//The fields are going to be in where condition * should match with the query
		chkFields.add( machine_code);
		chkFields.add( machine_name);
		chkFields.add( model_no);
		chkFields.add( manufacturer_id);
		chkFields.add( eff_status);
		chkFields.add( locale);
		

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );


		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
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
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" >
				<th><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.MachineName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.ModelNo.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<%
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
						<td class="<%=classvalue%>" style="cursor:pointer" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
						 //if gif has to be provided
							if(colCount == 4) {
								out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else if(colCount == 3) {
								out.println("align='left'>"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
							}
							else {
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
							}%>

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
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eST/jsp/MachineQueryResult.jsp", searched) );
	}
	catch(Exception e) {
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

