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

    <script language="JavaScript" SRC="../js/DrugDetailsDisplay.js"></SCRIPT>
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
	String criteria=request.getParameter("criteria");
	int displaySize = 0;
	String formulary_yn_chk="";

    String bean_id		= "DrugItemLink" ;
    String bean_name	= "ePH.DrugItemLinkBean";
	String classvalue	="";
	DrugItemLinkBean bean = (DrugItemLinkBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale); 
	bean.clear();
	displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
	ArrayList result=new ArrayList();
	if ( from == null )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = displaySize;
	else
		end = Integer.parseInt( to ) ;
	try{
	if(dispMode.equals("")){
		count=0;
		maxRec=0;
		if(criteria!=null && criteria.equals("IT")){
			result=bean.SearchItemCodeResultMR_IT(start,end);
		}else if(criteria!=null && criteria.equals("DR")){
			result=bean.SearchItemCodeResultMR_DR(start,end);		
		}else if(criteria!=null && criteria.equals("BT")){
			result=bean.SearchItemCodeResultMR_BT(start,end);		
		}
		
	}else{
		if(criteria!=null && criteria.equals("IT")){
			result=bean.SearchItemCodeResultMR_IT(start,end);
		}else if(criteria!=null && criteria.equals("DR")){
			result=bean.SearchItemCodeResultMR_DR(start,end);		
		}else if(criteria!=null && criteria.equals("BT")){
			result=bean.SearchItemCodeResultMR_BT(start,end);		
		}	
	}
	maxRec=bean.getmaxCount();

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
		out.println("<A HREF='javascript:goPrevMR();' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"&nbsp;&nbsp;</A>");
	}
	if ( !( (start+displaySize) >= maxRec) ){
		out.println("<A HREF='javascript:goNextMR();' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
	%>	</p>
	    </td>
	</tr>
	</table>
	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="1" id="result">
		<tr>
		<%
		if(criteria!=null &&  criteria.equals("IT")){
		%>
		<th width="15%" ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
		<th width="40%" ><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
		<th width="5%" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
		<th width="10%" ><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th>
		<%
		}else if(criteria!=null && criteria.equals("BT")){
		%>
		<th width="1%" ></th>
		<th width="15%" ><fmt:message key="ePH.Item/DrugCodeoverhere.label" bundle="${ph_labels}"/></th>
		<th width="40%" ><fmt:message key="ePH.ItemDescription/DrugName.label" bundle="${ph_labels}"/></th>
		<th width="5%" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
		<th width="10%"><fmt:message key="ePH.Formulary.label" bundle="${ph_labels}"/></th>
		<th width="10%" ><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th>
		<th width="24%" ><fmt:message key="ePH.ContentinPresBaseUOM.label" bundle="${ph_labels}"/></th>
		<%
		}else if(criteria!=null && criteria.equals("DR")){
		%>
		<th width="1%" ></th>
		<th width="15%" ><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th>
		<th width="40%" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
		<th width="10%" ><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th>
		<th width="24%" ><fmt:message key="ePH.ContentinPresBaseUOM.label" bundle="${ph_labels}"/></th>
		<%
		}
		%>
	</tr>
			
<%
	for(int recCount=0; recCount<displaySize; recCount++) {
		if(count<maxRec){
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
%>
			<tr>
		<%
			HashMap data=new HashMap();
				data=(HashMap) result.get(recCount);
				
				%>
				
				<%
				if(criteria!=null && criteria.equals("IT")){
				String drug_yn=(String) data.get("DRUG_YN");
				if(drug_yn !=null && drug_yn.equals("Y")){
						drug_yn="<img src='../../eCommon/images/enabled.gif'></img>" ;
				}else{
						drug_yn="<Img src='../../eCommon/images/disabled.gif'></img>" ;
				}
				
				%>
				<td class="<%=classvalue%>" wrap><%=data.get("ITEM_CODE")%></td>
				<td class="<%=classvalue%>" wrap><font color="#660000"><%=data.get("ITEM_DESC")%></font></td>
				<td class="<%=classvalue%>" wrap><%=drug_yn%></td>
				<td class="<%=classvalue%>" wrap><%=data.get("STOCK_UOM_DESC")%></td>
				<%
				}else if(criteria!=null && criteria.equals("BT")){	
				
				String font_color="";
				String code_flag=(String) data.get("CODE_FLAG");
				if(code_flag!=null && code_flag.equals("D")) font_color="#6666CC";
				else if(code_flag!=null && code_flag.equals("I"))
				font_color="#CC3300";	
				
				String drug_yn=(String) data.get("DRUG_YN");
				if(drug_yn !=null && drug_yn.equals("Y")){
						drug_yn="<img src='../../eCommon/images/enabled.gif'></img>" ;
				}else{
						drug_yn="<img src='../../eCommon/images/disabled.gif'></img>" ;
				}

				if(code_flag!=null && code_flag.equals("D"))
				drug_yn="<img src='../../eCommon/images/enabled.gif'></img>" ;				
				if(data.get("IN_FORMULARY_YN")!=null && data.get("IN_FORMULARY_YN").equals("Y")){
						formulary_yn_chk="<img src='../../eCommon/images/enabled.gif'></img>";
				}else{
						formulary_yn_chk="<img src='../../eCommon/images/disabled.gif'></img>";
				}
				if(code_flag!=null && code_flag.equals("I"))
				formulary_yn_chk="&nbsp;" ;
				
				String content_base_uom=(String)data.get("CONTENT_IN_PRES_BASE_UOM");
				String pres_base_desc=(String)data.get("PRES_BASE_UOM_DESC");
				
				if(content_base_uom==null || (content_base_uom!=null && content_base_uom.equals("0")))
					content_base_uom="&nbsp;";
				if(pres_base_desc==null || (pres_base_desc!=null && pres_base_desc.equals("#")))
					pres_base_desc="&nbsp;";
				String stock_uom_desc=(String)data.get("STOCK_UOM_DESC");
				if(stock_uom_desc==null) stock_uom_desc="&nbsp;"; 
				
				if(code_flag!=null && code_flag.equals("D")){
				%>
				<td class="<%=classvalue%>" ><a href="javascript:loadPage('<%=(String)data.get("CODE")%>')">+</a></td>
				<%
				}else if(code_flag!=null && code_flag.equals("I")){
				%>
				<td class="<%=classvalue%>" >&nbsp;</td>
				<%
				}
				%>
				<td class="<%=classvalue%>" wrap><%=data.get("CODE")%></td>
				<td class="<%=classvalue%>" wrap><font color="<%=font_color%>"><%=data.get("DESC")%></font></td>
				<td class="<%=classvalue%>" wrap><%=drug_yn%></td>
				<td class="<%=classvalue%>" wrap><%=formulary_yn_chk%></td>
				<td class="<%=classvalue%>" wrap><%=stock_uom_desc%></td>
				<td class="<%=classvalue%>" wrap><%=content_base_uom%>&nbsp;<%=pres_base_desc%></td>
				<%
				}else if(criteria!=null && criteria.equals("DR")){	
				if(data.get("IN_FORMULARY_YN")!=null && data.get("IN_FORMULARY_YN").equals("Y")){
						formulary_yn_chk="<img src='../../eCommon/images/enabled.gif'></img>";
				}else{
						formulary_yn_chk="<img src='../../eCommon/images/disabled.gif'></img>";
				}
				String stock_uom=(String)data.get("STOCK_UOM_DESC");
				if(stock_uom==null || stock_uom.equals(""))
					stock_uom="&nbsp;";
				
				
				String content_base_uom=(String)data.get("CONTENT_IN_PRES_BASE_UOM");
				String pres_base_desc=(String)data.get("PRES_BASE_UOM_DESC");
				if(content_base_uom==null || (content_base_uom!=null && content_base_uom.equals("0")))
					content_base_uom="&nbsp;";
				if(pres_base_desc==null || (pres_base_desc!=null && pres_base_desc.equals("#")))
					pres_base_desc="&nbsp;";

				%>
				<td class="<%=classvalue%>" ><a href="javascript:loadPage('<%=(String)data.get("DRUG_CODE")%>')">+</a></td>
				<td class="<%=classvalue%>" wrap><%=data.get("DRUG_CODE")%></td>
				<td class="<%=classvalue%>"  wrap><font color="#660000"><%=data.get("DRUG_DESC")%></td>
				<td class="<%=classvalue%>" wrap><%=stock_uom%></td>
				<td class="<%=classvalue%>" wrap><%=content_base_uom%>&nbsp;<%=pres_base_desc%></td>
				<%
				}
				%>
				
			</tr>
	<%
		count++;
			}
	}
%>
	<table>
	<input type="hidden" value="<%=end%>" name="end">
	<input type="hidden" value="<%=start%>" name="start">
	<input type="hidden" value="<%=count%>" name="count">
	<input type="hidden" value="<%=maxRec%>" name="maxRec">
	<input type="hidden" value="<%=displaySize%>" name="displaysize">
	<input type="hidden" name="criteria" id="criteria" value="<%=criteria%>">
</form>
<%
	}else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%
	}
	}catch(Exception es){
		out.println(es);
	}
%>
</body>
</html>
 
<%
putObjectInBean(bean_id,bean,request);
%>

