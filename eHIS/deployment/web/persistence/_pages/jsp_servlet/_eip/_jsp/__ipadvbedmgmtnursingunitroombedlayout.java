package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIP.advbedmgmt.setup.beddimension.response.RetrieveDimensionResponse;
import eIP.advbedmgmt.setup.beddimension.request.RetrieveDimensionRequest;
import eIP.advbedmgmt.setup.beddimension.bc.BedDimensionBC;
import eIP.advbedmgmt.setup.beddimension.BedDimensionConstants;
import eIP.advbedmgmt.GBMConstants;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.sql.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __ipadvbedmgmtnursingunitroombedlayout extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtNursingUnitRoomBedLayout.jsp", 1738425901774L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3_0 ="\n<html>\n\t<head>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eIP/html/JQuery/base/jquery.ui.resizable.css\"/>\n\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"../../eIP/html/IPAdvBedMgmtSetupStyle.css\"/>\n\t\t<!--<script src=\'../../eIP/js/IPNursingUnitRoomLayout.js\' language=\'javascript\'></script>-->\n\t\t<script src=\'../../eIP/js/IPAdvBedMgmtSetup.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n\t\t<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.min.js\"></script>\n\t\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-layout/1.4.3/jquery.layout.min.js\" integrity=\"sha512-ivkojFS3Hd6k9wRLJqWXwOXVWh3Ygr3VKpcxB8m6FCn95pZE2tt0vFP3tTa08OW8PvPLfJk97pk6n3jAyvEA3g==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\t\t\t\n\t\n\t\t<script type=\"text/javascript\">\n\t\t\tvar bedArray = [];\n\t\t\tvar assignedBedArray=[];\n\t\t\tvar delBedArray=[];\n\t\t\tvar divId;\n\t\t\tvar divLeft=0;\n\t\t\tvar divTop=0;\n\t\t\tvar divHeight=0;\n\t\t\tvar divWidth=0;\n\t\t\tvar divTotalWidth=0;\n\t\t\tvar divTotalHeight=0;\n\t\t\tvar Rx1=0;\n\t\t\tvar Rx2=0;\n\t\t\tvar Rx3=0;\n\t\t\tvar Rx4=0;\n\t\t\tvar Ry1=0;\n\t\t\tvar Ry2=0;\n\t\t\tvar Ry3=0;\n\t\t\tvar Ry4=0;\n\t\t\tvar dropped=false;\n\t\t\tvar droppedFit=false;\n\t\t\tvar Parent=\"\";\n\t\t\tvar Me=\"\";\n\t\t\tvar did=\"\";\n\t\t\t$(document).ready(function(){\n\t\t\t\t$(\'#unassignedbedssbox\').height(document.documentElement.clientHeight-2);\n\t\t\t\t$(\'#floorWrapper_roombed\').css(\"left\", ($(\'#unassignedbedssbox\').width()+5));\n\t\t\t\t$(\'#floorWrapper_roombed\').width(document.documentElement.clientWidth-($(\'#unassignedbedssbox\').width()+5))\n\t\t\t\t$(\'#floorWrapper_roombed\').height(document.documentElement.clientHeight-2)\n\t\t\t\t$(\"#roomContainer_roombed\").children(\".assignedBed_roombed\").each(function(){\n\t\t\t\t\tif(jQuery.inArray($(this).attr(\"id\"), assignedBedArray)==\'-1\'){\n\t\t\t\t\t\tassignedBedArray.push($(this).attr(\"id\"));\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\tvar floorPos=$(\'#floor_roombed\').offset();\n\t\t\t\tvar roomPos=$(\'#roomContainer_roombed\').offset();\n\t\t\t\t$(\'.assignedBed_roombed\').draggable({\n\t\t\t\t\thelper:\'clone\',\n\t\t\t\t\tappendTo:\'#roomContainer_roombed\',\n\t\t\t\t\trevert: \'invalid\',\t\t\t\t\t\n\t\t\t\t\tcontainment: \'#roomContainer_roombed\',\n\t\t\t\t\tstart:function(e,ui){\n\t\t\t\t\t\tdropped=false;\n\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\tParent=\"\";\n\t\t\t\t\t\tMe=\"\";\n\t\t\t\t\t\tdid=\"\";\n\t\t\t\t\t},\n\t\t\t\t\tstop: function(e,ui){\n\t\t\t\t\t\tif(dropped && droppedFit){\n\t\t\t\t\t\t\tParent.removeChild(Me);\n\t\t\t\t\t\t}else if(dropped && (!droppedFit)){\n\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}).droppable({\n\t\t\t\t\tgreedy: true,\n\t\t\t\t\ttolerance: \'touch\',\n\t\t\t\t\tdrop: function(event,ui){\n\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\tui.draggable.draggable(\'option\',\'revert\',true);\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t$(\'.assignedBed_roombed\').resizable({\n\t\t\t\t\thandles:  \'e,s\',\n\t\t\t\t\tzIndex: 10000,\n\t\t\t\t\tappendTo:\'#roomContainer_roombed\',\n\t\t\t\t\tcontainment: \'#roomContainer_roombed\',\n\t\t\t\t\tminWidth:150,\n\t\t\t\t\tminHeight:90,\n\t\t\t\t\tstart: function(event, ui){\n\t\t\t\t\t\tdivWidth=$(this).width();\n\t\t\t\t\t\tdivHeight=$(this).height();\t\t\t\t\t\t\n\t\t\t\t\t},\n\t\t\t\t\tstop: function(event,ui){\n\t\t\t\t\t\tdivLeft=$(this).position().left;\n\t\t\t\t\t\tdivTop=$(this).position().top;\n\t\t\t\t\t\tRx1=ui.position.left;\n\t\t\t\t\t\tRx2=parseInt(ui.position.left) + parseInt(ui.size.width);\n\t\t\t\t\t\tRx3=ui.position.left;\n\t\t\t\t\t\tRx4=ui.position.left + ui.size.width;\n\t\t\t\t\t\tRy1=ui.position.top+ui.size.height;\n\t\t\t\t\t\tRy2=ui.position.top+ui.size.height;\n\t\t\t\t\t\tRy3=ui.position.top;\n\t\t\t\t\t\tRy4=ui.position.top;\n\t\t\t\t\t\tvar dest = $(\"#roomContainer_roombed\").position();\n\t\t\t\t\t\tdivId=$(this).attr(\"id\");\n\t\t\t\t\t\tvar divRight=Rx2;\n\t\t\t\t\t\tvar divBottom=Ry2;\n\t\t\t\t\t\tif($(\"#roomContainer_roombed\").css(\'position\')==\'relative\'){\n\t\t\t\t\t\t\tdivRight=Rx2+parseInt(dest.left);\n\t\t\t\t\t\t\tdivBottom=Ry2+parseInt(dest.top);\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar destRightEdge=parseInt(dest.left)+parseInt($(\"#roomContainer_roombed\").width());\n\t\t\t\t\t\tvar destBottomEdge=parseInt(dest.top)+parseInt($(\"#roomContainer_roombed\").height());\n\t\t\t\t\t\tif((divRight>destRightEdge)|| (divBottom>destBottomEdge)){\n\t\t\t\t\t\t\tsetBackDiv(divId);\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tIterateChildren($(this).attr(\"id\"));\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t$(\'.unassignedbed_roombed\').draggable({\n\t\t\t\t\thelper:\'clone\',\n\t\t\t\t\tappendTo:\'body\',\n\t\t\t\t\trevert: \'invalid\',\n\t\t\t\t\tstart:function(e,ui){\n\t\t\t\t\t\tdropped=false;\n\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\tParent=\"\";\n\t\t\t\t\t\tMe=\"\";\n\t\t\t\t\t\tdid=\"\";\n\t\t\t\t\t},\n\t\t\t\t\tstop: function(e,ui){\n\t\t\t\t\t\tif(dropped && droppedFit){\n\t\t\t\t\t\t\t$(this).attr(\"id\",\"H\"+$(this).attr(\"id\"));\n\t\t\t\t\t\t\t//$(ui.helper).find(\'.bedreset_roombed\').find(\'img\').show(\'fast\');\n\t\t\t\t\t\t}else if(dropped && (!droppedFit)){\n\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t$(\'#roomContainer_roombed\').droppable({\n\t\t\t\t\ttolerance: \'fit\',\n\t\t\t\t\tdrop: function(event,ui){\n\t\t\t\t\t\tvar droppedLeft=ui.position.left;\n\t\t\t\t\t\tvar droppedTop=ui.position.top;\n\t\t\t\t\t\tif(ui.draggable.parent().attr(\'id\')==\'unassignedbedssbox\'){\n\t\t\t\t\t\t\tdroppedLeft=ui.position.left - (roomPos.left);\n\t\t\t\t\t\t\tdroppedTop=ui.position.top - (roomPos.top);\n\t\t\t\t\t\t\tdroppedLeft=droppedLeft+$(\'#floorWrapper_roombed\').scrollLeft();\n\t\t\t\t\t\t\tdroppedTop=droppedTop+$(\'#floorWrapper_roombed\').scrollTop();\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t\tdropped=true;\n\t\t\t\t\t\tdroppedFit=true;\t\t\t\t\t\n\t\t\t\t\t\tdid=ui.draggable.attr(\'id\');\n\t\t\t\t\t\tParent=ui.draggable.parent()[0] // add [0] to the end of jQuery object to convert to a normal javascript one.\n\t\t\t\t\t\tMe=ui.draggable[0];\n\t\t\t\t\t\tui.helper.attr(\'id\',did);\n\t\t\t\t\t\tui.helper.droppable({\n\t\t\t\t\t\t\tgreedy: true,\n\t\t\t\t\t\t\ttolerance: \'touch\',\n\t\t\t\t\t\t\tdrop: function(event,ui){\n\t\t\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\t\t\tui.draggable.draggable(\'option\',\'revert\',true);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t});\t\t\t\t\t\n\t\t\t\t\t\tui.helper.draggable({\n\t\t\t\t\t\t\trevert: \'invalid\', \n\t\t\t\t\t\t\tscroll: false,\n\t\t\t\t\t\t\tappendTo:\'#roomContainer_roombed\',\n\t\t\t\t\t\t\tcontainment: \'#roomContainer_roombed\',\n\t\t\t\t\t\t\thelper: \'clone\',\n\t\t\t\t\t\t\tzIndex: 10000,\n\t\t\t\t\t\t\tstart : function() {\n\t\t\t\t\t\t\t\tParent=\"\";\n\t\t\t\t\t\t\t\tMe=\"\";\n\t\t\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\tstop: function() {\n\t\t\t\t\t\t\t\tif(dropped && droppedFit){\n\t\t\t\t\t\t\t\t\tParent.removeChild(Me);\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}else if(dropped && (!droppedFit)){\n\t\t\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t});\n\t\t\t\t\t\tui.helper.find(\'.ui-resizable-handle\').remove();\n\t\t\t\t\t\tui.helper.resizable({\n\t\t\t\t\t\t\thandles:  \'e,s\',\n\t\t\t\t\t\t\tzIndex: 10000,\n\t\t\t\t\t\t\tappendTo:\'#roomContainer_roombed\',\n\t\t\t\t\t\t\tcontainment: \'#roomContainer_roombed\',\n\t\t\t\t\t\t\tminWidth:150,\n\t\t\t\t\t\t\tminHeight:90,\n\t\t\t\t\t\t\tstart: function(event, ui){\n\t\t\t\t\t\t\t\tdivWidth=$(this).width();\n\t\t\t\t\t\t\t\tdivHeight=$(this).height();\n\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\tstop: function(event,ui){\n\t\t\t\t\t\t\t\tdivLeft=0;\n\t\t\t\t\t\t\t\tdivTop=0;\n\t\t\t\t\t\t\t\tdivLeft=$(this).position().left;\n\t\t\t\t\t\t\t\tdivTop=$(this).position().top;\n\t\t\t\t\t\t\t\tRx1=ui.position.left;\n\t\t\t\t\t\t\t\tRx2=ui.position.left + ui.size.width;\n\t\t\t\t\t\t\t\tRx3=ui.position.left;\n\t\t\t\t\t\t\t\tRx4=ui.position.left + ui.size.width;\n\t\t\t\t\t\t\t\tRy1=ui.position.top+ui.size.height;\n\t\t\t\t\t\t\t\tRy2=ui.position.top+ui.size.height;\n\t\t\t\t\t\t\t\tRy3=ui.position.top;\n\t\t\t\t\t\t\t\tRy4=ui.position.top;\n\t\t\t\t\t\t\t\tdivId=$(this).attr(\"id\");\n\t\t\t\t\t\t\t\tvar divRight=Rx2;\n\t\t\t\t\t\t\t\tvar divBottom=Ry2;\n\t\t\t\t\t\t\t\tvar destRightEdge=parseInt(roomPos.left)+parseInt($(\"#roomContainer_roombed\").width());\n\t\t\t\t\t\t\t\tvar destBottomEdge=parseInt(roomPos.top)+parseInt($(\"#roomContainer_roombed\").height());\n\t\t\t\t\t\t\t\tif((divRight>destRightEdge)|| (divBottom>destBottomEdge)){\n\t\t\t\t\t\t\t\t\tsetBackDiv(divId);\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tIterateChildren($(this).attr(\"id\"));\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t});\n\t\t\t\t\t\t$(ui.helper).find(\'.bedreset_roombed\').find(\'img\').remove();\n\t\t\t\t\t\t$(\'<img/>\', {\n\t\t\t\t\t\t\tsrc:     \'../../eCommon/images/disabled.gif\',\n\t\t\t\t\t\t\tid:\"R\"+ui.helper.attr(\"id\"),\n\t\t\t\t\t\t\t//title:   \'Delete \' + fotos[f].Title,\n\t\t\t\t\t\t\t\'class\': \'icon_delete\', // in quotes because class is a reserved js word\n\t\t\t\t\t\t\tclick:   function( e ){\n\t\t\t\t\t\t\t\tdelBed(($(this).attr(\'id\')).substring(1));\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}).appendTo($(ui.helper).find(\'.bedreset_roombed\'));\n\t\t\t\t\t\t$.ui.ddmanager.current.cancelHelperRemoval = true;\t\n\t\t\t\t\t\tui.helper.css({\'position\':\'absolute\',\'top\':droppedTop,\'left\':droppedLeft});\n\t\t\t\t\t\tui.helper.appendTo($(this));\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t});\n\t\t\twindow.onresize=function(){\n\t\t\t\t$(\'#floorWrapper_roombed\').width(document.documentElement.clientWidth-($(\'#unassignedbedssbox\').width()+5));\n\t\t\t};\n\t\t\t\n\t\t\tfunction IterateChildren(id){\n\t\t\t\t$(\"#roomContainer_roombed\").children(\"div\").each(function(){\n\t\t\t\t\tvar $currElement=$(this);\n\t\t\t\t\tif(id!=$currElement.attr(\'id\')){\n\t\t\t\t\t\tvar Dx1=$currElement.position().left;\n\t\t\t\t\t\tvar Dx2=$currElement.position().left + $currElement.width();\n\t\t\t\t\t\tvar Dx3=$currElement.position().left;\n\t\t\t\t\t\tvar Dx4=$currElement.position().left + $currElement.width();\n\t\t\t\t\t\tvar Dy1=$currElement.position().top+$currElement.height();\n\t\t\t\t\t\tvar Dy2=$currElement.position().top+$currElement.height();\n\t\t\t\t\t\tvar Dy3=$currElement.position().top;\n\t\t\t\t\t\tvar Dy4=$currElement.position().top;\n\t\t\t\t\t\tif(((Dx1<Rx1 && Rx1<Dx4) && (Dy4<Ry1 && Ry1<Dy1))||((Dx1<Rx2 && Rx2<Dx4) && (Dy4<Ry2 && Ry2<Dy1))||((Dx1<Rx4 && Rx4<Dx4) && (Dy4<Ry4 && Ry4<Dy1))){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Rx1<Dx1 && Dx1<Rx4) && (Ry3<Dy1 && Dy1<Ry2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Rx1<Dx4 && Dx4<Rx4) && (Ry3<Dy4 && Dy4<Ry2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Ry1==Dy1 && Ry3==Dy3) && (Dx1<Rx2 && Rx2<Dx2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Rx1==Dx1 && Rx2==Dx2) && (Dy3<Ry1 && Ry1<Dy1)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Rx1<Dx1 && Dx2<Rx2) && (Dy4<Ry4 && Ry2<Dy2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Dx1<Rx1 && Rx2<Dx2) && (Ry4<Dy4 && Dy2<Ry2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t);\n\t\t\t}\n\t\t\tfunction setBackDiv(ID){\n\t\t\t\tvar $currDiv = $(\"#\"+ID);\n\t\t\t\t$currDiv.width(divWidth);\n\t\t\t\t$currDiv.height(divHeight);\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tfunction submitBedLayout(){\n\t\t\t\tvar layOutData=\"\";\n\t\t\t\tvar dest = $(\"#roomContainer_roombed\").offset();\n\t\t\t\tvar droppedCount=0;\n\t\t\t\tvar count=0;\t\t\t\t\n\t\t\t\tvar count=0;\n\t\t\t\t$(\"#roomContainer_roombed\").children(\"div\").each(function(){\n\t\t\t\t\tif($(this).attr(\'id\')){\n\t\t\t\t\t\tif(count==0){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tlayOutData=$(this).attr(\'id\')+\"~\"+($(this).position().left)+\"~\"+($(this).position().top)+\"~\"+$(this).width()+\"~\"+$(this).height();\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tlayOutData=layOutData+\"|\"+$(th";
    private final static byte[]  _wl_block3_0Bytes = _getBytes( _wl_block3_0 );

    private final static java.lang.String  _wl_block3_1 ="is).attr(\'id\')+\"~\"+($(this).position().left)+\"~\"+($(this).position().top)+\"~\"+$(this).width()+\"~\"+$(this).height();\n\t\t\t\t\t\t}\n\t\t\t\t\t\tcount++;\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\tif(layOutData!=\'\'){\n\t\t\t\t\t$.post(\"../../servlet/eIP.IPAdvBedMgmtSetupServlet\",\n\t\t\t\t\t{\n\t\t\t\t\t\toperation: \"roomBedLayout\",\n\t\t\t\t\t\tnursingUnit:parent.blank.document.bedMgmtSetupForm.nursing_unit.value,\n\t\t\t\t\t\tlayOutDataInfo:layOutData\n\t\t\t\t\t},\n\t\t\t\t\tfunction(data, textStatus)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"RECORD_MODIFIED\",\"SM\")+\"&err_value=0\";\n\t\t\t\t\t\tparent.blank.document.bedMgmtSetupForm.room.value=\'\';\n\t\t\t\t\t\tlocation.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\n\t\t\t\t\t} \n\t\t\t\t\t);\n\t\t\t\t}else{\n\t\t\t\t\talert(getMessage(\"LAYOUT_NOT_SPC\",\"IP\"));\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tfunction delBed(obj){\t\t\t\t\n\t\t\t\tif(jQuery.inArray(obj, assignedBedArray)==\'-1\' || (jQuery.inArray(obj, delBedArray)!=\'-1\')){\n\t\t\t\t\t$(\"#\"+obj).remove();\n\t\t\t\t\t$(\"#H\"+obj).show();\n\t\t\t\t\t$(\"#H\"+obj).attr(\'id\',obj);\n\t\t\t\t}else{\n\t\t\t\t\t$.post(\"../../servlet/eIP.IPAdvBedMgmtSetupServlet\",\n\t\t\t\t\t{\n\t\t\t\t\t\toperation: \"delBedFromLayout\",\n\t\t\t\t\t\tfacility_id:document.forms[0].facility_id.value,\n\t\t\t\t\t\troomNo:document.forms[0].room.value,\n\t\t\t\t\t\tbedNo:obj,\n\t\t\t\t\t\tnursingUnit:document.forms[0].nursingUnit.value\n\t\t\t\t\t},\n\t\t\t\t\tfunction(data, textStatus)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(textStatus==\'success\'){\n\t\t\t\t\t\t\t$(\'#\'+obj).remove();\n\t\t\t\t\t\t\tdelBedArray.push(obj);\n\t\t\t\t\t\t\talert(getMessage(\"RECORD_MODIFIED\",\"SM\"));\n\t\t\t\t\t\t\t//alert(getMessage(\"BED_DEL_FROM_LT\",\"IP\"));\t\t\t\t\t\t\t\n\t\t\t\t\t\t\td=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d).attr(\'id\',obj).addClass(\'unassignedbed_roombed\');\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t$(d).height($(\"#bedDfltHeight\").val());\n\t\t\t\t\t\t\t$(d).width($(\"#bedDfltWidth\").val());\t\t\t\n\t\t\t\t\t\t\td1=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d1).addClass(\'bedheader_roombed\')\n\t\t\t\t\t\t\td2=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d2).addClass(\'bedDtls_roombed\').html(obj)\n\t\t\t\t\t\t\td3=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d3).addClass(\'bedreset_roombed\')\n\t\t\t\t\t\t\td4=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d4).addClass(\'bedbody_roombed\');\n\t\t\t\t\t\t\t$(d2).appendTo($(d1));\n\t\t\t\t\t\t\t$(d3).appendTo($(d1));\n\t\t\t\t\t\t\t$(d1).appendTo($(d));\n\t\t\t\t\t\t\t$(d4).appendTo($(d));\n\t\t\t\t\t\t\t$(d).appendTo($(\"#unassignedbedssbox\"));\n\t\t\t\t\t\t\t$(d).draggable({\n\t\t\t\t\t\t\t\thelper:\'clone\',\n\t\t\t\t\t\t\t\tappendTo:\'body\',\n\t\t\t\t\t\t\t\trevert: \'invalid\',\n\t\t\t\t\t\t\t\tstart:function(e,ui){\n\t\t\t\t\t\t\t\t\tdropped=false;\n\t\t\t\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\t\t\t\tParent=\"\";\n\t\t\t\t\t\t\t\t\tMe=\"\";\n\t\t\t\t\t\t\t\t\tdid=\"\";\n\t\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\t\tstop: function(e,ui){\n\t\t\t\t\t\t\t\t\tif(dropped && droppedFit){\n\t\t\t\t\t\t\t\t\t\t$(this).attr(\"id\",\"H\"+$(this).attr(\"id\"));\n\t\t\t\t\t\t\t\t\t\t$.ui.ddmanager.current.cancelHelperRemoval = true;\n\t\t\t\t\t\t\t\t\t}else if(dropped && (!droppedFit)){\n\t\t\t\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t});\n\t\t\t\t\t\t}\n\t\t\t\t\t});\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block3_1Bytes = _getBytes( _wl_block3_1 );

    private final static java.lang.String  _wl_block4 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown = \"lockKey()\">\n\t<form name=\'bedLayOutMgmt\' id=\'bedLayOutMgmt\' method=\'post\'>\n\t<!--bedDiv0~crdbed|bedDiv1~surbed|bedDiv2|bedDiv3~nrmbed-->\n\t\t<div class=\'unassignedbedssbox\' id=\'unassignedbedssbox\'>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" class=\"unassignedbed_roombed\" name=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" style=\"width:";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="px; height:";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="px;\"><div class=\'bedheader_roombed\'><div class=\'bedDtls_roombed\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</div><div class=\'bedreset_roombed\'></div></div><div class=\'bedbody_roombed\'></div></div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\n\t\t</div>\n\t\t\t<div class=\'floorWrapper_roombed\' id=\"floorWrapper_roombed\">\n\t\t\t\t<div class=\"floor_roombed\" id=\"floor_roombed\" style=\"width:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="px;\">\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t<div class=\"roomContainer_roombed\"  style=\"top:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="px; left:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="px;width:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="px;\">\n\t\t\t\t\t\t\t\t\t<div class=\'roomheader_roombed\'><div class=\'roomDtls_roombed\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div></div>\n\t\t\t\t\t\t\t\t\t\t<div id=\"roomContainer_roombed\" style=\"position:relative;height:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="px;\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<div class=\"roomContainer_roombed\"  style=\"filter:alpha(opacity=25);top:";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div></div>\n\t\t\t\t\t\t\t\t\t\t<div id=\"roomContainer_roombed";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" style=\"position:relative;height:";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" class=\"assignedBed_roombed\" style=\"top:";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div><div class=\'bedreset_roombed\'><img id=\'small\' src=\'../../eCommon/images/disabled.gif\' onClick=\"delBed(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\"></img></div></div><div class=\'bedbody_roombed\'></div></div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" class=\"assignedBedMask_roombed\" style=\"top:";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div><div class=\'bedreset_roombed\'></div></div><div class=\'bedbody_roombed\'></div></div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'nursingUnit\' id=\'nursingUnit\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'room\' id=\'room\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'/>\n\t\t\t<input type=\'hidden\' id=\'bedDfltWidth\' name=\'bedDfltWidth\' id=\'bedDfltWidth\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'/>\n\t\t\t<input type=\'hidden\' id=\'bedDfltHeight\' name=\'bedDfltHeight\' id=\'bedDfltHeight\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'/>\n\t\t</form>\n\t\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

		String nursingUnit=request.getParameter("nursingUnit")==null?"":request.getParameter("nursingUnit");
		String room=request.getParameter("room")==null?"":request.getParameter("room");
		request.setCharacterEncoding("UTF-8");
		Connection con	= null;
		Statement stmt=null;
		PreparedStatement	pstmt	= null;
		ResultSet rs	= null;
		ArrayList unassignedBedList 	= new ArrayList();
		ArrayList assignedBedList 		= new ArrayList();
		ArrayList floorRoomBedList 		= new ArrayList();
		String facility_id		= (String)session.getAttribute("facility_id");
		HashMap ipRoomBedDataMap=new HashMap();
		int bedDfltWidth=0;
		int bedDfltHeight=0;
	
            _bw.write(_wl_block3_0Bytes, _wl_block3_0);
            _bw.write(_wl_block3_1Bytes, _wl_block3_1);
 
		HashMap floorLayoutmap=new HashMap();
		String floorWidth="0";
		String floorHeight="0";
			try{
				con=ConnectionManager.getConnection(request);
				ipRoomBedDataMap=eIP.IPAdvBedMgmtConfigBean.getIPRoomBedData(con,pstmt,rs,nursingUnit,room,facility_id);

				// get data through BC class
				RetrieveDimensionRequest retrDimRequest = new RetrieveDimensionRequest();
				ApplicationContext context = new ClassPathXmlApplicationContext(
								GBMConstants.SPRING_BEANS_XML_NAME);
				BedDimensionBC bcInst = (BedDimensionBC)context
										.getBean(BedDimensionConstants.BC_IDENTIFIER);
				RetrieveDimensionResponse retrDimResponse = bcInst.getBedDimension(retrDimRequest);
				
				if(retrDimResponse.isSuccessful()){
					bedDfltWidth = retrDimResponse.getWidth();
					bedDfltHeight = retrDimResponse.getHeight();
				}else{
					bedDfltWidth = BedDimensionConstants.DEFAULT_WIDTH;
					bedDfltHeight = BedDimensionConstants.DEFAULT_HEIGHT;
				}
				
				
				/* HashMap sizeInfoMap=eIP.IPAdvBedMgmtConfigBean.getRoomBedSizeData(con,facility_id);
				bedDfltWidth=Integer.parseInt((String)sizeInfoMap.get("bed_img_width"));
				bedDfltHeight=Integer.parseInt((String)sizeInfoMap.get("bed_img_height")); */
				
				unassignedBedList 	= (ArrayList)ipRoomBedDataMap.get("unassignedBedList");
				assignedBedList 	= (ArrayList)ipRoomBedDataMap.get("assignedBedList");
				
				// to get all rooms of nursing unit starts
				stmt=con.createStatement();
				if(rs!=null)rs.close();
				floorRoomBedList=eIP.IPAdvBedMgmtConfigBean.getNursingUnitRoomBedSetupData(con,stmt,rs,nursingUnit,facility_id);
				// to get all rooms of nursing unit ends
				
				floorLayoutmap=eIP.IPAdvBedMgmtConfigBean.getFloorLayout(con,facility_id,nursingUnit);
				floorWidth=(String)floorLayoutmap.get("floor_width");
				floorHeight=(String)floorLayoutmap.get("floor_height");
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if(con != null)  ConnectionManager.returnConnection(con,request);
			}
		
            _bw.write(_wl_block4Bytes, _wl_block4);

				if(unassignedBedList.size()>0){
					Iterator iterator=unassignedBedList.iterator();
					while(iterator.hasNext()){
						HashMap tempMap = (HashMap)iterator.next();
						String bedNo=(String)tempMap.get("bedNo");
						
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bedDfltWidth));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bedDfltHeight));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block10Bytes, _wl_block10);

					}
				}
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(floorWidth));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(floorHeight));
            _bw.write(_wl_block12Bytes, _wl_block12);


					if(floorRoomBedList.size()>0){
						Iterator iterator=floorRoomBedList.iterator();
						int roomCounter=0;
						while(iterator.hasNext()){
							HashMap tempMap = (HashMap)iterator.next();
							String roomNo=(String)tempMap.get("roomNo");
							String roomName=(String)tempMap.get("roomName");						
							String roomTopPos=(String)tempMap.get("roomTopPos");
							String roomLeftPos=(String)tempMap.get("roomLeftPos");
							String roomWidth=(String)tempMap.get("roomWidth");
							String roomHeight=(String)tempMap.get("roomHeight");
							ArrayList roomBedsList =(ArrayList)tempMap.get("roomBedsList");
							boolean sameRoomFlag=false;
							int roomHeight1=Integer.parseInt(roomHeight)-20;
							if(room.equals(roomNo)){
								sameRoomFlag=true;
							}else{
								sameRoomFlag=false;
							}
							if(sameRoomFlag){
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(roomTopPos));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(roomLeftPos));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(roomWidth));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(roomHeight));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(roomName));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(roomHeight1));
            _bw.write(_wl_block18Bytes, _wl_block18);

							}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(roomTopPos));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(roomLeftPos));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(roomWidth));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(roomHeight));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(roomName));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(roomCounter));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(roomHeight1));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
							if(roomBedsList.size()>0){
								Iterator bedItr=roomBedsList.iterator();
								while(bedItr.hasNext()){
									HashMap roomBedsMap = (HashMap)bedItr.next();
									//System.out.println("roomBedsMap set up:"+roomBedsMap.toString());
									String bedNo=(String)roomBedsMap.get("bedNo");						
									String bedTopPos=(String)roomBedsMap.get("bedTopPos");
									String bedLeftPos=(String)roomBedsMap.get("bedLeftPos");
									String bedWidth=(String)roomBedsMap.get("bedWidth");
									String bedHeight=(String)roomBedsMap.get("bedHeight");
									//System.out.println("IPNursingUnitRoomBedLayout roomNo ="+roomNo+":bedNo="+bedNo+":bedTopPos="+bedTopPos+":bedLeftPos="+bedLeftPos+":bedWidth="+bedWidth+":bedHeight="+bedHeight);
									if(sameRoomFlag){
									
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bedTopPos));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bedLeftPos));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bedWidth));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bedHeight));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block25Bytes, _wl_block25);

									}else{
										
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bedTopPos));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bedLeftPos));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bedWidth));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bedHeight));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block27Bytes, _wl_block27);

									}
								}//while loop for roomBedsList ends
							}//if condition roomBedsList ends
							
            _bw.write(_wl_block28Bytes, _wl_block28);

							roomCounter++;
						}//while loop for floorRoomBedList ends
					}//if condition floorRoomBedList ends
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nursingUnit));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(room));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bedDfltWidth));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedDfltHeight));
            _bw.write(_wl_block34Bytes, _wl_block34);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
