<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, java.io.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%
/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
?             100            ?           	?				?				created
01/08/2014	  IN049133	    Chowminya										CRF:Disallow user to enter the future date in the LMP date field
------------------------------------------------------------------------------------------
*/
%>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter( "bean_id" ) ;
	String bean_name 		= request.getParameter( "bean_name" ) ;
	String func_mode 		= request.getParameter( "func_mode" ) ;
	String localeName=request.getParameter("localeName");	
	beanQueryObj.setLanguageId(localeName);

	if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
		return ;

	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

	/* Initialize Function specific start */
	//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	/* Initialize Function specific end */

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	try
	{
		String format_id 				= beanQueryObj.checkForNull((String)hash.get("format_id"),"") ;
		String field_mnemonic			= beanQueryObj.checkForNull((String)hash.get("field_mnemonic"),"") ;
		String seq_num 					= beanQueryObj.checkForNull((String)hash.get("seq_num"),"0") ;
		String new_seq_num 				= beanQueryObj.checkForNull((String)hash.get("new_seq_num"),"0") ;

		String order_category 			= beanQueryObj.checkForNull((String)hash.get("order_category"),"") ;
		String contr_msr_panel_id 		= beanQueryObj.checkForNull((String)hash.get("contr_msr_panel_id"),"") ;
		String contr_msr_mod_id 		= beanQueryObj.checkForNull((String)hash.get("contr_msr_mod_id"),"") ;
		String order_type_code 			= beanQueryObj.checkForNull((String)hash.get("order_type_code"),"") ;
		String discr_msr_id 			= beanQueryObj.checkForNull((String)hash.get("discr_msr_id"),"") ;
		String performing_facility_id	= beanQueryObj.checkForNull((String)hash.get("performing_facility_id"),"");
		String oper_side_appl_yn 		= beanQueryObj.checkForNull((String)hash.get("oper_side_appl_yn"),"") ;
		String specimen_def_yn 			= beanQueryObj.checkForNull((String)hash.get("specimen_def_yn"),"") ;	
		String max_dependency_rows		= beanQueryObj.checkForNull((String)hash.get("max_dependency_rows"),"0") ;

		String field_value 				= beanQueryObj.checkForNull(request.getParameter("field_value"),"") ;
		String field_name 				= beanQueryObj.checkForNull(request.getParameter("field_name"),"") ;
		String new_field_name 			= beanQueryObj.checkForNull(request.getParameter("new_field_name"),"") ;
		String login_facility_id		= beanQueryObj.checkForNull(request.getParameter("login_facility_id"),"") ;
		String sex			 			= beanQueryObj.checkForNull(request.getParameter("sex"),"") ;
		String catalog_code			 	= beanQueryObj.checkForNull(request.getParameter("catalog_code"),"") ;
		String oth_dependency_yn		= beanQueryObj.checkForNull((String)hash.get("oth_dependency_yn"),"N") ;//IN049133
		String field_type 			= beanQueryObj.checkForNull((String)hash.get("field_type"),"") ;	
		String value_seq_num			= "", 	field_mnemonic_value	= "";
		String field_mnemonic_value1	= "", 	field_value_type		= "";
		String field_mnemonic_action	= "", 	field_action_msg		= "";
		String oth_mnemonic_yn			= "",	notify_yn				= "N";
		ArrayList OrderDependency		= null;
		String[] dependencyRecords		= null;
		//IN049133 
		//if(func_mode.equals("CHECK_DEPENDENCY"))
		if(func_mode.equals("CHECK_DEPENDENCY") & "N".equals(oth_dependency_yn))
		{
			OrderDependency = beanQueryObj.getDependencyValues(properties, format_id, Integer.parseInt(seq_num), field_mnemonic, field_value,field_type);
			for(int i=0; i<OrderDependency.size(); i++)		// Only one record at a time
			{
				dependencyRecords		 = (String[])OrderDependency.get(i);
				field_mnemonic_value	 = beanQueryObj.checkForNull(dependencyRecords[0],"");
				value_seq_num	 		 = beanQueryObj.checkForNull(dependencyRecords[1],"");
				field_mnemonic_value1	 = beanQueryObj.checkForNull(dependencyRecords[2],"");
				field_value_type	 	 = beanQueryObj.checkForNull(dependencyRecords[3],"");
				field_mnemonic_action	 = beanQueryObj.checkForNull(dependencyRecords[4],"");
				field_action_msg		 = beanQueryObj.checkForNull(dependencyRecords[5],"");
				oth_mnemonic_yn			 = beanQueryObj.checkForNull(dependencyRecords[6],"");
				notify_yn				 = beanQueryObj.checkForNull(dependencyRecords[7],"N");
				 
	 			out.println( "loadDecisionDependency(\""+field_name+"\", \""+new_field_name+"\", \""+bean_id+"\" , \""+bean_name+"\", \""+field_value+"\", \""+format_id+"\", \""+field_mnemonic+"\", \""+new_seq_num+"\", \""+seq_num+"\", \""+field_mnemonic_value+"\", \"" +value_seq_num+"\" ,\""+field_mnemonic_value1+"\", \""+field_value_type+"\", \""+field_mnemonic_action+"\", \"" +field_action_msg+"\" ,\""+oth_mnemonic_yn+"\" , \""+order_category+"\",\""+contr_msr_panel_id+"\",\""+contr_msr_mod_id+"\",\""+order_type_code+"\",\""+discr_msr_id+"\",\""+performing_facility_id+"\",\""+oper_side_appl_yn+"\",\""+specimen_def_yn+"\",\""+max_dependency_rows+"\", \""+login_facility_id+"\", \""+sex+"\",\""+notify_yn+"\",\""+catalog_code+"\") ; " ) ;
	 		} // End of for OrderDependencyFormat	 
	
			//if(field_value.equalsIgnoreCase("YES") || field_value.equalsIgnoreCase("NO") && OrderDependency.size()==0) // For checkbox if values is YES or NO, but no record then hide the dependency fiels.
			//	out.println( "hideColumns(\""+new_field_name+"\",\""+max_dependency_rows+"\"); ");
		}  // End of CHECK_DEPENDENCY
		else if(func_mode.equals("POPULATE_OTH_MNEMONIC")){
				value_seq_num			= beanQueryObj.checkForNull((String)hash.get("value_seq_num"),"0") ;
				field_mnemonic_value	= beanQueryObj.checkForNull((String)hash.get("field_mnemonic_value"),"0") ;
				String patient_id		= beanQueryObj.checkForNull((String)hash.get("patient_id"),"") ;
				String	parent_seq_num  = "",	parent_field_mnemonic	= "";
				String  label_text		= "",	accept_option			= "";
				String  dflt_value		= "";
				String  min_num_value	= "",	max_num_value			= "";
				String	help_text		= "",   new_discr_msr_id		= "";
				String  age_group_code  = "",   dependency_yn  = "";//IN049133


				OrderDependency			= beanQueryObj.getOthFieldMnemonicValues(properties, format_id, seq_num, field_mnemonic, field_mnemonic_value , value_seq_num, patient_id);
			
				for(int i=0; i<OrderDependency.size(); i++)		// Only one record at a time
				{
					dependencyRecords		 = (String[])OrderDependency.get(i);
					format_id				 = beanQueryObj.checkForNull(dependencyRecords[0],"");
					parent_seq_num			 = beanQueryObj.checkForNull(dependencyRecords[1],"");
					parent_field_mnemonic	 = beanQueryObj.checkForNull(dependencyRecords[2],"");
					field_mnemonic_value	 = beanQueryObj.checkForNull(dependencyRecords[3],"");
					value_seq_num			 = beanQueryObj.checkForNull(dependencyRecords[4],"");
					field_mnemonic	 		 = beanQueryObj.checkForNull(dependencyRecords[5],"");
					seq_num					 = beanQueryObj.checkForNull(dependencyRecords[6],"");
					label_text				 = beanQueryObj.checkForNull(dependencyRecords[7],"");
					accept_option			 = beanQueryObj.checkForNull(dependencyRecords[8],"");
					dflt_value				 = beanQueryObj.checkForNull(dependencyRecords[9],"");
					field_type				 = beanQueryObj.checkForNull(dependencyRecords[10],"");
					min_num_value			 = beanQueryObj.checkForNull(dependencyRecords[11],"");
					max_num_value			 = beanQueryObj.checkForNull(dependencyRecords[12],"");
					help_text				 = beanQueryObj.checkForNull(dependencyRecords[13],"");
					new_discr_msr_id		 = beanQueryObj.checkForNull(dependencyRecords[14],"");
					age_group_code			 = beanQueryObj.checkForNull(dependencyRecords[15],"");
					dependency_yn			 = beanQueryObj.checkForNull(dependencyRecords[16],"");//IN049133

					int		new_no					 = Integer.parseInt(new_seq_num)+(i+1);
					out.println( "loadOtherMnemonicValues(\""+bean_id+"\",\""+bean_name+"\",\""+field_name+"\", \""+(new_field_name+new_no)+"\", \""+new_no+"\",\""+seq_num+"\",\""+format_id+"\",\""+parent_seq_num+"\",\""+parent_field_mnemonic+"\",\""+field_mnemonic_value+"\",\"" +value_seq_num+"\" ,\""+field_mnemonic+"\",\""+new_seq_num+"\",\""+label_text+"\",\"" +accept_option+"\" ,\""+dflt_value+"\",\""+field_type+"\",\""+min_num_value+"\",\""+max_num_value+"\",\""+help_text+"\",\""+new_discr_msr_id+"\",\""+age_group_code+"\",\""+dependency_yn+"\", \""+order_category+"\",\""+contr_msr_panel_id+"\",\""+contr_msr_mod_id+"\",\""+order_type_code+"\",\""+performing_facility_id+"\",\""+oper_side_appl_yn+"\",\""+specimen_def_yn+"\",\""+login_facility_id+"\", \""+sex+"\",\""+catalog_code+"\") ; " ) ; //IN049133 included dependency_yn
				} // End of for OrderDependencyFormat	 
				
		} // End of POPULATE_OTH_MNEMONIC //IN049133 - Start
		else if(func_mode.equals("CHECK_OTH_DEPENDENCY") || (func_mode.equals("CHECK_DEPENDENCY") & "Y".equals(oth_dependency_yn)))
		{
			OrderDependency = beanQueryObj.getOthDependencyValues(properties, format_id, Integer.parseInt(seq_num), field_mnemonic, field_value,field_type);
			for(int i=0; i<OrderDependency.size(); i++)		// Only one record at a time
			{
				dependencyRecords		 = (String[])OrderDependency.get(i);
				field_mnemonic_value	 = beanQueryObj.checkForNull(dependencyRecords[0],"");
				value_seq_num	 		 = beanQueryObj.checkForNull(dependencyRecords[1],"");
				field_value_type	 	 = beanQueryObj.checkForNull(dependencyRecords[2],"");
				field_mnemonic_action	 = beanQueryObj.checkForNull(dependencyRecords[3],"");
				field_action_msg		 = beanQueryObj.checkForNull(dependencyRecords[4],"");
				field_mnemonic_value1	 = beanQueryObj.checkForNull(dependencyRecords[5],"");
	
	 			out.println( "loadDecisionOthDependency(\""+field_name+"\", \""+new_field_name+"\", \""+bean_id+"\" , \""+bean_name+"\", \""+field_value+"\", \""+format_id+"\", \""+field_mnemonic+"\", \""+new_seq_num+"\", \""+seq_num+"\", \""+field_mnemonic_value+"\", \"" +value_seq_num+"\" , \""+field_value_type+"\", \""+field_mnemonic_action+"\", \"" +field_action_msg+"\" , \""+order_category+"\",\""+contr_msr_panel_id+"\",\""+contr_msr_mod_id+"\",\""+order_type_code+"\",\""+discr_msr_id+"\",\""+performing_facility_id+"\",\""+oper_side_appl_yn+"\",\""+specimen_def_yn+"\", \""+login_facility_id+"\", \""+sex+"\", \""+catalog_code+"\", \""+field_mnemonic_value1+"\") ; " ) ;
	 		}  
	 	}  // End of CHECK_OTH_DEPENDENCY
		//IN049133 - End
		if(OrderDependency!=null)
		{
			OrderDependency.clear(); 
			OrderDependency = null;
		}
		if(hash!=null)
		{
			hash.clear();			 
			hash = null;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}

%>
