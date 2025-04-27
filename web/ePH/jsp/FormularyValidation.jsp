<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*" contentType="text/html;charset=ISO-8859-1 " %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	try {
		String called_from			= request.getParameter("called_from");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		//System.err.println("FormularyValidation.jsp======================>");
		if(called_from != null && called_from.equals("getFormNames" ) ){
			String generic_id					= (String) hash.get("generic_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1					= (String) hash.get("bean_name");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			ArrayList formNames	= bean.getFormNames(generic_id);
				//System.err.println("formNames==>"+formNames+"==generic_id==>"+generic_id);
			if(formNames.size()>0){
				String form_code="";
				String form_desc="";
				for(int i=0;i<formNames.size();i=i+2){
				form_code = (String)formNames.get(i);
				form_desc = (String)formNames.get(i+1);
				//System.err.println("form_code==>"+form_code+"==form_desc==>"+form_desc);
				out.println("addFormNameList('"+form_code+"','"+form_desc+"')");
				}
				out.println("changeForm(document.formulary_drug_search.form_name)");
			}
		putObjectInBean(bean_id1,bean,request);			
		
		}else if(called_from != null && called_from.equals("getStrengthValues" ) ){
			String generic_id				= (String) hash.get("generic_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String form_code				= (String) hash.get("form_code");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			ArrayList stregthValues	= bean.getStrengthValues(generic_id,form_code);
			//System.err.println("stregthValues====>"+stregthValues);
			if(stregthValues.size()>0){

				String form_desc="";
				String strength_value = "";
				String strength_uom	  = "";
				String uom_desc		  = "";
				String strength_desc  = "";
				for(int i=0;i<stregthValues.size();i=i+3){
				strength_value = (String)stregthValues.get(i);
				strength_uom = strength_value+"~"+(String)stregthValues.get(i+1);
				uom_desc	 = (String)stregthValues.get(i+2);
				strength_desc = strength_value+" "+uom_desc ;
				out.println("addStrengthValueList('"+strength_uom+"','"+strength_desc+"')");
				}

			}
		putObjectInBean(bean_id1,bean,request);
		}else if(called_from != null && called_from.equals("saveBlgGroupID")){
			String blg_grp_id				= (String) hash.get("blg_grp_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String checked_yn				= (String) hash.get("checked_yn");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			 ArrayList slectedBlgGrpID = bean.getselectedFormularyBLGId();
			if(slectedBlgGrpID == null && slectedBlgGrpID.size()==0)
			 bean.setselectedFormularyBLGId(blg_grp_id,"Y");
			else{
				if(checked_yn.equals("Y")){
					if(!slectedBlgGrpID.contains(blg_grp_id))
						bean.setselectedFormularyBLGId(blg_grp_id,"Y");
				}else{
						bean.setselectedFormularyBLGId(blg_grp_id,"N");
				}

			}
			
 

		putObjectInBean(bean_id1,bean,request);
		}else if(called_from != null && called_from.equals("setBillingGrp")){
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String billing_type				= (String) hash.get("billing_type");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			//System.err.println("billing_type=====>"+billing_type);
			bean.setBillingType(billing_type);			
 

		putObjectInBean(bean_id1,bean,request);
		}else if(called_from != null && called_from.equals("saveSelectedItem" ) ){
			String generic_id				= (String) hash.get("generic_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String tot_rec					= (String) hash.get("total_rec");
			String generic_name				= (String) hash.get("generic_name");
			String item_type				= (String) hash.get("item_type");
			String generic_name_key			= (String) hash.get("generic_name_key");
			generic_name_key = java.net.URLDecoder.decode(generic_name_key,"UTF-8");//GHL-SCF-1533
			String form_code				= (String) hash.get("form_code");
			String save_type				= (String) hash.get("save_type");
			ArrayList preferenceItem  = new ArrayList();
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			if(save_type.equals("A")){
				for(int i=1; i<Integer.parseInt(tot_rec); i++) {
					preferenceItem.add(generic_id);
					preferenceItem.add(generic_name);
					preferenceItem.add(item_type);
					preferenceItem.add((String) hash.get("item_code_"+i));
					preferenceItem.add((String) hash.get("item_desc_"+i));
					preferenceItem.add(form_code);
					preferenceItem.add(java.net.URLDecoder.decode((String) hash.get("form_name_"+i),"UTF-8"));//GHL-SCF-1533
					preferenceItem.add((String) hash.get("strength_txt_"+i));
					preferenceItem.add((String) hash.get("route_code_"+i));
					preferenceItem.add((String) hash.get("route_"+i));
					preferenceItem.add((String) hash.get("preference_item_"+i));
					preferenceItem.add((String) hash.get("unit_price_"+i));
					preferenceItem.add((String) hash.get("strength_"+i));
					preferenceItem.add((String) hash.get("strength_uom_"+i));
					
				}
			bean.setSelectedGenericID(generic_name_key,preferenceItem);
			
			
//System.err.println("FormularyValidation.jsp===dssd===preferenceItem=====77==>"+preferenceItem+"===>"+item_type);
			if(item_type!=null && item_type.equals("D")){
				ArrayList genericNameForDrug = bean.getGenericNameForDrug();
				if(genericNameForDrug!=null && genericNameForDrug.size()>0)
				{
					if(!genericNameForDrug.contains(generic_name_key)){
						bean.setGenericNameForDrug(generic_name_key);
					}
				}else{
						bean.setGenericNameForDrug(generic_name_key);
				}
			}
			else{
					ArrayList genericNameForMedicalItem = bean.getGenericNameForMedicalItem();
					
					if(genericNameForMedicalItem!=null && genericNameForMedicalItem.size()>0)
					{
						if(!genericNameForMedicalItem.contains(generic_name_key)){
							bean.setGenericNameForMedicalItem(generic_name_key);
						}
					}else{
							bean.setGenericNameForMedicalItem(generic_name_key); 
					}
 				}
			}else{
				 if(bean.getSelectedGenericID().containsKey(generic_name_key)){
					bean.getSelectedGenericID().remove(generic_name_key);
				 }
				 if(bean.getGenericNameForMedicalItem().contains(generic_name_key)){
					bean.getGenericNameForMedicalItem().remove(generic_name_key);
				 }

				 if(bean.getGenericNameForDrug().contains(generic_name_key)){
					 bean.getGenericNameForDrug().remove(generic_name_key);
				 }
			}
			
			ArrayList itemGenericType = bean.getItemGenericType();
			
			if(itemGenericType!=null && itemGenericType.size()>0){
				if(!itemGenericType.contains(item_type))
					bean.setItemGenericType(item_type);
			}else{
				bean.setItemGenericType(item_type);
			}
				out.println("closeWindow('"+save_type+"','"+generic_id+"')");
			
		putObjectInBean(bean_id1,bean,request);
		}else if(called_from != null && called_from.equals("checkDuplicate")){
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String formulary_code			= (String) hash.get("formulary_code");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			//System.err.println("billing_type=====>"+billing_type);
			boolean formular_dup_flag= bean.checkDuplicate(formulary_code);			

			if(formular_dup_flag){
			out.println("duplicateFormularyAlert()");
			}
 

		putObjectInBean(bean_id1,bean,request);
		} 

	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}	
%>

