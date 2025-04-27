<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*,java.io.*,java.net.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
	String bean_id				=		request.getParameter("bean_id");
	String bean_name			=		request.getParameter("bean_name");	
	String functionType					=		request.getParameter("function_type");	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	VendorLoanReturnBean bean		= (VendorLoanReturnBean) getBeanObject(bean_id, bean_name , request);
	Hashtable hash				= (Hashtable) XMLobj.parseXMLString(request);
    hash						= (Hashtable) hash.get ("SEARCH");
	try{
		if (functionType.equals("1"))
		{
			String doc_type_code = (String) hash.get("doc_type_code");
			if (doc_type_code.trim().equals("")) {
				out.println("disableDocNo();");
				return;
			}
			if (!bean.isDocNoAutoGenYN(doc_type_code)) 
				out.println("enableDocNo();");
			else 
				out.println("disableDocNo();");
		}else if (functionType.equals("2")){
			String selDocNo 	= (String)hash.get("selDocNo") ;
			String selDocGroupDtl 	= URLDecoder.decode((String)hash.get("selDocGroupDtl"), "UTF-8");
			String[] selDocGroupArray = selDocGroupDtl.split("\\#");
			HashMap groupDetailsMap = bean.getTotalGroupQty();
			HashMap selDocGroupDetails = bean.getSelDocGropuDetails();			
			String selcDocYN = "Y";
			String ErroMsg	 = "";
			for(int i=0;i<selDocGroupArray.length;i++){
				String[] groupDtlArray = selDocGroupArray[i].split("\\|");
				if((Integer.parseInt((String)groupDtlArray[1])<=(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))))){						
					if((Integer.parseInt((String)groupDtlArray[1])<=(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))))){
						selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk",(String)groupDtlArray[1]);
						selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"ST","0");
					}else{
						int removeStQty=Integer.parseInt((String)groupDtlArray[1])-(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK")));
						
						selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk",(String)groupDtlArray[1]);
						selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"ST",String.valueOf(removeStQty));
					}						
				}else{
					selcDocYN = "N";
					if("".equals(ErroMsg))
						ErroMsg = (String)groupDetailsMap.get(groupDtlArray[0]+"_DESC");
					else
						ErroMsg = ErroMsg+", "+(String)groupDetailsMap.get(groupDtlArray[0]+"_DESC");					
				}
			}
			if("Y".equals(selcDocYN)){
				for(int j=0;j<selDocGroupArray.length;j++){
					String[] groupDtlArray = selDocGroupArray[j].split("\\|");
					groupDetailsMap.put(groupDtlArray[0],String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))-Integer.parseInt((String)groupDtlArray[1])));
					groupDetailsMap.put((groupDtlArray[0]+"PACK"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))-Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk"))));
					groupDetailsMap.put((groupDtlArray[0]+"ST"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"ST"))-Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"ST"))));				
				}
				bean.setTotalGroupQty(groupDetailsMap);				
				bean.setSelDocGropuDetails(selDocGroupDetails);
			}
				
			out.println(selcDocYN+"|"+ErroMsg+"  ");
		}else if (functionType.equals("3")){
			String selDocNo 	= (String)hash.get("selDocNo") ;
			String selDocGroupDtl 	= URLDecoder.decode((String)hash.get("selDocGroupDtl"), "UTF-8");
			String[] selDocGroupArray = selDocGroupDtl.split("\\#");
			HashMap groupDetailsMap = bean.getTotalGroupQty();
			HashMap selDocGroupDetails = bean.getSelDocGropuDetails();						
			for(int i=0;i<selDocGroupArray.length;i++){
				String[] groupDtlArray = selDocGroupArray[i].split("\\|");				
				groupDetailsMap.put(groupDtlArray[0],String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))+Integer.parseInt((String)groupDtlArray[1])));
				groupDetailsMap.put((groupDtlArray[0]+"PACK"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))+Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk"))));
				groupDetailsMap.put((groupDtlArray[0]+"ST"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"ST"))+Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"ST"))));				
				selDocGroupDetails.remove("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk");
				selDocGroupDetails.remove("D_"+selDocNo+"_"+groupDtlArray[0]+"ST");
			}
			bean.setTotalGroupQty(groupDetailsMap);			
			bean.setSelDocGropuDetails(selDocGroupDetails);			
			out.println("Y|  ");
		}else if (functionType.equals("4")){
			String totalDocNo = URLDecoder.decode((String)hash.get("totalDocNo"), "UTF-8");
			String totalDocDtls = URLDecoder.decode((String)hash.get("totalDocDtls"), "UTF-8");
			String[] totalDocArr = totalDocDtls.split("\\^");
			HashMap groupDetailsMap = bean.getTotalGroupQty();
			HashMap selDocGroupDetails = bean.getSelDocGropuDetails();	
			String selcDocYN = "Y";
			String ErroMsg	 = "";
			for(int i=0;i<totalDocArr.length;i++){
				String[] docDtls =(totalDocArr[i]).split("\\~");				
				String selDocNo 	= docDtls[0] ;
				String selDocGroupDtl 	= docDtls[1];
				String[] selDocGroupArray = selDocGroupDtl.split("\\#");
				String tempDocYN="Y";
				String tempErroMsg ="";
				for(int j=0;j<selDocGroupArray.length;j++){
					String[] groupDtlArray = selDocGroupArray[j].split("\\|");
					if((Integer.parseInt((String)groupDtlArray[1])<=(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))))){						
						if((Integer.parseInt((String)groupDtlArray[1])<=(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))))){
							selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk",(String)groupDtlArray[1]);
							selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"ST","0");
						}else{
							int removeStQty=Integer.parseInt((String)groupDtlArray[1])-(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK")));
							
							selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk",(String)groupDtlArray[1]);
							selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"ST",String.valueOf(removeStQty));
						}	
						
						groupDetailsMap.put(groupDtlArray[0],String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))-Integer.parseInt((String)groupDtlArray[1])));
						groupDetailsMap.put((groupDtlArray[0]+"PACK"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))-Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk"))));
						groupDetailsMap.put((groupDtlArray[0]+"ST"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"ST"))-Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"ST"))));				
					
					}else{
						tempDocYN ="N";						
					}
				}
				if("N".equals(tempDocYN)){
					selcDocYN = "N";
					if("".equals(ErroMsg))
						ErroMsg = selDocNo;
					else
						ErroMsg = ErroMsg+", "+selDocNo;
				}
			}
			if("Y".equals(selcDocYN)){				
				bean.setTotalGroupQty(groupDetailsMap);				
				bean.setSelDocGropuDetails(selDocGroupDetails);
			}else{				
				bean.setSelDocGropuDetails(new HashMap());
				bean.setTotalGroupQty(new HashMap());
				bean.loadHashMaps(totalDocNo);					
			}
			out.println(selcDocYN+"|"+ErroMsg+"  ");
		}else if (functionType.equals("5")){			
			String totalDocNo = URLDecoder.decode((String)hash.get("totalDocNo"), "UTF-8");			
			bean.setSelDocGropuDetails(new HashMap());
			bean.setTotalGroupQty(new HashMap());			
			bean.loadHashMaps(totalDocNo);	
			
			out.println("Y|  ");
		}
		
	putObjectInBean(bean_id,bean,request); 
	}catch(Exception ex){
		ex.printStackTrace();
		out.println("ERROR");
	}
%>
