package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patlistbyrelnprovlocn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByRelnProvLocn.jsp", 1709116007904L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script src=\'../../eCA/js/PatListByRelnProvResult.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<!-- \t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/CAStyle.css\"></link>\n -->\t\t\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\n <title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =")</title>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<style>\n\tA:link {\n\t\tCOLOR: white;\n\t}\n\n\t/*TD.FIRSTSELECTED\n\t{\n\t\tFONT-SIZE: 8pt ;\n\t\tbackground-color : #3399CC;\n\t\tborder-width: thin ;\n\t\tborder-style: inset;\n\t\tBORDER-LEFT-COLOR: #696969;\n\t\tBORDER-RIGHT-COLOR: #696969;\n\t\tBORDER-TOP-COLOR: #696969;\n\t\tBORDER-BOTTOM-COLOR: #696969 ;\n\t}\n\tTD.FIRSTNORMAL\n\t{\n\t\tFONT-SIZE: 8pt ;\n\t\tbackground-color : SLATEGRAY;\n\t\tborder-width: thin ;\n\t\tborder-style: inset;\n\t\tBORDER-LEFT-COLOR: #696969;\n\t\tBORDER-RIGHT-COLOR: #696969;\n\t\tBORDER-TOP-COLOR: #696969;\n\t\tBORDER-BOTTOM-COLOR: #696969 ;\n\t}\n\n\tTD.SECONDSELECTED{\n\t\tFONT-SIZE: 8pt ;\n\t\tbackground-color : SLATEGRAY;\n\t\tborder-width: thin ;\n\t\tborder-style: inset;\n\t\tBORDER-LEFT-COLOR: #696969;\n\t\tBORDER-RIGHT-COLOR: #696969;\n\t\tBORDER-TOP-COLOR: #696969;\n\t\tBORDER-BOTTOM-COLOR: #696969 ;\n\t}\n\tTD.SECONDNORMAL{\n\t\tFONT-SIZE: 8pt ;\n\t\tbackground-color : PALEVIOLETRED;\n\t\tborder-width: thin ;\n\t\tborder-style: inset;\n\t\tBORDER-LEFT-COLOR: #696969;\n\t\tBORDER-RIGHT-COLOR: #696969;\n\t\tBORDER-TOP-COLOR: #696969;\n\t\tBORDER-BOTTOM-COLOR: #696969 ;\n\t}\n*/\n\tA:visited {\n\t\tCOLOR:white ;\n\t}\n\tA:active {\n\t\tCOLOR: white;\n\t}\n</style>\n\n<script>\n/***********/\n\t \n\t/**********/\n\n\tfunction callResult(obj, obj1,current_pos){\n\t\tif(obj1 != \"\"){\n\t\t\t//alert(\"result\");\n\t\t\tif(document.getElementById(\"locnTab\") == null){\n\t\t\t\tif(document.getElementById(\"locnTab\").rows(0).cells(1).className==\"FIRSTSELECTED\");\n\t\t\t\t\tdocument.getElementById(\"locnTab\").rows(0).cells(1).className=\"FIRSTNORMAL\"\n\t\t\t}\n\t\t\tvar qryStr = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\tdocument.forms[0].currentPos.value=current_pos;\n\t\t\turl = qryStr+\'&locn_type=\'+obj+\'&locn_code=\'+obj1;\n\t\t\tif(document.forms[0]!=null)\n\t\t\t{\n\t\t\t\tdocument.forms[0].url.value=url;\n\t\t\t}\n\t\ttop.content.workAreaFrame.PatResultFr.RelnResultPatClass.document.forms[0].url.value=url;\n\t\ttop.content.workAreaFrame.PatResultFr.RelnResultTitle.location.href=\'PatListByRelnProvTitle.jsp?locn_type=\'+obj;\n\n\t\t}\n\t}\n\n\t\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<script>\n\tfunction callOnLoad()\n\t{\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\tcallResult(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'0\');\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t\t\tcallResult(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'0\');\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t}\n\n\t</script>\n\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<body onload=\'fillUrl(); callOnLoad();\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"formLocnResultLocation\" id=\"formLocnResultLocation\">\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' class=\'\' id=\'locnTab\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'button\'  width=\'4%\'><input type=\'button\' name=\'prev\' id=\'prev\' class=\'button\' value=\"  <<  \" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" onClick=\"showPrevLocn();\" style=\"font-size:6pt\" title=\'Previous\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onMouseOver=\'callOnMouseOver(this);\' onMouseOut=\'callOnMouseOut(this);\' style=\'cursor:pointer;\'  onclick=\"display(this);callResult(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\"  width=\'23%\' ><a href=\"javascript:callResult(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onMouseOver=\'callOnMouseOver(this);\' onMouseOut=\'callOnMouseOut(this);\' style=\'cursor:pointer;\' onclick=\"display(this);callResult(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  onMouseOver=\'callOnMouseOver(this);\' onMouseOut=\'callOnMouseOut(this);\' style=\'cursor:pointer;\'  onclick=\"display(this);callResult(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<td  class=\'button\' width=\'4%\'><input type=\'button\' name=\'next\' id=\'next\' class=\'button\' value=\"  >>  \" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" onClick=\"showNextLocn();\" style=\"font-size:6pt\" title=\'Next\' ></td>\n\t\t\t\t</tr>\n\t\t\t\t<input type=\"hidden\" name=\"pat_type\" id=\"pat_type\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"><input type=\"hidden\" name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"url\" id=\"url\" value=\'\'>\n\t\t\t\t<input type=\"hidden\" name=\"currentPos\" id=\"currentPos\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"from_disp\" id=\"from_disp\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"to_disp\" id=\"to_disp\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"flagYN\" id=\"flagYN\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n<script>\n</script>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
	
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

 int maxCount = 0;

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);

            _bw.write(_wl_block5Bytes, _wl_block5);

  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	String queryString ="";
	queryString		= request.getQueryString();
	//String locationType=request.getParameter("locationType");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block1Bytes, _wl_block1);

	int from_disp = 0;
	int to_disp = 6;
	ArrayList beanList  = new ArrayList();
	HashMap hLocn		= new HashMap();
	String locn_short_desc="", locn_code="", pat_type="";
	String disabled_next ="", disabled_prev = "", qryLocnCode="";
	pat_type		= request.getParameter("pat_type");
	qryLocnCode		= request.getParameter("relationshipCode");
	
	String labelCounter1 = request.getParameter("labelCounter")==null?"0":request.getParameter("labelCounter");
	int labelCounter=Integer.parseInt(labelCounter1);
	int tempLabelCounter=labelCounter;
	String flagYN = request.getParameter("flagYN")==null?"":request.getParameter("flagYN");
	String flagLastYN = request.getParameter("flagLastYN")==null?"":request.getParameter("flagLastYN");
////////

	String groupByReln=request.getParameter("groupByReln");
	String groupByEpisode=request.getParameter("groupByEpisode");
	if(groupByReln.equals("N") && groupByEpisode.equals("Y") && qryLocnCode.equals("ALL"))
		qryLocnCode="RALL";

/////
	if(queryString	== null)queryString="";
	if(pat_type	== null)pat_type="";
	if(qryLocnCode ==  null) qryLocnCode = "";

	try{
		//String pract_id		= (String)session.getValue("ca_practitioner_id");
		//String facility_id	= (String)session.getValue("facility_id");
		String isError = "";
		boolean isFirstLevel = false;
		if(pat_type.equals("")){
			isError="QQ";
		}
		if(isError.equals("")){
			isFirstLevel = PatSearch.isFirstLevel();
			if(isFirstLevel){
				beanList = PatSearch.getSecondLevel(pat_type);
				maxCount = beanList.size();
			}
		}
	}catch(Exception e){
		out.println("<script>alert("+e+");</script>");
	}finally {
}

	String start = request.getParameter("start_disp");
	String end = request.getParameter("end_disp");
	
            _bw.write(_wl_block11Bytes, _wl_block11);

	if(start == null){
		from_disp = 0;
		flagYN = "true";
		String ln_code ="";

		HashMap hTable = (HashMap)beanList.get(0);
		ln_code = (String)hTable.get("LOCN_CODE");

		if(!qryLocnCode.equals("")){
			if( qryLocnCode.equals("ALL")){
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ln_code));
            _bw.write(_wl_block14Bytes, _wl_block14);

			}else{
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(qryLocnCode));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
		}
	}
	else
		from_disp = Integer.parseInt(start);

	
            _bw.write(_wl_block17Bytes, _wl_block17);

	if(end == null)
		to_disp = 2;
	else
		to_disp = Integer.parseInt(end);

	if(to_disp >= maxCount){
		disabled_next = "disabled";
	}else{
		disabled_next = "";
	}

	if(from_disp <= 1){
		disabled_prev = "disabled";
	}else{
		disabled_prev = "";
	}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disabled_prev));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
					String className = "";
					if(flagYN.equals("false") && !flagLastYN.equals("true"))
					{
							className = "FIRSTSELECTED";
							hLocn			=	(HashMap)beanList.get(labelCounter);
							locn_short_desc =	(String)hLocn.get("LOCN_SHORT_DESC");
							locn_code		=	(String)hLocn.get("LOCN_CODE");
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(className));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(labelCounter));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(labelCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locn_short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

					}
					for(int i=from_disp; i<=to_disp; i++){
						labelCounter=i;
						if(i==tempLabelCounter)
								className = "FIRSTSELECTED";
						else
								className = "FIRSTNORMAL";

						if(i < maxCount ){
							hLocn			=	(HashMap)beanList.get(i);
							locn_short_desc =	(String)hLocn.get("LOCN_SHORT_DESC");
							locn_code		=	(String)hLocn.get("LOCN_CODE");

						}else{
								className="WHITE";
								locn_short_desc ="&nbsp;";
								locn_code	    ="";
						}
						if(locn_short_desc == null)locn_short_desc="";
						if(locn_code == null)locn_code="";
						
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(className));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(labelCounter));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(labelCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locn_short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
	}
					if(flagLastYN.equals("true")){
							className = "FIRSTSELECTED";
							hLocn			=	(HashMap)beanList.get(tempLabelCounter);
							locn_short_desc =	(String)hLocn.get("LOCN_SHORT_DESC");
							locn_code		=	(String)hLocn.get("LOCN_CODE");
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(className));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tempLabelCounter));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tempLabelCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locn_short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
	}	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled_next));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tempLabelCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(from_disp));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(flagYN));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewPatientListbyPPRelationResult.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
