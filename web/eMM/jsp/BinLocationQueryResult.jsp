<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.Common.*, eMM.* " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html> 
<head>
<%
		request.setCharacterEncoding("UTF-8");
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<!-- <script language="javascript" src="../js/MmMessages.js"></script> -->
	<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src="../../eMM/js/BinLocation.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body>
<%
	String bin_location_code	=	request.getParameter("bin_location_code");
	String long_desc			=	request.getParameter("long_desc");
	String eff_status			=	request.getParameter("eff_status");
	String store_code			=	request.getParameter("store_code");
	
	String store_desc			=	"";
	String facility_id			="";
	facility_id					=(String) session.getAttribute("facility_id");
	
	String orderByTemp[]				=	request.getParameterValues("orderbycolumns");
	String[] orderBy	= new String[orderByTemp.length+2] ;
	orderBy[0] = "ms.short_desc" ;
	orderBy[1] =  "mb.store_code" ;

	for(int i=2,j=0;j<orderByTemp.length;i++,j++)
	{
			orderBy[i] = orderByTemp[j] ;
			
	}
	orderByTemp = null ;

	/*(for(int j=0;j<orderBy.length;j++)
	{
		out.println(orderBy[j]+",");
	}*/
	
	boolean searched				=	(request.getParameter("searched") == null) ?false:true;
	String classvalue				=	"";
//	String bean_id					=	"BinLocationBean" ;
//	String bean_name				=	"eMM.BinLocationBean";

	try{

//		BinLocationBean bean = (BinLocationBean) mh.getBeanObject(bean_id, request, bean_name);

		bin_location_code = CommonBean.checkForNull(bin_location_code)+'%';
		long_desc = CommonBean.checkForNull(long_desc)+'%';
		eff_status = CommonBean.checkForNull(eff_status);
		store_code = CommonBean.checkForNull(store_code,"%");

		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", MmRepository.getMmKeyValue("SQL_MM_BINLOCATION_QUERYCRIT"));
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add("store_desc");
		displayFields.add("bin_location_code");
		displayFields.add("long_desc");
		displayFields.add("short_desc");
		displayFields.add("eff_status");
		displayFields.add("store_code");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( bin_location_code);
		chkFields.add( long_desc);
		chkFields.add( eff_status);
		chkFields.add( facility_id);
		chkFields.add( store_code);
		chkFields.add( locale);


		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			//if(true) return;
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
		<th ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
				
			for(int recCount=2; recCount<result.size(); recCount++)
			{
				records=(ArrayList) result.get( recCount );

				if( !store_desc.equals((String)records.get(0)) ) {
				store_desc = (String)records.get(0) ;
				out.println("<tr><td class='ITEMSELECT' align='left' colspan='4'><b>"+store_desc+"</b></td></tr>");
				}

				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				
		%>
		
			<tr onClick="Modify(this,'<%=records.get(4)%>','<%=records.get(5)%>');" >
				<td class="<%=classvalue%>"  onmouseover="changeCursor(this);" align="left"><font class='HYPERLINK'><%=records.get(1)%></font></td>
				<td class="<%=classvalue%>"><%=records.get(2)%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
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
		out.println(CommonBean.setForm ( request ,"../../eMM/jsp/BinLocationQueryResult.jsp", searched) );
	}
	catch(Exception e)
	{
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0184
	}
%>
</body>
</html>

