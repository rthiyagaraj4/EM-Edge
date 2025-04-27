package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.Common.*;
import eOR.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ordersetvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderSetValidate.jsp", 1732514614000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n ";
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		07/08/2017		Ramesh G		ML-MMOH-CRF-0345.1
12/02/2018	IN065713		Dinesh T		12/02/2017		Ramesh G		ML-MMOH-CRF-0987
10/10/2018	IN68241			Dinesh T		10/10/2018		Ramesh G		ML-MMOH-CRF-1227
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
08/01/2020	IN068314	Nijitha S     08/01/2020	Ramesh G	ML-MMOH-CRF-1229
---------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);

try
{
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= (String)hash.get("BEAN_ID");
	String l_class_name = (String)hash.get("CLASS_NAME");//IN062992
	String l_catalog_code = (String)hash.get("CATALOG_CODE");//IN062992
	String l_iv_prep_yn = (String)hash.get("IV_PREP_YN");//IN062992
	String l_dosage_type = (String)hash.get("P_DOSAGE_TYPE");
	String l_age_grp_code = (String)hash.get("P_AGE_GRP_CODE");

	CareSetBean bean = (CareSetBean)getBeanObject( bean_id,"eOR.CareSetBean", request ) ;
	
	String localeName=(String)session.getAttribute("LOCALE");
	bean.setLanguageId(localeName);

	//IN062992, starts
	//bean.setHashValues(hash);//IN062992
	if("DOSAGE_TYPE_AGE_GROUP".equals(l_class_name))
	{
		//bean.clearAdditionalCatalogs();//IN065713
		bean.clearAdditionalCatalogs(l_catalog_code);//IN065713
		bean.setAgeGrpWiseHashValues(hash);
	}
	else if("CLEAR_AGE_WISE_CATALOG_DETAILS".equals(l_class_name))
	{
		bean.getDBAgeWiseCatalogs().remove(l_catalog_code);
		//bean.ageWiseDBCatalogsSpecific(l_catalog_code);
	}
	else if("CLEAR_AGE_WISE_ALL_DETAILS".equals(l_class_name))
	{
		bean.getDBAgeWiseCatalogs().clear();
	}
	else if("CLEAR_ALL".equals(l_class_name))
	{
		bean.setApplicableTo(l_iv_prep_yn);
		bean.reloadFreqRecordedData();
		bean.clearAdditionalCatalogs();//IN065713
		
		bean.getDBAgeWiseCatalogs().clear();
		bean.getDBAgeWiseAdditionalCatalogs().clear();
		bean.getDosageTypeHashValues().clear();
		bean.getDosageTypeAdditionalKgHashValues().clear();
		bean.getDosageTypeAdditionalM2HashValues().clear();
	}
	else if("ORD_SET_AGE_GRP".equals(l_class_name))//IN065713, starts
	{
		bean.setAgeGrpWiseAdditionalHashValues(hash);
	}//IN065713, ends
	else if("DOSAGE_TYPE_DEFN_ADDITIONAL".equals(l_class_name))
	{
		if("K".equals(l_dosage_type))
			bean.setDosageTypeAdditionalKgHashValues(hash);
		else if("M".equals(l_dosage_type))
			bean.setDosageTypeAdditionalM2HashValues(hash);	
	}
	else if("DOSAGE_TYPE_DEFN".equals(l_class_name))
	{
		bean.setDosageTypeHashValues(hash);
	}
	else if("DOSAGE_TYPE_DEFN_CLEAR".equals(l_class_name))
	{	
		bean.clearDosageTypeWiseAdditional(l_catalog_code,l_dosage_type);		
	}	
	else if("CLEAR_ADDITIONAL_FOR_BASIC_DOSAGE_TYPE".equals(l_class_name))
	{	
		String l_index = (String)hash.get("INDEX");
		bean.clearAdditionalCatalogs(l_catalog_code);
		
		//if(bean.getDosageTypeHashValues().size()>0)
		out.println("clearAdditionals('"+l_index+"')");
	}
	else if("CLEAR_MAPPED_FACS".equals(l_class_name))//IN068370,IN068373, starts
	{
		bean.clearMappedFacilities();
	}//IN068370,IN068373, ends
	else if("VALIDATE_FPP_CATALOGS".equals(l_class_name)){//IN068314 Starts
		
		MultiRecordBean1 data =bean.getComponentStr();
		int size = data.getSize("DB");
		System.out.println("111:size1===>"+size);	
		out.println(size);
	}//IN068314 Ends
	else
	{		
		bean.setHashValues(hash);	
	}
	//IN062992, ends
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
e.printStackTrace();	
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
