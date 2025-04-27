<!DOCTYPE html>
<%@page contentType="application/xml;charset=UTF-8" import="java.util.*, ePH.*,java.sql.*,webbeans.eCommon.*, ePH.Common.*, eCommon.Common.*"%>
<?xml version='1.0' encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="../../ePH/html/CIMSAlertDisplay.xsl"?>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
		StringBuffer dup_drug_det_sbf = new   StringBuffer();
		String  patient_id="",external_product_id="",drug_db_interact_check_flag="",drug_db_duptherapy_flag="",DosageAlert="",AllergyAlert="",drug_db_contraind_check_flag="",dup_drug_det="",drug_db_allergy_flag="";
		patient_id						=   request.getParameter("patient_id");
		external_product_id				=	request.getParameter("external_product_id");
		drug_db_interact_check_flag		=	request.getParameter("drug_db_interact_check_flag");
		drug_db_duptherapy_flag			=	request.getParameter("drug_db_duptherapy_flag");
		drug_db_contraind_check_flag	=	request.getParameter("drug_db_contraind_check_flag");
		drug_db_allergy_flag             =	request.getParameter("drug_db_allergy_flag");
		String drug_db_dosecheck_flag	        =   request.getParameter("drug_db_dosecheck_flag");
		String conotra_reason			        =	request.getParameter("conotra_reason")==null?"": request.getParameter("conotra_reason");
		if(!conotra_reason.equals(""))
			conotra_reason = java.net.URLDecoder.decode(conotra_reason,"UTF-8");
		String interaction_reason		        =	request.getParameter("interaction_reason")==null?"": request.getParameter("interaction_reason");
		if(!interaction_reason.equals(""))
			interaction_reason = java.net.URLDecoder.decode(interaction_reason,"UTF-8");
		String alergy_reason			        =	request.getParameter("alergy_reason")==null?"": request.getParameter("alergy_reason");
		if(!alergy_reason.equals(""))
			alergy_reason = java.net.URLDecoder.decode(alergy_reason,"UTF-8");
		String duplicate_reason			        =	request.getParameter("duplicate_reason")==null?"": request.getParameter("duplicate_reason");
		if(!duplicate_reason.equals(""))
			duplicate_reason = java.net.URLDecoder.decode(duplicate_reason,"UTF-8");

		String dosage_reason			        =	request.getParameter("dosage_reason")==null?"": request.getParameter("dosage_reason");
		if(!dosage_reason.equals(""))
			dosage_reason = java.net.URLDecoder.decode(dosage_reason,"UTF-8");

		String pract_name						=	request.getParameter("pract_name");	
		pract_name = java.net.URLDecoder.decode(pract_name,"UTF-8");
		//pract_name=pract_name.replaceAll("%20"," ");
		String srl_no							=   request.getParameter("srl_no");
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		//String dosage_flag  = "N";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
		//HashMap externalDBCheckResult	=   beanex.getExternalDBCheckResult(external_product_id, srl_no);

		StringBuffer externalDBCheckResult	= new StringBuffer();	  // Added in June 2012
		dup_drug_det_sbf				= beanex.getStoreResult();				  // Added in June 2012
		HashMap drugProduct				= beanex.getDrugProduct();
		if(drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") ||  drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_flag.equals("Y") || drug_db_dosecheck_flag.equals("Y")){

			 String ext_prod_id_without_delim = "";
			 if(external_product_id.indexOf("::")!=-1)
					ext_prod_id_without_delim = external_product_id.substring(external_product_id.indexOf("::")+2);
				else
					ext_prod_id_without_delim  = external_product_id;
			//Added in January 2014 - to remove the unncessary warnings for dosage..
//			dup_drug_det_sbf = (StringBuffer)beanex.getWithoutDosageWarningXML(dup_drug_det_sbf, ext_prod_id_without_delim);    //IN066787- Performance


			StringBuffer dup_drug_det_sbf_result= new StringBuffer();
			 dup_drug_det_sbf_result = (StringBuffer)beanex.getContentXML(dup_drug_det_sbf, ext_prod_id_without_delim, drugProduct);
%>
			<%=dup_drug_det_sbf_result%> 
<%
		}
		putObjectInBean(ex_bean_id,beanex,request); 
%>
		 
