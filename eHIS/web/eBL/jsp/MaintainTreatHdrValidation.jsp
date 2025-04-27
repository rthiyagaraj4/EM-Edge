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

Connection con = null;
try 
	{
		con = ConnectionManager.getConnection(request);
		System.err.println("MaintainTreatHdrValidation.jsp...........................................................");
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String xmlValues=checkForNull(request.getParameter("xmlStr"));
		System.err.println("Inside MaintainTreatValidation::::xmlValues  "+xmlValues);
		Hashtable hash				= (Hashtable)parseXMLString1( xmlValues ) ;
		System.err.println(" hash .... Inside MaintainTreathdrValidation:::: "+hash);
		hash = (Hashtable) hash.get("SEARCH");
		System.err.println(" hash .... Inside MaintainTreathdrValidation2:::: "+hash);
		
		
		String encounterhdrCombinationString="";
		
		ArrayList<String> pkghdrDetailsCombination = new ArrayList<String>();

		HashMap<String,ArrayList<String>>  pkghdrDetailsEncounters=new HashMap<String,ArrayList<String>>();
		
		String patientId=(String)hash.get("patid");
		/*
		String visit_id=(String)hash.get("visit_id");
		String episode_id=(String)hash.get("episode_id");
		String episode_type=(String)hash.get("episode_type");
		*/
		System.err.println("patientId............"+patientId);
		
		int totalRecords=Integer.parseInt((String)hash.get("totcount"));
	
		System.err.println("totalRecords..hdr.........."+totalRecords);
		
		for (int i = 1; i<=totalRecords; i++) 
		{
			 	 
			String package_code=(String) hash.get("package_code"+i);
			System.err.println("package_code "+package_code);

			if(package_code.equals("") || package_code.equals("null") || package_code == null)
			{
				package_code="null";
			}
			System.err.println("package_code............"+package_code);

			String package_seq_no=(String) hash.get("package_seq_no"+i);
			if(package_seq_no.equals("") || package_seq_no.equals("null") || package_seq_no == null)
			{
				package_seq_no="null";
			}
			System.err.println("package_seq_no............"+package_seq_no);

			String eff_from_date=(String) hash.get("eff_from_date"+i);
			if(eff_from_date.equals("") || eff_from_date.equals("null")|| eff_from_date == null)
			{
				eff_from_date="null";
			}
			
			String db_eff_from_date=(String) hash.get("db_eff_from_date"+i);
			if(db_eff_from_date.equals("") || db_eff_from_date.equals("null")|| db_eff_from_date == null)
			{
				db_eff_from_date="null";
			}

			String cust_group_code=(String) hash.get("cust_group_code"+i);
			//hdn_order_catalog_code=checkForNull(hdn_order_catalog_code);
			System.err.println("cust_group_code............"+cust_group_code);
			if(cust_group_code.equals("")|| cust_group_code.equals("null") || cust_group_code == null)
			{
				cust_group_code="null";
			}
			System.err.println("cust_group_code........125...."+cust_group_code);

			String cust_code=(String) hash.get("cust_code"+i);
			// hdn_factor_rate_ind=checkForNull(hdn_factor_rate_ind);
			if(cust_code.equals("") || cust_code.equals("null") || cust_code == null)
			{
				cust_code="null";
			}
			System.err.println("cust_code........125...."+cust_code);
			
			String deposit_amt=(String) hash.get("deposit_amt"+i);
			System.err.println("deposit_amt........125...."+deposit_amt);
			//	hdn_factor_rate=checkForNull(hdn_factor_rate);
			if(deposit_amt.equals("") ||deposit_amt.equals("null") || deposit_amt == null  )
			{
				deposit_amt="null";
			}
			System.err.println("deposit_amt........125...."+deposit_amt);

			String prac_code=(String) hash.get("prac_code"+i);
			//		hdn_qty_limit=checkForNull(hdn_qty_limit);
			System.err.println("prac_code 106 "+prac_code);
			if(prac_code.equals("") || prac_code.equals("null") || prac_code == null )
			{
				prac_code="null";
			}
			System.err.println("prac_code........125...."+prac_code);
			
			String userid=(String) hash.get("userid");
			//		hdn_amt_limit_ind=checkForNull(hdn_amt_limit_ind);
			if(userid.equals("")|| userid.equals("null") || userid == null)
			{
				userid="null";
			} 
			System.err.println("userid........125...."+userid);
			
			String ws_no=(String) hash.get("ws_no");
			//		ws_no=checkForNull(ws_no);
			if(ws_no.equals("") || ws_no.equals("null") || ws_no == null )
			{
				ws_no="null";
			}
			System.err.println("ws_no........125...."+ws_no);
			
			String visit_id=(String)hash.get("visit_id"+i);
			System.err.println("visit_id "+visit_id);
			if(visit_id.equals("") || visit_id.equals("null") || visit_id == null)
			{
				System.err.println("visit_id "+visit_id);
				visit_id="null";
			}
			
			String episode_id=(String)hash.get("episode_id"+i);
			if(episode_id.equals("") || episode_id.equals("null") || episode_id == null)
			{
				System.err.println("episode_id "+episode_id);
				episode_id="null";
			}
			
			String episode_type=(String)hash.get("episode_type"+i);
			if(episode_type.equals("") || episode_type.equals("null") || episode_type == null)
			{
				episode_type="null";
			}
			System.err.println("episode_type "+episode_type);

			String isAdhocDiscountMod = (String)hash.get("isAdhocDiscountMod_"+i);
			if(isAdhocDiscountMod.equals("") || isAdhocDiscountMod.equals("null") || isAdhocDiscountMod == null)
			{
				isAdhocDiscountMod="N";
			}
			System.err.println("isAdhocDiscountMod "+isAdhocDiscountMod);

			String adhocDiscString = (String)hash.get("delimAdhocDiscStr_"+i);
			if(adhocDiscString.equals("") || adhocDiscString.equals("null") || adhocDiscString == null)
			{
				adhocDiscString="null";
			}
			System.err.println("adhocDiscString "+adhocDiscString);

			String isPackageCancelYN = (String)hash.get("hid_cancel_pkg_YN_"+i);
			if(isPackageCancelYN.equals("") || isPackageCancelYN.equals("null") || isPackageCancelYN == null)
			{
				isPackageCancelYN="null";
			}
			System.err.println("isPackageCancelYN "+isPackageCancelYN);

			String cancelPkgReasonCode = (String)hash.get("cancel_code"+i);
			if(cancelPkgReasonCode.equals("") || cancelPkgReasonCode.equals("null") || cancelPkgReasonCode == null)
			{
				cancelPkgReasonCode="null";
			}
			System.err.println("cancelPkgReasonCode "+cancelPkgReasonCode);	
			
			String isEncounterAssYN = (String)hash.get("hid_enc_checkbox_dtl"+i);
			if(isEncounterAssYN.equals("") || isEncounterAssYN.equals("null") || isEncounterAssYN == null)
			{
				isEncounterAssYN="N";
			}
			System.err.println("isEncounterAssYN "+isEncounterAssYN);

			String encAssString = (String)hash.get("encAssString_"+i);
			if(encAssString.equals("") || encAssString.equals("null") || encAssString == null)
			{
				encAssString="null";
			}
			System.err.println("encAssString "+encAssString);
			
			String isEncounterDeAssYN = (String)hash.get("hid_enc_deass_chkb_"+i);
			if(isEncounterDeAssYN.equals("") || isEncounterDeAssYN.equals("null") || isEncounterDeAssYN == null)
			{
				isEncounterDeAssYN="N";
			}
			System.err.println("isEncounterDeAssYN "+isEncounterDeAssYN);	
			
			String isCancelUnProcessOrdersYN = (String)hash.get("hid_cncl_unprocess_ord_"+i);
			if(isCancelUnProcessOrdersYN.equals("") || isCancelUnProcessOrdersYN.equals("null") || isCancelUnProcessOrdersYN == null)
			{
				isCancelUnProcessOrdersYN="N";
			}
			System.err.println("isCancelUnProcessOrdersYN "+isCancelUnProcessOrdersYN);	

			String effDateAuthStr = (String)hash.get("effDateAuthStr");
			if(effDateAuthStr.equals("") || effDateAuthStr.equals("null") || effDateAuthStr == null)
			{
				effDateAuthStr="null";
			}
			System.err.println("effDateAuthStr "+effDateAuthStr);

			String adhocDiscAuthStr = (String)hash.get("adhocDiscAuthStr");
			if(adhocDiscAuthStr.equals("") || adhocDiscAuthStr.equals("null") || adhocDiscAuthStr == null)
			{
				adhocDiscAuthStr="null";
			}
			System.err.println("adhocDiscAuthStr "+adhocDiscAuthStr);

			String cnclPackAuthStr = (String)hash.get("cnclPackAuthStr");
			if(cnclPackAuthStr.equals("") || cnclPackAuthStr.equals("null") || cnclPackAuthStr == null)
			{
				cnclPackAuthStr="null";
			}
			System.err.println("cnclPackAuthStr "+cnclPackAuthStr);

			String assDeassAuthStr = (String)hash.get("assDeassAuthStr");
			if(assDeassAuthStr.equals("") || assDeassAuthStr.equals("null") || assDeassAuthStr == null)
			{
				assDeassAuthStr="null";
			}
			System.err.println("assDeassAuthStr "+assDeassAuthStr);

			String pkgServDtlsAuthStr = (String)hash.get("pkgServDtlsAuthStr");
			if(pkgServDtlsAuthStr.equals("") || pkgServDtlsAuthStr.equals("null") || pkgServDtlsAuthStr == null)
			{
				pkgServDtlsAuthStr="null";
			}
			System.err.println("pkgServDtlsAuthStr "+pkgServDtlsAuthStr);			
		
			encounterhdrCombinationString=package_code+"|"+
				package_seq_no+"|"+
				eff_from_date+"|"+
				cust_group_code+"|"+
				cust_code+"|"+
				deposit_amt+"|"+
				prac_code+"|"+
				userid+"|"+
				ws_no+"|"+
				visit_id+"|"+
				episode_id+"|"+
				episode_type + "|" +
				isAdhocDiscountMod + "|" +
				adhocDiscString + "|" +
				isPackageCancelYN + "|" +
				cancelPkgReasonCode + "|" +
				isEncounterAssYN  + "|" +
				encAssString + "|" +
				isEncounterDeAssYN + "|" +
				isCancelUnProcessOrdersYN + "|" +
				effDateAuthStr + "|" +
				adhocDiscAuthStr + "|" +
				cnclPackAuthStr + "|" +
				assDeassAuthStr + "|" +
				pkgServDtlsAuthStr + "|" +
				db_eff_from_date;
					
				System.err.println("encounterhdrCombinationString"+encounterhdrCombinationString);
				
				pkghdrDetailsCombination.add(encounterhdrCombinationString);
				
				System.err.println("pkghdrDetailsCombination : : "+pkghdrDetailsCombination);			
		}
		pkghdrDetailsEncounters.put(patientId,pkghdrDetailsCombination);

		session.setAttribute("PKGHDRDETAILSENCOUNTERS", pkghdrDetailsEncounters);
		//	session.setAttribute("dbcount",count);

		System.err.println("pkghdrDetailsEncounters"+pkghdrDetailsEncounters);
	}
	catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception from maintaintreathdrValidation.jsp :"+ e);
	}
%>
