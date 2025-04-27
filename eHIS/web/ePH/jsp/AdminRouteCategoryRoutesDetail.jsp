<!DOCTYPE html>
<!-- TerminologyCodeForCaseTypeDetail.jsp -->
<%--
*	Copyright © ISoft. ALL RIGHTS RESERVED
*	Application		:	ePH
*	Purpose 		:	
*	Created By		:	Abdul Sukkur
*	Created On		:	28 Oct 2009

--%>
<%-- JSP Page specific attributes start --%>
<html>
<%@page import="ePH.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="AdminRouteCategoryRoutes" class="webbeans.eCommon.RecordSet" scope="session"/>

<head>
<%
	request.setCharacterEncoding("UTF-8");

//Added by Himanshu for MMS-ME-SCF-0097 Starts 
request= new XSSRequestWrapper(request); 
response.addHeader("X-XSS-Protection", "1; mode=block"); 
response.addHeader("X-Content-Type-Options", "nosniff"); 
//Added by Himanshu for MMS-ME-SCF-0097 ends

	String locale=(String)session.getAttribute("LOCALE");
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script> 
<script language="JavaScript" src="../../ePH/js/AdminRouteCategoryRoutes.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% 
  	
	Connection con=null;
	String classValue="";	
	String checked="";	
	String admin_route_categ_code="";	
	String sql_associated="";
	String route_code="" , short_desc="";	
	String search_criteria="" ,search_text="";// selected="";
	Statement stmt_Associated=null;	
	String sql_nature="";
	String sql_case_type="";
	String from = request.getParameter("from");
	String to = request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;

	String chkAttribute="" ,disabled="";
	String dbaction="";
	String  req_start   =   "", req_end     =   "" ;
	String alphalink ="";
	String code="";

	
	ResultSet rset_Associated=null ;

	try{
		con = ConnectionManager.getConnection(request);		
		admin_route_categ_code=request.getParameter("admin_route_categ_code")==null ? "":request.getParameter("admin_route_categ_code");		
		short_desc=request.getParameter("short_desc")== null?"":request.getParameter("short_desc");
		search_criteria=request.getParameter("search_criteria")== null?"":request.getParameter("search_criteria");
		 if(search_criteria.equals("S"))
			search_text = short_desc +"%";
		 else if(search_criteria.equals("E"))
			search_text ="%"+short_desc;
		 else if(search_criteria.equals("C"))
			search_text = "%"+short_desc+"%";
		 else
			search_text = "%";	
			
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 7; }   else {  end = Integer.parseInt( to ) ; }
        
               
        req_start       =   request.getParameter("start")==null ?"0" : request.getParameter("start");
        req_end         =   request.getParameter("end")==null ? "0" : request.getParameter("end");
		
		alphalink = request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
		if(alphalink.equals("*"))
		{
			alphalink="_";
		}

%>
</head>
<body  onLoad="FocusFirstElement();" onKeyDown = "lockKey();"  OnMouseDown=""> <!--/**
 * @Name - Sandhya A 
 * @Date - 18/12/2009
 * @Inc# - IN016185
 * @Desc - added lockKey() in <body> onKeyDown() event.
 */-->
<form name='form_AdminRoutedetail' id='form_AdminRoutedetail' action="../../ePH/jsp/AdminRouteCategoryRoutesDetail.jsp" method='post' >
	
