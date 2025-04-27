<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
15/02/2012    IN031116		 Menaka V		Functionality equivalent to 5.x, placing consultation order.
13/09/2013    IN030284.1 	 Chowminya G 	CRF:To capture Pre-consultation orders in Appointment Scheduling - to handle $ issue (replace $$ with ~~)	
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
	Orderables.setLanguageId(localeName);
	Orderables.setSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	Boolean is_ss_order_catlg_fac_wise = Orderables.isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
%>
<html>
<head>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script src='../../eOR/js/Orderable.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()" style='background-color:#E2E3F0;'>
<form name='OrderableResult' id='OrderableResult' action="OrderableResult.jsp?<%=request.getQueryString()%>"  method='post'>
<%

	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String checkedOnes	= "";
	String  req_start   =   "", req_end     =   "";
	String order_category1 = "",order_type_code1="";
	//ArrayList ar;
	String called_from = request.getParameter("called_from");
	if(called_from==null) called_from = "";
	String order_category=(request.getParameter("order_category")==null||request.getParameter("order_category").equals("null"))?"":request.getParameter("order_category");
	String order_type_code=(request.getParameter("type_code")==null||request.getParameter("type_code").equals("null"))?"":request.getParameter("type_code");
	String activity_type=(request.getParameter("activity_type")==null||request.getParameter("activity_type").equals("null"))?"":request.getParameter("activity_type");
 	String search_by=request.getParameter("search_by");
	if(search_by==null || search_by=="null") search_by = "C";
 	String description_code=(request.getParameter("description_code")==null||request.getParameter("description_code").equals("null"))?"":request.getParameter("description_code");
 	String p_clinic_code = (request.getParameter("p_clinic_code")==null||request.getParameter("p_clinic_code").equals("null"))?"":request.getParameter("p_clinic_code");
	String long_desc=request.getParameter("search_text");
	if(long_desc==null || long_desc=="null") long_desc = ""; 		
 	String facility_id = (String)session.getValue("facility_id");
	int counts=0;
	//if(from==null)
	//	Orderables.clearTempObject();
				 		
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	
	int i=1;
	
	if (from == null)
	{ 
		start = 1 ;  
	}  
	else
	{  
		start = Integer.parseInt( from ) ; 
	}

	if (to == null)
	{ 
		end = 10 ;
	}  
	else 
	{ 
		end = Integer.parseInt( to ) ; 
	}


	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");

	if(from != null && to != null)
	{
		int j=0;

		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		{
			if(request.getParameter("chk"+(i-1)) != null) 
			{
				checkedOnes = request.getParameter("chk"+(i-1));
				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}

	putObjectInBean("refusalOrdersBean",Orderables,request);
	i = 1;

	try
	{
		con = ConnectionManager.getConnection(request);
		String option_id	= "";
		String short_desc	= "";
		int ilCkeckedYN = 0;
		int recordCount;
		String checkStatus  = "";	
		String checkProp = "";
		StringBuffer sql = new StringBuffer();
		String classValue="";
		String limit_catalog_to_locn = "";

		sql.append("select nvl(limit_catalog_to_locn,'N') limit_catalog_to_locn from or_param_by_facility where operating_facility_id=?");
		pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1 , facility_id);
		rs = pstmt.executeQuery();

		while(rs.next() && rs!=null)
		{
			limit_catalog_to_locn = rs.getString("limit_catalog_to_locn")==null?"":rs.getString("limit_catalog_to_locn");
		}

		rs.close();
		pstmt.close();
		sql.setLength(0);

		sql.append("select a.order_catalog_code,or_get_desc.or_order_catalog(a.order_catalog_code,?,'2') long_desc,order_catalog_nature order_catalog_nature,order_category,order_type_code from or_order_catalog a"); 
		if(limit_catalog_to_locn.equalsIgnoreCase("Y"))
		{
			sql.append(" ,OP_CATALOG_FOR_CLINIC b "); 
		}
		//sql.append(" where order_category not in( 'PH' ,'CN') and order_category=NVL(?,order_category) AND order_type_code=NVL(?,order_type_code) AND ((upper(short_desc) LIKE DECODE(?,'C',UPPER('%'|| ? ||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) AND 'D' = ?) OR (upper(a.order_catalog_code) LIKE DECODE(?,'C',UPPER('%'|| ? ||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) AND 'C' = ?))  AND eff_status='E' AND NVL(activity_type,'!') = NVL(?,NVL(activity_type,'!'))");//IN031116
		sql.append(" where order_category not in( 'PH' ) and order_category=NVL(?,order_category) AND order_type_code=NVL(?,order_type_code) AND ((upper(short_desc) LIKE DECODE(?,'C',UPPER('%'|| ? ||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) AND 'D' = ?) OR (upper(a.order_catalog_code) LIKE DECODE(?,'C',UPPER('%'|| ? ||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) AND 'C' = ?))  AND eff_status='E' AND NVL(activity_type,'!') = NVL(?,NVL(activity_type,'!'))");//IN031116

		if(limit_catalog_to_locn.equalsIgnoreCase("Y"))
		{
			sql.append(" and a.order_catalog_code=b.order_catalog_code and b.clinic_code=?");
		}
		
		//IN068370,IN068373, starts
		if(is_ss_order_catlg_fac_wise)
			sql.append(" AND a.order_catalog_code IN (SELECT order_catalog_code FROM or_order_catalog_by_facility WHERE applicable_facility_id = ?) ");
		//IN068370,IN068373, ends
		sql.append(" ORDER BY long_desc");

		pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		//pstmt = con.prepareStatement(sql.toString());
		
		int indval =1;
		pstmt.setString(indval++ , localeName);
		pstmt.setString(indval++ , order_category);
		pstmt.setString(indval++ , order_type_code);
		pstmt.setString(indval++ , description_code);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ , search_by);
		pstmt.setString(indval++ , description_code);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ ,	long_desc);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ , search_by);
		pstmt.setString(indval++ , activity_type);
		if(limit_catalog_to_locn.equalsIgnoreCase("Y"))
		{
			pstmt.setString(indval++ , p_clinic_code);
		}
		//IN068370,IN068373, starts
		if(is_ss_order_catlg_fac_wise)
			pstmt.setString(indval++ ,Orderables.getLoginFacilityId());
		//IN068370,IN068373, ends

		rs = pstmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
	
