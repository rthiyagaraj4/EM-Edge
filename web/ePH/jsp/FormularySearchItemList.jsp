<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
	<style>

.billing
{
    overflow-y:auto;
	height: 100px;
	width: 250px;
}
.drugresult
{
    overflow-y:auto;
	height: 440px;
	width: 1320px;
}
.drugsearch
{

    overflow-y:auto;
	height: 170px;
	width: 1320px;
}
</style>

<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String facility_id					= (String) session.getValue("facility_id");

	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/FormularyMast.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.DrugSearch.label" bundle="${ph_labels}"/></title>
	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
	

<FORM name="formulary_item_search_list" id="formulary_item_search_list">

<% try{
	String	bean_id_1					=	"FormularyBillingGroupBean" ;
	String	bean_name_1					=	"ePH.FormularyBillingGroupBean";
	FormularyBillingGroupBean bean_1			= (FormularyBillingGroupBean)getBeanObject( bean_id_1, bean_name_1,request);
	String generic_id = request.getParameter("generic_id");
	String form_code = request.getParameter("form_code")==null?"":request.getParameter("form_code");
	String strength_value = request.getParameter("strength_value");
	String item_type	= request.getParameter("item_type");
	String strength_txt = request.getParameter("strength_txt");
	String form_name_txt = request.getParameter("form_name_txt")==null?"":request.getParameter("form_name_txt");
	String formulary_desc = request.getParameter("formulary_desc")==null?"":request.getParameter("formulary_desc");
	String formulary_blng_type = bean_1.getBillingType();
	if(formulary_blng_type==null)
		formulary_blng_type = "C";

	if(!formulary_desc.equals("")){
		bean_1.setFormularyDesc(formulary_desc);
	}
	
		
    String strength_uom = "";
	String str_value = "";
	
	String generic_name = request.getParameter("generic_name")==null?"":request.getParameter("generic_name");


		if(!form_name_txt.equals("")) //GHL-SCF-1548
	   form_name_txt		=   java.net.URLDecoder.decode(form_name_txt,"UTF-8");

		

	String generic_name_key= "";
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	//System.err.println("FormularySearchItemList.jsp==called_from==>"+called_from);
	if(!called_from.equals("modify")){
		if(item_type.equals("D"))
			generic_name_key = generic_name+"-"+form_name_txt+"-"+strength_txt;
		else
			generic_name_key = generic_name;
	}else{
		generic_name_key = request.getParameter("generic_name_key")==null?"":request.getParameter("generic_name_key");
	}
//System.err.println("FormularySearchItemList.jsp==generic_name_key==>"+generic_name_key);
	if(strength_value!=null && !strength_value.equals("")){
	 if(strength_value.indexOf("~") != -1){
		str_value =strength_value.split("~")[0]; 
		strength_uom = strength_value.split("~")[1];
	 }
	} 

	
//System.err.println("FormularySearchItemList.jsp=====69===strength_value==>"+strength_value+"form_code==>"+form_code+"==generic_id==>"+generic_id+"==str_value==>"+str_value+"==strength_uom==>"+strength_uom+"==item_type==>"+item_type+"called_from==>"+called_from);
	 ArrayList itemList   =  null;
	String disabled = "";
	HashMap hm = bean_1.getSelectedGenericID();
	 if(called_from.equals("modify") || (hm!=null && hm.size()>0 && hm.containsKey(generic_name_key))){
  		 
		 //System.err.println("hm============89===>"+hm);
		if(hm!=null && hm.size()>0){
			itemList = (ArrayList)hm.get(generic_name_key);
		}
		if(called_from.equals("")){
			itemList = (ArrayList)bean_1.getItemListForGenericName(item_type,generic_id,generic_name,form_code,str_value,strength_uom,itemList);
		}

	 }else{
		 itemList = (ArrayList)bean_1.getItemListForGenericName(item_type,generic_id,generic_name,form_code,str_value,strength_uom,itemList);
		 disabled = "disabled";

	 }
//System.err.println("FormularySearchItemList.jsp===>"+itemList);
%>
 <div class="drugresult">
 <TABLE CELLPADDING="0" CELLSPACING="0" height="100" WIDTH="100%" ALIGN="center" BORDER="1">
        <tr id="formulary_drug_search_result_row">
	      <th class="COLUMNHEADER" width='15%' align="left"><b>
		  
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
		  
		  &nbsp; : <%=generic_name_key%></b></th>
	      <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="ePH.form.label" bundle="${ph_labels}"/></b></th>
	      <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></b></th>
	      <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></b></th>
	      <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="ePH.PreferedItem.label" bundle="${ph_labels}"/></b></th>
		  <th rowspan="2" class="COLUMNHEADER" width="10%"><b><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/></b></th>
 

   		 </tr>
   
	    <tr>
		
   		 <th class="COLUMNHEADER" width='15%' align="left"><b>
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
	    <% int count = 1;
		 String selected_p1 = "";
		 String selected_p2 = "";
		 String selected_p3 = "";
		 String preference  = "";
			 if(itemList!=null && itemList.size()>0){
			 
				for(int i=0;i<itemList.size();i=i+14){
					
					//System.err.println("====itemList=130==>"+itemList);
					if(generic_id==null || generic_id.equals(""))
						generic_id= (String)itemList.get(i);
					if(generic_name==null || generic_name.equals(""))
						generic_name = (String)itemList.get(i+1);
					if(item_type.equals("D")){
						if(form_code==null || form_code.equals(""))
							form_code = (String)itemList.get(i+5);
					}
				 preference = (String)itemList.get(i+10)==null?"":(String)itemList.get(i+10);	
				 if(preference.equals("P1")){
					selected_p1 = "selected";
					selected_p2 = "";
					selected_p3 = "";
				 }
				 else if(preference.equals("P2")){
					 selected_p2 = "selected";
					 selected_p1 = "";
					 selected_p3 = "";
				 }
				 else if(preference.equals("P3")){
					 selected_p3 = "selected";
 					 selected_p1 = "";
					 selected_p2 = "";
				 }else{
					 selected_p3 = "";
 					 selected_p1 = "";
					 selected_p2 = "";
				 }
		//System.err.println("(String)itemList.get()=====>"+(String)itemList.get(i+10)+"=="+(String)itemList.get(i+11));


		%>
	    <tr >
	    <td class="QRYODD" style="font-size:12;" width='15%' ><%=(String)itemList.get(i+4)%></td>
	    <td class="QRYODD" style="font-size:12;" width='10%'><%=(String)itemList.get(i+6)%>&nbsp;</td>
	    <td class="QRYODD" style="font-size:12;" width='10%'><%=(String)itemList.get(i+7)%>&nbsp;</td>
	    <td class="QRYODD" style="font-size:12;" width='10%'><%=(String)itemList.get(i+9)%>&nbsp;</td>
	    <td class="QRYODD" style="font-size:12;" width='10%'> 
	    <select name="preference" id="preference" onchange="changePreference(this,'<%=count%>')">
		<option value="">-------select---------</option>
		<option value="P1" <%=selected_p1%>><fmt:message key="ePH.preference1.label" bundle="${ph_labels}"/></option>
		<%
		if(formulary_blng_type.equals("C")){
		%>
		<option value="P2" <%=selected_p2%>><fmt:message key="ePH.preference2.label" bundle="${ph_labels}"/></option>
		<option value="P3" <%=selected_p3%>><fmt:message key="ePH.preference3.label" bundle="${ph_labels}"/></option>
	    <%
		}
		%>
		</td>
		<td class="QRYODD" style="font-size:12;" width='10%'><%=(String)itemList.get(i+11)%>&nbsp;</td>

	  </tr> 
	  <input type="hidden" name="item_desc_<%=count%>" id="item_desc_<%=count%>" value="<%=(String)itemList.get(i+4)%>">
	   <input type="hidden" name="form_name_<%=count%>" id="form_name_<%=count%>" value="<%=(String)itemList.get(i+6)%>">
   	   <input type="hidden" name="strength_<%=count%>" id="strength_<%=count%>" value="<%=(String)itemList.get(i+12)%>">
	   
   	   <input type="hidden" name="strength_uom_<%=count%>" id="strength_uom_<%=count%>" value="<%=(String)itemList.get(i+13)%>">
	   <input type="hidden" name="strength_txt_<%=count%>" id="strength_txt_<%=count%>" value="<%=(String)itemList.get(i+7)%>">
	   
	   <input type="hidden" name="route_<%=count%>" id="route_<%=count%>" value="<%=(String)itemList.get(i+9)%>">
	    <input type="hidden" name="preference_item_<%=count%>" id="preference_item_<%=count%>" value="<%=preference%>">
	    <input type="hidden" name="item_code_<%=count%>" id="item_code_<%=count%>" value="<%=(String)itemList.get(i+3)%>">
		<input type="hidden" name="unit_price_<%=count%>" id="unit_price_<%=count%>" value="<%=(String)itemList.get(i+11)%>">
		<input type="hidden" name="route_code_<%=count%>" id="route_code_<%=count%>" value="<%=(String)itemList.get(i+8)%>">

  	 <%
		 
	count++;	 
	 }
		}
	 %> 
</div>
	<tr> <td></td><td></td><td></td><td></td><td></td>
	<td>
	<input type="hidden" name="total_rec" id="total_rec" value="<%=count%>">
		<input type="hidden" name="item_type" id="item_type" value="<%=item_type%>">
	<input type="hidden" name="generic_name_key" id="generic_name_key" value="<%=generic_name_key%>">
<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
	<input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onclick="save('<%=generic_id%>','<%=generic_name%>','A','<%=formulary_blng_type%>')">
	<input type="button" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' <%=disabled%> onclick="save('<%=generic_id%>','<%=generic_name%>','D')">
	<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.close()">
	 </td></tr> 	  
	   </TABLE>
	   
		</form>
<% }
catch(Exception e){
		   e.printStackTrace();
	   }%>
	</body>
</html>

