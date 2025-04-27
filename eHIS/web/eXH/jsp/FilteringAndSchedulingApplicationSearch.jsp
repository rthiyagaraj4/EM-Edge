<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import ="java.util.HashMap,java.util.List,eXH.*,eXH.XHSQLSet,java.util.TreeMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>



<%request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>    
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/jquery-3.6.3.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eXH/js/json2.js'></script>
<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>


<script Language="JavaScript">
//Added by prithivi for enotification requirement on 11/05/2016. these functions are used for filter out the details
	function searchFilterValues()
	{
		var filterGroupCode = document.forms[0].filterCodeValue.value;
		var filterLevelType = document.forms[0].filterLevelType.value;
		var filterLevelSubType= document.forms[0].filterLevelSubType.value;
		var filterLevelSubTypeDesc = document.forms[0].filterLevelSubTypeDesc.value;
		var filterLevelValue = document.forms[0].filterLevelValue.value;
		var searchFor = "QueryFilter";
		var queryString = "searchFor="+searchFor+"&Filter_group_code="+filterGroupCode+"&filter_level_type="+filterLevelType+"&filter_level_subtype="+filterLevelSubType+"&filter_level_subtype_desc="+filterLevelSubTypeDesc+"&filter_level_value="+filterLevelValue ;
		//alert("qry string value..."+queryString);
		parent.frames[3].location.href='../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?'+queryString+'&rule=R';
		parent.frames[4].location.href="../../eCommon/html/blank.html";
		parent.frames[5].location.href='../../eCommon/jsp/MstCodeError.jsp';  
	}

	function clearSearch()
	{	
		var filterGroupCode = document.forms[0].filterCodeValue.value;
		document.forms[0].filterLevelType.value="";
		document.forms[0].filterLevelSubType.value="";
        document.forms[0].filterLevelSubTypeDesc.value="";
        document.forms[0].filterLevelValue.value="";
		var queryString = "Filter_group_code="+filterGroupCode;
		//alert("qry string value..."+queryString);
		parent.frames[3].location.href='../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?'+queryString+'&rule=R';
		parent.frames[4].location.href="../../eCommon/html/blank.html";
		parent.frames[5].location.href='../../eCommon/jsp/MstCodeError.jsp';
	}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="FilterSearchForm" id="FilterSearchForm" target='' action=''>
<%
Connection conn = null;
ResultSet rset = null; 
PreparedStatement pstmt = null ;  

String button_width = "100";
	String button_height = "100";
	String button_label = "Read";
 
