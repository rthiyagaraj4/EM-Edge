<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
---------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
---------------------------------------------------------------------------------------------------------
?             100            ?           created

12/12/2011    IN029211       Chowminya G    Incident No: IN029211 - <Record Refusal of order set then view Existing Refusal system show only 1 order with multiple line> 
24/09/2012    IN034904        Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal
---------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%> 

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
 	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="orderidresult" id="orderidresult">
<table >
<%	
			
	String temp = "";
	//String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "RefusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";


	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);

	ArrayList getBeanOrderId = new ArrayList();
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patientId=request.getParameter("patientid");
	String orderid=request.getParameter("orderid");
	String linenum = request.getParameter("linenum");
	
	if(orderid == null && linenum == null && !patientId.equals("")|| orderid.equals("") || linenum.equals(""))
	{
		//bean.clearBean();
	}

	if(request.getQueryString() != null)
		bean.clearBean();

	getBeanOrderId.add(orderid);

	if(linenum.equals("") || linenum.equals(" ") || linenum == null)
	{
		getBeanOrderId.add(linenum);
	}
	else
	{
		StringTokenizer strTokenizer = new StringTokenizer(linenum,":");
		
		while(strTokenizer.hasMoreTokens())
		{
			temp = strTokenizer.nextToken();

			if(temp != "" && temp != null)
			{
				getBeanOrderId.add(temp+":");	
				temp = "";
			}
		}
	}
					
	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;
	//String order_y_n = request.getParameter( "order_y_n" ) ;
	String check="";
	String classvalue		= "";
	//	String get_y_n="";

	HashMap sqlMap = new HashMap();
	//sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_ID"));//Commented --[IN029211]
	//sqlMap.put( "sqlData", "select b.order_id order_id,b.order_line_num order_line_num, b.ORD_CONSENT_REQD_YN ord_consent_reqd_yn,b.catalog_synonym_dc catalog_desc,b.ORD_PRACT_ID ord_pract_id,c.practitioner_name practitioner_name,a.encounter_id encounter_id, b.order_type_code order_type_code, a.patient_class patient_class,a.source_type  location_type,a.source_code location_code,b.priority priority,b.order_catalog_code order_catalog_code  from or_order a, or_order_line b, am_Practitioner c  where a.order_id = b.order_id and a.order_type_code = b.order_type_code and a.order_category = b.order_category and a.ord_pract_id = c.practitioner_id and a.patient_id=? and upper(b.order_id) LIKE upper(?||'%') and a.order_category not in ('PH') and SUBSTR (a.order_id, 1, 2) NOT IN ('CS') and b.order_line_status not in ( select order_status_code from or_order_status_code where order_status_type in (60,70,75,85,90,93,96,97,99))   order by b.order_id desc,b.order_line_num");//--[IN034904] - Commented - include form_id value
	sqlMap.put( "sqlData", "select b.order_id order_id,b.order_line_num order_line_num, b.ORD_CONSENT_REQD_YN ord_consent_reqd_yn,b.catalog_synonym_dc catalog_desc,b.ORD_PRACT_ID ord_pract_id,c.practitioner_name practitioner_name,a.encounter_id encounter_id, b.order_type_code order_type_code, a.patient_class patient_class,a.source_type  location_type,a.source_code location_code,b.priority priority,b.order_catalog_code order_catalog_code, d.consent_form_id consent_form_id  from or_order a, or_order_line b, am_Practitioner c,or_order_catalog d  where a.order_id = b.order_id and a.order_type_code = b.order_type_code and a.order_category = b.order_category and a.ord_pract_id = c.practitioner_id and a.patient_id=? and upper(b.order_id) LIKE upper(?||'%') and a.order_category not in ('PH') and SUBSTR (a.order_id, 1, 2) NOT IN ('CS') and b.order_line_status not in ( select order_status_code from or_order_status_code where order_status_type in (60,70,75,85,90,93,96,97,99)) AND b.order_catalog_code = d.order_catalog_code   order by b.order_id desc,b.order_line_num");
	
	ArrayList selList = new ArrayList();
	ArrayList selList1 = new ArrayList();//--[IN029211]
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("order_id");
	displayFields.add("order_line_num" );
	displayFields.add("catalog_desc" );
	displayFields.add("practitioner_name" );
	displayFields.add("ord_consent_reqd_yn" );
	displayFields.add("encounter_id");
	displayFields.add("patient_class");
	displayFields.add("order_type_code");
	displayFields.add("location_code");
	displayFields.add("location_type");
	displayFields.add("PRIORITY");
	displayFields.add("order_catalog_code");
	displayFields.add("consent_form_id"); //--[IN034904]

	ArrayList chkFields = new ArrayList();

	chkFields.add(patientId);
	chkFields.add(orderid);
	
	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.(sqlMap, funcMap, request,false)
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	int  n=0;
		
	String msg="";
	String msg1=""; //uncommented by --[IN029211]

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table border="" cellpadding="3" cellspacing="0" width="100%" align="center" class="grid">
		<tr>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="eOR.CatalogDescription.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="eOR.OrderLineNo.label" bundle="${or_labels}"/></td>
		
		<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
