<%@page import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	try{
		String bean_id = request.getParameter( "bean_id" ) ;
		String bean_name = request.getParameter( "bean_name" ) ;
		String validate = request.getParameter( "validate" ) ;
		String objname = request.getParameter( "object" ) ;
		String calledFrom = request.getParameter( "calledFrom" ) ;
		if ( bean_id == null || bean_id.equals( "" ) )
			return ;
		if ( validate == null || validate.equals( "" ) )
			return ;
		PresRemarkBean beanObj = ( PresRemarkBean )getBeanObject(bean_id,bean_name,request ) ;
		Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
		hash = ( Hashtable )hash.get( "SEARCH" ) ;

		if ( validate.equals( "Formcode" ) ) {
			String suffix = objname.substring( objname.lastIndexOf( "_" ) + 1 ) ;
			out.println( "clearList( 'document.formPresRemark.ROUTE_CODE_', " + suffix + " ) ; " ) ;
			String form_code = ( String )hash.get( objname ) ;
			ArrayList routeOfDrug = new ArrayList();
			routeOfDrug = beanObj.getRouteOfDrug( form_code );
			String route_color="", fntColor="", backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
			if (routeOfDrug.size() != 0) {
				for (int i = 0; i < routeOfDrug.size(); i+=3) {
					route_color=(String)routeOfDrug.get(i+2) ;// added for CRF RUT-CRF-0034.1[IN:037389]-start
					if(route_color!= null && !route_color.equals("")){
						if(route_color.length()==12){
							fntColor= route_color.substring(0, 6);
							backgrndColor= route_color.substring(6, 12);
						}
					}
					else{
						fntColor= "";
						backgrndColor= "";
					}// added for CRF RUT-CRF-0034.1[IN:037389]-end
					out.println( "addList( '" + routeOfDrug.get(i) + "','" + routeOfDrug.get(i+1) + "','document.formPresRemark.ROUTE_CODE_','" + suffix +"','" + fntColor +"','" + backgrndColor +"') ; " ) ;
				}
			}
		}
		else if ( validate.equals( "FormCodeforMod" ) ) {
			String form_code = ( String )hash.get( objname ) ;
			ArrayList routeOfDrug = new ArrayList();
			routeOfDrug = beanObj.getRouteOfDrug( form_code );
			String route_color="", fntColor="", backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
			if (routeOfDrug.size() != 0) {
				if (calledFrom.equals("1")) {
					out.println( "clearList( 'f_query_add_mod.document.formPresRemark.ROUTE_CODEANDDESC', '' ) ; " ) ;
					for (int i = 0; i < routeOfDrug.size(); i+=3) {
						route_color=(String)routeOfDrug.get(i+2) ;// added for CRF RUT-CRF-0034.1[IN:037389]-start
						if(route_color!= null && !route_color.equals("")){
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}
						else{
							fntColor= "";
							backgrndColor= "";
						}// added for CRF RUT-CRF-0034.1[IN:037389]-end
						out.println( "addList( '" + routeOfDrug.get(i) + "','" + routeOfDrug.get(i+1) + "','f_query_add_mod.document.formPresRemark.ROUTE_CODEANDDESC', '','" + fntColor +"','" + backgrndColor +"') ; " ) ;
					}
				}
				else if (calledFrom.equals("2")) {
					out.println( "clearList( 'document.formPresRemark.ROUTE_CODEANDDESC', '' ) ; " ) ;
					for (int i = 0; i < routeOfDrug.size(); i+=3) {
						route_color=(String)routeOfDrug.get(i+2) ;// added for CRF RUT-CRF-0034.1[IN:037389]-start
						if(route_color!= null && !route_color.equals("")){
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}
						else{
							fntColor= "";
							backgrndColor= "";
						}// added for CRF RUT-CRF-0034.1[IN:037389]-end
						out.println( "addList( '" + routeOfDrug.get(i) + "','" + routeOfDrug.get(i+1) + "','document.formPresRemark.ROUTE_CODEANDDESC', '','" + fntColor +"','" + backgrndColor +"') ; " ) ;
					}
				}
			}
		}
		putObjectInBean(bean_id,beanObj,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}

%>
