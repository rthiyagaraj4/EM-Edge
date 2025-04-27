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
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.*;
import org.jfree.chart.axis.DateAxis;
import java.text.DecimalFormat;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import java.util.*;
import com.ehis.util.*;

public final class __periocomparebuccalgraph extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioCompareBuccalGraph.jsp", 1742903449676L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
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

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t</head>\n\n\t \t<div id=\'img1\' name=\'1\' style=\"display:None;position:absolute;left:65;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img2\' name=\'2\' style=\"display:None;position:absolute;left:115;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t \t<div id=\'img3\' name=\'3\' style=\"display:None;position:absolute;left:160;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img4\' name=\'4\' style=\"display:None;position:absolute;left:210;top:35;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img5\' name=\'5\' style=\"display:None;position:absolute;left:250;top:33;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n \t\t<div id=\'img6\' name=\'6\' style=\"display:None;position:absolute;left:295;top:25;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img7\' name=\'7\' style=\"display:None;position:absolute;left:345;top:35;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img8\' name=\'8\' style=\"display:None;position:absolute;left:390;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img9\' name=\'9\' style=\"display:None;position:absolute;left:435;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div> \n\t\t<div id=\'img10\' name=\'10\' style=\"display:None;position:absolute;left:485;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img11\' name=\'11\' style=\"display:None;position:absolute;left:525;top:25;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img12\' name=\'12\' style=\"display:None;position:absolute;left:575;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img13\' name=\'13\' style=\"display:None;position:absolute;left:615;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img14\' name=\'14\' style=\"display:None;position:absolute;left:666;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img15\' name=\'15\' style=\"display:None;position:absolute;left:713;top:25;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>\n\t\t<div id=\'img16\' name=\'16\' style=\"display:None;position:absolute;left:760;top:30;height:100;width:100\">\n\t\t\t<img src=\'../../eOH/images/Cross.PNG\' style=\"position:absolute; left:0; top:0\">\n\t\t</div>   \n\n\t \t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" >\n\t\t<form>\n\t\t\t<table>\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\t\t\t\t\t\t\n\t\t\t\t\t\t<center><img  src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" border=0 usemap=\"#";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/></center>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\n\t\t\t<table cellspacing=\"\" cellpadding=\"\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'7%\' >&nbsp;</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<center ><font size=1>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></center> \n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'6%\' >&nbsp;</td>\n\t\t\t\t</tr>\t\n\t\t\t\t\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
 
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

			String locale = (String)session.getAttribute("LOCALE"); 
			request.setCharacterEncoding("UTF-8");
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	//Declarations

	int chartWidth = 831;

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Font labelFont = null;
    Font titleFont = null;

	String sql="";
	String graphURL = "";
	String filename = "";
	String sql1="";
	String tooth_no="";
	String component_code="";
	String s1_Val="";
	String s2_Val="";
	String s3_Val="";
	String tooth_num="";
	String tooth_arr="";
	String X_Axis="";
	String line_seq="";
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num1"));
	String chart_num2=checkForNull(request.getParameter("chart_num2"));
	String chart_num3=checkForNull(request.getParameter("chart_num3"));
	String chart_line_num="";
	String chart_line_num2="";
	String chart_line_num3="";
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	String comp_code=checkForNull(request.getParameter("components"));
	String surfface_appl_yn=checkForNull(request.getParameter("surfface_appl_yn"));
	String perio_arch=checkForNull(request.getParameter("perio_arch"));
	String eval_type=checkForNull(request.getParameter("eval_type"));
	String no_of_charts=checkForNull(request.getParameter("no_of_charts"));
	String quadrant=checkForNull(request.getParameter("quadrant"));
	if(eval_type.equals("BB")){
		chart_line_num="1";
		chart_line_num2="1";
		chart_line_num3="1";
	}else{
		chart_line_num=checkForNull(request.getParameter("chart_line_num1"));	
		chart_line_num2=checkForNull(request.getParameter("chart_line_num2"));
		chart_line_num3=checkForNull(request.getParameter("chart_line_num3"));
	}

