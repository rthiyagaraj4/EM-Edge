<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,java.io.*,java.util.*,org.jdom.*,org.jdom.input.SAXBuilder, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>   



<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%!
private String checkForNull(String input){
	
	if(input == null || "null".equals(input)){
		input = "null";
	}
	return input;
}

private Hashtable parseXMLString1(String var1) {
      Hashtable var2 = new Hashtable();
      try {
		 Reader inputString = new StringReader(var1);
		 BufferedReader var3 = new BufferedReader(inputString);
         // BufferedReader var3 = var1.getReader();
         SAXBuilder var4 = new SAXBuilder();
         Document var5 = var4.build(var3);
         Element var6 = var5.getRootElement();
         ListIterator var7 = var6.getChildren().listIterator();

         while(var7.hasNext()) {
            Element var8 = (Element)var7.next();
            Hashtable var9 = new Hashtable();
            List var10 = var8.getAttributes();
            Iterator var11 = var10.iterator();
            while(var11.hasNext()) {
               Attribute var12 = (Attribute)var11.next();
               String var13 = var12.getValue().replace('"', '\n');
               var9.put(var12.getName(), var13);
            }
            var2.put(var8.getName(), var9);
         }
      } catch (Exception var14) {
		  System.err.println("error in parseXMLSStirng 1  "+var14.toString());
         var2.put("error", var14.toString());
      }
      return var2;
   }
%>
<%
//String bean_id		= "bl_MaintainTreatBean" ;
//String bean_name	= "eBL.MaintainTreatBean";


