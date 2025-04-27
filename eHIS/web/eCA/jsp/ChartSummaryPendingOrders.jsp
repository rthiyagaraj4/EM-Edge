<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History   		 Name        		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.
19/06/2013		IN040967		ChowminyaG		System doesn?t sorting data by start date/time	
09/09/2014      PER0909			AKbar	     	Performance changes suggested by sunil										
15/11/2017		IN061896		Kamalakannan G		15/11/2017		Ramesh G		System should show icon for stat pending orders
16/11/2017     		IN065781		Kamalakannan G		16/11/2017		Ramesh G 		icon link removed 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<!--  <link rel='stylesheet' type='text/css' href='../../eCA/html/CAHomeIeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css'></link>

    <script language='javascript' src='../../eCommon/js/common.js'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<head>
	<!--<title></title> [IN035950]-->
	<title><%=title%></title><!--[IN035950]-->
	<script>
	async function orderFormatWindow(orderId,lineId){
	
		var dialogHeight ='36' ;
		var dialogWidth = '48' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId+"&lineId="+lineId;

		var retVals =await window.showModalDialog("../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<!-- <script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	<center>
		<form name='CAViewPatientAllergyForm' id='CAViewPatientAllergyForm' method='post'>
		<table width='100%' class='grid' align='center'>
	
		<%			
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			String practitioner_type = (String)session.getValue("practitioner_type");
			String facilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");			
			Connection con = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			ResultSet	rs = null;
			//[IN035950] Starts
			String order_category = request.getParameter("order_category");
			System.out.println("ChartSummaryPendingOrders.jsp--->"+order_category);
			if ("null".equals(order_category) || order_category==" ") order_category="";
			String date_from = request.getParameter("p_date_from");
			String date_to = request.getParameter("p_date_to");
			//[IN035950] Ends

			try
			{	String patient_id = "", query_pending_orders = "";
				String test_date_time = "", item_short_desc = 	"",item_short_desc_ms="",category_short_desc = "",category="",order_type_code="" ,format_exist_yn = "",orderId="",lineId="";
				String classValue = "";
				int i=0;
				patient_id = request.getParameter("patient_id");
				if(patient_id==null) patient_id = "";
				String overdue_yn = "";//IN061896
				String currCategory = "";
						
				//[IN035950] Starts
				//query_pending_orders = "SELECT DISTINCT b.order_category,b.ORDER_TYPE_CODE, c.short_desc order_category_short_desc,TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time,   or_get_order_catalog(a.order_id,a.order_type_code,?,?,b.order_line_num)  item_short_desc,e.catalog_synonym||DECODE(a.order_category,'PH', ((SELECT DECODE(am_get_desc.am_trade_name(trade_code,'en','1'),NULL, '','['|| am_get_desc.am_trade_name(trade_code,'en','1')|| ']') trade_name FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))|| '<br />'|| RTRIM(RTRIM(TO_CHAR (b.order_qty,'9999999999999990.999999999999'),'0'), '.')|| ' '|| PH_GET_UOM_DISPLAY('"+facilityId+"',b.order_uom,'"+locale+"')|| ' '|| ( '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')||']'),'') item_short_desc_ms,NVL2 (line_fields_display_text, 'Y', 'N') format_exist_yn,b.order_id order_id, b.order_line_num order_line_num FROM or_order a,or_order_line b,or_order_category_lang_vw c,am_duration_type d,or_catalog_synonym_lang_vw e WHERE b.order_category = c.order_category AND b.order_catalog_code = e.order_catalog_code AND e.language_id = ? AND catalog_synonym_type =    or_get_synonym_type(?,b.order_catalog_code) AND patient_id = ? AND a.order_id = b.order_id AND b.durn_type = d.durn_type(+) AND b.order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (10,15,16,17,20,23,25,30,40,45,50,52,54,55,65,67)) AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') and EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code=b.order_catalog_code AND ORDER_CATALOG_NATURE != 'S')AND c.language_id = ?  &&ORDER_CAT_FILTER &&DATE_FROM_FILTER &&DATE_TO_FILTER ORDER BY c.short_desc,b.order_category,TO_CHAR (b.start_date_time, 'dd/mm/yyyy HH24:MI') DESC";//Commentted IN040967 
				//query_pending_orders = "SELECT DISTINCT b.order_category,b.ORDER_TYPE_CODE, c.short_desc order_category_short_desc,TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time,   or_get_order_catalog(a.order_id,a.order_type_code,?,?,b.order_line_num)  item_short_desc,e.catalog_synonym||DECODE(a.order_category,'PH', ((SELECT DECODE(am_get_desc.am_trade_name(trade_code,'en','1'),NULL, '','['|| am_get_desc.am_trade_name(trade_code,'en','1')|| ']') trade_name FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))|| '<br />'|| RTRIM(RTRIM(TO_CHAR (b.order_qty,'9999999999999990.999999999999'),'0'), '.')|| ' '|| PH_GET_UOM_DISPLAY('"+facilityId+"',b.order_uom,'"+locale+"')|| ' '|| ( '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')||']'),'') item_short_desc_ms,NVL2 (line_fields_display_text, 'Y', 'N') format_exist_yn,b.order_id order_id, b.order_line_num order_line_num, b.start_date_time date_to_sort FROM or_order a,or_order_line b,or_order_category_lang_vw c,am_duration_type d,or_catalog_synonym_lang_vw e WHERE b.order_category = c.order_category AND b.order_catalog_code = e.order_catalog_code AND e.language_id = ? AND catalog_synonym_type =    or_get_synonym_type(?,b.order_catalog_code) AND patient_id = ? AND a.order_id = b.order_id AND b.durn_type = d.durn_type(+) AND b.order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (10,15,16,17,20,23,25,30,40,45,50,52,54,55,65,67)) AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') and EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code=b.order_catalog_code AND ORDER_CATALOG_NATURE != 'S')AND c.language_id = ?  &&ORDER_CAT_FILTER &&DATE_FROM_FILTER &&DATE_TO_FILTER ORDER BY c.short_desc,b.order_category,date_to_sort DESC";//IN040967
				
				query_pending_orders = "SELECT b.order_category,b.ORDER_TYPE_CODE, (select short_desc from or_order_category_lang_vw where language_id = ? and order_Category = b.order_category) order_category_short_desc,TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time,   or_get_order_catalog(a.order_id,a.order_type_code,?,?,b.order_line_num)  item_short_desc,  (select catalog_synonym from or_catalog_synonym_lang_vw where  language_id = ?  AND catalog_synonym_type = or_get_synonym_type ('PH', b.order_catalog_code) and order_catalog_code = b.order_catalog_code) || DECODE(a.order_category,'PH', ((SELECT DECODE(am_get_desc.am_trade_name(trade_code,?,'1'),NULL, '','['|| am_get_desc.am_trade_name(trade_code,?,'1')|| ']') trade_name FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))|| '<br />'|| RTRIM(RTRIM(TO_CHAR (b.order_qty,'9999999999999990.999999999999'),'0'), '.')|| ' '|| PH_GET_UOM_DISPLAY(?,b.order_uom,?)|| ' '|| ( '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')||']'),'') item_short_desc_ms,NVL2 (line_fields_display_text, 'Y', 'N') format_exist_yn,b.order_id order_id, b.order_line_num order_line_num,or_statorder_overdue_yn (b.order_category,b.order_catalog_code,b.start_date_time,b.priority) overdue_yn FROM or_order a,or_order_line b WHERE  patient_id = ? AND a.order_id = b.order_id AND  b.order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (10,15,16,17,20,23,25,30,40,45,50,52,54,55,65,67)) AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') and EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code=b.order_catalog_code AND ORDER_CATALOG_NATURE != 'S')  &&ORDER_CAT_FILTER &&DATE_FROM_FILTER &&DATE_TO_FILTER ORDER BY b.order_category,TO_CHAR (b.start_date_time, 'dd/mm/yyyy HH24:MI') DESC";//IN061896 added or_statorder_overdue_yn function

				if((!"".equals(order_category)) && (null!=order_category)){
					query_pending_orders=query_pending_orders.replace("&&ORDER_CAT_FILTER", "AND A.ORDER_CATEGORY = ? AND B.ORDER_CATEGORY = ?");	
				}
				else{
					query_pending_orders=query_pending_orders.replace("&&ORDER_CAT_FILTER", "");
				}
				if((!"".equals(date_to)) && (null!=date_to))
				{
				query_pending_orders=query_pending_orders.replace("&&DATE_FROM_FILTER", "and b.start_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' )");
				}
				else
				{
				query_pending_orders=query_pending_orders.replace("&&DATE_FROM_FILTER", "");
				}
				//
				if((!"".equals(date_from)) && (null!=date_from))
				{
				query_pending_orders=query_pending_orders.replace("&&DATE_TO_FILTER", "and b.end_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' )");
				}
				else
				{
				query_pending_orders=query_pending_orders.replace("&&DATE_TO_FILTER", "");
				}
				//[IN035950] Ends
				//Modified by Uma on 7/2/2009 for IN08174

				con = ConnectionManager.getConnection(request);

				String orInstallYn="select 1 from  sm_module where module_id='OR' and INSTALL_YN='Y'";
				pstmt1 = con.prepareStatement(orInstallYn);

				if(rs != null) rs = null;
				rs = pstmt1.executeQuery();				
				int index=1;//[IN035950]				
				if(rs.next())
				{
				if(rs!=null)rs.close();
				pstmt	=	con.prepareStatement(query_pending_orders);				
				//[IN035950] Starts				
				/*pstmt.setString(1,locale);
				pstmt.setString(2,practitioner_type);
				pstmt.setString(3,locale);	
				pstmt.setString(4,practitioner_type);
				pstmt.setString(5,patient_id);				
				pstmt.setString(6,locale);				
				
				if((!"".equals(order_category)) 	&& (null!=order_category)){
				pstmt.setString(7,order_category);
				pstmt.setString(8,order_category);
				}*/
				pstmt.setString(index++,locale);//PER0909
				pstmt.setString(index++,locale);
				pstmt.setString(index++,practitioner_type);
				pstmt.setString(index++,locale);
				//PER0909 - start					
				pstmt.setString(index++,locale);	
				pstmt.setString(index++,locale);	
				pstmt.setString(index++,facilityId);	
				pstmt.setString(index++,locale);	
				//pstmt.setString(index++,practitioner_type);
				//PER0909 - end
				pstmt.setString(index++,patient_id);				
				//pstmt.setString(index++,locale);//PER0909
				if((!"".equals(order_category)) && (null!=order_category)){
				pstmt.setString(index++,order_category);
				pstmt.setString(index++,order_category);
				}
				if((!"".equals(date_from)) && (null!=date_from))
				{
				pstmt.setString(index++,date_from);
				}
				if((!"".equals(date_to)) && (null!=date_to))
				{
				pstmt.setString(index++,date_to);
				}
				//[IN035950] Ends
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					i++;

					if(i%2==0) classValue = "CAQUERYEVEN";
					else classValue = "CAQUERYODD";

					test_date_time			= rs.getString("test_date_time");

					if(test_date_time == null)
						test_date_time = "";
					

					test_date_time = com.ehis.util.DateUtils.convertDate(test_date_time,"DMYHM","en",locale);

					item_short_desc			= rs.getString("item_short_desc");				
					overdue_yn			= rs.getString("overdue_yn");//kamal
					order_type_code			= rs.getString("ORDER_TYPE_CODE");
					item_short_desc_ms		= rs.getString("item_short_desc_MS");
					category_short_desc		= rs.getString("order_category_short_desc");
					category				= rs.getString("order_category");
					format_exist_yn			= rs.getString("format_exist_yn");
					orderId					= rs.getString("order_id");
					lineId					= rs.getString("order_line_num");

					if(test_date_time==null)	test_date_time	= "&nbsp;";
					if(item_short_desc==null)	item_short_desc	= "&nbsp;";
					if(format_exist_yn==null)	format_exist_yn	= "N";
					if(orderId==null)	orderId	= "";
					if(lineId==null)	lineId	= "";
					if(!currCategory.trim().equalsIgnoreCase(category_short_desc.trim()))
					{
					
						%>
						<!-- <tr><td class='columnHeadercenter' colspan="2"><%=category_short_desc%></td></tr> IN035950 -->
						<%
						//IN035950 Starts
						if(sStyle.equals(prefStyleSheet) )
						{
						%>
						<tr><td class='columnHeadercenter' colspan="2"><%=category_short_desc%></td></tr>
						<%}else{%>
						<tr><td class='COLUMNHEADERCENTER<%=content_ID%>' colspan="2"><%=category_short_desc%></td></tr>
						<%
						}
						//IN035950 Ends
						currCategory = 	 category_short_desc;
				    }

			%>
					<tr>
						<td class='gridData' width='45%'><B><%=test_date_time%></B></td>
						<td class='gridData' width='5%'>
						<%
						if(format_exist_yn.equals("Y"))
						{
						%>
							<a class='gridLink' href="javascript:orderFormatWindow('<%=orderId%>','<%=lineId%>')"><img src='../../eOR/images/Flex_red.gif' align='center'></a><%
						}
						else
						{%>&nbsp;<%}%></td>
					</tr>
					<%if((category.equals("PH") && order_type_code.equals("MS"))){%>
					 <tr>
						<td class='gridData' width='50%' colspan="2"><%=item_short_desc_ms%><!--</td> commented kamal  -->
					
					<%}else{%>
					<td class='gridData' width='50%' colspan="2"><%=item_short_desc%><!--</td> commented kamal  -->
					
							<%}%>
							
							<%
								if(overdue_yn.equals("Y"))
								{
									%>
								 		<img title="Overdue"  src='../../eCA/images/order_overdue.PNG' align='center' ><!--IN065781-->
									<%}else{%>	
									&nbsp;</td>	</tr>
							<%}
				}
			} // module install
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}
		%>
		</table>
		</form>
	</center>
</body>
</html>

