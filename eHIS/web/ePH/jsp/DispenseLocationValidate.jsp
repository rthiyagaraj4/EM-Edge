 <%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%	
	request.setCharacterEncoding("UTF-8");
	//String locale			= (String)session.getAttribute("LOCALE");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;
	
	String objname = request.getParameter( "object" ) ;

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	DispenseLocationBean beanObj = ( DispenseLocationBean )getBeanObject( bean_id, bean_name,request ) ;

	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if ( validate.equals( "onlineprintlist" ) ) {
		
		
		String report_id	= (String)hash.get("report_id");
		String list_name	= (String)hash.get("list_name");
		String changed_value = (String)hash.get("changed_value");
		
          
		HashMap onlineMap	= beanObj.getOnlinePrintSetupMap();
		HashMap map			= (HashMap)onlineMap.get(report_id);
		beanObj.setToOnlinePrintMap(report_id+"~~"+list_name,map.get(list_name).toString());
		map.put(list_name,changed_value);
		onlineMap.put(report_id,map);
		beanObj.setOnlinePrintSetupMap(onlineMap);
	}

	if ( validate.equals( "onlineprintlist_ok_cancel" ) ) {		
		String action_type = request.getParameter("action_type");
		String select_all = (String)hash.get("select_all");		
     	HashMap  onlinePrintMap = beanObj.getOnlinePrintSetupMap(); //updated values are stored in this map
		HashMap  map = beanObj.getOnlinePrintMap();
		String select_all_prev = beanObj.getSelectAll();
		if (action_type.equals("cancel")){
			 //before changed values are stored in this map
			Set keys = map.keySet();
			String label_listname ="";
			String label ="";
		    String listName ="";
			for (Iterator i = keys.iterator(); i.hasNext();){
			label_listname = (String) i.next();
			StringTokenizer st =new StringTokenizer(label_listname,"~~");
			while (st.hasMoreTokens()){
			 label= st.nextToken();
			 listName= st.nextToken();
			 if (onlinePrintMap.containsKey(label)){
				 HashMap map1 = (HashMap)onlinePrintMap.get(label);
				 map1.put(listName,map.get(label_listname).toString());
				 onlinePrintMap.put(label,map1);
			 }
			}
			}
				beanObj.setSelectAll(select_all_prev); //previous select all value will be stored in the bean
		}
		else{
				beanObj.setSelectAll(select_all);
		}
		beanObj.setOnlinePrintSetupMap(onlinePrintMap);	
		map.clear();	

		}	

	if ( validate.equals( "DISP_LOCN_CODE" ) ) {
		String disp_locn_code = ( String )hash.get( objname ) ;
		if ( beanObj.validateCode(disp_locn_code, 1).equals("true") ) {
			out.println("callalert('DISP_LOCN_CODE');") ;
		}
	}

	if ( validate.equals( "STORE_CODE" ) ) {
		String store_code = ( String )hash.get( objname ) ;
		if ( beanObj.validateCode(store_code, 1).equals("true") ) {
			out.println("callalert('STORE_CODE');") ;
		}else{
			String retVal = beanObj.validateCode(store_code, 2) ;
			out.println("assignDescs('"+ store_code + "|" + retVal +"');") ;
		}
	}
	if ( validate.equals( "IP_DAILY_SQENCE_NO" ) )
		{
			String dsn_from =  (String)request.getParameter( "IP_SQE_NO_FROM" )==null?"":(String) request.getParameter( "IP_SQE_NO_FROM" );
			String dsn_to = (String)request.getParameter( "IP_SQE_NO_TO" )==null?"":(String) request.getParameter( "IP_SQE_NO_TO" );
			String disp_loc_code_modify = (String)request.getParameter( "DISP_LOCN_CODE" )==null?"":(String) request.getParameter( "DISP_LOCN_CODE" );
			if(!(dsn_from.equals("")) && !(dsn_to.equals("")))
				{
					int IP_SQE_NO_FROM =Integer.parseInt(dsn_from) ;
					int IP_SQE_NO_TO = Integer.parseInt(dsn_to) ;
		
				    boolean validRange= beanObj.getRangeOverlapValidate((ArrayList)beanObj.getDailySpecificRange(),IP_SQE_NO_FROM,IP_SQE_NO_TO,disp_loc_code_modify);
			
					 if(validRange)
						{
							out.println("callconform();") ;
						}
				}
		}

	if ( validate.equals( "saveRemarks" ) ) {

		String remarks_code			=	(String)hash.get("remarks");
		if(remarks_code.equals(""))
			remarks_code=beanObj.getRemarksCode()==null?"":beanObj.getRemarksCode();

		String reason_desc			=java.net.URLDecoder.decode((String)hash.get("remarks_desc"));
		String remarks_desc			=	beanObj.getRemarksDescription(remarks_code)==null?"":beanObj.getRemarksDescription(remarks_code);
		beanObj.setRemarksCode(remarks_code);
		beanObj.setReasonDesc(reason_desc);
		beanObj.setRemarksDesc(remarks_desc);


	}
	if ( validate.equals( "saveRemark" ) ) {
		String remarks_code			 = (String)hash.get("remarks");
		if(remarks_code.equals(""))
			remarks_code=beanObj.getRemarksCode()==null?"":beanObj.getRemarksCode();
		String reason_desc		=java.net.URLDecoder.decode((String)hash.get("remarks_desc"));
		String remarks_desc =beanObj.getRemarksDescription(remarks_code)==null?"":beanObj.getRemarksDescription(remarks_code);				
			remarks_desc=java.net.URLEncoder.encode(remarks_desc);	
		out.println("assignRemarksDescs('"+ remarks_desc + "');") ;
	}
	
%>
<%
putObjectInBean(bean_id,beanObj,request);
%>
