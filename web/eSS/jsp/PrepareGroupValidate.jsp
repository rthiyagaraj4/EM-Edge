<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
	String validate					= request.getParameter("validate");
	String bin_location_code		= request.getParameter("bin_location_code");
	int functionType				= Integer.parseInt(request.getParameter("function_type"));

	if ((bean_id == null) || (bean_id.equals("")))
		return;
	if ((validate == null) || (validate.equals(""))) 
		return;

	PrepareGroupBean bean			= (PrepareGroupBean) getBeanObject( bean_id, bean_name,request  );  
	Hashtable hash					= (Hashtable) XMLobj.parseXMLString(request);
    hash							= (Hashtable) hash.get ("SEARCH");

	switch (functionType) {
	case 1:
		{
			if (validate.equals("doc_type_code")) {
				String doc_type_code = (String) hash.get("doc_type_code");
				if (doc_type_code.trim().equals("")) {
					//To be replaced with proper error message
					out.println("errorDisplay();");
					return;
				}
				if (!bean.isDocNoAutoGenYN(doc_type_code)) {
					out.println("enableDocNo();");
				}
				else {
					out.println("disableDocNo();");
				}
			}
		}
		break;
	case 2: // case - 2 will be executed on focus lost of Store Code
		{
			/*if (validate.equals("store_code")) {
				String store_code = (String) hash.get("store_code");
				if (store_code.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				bean.setStore_code(store_code);
				out.println("clearListItems('formPrepareGroup.bin_location_code'); ");
				ArrayList binLocation = bean.getBinLocationData(store_code);
				for(int i=0; i< binLocation.size(); i++) {
					String[] record = (String[])binLocation.get(i);
					out.println("addListItem(\"formPrepareGroup.bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\",\""+bin_location_code+"\"); ");
				}
			}*/
		}
		break;
	case 3: // This case will be executed on Click of apply to calculate the total cost
		{
			if (validate.equals("prepare_qty")) {
				//String prepare_qty = (String) hash.get("prepare_qty");
				//String group_code  = (String) hash.get("group_code");
				String prepare_qty = request.getParameter("prepare_qty");
				String group_code = request.getParameter("group_code");
				String index = request.getParameter("index");
 				
				if (prepare_qty.trim().equals("") || group_code.trim().equals("") ) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				//bean.setPrepare_qty(prepare_qty);
				//bean.setGroup_code(group_code);
				
				String totalCost = bean.getTotalCost(prepare_qty,group_code);
				out.println("setTotalCostValue("+totalCost+","+index+");");//Modified by sakti against BRU-HIMS-CRF-370
			}
		}
		break;
	case 4: // This case will be executed on focus lost of Prepared Quantity and Calculates the total cost
		{
System.err.println("==validate"+validate+"===hash"+hash);				
			if (validate.equals("doc_date")) {
				int isValidDocDate = -1;
				String doc_date = (String) hash.get("doc_date");
System.err.println("==doc_date"+doc_date);				
				if (doc_date.trim().equals("")) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				isValidDocDate = bean.isValidDocDate(doc_date);
System.err.println("==isValidDocDate"+isValidDocDate);				
				String errorCode = null;
				if (isValidDocDate > 0) {
					if (isValidDocDate== 1) {
						errorCode = "DOC_DT_NOT_LT_PROC_MTH";
					}
					else if (isValidDocDate== 2) {
						errorCode = "DOC_DT_NOT_GR_SYSDATE";
					}
					out.println("requestDocDateFocus("+isValidDocDate+");");				
					out.println("assignResult(false,getMessage(\""+errorCode+"\",\"SS\"), \"0\")");
				} 
				else {
					out.println("assignResult(true,\"\", \"0\");");
					return;
				}
				
			}
			
		}
		break;
	case 5: // This case will be executed on apply added against BRU-HIMS-CRF-370
	{

		
		ArrayList	alRecords	=	new ArrayList();
		HashMap	hmDtlRecord	=	new HashMap();
		int total_rec	=	Integer.parseInt((String)hash.get("total_rec"));

		for(int i=0;i<total_rec;i++){
			hmDtlRecord.put("GROUP_CODE",(String)hash.get("group"+i));
			hmDtlRecord.put("TOTAL_VALUE",(String)hash.get("total_value_"+i));
			hmDtlRecord.put("BIN_LOC_CODE",(String)hash.get("bin_location_code_"+i));
			hmDtlRecord.put("PREPARE_QTY",(String)hash.get("prepare_qty_"+i));
			hmDtlRecord.put("mode",(String)hash.get("new_mode"+i));

			alRecords.add(hmDtlRecord);
			hmDtlRecord = new HashMap();
		}

		bean.setDataList(alRecords);
			
	}
	break;
	
	case 6: // This case will be executed on click of OK or next_previous added against BRU-HIMS-CRF-370
	{
		bean.selectedBatches(hash);
			
	}
	break;
	
	case 7: // This case will be executed on click of group search button added against BRU-HIMS-CRF-370
	{

		ArrayList	alRecords	=	new ArrayList();
		HashMap	hmDtlRecord	=	new HashMap();
		int total_rec	=	Integer.parseInt((String)hash.get("total_rec"));
       
		for(int i=0;i<total_rec;i++){
			hmDtlRecord.put("GROUP_CODE",(String)hash.get("group"+i));
			hmDtlRecord.put("GROUP_DESC",(String)hash.get("desc"+i));
			hmDtlRecord.put("TOTAL_VALUE",(String)hash.get("total_value_"+i));
			hmDtlRecord.put("BIN_LOCATION_CODE",(String)hash.get("bin_location_code_"+i));
			hmDtlRecord.put("PREPARE_QTY",(String)hash.get("prepare_qty_"+i));
			hmDtlRecord.put("mode",(String)hash.get("new_mode"+i));

			alRecords.add(hmDtlRecord);
			hmDtlRecord = new HashMap();

			bean.setAlSelectedTrayDetails((String)hash.get("group"+i));//Added against inc#42370
		}

		bean.setSelectedList(alRecords);
			
	}
	break;
	//Added against inc#42370
	case 8: // This case will be executed on click of OK or next_previous added against BRU-HIMS-CRF-370
	{
			ArrayList checkedrecord =  bean.getAlSelectedTrayDetails();
			checkedrecord.clear();
					
	}
	break;
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}


%>
<%
putObjectInBean(bean_id,bean,request);
%>
 
