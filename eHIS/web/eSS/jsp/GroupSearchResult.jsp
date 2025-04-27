<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.PrepareGroupBean,eCommon.Common.*,eSS.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
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
		<script language="Javascript" src="../../eSS/js/PrepareGroup.js"> </script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	    
</head>
<body onload="">
<%
	String radioval							=		request.getParameter( "radioval" )==null?"":request.getParameter( "radioval" ) ;
	String search_text						=		request.getParameter( "search_text" )==null?"%":request.getParameter( "search_text" );//% REMOVED FOR ML-MMOH-CRF-1827
	String store_code						=		request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
	boolean searched						=		(request.getParameter("searched") == null) ?false:true;

	String group_type						=		request.getParameter( "group_type" )==null?"":request.getParameter( "group_type" ) ; //ML-MMOH-CRF-1827
	String search_criteria					=		request.getParameter( "search_criteria" )==null?"":request.getParameter( "search_criteria" ) ; //ML-MMOH-CRF-1827

	String checked = "";
	String disabled = "";
	String stlightgreen						=		"";
	String code = "";
	String description = "";
	//ML-MMOH-CRF-1827
	/*if(radioval.equals("D")){
		code = "%";
		description = search_text;
	}else{
		code = search_text;
		description ="%" ;
	}*/
		//Added for Search Criter filter
	if(radioval.equals("D")){
		code = "%";
			if( search_criteria.equals( "S" ) ){
				description = search_text+"%";
			}else if( search_criteria.equals( "E" ) ){
				description = "%"+search_text;
			}else if( search_criteria.equals( "C" ) ){
				description = "%"+search_text+"%";
			}
	}else{
			if( search_criteria.equals( "S" ) ){
				code = search_text+"%";
			}else if( search_criteria.equals( "E" ) ){
				code = "%"+search_text;
			}else if( search_criteria.equals( "C" ) ){
				code = "%"+search_text+"%";
			}
			
		description ="%" ;
	}//Added ends
	//Added for group_type filter
	if(group_type.equals("A")){
		group_type = "%";
	}//Added ends - ML-MMOH-CRF-1827
	
	String bean_id = "prepareGroupBean";
	String bean_name = "eSS.PrepareGroupBean";
	PrepareGroupBean bean				=		(PrepareGroupBean) getBeanObject( "prepareGroupBean","eSS.PrepareGroupBean",request );
	bean.setLanguageId(locale);
	bean.setStore_code(store_code);
  		
	String  classvalue					=		"";
	ArrayList result					=		new ArrayList();	
	HashMap dataList					=		null;
	String stSQL						=		"";
	String short_desc					=		"";
	
	ArrayList alParameters	=	new ArrayList();
	ArrayList listRecord	=	new ArrayList();
	ArrayList DataList      =new ArrayList();
	
	// Ends
	try{
				HashMap sqlMap					=	new HashMap();
				//stSQL		=		eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_SEARCH_QUERY_RESULT");
				stSQL		=		eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_SEARCH_QUERY_RESULT");
				sqlMap.put("sqlData", stSQL );
				HashMap funcMap = new HashMap();
				ArrayList displayFields = new ArrayList();

				displayFields.add("CODE");
				displayFields.add("DESCRIPTION"); 

				ArrayList chkFields		=		new ArrayList();
				chkFields.add(store_code);
				chkFields.add(locale);
				chkFields.add(code);
				chkFields.add(description);
				chkFields.add(group_type); //ML-MMOH-CRF-1827
				
					
				

				funcMap.put( "displayFields", displayFields );
				funcMap.put( "chkFields", chkFields );
				 result		=		(ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,15);
				

				 
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	
		%>
			<form name="GroupsearchForm" id="GroupsearchForm">
			
			<br>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%>&nbsp;</td>
			</tr>
			</table>
		
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
			<tr>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.code.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.description.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font><input type="checkbox" value="Y" name="selectAll" id="selectAll"   onClick="return toggleCheck(this);" ></th>

			</tr>
		<%
			int index=0, recCount=2;
			ArrayList records=new ArrayList();
			for(index=0, recCount=2; recCount<result.size(); recCount++,index++) {
				checked = "";
				disabled = "";
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

%>
			
		 <tr >
<%			records = (ArrayList) result.get( recCount );
			
			if (bean.isAlreadySelected((String)records.get(0))) {
			checked = "checked";
			}
			if(bean.isModifyRecord((String)records.get(0))){
				disabled= "disabled";
			}
			
			short_desc					=			CommonBean.checkForNull((String)records.get(1));
			
			if(!short_desc.equals("")){
				//short_desc = java.net.URLEncoder.encode(short_desc,"UTF-8");
				/*short_desc = short_desc.replaceAll(" ","%20");
				short_desc = short_desc.replaceAll("\" ","%22");
				short_desc = java.net.URLEncoder.encode(short_desc,"UTF-8");
				short_desc = java.net.URLDecoder.decode(short_desc,"UTF-8");
				short_desc=short_desc.replaceAll("%2520"," ");
				short_desc=short_desc.replaceAll("%20"," ");
				short_desc = short_desc.replaceAll("%22" ," \" ");*/

					//short_desc = short_desc.replaceAll(" ","%20");
					short_desc = java.net.URLEncoder.encode(short_desc,"UTF-8");
					//short_desc = short_desc.replaceAll("%2520","%20");

			}	
%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onClick="details('<%=records.get(0)%>','<%=short_desc%>')"><font size=1 class='HYPERLINK'><%=CommonBean.checkForNull((String)records.get(0),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=java.net.URLDecoder.decode(short_desc,"UTF-8")%></font></td>
				<td class="<%=classvalue%>" ><input type="checkbox" <%=disabled%> name="group_code<%=index%>" <%=checked%> value="<%=records.get(0)%>" onclick="updateSelectionGroupSearch();"</td>
				
			</tr>
			<input type=hidden name="group<%=index%>" id="group<%=index%>"				value="<%=records.get(0)%>">
			<input type=hidden name="desc<%=index%>" id="desc<%=index%>"				value="<%=short_desc%>">
			<input type=hidden name="checked_key<%=index%>" id="checked_key<%=index%>"				value="<%=checked%>"> <!-- Added against Inc#42119 -->
			
		<%}%>
			</table>
			</br>
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="totalRecords" id="totalRecords"			value='<%=index%>'>
			<input type="hidden" name="count" id="count"					value="1">
			<input type="hidden" name="store_code" id="store_code"				value="<%=store_code%>">
			<input type="hidden" name="loc_batch_string" id="loc_batch_string"		value="">
			<input type="hidden" name="chkdIndices" id="chkdIndices"				value="" >
			<input type="hidden" name="total_trays" id="total_trays"				value="<%=index%>">
			 <input type=hidden name=bean_id					value="<%=bean_id%>"/>
			<input type=hidden name=bean_name					value="<%=bean_name%>"/>
			<input type="hidden" name="loc_batch_string" id="loc_batch_string" 		value="">
			<input type="hidden" name="index" id="index" 					value="">
			<input type="hidden" name="mode" id="mode" 					value="">
			<input type="hidden" name="unchecked_index" id="unchecked_index" 		value="">
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/GroupSearchResult.jsp", searched) );
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
  

