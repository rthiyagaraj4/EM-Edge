package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.PageContext;
import javax.servlet.ServletContext;
import java.sql.*;
import webbeans.eCommon.*;
import java.awt.Image;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.*;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.urls.*;
import org.jfree.data.*;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.CustomXYToolTipGenerator;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import javax.swing.JPanel;
import org.jfree.chart.title.LegendTitle;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.time.*;
import org.jfree.chart.axis.DateAxis;
import java.text.DecimalFormat;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.block.*;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.ui.*;
import java.util.*;
import com.ehis.util.*;

public final class __periobuccalgraph extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioBuccalGraph.jsp", 1709119353676L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/PerioBuccalGraph.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t\t\n\t\t<div id=\'BucNumber1\' name=\'bucNumber1\' style=\"display:None;position:absolute;left:10;top:00;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/vertical Numbering_new.png\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'PDGraph\' name=\'PDGraph\' style=\"display:None;position:absolute;left:350;top:240;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/legend3.png\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'CALGraph\' name=\'CALGraph\' style=\"display:None;position:absolute;left:320;top:240;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/legend2.png\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'CEJGraph\' name=\'CEJGraph\' style=\"display:None;position:absolute;left:328;top:240;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/legend1.png\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\n\t\t<div id=\'BucNumber2\' name=\'BucNumber2\' style=\"display:None;position:absolute;left:838;top:00;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/vertical Numbering_new.png\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\n\n\t\t<div id=\'fdilin\' name=\'fdilin\' style=\"display:None;position:absolute;left:64;top:220;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Numbering2_New.png\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\n\t\t<div id=\'fdibuc\' name=\'fdibuc\' style=\"display:None;position:absolute;left:64;top:220;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Numbering1_1.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'unibuc\' name=\'unibuc\' style=\"display:None;position:absolute;left:64;top:220;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Numbering3_1.png\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t\n\t\t<div id=\'unilin\' name=\'unilin\' style=\"display:None;position:absolute;left:64;top:220;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Numbering4_1.png\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\n \t \t<div id=\'img1\' name=\'1\' style=\"display:none;position:absolute;left:62;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img2\' name=\'2\' style=\"display:none;position:absolute;left:104;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t \t<div id=\'img3\' name=\'3\' style=\"display:none;position:absolute;left:150;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img4\' name=\'4\' style=\"display:none;position:absolute;left:198;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img5\' name=\'5\' style=\"display:none;position:absolute;left:245;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n \t\t<div id=\'img6\' name=\'6\' style=\"display:None;position:absolute;left:286;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img7\' name=\'7\' style=\"display:none;position:absolute;left:330;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img8\' name=\'8\' style=\"display:none;position:absolute;left:375;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img9\' name=\'9\' style=\"display:none;position:absolute;left:419;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img10\' name=\'10\' style=\"display:none;position:absolute;left:462;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img11\' name=\'11\' style=\"display:none;position:absolute;left:508;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img12\' name=\'12\' style=\"display:none;position:absolute;left:552;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img13\' name=\'13\' style=\"display:none;position:absolute;left:593;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img14\' name=\'14\' style=\"display:none;position:absolute;left:641;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img15\' name=\'15\' style=\"display:None;position:absolute;left:688;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img16\' name=\'16\' style=\"display:None;position:absolute;left:735;top:20;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>   \n\n\n \t \t<div id=\'img32\' name=\'32\' style=\"display:none;position:absolute;left:64;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img31\' name=\'31\' style=\"display:none;position:absolute;left:106;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t \t<div id=\'img30\' name=\'30\' style=\"display:none;position:absolute;left:150;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img29\' name=\'29\' style=\"display:none;position:absolute;left:200;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img28\' name=\'28\' style=\"display:none;position:absolute;left:240;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n \t\t<div id=\'img27\' name=\'27\' style=\"display:none;position:absolute;left:285;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img26\' name=\'26\' style=\"display:none;position:absolute;left:330;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img25\' name=\'25\' style=\"display:none;position:absolute;left:375;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img24\' name=\'24\' style=\"display:none;position:absolute;left:422;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img23\' name=\'23\' style=\"display:none;position:absolute;left:465;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img22\' name=\'22\' style=\"display:none;position:absolute;left:510;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img21\' name=\'21\' style=\"display:none;position:absolute;left:555;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img20\' name=\'20\' style=\"display:none;position:absolute;left:600;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img19\' name=\'19\' style=\"display:none;position:absolute;left:645;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img18\' name=\'18\' style=\"display:none;position:absolute;left:695;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img17\' name=\'17\' style=\"display:none;position:absolute;left:740;top:47;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>   \n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!-- onload=\'loadBucNumsystem();checkMissingTooth();\' -->\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\'loadBucNumsystem();checkMissingTooth();\'>\n\t\t<form >\n\t\t\t<table>\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\t\t\t\t\t\t\n\t\t\t\t\t\t<center><img  src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" border=0 usemap=\"#";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/></center> \n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellspacing=\"\" cellpadding=\"\">\n\t\t\t\t<!-- <tr>\n\t\t\t\t\t<td width=\'7%\' >&nbsp;</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<center ><font size=1>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></center> \n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'6%\' >&nbsp;</td>\n\t\t\t\t</tr>\t -->\n\t\t\t\t\n\t\t\t</table>\n\t<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type = \"hidden\" name= \"perio_arch\" value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type = \"hidden\" name= \"chart_code1\" value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type = \"hidden\" name= \"chart_num\" value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type = \"hidden\" name= \"chart_line_num\" value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type = \"hidden\" name= \"tns\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type = \"hidden\" name= \"sel_radio_val\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

		request.setCharacterEncoding("UTF-8");
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	//Declarations

	int chartWidth = 861;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String graphURL = "";
	String filename = "";
	String sql="";
	String sql1="";
	String tooth_no="";
	String component_code="";
	String s1_Val="";
	String s2_Val="";
	String s3_Val="";
	String s4_Val="0";
	String tooth_num="";
	String tooth_arr="";
	String X_Axis="";

	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String perio_arch=checkForNull(request.getParameter("perio_arch"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	String pd_val=checkForNull(request.getParameter("pd_val"));
	String cal_val=checkForNull(request.getParameter("cal_val"));
	String cej_val=checkForNull(request.getParameter("cej_val"));
	String components=checkForNull(request.getParameter("components"));
	String load_flag=checkForNull(request.getParameter("load_flag"));
	String sel_radio_val=checkForNull(request.getParameter("sel_radio_val"));
	if(components.equals("") && sel_radio_val.equals("PD")){
		components="'PD','CAL'";
	}

	String qry_str2 =("2".equals(load_flag))?"AND Y.COMPONENT_CODE IN ("+components+")":"AND Y.COMPONENT_CODE IN ('PD','CAL')";
	String X_Axis_uni_upper="";
	String X_Axis_uni_lower="";
	String X_Axis_Lower="";
	String X_Axis_Upper="";
	String img_src="";
	if(tooth_numbering_system.equals("UNI")){
		if(perio_arch.equals("U")){
			X_Axis=X_Axis_uni_upper;
			//img_src="/eOH/images/R&D_upper_1.png";
			img_src="/eOH/images/DC1.png";

		}else{
			X_Axis=X_Axis_uni_lower;
			//img_src="/eOH/images/DetalChartFour_NEW_6.PNG";
			img_src="/eOH/images/DC4.png";
		}
	}else if(tooth_numbering_system.equals("FDI")){
		if(perio_arch.equals("U")){
			X_Axis=X_Axis_Upper;
			//img_src="/eOH/images/R&D_upper_1.png";
			img_src="/eOH/images/DC1.png";
		}else{
			X_Axis=X_Axis_Lower;
			img_src="/eOH/images/DC4.png";
		}
	}
	
	try{
	
		con=ConnectionManager.getConnection(request);
		sql1="SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND A.ARCH_SNO = (?)";
		pstmt=con.prepareStatement(sql1);
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,permanent_deciduous_flag);
		pstmt.setString(3,perio_arch);
		rs=pstmt.executeQuery();
		while(rs.next()){
				tooth_num=rs.getString(1);
				tooth_arr=tooth_arr+tooth_num+"    ";
		}

		//Data Set
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

		if(sel_radio_val.equals("PD")){
			if(perio_arch.equals("U")){
				sql="SELECT B.TOOTH_NO,B.COMPONENT_CODE,A.S1,A.S2,A.S3 FROM OH_PERIODONTAL_CHART_DTL A, (SELECT TOOTH_NO, COMPONENT_CODE FROM OH_TOOTH X, OH_PERIODONTAL_CHART_COMP Y WHERE X.PERMANENT_DECIDUOUS = 'P' AND X.ARCH_SNO = ? "+qry_str2+" ) B WHERE A.PATIENT_ID (+) =? AND A.CHART_NUM (+) = ? AND A.CHART_LINE_NUM (+) =?  AND A.CHART_CODE (+)= ? AND A.TOOTH_NO (+) = B.TOOTH_NO AND A.COMPONENT_CODE (+) = B.COMPONENT_CODE ORDER BY B.COMPONENT_CODE DESC, B.TOOTH_NO";
			}else if(perio_arch.equals("L")){
				sql="SELECT B.TOOTH_NO,B.COMPONENT_CODE,A.S1,A.S2,A.S3 FROM OH_PERIODONTAL_CHART_DTL A, (SELECT TOOTH_NO, COMPONENT_CODE FROM OH_TOOTH X, OH_PERIODONTAL_CHART_COMP Y WHERE X.PERMANENT_DECIDUOUS = 'P' AND X.ARCH_SNO = ? "+qry_str2+" ) B WHERE A.PATIENT_ID (+) =? AND A.CHART_NUM (+) = ? AND A.CHART_LINE_NUM (+) =?  AND A.CHART_CODE (+)= ? AND A.TOOTH_NO (+) = B.TOOTH_NO AND A.COMPONENT_CODE (+) = B.COMPONENT_CODE ORDER BY B.COMPONENT_CODE DESC, B.TOOTH_NO DESC";	
			} 
		}else{
			if(perio_arch.equals("U")){
				sql="SELECT B.TOOTH_NO,B.COMPONENT_CODE,A.S1,A.S2,A.S3 FROM OH_PERIODONTAL_CHART_DTL A, (SELECT TOOTH_NO, COMPONENT_CODE FROM OH_TOOTH X, OH_PERIODONTAL_CHART_COMP Y WHERE X.PERMANENT_DECIDUOUS = 'P' AND X.ARCH_SNO = ? "+qry_str2+" ) B WHERE A.PATIENT_ID (+) =? AND A.CHART_NUM (+) = ? AND A.CHART_LINE_NUM (+) =?  AND A.CHART_CODE (+)= ? AND A.TOOTH_NO (+) = B.TOOTH_NO AND A.COMPONENT_CODE (+) = B.COMPONENT_CODE ORDER BY B.COMPONENT_CODE, B.TOOTH_NO";
			}else if(perio_arch.equals("L")){
				sql="SELECT B.TOOTH_NO,B.COMPONENT_CODE,A.S1,A.S2,A.S3 FROM OH_PERIODONTAL_CHART_DTL A, (SELECT TOOTH_NO, COMPONENT_CODE FROM OH_TOOTH X, OH_PERIODONTAL_CHART_COMP Y WHERE X.PERMANENT_DECIDUOUS = 'P' AND X.ARCH_SNO = ? "+qry_str2+" ) B WHERE A.PATIENT_ID (+) =? AND A.CHART_NUM (+) = ? AND A.CHART_LINE_NUM (+) =?  AND A.CHART_CODE (+)= ? AND A.TOOTH_NO (+) = B.TOOTH_NO AND A.COMPONENT_CODE (+) = B.COMPONENT_CODE ORDER BY B.COMPONENT_CODE , B.TOOTH_NO DESC";
			}
		}
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,perio_arch);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,chart_num);
		pstmt.setString(4,chart_line_num);
		pstmt.setString(5,chart_code);
		rs=pstmt.executeQuery();
		int i=1;
		int j=1;
		int k=1;

		if(pd_val.equals("") && cal_val.equals("") && cej_val.equals("") ){
			while(rs.next()){
				tooth_no=rs.getString("TOOTH_NO");
				component_code=rs.getString("COMPONENT_CODE");
				if(component_code.equals("PD")){
					s1_Val=checkForNull(rs.getString("S1"),"0");
					s2_Val=checkForNull(rs.getString("S2"),"0");
					s3_Val=checkForNull(rs.getString("S3"),"0");
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
						//s1_Val=(String)s1;
						//s1_Val="-"+s1_Val;
						//s2_Val="-"+s2_Val;
						//s3_Val="-"+s3_Val;
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "PD", new Double(i+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "PD", new Double(i+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "PD", new Double(i+".14"));
					} 
					if (!s4_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s4_Val), "PD", new Double(j+".2"));
					}

					i++;
				}
				if(component_code.equals("CAL")){
					
					s1_Val=checkForNull(rs.getString("S1"),"0");
					s2_Val=checkForNull(rs.getString("S2"),"0");
					s3_Val=checkForNull(rs.getString("S3"),"0");
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "CAL", new Double(j+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "CAL", new Double(j+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "CAL", new Double(j+".14"));
					}
					if (!s4_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s4_Val), "CAL", new Double(j+".2"));
					}
					j++;

				}
				if(component_code.equals("CEJ")){
					s1_Val=checkForNull(rs.getString("S1"),"0");
					s2_Val=checkForNull(rs.getString("S2"),"0");
					s3_Val=checkForNull(rs.getString("S3"),"0");
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "CEJ-GM", new Double(k+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "CEJ-GM", new Double(k+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "CEJ-GM", new Double(k+".14"));
					}
					if (!s4_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s4_Val), "CEJ-GM", new Double(j+".2"));
					}
					k++;
				}
			}
		}else{
			while(rs.next()){
				tooth_no=rs.getString("TOOTH_NO");
				component_code=rs.getString("COMPONENT_CODE");
				if(component_code.equals("PD") && (pd_val.equals("PD")) ){
					if(components.equals("'PD','CAL'") && sel_radio_val.equals("PD")){
						s1_Val=checkForNull(rs.getString("S1"),"0");
						s2_Val=checkForNull(rs.getString("S2"),"0");
						s3_Val=checkForNull(rs.getString("S3"),"0");
					}else{
						s1_Val="0";
						s2_Val="0";
						s3_Val="0";
					}
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "PD", new Double(i+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "PD", new Double(i+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "PD", new Double(i+".14"));
					} 
					if (!s4_Val.equals("")){
						if(sel_radio_val.equals("PD")){
							defaultcategorydataset.addValue(new Double(s4_Val), "PD", new Double(i+".2"));
						}else{
							defaultcategorydataset.addValue(new Double(s4_Val), "PD", new Double(j+".2"));
						}
					}
					i++;
				}
					if(component_code.equals("CAL") && (cal_val.equals("CAL")) ){
						if(components.equals("'CEJ','CAL'") && sel_radio_val.equals("CAL")){
							s1_Val=checkForNull(rs.getString("S1"),"0");
							s2_Val=checkForNull(rs.getString("S2"),"0");
							s3_Val=checkForNull(rs.getString("S3"),"0");
						}else{
							s1_Val="0";
							s2_Val="0";
							s3_Val="0";
						}
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
						if (!s1_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s1_Val), "CAL", new Double(j+".1"));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "CAL", new Double(j+".12"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "CAL", new Double(j+".14"));
						}
						if (!s4_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s4_Val), "CAL", new Double(j+".2"));
						}
						j++;

				}
				if(component_code.equals("CEJ") && (cej_val.equals("CEJ")) ){
					if(components.equals("'CEJ','PD'") && sel_radio_val.equals("CEJ")){
						s1_Val=checkForNull(rs.getString("S1"),"0");
						s2_Val=checkForNull(rs.getString("S2"),"0");
						s3_Val=checkForNull(rs.getString("S3"),"0");
					}else{
						s1_Val="0";
						s2_Val="0";
						s3_Val="0";
					}
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "CEJ-GM", new Double(k+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "CEJ-GM", new Double(k+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "CEJ-GM", new Double(k+".14"));
					}
					if (!s4_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s4_Val), "CEJ-GM", new Double(k+".2"));
					}
					k++;
				}
			}
		
		}

		JFreeChart jfreechart = ChartFactory.createBarChart(null, null, null, defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
		jfreechart.setBackgroundPaint(Color.white);
	//	String img1="/eOH/images/R&D_upper.png";
		String url =pageContext.getServletContext().getRealPath("/")+img_src;
		if(url != null){
            ImageIcon imageicon = new ImageIcon(url);
            categoryplot.setBackgroundImage(imageicon.getImage());
			categoryplot.setBackgroundImageAlpha(1.0F);
			//categoryplot.setBackgroundPaint(Color.lightGray);

		}

		categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT, false); //get the horizontal scale at the top or bottom(.... line)
        CategoryDataset categorydataset = defaultcategorydataset;
        categoryplot.setDataset(1, categorydataset);
   //   categoryplot.mapDatasetToRangeAxis(1, 1);
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);
		numberaxis.setLabelAngle(Math.PI / 2.0);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setRange(-25,20);
        categoryplot.setRangeAxis(1, numberaxis);
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
		lineandshaperenderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());
		lineandshaperenderer.setShapesVisible(false); //Line chart with outline.
        categoryplot.setRenderer(1, lineandshaperenderer);
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
   		org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
		org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFGrCH");
		try{
			filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,261,info,null);
			org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
			graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
			//onload="checkMissingTooth();" 
		}
		catch(Exception ee){
			System.err.println("279 PerioBuccalGraph Exception:==="+ee.toString());
		}	
	}catch(Exception e){
		System.err.println("287 Exception in PerioBuccalGraph.jsp :"+e.toString());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
	}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(graphURL));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(X_Axis));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(perio_arch));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(chart_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sel_radio_val));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
