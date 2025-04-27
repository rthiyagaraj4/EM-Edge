package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import com.ehis.util.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgrefundvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgRefundValidation.jsp", 1743663937222L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();	
try {
	
	String bean_id		= "PkgRefundBean" ;
	String bean_name	= "eBL.PkgRefundBean";
	PkgRefundBean bean			= (PkgRefundBean)getBeanObject( bean_id, bean_name, request ) ;
	String locale			= (String)session.getAttribute("LOCALE");

	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
		if(func_mode!= null && func_mode.equals("getPatDtls")){
			String patient_id =hash.get( "patient_id" ) == null ? "":(String)hash.get( "patient_id" ) ;
			String pat_dtls=bean.getPatientDtls(patient_id,locale);
			if ( pat_dtls == null ) pat_dtls = "";
			if(!pat_dtls.equals("")){
				int ind=pat_dtls.indexOf("#");
				pat_dtls=pat_dtls.substring(0,ind);
				if ( pat_dtls == null ) pat_dtls = "";
				if(!pat_dtls.equals(""))
				out.println("document.PkgRefundHdrForm.pat_dtls.innerHTML='"+pat_dtls+"'");
			}
			if(pat_dtls.equals("")){
				out.println("alert(getMessage(\"BL0440\",\"BL\"))");
				out.println("document.PkgRefundHdrForm.patient_id.value=''");
				out.println("document.PkgRefundHdrForm.pat_dtls.innerHTML=''");
			}
						
		}else if(func_mode!= null && func_mode.equals("getPkgDtls")){
			String patient_id =hash.get( "patient_id" ) == null ? "":(String)hash.get( "patient_id" ) ;
			String facility_id =hash.get( "facility_id" ) == null ? "":(String)hash.get( "facility_id" ) ;
			String pkg_code =hash.get( "pkg_code" ) == null ? "":(String)hash.get( "pkg_code" ) ;
			String[] pkg_dtls=bean.getPkgDtls(facility_id,patient_id,locale,pkg_code);
			out.println("document.PkgRefundHdrForm.pkg_seq_no.value='"+pkg_dtls[1]+"'");
			
		}else if(func_mode!= null && func_mode.equals("saveExclToBean")){
			HashMap excl_srv_dtls=new HashMap();
			String	total_records		=	(String) hash.get( "total_records" );
			String[] record;
			int totalRec				=	Integer.parseInt(total_records);
			String pkg_serv_code = "";
			ArrayList excl_srv_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   pkg_serv_code = (String) hash.get( "pkg_serv_code" );
			   if(pkg_serv_code!=null && !pkg_serv_code.equals(""))
			   {
					record=new String[13];
					record[0]=(String)hash.get( "excl_serv_ind"+i );
					record[1]=(String)hash.get( "excl_serv_code"+i );
					record[2]=(String)hash.get( "excl_serv_desc"+i );
					record[3]=(String)hash.get( "exclude_yn"+i );
					record[4]=(String)hash.get( "refund_yn"+i );
					record[5]=(String)hash.get( "refund_rate"+i );
					record[6]=(String)hash.get( "utilized_serv_qty"+i );
					record[7]=(String)hash.get( "utilized_serv_amt"+i );
					record[8]=hash.get( "available_amt"+i )==null?"0":((String)hash.get( "available_amt"+i ));
					record[9]=hash.get( "refund_amt"+i )==null?"0":((String)hash.get( "refund_amt"+i ));
					record[10]=(String)hash.get( "refunded"+i );
					record[11]=hash.get( "refunded_amount"+i )==null?"0":((String)hash.get( "refunded_amount"+i ));
					record[12]=(String)hash.get( "refund_serv"+i );					
					excl_srv_list.add(record)	;									
			   }
			}	
			if(excl_srv_dtls!=null && excl_srv_dtls.size()>0 && excl_srv_dtls.containsKey(pkg_serv_code))
				excl_srv_dtls.remove(pkg_serv_code);
				 if(excl_srv_list.size()>0)
			   {
					excl_srv_dtls.put(pkg_serv_code,excl_srv_list);					
					bean.setExclSrvDtls(excl_srv_dtls);	
				}
		
		}else if(func_mode!= null && func_mode.equals("saveSrvToBean")){
			ArrayList srv_dtls=new ArrayList();
			String	total_records		=	(String) hash.get( "total_records" );
			String[] record;
			int totalRec				=	Integer.parseInt(total_records);
			String pkg_serv_code="";
			for(int i=0;i<totalRec; i++)
			{
			   pkg_serv_code = (String) hash.get( "pkg_serv_code"+i );
			   if(pkg_serv_code!=null && !pkg_serv_code.equals(""))
			   {
					record=new String[13];
					record[0]=(String)hash.get( "pkg_serv_ind"+i );
					record[1]=(String)hash.get( "pkg_serv_code"+i );
					record[2]=(String)hash.get( "pkg_serv_desc"+i );
					record[3]=(String)hash.get( "order_catalog_code"+i );
					record[4]=(String)hash.get( "refund_yn"+i );
					record[5]=(String)hash.get( "refund_rate"+i );
					record[6]=(String)hash.get( "utilized_serv_qty"+i );
					record[7]=(String)hash.get( "utilized_serv_amt"+i );					
					record[8]=(String)hash.get( "available_amt"+i );					
					record[9]=(String)hash.get( "refund_amt"+i );					
					record[10]=(String)hash.get( "refunded"+i );					
					record[11]=hash.get( "refunded_amount"+i )==null?"0":((String)hash.get( "refunded_amount"+i ));				
					record[12]=(String)hash.get( "refund_serv"+i );					
					srv_dtls.add(record)	;									
			   }
			}	
			if(srv_dtls!=null && srv_dtls.size()>0)
				bean.setPkgSrvDtls(srv_dtls);		
		}
		putObjectInBean(bean_id,bean,request);
}catch (Exception e) {
	e.printStackTrace() ;
	System.out.println("Exception from PkgRefundValidation :"+e);
}finally
	{
		//if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}



            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
