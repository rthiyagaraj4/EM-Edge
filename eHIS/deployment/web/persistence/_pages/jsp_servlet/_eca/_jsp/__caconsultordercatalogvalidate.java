package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __caconsultordercatalogvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAConsultOrderCatalogValidate.jsp", 1732512255196L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

	//HashMap dataMap=null;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String index_value	= (String)hash.get("INDEX_VALUES");
	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");
	String called_from	= (String)hash.get("CALLED_FROM");
	String speciality_code	= (String)hash.get("SPECIALITY_CODE");
	String code="";
	String description="";
//	String class_name   = (String)hash.get("CLASS_NAME");
	String update_value	="";
	//boolean alteredRecord = false;
//	int count_code		= 0;

	CAConsultationBean bean				= (CAConsultationBean)getObjectFromBean( bean_id,bean_name, session ) ;
	eCA.CAMultiRecordBean multiRecSet	= (eCA.CAMultiRecordBean)bean.getBean();
	if(called_from.equalsIgnoreCase("create"))
	{
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
	
	try{

		con =  ConnectionManager.getConnection(request);

		String catalogQuery = "select a.order_catalog_code code,b.short_desc description from CA_CONS_CATALOG_FOR_RESOURCE a,or_order_catalog b where a.order_catalog_code=b.order_catalog_code and a.resource_code=? and a.resource_type='S'" ;

		stmt = con.prepareStatement(catalogQuery);

		stmt.setString(1,speciality_code.trim());
		
		rs = stmt.executeQuery();

		while(rs.next())
		{
			code=rs.getString("code")==null?"":rs.getString("code").trim();
			description=rs.getString("description")==null?"":rs.getString("description").trim();
			out.println( "CatalogValues(\"" +code+" \",\"" +description+"\") ; " ) ;
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
			
		ConnectionManager.returnConnection(con,request);
	}

	}
	else if(called_from.equalsIgnoreCase("practcreate"))
	{
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
	
	try{

		con =  ConnectionManager.getConnection(request);

		String catalogQuery = "select a.order_catalog_code code,b.short_desc description from CA_CONS_CATALOG_FOR_RESOURCE a,or_order_catalog b where a.order_catalog_code=b.order_catalog_code and a.resource_code=? and a.resource_type='P'" ;

		stmt = con.prepareStatement(catalogQuery);

		stmt.setString(1,speciality_code.trim());
		
		rs = stmt.executeQuery();

		while(rs.next())
		{
			code=rs.getString("code")==null?"":rs.getString("code").trim();
			description=rs.getString("description")==null?"":rs.getString("description").trim();
			out.println( "practCatalogValues(\"" +code+" \",\"" +description+"\") ; " ) ;
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
			
		ConnectionManager.returnConnection(con,request);
	}

	}
	else
	{
		int fm_value = Integer.parseInt(fm_val);
		int to_value = Integer.parseInt(to_val);

		StringTokenizer stoken = new StringTokenizer(index_value,"~");
	//	count_code		=	stoken.countTokens();

		for(int j=fm_value; j<=to_value; j++){
			update_value		=	stoken.nextToken();
			if(tab_value.equals("S"))
				multiRecSet.setBeanValue(j,update_value);  //alteredRecord		=	multiRecSet.setBeanValue(j,update_value);
			else if(tab_value.equals("A"))
				multiRecSet.setDBBeanValue(j,update_value); //alteredRecord		=	multiRecSet.setDBBeanValue(j,update_value);
		}
	}

	putObjectInBean(bean_id,bean,session);
	
	/*
	out.println(tab_value);
	out.println(alteredRecord);
	out.println(index_value);
	out.println(fm_value);
	out.println(to_value);
	out.println(count_code);
	*/


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
