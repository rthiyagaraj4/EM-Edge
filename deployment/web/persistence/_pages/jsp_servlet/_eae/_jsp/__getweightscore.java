package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __getweightscore extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/GetWeightScore.jsp", 1709113875990L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\t<html><HEAD>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</HEAD><body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'><form name=\'testform\' id=\'testform\'>;\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<script>\n\tfunction getVal()\n\t{\n\t\tvar gcs_weight1\t=\tparent.frames[3].document.forms[0].gcs_weight1.value;\n\t\tvar gcs_weight2\t=\tparent.frames[3].document.forms[0].gcs_weight2.value;\n\t\tvar gcs_weight3\t=\tparent.frames[3].document.forms[0].gcs_weight3.value;\n\n\t\tif(gcs_weight1==\"\")gcs_weight1=\"0\";\n\t\tif(gcs_weight2==\"\")gcs_weight2=\"0\";\n\t\tif(gcs_weight3==\"\")gcs_weight3=\"0\";\n\n\t\tvar gcs_score\t=\tparseFloat(gcs_weight1)+parseFloat(gcs_weight2)+parseFloat(gcs_weight3);\n\t\tparent.frames[3].document.forms[0].gcs_score.value=gcs_score;\n\t\t\tvar calc_gcs_score = parseFloat(gcs_score);\n\t\t\tif(calc_gcs_score <=3)\n\t\t\t\tparent.frames[3].document.forms[0].priority.options[1].selected=true;\n\t\t\telse if(calc_gcs_score==4 || calc_gcs_score==5 )\n\t\t\t\tparent.frames[3].document.forms[0].priority.options[2].selected=true;\n\t\t\telse if(calc_gcs_score==6 || calc_gcs_score==7 || calc_gcs_score==8 )\n\t\t\t\tparent.frames[3].document.forms[0].priority.options[3].selected=true;\n\t\t\telse if(calc_gcs_score==9 || calc_gcs_score==10 || calc_gcs_score==11 || calc_gcs_score==12)\n\t\t\t{\n\t\t\t\tparent.frames[3].document.forms[0].priority.options[4].selected=true;\n\t\t\t}\n\t\t\telse if(calc_gcs_score>12)\n\t\t\t{\n\t\t\t\tparent.frames[3].document.forms[0].priority.options[5].selected=true;\n\t\t\t}\n\t\t\telse if(calc_gcs_score ==0)\n\t\t\t{\n\t\t\t\tparent.frames[3].document.forms[0].priority.options[0].selected=true;\n\t\t\t}\n\t}\n\t</script>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\tvar score_val=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'\n\t\t\tparent.frames[3].document.forms[0].gcs_weight1.value=score_val;\n\t\t\tgetVal();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\t\t\tparent.frames[3].document.forms[0].gcs_weight2.value=score_val;\n\t\t\tgetVal();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\t\t\tparent.frames[3].document.forms[0].gcs_weight3.value=score_val;\n\t\t\tgetVal();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n</form>\n</body>\n</html>\n\n";
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
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement stmt1=null;
	ResultSet rset1=null;
try
{
	con						=	ConnectionManager.getConnection(request);
	String gcs_code			=	request.getParameter("gcs_code");
	String Response_code	=	request.getParameter("Response_code");
	String gcs_score		=	request.getParameter("gcs_score")==null?"":request.getParameter("gcs_score");
	if(gcs_score.equals(""))	gcs_score	=	"0";

	String gcs_weight1 = "";
	String gcs_weight2 = "";
	String gcs_weight3 = "";

	

	
            _bw.write(_wl_block4Bytes, _wl_block4);

	if(Response_code.equals("ER"))	
	{
		stmt1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset1=stmt1.executeQuery("select *  from ae_gcs_score ");
		if (gcs_code.equals("E1"))
		{	
			while (rset1.next())
			{
				gcs_weight1=rset1.getString("ER_GCS_CODE1_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("E2"))
		{
			while (rset1.next())
			{
				gcs_weight1=rset1.getString("ER_GCS_CODE2_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("E3"))
		{
			while (rset1.next())
			{
				gcs_weight1=rset1.getString("ER_GCS_CODE3_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("E4"))
		{
			while (rset1.next())
			{
				gcs_weight1=rset1.getString("ER_GCS_CODE4_SCORE");
			}
		}
		if(rset1!=null) rset1.close();
		if(stmt1!=null) stmt1.close();
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(gcs_weight1));
            _bw.write(_wl_block6Bytes, _wl_block6);

	}
	else if(Response_code.equals("VR"))	
	{
		stmt1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset1=stmt1.executeQuery("select *  from ae_gcs_score ");
		if (gcs_code.equals("V1"))
		{	
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE1_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("V2"))
		{
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE2_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("V3"))
		{
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE3_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("V4"))
		{
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE4_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("V5"))
		{
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE5_SCORE");
			}
		}
		if(rset1!=null) rset1.close();
		if(stmt1!=null) stmt1.close();

		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(gcs_weight2));
            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	else if(Response_code.equals("MR"))	
	{
		stmt1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset1=stmt1.executeQuery("select *  from ae_gcs_score ");
		if (gcs_code.equals("M1"))
		{	
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE1_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M2"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE2_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M3"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE3_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M4"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE4_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M5"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE5_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M6"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE6_SCORE");
			}
		}
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(gcs_weight3));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
}
catch( Exception e ){e.printStackTrace();}
finally
{
	if(rset1 != null)rset1.close();
	if(stmt1 != null)stmt1.close();
	ConnectionManager.returnConnection(con,request);

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
