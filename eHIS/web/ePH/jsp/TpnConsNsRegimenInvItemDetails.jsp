<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,eCommon.Common.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
  	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/TpnConsNsRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
//	getItemModifyData
/* Mandatory checks start */
	String mode				= request.getParameter( "mode" ) ;
	String conc_percent		= "";
	String bean_id = "TPNConsNSRegimenBean" ;
	String bean_name = "ePH.TPNConsNSRegimenBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	TPNConsNSRegimenBean bean = (TPNConsNSRegimenBean)getBeanObject( bean_id,bean_name,request) ;
	ArrayList arr_list_modify_data = new ArrayList();
	
	String const_generic_code	 = "";
	String item_code	 = "";
	//added for ml-mmoh-crf-1201 start
Connection connection				= null;
boolean site_moh=false;
		 try {
				connection						= ConnectionManager.getConnection(request);
		
				 site_moh=eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","APPLICABILITY_SETTINGS");
		 }
		 catch(Exception e) {
				out.print("Exception @ Result JSP :"+e.toString());
				e.printStackTrace();
			}
			finally{
				

				if(connection != null)
					ConnectionManager.returnConnection(connection,request);
			
			}
			//Added  for ml-mmoh-crf-1201 end
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		const_generic_code	 = request.getParameter( "const_generic_code" ) ;
		conc_percent		 = request.getParameter( "conc_percent" ) ;
		item_code			 = request.getParameter( "item_code" ) ;

		if(conc_percent.equals("null")){conc_percent="";}
		arr_list_modify_data = bean.getItemModifyData(const_generic_code,conc_percent,locale);
/*
	 ArrayList  osmol_val =	new ArrayList();
     osmol_val = bean.getOsmolarValue(item_code);
*/
	}

	bean.setLanguageId(locale);
%>
<form name="frmTpnConstNsRegimenInvItemDetails" id="frmTpnConstNsRegimenInvItemDetails">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="inv_item_details_table">
	<th colspan="7" align="left"><fmt:message key="ePH.InventoryItems.label" bundle="${ph_labels}"/></th>
	<tr>
		<%if(site_moh){ %>
		<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>/<fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
		<%}else {%>
		<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th> 
		<%} %>
		<th><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="ePH.Molecule.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.Osmolarity.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.mOsmol/L.label" bundle="${ph_labels}"/></th>
		<!-- Added for ML-MMOH-CRF-1201 start -->
		<%if(site_moh){ %>
		<th><fmt:message key="ePH.Concentration.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.volume.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="ePH.ApplicibilitySetting.label" bundle="${ph_labels}"/></th>
		<%}%>
		<!-- Added for ML-MMOH-CRF-1201  end-->
	</tr> 
	<%
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){			   
			String const_srl_no =""; 			 
//			String item_code ="";                
			String item_desc ="";    			 String stock_uom ="";                
			 String molecule_code =""; 
			String molecule_desc ="";			 String classvalue ="";
			String osmolar_value ="";
			String osmolar_desc ="";
			String volume        ="";//Added for ML-MMOH-CRF-1201
			String concentration ="";//Added for ML-MMOH-CRF-1201

			int recCount = 1;
			
			for (int i=0;i<arr_list_modify_data.size();i=i+9){//Changed t= 7 to 9 for ML-MMOH-CRF-1201
				
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
				recCount++;
				const_generic_code =(String)arr_list_modify_data.get(i);        
				//const_srl_no =(String)arr_list_modify_data.get(i+1);              
				item_code =(String)arr_list_modify_data.get(i+1);                 
				item_desc =(String)arr_list_modify_data.get(i+2);                                  	

				molecule_code =(String)arr_list_modify_data.get(i+3);
				molecule_desc = (String)arr_list_modify_data.get(i+4);
				if(molecule_desc==null){
					molecule_code ="";
					molecule_desc ="&nbsp;";
				}
				/*if(osmolar_value==null){
					osmolar_value ="&nbsp;";
					osmolar_desc ="&nbsp;";
				}*/

				stock_uom =(String)arr_list_modify_data.get(i+5);
				osmolar_value=(String)arr_list_modify_data.get(i+6);

				if(osmolar_value==null){
					osmolar_value ="";
				//	osmolar_desc ="&nbsp;";
				}
				concentration = (String)arr_list_modify_data.get(i+7)==null?"":(String)arr_list_modify_data.get(i+7);//Added for ML-MMOH-CRF-1201
				volume        = (String)arr_list_modify_data.get(i+8)==null?"":(String)arr_list_modify_data.get(i+8);//Added for ML-MMOH-CRF-1201

    %>
		<tr>
			<td class="<%=classvalue%>">
				<%if(site_moh){ %>
				
				<a href="javascript:loadDataForAmend(this,'<%=recCount-1%>')"><%=item_code%> / <%=item_desc%></a>
			
			<%}else {%>
			<a href="javascript:loadDataForAmend(this,'<%=recCount-1%>')"><%=item_code%></a>
				<%} %>
				<input type="hidden" name="const_srl_no<%=recCount-1%>" id="const_srl_no<%=recCount-1%>" value="<%=const_srl_no%>">
				<input type="hidden" name="item_code<%=recCount-1%>" id="item_code<%=recCount-1%>" value="<%=item_code%>">
				<input type="hidden" name="item_add<%=recCount-1%>" id="item_add<%=recCount-1%>" value="Y">
				<input type="hidden" name="item_desc<%=recCount-1%>" id="item_desc<%=recCount-1%>" value="<%=item_desc%>">
			</td>

			<td class="<%=classvalue%>" style="color:red"><input type="hidden" name="stock_uom_code<%=recCount-1%>" id="stock_uom_code<%=recCount-1%>" value="<%=stock_uom%>"><%=stock_uom%></td>
			<td class="<%=classvalue%>"><input type="hidden" name="molecule<%=recCount-1%>" id="molecule<%=recCount-1%>" value="<%=molecule_code%>"><%=molecule_desc%></td>
			<td class="<%=classvalue%>"><%=osmolar_value%></td>
			<input type="hidden" name="osmolar_value<%=recCount-1%>" id="osmolar_value<%=recCount-1%>" value="<%=osmolar_value%>" >
			<!-- Added for ML-MMOH-CRF-1201 start -->
			<%if(site_moh){ %>
			<td class="<%=classvalue%>"> &nbsp;<%=concentration%></td>
			<td class="<%=classvalue%>"> &nbsp;<%=volume%></td>
			<td class="<%=classvalue%>"><b><a href="javascript:applicibilitySettingmodeEdit(eval('frmTpnConstNsRegimenInvItemDetails.item_code'+<%=recCount-1%>))">Link</a></b></td>
			<%} %>
			<input type="hidden" name="item_concentration<%=recCount-1%>" id="item_concentration<%=recCount-1%>" value="<%=concentration%>">
			<input type="hidden" name="volume<%=recCount-1%>" id="volume<%=recCount-1%>" value="<%=volume%>">
			<!-- Added for ML-MMOH-CRF-1201  end-->
			
			 
		</tr>
	<%
			}
		}
	%>
</table>
	<input type="hidden" name="tot_no_of_rows" id="tot_no_of_rows" value="">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

