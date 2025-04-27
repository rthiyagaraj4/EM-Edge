<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
<script language="JavaScript" src="../../eOT/js/PreOperative.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>

<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language='javascript'>
function assignItem( desc,code,flag){
	var frmObj=document.forms[0];  
	var descArr=new Array();
	var codeArr=new Array();
			
	desc=desc.replace("^","(");
	desc=desc.replace("!",")");
	desc=desc.replace("@","'");
	if(flag=='1'){
		selObj=frmObj.order_catagory;
		descArr=desc.split(",");
		codeArr=code.split(",");
		var len=0;
		len=selObj.length-2;
		for( var co=len;co>1;co--)
			selObj.remove(co);   
		for( len=1;len<codeArr.length;len++)
			selObj.options[len]=new Option(descArr[len-1],codeArr[len-1]);
	}else if(flag=='2'){
		selObj=frmObj.order_type_code;
		descArr=desc.split(",");
		codeArr=code.split(",");
		var len=0;
		len=selObj.length-2;
		for( var co=len;co>1;co--)
			selObj.remove(co);   
		for( len=1;len<codeArr.length;len++)
			selObj.options[len]=new Option(descArr[len-1],codeArr[len-1]);
	}
}
//Added for 23903 by AnithaJ on 9/21/2010
function clearCategory()
{
	//if(document.forms[0].order_type_code.value =='')
		document.forms[0].catalog.value="";
		document.forms[0].order_catalog_code.value="";

	//funPreOpeartiveSearch();
}

