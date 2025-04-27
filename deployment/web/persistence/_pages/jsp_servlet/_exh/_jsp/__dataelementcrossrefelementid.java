package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.lang.String;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __dataelementcrossrefelementid extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DataElementCrossRefElementID.jsp", 1709122316070L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\"  src=\"../../eXH/js/DataElementCrossReferencebasicelement.js\" ></script>\n<script Language=\"JavaScript\"  src=\"../../eXH/js/DataElementCrossReferencebasicelementID.js\" ></script>\n<script Language=\"JavaScript\">\nfunction funSubmit2(application_id1,element_id1)\n{\nvar act=\"../../eXH/jsp/DataElementCrossRefSearchServlet.jsp?application_id=\"+application_id1+\"&element_id=\"+element_id1;\n\tthis.document.forms[0].action = act;\n  this.document.forms[0].action_type.value=\'R\';\n\tthis.document.forms[0].target=\'messageFrame\';\n\tthis.document.forms[0].submit(); \n}\nfunction func1(element_id,element_name,derivation_type,in_use_yn,condition_exp1_val,expected_value,execution_order,expected_value2,position,application_id,profile_id)\n{\n  /*var url=\'&element_id=\'+escape(element_id)+\'&element_name=\'+element_name+\n\'&derivation_type=\'+derivation_type+\'&in_use_yn=\'+in_use_yn+\'&condition_exp1_val=\'+condition_exp1_val+\'&expected_value=\'+expected_value+\'&execution_order=\'+execution_order+\'&expected_value2=\'+expected_value2+\'&position=\'+position+\'&application_id=\'+application_id+\'&profile_id=\'+profile_id+\'&act_mode=D\';*/\n\nvar url=\'element_id=\'+escape(element_id)+\'&derivation_type=\'+derivation_type+\'&expected_value=\'+expected_value+\'&execution_order=\'+execution_order+\'&expected_value2=\'+expected_value2+\'&position=\'+position+\'&condition_exp1_val=\'+condition_exp1_val+\'&application_id=\'+application_id+\'&act_mode=D\';\n\nthis.parent.frames[1].document.location.href=\"../../eXH/jsp/DataElementCrossRefElementIDDeleteModify.jsp?\"+url;\n}\nfunction hide()\n{\n/*var value=parseInt(document.forms[0].count.value);\nfor(var i=0; i<value;i++)\n\t{\n\t\n\n\tif(document.getElementById(i+\"_EV2\").value==\"\"||document.getElementById(i+\"_EV2\").value==null)\n\t\t{\ndocument.getElementById(i+\"_EV2\").disabled=true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(i+\"_EV2\").disabled=false;\n\t\t}\n\t}*/\n\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n </head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onload=\'hide();\'>\n<form name=\"DATAELEMENTCROSSREF\" id=\"DATAELEMENTCROSSREF\" method=\"POST\" action=\'../../eXH/jsp/DataElementCrossRefBasicElement.jsp\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<table name=elTableRow border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t<tr>\n<td colspan=\"4\" align=\"right\" class=\"CAGROUP\" >\n\t</td>\n\t\n\t<td colspan=\"4\" align=\"right\" class=\"CAGROUP\" > \n<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</A>\n</td>\n\n\n</tr>\n<tr>\n<!--\n\t<td class=\'COLUMNHEADER\' width=\'35%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td> -->\n\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n</tr>\n\n\t\n\t\t\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<td ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" align=\"left\" nowrap>\n<a  href=\" javascript:func1(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\n  \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\">\n  &nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</td>\n\n<td ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" align=\"left\" nowrap>\n<input type=\'hidden\' id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" name=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n<input type=\'hidden\' id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' >\n\n<input type=\'hidden\'  name=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\n<INPUT TYPE=\"text\" id=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' NAME=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" disabled>\n\n\t\n\t\n\t</td>\n\n\t<td ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" align=\"left\" nowrap>\n\t\t<INPUT TYPE=\"text\" id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" NAME=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" align=\"left\" nowrap>\n\t\t<INPUT TYPE=\"text\"  id=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" size=8 disabled>\n<input type=\'hidden\' name=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' ></td> \n\t</td>\n\t<td ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =">\n\t\t<input type=\'hidden\' id=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' name=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' >\n\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\n\t</td>\n\t\n\t</tr>\n    \n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\n\n\t</table>\n\n<input type=\'hidden\' name=\'action_type\' id=\'action_type\'  >\n<input type=\'hidden\' name=\'Application_id\' id=\'Application_id\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >\n<input type=\'hidden\' name=\'element_id\' id=\'element_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' >\n<input type=\"hidden\" name=\"button_id\" id=\"button_id\" value=\'T\'>\n<input type=\"hidden\" name=\"Mode\" id=\"Mode\" value=\'U\' >\n</form>\n\t  </body>\n\t  </html>\n\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	//int count=0;
boolean boolToggle =  true;	
//String strTDClass = "";
String strBeanName = XHApplicationDerivationProfileSetupControllerBean.strBeanName;
//System.out.println("strBeanName"+strBeanName);
 String application_id="";
  String element_id="";
  String whereClause="";
  String qry_id = "VIEWXHAPPLDERIVATIONRULES";
  application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
