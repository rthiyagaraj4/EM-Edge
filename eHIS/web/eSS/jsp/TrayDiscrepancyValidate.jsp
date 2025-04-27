<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%> 
<jsp:useBean id="alTrayDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
	String locale=(String)session.getAttribute("LOCALE");
	TrayDiscrepancyListBean bean = (TrayDiscrepancyListBean)getBeanObject( "trayDiscrepancyListBean",  "eSS.TrayDiscrepancyListBean",request) ;  
	String validate				=	request.getParameter("validate");

	String group_type			=	request.getParameter("group_type");
	String group_code			=	request.getParameter("group_code");
	String store_code			=	request.getParameter("store_code");
	String tray_no				=	request.getParameter("tray_no");

	String item_code			=	request.getParameter("item_code");
	String write_off_reason_code=	request.getParameter("write_off_reason_code");
	String remarks				=	request.getParameter("remarks");
	String discrepancy_qty		=	request.getParameter("discrepancy_qty");
	String discrepancy_type		=	request.getParameter("discrepancy_type");
	String item_desc			=	request.getParameter("item_desc");
	String write_off_reason_desc=	request.getParameter("write_off_reason_desc");

	String index				=	request.getParameter("index");

	String message				=	"initmessage";
	String flag				=	"";
	boolean	result			=	false;
	try{

		if (validate.equals("GROUP_DESC")){
			try{
				HashMap	hmRecord	=	bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_GROUP_SELECT_SINGLE"),group_code.toUpperCase());
				if (!hmRecord.get("GROUP_TYPE").toString().equals(group_type)){
					throw new Exception();				
				}
				if (!hmRecord.get("EFF_STATUS").toString().equals("E")){
					throw new Exception();				
				}
				out.println("setGroupDetails(\""+group_code.toUpperCase()+"\",\""+hmRecord.get("SHORT_DESC").toString()+"\");");
				result	=	true;
				message	=	"Done";
			}
			catch(Exception exception){
				flag			=	"INVALID_GROUP_CODE";
				result			=	false;
			}
		}

		else if (validate.equals("POPULATE_DISCREPANCY")){
			ArrayList alParameters=new ArrayList(3);
			alParameters.add(store_code);
			alParameters.add(group_code);
			alParameters.add(tray_no);
		if(bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT_VALID_FOR_TRD"),alParameters).get("TOTAL").toString().equals("0")){
				throw new Exception("INVALID_TRAY_NO");
			}
			ArrayList alParam=new ArrayList(2);
			alParam.add(group_code);
			alParam.add(locale);
			ArrayList alRecords	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),alParam);
			for (int i=0; i<alRecords.size(); i++){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				out.println(  "addListItem(\"parent.frameTrayDiscrepancyDetail.document.formTrayDiscrepancyDetail.item_code\",\""+hmRecord.get("ITEM_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
			}

			alParameters=new ArrayList(3);
			alParameters.add(group_code);
			alParameters.add(tray_no);

			alRecords	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_DISCREPANCY_DTL_SELECT_MULTIPLE_FOR_TRD"),alParameters);
			for (int i=0; i<alRecords.size(); i++){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				hmRecord.put("item_code",			hmRecord.get("ITEM_CODE")				);
				hmRecord.put("write_off_reason_code",hmRecord.get("WRITE_OFF_REASON_CODE")	);
				hmRecord.put("item_desc",			hmRecord.get("ITEM_DESC")				);
				hmRecord.put("write_off_reason_desc",hmRecord.get("WRITE_OFF_REASON_DESC")	);
				hmRecord.put("remarks",				hmRecord.get("REMARKS")					);
				hmRecord.put("discrepancy_qty",		hmRecord.get("DISCREPANCY_QTY")			);
				hmRecord.put("discrepancy_type",	hmRecord.get("DISCREPANCY_TYPE")		);
				hmRecord.put("usage_ind",			hmRecord.get("USAGE_IND")				);
				hmRecord.put("charge_amt",			bean.checkForNull((String)hmRecord.get("CHARGE_AMT"))				);
				hmRecord.put("finalized_yn",		hmRecord.get("FINALIZED_YN")			);
				hmRecord.remove("ITEM_CODE"				);
				hmRecord.remove("WRITE_OFF_REASON_CODE"	);
				hmRecord.remove("ITEM_DESC"				);
				hmRecord.remove("WRITE_OFF_REASON_DESC"	);
				hmRecord.remove("REMARKS"				);
				hmRecord.remove("DISCREPANCY_QTY"		);
				hmRecord.remove("DISCREPANCY_TYPE"		);
				hmRecord.remove("CHARGE_AMT"			);
				hmRecord.remove("FINALIZED_YN"			);
				hmRecord.put("mode",bean.getCommonRepositoryValue("MODE_MODIFY"));
				alTrayDiscrepancyList.add(hmRecord);
			}
			out.println("disableHeader();");
			out.println("refreshList();");
			result	=	true;
			message	=	"Done"+validate;
		}
		else if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	new HashMap();

			if(bean.isItemAndDiscrepancyInArrayList(alTrayDiscrepancyList,item_code,write_off_reason_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			if(remarks.length()>200)
				throw new Exception("REMARKS_EXCEEDS_MAX_LIMIT");
			double dPackingCost	= bean.getItemUnitCost(item_code);	
			if (dPackingCost<0){
				throw new Exception("NOT_A_CSSD_ITEM");
			}

			if (!bean.isValidDiscrepancyQty(group_code, tray_no, item_code, discrepancy_type, discrepancy_qty )){
				throw new Exception("INVALID_DISCREPANCY_QTY_MSG");
			}

			hmListItems.put("item_code",			item_code				);
			hmListItems.put("write_off_reason_code",write_off_reason_code	);
			hmListItems.put("remarks",				remarks					);
			hmListItems.put("discrepancy_qty",		discrepancy_qty			);
			hmListItems.put("discrepancy_type",		discrepancy_type		);
			hmListItems.put("item_desc",			item_desc				);
			hmListItems.put("write_off_reason_desc",write_off_reason_desc	);
			hmListItems.put("charge_amt",			""+(Integer.parseInt(discrepancy_qty)*dPackingCost));

			if(index.equals("-1")){
				hmListItems.put("usage_ind","O");
				hmListItems.put("finalized_yn","N");
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alTrayDiscrepancyList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("mode"));
				hmListItems.put("usage_ind",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("usage_ind"));
				hmListItems.put("finalized_yn",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("finalized_yn"));
				alTrayDiscrepancyList.set(Integer.parseInt(index),hmListItems);
			}
			result	=	true;
			message	=	"Done";
		}
		else if(validate.equals("POPULATE_COST")){
			item_code			=	request.getParameter("item_code");
			String desc_qty			=	request.getParameter("desc_qty");
			
			double dPackingCost	= bean.getItemUnitCost(item_code);		out.println("document.forms[0].charge_amt.value=(\""+Integer.parseInt(desc_qty)*dPackingCost+"\");");
			result	=	true;
			message	=	"Done";
		}
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		//exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
putObjectInBean("trayDiscrepancyListBean",bean,request);

%>
