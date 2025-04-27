package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.DCRIncidentsBean;
import eCA.DCRSpiraIncidentsBean;
import eCA.CommonCollectionUtils;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dcrincidentdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eCA/jsp/DCRIncidentDetails.jsp", 1724346980282L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<html>\r\n\t<head>\r\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\t\r\n\t<link rel=\'StyleSheet\' href=\'../../eCA/html/DCRStyle.css\' type=\'text/css\' />\r\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\r\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\r\n\t<script src=\'../../eCA/js/DCRTree.js\' language=\'javascript\'></script>\r\n\t<script src=\'../../eCA/js/DCRmasks.js\' language=\'javascript\'></script>\r\n\t</head>\r\n\t<body class=\'dcrBlankPage\' onKeyDown=\"lockKey()\" onMouseDown=\"CodeArrest()\">\r\n\t\t<form name=\'DcrIncFrm\'>\t\t\r\n\t\t\t<table align=\'center\' border=\'0\'  cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' class=\'dcrBlankPage\'>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\'DCRCOLUMNHEADERCENTER\' colspan=\'2\'><b>Incident Details</b></td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t<table align=\'center\' border=\'0\'  cellpadding=\'3\' cellspacing=\'0\' width=\'95%\'>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\'LABEL1\' width=\'20%\'>Incident Ref No</td>\r\n\t\t\t\t\t<td class=\'LABEL1\' ><input type=\'text\' size=\'35\' maxlength=\"8\" name=\'dcrIncdRefTxt\' value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" onblur=\'hideTip(\"dcrIncdRefTxt\", \"txtINCDHint\");validateIncidentNum(this);\' onkeypress=\"showSpiraDIV();return allowValidIncidentNum(this);disableCtrlKeyCombination(event);\"  onKeyDown=\"return disableCtrlKeyCombination(event);\" onKeyUp=\'dispSpiraIDs(this);\'><img src=\'../../eCommon/images/mandatory.gif\'/><div class=\'hideDIV\' id=\'txtINCDHint\'/>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</div><div id=\'drpDiv\' style=\'position:absolute;display:none;overflow:overflow\'></div></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td class=\'CLABEL1\' colspan=\'2\'><div id = \'hintDivIncd\' style=\'display:none\' >Please enter Incident Ref No.</div>&nbsp;<div id = \'spiraDiv\' style=\'display:none\' >NOTE : Invalid TFS ID will refresh empty page</div></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<!-- <td class=\'LABEL1\'>SCF/CRF/ICN No</td> -->\r\n\t\t\t\t\t <td class=\'LABEL1\'>UserStory/Bug Name</td> \r\n\t\t\t\t\t<td class=\'LABEL1\'><input type=\'text\' size=\'90\' maxlength=\"90\" name=\'dcrScfTxt\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' onblur=\'hideTip(\"dcrScfTxt\", \"txtSCFHint\");\' onkeypress=\'return allowAlphaNumeric(event,this);\' ><img src=\'../../eCommon/images/mandatory.gif\'/><div class=\'hideDIV\' id=\'txtSCFHint\'/></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr id=\'incdDesc\'>\r\n\t\t\t\t\t<td class=\'LABEL1\' width=\'20%\' valign=\'top\'>Description</td>\r\n\t\t\t\t\t<td class=\'LABEL1\' ><textarea name=\'incdDesctxtarea\' rows=\'15\' cols=\'75\' readOnly>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</textarea></td>\r\n\t\t\t\t</tr>\t\t\t\t\t\t\t\r\n\t\t\t\t<tr>\t\t\t\t\t\r\n\t\t\t\t\t<td class=\'RLABEL1\' colspan=\" 2\" align=\"right\">\r\n\t\t\t\t\t\t<input type=\'button\' value=\'Add\' onClick=\"checkIncd();addElementToTree(\'DcrIncFrm\',\'INCIDENT\');\" class=\'actButton\'>&nbsp;<input type=\'button\' value=\'Remove\' onClick=\"remove(\'DcrIncFrm\',\'INCD\',document.DcrIncFrm.dcrIncdRefTxt.value);reloadPage(\'DCRIncidentDetails.jsp\',\'\')\" class=\'actButton\'>&nbsp;<input type=\'button\' value=\'Cancel\' onclick=\'reloadPage(\"DCRIncidentDetails.jsp\",\"\")\' class=\'actButton\'>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t</form>\r\n\t</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);

		request.setCharacterEncoding("UTF-8");	
				
		String keyName = request.getParameter("strDCRRefNo") == null ? "" : request.getParameter("strDCRRefNo");
		String spiraIncd = request.getParameter("spiraIncd") == null ? "" : request.getParameter("spiraIncd");
		String spiraIncdID = request.getParameter("spiraIncdID") == null ? "" : request.getParameter("spiraIncdID");
		String mode = "";
		String incdRef = "";
		String incdScf = "";
		String incdDesc = "";
		String disabledTxt = "";
		String spriaIncdDesc = "";
		String incdScfNo = "";
		String invalidSpiraINCD = "";
		boolean alertFlag = false;

		//System.err.println("DCRIncidentDetails.jsp.jsp -----------keyName 22------------------>"+keyName);
		//System.err.println("DCRIncidentDetails.jsp.jsp -----------spiraIncd 22------------------>"+spiraIncd);
		//System.err.println("DCRIncidentDetails.jsp.jsp -----------spiraIncdID 22------------------>"+spiraIncdID);


		if(keyName != null && !keyName.equals(""))
		{
			mode = "Modify";
		}
