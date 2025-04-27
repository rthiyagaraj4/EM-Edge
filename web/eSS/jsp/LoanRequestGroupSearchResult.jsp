<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.LoanRequestGroupBean,eCommon.Common.*,eSS.*,java.util.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF8"%>
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
		<script language="Javascript" src="../../eSS/js/LoanRequestGroup.js"> </script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	    
</head>
<body onload="">
<%
	String radioval							=		request.getParameter( "radioval" )==null?"":request.getParameter( "radioval" ) ;
	String search_text						=		request.getParameter( "search_text" )==null?"":request.getParameter( "search_text" ) ;
	String req_on_store_code				=		request.getParameter( "req_on_store_code" )==null?"":request.getParameter( "req_on_store_code" ) ;
	String req_by_store_code				=		request.getParameter( "req_by_store_code" )==null?"":request.getParameter( "req_by_store_code" ) ;
	String isincludetargetstore				=		request.getParameter( "isincludetargetstore" )==null?"":request.getParameter( "isincludetargetstore" ) ;
	String rcvng_store_code					=		request.getParameter( "rcvng_store_code" )==null?"":request.getParameter( "rcvng_store_code" ) ;
	String group_type						=		request.getParameter( "group_type" )==null?"":request.getParameter( "group_type" ) ;
	String surgery_type						=		request.getParameter( "surgery_type" )==null?"":request.getParameter( "surgery_type" ) ;
	String surg_description					=		request.getParameter( "surg_description" )==null?"":request.getParameter( "surg_description" ) ;
	String ot_surg_description				=		request.getParameter( "ot_surg_description" )==null?"":request.getParameter( "ot_surg_description" ) ;
	boolean searched						=		(request.getParameter("searched") == null) ?false:true;
	String mode								=		request.getParameter( "mode" )==null?"":request.getParameter( "mode" ) ;
	String searchCriteria  					= 		CommonBean.checkForNull(request.getParameter( "searchCriteria" ) ) ;
	
	String disabled 						= 		"";
	
	String checked 							= 		"";
	String stlightgreen						=		"";
	String code 							= 		"";
	String description 						= 		"";
	
	//Added for Search Criter filter
	if(radioval.equals("D")){
		code = "%";
			if( searchCriteria.equals( "S" ) ){
			description = search_text+"%";
			}else if( searchCriteria.equals( "E" ) ){
				description = "%"+search_text;
			}else if( searchCriteria.equals( "C" ) ){
				description = "%"+search_text+"%";
			}
	}else{
			if( searchCriteria.equals( "S" ) ){
			code = search_text+"%";
			}else if( searchCriteria.equals( "E" ) ){
				code = "%"+search_text;
			}else if( searchCriteria.equals( "C" ) ){
				code = "%"+search_text+"%";
			}
			
		description ="%" ;
	}//Added ends
	//Added for group_type filter
	if(group_type.equals("A")){
		group_type = "%";
	}//Added ends
	
	String bean_id = "LoanRequestGroupBean";
	String bean_name = "eSS.LoanRequestGroupBean";
	LoanRequestGroupBean bean				=		(LoanRequestGroupBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	  		
	String  classvalue					=		"";
	ArrayList result					=		new ArrayList();	
	HashMap dataList					=		null;
	String stSQL						=		"";
	String short_desc					=		"";
	String surg_nature_link_to_OT_yn 	= 		bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_SURG_NATURE_LINK_OT_YN_SELECT"),bean.getLoginFacilityId())).get("SURG_NATURE_LINK_OT_YN"));
	
	ArrayList alParameters				=	new ArrayList();
	ArrayList listRecord				=	new ArrayList();
	ArrayList DataList      			=new ArrayList();
	
	
	
	// Ends
	try{
				HashMap sqlMap					=	new HashMap();
				
				if(isincludetargetstore.equals("true")){					
					stSQL		=		bean.getSsRepositoryValue("SQL_SS_GROUP_SELECT_NEW_WITH_TARGETSTORE");											
				}else{
					stSQL		=		bean.getSsRepositoryValue("SQL_SS_GROUP_SELECT_NEW_WITHOUT_TARGETSTORE");		
				}
				
				if(!surgery_type.equals(""))
					stSQL = stSQL + "  and a.surgery_type=? ";	
				

				sqlMap.put("sqlData", stSQL );
				
				HashMap funcMap = new HashMap();
				ArrayList displayFields = new ArrayList();

				displayFields.add("CODE");
				displayFields.add("DESCRIPTION"); 
				displayFields.add("GROUP_TYPE"); 
				displayFields.add("STERILIZED_QTY"); 
				displayFields.add("SURGERY_DESC");
				displayFields.add("SURGERY_NATURE_CODE");
				displayFields.add("OT_SURGERY_DESC"); 
				
				 

				ArrayList chkFields		=		new ArrayList();
				
				
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(group_type);
				chkFields.add(locale);
				chkFields.add(req_by_store_code);
				chkFields.add(code);
				chkFields.add(description);
				
				if(!surgery_type.equals(""))
					chkFields.add(surgery_type);
				
				if(isincludetargetstore.equals("true"))
					chkFields.add(req_on_store_code);
				
				
				
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
				
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></b></font></th>
				<%if(surg_nature_link_to_OT_yn.equals("Y")){ %>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eSS.SurgeryName.label" bundle="${ss_labels}"/></b></font></th>
				<%} %>
							
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></b></font></th>
				<!-- <th width='15%'><fmt:message key="eSS.AvailableSterilized.label" bundle="${ss_labels}"/><br><fmt:message key="eSS.Quantity.label" bundle="${ss_labels}"/></th> -->
				<th  class='CAGROUP_HEADING' ><font size=1><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font><input type="checkbox" value="Y" name="selectAll" id="selectAll"   onClick="return toggleCheck(this);" ></th>

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
	//Added for checking the records which are already selected or added in detail part
	if (bean.isAlreadySelected((String)records.get(0)) ) {
		checked = "checked";
			
		}//Added ends
			//Added for disabling check box in modify mode which are already available in table
			if(bean.isModifyRecord((String)records.get(0))){
				disabled= "disabled";
			}//Added ends
			
			//Added to avoid script error if description having special character
			short_desc					=			CommonBean.checkForNull((String)records.get(1));
			if(!short_desc.equals("")){
				short_desc = java.net.URLEncoder.encode(short_desc,"UTF-8");
			}//Added ends

						
			
%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onClick="details('<%=records.get(0)%>','<%=short_desc%>')"><font size=1 class='HYPERLINK'><%=CommonBean.checkForNull((String)records.get(0),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=java.net.URLDecoder.decode(short_desc,"UTF-8")%></font></td>
				
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)records.get(4),"&nbsp;")%></font></td>
				<%if(surg_nature_link_to_OT_yn.equals("Y")){ %>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)records.get(6),"&nbsp;")%></font></td>
				<%} %>
				
				<td class="<%=classvalue%>" ><font size=1><%=records.get(2)%></font></td>
				<!-- <td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=records.get(3)%></font></td> -->
				
				<td class="<%=classvalue%>" ><input type="checkbox" <%=disabled %> name="group_code<%=index%>" <%=checked%> value="<%=records.get(0)%>" onclick="updateSelectionGroupSearch();"</td>
				
			</tr>
			<input type=hidden name="group<%=index%>" id="group<%=index%>"				value="<%=records.get(0)%>">
			<input type=hidden name="desc<%=index%>" id="desc<%=index%>"				value="<%=java.net.URLDecoder.decode(short_desc,"UTF-8")%>">
			<input type=hidden name="group_type<%=index%>" id="group_type<%=index%>"				value="<%=records.get(2)%>">
			<input type=hidden name="auth_group<%=index%>" id="auth_group<%=index%>"				value="">
			<input type=hidden name="surgery_type<%=index%>" id="surgery_type<%=index%>"				value="<%=CommonBean.checkForNull((String)records.get(4),"")%>">
			<input type=hidden name="surgery_name<%=index%>" id="surgery_name<%=index%>"				value="<%=CommonBean.checkForNull((String)records.get(6),"")%>">
			<input type=hidden name="qty<%=index%>" id="qty<%=index%>"				value="">
			<input type=hidden name="avlbl_ster_qty<%=index%>" id="avlbl_ster_qty<%=index%>"				value="<%=CommonBean.checkForNull((String)records.get(3),"0")%>">
			
			
		<%}%>
			</table>
			</br>
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>"/>
			<input type="hidden" name="totalRecords" id="totalRecords"			value='<%=index%>'/>
			<input type="hidden" name="count" id="count"					value="1"/>
			<input type="hidden" name="store_code" id="store_code"				value="<%=req_by_store_code%>"/>
			<input type="hidden" name="loc_batch_string" id="loc_batch_string"		value="">
			<input type="hidden" name="chkdIndices" id="chkdIndices"				value="" >
			<input type="hidden" name="total_trays" id="total_trays"				value="<%=index%>">
			 <input type=hidden name=bean_id					value="<%=bean_id%>"/>
			<input type=hidden name=bean_name					value="<%=bean_name%>"/>
			<input type="hidden" name="loc_batch_string" id="loc_batch_string" 		value="">
			<input type="hidden" name="index" id="index" 					value="">
			<input type="hidden" name="mode" id="mode" 					value="<%=mode%>"/>
			<input type="hidden" name="unchecked_index" id="unchecked_index" 		value=""/>
			<input type="hidden" name="search_type" id="search_type" 			value=""/>
			<input type="hidden" name="isincludetargetstore" id="isincludetargetstore"	value="<%=isincludetargetstore%>"/>
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/LoanRequestGroupSearchResult.jsp", searched) );
		} catch(Exception e) {
		  // out.print("Exception @ Result JSP :"+e.toString());
		  e.printStackTrace(); // COMMON-ICN-0185
		}
%>

<%
putObjectInBean(bean_id,bean,request); 
%>
<script>
updateSelectionGroupSearch();
</script>
</body>
</html>
 

