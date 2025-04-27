package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __periochartdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioChartDisplay.jsp", 1709119354067L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOH/js/PerioChart.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOH/js/HistPerioChart.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!-- <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onmouseover=\"delayRemarkLinkLoadTime()\" onload=\"delayRemarkLinkLoadTime()\"> -->\n<!-- onmouseover=\"delayRemarkLinkLoadTime() is removed by Sridevi Joshi on 4/27/2010 for PE....this function was getting called multiple times -->\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\"delayRemarkLinkLoadTime()\">\n\t<form name=\"perioChartDisplayForm\" id=\"perioChartDisplayForm\" action=\"../../servlet/eOH.OHDentalChartServletNew\" method=\"post\" target=\"messageFrame\">\n\t\t\n\t\t<table width=\"100%\" cellpadding =0 cellspacing=0 border = \'1\'>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t <td  id=\"header_id\" width= \"100%\" align=\"center\" style=\"background-color:brown\" id=\"tabColor\"><font color=\"white\"> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="  # ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ,";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =", ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></font></td>  \n\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t  <td  id=\"header_id\"width= \"100%\" align=\"center\" style=\"background-color:brown\"><font color=\"white\"> ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="  # ,";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" , ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></font></td>    \n\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</tr>\n\t\t</table>\n\t\t<table width=\"100%\" cellpadding =0 cellspacing=0 border = \'1\'>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"10%\" class=\"label\"><font size=\'1\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<td id=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" width=\"2%\" align=\'center\'>&nbsp;</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" width=\"2%\" align=\'center\'>&nbsp;</td>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\"10%\" style=\"background-color:white\" colspan=\"17\">&nbsp;</td> \n\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t<td id=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" width=\"2%\" align=\'center\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"10%\"><B>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</B></td>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<td id=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" width=\"5%\"><img src=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" ></td>\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td width=\"10%\" style=\"background-color:white\" colspan=\"17\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"10%\" class=\"columnHeader\"><img src=\"../../eOH/images/spacer.gif\" height=\"10\" width=\"66\"></td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<td id=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" class=\"columnHeader\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" class=\"columnHeader\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"10%\" style=\"background-color:white\" colspan=\"17\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"10%\"><B>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" ></td>\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<td id=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" width=\"2%\" align=\'center\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\n\t\t</table>\n\t\t<table width=\"100%\" cellpadding =0 cellspacing=0 border = \'0\'>\n\t\t<!-- Added by yadav for CRF-492 on 1/20/2010 -->\n\t\t\t<tr>\n\t\t\t\n\t\t\t<td class=\'label\'  width=\"25%\" colspan=\"5\" nowrap>\n\t\t\t\t<div  id=\"disableId\" name=\'disableId\' style=\"display:none;\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</div>\n\n\t\t\t\t<div  id=\"enableId\" name=\'enableId\' style=\"display:none;\"><font color=\"blue\"><a onclick=\"showPerioRemarks(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\')\" style=\"cursor:pointer\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</a></font> </div>\t\t\t\t\t\n\t\t\t</td>\n\t\t\t\t\t\n\t\t\t<td class=\'label\' width=\"25%\" colspan=\"5\" nowrap>\n\t\t\t\t<div  id=\"enableHistId\" name=\'enableHistId\' style=\"display:none;\">\n\t\t\t\t\t\t<font color=\"blue\"><a onclick=\"showPerioRemarksHistory(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a></font></div>\n\t\t\t\t<div  id=\"disableHistId\" name=\'disableHistId\' style=\"display:none;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</div>\t\t\t\t\t\t\t\t\t\n\t\t\t</td>\n\t\t\t<!-- end -->\n\t\t\t\t<!-- <td class=\'label\' colspan=\'\' align=\"right\">\n\n\t\t\t\t\t<a href=\"javascript:callPerioSummary(\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\');\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t</a>\n\t\t\t\t</td> -->\n\n\t\t\t\t<td class=\'label\' colspan=\'\' align=\"right\">\n\t\t\t\t\t<div  id=\"disablePerioLink\" name=\'disablePerioLink\' style=\"display:none;\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</div>\n\t\t\t\t\t<div  id=\"enablePerioLink\" name=\'enablePerioLink\' style=\"display:none;\"><font color=\"blue\"><a onclick=\"callPerioSummary(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</a></font> </div>\t\n\t\t\t\t</td>\n\t\t\t\t  <td class=\'label\' colspan=\'\' align=\"right\">\n\t\t\t\t\t<img  align=\'center\' src=\'../../eCA/images/graph.gif\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" \t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t<a href=\"javascript:showGraphDialog(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</a> \n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\n\t\t\t\t</td> \n\t\t\t</tr>\n\t\t</table>\n\t\t<input type = \"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type = \"hidden\" name= \"permanent_deciduous_flag\" value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type = \"hidden\" name= \"tooth_numbering_system\" value = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type = \"hidden\" name= \"facility_id\" value = \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\n\t\t<input type = \"hidden\" name= \"chart_num\" value = \"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t<input type = \"hidden\" name= \"chart_line_num\" value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t<input type = \"hidden\" name= \"perio_chart\" value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t<input type = \"hidden\" name= \"baseline_active_yn\" value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t<input type = \"hidden\" name= \"baseline_closed_yn\" value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t<input type = \"hidden\" name= \"added_date\" value = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t<input type = \"hidden\" name= \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t<input type = \"hidden\" name= \"remarks\" value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"> \n\t\t<input type = \"hidden\" name= \"facility_name\" value = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"> \n\t\t<input type = \"hidden\" name= \"languageId\" value = \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"> \n\t\t<input type = \"hidden\" name= \"encounter_id\" value = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"> \n\t\t<input type = \"hidden\" name= \"patient_class\" value = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"> \n\t\t<input type = \"hidden\" name= \"chart_code\" value = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"> \n\t</form>\n\t<script>\n\t\tloadSurfaceValues();\n\t</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );
 
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
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
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

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String q1_sno = "";
	String q2_sno = "";
	String tooth_str = "";
	String display_tooth_str = "";
	String max_chart_num = "";
 
	int tooth_count = 0;

	String[] tooth_str_arr = null;
	String[] display_tooth_str_arr = null;

	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String chart_num = checkForNull(request.getParameter("chart_num")) ;
	String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
	String baseline_active_yn = checkForNull(request.getParameter("baseline_active_yn")) ;
	String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn")) ;
	
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String perio_chart = checkForNull(request.getParameter("perio_chart"));
	String perio_arch = checkForNull(request.getParameter("perio_arch"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String added_date = checkForNull(request.getParameter("added_date"));	
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));	
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	String patient_class = checkForNull(request.getParameter("patient_class"));
	if(other_facilitychart_yn.equals("Y")){
			facility_id=other_chart_facility_id;
	
	}

	if(!perio_arch.equals("")){
		if(perio_arch.equals("U")){
			q1_sno = "1";
			q2_sno = "2";
		}
		else if(perio_arch.equals("L")){
			q1_sno = "3";
			q2_sno = "4";
		}
	}

	String remarks = checkForNull(request.getParameter( "remarks" )) ;
	String remarks_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
	String remarks_history = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RemarksHistory.Label","OH");
	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

