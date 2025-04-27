package jsp_servlet._eca._jsp;

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

public final class __locationforpractquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/LocationForPractQueryCriteria.jsp", 1709115924153L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n<script language=javascript src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=javascript>\nfunction callfunction(){\n\tvar target=parent.frames[1].frames[0].document.forms[0].pctr;\n\tvar practval= parent.frames[1].frames[0].document.forms[0].pctr.value;\n\tvar speciality= parent.frames[1].frames[0].document.forms[0].spl.value;\n\tvar p_facility_id=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight= \"10\" ;\n\tvar dialogWidth= \"40\" ;\n\tvar features= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t= \"\" ;\n\tvar search_desc\t= \"\";\n\tvar sql=\"\";\n\tvar title=getLabel(\"Common.practitioner.label\",\"COMMON\");\n\n\tif(parent.frames[1].frames[0].document.forms[0].spl.value!=\"\"){\n\t\tsql =\"select b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id= a.func_role_id and b.operating_facility_id =\'\"+p_facility_id+\"\' and b.primary_speciality_code=\'\"+speciality+\"\' and upper(b.practitioner_name) like upper(?) and b.practitioner_id like ? \";\n\t}\n\tif(!(parent.frames[1].frames[0].document.forms[0].spl.value))\n\t\t{\n\t\t  sql =\"select b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id= a.func_role_id and b.operating_facility_id =\'\"+p_facility_id+\"\' and upper(b.practitioner_name) like upper(?) and b.practitioner_id like ? \";  \n\t\t}\n\t\t\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array();\n\tvar datatypesArray = new Array();\n\targArray[0] = sql;\n\targArray[1] = namesArray;\n\targArray[2] = valuesArray;\n\targArray[3] = datatypesArray;\n\targArray[4] = \"1,2\";\n\targArray[5] = target.value;\n\targArray[6] = DESC_LINK;\n\targArray[7] = DESC_CODE;\n\nif(parent.frames[1].frames[0].document.forms[0].pctr.value !=\"\"){\n\t\tvar retArray = CommonLookup(title,argArray);\n\t\tif(retArray != null && retArray !=\"\"){\n\t\t\tparent.frames[1].frames[0].document.forms[0].pctr.value = retArray[1];\n\t\t\tparent.frames[1].frames[0].document.forms[0].practitioner_id.value=retArray[0];\n\t\t\tparent.frames[1].frames[0].document.forms[0].searchpctr.disabled=false;\n\t\t\tPopulateName(retArray[0]);\n\t\t}\n\t\telse\n\t\t{\n               parent.frames[1].frames[0].document.forms[0].pctr.value=\"\";\n\t\t\t   parent.frames[1].frames[0].document.forms[0].practitioner_id.value=\"\";\n\t\t\t   parent.frames[1].frames[0].document.forms[0].searchpctr.disabled=false;\n\t\t\t   parent.frames[1].frames[1].location.href=\"../../eCA/jsp/LocationForPractList.jsp\";\n\t\t}\n\t}\n\t\nparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\';\n\n}// callfunction\nfunction PopulateName(obj)\n{\n\tvar speciality = parent.frames[1].frames[0].document.forms[0].spl.value;\nvar practitioner_id=obj;\n\n\nparent.frames[1].frames[1].location.href=\"../../eCA/jsp/LocationForPractList.jsp?practitioner_id=\"+practitioner_id.toUpperCase()+\"&speciality_id=\"+speciality;\n\nparent.frames[1].frames[2].location.href=\"../../eCA/jsp/LocationForPractDetail.jsp?practitioner_id=\"+practitioner_id.toUpperCase()+\"&speciality_id=\"+speciality;\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script>\nvar speciality = parent.frames[1].frames[0].document.forms[0].spl.value;\nvar practitioner_id=parent.frames[1].frames[0].document.forms[0].practitioner_id.value;\nparent.frames[1].frames[1].location.href=\"../../eCA/jsp/LocationForPractList.jsp?practitioner_id=\"+practitioner_id.toUpperCase()+\"&speciality_id=\"+speciality;\nparent.frames[1].frames[2].location.href=\"../../eCA/jsp/LocationForPractDetail.jsp?practitioner_id=\"+practitioner_id.toUpperCase()+\"&speciality_id=\"+speciality;\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\tparent.frames[1].frames[0].document.forms[0].searchpctr.disabled=true;\n\t\t\tcallfunction();\n\t\t</script>\n        ";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
String facility_id ="";
facility_id = (String)session.getValue("facility_id");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block6Bytes, _wl_block6);

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String pract=request.getParameter("pract")==null?"":request.getParameter("pract");	
		String practId="";
		String practDesc="";
		
		int count=0;
		try
		{
				con=ConnectionManager.getConnection(request);
					if (!pract.equals("")){
						pract=pract+"%";
						}
        String sql="select  PRACTITIONER_ID,PRACTITIONER_NAME from AM_PRACTITIONER where EFF_STATUS ='E'  AND upper(PRACTITIONER_NAME) like upper(?)";  
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,pract);
					rset=pstmt.executeQuery();
					while(rset.next())
					{	
					   
					  practId=""; practId=rset.getString("PRACTITIONER_ID");
                       practDesc="";
                       practDesc=rset.getString("PRACTITIONER_NAME");
					   count=count+1;
					}
				 
        if (count==1)
			{
				out.println("<script>");
			    
				out.println("parent.frames[1].Header.document.forms[0].pctr.value='"+practDesc+"'");
				out.println("parent.frames[1].Header.document.forms[0].practitioner_id.value='"+practId+"'");
				
				out.println("parent.frames[1].frames[2].document.forms[0].practitioner_id.value='"+practId+"'");
				out.println("</script>");
				
            _bw.write(_wl_block7Bytes, _wl_block7);

out.println("<script>");   
out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
out.println("</script>");
	}
		if(count > 1 || count ==0){
	
	out.println("<script>");
	out.println("parent.frames[1].frames[2].document.forms[0].practitioner_id.value='"+practId+"'");
	out.println("</script>");
			
            _bw.write(_wl_block8Bytes, _wl_block8);
 
			
     	}//if
			if (rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception ex)
			{
				//out.println("Exception="+ex.getMessage());//COMMON-ICN-0181
				ex.printStackTrace();//COMMON-ICN-0181
			}
		finally{
					
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