%>	

	 <table border='0' width='100%'>
		<tr>
			<td width='65%'></td> 
			<td align='right' width='35%'>
<%
		if ( !(start <= 1)) 
		{
%>
			<a class='gridLink' href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
		}

		if ( !((start+10) > maxRecord ))
		{
%>
			<a class='gridLink' href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'>&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			<input type=hidden name='whichPage' id='whichPage' value='next'>
<%
		}
%>
			</td>
		</tr>
	 </table>

	  <table border='1' cellpadding='3' cellspacing='0' width='100%' align='center' id='tableId' class='grid'>
		<td class='COLUMNHEADERCENTER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>	
<%
		if (start != 0)
		{
			for(int j=1; j<start; i++,j++)
			{
				rs.next() ;
			}
			ilCkeckedYN+=start;
			--ilCkeckedYN ;
		}

		recordCount			=	Orderables.getSize();

		while(rs.next()&& i<=end)
		{
			counts++;
			option_id = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
			short_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
			order_category1 = rs.getString("order_category")==null?"":rs.getString("order_category");
			order_type_code1 = rs.getString("order_type_code")==null?"":rs.getString("order_type_code");
		
			try
			{
				//Commented By by Shaiju for Incident # 21657 Starts
				/*if(Orderables.containsObject(option_id+"$$"+short_desc))
				{
					if(!Orderables.containsTempObject(option_id+"$$"+short_desc))
					{
						Orderables.putTempObject(option_id+"$$"+short_desc);
					}
				}*/
				//IN030284.1
				if(Orderables.containsTempObject(option_id+"~~"+short_desc+"~~"+order_type_code1+"~~"+order_category1))
				{
					checkStatus = "Y";
				}
				else
					checkStatus = "N";
				//ar=Orderables.getArrayList();
					
			} 
			catch(Exception e) 
			{
               //out.println("Exception in OrderableResult.jsp: "+e.toString());//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181				
			}
			
			if(checkStatus.equals("Y")) 
			{
				checkProp = " CHECKED "; 
			} 
			else 
			{
				checkProp = "";
			}
			
			classValue="gridData";
%>
			<tr>
			<td class='<%=classValue%>'><%=option_id%></td>
			<td class='<%=classValue%>'><%=short_desc%></td>
			<td class='<%=classValue%>' align='center'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value="<%=option_id%>~~<%=short_desc%>~~<%=order_type_code1%>~~<%=order_category1%>" <%=checkProp%> onclick='getDescription(this,"<%=option_id%>","<%=counts%>");'> <!--IN030284.1 -->
			<input type="hidden" name="short_desc<%=counts%>" id="short_desc<%=counts%>" value="<%=short_desc%>">
			<input type="hidden" name="order_type_code1<%=counts%>" id="order_type_code1<%=counts%>" value="<%=order_type_code1%>">
			<input type="hidden" name="order_category1<%=counts%>" id="order_category1<%=counts%>" value="<%=order_category1%>">
			</td></tr>
<%
			ilCkeckedYN = ilCkeckedYN + 1;		
			i=i+1;
				//}
		}
		out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
		out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
		out.println("<input type=hidden name=occurance value='next'>");
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
%>

		<input type=hidden name=from value='<%=start%>'>
		<input type=hidden name=to value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type=hidden name='called_from' id='called_from' value='<%=called_from%>'>
		<input type=hidden name='order_category' id='order_category' value='<%=order_category%>'>
		<input type=hidden name='order_type_code' id='order_type_code' value='<%=order_type_code%>'>
		<input type=hidden name='activity_type' id='activity_type' value='<%=activity_type%>'>
		<input type=hidden name='search_by' id='search_by' value='<%=search_by%>'>
		<input type=hidden name='description_code' id='description_code' value='<%=description_code%>'>
		<input type=hidden name='long_desc' id='long_desc' value='<%=long_desc%>'>
		<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>
		<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>
		
	 </table>
<%	    if(counts==0)
		{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
<%
		}
		else
		{
%>
			<table border='0' width='100%'>
			<tr><td align='right'><input type='button' class='white' value='Ok' width='25%' onclick='ok(<%=(start+10)%>,<%=(end+10)%>)'></td></tr></table>
<%
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
<script>
function submitPrevNext(from, to)
{
	document.OrderableResult.from.value = from;
	document.OrderableResult.to.value = to; 
	document.OrderableResult.target = "refusal_resultframe1"
	document.OrderableResult.submit();
}
function ok(from,to)
{
	submitOrderable();
	//window.close();
	console.log("Inside OrderableResult JSP 368 ok Click from : "+from+" to : "+to);
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = 1;
	const dialogTag = parent.parent.document.getElementById("dialog_tag");  
    dialogTag.close(); 
}
function dummy()
{
}
</script>
</html>

