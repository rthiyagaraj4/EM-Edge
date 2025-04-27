 <%--This file is saved on 07/11/2005 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*" contentType="text/html;charset=ISO-8859-1" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	try {
		String called_from			= request.getParameter("called_from");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String from					= (String) hash.get( "from" );
		if(from==null || from.equals(""))
			from	=	"1";

		if(called_from!= null && called_from.equals("override")) {
			OverRideBMSBean beanObj		= (OverRideBMSBean)getBeanObject(bean_id,bean_name,request);
			Enumeration keys		= hash.keys();
			String key				=	null;
			String value			=  null;

			while(keys.hasMoreElements()) {
				key				= (String)keys.nextElement();
				value			= (String)hash.get(key);
				
				if(key.startsWith("chk_")){
					beanObj.getRecordStatus().put(key.substring(4,key.length()),value);
				}
			}
			putObjectInBean(bean_id,beanObj,request);
		} 
		else if(called_from!= null && called_from.equals("release")) {
			ReleaseBatchesBean beanObj		= (ReleaseBatchesBean)getBeanObject(bean_id,bean_name, request);
			
			Enumeration keys		= hash.keys();
			String key				=	null;
			String value			=  null;
			while(keys.hasMoreElements()) {
				key				= (String)keys.nextElement();
				value			= (String)hash.get(key);
				if(key.startsWith("chk_")){
					beanObj.getRecordStatus().put(key.substring(4,key.length()),value);
				}
				if(key.startsWith("rcode_")){
					beanObj.getRsnCodes().put(key.substring(6,key.length()),value);
				}
			}
			// Added for SRR20056-SCF-7734 ICN 28022 - Start
			String incompleteAdmixORdID = hash.get("incompleteAdmixORdID")==null?"":(String) hash.get("incompleteAdmixORdID");
			if(!incompleteAdmixORdID.equals("")){
				beanObj.setIncompleteAdmixFoundPrev("Y");
				beanObj.setPrevAdmixOrderID(incompleteAdmixORdID);
			}
			// Added for SRR20056-SCF-7734 ICN 28022 - End
			putObjectInBean(bean_id,beanObj,request);	
		}
		// Added for SRR20056-SCF-7734 ICN 28022 - Start
		else if(called_from!= null && called_from.equals("AdmixtureGroup")) {
			ReleaseBatchesBean beanObj		= (ReleaseBatchesBean)getBeanObject(bean_id,bean_name, request);
			String order_id = (String) hash.get("order_id");
			String Nxtorder_line_num = (String) hash.get("Nxtorder_line_num");
			String select_yn = (String) hash.get("select_yn");
			String sWorkSheetId = (String) hash.get("WorkSheetId");
			if(select_yn != null && select_yn.equals("Y")){
				beanObj.setPrevAdmixOrderID(order_id);
				beanObj.setPrevAdmixWorkSheetId(sWorkSheetId);
			}
			else{
				beanObj.setPrevAdmixOrderID("");
				beanObj.setPrevAdmixWorkSheetId("");
				beanObj.setPrevAdmixReasonCode("");
				HashMap  rsnCodes =  beanObj.getRsnCodes();
				Set keyset		= rsnCodes.keySet();
				Iterator keyIter = keyset.iterator();
				String key				=	null;
				String value			=  null;
				while(keyIter.hasNext()) {
					key				= (String)keyIter.next();

					if(key!=null && key.indexOf(order_id+Nxtorder_line_num)!= -1){
						out.println("document.frmReleaseBatchesResult.incompleteAdmixFound.value='Y';");
						beanObj.setPrevAdmixOrderID(order_id);
						break;
					}
				}
			}

			putObjectInBean(bean_id,beanObj,request);	
		}
		else if(called_from!= null && called_from.equals("AdmixtureGroupReason")) {
			ReleaseBatchesBean beanObj		= (ReleaseBatchesBean)getBeanObject(bean_id,bean_name, request);
			String reason_code = (String) hash.get("reason_code");
			beanObj.setPrevAdmixReasonCode(reason_code);
			putObjectInBean(bean_id,beanObj,request);	
		}
		// Added for SRR20056-SCF-7734 ICN 28022 - End
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
