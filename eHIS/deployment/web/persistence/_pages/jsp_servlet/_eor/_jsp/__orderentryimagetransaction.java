package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __orderentryimagetransaction extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryImageTransaction.jsp", 1740484774000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="<!--IN072524-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<SCRIPT>\n//b\t\t\t\t\t= (document.all)?1:0;\nb\t\t\t\t\t= (document.getElementById)?1:0;\nvar pos\t\t\t\t= new Array();\nvar pos1\t\t\t= new Array();\nvar db_values\t\t= new Array();\nvar tmp_spotname\t= new Array();\n\nvar image_id_arr\t= new Array();\nvar hotspot_id_arr\t= new Array();\n \nfunction s(){\n  \tif(!b){\n\t/*\tww=window.innerWidth;\n\t\twh=window.innerHeight;*/\n\t}if(b){\n\t\tww=document.body.offsetWidth;\n\t\twh=document.body.offsetHeight;\n\t}\n\t\n \tcL(\'qD\',0,0,0,0,\'\'+cc+\'*\'+c2+\'\',\"#FF3333\",null,1,\"\",\"\",\"\");\n\tvar y=0;\n   \tfor(var x=0;x<db_values.length;x++){\n\t\t//alert(db_values[x]);\n\t\tvar tmp_values\t\t= db_values[x].split(\"~\");\n\t\tif(tmp_values[2] != \" \"){\n\t\t\ttmp_spotname[y]\t\t= tmp_values[0];\n\t\t\t//pos[y]\t\t\t\t= tmp_values[2];\n\t\t\t//pos1[y]\t\t\t\t= tmp_values[3];\n\t\t\tpos[y]\t\t\t\t= eval(parseInt(tmp_values[2])+2);\n\t\t\t//alert(tmp_values[2]+\"====\"+eval(parseInt(tmp_values[2])+5));\n\t\t\tpos1[y]\t\t\t\t= eval(parseInt(tmp_values[3])-10) ;\n\t\t\timage_id_arr[y]\t\t= tmp_values[4];\n\t\t\thotspot_id_arr[y]   = tmp_values[5];\n\t\t\ty++;\n\t\t}\n\t}\n\tfor(var i=0;i<pos.length;i++){\n\t\tif(pos[i] != \" \"){\n\t\tx_arr[i]=pos[i];y_arr[i]=pos1[i];\t\t\n \t\tcL(\'q\'+i+\'D\',parseInt(eval(pos[i])-2),parseInt(eval(pos1[i])+14),6,6,\'\'+cc+\'*\'+c2+\'\',\"#CC3300\",null,1,tmp_spotname[i], image_id_arr[i], hotspot_id_arr[i]);\n\t\t}\n\t}\n\tkk=0;\n \tfor(var i=0;i<=to;i++){\n\t//\tfor(var j=0;j<o[i].length;j++){\n\t\t\tkk+=1;\n\t\t//\tt=eval(\"o[\"+i+\"].charAt(\"+j+\")\"); \n\t\t\tt=\'\';\n\t\t\teval(\"cL(\'km\"+i+\"D\',0,-50,6,6,\'<font size=3 face=arial color=#FF0033 size=3>\"+t+\"</font>\',\'#FF0033\',null,1,\'\',\'\',\'\');km\"+i+\"=new DL(\'km\"+i+\"D\');\");\n\t//\t}\n\t}\n //\tdocument.getElementById(\"tb1\").onmousedown=mouseDown;\n /*\tvar doc_val=\"document.all.\";\n\tfor(var i =0 ;i<document.getElementById(\"tb1\").rows.length;i++){\n\t\tfor(var j=0;j<document.getElementById(\"tb1\").rows(i).cells.length;j++){\n\t\t\tvar id_val = document.getElementById(\"tb1\").rows(i).cells(j).id;\n  \t\t\tif( id_val != \"\"){\n\t\t\t\teval(doc_val+id_val).onmousedown=mouseDown;\n\t\t\t}\n\t\t}\n\t}\n  */\t\n}\n \n\nfunction cL(id,lf,tp,w,h,c,bg,vi,z,spot_nm,image_id,hotspot_id){\n \tif(!b){\n\t}\n\telse{\n\t\tst=\'\\n<DIV id=\'+id+\' align=\"center\" style=\"position:absolute; left:\'+lf+\'px; top:\'+tp+\'px; width:\'+w;\n\t\tif(h!=null){\n\t\t\tst+=\'; height:\'+h+\'px\';\n\t\t\tst+=\'; clip:rect(0,\'+w+\'px,\'+h+\'px,0)\';\n\t\t}\n \n\t\tif(bg!=null)\t\n\t\t\tst+=\'; background-color:\'+bg;\n\t\tif(z!=null)\n\t\t\tst+=\'; z-index:\'+z;\n\t\tif(vi)\n\t\t\tst+=\'; visibility:\'+vi;\n\t\tst+=\'; \"><a href=\"javascript:callLink(\'+lf+\',\'+tp+\')\" title=\"\'+spot_nm+\'\">\'+((c)?c:\'\')+\'</a></DIV>\';\n \t\tdocument.body.insertAdjacentHTML(\"beforeend\",st);\n \t}\n}\n \nfunction callLink(x_pos,y_pos){\n\tx_pos = parseInt(eval(x_pos)+2);\n\ty_pos = parseInt(eval(y_pos)-14);\n  \tvar x=x_pos;var y= y_pos;\n\tvar tmp_x ;\n\tvar tmp_y ;\n \n\tvar flag = false;\n\tfor(var c=0;c<pos.length;c++){\n\t\ttmp_x\t\t= pos[c];\n\t\ttmp_y\t\t= pos1[c];\n\t\t \n\t\tvar j =0,k=0;\n\t\twhile(j<3){\n\t\t\tk=0;\n\t\t\twhile(k<3){\n\t\t\t\tif( (x == parseInt(eval(tmp_x+j))) && (y == parseInt(eval(tmp_y+k))) ){\n\t\t\t\t\tflag = true;\n\t\t\t\t\tif(flag)\n\t\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\tk++;\n\t\t\t}\n\t\t\tj++;\n\t\t\tif(flag)\n\t\t\t\tbreak;\n\t\t}\n\t}\nvar hotspot_pos = \"NOPOSTN\";var tmp_name_values;var tmp_pos_values;var tmp_xpos_values;var tmp_ypos_values;var image_id,hotspot_id;\nx_pos = eval(parseInt(x_pos)-2);\ny_pos = eval(parseInt(y_pos)+10);\nfor(var x=0;x<db_values.length;x++){\n\tvar tmp_values\t\t= db_values[x].split(\"~\");\n\tvar tmp_xpos_values = tmp_values[2];\n\tvar tmp_ypos_values = tmp_values[3];\n\tvar tmp_ypos_values = tmp_values[3];\n\n \tif(x_pos == tmp_xpos_values && y_pos == tmp_ypos_values){\n\t\thotspot_pos\t\t= tmp_values[1];\n\t\timage_id\t\t= tmp_values[4];\n\t\thotspot_id\t\t= tmp_values[5];\n\t\tbreak;\n\t}\n\t\n}\n \tpopulatePanels(image_id,hotspot_id);\n\t\n \t//parent.frames[1].location.href=\'../../eOR/jsp/ImageHotspotAddModify.jsp?hotspot_pos=\'+hotspot_pos+\'&image_id=\'+document.forms[0].image_id.value+\"&status=modify&function_id=&x_pos=\"+x_pos+\"&y_pos=\"+y_pos;\n\n}\n\nDL.set=false;\nfunction DL(id){\n\n\tif(!DL.set){\n\t\tDLInit();\n\t}if(!b){\n\t\t/*this.css=document.layers[id];\n\t\tthis.elm=this.event=this.css;\n\t\tthis.doc=this.css.document;\n\t\tthis.x=this.css.left;\n\t\tthis.y=this.css.top;*/\n\t}else{\n\t\tthis.elm=this.event=document.all[id];\n\t\tcss=document.all[id].style;\n\t\tthis.doc=document;\n\t\tthis.x=this.elm.offsetLeft;\n\t\tthis.y=this.elm.offsetTop;\n\t}\n\tthis.id=id;\n\tthis.obj=id+\"DL\";\n\teval(this.obj+\"=this\");\n}\n\nfunction DLInit(){\n\tif(!DL.set)\n\t\tDL.set=true;\n\tif(!b){/*\n\t\tref=document;\n\t\tfor(var i=0;i<ref.layers.length;i++){\n\t\t\tdn=ref.layers[i].name;ix=dn.indexOf(\"D\");\n\t\t\tif(ix>0)\n\t\t\t\teval(dn.substr(0,ix)+\' = new DL(\"\'+dn+\'\")\');\n\t\t}*/\n\t}else{\n\t\tfor(var i=0;i<document.getElementsByTagName(\"DIV\").length;i++){\n\t\t\tdn=document.getElementsByTagName(\"DIV\")[i].id;\n\t\t\tix=dn.indexOf(\"D\");\n\t\t\tif(ix>0)\n\t\t\t\teval(dn.substr(0,ix)+\' = new DL(\"\'+dn+\'\")\');\n\t\t}\n\t}\n\treturn true;\n}\n\nfunction DLMoveTo(x,y){\n \tif(x!=null){\n\t\tthis.x=x;\n\t\tif(!b)\n\t\t\tthis.css.left=this.x;\n\t\telse {\n \t\t\tcss.pixelLeft = this.x;\n\t\t}\n\t}\n\tif(y!=null){\n\t\tthis.y=y;\n\t\tif(!b)\n\t\t\tthis.css.top=this.y;\n\t\telse {\n \t\t\tcss.pixelTop=this.y;\n\t\t\t}\n\t}\n\n\t\t\t//parent.frames[1].location.href=\"ImageHotspotAddModify.jsp?hotspot_pos=NOPOSTN&status=insert&function_id=&x_pos=\"+x+\"&y_pos=\"+y;\n\t\n}\nDL.prototype.mTo=DLMoveTo;\n\nfunction DLW(html){\n\tif(!b){\n\t//\tthis.doc.open();\n\t//\tthis.doc.write(html);\n\t//\tthis.doc.close();\n\t}else if(b);\n\t\t \n}\nDL.prototype.write=DLW;\n\nvar\to=new Array();\nfor(var i=0;i<100;i++)\n\to[i]=\"*\";\n\n//var to=100;\nvar to=1;\nvar tt=0;\n//var cc=\"<center><font size=1 face=arial color=red>\";\n//var c2=\"</font></center>\";\n\nvar cc=\"<span style=\'display: flex;justify-content: center; align-items: center; height: 100%;\'><span style=\'font-size: 1em;font-family: Arial, sans-serif; color: red;\'>\";\nvar c2=\"</span></span>\";\n\nvar g=0;\nvar vk=0;\nvar t=\"\";\nvar sp=0;\nvar ak=true;\nvar x_arr = new Array();\nvar y_arr = new Array();\nvar hot=0;\n\n\n/*function mouseDown(e){ \nhot +=1;\nvar x=(!b)?e.pageX:(event.x+document.body.scrollLeft);\nvar y=(!b)?e.pageY:(event.y+document.body.scrollTop);\nvar temp=hot -1;\n\ntemp= x_arr.length;\nx_arr[2]=x;\ny_arr[2]=y;\n \n\nif(ak){\n\tif(g<to){\n\t\tg+=1\n\t\tt=\"\";\n\t\tak=false;\n\t\tq.write(\'\');\n\t\tfor(var i=0;i<=o[vk].length-1;i++){\n\t\t\tsp+=1;\n\t\t\t//v=Math.round(Math.random()*20)+1;\n\t\t\tsetTimeout(\"km\"+sp+\".mTo(\"+x+\",\"+y+\");\",0);\n\t\t}\n\tvk+=1;ak=true;\n \t} \n}\nreturn true;\n}\n*/\n\n</SCRIPT>\n \n\n<style>\n \n\tA:link {\n\t\tCOLOR: blue;\n\t\ttext-decoration : none ;\n\t}\n\tA:visited {\n\t\tCOLOR:blue;\n\t\ttext-decoration : none ;\n\t}\n</style>\n</head>\n<!--bgcolor=\"#E6E6FA\"-->\n<body topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"s()\">\n    <form name=\"image_form\" id=\"image_form\"  method=\"post\" target=\"messageFrame\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<table border=\'0\'>\n\t<tr>\n\t<!--background-color:#E2E3F0;-->\n\t<td nowrap style=\'color=navy;font-size:9pt;border:0\' align=\"left\" colspan=\'2\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t<select name=\"image\" id=\"image\"    width=\"15\"  onChange=\"changeImage(this)\" style=\'font-size:7pt;\'>\n\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ---</option>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</select>\t\n \t</td>\n\t</tr>\n\t<tr>\n\t<td    nowrap style=\'color=navy;font-size:9pt;border:0\' align=\"center\"><input type=radio     name=\"front\" id=\"front\"  onClick=\"changeImage(this)\" style=\"width:10;height:14\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">&nbsp;&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td><td nowrap style=\'color=navy;font-size:9pt;border:0\' align=\"left\"><input type=radio name=\"back\" id=\"back\" style=\"width:10;height:14\" onClick=\"changeImage(this)\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n \t</td>\n\t</tr>\n</table>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<!-- <table border=\"2\"  height = \'100%\'  width=\"92%\"  align=\"left\" style=\'background-position:0px -2px\' background=\"../../eOR/images/";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" bordercolorlight=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" id=\"tb1\" > -->\n\t<table border=\"0\"  style=\"width: 240px;height: 480px; background-position:0px -2px;\" background=\"../../eOR/images/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" bordercolorlight=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" id=\"tb1\" >\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<table border=\"0\"  height = \"86.5%\"  width=\"92%\"  align=\"left\"  background=\"\" bordercolorlight=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" id=\"tb1\" >  <!-- No Image -->\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<!--\n <tr>\n    <td  width=\"6%\">&nbsp;</td>\n    <td  width=\"6%\"  valign=\"bottom\">&nbsp;</td>\n    <td  width=\"6%\"  valign=\"center\">&nbsp;</td>\n    <td  width=\"6%\"  valign=\"center\">&nbsp;</td>\n    <td  width=\"6%\"  id=\"A1\">&nbsp;</td>\n    <td  width=\"6%\"  id=\"A2\">&nbsp;</td>\n    <td  width=\"6%\"  id=\"A3\">&nbsp;</td>\n    <td  width=\"6%\"  id=\"A4\">&nbsp;</td>\n    <td  width=\"6%\">&nbsp;</td>\n    <td  width=\"6%\">&nbsp;</td>\n    <td  width=\"6%\">&nbsp;</td>\n </tr>\n <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"B1\" >&nbsp;</td>\n    <td id=\"B2\" >&nbsp;</td>\n    <td id=\"B3\" >&nbsp;</td>\n    <td id=\"B4\" >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n </tr>\n <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"C1\" >&nbsp;</td>\n    <td id=\"C2\" >&nbsp;</td>\n    <td id=\"C3\" >&nbsp;</td>\n    <td id=\"C5\" >&nbsp;</td>\n    <td id=\"C6\" >&nbsp;</td>\n    <td id=\"C7\" >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n </tr>\n <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td  id=\"D1\" >&nbsp;</td>\n    <td  id=\"D2\" >&nbsp;</td>\n    <td  id=\"D3\" >&nbsp;</td>\n    <td  id=\"D4\" >&nbsp;</td>\n    <td  id=\"D5\" >&nbsp;</td>\n    <td  id=\"D6\" >&nbsp;</td>\n    <td  id=\"D7\" >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"E1\"  >&nbsp;</td>\n    <td id=\"E2\" >&nbsp;</td>\n    <td id=\"E3\" >&nbsp;</td>\n    <td id=\"E4\" >&nbsp;</td>\n    <td id=\"E5\" >&nbsp;</td>\n    <td id=\"E6\" >&nbsp;</td>\n    <td id=\"E7\" >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td id=\"F1\"  >&nbsp;</td>\n    <td id=\"F2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"F3\"  >&nbsp;</td>\n    <td id=\"F4\"  >&nbsp;</td>\n    <td id=\"F5\"  >&nbsp;</td>\n    <td id=\"F6\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"F7\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td id=\"G1\"  >&nbsp;</td>\n    <td id=\"G2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"G3\"  >&nbsp;</td>\n    <td id=\"G4\"  >&nbsp;</td>\n    <td id=\"G5\"  >&nbsp;</td>\n    <td id=\"G6\"  >&nbsp;</td>\n    <td id=\"G7\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"G8\"  >&nbsp;</td>\n    <td id=\"G9\"  >&nbsp;</td>\n   </tr>\n  <tr>\n    <td id=\"H1\"  >&nbsp;</td>\n    <td id=\"H2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"H3\"  >&nbsp;</td>\n    <td id=\"H4\"  >&nbsp;</td>\n    <td id=\"H5\"  >&nbsp;</td>\n    <td id=\"H6\"  >&nbsp;</td>\n    <td id=\"H7\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"H8\"  >&nbsp;</td>\n    <td id=\"H9\"  >&nbsp;</td>\n   </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"I1\"  >&nbsp;</td>\n    <td id=\"I2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"I3\"  >&nbsp;</td>\n    <td id=\"I4\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"J1\"  >&nbsp;</td>\n    <td id=\"J2\"  >&nbsp;</td>\n    <td id=\"J3\"  >&nbsp;</td>\n    <td id=\"J4\"  >&nbsp;</td>\n    <td id=\'J5\'  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"K1\"  >&nbsp;</td>\n    <td id=\"K2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"K3\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"L1\"  >&nbsp;</td>\n    <td id=\"L2\"  >&nbsp;</td>\n    <td id=\"L3\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"L4\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n </tr>\n <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"M1\"  >&nbsp;</td>\n    <td id=\"M2\"  >&nbsp;</td>\n    <td>&nbsp;</td>\n    <td id=\"M3\"  >&nbsp;</td>\n    <td id=\"M4\"  >&nbsp;</td>\n    <td id=\"M5\"  >&nbsp;</td>\n    <td id=\"M6\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n </tr>\n -->\n \n <tr>\n    <td style=\"width: 6%; vertical-align: top;\">&nbsp;</td>\n    <td style=\"width: 6%; vertical-align: bottom;\">&nbsp;</td>\n    <td style=\"width: 6%; vertical-align: middle;\">&nbsp;</td>\n    <td style=\"width: 6%; vertical-align: middle;\">&nbsp;</td>\n    <td style=\"width: 6%;\" id=\"A1\">&nbsp;</td>\n    <td style=\"width: 6%;\" id=\"A2\">&nbsp;</td>\n    <td style=\"width: 6%;\" id=\"A3\">&nbsp;</td>\n    <td style=\"width: 6%;\" id=\"A4\">&nbsp;</td>\n    <td style=\"width: 6%; vertical-align: top;\">&nbsp;</td>\n    <td style=\"width: 6%; vertical-align: top;\">&nbsp;</td>\n    <td style=\"width: 6%; vertical-align: top;\">&nbsp;</td>\n</tr>\n<tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"B1\" >&nbsp;</td>\n    <td id=\"B2\" >&nbsp;</td>\n    <td id=\"B3\" >&nbsp;</td>\n    <td id=\"B4\" >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n </tr>\n <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"C1\" >&nbsp;</td>\n    <td id=\"C2\" >&nbsp;</td>\n    <td id=\"C3\" >&nbsp;</td>\n    <td id=\"C5\" >&nbsp;</td>\n    <td id=\"C6\" >&nbsp;</td>\n    <td id=\"C7\" >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n </tr>\n <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td  id=\"D1\" >&nbsp;</td>\n    <td  id=\"D2\" >&nbsp;</td>\n    <td  id=\"D3\" >&nbsp;</td>\n    <td  id=\"D4\" >&nbsp;</td>\n    <td  id=\"D5\" >&nbsp;</td>\n    <td  id=\"D6\" >&nbsp;</td>\n    <td  id=\"D7\" >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"E1\"  >&nbsp;</td>\n    <td id=\"E2\" >&nbsp;</td>\n    <td id=\"E3\" >&nbsp;</td>\n    <td id=\"E4\" >&nbsp;</td>\n    <td id=\"E5\" >&nbsp;</td>\n    <td id=\"E6\" >&nbsp;</td>\n    <td id=\"E7\" >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td id=\"F1\"  >&nbsp;</td>\n    <td id=\"F2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"F3\"  >&nbsp;</td>\n    <td id=\"F4\"  >&nbsp;</td>\n    <td id=\"F5\"  >&nbsp;</td>\n    <td id=\"F6\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"F7\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td id=\"G1\"  >&nbsp;</td>\n    <td id=\"G2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"G3\"  >&nbsp;</td>\n    <td id=\"G4\"  >&nbsp;</td>\n    <td id=\"G5\"  >&nbsp;</td>\n    <td id=\"G6\"  >&nbsp;</td>\n    <td id=\"G7\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"G8\"  >&nbsp;</td>\n    <td id=\"G9\"  >&nbsp;</td>\n   </tr>\n  <tr>\n    <td id=\"H1\"  >&nbsp;</td>\n    <td id=\"H2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"H3\"  >&nbsp;</td>\n    <td id=\"H4\"  >&nbsp;</td>\n    <td id=\"H5\"  >&nbsp;</td>\n    <td id=\"H6\"  >&nbsp;</td>\n    <td id=\"H7\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"H8\"  >&nbsp;</td>\n    <td id=\"H9\"  >&nbsp;</td>\n   </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"I1\"  >&nbsp;</td>\n    <td id=\"I2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"I3\"  >&nbsp;</td>\n    <td id=\"I4\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"J1\"  >&nbsp;</td>\n    <td id=\"J2\"  >&nbsp;</td>\n    <td id=\"J3\"  >&nbsp;</td>\n    <td id=\"J4\"  >&nbsp;</td>\n    <td id=\'J5\'  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"K1\"  >&nbsp;</td>\n    <td id=\"K2\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"K3\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"L1\"  >&nbsp;</td>\n    <td id=\"L2\"  >&nbsp;</td>\n    <td id=\"L3\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"L4\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n </tr>\n <tr>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td id=\"M1\"  >&nbsp;</td>\n    <td id=\"M2\"  >&nbsp;</td>\n    <td>&nbsp;</td>\n    <td id=\"M3\"  >&nbsp;</td>\n    <td id=\"M4\"  >&nbsp;</td>\n    <td id=\"M5\"  >&nbsp;</td>\n    <td id=\"M6\"  >&nbsp;</td>\n    <td >&nbsp;</td>\n    <td >&nbsp;</td>\n </tr>\n\n</table>\n<script>\n\tdocument.getElementById(\"tb1\").style.backgroundRepeat=\"no-repeat\";\n\tif(document.body.offsetWidth > 240)\n\t{\n\t\t//document.getElementById(\"tb1\").height\t= \"66%\"\n\t\t//document.getElementById(\"tb1\").width\t= \"74%\"\n\t\t//document.getElementById(\"tb1\").height\t= \"55.5%\"\n\t\t//document.getElementById(\"tb1\").width\t= \"70%\"\n\t}\n\tif(document.body.offsetWidth <= 190)\n\t{\n\t\t//document.getElementById(\"tb1\").height\t= \"83%\"\n\t\t//document.getElementById(\"tb1\").width\t= \"98%\"\n\t\t//document.getElementById(\"tb1\").height\t= \"75.5%\"\n\t\t//document.getElementById(\"tb1\").width\t= \"90%\"\n\t}\n\n</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<script>\n\t//var hot_spot_pos = eval(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\");\n\t//var hotspot_id\t = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t//var order_type = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t//hot_spot_pos.innerHTML=\"<a href=\'javascript:populatePanels(\\\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\\\",\\\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\\\")\'><font color=\'ORANGERED\'>*</font></a>\";\n\t//hot_spot_pos.title= \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\n//alert(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\")\n//alert(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\")\n \tdb_values[\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"] = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"+\"~\"+\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\n\n</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<input type=\"hidden\" name=\"order_category_yn\" id=\"order_category_yn\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"><!--//bean.getOrderCategoryYn()-->\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\"hidden\" name=\"order_type_code\" id=\"order_type_code\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\"hidden\" name=\"activity_type\" id=\"activity_type\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type=\"hidden\" name=\"order_category_yn\" id=\"order_category_yn\"\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<input type=\"hidden\" name=\"order_type_yn\" id=\"order_type_yn\"\t\tvalue=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<input type=\"hidden\" name=\"priv_applicable_yn\" id=\"priv_applicable_yn\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</form>\n</body>\n\n</html>\n\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            eOR.OrderEntryQueryBean bean= null;{
                bean=(eOR.OrderEntryQueryBean)pageContext.getAttribute("bean");
                if(bean==null){
                    bean=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("bean",bean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 				= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
//	String disableOrderCategory = "";
//	String disableOrderType		= "";
	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 

            _bw.write(_wl_block6Bytes, _wl_block6);

	//String image_position = bean.checkForNull(request.getParameter("image_position"),"FRNT");
	String image_url 		= bean.checkForNull(request.getParameter("image_url"),"skeleton_front.gif");
	String image_id 		= bean.checkForNull(request.getParameter("image_id"),"");
	String image_link_id 	= bean.checkForNull(request.getParameter("image_link_id"),"");
	
 	String order_category 	= bean.checkForNull(request.getParameter("order_category"),"");
	String order_type_code 	= bean.checkForNull(request.getParameter("order_type_code"),"");
	String activity_type 	= bean.checkForNull(request.getParameter("activity_type"),"");
	String order_category_yn= bean.checkForNull(request.getParameter("order_category_yn"),"");
	String order_type_yn	= bean.checkForNull(request.getParameter("order_type_yn"),"");
	String priv_applicable_yn	= bean.checkForNull(request.getParameter("priv_applicable_yn"),"");
	OrderEntryBean bean1					= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;//IN072524
	String fpp_patient_yn =bean1.getFpp_patient_yn();//IN072524 Starts
	//String hotspot			= order_category+image_position;
    //String tick_sheet_id	= "";
 	String hotspot_name		= "";
	String hotspot_id		= "", hotspot_pos		= "";
	String hotspot_xpos		= "", hotspot_ypos		= "";
	
	if(image_id.equals("") && !order_category.equals(""))
		image_id  = order_category+"FRNT";
	
//out.println("order_category=="+order_category+"=="+image_id);
//out.println("BACK=="+image_id.indexOf("BACK"));
  	String[] record			= null;

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

			
			bean.setLanguageId(localeName);

		//ArrayList ImageList = bean.getImageLink(properties,image_id,order_category);
		ArrayList ImageList = bean.getImageLink(properties,image_id,order_category,fpp_patient_yn);//IN072524 
		for(int i=0; i<ImageList.size(); i++)
		{
			record = (String[])ImageList.get(i);
			if(image_link_id.equals(record[1]))
				out.println("<option value=\""+record[0]+"||"+record[1]+"||"+record[2]+"\" selected> "+record[1]+" </option>");
			else 
				out.println("<option value=\""+record[0]+"||"+record[1]+"||"+record[2]+"\" > "+record[1]+" </option>");
		}
	
		if(ImageList!=null) {
			ImageList.clear();
			ImageList	= null;  
		}

            _bw.write(_wl_block10Bytes, _wl_block10);
if(image_id.equals("") ||image_id.indexOf("FRNT")!=-1){ out.println("checked");}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(image_id.indexOf("BACK")!=-1){ out.println("checked");}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

if(!image_url.equals("")) { 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(image_url));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(image_url));
            _bw.write(_wl_block16Bytes, _wl_block16);
 } else { 
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);

	//if( image_position.equals("FRNT") || image_position.equals(""))
	//	out.println("<script>document.image_form.front.checked = true </script>");
	//else
	//	out.println("<script> document.image_form.back.checked = true </script>");
	if(image_id.equals("") || image_id.indexOf("FRNT")!=-1){
		out.println("<script>document.image_form.front.checked = true </script>");
		out.println("<script>document.image_form.back.checked = false </script>");
	}else{
		out.println("<script> document.image_form.front.checked = false </script>");
		out.println("<script> document.image_form.back.checked = true </script>");
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

try{
	 //Call the method to get the values for the population of the hot spot
	 //ArrayList HotSpot = bean.getHotSpot(properties, image_id, image_link_id, order_category);//IN072524
	ArrayList HotSpot = bean.getHotSpot(properties, image_id, image_link_id, order_category,fpp_patient_yn);//IN072524

	// System.err.println("=============================="+HotSpot.size());
	 for(int i=0; i<HotSpot.size(); i++)
	{
		record = (String[])HotSpot.get(i);

		hotspot_pos		= record[0];
		hotspot_name	= record[1];
		hotspot_id		= record[2];
		image_id		= record[3];
		hotspot_xpos	= bean.checkForNull(record[4]," ");
		hotspot_ypos	= bean.checkForNull(record[5]," ");

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hotspot_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(image_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hotspot_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(hotspot_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(hotspot_xpos));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(hotspot_ypos));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(image_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(hotspot_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(hotspot_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(hotspot_xpos));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(hotspot_ypos));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(image_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(hotspot_id));
            _bw.write(_wl_block30Bytes, _wl_block30);

	}
		if(HotSpot!=null) {
			HotSpot.clear();
			HotSpot	 = null;
		}
}catch(Exception e)
{
	//out.println("exception"+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
 

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_category_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_category_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_type_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(priv_applicable_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);

		// Nullifying the objects
		record		= null;

		// no need to set it back persistence
		//putObjectInBean(bean_id,bean,request);



            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BodyPart.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Front.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Back.label", java.lang.String .class,"key"));
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
}
