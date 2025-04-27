<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>

<html>
	<title><fmt:message key="eOA.InvitationStatus.label" bundle="${oa_labels}"/></title>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eOA/js/WaitListInvitation.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
request.setCharacterEncoding("UTF-8");
	Connection con =null;
	Statement st = null;
	ResultSet rsSet=null;
	PreparedStatement pstmt=null;
	String facilityId=(String) session.getValue("facility_id");
	String locale=(String)session.getAttribute("LOCALE");
	String mon	=   request.getParameter("mon")== null?"":request.getParameter("mon");
	String yr	=	request.getParameter("yr")== null?"":request.getParameter("yr");
	String dt	=	request.getParameter("dt")== null?"":request.getParameter("dt");
	String prd = request.getParameter("prd")==null?"":request.getParameter("prd");
	String date_val=dt+"/"+mon+"/"+yr;
	if(date_val ==null) date_val="";
	String  open="";
	String selected="";
	String invited="";
	java.util.ArrayList arrlst=new java.util.ArrayList();
	
	String date_val_display=DateUtils.convertDate(date_val,"DMY","en",locale);
	try{
			con = ConnectionManager.getConnection(request);
	 st = con.createStatement();
			String sqlmain="";
			
		
			//sqlmain="select  'I' WAIT_STATUS,count(*) count from pr_wait_list where facility_id = '"+facilityId+"'  and  INVITED_DATE_TIME=to_date('"+date_val+"','dd/mm/yyyy') and WAIT_LIST_STATUS ='I' UNION Select  'S' WAIT_STATUS,COUNT (*) count FROM pr_wait_list  WHERE facility_id = '"+facilityId+"'  and wait_list_status='S' and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  between   trunc(sysdate - '"+prd+"' ) and trunc(sysdate+1) UNION Select  '0' WAIT_STATUS, count(*) count FROM pr_wait_list WHERE facility_id = '"+facilityId+"' and preferred_date_time   between trunc(sysdate - '"+prd+"' ) and trunc(sysdate+1)  and wait_list_status='O' ORDER BY WAIT_STATUS";
			sqlmain="select  'I' WAIT_STATUS,count(*) count from pr_wait_list where facility_id = ?  and  INVITED_DATE_TIME=to_date(?,'dd/mm/yyyy') and WAIT_LIST_STATUS ='I' UNION Select  'S' WAIT_STATUS,COUNT (*) count FROM pr_wait_list  WHERE facility_id = ? and wait_list_status='S' and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  between   trunc(sysdate - ? ) and trunc(sysdate+1) UNION Select  '0' WAIT_STATUS, count(*) count FROM pr_wait_list WHERE facility_id = ? and preferred_date_time   between trunc(sysdate - ? ) and trunc(sysdate+1)  and wait_list_status='O' ORDER BY WAIT_STATUS";
			
			rsSet=null;
			//rsSet 	= st.executeQuery(sqlmain);
			pstmt = con.prepareStatement(sqlmain);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,date_val);
			pstmt.setString(3,facilityId);
			pstmt.setString(4,prd);
			pstmt.setString(5,facilityId);
			pstmt.setString(6,prd);
			rsSet = pstmt.executeQuery();
			if (rsSet!=null)
			{
				while(rsSet.next())
				{			
					arrlst.add(rsSet.getString("count"));

				}
			}

		if(arrlst.size()>0)
				{%>
<table border="0" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
				
		<tr>
			<td class='COLUMNHEADER' nowrap width='15%'><fmt:message key="eOA.CurrentDayStatus.label" bundle="${oa_labels}"/></td>
			<td class='COLUMNHEADER'  nowrap width='6%'><td class='COLUMNHEADER' nowrap  width='6%'>
			<td class='COLUMNHEADER'  nowrap width='6%'><td class='COLUMNHEADER' nowrap width='6%'>
			<td class='COLUMNHEADER'  nowrap width='6%'><td class='COLUMNHEADER' nowrap width='6%'>
			<td class='COLUMNHEADER'  nowrap width='6%'>
		</tr>
				<%for (int j=0;j<arrlst.size();j+=3)
				 
				{
					 
					open =(String) arrlst.get(j);
					 invited  =(String) arrlst.get(j+1);
					selected  =(String) arrlst.get(j+2);%>

					  </table>
<table border="1" width="100%" cellspacing='0' cellpadding='0' >
		<tr>

				<td  nowrap  class=LABEL width='8%'><fmt:message key="Common.date.label" bundle="${common_labels}"/> -<%=date_val_display%></td> 
				<!--<td  class=label width='6%' nowrap><fmt:message key="Common.open.label" bundle="${common_labels}"/> -</td>
				<td  class=EMERGENT nowrap width='6%'></td>
				<td width='6%'  class=label nowrap><fmt:message key="Common.Selected.label" bundle="${common_labels}"/> -<td width='6%'  class=ORBROWN nowrap>-->
				<td width='6%'  class=label nowrap> <fmt:message key="eOA.invited.label" bundle="${oa_labels}"/> -<td  width='6%' class=MRHYPERIII nowrap></td>
				<td width='6%'  class=label nowrap></td>
				<td width='6%'  class=label nowrap></td>
				<td width='6%'  class=label nowrap></td>
				<td width='6%'  class=label nowrap></td>
				<td width='6%'  class=label nowrap></td>
		        <td  class='button' width='6%' ><input class='button' type='button' name='close' id='close' 
				value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='close_window();'></td>
				
		</tr>
</html>

<%}
				}
				arrlst.clear();
	if(st !=null) st.close();
	if(rsSet !=null) rsSet.close();
	
}
catch(Exception es){
//out.println(es);
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

