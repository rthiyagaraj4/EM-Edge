<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*,eSS.Common.*,java.util.*" %>  
<jsp:useBean id="alGroupList" scope="session" class="java.util.ArrayList" />
<jsp:useBean id="alCheckList" scope="session" class="java.util.ArrayList" />
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		 <%
			request.setCharacterEncoding("UTF-8");

			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 %>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>		
		<script language="javascript" src="../../eSS/js/Group.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	GroupItemBean bean = (GroupItemBean)getBeanObject( "groupItemBean", "eSS.GroupItemBean",request) ;  
	HashMap hmRecord			=	new HashMap();
	String className			=	"";
	String group_code			=	request.getParameter("group_code");
	String checklist			=	bean.checkForNull(request.getParameter("checklist"),"");
	String checklist_desc			=	bean.checkForNull(request.getParameter("checklist_desc"));
	int	i						=	0;
	boolean disabledWhenTrayExists	=	false;
  
	String disabled			=	"";
	String code_disabled	=	"";
	if(group_code!=null){
		group_code=group_code.trim();
		if( bean.isDisabledGroupCode(group_code) )
			disabled="disabled";
		//disabledWhenTrayExists=bean.trayExists(group_code); //Commented by Sakti against ML-BRU-SCF-0775.1[INC#44128]

	}
	putObjectInBean( "groupItemBean", bean,request);
%>
	<body  onMouseDown="CodeArrest();" >
	<form name="formGroupList" id="formGroupList">
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
	<tr>
			<th width='3%'><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
			<th width='44%' ><fmt:message key="eSS.Item.label" bundle="${ss_labels}"/></th>
			<th width='15%' ><fmt:message key="eSS.Consumable.label" bundle="${ss_labels}"/></th>
			<th width='15%' ><fmt:message key="eSS.Chargeable.label" bundle="${ss_labels}"/></th>
			<%
		 if(checklist.equals("Y"))
		 {%>
		   <th width='15%' >Mandatory Item</th>
		   <th width='15%' >Quantity As per CheckList</th>
		<%}%>
			<th width='28%' ><fmt:message key="eSS.Quantity.label" bundle="${ss_labels}"/></th>
		
		</tr>
<%

if((checklist.equals("Y")) && (!(checklist_desc.equals(""))))
{
alGroupList.clear();
for	(i	=0;	i<alCheckList.size();i++){
hmRecord	=(HashMap)	alCheckList.get(i);
alGroupList.add(hmRecord);
	//			session.setAttribute("alGroupList",alCheckList);
}

}
if((checklist.equals("N") || checklist.equals("Y")) && (checklist_desc.equals("")))
{
alGroupList.clear();
}
for	(i	=0;	i<alGroupList.size();i++){
	hmRecord	=(HashMap)	alGroupList.get(i);
	bean.initialize(hmRecord);
	className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
if((bean.checkForNull(bean.getMadatory_Item_Yn(),"").equals("Y")) && (checklist.equals("Y")))
	{
	code_disabled = "disabled";
	}else 
	code_disabled = "";
// removed this condition "<%=(disabledWhenTrayExists && bean.getMode().equals(bean.getCommonRepositoryValue("MODE_MODIFY")))?"disabled":"" " from below line against ML-BRU-SCF-0775.1[INC#44128] by Sakti
%>
	<tr>
		<td class="<%=className%>" align='center' width='3%'><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%> <%=code_disabled%> ></td>
		<% //if(disabled.equals("disabled")||(disabledWhenTrayExists&&bean.getMode().equals(bean.getCommonRepositoryValue("MODE_MODIFY")))){ //Commented by Sakti against ML-BRU-SCF-0775.1[INC#44128]
		if(disabled.equals("disabled")) {%>
		<td class="<%=className%>"  width='40%'><%=bean.getDescription()%></td>
		<%}else{%>
		<%if(checklist.equals("Y"))
		 {%>
		<td class="<%=className%>" width='40%' ><%=bean.getDescription()%></td>
		<%} else {%>
		<td class="<%=className%>" width='40%' ><a href="javascript:listModify('<%=i%>');" ><%=bean.getDescription()%></a></td>
		<%}}%>
		<td class="<%=className%>" align='center' width='15%' ><%=bean.getImage(bean.getConsumable_yn())%></td>
		<td class="<%=className%>" align='center' width='15%' ><%=bean.getImage(bean.getChargeable_yn())%></td>
		<%if(checklist.equals("Y"))
		 {%>
		 <td class="<%=className%>" align='center' width='15%' ><%=bean.getImage(bean.getMadatory_Item_Yn())%></td>
         <td class="<%=className%>" align='right' width='26%' ><%=bean.getMode().equals(bean.getCommonRepositoryValue("MODE_MODIFY"))? bean.getItem_qty1():bean.getItem_qty()%></td>
		<td  class='fields' width='28%'>&nbsp;&nbsp;<input type=text name="item_qty_<%=i%>" id="item_qty_<%=i%>" size=8 maxlength=7 class="NUMBER" onKeyPress="return isValidNumber(this,event,12,3);"value="<%=bean.getItem_qty()%>"></td>
		<%}%>
		<%if(checklist.equals("N") || checklist.equals(""))
	{ %>
		<td class="<%=className%>" align='center' width='15%' ><%=bean.getItem_qty()%></td>
	<%}%>
	</tr>
<%
}
%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
	<input type="hidden" name="checklist" id="checklist" value="<%=checklist%>">
	</form>
</body>
</html>



