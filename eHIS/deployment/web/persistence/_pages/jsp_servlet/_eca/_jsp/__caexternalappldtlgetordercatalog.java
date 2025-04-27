package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __caexternalappldtlgetordercatalog extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAExternalApplDtlGetOrderCatalog.jsp", 1709115516138L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/CAExternalApplDtl.js\'></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script language=javascript>\n\t\nfunction callfunction(order_category,order_type_code){\n\t\t\t\n\n\t\t\tvar target=parent.frames[1].document.forms[0].order_catalog1;\n\t\t\tvar retVal=  new String();\n\t\t\tvar dialogTop\t= \"40\";\n\t\t\tvar dialogHeight= \"10\" ;\n\t\t\tvar dialogWidth= \"40\" ;\n\t\t\tvar features= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar search_desc\t= \"\";\n\t\t\tvar title=getLabel(\"Common.ordercatalog.label\",\"Common\");\n\t\t\t//var title=\"Order Catalog\";\n\t\t\tvar sql=\"select order_catalog_code code,short_desc description from or_order_catalog where  order_category = \'\"+order_category+\"\' and order_type_code    =\'\"+order_type_code+\"\' and eff_status=\'E\' and upper(order_catalog_code) like upper(?)  and upper(short_desc) like upper(?)  \";\n\t\t\tvar argArray = new Array();\n\t\t\tvar namesArray = new Array();\n\t\t\tvar valuesArray = new Array();\n\t\t\tvar datatypesArray = new Array();\n\t\t\targArray[0] = sql;\n\t\t\targArray[1] = namesArray;\n\t\t\targArray[2] = valuesArray;\n\t\t\targArray[3] = datatypesArray;\n\t\t\targArray[4] = \"2,1\";\n\t\t\targArray[5] = target.value;\n\t\t\targArray[6] = DESC_LINK;\n\t\t\targArray[7] = DESC_CODE;\n\n\t\t\tif(parent.frames[1].document.forms[0].order_catalog.value!=\"ALL\" && parent.frames[1].document.forms[0].order_catalog.value!=\"\"){\n\t\t\t\tretArray = CommonLookup(title,argArray);\n\t\t\t\t\n\t\t\t\tif(retArray != null && retArray !=\"\"){\n\t\t\t\t\t\tparent.frames[1].document.forms[0].order_catalog1.value = retArray[1];\n\t\t\t\t\t\tparent.frames[1].document.forms[0].order_catalog.value=retArray[0];\n\t\t\t\t\t\tparent.frames[1].document.forms[0].catalog_buttn.disabled=false;\n\t\t\t\t\t}else {\n\t\t\t\t\t\tparent.frames[1].document.forms[0].order_catalog1.value = \"All\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].order_catalog.value = \"*ALL\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].catalog_buttn.disabled=false;\n\t\t\t}\n\t\t}\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\';\n}\n\n</script>\n</head>\n<body onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t\t\t<script language=javascript>\n\t\t\t\tparent.frames[1].document.forms[0].catalog_buttn.disabled=true;\n\t\t\t\tcallfunction(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String search_value=request.getParameter("search_value")==null?"":request.getParameter("search_value");	
		String order_category=request.getParameter("order_category")==null?"":request.getParameter("order_category");	
		String order_type_code=request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");	

		String order_catalog_code = "";
		String short_desc = "";
		String sql = "";
		int count=0;
		
		try
		{
			con=ConnectionManager.getConnection();
			if (!search_value.equals("")){
					search_value=search_value+"%";
				}
				
				//sql = "select ORDER_CATALOG_CODE ,SHORT_DESC from or_order_catalog where  ORDER_CATEGORY = '"+order_category+"' and ORDER_TYPE_CODE    ='"+order_type_code+"' and eff_status='E' and upper(SHORT_DESC) like upper(?) ";//common-icn-0180
				sql = "select ORDER_CATALOG_CODE ,SHORT_DESC from or_order_catalog where  ORDER_CATEGORY = '"+order_category+"' and ORDER_TYPE_CODE    ='"+order_type_code+"' and eff_status='E' and upper(SHORT_DESC) like upper(?) ";//common-icn-0180
				
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,order_category);//common-icn-0180
				pstmt.setString(2,order_type_code);//common-icn-0180
				//pstmt.setString(1,search_value);//common-icn-0180
				pstmt.setString(3,search_value);//common-icn-0180
				rset=pstmt.executeQuery();

				while(rset.next())
				{	
					   order_catalog_code=rset.getString("ORDER_CATALOG_CODE");
                       short_desc=rset.getString("SHORT_DESC");
					   count=count+1;
				}
		if (count==1)
		{ 
			out.println("<script>");
			out.println("parent.frames[1].document.forms[0].order_catalog1.value='"+short_desc+"'");
			out.println("parent.frames[1].document.forms[0].order_catalog.value='"+order_catalog_code+"'");
			out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
			out.println("</script>");
		}

		if(count>1 || count==0){	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
		}
	}
	catch(Exception ex){
			//out.println("Exception in try of CAExternalApplDtlGetOrderCatalog.jsp"+ex.toString());//common-icn-0181
                        ex.printStackTrace();//COMMON-ICN-0181
	}
	finally
		{
			if (rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
