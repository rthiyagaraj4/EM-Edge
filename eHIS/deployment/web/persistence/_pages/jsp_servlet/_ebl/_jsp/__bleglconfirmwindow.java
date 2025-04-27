package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __bleglconfirmwindow extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLeGLConfirmWindow.jsp", 1709114489336L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<title>eGL Confirmation window</title>\n<script>\n\n   function confirmeGL()\n    {\n\t   \n\t   var formObj = document.forms[0];\n\t   var retVal = formObj.cust_grp_code.value+\"^\"+formObj.cust_code.value+\"^\"+formObj.reln_code.value+\"^\"+formObj.reln_paymnt.value+\"^\"+formObj.doc_id.value;\t  \n\n\t   // +\"^\"+formObj.doc_id.value Code Added by Sethu for ML-MMOH-CRF-1100 on 28/05/2018\n\t   //alert(\'confirmGL \'+retVal);\n\t   parent.window.returnValue = retVal;\n\t   parent.window.close();\t  \n    }\n   \n   function canceleGL()\n   {\n\t //  alert(\'canceleGL\');\n\t   parent.window.returnValue = \'N\';\n\t   parent.window.close();\t  \n   }\n   \n   \n\n\tfunction lockKey()\n\t  {\n\t\t \t \n\t\tif(event.keyCode == 93)\n\t\t\talert(\"Welcome to eHIS\");\n\t  }\n\n\t  function lockbackSpace()\n\t  {\n\t\t// alert(document.order_type_form.mode.value);\n\t\t   var mode = document.mode.value;\n      // alert(window.event.keyCode);\n\t\t if(mode==\'modify\' && window.event.keyCode==8)\n\t\t  {\n           //return false;\n\t\t  }\n\t  }\n\t\n\t\n</script>\n</head>\n\n<body>\n      <form name =\'eGLConfirmForm\' >\n\t\t\t<table width=\'100%\'>\n\t\t\t<tr>\n\t\t\t<td  width=\'60%\' nowrap class=\"label\" align = \'left\'>\n\t\t\t<label nowrap style=\"font-size:12;font-weight:bold\"> Nama Pegawai</label></td>\n\t\t\t<td  width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\t\t\t<input type=\'hidden\' name=reln_paymnt value =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t</td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">No. K/P</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">Jawatan</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">Gred</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">Kelayakan Kelas Wad</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">Nama Tempat Kerja</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">Nama Pesakit</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">No. Kad Pengenalan Pesakit</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">Perhubungan Keluarga</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<input type=\'hidden\' name=reln_code value =\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<input type=\'hidden\' name=reln_desc value =\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> </td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">Customer Group</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\t\t\t<input type=\'hidden\' name=cust_grp_code value =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"></td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' nowrap class=\"label\" align = \'left\'><label nowrap style=\"font-size:12;font-weight:bold\">Customer</label></td>\n\t\t\t<td width=\'40%\' nowrap class=\"label\" align right>:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \n\t\t\t<input type=\'hidden\' name=cust_code value =\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></td>\t\n\t\t\t<input type=\'hidden\' name=\"doc_id\" id=\"doc_id\" id=\"doc_id\" value =\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></td>\t\n\t\t\t</tr>\n\t\t\t<tr>\t\t\t\n\t\t\t<td width=\'60%\'>&nbsp;</td>\n\t\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t<input type=\"button\" name=\"accept_button\" id=\"accept_button\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" class=\"button\" onClick=\'confirmeGL(cust_grp_code,cust_code)\' >&nbsp;\n\t\t\t<input type=\"button\" name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" class=\"button\"  onClick=\'canceleGL()\' >\n\t\t\t</td>\n\t\t\t\n\t\t\t</table></form>\n</body>\n\t\t\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String retVal =request.getParameter("mesg");


//retVal = retVal.replace("|#","");
//cust_desc =cust_desc.replace(/\#/g,' ');	
//cust_desc =cust_desc.replace(/\&/g,' ');	

//retVal = "SUCCESS$|#ADIBAH BINTI HASHIM$|#780504086208$|#PENTADBIR/KLINIKAL, PEGAWAI PERUBATAN, GRED UD43/UD44/UD47/UD48/UD51/UD52/UD53/UD54$|#$|#Kelas 1 Bilik Seorang$|#UNIT KAWALAN AMALAN PERUBATAN SWASTA (UKAPS)$|#HASHIM B. MOHAMAD SAID$|#411103085083$|#04^Father$|#QB^JKN$!#QB000001^JABATAN KESIHATAN NEGERI SELANGOR$|#UD52$|#HSEL/eGL/100001!S!";

System.out.println(" mesg"+retVal);

String arr[] = retVal.split("$|#");

for(int i=0;i<arr.length;i++)
	System.out.println(" pos :"+i+" value  "+arr[i]);

String  pos1=arr[1].replace("$|","");
String pos2=arr[2].replace("$|","");
String pos3=arr[3].replace("$|","");
String pos4=arr[4].replace("$|","");
String pos5=arr[5].replace("$|","");
String pos6=arr[6].replace("$|","");
String pos7=arr[7].replace("$|","");
String pos8=arr[8].replace("$|","");
String pos9=arr[9].replace("$|","");
String cust_grp_code="";
String cust_grp_desc="";
String cust_code="";
String cust_desc="";
String  relnCode ="";
String  relnDesc ="";
int loc=0;
if(arr[9]!=null && arr[9].length()>0){
	
	  loc= arr[9].indexOf('^');	 
	  	  if(loc != -1)
	{
	 relnCode=arr[9].substring(0,loc);
	 relnDesc=arr[9].substring(loc+1,arr[9].length()-2);
	}
	else
	{
		relnCode = arr[9];
		relnDesc ="SELF";
	}
	}

if(arr[10]!=null && arr[10].length()>0){
	
  loc= arr[10].indexOf('^');
  System.out.println("Location "+loc);
 cust_grp_code=arr[10].substring(0,loc);
 cust_grp_desc=arr[10].substring(loc+1,arr[10].length()-2);
}


if(arr[11]!=null && arr[11].length()>0){
	loc= arr[11].indexOf('^');		
	 cust_code=arr[11].substring(0,loc);
	 cust_desc=arr[11].substring(loc+1,arr[11].length()-2);
	}
	String pos12=arr[12].replace("$|","");

	// Code Added by Sethu for ML-MMOH-CRF-1100 on 28/05/2018
	String pos13=arr[13].replace("$|","");



            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(pos1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pos1 ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pos2));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pos3));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pos12));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pos5));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pos6));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pos7));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pos8));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(relnDesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(relnCode ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(relnDesc ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cust_grp_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cust_grp_code ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cust_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cust_code ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pos13 ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
