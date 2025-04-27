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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderroutingvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OrderRoutingValidate.jsp", 1721013785589L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
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

	request.setCharacterEncoding("UTF-8");	
	String locale			= (String)session.getAttribute("LOCALE");
	


	String bean_id	= request.getParameter( "bean_id" ) ;
	String bean_name= request.getParameter( "bean_name" ) ;
	String ordering_source_type	= (request.getParameter( "ordering_source_type" )==null?"":request.getParameter( "ordering_source_type" ));
	String disp_locn_type = request.getParameter("disp_locn_type");
	String routing_level = request.getParameter( "routing_level" );
	String facility_id	=	request.getParameter("facility_id");
	String routing_code =   request.getParameter("routing_code");
	String identity		=	request.getParameter("identity");
	String modifyMode = request.getParameter("modifyMode");
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	OrderRoutingBean bean = (OrderRoutingBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(locale);
	bean.clear();

	if (modifyMode==null){
		modifyMode = "";
	}
	if(identity==null){
		identity = "";
	}

	if(identity.equals("S")){
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

	if (!modifyMode.equals("Yes")){
		if (ordering_source_type != null){
			ArrayList arrList = bean.loadRelatedLocation(facility_id,ordering_source_type);
			for (int i=0;i<arrList.size();i++){
				//out.println("loadIntoLocation('"+(String)arrList.get(i)+"','"+(String)arrList.get(++i)+"')");
				 String QryMode=request.getParameter("QryMode");
				if(QryMode!=null){
					out.println( "loadIntoLocationQry(\"" +(String)arrList.get(i)+ "\",\"" +(String)arrList.get(++i)+ "\") ; " ) ;
			    }else{
             	out.println( "loadIntoLocation(\"" +(String)arrList.get(i)+ "\",\"" +(String)arrList.get(++i)+ "\") ; " ) ;
				}
			}
		}
		if(routing_code != null){
			if(routing_code.equals("ALLA") || routing_code.equals("CMPA") || routing_code.equals("IVOA") || routing_code.equals("ONCA") || routing_code.equals("TPNA")){
				bean.setDispLocnForAdmixtures("Y");
			}else{
				bean.setDispLocnForAdmixtures("N");
			}
		}
		if (routing_code ==null && identity.equals(""))	{
			if ((routing_level != null)){
				ArrayList all = bean.getDataForList();
				ArrayList routingCode = (ArrayList)all.get(2);
				for (int i=0;i<routingCode.size();i++){
					out.println("addDataToRoutingCode('"+routingCode.get(i)+"','"+routingCode.get(++i)+"','"+routingCode.get(++i)+"')");
				}
			}
		}else if ((routing_code != null)&&(!routing_level.equals("G"))){

			ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
			for (int i=0;i<all.size();i++){
				out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
			}
			ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
			for (int i=0;i<allD.size();i++){
				out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
			}
		}else if ((routing_code != null)&&(routing_level.equals("G"))){
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
	if (modifyMode.equals("Yes")){
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

            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);

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
