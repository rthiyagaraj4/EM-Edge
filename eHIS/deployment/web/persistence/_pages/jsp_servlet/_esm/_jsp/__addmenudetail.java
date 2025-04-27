package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmenudetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/addmenuDetail.jsp", 1714840393605L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\'></link>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eSM/js/menuDetail.js\'></script>\n\n\t\t<script language=\"JavaScript\">\n\t\t\tvar index;\n\t\t\tvar val;\n\t\t\tvar txt;\n\t\t\tvar oOption;\n\t\t\tvar object;\n\n\t\t\tfunction showmodal()\n\t\t\t{\n\t\t\t\tif(document.getElementById(\'MainMenus\').options.length==0 || document.getElementById(\"norows\").value==\'N\')\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tvar menu_id=menu_detail_form.prev_menu.value;\n\n\t\t\t\tvar url\t= \"../../eSM/jsp/menuPreviewFrames.jsp?menuid=\" + menu_id ;\n\t\t\t\tvar dialogHeight\t= \"400px\" ;\n\t\t\t\tvar dialogWidth\t= \"700px\" ;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar scroll = \"yes\";\n\t\t\t\tvar dialogTop = \"60\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\t\t\t\n\t\t\t\tvar reportURL \t= window.showModalDialog( url, arguments, features ) ;\n\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction globalIndex(num) {\n\t\t\t\t\n\t\t\t\tmenu_detail_form.MainMenus.selectedIndex= -1;\n\t\t\t\tif(num==1) menu_detail_form.Functions.selectedIndex= -1;\n\t\t\t\t\n\t\t\t\telse menu_detail_form.SubMenus.selectedIndex= -1;\n\t\t\t\t\n\t\t\t\treturn true;\n\t\t\t}\n\n\t\t\tfunction Drag(obj)\n\t\t\t{\n\t\t\t\t\n\t\n\t\t\t\t\tvar spc=\"\";\n\t\t\t\t\tvar obj1=menu_detail_form.SubMenus;\n\t\t\t\t\tvar obj2=menu_detail_form.Functions;\n\t\t\t\t\tif(menu_detail_form.root_menu.value == \'N\')\n\t\t\t\t\t\tspc+=\"              \" ;\n\t\t\t\t\tif(obj1.selectedIndex != -1)\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tindex=obj1.selectedIndex;\n\t\t\t\t\t\t\tval=obj1.options[index].value;\n\t\t\t\t\t\t\ttxt=spc+obj1.options[index].text;\n\t\t\t\t\t\t\tobj1.selectedIndex=-1;\n\n\t\t\t\t\t\t\tif(containMenu(obj,val)==false)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\toOption.text=txt;\n\t\t\t\t\t\t\t\t\tval=menu_detail_form.Menu.value + \"#\" +\tval;\n\t\t\t\t\t\t\t\t\toOption.value=val;\n\t\t\t\t\t\t\t\t\tindex=menu_detail_form.MainMenus.length;\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,index);\n\t\t\t\t\t\t\t\t\tvar arr=val.split(\"#\");\n\t\t\t\t\t\t\t\t\tvar menu_id=arr[3];\n\t\t\t\t\t\t\t\t\tPass2MsgFrm(2,menu_id,index);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t\tif(obj2.selectedIndex != -1)\n\t\t\t\t\t{\n\t\t\t\t\t\t\tindex=obj2.selectedIndex;\n\t\t\t\t\t\t\tval=obj2.options[index].value;\n\t\t\t\t\t\t\ttxt=spc+ obj2.options[index].text;\n\t\t\t\t\t\t\tobj2.selectedIndex=-1;\n\t\t\t\t\t\t\tindex=menu_detail_form.MainMenus.selectedIndex;\n\t\t\t\t\t\t\tvar menu_id=menu_detail_form.Menu.value;\n\t\t\t\t\t\t\tvar obj=menu_detail_form.MainMenus;\n\t\t\t\t\t\t\tvar len=obj.length;\n\t\t\t\t\t\t\tvar newindex=obj.selectedIndex;\n\n\t\t\t\t\t\t\tif(containFunction(obj,val,newindex)==false)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(len==1)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tif(newindex==0 || newindex== -1)\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar val1=obj.options[0].value;\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar arr=val1.split(\"#\");\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(arr[4]==\"M\") menu_id=arr[3];\n\t\t\t\t\t\t\t\t\t\t\t\t\telse menu_id=arr[0];\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if(len==0)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tmenu_id=menu_detail_form.Menu.value;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tif(newindex==-1)\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar val1=obj.options[len-1].value;\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar arr=val1.split(\"#\");\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(arr[4]==\"M\") menu_id=arr[3];\n\t\t\t\t\t\t\t\t\t\t\t\t\telse menu_id=arr[0];\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\telse if(newindex==0)\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tmenu_id=menu_detail_form.Menu.value;\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar val1=obj.options[newindex-1].value;\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar arr=val1.split(\"#\");\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(arr[4]==\"M\") menu_id=arr[3];\n\t\t\t\t\t\t\t\t\t\t\t\t\telse menu_id=arr[0];\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\toOption.text=txt;\n\t\t\t\t\t\t\t\t\toOption.value=menu_id + \"#\" + val;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,0);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tDelDummy();\n\t\t\t\t\tEnable_Disable_Buttons();\n\t\t\t}\n\n\t\t\tfunction Enable_Disable_Buttons()\n\t\t\t{\n\t\t\t\t    var mainobject=menu_detail_form.MainMenus.value;\n\t\t\t\t\tvar main_menu = mainobject.substring(0,mainobject.indexOf(\"#\"));\n\t\t\t\t\tvar type = mainobject.charAt(mainobject.length-1);\n\n\t\t\t\t\tif(main_menu == \"\" || main_menu==\"DUMMY\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.getElementById(\'Up\').disabled==true)\n\t\t\t\t\t\t\t{\n\t\t\t\t  \t\t\t\t \tparent.document.f_query_add_mod.document.getElementById(\'Up\').disabled=false;\n\t\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Down\').disabled=false;\n\t\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Del\').disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse if(main_menu == document.getElementById(\'Menu\').value && type == \"F\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.getElementById(\'Up\').disabled==true)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Up\').disabled=false;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Down\').disabled=false;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Del\').disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}else if(main_menu == document.getElementById(\'Menu\').value && type == \"P\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.getElementById(\'Up\').disabled==true)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Up\').disabled=false;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Down\').disabled=false;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Del\').disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse if(main_menu == document.getElementById(\'Menu\').value && type == \"R\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.getElementById(\'Up\').disabled==true)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Up\').disabled=false;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Down\').disabled=false;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Del\').disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse if(type == \"M\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.getElementById(\'Up\').disabled==true)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Up\').disabled=false;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Down\').disabled=false;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Del\').disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{ \n\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.getElementById(\'Up\').disabled==false)\n\t\t\t\t\t\t{      \n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Up\').disabled=true;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Down\').disabled=true;\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Del\').disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction AddDummy() {\n\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\toOption.text=\" \";\n\t\t\t\toOption.value=\"DUMMY\";\n\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption);\n\t\t\t}\n\n\t\t\tfunction DelDummy() {\n\n\t\t\t\tvar obj=menu_detail_form.MainMenus;\n\t\t\t\tif(obj.length > 0 ) {\n\t\t\t\t\tfor(var i=0;i<obj.length;i++) {\n\t\t\t\t\t\tif(obj.options[i].value==\"DUMMY\") {\n\t\t\t\t\t\t\tobj.remove[i];\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction containFunction(obj,val,index) {\n\t\t\t\tvar temp;\n\t\t\t\tvar val1;\n\t\t\t\tvar val2;\n\t\t\t\tvar val3;\n\t\t\t\tif(obj.length!=0) {\n\t\t\t\t\tif(index == -1) {\n\t\t\t\t\t\ttemp=obj.options[obj.length-1].value;\n\t\t\t\t\t\tvar arr=temp.split(\"#\");\n\t\t\t\t\t\tval1=arr[0] + \"#\"  + val;\n\t\t\t\t\t}\n\t\t\t\t\telse\tif(index == 0) {\n\t\t\t\t\t\ttemp=obj.options[0].value;\n\t\t\t\t\t\tvar arr=temp.split(\"#\");\n\t\t\t\t\t\tval1=arr[0] + \"#\"  + val;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\ttemp=obj.options[index-1].value;\n\t\t\t\t\t\tvar arr=temp.split(\"#\");\n\t\t\t\t\t\tval1=arr[0] + \"#\"  + val;\n\n\t\t\t\t\t}\n\n\t\t\t\t\tfor(var n=0;n<obj.length;n++) {\n\t\t\t\t\t\tvar temp1=obj.options[n].value;\n\t\t\t\t\t\tvar arr1=temp1.split(\"#\");\n\t\t\t\t\t\tval3=arr1[0]+ \"#\"  + val;\n\n\t\t\t\t\t\tif(arr[0]==arr1[0] && val1==temp1) return true;\n\t\t\t\t\t\telse if(val3==temp1) return true;\n\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tfunction containMenu(obj,val) {\n\t\t\t\tvar val1=menu_detail_form.Menu.value + \"#\" +  val;\n\t\t\t\tfor(var n=0;n<obj.length;n++) {\n\t\t\t\tvar arr2=val1.split(\"#\");\n\t\t\t\tval2=arr2[3];\n\t\t\t\tvar arr3=(obj.options[n].value).split(\"#\");\n\t\t\t\tval3=arr3[3];\n\n\t\t\t\t\tif(obj.options[n].value==val1) return true;\n\t\t\t\t\telse if (val2==val3) return true;\n\t\t\t\t}\n\t\t\t\treturn false;\n\t\t\t}\n\n\n\t\t\tfunction moveoption(num)\n\t\t\t{\n\t\t\t\t    sel_ind =menu_detail_form.MainMenus.selectedIndex;\n\t\t\t\t\tif(num==1)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(sel_ind !=0 && sel_ind !=-1)\n                        {\n\t\t\t\t\t\t\tvar obj=menu_detail_form.MainMenus;\n\t\t\t\t\t        index=obj.selectedIndex;\n\t\t\t\t\t        val=obj.options[index].value;\n\t\t\t\t\t        txt=obj.options[index].text;\n\t\t\t\t\t        var arr = val.split(\"#\");\n\n\t\t\t\t\t\tvar prev_ind = menu_detail_form.MainMenus.selectedIndex;\n\t\t\t\t\t\tvar prev_val = document.menu_detail_form.MainMenus.options[prev_ind-1].value;\n\t\t\t\t\t\tvar s_menu = prev_val.substring(0,prev_val.indexOf(\"#\"));\n\t\t\t\t\t\tvar cur_val = menu_detail_form.MainMenus.value;\n\t\t\t\t\t    var opt_type = cur_val.charAt(cur_val.length-1);\n\t\t\t\t\t\tvar temp = \"N\";\n\n\t\t\t\t\t\tif( s_menu != document.getElementById(\'Menu\').value &&  opt_type == \"M\" )\n\t\t\t\t\t\t   temp = \"Y\";\n\n\t\t\t\t\t\tif( s_menu == \"DUMMY\" &&  opt_type == \"M\")\n\t\t\t\t\t\t   temp = \"N\";\n\n\t\t\t\t\t\tif( s_menu == \"DUMMY\" &&  opt_type == \"F\")\n\t\t\t\t\t\t   temp = \"Y\";\n\t\t\t\t\t\tif( s_menu == \"DUMMY\" &&  opt_type == \"P\")\n\t\t\t\t\t\t   temp = \"Y\";\n\n\t\t\t\t\t\tif( s_menu == document.getElementById(\'Menu\').value &&  opt_type == \"F\")\n\t\t\t\t\t\t   temp = \"Y\";\n\t\t\t\t\t\tif( s_menu == document.getElementById(\'Menu\').value &&  opt_type == \"R\")\n\t\t\t\t\t\t   temp = \"Y\";   \n\t\t\t\t\t\tif( s_menu == document.getElementById(\'Menu\').value &&  opt_type == \"P\")\n\t\t\t\t\t\t   temp = \"Y\";\n\n\t\t\t\t\t\tif(temp == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(index > 0)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif((arr[4]==\"F\" )||(arr[4]==\"R\" ))\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj.remove(index);\n\t\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\toOption.text=txt;\n\t\t\t\t\t\t\t\t\t\toOption.value=val;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,index-1);\n\t\t\t\t\t\t\t\t\t\tobj.options[index-1].selected=true;\n\t\t\t\t\t\t\t\t}else if(arr[4]==\"P\" )\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj.remove(index);\n\t\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\toOption.text=txt;\n\t\t\t\t\t\t\t\t\t\toOption.value=val;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,index-1);\n\t\t\t\t\t\t\t\t\t\tobj.options[index-1].selected=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar endindex;\n\t\t\t\t\t\t\t\t\t\tif(index==obj.length-1) endindex=obj.length-1;\n\t\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tfor(var i=index+1;i<obj.length;i++)\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tval=obj.options[i].value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\ttxt=obj.options[i].text;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar arr1 = val.split(\"#\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(arr1[4] ==\"M\")\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tendindex=i;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tendindex=obj.length;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tvar moveindex;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="\t\t\tfor(var m=index-1;m>=0;m--)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tval=obj.options[m].value;\n\t\t\t\t\t\t\t\t\t\t\t\ttxt=obj.options[m].text;\n\t\t\t\t\t\t\t\t\t\t\t\tvar arr2 = val.split(\"#\");\n\t\t\t\t\t\t\t\t\t\t\t\tif(arr2[4] ==\"M\")\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tmoveindex=m;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tmoveindex=0;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tvar selectindex=moveindex;\n\t\t\t\t\t\t\t\t\t\tif(index==obj.length-1)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\t\t\toOption.text=obj.options[index].text;\n\t\t\t\t\t\t\t\t\t\t\t\toOption.value=obj.options[index].value;\n\t\t\t\t\t\t\t\t\t\t\t\tobj.remove(index);\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,moveindex);\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tfor(var n=index;n<endindex;n++)\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption.text=obj.options[n].text;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption.value=obj.options[n].value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tobj.remove(n);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,moveindex);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tmoveindex++;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tobj.options[selectindex].selected=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(sel_ind != menu_detail_form.MainMenus.options.length-1 && sel_ind !=-1)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar obj=menu_detail_form.MainMenus;\n\t\t\t\t\t        index=obj.selectedIndex;\n\t\t\t\t\t        val=obj.options[index].value;\n\t\t\t\t\t        txt=obj.options[index].text;\n\t\t\t\t\t\t\tvar arr = val.split(\"#\");\n\n\t\t\t\t\t\t    var next_ind = menu_detail_form.MainMenus.selectedIndex;\n\t\t\t\t\t\t    var next_val = document.menu_detail_form.MainMenus.options[next_ind+1].value;\n\t\t\t\t\t\t    var temp_ind;\n\n\t\t\t\t\t\tif(next_val.charAt(next_val.length-1) != \"M\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(index < obj.length-1)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif((arr[4]==\"F\")||(arr[4]==\"R\"))\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj.remove(index);\n\t\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\toOption.text=txt;\n\t\t\t\t\t\t\t\t\t\toOption.value=val;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,index+1);\n\t\t\t\t\t\t\t\t\t\tobj.options[index+1].selected=true;\n\t\t\t\t\t\t\t\t} else if(arr[4]==\"P\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj.remove(index);\n\t\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\toOption.text=txt;\n\t\t\t\t\t\t\t\t\t\toOption.value=val;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,index+1);\n\t\t\t\t\t\t\t\t\t\tobj.options[index+1].selected=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar endindex;\n\t\t\t\t\t\t\t\t\t\tfor(var i=index+1;i<obj.length;i++)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tval=obj.options[i].value;\n\t\t\t\t\t\t\t\t\t\t\t\ttxt=obj.options[i].text;\n\t\t\t\t\t\t\t\t\t\t\t\tvar arr1 = val.split(\"#\");\n\t\t\t\t\t\t\t\t\t\t\t\tif(arr1[4] ==\"M\")\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tendindex=i;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tendindex=obj.length;\n\t\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\t\tvar moveindex;\n\t\t\t\t\t\t\t\t\t\tif(endindex==obj.length-1)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tfor(var n=index;n<endindex;n++)\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption.text=obj.options[index].text;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption.value=obj.options[index].value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tobj.remove(index);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,endindex+1);\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tif(endindex < obj.length-1)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tfor(var m=endindex+1;m<obj.length;m++)\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tval=obj.options[m].value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\ttxt=obj.options[m].text;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar arr2 = val.split(\"#\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(arr2[4] ==\"M\")\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmoveindex=m;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tmoveindex=obj.length;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tvar selectindex=moveindex;\n\t\t\t\t\t\t\t\t\t\t\t\tfor(var n=index;n<endindex;n++)\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption.text=obj.options[index].text;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\toOption.value=obj.options[index].value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tobj.remove(index);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'MainMenus\').add(oOption,moveindex-1);\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tobj.options[endindex].selected=true;\n\n\t\t\t\t\t\t\t\t\t\t\t\tvar present_index = menu_detail_form.MainMenus.selectedIndex;\n\n\t\t\t\t\t\t\t\t\t\t\t\tfor(i=present_index;i>0;--i)\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t     if(menu_detail_form.MainMenus.value.charAt(menu_detail_form.MainMenus.value.length-1) == \"M\")\n\t\t\t\t\t\t\t\t\t\t\t\t     {\n\t\t\t\t\t\t\t\t\t\t\t\t        \tmenu_detail_form.MainMenus(i+1).selected=true;\n\t\t\t\t\t\t\t\t\t\t\t\t        \tbreak;\n\t\t\t\t\t\t\t\t\t\t\t\t \t }\n\t\t\t\t\t\t\t\t\t\t\t\t \t else\n\t\t\t\t\t\t\t\t\t\t\t\t \t {        menu_detail_form.MainMenus(i).selected=true;   }\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t \n            }\n\t\t\tfunction Delete(ind) {\n\t\t\t\tif(parent.f_query_add_mod.document.menu_detail_form.MainMenus.selectedIndex !=-1)\n\t\t\t\t{\n                obj = parent.f_query_add_mod.document.menu_detail_form.MainMenus;\n                if(ind == \'\' || ind==null)\n\t\t\t\t\tindex=obj.selectedIndex;\n\t\t\t\telse\n\t\t\t\t\tindex = eval(ind);\n\t\t\t\tval=obj.options[index].value;\n\t\t\t\ttxt=obj.options[index].text;\n\t\t\t\t\n\t\t\t\tvar arr = val.split(\"#\");\n\n\t\t\t\tif(arr[4]==\"F\" || arr[4]==\"R\" || arr[4]==\"P\")   {\n\t\t\t\t\tobj.remove(index);\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\t\n\t\t\t\t\tvar endindex;\n\t\t\t\t\tif(index==obj.length-1) obj.remove(index);\n\t\t\t\t\telse {\n\t\t\t\t\t\t\n\t\t\t\t\t\tfor(var i=index+1;i<obj.length;i++) {\n\t\t\t\t\t\t\tval=obj.options[i].value;\n\t\t\t\t\t\t\ttxt=obj.options[i].text;\n\t\t\t\t\t\t\tvar arr1 = val.split(\"#\");\n                            if(arr1[4] ==\"M\") {\n\t\t\t\t\t\t\t\tendindex=i;\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tendindex=obj.length;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(obj.length==1) obj.remove(0);\n\t\t\t\t\t\telse {\n\t\t\t\t\t\n\t\t\t\t\t\t\tfor(var n=index;n<endindex;n++) obj.remove(index);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\t}\n\n\t\t\tfunction hidelist()\n\t\t\t{\n\t\t\t\tmenu_detail_form.hiddenlist.style.visibility=\'hidden\';\n\n\t\t\t}\n\n\t\t\tfunction hiddenlistassign()\n\t\t\t{\n\t\t\t\t\tvar menu_func_chk=0;\n\t\t\t\t\tvar mainobj=menu_detail_form.MainMenus;\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tvar hddnobj=menu_detail_form.hiddenlist;\n\t\t\t\t\tvar len=hddnobj.length;\n\t\t\t\t\tfor(var j=0;j<len;j++) hddnobj.remove(0);\n\t\t\t\t\t\n\t\t\t\t\tif(mainobj.length > 0)\n\t\t\t\t\t{\n\t\t\t\t\t\t\tvar option_sequence=0;\n\t\t\t\t\t\t\tvar srl_no=0;\n\t\t\t\t\t\t\tvar menu_id=menu_detail_form.Menu.value;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar tempmenu_id;\n\t\t\t\t\t\t\tvar rootmenu_id=menu_id;\n\t\t\t\t\t\t\tvar rootmax_no=0;\n\t\t\t\t\t\t\tvar temp1;\n\t\t\t\t\t\t\tvar assignmenu=menu_id;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tfor(var i=0;i<mainobj.length;i++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar temp=mainobj.options[i].value;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar arr=temp.split(\"#\");\n\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(arr[4]==\"M\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\ttemp1=menu_id + \"#\" + arr[1] + \"#\" + arr[2] + \"#\" + arr[3] + \"#\" + arr[4] ;\n\t\t\t\t\t\t\t\t\t\tassignmenu=arr[3];\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if(arr[4]==\"F\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\ttemp1=assignmenu + \"#\" + arr[1] + \"#\" + arr[2] + \"#\" + arr[3] + \"#\" + arr[4];\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if(arr[4]==\"R\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\ttemp1=assignmenu + \"#\" + arr[1] + \"#\" + arr[2] + \"#\" + arr[3] + \"#\" + arr[4];\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}else if(arr[4]==\"P\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\ttemp1=assignmenu + \"#\" + arr[1] + \"#\" + arr[2] + \"#\" + arr[3] + \"#\" + arr[4];\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\ttemp1=\"\";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tmainobj.options[i].value=temp1;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar plen=mainobj.length\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tfor(var zz=0;zz<plen;zz++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\toOption = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\toOption.text=mainobj.options[zz].text;\n\t\t\t\t\t\t\t\t\tvar temp=mainobj.options[zz].value;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar arr=temp.split(\"#\");\n\n\t\t\t\t\t\t\t\t\toption_sequence++;\n\t\t\t\t\t\t\t\t\tsrl_no++;\n\t\t\t\t\t\t\t\t\tif( tempmenu_id !=arr[0] )\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tif( rootmenu_id !=arr[0] )\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\toption_sequence = 1;\n\t\t\t\t\t\t\t\t\t\t\t\t\tsrl_no = 1;\n\t\t\t\t\t\t\t\t\t\t\t\t\ttempmenu_id=arr[0];\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\tif(rootmenu_id==arr[0])\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\trootmax_no++;\n\t\t\t\t\t\t\t\t\t\t\toption_sequence=rootmax_no;\n\t\t\t\t\t\t\t\t\t\t\tsrl_no=rootmax_no;\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\tif(arr[4]==\"M\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t  \tmenu_func_chk = 1;\n\t\t\t\t\t\t\t\t\t\t  \ttemp1=arr[0] + \" # \" + arr[1] + \" # \" + arr[2] + \" # \" + arr[3] + \" # \" + arr[4] + \" # \" + option_sequence + \" # \" + srl_no;\n\t\t\t\t\t\t\t\t\t\t\toOption.value=temp1;\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'hiddenlist\').add(oOption,zz);\n\t\t\t\t\t\t\t\t\t\t\thddnobj.options[hddnobj.length-1].selected=true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tif(menu_func_chk == 0)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\ttemp1=arr[0] + \" # \" + arr[1] + \" # \" + arr[2] + \" # \" + arr[3] + \" # \" + arr[4] + \" # \" + option_sequence + \" # \" + srl_no;\n\t\t\t\t\t\t\t\t\t\t\toOption.value=temp1;\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'hiddenlist\').add(oOption,zz);\n\t\t\t\t\t\t\t\t\t\t\thddnobj.options[zz].selected=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\tif(document.getElementById(\'hiddenlist\').value == \'\' || document.getElementById(\'hiddenlist\').value == null){\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\treturn true;\n\n\t\t\t}\n\n\n\t\t\tfunction Pass2MsgFrm(num,menu_id,index)\n\t\t\t{   \n\t\t\t   \n\t\t\t\tif(parent.document.f_query_add_mod.document.getElementById(\'Menu\').value==\"\")\n\t\t\t\t{\n\t\t\t\t//\tparent.document.f_query_add_mod.document.forms[0].Preview.disabled=true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t//\tparent.document.f_query_add_mod.document.forms[0].Preview.disabled=false;\n\t\t\t\t}\n\t\t\t\tvar n=0;\n\t\t\t\tvar i=0;\n\t\t\t\tvar HTMLVal = new String();\n\t\t\t\tvar m = document.getElementById(\'Menu\').value;\n\t\t\t\tif(m != \"\"){\n\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Module\').disabled=false;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t\t\n\t\t\t\t\t\tn=parent.document.f_query_add_mod.document.getElementById(\'MainMenus\').options.length;\n\t\t\t\t\t\tfor(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById(\'MainMenus\').remove(\"MainMenus\");\n\t\t\t\t\t\tn=parent.document.f_query_add_mod.document.getElementById(\'SubMenus\').options.length;\n\t\t\t\t\t\tfor(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById(\'SubMenus\').remove(\"SubMenus\");\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Module\').options[0].selected = true;\t\n\t\t\t\t\t\tn=parent.document.f_query_add_mod.document.getElementById(\'Functions\').options.length;\n\t\t\t\t\t\tfor(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById(\'Functions\').remove(\"Functions\");\n\t\t\t\t\t\tparent.document.f_query_add_mod.documentElementById(\'Module\').disabled=true;\n\t\t\t\t}\n\t\t\t\tif(m != \"\"){\n\t\t\t\tif(num==1 ) {\n\n\n\t\t\t\t\tval = parent.document.f_query_add_mod.document.getElementById(\'Menu\').value ;\n\t\t\t\t    parent.document.f_query_add_mod.document.getElementById(\'prev_menu\').value = val;\n\n\t\t\t\t\tif(parent.document.f_query_add_mod.document.getElementById(\'Up\').disabled==true)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Up\').disabled=false;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Down\').disabled=false;\n\t\t\t\t\t\tparent.document.f_query_add_mod.document.getElementById(\'Del\').disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tn=parent.document.f_query_add_mod.document.getElementById(\'MainMenus\').options.length;\n\t\t\t\t\tfor(i=0;i<n;i++) parent.document.";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block8_2 ="f_query_add_mod.document.getElementById(\'MainMenus\').remove(\"MainMenus\");\n\t\t\t\t\tn=parent.document.f_query_add_mod.document.getElementById(\'SubMenus\').options.length;\n\t\t\t\t\tfor(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById(\'SubMenus\').remove(\"SubMenus\");\n\t\t\t\t\tnum=\"seven\";\n\t\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\txmlStr =\"<root><SEARCH Chksrc=\\\"\"+num+\"\\\" Common_Text=\\\"\"+document.getElementById(\'Menu\').value+\"\\\"  /></root>\"\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"GetValues.jsp\",false)\n\n\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\t\tresponseText = trimString(responseText)\t\t\t\t\t\n\t\t\t\t\teval(responseText);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(num==2) {\n\t\t\t\t\tnum=\"nine\";\n\t\t\t\t\t\n\t\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\t\n\t\t\t\t\txmlStr =\"<root><SEARCH Chksrc=\\\"\"+num+\"\\\" Index=\\\"\"+index+\"\\\" Common_Text=\\\"\"+menu_id+\"\\\"  /></root>\"\n\t\t\t\t\t\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\n\t\t\t\t\txmlHttp.open(\"POST\",\"GetValues.jsp\",false)\n\t\t\t\t\t\n\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\t\t\n\t\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\t\t\t\n\t\t\t\t\tresponseText = trimString(responseText)\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\teval(responseText);\n\t\t\t\t}\n\t\t\t\tif(num==3) {\n\t\t\t\t\tn=parent.document.f_query_add_mod.document.getElementById(\'Functions\').options.length;\n\t\t\t\t\tfor(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById(\'Functions\').remove(\"Functions\");\n\t\t\t\t\tnum=\"eight\";\n\t\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\txmlStr =\"<root><SEARCH Chksrc=\\\"\"+num+\"\\\" menuID=\\\"\"+document.getElementById(\'Menu\').value+\"\\\" Common_Text=\\\"\"+document.getElementById(\'Module\').value+\"\\\"  /></root>\"\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"GetValues.jsp\",false)\n\n\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\t\tresponseText = trimString(responseText)\n\t\t\t\t\teval(responseText);\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body  OnMouseDown=\"CodeArrest()\" onLoad=\"Focusing(\'Menu\');hidelist()\" onKeyDown = \'lockKey()\'>\n\t<form name=\"menu_detail_form\" id=\"menu_detail_form\" action=\"../../servlet/eSM.menuDetailServlet\" method=\"post\" target=\"messageFrame\">\n\t<center><br>\n\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\"BORDER\" width=\"100%\">\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"10%\" class=\"label\">";
    private final static byte[]  _wl_block8_2Bytes = _getBytes( _wl_block8_2 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' width=\"25%\"><Select name=\"Menu\" id=\"Menu\" onChange=\"Pass2MsgFrm(1,\'test\',0)\"><Option value=\"\">----------";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="----------\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t</Select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t\t\t\t\t <td class=\'fields\' width=\"35%\"><input type=\"hidden\" name=\"function\" id=\"function\" value=\"insert\"><Select name=\"hiddenlist\" id=\"hiddenlist\" size=\"1\" multiple=\'true\'></Select>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"BORDER\" width=\"100%\">\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th  width=\"25%\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t\t<th align=\"left\" width=\"25%\" colspan=\"1\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'fields\' width=\"25%\">&nbsp;&nbsp;&nbsp;&nbsp;<Select name=\"SubMenus\" id=\"SubMenus\" size=\"5\" style=\"HEIGHT: 160px; WIDTH: 320px\" onClick=\"globalIndex(1)\"></Select></td>\n\t\t\t\t\t\t<td class=\'fields\' width=\"60%\" rowspan=\"5\" valign=\"top\"><Select name=\"MainMenus\" id=\"MainMenus\" size=\"15\" style=\"HEIGHT: 360px; WIDTH: 280px\" onClick=\"Drag(this)\"></Select></td>\n\t\t\t\t\t\t<td width=\"5%\" class=\"fields\" valign=\"bottom\"><input type=\'button\' name=\'Up\' id=\'Up\' class=\"Button\" onclick=\"moveoption(1)\" value=\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="      \'> </td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"25%\" class=\"fields\" ><span class=\'label\' width=\"25%\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>&nbsp;&nbsp;<Select name=\"Module\" id=\"Module\" onChange=\"Pass2MsgFrm(3,\'test\',0)\" disabled><Option value=\"\">------------- ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="------------\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t</Select></td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"5%\"> <input type=\'button\' name=\'Down\' id=\'Down\' class=\"Button\" onclick=\"moveoption(2)\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="   \' > </td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th  >&nbsp;&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t\t\t\t<td class=\"fields\" width=\"5%\"> <input type=\'button\' name=\'Del\' id=\'Del\' class=\"Button\" onclick=\"Delete()\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'> </td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"60%\" class=\'fields\' valign=\"bottom\">&nbsp;<Select name=\"Functions\" id=\"Functions\" size=\"5\" style=\"HEIGHT: 160px; WIDTH: 267px\"  onClick=\"globalIndex(2);\"></Select></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr><td>&nbsp;</td></tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<input type=\"hidden\" name=\"prev_menu\" id=\"prev_menu\" value =\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n\t<input type=\"hidden\" name=\"root_menu\" id=\"root_menu\" value =\'\' >\n\t<input type=\"hidden\" name=\"norows\" id=\"norows\" value =\'Y\' >\n\t</center>\n\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con=null;
	Statement stmt = null;
	Statement stmtnew = null;
			try{
			request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rset=null;
	String prev_menu=request.getParameter("menu");
	String Log_user= (String) session.getAttribute("login_user");
	if(prev_menu == null) prev_menu="";
	String responsibility_id= (String) session.getAttribute("responsibility_id");
	//String Role="";
	StringBuffer sqlMenu=new StringBuffer();
	String sql_module="";
	
	
	/*int Medadmin=0;

	String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";
	
	rset=stmt.executeQuery(sql);
	if (rset !=null){
		while (rset.next()){
					Medadmin=Integer.parseInt(rset.getString(1));
			}
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	}

	String sqlResp="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"'";
	
	stmt = con.createStatement();
	rset=stmt.executeQuery(sqlResp);
	if (rset !=null){
		while (rset.next()){
					Role=rset.getString(1);
					if(Role==null) Role="";
		}
	if(rset!=null) rset.close();
	}*/
//add condition(sys_defined_yn='N') in query by Senthil on 10-Oct-2011 for this incident[IN:027210] 
	//if (Role.equalsIgnoreCase("MEDADMIN"))
	sqlMenu.append("SELECT MENU_ID,MENU_NAME FROM sm_menu_hdr WHERE sys_defined_yn='N' AND (ADHOC_MENU_YN='N' OR TRUNC(SYSDATE) BETWEEN Nvl(ADHOC_MENU_EFF_FROM,TRUNC(SYSDATE)) AND NVL(ADHOC_MENU_EFF_TO ,TRUNC(SYSDATE)) AND sys_defined_yn='N')ORDER BY menu_name ");


/*else if (Medadmin==1)
{
	sqlMenu.append("Select menu_id,menu_name from sm_menu_hdr  where resp_group_id  in");
	sqlMenu.append("(Select resp_group_id   from sm_menu_admin  where ");
	sqlMenu.append(" menu_admin_id  ='"+Log_user+"' ) order by menu_name " );
}*/

            _bw.write(_wl_block6Bytes, _wl_block6);

        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            _bw.write(_wl_block8_2Bytes, _wl_block8_2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

							try {
							   
								rs=stmt.executeQuery(sqlMenu.toString());
								if(rs!=null) {
									while(rs.next()) {
										String menu_id=rs.getString("menu_id")==null ? "" : rs.getString("menu_id");
										String menu_name=rs.getString("menu_name")==null ? "" : rs.getString("menu_name");
					//modified below line by Senthil on 10-Oct-2011 for this incident[IN:027210] 					
					out.println("<Option value='" + menu_id + "'>" + menu_name+" ["+menu_id+"]");
									}
								}
								if(rs!=null) rs.close();
								//if(stmt!=null) stmt.close();
							}catch(Exception e) {}
						
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

							try {
									String resp_group_id="";
								//	if (Role.equalsIgnoreCase("MEDADMIN")) // sys admin
										sql_module="Select  a.module_id,a.module_name from sm_module a  where a.install_yn='Y'  order by a.module_name";

								/*	else if (Medadmin==1)	// menu admin
									{
										 stmtnew=con.createStatement();
										String sql_new=" Select resp_group_id from sm_menu_admin where menu_admin_id='"+Log_user+"' "; 
										ResultSet rsnew=stmtnew.executeQuery(sql_new);
										if(rsnew!=null)
										{
											while(rsnew.next())
											{
												resp_group_id=rsnew.getString("resp_group_id");
												if(resp_group_id==null) resp_group_id="";
											}
										}
										if (rsnew!=null) rsnew.close();
										sql_module=" Select distinct a.module_id,a.module_name from sm_module a, sm_func_by_resp_grp b where a.install_yn='Y' and a.module_id=b.module_id and		b.resp_group_id = '"+resp_group_id+"' order by a.module_name";
									}*/
									 //System.out.println("sql_moduolle--->"+sql_module);//sel
								rs1=stmt.executeQuery(sql_module);
								if(rs1!=null) {
									while(rs1.next()) {
										String module_id=rs1.getString("module_id")==null ? "" : rs1.getString("module_id");
										String module_name=rs1.getString("module_name")==null ? "" : rs1.getString("module_name");
								
						out.println("<Option value='" + module_id + "'>" + module_name);
									}
								}
								//if(rs !=null) rs.close();
								if(rs1 !=null) rs1.close();
								if(stmt !=null) stmt.close();
								if(stmtnew !=null) stmtnew.close();

							}catch(Exception e) {}
							
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(prev_menu));
            _bw.write(_wl_block21Bytes, _wl_block21);

	}catch(Exception e){//out.println(e);
		e.printStackTrace();
	}
	finally { 
		
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.menu.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ListofSubmenus.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.menu.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Up.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Module.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.down.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ListofFunctions.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