<%	
		ArrayList TabList		=	null;
		ArrayList sessionList	=  (ArrayList)AdminRouteCategoryRoutes.getRecordSetHandle();
		//out.println(sessionList);
		if(sessionList.size()>0)
		{
			//TabList=(ArrayList)AdminRouteCategoryRoutes.getObject(0);
		}
		if(alphalink.equals("Associated"))
		{			
			 sql_associated="SELECT a.route_code, b.route_desc short_desc,'U' db_action FROM ph_admin_route_catg_dtl a, ph_route b WHERE a.admin_route_catg_code = '"+admin_route_categ_code+"' and a.route_code = b.route_code ORDER BY 2";			
		}
		else
		{			
			 sql_associated="select route_code, route_desc short_desc, 'I' db_action from ph_route where (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(route_desc,1,1)) = upper('"+alphalink+"') and upper(route_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and upper(substr(route_desc,1,1)) not between 'A' and 'Z' and upper(route_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(route_desc) like upper('"+alphalink+"' || '"+search_text+"'))) and route_code not in (select route_code from ph_admin_route_catg_dtl where admin_route_catg_code = '"+admin_route_categ_code+"') UNION ALL select a.route_code, b.route_desc short_desc, 'U' db_action from ph_admin_route_catg_dtl a, ph_route b where a.admin_route_catg_code = '"+admin_route_categ_code+"' and a.route_code = b.route_code and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(route_desc,1,1)) = upper('"+alphalink+"') and upper(route_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and upper(substr(route_desc,1,1)) not between 'A' and 'Z' and upper(route_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(route_desc) like upper('"+alphalink+"' || '"+search_text+"'))) ORDER BY 2 "; 			
		}


		//System.out.println("==fggfg=="+"srch_crt+="+search_criteria+"=+++="+search_text+"=+++"+sql_associated);
		stmt_Associated=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset_Associated=stmt_Associated.executeQuery(sql_associated);
		rset_Associated.last();
		maxRecord = rset_Associated.getRow();
		rset_Associated.beforeFirst();
		if(maxRecord > 0){	
%>

		<script>
			parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?';
		</script>
		<table width='100%'>
		<tr>
		<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    if ( !(start <= 1)) {
	%>
			<a href='javascript:submitPrevNext(<%=(start-7)%>,<%=(end-7)%>,"<%=search_criteria%>","<%=short_desc%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>	
	<%
	    }
	    if ( !((start+7) > maxRecord )){
	%>
	    <a href='javascript:submitPrevNext(<%=(start+7)%>,<%=(end+7)%>,"<%=search_criteria%>","<%=short_desc%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<%
	    }
	%>
		</td>
		</tr>
		<table>

		<table border='1' cellpadding='0' cellspacing='0' align='center'  width='100%' >
			<th width='13%'><fmt:message key="ePH.RouteCode.label" bundle="${ph_labels}"/></th>
			<th width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>			
			<th width='7%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><BR><INPUT type="checkbox" name="chkAll" id="chkAll"  <%=checked%> onclick="selectAll(this);"></th>

		<%if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rset_Associated.next() ;
			}
		 }
		//out.println("start "+start+ " i->"+i+" - "+end);
		while(rset_Associated.next() && i< end){

			route_code = rset_Associated.getString("route_code");
			short_desc=rset_Associated.getString("short_desc");			
			dbaction=rset_Associated.getString("db_action");			
			
			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
			disabled="";
				
			if(dbaction.equals("U")){
				if(alphalink.equals("Associated")){
						disabled="";						
				}
				else
					disabled="Disabled";
			}
			int index=-1;
			for(int j=0; j<AdminRouteCategoryRoutes.getSize();j++){
				ArrayList temp_list = (ArrayList)AdminRouteCategoryRoutes.getObject(j);
				 code=(String)temp_list.get(0);
				if(code.equals(route_code)){
					index=j;
					break;
				}
			}
			if(index!=-1){
				chkAttribute="checked";
				TabList = (ArrayList)AdminRouteCategoryRoutes.getObject(index);				
			}
			else{
				TabList=null;
				chkAttribute="";				
			}
			
%>
			<tr>
				<td class='<%=classValue%>'><%=route_code%></td>
				<td class='<%=classValue%>' align="left"><%=short_desc%></td>				
				<td align='center' class='<%=classValue%>'><input type='checkbox' name='chk<%=i%>' id='chk<%=i%>'  value='<%=route_code%>' <%=chkAttribute%> <%=disabled%> onclick="setchkAll(this);"> </td>
			</tr>

	<%
		i++;
	chkAttribute="";
/*	if(TabList.size()>0)
		flag=1;*/
	
		}
			
%>	
	<input type='hidden' name='from' id='from' value='<%=start%>'>
	<input type='hidden' name='to' id='to' value='<%=end%>'>
	<input type='hidden' name='start' id='start' value='<%=start%>'>
	<input type='hidden' name='end' id='end' value='<%=end%>'>
	<input type='hidden' name='route_code' id='route_code' value="<%=route_code%>" >
	<input type='hidden' name='function_name' id='function_name' value=''>
	<input type='hidden' name='maxRecords' id='maxRecords' value='<%=maxRecord%>'>
	<input type='hidden' name="admin_route_categ_code" id="admin_route_categ_code" value='<%=admin_route_categ_code%>'>	
	<input type='hidden' name="alphalink" id="alphalink" value='<%=alphalink%>'>
	<input type='hidden' name="search_criteria" id="search_criteria" value='<%=search_criteria%>'>
	<input type='hidden' name="short_desc" id="short_desc" value='<%=short_desc%>'> 

	</table>
	<script>
		checkselectAll();
	</script> 
<%	
	}
	else{%>
		<script>
			var message=getMessage("NO_RECORD_FOUND","Common");
			parent.f_query_detail.location.href='../../eCommon/html/blank.html';
			parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
		</script>
	<%}
	}catch(Exception e){

		System.err.println(e.toString());
		e.printStackTrace();
	}
	finally { 
		if(rset_Associated!=null) rset_Associated.close();	
		if(stmt_Associated!=null) stmt_Associated.close();
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("AdminRouteCategoryRoutes", AdminRouteCategoryRoutes);
	}	
	%>
	
	</form>
  </body>
</html>