try{
	con=ConnectionManager.getConnection(request);
	String facility_name = "";
	String chart_code_1 = "";
	String chart_date_start_1 = "";
	String chart_close_date_1 =  "";
	String chart_num_1 = "";
	String chart_desc_1 =  "";
	String chart_status_1 =  "";
	String chart_code =  perio_chart;
	ArrayList comp_details = new ArrayList();
		

	if(chart_num.equals("")){
		//To get the chart_num when the chart is new (there are no records for this chart in the HDR table).Since onclick of record we are not refreshing display page chart_num will be null.
		pstmt = con.prepareStatement("SELECT MAX(CHART_NUM)+1 MAX_CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? ");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			max_chart_num = checkForNull(rs.getString("MAX_CHART_NUM"),"1");
		}
		chart_num = max_chart_num;
	}

	//To get the No of tooth per Arch
	pstmt = con.prepareStatement("SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND B.QUADRANT_SNO IN (?,?) ORDER BY B.QUADRANT_SNO,A.TOOTH_NO");
	pstmt.setString(1,tooth_numbering_system);
	pstmt.setString(2,q1_sno);
	pstmt.setString(3,q2_sno);
	rs = pstmt.executeQuery();
	while(rs.next()){
		if(tooth_count == 0){
			tooth_str = checkForNull(rs.getString("TOOTH_NO"));
			display_tooth_str = checkForNull(rs.getString("DISPLAY_TOOTH_NO"));
		}
		else{
			tooth_str = tooth_str + "," +checkForNull(rs.getString("TOOTH_NO"));
			display_tooth_str = display_tooth_str + "," +checkForNull(rs.getString("DISPLAY_TOOTH_NO"));
		}
		tooth_count++;
	}

	if(!chart_code.equals("")){
		pstmt = con.prepareStatement("SELECT A.CHART_STATUS, A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD,TO_CHAR (A.CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE ,A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC,  A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A  WHERE  A.PATIENT_ID = ? AND A.CHART_STATUS IN('PE','CM','CD') and A.chart_code=? and A.CHART_NUM=?ORDER BY A.CHART_DATE DESC ");
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_code);
		pstmt.setString(3,chart_num);
		rs = pstmt.executeQuery();
		while(rs.next()){
			chart_status_1 = checkForNull(rs.getString("CHART_STATUS"));
			chart_code_1 = checkForNull(rs.getString("CHART_CODE"));
			chart_date_start_1=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("CHART_DATE_MOD"),"DMY","en",locale));
			chart_close_date_1=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("CHART_CLOSE_DATE"),"DMY","en",locale));
			chart_num_1 = checkForNull(rs.getString("CHART_NUM"));
			chart_desc_1 = checkForNull(rs.getString("CHART_DESC"));
			chart_status_1 = checkForNull(rs.getString("CHART_STATUS"));
			
		}

		pstmt = con.prepareStatement("SELECT FACILITY_NAME  FROM SM_FACILITY_PARAM WHERE FACILITY_ID = (SELECT OPERATING_FACILITY_ID FROM OH_PERIODONTAL_CHART_HDR  WHERE CHART_NUM = ? AND PATIENT_ID = ?)");
		pstmt.setString(1,chart_num);
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			facility_name = rs.getString("FACILITY_NAME");
		}
	}

	if(!perio_chart.equals("")){
		//Added by Sridevi Joshi on 4/29/2010 for PE .. this qry was getting exexcuted 3 times to retrieve components...
		pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
		pstmt.setString(1,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			comp_details.add(checkForNull(rs.getString("COMPONENT_CODE")));
			comp_details.add(checkForNull(rs.getString("COMPONENT_SHORT_DESC_USER_DEF")));
			comp_details.add(checkForNull(rs.getString("SURFACES_APPL_YN")));
		}
	}

	

            _bw.write(_wl_block7Bytes, _wl_block7);

		if((baseline_active_yn.equals("Y")|| baseline_closed_yn.equals("Y") ) || (chart_status_1.equals("CM")|| chart_status_1.equals("PE") || (chart_status_1.equals("CD")))){
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(chart_date_start_1));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(chart_close_date_1));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
		else{
	  
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

				
					/*pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
					pstmt.setString(1,perio_chart);
					rs = pstmt.executeQuery();*/
					//while(rs.next()){
					for(int x=0;x<comp_details.size();x+=3){
						//if(rs.getString("SURFACES_APPL_YN").equals("N") && !rs.getString("COMPONENT_CODE").equals("MITH")){
						if(((String)comp_details.get(x+2)).equals("N") && !((String)comp_details.get(x)).equals("MITH")){
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)comp_details.get(x+1)));
            _bw.write(_wl_block21Bytes, _wl_block21);

								tooth_str_arr = tooth_str.split(",");
								display_tooth_str_arr = display_tooth_str.split(",");
							if(perio_arch.equals("U")){
								for(int j=0;j<tooth_str_arr.length;j++){
									String td_id = (String)comp_details.get(x) + tooth_str_arr[j] ;
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(td_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

								}
				
            _bw.write(_wl_block24Bytes, _wl_block24);

						
						}else
						{
							for(int j=tooth_str_arr.length-1;j>=0;--j){
									String td_id = (String)comp_details.get(x) + tooth_str_arr[j] ;
							
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(td_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

								}
							
            _bw.write(_wl_block26Bytes, _wl_block26);


						}
					}
				}
			
            _bw.write(_wl_block27Bytes, _wl_block27);

					/*pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
					pstmt.setString(1,perio_chart);
					rs = pstmt.executeQuery();*/
					//while(rs.next()){
					for(int x=0;x<comp_details.size();x+=3){
						//if(checkForNull(rs.getString("SURFACES_APPL_YN")).equals("Y")){
						if(((String)comp_details.get(x+2)).equals("Y")){
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(((String)comp_details.get(x+1))));
            _bw.write(_wl_block21Bytes, _wl_block21);

								tooth_str_arr = tooth_str.split(",");
								display_tooth_str_arr = display_tooth_str.split(",");
								if(perio_arch.equals("U")){
									for(int j=0;j<tooth_str_arr.length;j++){
										String td_id = ((String)comp_details.get(x)) + tooth_str_arr[j] +"B";
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(td_id));
            _bw.write(_wl_block29Bytes, _wl_block29);

									}
				
            _bw.write(_wl_block30Bytes, _wl_block30);

								}else if(perio_arch.equals("L")){
									for(int j=tooth_str_arr.length-1;j>=0;--j){
										String td_id = ((String)comp_details.get(x)) + tooth_str_arr[j] +"B";
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(td_id));
            _bw.write(_wl_block29Bytes, _wl_block29);

									}
				
            _bw.write(_wl_block30Bytes, _wl_block30);

								}
					
						}
					}
		// added by yadav on 2/17/2010 for 473
		if(!perio_arch.equals("")){
			
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

					// modified by yadav for 473 on 2/17/2010
					int startNo=0,endNo=0;
					String img_src="";
					if(perio_arch.equals("L")){ startNo=32;endNo=17;}
					else if (perio_arch.equals("U")){startNo=1;endNo=16;}
				

					if (perio_arch.equals("U"))
					for(int j=startNo;j<=endNo;j++){
						{ img_src="../../eOH/images/MXB/MXB"+j+".jpg";
											
				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(img_src));
            _bw.write(_wl_block35Bytes, _wl_block35);

						}
					} if(perio_arch.equals("L")){ 
						for(int m=startNo;m>=endNo;m--)
							{
								img_src="../../eOH/images/MDB/MDB"+m+".jpg";
						
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(m));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(img_src));
            _bw.write(_wl_block35Bytes, _wl_block35);
 
					}
					}
				
            _bw.write(_wl_block36Bytes, _wl_block36);

					tooth_str_arr = tooth_str.split(",");
					if(perio_arch.equals("L"))
					{
				
					if(tooth_str_arr.length >1){
						display_tooth_str_arr = display_tooth_str.split(",");
					
						
						for(int j=tooth_str_arr.length-1;j>=0;--j){

					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tooth_str_arr[j]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(display_tooth_str_arr[j]));
            _bw.write(_wl_block39Bytes, _wl_block39);


						}
					}
					else{
						for(int j=1;j<=16;j++){

					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);


						}
					}	
					
			}else{		
					if(tooth_str_arr.length >1){
						display_tooth_str_arr = display_tooth_str.split(",");
					
						for(int j=0;j<tooth_str_arr.length;j++){

					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tooth_str_arr[j]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(display_tooth_str_arr[j]));
            _bw.write(_wl_block39Bytes, _wl_block39);


						}
					}
					else{
						for(int j=1;j<=16;j++){

					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);


						}
					}
					}
					
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

				
				// modified by yadav for 473 on 2/17/2010
					int startUNo=0,endUNo=0;
					String img_src1="";
					if(perio_arch.equals("L")){ startUNo=32;endUNo=17;}
					else if (perio_arch.equals("U")){startUNo=1;endUNo=16;}
					
					if(perio_arch.equals("U")){
					for(int j=startUNo;j<=endUNo;j++){
						
						img_src1="../../eOH/images/MXL/MXL"+j+".jpg";
						
									
							
				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(img_src1));
            _bw.write(_wl_block35Bytes, _wl_block35);

					}
					}else if(perio_arch.equals("L")){
							for(int k=startUNo;k>=endUNo;k--){
						
						img_src1="../../eOH/images/MDL/MDL"+k+".jpg";
									
							
				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(k));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(img_src1));
            _bw.write(_wl_block42Bytes, _wl_block42);

					}
					}
				
				
            _bw.write(_wl_block43Bytes, _wl_block43);

					/*pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
					pstmt.setString(1,perio_chart);
					rs = pstmt.executeQuery();*/
					//while(rs.next()){
					for(int x=0;x<comp_details.size();x+=3){
						if(((String)comp_details.get(x+2)).equals("Y")){
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(((String)comp_details.get(x+1))));
            _bw.write(_wl_block21Bytes, _wl_block21);

								tooth_str_arr = tooth_str.split(",");
								display_tooth_str_arr = display_tooth_str.split(",");
						if(perio_arch.equals("U"))
						{
								for(int j=0;j<tooth_str_arr.length;j++){
									String td_id = ((String)comp_details.get(x)) + tooth_str_arr[j] +"P";
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(td_id));
            _bw.write(_wl_block29Bytes, _wl_block29);

								}
				
            _bw.write(_wl_block24Bytes, _wl_block24);

						}else
							{
								for(int j=tooth_str_arr.length-1;j>=0;j--){
								String td_id = ((String)comp_details.get(x)) + tooth_str_arr[j] +"P";
								
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(td_id));
            _bw.write(_wl_block45Bytes, _wl_block45);

									}
								
            _bw.write(_wl_block46Bytes, _wl_block46);

								
							}
						}
					}
				
			}

			
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(remarks_title));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(remarks_title));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(remarks_title));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(remarks_history));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(remarks_history));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(remarks_history));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(perio_chart));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(perio_arch));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(perio_chart));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(perio_arch));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

					if(perio_chart.equals("")){
					
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
}else{
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(perio_chart));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(perio_arch));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(perio_chart));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(baseline_active_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(baseline_closed_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(added_date));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(chart_code));
            _bw.write(_wl_block81Bytes, _wl_block81);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
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

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.BaselineChart.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ChartStartDate.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ClosedDate.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.CreatedAt.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.BaselineChart.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ChartStartDate.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ClosedDate.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.CreatedAt.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Buccal.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Lingual.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.PeriodontalSummary.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.PeriodontalSummary.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.PeriodontalSummary.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Viewgraph.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Viewgraph.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }
}
