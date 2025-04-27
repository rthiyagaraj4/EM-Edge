 <%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
06/02/2017		IN0063027			Badmavathi B							GHL-CRF-0413.7 - US009 - Barcode search
---------------------------------------------------------------------------------------------------------------
*/
%>
 <%@page import=" eST.CondemnExpiredBatchesHeaderBean,java.util.ArrayList,java.util.HashMap,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 


<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	String bean_id = CommonBean.checkForNull(request.getParameter( "bean_id" ),"condemnExpiredBatchesHeaderBean") ;
	String bean_name = CommonBean.checkForNull(request.getParameter( "bean_name" ),"eST.CondemnExpiredBatchesHeaderBean") ;
	CondemnExpiredBatchesHeaderBean bean = (CondemnExpiredBatchesHeaderBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	
	String doc_type_code	=	request.getParameter("doc_type_code");
	String validate		=	request.getParameter("validate");
	String doc_no		=	request.getParameter("doc_no");
	String doc_ref		=	request.getParameter("doc_ref");
	String doc_date		=	request.getParameter("doc_date");
	String adj_remarks	=	request.getParameter("adj_remarks");
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
	String adj_remarks_desc	=	CommonBean.checkForNull(request.getParameter("adj_remarks_desc"));
	String message		=	"";
	String flag		=	"";
	boolean	result		=	false;
	// doc_date = com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
	 
	try {
		if(validate.equals("UPDATE_VALUES")) {
		     String remarks = bean.checkForNull(bean.getAdj_remarks());
			 remarks = java.net.URLEncoder.encode(remarks,"UTF-8");
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) beg
			 if(!locale.equals("en"))
				{
				doc_date=	com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale);	
				}else
				{
				doc_date=bean.getDoc_date();
				}
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) end
			/*out.println("setDocumentDetails(\""+bean.getDoc_type_desc(bean.getDoc_type_code())+"\", \""+bean.getDoc_no()+"\", \""+bean.getDoc_date()+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\" );");*/			
            //Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 	
			//out.println("setDocumentDetails(\""+bean.getDoc_type_desc(bean.getDoc_type_code())+"\", \""+bean.getDoc_no()+"\", \""+bean.getDoc_date()+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\" , \""+remarks+"\");");	
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990)
			out.println("setDocumentDetails(\""+bean.getDoc_type_desc(bean.getDoc_type_code())+"\", \""+bean.getDoc_no()+"\", \""+doc_date+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\" , \""+remarks+"\");");
			/* removed for not displaying remarks..
			out.println("setDocumentDetails(\""+bean.getDoc_type_desc()+"\", \""+bean.getDoc_no()+"\", \""+bean.getDoc_date()+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\", \""+bean.getAdj_remarks()+"\");");			
			*/
			result	=	true;
			message	=	validate;			
		}
		else if(validate.equals("SET_DETAILS")) {
 
			bean.setDoc_type_code (doc_type_code);
			//bean.setDoc_date (doc_date); Commented by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990)
			bean.setDoc_ref (doc_ref);
			//bean.setDoc_no (doc_no);
			bean.setAdj_remarks (adj_remarks);
			bean.setAdj_remarks_Desc(adj_remarks);
			 
			//added by Rabbani on 06-MAR-2013 against inc no:29954
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) beg
           //doc_date = com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
           if(!locale.equals("en"))
			{
        	   doc_date=	com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
			}
				else
			{
					doc_date=doc_date;
			}
			bean.setDoc_date (doc_date);
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) end
			int iValidDocDate = bean.isValidDocDate(doc_date);
			if (iValidDocDate > 0) {
				if (iValidDocDate== 1) 
					throw new Exception( "ST_DOC_DT_NOT_LT_PROC_MTH");
				else if (iValidDocDate== 2) 
					throw new Exception( "ST_DOC_DT_NOT_GR_SYSDATE");
			}
			
			

			result	= true;
			message	= validate + doc_type_code + doc_date + doc_ref + doc_no;	
		}
		else if(validate.equals("LOAD_DATA")) {
			
			String from_date =  (String)request.getParameter("from_date");
			String to_date =  (String)request.getParameter("to_date");
			String from_item =  (String)request.getParameter("from_item");
			String to_item =  (String)request.getParameter("to_item");
			String from_store =  (String)request.getParameter("from_store");
			String to_store =  (String)request.getParameter("to_store");
			String batch_id =  (String)request.getParameter("batch_id");
			String exp_yn =  (String)request.getParameter("exp_yn");// Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
			
			
			HashMap hmParam = new HashMap();
			
			hmParam.put("from_date",from_date);
			hmParam.put("to_date",to_date);
			hmParam.put("from_item",from_item);
			hmParam.put("to_item",to_item);
			hmParam.put("from_store",from_store);
			hmParam.put("to_store",to_store);
			hmParam.put("batch_id",batch_id);
			hmParam.put("exp_yn",exp_yn); // Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
			
			
			bean.loadExpired_batches(hmParam);
		
			result	= true;			
			
		}
		else if(validate.equals("VALIDATE")) {

			 result = bean.validateCheckedCount(htFormValues);
		}
