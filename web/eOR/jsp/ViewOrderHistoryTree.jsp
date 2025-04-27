<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------
22/12/2016	IN062669     Vijayakumar K									ML-MMOH-CRF-0728 [IN:062669]
28/06/2018	IN065341     Prakash C		29/06/2018	Ramesh G	MMS-DM-CRF-0115
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
<!--<link rel="stylesheet" type="text/css" href="../../eOR/html/ORMainMenu.css"></link>-->
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
 	<script language="JavaScript" src="../js/ORMainMenu.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  	<script>
	function dummy(){
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	

	/* Mandatory checks start */
	//String mode					= "1";//request.getParameter( "mode" ) ;
 	String bean_id				= request.getParameter( "bean_id" ) ;
	String bean_name			= request.getParameter( "bean_name" ) ;
 
	//	ArrayList allValues = new ArrayList();
	/* Mandatory checks end */

	/* Initialize Function specific start */
 	//ViewOrder bean				= (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 ViewOrder bean					= (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	 bean.setLanguageId(localeName);

	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 	//bean.setMode( mode ) ;
	//String patient_id			= bean.checkForNull(request.getParameter("patient_id"));
 	String orderId				= bean.checkForNull(request.getParameter("orderId"));
 	String order_catalog_code	= request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");//IN061961
	String order_line_num		= request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");//IN061961
	String ord_cat		= request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");//IN061961
	String order_category		= request.getParameter("order_category")==null?"":request.getParameter("order_category");//IN061961
	String view_by		= request.getParameter("view_by")==null?"":request.getParameter("view_by");//IN061961
	boolean isviewLineDtls = bean.isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
	String executable_name		= "../../eOR/jsp/ViewOrderHistoryResults.jsp?"+request.getQueryString();
	String workAreaFrame		= "ViewOrderHistoryResult";
	String query_executable_name= "";
//IN065341 starts
	String RepDb		= request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	//ArrayList catalogDetails	= bean.getOrderCatalogDetails(orderId,RepDb);
//IN065341 ends	//COMMENTED FOR IN061961
//	ArrayList catalogDetails	= bean.getOrderCatalogDetails(orderId,RepDb,order_catalog_code,view_by);//IN061961
	ArrayList catalogDetails	= bean.getOrderCatalogDetails(orderId,RepDb,order_catalog_code,view_by,order_category);//IN061961
	ArrayList orderDetails		= null;
	String[] catalog_details	= null;
	String[] order_details		= null;
	int i						= 0;
	String catalog_code			= "", catalog_desc			= "";
	String field_mnemonic		= "";
%>
<FORM METHOD=POST ACTION="" name="frmMenu" id="frmMenu">
<script>
	var obj;
	obj = new dTree('obj');
	obj.add(0,-1,'<font size=1 style=font-weight:bold style=color:#333><a class="gridLink" href="#" onClick="showHistoryResults()" ><%=orderId%></a></font>');
	obj.config.useStatusText=true;

 <% 	
	if(catalogDetails.size() == 0)
	{			
%>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));
		parent.window.close();
