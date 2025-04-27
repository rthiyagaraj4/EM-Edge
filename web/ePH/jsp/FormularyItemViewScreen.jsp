<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.lang.*, ePH.*, ePH.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
<%
	try{
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String	bean_id_1					=	"FormularyBillingGroupBean" ;
	String	bean_name_1					=	"ePH.FormularyBillingGroupBean";
	FormularyBillingGroupBean bean_1			= (FormularyBillingGroupBean)getBeanObject( bean_id_1, bean_name_1,request);
	String sysdate = bean_1.getSysdate();
	ArrayList selected_blg_grp= bean_1.getselectedFormularyBLGId();
	
	String selected_blg_grp_desc= "";
	String blng_grp_id_list = "";
	String blg_grp_desc = "";
	if(selected_blg_grp!=null && selected_blg_grp.size()>0){

		for(int i=0;i<selected_blg_grp.size();i++){
			blg_grp_desc = bean_1.getselectedFormularyBLGIdDesc((String)selected_blg_grp.get(i));	
			
			if(blg_grp_desc==null)
				blg_grp_desc="";
			if(i==0 || i==(selected_blg_grp.size()-1)){
				if(i==0){
					selected_blg_grp_desc = blg_grp_desc;
				}else{
					if(!blg_grp_desc.equals(""))
					selected_blg_grp_desc = selected_blg_grp_desc+","+blg_grp_desc;
				}
			}else{
				if(!blg_grp_desc.equals(""))
				selected_blg_grp_desc = selected_blg_grp_desc+","+blg_grp_desc;
			}
		}
		//System.err.println("blng_grp_id_list===>"+blng_grp_id_list);
		
	}
String formulary_type = bean_1.getBillingType();
	if(formulary_type==null)
		formulary_type = "C";
		HashMap itemList= bean_1.getSelectedGenericID();
		ArrayList genericItemType = bean_1.getItemGenericType();

		if(genericItemType!=null && genericItemType.size()>0){
			Collections.sort(genericItemType);
		}

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/FormularyMast.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<title><fmt:message key="ePH.FormularyDetReport.label" bundle="${ph_labels}"/></title>
</HEAD>
<body TOPMARGIN="0" onMouseDown="" onKeyDown="lockKey()">

<form name="Billing" id="Billing">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
	
	<tr>
	<th  colspan="6"class="QRYODD" align="left"><center><fmt:message key="ePH.FormularyDetReport.label" bundle="${ph_labels}"/></th></center></th></tr>
	<tr><th colspan="6"  class="QRYODD" align="left"><center><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th></center></th>
	</tr>
	
	<tr>
	<td class="QRYODD" width="1%"><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : <%=sysdate%></b></td>
	</tr>
	
	<tr>
	<td class="QRYODD" width="1%"><b><fmt:message key="ePH.FormularyDescription.label" bundle="${ph_labels}"/></b></td>
	<td class="QRYODD" width="1%"><%=bean_1.getFormularyDesc()%></td>
	 
	<td class="QRYODD"  width="1%"><b><fmt:message key="ePH.FormularyType.label" bundle="${ph_labels}"/>:</b></td>
	<%
	if(formulary_type.equals("C")){
	%>
	<td class="QRYODD"  width="1%"><fmt:message key="Common.Cash.label" bundle="${common_labels}"/></td>
	<%}else{%>
	<td class="QRYODD"  width="1%"><fmt:message key="Common.Credit.label" bundle="${common_labels}"/></td>
	<%}%>
	</tr>
	
	<tr>
    <td class="QRYODD" width="1%"><b><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></b></td>
    <td class="QRYODD" width="1%"><%=selected_blg_grp_desc==null?"":selected_blg_grp_desc%></td>
    </tr>

  </table>
  <br><br>
 <TABLE CELLPADDING="0" CELLSPACING="0" height="100" WIDTH="100%" ALIGN="center" BORDER="1">

 <%
	String item_type= "";
	if(genericItemType!=null && genericItemType.size()>0){
		//System.err.println("genericItemType.size()====50==>"+genericItemType.size());
		for(int i=0;i<genericItemType.size();i++){
			item_type = (String)genericItemType.get(i);
			ArrayList genericNameList = null;
			if(item_type.equals("D")){
				genericNameList = bean_1.getGenericNameForDrug();
			}else{
				genericNameList = bean_1.getGenericNameForMedicalItem();
			}
			Collections.sort(genericNameList);
			//System.err.println("genericNameList==========>"+genericNameList+"==genericNameList===>"+genericNameList.size());
			for(int j=0;j<genericNameList.size();j++){
				ArrayList arr = (ArrayList)itemList.get((String)genericNameList.get(j));
 %>
        <tr id="formulary_drug_search_result_row">
	      <th class="COLUMNHEADER" width="35%" align="left">
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
		  
		  
		  &nbsp; : <%=(String)genericNameList.get(j)%></th>
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
	   		<center><fmt:message key="ePH.preference1.label" bundle="${ph_labels}"/></center>
		<%}else if(preference_item.equals("P2")){%>
			<center><fmt:message key="ePH.preference2.label" bundle="${ph_labels}"/></center>
			<%}else if(preference_item.equals("P3")){%>
			<center><fmt:message key="ePH.preference3.label" bundle="${ph_labels}"/></center>
	    <%}else{%> &nbsp;<%}%>
		</td>
	    <td class="QRYODD" style="font-size:12;" width='10%'><%=(String)arr.get(k+11)%>&nbsp;</td>
	    <td class="QRYODD" style="font-size:12;" width='16%'></td>
			
	  </tr> 
<%		   }
		}
	}
	}	%>
    
    </table>
<%	putObjectInBean(bean_id_1,bean_1,request);
	}catch(Exception e){
		   e.printStackTrace();
	}
%>
</form>
</BODY>
</HTML>

