<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@	page import="java.util.ArrayList,java.util.HashMap,ePO.UserPurchaseUnitAccessForTransactionsBean" contentType="text/html;charset=UTF-8"%>
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
		bean_id										 =		"userPurchaseUnitAccessForTransactionsBean" ;
		bean_name									 =		"ePO.UserPurchaseUnitAccessForTransactionsBean";
		UserPurchaseUnitAccessForTransactionsBean bean					 =		(UserPurchaseUnitAccessForTransactionsBean)getBeanObject( bean_id, bean_name, request );
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
		<script language="javascript" src="../../ePO/js/UserPurchaseUnitAccessForTransactions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<form name="QueryResult" id="QueryResult" onMouseDown="CodeArrest()">
<%
	String user_id				= request.getParameter("user_id");
	String appl_user_name		= request.getParameter("appl_user_name");
	String po_unit_code			= request.getParameter("pur_unit_code");
	String po_unit_desc			= request.getParameter("short_desc");
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
			po_unit_code     	= CommonBean.checkForNull(po_unit_code     )+"%";
			po_unit_desc     	= CommonBean.checkForNull(po_unit_desc     )+"%";
 										   
		    //Commented by Rabbani on 28/06/12
			//sqlMap.put("sqlData", "SELECT DISTINCT APU.APPL_USER_ID USER_ID, APU.APPL_USER_NAME APPL_USER_NAME,   STPO.PUR_UNIT_CODE PUR_UNIT_CODE, STPO.SHORT_DESC SHORT_DESC, UA.USER_STORE_ACCESS_YN , UA.DFLT_STORE_CODE DFLT_STORE_CODE, UA.REQ_ALLOWED_YN,UA.REQ_APPROVE_ALLOWED_YN, UA.REQ_CANCEL_ALLOWED_YN, UA.PO_ALLOWED_YN, UA.PO_APPROVE_ALLOWED_YN, UA.PO_AMEND_ALLOWED_YN, UA.PO_CANCEL_ALLOWED_YN FROM PO_USER_FOR_PUNIT UA,  PO_PURCHASE_UNIT STPO,  SM_APPL_USER_LANG_VW APU  WHERE STPO.EFF_STATUS = 'E'    AND UA.PUR_UNIT_CODE = STPO.PUR_UNIT_CODE   AND UA.USER_ID = APU.APPL_USER_ID   AND APU.EFF_STATUS = 'E'  AND UPPER (APU.APPL_USER_ID) LIKE UPPER (?)   AND UPPER (APU.APPL_USER_NAME) LIKE UPPER (?)   AND UPPER (STPO.PUR_UNIT_CODE) LIKE UPPER (?) AND UPPER (STPO.SHORT_DESC) LIKE UPPER (?) ");
			
			//Added by Rabbani on 28/06/12
	        sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_PUR_UNIT_ACCESS_QUERY_RESULT"));

		  //The fields are going to be display
			displayFields.add("user_id");
			displayFields.add("appl_user_name");
			displayFields.add("PUR_UNIT_CODE");
			displayFields.add("SHORT_DESC");
			//displayFields.add("USER_STORE_ACCESS_YN");
			//displayFields.add("DFLT_STORE_CODE");
			
			displayFields.add("REQ_ALLOWED_YN");
			displayFields.add("REQ_APPROVE_ALLOWED_YN");
            displayFields.add("REQ_CANCEL_ALLOWED_YN");
            displayFields.add("PO_ALLOWED_YN");
			displayFields.add("PO_APPROVE_ALLOWED_YN");
            displayFields.add("PO_AMEND_ALLOWED_YN");
			displayFields.add("PO_CANCEL_ALLOWED_YN");
			//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
			displayFields.add("TNDR_ALLOWED_YN"); 
			displayFields.add("TNDR_APPROVE_ALLOWED_YN");
			displayFields.add("TNDR_CANCEL_ALLOWED_YN");
			

			//System.out.println("displayFields"+displayFields);
			//System.out.println("sqlMap"+sqlMap);

			//displayFields.add("view_cost_yn");

		//	The fields are going to be in where condition * should match with the query


			chkFields.add(user_id);
			chkFields.add(appl_user_name);
			chkFields.add(po_unit_code);
			chkFields.add(po_unit_desc);
			chkFields.add(locale); //28/06/12

			
			

			System.out.println("chkFields"+chkFields);

			/* Commented on 12/10/2004 */

			//chkFields.add(session.getAttribute("facility_id"));
		

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
			<table border="1" cellpadding="0" cellspacing="0"  align="center">
                
				<th><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PurchaseRequestCreate.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PurchaseRequestFinalize.label" bundle="${po_labels}"/></th>
   				<th><fmt:message key="ePO.PurchaseRequestCancel.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PurchaseOrderCreate.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PurchaseOrderFinalize.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PurchaseOrderAmend.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PurchaseOrderCancel.label" bundle="${po_labels}"/></th> 	
                <!--Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013 -->
                <th><fmt:message key="ePO.TenderCreate.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.TenderFinalize.label" bundle="${po_labels}"/></th>
   				<th><fmt:message key="ePO.TenderCancel.label" bundle="${po_labels}"/></th>					
				<%
				String previous				=		"";
				String user_id_value		=		"";
			

			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue			=		"QRYEVEN" ;
				else
					classvalue			=		"QRYODD" ;

					String link_columns	=		"4";
					records				=		(ArrayList)result.get( recCount );
					user_id_value		=		(String)records.get( 1 );
			
				if(! (user_id_value.equals(previous)) ) {

				%>
				<tr>
				<td class = "ITEMSELECT" colspan=46><fmt:message key="Common.user.label" bundle="${common_labels}"/>:<b><%=(String)records.get( 1 )%></b> </td>
				</tr>
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
				for(int colCount=0; colCount<records.size(); colCount++){
					if((colCount < 3) || (colCount>colcountTemp1)) {
						out.println("<td class='NODISPLAY'>"+(String)records.get( colCount )+"</td>");
						continue;
					}
					
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
				%>             
						<td class="<%=classvalue%>" nowrap  onmouseover="changeCursor(this);">  <font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
		<%
					}
				else{
		%>
						<td class="<%=classvalue%>" nowrap onclick="disableClick(event);"
						<% 
							if(colCount >= 4 && colCount<colcountTemp) {
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
		
		out.println(CommonBean.setForm ( request ,"../../ePO/jsp/UserPurchaseUnitAccessForTransactionsQueryResult.jsp", searched) );
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