try  
 {
 if(conn==null) conn = ConnectionManager.getConnection();

	String Fileter_group_code=request.getParameter("Filter_group_code");
	String filterLevelTypeName="";
	String filterLevelSubtypeName="";
	String elementCodeName="";

	 

     if("ENOTIFYFIL".equals(Fileter_group_code))
	 {
	 // Added by prithivi for enotification requirement on 11/05/2016
	 HashMap<String, TreeMap> resultMap = null;
	 TreeMap tretype = new TreeMap();
	 TreeMap treelement = new TreeMap();


	 FilteringAndQuerySearch querySearchObj = new FilteringAndQuerySearch();

	 resultMap=querySearchObj.getSelectBoxValues(Fileter_group_code);
	  
	 tretype = resultMap.get("TreeType");
	 treelement = resultMap.get("TreeElement");

	request.setAttribute("tretype",tretype);
	request.setAttribute("treelement",treelement);

	 }
 
// Added by prithivi for enotification requirement on 11/05/2016
 String sql="select B.LEVEL_NUMBER,A.APPLICATION_ID,A.FACILITY_ID,A.EVENT_TYPE,A.MESSAGE_TYPE,A.PROTOCOL_LINK,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE  AND rownum = 1 and A.FILTER_GROUP_CODE='"+Fileter_group_code+"' ORDER BY 1";

 /*select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME ,A.FACILITY_ID,A.APPLICATION_ID, A.EVENT_TYPE, A.PROTOCOL_LINK from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='ENOTIFYFIL' ORDER BY 1*/


 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();

 while(rset.next())
 {
   filterLevelTypeName=rset.getString(10).toString().trim();
   filterLevelSubtypeName=rset.getString(11).toString().trim();
   elementCodeName=rset.getString(12).toString().trim();
   
  %>
<table cellspacing=0 cellpadding=3 width='100%' >
<tr>
<td>
<table cellspacing=0 cellpadding=3 width='100%' >
<tr>
<td class="label"><fmt:message key="Common.Application.label" bundle="${common_labels}"/>  
</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.EventType.label" bundle="${common_labels}"/>
</td>
</tr>
</table>
</td>
<td>
<table cellspacing=0 cellpadding=3 width='100%' >
<tr>
<td class="label"><B><%=rset.getString(2).toString().trim()%></B></td>
</tr>
<tr>
<td class="label"><B><%=rset.getString(4).toString().trim()%></B>
</td>
</tr>
</table>
</td>

<td>
<table cellspacing=0 cellpadding=3 width='100%' >
<tr>
<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/>
</td>
</tr>
</table>
</td>

<td>
<table cellspacing=0 cellpadding=3 width='100%' >
<tr>
<td class="label"><B><%=rset.getString(3).toString().trim()%></B></td>
</tr>
<tr>
<td class="label"><B><%=rset.getString(5).toString().trim()%></B>
</td>
</tr>
</table>
</td>

<td>
<table cellspacing=0 cellpadding=3 width='100%' >
<tr>
<td class="label"><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
<td class="label">
</td>
</tr>
</table>
</td>

<td>
<table cellspacing=0 cellpadding=3 width='100%' >
<tr>
<td class="label"><B><%=rset.getString(6).toString().trim()%></B></td>
</tr>
<tr>
<td class="label">
</td>
</tr>
</table>
</td>
	</tr>

</table>
<input type=hidden name="filterCodeValue" id="filterCodeValue" value='<%=Fileter_group_code %>' >
<%
 }
 
 //Added by prithivi for enotification requirement on 11/05/2016
 System.out.println("FilteringAndSchedulingApplicationSearch.jsp::::filter group code...."+Fileter_group_code);
              if("ENOTIFYFIL".equals(Fileter_group_code))
			 {
				%>
			   <table name=termSetSearchTable id=termSetSearchTable  cellspacing=0 cellpadding=8 width='100%' align=center border=0>
				  
				 <tr>
					<td class="label"><%=filterLevelTypeName%> </td>
					<td class="label" align="right">
					   <select name='filterLevelType' id='filterLevelType'  style="width:200"> 
							 <option value='' >---Select---</option>

							  <c:forEach items="${tretype}" var="subject1" >                  
								<option value="${subject1.key}">
									${subject1.value}
								</option>                    
							</c:forEach>	

					   </select>
					</td>						
					<td class="label" align="right"><%=filterLevelSubtypeName%> </td>
					<td class="label" align="right"><INPUT TYPE="text" name="filterLevelSubType" id="filterLevelSubType" > </td>
					<td class="label" align="right"> Description </td>
					<td class="label" align="right"><INPUT TYPE="text" name="filterLevelSubTypeDesc" id="filterLevelSubTypeDesc" > </td>
					<%
					if(elementCodeName!= null && elementCodeName.trim().indexOf("None")== -1)
					{
					%>
						<td class="label" align="right"><%=elementCodeName%></td>									
						<td class="label" align="center">
							  <select name='filterLevelValue' id='filterLevelValue' id='filterLevelValue' style="width:200"> 
							  <option value='' >---Select---</option>
							  <c:forEach items="${treelement}" var="subject2" >                  
										<option value="${subject2.key}">
											${subject2.value}
										</option>                    
									</c:forEach>	

							  </select>  					
						</td>

					<%
					 }
					%>
				</tr>
				<tr>
					<!--
					<td colspan=7 align=right> PayTM User Code <INPUT TYPE="text" name="PayTMCode" id="PayTMCode" > &nbsp;&nbsp;&nbsp;<INPUT TYPE="TEXT" name="paytmOtp" id="paytmOtp" ID="paytmOtp" SIZE="10" maxlength="10" style='text-align:left'>&nbsp;&nbsp;&nbsp;<INPUT TYPE="TEXT" name="paytmtrans" id="paytmtrans" ID="paytmtrans" SIZE="10" maxlength="10" style='text-align:left'></td>
					
					<td  colspan=6 align=right>
						<applet code="CardReaderApplet.class" name="CardReader"
							codebase="../CardReader/" archive="CardReaderApplet.jar" width="5"
							height="5">
							<PARAM name="button_width" value="<%=button_width%>" />
							<PARAM name="button_height" value="<%=button_height%>" />
							<PARAM name="button_label" value="<%=button_label%>" />						
							<param name="separate_jvm" value="true" />
							Sorry, Your browser does not support Java applet!
						</applet>
					</td>
					<td  align=right>
						<input class='button' type='button'  name='Capture Data' id='Capture Data' value='Capture Data' onClick="getCardData();"> 
					</td>
					-->

					<td align="center">
						<input class='button' type='button'  name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchFilterValues();"> 
						<input class='button' type='button'  name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearSearch();">
							
						<!--
						<input class='button' type='button'  name='pay' id='pay' value='PayTM' onClick='PayTMTrans("PayTM")'>
						<input class='button' type='button'  name='check' id='check' value='CheckStatus' onClick='PayTMTrans("CheckStatus")'>
						-->
						<!--<input class='button' type='button'  name='aadhaar' id='aadhaar' value='AADHAAR' onClick="AADHAAR()"> -->
						<!--
						<td colspan=7 align=right> <INPUT TYPE="text" name="Pancard" id="Pancard" id="Pancard"> </td>
						<input class='button' type='button'  name='Pancard' id='Pancard' value='Pancard' onClick="invokePanCardValidation()">
						<input class='button' type='button'  name='PHIS' id='PHIS' value='PHIS' onClick="PhisTransaction()"> 
						
						<input class='button' type='button'  name='MyHixDisplay' id='MyHixDisplay' value='MyHixDisplay' onClick="CheckMyHixDisplay()">
						-->
						
					</td>	
						
				</tr>
					<tr>
						<td colspan=7 align=right> </td>
						
					</tr>
			   </table> 
			<% 
			 }
	}
 catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of FilteringandschedulingApplicationLevel.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      } 
 finally
 {
	 if(conn != null) ConnectionManager.returnConnection(conn);
	 if(pstmt != null) pstmt.close();
	 if(rset != null) rset.close();
 }
 %>
<input type=hidden name="facility_id" id="facility_id" value='' >
 
</form>	
</BODY>
</HTML>

