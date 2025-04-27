<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
	<%

	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<html>
	<head>
		<title></title>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/AdminRouteCategory.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%  
	
	String strARCCode		=	request.getParameter("arc_code");
	String strARCDesc		=	request.getParameter("arc_desc");
	String eff_status			=	request.getParameter( "eff_status" ) ;
	boolean searched			=	 request.getParameter( "searched" ) == null ? false : true  ;

	try
	{
		String classvalue			= "";
		strARCCode	= CommonBean.checkForNull( strARCCode );
		strARCDesc  = CommonBean.checkForNull( strARCDesc );
		eff_status		= CommonBean.checkForNull( eff_status );
	
	
		if (eff_status.equals("B"))
		{
			eff_status="";
		}


	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters
	
	String sql="SELECT ADMIN_ROUTE_CATG_CODE,ADMIN_ROUTE_CATG_DESC,EFF_STATUS FROM PH_ADMIN_ROUTE_CATG_LANG_VW PH_ADMIN_ROUTE_CATG WHERE UPPER(ADMIN_ROUTE_CATG_CODE) like NVL(upper(?),ADMIN_ROUTE_CATG_CODE) AND UPPER(ADMIN_ROUTE_CATG_DESC) LIKE NVL(UPPER(?),ADMIN_ROUTE_CATG_DESC) AND EFF_STATUS LIKE NVL(?,EFF_STATUS) AND LANGUAGE_ID =?";
	sqlMap.put( "sqlData", sql); 
	
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "ADMIN_ROUTE_CATG_CODE" );
	displayFields.add( "ADMIN_ROUTE_CATG_DESC" );
	displayFields.add( "EFF_STATUS" );


	ArrayList chkFields = new ArrayList();
	chkFields.add( strARCCode.trim()+ "%" ); 
	chkFields.add( strARCDesc.trim() + "%" ); 
	chkFields.add( eff_status.trim() + "%" );
	chkFields.add(locale);

	

	
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
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
		
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
			<th><fmt:message key="ePH.AdminRouteCategoryCode.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.AdminRouteCategoryDescription.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
			<%
				//Retriving the records from result arraylist
				ArrayList records=new ArrayList();
				for(int recCount=2; recCount<result.size(); recCount++) 
				{
					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
					%>
				<tr>
					<%
					records=(ArrayList) result.get( recCount );
		
					for(int colCount=0; colCount<records.size(); colCount++)
					{
						if(colCount==0)
						{
							String dkVal = (String)records.get( colCount );
							%>
							<!-- <input type="hidden" name="adr_code<%=recCount%>" id="adr_code<%=recCount%>" value="<%=records.get( colCount )%>"> -->
							<input type="hidden" name="arc_code<%=recCount%>" id="arc_code<%=recCount%>" value="<%=records.get( colCount )%>">
							<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);" onClick="Modify('<%=records.get( 0 )%>')">  <%=dkVal%></font></td>
							<%
						}
						else if(colCount==1 )
						{
							String dkVal = (String)records.get( colCount );
							%>
							<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);" onClick="Modify('<%=records.get( 0 )%>')">  <%=dkVal%></font></td>
							<%
						}	
						else 
						{		
							String fieldValue=((String)records.get( colCount ));
							String dkVal =fieldValue ;
							%>
							<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">
							<%
							out.println(getImage(dkVal));
							out.println("</td>");
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
		} else{
		%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/AdminRouteCategoryQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>

<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
}
%>

</body>
</html>

	

