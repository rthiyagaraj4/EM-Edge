 <%@page import="java.util.*,java.io.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
		
	String func_mode			= request.getParameter("func_mode");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;

	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String facility_id   = (String)session.getValue( "facility_id" );
	String login_user	= (String)session.getValue("login_user");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	NPBRequestBean bean = (NPBRequestBean)getBeanObject(bean_id,bean_name ,request) ;
	try{
		bean.setLanguageId(locale);
		if(func_mode!= null && func_mode.equals("loadQuantityUOM")){
			String drugCode			= (String) hash.get("drugCode");
			ArrayList QtyDescDetails = null;
			if(drugCode==null || (drugCode.trim()).equals(""))
				QtyDescDetails	= (ArrayList)bean.loadQuantityUOM();
			else
				QtyDescDetails	= (ArrayList)bean.loadQuantityUOM(drugCode);
			String	uom_code	= "";
			String	uom_desc	= "";
			String  dflt_yn		= "";
			String  dflt_uomCode		= "";
			boolean deft_set = false;

			out.println("clearQtyDescList();");
			for(int i=0; i<QtyDescDetails.size(); i+=3)	{
				uom_code	= (String)QtyDescDetails.get(i);
				uom_desc	= (String)QtyDescDetails.get(i+1);
				if(uom_desc!=null && !uom_desc.equals("")){
					uom_desc=uom_desc.replaceAll(" ","%20");
					uom_desc= java.net.URLEncoder.encode(uom_desc,"UTF-8");
					uom_desc=uom_desc.replaceAll("%2520","%20");
				}
			//	if(((String)QtyDescDetails.get(i+2)).equals("Y"))
				dflt_yn		= ((String)QtyDescDetails.get(i+2))==null?"":(String)QtyDescDetails.get(i+2);
				if(dflt_yn.equals("Y"))
					dflt_uomCode= uom_code;
				out.println("addQtyDescList('"+uom_code+"','"+uom_desc+"');");
			}
			if(!dflt_uomCode.equals(""))
				out.println("setDefaultUOM('"+dflt_uomCode+"');");
			
			if(QtyDescDetails == null || QtyDescDetails.size()==0){
				out.println("addQtyDescList('','  ----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label", "common_labels")+"---   ');");
			}
		}		
		else if(func_mode.equals("StoreEditorText")){
			String NPBReqFormText			= java.net.URLDecoder.decode((String) hash.get("NPBReqFormText"),"UTF-8");
			String NPBReqFormId			= (String) hash.get("NPBReqFormId");
			if(!NPBReqFormId.equals(bean.getNPBReqFormId()))
				bean.setNPBReqFormId(NPBReqFormId);
			bean.setNPBReqFormText(NPBReqFormText);
		}
		else if(func_mode.equals("StoreEditorTextAmend")){
			String NPBReqFormText			= java.net.URLDecoder.decode((String) hash.get("NPBReqFormText"),"UTF-8");
			String request_no			= (String) hash.get("request_no");
			bean.setNPBRequestFormText(request_no, NPBReqFormText);
		}
		else if(func_mode.equals("searchNPBRequests")){
		}		 
	}
	catch(Exception e){
		e.printStackTrace();
	}

	putObjectInBean(bean_id,bean,request);
%>
