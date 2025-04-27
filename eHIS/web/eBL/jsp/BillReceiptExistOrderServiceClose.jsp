<!DOCTYPE html>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String entGroupName = decodeParam(request.getParameter("entGroupName"));
	String entLineName = decodeParam(request.getParameter("entLineName"));
	String servClassName = decodeParam(request.getParameter("servClassName"));
	String service_class =	checkForNull(request.getParameter("serviceClass"));
	String ent_servGroup =	checkForNull(request.getParameter("entServGroup"));
	String ent_GrpLine =	checkForNull(request.getParameter("entGrpLine"));
	String locale 	= 	(String)session.getAttribute("LOCALE");
	String facilityId	=   (String) session.getValue( "facility_id" ) ;
	String noOfDecimal = checkForNull(request.getParameter("noOfDecimal"));
	String allow_service_selection_yn = checkForNull(request.getParameter("allow_service_selection_yn"));
	String adhoc_discount_allowed_yn = checkForNull(request.getParameter("adhoc_discount_allowed_yn"));
	String pkgClosedYn = checkForNull(request.getParameter("pkgClosedYn"));

	HashMap<String,String> blngServGroup = new HashMap<String,String>();
	PlaceOrderBC placeOrderBC = new PlaceOrderBC();
	blngServGroup = placeOrderBC.getBlngServGroup(locale);
	request.setAttribute("blngServGroup", blngServGroup);
%>

<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eBL/js/BLChargePatientServiceLookup.js'></script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	$(document).ready(function(){
		$('#orderDetails').hide();
		$('#closeBtn').click(function(){	
			//parent.window.returnValue = $('#hdnRefresh').val();
			//parent.window.close();
			var dialogTag = parent.parent.document.getElementById("dialog_tag");    
			dialogTag.close(); 
		})		
	});
</script>
</head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<body>
	<form name='frmServiceSearch' id='frmServiceSearch'>
	<table style="z-index: 150;" width="100%" CELLSPACING=0 cellpadding=3 align='center'>
	<tr>
		<td width='15%'  nowrap class='fields'>
			<span ><input type='button' id='excludeBtn' name='excludeBtn'  class='button' value='Save Discount & Exclude' onclick='excludeServices();'></span>
			<span style="padding-left: 10px;"><input type='button'name='closeBtn' id='closeBtn' class='button' value='Close'></span>
		</td>
		<td width='17%'  nowrap class='label'>
			<fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"></fmt:message>
		</td>
		<td width='17%' nowrap class='fields'>
			<Select style="width: 180px;" name='serviceCode' id='serviceCode' >
			<option value=''>-------<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />
					-------	</option>
				<c:forEach var="serv" items="${blngServGroup }">      						
					<option value="${serv.key }">${serv.value }</option>
				</c:forEach>
			</Select>
		</td>     		
     			
		<td class="label" width="14%">
			<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/>
		</td>	
		<td class="fields" width="15%">
			<INPUT TYPE="TEXT"  name="serv_class" id="serv_class"  SIZE="15"  MAXLENGTH='40' VALUE="<%=servClassName %>" onBlur="if(this.value != ''){ servClassLkup(this,document.forms[0].serv_class_code,'Y') } else{ clearCode(serv_class_code);}">
			<input type='button' class='button' name="servClass_but" id="servClass_but" value='?' onClick='servClassLkup(document.forms[0].serv_class,document.forms[0].serv_class_code)' >
			<input type= 'hidden' id='serv_class_code' name="serv_class_code" id="serv_class_code"  value="<%=service_class %>">
			
		</td>	
		<td colspan='2'>
			&nbsp;
		</td>
    </tr>
    <tr>			
		<td>
			&nbsp;
		</td>
		<td class="label" width="15%">
			<fmt:message key="eBL.EnterpriseServiceGroup.Label" bundle="${bl_labels}"/>
		</td>	
		<td class="fields" width="17%">
			<INPUT TYPE="TEXT"  name="ent_serv_grp" id="ent_serv_grp" SIZE="15"  MAXLENGTH='40' VALUE="<%=entGroupName %>" onBlur="if(this.value != ''){ entServGrpLkup(this,document.forms[0].entServ_Grp_code,'Y') } else{ clearCode(entServ_Grp_code);}">
			<input type='button' class='button' name="entServGrp_but" id="entServGrp_but" value='?' onClick='entServGrpLkup(document.forms[0].ent_serv_grp,document.forms[0].entServ_Grp_code)' >
			<input type= 'hidden' name="entServ_Grp_code" id="entServ_Grp_code"  id='entServ_Grp_code' value="<%=ent_servGroup%>">
		</td>	
		<td class="label" width="14%">
			<fmt:message key="eBL.EntGrpLine.label" bundle="${bl_labels}"/>
		</td>	
		<td class="fields" width="15%">
			<INPUT TYPE="TEXT"  name="ent_grp_line" id="ent_grp_line" SIZE="15"  MAXLENGTH='40' VALUE="<%=entLineName %>" onBlur="if(this.value != ''){ entGrpLineLkup(this,document.forms[0].entGrp_Line_code,'Y') } else{ clearCode(entGrp_Line_code);}">
			<input type='button' class='button' name="entGrpLine_but" id="entGrpLine_but" value='?' onClick='entGrpLineLkup(document.forms[0].ent_grp_line,document.forms[0].entGrp_Line_code)' >
			<input type= 'hidden' name="entGrp_Line_code" id="entGrp_Line_code" id='entGrp_Line_code' value="<%=ent_GrpLine%>">
		</td>	
		<td>
			<input type='button' class='button' name='srchBtn' id='srchBtn' value='Search' onclick='refreshBillService(1,50);'> 
			&nbsp;
			<input type='button' class='button' name='resetBtn' id='resetBtn' value='Reset' onclick='resetSearch();'>
		</td>
	</tr>    
	</table>
		<input type='hidden' name='locale' id='locale'  value="<%=locale%>" >
		<input type= 'hidden' name="facility_id" id="facility_id"  value="<%=facilityId %>">
		<input type='hidden' name='noOfDecimal' id='noOfDecimal'  value='<%=noOfDecimal %>'>
		<input type='hidden' name='allow_service_selection_yn' id='allow_service_selection_yn' value='<%=allow_service_selection_yn %>'>
		<input type='hidden' name='adhoc_discount_allowed_yn'id='adhoc_discount_allowed_yn' value='<%=adhoc_discount_allowed_yn %>'>
		<input type='hidden' name='hdnRefresh' id='hdnRefresh'  value='N'>
		<input type='hidden' name='hdnDiscRefresh' id='hdnDiscRefresh'  value='N'>
		<input type='hidden' name='pkgClosedYn' id='pkgClosedYn'  value='<%=pkgClosedYn %>'>
	</form>		
		<!-- <span  style="padding-left: 25px;">
			<input type='button' id='closeBtn' name='closeBtn' id='closeBtn' class='button' value='Close'>
		</span> -->
</body>
<%!	
	private String checkForNull(String input)
	{
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	private String decodeParam(String input){
		try{
		if(input == null || "null".equals(input)){
				input = "";
			}
			else{
				input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
				input = input.replaceAll("\\+", "%2B");
				input = URLDecoder.decode(input,"UTF-8");
			}
		}
		catch(Exception e){
			System.err.println("Exception while Decoding BillReceiptExisOrder->"+e);
			e.printStackTrace();
		}
		return input;
	}
%>
</html>

