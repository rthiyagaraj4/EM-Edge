<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
03/05/2017		IN:064126		Badmavathi B								To remove Null Pointer Exception
22/07/2018      IN070913        B Haribabu                                  GHL-ICN-0049
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.BatchSearchBeanForBarcode,eST.Common.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%><!-- Added eST.Common for IN070913  -->

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj7" scope="page" class="eST.BatchSearchBeanForBarcode"/>
<%
		request.setCharacterEncoding("UTF-8");
		String locale					=	 (String)session.getAttribute("LOCALE");
		int functionType				=	Integer.parseInt(request.getParameter("function_type"));

		String bean_id					=	"batchSearchBeanForBarcode";
		String bean_name				=	"eST.BatchSearchBeanForBarcode";

		BatchSearchBeanForBarcode bean			=	(BatchSearchBeanForBarcode) getBeanObject( bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		//Modified for IN070913 start
		StHeaderBean beanHdr = (StHeaderBean) getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean", request );
		beanHdr.setLanguageId(locale);
		//Modified for IN070913 end
		Hashtable hash					=	(Hashtable) XMLobj.parseXMLString(request);
		hash							=	(Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
				String item_code_from				=		CommonBean.checkForNull(request.getParameter("item_code_from"),"");
				String item_code_to					=		CommonBean.checkForNull(request.getParameter("item_code_to"),"");
				String store_code_from				=		CommonBean.checkForNull(request.getParameter("store_code_from"),"");
				String store_code_to				=		CommonBean.checkForNull(request.getParameter("store_code_to"),"");
				String manufacturer_code			=		CommonBean.checkForNull(request.getParameter("manufacturer_code"),"");
				String period_of_expiry				=		CommonBean.checkForNull(request.getParameter("period_of_expiry"),"");
				String includeZeroStockBatches		=		CommonBean.checkForNull(request.getParameter("includeZeroStockBatches"),"N");
				String includeExpiredBatches		=		CommonBean.checkForNull(request.getParameter("includeExpiredBatches"),"N");
				String includeSuspendedBatches		=		CommonBean.checkForNull(request.getParameter("includeSuspendedBatches"),"N");
				String batch_id						=		CommonBean.checkForNull(request.getParameter("batch_id"),"")+"%";
				String Trade_code					=		CommonBean.checkForNull(request.getParameter("Trade_code"),"")+"%";
				String doc_type_code				=		CommonBean.checkForNull(request.getParameter("doc_type_code"),"");
				String doc_no						=		request.getParameter("doc_no");
				String trn_type						=		request.getParameter("trn_type");
				String item_class_from				=		CommonBean.checkForNull(request.getParameter("item_class_from"),"");
				String item_class_to				=		CommonBean.checkForNull(request.getParameter("item_class_to"),"");
				String drug_type				=		CommonBean.checkForNull(request.getParameter("drug_type"),"%");
				String barcode				=		CommonBean.checkForNull(request.getParameter("barcode"),"");
			   	String allow_zero_batches = CommonBean.checkForNull(request.getParameter("allow_zero_batches"),"");// Added for GHL-CRF-0503
			   	String store_code =beanHdr.getStore_code();//Modified for IN070913
				out.println(includeZeroStockBatches+"/"+includeExpiredBatches+"/"+includeSuspendedBatches);
				bean.setIncludeSuspendedBatches(includeSuspendedBatches) ;
				bean.setIncludeZeroStockBatches(includeZeroStockBatches) ;
				bean.setIncludeExpiredBatches(includeExpiredBatches) ;
				bean.setItem_code_from(item_code_from) ;
				bean.setItem_code_to(item_code_to) ;
				bean.setStore_code_from(store_code_from) ;
				bean.setStore_code_to(store_code_to) ;
				bean.setManufacturer_code(manufacturer_code) ;
				bean.setPeriod_of_expiry(period_of_expiry) ;
				bean.setBatch_id(batch_id) ;
				bean.setTrade_Code(Trade_code) ;
				bean.setItemClassFrom(item_class_from) ;
				bean.setItemClassTo(item_class_to) ;
				bean.setDrugType(drug_type) ;
				//Added against GHL-CRF-0446 starts
				String src_batch_id				=		CommonBean.checkForNull(request.getParameter("src_batch_id"),"");
				String src_bin_location_code			=		CommonBean.checkForNull(request.getParameter("src_bin_location_code"),"");
				String src_expiry_date				=		CommonBean.checkForNull(request.getParameter("src_expiry_date"),"");
				if(src_batch_id.length()>0){	
					bean.loadResultPage(doc_type_code,doc_no,trn_type,barcode,src_batch_id,src_bin_location_code,src_expiry_date,allow_zero_batches,store_code);//added allow_zero_batches for GHL-CRF-0503, Added store_code for IN070913
				}
				else{
				//Added against GHL-CRF-0446 ends
				bean.loadResultPage(doc_type_code,doc_no,trn_type,barcode);
				}
					}
		break;
		
		case 2:
		{
	}
		break;
		case 3:
		{
			out.println("document.forms[0].count.value=1;");
		}
		break;
		case 4:
		{
			bean.clear();
			String index					=		request.getParameter( "index" )==null?"":request.getParameter( "index" ) ;
			String noOfCheckedRecords		=		request.getParameter( "noOfCheckedRecords" )==null?"":request.getParameter( "noOfCheckedRecords" ) ;
			//Build an AL of selected batches
			bean.selectedBatches(index,noOfCheckedRecords);
			
		}
		break;	//Added against IN064126
		case 5:
		{
		String item_code_from = bean.checkForNull(request.getParameter("item_code_from"));	//Modified against IN064126
		//String item_code_from = request.getParameter("item_code_from");
		String item_code_to = bean.checkForNull(request.getParameter("item_code_to"),request.getParameter("item_code_from"));
		String p_list_all_trades_yn = request.getParameter("p_list_all_trades_yn");
		
		 if(!(item_code_from.equals("")) || (!(item_code_to.equals("")))){
		
		out.println("clearListItems('document.BatchSearchCriteria_Form.Trade_code"+p_list_all_trades_yn+"'); ");
        
		 ArrayList TradeIdArraylist=new ArrayList();
		 
		 TradeIdArraylist=bean.getTradeList(item_code_from,item_code_to);
		 
		   if (TradeIdArraylist!=null && TradeIdArraylist.size()>0)
					{
						HashMap record			= null;
						for(int i=0; i< TradeIdArraylist.size(); i++) 
						{
							record			=		(HashMap)TradeIdArraylist.get(i);
							String listRecord1		=		bean.checkForNull((String)record.get("TRADE_ID"));
							String listRecord2		=		bean.checkForNull((String)record.get("SHORT_NAME"));
		     		out.println("addListItem(\"document.BatchSearchCriteria_Form.Trade_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
				
				    }//End Of For
     							
				}//End Of 2nd Condition
		 
		 }else      //It is if the user clears the Items in the Criteria 
			{
             ArrayList TradeIdArraylist=new ArrayList();
			TradeIdArraylist=bean.getTradeList("","");
			out.println("clearListItems('document.BatchSearchCriteria_Form.Trade_code"+p_list_all_trades_yn+"'); ");
			if (TradeIdArraylist!=null && TradeIdArraylist.size()>0)
					{
						HashMap record			= null;
						for(int i=0; i< TradeIdArraylist.size(); i++) 
						{
							record			=		(HashMap)TradeIdArraylist.get(i);
							String listRecord1		=		bean.checkForNull((String)record.get("TRADE_ID"));
							String listRecord2		=		bean.checkForNull((String)record.get("SHORT_NAME"));
		     		out.println("addListItem(\"document.BatchSearchCriteria_Form.Trade_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
				
				    }
     							
				}
				
			}

		}
		break;

		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>
<%
	putObjectInBean(bean_id,bean,request);
%>
