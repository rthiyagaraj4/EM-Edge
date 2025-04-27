<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		//Added  for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/SlidingScaleTmpl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String template_id	= request.getParameter( "template_id" );
	String templateDesc			= request.getParameter( "templateDesc" );
	String rangeUOM_code		= request.getParameter( "rangeUOM_code" ) ;
	String adminUnitUOM_code		= request.getParameter( "adminUnitUOM_code" ) ;
	String eff_statusTemp     		= request.getParameter( "eff_statusTemp" ) ;
	String ord[]				= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	try{
		String classvalue			= "";

		template_id = CommonBean.checkForNull( template_id.trim() );
		templateDesc		   = CommonBean.checkForNull( templateDesc.trim() );
		rangeUOM_code   = CommonBean.checkForNull( rangeUOM_code.trim() );
		adminUnitUOM_code    = CommonBean.checkForNull( adminUnitUOM_code.trim() );
		eff_statusTemp         = CommonBean.checkForNull( eff_statusTemp);
		if (eff_statusTemp.equals("B")){
			eff_statusTemp="";
		}
	
	HashMap sqlMap = new HashMap();
	/*sqlMap.put( "sqlData", "Select TEMPLATE_ID, TEMPLATE_DESC, RANGE_UOM_CODE,ADMIN_UNITS_UOM_CODE, EFF_STATUS from PH_SLIDING_SCALE_TMPL where UPPER(TEMPLATE_ID) like UPPER(?) and UPPER(TEMPLATE_DESC) like UPPER(?) and UPPER(RANGE_UOM_CODE) like UPPER(?) and UPPER(ADMIN_UNITS_UOM_CODE) like UPPER(?) and UPPER(EFF_STATUS) like UPPER(?)"); */

	sqlMap.put("sqlData",PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_TMPL_SELECT")); 
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();
   
	displayFields.add( "TEMPLATE_ID" );
	displayFields.add( "TEMPLATE_DESC" );
	displayFields.add( "RANGE_UOM_CODE" );
	displayFields.add( "ADMIN_UNITS_UOM_CODE" );
	displayFields.add( "EFF_STATUS" );
    //The fields for checking
	ArrayList chkFields = new ArrayList();
	chkFields.add( template_id.trim() + "%" );
	chkFields.add( templateDesc.trim() + "%" );
	chkFields.add( rangeUOM_code.trim() + "%" );
	chkFields.add( adminUnitUOM_code.trim() + "%" );
	chkFields.add( eff_statusTemp.trim() + "%" );
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap,funcMap,request);
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>  <form name="queryResultForm" id="queryResultForm">
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(1));
	%>
	</td></tr>
	</table>
	<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
	<th width="12%"><fmt:message key="Common.TemplateID.label" bundle="${common_labels}"/></th><th width="22%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	
	<th width="22%"><fmt:message key="ePH.RangeUOM.label" bundle="${ph_labels}"/></th>
	<th width="22%"><fmt:message key="ePH.AdminUnitsUOM.label" bundle="${ph_labels}"/></th>
	<th width="10%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
	   <%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr onClick="ModifyRow(this);" >
	<%
				records=(ArrayList) result.get( recCount );
			String link_columns = "1";
			String dkVal = "";
			for(int colCount=0; colCount<records.size(); colCount++)
				{
				       dkVal = (String)records.get(colCount);
								if(dkVal == null)	
									 dkVal = "&nbsp;";
								else if(colCount ==4)
								{
									if(dkVal.compareTo("E")==0)
										dkVal="<img src=\"../../eCommon/images/enabled.gif\">";
									else
										dkVal="<img src=\"../../eCommon/images/disabled.gif\">";
								}
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					{
					%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'> 
						<!-- <%=(String)records.get( colCount )%> -->
						<%=(String)dkVal%>
						</font></td>
					<%
					}else{

						%>
						<%
							if(colCount==4)
							{ %>

							<td class="<%=classvalue%>" onclick="disableClick(event);" align='center' >
							<font style='display:none'><%=records.get(colCount)%></font>
							<%
							out.println(dkVal);
							%>
							<%
							}
							else
							{
							%>
							<td class="<%=classvalue%>" onclick="disableClick(event);" align='center' >
							<%
							out.println(dkVal);
							}
							}
					%> </td>
					<%
					
				}
				%>
			</tr>
		<%}	%>
		</table>
		</form>
		<%
			out.flush();
		} else{
		%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script> 
		<%
		}
		 out.println(CommonBean.setForm ( request ,"../../ePH/jsp/SlidingScaleTmplQueryResult.jsp", searched) );
	} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

