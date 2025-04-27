<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	try{
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String	bean_id_1					=	"FormularyBillingGroupBean" ;
		String	bean_name_1					=	"ePH.FormularyBillingGroupBean";
		FormularyBillingGroupBean bean_1			= (FormularyBillingGroupBean)getBeanObject( bean_id_1, bean_name_1,request);
//		String called_from	= request.getParameter("called_from")==null?"":request.getParameter("called_from");
//		String generic_id = request.getParameter("generic_id");
		String form_name = "";
		String strength_value = "";
		String item_type	= "";
		//added for GHL-SCF-1548 - start
		String scrollTop = 	request.getParameter("scrollTop")==null?"0":request.getParameter("scrollTop");

		if(scrollTop.equals(""))
		scrollTop = "0";
		int scrollTopValue = Integer.parseInt(scrollTop);
		//added for GHL-SCF-1548 - end
		String strength_uom = "";
		String str_value = "";
//		String generic_name = request.getParameter("generic_name");
		HashMap itemList= bean_1.getSelectedGenericID();
		ArrayList genericItemType = bean_1.getItemGenericType();

		if(genericItemType!=null && genericItemType.size()>0){
			Collections.sort(genericItemType);
		}

		//System.err.println("itemList=dsdsdsds=>"+itemList+"==genericItemType===>"+genericItemType);
		  

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/FormularyMast.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<FORM name="FormularyDrugSearchResult" id="FormularyDrugSearchResult">
 <div class="drugresult">
 <TABLE CELLPADDING="0" CELLSPACING="0" height="100" WIDTH="100%" ALIGN="center" BORDER="1">

 <%
	String formulary_desc = bean_1.getFormularyDesc();
	boolean record_count_flag = false;
	ArrayList genericNameList = null;
	if(genericItemType!=null && genericItemType.size()>0){

		for(int i=0;i<genericItemType.size();i++){
			item_type = (String)genericItemType.get(i);
			genericNameList = null;
			if(item_type.equals("D")){
				genericNameList = bean_1.getGenericNameForDrug();
			}else{
				genericNameList = bean_1.getGenericNameForMedicalItem();
			}
			Collections.sort(genericNameList);
				
			if(genericNameList!=null && genericNameList.size()>0){
				record_count_flag = true;
			}
			formulary_desc = java.net.URLEncoder.encode(formulary_desc);
			for(int j=0;j<genericNameList.size();j++){
				ArrayList arr = (ArrayList)itemList.get((String)genericNameList.get(j));
 %>
        <tr id="formulary_drug_search_result_row">
	      <th class="COLUMNHEADER" width="35%" align="left"><a href="#" onclick="getSelectedItemList('<%=(String)genericNameList.get(j)%>','modify','<%=item_type%>','<%=formulary_desc%>');">
		  <%
		  //added for GHL-SCF-1533
	      if(item_type.equals("D")){
		 %>
		  <fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>
		  <%
			}else{ 
%> 
			<fmt:message key="ePH.TechnicalName.label" bundle="${ph_labels}"/> </label>
<%			}
		 %>
		  &nbsp; : <%=(String)genericNameList.get(j)%></a></th>
		  <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="ePH.form.label" bundle="${ph_labels}"/></b></th>
	      <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></b></th>
	      <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></b></th>
	      <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="ePH.PreferedItem.label" bundle="${ph_labels}"/></b></th>
		  <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/></b></th>

   		 </tr>
  
	    <tr>
   		 <th class="COLUMNHEADER" width="35%" align="left"><b>
		 <%
		  //added for GHL-SCF-1533
	      if(item_type.equals("D")){
		 %>
		 <fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>
		 <%}else{%>
		 <fmt:message key="ePH.NonDrugName.label" bundle="${ph_labels}"/>
		 <%}%>
		 </b></th>
	    </tr>
		
	    <%
			for(int k=0;k<arr.size();k=k+14){
		%>
	    <tr >
	    <td class="QRYODD" style="font-size:12;" width='18%' ><%=(String)arr.get(k+4)%></td>
	    <td class="QRYODD" style="font-size:12;" width='10%'><%=(String)arr.get(k+6)%>&nbsp;</td>
	    <td class="QRYODD" style="font-size:12;" width='10%'><%=(String)arr.get(k+7)%>&nbsp;</td>
	    <td class="QRYODD" style="font-size:12;" width='10%'><%=(String)arr.get(k+9)%>&nbsp;</td>
	    <td class="QRYODD" style="font-size:12;" width='18%'> 
		<%
		String preference_item = (String)arr.get(k+10);
		//System.err.println("preference_item===90===>"+preference_item);
		if(preference_item==null)
			preference_item="";

		if(preference_item.equals("P1")){
		%>
	   		<center><input type="button" value="Preference 1"></center>
		<%}else if(preference_item.equals("P2")){%>
			<center><input type="button" value="Preference 2"></center>
			<%}else if(preference_item.equals("P3")){%>
			<center><input type="button" value="Preference 3"></center>
	    <%}else{%> &nbsp;<%}%>
		</td>
	    <td class="QRYODD" style="font-size:12;" width='10%'><%=(String)arr.get(k+11)%>&nbsp;</td>
	    <td class="QRYODD" style="font-size:12;" width='16%'></td>
			
	  </tr> 
<%		   }
		}
	}
	}
	putObjectInBean(bean_id_1,bean_1,request);   
	%>
	<%
	if(genericNameList!=null && genericNameList.size()>0){
	%>
	<tr><td colspan="6" align="right">
	<input type="button" value="Print" onclick="viewFormularyBlngGrpItemDtls()"></td>
	</tr>
<script>
	if(parent.FormularyQuerySearchFrame.formulary_drug_search.billing_type){

		parent.FormularyQuerySearchFrame.formulary_drug_search.billing_type.disabled=true;
	}
</script>
	
<%	}else{
%>
<script>
	if(parent.FormularyQuerySearchFrame.formulary_drug_search.billing_type){
		
		parent.FormularyQuerySearchFrame.formulary_drug_search.billing_type.disabled=false;
	}
	</script>
	<%}
	
	%>
	<input type="hidden" name="record_count_flag" id="record_count_flag" value="<%=record_count_flag%>">
	
	</table>
	<script>
	document.body.scrollTop = "<%=scrollTopValue%>"
	</script>
		</form>
		
	</body>
	<%
	}catch(Exception e){
	 e.printStackTrace();
	}
	
	%>
</html>

