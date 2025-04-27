<%-- saved on 26/10/2005 --%>
<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	Hashtable hash	= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash			= (Hashtable)hash.get( "SEARCH" ) ;
	ArrayList prscontvalue= new ArrayList();	
	String prscontvalueUOM = "";
	ArrayList 	pressUom = new ArrayList();
	ArrayList 	loadPressUom = new ArrayList();
	String bean_id	=	"TPNConsNSRegimenBean"; 
	String bean_name=	"ePH.TPNConsNSRegimenBean";
	TPNConsNSRegimenBean bean = (TPNConsNSRegimenBean)getBeanObject( bean_id, bean_name,request) ;
	String identity = request.getParameter("identity");
	
	

	if(identity.equals("getcontPresbaseUOM")){
		String item_code = (String)hash.get("item_code");
		String const_generic_code = (String)hash.get("const_generic_code");

		pressUom =	bean.getcontPrssUOM(item_code,const_generic_code);
		
		for(int i=0;i<pressUom.size();i++) {
		prscontvalueUOM =(String) pressUom.get(i);
		}

		if (prscontvalueUOM == null ||  prscontvalueUOM.equals("") ) {
		prscontvalueUOM="";
		}
	
/*
	for(int i=0;i<pressUom.size();i=i+2) {
		if(pressUom.get(i).equals(item_code)) {
		out.println("alert('inside the if condition in interm jsp .. ')");
		prscontvalue = (String) pressUom.get(i+1);
		}
	}*/
	out.println("assigncontPresbaseUOM('"+prscontvalueUOM+"')");
	}
else if(identity.equals("loadcontPresUOM")){

		String item_code = (String)hash.get("item_code");
		String const_generic_code = (String)hash.get("const_generic_code");

		out.println("alert('"+item_code+"')");
		out.println("alert('"+const_generic_code+"')");

//		bean.loadContPrssUOM(item_code,const_generic_code);
		loadPressUom =	bean.loadContPrssUOM(item_code,const_generic_code);
			
/*		for(int i=0;i<loadPressUom.size();i++) {
		StrprscontvalueUOM =(String) loadPressUom.get(i);
		}
*/
	}

	else if(identity.equals("getStockUOM")){
		String item_code = (String)hash.get("item_code");
		out.println("assignSaleUOMCode('"+bean.getSaleUOMCode(item_code)+"')");
	}else if(identity.equals("getGroupCode")){
		String generic_code = (String)hash.get("generic_code");
		out.println(bean.getGroupCode(generic_code));
	}else if(identity.equals("getContentInPresBaseUOM")){
		String item_code	= (String)hash.get("item_code");
		//String generic_code = (String)hash.get("generic_code");
		String item_stock_uom = (String)hash.get("item_stock_uom");

		String 	stmval=	bean.getContentInPresBaseUOM(item_stock_uom);
//		out.println("assignContentInPresBaseUOM('"+bean.getContentInPresBaseUOM(item_stock_uom)+"')");
		out.println("assignContentInPresBaseUOM('"+stmval+"')");

	}
	else if(identity.equals("getOsmolarValue")){
		String item_code	= (String)hash.get("item_code");
		String osmolar_value = (String)hash.get("osmolar_value");		
		String molecule_value = (String)hash.get("molecule_value");		
		String molecule_code = (String)hash.get("molecule_code");	
		String pres_base_uom = (String)hash.get("pres_base_uom");	
		String concentration = (String)hash.get("item_concentration");//Added for ML-MMOH-CRF-1201
        String volume = (String)hash.get("volume");//Added for ML-MMOH-CRF-1201
		String locale = bean.getLanguageId();//Added for ML-MMOH-CRF-1201

	 ArrayList  osmol_val =	new ArrayList();
     osmol_val = bean.getOsmolar();
	
/*
	for(int i=0;i<osmol_val.size();i=i+2) {
		if(osmol_val.get(i).equals(item_code)) {
		osmol_val.set(i+1,osmolar_value);	
		}

*/
		for(int i=0;i<osmol_val.size();i=i+6) {//Changed 4 to 6 for ML-MMOH-CRF-1201
		if(osmol_val.get(i).equals(item_code)) {
		osmol_val.set(i+1,osmolar_value);	
		osmol_val.set(i+2,molecule_code);	
		osmol_val.set(i+3,pres_base_uom);
		osmol_val.set(i+4,concentration);//Added for ML-MMOH-CRF-1201
		osmol_val.set(i+5,volume);//Added for ML-MMOH-CRF-1201
		}

		else{
			osmol_val.add(item_code);
			osmol_val.add(osmolar_value);
			osmol_val.add(molecule_code);
			osmol_val.add(pres_base_uom);
			osmol_val.add(concentration);//Added for ML-MMOH-CRF-1201
			osmol_val.add(volume);//Added for ML-MMOH-CRF-1201
		}
	}

	/*
		if(!osmol_val.contains(item_code)) {
			osmol_val.add(item_code);
			osmol_val.add(osmolar_value);
		}
	*/

   bean.setOsmolar(osmol_val);
//Adding start for ML-MMOH-CRF-1201
  HashMap map_applicable=bean.getApplicabulityMap();
  System.err.println("map_applicable@@@@==="+map_applicable+"item_code==="+item_code+"locale=="+locale);
  if(!map_applicable.containsKey(item_code)){
	  bean.getAgeGroupsNS(locale,item_code);
  }//Adding end for ML-MMOH-CRF-1201
  }//added for ml-mmoh-crf-1201 start
  else if ( identity.equals( "applicable_ok_cancel" ) ) {		
	  String action_type = (String)hash.get("action_type");
	  HashMap  map = bean.getApplicabulityMap();
	  if (action_type.equals("OK")){
	  String drug_code=(String)hash.get("drug_code");
	  int count=Integer.parseInt((String)hash.get("count"));
	  
	  String param="code";
	   String param1="value";
	  String code="";
	  String value="";
	  if (map.containsKey(drug_code)){
		  HashMap  map1 = (HashMap)map.get(drug_code);  
	      for(int i=0;i<count;i++){
	    	   param="code"+i;
	   	       param1="value"+i;
	    	  code=(String)hash.get(param);
	    	   value=(String)hash.get(param1);
	    	  map1.put(code, value);  
	    	 
	      }
	     
	      map.put(drug_code,map1);
	    
	  }
	  }  
	  
	  bean.setApplicabulityMap(map);
	 
  }
%>
<% putObjectInBean(bean_id,bean,request); %>
