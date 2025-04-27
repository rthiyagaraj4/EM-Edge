  <%@page import="java.util.*, ePH.Common.*, ePH.* "
contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try{
		request.setCharacterEncoding("UTF-8");	
		String locale			= (String)session.getAttribute("LOCALE");
		//Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
		//hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id			= request.getParameter( "bean_id" ) ;
		String bean_name		= request.getParameter( "bean_name" ) ;
		String DISP_LOCN		=(request.getParameter( "DISP_LOCN" )==null?"":request.getParameter( "DISP_LOCN" ));
		String func_mode		= request.getParameter( "func_mode" );
		ArrayList arrListResult	= new ArrayList();
		ArrayList chkd_token_series  = new ArrayList();
		ArrayList chkd_default  = new ArrayList();
		String token_series_code = "", defTokenSeriesCode="";
		String tad_chkd  = "";
		
		Hashtable hash			= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash					= (Hashtable)hash.get( "SEARCH" ) ;
		WsTokenSeriesBean bean	= (WsTokenSeriesBean)getBeanObject(bean_id,bean_name ,request) ;
		bean.setLanguageId(locale);
		//	bean.getWSLocns(DISP_LOCN);
		if(func_mode != null && func_mode.equals("validate_ws" ) ){
			arrListResult=(ArrayList)bean.getWSLocns(DISP_LOCN);
			for(int i=0; i<arrListResult.size() ; i++)

				out.println("addToWorkStationRelated('"+arrListResult.get(i)+"','"+arrListResult.get(i)+"')");
		}
		else if(func_mode != null && func_mode.equals("validate_checked_items" ) ){
			chkd_token_series= (ArrayList) bean.getTempAssoDatas();
			token_series_code = (String) hash.get( "token_series");
			tad_chkd = (String) hash.get( "tad_chkd");
			defTokenSeriesCode = bean.getDefaultTokenSeries();
			// Adding the token series code into temp array list if checkbox is checked and removing the code if checkbox is unchecked
			
			if(tad_chkd.equals("yes")){
				if(!chkd_token_series.contains(token_series_code))
					chkd_token_series.add(token_series_code);
			}
			else if(tad_chkd.equals("no")){
				if(chkd_token_series.contains(token_series_code))
					chkd_token_series.remove(token_series_code);
				if(defTokenSeriesCode.equals(token_series_code))
					bean.setDefaultTokenSeries("");
			}
			
			bean.setTempAssoDatas(chkd_token_series);
		}
		if(func_mode != null && func_mode.equals("validate_default_check" ) ){
			chkd_token_series= (ArrayList) bean.getTempAssoDatas();
			String default_yn=(String)hash.get( "defaultChk");
			defTokenSeriesCode=(String)hash.get( "code");
			if(default_yn.equals("true"))
				bean.setDefaultTokenSeries(defTokenSeriesCode);
			else 
				bean.setDefaultTokenSeries("");
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>
