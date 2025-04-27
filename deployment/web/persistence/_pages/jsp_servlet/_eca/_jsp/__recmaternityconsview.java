package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recmaternityconsview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecMaternityConsView.jsp", 1709116210762L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<head> \n\t<link rel=\'StyleSheet\' href=\'../../eCA/html/SpecialityStyle.css\' type=\'text/css\'></link> \n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n\n<body class=\'MCCONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n\n<form name = \"RecMaternityconsViewForm\" >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	
	
	//String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"SpecialityStyle.css";
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);


	java.sql.Connection			con		=	null;
	java.sql.PreparedStatement	pstmt	=	null;
	java.sql.ResultSet			rs		=	null;
	String query_section_details		=	"";
	
	StringBuffer htmContent = new StringBuffer();
	String accession_num					="";
	String sec_hdg_code						="";
	String moduleId							="";
	String sectioncode						="";
	String sectiondesc						="";
	String sectionType						="";
	String hrmode							="";
	String modeValue						="";
	String patient_id						="";
	String cycle_no							="";
	String facility_id       = (String) session.getValue("facility_id");
	
	accession_num	=	request.getParameter("accessionNum")==null?"":request.getParameter("accessionNum");
	sec_hdg_code	=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	moduleId	=	request.getParameter("module_id")==null?"":request.getParameter("module_id");
	sectionType	=	request.getParameter("sectionType")==null?"":request.getParameter("sectionType");
	hrmode	=	request.getParameter("HRmode")==null?"":request.getParameter("HRmode");
	modeValue	=	request.getParameter("modeValue")==null?"":request.getParameter("modeValue");
	
	//modeValue	=	request.getParameter("modeValue")==null?"":request.getParameter("modeValue");
	patient_id	=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	cycle_no	=	request.getParameter("cycle_no")==null?"0":request.getParameter("cycle_no");
	//String QueryString	=	request.getQueryString() == null ? "" : request.getQueryString();
	String splt_event_code = request.getParameter("splty_event_code")==null?"":request.getParameter("splty_event_code");
//	String splty_task_code = request.getParameter("splty_task_code")==null?"":request.getParameter("splty_task_code");
	String birth_order = request.getParameter("birth_order")==null?"":request.getParameter("birth_order");
	
	con = ConnectionManager.getConnection(request);

	try
	{
		if(sectionType.equals("TM")||sectionType.equals("OC"))
		{
			query_section_details="SELECT HDR_CODE sectcode , HDR_CODE sectdesc, HTM_CONTENT FROM CA_PAT_SPLTY_TASK_DTL WHERE HDR_CODE=? AND ACCESSION_NUM =?";
		
		}

		else
		{
			if(modeValue.equals("VA"))
				{
					query_section_details = " SELECT  a.CHILD_SEC_HDG_CODE sectcode , a.CHILD_SEC_HDG_DESC sectdesc,  b.HTM_CONTENT FROM  CA_SUBSECTION_LINK_VW a,CA_PAT_SPLTY_TASK_DTL b,CA_PAT_SPLTY_EPISODE_TASK C WHERE b.HDR_CODE = a.HEADER_SEC_HDG_CODE AND SUBHDR_CODE = CHILD_SEC_HDG_CODE AND B.ACCESSION_NUM=C.ACCESSION_NUM AND C.PATIENT_ID = ? AND C.FACILITY_ID= ? AND C.MODULE_ID= ? AND C.CYCLE_NO = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE= 'MCT005' AND BIRTH_ORDER = 1 AND HDR_CODE='MC25' AND CHILD_SEC_HDG_CODE ='MC05' union all SELECT  a.CHILD_SEC_HDG_CODE sectcode , a.CHILD_SEC_HDG_DESC sectdesc,  b.HTM_CONTENT FROM  CA_SUBSECTION_LINK_VW a,CA_PAT_SPLTY_TASK_DTL b,CA_PAT_SPLTY_EPISODE_TASK C WHERE b.HDR_CODE = a.HEADER_SEC_HDG_CODE AND SUBHDR_CODE = CHILD_SEC_HDG_CODE AND B.ACCESSION_NUM=C.ACCESSION_NUM AND C.PATIENT_ID =? /*AND C.FACILITY_ID=?*/ AND C.MODULE_ID= ? AND C.CYCLE_NO = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND BIRTH_ORDER = ? AND   HDR_CODE='MC25' AND CHILD_SEC_HDG_CODE !='MC05' ";

				}
			else if(!hrmode.equals("H"))
			{
				query_section_details = "SELECT  a.CHILD_SEC_HDG_CODE sectcode , a.CHILD_SEC_HDG_DESC sectdesc,  b.HTM_CONTENT FROM  CA_SUBSECTION_LINK_VW a,CA_PAT_SPLTY_TASK_DTL b WHERE b.HDR_CODE = a.HEADER_SEC_HDG_CODE AND SUBHDR_CODE = CHILD_SEC_HDG_CODE AND   HDR_CODE=? AND ACCESSION_NUM = ? ";
			}
			else
			{
				
					query_section_details = "SELECT  a.CHILD_SEC_HDG_CODE sectcode , a.CHILD_SEC_HDG_DESC sectdesc,  b.HTM_CONTENT FROM  CA_SUBSECTION_LINK_VW a,CA_PAT_SPLTY_TASK_DTL b WHERE b.HDR_CODE = a.HEADER_SEC_HDG_CODE AND SUBHDR_CODE = CHILD_SEC_HDG_CODE AND   HDR_CODE=? AND ACCESSION_NUM = ? AND CHILD_SEC_HDG_CODE =? ";
				
			}
		}
			
			pstmt		=	con.prepareStatement(query_section_details);
				
			if(modeValue.equals("VA"))
				{									
					pstmt.setString(1,patient_id);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,moduleId);
					pstmt.setString(4,cycle_no);
					pstmt.setString(5,splt_event_code);
					//pstmt.setString(6,splty_task_code);
					pstmt.setString(6,patient_id);
			//		pstmt.setString(7,facility_id);
					pstmt.setString(7,moduleId);
					pstmt.setString(8,cycle_no);
					pstmt.setString(9,splt_event_code);
					//pstmt.setString(12,splty_task_code);
					pstmt.setString(10,birth_order);

				}
			else if(!hrmode.equals("H"))
			{
				pstmt.setString(1,sec_hdg_code);
				pstmt.setString(2,accession_num);
			}
			else
			{
				
				
					pstmt.setString(1,sec_hdg_code);
					pstmt.setString(2,accession_num);
					pstmt.setString(3,"MC03");
				
			}
			rs			=	pstmt.executeQuery();
	

		while(rs.next())
		{
				
			sectioncode = rs.getString("sectcode");
			sectiondesc = rs.getString("sectdesc");
			if(!sectionType.equals("TM"))
			{
				htmContent.append("<table width='100%' class='MCSUBHEADER'><tr><td align='left' colspan='3'><a name='"+sectiondesc+"'>"+sectiondesc+"</a></td></tr></table>");
			}
			Clob HTM_CONTENT = (Clob) rs.getClob("HTM_CONTENT");
			

			if(HTM_CONTENT !=null)
			{
				java.io.BufferedReader r = new java.io.BufferedReader(HTM_CONTENT.getCharacterStream());
				String line = null;

				while((line=r.readLine()) != null) 
				{
					htmContent.append(line);
				}
			}
			
		 }	
		
	}
	catch(Exception e)
	{
		//out.println("Exception @ RecMaternityConsView.jsp"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(htmContent.toString()));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RecMaternityconsView.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
