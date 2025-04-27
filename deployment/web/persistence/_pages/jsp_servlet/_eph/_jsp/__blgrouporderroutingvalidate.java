package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blgrouporderroutingvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eph/jsp/BLGroupOrderRoutingValidate.jsp", 1721221152538L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n \n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
 /*-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/10/2017      IN063877         Devindra       Unused Variables.
--------------------------------------------------------------------------------------------------------------- */
/*Commented for GHL-SCF-1344 */ 
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	try{
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String bean_id	= request.getParameter( "bean_id" ) ;
		String bean_name= request.getParameter( "bean_name" ) ;
		String ordering_source_type	= (request.getParameter( "ordering_source_type" )==null?"":request.getParameter( "ordering_source_type" ));
		String disp_locn_type = request.getParameter("disp_locn_type");
		String routing_level = request.getParameter( "routing_level" );
		String facility_id	=	request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String routing_code =   request.getParameter("routing_code")==null?"":request.getParameter("routing_code");
		String identity		=	request.getParameter("identity")==null?"":request.getParameter("identity");
		String modifyMode = request.getParameter("modifyMode")==null?"":request.getParameter("modifyMode");
		Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		ArrayList altdispdetails=new ArrayList();
		BLGroupOrderRoutingBean bean = (BLGroupOrderRoutingBean)getBeanObject( bean_id,  bean_name , request) ;
		bean.setLanguageId(locale);
		if (identity.equals("LOADDISPLOCANS")){
			ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
			out.println(all.size());
			for (int i=0;i<all.size();i++){
				out.println("addRoutineStatListInModify('"+all.get(i)+"','"+all.get(++i)+"')");
			}
			ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
			out.println(allD.size());
			for (int i=0;i<allD.size();i++){
				out.println("addDischargeListInModify('"+allD.get(i)+"','"+allD.get(++i)+"')");
			}
		}
		if (identity.equals("LOADALLDISPLOCANS")){
			if (ordering_source_type != null){
				ArrayList arrList = bean.loadRelatedLocation(facility_id,ordering_source_type);
				 String QryMode=request.getParameter("QryMode");
				for (int i=0;i<arrList.size();i++){
					if(QryMode!=null){
						out.println( "loadIntoLocationQry(\"" +(String)arrList.get(i)+ "\",\"" +(String)arrList.get(++i)+ "\") ; " ) ;
					}
					else{
						out.println( "loadIntoLocation(\"" +(String)arrList.get(i)+ "\",\"" +(String)arrList.get(++i)+ "\") ; " ) ;
					}
				}
			}
			if(routing_code != null){
				if(routing_code.equals("ALLA") || routing_code.equals("CMPA") || routing_code.equals("IVOA") || routing_code.equals("ONCA") || routing_code.equals("TPNA")){
					bean.setDispLocnForAdmixtures("Y");
				}
				else{
					bean.setDispLocnForAdmixtures("N");
				}
			}
			if (routing_code ==null||routing_code.equals(""))	{// ||routing_code=="" added for MMS_BETA_0047[IN:046258]
				if ((routing_level != null)){
					ArrayList all = bean.getDataForList();
					ArrayList routingCode = (ArrayList)all.get(2);
					for (int i=0;i<routingCode.size();i++){
						out.println("addDataToRoutingCode('"+routingCode.get(i)+"','"+routingCode.get(++i)+"','"+routingCode.get(++i)+"','"+modifyMode+"')");
					}
				}
			}
			else if ((routing_code != null)&&(!routing_level.equals("G"))){

				ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
				for (int i=0;i<all.size();i++){
					out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
				}
				ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
				for (int i=0;i<allD.size();i++){
					out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
				}
			}
			else if ((routing_code != null)&&(routing_level.equals("G"))){
				ArrayList all = bean.getDefaultDispLocDataForDrug(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
				for (int i=0;i<all.size();i++){
					out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
				}
				ArrayList allD = bean.getDefaultDispLocDataForDrugD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
				for (int i=0;i<allD.size();i++){
					out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
				}
			}
		}
		else if(identity.equals("LOADALLDISPLOCANS_AFTER_UPDATE")){
			if((routing_code != null)&&(!routing_level.equals("G"))){
				ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
				for (int i=0;i<all.size();i++){
					out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
				}
				ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
				for (int i=0;i<allD.size();i++){
					out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
				}
			}
			else if((routing_code != null)&&(routing_level.equals("G"))){
				ArrayList all = bean.getDefaultDispLocDataForDrug(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
				for (int i=0;i<all.size();i++){
					out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
				}
				ArrayList allD = bean.getDefaultDispLocDataForDrugD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
				for (int i=0;i<allD.size();i++){
					out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
				}
			}
		}
		else if(identity.equals("S")){
			ArrayList all = bean.getDefaultDispLocDataForSource(facility_id.trim(),ordering_source_type); //shyampriya
			for (int i=0;i<all.size();i++){
				out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
			}
			ArrayList allD = bean.getDefaultDispLocDataForSourceD(facility_id.trim()); //shyampriya
			for (int i=0;i<allD.size();i++){
				out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
			}
			return;
		}
		else if(identity.equals("loadCustomer")){
			String cust_group_code=request.getParameter("customer_group"); 
			ArrayList customer = bean.getCustomer(cust_group_code); 
			String customername="";                                                // Added for MMSBETA  MMS_BETA_0037[IN046175]
			for (int i=0;i<customer.size();i+=2){
				 customername=customer.get(i+1).toString().replaceAll(" ","%20");	// Added for MMSBETA  MMS_BETA_0037[IN046175]
				 customername = java.net.URLEncoder.encode(customername,"UTF-8");	// Added for MMSBETA  MMS_BETA_0037[IN046175]
				 customername=customername.replaceAll("%2520","%20");              // Added for MMSBETA   MMS_BETA_0037[IN046175]
				 out.println("addCustomer('"+customer.get(i)+"','"+customername+"')");
			}
		}
		else if(identity.equals("loadCustomerAfterUpdate")){ //loadCustomerclick
			String cust_group_code=request.getParameter("customer_group"); 
			ArrayList customer = bean.getCustomer(cust_group_code); 
			String customername="";    
			for (int i=0;i<customer.size();i+=2){
				 customername=customer.get(i+1).toString().replaceAll(" ","%20");	// Added for MMSBETA  MMS_BETA_0037[IN046175]
				 customername =java.net.URLEncoder.encode(customername,"UTF-8");	// Added for MMSBETA  MMS_BETA_0037[IN046175]
				 customername=customername.replaceAll("%2520","%20");              // Added for MMSBETA   MMS_BETA_0037[IN046175]
				out.println("addCustomerAfterEdit('"+customer.get(i)+"','"+customername+"')"); ///addCustomerclick
			}
		}
		else if(identity.equals("loadPolcyType")){
			String cust_group_code=request.getParameter("customer_group"); 
			String customer_id=request.getParameter("customer_id"); ;
			ArrayList polocyType = bean.getPolocyType(cust_group_code,customer_id,facility_id.trim()); 
			for (int i=0;i<polocyType.size();i+=2){
				out.println("addPolocyType('"+polocyType.get(i)+"','"+polocyType.get(i+1)+"')");
			}
		}	
		else if(identity.equals("loadPolicyAfterUpdate")){//loadPolicyclick
			String cust_group_code=request.getParameter("customer_group");
			String customer_id=request.getParameter("customer_id"); 
			ArrayList polocyType = bean.getPolocyType(cust_group_code,customer_id,facility_id.trim()); 
			for (int i=0;i<polocyType.size();i+=2){
				out.println("addPolocyAfterEdit('"+polocyType.get(i)+"','"+polocyType.get(i+1)+"')");//addPolocyClickType
			}
		}		
		if(identity.equals("alt_disp_locn_select")){	
			String alt_disp_code=request.getParameter("alt_disp_code");
			String frmtime=request.getParameter("frmtime");
			String totime=request.getParameter("totime");
			String flag=request.getParameter("flag");
			String eff_status=request.getParameter("eff_status");
			String repeat=request.getParameter("repeat");
			String id=request.getParameter("id");
			String order_src_type = (String)hash.get("ord_src_type");
			String ord_src_code = (String)hash.get("ord_src_code");
			String perform_fcy = (String)hash.get("perform_fcy");
			String order_fcy = (String)hash.get("order_fcy");
			String day_type = (String)hash.get("day_type");
			String disp_locn_code = (String)hash.get("disp_locn_code");
			String routing_level_code = (String)hash.get("routing_level_code");
			String routing_code_alt = (String)hash.get("routing_code");
			String billing_group_id = (String)hash.get("billing_group_id");
			String customer_group_id = (String)hash.get("customer_group_id");
			String customer_id = (String)hash.get("customer_id");
			String policy_type_id = (String)hash.get("policy_type_id");
			String mode =(String)hash.get("mode");
			String flag_mode =(String)hash.get("flag_mode");
			if(mode.equals("undefined") && flag_mode.equals("I"))
				mode="1";
			if(mode.equals("undefined") && flag_mode.equals("U"))
				mode="UPDATE";
		//	ArrayList altdisp=new ArrayList(); // comment Added for IN063877
		}
		else if(identity.equals("store_alt_data")){
			String mode =request.getParameter("mode");
			String callFrom =request.getParameter("callFrom");
			String res="";
			String tmplDtlString =request.getParameter("tmplDtlString");
			String alt_disp_code=request.getParameter("alt_disp_code");
			String frmtime=request.getParameter("frmtime");
			String totime=request.getParameter("totime");
			String flag=request.getParameter("flag");
			String eff_status=request.getParameter("eff_status");
			String repeat=request.getParameter("repeat");
			String id=(String)hash.get("id");
			String order_src_type = (String)hash.get("ord_src_type");
			String ord_src_code = (String)hash.get("ord_src_code");
			String perform_fcy = (String)hash.get("perform_fcy");
			String order_fcy = (String)hash.get("order_fcy");
			String day_type = (String)hash.get("day_type");
			String disp_locn_code = (String)hash.get("disp_locn_code");
			String routing_level_code = (String)hash.get("routing_level_code");
			String routing_code_alt = (String)hash.get("routing_code");
			String billing_group_id = (String)hash.get("billing_group_id");
			String customer_group_id = (String)hash.get("customer_group_id");
			String customer_id = (String)hash.get("customer_id");
			String policy_type_id = (String)hash.get("policy_type_id");
			String flag_mode =(String)hash.get("flag_mode");
			
			if(mode.equals("undefined") && flag_mode.equals("I"))
				mode="1";
			if(mode.equals("undefined") && flag_mode.equals("U"))
				mode="UPDATE";
			ArrayList altdisp=new ArrayList();
			altdisp=bean.selectedlocn(alt_disp_code,frmtime,totime,flag,eff_status,repeat,id,order_src_type,ord_src_code,perform_fcy,order_fcy,day_type,disp_locn_code,routing_level_code,routing_code_alt,billing_group_id,customer_group_id,customer_id,policy_type_id,mode,tmplDtlString);
			 res =bean.TimeChk();
			if (res.equals("Y")) {
				out.println("alert(getMessage('ALT_TIMINGS_OVERLAP','PH'));") ;
				return;
			}
			bean.getAltDispData();
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