function callCommonServlet(fl,locale){
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	var objFrm =document.forms[0];
	var order_category = objFrm.order_catagory.value
	sql1="SELECT SHORT_DESC SHOR_DESC1, ORDER_TYPE_CODE ORDER_TYPE1	FROM OR_ORDER_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY IN ('RD','LB','PC','NC') ORDER BY 1";
	//alert(fl);
	var sql="";
	if(fl=='1')	
		//sql="SELECT SHORT_DESC SHOR_DESC1, ORDER_CATEGORY ORDER_TYPE1 FROM OR_ORDER_CATEGORY ORDER BY 1";
		sql = "SELECT SHORT_DESC SHOR_DESC1, ORDER_CATEGORY ORDER_TYPE1 FROM OR_ORDER_CATEGORY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY  IN ('RD','LB','PC','NC') ORDER BY 1";	
	else if(fl=='2'){
		sql="SELECT SHORT_DESC SHOR_DESC1, ORDER_TYPE_CODE ORDER_TYPE1 	FROM OR_ORDER_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY ='"+order_category+"'";
		sql1="SELECT SHORT_DESC SHOR_DESC1, ORDER_TYPE_CODE ORDER_TYPE1 	FROM OR_ORDER_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY IN ('RD','LB','PC','NC') ORDER BY 1";
		sql = (order_category=="*A")?sql1:sql;
		
	}else
		sql="SELECT SHORT_DESC SHOR_DESC1, ORDER_CATALOG_CODE ORDER_CATALOG_CODE1 FROM OR_ORDER_CATALOG WHERE ORDER_CATEGORY = '"+objFrm.order_catagory.value+"' AND ORDER_TYPE_CODE = NVL('"+objFrm.order_type_code.value+"', ORDER_TYPE_CODE) AND NVL(EFF_STATUS) = 'E'";
	var param="sql="+sql+"&flag="+fl;
	//alert(sql);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param, false);
	xmlHttp.send(xmlDoc);
	var resTxt=""+xmlHttp.responseText;
	//alert(resTxt);
	eval(resTxt);
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body  onLoad="callCommonServlet('1','<%=locale%>');callCommonServlet('2','<%=locale%>');" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
String facilityid=(String)session.getValue("facility_id");
String strFromSysDate="";
String strPatientId="";
String strBookingNo="";

strPatientId=CommonBean.checkForNull(request.getParameter("patient_id"));

//eOT.LogFile.log("OTDebugger","patient id"+strPatientId,this);

strBookingNo=CommonBean.checkForNull(request.getParameter("booking_no"));
//eOT.LogFile.log("OTDebugger","strBookingNo"+strBookingNo,this);
		Connection conn=null;
		//rrayList list = new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet rs=null;		
		conn = ConnectionManager.getConnection(request);
		try
		{ 

String sql="SELECT TO_CHAR(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy') ADM_DATE1 FROM  PR_ENCOUNTER A,OT_BOOKING_HDR B WHERE A.PATIENT_ID = ? AND   B.OPERATING_FACILITY_ID = ? AND A.ENCOUNTER_ID=B.ENCOUNTER_ID AND B.OPERATING_FACILITY_ID= A.FACILITY_ID AND B.BOOKING_NUM=?";

//String SQL1 = "SELECT SHORT_DESC SHORT_DESC1, ORDER_TYPE_CODE ORDER_TYPE1 	FROM OR_ORDER_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY IN  ('RD','LB','PC','NC') ORDER BY 1";

	pstmt=conn.prepareCall(sql);

	pstmt.setString(1,strPatientId);
	pstmt.setString(2,facilityid);
	pstmt.setString(3,strBookingNo);		

	rs=pstmt.executeQuery();

		if(rs!=null &&rs.next()==true)
		{
			//strFromSysDate=rs.getString("ADM_DATE1");
			strFromSysDate=com.ehis.util.DateUtils.convertDate(rs.getString("ADM_DATE1"),"DMY","en",locale);
			
		}
		if(rs!=null)		rs.close();
		pstmt.close();

		}catch(Exception ee)
		{
			ee.printStackTrace();
		////eOT.LogFile.log("OTDebugger","Exception  "+ee,this);
		}

		finally
		{
if(rs!=null) rs.close();	
pstmt.close();
ConnectionManager.returnConnection(conn,request);

		}
%>

<form name="PreOperativeSearchForm" id="PreOperativeSearchForm" >
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
<tr>

	<td width="25%" class="label" >
	<fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>
	</td>
	<td  width="25%" class='fields'   >
	<select name="order_catagory" id="order_catagory" onChange="callCommonServlet('2','<%=locale%>')">
	<option value='*A'>
	<fmt:message key="eOT.AllCategories.Label" bundle="${ot_labels}"/></option>
	</select>
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>

	<td  width="25%" class="label"   >
	<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td width="25%"  class='fields'>
	<select name="order_type_code" id="order_type_code" onChange="clearCategory();">
	<option value=''>
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
	</select>
	</td>
	</tr>

	<tr>
	<td  width="25%" class="label"   >
	<fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td  width="25%" class="fields">
	<input type="text" name="from_date" id="from_date" size="10" maxlength=10 value="<%=strFromSysDate%>" Onblur="javascript:isValidDate(this);">
	<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('from_date');" Onblur="javascript:isValidDate(this);">
	</td>
	<td width="25%" class="label">
	<fmt:message key="Common.todate.label" bundle="${common_labels}"/>
	 </td>
	<td width="25%" class="fields">
		<input type="text" name="to_date" id="to_date" size="10" maxlength=10 value="" Onblur="javascript:isValidDate(this);" >
	<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('to_date');" Onblur="javascript:isValidDate(this);">
    </td>
	
</tr>

<tr>
<td width="25%" class="label"   >
	<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields">
	<input type='text' name='orderid' id='orderid' maxlength='15' size='15' value= "" >
	</td>
<td class="label" width="25%" >
<fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
<td  align="left">
<select name='status' id='status' >
<option value='A'>
<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<option value='P'>
<fmt:message key="Common.PendingforReviews.label" bundle="${common_labels}"/> </option>
<option value='O'>
<fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option>
<option value='V'>
<fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
<option value='C'>
<fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
</select>			
<img src='../../eCommon/images/mandatory.gif'></img>
</td></tr>

<tr>

<td width="25%" class="label"  >
<fmt:message key="Common.catalog.label" bundle="${common_labels}"/>
</td>
<td  width="25%" class="fields"colspan="2" >
<input type='text' name='catalog' id='catalog' maxlength='100' size='40' value= ""  readonly>
<input type='button' class='button' value='?' name='catalogbut' id='catalogbut' onClick="funOTCheckDetail1('Catalog','','<%=locale%>');" >
</td>
<td width="25%"  >
<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="funPreOpeartiveSearch()">
<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' 	onClick="clearAllValue();">
</td>
</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->


<input type='hidden' name='order_catalog_code' id='order_catalog_code' value=''>
<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityid%>">
<input type='hidden' name='patient_id' id='patient_id' value="<%=strPatientId%>">
<input type='hidden' name='booking_no' id='booking_no' value="<%=strBookingNo%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='strFromSysDate' id='strFromSysDate' value="<%=strFromSysDate%>">
</form>
<script>funPreOpeartiveSearch();</script>
</body>
</html>

