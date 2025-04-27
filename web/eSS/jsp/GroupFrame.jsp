<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eSS.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alGroupList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="alCheckList" scope="session" class="java.util.ArrayList"/>
<%
		request.setCharacterEncoding("UTF-8");
		String bean_id = "groupItemBean" ;
		String bean_name = "eSS.GroupItemBean";
		String checklist_code = "";
		alGroupList.clear();

	GroupItemBean bean = (GroupItemBean)getBeanObject( bean_id,  bean_name,request );

	String group_code				=	request.getParameter("group_code");
	ArrayList alItemForGroupRecords	=	null;
	
	if( group_code!=null )
	{
		try{
			
			 HashMap h1 = bean.fetchRecord("select nvl(CHECKLIST_CODE,'') CHECKLIST_CODE from ss_group where group_code = ?",group_code);
			checklist_code = bean.checkForNull((String)h1.get("CHECKLIST_CODE"),"");
	
			if(!(checklist_code.equals("")))
			{
			alItemForGroupRecords=bean.fetchRecords("SELECT s.item_code, s.item_qty, si.consumable_yn, si.chargeable_yn, m.short_desc, chd.madatory_item_yn madatory_item_yn,chd.quantity item_qty1 FROM mm_item m, ss_item si,       ss_item_for_group s, ss_checklist ch, ss_checklist_dtl chd,    ss_group sg WHERE sg.group_code = ?   AND s.group_code = sg.group_code AND ch.checklist_code = sg.checklist_code   AND ch.checklist_code = chd.checklist_code  AND chd.item_code = s.item_code  AND s.item_code = m.item_code  AND s.item_code = si.item_code order by chd.SEQ_NO",group_code);
			}
			if(checklist_code.equals(""))
			{
			alItemForGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_DETAIL"),group_code);
			}

	
	         alGroupList.clear();
	         alCheckList.clear();
			for (int i=0;i<alItemForGroupRecords.size();i++){
				HashMap hmItemForGroupRecord=(HashMap)alItemForGroupRecords.get(i);
				hmItemForGroupRecord.put("ITEM_CODE",	(String)hmItemForGroupRecord.get("ITEM_CODE") );
				hmItemForGroupRecord.put("ITEM_QTY",	(String)hmItemForGroupRecord.get("ITEM_QTY")  );
				hmItemForGroupRecord.put("CONSUMABLE_YN",	(String)hmItemForGroupRecord.get("CONSUMABLE_YN")  );
				hmItemForGroupRecord.put("CHARGEABLE_YN",	(String)hmItemForGroupRecord.get("CHARGEABLE_YN")  );
				if(hmItemForGroupRecord.containsKey("MADATORY_ITEM_YN"))
				hmItemForGroupRecord.put("MADATORY_ITEM_YN",	bean.checkForNull((String)hmItemForGroupRecord.get("MADATORY_ITEM_YN") ,""));
				hmItemForGroupRecord.put("DESCRIPTION",	(String)hmItemForGroupRecord.get("SHORT_DESC"));
                 if(hmItemForGroupRecord.containsKey("ITEM_QTY1"))
				hmItemForGroupRecord.put("ITEM_QTY1",	bean.checkForNull((String)hmItemForGroupRecord.get("ITEM_QTY1") ,""));
				/*hmItemForGroupRecord.remove("ITEM_CODE") ;
				hmItemForGroupRecord.remove("ITEM_QTY")  ;
				hmItemForGroupRecord.remove("SHORT_DESC");
				hmItemForGroupRecord.remove("CONSUMABLE_YN");*/
				hmItemForGroupRecord.put("MODE",		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				alGroupList.add(hmItemForGroupRecord);
			    alCheckList.add(hmItemForGroupRecord);
			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}
   
   putObjectInBean( bean_id,  bean ,request);

%>
<html>
<head>
 <%
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eSS/js/GroupMaster.js'></script>

</head>
<% 
	if(!(checklist_code.equals("")))
	{
	%>
	<iframe name='frameGroup' src='../../eSS/jsp/GroupAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style="height:50vh;width:100vw"></iframe>
<!--  <frameset rows='*,55%,0%' id='check'>-->
	<%} else {%>
<!--  <frameset rows='*,40%,15%' id='check'>-->
	<iframe name='frameGroup' src='../../eSS/jsp/GroupAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style="height:47vh;width:100vw"></iframe>
	<%}%>
	
	
	<!--<frameset rows="15,*" >
		<frame name='frameGroupListHeader' frameborder="0" scrolling="no" noresize src="../../eSS/html/GroupListHeader.html"> -->
	<% if(!(checklist_code.equals("")))
	{
	%>
	<iframe name='frameGroupList' frameborder="0" scrolling="auto" noresize style="height:35vh;width:100vw" src="../../eSS/jsp/GroupList.jsp?<%=request.getQueryString()%>&checklist=Y&checklist_desc=<%=checklist_code%>"></iframe>
		
	<%} else {	%>
			<iframe name='frameGroupList' frameborder="0" scrolling="auto" noresize style="height:43vh;width:100vw" src="../../eSS/jsp/GroupList.jsp?<%=request.getQueryString()%>">	</iframe>
	<%}%>
	<!--</frameset>	 -->
	<% if(checklist_code.equals(""))
	{
	%>
	<iframe name='frameGroupDetail' frameborder="0" scrolling="auto" noresize src="../../eSS/jsp/GroupDetail.jsp?<%=request.getQueryString()%>" style="height:12vh;width:100vw"> </iframe>
	<%}%>
</frameset>
</html>

