<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePO.Common.*, ePO.* " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
	<script language="javascript" src="../../ePO/js/PurchaseUnit.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String unit_code	=	request.getParameter("PUR_UNIT_CODE");
	String long_desc			=	request.getParameter("long_desc");
	String global_unit			=	request.getParameter("global_unit");
	String eff_status			=	request.getParameter("eff_status");
	
	

	
		
	String master_desc			=	"";
	String facility_id			="";
	facility_id					=(String) session.getAttribute("facility_id");
	
	String orderByTemp[]				=	request.getParameterValues("orderbycolumns");
	String[] orderBy	= new String[orderByTemp.length+2] ;
	orderBy[0] = "short_desc" ;
	
	for(int i=2,j=0;j<orderByTemp.length;i++,j++)
	{
			orderBy[i] = orderByTemp[j] ;
			
	}
	orderByTemp = null ;

	boolean searched				=	(request.getParameter("searched") == null) ?false:true;
	String classvalue				=	"";

	try{


		unit_code = CommonBean.checkForNull(unit_code)+'%';
		long_desc = CommonBean.checkForNull(long_desc)+'%';
		global_unit = CommonBean.checkForNull(global_unit);
		eff_status = CommonBean.checkForNull(eff_status);
		
		
		
		
		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", PoRepository.getPoKeyValue("SQL_PO_PURCHASE_UNIT_QUERYCRIT"));
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add("PUR_UNIT_CODE");
		displayFields.add("long_desc");
		displayFields.add("short_desc");
		displayFields.add("global_unit_yn");
		displayFields.add("eff_status");
		
		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( unit_code);
		chkFields.add( long_desc);
		chkFields.add( global_unit);
		chkFields.add( eff_status);
		chkFields.add( locale);//27/06/12

		
		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		
		System.out.println("sqlMap in Purchase Unit qry res = "+sqlMap);
		System.out.println("displayFields in Purchase Unit qry res = "+displayFields);
		System.out.println("chkFields in Purchase Unit qry res = "+chkFields);
		
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
		System.out.println("result in Purchase Unit qry res = "+result);
					
		if((result.size()>=2) && (!(((String) result.get(0)).equals("0"))))
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
		<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="ePO.GlobalUnit.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
				
			for(int recCount=2; recCount<result.size(); recCount++)
			{
				records=(ArrayList) result.get( recCount );

				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				
		%>
		
			<tr onClick="Modify(this,'<%=records.get(2)%>');" >
				<td class="<%=classvalue%>"  onmouseover="changeCursor(this);" align="left"><font class='HYPERLINK'><%=records.get(0)%></font></td>
				<td class="<%=classvalue%>"><%=records.get(1)%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></td>
				<td class="<%=classvalue%>"  align="center" onclick="disableClick(event);">
				<%
					if(((String)records.get(3)).equals("Y"))
					out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
					out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
	
				%>
				</td>
				<td class="<%=classvalue%>"  align="center" onclick="disableClick(event);">
				<%
					if(((String)records.get(4)).equals("E"))
					out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
					out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
	
				%>
				</td>
				
				
			</tr> 
	<%
		}
	%>
		</table>
		<%
			out.flush();
		} 
		else
		{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePO/jsp/PurchaseUnitQueryResult.jsp", searched) );
	}
	catch(Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

