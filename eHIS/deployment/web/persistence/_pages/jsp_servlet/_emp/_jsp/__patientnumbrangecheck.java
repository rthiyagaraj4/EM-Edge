package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __patientnumbrangecheck extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatientNumbRangeCheck.jsp", 1742365622459L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\t//parent.frames[1].document.forms[0].submit();\n\tvar errors= getMessage(\"INV_RANGE\",\"MP\")+ \"<br>\";\n\tparent.frames[3].location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + errors+\"&error_value=\"+1;\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script>\n\tparent.frames[1].document.forms[0].submit()\n\t</script> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\tvar errors= getMessage(\"PAT_ID_EXIST_IN_RANGE\",\"MP\")+ \"<br>\";\n\tparent.frames[3].location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + errors+\"&error_value=\"+1;\n</script>\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con =null;
	PreparedStatement pstmt=null ;
	PreparedStatement pstmt1=null ;
	ResultSet rs=null;
	ResultSet rs1=null;

try{
long rangeval = Long.parseLong(request.getParameter("rangeval"));
long maxrangeval = Long.parseLong(request.getParameter("maxrangeval"));
String pat_ser_grp_code = request.getParameter("pat_ser_grp_code");
String prefix_reqd_yn ="";
long str_num=0l;
long max_num =0l;
int flag=0;
int flag2=0;

	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("select prefix_reqd_yn,decode(pat_no_ctrl,'Z','S','U','F') sf from mp_pat_ser_grp where pat_ser_grp_code='"+pat_ser_grp_code +"'");
	
	rs=pstmt.executeQuery();

	if( rs != null )
	{
		while( rs.next() )
		{
			prefix_reqd_yn = rs.getString("prefix_reqd_yn")==null?"":rs.getString("prefix_reqd_yn");
			//sf = rs.getString("sf");
		}
	} if(pstmt != null) pstmt.close();
	//added on 29/03/04 to restrict the same range of values cannot be selected for any facility if the numbering control is facility based.
	 pstmt1 = con.prepareStatement("select MP_Pat_NumRange_Check('"+rangeval+"','"+maxrangeval+"','"+pat_ser_grp_code+"','"+prefix_reqd_yn+"') from dual");
	 if(rs!=null) rs.close();
	 rs= pstmt1.executeQuery();
	 
  while(rs.next())
	{
	   flag=rs.getInt(1);
	}     
	if(pstmt1 != null) pstmt1.close();



		if(flag==1)
		{
		
            _bw.write(_wl_block5Bytes, _wl_block5);

	    } 
    
	if (flag==0)
	{

if(prefix_reqd_yn.equals("N"))
{

	String min_max_value="select (min(a.START_SRL_NO)) START_SRL_NO ,(max(a.MAX_SRL_NO)) MAX_SRL_NO from MP_PAT_SER_FACILITY a, mp_pat_ser_grp b where a.PAT_SER_GRP_CODE=b.PAT_SER_GRP_CODE and  b.prefix_reqd_yn ='N'";

	pstmt = con.prepareStatement(min_max_value);
	rs1=pstmt.executeQuery();

	if(rs1 !=null && rs1.next())
	{
		str_num=rs1.getLong("START_SRL_NO");
		max_num=rs1.getLong("MAX_SRL_NO");
	} if(pstmt != null) pstmt.close();

if(((rangeval>=str_num )&& (rangeval<=max_num)) || ((maxrangeval >=str_num) && (maxrangeval<=max_num)) || (rangeval<=str_num ))
{
	flag2=1;
}else
{
	flag2=0;
}

}else
{
	flag2=0;
}

	if(flag2==0) {
            _bw.write(_wl_block6Bytes, _wl_block6);

	}else { 
            _bw.write(_wl_block7Bytes, _wl_block7);
}
	}
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (pstmt1 != null) pstmt1.close();
	if (rs != null) rs.close();
	if (rs1 !=null) rs1.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

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
