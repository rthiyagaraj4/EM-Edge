<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
05/10/2017	  	IN064474	     	Devindra 											GHL-CRF-0467 [IN064474] 
07/01/2019		IN068344		    Devindra				 		                    Required indication of different item types during dispense/order 
                                                                                        according to patient billing group.      
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, java.sql.*,ePH.Common.*,eCommon.Common.*" %>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../js/ConsumableOrder.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% 
		
		String item_desc = request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
		String item_code = request.getParameter("item_desc")==null?"":request.getParameter("item_code");
		String bean_id = request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
		String bean_name = request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
		String search_string	=	CommonBean.checkForNull(request.getParameter("search_string"),"");//9/11/09
		String item_class	=		CommonBean.checkForNull((String)request.getParameter("item_class"),"");//9/11/09
		//String consignment	=			CommonBean.checkForNull(request.getParameter("consignment"),"%");//9/11/09
		String store_name =  request.getParameter("store_name")==null?"":request.getParameter("store_name");
		String disp_locn_code =  request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");
		String CALL_FROM =  request.getParameter("CALL_FROM")==null?"":request.getParameter("CALL_FROM");
		if(item_class.equals("undefined"))
			item_class = ""; //9/11/09 


		String priority = request.getParameter("priority")==null?"":request.getParameter("priority");
		String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String bl_disp_charge_dtl_in_drug_lkp_yn = request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn");

		String bl_disp_price_type_in_drug_lkp = request.getParameter("bl_disp_price_type_in_drug_lkp")==null?"":request.getParameter("bl_disp_price_type_in_drug_lkp");
		String patient_class =	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//patient_class addded for GHL-CRF-0467
		String code="";	
		String desc="";

		ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
		bean.setSelectedItems();  //Added for the incident number 20275 for controlling duplicate items onlick of select button

		String patient_id 	=""; // Added for GHL-CRF-0467 - Start
		String encounter_id ="";
		patient_id		= bean.getPatientId(); ;
		encounter_id	= bean.getEncounterId() ;
		String	drug_bean_id		=	"@DrugSearchBean"+patient_id+encounter_id;
		String	drug_bean_name		=	"ePH.DrugSearchBean";		
		DrugSearchBean drug_bean		=	(DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ; 
		drug_bean.setPatientClass(patient_class); // Added for GHL-CRF-0467 - End
		boolean  Search									=			true;
	if(search_string!="")
		Search										=			true;
    else
		Search										=			false;
		ArrayList Item_Classlist=new ArrayList();
		ArrayList Manufacturer_List=new ArrayList();
		ArrayList Item_Analysis_List=new ArrayList();
		HashMap itemlistvalues=new HashMap();
		HashMap manufacturerlistvalues=new HashMap();
		HashMap itemanalysislistvalues=new HashMap();
		Item_Classlist=bean.getItemclassList();
		Manufacturer_List=bean.getManufacturerList();
		Item_Analysis_List=bean.getItemAnalysisList();
		//GHL-CRF-0467 starts
		String consider_stock					= 	"";
		String allow_pres_without_stock_yn		=	"";
		ArrayList stock_params	=	drug_bean.validateForStock();

		if(stock_params.size() > 1) {
			consider_stock					= (String)stock_params.get(0);
			allow_pres_without_stock_yn		= (String)stock_params.get(1);
		}

		String split_stock=consider_stock+"_"+allow_pres_without_stock_yn;

		//GHL-CRF-0467 ends

		

%>
		
		
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
	
		<form name="frm_consumableItemLkpCriteria" id="frm_consumableItemLkpCriteria">
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr><td colspan='4'>&nbsp;</td></tr>

				<tr><td colspan='1'>&nbsp;</td>

				<td class='LABEL'><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>&nbsp;&nbsp;
				&nbsp;&nbsp;<select name="p_Item_class" id="p_Item_class"style="width:150px">
				<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<% for(int i=0; i<Item_Classlist.size(); i++)
				{
					itemlistvalues = (HashMap)Item_Classlist.get(i);
					code = (String)itemlistvalues.get("code");
                    desc = (String)itemlistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
			</select>

			</td>
			
				<td class='LABEL'nowrap><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;1
				<select name="p_Item_analysis1" id="p_Item_analysis1"style="width:140px">
				<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<% for(int i=0; i<Item_Analysis_List.size(); i++)
				{
					itemanalysislistvalues = (HashMap)Item_Analysis_List.get(i);
					code = (String)itemanalysislistvalues.get("code");
                    desc = (String)itemanalysislistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
			</select>
				</td>
				</tr>
				<tr>
					<!-- <td width="10%" class='label'>sandyyy<fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></td> -->
					<td class='fields'nowrap><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
					&nbsp;
					<input type='radio' <%=(Search)?"checked":""%> name='searchby' accesskey='N' value='IC' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
					
					<input type='radio' <%=(Search)?"":"checked"%> name='searchby' value='ID' accesskey='T' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>&nbsp;	
					<input type='radio'  name='searchby' id='searchby' value='TC' accesskey='T' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.TradeID.label" bundle="${common_labels}"/> <!-- IN073342 -->
					<input type='radio' name='searchby' id='searchby' value='TN' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/> <!-- IN073342 -->
					</td>
					<td class='LABEL'><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/>&nbsp;
					<select name="p_Manufacturer" id="p_Manufacturer"style="width:150px">
					<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<% for(int i=0; i<Manufacturer_List.size(); i++)
				{
					manufacturerlistvalues = (HashMap)Manufacturer_List.get(i);
					code = (String)manufacturerlistvalues.get("code");
                    desc = (String)manufacturerlistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
			</select>
			

					</td>
					<td class='LABEL'nowrap><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;2
					<select name="p_Item_analysis2" id="p_Item_analysis2"style="width:140px">
					<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<% for(int i=0; i<Item_Analysis_List.size(); i++)
					{
					itemanalysislistvalues = (HashMap)Item_Analysis_List.get(i);
					code = (String)itemanalysislistvalues.get("code");
                    desc = (String)itemanalysislistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
			</select>
					</td>
					
				</tr>
				<tr><td colspan='1'></td>
				<td class='LABEL'><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/>&nbsp;
				<select name="consignment" id="consignment"style="width:150px">
				<option value="A" selected>---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---</option>
				<!-- <option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> -->
				<option value="Y"><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></option>
				<option value="N"><fmt:message key="eST.NonConsignment.label" bundle="${st_labels}"/></option>
				    </select>
				</td>
			
				<td class='LABEL'nowrap><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;3
				<select name="p_Item_analysis3" id="p_Item_analysis3"style="width:140px">
				<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<% for(int i=0; i<Item_Analysis_List.size(); i++)
					{
					itemanalysislistvalues = (HashMap)Item_Analysis_List.get(i);
					code = (String)itemanalysislistvalues.get("code");
                    desc = (String)itemanalysislistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
			</select>
				</td>

				</tr>
				<tr>
				<td class='label'  nowrap>
						<fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
						&nbsp;<input type='text' name='search_string' id='search_string'  size='20'  maxlength='200'   value="<%=item_desc%>" onblur="searchItem()";>
						&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"	id="imgMandatory"></img>
						&nbsp;<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
					&nbsp;&nbsp;<select name='search_criteria' id='search_criteria'>
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				</select>
				</td> 
				<td>
				&nbsp;
				</td>
				<td colspan='2'></td>
				</tr>
				<tr>
					<td colspan='1' align='right'>
					
				</td>
					<td><input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name='btn_search' onclick='searchItem()'>
					<input type='button' class='button' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' name='btn_reset' onclick='consumablereset()'>
					<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="button" onClick="parent.window.close();">
					</td>
				</tr>
			</table>
			<input type='hidden' name='hdn_bean_id' id='hdn_bean_id' value='<%=bean_id%>'>
			<input type='hidden' name='hdn_bean_name' id='hdn_bean_name' value='<%=bean_name%>'>
			<input type='hidden' name='hdn_locale' id='hdn_locale' value='<%=locale%>'>
			<input type='hidden' name='hdn_priority' id='hdn_priority' value='<%=priority%>'>
			<input type='hidden' name='hdn_take_home_medication' id='hdn_take_home_medication' value='<%=take_home_medication%>'>
			<input type='hidden' name='hdn_bl_install_yn' id='hdn_bl_install_yn' value='<%=bl_install_yn%>'>
			<input type='hidden' name='hdn_bl_disp_charge_dtl_in_drug_lkp_yn' id='hdn_bl_disp_charge_dtl_in_drug_lkp_yn' value='<%=bl_disp_charge_dtl_in_drug_lkp_yn%>'>
			<input type='hidden' name='hdn_bl_disp_price_type_in_drug_lkp' id='hdn_bl_disp_price_type_in_drug_lkp' value='<%=bl_disp_price_type_in_drug_lkp%>'>
			<input type='hidden' name='store_name' id='store_name' value='<%=store_name%>'>
			<input type='hidden' name='disp_locn_code' id='disp_locn_code' value='<%=disp_locn_code%>'>
			<input type='hidden' name='CALL_FROM' id='CALL_FROM' value='<%=CALL_FROM%>'>
			<input type='hidden' name='allow_alt_for_med_item' id='allow_alt_for_med_item' value='<%=bean.getAllowAltForMedItem()%>'> <!-- Added for GHL-CRF-0549 [IN:068344] -Devindra -->
			<!-- <input type='hidden' name='hdn_bl_disp_price_type_in_drug_lkp' id='hdn_bl_disp_price_type_in_drug_lkp' value='<%=bl_disp_price_type_in_drug_lkp%>'> -->
			<!-- <input type='hidden' name='hdn_item_code' id='hdn_item_code' value='<%=item_code%>'> -->
			<input type='hidden' name='searchby' id='searchby' value="ID">
 			<input type='hidden' name='hdn_patient_class' id='hdn_patient_class' value='<%=patient_class%>'><!-- patient_class addded for GHL-CRF-0467-->
 			<input type="hidden" name="hdn_split_stock" id="hdn_split_stock" value='<%=split_stock%>'> <!-- // Added for GHL-CRF-0467 - Start -->
		</form>
	</body>
<%
	if(item_desc != null && !item_desc.equals("")){
%>
		<script>
			searchItem();
		</script>
<%
	}
	putObjectInBean(bean_id,bean,request);
%>
</html> 

