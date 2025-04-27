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
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
11/09/2013  IN043253	 	Chowminya	Ticksheet has more than 5 sections in it, the 6th section onwards displays below and it is hidden
16/09/2013  IN043253.1  	Chowminya	Ticksheet display fails when 10 section was used
01/12/2013	IN038787		Ramesh G			Bru-HIMS-CRF-358
13/03/2014	IN047581		Chowminya	Reduce space between Tick Sheet Section and Order Catalog
-----------------------------------------------------------------------
*/
%> 
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean	  = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */
	String order_category	= bean.checkForNull(request.getParameter("order_category"),"");
	String order_type		= bean.checkForNull(request.getParameter("order_type"),"");
	String activity_type	= bean.checkForNull(request.getParameter("activity_type"),"");
	String tick_sheet_id	= bean.checkForNull(request.getParameter("tick_sheet_id"),"");
	String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
	String priv_applicability_yn	= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
	String  order_dispaly_verticalYN			= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");  //IN038787
	// Set to the bean
	bean.setOrderCategoryValue(order_category);
	bean.setOrderTypeValue(order_type);
	int i = 0;
%>

	 <html>
	 <head><title><fmt:message key="eOR.SearchForOrderingPractitioner.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
  	<script language="Javascript" src="../../eCommon/js/common.js"></script>
  	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
  	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
  	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  	<STYLE TYPE="text/css">	</STYLE>
   	<script>
		var rows_cnt=0;
		var cell_cnt=0;

		function rowCountChange(obj)
		{
			rows_cnt=obj.rowIndex;
		}

		function changeColor(obj) //changes by Anbarasi
		{
			cell_cnt=obj.cellIndex;
			console.log(cell_cnt);
			 var table = document.getElementById("tab");
			for (var t1 = 0; t1 < table.rows.length; t1++) {
				var row = table.rows[t1];

					// Loop through the cells of the current row
			for (var t2 = 0; t2 < row.cells.length; t2++) {
				var cell = row.cells[t2];
					 if (cell && cell.innerText.trim() !== '') 
					 {
                cell.className = "CAFIRSTSELECTHORZ"; // Apply class
						}
				}
			}
			//obj.className="CAFIRSTSELECTHORZ"//IN043253
			obj.className="CAHIGHERLEVELCOLOR"//IN043253
		}

		function selectCell()
		{
			if(document.getElementById("tab").rows[0])
			{
				if(document.getElementById("tab").rows[0].cells[0])
					//document.getElementById("tab").rows(0).cells(0).className="CAFIRSTSELECTHORZ"//IN043253
					document.getElementById("tab").rows[0].cells[0].className="CAHIGHERLEVELCOLOR"//IN043253
			}
		}
	</script>
	</head>
	<body onLoad='selectCell()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='sectionForm' id='sectionForm'>
	<table border='0' cellpadding='3' cellspacing='0' width='99.9%' id='tab' align="center">
<%
	try
	{
		ArrayList SectionDisplay = bean.getSectionPopulate(order_category,tick_sheet_id,order_type);

		for(int j=0; j<SectionDisplay.size(); j++)
		{
			String[] record = (String[])SectionDisplay.get(i);

			if(i == 0)
			{
%>					
				<tr width="100%" onClick="rowCountChange(this)">
					<td width="19%" class="CAFIRSTSELECTHORZ" nowrap  onClick="changeColor(this)"><!-- IN043253 -->
						<script>
							//IN038787 Start.
							//parent.criteriaTickSheetsFrame.location.href="../../eOR/jsp/OrderEntryTickSheetPanels.jsp?order_type=<%=order_type%>&order_category=<%=order_category%>&activity_type=<%=activity_type%>&tick_sheet_id=<%=tick_sheet_id%>&section_code=<%=record[0]%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>&priv_applicability_yn=<%=priv_applicability_yn%>&function_from=<%=function_from%>"; 
							parent.criteriaTickSheetsFrame.location.href="../../eOR/jsp/OrderEntryTickSheetPanels.jsp?order_type=<%=order_type%>&order_category=<%=order_category%>&activity_type=<%=activity_type%>&tick_sheet_id=<%=tick_sheet_id%>&section_code=<%=record[0]%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>&priv_applicability_yn=<%=priv_applicability_yn%>&function_from=<%=function_from%>&order_dispaly_verticalYN=<%=order_dispaly_verticalYN%>"; 
							//IN038787 End.
						</script>
<%
			} 
			else 
			{  
%>
				<td  width="19%" class="CAFIRSTSELECTHORZ" nowrap  onClick="changeColor(this)"><!-- IN043253 -->
<%						
			}							
%>
			
			<a CLASS="HIGHERLEVELLINK"  style='color:white;cursor:pointer;height:20px;' href='javascript:populateTickSheets("<%=order_type%>","<%=order_category%>","<%=tick_sheet_id%>","<%=record[0]%>","<%=bean_id%>","<%=bean_name%>","<%=activity_type%>","<%=priv_applicability_yn%>","<%=function_from%>","<%=order_dispaly_verticalYN%>");'><%=record[1]%></a> </td>
<%
			i++;
			if( i %5 == 0)
			{
				out.print( "</td></tr> <tr width='100%' onClick=\"rowCountChange(this)\">" ); //rowChange
			}
		} // End of For

		if( i % 5 > 0)
		{
			for (int u=0;u<5-i%5;u++)
				out.println("<td width='19%' class=\"white\" align=\"left\">&nbsp;&nbsp;</td>");
		}

		if(SectionDisplay.size()==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script> ");
		}

%>
		</tr>
		<script>
			//IN047581 added else if condition for <10 >5 condition
			if(<%=SectionDisplay.size()%> >= 10) //Changed IN043253.1
			{
				//IN043253 - Start
				parent.document.getElementById("OrderEntryFrameset").rows = "19%,10%,*"; //IN047581.1
				
				//parent.document.getElementById("OrderEntryFrameset").rows = "19%,9%,*";
				//IN043253 - End
			}
			else if(<%=SectionDisplay.size()%> < 10 &&  <%=SectionDisplay.size()%> > 5)
			{
				parent.document.getElementById("OrderEntryFrameset").rows = "19%,11%,*";
			}else
			//	parent.document.getElementById("OrderEntryFrameset").rows = "19%,5.5%,*";
		parent.document.getElementById("criteriaMainFrame").style.height="17vh";
		parent.document.getElementById("criteriaDetailFrame").style.height="6vh";
		parent.document.getElementById("criteriaTickSheetsFrame").style.height="74vh";


		</script>
<%
	} catch(Exception e)
	{
		//out.println("Exception Section"+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
%>
	</table>
	</form>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
	<input type="hidden" name="order_dispaly_verticalYN" id="order_dispaly_verticalYN" value="<%=order_dispaly_verticalYN%>"> <!--  IN038787  -->
	</body>	
</html>

<%
	// set it back persistence, few set Methods have been used, to set the value in the bean
	putObjectInBean(bean_id,bean,request);

%>

