package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eCommon.Common.*;
import java.net.URLEncoder;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesforwardpractresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesForwardPractResult.jsp", 1709116134467L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n    <head>\n        <title></title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n        <script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>       \n        <script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n    \n</head>\n<body onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t</td></tr>\n\t\t\t\t</table>\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\"ResultTab\">\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\t  \n\t\t\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\n\t\t\t\t\t\t<td class=\"gridData\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t<td class=\"gridData\"><a href=\"#\" onclick=\"javaScript:returnPractitioner(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a></td>\t\t\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t</table>\t\t\t\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<script>\n\t\t\t\t\t\tif(!parent.lookup_head.chkBothCriteria )\n\t\t\t\t\t\t{\n\n\t\t\t\t\t\t\tif(parent.lookup_head.fromCalledPage)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.lookup_head.chkBothCriteria = true;\n\t\t\t\t\t\t\t\tparent.lookup_head.document. CriteriaForm .elements[1].click()\n\t\t\t\t\t\t\t\tparent.lookup_head.document. CriteriaForm .Search.click()\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\n\t\t\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\t\t}            \t                             \n\t\t\t   </script>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\tfirstCodeVal = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ;\n\t\t\tfirstDescVal = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" ;\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="   \n<script>\n\tparent.lookup_head.document.CriteriaForm.Search.disabled=false;\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 String callFrom        = request.getParameter( "callFrom" )==null?"": request.getParameter( "callFrom" );
if( !callFrom.equals("0") ) {
            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    }
    eCA.RecClinicalNotesPractBean pracObj = new eCA.RecClinicalNotesPractBean();
    //Search Criteria's from Query Criteria page
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int maxRecord = 0;
	String sql = "",sqlCount="";
	
	String speciality_id = request.getParameter("speciality_id")==null?"":request.getParameter("speciality_id");
	String locale =		session.getAttribute("LOCALE")==null?"":(String)session.getAttribute("LOCALE");
	String facility_id =		session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String clinician_id = request.getParameter("clinician_id")==null?"":request.getParameter("clinician_id");
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String search_text = request.getParameter("search_text")==null?"":request.getParameter("search_text");
	String search_by = request.getParameter("search_by")==null?"D":request.getParameter("search_by");
	String search_criteria = request.getParameter("search_criteria")==null?"S":request.getParameter("search_criteria");
	String from = request.getParameter("from")==null?"1":request.getParameter("from");
	String to = request.getParameter("to")==null?"14":request.getParameter("to");
	
	int start = Integer.parseInt(from) ;
    int end = Integer.parseInt(to) ;    
/*	HashMap<String,String> sqlMap = new HashMap<String,String>();
	sqlMap.put("SPECIALITY_ID",speciality_id);
	sqlMap.put("LOCALE",locale);
	sqlMap.put("FACILITY_ID",facility_id);
	sqlMap.put("CLINICIAN_ID",clinician_id);
	sqlMap.put("NOTE_TYPE",note_type);
	sqlMap.put("SEARCH_TEXT",search_text);
	sqlMap.put("SEARCH_BY",search_by);
	sqlMap.put("SEARCH_CRITERIA",search_criteria);
	sqlMap.put("FROM",from);
	sqlMap.put("TO",to);	*/
	
	String code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	String desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
      
  //  boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;	
try{
	ArrayList result = (ArrayList) pracObj.getPractitionerResultPage(request);	
	if (result != null){
		maxRecord = result.get(0)==null?0:Integer.parseInt((String)result.get(0));		
		if(!callFrom.equals("0")){
		if(result.size() > 1 && maxRecord > 0 ) {			
			
            _bw.write(_wl_block8Bytes, _wl_block8);

				if (start != 1)
					out.println("<A class='gridLink'  href='../../eCA/jsp/RecClinicalNotesForwardPractResult.jsp?from="+(start-14)+"&to="+(end-14)+"&"+request.getQueryString()+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

				if (maxRecord > 14 )
					out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/RecClinicalNotesForwardPractResult.jsp?from="+(start+14)+"&to="+(end+14)+"&"+request.getQueryString()+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

				//Retriving the records from result arraylist
				ArrayList records=new ArrayList();
				for(int recCount=1; recCount<result.size(); recCount++) {				
			
            _bw.write(_wl_block12Bytes, _wl_block12);

					records=(ArrayList) result.get( recCount );
					//String retval="";
					//for(int colCount=0; colCount<records.size(); colCount++){												
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(records.get(0)==null?"":records.get(0)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(records.get(0)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(records.get(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(records.get(1)==null?"":records.get(1)));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
			
            _bw.write(_wl_block19Bytes, _wl_block19);

			}     
		}else if(maxRecord == 1){
			java.util.ArrayList records = (java.util.ArrayList) result.get( 1 ); 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(((String)records.get(0)).trim()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(((String)records.get(1)).trim()));
            _bw.write(_wl_block22Bytes, _wl_block22);
		}  
   }else{
            _bw.write(_wl_block23Bytes, _wl_block23);
   }

} catch(Exception e) {
    //out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
if( !callFrom.equals("0") ) {

            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