<%
		selList = bean.getSelectedCatalog();
		selList1 = bean.getSelectedOrderId(); //--[IN029211]

		//int count=0;
		int count1=0;
		
        for(int recCount=2; recCount<result.size(); recCount++) 
		{
           classvalue="gridData";
%>
            <tr >		
<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		 //  String link_columns = "1";

		records=(ArrayList) result.get( recCount );
	//	for(int colCount=0; colCount<records.size(); colCount+=12)//--[IN034904]
	// includ consent_form_id in all the js calls IN034904
		for(int colCount=0; colCount<records.size(); colCount+=13)
		{
			if(! msg.equals((String)records.get( colCount)))
			{	
				msg=(String)records.get( colCount);
				msg1=(String)records.get( colCount+2);//--[IN029211]
%>
		 
				<tr>
					<td colspan="4" class="CAGROUPHEADING" align='left'><font size="1pt"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/><%=msg %> </font></td>
				</tr>
<%
			}
%>
            <td class="<%=classvalue%>" ><font size="1pt"> <%=(String)records.get( colCount+2)%></font></td>
			<td class="<%=classvalue%>"><font size="1pt"><%=(String)records.get( colCount+1)%></font></td>
			<td class="<%=classvalue%>"><font size="1pt"><%=(String)records.get( colCount+3)%></font></td>
<%
					 //get_y_n=(String)records.get( colCount+4);
			
			n=n+1;				
			if(selList.contains(msg1) && selList1.contains(msg))
			{
				//String get_ord_id_line="";

				//	String strOrderId = "";


				/*if(cnt > 1)
				{
				get_ord_id_line = msg +":"+(String)records.get( colCount+1)+":";
				strOrderId = "1:";
				}
				else
				{
				}*/
				/*if(((String)records.get( colCount+1)).equals("1"))
				{
				get_ord_id_line = msg +":"+(String)records.get( colCount+1)+":";
				strOrderId = "1:";
				}
				else
				{
				get_ord_id_line = msg+":"+(String)getBeanOrderId.get(1);
				strOrderId = "1:2:";
				}*/

				//get_ord_id_line = msg +":"+(String)records.get( colCount+1)+":";




				//if((get_ord_id_line).equals((String)getBeanOrderId.get(0)+ ":"+(String)getBeanOrderId.get(count1+1)))
							
				if(selList.contains((String)records.get( colCount+2)) && selList1.contains((String)records.get( colCount)))//--[IN029211]
				{
					count1=count1+1;
					check="CHECKED";
					//chk = true;
											
%>
					<td class="<%=classvalue%>"  align="center"><input type="checkbox" name="s_<%=n%>" id="s_<%=n%>" value="<%=msg%>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get(colCount+2)%>:$#<%=(String)records.get(colCount+5)%>:$#<%=(String)records.get(colCount+6)%>:$#<%=(String)records.get(colCount+7)%>:$#<%=(String)records.get( colCount+8)%>:$#<%=(String)records.get(colCount+9)%>:$#<%=(String)records.get( colCount+10)%>:$#<%=(String)records.get( colCount+11)%>:$#<%=(String)records.get( colCount+12)%>" <%=check %>
						onClick="checky_n(this,'<%=msg %>:$#<%=(String)records.get( colCount+1)%>:$#<%=(String)records.get( colCount+12)%>');">
					</td>
												
<%
				}//153
				else if(selList1.contains(msg)) //Condition Added By --[IN029211] 
				{
%>				
				<td class="<%=classvalue%>"  align="center"><input type="checkbox" name="s_<%=n%>" id="s_<%=n%>" value="<%=msg%>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get(colCount+2)%>:$#<%=(String)records.get(colCount+5)%>:$#<%=(String)records.get(colCount+6)%>:$#<%=(String)records.get(colCount+7)%>:$#<%=(String)records.get(colCount+8)%>:$#<%=(String)records.get(colCount+9)%>:$#<%=(String)records.get(colCount+10)%>:$#<%=(String)records.get( colCount+11)%>:$#<%=(String)records.get( colCount+12)%>"  onClick="checky_n(this,'<%=msg%>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get( colCount+12)%>');" >
				</td>
<%				
				}
				else
				{
%>

					<td class="<%=classvalue%>"  align="center"><input type="checkbox" name="s_<%=n %>" id="s_<%=n %>" value="<%=msg%>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get(colCount+2)%>:<%=(String)records.get(colCount+5)%>:$#<%=(String)records.get(colCount+6)%>:$#<%=(String)records.get(colCount+7)%>:$#<%=(String)records.get(colCount+8)%>:$#<%=(String)records.get(colCount+9)%>:$#<%=(String)records.get(colCount+10)%>:$#<%=(String)records.get(colCount+11)%>:$#<%=(String)records.get( colCount+12)%>"  onClick="checky_n(this,'<%=msg %>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get( colCount+12)%>');" disabled> <!--///@@@@/////-->
					</td>
<%									//	} /////
				}
			}//149
			else
			{
				if(selList.size() != 0)
				{
%>
					<td class="<%=classvalue%>"  align="center"><input type="checkbox" name="s_<%=n%>" id="s_<%=n%>" value="<%=msg%>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get(colCount+2)%>:$#<%=(String)records.get(colCount+5)%>:$#<%=(String)records.get(colCount+6)%>:<%=(String)records.get(colCount+7)%>:$#<%=(String)records.get(colCount+8)%>:$#<%=(String)records.get(colCount+9)%>:$#<%=(String)records.get(colCount+10)%>:$#<%=(String)records.get(colCount+11)%>:$#<%=(String)records.get( colCount+12)%>"  onClick="checky_n(this,'<%=msg %>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get( colCount+12)%>');" disabled>
					</td>									
<%
				}
				else
				{
%>
					<td class="<%=classvalue%>"  align="center"><input type="checkbox" name="s_<%=n%>" id="s_<%=n%>" value="<%=msg%>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get(colCount+2)%>:$#<%=(String)records.get(colCount+5)%>:$#<%=(String)records.get(colCount+6)%>:$#<%=(String)records.get(colCount+7)%>:$#<%=(String)records.get(colCount+8)%>:$#<%=(String)records.get(colCount+9)%>:$#<%=(String)records.get(colCount+10)%>:$#<%=(String)records.get( colCount+11)%>:$#<%=(String)records.get( colCount+12)%>"  onClick="checky_n(this,'<%=msg%>:$#<%=(String)records.get(colCount+1)%>:$#<%=(String)records.get( colCount+12)%>');" >
					</td>
<%
				}
			}
							
						//}//147
			//	else
			//		{
										
				%>
	<!--	<td class="<%//=classvalue%>"  align="center"><input type="checkbox" name="s_<%//=n %>" id="s_<%//=n %>" value="<%//=msg %>:<%//=(String)records.get( colCount+1)%>:<%//=(String)records.get( colCount+2)%>" onClick="checky_n(this,'<%//=msg %>:<%//=(String)records.get( colCount+1)%>');">
		</td> -->
		<%
			//	
			//		}
			/*	}//143
				else
				{
					*/
		%>

				<!--<td class="<%=classvalue%>" >&nbsp;</td>-->

<%
			//	}//last else block 
		
						
		}
	}
%>
</table>

<table  width="100%" class="a1">
 <tr>
 <td align='right' bgcolor='white'>
 <input type="button"   class="button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>" onClick="displayOrderId()">
	
 </td>
 </tr>
 </table>
<input type="hidden" name="store_n" id="store_n" value="<%=n %>">
<input type="hidden" name="order_y_n" id="order_y_n" value="">
<input type="hidden" name="from" id="from" value="">
<input type="hidden" name="to" id="to" value="">
<input type="hidden" name="store_orderid" id="store_orderid" value="">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id %>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="mode" id="mode" value="1">
<input type="hidden" name="line_num" id="line_num" value="">
<input type="hidden" name="selectedCatalog" id="selectedCatalog" value="">
<input type="hidden" name="localeName" id="localeName" value="<%= localeName %>">
</form>
<%
	 //selList.clear();
	
}
else
{
%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>		
<%
	out.println("<script>window.close();</script>");
}	
out.println(CommonBean.setForm(request ,"../../eOR/jsp/RefusalOrderIDResults.jsp",searched) );
%>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

