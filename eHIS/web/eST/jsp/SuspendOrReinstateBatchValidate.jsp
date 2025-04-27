
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%  request.setCharacterEncoding("UTF-8");
	String locale						=		(String)session.getAttribute("LOCALE");
	int functionType					=		Integer.parseInt(request.getParameter("function_type"));

	String bean_id						=		"SuspendOrReinstateBatchBean";
	String bean_name					=		"eST.SuspendOrReinstateBatchBean";
	SuspendOrReinstateBatchBean bean	=		(SuspendOrReinstateBatchBean) getBeanObject( bean_id,  bean_name,request  );  

	bean.setLanguageId(locale);
	bean.clear();
	Hashtable hash						=		(Hashtable) XMLobj.parseXMLString(request);
    hash								=		(Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
			String Item_code			=		bean.checkForNull((String) hash.get("item_code"));
			String manufacturer			=		bean.checkForNull((String) hash.get("manufacturer"));
            String stNotifiedItems		=		bean.checkForNull((String) hash.get("include_complained_items"));

			//String Batch				=		((String) hash.get("Batch")).equals("S")?"A":"S";

            String Batch				=		bean.checkForNull((String) hash.get("Batch")) ;

            String stTempBatch			=		 Batch ;
			String  item_batch = "";
			String  st_batch = "";
           
			if(stTempBatch.equals("S")){
				if(stNotifiedItems.equals("Y")){
                   Batch = "C" ;
              	   bean.setBatchStatusNotify("C");
				    item_batch = "C";
				   st_batch = "C";
				}
                if(stNotifiedItems.equals("N")){
                   Batch = "A" ;
              	   bean.setBatchStatusNotify("C");
				   item_batch = "N";
				      st_batch = "C";
				}
			} 

			if (stTempBatch.equals("R")){ 
				
                if(stNotifiedItems.equals("N")) {
                  Batch = "S" ;
             	  bean.setBatchStatusNotify("S");
				  item_batch = "Y";
				   st_batch = "Y";
				}
				if(stNotifiedItems.equals("Y")){
                  Batch = "S" ;
             	  bean.setBatchStatusNotify("C");
				   item_batch = "Y";
				   st_batch   = "C";
				}
				              }

			if (stTempBatch.equals("C")){

				if(stNotifiedItems.equals("N")) {
                  Batch = "A" ;
             	  bean.setBatchStatusNotify("A");
				   item_batch = "N";
				   st_batch = "N";
				}
				if(stNotifiedItems.equals("Y")){
                  Batch = "A" ;
             	  bean.setBatchStatusNotify("C");
				  item_batch = "N";
				   st_batch = "C";
				}
			}
			bean.setItem_code(Item_code);
			bean.setManufacturer(manufacturer);
			bean.setBatch(Batch);
			bean.setBatch_status((String) hash.get("Batch"));
			bean.setBatch_id((String) hash.get("batch_id"));
			//Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  05-AUG-2013 Starts
			bean.setFacility(bean.checkForNull((String) hash.get("dflt_facility_id")));
			bean.setStore_code(bean.checkForNull((String) hash.get("store_code")));
			//ends
           // bean.loadResultPage(); // most important  
            bean.loadResultPage(item_batch,st_batch); // most important 
	}
	break;
	case 2:
		{
			String start					=		(String) hash.get("start");
			String end						=		(String) hash.get("end");

            bean.setCheckbox(hash,Integer.parseInt(start),Integer.parseInt(end));
			out.println(bean.getDataList());
			
		}
	break;

    case 3:
		{
		bean.setProfile((String)hash.get("profile")); 
		bean.updateRemarks(hash);

		}
	break;

	case 4:
		{
			//bean.updateSelectedValues(hash);
		}
	break;
	case 5 :
		{
				out.println("clearListItems('document.SuspendReinstate_form.manufacturer'); ");
				try
				{
					ArrayList manufacturer_list		=		bean.getManufacturerList_item(bean.checkForNull(request.getParameter("item_code")));
					if (manufacturer_list!=null && manufacturer_list.size()>0)
					{
						HashMap record			= null;
						for(int i=0; i< manufacturer_list.size(); i++) 
						{
							record			=		(HashMap)manufacturer_list.get(i);
							String listRecord1		=		bean.checkForNull((String)record.get("MANUFACTURER_ID"));
							String listRecord2		=		bean.checkForNull((String)record.get("SHORT_NAME"));
							out.println("addListItem(\"document.SuspendReinstate_form.manufacturer\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
						}
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}

		}
		break;

	
	default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>
<% putObjectInBean(bean_id,bean,request);
%>
