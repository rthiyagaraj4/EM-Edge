<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eOR.Common.OrderEntryRecordBean"%>
<%@ page import="eOR.OrderEntryBean"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
try{
	if(patientContext!=null){
		String patientId = patientContext.getPatientId();
		String encounterId = patientContext.getEncounterId();
		String locale = patientContext.getLocale();
		String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
		String or_bean_name = "eOR.OrderEntryBean";
		OrderEntryBean beanObj	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
		String removeCodes = request.getParameter("code") == null ? "":request.getParameter("code");
		
		String key				= (beanObj.getPatientId()+beanObj.getEncounterId());
		HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
		
		String orderCatalogCodes = request.getParameter("code") == null ? "":request.getParameter("code");
		String check_box_value = request.getParameter("check_box_value") == null ? "":request.getParameter("check_box_value");
		String orderCategoryCode = request.getParameter("cat") == null ? "":request.getParameter("cat");
		StringTokenizer comma = new StringTokenizer(orderCatalogCodes, ",");
		while(comma.hasMoreElements()){
			String item = comma.nextToken();
			previousValues.remove("ck"+item);
			previousValues.remove("h1"+item);
			previousValues.remove("h2"+item);
			orderEntryRecordBean.setCheckedEntries(key, previousValues);
			beanObj.clearTempOrderSet("start_date_time"+item);
			beanObj.clearTempOrderSet("end_date_time"+item);
			beanObj.clearTempOrderSet("order_type_code"+item);
			beanObj.clearTempOrderSet("priority"+item);
			beanObj.clearTempOrderSet("quantity"+item);
			beanObj.clearTempOrderSet("frequency_code"+item);
			beanObj.clearTempOrderSet("duration_code"+item);
			beanObj.clearTempOrderSet("duration_value"+item);
			beanObj.clearTempOrderSet("performing_facility_id"+item);
			beanObj.clearTempOrderSet("performing_dept_loc_code"+item);
			beanObj.clearTempOrderSet("performing_facility_desc"+item);
			beanObj.clearTempOrderSet("performing_dept_loc_desc"+item);
		}
		beanObj.setCatalogCodes(check_box_value);
		if(orderCategoryCode.equals("CS")){
			beanObj.setTempValues("OrderSetChecked", "0");
		}
		/* if(removeMode.equals("IND")){
			String orderCatalogCode = request.getParameter("code") == null ? "":request.getParameter("code");
			if(!orderCatalogCode.equals("")){
				ArrayList ckOrderCatalogCodes = (ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
				ckOrderCatalogCodes.remove("ck"+orderCatalogCode);
				beanObj.setCatalogCodes(ckOrderCatalogCodes.toString().replace("[", "").replace("]", ""));
				out.println(ckOrderCatalogCodes.toString());
				previousValues.remove("ck"+orderCatalogCode);
				previousValues.remove("h1"+orderCatalogCode);
				previousValues.remove("h2"+orderCatalogCode);
				orderEntryRecordBean.setCheckedEntries(key, previousValues);
				beanObj.clearTempOrderSet("start_date_time"+orderCatalogCode);
				beanObj.clearTempOrderSet("end_date_time"+orderCatalogCode);
				beanObj.clearTempOrderSet("order_type_code"+orderCatalogCode);
				beanObj.clearTempOrderSet("priority"+orderCatalogCode);
				beanObj.clearTempOrderSet("quantity"+orderCatalogCode);
				beanObj.clearTempOrderSet("frequency_code"+orderCatalogCode);
				beanObj.clearTempOrderSet("duration_code"+orderCatalogCode);
				beanObj.clearTempOrderSet("duration_value"+orderCatalogCode);
				beanObj.clearTempOrderSet("performing_facility_id"+orderCatalogCode);
				beanObj.clearTempOrderSet("performing_dept_loc_code"+orderCatalogCode);
				beanObj.clearTempOrderSet("performing_facility_desc"+orderCatalogCode);
				beanObj.clearTempOrderSet("performing_dept_loc_desc"+orderCatalogCode);
			}
			
		}else if(removeMode.equals("CAT")){
			String orderCategoryCode = request.getParameter("code") == null ? "":request.getParameter("code");
			if(!orderCategoryCode.equals("")){
				if(orderCategoryCode.equals("CS")){
					//if OrderSet, directly remove the OrderSet using its catalog code
					String orderCatalogCode = beanObj.getOrderCatalogCode(previousValues,orderCategoryCode,beanObj.getPractitionerType());//gets the OrderSet Code
					//orderCatalogCode = orderCatalogCode.substring(1, orderCatalogCode.length());
					if(!orderCatalogCode.equals("")){
						ArrayList ckOrderCatalogCodes = (ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
						ckOrderCatalogCodes.remove("ck"+orderCatalogCode);
						beanObj.setCatalogCodes(ckOrderCatalogCodes.toString().replace("[", "").replace("]", ""));
						out.println(ckOrderCatalogCodes.toString());
						previousValues.remove("ck"+orderCatalogCode);
						previousValues.remove("h1"+orderCatalogCode);
						previousValues.remove("h2"+orderCatalogCode);
						orderEntryRecordBean.setCheckedEntries(key, previousValues);
						beanObj.clearTempOrderSet("start_date_time"+orderCatalogCode);
						beanObj.clearTempOrderSet("end_date_time"+orderCatalogCode);
						beanObj.clearTempOrderSet("order_type_code"+orderCatalogCode);
						beanObj.clearTempOrderSet("priority"+orderCatalogCode);
						beanObj.clearTempOrderSet("quantity"+orderCatalogCode);
						beanObj.clearTempOrderSet("frequency_code"+orderCatalogCode);
						beanObj.clearTempOrderSet("duration_code"+orderCatalogCode);
						beanObj.clearTempOrderSet("duration_value"+orderCatalogCode);
						beanObj.clearTempOrderSet("performing_facility_id"+orderCatalogCode);
						beanObj.clearTempOrderSet("performing_dept_loc_code"+orderCatalogCode);
						beanObj.clearTempOrderSet("performing_facility_desc"+orderCatalogCode);
						beanObj.clearTempOrderSet("performing_dept_loc_desc"+orderCatalogCode);
						
						//Remove all the temp values of individual items
						ArrayList PlaceOrderSetItems	= beanObj.getPlaceOrderCareSets(orderCatalogCode,"","");
						
						for(int i=0;i<PlaceOrderSetItems.size();i++){
							String[] care_set_group 			= (String[])PlaceOrderSetItems.get(i);
							String itemCatalogCode = care_set_group[2];
							beanObj.clearTempOrderSet("start_date_time"+itemCatalogCode);
							beanObj.clearTempOrderSet("end_date_time"+itemCatalogCode);
							beanObj.clearTempOrderSet("order_type_code"+itemCatalogCode);
							beanObj.clearTempOrderSet("priority"+itemCatalogCode);
							beanObj.clearTempOrderSet("quantity"+itemCatalogCode);
							beanObj.clearTempOrderSet("frequency_code"+itemCatalogCode);
							beanObj.clearTempOrderSet("duration_code"+itemCatalogCode);
							beanObj.clearTempOrderSet("duration_value"+itemCatalogCode);
							beanObj.clearTempOrderSet("performing_facility_id"+itemCatalogCode);
							beanObj.clearTempOrderSet("performing_dept_loc_code"+itemCatalogCode);
							beanObj.clearTempOrderSet("performing_facility_desc"+itemCatalogCode);
							beanObj.clearTempOrderSet("performing_dept_loc_desc"+itemCatalogCode);
						}
						beanObj.setTempValues("OrderSetChecked", "0");
					}
					
				}else{
					
					String order_type_catalog 		= beanObj.getOrderTypeCatalog(previousValues);
					String practitioner_type = beanObj.getPractitionerType();
					String order_catalog_code 		= beanObj.getOrderCatalogCode(previousValues,orderCategoryCode,practitioner_type);//IN042045
			    	ArrayList PlaceOrderItems 		= beanObj.getPlaceOrdersResult(beanObj.checkForNull(order_type_catalog,"'1||1','1'"),beanObj.checkForNull(orderCategoryCode,""),beanObj.checkForNull(order_catalog_code,"''"),""); // Last parameter to identify normalOE or from preview
			    	ArrayList ckOrderCatalogCodes = (ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
					if(PlaceOrderItems!=null){
			    		for(int i=0; i<PlaceOrderItems.size(); i++){
			    			String[] records =(String[])PlaceOrderItems.get(i);
			    			previousValues.remove("ck"+records[0]);
							previousValues.remove("h1"+records[0]);
							previousValues.remove("h2"+records[0]);
							orderEntryRecordBean.setCheckedEntries(key, previousValues);
							beanObj.clearTempOrderSet("start_date_time"+records[0]);
							beanObj.clearTempOrderSet("end_date_time"+records[0]);
							beanObj.clearTempOrderSet("order_type_code"+records[0]);
							beanObj.clearTempOrderSet("priority"+records[0]);
							beanObj.clearTempOrderSet("quantity"+records[0]);
							beanObj.clearTempOrderSet("frequency_code"+records[0]);
							beanObj.clearTempOrderSet("duration_code"+records[0]);
							beanObj.clearTempOrderSet("duration_value"+records[0]);
							beanObj.clearTempOrderSet("performing_facility_id"+records[0]);
							beanObj.clearTempOrderSet("performing_dept_loc_code"+records[0]);
							beanObj.clearTempOrderSet("performing_facility_desc"+records[0]);
							beanObj.clearTempOrderSet("performing_dept_loc_desc"+records[0]);
							ckOrderCatalogCodes.remove("ck"+records[0]);
			    		}
					}
					beanObj.setCatalogCodes(ckOrderCatalogCodes.toString().replace("[", "").replace("]", "")); */
					/* String orderCatalogCode = beanObj.getOrderCatalogCode(previousValues,orderCategoryCode,beanObj.getPractitionerType());
					out.println(orderCatalogCode);
					ArrayList ckOrderCatalogCodes = (ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
					StringTokenizer comma = new StringTokenizer(orderCatalogCode, ",");
					while(comma.hasMoreElements()){
						String item = comma.nextToken();
						item = item.substring(1, item.length()-1);//because the values are enclosed in single quotes ''
						ckOrderCatalogCodes.remove("ck"+item);
						previousValues.remove("ck"+item);
						previousValues.remove("h1"+item);
						previousValues.remove("h2"+item);
						orderEntryRecordBean.setCheckedEntries(key, previousValues);
						beanObj.clearTempOrderSet("start_date_time"+item);
						beanObj.clearTempOrderSet("end_date_time"+item);
						beanObj.clearTempOrderSet("order_type_code"+item);
						beanObj.clearTempOrderSet("priority"+item);
						beanObj.clearTempOrderSet("quantity"+item);
						beanObj.clearTempOrderSet("frequency_code"+item);
						beanObj.clearTempOrderSet("duration_code"+item);
						beanObj.clearTempOrderSet("duration_value"+item);
						beanObj.clearTempOrderSet("performing_facility_id"+item);
						beanObj.clearTempOrderSet("performing_dept_loc_code"+item);
						beanObj.clearTempOrderSet("performing_facility_desc"+item);
						beanObj.clearTempOrderSet("performing_dept_loc_desc"+item);
					}
					beanObj.setCatalogCodes(ckOrderCatalogCodes.toString().replace("[", "").replace("]", "")); */
				/* }
			}
		} */
		/* String orderCatalogCode = request.getParameter("OrderCatalogCode") == null ? "":request.getParameter("OrderCatalogCode");
		String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");
		String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "":request.getParameter("OrderCatCode");
		String orderCatalogCodeCSV = request.getParameter("OrderCatalogCodes") == null ? "":request.getParameter("OrderCatalogCodes"); //In case of ordersets, multiple values will be present in the csv
		String [] orderCatalogCodes = orderCatalogCodeCSV.split(",");
		
		String check_box_value	= beanObj.checkForNull(request.getParameter( "check_box_value" ),"") ;
		
		.setCatalogCodes(check_box_value);
		String key				= (beanObj.getPatientId()+beanObj.getEncounterId());
		HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
		if(previousValues == null){
			previousValues = new HashMap();
		}
		previousValues.put("ck"+orderCatalogCode, "Y");
		previousValues.put("h1"+orderCatalogCode,orderCategoryCode);
		previousValues.put("h2"+orderCatalogCode,orderTypeCode);
		orderEntryRecordBean.setCheckedEntries(key, previousValues);
		for(int i=0;i<orderCatalogCodes.length;i++){
			beanObj.setTempValues("start_date_time"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("StartDate-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("end_date_time"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("EndDate-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("order_type_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("OrderType-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("priority"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Priority-"+orderCatalogCodes[i]),""));
			String quantity = request.getParameter("Quantity-"+orderCatalogCodes[i]);
			if(quantity == null || quantity.trim().equals(""))
				quantity = "1";
			beanObj.setTempValues("quantity"+orderCatalogCodes[i],beanObj.checkForNull(quantity,"1"));
			beanObj.setTempValues("frequency_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Frequency-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("duration_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Duration-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("duration_value"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("DurationNum-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_facility_id"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingLocation-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_dept_loc_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingDept-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_facility_desc"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingLocation-"+orderCatalogCodes[i]+"_input"),""));
			beanObj.setTempValues("performing_dept_loc_desc"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingDept-"+orderCatalogCodes[i]+"_input"),""));
		}
		if(orderCategoryCode.equals("CS")){
			beanObj.setTempValues("OrderSetChecked", "1");
		}
		
		
		//Setting all the values entered in the form
		//beanObj.setTempValues(key,value); */
		putObjectInBean(or_bean_id,beanObj,request);
	}
}catch(Exception e){
	System.out.println(e.getMessage());
}
%>
