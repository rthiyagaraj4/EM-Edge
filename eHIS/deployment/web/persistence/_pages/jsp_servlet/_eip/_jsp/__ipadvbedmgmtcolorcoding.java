package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eCommon.Common.CommonBean;
import eIP.advbedmgmt.common.model.BedLegend;
import java.util.List;
import eIP.advbedmgmt.common.bedlegend.response.BedLegendResponse;
import eIP.advbedmgmt.common.bedlegend.bc.BedLegendBC;
import eIP.advbedmgmt.common.bedlegend.BedLegendConstants;
import eIP.advbedmgmt.common.model.BedStatusEnum;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import eIP.advbedmgmt.GBMConstants;
import org.springframework.context.ApplicationContext;
import eIP.advbedmgmt.common.bedlegend.request.BedLegendRequest;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eMP.PatSearch.*;
import webbeans.eCommon.*;
import javax.naming.*;
import javax.ejb.*;
import java.rmi.*;
import javax.rmi.*;
import java.util.*;
import com.ehis.util.*;

public final class __ipadvbedmgmtcolorcoding extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtColorCoding.jsp", 1738425866005L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n\t<head>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=8\" >\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"../../eIP/html/IPAdvBedMgmtSetupStyle.css\"/>\n\t\t<script src=\'../../eIP/js/IPAdvBedMgmtSetup.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eIP/html/JQuery/jquery-ui-1.8.21.custom.min.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eIP/html/JQuery/ColorCoding/jquery.layout-latest.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eIP/html/JQuery/ColorCoding/farbtastic.js\"></script>\n\t\t<link rel=\"stylesheet\" href=\"../../eIP/html/JQuery/ColorCoding/farbtastic.css\" type=\"text/css\" />\n\t\t\n\t\t<style type=\"text/css\">\t\t\t\n\t\t\t.colorpickerDiv{\n\t\t\t\tfloat:left;\n\t\t\t\tborder:0px solid black;\n\t\t\t}\n\t\t\t.colorPickTextId{\n\t\t\t\tmargin-left:10%;\n\t\t\t\twidth:100%;\n\t\t\t}\n\t\t\t.TextId{\n\t\t\t\twidth:100%;\t\t\t\t\n\t\t\t}\n\t\t\t.colorPickId{\n\t\t\t\ttop:80%;\n\t\t\t\tmargin-left:10%;\n\t\t\t\tmargin-top:10%;\n\t\t\t\tmargin-top:10%;\n\t\t\t}\t\n\t\t</style>\n\t\t<script type=\"text/javascript\">\n\t\t\t$(document).ready(function () {\n\t\t\t\t$(\'body\').layout({ applyDefaultStyles: true });\n\t\t\t\t$(\'#colorpicker\').farbtastic(\'#color\');\n\t\t\t\t$(\'.color_pick_bed\').click(function (event){\n\t\t\t\t\tvar $target = $(event.target); // the element that fired the original click event\n\t\t\t\t\t$(\'#color\').val($(this).css(\'backgroundColor\'));\n\t\t\t\t\t$(\'#color\').focus();\n\t\t\t\t\t$(\'#color\').trigger(\'keyup\');\n\t\t\t\t\t$(\"input[id=selectedElem]\").val($(this).attr(\'id\'));\n\t\t\t\t\tvar selectedElem = $(\'input[id=selectedElem]\').val();\n\t\t\t\t\tvar elementColor = $(\'#\' + selectedElem + \'Text\').css(\'color\');\n\t\t\t\t\tif(elementColor ==\'white\'){\n\t\t\t\t\t\tdocument.getElementById(\"textcolor\").item[0].checked=true;\n\t\t\t\t\t\t//document.getElementById(\"textcolor\").item(0).selected=true;\n\t\t\t\t\t}else if(elementColor ==\'black\'){\n\t\t\t\t\t\tdocument.getElementById(\"textcolor\").item[1].checked=true;\n\t\t\t\t\t}\n\t\t\t\t\tevent.stopPropagation();\n\t\t\t\t});\n\t\t\t\t$(\'#room\').click(function (event){\n\t\t\t\t\tvar $target = $(event.target); // the element that fired the original click event\n\t\t\t\t\t$(\'#color\').val($(this).css(\'backgroundColor\'));\n\t\t\t\t\t$(\'#color\').focus();\n\t\t\t\t\t$(\'#color\').trigger(\'keyup\');\n\t\t\t\t\t$(\"input[id=selectedElem]\").val($(this).attr(\'id\'));\n\t\t\t\t\tdocument.getElementById(\"textcolor\").item[0].checked=false;\n\t\t\t\t\tdocument.getElementById(\"textcolor\").item[1].checked=false;\n\t\t\t\t\tevent.stopPropagation();\n\t\t\t\t});\n\t\t\t});\n\t\t\tfunction submitColorCoding(){\n\n\t\t\t\t\n\t\t\t\tif(($(\"#bedWidth\").val()>=150 && $(\"#bedWidth\").val()<=300) && ($(\"#bedHeight\").val()>=90 && $(\"#bedHeight\").val()<=200)){\n\t\t\t\t\t$.post(\"../../servlet/eIP.IPAdvBedMgmtSetupServlet\",\n\t\t\t\t\t\t{ \n\t\t\t\t\t\t\toperation: \"colorCoding\",\n\t\t\t\t\t\t\tbedDfltWidth:$(\"#bedWidth\").val(),\n\t\t\t\t\t\t\tbedDfltHeight:$(\"#bedHeight\").val(),\n\t\t\t\t\t\t\troom:$(\".clrpick_clr_disp\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tadmittedBed:$(\"#ADMITTED\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tadmittedBedText:$(\"#ADMITTED_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tadmissionInitiatedBed:$(\"#ADMISSION_INITIATED\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tadmissionInitiatedBedText:$(\"#ADMISSION_INITIATED_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tabscondBed:$(\"#ABSCOND\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tabscondBedText:$(\"#ABSCOND_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tblockedBed:$(\"#BLOCKED\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tblockedBedText:$(\"#BLOCKED_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tblockedOverrideableBed:$(\"#BLOCKED_OVERRIDEABLE\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tblockedOverrideableBedText:$(\"#BLOCKED_OVERRIDEABLE_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tbookedBed:$(\"#BOOKED\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tbookedBedText:$(\"#BOOKED_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tdischargedBed:$(\"#DISCHARGED\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tdischargedBedText:$(\"#DISCHARGED_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tdischargeInitiatedBed:$(\"#DISCHARGE_INITIATED\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tdischargeInitiatedBedText:$(\"#DISCHARGE_INITIATED_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tinfantBed:$(\"#INFANT\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tinfantBedText:$(\"#INFANT_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tleaveBed:$(\"#LEAVE\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tleaveBedText:$(\"#LEAVE_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\ttransferOutBed:$(\"#TRANSFER_OUT\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\ttransferOutBedText:$(\"#TRANSFER_OUT_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\ttransferInitBed:$(\"#TRANSFER_INIT\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\ttransferInitBedText:$(\"#TRANSFER_INIT_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tvacantBed:$(\"#VACANT\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\tvacantBedText:$(\"#VACANT_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\ttransferAcceptedBed:$(\"#TRANSFER_ACCEPTED\").css(\'backgroundColor\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slic";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="e(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t}),\n\t\t\t\t\t\t\ttransferAcceptedBedText:$(\"#TRANSFER_ACCEPTED_Text\").css(\'color\').replace(/^rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)$/, function(_, r, g, b) {\n\t\t\t\t\t\t\t    return [r, g, b].map(function(x) {\n\t\t\t\t\t\t\t        return (\'0\' + parseInt(x, 10).toString(16)).slice(-2);\n\t\t\t\t\t\t\t    }).join(\'\');\n\t\t\t\t\t\t\t})\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t},\n\t\t\t\t\t\tfunction(data, textStatus)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.blank.location.href=\"../../eIP/jsp/IPAdvBedMgmtCriteria.jsp\";\n\t\t\t\t\t\t\tlocation.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t//alert(data+\'||\'+textStatus);\n\t\t\t\t\t\t\tif(data.length > 0){\n\t\t\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"BED_DIM_SAVE_FAILURE\",\"IP\")+\"&err_value=0\";\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"RECORD_MODIFIED\",\"SM\")+\"&err_value=0\";\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t);\n\t\t\t\t}else{\n\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"BED_WIDTH_HEIGHT_RANGE\",\"IP\")+\"&err_value=0\";\n\t\t\t\t}\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<!--Below code was modified  on 08-JAN-2013 against [IN037130] -->\n\t<body id=\"bedMgmtColorBody\" onKeyDown = \"lockKey()\" >\n\t\t";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<div class=\"ui-layout-center\">\n\t\t\t<div id=\'dfltdtls_container\' class=\'dfltdtls_container\'>\n\t\t\t\t<div id=\'dfltdtls\' class=\'dfltdtls\'>\n\t\t\t\t\t<table style=\"width:100%;border:1px\">\n\t\t\t\t\t\t<tr><td class=\'label\'>Details(in Pixels)</td><td class=\'label\'>Width(Min/Max)</td><td class=\'label\'>Height(Min/Max)</td></tr>\n\t\t\t\t\t\t<tr><td class=\'label\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td><td><input type=\"text\" id=\"bedWidth\" name=\"bedWidth\" id=\"bedWidth\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" size=\'5\'/><span class=\'label\'>(150/300)</span></td><td><input type=\"text\" id=\"bedHeight\" name=\"bedHeight\" id=\"bedHeight\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" size=\'5\'/><span class=\'label\'>(90/200)</span></td></tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"clrpick_container\" id=\"clrpick_container\">\n\t\t\t\t<div id=\'room\'  name=\'room\' class=\'clrpick_clr_disp\' style=\'background-color:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'> <span id=\'roomText\'>Room Name</span>\n\t\t\t\t\t<div id=\'clr_pick_beds\' class=\'clr_pick_beds\'><p></p>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" class=\'color_pick_bed\' style=\"background-color:#";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =";\"><p id=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="_Text\' style=\'color:#";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</p></div>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<div id=\"colorpickerDiv\" class=\'colorpickerDiv\'>\n\t\t\t\t\t\t<div id=\'colorPickTextId\' class=\'colorPickTextId\'>\n\t\t\t\t\t\t\t<!--<span id=\'TextId\'></span><br>\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"color\" name=\"color\" id=\"color\" value=\"#123456\" />\n\t\t\t\t\t\t\t<span id=\'TextId\'>TextColor</span><br>-->\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"color\" name=\"color\" id=\"color\" value=\"#123456\" /><br>\n\t\t\t\t\t\t\tText Color<input type=\"radio\" name=\"textcolor\" id=\"textcolor\" value=\"W\" onclick=\"updateTextColor(\'W\')\">White\n\t\t\t\t\t\t\t<input type=\"radio\" name=\"textcolor\" id=\"textcolor\" value=\"B\" onclick=\"updateTextColor(\'B\')\">Black\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div id=\'colorPickId\' class=\'colorPickId\'>\n\t\t\t\t\t\t\t<div id=\"colorpicker\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\n\t\t\t</div>\n\t\t\t\n\t\t\t\n\t\t</div>\n\t\t<input type=\'hidden\' id=\'selectedElem\' name=\'selectedElem\' id=\'selectedElem\' value=\'\'>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</body>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);

			Connection con	= null;
			PreparedStatement	pstmt	= null;
			ResultSet rSet	= null;
			String bedWidth="";
			String bedHeight="";
			try{
				con = ConnectionManager.getConnection(request);
				HashMap dataMap=eIP.IPAdvBedMgmtConfigBean.getBedConfSetupData(con);
				bedWidth=(String)dataMap.get("bed_img_width");
				bedWidth	= bedWidth==null?"":bedWidth;
				bedHeight=(String)dataMap.get("bed_img_height");
				bedHeight	= bedHeight==null?"":bedHeight;
				String room_clr=(String)dataMap.get("room_clr");


				BedLegendRequest bedLegendRequest = new BedLegendRequest();
				ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
				BedLegendBC bcInst = (BedLegendBC)context.getBean(BedLegendConstants.LEGEND_BC_NAME);
				BedLegendResponse bedLegendResponse = bcInst.getBedLegend(bedLegendRequest);
				
			
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bedWidth));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bedHeight));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(room_clr));
            _bw.write(_wl_block11Bytes, _wl_block11);

						BedStatusEnum legendIdentifier = null;
						if(bedLegendResponse.isSuccessful()){
							List<BedLegend> legends = bedLegendResponse.getLegends();
							String color = "";
							String desc = "";
							String txtcolor	= "";
							
							
							for(BedLegend bedLegend:legends){	
							color = bedLegend.getLegendColor();
							desc = bedLegend.getLegendDescription();
							txtcolor	= bedLegend.getTextColor();
							legendIdentifier	= (BedStatusEnum)bedLegend.getLegendIdentifier();
						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(legendIdentifier));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(color));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(legendIdentifier));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(txtcolor));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

							
							}
						}
						
            _bw.write(_wl_block18Bytes, _wl_block18);

			if(rSet!=null)rSet.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			ex.printStackTrace();
			try{
				con.rollback();
			}catch(Exception e){
				e.printStackTrace();
			}
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Beds.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
