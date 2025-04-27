<%-- saved on 26/10/2005 --%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString(request);
	hash				= (Hashtable)hash.get("SEARCH");
	String bean_id		= (String) hash.get("bean_id");
	String bean_name	= (String) hash.get("bean_name");
	String func_mode	= request.getParameter("func_mode");

	
	TPNRegimenMastBean beanObj	= (TPNRegimenMastBean)getBeanObject(bean_id,bean_name,request);

/*
	if(func_mode!=null && func_mode.equals("")) {

		HashMap masterform	= new HashMap();
		String schedule_id			=	(hash.get("schedule_id")==null)?"":(String)hash.get("schedule_id");
		String prescribing_catg		=	(hash.get("prescribing_catg")==null)?"":(String)hash.get("prescribing_catg");
		String tpn_regimen_code				= (String) hash.get( "tpn_regimen_code" );
		String infuse_over			=	(hash.get("infuse_over")==null)?"":(String)hash.get("infuse_over");
		String infuse_over_list		=	(hash.get("infuse_over_list")==null)?"":(String)hash.get("infuse_over_list");
		String long_name	=	(hash.get("long_name")==null)?"":(String)hash.get("long_name");
		String single_emulsion	=	(hash.get("single_emulsion")==null)?"":(String)hash.get("single_emulsion");
		String pres_base_uom	=	(hash.get("pres_base_uom")==null)?"":(String)hash.get("pres_base_uom");
		
		masterform.put("schedule_id",schedule_id);
		masterform.put("prescribing_catg",prescribing_catg);
		masterform.put("tpn_regimen_code",tpn_regimen_code);
		masterform.put("infuse_over",infuse_over);
		masterform.put("infuse_over_list",infuse_over_list);
		masterform.put("long_name",long_name);
		masterform.put("single_emulsion",single_emulsion);
		masterform.put("pres_base_uom",pres_base_uom);


		beanObj.setMasterform(masterform);
	
	}
	else
*/		
		if(func_mode!=null && func_mode.equals("Constituents_tab")) {
		
		String key			= "";
		String value		= "";
	
		String total_energy = (String)hash.get("ttl_energy");
		String lipid_emulsion_type = (String)hash.get("lipid_emulsion_type");
		String npc_ratio = (String)hash.get("npc_ratio_val");
		ArrayList  constituents	= new ArrayList();
	
		HashMap	record1	= new HashMap();
		Enumeration keys		= hash.keys();
	
		float total_volume		=	0.0f;

		while(keys.hasMoreElements()) {
			HashMap	record	= new HashMap();
			
			key				= (String)keys.nextElement();
			value			= (String)hash.get(key);

			if(key.startsWith("des_"))
			{

			out.println("alert(\"key" + key + "\");") ;
			out.println("alert(\"val" + value + "\");") ;
			record1.put("const_generic_code",key);
			record1.put("const_weight",value);
			}



			if(!key.equals("bean_id") && !key.equals("bean_name") && !key.equals("mode") &&!key.endsWith("_unit") && !value.equals("") && !key.endsWith("_perc") && !key.endsWith("_vol")
			){

				record.put("const_generic_code",key);
				record.put("const_weight",value);
				if(hash.get(key+"_FL")!=null) {

					beanObj.setTotalVolume(value);
				}
				

				value = (String)hash.get(key+"_unit");

				record.put("const_weight_unit",value);


				if(hash.get(key+"_perc")!=null) {
					String const_perc	= (String)hash.get(key+"_perc");
					String const_vol	= (String)hash.get(key+"_vol");
					String const_uom	= (String)hash.get(key+"_actuom");//added for ml-mmoh-scf-1303

					record.put("const_perc", const_perc);
					record.put("const_vol", const_vol);
					record.put("const_uom", const_uom);//added for ml-mmoh-scf-1303

					total_volume	+=	Float.parseFloat(const_vol);

				}



				if(total_volume!=0)
					beanObj.setTotalVolume(total_volume+"");

				if(record.get("const_weight_unit")!=null || record.get("Percentage_cal")!=null)
				{
					constituents.add(record);
				}
			}

		}
		out.println("alert(\"" + constituents + "\");") ;


		beanObj.setConstituents(constituents);
		
		beanObj.setTotalEnergy(total_energy);
		beanObj.setLipidEmulsion(lipid_emulsion_type);
		beanObj.setNpcRatio(npc_ratio);
	}
	else if(func_mode!=null && func_mode.equals("OrderingDispensingRules_tab")) {


		HashMap ordering_dispensing	= new HashMap();

		String schedule_id			=	(hash.get("schedule_id")==null)?"":(String)hash.get("schedule_id");
		String prescribing_catg		=	(hash.get("prescribing_catg")==null)?"":(String)hash.get("prescribing_catg");
		String infuse_over			=	(hash.get("infuse_over")==null)?"":(String)hash.get("infuse_over");
		String infuse_over_list		=	(hash.get("infuse_over_list")==null)?"":(String)hash.get("infuse_over_list");
		String authorize_yn			=	(hash.get("authorize_yn")==null)?"":(String)hash.get("authorize_yn");
		String disp_via_pres		=	(hash.get("disp_via_pres")==null)?"":(String)hash.get("disp_via_pres");
		String disp_against_damage	=	(hash.get("disp_against_damage")==null)?"":(String)hash.get("disp_against_damage");
		String caution_label_1		=	(hash.get("caution_label_1")==null)?"":(String)hash.get("caution_label_1");
		String caution_label_2		=	(hash.get("caution_label_2")==null)?"":(String)hash.get("caution_label_2");
		String spl_instruction		=	(hash.get("spl_instruction")==null)?"":(String)hash.get("spl_instruction");
		String patient_direction	=	(hash.get("patient_direction")==null)?"":(String)hash.get("patient_direction");

		ordering_dispensing.put("schedule_id",schedule_id);
		ordering_dispensing.put("prescribing_catg",prescribing_catg);
		ordering_dispensing.put("infuse_over",infuse_over);
		ordering_dispensing.put("infuse_over_list",infuse_over_list);
		ordering_dispensing.put("authorize_yn",authorize_yn);
		ordering_dispensing.put("disp_via_pres",disp_via_pres);
		ordering_dispensing.put("disp_against_damage",disp_against_damage);
		ordering_dispensing.put("caution_label_1",caution_label_1);
		ordering_dispensing.put("caution_label_2",caution_label_2);
		ordering_dispensing.put("spl_instruction",spl_instruction);
		ordering_dispensing.put("patient_direction",patient_direction);

		beanObj.setOrdDispensing(ordering_dispensing);
	}
	else if(func_mode!=null && func_mode.equals("external_db")) {
		String external_drug = (hash.get("external_drug_id")==null)?"":(String)hash.get("external_drug_id");
		beanObj.setExternalDrug(external_drug);
	}
	else if(func_mode!=null && func_mode.equals("item_search")) {
		String base_unit = (String)hash.get("base_unit");
		String item_code = (String)hash.get("item_code");
		String item_desc = (String)hash.get("item_desc");
			
		if(beanObj.checkValidItem(base_unit,item_code))
			out.println("setItemCode('"+item_code+"','"+item_desc+"')");
		else
				out.println("invalidItemMessage();");
	}else if(func_mode!= null && func_mode.equals("tpn_regimen_code")){

		String tpn_regimen_code				= (String) hash.get( "tpn_regimen_code" );
		boolean result				= beanObj.validateRegimenCode(tpn_regimen_code);

		out.println("regimenCodeResult('"+result+"');");
	}
	putObjectInBean(bean_id,beanObj,request);
%>