//PreApprovalRequestDetailsBean preApprovalRequestDetailsBean 	=  (PreApprovalRequestDetailsBean)getBeanObject(beanId, beanName, request);
//MaintainTreatBean bean= (MaintainTreatBean)getBeanObject( bean_id, bean_name, request ) ;	
Connection con = null;
try 
	{
		con = ConnectionManager.getConnection(request);
		System.err.println("MaintainTreatValidation.jsp...........................................................");
		request.setCharacterEncoding("UTF-8");
		//ArrayList test = 	new ArrayList();
		String locale = (String) session.getAttribute("LOCALE");
		String xmlValues=checkForNull(request.getParameter("xmlStr"));
		String count=checkForNull(request.getParameter("count"));
		System.out.println("Inside MaintainTreatValidation::::xmlValues  "+xmlValues);
		System.out.println("count---"+count); 
		Hashtable hash				= (Hashtable)parseXMLString1( xmlValues ) ;
		//Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		System.out.println(" hash .... Inside MaintainTreatValidation:::: "+hash);
		hash = (Hashtable) hash.get("SEARCH");
		System.out.println(" hash .... Inside MaintainTreatValidation2:::: "+hash);
		//String[] tempString = new String[25];
		
		
		String encounterCombinationString="";
		
		ArrayList<String> pkgServiceDetailsCombination = new ArrayList<String>();

		HashMap<String,ArrayList<String>>  pkgServiceDetailsEncounters=new HashMap<String,ArrayList<String>>();
		
		String patientId=(String)hash.get("patientid1");
		
		String visit_id=(String)hash.get("visit_id");
		String episode_id=(String)hash.get("episode_id");
		String episode_type=(String)hash.get("episode_type");
		
		System.err.println("patientId............"+patientId);
		System.err.println("cnt............"+(String)hash.get("cnt"));
		
		int totalRecords=Integer.parseInt((String)hash.get("index"));
	
		System.err.println("totalRecords............"+totalRecords);
		
		for (int i = 1; i<=totalRecords; i++) 
		{			 
			String hdn_pkg_serv_ind=(String) hash.get("pkg_serv_ind"+i);
			System.err.println("hdn_pkg_serv_ind 48"+hdn_pkg_serv_ind);
			// hdn_pkg_serv_ind=checkForNull(hdn_pkg_serv_ind);
			System.err.println("hdn_pkg_serv_ind 57"+hdn_pkg_serv_ind);
			//String hdn_pkg_serv_ind="G";
			
			if(hdn_pkg_serv_ind.equals("") || hdn_pkg_serv_ind.equals("null") || hdn_pkg_serv_ind == null)
			{
				System.err.println("hdn_pkg_serv_ind 52"+hdn_pkg_serv_ind);
				hdn_pkg_serv_ind="null";
			}
			System.err.println("hdn_pkg_serv_ind............"+hdn_pkg_serv_ind);

			String hdn_pkg_serv_code=(String) hash.get("pkg_serv_code"+i);
			// hdn_pkg_serv_code=checkForNull(hdn_pkg_serv_code);
			if(hdn_pkg_serv_code.equals("") || hdn_pkg_serv_code.equals("null") || hdn_pkg_serv_code == null)
			{
				hdn_pkg_serv_code="null";
			}
			System.err.println("hdn_pkg_serv_code............"+hdn_pkg_serv_code);
			
			String hdn_rate_charge_ind=(String) hash.get("rate_charge_ind"+i);
			// hdn_rate_charge_ind=checkForNull(hdn_rate_charge_ind);
			if(hdn_rate_charge_ind.equals("") || hdn_rate_charge_ind.equals("null")|| hdn_rate_charge_ind == null)
			{
				hdn_rate_charge_ind="null";
			}

			String hdn_order_catalog_code=(String) hash.get("order_catalog_code"+i);
			//hdn_order_catalog_code=checkForNull(hdn_order_catalog_code);
			System.err.println("hdn_order_catalog_code............"+hdn_order_catalog_code);
			if(hdn_order_catalog_code.equals("")|| hdn_order_catalog_code.equals("null") || hdn_order_catalog_code == null)
			{
				hdn_order_catalog_code="null";
			}
			System.err.println("hdn_order_catalog_code........125...."+hdn_order_catalog_code);
			
			String hdn_factor_rate_ind=(String) hash.get("factor_rate_ind"+i);
			// hdn_factor_rate_ind=checkForNull(hdn_factor_rate_ind);
			if(hdn_factor_rate_ind.equals("") || hdn_factor_rate_ind.equals("null") || hdn_factor_rate_ind == null)
			{
				hdn_factor_rate_ind="null";
			}

			String hdn_factor_rate=(String) hash.get("factor_rate"+i);
			//	hdn_factor_rate=checkForNull(hdn_factor_rate);
			if(hdn_factor_rate.equals("") ||hdn_factor_rate.equals("null") || hdn_factor_rate == null  )
			{
				hdn_factor_rate="null";
			}

			String hdn_qty_limit=(String) hash.get("qty_limit"+i);
			//		hdn_qty_limit=checkForNull(hdn_qty_limit);
			System.err.println("hdn_qty_limit 106 "+hdn_qty_limit);
			if(hdn_qty_limit.equals("") || hdn_qty_limit.equals("null") || hdn_qty_limit == null )
			{
				hdn_qty_limit="null";
			}

			String hdn_amt_limit_ind=(String) hash.get("amt_limit_ind"+i);
			//		hdn_amt_limit_ind=checkForNull(hdn_amt_limit_ind);
			if(hdn_amt_limit_ind.equals("")|| hdn_amt_limit_ind.equals("null") || hdn_amt_limit_ind == null)
			{
				hdn_amt_limit_ind="null";
			} 

			String hdn_amt_limit=(String) hash.get("amt_limit"+i);
			//		hdn_amt_limit=checkForNull(hdn_amt_limit);
			if(hdn_amt_limit.equals("") || hdn_amt_limit.equals("null") || hdn_amt_limit == null )
			{
				hdn_amt_limit="null";
			}
			//GrpsSrvind
			//	 String hdn_group_service_ind=(String) hash.get("hdn_group_service_ind"+i);
			String hdn_group_service_ind=(String) hash.get("GrpsSrvind"+i);
			// String hdn_group_service_ind="Y";
			//	hdn_group_service_ind=checkForNull(hdn_group_service_ind);
			System.err.println("hdn_group_service_ind "+hdn_group_service_ind);
			if(hdn_group_service_ind.equals("") || hdn_group_service_ind.equals("null") || hdn_group_service_ind == null)
			{
				System.err.println("hdn_group_service_ind "+hdn_group_service_ind);
				hdn_group_service_ind="B";
			}			
			System.err.println("hdn_group_service_ind "+hdn_group_service_ind);
			
			String hdn_incl_home_medication_yn=(String) hash.get("incl_home_medication_yn"+i);
			System.err.println("hdn_incl_home_medication_yn "+hdn_incl_home_medication_yn);
			//		hdn_incl_home_medication_yn=checkForNull(hdn_incl_home_medication_yn);
			if(hdn_incl_home_medication_yn.equals("") || hdn_incl_home_medication_yn.equals("null") ||  hdn_incl_home_medication_yn == null)
			{
				hdn_incl_home_medication_yn="N";
			}

			String hdn_replaceable_yn=(String) hash.get("replaceable_yn"+i);
			System.err.println("188,hdn_replaceable_yn "+hdn_replaceable_yn+" i="+i);
			//		hdn_replaceable_yn=checkForNull(hdn_replaceable_yn);
			if(hdn_replaceable_yn.equals("") || hdn_replaceable_yn.equals("null") || hdn_replaceable_yn == null)
			{
				hdn_replaceable_yn="N";
			}	

			String hdn_replaceable_serv_code=(String) hash.get("replaceable_serv_code"+i);
			//	 hdn_replaceable_serv_code=checkForNull(hdn_replaceable_serv_code);
			if(hdn_replaceable_serv_code.equals("") || hdn_replaceable_serv_code.equals("null") || hdn_replaceable_serv_code == null)
			{
				hdn_replaceable_serv_code="null";
			} 

			String hdn_rep_serv_ord_cat_code=(String) hash.get("rep_serv_ord_cat_code"+i);
			//	 hdn_rep_serv_ord_cat_code=checkForNull(hdn_rep_serv_ord_cat_code);
			if(hdn_rep_serv_ord_cat_code.equals("") || hdn_rep_serv_ord_cat_code.equals("null") || hdn_rep_serv_ord_cat_code == null)
			{
				hdn_rep_serv_ord_cat_code="null";
			}	
			System.err.println("hdn_rep_serv_ord_cat_code===>>132"+hdn_rep_serv_ord_cat_code);
			
			String hdn_daily_limit_ind=(String) hash.get("daily_limit_ind"+i);
			//	 hdn_daily_limit_ind=checkForNull(hdn_daily_limit_ind);
			System.err.println("hdn_daily_limit_ind===>>132"+hdn_daily_limit_ind);
			if(hdn_daily_limit_ind.equals("") || hdn_daily_limit_ind.equals("null") || hdn_daily_limit_ind == null)
			{
				hdn_daily_limit_ind="null";
			}	

			String hdn_daily_qty_limit=(String) hash.get("daily_qty_limit"+i);
			//	 hdn_daily_qty_limit=checkForNull(hdn_daily_qty_limit);
			if(hdn_daily_qty_limit.equals("") || hdn_daily_qty_limit.equals("null") || hdn_daily_qty_limit == null)
			{
				hdn_daily_qty_limit="null";
			}	

			String hdn_daily_amt_limit=(String) hash.get("daily_amt_limit"+i);
			//	 hdn_daily_amt_limit=checkForNull(hdn_daily_amt_limit);
			if(hdn_daily_amt_limit.equals("")  || hdn_daily_amt_limit.equals("null") || hdn_daily_amt_limit == null)
			{
				hdn_daily_amt_limit="null";
			}

			String hdn_daily_amt_limit_gross_net=(String) hash.get("GrossNet"+i);
			//	String hdn_daily_amt_limit_gross_net=(String) hash.get("hdn_daily_amt_limit_gross_net"+i);
			//String hdn_daily_amt_limit_gross_net="Y";
			//	 hdn_daily_amt_limit_gross_net=checkForNull(hdn_daily_amt_limit_gross_net);
			System.err.println("hdn_daily_amt_limit_gross_net+++++++++++++++++++++++++++++++++++++++"+hdn_daily_amt_limit_gross_net);
			if(hdn_daily_amt_limit_gross_net.equals("") || hdn_daily_amt_limit_gross_net.equals("null") || hdn_daily_amt_limit_gross_net == null)
			{
				hdn_daily_amt_limit_gross_net="null";
				System.err.println("hdn_daily_amt_limit_gross_net+++++++++++++++++++++++++++++++++++++++inside"+hdn_daily_amt_limit_gross_net);
			}	

			String hdn_refund_yn=(String) hash.get("refund_yn"+i);
			//	 hdn_refund_yn=checkForNull(hdn_refund_yn);
			if(hdn_refund_yn.equals("")  || hdn_refund_yn.equals("null") || hdn_refund_yn == null)
			{
				hdn_refund_yn="null";
			}

			String hdn_refund_rate=(String) hash.get("refund_rate"+i);
			//	hdn_refund_rate=checkForNull(hdn_refund_rate);
			if(hdn_refund_rate.equals("")  || hdn_refund_rate.equals("null") || hdn_refund_rate == null)
			{
				hdn_refund_rate="null";
			}	

			String hdn_auto_refund_yn=(String) hash.get("auto_refund_yn"+i);
			//	 hdn_auto_refund_yn=checkForNull(hdn_auto_refund_yn);
			if(hdn_auto_refund_yn.equals("")  || hdn_auto_refund_yn.equals("null") || hdn_auto_refund_yn == null)
			{
				hdn_auto_refund_yn="null";
			}

			String hdn_close_package_yn=(String) hash.get("close_package_yn"+i);
			//	hdn_close_package_yn=checkForNull(hdn_close_package_yn);
			if(hdn_close_package_yn.equals("")  || hdn_close_package_yn.equals("null") || hdn_close_package_yn == null)
			{
				hdn_close_package_yn="null";
			}	

			String hdn_utilized_serv_qty=(String) hash.get("utilized_serv_qty"+i);
			// hdn_utilized_serv_qty=checkForNull(hdn_utilized_serv_qty);
			if(hdn_utilized_serv_qty.equals("")  || hdn_utilized_serv_qty.equals("null") || hdn_utilized_serv_qty == null)
			{
				hdn_utilized_serv_qty="null";
			}	

			String hdn_utilized_serv_amt=(String) hash.get("utilized_serv_amt"+i);
			//	 hdn_utilized_serv_amt=checkForNull(hdn_utilized_serv_amt);
			if(hdn_utilized_serv_amt.equals("")  || hdn_utilized_serv_amt.equals("null") || hdn_utilized_serv_amt == null)
			{
				hdn_utilized_serv_amt="null";
			}	

			String hdn_apply_fact_for_srv_lmt_yn=(String) hash.get("apply_fact_for_srv_lmt_yn"+i);
			// hdn_apply_fact_for_srv_lmt_yn=checkForNull(hdn_apply_fact_for_srv_lmt_yn);
			if(hdn_apply_fact_for_srv_lmt_yn.equals("")  || hdn_apply_fact_for_srv_lmt_yn.equals("null") || hdn_apply_fact_for_srv_lmt_yn == null)
			{
				hdn_apply_fact_for_srv_lmt_yn="null";
			}	

			String hdn_split_allowed_yn=(String) hash.get("split_allowed_yn"+i);
			//	 hdn_split_allowed_yn=checkForNull(hdn_split_allowed_yn);
			if(hdn_split_allowed_yn.equals("")  || hdn_split_allowed_yn.equals("null") || hdn_split_allowed_yn == null)
			{
				hdn_split_allowed_yn="null";
			}	
			/*
			String package_code=(String) hash.get("hdn_package_code"+i);
			if(package_code.equals(""))
			{
				package_code="null";
			}

			String package_seq_no=(String) hash.get("hdn_package_seq_no"+i);
			if(package_seq_no.equals(""))
			{
				package_seq_no="null";
			}
			*/

			// String package_code=(String) hash.get("hdn_package_code"+i);
			String package_code=(String) hash.get("defaultPkgCode");
			// package_code=checkForNull(package_code);
			if(package_code.equals("")  || package_code.equals("null") || package_code == null)
			{
				package_code="null";
			}	
			System.out.println("package_code in validation @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+package_code);
			
			// String package_seq_no=(String) hash.get("hdn_package_seq_no"+i);
			String package_seq_no=(String) hash.get("defaultPkgSeq");
			//	 package_seq_no=checkForNull(package_seq_no);
			if(package_seq_no.equals("")  || package_seq_no.equals("null") || package_seq_no == null)
			{
				package_seq_no="null";
			}

			System.out.println("package_seq_no in validation @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+package_seq_no);

			// String defaultEffFromDate=(String) hash.get("eff_from_date"+i);
			String eff_from_date=(String) hash.get("defaultEffFromDate");
			//	 eff_from_date=checkForNull(eff_from_date);
			if(eff_from_date.equals("")  || eff_from_date.equals("null") || eff_from_date == null)
			{
				eff_from_date="null";
			}	

			String hdn_rowid= (String) hash.get("hdn_rowid"+i);	

			if(hdn_rowid== null || hdn_rowid.equals("null")|| hdn_rowid.equals("") )
			hdn_rowid="null"; 			
				
			String isRowMarkedForDeletionYN = (String) hash.get("hdn_row_marked_for_del_"+i);
			if(isRowMarkedForDeletionYN == null || isRowMarkedForDeletionYN.equals("null") || isRowMarkedForDeletionYN.equals("")) isRowMarkedForDeletionYN = "N"; 
			System.err.println("isRowMarkedForDeletionYN:"+isRowMarkedForDeletionYN);
			
			String isRowAddedNewlyYN = (String) hash.get("hdn_is_newly_added_row_YN_"+i);
			if(isRowAddedNewlyYN == null || isRowAddedNewlyYN.equals("null") || isRowAddedNewlyYN.equals("")) isRowAddedNewlyYN = "N"; 
			System.err.println("isRowAddedNewlyYN:"+isRowAddedNewlyYN);	
			
			String is_excl_mod_YN = (String) hash.get("is_excl_mod_YN_"+i);
			if(is_excl_mod_YN == null || is_excl_mod_YN.equals("null") || is_excl_mod_YN.equals("")) is_excl_mod_YN = "N"; 
			System.err.println("is_excl_mod_YN:"+is_excl_mod_YN);				
			
			String exclString = (String) hash.get("excl_string_"+i);
			if(exclString == null || exclString.equals("null") || exclString.equals("")) exclString = "N"; 
			System.err.println("exclString:"+exclString);				

			System.err.println("dddddddddddddddddddddddddddddddddddddddddddddddddddd"+hdn_rowid);
			 
			encounterCombinationString=hdn_pkg_serv_ind+"|"+
						hdn_pkg_serv_code+"|"+
						hdn_rate_charge_ind+"|"+
						
						hdn_order_catalog_code+"|"+
						hdn_factor_rate_ind+"|"+
						hdn_factor_rate+"|"+
						hdn_qty_limit+"|"+
						hdn_amt_limit_ind+"|"+
						hdn_amt_limit+"|"+
						
						hdn_group_service_ind+"|"+
						hdn_incl_home_medication_yn+"|"+
						hdn_replaceable_yn+"|"+
						hdn_replaceable_serv_code+"|"+
						hdn_rep_serv_ord_cat_code+"|"+
						
						hdn_daily_limit_ind+"|"+
						hdn_daily_qty_limit+"|"+
						hdn_daily_amt_limit+"|"+
						hdn_daily_amt_limit_gross_net+"|"+
						hdn_refund_yn+"|"+
						hdn_refund_rate+"|"+
						hdn_auto_refund_yn+"|"+
						
						hdn_close_package_yn+"|"+
						hdn_utilized_serv_qty+"|"+	
						hdn_utilized_serv_amt+"|"+
						hdn_apply_fact_for_srv_lmt_yn+"|"+
						hdn_split_allowed_yn+"|"+
						package_code+"|"+
						package_seq_no+"|"+
						eff_from_date+"|"+
						hdn_rowid+"|"+
						isRowMarkedForDeletionYN+"|"+
						isRowAddedNewlyYN+"|"+
						is_excl_mod_YN+"|"+
						exclString;
						
					 	System.err.println("encounterCombinationString"+encounterCombinationString);
						
						pkgServiceDetailsCombination.add(encounterCombinationString);
						
						System.err.println("pkgServiceDetailsCombination : : "+pkgServiceDetailsCombination);			
		}
		pkgServiceDetailsEncounters.put(patientId,pkgServiceDetailsCombination);

		session.setAttribute("PKGSERVICEDETAILSENCOUNTERS", pkgServiceDetailsEncounters);
		//	session.setAttribute("dbcount",count);

		System.err.println("pkgServiceDetailsEncounters"+pkgServiceDetailsEncounters);
	}
	catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception from maintaintreatValidation.jsp :"+ e);
	}	
%>