String D1="";
String D2="";
String D3="";
			if("BE".equals(eval_type)){
				//chart_date= ("1".equals(line_seq))?eval_chart_date1+"(BL)":eval_chart_date2+"(EV)";//chart_date
				if("1".equals(line_seq)){
					D1 = "Baseline";
				}else if("2".equals(line_seq)){
					D2 = "Evaluation1";
				}else if("3".equals(line_seq)){
					D3 = "Evaluation2";
				}
			}else if("EE".equals(eval_type)){
				//chart_date= ("1".equals(line_seq))?eval_chart_date1+"(EV1)":eval_chart_date2+"(EV2)";//chart_date
				if("1".equals(line_seq)){
					D1 = "Evaluation1";
				}else if("2".equals(line_seq)){
					D2 = "Evaluation2";
				}else if("3".equals(line_seq)){
					D3 = "Evaluation3";
				}
			}else if("BB".equals(eval_type)){
				//chart_date = ("1".equals(line_seq))?eval_chart_date1+"(BL1)":eval_chart_date2+"(BL2)";//chart_date
				if("1".equals(line_seq)){
					D1 = "Baseline1";
				}else if("2".equals(line_seq)){
					D2 = "Baseline2";
				}else if("3".equals(line_seq)){
					D3 = "Baseline3";
				}
			}
	
	String X_Axis_uni_upper="";
	String X_Axis_uni_lower="";
	String X_Axis_Lower="";
	String X_Axis_Upper="";
	String img_src="";
	if(quadrant.equals("1")){
		img_src="/eOH/images/R&D_upper_1.png";		
	}else if(quadrant.equals("2")){
		img_src="/eOH/images/R&D_upper2_1.png";		
	}else if(quadrant.equals("4")){
		img_src="/eOH/images/DetalChartFour_NEW_6.PNG";		
	}else if(quadrant.equals("3")){
		img_src="/eOH/images/DetalChartThird_New_4.png";		
	}

	if(tooth_numbering_system.equals("UNI")){
		if(perio_arch.equals("U")){
			X_Axis=X_Axis_uni_upper;

		}else{
			X_Axis=X_Axis_uni_lower;
		}
	}else if(tooth_numbering_system.equals("FDI")){
		if(perio_arch.equals("U")){
			X_Axis=X_Axis_Upper;
		}else{
			X_Axis=X_Axis_Lower;
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
	
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		if(surfface_appl_yn.equals("N")){
			if(no_of_charts.equals("2")){
				sql="SELECT COMPONENT_CODE,TOOTH_NO, VALUE ,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ 		FROM OH_PERIODONTAL_CHART_DTL A,		(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 			 FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y			 WHERE Z.CHART_CODE = ? 			 AND X.LANGUAGE_ID = ? 			 AND Y.PERMANENT_DECIDUOUS = 'P'	  			 AND Y.ARCH_SNO = ? 			 AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  		WHERE A.PATIENT_ID(+) =?	   	  		AND A.CHART_CODE(+) =?	 		AND A.CHART_NUM(+)  =?	 		AND A.CHART_LINE_NUM(+) =?	  		AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	 		AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	  		UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		  WHERE COMPONENT_CODE =?		    ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";

			}else if(no_of_charts.equals("3")){

				sql="SELECT COMPONENT_CODE,TOOTH_NO, VALUE ,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ 		FROM OH_PERIODONTAL_CHART_DTL A,		(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 			 FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y			 WHERE Z.CHART_CODE = ? 			 AND X.LANGUAGE_ID = ? 			 AND Y.PERMANENT_DECIDUOUS = 'P'	  			 AND Y.ARCH_SNO = ? 			 AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  		WHERE A.PATIENT_ID(+) =?	   	  		AND A.CHART_CODE(+) =?	 		AND A.CHART_NUM(+)  =?	 		AND A.CHART_LINE_NUM(+) =?	  		AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	 		AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	  		UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,3 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE)  		  WHERE COMPONENT_CODE =?		    ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";	
			}

			if(no_of_charts.equals("2")){
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,chart_code);
				pstmt.setString(2,locale);
				pstmt.setString(3,perio_arch);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_code);
				pstmt.setString(6,chart_num);
				pstmt.setString(7,chart_line_num);
				pstmt.setString(8,chart_code);
				pstmt.setString(9,locale);
				pstmt.setString(10,perio_arch);
				pstmt.setString(11,patient_id);
				pstmt.setString(12,chart_code);
				pstmt.setString(13,chart_num2);
				pstmt.setString(14,chart_line_num2);
				pstmt.setString(15,comp_code);
			}else if(no_of_charts.equals("3")){
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,chart_code);
				pstmt.setString(2,locale);
				pstmt.setString(3,perio_arch);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_code);
				pstmt.setString(6,chart_num);
				pstmt.setString(7,chart_line_num);
				pstmt.setString(8,chart_code);
				pstmt.setString(9,locale);
				pstmt.setString(10,perio_arch);
				pstmt.setString(11,patient_id);
				pstmt.setString(12,chart_code);
				pstmt.setString(13,chart_num2);
				pstmt.setString(14,chart_line_num2);
				pstmt.setString(15,chart_code);
				pstmt.setString(16,locale);
				pstmt.setString(17,perio_arch);
				pstmt.setString(18,patient_id);
				pstmt.setString(19,chart_code);
				pstmt.setString(20,chart_num3);
				pstmt.setString(21,chart_line_num3);
				pstmt.setString(22,comp_code);
			}

			rs=pstmt.executeQuery();

			int i=0;
			int j=0;
			int k=0;
			String value_exists_yn = "N";
			while(rs.next()){
				value_exists_yn = "Y";
				tooth_no=rs.getString("TOOTH_NO");
				component_code=rs.getString("COMPONENT_CODE");
				line_seq=rs.getString("LINE_SEQ");

				if(comp_code.equals(component_code) ){
					if("1".equals(line_seq)){
						s2_Val="0";
						s1_Val=checkForNull(rs.getString("VALUE"),"0");
						s3_Val="0";
						if (!s1_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart1", new Double(i));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart1", new Double(i+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart1", new Double(i+".7"));
						} 
						i++;
					}else if("2".equals(line_seq)){
						s1_Val="0";
						s2_Val=checkForNull(rs.getString("VALUE"),"0");
						s3_Val="0";
					if (!s1_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart2", new Double(j));
						}
					if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart2", new Double(j+".3"));
						}
					if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart2", new Double(j+".7"));
						} 
						j++;

					}else if("3".equals(line_seq)){
						s1_Val="0";
						s3_Val=checkForNull(rs.getString("VALUE"),"0");
						s2_Val="0";
					if (!s1_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart3", new Double(k));
						}
					if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart3", new Double(k+".3"));
						}
					if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart3", new Double(k+".7"));
						} 
						k++;

					}
				}
				
			}
		}else{
			if(no_of_charts.equals("2")){
					sql="SELECT COMPONENT_CODE,TOOTH_NO, S1, S2, S3, S4, S5, S6,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6 ,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   	(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	  	FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	  WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	  AND Y.PERMANENT_DECIDUOUS = 'P'	 AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D	 WHERE  A.PATIENT_ID(+) =?	   	 AND A.CHART_CODE(+) =?	AND A.CHART_NUM(+)  =?	AND A.CHART_LINE_NUM(+) =?	 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	 UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		 WHERE COMPONENT_CODE =?		   ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";
			}else if(no_of_charts.equals("3")){
					sql="SELECT COMPONENT_CODE,TOOTH_NO, S1, S2, S3, S4, S5, S6,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6 ,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   	(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	  	FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	  WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	  AND Y.PERMANENT_DECIDUOUS = 'P'	 AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D	 WHERE  A.PATIENT_ID(+) =?	   	 AND A.CHART_CODE(+) =?	AND A.CHART_NUM(+)  =?	AND A.CHART_LINE_NUM(+) =?	 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	 UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,3 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		 WHERE COMPONENT_CODE =?		   ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";
			}
		if(no_of_charts.equals("2")){
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			pstmt.setString(3,perio_arch);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			pstmt.setString(8,chart_code);
			pstmt.setString(9,locale);
			pstmt.setString(10,perio_arch);
			pstmt.setString(11,patient_id);
			pstmt.setString(12,chart_code);
			pstmt.setString(13,chart_num2);
			pstmt.setString(14,chart_line_num2);
			pstmt.setString(15,comp_code);

		}else if(no_of_charts.equals("3")){
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			pstmt.setString(3,perio_arch);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			pstmt.setString(8,chart_code);
			pstmt.setString(9,locale);
			pstmt.setString(10,perio_arch);
			pstmt.setString(11,patient_id);
			pstmt.setString(12,chart_code);
			pstmt.setString(13,chart_num2);
			pstmt.setString(14,chart_line_num2);
			pstmt.setString(15,chart_code);
			pstmt.setString(16,locale);
			pstmt.setString(17,perio_arch);
			pstmt.setString(18,patient_id);
			pstmt.setString(19,chart_code);
			pstmt.setString(20,chart_num3);
			pstmt.setString(21,chart_line_num3);
			pstmt.setString(22,comp_code);

		}
			rs=pstmt.executeQuery();
			int i=0;
			int j=0;
			int k=0;
			String value_exists_yn = "N";
			while(rs.next()){
				value_exists_yn = "Y";
				tooth_no=rs.getString("TOOTH_NO");
				component_code=rs.getString("COMPONENT_CODE");
				line_seq=rs.getString("LINE_SEQ");
				if(comp_code.equals(component_code) ){
					if(no_of_charts.equals("2")){	
					if("1".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart1", new Double(i));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart1", new Double(i+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart1", new Double(i+".7"));
						} 
						i++;
					}else if("2".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart2", new Double(j));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart2", new Double(j+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart2", new Double(j+".7"));
						} 
						j++;

					}
				}else if(no_of_charts.equals("3")){	
					if("1".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart1", new Double(i));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart1", new Double(i+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart1", new Double(i+".7"));
						} 
						i++;
					}else if("2".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart2", new Double(j));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart2", new Double(j+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart2", new Double(j+".7"));
						} 
						j++;

					}else if("3".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart3", new Double(k));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart3", new Double(k+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart3", new Double(k+".7"));
						} 
						k++;
					  }
				   }
				}
			}
		}//Else  condition for surface_appl_yn

	JFreeChart jfreechart = ChartFactory.createLineChart(null,null,null , defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);

		/*
		 "Line Chart Demo 1",			// chart title
            "Type",						// domain xaxis label
            "Value",					// range yaxis label will come
            dataset,					// data
            PlotOrientation.VERTICAL,	// orientation
            true,						// include legend
            true,						// tooltips
            false						// urls
		*/
		jfreechart.setBackgroundPaint(Color.white);
        labelFont = new Font("Helvetica", Font.PLAIN, 1);
        titleFont = new Font("Helvetica", Font.PLAIN, 8);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
	    categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT, false);
		CategoryAxis xAxis = new CategoryAxis("");
        xAxis.setLabelFont(titleFont);
        xAxis.setTickLabelFont(labelFont);
        xAxis.setTickMarksVisible(false);
		categoryplot.setDomainAxis(xAxis);
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);
 		numberaxis.setLabelAngle(Math.PI / 2.0);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setRange(-25,20);
		categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.lightGray);
        categoryplot.setRangeGridlinesVisible(true);
		categoryplot.setBackgroundImageAlpha(1.0F);
		String url =pageContext.getServletContext().getRealPath("/")+img_src;
	    if(url != null){
            ImageIcon imageicon = new ImageIcon(url);
            categoryplot.setBackgroundImage(imageicon.getImage());
        }

		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setItemLabelsVisible(true);
        lineandshaperenderer.setPositiveItemLabelPosition(new ItemLabelPosition());
        lineandshaperenderer.setNegativeItemLabelPosition(new ItemLabelPosition());
        lineandshaperenderer.setShapesVisible(true);
        lineandshaperenderer.setDrawOutlines(true);
        lineandshaperenderer.setUseFillPaint(true);
        lineandshaperenderer.setFillPaint(Color.lightGray);
        lineandshaperenderer.setSeriesStroke(0, new BasicStroke(1F));
        lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(0.0F));
        lineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-3D, -3D, 5D, 5D));
		org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
		org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFGrCH");
		try{
			filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,261,info,null);
			org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
			graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
		}
		catch(Exception ee){
			out.println("Exception in try -2 :"+ee.toString());
		}	
	}catch(Exception e){
		out.println("Exception in ComparePerioBuccalGraph.jsp :"+e.toString());
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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