//  Added for online printing on 10/1/2004

		else if (validate.equals("printOnlineDoc")){
		   ArrayList alData     =  bean.getPrintDocNo();
			try{
			// Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
			//for(int i=0;i<alData.size();i++){
				 String pdoc_no = (String)alData.get(1);
				 String pdoc_type_code = (String)alData.get(0);
				 bean.doOnlineReportPrinting(pdoc_no,pdoc_type_code,request,response);
			  //}
			//bean.CalldoOnlineReportPrinting();	
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");

		}else if(validate.equals("CHECKEDCOMMITED")){
			try
			{
				 result = false;
				String checkedValues = (String) htFormValues.get("checkedValues");

			 java.util.StringTokenizer st	=		new java.util.StringTokenizer(checkedValues,"~");
				 ArrayList arr					=		new ArrayList();
				 while( st.hasMoreElements())
				 {
					 arr.add(st.nextElement() );
			 	 }

				String count="0";
				String item_code="";
				String store_code="";
				String batch_id="";
				String bin_location_code="";
				String expiry_date_or_receipt_date="";
				String trade_id="";
				String qty_on_hand="";
				String replace_on_expiry_yn="";
				String item_desc = "";
				 
				for(int i=0;i<arr.size();i++){
				String stBatch = (String)arr.get(i);
				StringTokenizer st1 = new StringTokenizer (stBatch,"||");
				 while( st1.hasMoreElements())
				 {
				 item_code=(String)st1.nextElement();
				 store_code=(String)st1.nextElement();
				 batch_id=(String)st1.nextElement();
				 bin_location_code=(String)st1.nextElement();
				 expiry_date_or_receipt_date=(String)st1.nextElement();
				 trade_id=(String)st1.nextElement();
				 qty_on_hand=(String)st1.nextElement();
				 replace_on_expiry_yn=(String)st1.nextElement();
				 
				   
				 }
				 
				
				 
					
					count=(String)bean.fetchRecord("SELECT COUNT (*) count  FROM st_item_batch WHERE item_code = ? AND store_code = ? AND  batch_id = ?  AND bin_location_code = ? AND  expiry_date_or_receipt_date = TO_DATE (?, 'dd/mm/yyyy') and committed_qty >0 ",new String[]{item_code,store_code,batch_id,bin_location_code,expiry_date_or_receipt_date}).get("COUNT");
					if(Integer.parseInt(count) >0){
					result=true;
					
					message=(String)bean.fetchRecord("select short_desc from mm_store_lang_vw where store_code = ? and language_id = ?",new String[]{store_code,locale}).get("SHORT_DESC");
					item_desc =(String)bean.fetchRecord("select short_desc from mm_item_lang_vw where item_code=? and language_id=?",new String[]{item_code,locale}).get("SHORT_DESC");
					item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
					 if(!locale.equals("en"))
				{
                 expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date, "DMY" , "en",locale);
				}
					flag=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.item.label","common_labels")+": "+item_desc+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BatchID.label","common_labels")+": "+batch_id+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+": "+expiry_date_or_receipt_date;
					break;
					}

					}

				}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}
// End of Online printing on 10/1/2004
		//Added for GHL-CRF-0413.7 starts
		else if(validate.equals("VALID_BARCODE")){
			String barcode = request.getParameter("barcode");
			String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Adding start for MMS-DM-CRF-0174.6
			String item_code ="";
			String batch_id  ="";
			String list_item_code ="";
			String list_batch_id ="";
			ArrayList barcodeBatches =bean.get2DBarcodeBacthes("",barcode);//Adding end for MMS-DM-CRF-0174.6
			result = false;
			try{
				int barcodeExists = 0;
				ArrayList alExpiredBatches = bean.getExpired_batches();	
				 HashMap hmBatch = new HashMap();
				 String list_barcode = "";
				int selectedBatch=0;
				for(int i=0;i<alExpiredBatches.size();i++){
					 hmBatch = (HashMap)alExpiredBatches.get(i);
					 list_item_code =(String) hmBatch.get("item_code");//Adding start for MMS-DM-CRF-0174.6
					 list_batch_id =(String) hmBatch.get("batch_id");
					 if(barcode_2d_applicable_yn.equals("Y")){
						 if(barcodeBatches.size()>0){
						      HashMap batch =(HashMap)barcodeBatches.get(0);
                               item_code = (String)batch.get("ITEM_CODE");
							   batch_id  = (String)batch.get("BATCH_ID");
							   System.err.println("item_code==="+item_code+"list_item_code=="+list_item_code+"batch_id=="+batch_id+"list_batch_id=="+list_batch_id);
							   if(item_code.equals(list_item_code)&& batch_id.equals(list_batch_id)){
                                   selectedBatch = i;
						           barcodeExists++;
							   }
						 }
					 }else{//Addign end for MMS-DM-CRF-0174.6
					 list_barcode = (String) hmBatch.get("barcode_id");
					     if(barcode.equals(list_barcode)){
						       selectedBatch = i;
						       barcodeExists++;
					      }
					 }
				}
				if( barcodeExists != 0){
				   	  result = true;
				   	  message = ""+selectedBatch;
				}
				else{
				   	  result = false;
				}
			}
			catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
				flag = "";
			}
		}
		//Added for GHL-CRF-0413.7 ends
	}
	catch (Exception exception) {	
		result	=	false;
		message	=	exception.getMessage();
	}
	finally {
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
