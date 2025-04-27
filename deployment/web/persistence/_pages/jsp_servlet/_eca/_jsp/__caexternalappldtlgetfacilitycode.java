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
import java.util.*;
import com.ehis.util.*;

public final class __caexternalappldtlgetfacilitycode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAExternalApplDtlGetFacilityCode.jsp", 1720070480947L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script language=javascript>\n\t\nasync function callfunction(){\n\t\t\t\n\t\t\tvar target=parent.frames[1].document.forms[0].facility_id1;\n\t\t\tvar retVal=  new String();\n\t\t\tvar dialogTop\t= \"40\";\n\t\t\tvar dialogHeight= \"10\" ;\n\t\t\tvar dialogWidth= \"40\" ;\n\t\t\tvar features= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar search_desc\t= \"\";\n\t\t\t//var title=\"Facility\";\n\t\t\tvar title= getLabel(\"Common.facility.label\",\"Common\");\n\t\t\tvar sql=\"select facility_id code,facility_name description from sm_facility_param where  status=\'E\' and upper(facility_name) like upper(?) and upper(facility_id) like upper(?)  \";\n\t\t\tvar argArray = new Array();\n\t\t\tvar namesArray = new Array();\n\t\t\tvar valuesArray = new Array();\n\t\t\tvar datatypesArray = new Array();\n\t\t\targArray[0] = sql;\n\t\t\targArray[1] = namesArray;\n\t\t\targArray[2] = valuesArray;\n\t\t\targArray[3] = datatypesArray;\n\t\t\targArray[4] = \"2,1\";\n\t\t\targArray[5] = target.value; \n\t\t\targArray[6] = DESC_LINK;\n\t\t\targArray[7] = DESC_CODE;\n\t\t\t\n\t\t\tif(parent.frames[1].document.forms[0].facility_id1.value!=\"ALL\" && parent.frames[1].document.forms[0].facility_id.value!=\"\"){\n\t\t\t\t\n\t\t\t\tretArray =await  CommonLookup(title,argArray);\n\t\t\t\t\n\t\t\t\tvar ret1=unescape(retArray);\n\t\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t{\n\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t}\n\t\t\t\tif(retArray != null && retArray !=\"\"){\n\t\t\t\t\t\tparent.frames[1].document.forms[0].facility_id1.value = arr[1];\n\t\t\t\t\t\tparent.frames[1].document.forms[0].facility_id.value=arr[0];\n\t\t\t\t\t\tparent.frames[1].document.forms[0].facility_buttn.disabled=false;\n\t\t\t\t\t}else {\n\t\t\t\t\t\tparent.frames[1].document.forms[0].facility_id1.value=\"All\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].facility_id.value=\"*A\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].facility_buttn.disabled=false;\n\t\t\t}\n\t\t}\n\t\t\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\';\n}\n\n\n</script>\n</head>\n<body onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<script language=javascript>\n\t\t\t\tparent.frames[1].document.forms[0].facility_buttn.disabled=true;\n\t\t\t\tcallfunction();\n\t\t\t\t</script>\n<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\n\n\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String search_value=request.getParameter("search_value")==null?"":request.getParameter("search_value");	
	
		 String facility_id = "";
		 String facility_name = "";
		 String sql = "";
		 int count=0;
		
		try
		{
			con=ConnectionManager.getConnection();
			if (!search_value.equals("")){
					search_value=search_value+"%";
				}
				
				sql = "select facility_id ,facility_name from sm_facility_param where  status='E' and upper(facility_name) like upper(?) ";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,search_value);
				rset=pstmt.executeQuery();

				while(rset.next())
				{	
					   facility_id=rset.getString("facility_id");
                       facility_name=rset.getString("facility_name");
					   count=count+1;
				}
		if (count==1)
		{ 
			out.println("<script>");
			out.println("parent.frames[1].document.forms[0].facility_id1.value='"+facility_name+"'");
			out.println("parent.frames[1].document.forms[0].facility_id.value='"+facility_id+"'");
			out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
			out.println("</script>");
		}

		if(count>1 || count==0){	
            _bw.write(_wl_block6Bytes, _wl_block6);
 
		}
}
catch(Exception ex){
		//out.println("Exception in try of CAExternalApplDtlGetFacilityCode.jsp"+ex.toString());//COMMON-ICN-0181
				ex.printStackTrace();//COMMON-ICN-0181
}
finally{
		if (rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if (con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
