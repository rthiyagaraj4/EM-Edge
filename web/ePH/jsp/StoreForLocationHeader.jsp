<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
	
	String	bean_id			=	"@StoreForLocationBean" ;
	String	bean_name		=	"ePH.StoreForLocationBean";
	
	String facility_id=(String) session.getValue("facility_id") ;
	
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<script language="JavaScript" src="../js/StoreForLocation.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<!-- <body  > -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name='storeforlocationheaderform' id='storeforlocationheaderform' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<table border="0" align="left" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr >
					<td  width="20%" class='label'>       
					<fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
					</td>
					<td  width="60%"><input type='text' name='dispense_location' id='dispense_location' value=''
					size='60' maxlength='60' readonly>
					<input type="button" name="dispense_location_search" id="dispense_location_search" value="?" class="button" 
					 onfocus="dispenseLocationSearch(dispense_location);" onClick="dispenseLocationSearch(dispense_location);">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
					<input type='hidden' value='' name='disp_loc_code' id='disp_loc_code'>
					</td>
					</tr>
				 <tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
			<tr>

				<td  width="20%" class='label'>
				<fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				<input type='hidden'  name='store' id='store'>
			<td>	<label class='label' id="store_detail"  ></label></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
						<tr>
                   <td class="label" width="10%">
				   <fmt:message key="Common.locationtype.label" bundle="${common_labels}"/> &nbsp; </td>
				  
				  <td class="data" >
		<SELECT name="location_type" id="location_type" >
			<OPTION value="N" >   <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
			<OPTION value="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
				</SELECT>                 
</td>
				</tr>
<!-- <tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
 -->		<tr>
		<td  >&nbsp;</td>		
		<td class="label" align=right ><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' class='BUTTON' name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="popstoreforlocation(document.storeforlocationheaderform.dispense_location);"  name="storforlocation_search">
				</td>
			</tr>
			</table>
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
	
		</form>
	</body>
</html>

