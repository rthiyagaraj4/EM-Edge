<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,java.util.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%-- Mandatory declarations end --%>

<%!int row_count=0;%>
<html>
<head>
<%
	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/AssignPrivilegeGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>

</head>
<%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	int row_disp=12;
	int start = 0 ;
	int end = 0 ;
	int pageCnt = 0;

    String bean_id = "Or_Assignprevilege_Group" ;
	String bean_name = "eOR.AssignPrevilegeGroup";
	String checked = "";
	String mode = "1";
	String from = request.getParameter("from")==null?"0": request.getParameter("from");
	String to = request.getParameter("to")==null?"12": request.getParameter("to");
	String user = request.getParameter("user")==null?"": request.getParameter("user");
	String groupBy = request.getParameter("groupBy")==null?"": request.getParameter("groupBy");
	String dispMode = request.getParameter("dispMode")==null?"": request.getParameter("dispMode");
	String clearUser = request.getParameter("clearUser")==null?"": request.getParameter("clearUser");

	start = Integer.parseInt(from);
	end = Integer.parseInt(to);
	AssignPrevilegeGroup bean = (AssignPrevilegeGroup)getBeanObject(bean_id, bean_name, request ) ; /* Initialize Function specific 
	end */
	List<String> privilegeGrp = bean.getPrevilegeGroups();
	int row_count = 0;
	if(privilegeGrp != null)
	{
		row_count = privilegeGrp.size();
	}	
	if(clearUser.equals("Y"))
	{
		if(bean.getPrivilegeList() != null)
		{
			bean.getPrivilegeList().clear();
		}
	}
	List<String> privGRP =  bean.getPrivilegeList();
%>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'>
	<form name="AssignPrivilegeToPracResultFrm" id="AssignPrivilegeToPracResultFrm">
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr width='10%'>
		<td class='WHITE' align="right">
		<%
		if((!(start <= 1)) && (start < row_count))
		{
		%>
			<A class='gridlink' HREF='javascript:onClick=navigate("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		<%	
		}
		 if(!( (start+row_disp) >= row_count ))
		 {
		%>
			<A class='gridlink' HREF='javascript:onClick=navigate("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		<%
			
		 }
		%>
		</td>
	</tr>
	</table>  
	<table class='grid' width='100%'>
	<tr>
		<th class='columnheader' width='75%' style="text-align:left;"><fmt:message key="eOR.PrivilegeGroup.label" bundle="${or_labels}"/></th>	
	    <th class='columnheader' width='25%' style="text-align:left;"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>	
	<%	 
	
	try{

		if(privilegeGrp != null )
		{
			for(int i = start; i< end; i++)
			{
					if(i < privilegeGrp.size())
					{
						String preGrp = privilegeGrp.get(i);
						String []str = preGrp.split("`~");
						if(bean.isPrevilegeGRPExists(str[0], user, "P") || (privGRP != null && privGRP.contains(str[0])))
						{
							checked = "checked";
						}
						else
						{
							checked = "";
						}
						mode = checked==""?"1":"2";
						%>		
						<tr>
						<td class='gridData' ><%=str[1]%></td>
						<td class='gridData'><input type='checkbox' name='chk_previlege_<%=i%>' id='chk_previlege_<%=i%>' value='<%=str[0]%>' <%=checked%> onclick='addPrevilege(this)'></td> 
						</tr>
						<%
						pageCnt++;

				}
			
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("AssignPrivilegeGroupToPractResult.jsp Exception@1: "+e);
	}
	
	if(dispMode.equals("") && row_count > row_disp)
	{
		dispMode	="Next";		
	}
	if(dispMode.equals("Next"))
	{
		dispMode	="Next";		
	}else if(dispMode.equals("Previous"))
	{
	    dispMode	="Previous";		
	}
	%>
	</table>

	<input type="hidden" name="from" id="from" value="<%=start%>">
	<input type="hidden" name="to" id="to" value=<%=end%>>
	<input type='hidden' name='user' id='user' value="<%=user%>">
	<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="row_count" id="row_count" value=<%=row_count%> > 
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value=<%=to%>>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="groupBy" id="groupBy" value="<%= groupBy %>">
	<input type="hidden" name="dispMode" id="dispMode" value="<%= dispMode %>">
	<input type="hidden" name="pageCnt" id="pageCnt" value="<%= pageCnt %>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</form>
</body>
</html>
<SCRIPT LANGUAGE="JavaScript">
		<!--
			//dispLink("A");
			if(parent.AssignPrivilegeGroupDtl)
			{
				var formObjAddMod=	parent.AssignPrivilegeGroupDtl;
				if(formObjAddMod.grp_by_desc)
				{
					formObjAddMod.grp_by_desc.disabled=true;
				}
				if(formObjAddMod.grp_by_desc_search)
				{
					formObjAddMod.grp_by_desc_search.disabled=true;
				}
				
			}
			
		//-->
		</SCRIPT>
<%

putObjectInBean(bean_id,bean,request);

%>

