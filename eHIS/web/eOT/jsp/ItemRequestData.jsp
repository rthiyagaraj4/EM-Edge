<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.PkgDefBean, eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params		= request.getQueryString() ;
%>
 
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src='../js/PkgDef.js'></script> 
		<script type='text/javascript' src='../../eOT/js/ManageQuery.js'></script>
		<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eOT/js/ItemDetails.js"></script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		var headTop = -1;
		var FloatHead1;
//		alert(location.href);
		function processScroll()
		{
			if (headTop < 0)
			{
				saveHeadPos();
			}
			if (headTop>0)
			{
				if (document.documentElement && document.documentElement.scrollTop)
					theTop = document.documentElement.scrollTop;
				else if (document.body)
					theTop = document.body.scrollTop;
				if (theTop>headTop)
					FloatHead1.style.top = (theTop-headTop) + 'px';
				else
					FloatHead1.style.top = '0px';
			}
		}

		function saveHeadPos()
		{
			parTable = document.getElementById("divHeadSep");
			if (parTable != null)
			{
				headTop = parTable.offsetTop + 3;
				FloatHead1 = document.getElementById("heading");
				FloatHead1.style.position = "relative";
			}
		}
		</script>
	</head>
	<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
	</style>
	<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="" onSelect="codeArrestThruSelect();">
		<form name='itemDetails' id='itemDetails' action='../../servlet/eOT.ItemDetailsServlet' method="post" target="messageFrame" id="itemDetailsForm">	

			<input class="oldbtn"  type="button" value="Add" onclick='javascript:addRow()'/>
			<input type="button" class="button" name="print_item_dtl" id="print_item_dtl"  value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>'  onClick="printItemDetails()">

			<table  class="crstaffgrid"  border="1" cellspacing="0" id='ItemTable' width="100%" >
				<th><fmt:message key="eOT.ItemDesc.label" bundle="${ot_labels}"/></th>
				<th><fmt:message key="eOT.Qty.Label" bundle="${ot_labels}"/></th>
				<th><fmt:message key="eOT.RequestedDate.label" bundle="${ot_labels}"/></th>
				<th><fmt:message key="eOT.Cancel.label" bundle="${ot_labels}"/></th>
				<th><fmt:message key="eOT.CancelledRemarks.Label" bundle="${ot_labels}"/></th>
				<th><fmt:message key="eOT.ItemSpecRem.label" bundle="${ot_labels}"/></th>

