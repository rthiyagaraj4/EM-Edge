<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%> 
<jsp:useBean id="alReturnInstrumentsList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
	ReturnInstrumentsListBean bean		=	(ReturnInstrumentsListBean)getBeanObject( "returnInstrumentsListBean", "eSS.ReturnInstrumentsListBean", request ) ;

	String doc_type_code				=	request.getParameter("doc_type_code");
	String validate						=	request.getParameter("validate");

	String item_code					=	request.getParameter("item_code");
	String item_desc					=	request.getParameter("item_desc");
	String ret_item_qty					=	request.getParameter("ret_item_qty");
	String damaged_yn					=	request.getParameter("damaged_yn");
	String contaminated_yn				=	request.getParameter("contaminated_yn");
	String remarks						=	request.getParameter("remarks");
	String ret_store_code				=	request.getParameter("ret_store_code");
	String rec_store_code				=	request.getParameter("rec_store_code");
	String mode							=	request.getParameter("mode");
	
	String patient_id					=	request.getParameter("patient_id");
	String index						=	request.getParameter("index");
	String expiry_date                  =   request.getParameter("expiry_date");//Added for TH-KW-CRF-0030

	String message						=	"";
	String flag							=	"";
	boolean	result						=	true;

	try{
		if (validate.equals("DOC_TYPE_CODE")){
			out.println("enableDocNo("+!bean.isDocNoAutoGenYN(doc_type_code)+");");
		}
		else if (validate.equals("PATIENT_NAME")){
			try{
				out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\");");
				out.println("populateItem();");
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
		}
		else if (validate.equals("POPULATE_ITEM_CODE")){
			ArrayList alRecords	=	null;
			ArrayList alParameters	=	new ArrayList(4);
			alParameters.add(bean.getLoginFacilityId());
			alParameters.add(ret_store_code);
			alParameters.add(rec_store_code);
			alParameters.add(bean.checkForNull(patient_id,""));
			alRecords = bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_RETURN_DISCREPANCY_DTL_SELECT_LIST"),alParameters);
				
			out.println(  "clearListItems(\"parent.frameReturnInstrumentsDetail.document.formReturnInstrumentsDetail.item_code\");"  );
			if(alRecords==null) return;
			for (int i=0;i<alRecords.size();i++){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				out.println(  "addListItem(\"parent.frameReturnInstrumentsDetail.document.formReturnInstrumentsDetail.item_code\",\""+hmRecord.get("CODE")+"\",\""+hmRecord.get("DESCRIPTION")+"\");"  );
			}
		}

		else if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	new HashMap();

			if(bean.isItemInArrayList(alReturnInstrumentsList,item_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			if(remarks.length()>200){
				throw new Exception("REMARKS_EXCEEDS_MAX_LIMIT");
			}
			
			StringTokenizer stItem_code	=	new StringTokenizer(item_code,"|");//21052
			String strGroup_code	=	stItem_code.nextToken();
			String strTray_no		=	stItem_code.nextToken();
			String strItem_code		=	stItem_code.nextToken();
			String streExpiry_Date	=	stItem_code.nextToken();//Added for TH-KW-CRF-0030
		
			HashMap hmRecord	=	null;
			ArrayList alParameters	=	new ArrayList(7);
			alParameters.add(bean.getLoginFacilityId());
			alParameters.add(ret_store_code);
			alParameters.add(rec_store_code);
			alParameters.add(bean.checkForNull(patient_id,""));
			alParameters.add(strItem_code);
			alParameters.add(strTray_no);
			alParameters.add(strGroup_code);
			
			hmRecord = bean.fetchRecord("SELECT dtl.discrepancy_qty-dtl.returned_qty pending_qty,dtl.discrepancy_qty DISCREPANCY_QTY FROM ss_return_hdr hdr, ss_return_discrepancy_dtl dtl, ss_group ss, mm_item mm WHERE ss.group_code=dtl.group_code AND mm.item_code=dtl.item_code AND hdr.doc_type_code = dtl.doc_type_code AND hdr.FACILITY_ID=dtl.FACILITY_ID AND hdr.doc_no=dtl.doc_no  AND (dtl.discrepancy_qty - dtl.returned_qty) >= 0  AND item_returnable_yn='Y' AND hdr.facility_id=? AND hdr.fr_store_code=? AND hdr.to_store_code=? AND NVL(dtl.patient_id,'~')=nvl(?,nvl(dtl.patient_id,'~')) AND dtl.item_code=? AND dtl.tray_no=? AND dtl.group_code=?",alParameters);
		
			
			if(mode.equals(bean.getCommonRepositoryValue("MODE_INSERT"))){
			if(Long.parseLong(ret_item_qty)>Long.parseLong(hmRecord.get("PENDING_QTY").toString()) ){
				
				throw new Exception("RETURN_EXCEEDS_PENDING");
			}
			}
			else
			{
			if(Long.parseLong(ret_item_qty)>Long.parseLong(hmRecord.get("DISCREPANCY_QTY").toString()) ){
				
				throw new Exception("RETURN_EXCEEDS_PENDING");
			}
			}
			System.err.println("Returned Qty"+ret_item_qty);
			hmListItems.put("item_code",		item_code		);
			hmListItems.put("item_desc",		item_desc		);
			hmListItems.put("ret_item_qty",		ret_item_qty	);
			hmListItems.put("ret_item_cost",	""+(bean.getItemUnitCost(strItem_code)*Double.parseDouble(ret_item_qty)));
			hmListItems.put("damaged_yn",		damaged_yn.equals("true")?"Y":"N"		);
			hmListItems.put("contaminated_yn",	contaminated_yn.equals("true")?"Y":"N"	);
			hmListItems.put("remarks",			remarks			);
			hmListItems.put("expiry_date",			streExpiry_Date			);//Added for TH-KW-CRF-0030
			System.err.println(item_code+item_desc+ret_item_qty+(bean.getItemUnitCost(strItem_code)*Double.parseDouble(ret_item_qty))+damaged_yn+contaminated_yn+remarks);
			if(index.equals("-1")){
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alReturnInstrumentsList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alReturnInstrumentsList.get(Integer.parseInt(index))).get("mode"));
				System.err.println("hmListItems "+hmListItems);
				alReturnInstrumentsList.set(Integer.parseInt(index),hmListItems);
			}
			System.err.println("hmListItems "+hmListItems);
			out.println("disableStorePatient();");
			result	=	true;
			message	=	"Done";
		}

	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		System.err.println("message "+message);
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
putObjectInBean("returnInstrumentsListBean",bean,request);
%>
