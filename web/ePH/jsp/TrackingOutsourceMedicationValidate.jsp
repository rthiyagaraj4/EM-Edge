 <%@page import="java.util.*, ePH.Common.*, ePH.*,eST.*,java.text.DecimalFormat " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String identity		  = request.getParameter( "identity" );
	String bean_id		  = request.getParameter( "bean_id" ) ;
	String bean_name	  = request.getParameter( "bean_name" ) ; 
	String disp_locn_code = "";
	String disp_locn_name = "";

	Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				  = (Hashtable)hash.get( "SEARCH" ) ;

	TrackingOutsourceMedicationBean bean = (TrackingOutsourceMedicationBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(locale);
	try {
		if (identity.equals("validateLogin")){
			disp_locn_code = (String) hash.get("disp_locn_code");
			String homepage =  hash.get("homepage")==null?"":(String) hash.get("homepage"); //added for Bru-HIMS-CRF-073.1 [IN:047222]
			if(!homepage.equals("Y")){ //if condition and else block added for Bru-HIMS-CRF-073.1 [IN:047222] 
				disp_locn_name = (String) hash.get("disp_locn_name");
				if(!bean.validateThePassword((String) hash.get("password"))){
					out.println("alert(getMessage('PH_INVALID_PASSWORD','PH'))");
					out.println("focusOnPasswordField('Y')");			
				}
				else{
					out.println("focusOnPasswordField('N')");	
					bean.setPassword((String) hash.get("password"));
					bean.setDispLocnCode(disp_locn_code);
					bean.setDispLocnName(java.net.URLDecoder.decode(disp_locn_name,"UTF-8"));
					bean.setAccessDetails(disp_locn_code);
				}
			} //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
			else{
				String facility_id			= (String) session.getValue("facility_id");
				ArrayList result = bean.checkToProceed(facility_id.trim());
				boolean dispLocnFound = false;
				String strdisp_locn_code = "", disp_locn_details="", disp_locn="";
				StringTokenizer st_disp_locn=null;
				if(result.size()>0) {
					disp_locn_details =(String)result.get(0);
				}
				StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
				while (stdisp_locn_details.hasMoreTokens()){
					disp_locn = stdisp_locn_details.nextToken();
					st_disp_locn = new StringTokenizer(disp_locn,",");
					strdisp_locn_code = st_disp_locn.nextToken();
					if((strdisp_locn_code).equals(disp_locn_code)){
						disp_locn_name = st_disp_locn.nextToken();
						dispLocnFound = true;
						break;
					}
				}
				if(dispLocnFound){
					out.println("retVal='GOQUERYCRITERIA'");
					bean.setDispLocnCode(disp_locn_code);
					bean.setDispLocnName(disp_locn_name);
					bean.setAccessDetails(disp_locn_code);
				}
				else
					out.println("retVal ='ACCESS_DENIED'");			
			} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end
		}
		if (identity.equals("getResult")){
			String trackingAction = (String) hash.get("trackingAction");
			String order_type = (String) hash.get("order_type");
			String tracking_ref_facility = (String) hash.get("tracking_ref_facility");
			bean.setTrackingAction(trackingAction);
			bean.setOrderType(order_type);
			if(!trackingAction.equals("S")){
				bean.setReferralFacility(tracking_ref_facility);
			}
			if(bean.getTrackingDetails() !=null)
				bean.clearTrackingDetails();
		}
		if (identity.equals("selectDrug")){
			String patientId = (String) hash.get("patientId");
			String orderId = (String) hash.get("orderId");
			String orderLineNum = (String) hash.get("orderLineNum");
			String selectYN = (String) hash.get("selectYN");
			String trackingAction = (String) hash.get("trackingAction");
			String key = "", outsourceId="", index="";
			HashMap hmTrackingDetails = bean.getTrackingDetails();
			ArrayList alPatTackingDtls = null;
			if(trackingAction.equals("S")){
				key = orderId+"~"+orderLineNum;
				if(hmTrackingDetails.containsKey(patientId))
					alPatTackingDtls = (ArrayList)hmTrackingDetails.get(patientId);
				else
					alPatTackingDtls = new ArrayList();
				if(selectYN.equals("Y")){
					alPatTackingDtls.add(key);
				}
				else{
					if(alPatTackingDtls!=null && alPatTackingDtls.contains(key))
						alPatTackingDtls.remove(alPatTackingDtls.indexOf(key));
				}
				if(alPatTackingDtls.size()>0)
					hmTrackingDetails.put(patientId,alPatTackingDtls );
				else
					hmTrackingDetails.remove(patientId);
			}
			else{
				outsourceId = (String) hash.get("outsourceId");
				key = outsourceId+"~"+orderId+"~"+orderLineNum;
				index = (String) hash.get("index");
				if(hmTrackingDetails.containsKey(key))
					alPatTackingDtls = (ArrayList)hmTrackingDetails.get(key);
				else
					alPatTackingDtls = new ArrayList();

				if(selectYN.equals("Y")){
					hmTrackingDetails.put(key,alPatTackingDtls );
					out.println("editReceiveDtls('"+index+"')");	
				}
				else
					hmTrackingDetails.remove(key);
			}
		}
		else if(identity.equals("storeRemarks")){ 
			String remarks = (String) hash.get("remarks")==null?"":(String) hash.get("remarks");
			bean.setTrackingRemarks(java.net.URLDecoder.decode(remarks,"UTF-8"));
		}
		else if(identity.equals("storeReceivedDtls")){ 
			String outsourceId = hash.get("outsourceId")==null?"":(String) hash.get("outsourceId");
			String orderId =  hash.get("orderId")==null?"": (String)hash.get("orderId");
			String orderLineNum =  hash.get("orderLineNum")==null?"": (String)hash.get("orderLineNum");
			String productCount = hash.get("productCount")==null?"0":(String) hash.get("productCount");
			HashMap hmTrackingDetails = bean.getTrackingDetails();
			HashMap hmTrackingDetail = null;
			ArrayList alPatTackingDtls = null;
			String productId, productName, batchId, expiryDate, quantity, ingredient,  remarks, ingntCount, quantityUOM;
			String key = outsourceId+"~"+orderId+"~"+orderLineNum;
			ArrayList alIngredients = null;
			if(hmTrackingDetails.containsKey(key))
				alPatTackingDtls = (ArrayList)hmTrackingDetails.get(key);
			else
				alPatTackingDtls = new ArrayList();
			int intProdCount = Integer.parseInt(productCount);
			int intIngntCount=0;
			for(int p=0; p< intProdCount;p++){
				hmTrackingDetail = new HashMap();
				alIngredients = new ArrayList();
				productId= hash.get("productId"+p)==null?"":(String) hash.get("productId"+p);
				productName= hash.get("productName"+p)==null?"":(String) hash.get("productName"+p);
				batchId= hash.get("batchId"+p)==null?"":(String) hash.get("batchId"+p);
				expiryDate= hash.get("expiryDate"+p)==null?"":(String) hash.get("expiryDate"+p);
				quantity= hash.get("quantity"+p)==null?"":(String) hash.get("quantity"+p);
				quantityUOM= hash.get("quantityUOM"+p)==null?"":(String) hash.get("quantityUOM"+p);
				ingntCount= hash.get("ingntCount"+p)==null?"0":(String) hash.get("ingntCount"+p);
				intIngntCount = Integer.parseInt(ingntCount);
				hmTrackingDetail.put("srlNo",(p+1)+"");
				hmTrackingDetail.put("productId",productId);
				hmTrackingDetail.put("productName",java.net.URLDecoder.decode(productName,"UTF-8"));
				hmTrackingDetail.put("batchId",batchId);
				hmTrackingDetail.put("expiryDate",com.ehis.util.DateUtils.convertDate(expiryDate,"DMY",locale,"en"));
				hmTrackingDetail.put("quantity",quantity);
				hmTrackingDetail.put("quantityUOM",java.net.URLDecoder.decode(quantityUOM,"UTF-8"));
				hmTrackingDetail.put("ingntCount",ingntCount);
				for(int ing=0; ing<intIngntCount; ing++){
					ingredient= hash.get("ingredient"+p+"_"+ing)==null?"":(String) hash.get("ingredient"+p+"_"+ing);
					if(!ingredient.equals(""))
						alIngredients.add(java.net.URLDecoder.decode(ingredient,"UTF-8"));
				}
				hmTrackingDetail.put("ingredients",alIngredients);
				remarks= hash.get("remarks"+p)==null?"":(String) hash.get("remarks"+p);
				hmTrackingDetail.put("remarks",java.net.URLDecoder.decode(remarks,"UTF-8"));
				if(alPatTackingDtls.size()<=p)
					alPatTackingDtls.add(hmTrackingDetail);
				else
					alPatTackingDtls.set(p,hmTrackingDetail);
			}
			hmTrackingDetails.put(key,alPatTackingDtls );
		}
		else if(identity.equals("checkForReceivedDtls")){ 
			String outsourceId = hash.get("outsourceId")==null?"":(String) hash.get("outsourceId");
			String orderId =  hash.get("orderId")==null?"": (String)hash.get("orderId");
			String orderLineNum =  hash.get("orderLineNum")==null?"": (String)hash.get("orderLineNum");
			String index = hash.get("index")==null?"":(String) hash.get("index");
			String key = outsourceId+"~"+orderId+"~"+orderLineNum;
			HashMap hmTrackingDetails = bean.getTrackingDetails();
			if(!hmTrackingDetails.containsKey(key) || ((ArrayList)hmTrackingDetails.get(key)).size()==0){
				if(hmTrackingDetails.containsKey(key))
					hmTrackingDetails.remove(key);
				out.println("selectRecord('"+index+"',false)");
			}
		}
		else if(identity.equals("storeDeliverDetails")){ 
			String selectCount = hash.get("selectCount")==null?"0":(String) hash.get("selectCount");
			int intSelectCount = Integer.parseInt(selectCount);
			String outsourceId, orderId, orderLineNum, deliverSource, deliverSourceCode, deliverToInd, deliverTo, deliverToName, selectYN, key;

			if(intSelectCount>0){
				HashMap hmTrackingDetails = bean.getTrackingDetails();
				HashMap hmTrackingDetail = null;
				for(int i=0; i<intSelectCount; i++){
					selectYN = hash.get("selectYN"+i)==null?"":(String) hash.get("selectYN"+i);
					outsourceId = hash.get("outsourceId"+i)==null?"":(String) hash.get("outsourceId"+i);
					orderId =  hash.get("orderId"+i)==null?"": (String)hash.get("orderId"+i);
					orderLineNum =  hash.get("orderLineNum"+i)==null?"": (String)hash.get("orderLineNum"+i);
					key = outsourceId+"~"+orderId+"~"+orderLineNum;
					if(selectYN.equals("Y")){
						hmTrackingDetail = new HashMap();
						deliverSourceCode =  hash.get("deliverSourceCode"+i)==null?"": (String)hash.get("deliverSourceCode"+i);
						deliverSource =  hash.get("deliverSource"+i)==null?"": (String)hash.get("deliverSource"+i);
						deliverToInd = hash.get("deliverToInd"+i)==null?"":(String) hash.get("deliverToInd"+i);
						deliverTo = hash.get("deliverTo"+i)==null?"":(String) hash.get("deliverTo"+i);
						deliverToName =  hash.get("deliverToName"+i)==null?"": (String)hash.get("deliverToName"+i);

						hmTrackingDetail.put("DELIVERED_SOURCE_CODE",deliverSourceCode);
						hmTrackingDetail.put("DELIVERED_SOURCE_DESC",deliverSource);
						hmTrackingDetail.put("DELIVERED_TO_IND",deliverToInd);
						hmTrackingDetail.put("DELIVERED_TO",deliverTo);
						hmTrackingDetail.put("DELIVERED_TO_NAME",deliverToName);
						hmTrackingDetails.put(key,hmTrackingDetail );
					}
					else{
						if(hmTrackingDetails.containsKey(key))
							hmTrackingDetails.remove(key);
					}
				}
			}
		}
		else if(identity.equals("getUpdateRecCount")){ 
			int count = 0;
			HashMap hmTrackingDetails = bean.getTrackingDetails();
			if(hmTrackingDetails !=null)
				count = hmTrackingDetails.size();
			out.println("assignUpdateRecCount('"+count+"')");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	putObjectInBean(bean_id,bean,request);
%>
