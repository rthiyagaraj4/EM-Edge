<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page    import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%> 
<jsp:useBean id="alPackingDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="alPackingList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%

		PackingDiscrepancyListBean bean = (PackingDiscrepancyListBean)getBeanObject( "packingDiscrepancyListBean", "eSS.PackingDiscrepancyListBean", request ) ;  
	PackingListBean packingListBean	=	(PackingListBean)getBeanObject( "packingListBean", "eSS.PackingListBean" ,request ) ;

	PackingBean packingBean	=	(PackingBean)getBeanObject( "packingBean", "eSS.PackingBean" ,request ) ;
	
	Hashtable htXMLData				=	(Hashtable) XMLobj.parseXMLString(request);
	htXMLData						=	(Hashtable) htXMLData.get ("SEARCH");

	String validate					=	request.getParameter("validate");

	String group_code				=	request.getParameter("group_code");
	String tray_no					=	request.getParameter("tray_no");
	String item_code				=	request.getParameter("item_code");
	String item_desc				=	request.getParameter("item_desc");
	String write_off_reason_code	=	request.getParameter("write_off_reason_code");
	String write_off_reason_desc	=	request.getParameter("write_off_reason_desc");
	String discrepancy_qty			=	request.getParameter("discrepancy_qty"); 

	String remarks					=	request.getParameter("remarks"); ;
	String index					=	request.getParameter("index");


	String pack_item_code			=	request.getParameter("pack_item_code");
	String pack_item_desc			=	request.getParameter("pack_item_desc");
	String pack_item_qty			=	request.getParameter("pack_item_qty");

	String packing_date				=	request.getParameter("packing_date");
	String hold_reason				=	request.getParameter("hold_reason");
	String hold_yn					=	request.getParameter("hold_yn");
	String message					=	"";
	String flag						=	"";
	boolean	result					=	false;
	

	try{
		if (validate.equals("ADD_TO_DISCREPANCY_LIST")){
			HashMap hmListItems	=	new HashMap();

			double dPackingCost	= bean.getItemUnitCost(item_code);

			if (dPackingCost<0){
				throw new Exception("NOT_A_CSSD_ITEM");
			}
			if (remarks.length()>200){
				throw new Exception("REMARKS_EXCEEDS_LIMIT");
			}
			if(index.equals("-1")){
			if(item_code.equals(bean.getItem_code()))
			{
					
				throw new Exception("RECORD_ALREADY_EXISTS");

			}
			}
			if (!packingListBean.isValidDiscrepancyQty(group_code, tray_no, item_code, "N", discrepancy_qty )){
				throw new Exception("INVALID_DISCREPANCY_QTY_MSG");
			}

			
		

			if(alPackingDiscrepancyList.size()>0){
				int des_qty=0;
				for(int i=0;i<alPackingDiscrepancyList.size();i++){
						
				if(((String)(((HashMap)alPackingDiscrepancyList.get(i)).get("group_code"))).equals(group_code) && 
					((String)(((HashMap)alPackingDiscrepancyList.get(i)).get("tray_no"))).equals(tray_no)   &&  
					((String)(((HashMap)alPackingDiscrepancyList.get(i)).get("item_code"))).equals(item_code)){	
						des_qty=Integer.parseInt(discrepancy_qty)+des_qty+Integer.parseInt((String)(((HashMap)alPackingDiscrepancyList.get(i)).get("discrepancy_qty")));

					}
			    }

				if (!packingListBean.isValidDiscrepancyQty(group_code, tray_no, item_code, "N", ""+des_qty )){
					throw new Exception("INVALID_DISCREPANCY_QTY_MSG");
				}
			}

			if(bean.isItemAndDiscrepancyInArrayList(alPackingDiscrepancyList,item_code,write_off_reason_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			hmListItems.put("group_code",			group_code				);
			hmListItems.put("tray_no",				tray_no					);
			hmListItems.put("item_code",			item_code				);
			hmListItems.put("item_desc",			item_desc				);
			hmListItems.put("write_off_reason_code",write_off_reason_code	);
			hmListItems.put("write_off_reason_desc",write_off_reason_desc	);
			hmListItems.put("discrepancy_qty",		discrepancy_qty			);
			hmListItems.put("discrepancy_cost",		""+(Long.parseLong(discrepancy_qty)*dPackingCost)		);
			hmListItems.put("remarks",				remarks					);

			if(index.equals("-1")){
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				hmListItems.put("markedAsDelete",		"N"						);
				alPackingDiscrepancyList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alPackingDiscrepancyList.get(Integer.parseInt(index))).get("mode"));
				hmListItems.put("markedAsDelete",((HashMap)alPackingDiscrepancyList.get(Integer.parseInt(index))).get("markedAsDelete"));
				alPackingDiscrepancyList.set(Integer.parseInt(index),hmListItems);
			}
			result	=	true;
			message	=	"Done";
		}
		else if (validate.equals("PRESERVE_DISCREPANCY")){
			for(int i=0;i<alPackingDiscrepancyList.size();i++){
				String stMarkedForDeletion=(String)htXMLData.get("checkbox"+i);
				if(stMarkedForDeletion==null) continue;
				HashMap hmListItems	=	(HashMap) alPackingDiscrepancyList.get(i);
				hmListItems.put("markedAsDelete",stMarkedForDeletion);
			}
			result	=	true;
			message	=	"DonePRESERVE_DISCREPANCY";
		}
		else if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	(HashMap)alPackingList.get(Integer.parseInt(index));
			double dPackingCost=0;
			
			if(!pack_item_code.equals("")   ){
				dPackingCost	= bean.getItemUnitCost(pack_item_code);	
				if (dPackingCost<0){
					throw new Exception("NOT_A_CSSD_ITEM");
				}
			}
			
				hmListItems.put("PACK_ITEM_CODE",		bean.checkForNull(pack_item_code ,"" ));
				hmListItems.put("PACK_ITEM_DESC",		bean.checkForNull(pack_item_desc,""));
				hmListItems.put("PACK_ITEM_QTY",		bean.checkForNull(pack_item_qty,""));
				if(!pack_item_code.equals("")  )
			
				hmListItems.put("PACK_COST",		"100");
				hmListItems.put("remarks",				remarks					);
				hmListItems.put("hold_reason",			hold_reason				);
				hmListItems.put("hold_yn",				hold_yn.equals("true")?"Y":"N");
				hmListItems.put("packing_date",			packing_date);
				alPackingList.set(Integer.parseInt(index),hmListItems);
				
				
				result	=	true;
				
				message	=	"Done";
		}
		
			else if (validate.equals("doc_date")) {
				int isValidDocDate = -1;
				String doc_date = (String) htXMLData.get("packing_date");
				if (doc_date.trim().equals("")) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				
				isValidDocDate = bean.isValidDocDate(doc_date);

				if (isValidDocDate > 0) {
					if (isValidDocDate== 1) {

						throw new Exception("DOC_DT_NOT_LT_PROC_MTH");
					}
					else if (isValidDocDate== 2) {

						throw new Exception("DOC_DT_NOT_GR_SYSDATE");
					}
					out.println("requestDocDateFocus("+isValidDocDate+");");

				} 
				else {
					result = true;

				}

						
             }

			  else if (validate.equals("printOnlineDoc")){
			try{
				String pdocno=packingBean.getPrintDocNo();
				System.out.println("pdocno"+pdocno);
				//packingBean.doOnlineReportPrinting(pdocno,pdocno);
				packingBean.doOnlineReportPrinting(pdocno,pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
		
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}
		

	}
	catch (Exception exception){

		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{

		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	
putObjectInBean("packingDiscrepancyListBean",bean,request);
putObjectInBean("packingListBean",packingListBean,request);
putObjectInBean("packingBean",packingBean,request);
%>