<% 
				String strSysDate = "";
				Connection con=null;
				PreparedStatement pstmt1=null;
				ResultSet rs1=null;
				try
				{
					String locale			 = (String)session.getAttribute("LOCALE");
					String facilityId		 = (String) session.getValue( "facility_id" ) ;
					String orderId		     = request.getParameter( "orderid" ) ;
					String bookingNum		 = request.getParameter( "booking_no" );
					String bookingDate		 = request.getParameter("booking_date");
					System.err.println("bookingDate "+bookingDate);
					String strToDate="";
					String strItemDesc="";
					int  totRec = 1;
					int recordCount = 1;
					con = ConnectionManager.getConnection(request);
					strSysDate = com.ehis.util.DateUtils.getCurrentDate("dd/mm/yyyy", locale);
					String item_code="", qty="",reqDate="",canStat="",canRem="",itemSpec="",item_desc="";
					StringBuffer sqlselect = new StringBuffer();
					sqlselect.append("	SELECT mit.item_code, mit.quantity, mi.short_desc shortdesc,		");
					sqlselect.append("	TO_CHAR (mit.requested_date, 'dd/mm/yyyy') reqdate, mit.cancel_status,		");
					sqlselect.append("	mit.cancel_remarks, mit.item_spec_remarks		");
					sqlselect.append("	FROM ot_manage_item_request mit, mm_item mi		");
					sqlselect.append("	WHERE mit.booking_num = ? AND mit.item_code = mi.item_code		");

					pstmt1 = con.prepareStatement(sqlselect.toString());
					System.out.println("===bookingNum=="+bookingNum);
					pstmt1.setString(1,bookingNum);
					rs1 = pstmt1.executeQuery();
%>
					<tr>
						<td class="alignimgtext">
							<input type='hidden' name='mode_0' id='mode_0' id='mode_0' value="A">
							<input type='hidden' name='itemCode_0' id='itemCode_0' value = ''>
							<input class="brdclr"class="brdclr" type="text" name='itemDesc_0' id='itemDesc_0' size='12' onBlur="if(this.value!='') searchItem(itemDesc_0, 0); else searchItem('', 0);checkItemDescExist('0');"/>
							<input type='button' class='button' value='?' name='ItemLookUp_0' id='ItemLookUp_0' onClick="searchItem(itemDesc_0, 0);checkItemDescExist('0');" /> 
							<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
<%
						if(rs1.isBeforeFirst())
						{
%>
							<td class="alignimgtext">
								<input type='text' name='itemQuantity_0' id='itemQuantity_0'  size='20' onblur='checkNum(0);' maxlength='5'>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td>
								<input class="brdclr" type='text' name='requestedDate_0' id='requestedDate_0' size='11' maxlength='10' onblur='checkDateFormat(this)' >
								<img src="../../eCommon/images/CommonCalendar.gif" Onblur="checkDate('0')" 
								onClick="return showCalendar('requestedDate_0','dd/mm/y');">
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
<%
						}
						else
						{
%>
							<td class="alignimgtext">
								<input type='text' name='itemQuantity_0' id='itemQuantity_0'  size='20' value="1" onblur='checkNum(0);' maxlength='5'> 
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td>
								<input class="brdclr" type='text' name='requestedDate_0' id='requestedDate_0' size='11' value='<%=strSysDate%>' maxlength='10' onblur='checkDateFormat(this)' >
								<img src="../../eCommon/images/CommonCalendar.gif" Onblur="checkDate('0')" 
								onClick="return showCalendar('requestedDate_0','dd/mm/y');">
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
<%
						}
%>
						<td>
							<select name='cancel_0' id='cancel_0'>
								<option value="N">No</option>
								<option value="Y">Yes</option>
							</select>
							<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td>
							<input class="brdclr"class="brdclr" type="text" name='cancelledRemark_0' id='cancelledRemark_0' size='10' maxlength='150' onblur="isSpclChar('CR', 0)"/>	
						</td>
						<td class="alignimgtext">
							<input class="brdclr"class="brdclr" type="text" name='itemSpecRemark_0' id='itemSpecRemark_0' maxlength='150' size='10'  onblur="isSpclChar('IR', 0)"/>
						</td>
					</tr>
<%
					while(rs1.next())
					{
						item_code = CommonBean.checkForNull(rs1.getString("item_code"));
						qty = CommonBean.checkForNull(rs1.getString("quantity"));
						reqDate = com.ehis.util.DateUtils.convertDate(rs1.getString("reqdate"),"DMY","en",locale);
						canStat = CommonBean.checkForNull(rs1.getString("cancel_status"));
						canRem = CommonBean.checkForNull(rs1.getString("cancel_remarks"));
						itemSpec = CommonBean.checkForNull(rs1.getString("item_spec_remarks"));
						strItemDesc = CommonBean.checkForNull(rs1.getString("shortdesc"));
%>	
						<tr>
							<td class="alignimgtext">
								<input type='hidden' name='mode_<%=recordCount%>' id='mode_<%=recordCount%>' id='mode_<%=recordCount%>' value="I">
								<input type='hidden' name='itemCode_<%=recordCount%>' id='itemCode_<%=recordCount%>' value="<%=item_code%>">
								<input class="brdclr"class="brdclr" type="text" name='itemDesc_<%=recordCount%>' id='itemDesc_<%=recordCount%>' id='itemDesc_<%=recordCount%>' onchange="callMode(<%=recordCount%>);" value="<%=strItemDesc%>" size='12' onBlur="if(this.value!='') searchItem(itemDesc_<%=recordCount%>, <%=recordCount%>); else searchItem('', <%=recordCount%>);checkItemDescExist(<%=recordCount%>);"/>
								<input type='button' class='button' value='?' name='ItemLookUp_<%=recordCount%>' id='ItemLookUp_<%=recordCount%>' onClick="searchItem(itemDesc_<%=recordCount%>, <%=recordCount%>);checkItemDescExist(<%=recordCount%>);callMode(<%=recordCount%>);"/>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td class="alignimgtext">
								<input type='text' name='itemQuantity_<%=recordCount%>' id='itemQuantity_<%=recordCount%>'  size='20' value="<%=qty%>" onchange="callMode(<%=recordCount%>);"  onblur='checkNum(<%=recordCount%>);' maxlength='5'> 
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td>
								<input class="brdclr" type='text' name='requestedDate_<%=recordCount%>' id='requestedDate_<%=recordCount%>' size='11' value='<%=reqDate%>' maxlength='10' onblur='checkDateFormat(this)' onchange="callMode(<%=recordCount%>);" >
								<img src="../../eCommon/images/CommonCalendar.gif" Onblur="checkDate('<%=recordCount%>')" onClick="return showCalendar('requestedDate_<%=recordCount%>','dd/mm/y');callMode(<%=recordCount%>);">
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td>
								<select name='cancel_<%=recordCount%>' id='cancel_<%=recordCount%>' onchange="callMode(<%=recordCount%>);" >
<%
									if(canStat != null && canStat.equalsIgnoreCase("Y"))
									{
%>
										<option value="N">No</option>
										<option value="Y" selected>Yes</option>
<%
									}
									else
									{
%>
										<option value="N" selected>No</option>
										<option value="Y">Yes</option>
<%
									}
%>
								</select>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td>
								<input class="brdclr"class="brdclr" type="text" name='cancelledRemark_<%=recordCount%>' id='cancelledRemark_<%=recordCount%>' size='10' maxlength='150' value="<%=canRem%>" onchange="callMode(<%=recordCount%>);" onblur="isSpclChar('CR', <%=recordCount%>)" />	
							</td>
							<td class="alignimgtext">
								<input class="brdclr"class="brdclr" type="text" name='itemSpecRemark_<%=recordCount%>' id='itemSpecRemark_<%=recordCount%>' size='10' maxlength='150' value="<%=itemSpec%>" onchange="callMode(<%=recordCount%>);" onblur="isSpclChar('IR', <%=recordCount%>)"/>
							</td>
						</tr>
<%
						recordCount++;
					}
%>

					</table>

					<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
					<input type='hidden' name='totRec' id='totRec' value="<%=totRec%>" >
					<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityId%>">
					<input type='hidden' name='booking_no' id='booking_no' value="<%=bookingNum%>">
					<input type='hidden' name='orderid' id='orderid' value="<%=orderId%>">
					<input type='hidden' name='rowIndex' id='rowIndex' value = "">
					<input type='hidden' name='params' id='params' id='params' value = "<%=params%>"><!-- 20-Jan-14 -->
					<input type='hidden' name='booking_Date' id='booking_Date' value = "<%=bookingDate%>">	<!-- 20-Jan-14 -->
<%
					if(rs1!=null)
						rs1.close();
					if(pstmt1!=null)
						pstmt1.close();
					if(con!=null)
						ConnectionManager.returnConnection(con,request);
				}
				catch(Exception e)
				{
					System.out.println("Exception from Package Date :"+e);
					e.printStackTrace();
				}
%>
		</form>
	</body>
</html>

