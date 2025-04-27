<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125 . To Persist all the Price Discount Revision --%>

<%@page import="eBL.pkgpricerevision.bc.PkgPriceDisountBC"%>
<%@page import="eBL.pkgpricerevision.request.PackagePriceBean"%>
<%@page import="eBL.pkgpricerevision.request.BulkUpdateBean"%>
<%@page import="eBL.pkgpricerevision.request.PkgPriceRevisionRequest"%>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%!
	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}	
	
	
%>
<%
	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "PkgPriceRevisionRequest" ;
	String beanName = "eBL.pkgpricerevision.request.PkgPriceRevisionRequest";
	PkgPriceRevisionRequest pkgPriceDiscount = null;
	


	try 
	{
		pkgPriceDiscount = (PkgPriceRevisionRequest) getObjectFromBean(beanId, beanName, session);
		if(pkgPriceDiscount.getBulkUpdateDiscount() == null){
			pkgPriceDiscount.setBulkUpdateDiscount(new ArrayList<BulkUpdateBean>());
		}
		
		if(pkgPriceDiscount.getBulkUpdatePrice() == null){
			pkgPriceDiscount.setBulkUpdatePrice(new ArrayList<BulkUpdateBean>());
		}
		
		if(pkgPriceDiscount.getPriceRevision() == null){
			pkgPriceDiscount.setPriceRevision(new ArrayList<PackagePriceBean>());
		}
		
		if(pkgPriceDiscount.getDiscountRevision() == null){
			pkgPriceDiscount.setDiscountRevision(new ArrayList<PackagePriceBean>());
		}
		
		List<BulkUpdateBean> bulkUpdatePrice = pkgPriceDiscount.getBulkUpdatePrice();
		List<BulkUpdateBean> bulkUpdateDiscount = pkgPriceDiscount.getBulkUpdateDiscount();
		List<PackagePriceBean> priceRevision = pkgPriceDiscount.getPriceRevision();
		List<PackagePriceBean> discountRevision = pkgPriceDiscount.getDiscountRevision();
		
		String facility_id = (String)session.getAttribute("facility_id");
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	    PackagePriceBean priceBean = null;
	    BulkUpdateBean bulkUpd = null;
	    
		if(func_mode!= null && "priceRevision".equals(func_mode)){	
			String chkPkgCode = "";
			priceRevision = new ArrayList<PackagePriceBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("lastRowIndex"));
			for(int i=0;i<=lastRowIndex;i++){
				chkPkgCode = (String)hash.get("pkgCode"+i);
				if(chkPkgCode != null && !"".equals(chkPkgCode)){
					priceBean = new PackagePriceBean();
					priceBean.setPkgCode((String)hash.get("pkgCode"+i));
					priceBean.setPkgDesc((String)hash.get("pkgDesc"+i));
					priceBean.setCustGroupCode((String)hash.get("custGrp"+i));
					priceBean.setCustCode((String)hash.get("cust"+i));
					priceBean.setBlngClassCode((String)hash.get("blngClass"+i));
					priceBean.setCurrentPriceValue((String)hash.get("currentPrice"+i));
					priceBean.setCurrentPriceType((String)hash.get("currentType"+i));
					priceBean.setRevisedPriceValue((String)hash.get("revisedPrice"+i));
					priceBean.setRevisedPriceType((String)hash.get("revisedType"+i));
					priceBean.setEffectiveFrom((String)hash.get("effFrom"+i));
					priceBean.setEffectiveTo((String)hash.get("effTo"+i));
					priceBean.setStatus((String)hash.get("status"+i));
					priceBean.setPackagePrice((String)hash.get("pkgPrice"+i)); //added against mms-dm-crf-118.9 starts
					priceBean.setVAT((String)hash.get("VAT"+i));
					priceBean.setVatApplicable((String)hash.get("VATapp"+i));
					priceBean.setVatRule((String)hash.get("VATpercent"+i));
					priceBean.setRuleCoverage((String)hash.get("RuleCoverage"+i));//added against mms-dm-crf-118.9 ends	
					priceRevision.add(priceBean);
				}
			}
			pkgPriceDiscount.setPriceRevision(priceRevision);
		}
		else if(func_mode!= null && "discountRevision".equals(func_mode)){			
			String chkPkgCode = "";
			discountRevision = new ArrayList<PackagePriceBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("lastRowIndex"));
			for(int i=1; i<=lastRowIndex; i++ ){
				chkPkgCode = (String)hash.get("pkgCode"+i);
				if(chkPkgCode != null && !"".equals(chkPkgCode)){
					priceBean = new PackagePriceBean();
					priceBean.setPkgCode((String)hash.get("pkgCode"+i));
					priceBean.setPkgDesc((String)hash.get("pkgDesc"+i));
					priceBean.setBlngGroupCode((String)hash.get("blngGroup"+i));
					priceBean.setBlngClassCode((String)hash.get("blngClass"+i));
					priceBean.setCustGroupCode((String)hash.get("custGrp"+i));
					priceBean.setCustCode((String)hash.get("cust"+i));
					
					priceBean.setCurrentPriceValue((String)hash.get("currentValue"+i));
					priceBean.setCurrentPriceType((String)hash.get("currentType"+i));
					priceBean.setRevisedPriceValue((String)hash.get("revisedValue"+i));
					priceBean.setRevisedPriceType((String)hash.get("revisedType"+i));
					priceBean.setEffectiveFrom((String)hash.get("effFrom"+i));
					priceBean.setEffectiveTo((String)hash.get("effTo"+i));
					priceBean.setStatus((String)hash.get("status"+i));
					discountRevision.add(priceBean);
				}
			}
			pkgPriceDiscount.setDiscountRevision(discountRevision);
		}
		else if(func_mode!= null && "priceBulk".equals(func_mode)){		
			String pkgPriceType = "";
			bulkUpdatePrice = new ArrayList<BulkUpdateBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("lastRowIndex"));
			for(int i=1; i<=lastRowIndex; i++ ){
				pkgPriceType = (String)hash.get("pkgPriceType"+i);
				//if(pkgPriceType != null && !"".equals(pkgPriceType)){ commented against mms-dm-crf-118.9
					bulkUpd = new BulkUpdateBean();
					bulkUpd.setPkgPriceDiscType((String)hash.get("pkgPriceType"+i));
					bulkUpd.setPkgPriceDiscValue((String)hash.get("pkgPriceOrAmt"+i));
					bulkUpd.setMarkUpDown((String)hash.get("priceMarkUpDown"+i));
					bulkUpd.setRoundOff((String)hash.get("priceRoundOff"+i));
					bulkUpd.setRndMarkUpDown((String)hash.get("priceRndMarkUpDown"+i));
					bulkUpd.setEffectiveFrom((String)hash.get("effFrom"+i));	
					bulkUpd.setEffectiveTo((String)hash.get("effTo"+i));
					bulkUpd.setPackagePrice((String)hash.get("pkgPrice"+i)); //added against mms-dm-crf-118.9 starts
					bulkUpd.setVAT((String)hash.get("VAT"+i));
					bulkUpd.setVatApplicable((String)hash.get("VATapp"+i));
					bulkUpd.setVatRule((String)hash.get("VATpercent"+i));
					bulkUpd.setRuleCoverage((String)hash.get("RuleCoverage"+i));//added against mms-dm-crf-118.9 ends					
					bulkUpdatePrice.add(bulkUpd);
				//}
				
			}
			//pkgPriceDiscount.setPriceBulkUpdateFlag((String)hash.get("packageRate"));
			pkgPriceDiscount.setBulkUpdatePrice(bulkUpdatePrice);
		}
		else if(func_mode!= null && "discountBulk".equals(func_mode)){		
			String pkgPriceType = "";
			bulkUpdateDiscount = new ArrayList<BulkUpdateBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("lastRowIndex"));
			for(int i=1; i<=lastRowIndex; i++ ){
				pkgPriceType = (String)hash.get("pkgDiscType"+i);
				if(pkgPriceType != null && !"".equals(pkgPriceType)){
					bulkUpd = new BulkUpdateBean();
					bulkUpd.setPkgPriceDiscType((String)hash.get("pkgDiscType"+i));
					bulkUpd.setPkgPriceDiscValue((String)hash.get("discPriceOrAmt"+i));
					bulkUpd.setMarkUpDown((String)hash.get("discMarkUpDown"+i));
					bulkUpd.setRoundOff((String)hash.get("discRoundOff"+i));
					bulkUpd.setRndMarkUpDown((String)hash.get("discRndMarkUpDown"+i));
					bulkUpd.setEffectiveFrom((String)hash.get("effFrom"+i));
					bulkUpd.setEffectiveTo((String)hash.get("effTo"+i));	
					bulkUpdateDiscount.add(bulkUpd);
				}
				
			}
			//pkgPriceDiscount.setDiscountBulkUpdateFlag((String)hash.get("discountRate"));
			pkgPriceDiscount.setBulkUpdateDiscount(bulkUpdateDiscount);
		}
		else if(func_mode!= null && "persistHeader".equals(func_mode)){		
			String priceType = (String)hash.get("priceType");
			String updateType = (String)hash.get("updateType");
			String pkgCode = (String)hash.get("pkgCode");
			String blngClassCode = (String)hash.get("blngClassCode");
			String custGrpCode = (String)hash.get("custGrpCode");
			String custCode = (String)hash.get("custCode");
			String blngGrpCode = (String)hash.get("blngGrpCode");			
			String policyCode = (String)hash.get("policyCode"); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
			
			if("C".equals(priceType)){
				if("".equals(custGrpCode)){
					custGrpCode = "**";
				}
				if("".equals(custCode)){
					custCode = "**";
				}
			}
			else if("S".equals(priceType)){
				custGrpCode = "";
				custCode = "";
			}
			if("".equals(blngClassCode)){
				blngClassCode = "ALL";
			}
			if("".equals(blngGrpCode)){
				blngGrpCode = "ALL";
			}
			//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
			if("".equals(policyCode)){
				policyCode = "ALL";
			}
			//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
			pkgPriceDiscount.setPriceType(priceType);
			pkgPriceDiscount.setUpdateType(updateType);
			pkgPriceDiscount.setCustGroupCode(custGrpCode);
			pkgPriceDiscount.setCustCode(custCode);
			pkgPriceDiscount.setPkgCode(pkgCode);
			pkgPriceDiscount.setBlngClassCode(blngClassCode);
			pkgPriceDiscount.setBlngGroupCode(blngGrpCode);
			pkgPriceDiscount.setPolicyCode(policyCode); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
		}
		else if(func_mode!= null && "getPriceDiscMod".equals(func_mode)){
			String pageId = request.getParameter("pageId");
			String retVar = "";
			if("Bulk".equals(pageId)){
				if(bulkUpdatePrice.size()>0){
					retVar = "Y";
				}else{
					retVar = "N";
				}
				
				if(bulkUpdateDiscount.size()>0){
					retVar += ":::Y";
				}
				else{
					retVar += ":::N";
				}
				
			}
			else{
				if(priceRevision.size()>0){
					retVar = "Y";
				}else{
					retVar = "N";
				}
				
				if(discountRevision.size()>0){
					retVar += ":::Y";
				}
				else{
					retVar += ":::N";
				}
			}
			
			out.println(retVar);
		 }
		else if(func_mode!= null && "getPkgEffDates".equals(func_mode)){
			String pkgCode = request.getParameter("pkgCode");
			PkgPriceDisountBC priceDiscBC = new PkgPriceDisountBC();
			System.err.println("getPriceDiscMod"+pkgCode+","+facility_id);
			String retVal = priceDiscBC.getPkgEffectiveDates(pkgCode, facility_id);
			out.println(retVal);
		}
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from Pkg Price Revision :" + e);
	}
	finally
	{
		
	}

	putObjectInBean(beanId,pkgPriceDiscount,request);

%>


