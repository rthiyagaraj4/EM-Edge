package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __discrmsrcompstandardrefsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DiscrMsrCompStandardRefSearch.jsp", 1709113997382L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<script language=javascript src=\'../js/CAMessages.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=javascript>\nfunction callfunction(){\nvar target=parent.frames[1].document.forms[0].std_ref;\nvar splval= parent.frames[1].document.forms[0].std_ref.value;\nvar resulttype= parent.frames[1].document.forms[0].comp_type.value;\n\nvar retVal=  new String();\nvar dialogTop\t= \"40\";\nvar dialogHeight= \"10\" ;\nvar dialogWidth= \"40\" ;\nvar features= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\nvar arguments\t= \"\" ;\nvar search_desc\t= \"\";\nvar title=\"StandardComp\";\n\n\n\nvar sql=\"SELECT STD_COMP_ID code,STD_COMP_DESC description FROM AM_STANDARD_COMP where eff_status=\'E\' and upper(STD_COMP_DESC) like upper(?) and upper(STD_COMP_ID) like upper(?) and STD_COMP_RESULT_TYPE = \'\"+resulttype+\"\' \";\n\nvar argArray = new Array();\nvar namesArray = new Array();\nvar valuesArray = new Array();\nvar datatypesArray = new Array();\nargArray[0] = sql;\nargArray[1] = namesArray;\nargArray[2] = valuesArray;\nargArray[3] = datatypesArray;\nargArray[4] = \"2,1\";\nargArray[5] = target.value;\nargArray[6] = DESC_LINK;\nargArray[7] = DESC_CODE;\n\nif(parent.frames[1].document.forms[0].std_ref.value!=\"\" ){\nretArray = CommonLookup(title,argArray);\nif(retArray != null && retArray !=\"\"){\nparent.frames[1].document.forms[0].std_ref.value = retArray[1];\n//parent.frames[1].document.forms[0].desc.value=retArray[1];\n//parent.frames[1].document.forms[0].id.disabled=false;\n}//if\nelse\n{\n\tparent.frames[1].document.forms[0].std_ref.value= \"\";\n//\tparent.frames[3].document.forms[0].desc.value=\"\";\n//\tparent.frames[3].document.forms[0].id.disabled=false;\n\n}\n}//if\nparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\';\n}\n//callfunction\n</script>\n</head>\n<body  class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script language=javascript>\n\t\t\t//parent.frames[3].document.forms[0].id.disabled=true;\n\t\t\tcallfunction();\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n        ";
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

		Connection con2=null;
		request.setCharacterEncoding("UTF-8");
		String stdref=request.getParameter("stdref")==null?"":request.getParameter("stdref");
		String restype=request.getParameter("restype")==null?"":request.getParameter("restype");
		
		String stdcompDesc="";
		int count=0;
		try
		{
				
				PreparedStatement pstmt2=null;
				ResultSet rset2=null;
				con2=ConnectionManager.getConnection(request);
        if (!stdref.equals("")){
						stdref=stdref+"%";
						}
			StringBuffer sql= new StringBuffer();

			sql.append("SELECT STD_COMP_ID,STD_COMP_DESC FROM  AM_STANDARD_COMP ");
			sql.append("WHERE EFF_STATUS ='E' AND "); 
            sql.append("STD_COMP_ID like UPPER(?) AND STD_COMP_RESULT_TYPE = ?");  
			

			pstmt2=con2.prepareStatement(sql.toString());
         	
            pstmt2.setString(1,stdref);
			pstmt2.setString(2,restype);
			
			
			rset2=pstmt2.executeQuery();
			
					while(rset2.next())
					{	
						
						
							//stdcompId=rset2.getString("STD_COMP_ID");
							stdcompDesc=rset2.getString("STD_COMP_DESC");
							count=count+1;
					}   
      

  if (count==1)
		{
		    out.println("<script>");
			out.println("parent.frames[1].document.forms[0].std_ref.value='"+stdcompDesc+"'");
			//out.println("parent.frames[1].document.forms[0].flagSpecialty.value='true' ");
			out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
        	out.println("</script>");
		 } 
    if(count>1 || count==0)
		{
			
            _bw.write(_wl_block6Bytes, _wl_block6);
 

		}//if 
	if (rset2!=null) rset2.close();
	if(pstmt2!=null) pstmt2.close();
	}
	catch(Exception ex)
	{
				out.println("Exception in DiscreteStandardCompSearch.jsp"+ex.toString());
	}
	finally
	{
		if (con2!=null) ConnectionManager.returnConnection(con2,request);
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
