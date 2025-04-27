package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __imagehotspotfigure extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ImageHotspotFigure.jsp", 1743590030737L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<html>\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../../eOR/js/HotSpot.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n<SCRIPT>\nb=(document.length)?1:0;\nvar pos\t\t\t= new Array();\nvar pos1\t\t= new Array();\nvar db_values\t= new Array();\nvar tmp_spotname= new Array();\nfunction s(){\n\tif(!b){\n\t/*\tww=window.innerWidth;\n\t\twh=window.innerHeight;*/\n\t}if(b){\n\t\tww=document.body.offsetWidth;\n\t\twh=document.body.offsetHeight;\n\t}\n\t\n\t//cL(\'qD\',0,0,0,0,\'\'+cc+\'*\'+c2+\'\',\"#FF3333\",null,1,\"\");\n\n\t//alert(db_values.length);\n\tfor(var x=0;x<db_values.length;x++){\n\t\tvar tmp_values = db_values[x].split(\"~\");\n\t\ttmp_spotname[x]=tmp_values[0];\n\t\tpos[x] = tmp_values[2];\n\t\tpos1[x] = tmp_values[3];\n\t}\n\t\n\tfor(var i=0;i<pos.length;i++){\n\t\tif(pos[i] != \" \"){\n\t\t\tcL(\'q\'+i+\'D\',pos[i],pos1[i],6,6,\'\'+cc+\'*\'+c2+\'\',\"#66FF33\",null,1,tmp_spotname[i]);\n\t\t}\n\t}\n\tkk=0;\n\tfor(var i=0;i<=to;i++){\n\t\tkk+=1;\n\t\tt=\'\';\n\t\teval(\"cL(\'km\"+i+\"D\',0,-50,6,6,\'<font size=3 face=arial color=#FF0033 size=3 style=\\\"display: block;\\\">\"+t+\"</font>\',\'#FF0033\',null,1,\'\');km\"+i+\"=new DL(\'km\"+i+\"D\');\");\n\t}\n\t\n\t//document.getElementById(\"tb1\").onmousedown=mouseDown;\n\t//document.onmousedown=mouseDown;\n\n\tvar doc_val=\"document\";\n\tfor(var i =0 ;i<document.getElementById(\"tb1\").rows.length;i++){\n\t\tfor(var j=0;j<document.getElementById(\"tb1\").rows[i].cells.length;j++){\n\t\t\tvar id_val = document.getElementById(\"tb1\").rows[i].cells[j].id;\n\t\t\tif( id_val != \"\"){\n\t\t\t\teval(doc_val+id_val).onmousedown=mouseDown;\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction cL(id,lf,tp,w,h,c,bg,vi,z,spot_nm){\n\tif(!b){\n\t}\n\telse{\n\t\n\t\tst=\'\\n<DIV id=\'+id+\' style=\"position:absolute; left:\'+lf+\'px; top:\'+tp+\'px; width:\'+w+\'px\';\n\t\tif(h!=null){\n\t\t\tst+=\'; height:\'+h+\'px\';\n\t\t\t//st+=\'; clip:rect(0,\'+w+\',\'+h+\',0)\';\n\t\t}\n\t\tif(bg!=null)\t\n\t\t\tst+=\'; background-color:\'+bg;\n\t\tif(z!=null)\n\t\t\tst+=\'; z-index:\'+z;\n\t\tif(vi)\n\t\t\tst+=\'; visibility:\'+vi;\n\t\tst+=\'; \"><a href=\"#\" onClick=\"callLink(\'+lf+\',\'+tp+\')\" title=\"\'+spot_nm+\'\" style=\"display: block;width: 100%;height: 100%; text-align: center;\">\'+((c)?c:\'\')+\'</a></DIV>\';\n\t\tdocument.body.insertAdjacentHTML(\"BeforeEnd\",st);\n\t\t\n\t}\n}\nfunction callLink(x_pos,y_pos){\n\t//alert(\"here===x==\"+x_pos+\"-y---\"+y_pos);\n\tvar tmp_x ;\n\tvar tmp_y ;\n\t\n\tvar flag = false;\n\tfor(var c=0;c<pos.length;c++){\n\t\ttmp_x = pos[c];\n\t\ttmp_y = pos1[c];\n\t\n\t\tvar j =0,k=0;\n\t\twhile(j<3){\n\t\t\tk=0;\n\t\t\twhile(k<3){\n\t\t\t\tif( (x_pos == parseInt(eval(tmp_x+j))) && (y_pos == parseInt(eval(tmp_y+k))) ){\n\t\t\t\t\tflag = true;\n\t\t\t\t\tif(flag)\n\t\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\tk++;\n\t\t\t}\n\t\t\tj++;\n\t\t\tif(flag)\n\t\t\t\tbreak;\n\t\t}\n\t}\n\t//alert(\"Call the link ...........\");alert(\"===x_pos==\"+x_pos+\"-y_pos---\"+y_pos);\n\n\tvar hotspot_pos = \"NOPOSTN\";\n\tvar tmp_name_values;\n\tvar tmp_pos_values;\n\tvar tmp_xpos_values;\n\tvar tmp_ypos_values;\n\n\tfor(var x=0;x<db_values.length;x++){\n\t\ttmp_values = db_values[x].split(\"~\");\n\t\ttmp_xpos_values = tmp_values[2];\n\t\ttmp_ypos_values = tmp_values[3];\n\t\tif(x_pos == tmp_xpos_values && y_pos == tmp_ypos_values){\n\t\t\thotspot_pos = tmp_values[1];\n\t\t\tbreak;\n\t\t}\n\t\t\n\t}\n\nparent.frames[0].location.href=\'../../eOR/jsp/ImageHotspotAddModify.jsp?hotspot_pos=\'+hotspot_pos+\'&image_id=\'+document.forms[0].image_id.value+\"&mode=2&status=modify&function_id=&x_pos=\"+x_pos+\"&y_pos=\"+y_pos;\n\n}\n\nDL.set=false;\nfunction DL(id){\n\n\tif(!DL.set){\n\t\tDLInit();\n\t}if(!b){\n\t\t/*this.css=document.layers[id];\n\t\tthis.elm=this.event=this.css;\n\t\tthis.doc=this.css.document;\n\t\tthis.x=this.css.left;\n\t\tthis.y=this.css.top;*/\n\t}else{\n\t\tthis.elm=this.event=document.getElementById(id);\n\t\tthis.css=document.getElementById(id).style;\n\t\tthis.doc=document.getElementById(id);\n\t\tthis.x=this.elm.offsetLeft;\n\t\tthis.y=this.elm.offsetTop;\n\t}\n\tthis.id=id;\n\tthis.obj=id+\"DL\";\n\teval(this.obj+\"=this\");\n}\n\nfunction DLInit(){\n\tif(!DL.set)\n\t\tDL.set=true;\n\tif(!b){/*\n\t\tref=document;\n\t\tfor(var i=0;i<ref.layers.length;i++){\n\t\t\tdn=ref.layers[i].name;ix=dn.indexOf(\"D\");\n\t\t\tif(ix>0)\n\t\t\t\teval(dn.substr(0,ix)+\' = new DL(\"\'+dn+\'\")\');\n\t\t}*/\n\t}else{\n\t\tfor(var i=0;i<document.getElementsByTagName(\"DIV\").length;i++){\n\t\t\tdn=document.getElementsByTagName(\"DIV\")[i].id;\n\t\t\tix=dn.indexOf(\"D\");\n\t\t\tif(ix>0)\n\t\t\t\teval(dn.substr(0,ix)+\' = new DL(\"\'+dn+\'\")\');\n\t\t}\n\t}\n\treturn true;\n}\n\nfunction DLMoveTo(x,y){\n//alert(x+\"============,\"+y)\n\tif(x!=null){\n\t\tthis.x=x;\n\t\tif(!b)\n\t\t\tthis.css.left=this.x + \"px\"; \n\t\telse {\n\t\t\tthis.css.left=this.x + \"px\";\n\t\t\t//css.pixelLeft = this.x;\n\t\t}\n\t}\n\tif(y!=null){\n\t\tthis.y=y;\n\t\tif(!b)\n\t\t\tthis.css.top=this.y + \"px\";\n\t\telse {\n\t\t\tthis.css.top=this.y + \"px\";\n\t\t\t//css.pixelTop=this.y;\n\t\t\t}\n\t}\n\nparent.frames[0].location.href=\"ImageHotspotAddModify.jsp?image_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&hotspot_pos=NOPOSTN&mode=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&status=insert&function_id=&x_pos=\"+x+\"&y_pos=\"+y;\n\t\n}\nDL.prototype.mTo=DLMoveTo;\n\n\n\nfunction DLW(html){\n\tif(!b){\n\t//\tthis.doc.open();\n\t//\tthis.doc.write(html);\n\t//\tthis.doc.close();\n\t}else if(b);\n\t\t//this.event.innerHTML=html;\n}\nDL.prototype.write=DLW;\n\nvar\to=new Array();\nfor(var i=0;i<100;i++)\n\to[i]=\"*\";\n\nvar to=100;\nvar tt=0;\nvar cc=\"<font size=1 face=arial color=red style=\'display: block;\'>\";\nvar c2=\"</font>\";\n\n\nvar g\t= 0;\nvar vk\t= 0;\nvar t\t= \"\";\nvar sp\t= 0;\nvar ak\t= true;\n\nvar hot\t= 0;\n\n\nfunction mouseDown(e){\nhot +=1;\n//IN065956 starts\n//var x=(!b)?e.pageX:(event.x+document.body.scrollLeft);\n//var y=(!b)?e.pageY:(event.y+document.body.scrollTop);\nvar x=(!b)?e.pageX:(event.clientX+document.body.scrollLeft);\nvar y=(!b)?e.pageY:(event.clientY+document.body.scrollTop);\n//IN065956 ends\n//alert(\"x::\"+x+\" ,y::\"+y);\nvar temp=hot -1;\n\nif(ak){\n\tif(g<to){\n\t\tg+=1\n\t\tt=\"\";\n\t\tak=false;\n\t\t// Abdelhamid: resetting the last spot\n\t\tdocument.getElementById(\"km\"+sp+\"D\").style.left=\"0px\";\n\t\tdocument.getElementById(\"km\"+sp+\"D\").style.top=\"-50px\";\n\t\t//q.write(\'\');\n\t\tfor(var i=0;i<=o[vk].length-1;i++){\n\t\t\tsp+=1;\n\t\t\tsetTimeout(\"km\"+sp+\".mTo(\"+x+\",\"+y+\");\",0);\n\t\t}\n\t\tvk+=1;ak=true;\n\t}else{\n\t\t//q.write(\'\');li=true;\n\t}\n}\nreturn true;\n}\n\n</SCRIPT>\n<script>\nvar obj2;\n\tfunction changeColor(Obj){\n\t\tvar id=Obj.id;\n\t\t//alert(Obj.id);\n\t\tif( Obj.innerHTML.indexOf(\"<a href\") !=-1);\n\t\telse{\n\t\t\tif(obj2 == null)\n\t\t\tObj.innerHTML=\"<td    valign=\'center\'></td>\"\n\t\t\telse\n\t\t\tobj2.innerHTML=\"<td    valign=\'center\'></td>\"\n//alert(\"obj2::\"+obj2+\" Obj::\"+Obj);\n\t\t\tobj2=Obj;\n\t\t\tObj.innerHTML=\"<font color=\'red\'>*</font>\"\n\n\t\t\t present=1;\n\t\t\tparent.frames[0].location.href=\"ImageHotspotAddModify.jsp?image_id=\"+document.forms[0].image_id.value+\"&hotspot_pos=\"+id+\"&mode=\"+document.forms[0].mode.value+\"&status=insert&function_id=\"+function_id;\n\t\t}\n\t\t\n\t}\n\nvar val;\n\nfunction aa(val) {\n\tparent.frames[0].location.href=\'../../eOR/jsp/ImageHotspotAddModify.jsp?hotspot_pos=\'+val+\'&image_id=\'+document.forms[0].image_id.value+\"&mode=2&status=modify&function_id=\"+function_id;\n\t//alert(\"comes here\");\n}\n</script>\n\t<style>\n\tTD.DATA\n\t{\n\t COLOR:navy;\n\t  FONT-SIZE: 8pt;\n\t  FONT-WEIGHT: BOLDER\n\t  }\n\n  \tA:link {\n  \t\tCOLOR: blue;\n  \t\ttext-decoration : none ;\n\t  \t}\n  \tA:visited {\n  \t\tCOLOR:blue;\n  \t\ttext-decoration : none ;\n\t  \t}\n\t</style>\n\n\n</head>\n<body topmargin=0  onload=\'FocusFirstElement();s();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" ><!-- bgcolor=\"#E6E6FA\" -->\n <form name=\'image_form_check\' id=\'image_form_check\'  method=\'post\' target=\'messageFrame\'>\n <br><br>\n\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  name=\'image_id\'  id=\'image_id\'>\n\t\t<input type=\"hidden\" name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<table  height = \'350vh\'  width=\"200vw\"  align=\'left\' background=\"../../eOR/images/";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"   cellspacing=\"0\" cellpadding=\"0\" id=\'tb1\' border=\'0\'  >\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<table  height = \'380vh\'  width=\"200vw\"  align=\'left\'   background=\"../../eOR/images/skeleton_front.gif\"   cellspacing=\"0\" cellpadding=\"0\" id=\'tb1\' border=\'3\'  >\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n<tr>\n\t<td  width=\"6%\"></td>\n    <td  width=\"6%\"  valign=\"bottom\"></td>\n    <td  width=\"6%\"  valign=\"center\" id=\'A5\' onclick=\'mouseDown(this);\'></td>\n    <td  width=\"6%\"  valign=\"center\" id=\'A6\' onclick=\'mouseDown(this);\'></td>\n    <td  width=\"6%\"  id=\"A1\" onClick=\'mouseDown(this)\'></td>\n    <td  width=\"6%\"  id=\"A2\" onClick=\'mouseDown(this)\'></td>\n    <td  width=\"6%\"  id=\"A3\" onClick=\'mouseDown(this)\'></td>\n    <td  width=\"6%\"  id=\"A4\" onClick=\'mouseDown(this)\'></td>\n    <td  width=\"6%\"></td>\n    <td  width=\"6%\"></td>\n    <td  width=\"6%\"></td>\n </tr>\n <tr>\n     <td ></td>\n     <td ></td>\n     <td ></td>\n     <td id=\"B5\" onClick=\'mouseDown(this)\'></td>\n     <td id=\"B1\" onClick=\'mouseDown(this)\'></td>\n     <td id=\"B2\" onClick=\'mouseDown(this)\'></td>\n     <td id=\"B3\" onClick=\'mouseDown(this)\'></td>\n     <td id=\"B4\" onClick=\'mouseDown(this)\'></td>\n     <td ></td>\n     <td ></td>\n     <td ></td>\n </tr>\n <tr>\n     <td ></td>\n     <td id=\'C8\' onClick=\'mouseDown(this)\'></td>\n     <td id=\'C9\' onClick=\'mouseDown(this)\'></td>\n     <td id=\"C1\" onClick=\'mouseDown(this)\' ></td>\n     <td id=\"C2\" onClick=\'mouseDown(this)\' ></td>\n     <td id=\"C3\" onClick=\'mouseDown(this)\' ></td>\n     <td id=\"C5\" onClick=\'mouseDown(this)\' ></td>\n     <td id=\"C6\" onClick=\'mouseDown(this)\' ></td>\n     <td id=\"C7\" onClick=\'mouseDown(this)\' ></td>\n     <td ></td>\n     <td ></td>\n </tr>\n <tr >\n    <td ></td>\n    <td id=\"D8\" onClick=\'mouseDown(this)\'></td>\n    <td  id=\"D1\" onClick=\'mouseDown(this)\'></td>\n    <td  id=\"D2\" onClick=\'mouseDown(this)\'></td>\n    <td  id=\"D3\" onClick=\'mouseDown(this)\'></td>\n    <td  id=\"D4\" onClick=\'mouseDown(this)\'></td>\n    <td  id=\"D5\" onClick=\'mouseDown(this)\'></td>\n    <td  id=\"D6\" onClick=\'mouseDown(this)\' ></td>\n    <td  id=\"D7\" onClick=\'mouseDown(this)\'></td>\n    <td ></td>\n    <td ></td>\n  </tr>\n <tr >\n    <td ></td>\n    <td id=\'E8\' onClick=\'mouseDown(this)\'></td>\n    <td id=\"E1\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"E2\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"E3\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"E4\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"E5\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"E6\"  onClick=\'mouseDown(this)\' ></td>\n    <td id=\"E7\"  onClick=\'mouseDown(this)\'></td>\n    <td ></td>\n    <td ></td>\n  </tr>\n <tr>\n    <td id=\"F7\" onClick=\'mouseDown(this)\'></td>\n    <td id=\"F1\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"F2\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\'F8\' onClick=\'mouseDown(this)\'></td>\n    <td id=\"F3\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"F4\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"F5\"  onClick=\'mouseDown(this)\'></td>\n    <td id=\"F6\"  onClick=\'mouseDown(this)\'></td>\n    <td ></td>\n    <td id=\"F7\"  ></td>\n    <td ></td>\n  </tr>\n   <tr >\n      <td id=\"G1\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G2\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G8\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G3\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G4\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G5\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G6\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G7\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G10\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G8\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"G9\"  onClick=\'mouseDown(this)\'></td>\n   </tr>\n    <tr >\n       <td id=\"H1\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"H2\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"H10\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"H3\" onClick=\'mouseDown(this)\' ></td>\n       <td id=\"H4\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"H5\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"H6\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"H7\"  onClick=\'mouseDown(this)\'></td>\n       <td ></td>\n       <td id=\"H8\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"H9\"  onClick=\'mouseDown(this)\'></td>\n   </tr>\n    <tr>\n       <td ></td>\n       <td id=\"I6\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"I5\"  onClick=\'mouseDown(this)\' ></td>\n       <td id=\"I1\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"I2\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"I3\"  onClick=\'mouseDown(this)\'></td>\n       <td id=\"I4\"  onClick=\'mouseDown(this)\'></td>\n       <td ></td>\n       <td ></td>\n\t   <td ></td>\n       <td ></td>\n  </tr>\n  <tr >\n      <td ></td>\n      <td ></td>\n      <td id=\"J6\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"J1\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"J2\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"J3\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"J4\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\'J5\'  onClick=\'mouseDown(this)\'></td>\n      <td ></td>\n      <td ></td>\n      <td ></td>\n  </tr>\n  <tr>\n      <td ></td>\n      <td ></td>\n      <td id=\"K4\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"K1\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"K2\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"k5\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"K3\"  onClick=\'mouseDown(this)\'></td>\n      <td ></td>\n      <td ></td>\n      <td ></td>\n      <td ></td>\n  </tr>\n   <tr>\n      <td ></td>\n      <td id=\"L7\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"L6\"  onClick=\'mouseDown(this)\'></td>\n\t  <td id=\"L1\"  ></td> \n      <td id=\"L2\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"L3\"  onClick=\'mouseDown(this)\'></td>\n      <td id=\"L5\" onClick=\'mouseDown(this)\'></td>\n      <td id=\"L4\"  onClick=\'mouseDown(this)\'></td>\n      <td ></td>\n      <td ></td>\n      <td ></td>\n </tr>\n <tr>\n     <td ></td>\n     <td id=\"M7\"  onClick=\'mouseDown(this)\'></td>\n     <td id=\"M1\"  onClick=\'mouseDown(this)\'></td>\n     <td id=\"M2\"  onClick=\'mouseDown(this)\'></td>\n     <td id=\"M8\"  onClick=\'mouseDown(this)\'></td>\n     <td id=\"M3\"  onClick=\'mouseDown(this)\'></td>\n     <td id=\"M4\"  onClick=\'mouseDown(this)\'></td>\n     <td id=\"M5\"  onClick=\'mouseDown(this)\'></td>\n     <td id=\"M6\"  onClick=\'mouseDown(this)\'></td>\n    <!--  <td id=\"M6\"  onClick=\'changeColor(this);mouseDown();\'></td> -->\n     <td id=\"M7\"  onClick=\'mouseDown(this)\'></td>\n     <td id=\"M8\"  onClick=\'mouseDown(this)\' ></td>\n </tr>\n</table>\n<br><br>\n<script>\n\tdocument.getElementById(\"tb1\").style.backgroundRepeat=\"no-repeat\";\n\tif(document.body.offsetWidth > 240)\n\t{\n\t//\tdocument.getElementById(\"tb1\").height\t= \"70%\"\n\t//\tdocument.getElementById(\"tb1\").width\t= \"74%\"\n\t\tdocument.getElementById(\"tb1\").height\t= \"350vh\"\n\t\tdocument.getElementById(\"tb1\").width\t= \"200vw\"\n\t}\n\n</script>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<script>\n//alert(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\t\ndb_values[\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'] = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'+\"~\"+\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n//var t=eval(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\n//val =\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\n//t.innerHTML=\"<a href=\'javascript:aa(\\\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\\\")\'><font color=\'CHARTREUSE\'>*</font></a>\";\n//t.title= \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n</script>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
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

