<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@	page import="java.util.ArrayList,java.util.HashMap,ePO.UserAccessForDOBean" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@	include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id								 =		"";
		String bean_name							 =		"";
		bean_id										 =		"userAccessForDOBean" ;
		bean_name									 =		"ePO.UserAccessForDOBean";
		UserAccessForDOBean bean					 =		(UserAccessForDOBean)getBeanObject( bean_id, bean_name, request );
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
		<script language="javascript" src="../../ePO/js/UserAccessForDO.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<form name="QueryResult" id="QueryResult" onMouseDown="CodeArrest()">
<%
	String user_id				= request.getParameter("user_id");
	String appl_user_name		= request.getParameter("appl_user_name");
	
	String interface_to_external_po_yn			 =		"";
	String dflt_search_item		=	null;
	int colcountTemp = 0;
	int colcountTemp1 = 0;
	//interface_to_external_po_yn=bean.getInterface_to_external_po_yn((String)session.getAttribute("ACC_ENTITY_ID"));
    
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
			
	try{
			user_id        	= CommonBean.checkForNull(user_id        )+"%";
			appl_user_name 	= CommonBean.checkForNull(appl_user_name )+"%";
				
			sqlMap.put("sqlData", "SELECT DISTINCT APU.APPL_USER_ID USER_ID, APU.APPL_USER_NAME APPL_USER_NAME, UA.DO_ALLOWED_YN, UA.DO_APPROVE_ALLOWED_YN, UA.DO_CANCEL_ALLOWED_YN,UA.DO_DELETE_ALLOWED_YN ,UA.QUOT_ALLOWED_YN, UA.QUOT_APPROVE_ALLOWED_YN, UA.QUOT_CANCEL_ALLOWED_YN,UA.QUOT_DELETE_ALLOWED_YN FROM PO_USER_FOR_DELVORD UA,  SM_APPL_USER_LANG_VW APU  WHERE UA.USER_ID = APU.APPL_USER_ID   AND APU.EFF_STATUS = 'E'  AND UPPER (APU.APPL_USER_ID) LIKE UPPER (?)   AND UPPER (APU.APPL_USER_NAME) LIKE UPPER (?) AND APU.LANGUAGE_ID = ? ");
			

		  //The fields are going to be display
			displayFields.add("user_id");
			displayFields.add("appl_user_name");
			displayFields.add("DO_ALLOWED_YN");
			displayFields.add("DO_APPROVE_ALLOWED_YN");
            displayFields.add("DO_CANCEL_ALLOWED_YN");
			displayFields.add("DO_DELETE_ALLOWED_YN");
			displayFields.add("QUOT_ALLOWED_YN");
			displayFields.add("QUOT_APPROVE_ALLOWED_YN");
            displayFields.add("QUOT_CANCEL_ALLOWED_YN");
			displayFields.add("QUOT_DELETE_ALLOWED_YN");

			System.out.println("displayFields"+displayFields);
			System.out.println("sqlMap"+sqlMap);

			//displayFields.add("view_cost_yn");

		//	The fields are going to be in where condition * should match with the query


			chkFields.add(user_id);
			chkFields.add(appl_user_name);
			chkFields.add(locale); 

			
			

			System.out.println("chkFields"+chkFields);

			/* Commented on 12/10/2004 */
	

			// Adding function related array list into the HashMap

			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
		
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,	9);

			System.out.println("result"+result);

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0  align="center">
			<tr>
				<td width="80%" class="white" nowrap>&nbsp;</td>
				<td width="20%" class="white" nowrap>&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0"  align="center" width='80%'>
                <th><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="ePO.DeliveryOrderCreate.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.DeliveryOrderFinalize.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.DeliveryOrderCancel.label" bundle="${po_labels}"/></th> 			
				<th><fmt:message key="ePO.DeliveryOrderDelete.label" bundle="${po_labels}"/></th> 			
				<th><fmt:message key="ePO.QuotationCreate.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.QuotationFinalize.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.QuotationCancel.label" bundle="${po_labels}"/></th> 			
				<th><fmt:message key="ePO.QuotationDelete.label" bundle="${po_labels}"/></th> 			
				<%
				String previous				=		"";
				String user_id_value		=		"";
			

			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue			=		"QRYEVEN" ;
				else
					classvalue			=		"QRYODD" ;

					String link_columns	=		"2";
					records				=		(ArrayList)result.get( recCount );
					user_id_value		=		(String)records.get( 1 );
			
				if(! (user_id_value.equals(previous)) ) {

				%>
				
				<tr  onClick="Modify(this);">
				<%
				}
				else {
				%>
				<tr  onClick="Modify(this);">				
		<%
				}
				if(interface_to_external_po_yn.equals("Y")){
					colcountTemp = 49;
					colcountTemp1 = 48;

				}
				else{
					colcountTemp = 46;
					colcountTemp1 = 45;
				}
				System.out.println("records.size() = "+records);
				for(int colCount=0; colCount<records.size(); colCount++){
					if((colCount < 1) || (colCount>colcountTemp1)) {
						out.println("<td class='NODISPLAY'>"+(String)records.get( colCount )+"</td>");
						continue;
					}
					
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
					System.out.println("link_columns.indexOf(String.valueOf(colCount+1)) = "+link_columns.indexOf(String.valueOf(colCount+1)));
				%>             
						<td class="<%=classvalue%>" nowrap  onmouseover="changeCursor(this);">  <font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
		<%
					}
				else{
		%>
						<td class="<%=classvalue%>" nowrap onclick="disableClick(event);"
						<% 
							if(colCount >= 1 && colCount<colcountTemp) {
								out.println(" align=\'center\' >");
								if( ((String)records.get( colCount )).equals("Y") && ((String)records.get( colCount  )).equals("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							
										
							}
							else {
								out.println(">"+(String)records.get( colCount ));
								
								
							}
						
						%>
						
						
					
							</td>
						
							
		<%
						}
					}
		%>
			</tr>
		<%			previous		=		user_id_value;

			}
		%>
		</table>
		</form>
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
		
		out.println(CommonBean.setForm ( request ,"../../ePO/jsp/UserAccessForDOQueryResult.jsp", searched) );
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