//System.err.println("DCRIncidentDetails.jsp.jsp -----------mode 31------------------>"+mode);
		if(mode.equals("Modify"))
		{
			disabledTxt = "disabled";
			DCRIncidentsBean dcrBeanObj = (DCRIncidentsBean)getObjectFromBean("dcrBeanObj","eCA.DCRIncidentsBean",session);
			CommonCollectionUtils incds =  dcrBeanObj.getIncidentValues();
			HashMap<String, String> incdMap = (HashMap)incds.get(keyName);

			//System.err.println("DCRIncidentDetails.jsp.jsp -----------incds 39------------------>"+incds);

			
			if(incdMap != null)
			{
				incdRef = incdMap.get("incRef");
				incdScf = incdMap.get("incSPR");
				incdDesc = incdMap.get("incDes");				
			}

			//System.err.println("DCRIncidentDetails.jsp.jsp -----------incdRef 49------------------>"+incdRef);
			//System.err.println("DCRIncidentDetails.jsp.jsp -----------incdScf 49------------------>"+incdScf);
			//System.err.println("DCRIncidentDetails.jsp.jsp -----------incdDesc 49------------------>"+incdDesc);

			spiraIncdID = incdRef;
			if (spiraIncdID.length() == 4)
			{
				spiraIncdID = spiraIncdID.substring(7, spiraIncdID.length());
			}
			else if (spiraIncdID.length() == 5)
			{
				spiraIncdID = spiraIncdID.substring(6, spiraIncdID.length());
			}
			else if (spiraIncdID.length() == 6)
			{
				spiraIncdID = spiraIncdID.substring(5, spiraIncdID.length());
			}
			else if (spiraIncdID.length() == 7)
			{
				spiraIncdID = spiraIncdID.substring(4, spiraIncdID.length());
			}
			else if (spiraIncdID.length() == 8)
			{
				spiraIncdID = spiraIncdID.substring(3, spiraIncdID.length());
			}
			else if (spiraIncdID.length() == 9)
			{
				spiraIncdID = spiraIncdID.substring(2, spiraIncdID.length());
			}			
		}

//System.err.println("DCRIncidentDetails.jsp.jsp -----------spiraIncdID 80------------------>"+spiraIncdID);

		if(!spiraIncdID.equals(""))
		{

			//System.err.println("DCRIncidentDetails.jsp.jsp -----------spiraIncdID 85------------------>"+spiraIncdID);
			DCRSpiraIncidentsBean spBean = new DCRSpiraIncidentsBean();
			Map<String, String> incdSPMap = spBean.getSpiraIncidents(spiraIncdID);

			//System.err.println("DCRIncidentDetails.jsp.jsp -----------incdSPMap 89------------------>"+incdSPMap);

			if(incdSPMap != null)
			{
				spriaIncdDesc = incdSPMap.get("SPIRAINCDID")==null?"":incdSPMap.get("SPIRAINCDID");
				incdScfNo = incdSPMap.get("INCDSCFNO")==null?"":incdSPMap.get("INCDSCFNO");

				//System.err.println("DCRIncidentDetails.jsp.jsp -----------spriaIncdDesc 96------------------>"+spriaIncdDesc);
				//System.err.println("DCRIncidentDetails.jsp.jsp -----------incdScfNo 96------------------>"+incdScfNo);
				//System.err.println("DCRIncidentDetails.jsp.jsp -----------incdRef 96------------------>"+incdRef);
				//System.err.println("DCRIncidentDetails.jsp.jsp -----------spiraIncd 96------------------>"+spiraIncd);

				if(incdRef.equals(""))
				{
					incdRef = spiraIncd;
				}
				if(incdScf.equals(""))
				{
					incdScf = incdScfNo;
				}

				//System.err.println("DCRIncidentDetails.jsp.jsp -----------incdRef 96------------------>"+incdRef);
				//System.err.println("DCRIncidentDetails.jsp.jsp -----------incdScf 96------------------>"+incdScf);
			}
			else
			{
				invalidSpiraINCD = "Invalid Spria ID";
				alertFlag = true;
			}
		}
//out.println("<br>spriaIncdDesc --------> "+spriaIncdDesc);

	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(incdRef));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(disabledTxt));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(invalidSpiraINCD));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(incdScf));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(spriaIncdDesc));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
