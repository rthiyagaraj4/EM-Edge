package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import org.json.simple.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import eXH.*;
import eCommon.Common.CommonBean;
import eBL.BLReportIdMapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blselectnuhdeekcoupon extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLSelectNuhdeekCoupon.jsp", 1737916811333L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n-----------------------------------------------------------------------------------------------\n1            New File            8157          NMC-JD-CRF-0072               Shikha Seth\n2            V210211             8157          NMC-JD-CRF-0072               Shikha Seth\n3            V210224             8157          NMC-JD-CRF-0072               Shikha Seth\n4            V210319             16156         NMC-JD-CRF-0072.2             Shikha Seth\n -->\n<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<meta name=\"viewport\" http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1, width=device-width, initial-scale=1\" />\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\" ></script>\t\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language =\"javascript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n<script language = \"javascript\">\nfunction cancel()\n{\n\t//V210224 start\n\tvar couponcount = document.forms[0].couponcount.value;\n\tvar couponSelectedYN=\"N\";\t\n\tfor(i=0;i<couponcount;i++){\n\t\tif (document.getElementById(\"select\"+i).checked) {\n\t\t\tcouponSelectedYN = \"Y\";\t\t\n\t\t}\n\t}\t\t\t\n\tif (couponSelectedYN == \"Y\") { \t\t\t\n\t\t\tif(confirm(getMessage(\"BL0932\",\"BLEXT\"))) {\n\t\t\t\twindow.returnValue = \"\";\n\t\t\t\twindow.close();\n\t\t\t}else {\n\t\t\t\treturn false;\n\t\t\t}\t\t\n\t}else {\n\t\twindow.returnValue = \"\";\n\t\twindow.close();\n\t} //V210224 end\n}\nfunction confirm_ok() {\n\tvar couponcount = document.forms[0].couponcount.value;\t\t\n\tvar patientID = document.forms[0].patientID.value;\n\tvar clientIpAddress = document.forms[0].clientIpAddress.value;\n\tvar LoggedUser = document.forms[0].LoggedUser.value;\n\tvar setld_amt = parseInt(document.forms[0].setld_amt.value);\t\t\n\t//V210224 start\n\tvar remainingAmt = parseInt(document.forms[0].remainingAmt.value);\t\t\n\tif(isNaN(setld_amt)){\n\t\tsetld_amt=0;\n\t}\n\t//V210224 end\n\tvar transactionid = \"\";\n\tvar retVal=\"\";\n\tvar i=0;\n\tvar coupon=\"\";\n\tvar couponAndAmt=\"\";\n\tvar totamount=0;\n\tfor(i=0;i<couponcount;i++){\n\t\tif (document.getElementById(\"select\"+i).checked) {\n\t\t\tvar couponcode = document.getElementById(\"couponcode\"+i).innerText;\n\t\t\t totamount = parseInt(totamount)+parseInt(document.getElementById(\"couponAmt\"+i).innerText);\t\t\t\t\n\t\t\tif (coupon ==\"\") {\n\t\t\t\tcoupon=couponcode;\n\t\t\t\tretVal=couponcode;\n\t\t\t\tcouponAndAmt=couponcode.concat(\"-\"+(document.getElementById(\"couponAmt\"+i).innerText));\n\t\t\t} else {\n\t\t\t\tcoupon=coupon+\",\"+couponcode;\n\t\t\t\tretVal=retVal+\"::\"+couponcode;\n\t\t\t\tcouponAndAmt=couponAndAmt+\", \"+couponcode.concat(\"-\"+(document.getElementById(\"couponAmt\"+i).innerText));\n\t\t\t}\n\t\t}\n\t}\t\t\n\t\n\tif (!(coupon ==\"\")) {\t\t\t\n\t\t//V210224 start\t\t\t\n\t\t\tif ((totamount+parseInt(setld_amt)) > parseInt(remainingAmt)) {\n\t\t\t\tif(confirm(getMessage(\"BL0923\",\"BLEXT\"))) {\n\t\t\t\t\tvar NuhdeekResponse = NuhdeekTransactions(\'HOLD\',patientID,coupon,transactionid, LoggedUser, clientIpAddress);\t\t\n\t\t\t\t\tvar NuhdeekResponseArr = NuhdeekResponse.split(\"$!^\");\t\t\n\t\t\t\t\tif (NuhdeekResponseArr[0] == \'S\') {\t\t\t\t\t\t\t\n\t\t\t\t\t\twindow.returnValue = coupon+\"::\"+totamount+\"::\"+couponAndAmt;\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t} else if (NuhdeekResponseArr[0]==\'E\') {\n\t\t\t\t\t\t\talert(NuhdeekResponseArr[4]);\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t} \n\t\t\t\t}else {\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t} else{\t\t\t\t\n\t\t\t\tvar NuhdeekResponse = NuhdeekTransactions(\'HOLD\',patientID,coupon,transactionid, LoggedUser, clientIpAddress);\t\t\n\t\t\t\tvar NuhdeekResponseArr = NuhdeekResponse.split(\"$!^\");\t\t\n\t\t\t\tif (NuhdeekResponseArr[0] == \'S\') {\t\t\t\t\t\t\t\n\t\t\t\t\twindow.returnValue = coupon+\"::\"+totamount+\"::\"+couponAndAmt;\n\t\t\t\t\twindow.close();\n\t\t\t\t} else if (NuhdeekResponseArr[0]==\'E\') {\n\t\t\t\t\t\talert(NuhdeekResponseArr[4]);\n\t\t\t\t\t\treturn false;\n\t\t\t\t} //V210224 end\n\t\t} \n\t}else {\n\t\twindow.returnValue = \"\";\n\t\twindow.close();\n\t}\n}\t\n\nfunction selectcoupon(index,couponcode,couponAmt) {\t\n\tvar couponcount = document.forms[0].couponcount.value;\t\t\n\tvar count=0;\t\n\tvar i=0;\n\tvar selectCB = document.getElementById(\'select\'+index);\n\tif (selectCB.checked){\n\t\tdocument.getElementById(\'select\'+index).value=\'Y\';\n\t\tfor(i=0;i<couponcount;i++) {\n\t\t\tif(document.getElementById(\"select\"+i).checked == true)\n\t\t\tcount++;\n\t\t}\n\t\tif(count==couponcount) {\n\t\t\tdocument.getElementById(\"selectall\").checked=true;\n\t\t}\n\t}\n\telse if(selectCB.checked==false) {\n\t\tdocument.getElementById(\"selectall\").checked=false;\n\t}\n}\n\nfunction selectallcoupon(){\n\tvar couponcount = document.forms[0].couponcount.value;\t\n\tvar selectallCB = document.getElementById(\"selectall\");\n\tvar i=0;\t\n\tif(selectallCB.checked) {\t\t\n\t\tfor( i=0;i<couponcount;i++){\t\t\t\n\t\t\tdocument.getElementById(\"select\"+i).checked = true;\n\t\t\tdocument.getElementById(\"select\"+i).value = \"Y\";\n\t\t}\n\t}\n}\n\nfunction findcoupon() {\n  var input, filter, table, tr, td, i, txtValue;\n  input = document.getElementById(\"findstring\");\n  filter = input.value.toUpperCase();\n  table = document.getElementById(\"couponTable\");\n  tr = table.getElementsByTagName(\"tr\");\n  for (i = 1; i < tr.length; i++) {\n    td = tr[i].getElementsByTagName(\"td\")[0];\n    if (td) {\n      txtValue = td.textContent || td.innerText;\n      if (txtValue.toUpperCase().indexOf(filter) > -1) {\n        tr[i].style.display = \"\";\n      } else {\n        tr[i].style.display = \"none\";\n      }\n    }       \n  }\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>     \n    .couponbody {\n\t  height: 345px;\n\t  overflow: auto;\n\t  overflow-x: hidden;\n\t}\n   </style>\n<title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</title>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\n</head>\n<body>\n<form>\n<center>\n<table>\n\t<table >\n<tr>\n<td width=\"8%\" class=\"label\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td><input type=\'text\' name=\'findstring\' id=\'findstring\' id=\'findstring\' value=\'\' size=\'50\' maxlength=\'50\' > </td>\n</tr>\n</table>\n<tr>\n<div class=\"couponbody\">\n\t<table width=\'100%\' align=\"center\" cellpadding=\"4\" cellspacing=\"0\" class=\'grid\' id=\"couponTable\" >          \t\t\n\t\t\t<tr>\n            <td class=\'COLUMNHEADER\' >Coupon Code</td>\n\t\t\t<td class=\'COLUMNHEADER\' >Coupon Description </td>\n            <td class=\'COLUMNHEADER\' >Amount </td>\n            <td class=\'COLUMNHEADER\' >Select All <input type=\'checkbox\' name=\"selectall\" id=\"selectall\" id=\"selectall\" onclick=\"selectallcoupon()\"></td>            \n           </tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" <script>\t\t\n\talert(getMessage(\'BL0922\',\'BLEXT\')); \n\twindow.close();\n</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<tr>\n<td id=\'couponcode";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n<td id=\'couponDesc";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td> <!-- V210319 -->\n<!-- <td id=\'couponDesc";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>NMC100000003180000000003266394Coupon Amount 100 OFF</td> -->\n<td id=\'couponAmt";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n<td><input type=\'checkbox\' id=\"select";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" name=\"select";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" value=\'\' onclick=\"selectcoupon(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\"></td>\n</tr>\n  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</table>\n</div>\n</tr>\n<div>\n<tr>\n<td><input type=\'button\' id=\'find\' name=\'find\' id=\'find\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" class=\'button\' onClick=\"findcoupon()\"> </td> \n<td><input type=\'button\' id=\'ok\' name=\'ok\' id=\'ok\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" class=\'button\' onClick=\'confirm_ok()\'> </td>\n<input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" class=\'button\' onClick=\'cancel()\'>\n</tr>\n</div>\n</table>\n</center>\n<input type=\'hidden\' name=\'coupons\' id=\'coupons\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'clientIpAddress\' id=\'clientIpAddress\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'LoggedUser\' id=\'LoggedUser\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'patientID\' id=\'patientID\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'couponcount\' id=\'couponcount\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'setld_amt\' id=\'setld_amt\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'remainingAmt\' id=\'remainingAmt\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getParameter("title")));
            _bw.write(_wl_block8Bytes, _wl_block8);
		
	request.setCharacterEncoding("UTF-8");
	try
	{
		String query_string="";
		query_string = (request.getQueryString());
		System.out.println("query_string in nuhdeek.jsp:"+ query_string);
		}
	catch(Exception e)
	{
		System.out.println("main exception in nuhdeek-"+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

request.setCharacterEncoding("UTF-8");
String coupons = request.getParameter("coupons");
String clientIpAddress = request.getParameter("clientIpAddress");
String LoggedUser = request.getParameter("LoggedUser");
String patientID = request.getParameter("patientID");
String setld_amt = request.getParameter("setld_amt");
String remainingAmt = request.getParameter("remainingAmt"); //V210224
System.err.println("setld_amt="+setld_amt+"/"+remainingAmt);
  StringTokenizer st = new StringTokenizer(coupons,"|");  
  int count =st.countTokens();  
//  V210211 START
	if (count <= 0) {  
  
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
            _bw.write(_wl_block1Bytes, _wl_block1);

	//V210211 END
  for(int i=0;i<count;i++) {
  String couponNAmt = st.nextToken();
  String coupon[] = couponNAmt.split("~");  

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(coupon[0] ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(coupon[2] ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(coupon[1] ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(coupon[0] ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(coupon[1] ));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.Find.Label","bl_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(coupons));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clientIpAddress));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(LoggedUser));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(setld_amt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(remainingAmt ));
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Find.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
