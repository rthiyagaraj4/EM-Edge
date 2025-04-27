<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.PrepareGroupBean,eCommon.Common.*,eSS.*,java.util.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title> 
 <%
			request.setCharacterEncoding("UTF-8");
 			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/SurgeryType.js"> </script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	    
</head>
<body onload="">
<%
	String radioval							=		request.getParameter( "radioval" )==null?"":request.getParameter( "radioval" ) ;
	String search_text						=		request.getParameter( "search_text" )==null?"%":request.getParameter( "search_text" )+"%" ;
	
	boolean searched						=		(request.getParameter("searched") == null) ?false:true;
	String short_desc						=		"";
	
	
	String stlightgreen						=		""; 
	String code = "";
	String description = "";
	if(radioval.equals("D")){
		code = "%";
		description = search_text;
	}else{
		code = search_text;
		description ="%" ;
	}
	
	String bean_id = "surgeryTypeBean";
	String bean_name = "eSS.SurgeryTypeBean";
	SurgeryTypeBean bean				=		(SurgeryTypeBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	
  		
	String  classvalue					=		"";
	ArrayList result					=		new ArrayList();	
	String stSQL						=		"";
			
	// Ends
	try{
				HashMap sqlMap					=	new HashMap();
				stSQL		=		eSS.Common.SsRepository.getSsKeyValue("SQL_SS_OT_SURGERY_TYPE_SELECT");
				
				sqlMap.put("sqlData", stSQL );
				HashMap funcMap = new HashMap();
				ArrayList displayFields = new ArrayList();

				displayFields.add("CODE");
				displayFields.add("LONG_DESC");
				displayFields.add("SHORT_DESC");
				displayFields.add("NATURE_TYPE");

				ArrayList chkFields		=		new ArrayList();
				
				chkFields.add(locale);
				chkFields.add(code);
				chkFields.add(description);
				
					

				funcMap.put( "displayFields", displayFields );
				funcMap.put( "chkFields", chkFields );
				 result		=		(ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,15);
				

				 
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<form name="SurgeryNamesearchForm" id="SurgeryNamesearchForm">
			
			<br>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%>&nbsp;</td>
			</tr>
			</table>
		
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
			<tr>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eSS.SurgeryName.label" bundle="${ss_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></b></font></th>

			</tr>
		<%
			int index=0, recCount=2;
			ArrayList records=new ArrayList();
			for(index=0, recCount=2; recCount<result.size(); recCount++,index++) {
								
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				
				

%>
			
		 <tr onClick="" >
<%			records = (ArrayList) result.get( recCount );

				 short_desc = CommonBean.checkForNull((String)records.get(2));
				 short_desc = java.net.URLEncoder.encode(short_desc,"UTF-8");
				
%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onClick="ModifySearch('<%=(String)records.get( 0 )%>','<%=short_desc%>','<%=(String)records.get(3)%>');"><font size=1 class='HYPERLINK'><%=CommonBean.checkForNull((String)records.get(0),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=(String)records.get(1)%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=java.net.URLDecoder.decode(short_desc,"UTF-8")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=(String)records.get(3)%></font></td>
				
				
			</tr>
			
						
		<%}%>
			</table>
			</br>
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			 <input type=hidden name=bean_id					value="<%=bean_id%>"/>
			<input type=hidden name=bean_name					value="<%=bean_name%>"/>

</form>
		<%
			out.flush();
		} 
		else
		{%>
			<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			document.location.href="../../eCommon/html/blank.html";
		    </script>
  		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/OTSurgeryNameSearchResult.jsp", searched) );
		} catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
		}
%>

<%
putObjectInBean(bean_id,bean,request); 
%>
</body>
</html>
 

