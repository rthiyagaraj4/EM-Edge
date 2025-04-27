<!DOCTYPE html>
 <%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
28/2/2022		TFS-26601			Shazana										ML-MMOH-SCF-1948
---------------------------------------------------------------------------------------------------------
*/
%>
 
<%-- JSP Page specific attributes start --%>
<%@	page import="eSS.PrepareGroupBean, eCommon.Common.*,eSS.Common.*, eSS.*,java.util.*,java.sql.* ,java.lang.*,webbeans.eCommon.*,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@	include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
	<head>
		<title><fmt:message key="eSS.GroupItemDetails.label" bundle="${ss_labels}"/></title>
		
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				 =		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/RequestStatus.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body onload="window.scrollTo(0,0)">
<%

	String group_code			=		request.getParameter( "group_code" ) ;
	String group_desc			=		request.getParameter( "group_desc" ) ;
	
	String checklist_code 		= 		"";
	String bean_id 				= "groupItemBean" ;
	String bean_name 			= "eSS.GroupItemBean";

		GroupItemBean bean = (GroupItemBean)getBeanObject( bean_id,  bean_name,request );
		
try{
	String classvalue				=		"";
	ArrayList alRecords	= new ArrayList();
	HashMap	  hmResult =  new HashMap();
	ArrayList alParameters = new ArrayList();

	
	group_code					=		CommonBean.checkForNull( group_code );
	group_desc					=		CommonBean.checkForNull( group_desc );
	//doc_no						=		CommonBean.checkForNull( doc_no );



	//HashMap h1 = bean.fetchRecord("select nvl(CHECKLIST_CODE,'') CHECKLIST_CODE from ss_group where group_code = ?",group_code);
	HashMap h1 = bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_GROUP_CHECK_LIST_SELECT"),group_code);
	
	checklist_code = bean.checkForNull((String)h1.get("CHECKLIST_CODE"),"");
	
	//Comented By Sakti due to problem with next_previous
	
	/*if(!checklist_code.equals(""))
	{
	sqlMap.put( "sqlData", "SELECT m.short_desc  item_desc, s.item_qty, si.consumable_yn,       chd.madatory_item_yn madatory_item_yn FROM mm_item m, ss_item si,ss_item_for_group s, ss_checklist ch, ss_checklist_dtl chd, ss_group sg WHERE sg.group_code = ?   AND s.group_code = sg.group_code AND ch.checklist_code = sg.checklist_code   AND ch.checklist_code = chd.checklist_code AND chd.item_code = s.item_code  AND s.item_code = m.item_code   AND s.item_code = si.item_code order by chd.SEQ_NO");
	} else 
	{
	
	sqlMap.put("sqlData","SELECT m.short_desc item_desc, s.item_qty, si.consumable_yn, 'NA' madatory_item_yn    FROM mm_item m, ss_item si, ss_item_for_group s WHERE s.item_code = m.item_code   AND s.item_code = si.item_code   AND group_code =?");
	}

	//Function Parameters

	HashMap funcMap					=		new HashMap();

	//The fields are going to be display

	ArrayList displayFields			=		new ArrayList();

	displayFields.add( "item_desc"	);
	displayFields.add( "consumable_yn" );
	displayFields.add( "madatory_item_yn" );
	displayFields.add( "item_qty"	);
	
	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields				=		new ArrayList();
	
	chkFields.add(group_code );
	
	
	// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result				=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,15);*/

//Added by Sakti Sankar 
	alParameters.add(group_code);
	
	if(!checklist_code.equals(""))
	{
	
	alRecords = (ArrayList)bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_GROUP_ITEM_SELECT_BASED_ON_CHECK_LIST"),alParameters);
	} else 
	{
	alRecords = (ArrayList)bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_GROUP_ITEM_SELECT"),alParameters);
	
	}
		
	if( alRecords.size()>0) {
	%>
	<form name="GroupItemDetailForm" id="GroupItemDetailForm">
	<div>
		<table cellpadding=0 cellspacing=0 width="100%" align="center" >
		<tr>
          <td align="right" class="label" ><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/> :<%=group_code%></td>
           <td align="right" class="label" ><fmt:message key="Common.Group.label" bundle="${common_labels}"/>:<%=group_desc%></td>
		 </tr>
		 </table>
		<br>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr>
			<th ><fmt:message key="eSS.Item.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.Consumable.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.MandatoryItem.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.Quantity.label" bundle="${ss_labels}"/></th>
		</tr>

	<%
		for( int i=0; i<alRecords.size();i++) {

			hmResult = (HashMap) alRecords.get(i);
					
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
			<tr>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)hmResult.get("ITEM_DESC")%></td>
				<td class="<%=classvalue%>" align='center' width='15%' ><%=bean.getImage((String)hmResult.get("CONSUMABLE_YN"))%></td>
				<% if(((String)hmResult.get("MENDATORY_ITEM_YN") ).equals("NA") )   {%>
                 <td class="<%=classvalue%>" align='center' width='15%' >&nbsp;</td>
				 <%}else {%>
				<td class="<%=classvalue%>" align='center' width='15%' ><%=bean.getImage((String)hmResult.get("MENDATORY_ITEM_YN"))%></td>
				<%}%>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)hmResult.get("ITEM_QTY"),"&nbsp;")%></td>
			</tr> 
	<%
		}
	%>
	
		</table>
		</div>
	</form>	
		
	<%
		out.flush();
	} else{
	%>
		 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				//document.location.href="../../eCommon/jsp/error.jsp";
				//window.close(); //Added by Sakti against inc#45643 point # 1
				const dialogTag = parent.document.getElementById("dialog_tag");    
				dialogTag.close();   

	
		</script>
	<%
	}
	
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>
		<table align = right cellpadding=10 cellspacing=0  width="100%" align="center">
			<tr>		
				<td valign=bottom align = right>
					<input type="button" align = right value="Close" name="close" id="close" class="BUTTON" onClick='parent.document.getElementById("dialog_tag").close(); '>
				</td>
			</tr>
		</table>
		
<%
putObjectInBean(bean_id,bean,request); 
%>
</body>
</html>
   

