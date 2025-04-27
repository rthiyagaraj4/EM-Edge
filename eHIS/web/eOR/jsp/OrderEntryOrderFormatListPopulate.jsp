<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, java.io.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>

<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String bean_id 		= request.getParameter( "bean_id" ) ;
	//String bean_name 		= request.getParameter( "bean_name" ) ;
	String func_mode 		= request.getParameter( "func_mode" ) ;
	String localeName=request.getParameter("localeName");	
	beanQueryObj.setLanguageId(localeName);

	//if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
	//	return ;

	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

 
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;

	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to get the Connection using the Query Bean
	String field_mnemonic 			= beanQueryObj.checkForNull((String)hash.get("field_mnemonic"),"") ;
	String order_category			= beanQueryObj.checkForNull((String)hash.get("order_category"),"") ;
 	String order_type_code 			= beanQueryObj.checkForNull((String)hash.get("order_type_code"),"") ;
	String contr_msr_panel_id 		= beanQueryObj.checkForNull((String)hash.get("contr_msr_panel_id"),"") ;
	String contr_msr_mod_id 		= beanQueryObj.checkForNull((String)hash.get("contr_msr_mod_id"),"") ;
 	String discr_msr_id 			= beanQueryObj.checkForNull((String)hash.get("discr_msr_id"),"") ;
	String performing_facility_id	= beanQueryObj.checkForNull((String)hash.get("performing_facility_id"),"");
	String login_facility_id 			= beanQueryObj.checkForNull((String)hash.get("login_facility_id"),"") ;
	String sex 			= beanQueryObj.checkForNull((String)hash.get("sex"),"") ;
	String ot_install_yn 			= beanQueryObj.checkForNull((String)hash.get("ot_install_yn"),"") ;
	String rd_install_yn 			= beanQueryObj.checkForNull((String)hash.get("rd_install_yn"),"") ;
	String catalog_code=beanQueryObj.checkForNull((String)hash.get("catalog_code"),"") ;
	//String lab_install_yn 			= beanQueryObj.checkForNull((String)hash.get("lab_install_yn"),"") ;
	String bt_install_yn 			= beanQueryObj.checkForNull((String)hash.get("bt_install_yn"),"") ;
	String oper_side_appl_yn 		= beanQueryObj.checkForNull((String)hash.get("oper_side_appl_yn"),"") ;
	String specimen_def_yn 			= beanQueryObj.checkForNull((String)hash.get("specimen_def_yn"),"") ;	
	String lab_install_yn 		="N"; 
	String labmodule="";
	ArrayList OrderFormatList;
	//lab_install_yn=beanQueryObj.checkForNull((String)hash.get("lab_install_yn"),"") ;
	//System.out.println("catalog_code44"+catalog_code);
	labmodule=beanQueryObj.checkForNull((String)beanQueryObj.getmoduleRL(catalog_code,order_category,order_type_code,login_facility_id,properties),"");
	 if(order_category.equalsIgnoreCase("LB"))
	{
			if(labmodule.equalsIgnoreCase("IBARL"))
			{
				lab_install_yn="Y";
			}
			else
			{
				lab_install_yn="N";
				//System.out.println("lab_install_yn"+lab_install_yn+catalog_code);
			}
	}
					//System.out.println("lab_install_yn"+lab_install_yn);
	String new_field_name 			= beanQueryObj.checkForNull(request.getParameter("new_field_name"),"") ;
	String dflt_value 				= beanQueryObj.checkForNull((String)hash.get("dflt_value"),"") ;

 	if(func_mode.equals("POPULATE_LIST_VALUES")) {
		out.println( "clearFormatList('document.OrderFormatForm',\""+new_field_name+"\") ; " ) ;
		if(field_mnemonic.equals("DONOR_BLOOD_GROUP"))
		{
			 OrderFormatList = beanQueryObj.getdonorblood();
		}
		else if(field_mnemonic.equals("DONOR_RHESUS"))
		{
		   OrderFormatList = beanQueryObj.getdonorrhesus();
		}
		 else
		{
		    OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id,login_facility_id, sex,  lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn,catalog_code);

		} 
		//ArrayList OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id,login_facility_id, sex,  lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn);
  		 //ArrayList OrderFormatList = beanQueryObj.getdonorblood();
		   String[] records=null;
		for(int l=0; l<OrderFormatList.size(); l++)
		{
			 records = (String[])OrderFormatList.get(l);

 			//out.println( "addFormatList('document.OrderFormatForm',\""+new_field_name+"\", \""+records[0]+"\",\""+records[1]+"\", \""+records[2]+"\",\""+dflt_value+"\", \""+order_category+"\", \""+ot_install_yn+"\", \""+oper_side_appl_yn+"\", \""+specimen_def_yn+"\" ) ; " ) ;
			 if(field_mnemonic.equals("DONOR_BLOOD_GROUP") || field_mnemonic.equals("DONOR_RHESUS"))
			{
			out.println( "addFormatList('document.OrderFormatForm',\""+new_field_name+"\", \""+records[0]+"\",\""+records[1]+"\",' ',\""+dflt_value+"\", \""+order_category+"\", \""+ot_install_yn+"\", \""+oper_side_appl_yn+"\", \""+specimen_def_yn+"\" ) ; " ) ;
			}
			else
			{
				out.println( "addFormatList('document.OrderFormatForm',\""+new_field_name+"\", \""+records[0]+"\",\""+records[1]+"\", \""+records[2]+"\",\""+dflt_value+"\", \""+order_category+"\", \""+ot_install_yn+"\", \""+oper_side_appl_yn+"\", \""+specimen_def_yn+"\" ) ; " ) ;
			}
			
			records = null;
 	 	} // End of for OrderDependencyFormat	 
		OrderFormatList.clear(); OrderFormatList = null;
	} // End of POPULATE_LIST_VALUES
	else if(func_mode.equals("POPULATE_RADIO_VALUES")) {
 		ArrayList OrderFormatRadio = beanQueryObj.getOrderFormatRadio(properties, order_category,field_mnemonic,catalog_code,lab_install_yn,contr_msr_panel_id,contr_msr_mod_id);
		StringBuffer sbTemplate = new StringBuffer();
		sbTemplate.append("<table border='1' BGCOLOR='RED'><tr><td>");
		for(int l=0; l<OrderFormatRadio.size(); l++)
		{
			String[] records = (String[])OrderFormatRadio.get(l);
			if(dflt_value.equals(records[0])) // first Item
		   		sbTemplate.append("<input type='RADIO' name='"+(new_field_name)+"' id='"+(new_field_name)+"' value='"+records[0]+"' checked>"+records[1]+"</input>");
			else 
				sbTemplate.append("<input type='RADIO' name='"+(new_field_name)+"' id='"+(new_field_name)+"' value='"+records[0]+"'>"+records[1]+"</input>");
			records = null;
		} // End of for
		if(sbTemplate.length() > 0) {
			out.println( "addRadioGroup(\""+new_field_name+"\", \""+sbTemplate.toString()+"\") ; " ) ;
		sbTemplate.setLength(0);			
		OrderFormatRadio.clear(); OrderFormatRadio	 = null;
	}
}
%>
 

