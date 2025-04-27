package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __verificationcolorind extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/VerificationColorInd.jsp", 1743663548470L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/Tabs.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/Slate.js\"></script>\n\t\n\t<!--<script src=\"../../eOT/js/OTMessages.js\" language=\"javascript\"></script>-->\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\tTD.";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="{\n\t\tBACKGROUND-COLOR:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</style>\n</head>\n<body >\n\t<form name=\"VerficationColorInd\" id=\"VerficationColorInd\">\n\t\t<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"3\">\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<td class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' width=\'1%\'></td>\n\t\t<td class=\'white\' nowrap>\n\t\t<label nowrap style=\"font-size:9;font-weight:bold\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</label>\n\t\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\n\t</table>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t</form>\n</body>\n</html>\n<!-- <div id=\'tooltiptext\' style=\'display:none; width=40%\' >\t</div> -->\n\n\n<!--\nfunction createXML()\n{\n\n\tvar arrObj=rows;\nvar x=0;\nvar len=\tarrObj.length;\n\nvar xmlString=\"<root>\";\n\tfor(x=0;x<len;x++)\n\t{\n\n\t\txmlString+=\"<Detail\"+x+\"  \";\n\t\txmlString+=\"Desc=\\\"\"++\";\n\t\txmlString+=\"code=\\\"\"++\";\n\t\txmlString+=\"remarks=\\\"\"++\";\n\t\txmlString+=\"/>\";\n\t}\n\treturn xmlString;\n}\n\n-->\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
int pos=0;

String strColorInd="";
String strStageDesc="";
String strStageCode="";

String sql="";


ArrayList colorDesc=new ArrayList();
ArrayList stageCode=new ArrayList();


try
{
conn = ConnectionManager.getConnection(request);

//sql=OTRepository.getOTKeyValue("OT_VERIFICATION_SELECT1");

//sql="SELECT STAGE_CODE STAGE_CODE1, POST_STAGE_DESC POST_STAGE_DESC1, COLOR_IND COLOR_IND1, TEXT_COLOR TEXT_COLOR1 FROM OT_BOOKING_FIN_STAGES ORDER BY SERIAL_NO";

sql="SELECT STAGE_CODE STAGE_CODE1, POST_STAGE_DESC POST_STAGE_DESC1, COLOR_IND COLOR_IND1, TEXT_COLOR TEXT_COLOR1 FROM OT_BOOKING_FIN_STAGES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY SERIAL_NO";


pstmt = conn.prepareStatement(sql);

rs=pstmt.executeQuery();



            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	int column_count = 0;
	int count=0;
	while(rs.next())
		{			
			strColorInd=checkForNull(rs.getString("COLOR_IND1"));;
			strStageCode=checkForNull(rs.getString("STAGE_CODE1"));;
			strStageDesc=checkForNull(rs.getString("POST_STAGE_DESC1"));;

			colorDesc.add(count,strStageDesc);
			stageCode.add(count,strStageCode);
			
			count++;		

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strStageCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strColorInd));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}



            _bw.write(_wl_block12Bytes, _wl_block12);


for(pos=0;pos<count;pos++)
	{
			strStageDesc=""+colorDesc.get(pos);
			strStageCode=""+stageCode.get(pos);
			


	column_count++;
	if(column_count==1){
					out.println("<tr>");
				}
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strStageCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strStageDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);

	if(column_count==5){
						column_count=0;		
						out.println("</tr>");
						}
			}


}catch(Exception ee)
{
	out.println("Exception "+ee);
}
finally
{
if(rs!=null)		  rs.close();
pstmt.close();
ConnectionManager.returnConnection(conn,request);
colorDesc=null;
stageCode=null;
}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
