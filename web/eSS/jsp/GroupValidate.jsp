
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*,eSS.Common.*,java.util.*"%>  
<jsp:useBean id="alGroupList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="alCheckList" scope="session" class="java.util.ArrayList" />
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	GroupItemBean bean = (GroupItemBean)getBeanObject( "groupItemBean", "eSS.GroupItemBean",request ) ;  
	String item_code		=	request.getParameter("item_code");
	String item_qty			=	request.getParameter("item_qty");
	String validate			=	request.getParameter("validate");
	String description		=	"";
	String index			=	request.getParameter("index");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	true;

	try{
		if (validate.equals("ITEM_DESC")){
			try{
				out.println("setItemDetails(\""+item_code.toUpperCase()+"\",\""+bean.getItemDescription(item_code.toUpperCase())+"\");");
			}
			catch(Exception exception){
				flag			=	"INVALID_SS_ITEM_CODE";
				result			=	false;
			}
		}
		else if (validate.equals("PACK_ITEM_DESC")){
			try{
				out.println("setPackItemDetails(\""+item_code.toUpperCase()+"\",\""+bean.getItemDescription(item_code.toUpperCase())+"\");");
			}
			catch(Exception exception){
				flag			=	"INVALID_SS_ITEM_CODE";
				result			=	false;
			}
		}
		else if (validate.equals("ADD_TO_LIST")){
			if(bean.isValidItemCode(item_code)){
				description		=	bean.getItemDescription(item_code);	
				if(bean.isItemInArrayList(alGroupList,item_code,Integer.parseInt(index)))
					throw new Exception("RECORD_ALREADY_EXISTS");
				HashMap hmListItems=new HashMap();
				hmListItems.put("ITEM_CODE",item_code);
				hmListItems.put("ITEM_QTY",item_qty);
				hmListItems.put("CONSUMABLE_YN",bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"),item_code).get("CONSUMABLE_YN").toString());
				hmListItems.put("CHARGEABLE_YN",bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"),item_code).get("CHARGEABLE_YN").toString());

				hmListItems.put("DESCRIPTION",description);
				hmListItems.put("MADATORY_ITEM_YN","");
				if (index.equals("-1")){
					hmListItems.put("MODE",bean.getCommonRepositoryValue("MODE_INSERT"));
					alGroupList.add(hmListItems);
				}
				else{
					hmListItems.put("MODE",((HashMap)alGroupList.get(Integer.parseInt(index))).get("MODE"));
					alGroupList.set(Integer.parseInt(index),hmListItems);
				}
				result	=	true;
				message	=	"Done";
			}
			else{
				result	=	false;
				message	=	"INVALID_SS_ITEM_CODE";
			}
		}else if(validate.equals("CHECKLIST"))
		{
		String checklist_code = request.getParameter("checklist_code");
		try{
			
	    	ArrayList alParameters = new ArrayList(1);
			alParameters.add(checklist_code);
			ArrayList alResult = new ArrayList();
			alGroupList=bean.fetchRecords("SELECT dtl.item_code, mm.short_desc description, ss.consumable_yn,       ss.item_image_file_name, ss.chargeable_yn, dtl.madatory_item_yn, dtl.quantity item_qty  FROM SS_CHECKLIST_DTL dtl, SS_ITEM ss, mm_item mm, SS_CHECKLIST hdr WHERE dtl.item_code = ss.item_code   AND ss.item_code = mm.item_code   AND dtl.checklist_code = hdr.checklist_code   AND hdr.checklist_code = ? and dtl.EFF_STATUS='E' order by dtl.SEQ_NO",alParameters);
            
	    for	(int i	=0;	i<alGroupList.size();i++){
	    HashMap hmListItems			=	new HashMap();
		hmListItems	=(HashMap)	alGroupList.get(i);
			hmListItems.put("MODE",bean.getCommonRepositoryValue("MODE_INSERT"));
			alResult.add(hmListItems);
			}
			session.setAttribute("alCheckList",alResult);
		System.out.println("Validate alGroupList"+alResult);    
		}
			catch(Exception exception){
				flag			=	"Exception Occured";
				result			=	false;
			}
				
		        result	=	true;
				message	=	"Done";
		}else if(validate.equals("MODIFY_QTY")){
	        String item_qty_temp = request.getParameter("item_qty");
	        String index_temp = request.getParameter("index");
		try {
	    
	    HashMap hmListItems			=	new HashMap();
		hmListItems	=(HashMap)	alGroupList.get(Integer.parseInt(index_temp));
		alGroupList.remove(Integer.parseInt(index_temp));
		hmListItems.put("ITEM_QTY",item_qty_temp);
	    alGroupList.add(Integer.parseInt(index_temp),hmListItems);
		session.setAttribute("alGroupList",alGroupList);
				}
			catch(Exception exception){
				flag			=	"Exception Occured";
				result			=	false;
			}
				
		        result	=	true;
				message	=	"Done";
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
	putObjectInBean( "groupItemBean", bean,request);

%>
