package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __newprocedure extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedure.jsp", 1709117180000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t <script>\n\t \t\talert(\'APP-CA0052 You cannot access this function beyond the limit specified in IP/OP parameter\');\n\t\t </script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<!-- <frameset rows=\"5%,95%\" framespacing=0 frameborder=\"0\">\n \t\t<frame name=\"procMainTab\" src= \"../../eOR/jsp/NewProcedureTabs.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\"></frame>\n\t\t<frameset rows=\"17.5%,79%,3.5%,0%,0%,0%\" framespacing=0 name=\"procDetailFrame\" frameborder=\"0\">\n\t\t\t<frame src=\"../../eOR/jsp/NewProcedureSearch.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name=\"proc_main_search\" scrolling=\'no\' noresize>\t\n\n\t\t\t<frame src=\"../../eOR/jsp/NewProcedureQueryResult.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"proc_main_result\" scrolling=\'auto\' frameborder=\"0\" noresize> \n\n\t\t\t<frame src= \"../../eOR/jsp/NewProcedureLegend.jsp\" framespacing=\"0\"noresize frameborder=\"0\"  name=\"proc_main_label\" scrolling=\"auto\">\n\t\t\t\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_desc\"  scrolling=\'auto\' frameborder=\"0\" noresize>\n\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_butn\"  scrolling=\'no\' frameborder=\"0\" noresize>\n\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_temp_frame\"  scrolling=\'no\' frameborder=\"0\" noresize>\n\t\t</frameset>\n\t</frameset> -->\n\t<!-- <frameset rows=\"5%,95%\" framespacing=0 frameborder=\"0\">\n \t\t<frame name=\"procMainTab\" src= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\"></frame>\n\t\t<frameset rows=\"17.5%,79%,3.5%,0%,0%,0%\" framespacing=0 name=\"procDetailFrame\" frameborder=\"0\">\n\t\t\t<frame src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"proc_main_search\" scrolling=\'no\' noresize>\t\n\n\t\t\t<frame src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" name=\"proc_main_result\" scrolling=\'auto\' frameborder=\"0\" noresize> \n\n\t\t\t<frame src= \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" framespacing=\"0\"noresize frameborder=\"0\"  name=\"proc_main_label\" scrolling=\"auto\">\n\t\t\t\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_desc\"  scrolling=\'auto\' frameborder=\"0\" noresize>\n\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_butn\"  scrolling=\'no\' frameborder=\"0\" noresize>\n\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_temp_frame\"  scrolling=\'no\' frameborder=\"0\" noresize>\n\t\t</frameset>\n\t</frameset> -->\n\t<frameset rows=\"5%,95%\" framespacing=0 frameborder=\"0\">\n \t\t<frame name=\"procMainTab\" src= \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\"></frame>\n\t\t<frameset rows=\"17.5%,79%,3.5%,0%,0%,0%\" framespacing=0 name=\"procDetailFrame\" frameborder=\"0\">\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_search\" scrolling=\'no\' noresize>\t\n\n\t\t\t<!-- <frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_result\" scrolling=\'auto\' frameborder=\"0\" noresize>  -->\n\n\t\t\t<frameset cols=\"100%,0%\" framespacing=0 name=\"procTermFrame\" frameborder=\"0\">\n\t\t\t\t<frame src= \"../../eCommon/html/blank.html\" framespacing=\"0\"noresize frameborder=\"0\"  name=\"proc_main_result\" scrolling=\"auto\" noresize>\n\t\t\t\t\n\t\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_term_info\"  scrolling=\'no\' frameborder=\"0\" noresize>\n\t\t\t</frameset>\n\n\t\t\t<frameset cols=\"100%,0%\" framespacing=0 name=\"procPractFrame\" frameborder=\"0\">\n\t\t\t\t<frame src= \"../../eCommon/html/blank.html\" framespacing=\"0\"noresize frameborder=\"0\"  name=\"proc_main_label\" scrolling=\"auto\" noresize>\n\t\t\t\t\n\t\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_desc\"  scrolling=\'no\' frameborder=\"0\" noresize>\n\t\t\t</frameset>\n\t\t\t<!-- <frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_desc\"  scrolling=\'auto\' frameborder=\"0\" noresize> -->\n\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_main_butn\"  scrolling=\'no\' frameborder=\"0\" noresize>\n\n\t\t\t<frame src=\"../../eCommon/html/blank.html\" name=\"proc_temp_frame\"  scrolling=\'no\' frameborder=\"0\" noresize>\n\t\t</frameset>\n\t</frameset>\n</form>\n</html>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String title = request.getParameter("title");
if (title == null) title = "";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf((title.equals("")) ? "ttNew Procedure":(title)));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection con				= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	boolean func_appl_yn		= true;

	String past_visit="", tabFrameSrc = "",detfisrtFrameSrc="",detsecondFrameSrc="",detthirdFrameSrc="";
	String facility_id = (String) session.getValue("facility_id");
	String P_pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String P_patient_id = request.getParameter("patient_id");
	String P_encounter_id = request.getParameter("episode_id");
	String P_clinic_code = request.getParameter("location_code");
	//String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	//String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String query_string = request.getQueryString() == null? "" :request.getQueryString();
	//query_string = query_string + "&Encounter_Id="+P_encounter_id+"&Clinic_Code="+P_clinic_code+"&Patient_Id="+P_patient_id;
	query_string = query_string +"&Clinic_Code="+P_clinic_code;
	//String rows="";
	try
	{
		con	=	ConnectionManager.getConnection(request);
  	    pstmt = con.prepareStatement("select ca_get_func_appl_past_visit(?,?,?,?,?) from dual");
		pstmt.setString(1,facility_id);		// facid
        pstmt.setString(2,"PROCEDURE");		// p_function
        pstmt.setString(3,P_encounter_id);  // p_episode_id
        pstmt.setString(4,P_pat_class);     // p_episode_type
        pstmt.setString(5,P_patient_id);

		rs = pstmt.executeQuery();
        while(rs!=null && rs.next())
        {
          past_visit = rs.getString(1);
        }
		
        if(rs!=null) rs.close();
        if(pstmt!=null) pstmt.close();

       if(past_visit!=null && past_visit.equalsIgnoreCase("FALSE"))
       {
         func_appl_yn = false;
		 
            _bw.write(_wl_block10Bytes, _wl_block10);

       }
		if(rs!=null) rs.close();
		if(pstmt != null)pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Execption in main try"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181		
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}

	
	if(func_appl_yn)
	{
		tabFrameSrc			=	"../../eOR/jsp/NewProcedureTabs.jsp?"+query_string+"";
	//	detfisrtFrameSrc	=	"../../eOR/jsp/NewProcedureSearch.jsp?"+query_string+"";
	//	detsecondFrameSrc	=	"../../eOR/jsp/NewProcedureQueryResult.jsp?"+query_string+"";
	//	detthirdFrameSrc	=	"../../eOR/jsp/NewProcedureLegend.jsp"+query_string+"";
		
	}
	else
	{
		
		tabFrameSrc			=	"../../eCommon/html/blank.html";
		//detfisrtFrameSrc	=	"../../eCommon/html/blank.html";
		//detsecondFrameSrc	=	"../../eCommon/html/blank.html";
		//detthirdFrameSrc	=	"../../eCommon/html/blank.html";
		
	}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tabFrameSrc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(detfisrtFrameSrc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(detsecondFrameSrc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(detthirdFrameSrc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tabFrameSrc));
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
