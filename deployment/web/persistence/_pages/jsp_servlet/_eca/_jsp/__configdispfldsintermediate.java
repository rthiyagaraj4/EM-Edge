package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.SectionConfigDispFldBean;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __configdispfldsintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ConfigDispFldsIntermediate.jsp", 1709115774873L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>\n\t\t\tparent.ConfigDispCritList.location.href=\"../../eCA/jsp/ConfigDispCritList.jsp?resCategory=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&pos1=0&pos2=0\";\t\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&pos1=0&pos2=0&configStrSql=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&resSubCategory=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String key = request.getParameter("key")==null?"":request.getParameter("key");
	String fieldCount = request.getParameter("fieldCount")==null?"":request.getParameter("fieldCount");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String resCategory = request.getParameter("resCategory")==null?"":request.getParameter("resCategory");
	String resSubCategory = request.getParameter("resSubCategory")==null?"":request.getParameter("resSubCategory");
	String fillBean = request.getParameter("fillBean")==null?"":request.getParameter("fillBean");
	String configStrSql = request.getParameter("configStrSql")==null?"":request.getParameter("configStrSql");

	eCA.SectionConfigDispFldBean confBean = (eCA.SectionConfigDispFldBean)session.getAttribute("ConfigDispFldBean");
	if(confBean == null)
	{
		confBean	= new eCA.SectionConfigDispFldBean();
		session.setAttribute("ConfigDispFldBean", confBean);
	}

	if(fillBean != null && !fillBean.equals(""))
	{
		LinkedList<String> orderSeq = null;
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try 
		{
			String qryString = "SELECT  FIELD_REF, ORDER_SEQ_NUM FROM  CA_LINK_CATEG_DEF WHERE RESULT_CATEGORY =? ORDER BY 2";
			if(resSubCategory != null && !resSubCategory.equals("") )
			{
				qryString = "SELECT  FIELD_REF, ORDER_SEQ_NUM FROM  CA_LINK_CATEG_DEF WHERE RESULT_CATEGORY =? AND RESULT_SUB_CATEGORY=?ORDER BY 2";
			}
			con = ConnectionManager.getConnection(request);
			pst = con.prepareStatement(qryString);
			pst.setString(1, resCategory);
			if(resSubCategory != null && !resSubCategory.equals("") )
			{
				pst.setString(2, resSubCategory);
			}
			rs = pst.executeQuery();
			orderSeq = new LinkedList<String>();

			while(rs.next())
			{
				orderSeq.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in ConfigDispFlds.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con,request);
			}
			if(rs != null)
			{
				rs.close();
			}
			if(pst != null)
			{
				pst.close();
			}
		}
		
		if(configStrSql != null && !configStrSql.equals(""))
		{
			confBean.setSectionConfig(configStrSql, resCategory, resSubCategory, 0, 0);
		}
		else
		{
			confBean.setSectionConfig(resCategory, 0, 0);
		}

		if(orderSeq.size() > 0)
		{
			session.setAttribute("OrderSeq", orderSeq);
			confBean.setFieldOrder(orderSeq);		
		}
		else
		{
			session.setAttribute("OrderSeq", null);
		}
		if(resSubCategory == null || resSubCategory.equals(""))
			{
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(resCategory));
            _bw.write(_wl_block7Bytes, _wl_block7);

			 }
			else
			{
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(resCategory));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(configStrSql));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(resSubCategory));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
	}
	else if(confBean != null && fieldCount != null)
	{
		if(mode != null && mode.equals("ADD"))
		{
			confBean.addSelected(key, fieldCount);
		}
		else if(mode != null && mode.equals("REMOVE"))
		{
			confBean.removeSelected(key);
		}
	}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
