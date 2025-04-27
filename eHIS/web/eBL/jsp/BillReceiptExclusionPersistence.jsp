<!DOCTYPE html>
<%@page import="eBL.billreceipt.model.BillReceiptExclusionDiscount"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%// Page Added by Rajesh V. To Persist all the Excluded Service %>

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
//	String params = request.getQueryString(); //checklist
//	String sqlCoverage = ""; //checklist
//	PreparedStatement pstmt = null; //checklist
//	ResultSet rst = null; //checklist
	String beanId = "BillReceiptExistOrderExclusion" ;
	String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
	BillReceiptExistOrderExclusion exclusionBean = null;

	try 
	{
		exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
		if(exclusionBean.getServiceExclusion() == null){
			exclusionBean.setServiceExclusion(new HashSet<String>());
		}
		
		if(exclusionBean.getInterExclusion() == null){
			exclusionBean.setInterExclusion(new HashSet<String>());
		}
		if(exclusionBean.getGroupExclusion() == null){
			exclusionBean.setGroupExclusion(new HashSet<String>());
		}
		if(exclusionBean.getLineExclusion() == null){
			exclusionBean.setLineExclusion(new HashSet<String>());
		}
		
		if(exclusionBean.getDiscountMap() == null){
			exclusionBean.setDiscountMap(new HashMap<String,BillReceiptExclusionDiscount>());
		}
		Set<String> serviceSet = exclusionBean.getServiceExclusion();
		Set<String> interSet = exclusionBean.getInterExclusion();
		Set<String> groupExclusion = exclusionBean.getGroupExclusion();
		Set<String> lineExclusion = exclusionBean.getLineExclusion();
		HashMap<String,BillReceiptExclusionDiscount> discountMap = exclusionBean.getDiscountMap();
		HashMap<String,BillReceiptExclusionDiscount> interDiscount = exclusionBean.getInterDiscount();
		
//		String facility_id = (String)session.getAttribute("facility_id");//checklist
		request.setCharacterEncoding("UTF-8");
		
//		String locale = (String)session.getAttribute("LOCALE");//checklist
		String func_mode = request.getParameter("func_mode");
//		String event = (request.getParameter("event") == null ? "" : request.getParameter("event")); //checklist
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
		if(func_mode!= null && "excludeService".equals(func_mode)){
			//String status = "";//checklist
			String blngServCode = "";
			String trxDocRef = "";
			String trxDocRefLineNum = "";
			//String trxDocRefSeqNum = ""; //checklist
			//String servGroupKey = (String)hash.get("servGroupKey");			//checklist
			BillReceiptExclusionDiscount discBean = null;
			if(serviceSet == null){
				serviceSet = new HashSet<String>();
			}
			if(interSet == null){
				interSet = new HashSet<String>();
			}
			serviceSet.addAll(interSet);
			/*String excludedUnChecked = checkForNull((String)hash.get("excludedUnChecked"));
			String[] excludedUnChkArr = excludedUnChecked.split("####");
			for(int l=0;l<excludedUnChkArr.length;l++){
				if(serviceSet.contains(excludedUnChkArr[l]))	serviceSet.remove(excludedUnChkArr[l]);
			}*/
			int totalService = 0;
			try{
				totalService = Integer.parseInt((String)hash.get("totalService"));
				
			}
			catch(Exception NE){
				totalService = 0;
			}
			String serviceComb = "";
			int maxPayer = Integer.parseInt((String)hash.get("maxPayer"));
			for(int i=0;i<totalService;i++){
				blngServCode = (String)hash.get("serv_grp_code"+i);
				trxDocRef = (String)hash.get("trxDocRef"+i);
				trxDocRefLineNum = (String)hash.get("trxDocRefLineNum"+i);
				//trxDocRefSeqNum = (String)hash.get("trxDocRefSeqNum"+i);
				serviceComb = blngServCode+":::"+trxDocRef+":::"+trxDocRefLineNum;
						System.err.println("serviceComb->"+serviceComb);
						System.err.println("Checked->"+(String)hash.get("serv_grp_chk"+i));
						//System.err.println("seq no->"+(String)hash.get("trxDocRefSeqNumC"+i));
				if("Y".equals((String)hash.get("serv_grp_chk"+i))){					
					if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumC"+i)))){
						if(serviceSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i))){
							
						}
						else{
							serviceSet.add(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						System.err.println("Added->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						}
					}
					for(int m=1;m<=maxPayer;m++){
						if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumP"+m+i)))){
							if(serviceSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i))){
								
							}
							else{
								serviceSet.add(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
								System.err.println("Added->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
							}
						}
					}
				}
				else{					
					if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumC"+i)))){
						if(serviceSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i))){
							serviceSet.remove(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
							System.err.println("Removed->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						}
					}
					
					for(int m=1;m<=maxPayer;m++){
						if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumP"+m+i)))){
							if(serviceSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i))){
								serviceSet.remove(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
								System.err.println("Removed->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
							}
						}
					}											
				}				
			}
			
			List<BillReceiptExclusionDiscount> exclDisc = new ArrayList<BillReceiptExclusionDiscount>();
			HashMap<String,BillReceiptExclusionDiscount> copyDiscMap = new HashMap<String,BillReceiptExclusionDiscount>();
			discountMap.putAll(interDiscount);			
			copyDiscMap.putAll(discountMap);
			discBean = null;
			for (Iterator iterator = serviceSet.iterator(); iterator.hasNext();) {
				String combo = (String) iterator.next();
				if(copyDiscMap.containsKey(combo)){
					copyDiscMap.remove(combo);
				}
				String[] comboArr = combo.split(":::");
				discBean = new BillReceiptExclusionDiscount();
				discBean.setBlngServCode(comboArr[0]);
				discBean.setTrxDocRef(comboArr[1]);
				discBean.setTrxDocRefLineNum(comboArr[2]);
				discBean.setTrxDocRefSeqNum(comboArr[3]);
				discBean.setDiscOrExcl("E");
				exclDisc.add(discBean);
			}
			
			discBean = null;
			for (Iterator iterator = copyDiscMap.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				if(copyDiscMap.containsKey(key)){
					discBean = (BillReceiptExclusionDiscount) copyDiscMap.get(key);
					exclDisc.add(discBean);
				}
			}
			exclusionBean.setExclDiscList(exclDisc);	
			exclusionBean.setDiscountMap(copyDiscMap);
			exclusionBean.setInterDiscount(new HashMap<String,BillReceiptExclusionDiscount>());
			/*if(serviceSet.isEmpty()){
				if(serviceMap.containsKey(servGroupKey)){
					serviceMap.remove(servGroupKey);
					status = "true";
				}
				else{
					status = "false";
				}
				
			}
			else{
				serviceMap.put(servGroupKey, serviceSet);
				status = "true";
			}
			out.println(status);*/
			
		}
		else if(func_mode!= null && "nextPrevExcluded".equals(func_mode)){
			//String status = ""; //checklist
			String blngServCode = "";
			String trxDocRef = "";
			String trxDocRefLineNum = "";
			//String trxDocRefSeqNum = "";//checklist
			//String servGroupKey = (String)hash.get("servGroupKey");		//checklist	

			if(interSet == null){
				interSet = new HashSet<String>();
			}

			int totalService = 0;
			try{
				totalService = Integer.parseInt((String)hash.get("totalService"));				
			}
			catch(Exception NE){
				totalService = 0;
			}
			String serviceComb = "";
			int maxPayer = Integer.parseInt((String)hash.get("maxPayer"));
			for(int i=0;i<totalService;i++){
				blngServCode = (String)hash.get("serv_grp_code"+i);
				trxDocRef = (String)hash.get("trxDocRef"+i);
				trxDocRefLineNum = (String)hash.get("trxDocRefLineNum"+i);
				//trxDocRefSeqNum = (String)hash.get("trxDocRefSeqNum"+i);
				serviceComb = blngServCode+":::"+trxDocRef+":::"+trxDocRefLineNum;
						System.err.println("serviceComb->"+serviceComb);
						System.err.println("Checked->"+(String)hash.get("serv_grp_chk"+i));
						System.err.println("seq no->"+(String)hash.get("trxDocRefSeqNumC"+i));
				if("Y".equals((String)hash.get("serv_grp_chk"+i))){					
					if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumC"+i)))){
						if(interSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i))){
							
						}
						else{
							interSet.add(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						}
					}
					for(int m=1;m<=maxPayer;m++){
						if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumP"+m+i)))){
							if(interSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i))){
								
							}
							else{
								interSet.add(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
														System.err.println("Added->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
							}
						}
					}
				}
				else{					
					if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumC"+i)))){
						if(interSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i))){
							interSet.remove(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						System.err.println("Removed->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						}
					}
					
					for(int m=1;m<=maxPayer;m++){
						if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumP"+m+i)))){
							if(interSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i))){
								interSet.remove(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
						System.err.println("Removed->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
							}
						}
					}											
				}				
			}		
		}
		else if(func_mode!= null && "checkServicesExcluded".equals(func_mode)){
		//	String status = "true";//checklist
			/*if(serviceMap.isEmpty()){
						= "false";
			}*/
		//	out.println(status);//checklist
		}
		else if(func_mode!= null && "excludeGroupAdd".equals(func_mode)){
			String servGroup = (String)hash.get("serv_grp_code");
			groupExclusion.add(servGroup);
		}
		else if(func_mode!= null && "excludeLineAdd".equals(func_mode)){
			String servGroup = (String)hash.get("serv_grp_code");
			String servLine = (String)hash.get("serv_line_code");
			lineExclusion.add(servGroup+"::::"+servLine);
		}
		else if(func_mode!= null && "excludeGroupRemove".equals(func_mode)){
			String servGroup = (String)hash.get("serv_grp_code");
			groupExclusion.remove(servGroup);
		}
		else if(func_mode!= null && "excludeLineRemove".equals(func_mode)){
			String servGroup = (String)hash.get("serv_grp_code");
			String servLine = (String)hash.get("serv_line_code");
			lineExclusion.remove(servGroup+"::::"+servLine);
		}		
	}catch (Exception e) {	
		e.printStackTrace() ;
		System.err.println("Exception from BillReceiptExclusionPersistence.jsp:" + e);
	}
	finally
	{
		
	}
	putObjectInBean(beanId,exclusionBean,request);
%>
