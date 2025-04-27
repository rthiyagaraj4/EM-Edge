 <%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;
	String objname = request.getParameter( "object" ) ;
	String mode = request.getParameter( "mode" ) ;
	String code="";
	String desc="";
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null || validate.equals( "" ) )
		return ;	
  
	AltDispLocnBean beanObj = ( AltDispLocnBean )getBeanObject(bean_id,bean_name,request) ;
	beanObj.setLanguageId(locale);
	String logged_fcy = beanObj.getLoggedInFacility();
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
   
   

	hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if ( validate.equals( "ORDER_SRC_TYPE" ) ) {
      
		out.println("clearData('document.AltDispLocn.ORDER_SRC_LOCN');") ;
	
		String order_src_type = (String)hash.get( objname ) ;
		String Ordering_Facility = request.getParameter( "Ordering_Facility" ) ;
		ArrayList ordSrcLocns = beanObj.getLocns(order_src_type, "",Ordering_Facility,"1") ;
		for (int i=0; i<ordSrcLocns.size(); i+=2) {
			code=(String)ordSrcLocns.get(i);
			desc=(String)ordSrcLocns.get(i+1);
			if((code.substring(0,1)).equals("'")){
				code=code.substring(1,(code.length())-1);
			}
			if((desc.substring(0,1)).equals("'")){
				desc=desc.substring(1,(desc.length())-1);
			}
			out.println("addData('"+ code + "', '" + desc +"', 'document.AltDispLocnHeaderForm.ORDER_SRC_LOCN');") ;
		}
	}
	if ( validate.equals( "ORDER_FCY" ) ) {
	
		out.println("clearData('document.AltDispLocnHeaderForm.ORDER_SRC_LOCN');") ;
	
		String Ordering_Facility = (String)hash.get( objname ) ;
        String order_src_type = request.getParameter( "ord_src_type" ) ;
     
	
		ArrayList ordSrcLocns = beanObj.getLocns(order_src_type, "",Ordering_Facility,"1") ;
		
		for (int i=0; i<ordSrcLocns.size(); i+=2) {
			code=(String)ordSrcLocns.get(i);
			desc=(String)ordSrcLocns.get(i+1);
			if((code.substring(0,1)).equals("'")){
				code=code.substring(1,(code.length())-1);
			}
			if((desc.substring(0,1)).equals("'")){
				desc=desc.substring(1,(desc.length())-1);
			}
			out.println("addData('"+ code + "', '" + desc +"', 'document.AltDispLocnHeaderForm.ORDER_SRC_LOCN');") ;
		}
	}
	if ( validate.equals( "PERFORM_FCY" ) ) {
		String ord_src_type = request.getParameter( "ord_src_type" ) ;
	
		String perform_fcy = (String)hash.get( objname ) ;
		
	
		ArrayList ordSrcLocns = beanObj.getLocns(ord_src_type, perform_fcy,"","1") ;
		for (int i=0; i<ordSrcLocns.size(); i+=3) {
			
		
			
			if(mode.equals("1")){
							out.println("addData2();");
						}
		}
	}

	if(validate.equals("alt_disp_locn_select")){	
		String alt_disp_code=request.getParameter("alt_disp_code");
		String frmtime=request.getParameter("frmtime");
		String totime=request.getParameter("totime");
		String flag=request.getParameter("flag");
		String eff_status=request.getParameter("eff_status");
		String repeat=request.getParameter("repeat");
		ArrayList altdisp=new ArrayList();
		altdisp=beanObj.selectedlocn(alt_disp_code,frmtime,totime,flag,eff_status,repeat);
	}
	if ( validate.equals( "ORDER_SRC_LOCN" ) ) {
		String ord_src_type = request.getParameter( "ord_src_type" ) ;
		String perform_fcy = logged_fcy ;
		ArrayList ordSrcLocns = beanObj.getLocns(ord_src_type, perform_fcy,"","1") ;
		for (int i=0; i<ordSrcLocns.size(); i+=3) {
			
			if(mode.equals("1")){
				out.println("addData2();");
			}
		}
	}
	if ( validate.equals( "CUR_DISP_LOC" ) ) {
		String order_fcy = request.getParameter( "order_fcy" ) ;
		String ord_src_type = request.getParameter( "ord_src_type" ) ;
        String order_src_locn = request.getParameter( "order_src_locn" ) ;
		HashMap hm= null;
	 	out.println("clearData('document.AltDispLocnHeaderForm.CURR_DISP_LOC');") ;
	    ArrayList disp_loc_code = beanObj.getCurrDispLocation(order_fcy, ord_src_type,order_src_locn);
		if(disp_loc_code!=null && disp_loc_code.size()>0){
			for (int i=0; i<disp_loc_code.size(); i++) {
				hm= new HashMap();
				hm=(HashMap)disp_loc_code.get(i);
				code=hm.get("CODE")==null?"":(String)hm.get("CODE");
				desc=hm.get("DESC")==null?"":(String)hm.get("DESC");
				if(!code.equals("")){
					if((code.substring(0,1)).equals("'")){
						code=code.substring(1,(code.length())-1);
					}
					if((desc.substring(0,1)).equals("'")){
						desc=desc.substring(1,(desc.length())-1);
					}
					out.println("addData('"+ code  + "',\"" + desc +"\", 'document.AltDispLocnHeaderForm.CURR_DISP_LOC');") ;	
				}
			}
		}
   	}
	if ( validate.equals( "ALT_DISP_LOC" ) ) {
		String order_fcy = request.getParameter( "order_fcy" ) ;
		String ord_src_type = request.getParameter( "ord_src_type" ) ;
        String order_src_locn = request.getParameter( "order_src_locn" ) ;
		String alt_disp_locn_code = beanObj.getAltDispLocnCode(order_fcy, ord_src_type,order_src_locn) ;
			 if(!(alt_disp_locn_code.equals("")))   
				out.println("addData1('"+alt_disp_locn_code + "', 'f_query_add_mod.alt_disp_locn_header.document.AltDispLocnHeaderForm.alt_disp_locn_code');") ;		
	} 
	if ( validate.equals( "for_timings" ) ) {
		String order_fcy = request.getParameter( "order_fcy" ) ;
		String short_desc = request.getParameter( "short_desc" ) ;
		String working_hours_from="";
		String working_hours_to="";
        ArrayList desptimes = beanObj.getDespTimings(order_fcy,short_desc) ;
		if (desptimes.size() != 0){
		 working_hours_from = (String)desptimes.get(0);
		 working_hours_to = (String)desptimes.get(1);
		}          
		
         out.println("addtimings('"+ working_hours_from + "','"+working_hours_to+"' );") ;
	}
	putObjectInBean(bean_id,beanObj,request);
	%>
	