element_id=URLDecoder.decode(XHDBAdapter.checkNull(request.getParameter("element_id")),"utf-8");
//System.out.println("element_id64"+element_id);

if(application_id.equals("") )
{
if(element_id.equals(""))
	{

whereClause=" where A.ELEMENT_ID=B.ELEMENT_ID ";

	}
else 
	{
out.println("<script>alert('ApplicationID cannt Be Blank');</script>");
out.println("<script>parent.frames[1].document.forms[0].reset();</script>");

	}

}
else if(application_id!=null  )
{

	if(element_id.equals(""))
	{

	 whereClause=" where A.ELEMENT_ID=B.ELEMENT_ID and A.APPLICATION_ID='"+application_id+"'  " ;

	}
	else
	{
		
whereClause=" where A.ELEMENT_ID=B.ELEMENT_ID and A.APPLICATION_ID='"+application_id+"' and A.ELEMENT_ID='"+element_id+"' " ;

	}
}



 request.setAttribute(XHQueryRender.strQueryId,qry_id);
request.setAttribute(XHQueryRender.whereClause,whereClause);
Connection conn = null;
try
{


	conn = ConnectionManager.getConnection(request);

		XHApplicationDerivationSetupControllerBean	xhBean = XHApplicationDerivationSetupControllerBean.getBean(XHApplicationDerivationSetupControllerBean.strBeanName,request,session);
	//XHDervationControllerBean xhBean = XHDervationControllerBean.getBean(strBeanName,request,session,response);
	xhBean.action(request,conn);

	HashMap resultsQry = xhBean.getResultSet();
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}


		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

				
	String strstyle="";
	
	for (int j=0; j<arrRow.size();j++)
	{	
  	   arrCol = (ArrayList)arrRow.get(j);	  
	   if (boolToggle == true)
	   {
			strstyle = "class='QRYEVEN'";
			boolToggle =  false;
	   }
	   else
	   {
			strstyle = "class='QRYODD'";
			boolToggle =  true;
		}
//System.out.println("arrCol.get(0)"+arrCol.get(0)+"arrCol.get(1)"+arrCol.get(1)+"arrCol.get(2)"+arrCol.get(2)+"arrCol.get(3)"+arrCol.get(3)+"arrCol.get(4)"+arrCol.get(4)+"arrCol.get(5)"+arrCol.get(5)+"arrCol.get(6)"+arrCol.get(6)+"arrCol.get(7)"+arrCol.get(7)+"arrCol.get(8)"+arrCol.get(8)+"arrCol.get(9)"+arrCol.get(9));



            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(URLEncoder.encode((String)arrCol.get(0)) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String)arrCol.get(1) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)arrCol.get(2)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String)arrCol.get(3)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( (String)arrCol.get(6)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String)arrCol.get(4)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String)arrCol.get(5)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String)arrCol.get(7) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String)arrCol.get(8) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String)arrCol.get(9) ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(((String)arrCol.get(9)).equals("null")?"":((String)arrCol.get(9)) ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"Pr"));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"Pr"));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String)arrCol.get(9)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"El"));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"El"));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"C"));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"C"));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)arrCol.get(2)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j+"C1"));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"C1"));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(2))));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"CE"));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"CE"));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(6))));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"EV"));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"EV"));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(4))));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(arrCol.get(0)+"_E1"));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"_E1"));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(5))));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"_E"));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"_E"));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(5))));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(arrCol.get(0)+"EV2"));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"EV2"));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(7))));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(7)).equals("")?"disabled":""));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j+"_E"));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j+"_E"));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(5))));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(arrCol.get(0)+"P"));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(((String)arrCol.get(0))+((String)arrCol.get(2))+"P"));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(8))));
            _bw.write(_wl_block41Bytes, _wl_block41);

			



	}
	 
	

	/*//XHApplicationDerivationSetupControllerBean	xhBean =
	//XHApplicationDerivationSetupControllerBean.getBean(strBeanName,request,session);
	//xhBean.action(request,conn);

	
	//resultsQry = xhBean.getResultSet();
	//arrRow = (ArrayList)resultsQry.get("qry_result"); 
//	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	//boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	//strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	//strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{ 
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}*/


 
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
			
			

	}
	
catch(Exception e1)
	{
		System.out.println("(DataElementCrossRefElementID.jsp:Exception):"+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	} 
	

	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(application_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(element_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ElementDesc.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.DerivationType.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.CondExpr.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ExpectedValue.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ExecOrder.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ExpectedValue2.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