/* 
------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------
05/12/2017	IN065956		Raja S			 	05/12/2017		Ramesh G		ARYU-SCF-0018
------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String image_id				= request.getParameter("image_id");
	String image_url			= request.getParameter("image_url");
 	if(image_url==null) image_url = "";
 	String mode					= request.getParameter( "mode" ) ;
	//String function_id			= request.getParameter( "function_id" ) ;
	String bean_id				= "Or_ImageHotSpot" ;
	String bean_name			= "eOR.ImageHotSpotBean";
	//String readOnly				= "readOnly" ;

	String hotspot_pos     ="";
	String hotspot_name ="";
	String hotspot_xpos ="";
	String hotspot_ypos ="";
//	String hotspot_id        ="";

	////////////bean initialization start////////
	ImageHotSpotBean  bean = (ImageHotSpotBean)getBeanObject( bean_id,  bean_name, request ) ;


	////////////bean initialization end////////

	ArrayList idList=new 	ArrayList();
	try{
			idList=(ArrayList)bean.getHotspotImage(image_id);
	}catch(Exception e)	{
		System.out.println("Ex. Here :"+e);
	}

 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(image_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(image_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block11Bytes, _wl_block11);


if(!image_id.equals("") && !image_url.equals("") ) { 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(image_url));
            _bw.write(_wl_block13Bytes, _wl_block13);
 } else {  
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block15Bytes, _wl_block15);

String [] hotspotPosition=null;
  for(int i=0;i<idList.size();i++)
{
hotspotPosition=(String [])idList.get(i);
//hotspot_id=  hotspotPosition[0];
hotspot_name = hotspotPosition[1];
hotspot_pos  = hotspotPosition[2];
hotspot_xpos = hotspotPosition[3];
hotspot_ypos = hotspotPosition[4];
if(hotspot_xpos == null)
	hotspot_xpos = " ";
if(hotspot_ypos == null)
	hotspot_ypos = " ";


            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(hotspot_xpos));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(hotspot_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hotspot_xpos));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hotspot_ypos));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hotspot_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
}idList=null;
            _bw.write(_wl_block25Bytes, _wl_block25);

		putObjectInBean(bean_id,bean,request);
 

            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
