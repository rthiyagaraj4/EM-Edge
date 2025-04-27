package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import ePH.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __uomforformstore extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/UomForFormStore.jsp", 1709117419947L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

try {


    Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	int start					= Integer.parseInt((String) hash.get("start"));
	int end						= Integer.parseInt((String) hash.get("end"));
	String def_code				= (String) hash.get( "def_code" );
	ArrayList appl_Uom			=	new ArrayList();
	ArrayList associated_Uom	=	new ArrayList();
	Hashtable record			=	null;
	Hashtable associated_recs	=	null;
	String uom_code				=	"";
	String uom_desc				=	"";
	String uom_select			=	"";
	String uom_default			=	"";
	String uom_flag				=	"";
	UomForFormBean beanObj		= (UomForFormBean)getBeanObject(bean_id,bean_name ,request);
	boolean found				=	false;

	String frm_link				= (String) hash.get( "frm_link" );

	if(frm_link.equals("select"))
	{
		while(start<=end)
		{

		uom_code	=	(String) hash.get( "UomCode_"+start);
		uom_desc	=	(String) hash.get( "UomDesc_"+start);
		uom_default	=	(String) hash.get( "default_"+start);
		uom_select	=	(String) hash.get( "select_"+start);
		uom_flag	=	(String) hash.get( "flag_"+start);
		if(uom_code ==null || uom_desc==null || uom_default==null || uom_select==null)
		break;
		associated_recs	=	new Hashtable();
		associated_recs.put("code",uom_code);
		associated_recs.put("desc",uom_desc);
		associated_recs.put("default",uom_default);
		associated_recs.put("select",uom_select);
		if(uom_flag.equals("I") && uom_select.equals("Y"))	{
			associated_recs.put("flag","I");
		}
		else if(uom_flag.equals("I") && uom_select.equals("N"))	{
			associated_recs.put("default","N");
			associated_recs.put("flag","N");
		}
		else if(uom_flag.equals("DB") && uom_select.equals("Y"))	{
			if(def_code.equals(uom_code) && uom_default.equals("N"))
				associated_recs.put("flag","U");
			else if(!def_code.equals(uom_code) && uom_default.equals("Y"))
				associated_recs.put("flag","U");
			else
				associated_recs.put("flag","DB");
		}
		else if(uom_flag.equals("DB") && uom_select.equals("N"))	{
			associated_recs.put("default","N");
			associated_recs.put("flag","D");
		}
		else if(uom_flag.equals("D") && uom_select.equals("N"))	{
			associated_recs.put("default","N");
			associated_recs.put("flag","D");
		}
		else if(uom_flag.equals("D") && uom_select.equals("Y"))	{
			if(!def_code.equals(uom_code) && uom_default.equals("Y"))
				associated_recs.put("flag","U");
			else
				associated_recs.put("flag","DB");
		}
		else if(uom_flag.equals("U") && uom_select.equals("Y"))	{
			if(!def_code.equals(uom_code) && uom_default.equals("N"))
				associated_recs.put("flag","DB");
			else if(def_code.equals(uom_code) && uom_default.equals("Y"))
				associated_recs.put("flag","DB");
			else
				associated_recs.put("flag","U");
		}
		else if(uom_flag.equals("U") && uom_select.equals("N"))	{
						associated_recs.put("default","N");
						associated_recs.put("flag","D");
		}
		else
		associated_recs.put("flag","N");
		associated_Uom.add(associated_recs);
		start++;
		}

	//Update the newly added Records
		ArrayList vals	=	beanObj.getApplicableUom();
		for(int n=0; n<associated_Uom.size(); n++)	{
		Hashtable	assrec	=	(Hashtable)	associated_Uom.get(n);
		String ass_code		=		(String)assrec.get("code");
				for(int p=0; p<vals.size(); p++)	{
					Hashtable	selrec =	(Hashtable)	vals.get(p);
					String	sel_code   = (String) selrec.get("code");
					if(sel_code.equals(ass_code))	{
					vals.set(p,assrec);
					break;
					}
				}

		}

	}
	else	{

	while(start<=end)
	{
	uom_code	=	(String) hash.get( "UomCode_"+start);
	uom_desc	=	(String) hash.get( "UomDesc_"+start);
	uom_default	=	(String) hash.get( "default_"+start);
	uom_select	=	(String) hash.get( "select_"+start);
	uom_flag	=	(String) hash.get( "flag_"+start);

	if(uom_code ==null || uom_desc==null || uom_default==null || uom_select==null)
		break;
	record	=	new Hashtable();
	record.put("code",uom_code);
	record.put("desc",uom_desc);
		if(uom_default.equals("Y"))	{
		found=true;
		}
	record.put("default",uom_default);
	record.put("select",uom_select);
	if(uom_flag.equals("N") && uom_select.equals("Y"))
		record.put("flag","I");
	else if(uom_flag.equals("I") && uom_select.equals("Y"))
		record.put("flag","I");
	else if(uom_flag.equals("I") && uom_select.equals("N"))	{
		record.put("default","N");
		record.put("flag","N");
	}
	else if(uom_flag.equals("DB") && uom_select.equals("Y"))	{
		if(def_code.equals(uom_code) && uom_default.equals("N"))
			record.put("flag","U");
		else if(uom_default.equals("N"))
			record.put("flag","DB");
		else
			record.put("flag","U");
	}
	else if(uom_flag.equals("DB") && uom_select.equals("N"))	{
			record.put("default","N");
			record.put("flag","D");
	}
	else if(uom_flag.equals("D") && uom_select.equals("N"))	{
			record.put("default","N");
			record.put("flag","D");
		}
	else if(uom_flag.equals("D") && uom_select.equals("Y"))	{
			record.put("flag","D");
		}
	else if(uom_flag.equals("U") && uom_select.equals("Y"))	{
		 	record.put("flag","U");
		}
	else
		record.put("flag","N");

	appl_Uom.add(record);
	start++;
	}

		if(found)	{
		beanObj.makeDefault();
		}
	
	
	//Update the newly added Records
		ArrayList vals	=	beanObj.getApplicableUom();
		for(int n=0; n<appl_Uom.size(); n++)	{
		Hashtable	assrec	=	(Hashtable)	appl_Uom.get(n);
		String ass_code		=		(String)assrec.get("code");
				for(int p=0; p<vals.size(); p++)	{
					Hashtable	selrec =	(Hashtable)	vals.get(p);
					String	sel_code   = (String) selrec.get("code");
					if(sel_code.equals(ass_code))	{
					vals.set(p,assrec);
					break;
					}
				}

		}

	}

putObjectInBean(bean_id	,beanObj,request);

	}catch (Exception e) {
	out.println("alert(\"" + e + "\");") ;
	}


            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
