<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html> 
<head>
  <%
    request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../js/DrugItemLink.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" style="overflow-x:hidden;overflow-y:hidden">

<%! 
	int maxRec=0; 
	int count = 0;
%>
<%
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	String dispMode     = request.getParameter( "dispMode" ) ;
	if(dispMode==null) dispMode="";
	int start=0;
	int end  =0;	
	String from_code=request.getParameter("from_code");
	String to_code=request.getParameter("to_code");
	String criteria=request.getParameter("criteria");
	String max_rec=request.getParameter("max_rec");
	int displaySize = 0;
	String drug_yn_chk="";
	String formulary_yn_chk="";
	String link_dis="";
	String link_yn_chk	="";

    String mode			= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
    String bean_id		= "DrugItemLink" ;
    String bean_name	= "ePH.DrugItemLinkBean";
	String classvalue	="";

	DrugItemLinkBean bean = (DrugItemLinkBean)getBeanObject( bean_id,bean_name , request) ;
	bean.setLanguageId(locale);
	bean.clear();
	displaySize = Integer.parseInt( ((String)PhRepository.getPhKeyValue("DISPLAY_SIZE_MATCHING_RECORDS")) );

	ArrayList result=new ArrayList();
		
	try{
	if(dispMode.equals("")){
		count=0;
		int result_size=Integer.parseInt(max_rec);		
		result=bean.SearchItemCodeResult(from_code,to_code,criteria,result_size);
	}else{
		

		result=(ArrayList) bean.getResult();
	}
	maxRec=bean.getmaxCount();
	
	if ( from == null )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = displaySize;
	else
		end = Integer.parseInt( to ) ;

if(result.size()>0){
count=start;
 %>
<form name="drugitemlink_result" id="drugitemlink_result" >

	<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
	<tr width='10%'>
		<td class='WHITE'>
			<p>
			<%
	if ( !(start <= 0) ){
		out.println("<A HREF='javascript:goPrev();' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	if ( !( (start+displaySize) >= maxRec) ){
		out.println("<A HREF='javascript:goNext();' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
	%>	</p>
	    </td>
	</tr>
	</table>
	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="1" id="result">
		<tr>
			<th width="15%" ><fmt:message key="ePH.Item/DrugCodeoverhere.label" bundle="${ph_labels}"/></th>
			<th width="40%" ><fmt:message key="ePH.ItemDescription/DrugName.label" bundle="${ph_labels}"/></th>
			<th width="5%" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
			<th width="10%"><fmt:message key="ePH.Formulary.label" bundle="${ph_labels}"/></th>
			<th width="10%" ><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th>
			<%
			if(criteria!=null && ( criteria.equals("AS") || criteria.equals("NF") || criteria.equals("ND") ) ){
			%>
			<%
			}else{
			%>
			<th width="5%" ><fmt:message key="Common.Link.label" bundle="${common_labels}"/><input type="checkbox" name="head_link" id="head_link" onclick="chkAll(this);"></input></th>
			<%
			}
			%>
			<th width="25%" ><fmt:message key="ePH.ContentinPresBaseUOM.label" bundle="${ph_labels}"/></th>
			</tr>
			
<%
	for(int recCount=start; recCount<end; recCount++) {
		if(recCount<maxRec){
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
%>
			<tr>
		<%
			HashMap data=new HashMap();
				data=(HashMap) result.get(recCount);
				if(data.get("DRUG_YN")!=null && data.get("DRUG_YN").equals("Y")){
						drug_yn_chk="<img src='../../eCommon/images/enabled.gif'></img>";
					}else{
						drug_yn_chk="<img src='../../eCommon/images/disabled.gif'></img>";
					}
				
				if(data.get("IN_FORMULARY_YN")!=null && data.get("IN_FORMULARY_YN").equals("Y")){
						formulary_yn_chk="<img src='../../eCommon/images/enabled.gif'></img>";
						link_dis="";
					}else{
						formulary_yn_chk="<img src='../../eCommon/images/disabled.gif'></img>";
						link_dis="disabled";
					}
				
				if(data.get("LINK_YN")!=null && data.get("LINK_YN").equals("Y")){
						link_yn_chk="checked";
					}else{
						link_yn_chk="";
						
	 				}

			if(criteria!=null && ( criteria.equals("AS") || criteria.equals("NF") || criteria.equals("ND") ) ){
			link_dis="disabled";
			link_yn_chk="checked";
			}
				%>
				<td class="<%=classvalue%>" wrap><%=data.get("ITEM_CODE")%></td><input type="hidden" value="<%=data.get("ITEM_CODE")%>" name="item_code<%=recCount%>"><input type="hidden" value="<%=data.get("ITEM_DESC")%>" name="item_desc<%=recCount%>">
				<td class="<%=classvalue%>"  wrap><font color="#CC3300"><%=data.get("ITEM_DESC")%></font>&nbsp;/&nbsp;<font color="#6666CC"><%=data.get("DRUG_DESC")%></td>
				<td class="<%=classvalue%>" wrap><%=drug_yn_chk%></td>
				<td class="<%=classvalue%>" wrap><%=formulary_yn_chk%></td>
				<td class="<%=classvalue%>" wrap><%=data.get("STOCK_UOM_DESC")%></td>
				<%
				if(criteria!=null && ( criteria.equals("AS") || criteria.equals("NF") || criteria.equals("ND") ) ){
				}else{
				%>
				<td class="<%=classvalue%>" wrap><input type="checkbox" name="link_yn<%=recCount%>" id="link_yn<%=recCount%>" value="<%=data.get("LINK_YN")%>" <%=link_yn_chk%> <%=link_dis%> onclick="assignValue(this);"></input></td>
				<%
				}
				%>
				<td class="<%=classvalue%>" wrap><%=data.get("CONTENT_IN_PRES_BASE_UOM")%>&nbsp;<%=data.get("PRES_BASE_UOM_DESC")%><input type="hidden" name="head_link<%=recCount%>" id="head_link<%=recCount%>" value="<%=data.get("HEAD_LINK_YN")%>" ></input></td>
			</tr>
	<%
		count++;
			}
	}
	
	for(int i=start; i<end; i++) {
		if(i<maxRec){
			HashMap dataHash=new HashMap();
				dataHash=(HashMap) result.get(i);
				if(  ((String)dataHash.get("HEAD_LINK_YN")).equals("Y")){
	%>
		<script>document.drugitemlink_result.head_link.checked=true;</script>
	<%	
		break;	
		}
	  }
	}
	
	
	%>
	<table>
	<input type="hidden" value="<%=end%>" name="end">
	<input type="hidden" value="<%=start%>" name="start">
	<input type="hidden" value="<%=count%>" name="count">
	<input type="hidden" value="<%=maxRec%>" name="maxRec">
	<input type="hidden" value="<%=displaySize%>" name="displaysize">
	<input type="hidden" value="<%=bean_id%>" name="bean_id">
	<input type="hidden" value="<%=bean_name%>" name="bean_name">
	<input type="hidden" value="<%=mode%>" name="mode">
	<input type="hidden" value="<%=criteria%>" name="criteria">
	<input type="hidden" value="" name="form_modify" id="form_modify">
</form>
<%
	}else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	history.go(-1);</script>
<%
	}
	}catch(Exception es){
		out.println(es);
	}
%>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