<%		
	} 
	else
	{  
		for(i=0; i<catalogDetails.size(); i++)
		{
			catalog_details		= (String[])catalogDetails.get(i);
			catalog_code		= bean.checkForNull(catalog_details[0]);
			catalog_desc		= bean.checkForNull(catalog_details[1]);
			order_line_num		= bean.checkForNull(catalog_details[2]);
		//IN065341 starts
			//orderDetails		= bean.getOrderHistoryDetails(orderId, order_line_num);
			orderDetails		= bean.getOrderHistoryDetails(orderId, order_line_num,RepDb);
		//IN065341 ends		
			//query_executable_name = executable_name+"&order_cat=''&order_cat_desc="+catalog_desc+"&orderId="+orderId;
			query_executable_name = executable_name+"&order_cat=''&order_cat_desc="+catalog_desc+"&orderId="+orderId+"&view_by="+view_by+"&ind_order_line_num="+order_line_num;//IN061961
%>			 						

			obj.add("<%=catalog_code%>1","0","<%=catalog_desc%>","<%=query_executable_name%>","<%=catalog_desc%>","<%=workAreaFrame%>","","","","");
<%
			for(int j=0; j<orderDetails.size(); j++)
			{
				 order_details			= (String[])orderDetails.get(j);
				 field_mnemonic			= bean.checkForNull(order_details[0]);
				 //query_executable_name	=  executable_name+"&order_cat=''&order_cat_desc="+catalog_desc+"&orderId="+orderId+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic;
				 query_executable_name	=  executable_name+"&order_cat=''&order_cat_desc="+catalog_desc+"&orderId="+orderId+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&ind_order_line_num="+order_line_num;//IN061961
%>				
				var temp_orderdetails2="<%=bean.checkForNull(order_details[2])%>";
				if(temp_orderdetails2=="ORDER_LINE_STATUS")
					temp_orderdetails2=getLabel("Common.OrderStatus.label","common");
				else if(temp_orderdetails2=="QTY_VALUE")
					temp_orderdetails2=getLabel("Common.Qty.label","COMMON");
				else if(temp_orderdetails2=="QTY_UNIT")
					temp_orderdetails2=getLabel("Common.QtyUnit.label","COMMON");
				else if(temp_orderdetails2=="ROUTE_CODE")
					temp_orderdetails2=getLabel("Common.Route.label","COMMON");
				else if(temp_orderdetails2=="FREQ_CODE")
					temp_orderdetails2=getLabel("Common.Frequency.label","COMMON");
				else if(temp_orderdetails2=="DURN_VALUE")
					temp_orderdetails2=getLabel("Common.duration.label","common");
				else if(temp_orderdetails2=="DURN_TYPE")
					temp_orderdetails2=getLabel("Common.DurationType.label","common");
				else if(temp_orderdetails2=="ITEM_NARRATION")
					temp_orderdetails2=getLabel("eOR.ItemNarration.label","OR");
				else if(temp_orderdetails2=="START_DATE_TIME")
					temp_orderdetails2=getLabel("Common.startdatetime.label","common");
				else if(temp_orderdetails2=="END_DATE_TIME")
					temp_orderdetails2=getLabel("Common.enddatetime.label","common");
				else if(temp_orderdetails2=="ORDER_CATALOG_CODE")
					temp_orderdetails2=getLabel("Common.ordercatalog.label","common");
				else if(temp_orderdetails2=="IV_PREP_YN")
					temp_orderdetails2=getLabel("eOR.IVPrep.label","OR");
				else if(temp_orderdetails2=="NUM_OF_REFILLS")
					temp_orderdetails2=getLabel("eOR.NoOfRefills.label","OR");
				else if(temp_orderdetails2=="PERFORM_DEPTLOC_CODE")
					temp_orderdetails2=getLabel("Common.PerformingLocation.label","COMMON");
				else if(temp_orderdetails2=="SPECIMEN_DTLS")
					temp_orderdetails2=getLabel("Common.SpecimenDetails.label","COMMON");
				else if(temp_orderdetails2=="RESULT_REVIEW")
					temp_orderdetails2=getLabel("eCA.ReviewResults.label","CA");
				else if(temp_orderdetails2=="CONSENT_DTLS")
					temp_orderdetails2=getLabel("Common.ConsentDetails.label","COMMON");
				else if(temp_orderdetails2=="RESULT_VIEW")//IN062669
					temp_orderdetails2=getLabel("eOR.ResultsViewed.label","OR");//IN062669
				
				 obj.add("<%=orderId%><%=j%>1","<%=catalog_code%>1",temp_orderdetails2,"<%=query_executable_name%>","<%=bean.checkForNull(order_details[2])%>","<%=workAreaFrame%>","","","","");
		
<%				} // End of for j
			} // End of for i 
	} // End of else
 %>
</script>
	<input type="hidden" name="txtNodePoistions" id="txtNodePoistions" value="<%=i%>">
 	<input type="hidden" name="txtCurrentPosition" id="txtCurrentPosition" value="">
	<input type="hidden" name="txtToolTips" id="txtToolTips" value="">
	<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">
	<script>
 		document.write(obj);
		obj.openAll();
   		parent.ViewOrderHistoryResult.location.href="<%=executable_name%>";
  	</script>

 </form>
</body>
</html>

<%
	//putObjectInBean(bean_id,bean,request);
%>

