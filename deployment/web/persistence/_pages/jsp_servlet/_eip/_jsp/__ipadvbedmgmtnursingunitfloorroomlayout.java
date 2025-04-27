package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __ipadvbedmgmtnursingunitfloorroomlayout extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtNursingUnitFloorRoomLayout.jsp", 1738425893137L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2_0 ="\n<html>\n\t<head>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eIP/html/JQuery/base/jquery.ui.resizable.css\"/>\n\t\t<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>  \n\t\t<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js\" ></script>\n\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"../../eIP/html/IPAdvBedMgmtSetupStyle.css\"/>\n\t\t<script src=\'../../eIP/js/IPAdvBedMgmtSetup.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<style type=\"text/css\">\t\t\t\n\t\t\t.egrip{\n\t\t\t\twidth: 2px;\n\t\t\t\theight: 10px;\n\t\t\t\tbackground-color: #ffffff;\n\t\t\t\tborder: 1px solid #000000;\n\t\t\t\ttop:45%;\n\t\t\t\talign:center;\n\t\t\t}\n\t\t\t.sgrip{\n\t\t\t\twidth: 10px;\n\t\t\t\theight: 2px;\n\t\t\t\tbackground-color: #ffffff;\n\t\t\t\tborder: 1px solid #000000;\n\t\t\t\talign:center;\n\t\t\t\tleft:45%;\n\t\t\t}\n\t\t</style>\n\t\t<script type=\"text/javascript\">\n\t\t\tvar roomArray = [];\n\t\t\tvar assignedRoomArray=[];\n\t\t\tvar delRoomArray=[];\n\t\t\tvar divId;\n\t\t\tvar divLeft=0;\n\t\t\tvar divTop=0;\n\t\t\tvar divHeight=0;\n\t\t\tvar divWidth=0;\n\t\t\tvar divTotalWidth=0;\n\t\t\tvar divTotalHeight=0;\n\t\t\tvar Rx1=0;\n\t\t\tvar Rx2=0;\n\t\t\tvar Rx3=0;\n\t\t\tvar Rx4=0;\n\t\t\tvar Ry1=0;\n\t\t\tvar Ry2=0;\n\t\t\tvar Ry3=0;\n\t\t\tvar Ry4=0;\n\t\t\tvar dropped=false;\n\t\t\tvar droppedFit=false;\n\t\t\tvar Parent=\"\";\n\t\t\tvar Me=\"\";\n\t\t\tvar did=\"\";\n\t\t\tvar droppedLeft;\n\t\t\tvar droppedTop;\n\t\t\t$(document).ready(function(){\n\t\t\t\t$(\'#unassignedroomsbox\').height(document.documentElement.clientHeight-2);\n\t\t\t\t$(\'#floorWrapper_floorroom\').css(\"left\", ($(\'#unassignedroomsbox\').width()+5));\n\t\t\t\t$(\'#floorWrapper_floorroom\').width(document.documentElement.clientWidth-($(\'#unassignedroomsbox\').width()+5));\n\t\t\t\t$(\'#floorWrapper_floorroom\').height(document.documentElement.clientHeight-2);\t\n\t\t\t\t$(\"#floor_floorroom\").children(\".assignedRoom_floorroom\").each(function(){\n\t\t\t\t\tif(jQuery.inArray($(this).attr(\"id\"), assignedRoomArray)==\'-1\'){\n\t\t\t\t\t\tassignedRoomArray.push($(this).attr(\"id\"));\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\tvar floorPos=$(\'#floor_floorroom\').offset();\t\t\t\t\n\t\t\t\tvar wrapperPos=$(\".floorWrapper_floorroom\").offset();\t\t\t\t\n\t\t\t\tvar floorWidth=document.forms[0].floorWidth.value;\n\t\t\t\tvar floorHeight=document.forms[0].floorHeight.value;\n\t\t\t\t$(\'.assignedRoom_floorroom\').draggable({\n\t\t\t\t\thelper:\'clone\',\n\t\t\t\t\tappendTo:\'#floor_floorroom\',\n\t\t\t\t\trevert: \'invalid\',\n\t\t\t\t\tcontainment: \'#floor_floorroom\',\n\t\t\t\t\tstart:function(e,ui){\n\t\t\t\t\t\tdropped=false;\n\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\tParent=\"\";\n\t\t\t\t\t\tMe=\"\";\n\t\t\t\t\t\tdid=\"\";\n\t\t\t\t\t},\n\t\t\t\t\tstop: function(e,ui){\n\t\t\t\t\t\tif(dropped && droppedFit){\n\t\t\t\t\t\t\tParent.removeChild(Me);\n\t\t\t\t\t\t}else if(dropped && (!droppedFit)){\n\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}).droppable({\n\t\t\t\t\tgreedy: true,\n\t\t\t\t\ttolerance: \'touch\',\n\t\t\t\t\tdrop: function(event,ui){\n\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\tui.draggable.draggable(\'option\',\'revert\',true);\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t$(\'.assignedRoom_floorroom\').resizable({\n\t\t\t\t\thandles:  \'e,s\',\n\t\t\t\t\tzIndex: 10000,\n\t\t\t\t\tappendTo:\'#floor_floorroom\',\n\t\t\t\t\tcontainment: \'#floor_floorroom\',\n\t\t\t\t\tminWidth:160,\n\t\t\t\t\tminHeight:120,\n\t\t\t\t\tstart: function(event, ui){\n\t\t\t\t\t\tdivWidth=$(this).width();\n\t\t\t\t\t\tdivHeight=$(this).height();\t\t\t\t\t\t\n\t\t\t\t\t},\n\t\t\t\t\tstop: function(event,ui){\n\t\t\t\t\t\tdivLeft=$(this).position().left;\n\t\t\t\t\t\tdivTop=$(this).position().top;\n\t\t\t\t\t\tRx1=ui.position.left;\n\t\t\t\t\t\tRx2=parseInt(ui.position.left) + parseInt(ui.size.width);\n\t\t\t\t\t\tRx3=ui.position.left;\n\t\t\t\t\t\tRx4=ui.position.left + ui.size.width;\n\t\t\t\t\t\tRy1=ui.position.top+ui.size.height;\n\t\t\t\t\t\tRy2=ui.position.top+ui.size.height;\n\t\t\t\t\t\tRy3=ui.position.top;\n\t\t\t\t\t\tRy4=ui.position.top;\n\t\t\t\t\t\tvar dest = $(\"#floor_floorroom\").position();\n\t\t\t\t\t\tdivId=$(this).attr(\"id\");\n\t\t\t\t\t\tvar divRight=Rx2;\n\t\t\t\t\t\tvar divBottom=Ry2;\n\t\t\t\t\t\tvar destRightEdge=parseInt(dest.left)+parseInt($(\"#floor_floorroom\").width());\n\t\t\t\t\t\tvar destBottomEdge=parseInt(dest.top)+parseInt($(\"#floor_floorroom\").height());\n\t\t\t\t\t\tIterateChildren($(this).attr(\"id\"));\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t$(\'.unassignedroom_floorroom\').draggable({\n\t\t\t\t\thelper:\'clone\',\n\t\t\t\t\tappendTo:\'body\',\n\t\t\t\t\trevert: \'invalid\',\n\t\t\t\t\tstart:function(e,ui){\n\t\t\t\t\t\tdropped=false;\n\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\tParent=\"\";\n\t\t\t\t\t\tMe=\"\";\n\t\t\t\t\t\tdid=\"\";\n\t\t\t\t\t},\n\t\t\t\t\tstop: function(e,ui){\n\t\t\t\t\t\tif(dropped && droppedFit){\n\t\t\t\t\t\t\t$(this).attr(\"id\",\"H\"+$(this).attr(\"id\"));\n\t\t\t\t\t\t\t//$(ui.helper).find(\'.roomClose_floorroom\').find(\'img\').show(\'fast\');\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else if(dropped && (!droppedFit)){\n\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t\t$(\'#floor_floorroom\').droppable({\n\t\t\t\t\ttolerance: \'fit\',\n\t\t\t\t\tdrop: function(event,ui){\n\t\t\t\t\t\tvar droppedLeft=ui.position.left;\n\t\t\t\t\t\tvar droppedTop=ui.position.top;\n\t\t\t\t\t\tif(ui.draggable.parent().attr(\'id\')==\'unassignedroomsbox\'){\n\t\t\t\t\t\t\tdroppedLeft=ui.position.left - (wrapperPos.left+2);\n\t\t\t\t\t\t\tdroppedTop=ui.position.top - (wrapperPos.top+2);\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tdroppedLeft=droppedLeft+$(\'#floorWrapper_floorroom\').scrollLeft();\n\t\t\t\t\t\t\tdroppedTop=droppedTop+$(\'#floorWrapper_floorroom\').scrollTop();\n\t\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\t\tdropped=true;\n\t\t\t\t\t\tdroppedFit=true;\t\t\t\t\t\n\t\t\t\t\t\tdid=ui.draggable.attr(\'id\');\n\t\t\t\t\t\tParent=ui.draggable.parent()[0] // add [0] to the end of jQuery object to convert to a normal javascript one.\n\t\t\t\t\t\tMe=ui.draggable[0];\n\t\t\t\t\t\tui.helper.attr(\'id\',did);\n\t\t\t\t\t\tui.helper.droppable({\n\t\t\t\t\t\t\tgreedy: true,\n\t\t\t\t\t\t\ttolerance: \'touch\',\n\t\t\t\t\t\t\tdrop: function(event,ui){\n\t\t\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\t\t\tui.draggable.draggable(\'option\',\'revert\',true);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t});\n\t\t\t\t\t\tui.helper.draggable({\n\t\t\t\t\t\t\trevert: \'invalid\', \n\t\t\t\t\t\t\tscroll: false,\n\t\t\t\t\t\t\tappendTo:\'#floor_floorroom\',\n\t\t\t\t\t\t\tcontainment: \'#floor_floorroom\',\n\t\t\t\t\t\t\thelper: \'clone\',\n\t\t\t\t\t\t\tzIndex: 10000,\n\t\t\t\t\t\t\tstart : function() {\n\t\t\t\t\t\t\t\tParent=\"\";\n\t\t\t\t\t\t\t\tMe=\"\";\n\t\t\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\tstop: function() {\n\t\t\t\t\t\t\t\tif(dropped && droppedFit){\n\t\t\t\t\t\t\t\t\tParent.removeChild(Me);\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}else if(dropped && (!droppedFit)){\n\t\t\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t});\n\t\t\t\t\t\tui.helper.find(\'.ui-resizable-handle\').remove();\n\t\t\t\t\t\tui.helper.resizable({\n\t\t\t\t\t\t\thandles:  \'e,s\',\n\t\t\t\t\t\t\tzIndex: 10000,\n\t\t\t\t\t\t\tappendTo:\'#floor_floorroom\',\n\t\t\t\t\t\t\tcontainment: \'#floor_floorroom\',\n\t\t\t\t\t\t\tminWidth:160,\n\t\t\t\t\t\t\tminHeight:120,\n\t\t\t\t\t\t\tstart: function(event, ui){\n\t\t\t\t\t\t\t\tdivWidth=$(this).width();\n\t\t\t\t\t\t\t\tdivHeight=$(this).height();\n\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\tstop: function(event,ui){\n\t\t\t\t\t\t\t\tdivLeft=0;\n\t\t\t\t\t\t\t\tdivTop=0;\n\t\t\t\t\t\t\t\tdivLeft=ui.position.left;\n\t\t\t\t\t\t\t\tdivTop=ui.position.top;\n\t\t\t\t\t\t\t\tRx1=divLeft;\n\t\t\t\t\t\t\t\tRx2=divLeft + ui.size.width;\n\t\t\t\t\t\t\t\tRx3=divLeft;\n\t\t\t\t\t\t\t\tRx4=divLeft + ui.size.width;\n\t\t\t\t\t\t\t\tRy1=divTop+ ui.size.height;\n\t\t\t\t\t\t\t\tRy2=divTop+ ui.size.height;\n\t\t\t\t\t\t\t\tRy3=divTop;\n\t\t\t\t\t\t\t\tRy4=divTop;\n\t\t\t\t\t\t\t\tvar dest = $(\"#floor_floorroom\").position();\n\t\t\t\t\t\t\t\tdivId=$(this).attr(\"id\");\n\t\t\t\t\t\t\t\tvar divRight=Rx2;\n\t\t\t\t\t\t\t\tvar divBottom=Ry2;\n\t\t\t\t\t\t\t\tif($(\"#floor_floorroom\").css(\'position\')==\'relative\'){\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar destRightEdge=parseInt(floorPos.left)+parseInt(floorWidth);\n\t\t\t\t\t\t\t\tvar destBottomEdge=parseInt(floorPos.top)+parseInt(floorHeight);\n\t\t\t\t\t\t\t\tIterateChildren($(this).attr(\"id\"));\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t});\n\t\t\t\t\t\t$(ui.helper).find(\'.roomClose_floorroom\').find(\'img\').remove();\n\t\t\t\t\t\t$(\'<img/>\', {\n\t\t\t\t\t\t\tsrc:     \'../../eCommon/images/disabled.gif\',\n\t\t\t\t\t\t\tid:\"R\"+ui.helper.attr(\"id\"),\n\t\t\t\t\t\t\t//title:   \'Delete \' + fotos[f].Title,\n\t\t\t\t\t\t\t\'class\': \'icon_delete\', // in quotes because class is a reserved js word\n\t\t\t\t\t\t\tclick:   function( e ){\n\t\t\t\t\t\t\t\tdelRoom(($(this).attr(\'id\')).substring(1));\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}).appendTo($(ui.helper).find(\'.roomClose_floorroom\'));\n\t\t\t\t\t\t$.ui.ddmanager.current.cancelHelperRemoval = true;\t\t\t\t\t\t\n\t\t\t\t\t\tui.helper.css({\'position\':\'absolute\',\'top\':droppedTop,\'left\':droppedLeft});\n\t\t\t\t\t\tui.helper.appendTo($(this));\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t});\n\t\t\twindow.onresize=function(){\n\t\t\t\t$(\'#floorWrapper_floorroom\').width(document.documentElement.clientWidth-($(\'#unassignedroomsbox\').width()+5));\n\t\t\t};\n\t\t\t\n\t\t\tfunction IterateChildren(id){\n\t\t\t\t$(\"#floor_floorroom\").children(\"div\").each(function(){\n\t\t\t\t\tvar $currElement=$(this);\n\t\t\t\t\tif(id!=$currElement.attr(\'id\')){\n\t\t\t\t\t\tvar Dx1=$currElement.position().left;\n\t\t\t\t\t\tvar Dx2=$currElement.position().left + $currElement.width();\n\t\t\t\t\t\tvar Dx3=$currElement.position().left;\n\t\t\t\t\t\tvar Dx4=$currElement.position().left + $currElement.width();\n\t\t\t\t\t\tvar Dy1=$currElement.position().top+$currElement.height();\n\t\t\t\t\t\tvar Dy2=$currElement.position().top+$currElement.height();\n\t\t\t\t\t\tvar Dy3=$currElement.position().top;\n\t\t\t\t\t\tvar Dy4=$currElement.position().top;\n\t\t\t\t\t\tif(((Dx1<Rx1 && Rx1<Dx4) && (Dy4<Ry1 && Ry1<Dy1))||((Dx1<Rx2 && Rx2<Dx4) && (Dy4<Ry2 && Ry2<Dy1))||((Dx1<Rx4 && Rx4<Dx4) && (Dy4<Ry4 && Ry4<Dy1))){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Rx1<Dx1 && Dx1<Rx4) && (Ry3<Dy1 && Dy1<Ry2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Rx1<Dx4 && Dx4<Rx4) && (Ry3<Dy4 && Dy4<Ry2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Ry1==Dy1 && Ry3==Dy3) && (Dx1<Rx2 && Rx2<Dx2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Rx1==Dx1 && Rx2==Dx2) && (Dy3<Ry1 && Ry1<Dy1)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Rx1<Dx1 && Dx2<Rx2) && (Dy4<Ry4 && Ry2<Dy2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}else if((Dx1<Rx1 && Rx2<Dx2) && (Ry4<Dy4 && Dy2<Ry2)){\n\t\t\t\t\t\t\tsetBackDiv(id);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t}\n\t\t\tfunction setBackDiv(ID){\n\t\t\t\tvar $currDiv = $(\"#\"+ID);\n\t\t\t\t$currDiv.width(divWidth);\n\t\t\t\t$currDiv.height(divHeight);\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tfunction submitRoomLayout(){\n\t\t\t\tvar layOutData=\"\";\n\t\t\t\tvar dest = $(\"#floor_floorroom\").offset();\n\t\t\t\tvar droppedCount=0;\n\t\t\t\tvar count=0;\n\t\t\t\tvar updateFlag=true;\n\t\t\t\t$(\"#floor_floorroom\").children(\"div\").each(function(){\n\t\t\t\t\tif(count==0){\t\t\t\t\t\t\t\n\t\t\t\t\t\tlayOutData=$(this).attr(\'id\')+\"~\"+($(this).position().left)+\"~\"+($(this).position().top)+\"~\"+$(this).width()+\"~\"+$(this).height();\n\t\t\t\t\t}else{\n\t\t\t\t\t\tlayOutData=layOutData+\"|\"+$(this).attr(\'id\')+\"~\"+($(this).position().left)+\"~\"+($(this).position().top)+\"~\"+$(this).width()+\"~\"+$(this).height();\n\t\t\t\t\t}\n\t\t\t\t\tvar bedCountId=\"bedCountId\"+$(this).attr(\'id\');\n\t\t\t\t\tvar roomWidthId=\"roomWidthId\"+$(this).attr(\'id\');\n\t\t\t\t\tvar roomHei";
    private final static byte[]  _wl_block2_0Bytes = _getBytes( _wl_block2_0 );

    private final static java.lang.String  _wl_block2_1 ="ghtId=\"roomHeightId\"+$(this).attr(\'id\');\n\t\t\t\t\tif($(\"#\"+bedCountId).val()>0 && ($(\"#\"+roomWidthId).val() > $(this).width() || $(\"#\"+roomHeightId).val() > $(this).height())){\n\t\t\t\t\t\tupdateFlag=false;\n\t\t\t\t\t}\n\t\t\t\t\tcount++;\n\t\t\t\t});\n\t\t\t\tif(!updateFlag){\n\t\t\t\t\talert(getMessage(\"BEDS_CONF_ROOM_REDUCE\",\"IP\"));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tif(layOutData!=\'\'){\n\t\t\t\t\t$.post(\"../../servlet/eIP.IPAdvBedMgmtSetupServlet\",\n\t\t\t\t\t{\n\t\t\t\t\t\toperation: \"roomLayout\",\n\t\t\t\t\t\tnursingUnit:parent.blank.document.bedMgmtSetupForm.nursing_unit.value,\n\t\t\t\t\t\tlayOutDataInfo:layOutData\n\t\t\t\t\t},\n\t\t\t\t\tfunction(data, textStatus)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"RECORD_MODIFIED\",\"SM\")+\"&err_value=0\";\n\t\t\t\t\t\tparent.blank.location.href=\"../../eIP/jsp/IPAdvBedMgmtCriteria.jsp\";\n\t\t\t\t\t\tlocation.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t);\n\t\t\t\t}else{\n\t\t\t\t\talert(getMessage(\"LAYOUT_NOT_SPC\",\"IP\"));\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tfunction delRoom(obj){\n\t\t\t\tif(jQuery.inArray(obj, assignedRoomArray)==\'-1\' || (jQuery.inArray(obj, delRoomArray)!=\'-1\')){\n\t\t\t\t\t$(\"#\"+obj).remove();\n\t\t\t\t\t$(\"#H\"+obj).show();\n\t\t\t\t\t$(\"#H\"+obj).attr(\'id\',obj);\n\t\t\t\t}else{\n\t\t\t\t\tvar name=$(\"#\"+obj).text();\n\t\t\t\t\t$.post(\"../../servlet/eIP.IPAdvBedMgmtSetupServlet\",\n\t\t\t\t\t{\n\t\t\t\t\t\toperation: \"delRoomFromLayout\",\n\t\t\t\t\t\troomNo:obj,\n\t\t\t\t\t\tnursingUnit:parent.blank.bedMgmtSetupForm.nursing_unit.value,\n\t\t\t\t\t\tfacility_id:document.roomLayOutMgmt.facility_id.value\n\t\t\t\t\t},\n\t\t\t\t\tfunction(data, textStatus)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(textStatus==\'success\'){\n\t\t\t\t\t\t\t$(\'#\'+obj).remove();\n\t\t\t\t\t\t\tdelRoomArray.push(obj);\t\n\t\t\t\t\t\t\t//alert(getMessage(\"ROOM_DEL_FROM_LT\",\"IP\"));\n\t\t\t\t\t\t\talert(getMessage(\"RECORD_MODIFIED\",\"SM\"));\n\t\t\t\t\t\t\td=document.createElement(\'div\');\n\t\t\t\t\t\t\tvar roomDfltWidth=160;\n\t\t\t\t\t\t\tvar roomDfltHeight=120;\n\t\t\t\t\t\t\td.style.height = roomDfltHeight;\n\t\t\t\t\t\t\td.style.width = roomDfltWidth;\n\t\t\t\t\t\t\t$(d).attr(\'id\',obj).addClass(\'unassignedroom_floorroom\');\n\t\t\t\t\t\t\td1=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d1).addClass(\'roomheader_floorroom\')\n\t\t\t\t\t\t\td2=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d2).addClass(\'roomDtls_floorroom\').html(name)\n\t\t\t\t\t\t\td3=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d3).addClass(\'roomClose_floorroom\')\n\t\t\t\t\t\t\td4=document.createElement(\'div\');\n\t\t\t\t\t\t\t$(d4).addClass(\'roomDivBody_floorroom\');\n\t\t\t\t\t\t\t$(d2).appendTo($(d1));\n\t\t\t\t\t\t\t$(d3).appendTo($(d1));\n\t\t\t\t\t\t\t$(d1).appendTo($(d));\n\t\t\t\t\t\t\t$(d4).appendTo($(d));\n\t\t\t\t\t\t\t$(d).appendTo($(\"#unassignedroomsbox\"));\n\t\t\t\t\t\t\t//$(d).text(name);\n\t\t\t\t\t\t\tname=\"\";\n\t\t\t\t\t\t\t$(d).draggable({\n\t\t\t\t\t\t\t\thelper:\'clone\',\n\t\t\t\t\t\t\t\tappendTo:\'body\',\n\t\t\t\t\t\t\t\trevert: \'invalid\',\n\t\t\t\t\t\t\t\tstart:function(e,ui){\n\t\t\t\t\t\t\t\t\tdropped=false;\n\t\t\t\t\t\t\t\t\tdroppedFit=false;\n\t\t\t\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\t\t\t\tParent=\"\";\n\t\t\t\t\t\t\t\t\tMe=\"\";\n\t\t\t\t\t\t\t\t\tdid=\"\";\n\t\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\t\tstop: function(e,ui){\n\t\t\t\t\t\t\t\t\tif(dropped && droppedFit){\n\t\t\t\t\t\t\t\t\t\troomArray.push($(this).attr(\"id\"));\n\t\t\t\t\t\t\t\t\t\t$(this).attr(\"id\",\"H\"+$(this).attr(\"id\"));\n\t\t\t\t\t\t\t\t\t\t$.ui.ddmanager.current.cancelHelperRemoval = true;\n\t\t\t\t\t\t\t\t\t}else if(dropped && (!droppedFit)){\n\t\t\t\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t$(this).draggable(\'option\',\'revert\',\'invalid\');\n\t\t\t\t\t\t\t\t\t\t$(this).show();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t});\n\t\t\t\t\t\t}\n\t\t\t\t\t});\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block2_1Bytes = _getBytes( _wl_block2_1 );

    private final static java.lang.String  _wl_block3 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown = \"lockKey()\">\n\t\t<form name=\'roomLayOutMgmt\' id=\'roomLayOutMgmt\' method=\'post\'>\n\t\t<div class=\'floorroomContainer\' id=\'mainDiv\'>\n\t\t\t<div class=\'unassignedroomsbox\' id=\'unassignedroomsbox\'>\n\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" class=\"unassignedroom_floorroom\" name=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" style=\"width:";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="px; height:";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="px;\"><div class=\'roomheader_floorroom\'><div class=\'roomDtls_floorroom\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</div><div class=\'roomClose_floorroom\'></div></div><div class=\'roomDivBody_floorroom\'></div></div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\n\t\t\t</div>\n\t\t\t<div class=\'floorWrapper_floorroom\' id=\"floorWrapper_floorroom\">\n\t\t\t\t<div class=\"floor_floorroom\" id=\"floor_floorroom\" style=\"width:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="px;\">\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" class=\"assignedRoom_floorroom\" style=\"top:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="px; left:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="px;width:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div><div class=\'roomClose_floorroom\'><img id=\'small\' src=\'../../eCommon/images/disabled.gif\' onClick=\"delRoom(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\"></img></div></div><div class=\'roomDivBody_floorroom\'><!--<div class=\"ui-resizable-handle ui-resizable-e egrip\"></div><div class=\"ui-resizable-handle ui-resizable-s sgrip\"></div>--></div><input type=\'hidden\' name=\'bedCount";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'bedCount";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'bedCountId";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'><input type=\'hidden\' name=\'roomWidth";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'roomWidth";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'roomWidthId";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'><input type=\'hidden\' name=\'roomHeight";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'roomHeight";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'roomHeightId";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'></div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t</div>\n\t\t\t<input type=\'hidden\' name=\'floorWidth\' id=\'floorWidth\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type=\'hidden\' name=\'floorHeight\' id=\'floorHeight\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type=\'hidden\' name=\'roomDfltWidth\' id=\'roomDfltWidth\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'roomDfltHeight\' id=\'roomDfltHeight\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\'facility_idId\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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

	String nursingUnit=request.getParameter("nursingUnit")==null?"":request.getParameter("nursingUnit");
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	ArrayList unassignedRoomList 	= new ArrayList();
	ArrayList assignedRoomList 		= new ArrayList();
	String facility_id		= (String)session.getAttribute("facility_id");
	int roomDfltWidth=0;
	int roomDfltHeight=0;
	String floorWidth="0";
	String floorHeight="0";

            _bw.write(_wl_block2_0Bytes, _wl_block2_0);
            _bw.write(_wl_block2_1Bytes, _wl_block2_1);

		HashMap floorLayoutmap=new HashMap();
			try{
				con=ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				HashMap nursingUnitRoomDataMap=eIP.IPAdvBedMgmtConfigBean.getNursingUnitRoomData(con,facility_id,nursingUnit);
				HashMap sizeInfoMap=eIP.IPAdvBedMgmtConfigBean.getRoomBedSizeData(con,facility_id);
				unassignedRoomList 	= (ArrayList)nursingUnitRoomDataMap.get("unassignedRoomList");
				assignedRoomList 	= (ArrayList)nursingUnitRoomDataMap.get("assignedRoomList");
				//roomDfltWidth=Integer.parseInt((String)sizeInfoMap.get("room_img_width"));
				roomDfltWidth=Integer.parseInt((String)(sizeInfoMap.get("room_dflt_width")==null?"160":sizeInfoMap.get("room_dflt_width")));
				roomDfltHeight=Integer.parseInt((String)(sizeInfoMap.get("room_dflt_height")==null?"120":sizeInfoMap.get("room_dflt_height")));
				if(roomDfltWidth==0){
					roomDfltWidth=160;
				}
				if(roomDfltHeight==0){
					roomDfltHeight=120;
				}
				//roomDfltHeight=Integer.parseInt((String)sizeInfoMap.get("room_img_height"));
				floorLayoutmap=eIP.IPAdvBedMgmtConfigBean.getFloorLayout(con,facility_id,nursingUnit);
				floorWidth=(String)floorLayoutmap.get("floor_width");
				floorHeight=(String)floorLayoutmap.get("floor_height");
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if(con != null)  ConnectionManager.returnConnection(con,request);
			}
		
            _bw.write(_wl_block3Bytes, _wl_block3);

				if(unassignedRoomList.size()>0){
					Iterator iterator=unassignedRoomList.iterator();
					while(iterator.hasNext()){
						HashMap tempMap = (HashMap)iterator.next();
						String roomNo=(String)tempMap.get("roomNo");
						String roomName=(String)tempMap.get("roomName");
						
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(roomDfltWidth));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(roomDfltHeight));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(roomName));
            _bw.write(_wl_block9Bytes, _wl_block9);

					}
				}
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(floorWidth));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(floorHeight));
            _bw.write(_wl_block11Bytes, _wl_block11);

					if(assignedRoomList.size()>0){
						Iterator iterator=assignedRoomList.iterator();
						while(iterator.hasNext()){
							HashMap tempMap = (HashMap)iterator.next();
							String roomNo=(String)tempMap.get("roomNo");
							String roomName=(String)tempMap.get("roomName");
							
							String roomTopPos=(String)tempMap.get("roomTopPos");
							String roomLeftPos=(String)tempMap.get("roomLeftPos");
							String roomWidth=(String)tempMap.get("roomWidth");
							String roomHeight=(String)tempMap.get("roomHeight");
							String bedCount=(String)tempMap.get("bedCount");
							
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(roomTopPos));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(roomLeftPos));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(roomWidth));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(roomHeight));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(roomName));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bedCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(roomWidth));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(roomHeight));
            _bw.write(_wl_block27Bytes, _wl_block27);

						}
					}
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(floorWidth));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(floorHeight));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(roomDfltWidth));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(roomDfltHeight));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
