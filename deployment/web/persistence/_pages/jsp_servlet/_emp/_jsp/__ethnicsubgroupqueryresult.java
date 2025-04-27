package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __ethnicsubgroupqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/EthnicSubGroupQueryResult.jsp", 1719207028125L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<P>\n\t\t\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t<!-- \t<td align =\'right\' id=\'prev\' style=\'visibility:hidden\'> -->\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t<td align =\'right\'  style=\'visibility:hidden\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t\t<BR><BR>\n\t\t</P>\n\n\t\t<center>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t<th width=\'30%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t</table>\n\t\t<div id=\'page1\' style=\"display:\'none\'\">\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</table>\n\t\t</div>\n\t\t<div id=\'page";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' style=\"display:\'none\'\">\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</div>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script >\n\t\t\t//\tif (document.getElementById(\"next\"))\n\t\t\t\t//\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<script >\n\t\t\t//\tif (document.getElementById(\"next\"))\n\t\t\t\t//\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n</td></tr>\n</table>\n</center>\n\n<br><center>\n<SCRIPT LANGUAGE=\"JavaScript\">\nvar divno;\nif(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'==\'true\')\n{\ndivno =1;\n}\nelse\n{\n\tdivno =\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n}\nvar divcntlc=1;\nvar totaldivs=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\nfunction onld1(choice1)\n{\n\tvar choice=choice1;\n\t//alert(\'onld\');\n\t//alert(\'divno\'+divno);\n\t//alert(\'next:\'+document.getElementById(\"next1\").href);\n\tvar check=1;\n\tvar check1=1;\n\tif(choice==\'next\')\n\t{\n\t\t//eval(\"document.getElementById(\"page\")\"+divno+\".style.visibility=\'hidden\'\");\n\t\tif(eval(document.getElementById(\'page\'+divno)))\n\t\teval(document.getElementById(\'page\'+divno).style.display=\'none\');\n\t\tdivno=parseInt(divno) + 1;\n\t\tdivcntlc=parseInt(divcntlc) + 1;\n\t\tif(eval(document.getElementById(\'page\'+divno)))\n\t\teval(document.getElementById(\'page\'+divno).style.display=\'inline\');\n\t\tcheck=parseInt(divno) + 1;\n\t\tcheck1=parseInt(divno) - 1;\n\t}\n\tif(choice==\'prev\')\n\t{\n\t\tif(eval(document.getElementById(\'page\'+divno)))\n\t\teval(document.getElementById(\'page\'+divno).style.display=\'none\');\n\t\tdivno=parseInt(divno) - 1;\n\t\tdivcntlc=parseInt(divcntlc) - 1;\n\t\tif(eval(document.getElementById(\'page\'+divno)))\n\t\teval(document.getElementById(\'page\'+divno).style.display=\'inline\');\n\t\tcheck1=parseInt(divno) - 1;\n\t\tcheck=parseInt(divno) + 1;\n\t\t\n\t}\n\tif(choice==\'first\')\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'==\'true\')\n\t\t{\n\t\tdocument.getElementById(\"page1\").style.display=\'inline\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\teval(document.getElementById(\'page\'+";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =").style.display=\'inline\');\n\t\t}\n\n\t\tif(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'==1)\n\t\t{\n\t\tdocument.getElementById(\"prev\").style.visibility=\'hidden\';\n\t\t}\n\t\tcheck=parseInt(divno) + 1;\n\t\tcheck1=parseInt(divno) - 1;\n\t}\n\t\n\t\tif(eval(document.getElementById(\'page\'+check)))\n\t\t{\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'==\'N\' )\n\t\t\t{\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t}\n\t\t}\n\t\tif(eval(document.getElementById(\'page\'+check1))\n\t\t{\n\t\t\tdocument.getElementById(\"prev\").style.visibility=\'visible\';\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\tif(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'==1)\n\t\t\t{\n\t\t\tdocument.getElementById(\"prev\").style.visibility=\'hidden\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"prev\").style.visibility=\'visible\';\n\t\t\t}\n\t\t\t\n\t\t}\n\t\tprevnextlink(choice);\n//alert(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');\n\n}\n\nfunction prevnextlink(choice)\n{\t\n\tif(choice==\'first\')\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'!=1 && (divno==1 || divno==0))\n\t\t{\n\t\tdocument.getElementById(\'prev\').innerHTML=\"<A HREF=\'../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&to=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&prevflg=false&whereclause=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' text-decoration=\'none\'>\"+getLabel(\'Common.previous.label\',\'common\')+\"</A>\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\'prev\').innerHTML=\"<A HREF=\'#\' onclick=\'onld1(\'prev\')\' text-decoration=\'none\'>\"+getLabel(\'Common.previous.label\',\'common\')+\"</A>\";\n\t\t}\n\t\n\t\tif(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'==\'true\')\n\t\t{\n\t\tdocument.getElementById(\'next\').innerHTML=\"<A HREF=\'#\' style=\'cursor: pointer\' onclick=\'onld1(\'next\')\' text-decoration=\'none\'>\"+getLabel(\'Common.next.label\',\'common\')+\"</A>\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\'next\').innerHTML=\"<A HREF=\'../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&prevflg=true&whereclause=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' text-decoration=\'none\'>\"+getLabel(\'Common.next.label\',\'common\')+\"</A>\";\n\t\t}\n\t\n\t}\n\telse if(choice==\'next\' || choice==\'prev\')\n\t{\n\t\tif(divno==\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' && \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'!=\'N\')\n\t\t{\n\t\t\tdocument.getElementById(\"next\").innerHTML=\"<A HREF=\'../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' text-decoration=\'none\'>\"+getLabel(\'Common.next.label\',\'common\')+\"</A>\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"next\").innerHTML=\"<A HREF=\'#\' onclick=\'onld1(\'next\')\' text-decoration=\'none\'>\"+getLabel(\'Common.next.label\',\'common\')+\"</A>\"\n\t\t}\n\t/*}\n\telse if(choice==\'prev\')\n\t{*/\n//\t\tif(divno==1 && \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'==\'true\')\n\t\tif(divno==1)\n\t\t{\n\t\t\tdocument.getElementById(\'prev\').innerHTML=\"<A HREF=\'../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' text-decoration=\'none\'>\"+getLabel(\'Common.previous.label\',\'common\')+\"</A>\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\'prev\').innerHTML=\"<A HREF=\'#\' onclick=\'onld1(\'prev\')\' text-decoration=\'none\'>\"+getLabel(\'Common.previous.label\',\'common\')+\"</A>\";\n\t\t}\n\t}\n//\talert(document.getElementById(\"prev\").innerHTML);\n\t//alert(document.getElementById(\"next\").innerHTML);\n}\n</SCRIPT>\n\n<SCRIPT LANGUAGE=\"JavaScript\">\n\tonld1(\'first\');\n</SCRIPT>\n<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n</center>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	int divcnt = 2;
	String nextrecord ="N";
	String prevflg =request.getParameter( "prevflg" );
	if(prevflg == null)
	prevflg="true";
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' ");

	String whereClause = request.getParameter("whereclause");
	
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	/*Added by lakshmanan for security issue ID 174153177 on 05-09-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174153177 on 05-09-2023 end */

	if ( (whereClause == null || whereClause.equals("")) )
	{
//	sql = "";
	String cd = request.getParameter("ETHNIC_GROUP_CODE");
	cd = cd.toUpperCase();
	String longdesc = request.getParameter("LONG_DESC");
	longdesc = longdesc.toUpperCase();
	String enabled = request.getParameter("nature");

	String subcd = request.getParameter("RACE_CODE");
	subcd = subcd.toUpperCase();
	String sublongdesc = request.getParameter("RACE_LONG_DESC");
	sublongdesc = sublongdesc.toUpperCase();

	int andCheck = 0;
	

	if ( !(cd == null || cd.equals("")) )
	{
		sbQuery.append("where ETHNIC_GROUP_CODE like ? ");
		psthashmap.put(++psthmcount,cd+"%");
		//sbQuery.append(cd);
		//sbQuery.append("%'");
//		sql = "where ETHNIC_GROUP_CODE like '"+cd+"%'";
		andCheck = 1;
	}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(LONG_DESC) like ? ");
			psthashmap.put(++psthmcount,longdesc+"%");
			//sbQuery.append(longdesc);
			//sbQuery.append("%'" );
//			sql = sql + " and ";
//			sql = sql + "upper(LONG_DESC) like  '"+longdesc+"%'" ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(LONG_DESC) like ? ");
			psthashmap.put(++psthmcount,longdesc+"%");
			//sbQuery.append(longdesc);
			//sbQuery.append("%'" );
//			sql = "where upper(LONG_DESC) like '"+longdesc+"%'" ;
			andCheck = 1;
		}
	}
	if ( !(subcd == null || subcd.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(RACE_CODE) like ? ");
			psthashmap.put(++psthmcount,subcd+"%");
			//sbQuery.append(subcd);
			//sbQuery.append("%'");
//			sql = sql + " and ";
//			sql = sql + "upper(RACE_CODE) like  '"+subcd+"%'" ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(RACE_CODE) like ? ");
			psthashmap.put(++psthmcount,subcd+"%");
			//sbQuery.append(subcd);
			//sbQuery.append("%'");
//			sql = "where upper(RACE_CODE) like '"+subcd+"%'" ;
			andCheck = 1;
		}
	}

	if ( !(sublongdesc == null || sublongdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(RACE_LONG_DESC) like ? ");
			psthashmap.put(++psthmcount,sublongdesc+"%");
			//sbQuery.append(sublongdesc);
			//sbQuery.append("%'" );
//			sql = sql + " and ";
//			sql = sql + "upper(RACE_LONG_DESC) like  '"+sublongdesc+"%'" ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(RACE_LONG_DESC) like ? ");
			psthashmap.put(++psthmcount,sublongdesc+"%");
			//sbQuery.append(sublongdesc);
			//sbQuery.append("%'");
//			sql = "where upper(RACE_LONG_DESC) like '"+sublongdesc+"%'" ;
			andCheck = 1;
		}
	}

	if ( !(enabled == null || enabled.equals("")) )
	{
		//Added by Sabarinathan S on 2/17/2005		
		if(!enabled.equals("B")){
			if(andCheck == 0){
				sbQuery.setLength(0);
				sbQuery.append("where  ");
			}else
				sbQuery.append(" and ");
			sbQuery.append("eff_status=? ");
			psthashmap.put(++psthmcount,enabled);
		}else if(enabled.equals("B")){
			if(andCheck == 1)	
				sbQuery.append(" and (eff_status='E' or eff_status='D')");
			else{
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E' or eff_status='D'");				
			}
		}
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
			sbQuery.append(" order by ");
//			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
//					sql=sql+ord[i];
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
//					sql=sql+ord[i]+",";
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//		sql = whereClause;
	}
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 42 ;
	else
		end = Integer.parseInt( to ) ;

//Connection conn = (Connection) session.getValue( "connection" ) ;

Connection conn = null;

PreparedStatement pstmt=null;
ResultSet rs=null;
//int maxRecord = 0;
try{
	 conn = ConnectionManager.getConnection(request);
/*try{
	pstmt = conn.prepareStatement("select count(*) as total from MP_ETHNIC_GROUP_VW "+sbQuery.toString());
	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");*/
try{
	pstmt =conn.prepareStatement("select * from MP_ETHNIC_GROUP_VW "+sbQuery.toString()); 
	int pstcount=1;
	while ( pstcount<=psthashmap.size()) {
	pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
	pstcount++;
	}
	psthashmap.clear();
	psthmcount=0;
	rs = pstmt.executeQuery();


            _bw.write(_wl_block6Bytes, _wl_block6);

 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
    String classValue = "" ;
	String race_long_desc = "";
	int cnt=0;

while (i<=(end+1) && rs.next() )
//while (rs.next())
{
	

	if(i<=end)
	{
	
	if(cnt==0)
	{
            _bw.write(_wl_block7Bytes, _wl_block7);

		//if ( start == 1 )
		//{
			out.println("<td align ='right' id='prev' style='visibility:hidden'><A HREF='#' id='prev1' style='cursor: pointer' onclick='onld1('prev')'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		//}
		//else
		//{
		//	out.println("<td align ='right' id='prev' ><A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" id='prev1' style='cursor: pointer' onclick='onld1('prev')'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		//}
		//	out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		
            _bw.write(_wl_block8Bytes, _wl_block8);

		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='#'  style='cursor: pointer' id='next1'  onclick='onld1('next')' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			//out.println("<A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
		classValue = "QRYODD" ;
	race_long_desc = rs.getString("RACE_LONG_DESC")==null?"":rs.getString("RACE_LONG_DESC");
	out.println("<tr><td align='left' width='10%' class='" + classValue + "'>");
	String code = rs.getString("ETHNIC_GROUP_CODE");

	out.println("<a href='../../eMP/jsp/EthnicSubGroupModify.jsp?ETHNIC_GROUP_CODE="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td width='30%' class='" + classValue + "'>");
	out.println( rs.getString("LONG_DESC") );
	out.println("</td><td width='25%' class='" + classValue + "'>");
	out.println(rs.getString("SHORT_DESC") );
	out.println("</td><td  width='25%' class='" + classValue + "'>");
	out.println(" "+race_long_desc+" ");
	out.println("</td><td width='10%' class='" + classValue + "' align='center'>");
	/*if ( rs.getDate("eff_date_from") != null )
	{
	 java.util.Date date = rs.getDate("eff_date_from");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 String dateString = formatter.format(date);
	 out.println(dateString);
	 dateString = null;
	 formatter = null;
	}
	else
	{
	     out.println("&nbsp;");
	}
	out.println("</td><td class='" + classValue + "'>");

	if ( rs.getDate("eff_date_to") != null )
	{
	 java.util.Date date1 = rs.getDate("eff_date_to");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 String dateString = formatter.format(date1);
	 out.println(dateString);
	}
	else
	{
	        out.println("&nbsp;");
	}
	out.println("</td><td align='center' class='" + classValue + "'>");
*/
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	
	cnt++;
	if(cnt%14 == 0 && (cnt+start-1) != end)
	{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(divcnt));
            _bw.write(_wl_block16Bytes, _wl_block16);
 divcnt++;	
	}
	}
	else
	{
		nextrecord="Y";
	}
	i++;
} 


            _bw.write(_wl_block17Bytes, _wl_block17);

		if (cnt==0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			boolean flag = false;
			if ( cnt < 14 || (!rs.next()) ) {
			
            _bw.write(_wl_block18Bytes, _wl_block18);
 flag = true;
					} else {
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(prevflg));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(divcnt-1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(divcnt-1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(prevflg));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(divcnt-1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(start));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nextrecord));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(start));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nextrecord));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(start));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((start-42)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((end-42)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(URLEncoder.encode(sbQuery.toString())));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(prevflg));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((start+42)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((end+42)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(URLEncoder.encode(sbQuery.toString())));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(divcnt-1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nextrecord));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((start+42)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((end+42)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(URLEncoder.encode(sbQuery.toString())));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(prevflg));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((start-42)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((end-42)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(URLEncoder.encode(sbQuery.toString())));
            _bw.write(_wl_block41Bytes, _wl_block41);


}catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174222042 on 05-09-2023
	}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}
}catch(Exception e) { 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174222043 on 05-09-2023
	}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}



            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
