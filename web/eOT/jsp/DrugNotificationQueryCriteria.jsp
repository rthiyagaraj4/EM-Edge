<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	%>        
<% String mode = request.getParameter("mode"); 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>
<html>
<head>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>       
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/DrugNotification.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link type='text/css' rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' />
</head>
<!--<div name='one' id='one' style='position:absolute;left:80;top:5;width:80%;height:70%;' >-->

<% if(mode.equals("create")){ %>
		<form name="DrugNotificationQueryCriteriaForm" id="DrugNotificationQueryCriteriaForm"  onload='FocusFirstElement();parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;'  > 
		<table border=0 cellspacing=0 cellpadding=0 width='100%'  align=center>
		<tr>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'></td>

		</tr>
		<tr>
			<td class="label" width='25%'>Definition</td>
		<td width='25%'>
				<select name="lstdefinition_type" id="lstdefinition_type" onChange="emptyDtlCanvas()">
				<option value="D"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
				<option value="G"><fmt:message key="Common.generic.label" bundle="${common_labels}"/></option>
				</select>
		</td>
		<td width='25%'></td>
		<td width='25%'></td>
		</tr>
		<tr>
			<td width='25%'></td>
			<td width='25%'></td>
			<td width='25%'></td>
			<td width='25%'></td>
		</tr>
	<tr>
				<td width='25%'></td>
				<td width='25%'></td>
				<td width='25%'>
				<input type="button" class="button" name="btnSearch" id="btnSearch" onclick="callSearch();"
				value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' >
			</td >
			<td width='25%'></td>
</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->
<%}else{
		ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
		StringBuffer strbuff;
		String sortorder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
		String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
		String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
		String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		String drug =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Drug.label","common_labels");
		String notifyAtPreAnaesthesia =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.NotifyAtPreAnaesthesia.Label","ot_labels");
		String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String generic = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.generic.label","common_labels") ;
		String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		Connection con=null ;
		
			   ArrayList finAr = new ArrayList();
			   ArrayList firstItem = new ArrayList();
			   firstItem.add("List");           //Type of item
			   firstItem.add("Drug/Generic");     // label
			   firstItem.add("def_type");   //name of field
			   firstItem.add("S,"+select+",D,"+drug+",G,"+generic); 
			   finAr.add(firstItem);//add to ArrayList obj finAr

			   ArrayList secondItem = new ArrayList();
			   secondItem.add("Text");    //Type of item
			   secondItem.add("Drug Description");   // label
			   secondItem.add("drug_desc");   //name of field
			   secondItem.add("20"); // SIZE
			   secondItem.add("20"); // LENGTH
			   finAr.add(secondItem);//add to ArrayList obj finAr

			   ArrayList thirdItem = new ArrayList();
			   thirdItem.add("List");   //Type of item
               thirdItem.add(notifyAtPreAnaesthesia);  // label
			   thirdItem.add("status");//name
			   thirdItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
			   finAr.add(thirdItem);

				String[] orderByCols = new String[3];
				String[] orderByColVals = new String[3];
				
				orderByCols[0] = "Definiton Type";
				orderByColVals[0] = "DEFN_TYPE";

				orderByCols[1] = drug+" "+description;
			    orderByColVals[1] = "DRUG"; 
			    
				orderByCols[2] = notifyAtPreAnaesthesia; 
				orderByColVals[2] = "NOTIFY_PRE_ANESTHESIA_YN"; 
		
		try{
			   con  =  ConnectionManager.getConnection(request);
			strbuff = qrypg.getQueryPage( con,finAr,"Drugs for Notification","../../eOT/jsp/DrugNotificationModify.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
			//strbuff = qrypg.getQueryPage( con,finAr,"OperationTypes" ,"../../eOT/jsp/../../eOT/jsp/OperationTypesQueryResult.jsp",sortorder,queryCriteria,select,orderby,orderByCols,orderByColVals,executequery);
			out.println(strbuff.toString());
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Err Msg From DrugNotificationQueryCriteria.jsp"+e);
		}finally{
			firstItem.clear();
			secondItem.clear();
			thirdItem.clear();
			finAr.clear();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
}%>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>" >
 <input type="hidden" name="locale" id="locale" value="<%=locale%>" >
</form>
<!--</div>-->
</html>

