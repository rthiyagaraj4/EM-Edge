package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __casectiontemplatelinkingdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CASectionTemplateLinkingDetail.jsp", 1736789709331L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    \n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script>\n\t\tfunction callOnRestrict(currentCompIdSrlNo,compItemId,comp_id)\n\t\t{\n\t\t\tvar retVal\t\t\t=\t\"\";\n\t\t\tvar dialogHeight\t=\t\"80vh\";\n\t\t\tvar dialogWidth\t\t=\t\"50vw\";\n\t\t\tvar dialogTop\t\t=\t\"0vh\";\n\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\tvar action_url\t\t=\t\'../../eCA/jsp/CASectionTemplateLinkingListItmesMain.jsp\';\n\t\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\" + dialogTop +\" ; scroll=auto; status:\" + status;\n\t\t\tvar compIdSrlNo = document.forms[0].compIdSrlNo.value;\n\t\t\taction_url\t\t\t+=\t\"?comp_id=\"+comp_id+\"&currentCompIdSrlNo=\"+currentCompIdSrlNo+\"&compItemId=\"+compItemId+\"&compIdSrlNo=\"+compIdSrlNo;\n\t\t\tretVal = top.window.showModalDialog(action_url,arguments,features);\n\t\t\t//parent.templateLinkingDetailFrame.location.href = parent.templateLinkingDetailFrame.location.href;\n\t\t}\n\t\tfunction enableFields(obj,compId_srlNo)\n\t\t{\n\t\t\tif(obj.checked)\n\t\t\t{\n\t\t\t\teval(\"document.compLinkingForm.status_\"+compId_srlNo+\".value=\'false\'\");\n\t\t\t\teval(\"document.compLinkingForm.status_\"+compId_srlNo+\".disabled=false\");\n\t\t\t\tif(eval(document.getElementById(\"anchor_\"+compId_srlNo))!=null)\n\t\t\t\t{\n\t\t\t\t\teval(\"document.compLinkingForm.statusItem_\"+compId_srlNo+\".disabled=false\");\n\t\t\t\t\t//eval(\"document.compLinkingForm.statusItem_\"+compId_srlNo+\".style.display=\'inline\'\");\n\t\t\t\t\tdocument.getElementById(\"anchor_\"+compId_srlNo).innerText=\"Restrict\";\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\teval(\"document.compLinkingForm.status_\"+compId_srlNo+\".disabled=true\");\n\t\t\t\tif(eval(document.getElementById(\"anchor_\"+compId_srlNo))!=null)\n\t\t\t\t{\n\t\t\t\t\teval(\"document.compLinkingForm.statusItem_\"+compId_srlNo+\".disabled=true\");\n\t\t\t\t\t//eval(\"document.compLinkingForm.statusItem_\"+compId_srlNo+\".style.display=\'none\'\");\n\t\t\t\t\t//eval(document.getElementById(\"anchor_\"+compId_srlNo+\".innerText=\'\'\"));\n\t\t\t\t\tdocument.getElementById(\"anchor_\"+compId_srlNo).innerText=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n</head>\n<body onKeyDown=\"lockKey()\">\n<form name=compLinkingForm action=\"CASectionTemplateUpdateBean.jsp\" method=post target=dummyFrame>\n\t<table width=\'100%\' class=\'grid\'>\n\t<tr>\n\t\t<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td class=\'columnheadercenter\' colspan = 2>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"><select name =\"status_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" onclick=\"if(this.value==\'true\' && \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'==\'L\'){  /*document.compLinkingForm.statusItem_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =".style.display=\'none\';*/ document.getElementById(\"anchor_\")";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =".innerText=\'\';}else if(this.value==\'false\' && \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =".style.display=\'inline\'; */document.getElementById(\"anchor_\")";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =".innerText=\'Restrict\';}\">\n\t\t\t\t\t\t<option value = \"false\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">&nbsp;&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;&nbsp;</option>\n\t\t\t\t\t\t<option value = \"true\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;&nbsp;</option>\n\t\t\t\t\t</select>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t&nbsp;<select name =\"statusItem_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" style=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" selected>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t</select>&nbsp;&nbsp;<a id=\"anchor_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"  href=\"javascript:callOnRestrict(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\')\" >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"><input type=checkbox value=\"Y\" name=\"check";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"check";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onclick=\"enableFields(this,\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\')\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="><input type=hidden name=\"currentCompIdSrlNo";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"currentCompIdSrlNo";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"><input type=hidden name=\"currentCompType";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"currentCompType";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t<input type=hidden name=\"currentCompTypeLinked";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"currentCompTypeLinked";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"><!--INC61905-->\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t</table>\n\t<input type=hidden name=count value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=hidden name=compItemId value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=hidden name=compIdSrlNo value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=hidden name=calledFrom value=\"ONCHANGE\">\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );
	
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

/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
--------------------------------------------------------------------------------------------------------------------------------
?				?				?				Created
11/04/2017     	INC61905       	DineshT        	The Scoring functionality In Notes should work in the similar manner as in Charts 												i.e on selection of individual variable, the score gets automatically calculated
--------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);
	

            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String compId=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");
	String srlNo=request.getParameter("srl_no")==null?"":request.getParameter("srl_no");

	Vector dependent = templateBean.getAssociatedComponents(compId+srlNo);
	String compType=request.getParameter("comp_type")==null?"":request.getParameter("comp_type");
	String sectionHdgCode= request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code");	
	String compItemId= request.getParameter("compItemId")==null?"":request.getParameter("compItemId");
	String selectedCompIds = request.getParameter("selectedCompIds")==null?"":request.getParameter("selectedCompIds");
	selectedCompIds = java.net.URLDecoder.decode(selectedCompIds);
	

	

   String selectedSrlno ="";
    if(dependent != null)
	{
		Enumeration enumeration = dependent.elements();
        while(enumeration.hasMoreElements())
		{
	  selectedSrlno=selectedSrlno+"'"+enumeration.nextElement()+"'";
      if(enumeration.hasMoreElements())
      selectedSrlno = selectedSrlno + ",";
		}
	}

	if(compItemId == null || compItemId.equals("") )
	{
		if(compType.equals("L"))
			compItemId = "";  			//compItemId = compId+srlNo;

		else
			compItemId = "Y";    		//compItemId = compId+srlNo+"Yes";
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	int rowNo=0;

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		try
		{
			String currentCompId = "";
			String currentCompPrompt = "";
			String currentCompType = "",currentCompTypeDesc="";
			int currentSrlNo = -1;
			String listItemId = "",defaultItemId="";
			String listItemText = "";							
			String currentCompIdSrlNo = "";
			//String sql1 = "";
			String defaultYN= "";
			String classValue = "";
			String disabled = "disabled",display="display:none";
			String checked = "";
			String selectE="",selectD="",selected="",anchorText="",statusWhenList="";
			Object status = null;
			Hashtable itemHash = null;
			Enumeration enum1 = null;
			String currentCompTypeLinked = "";//INC61905
			con = ConnectionManager.getConnection(request);

			//String sql = "select comp_id ,comp_prompt, comp_type, srl_no,decode(comp_type,'C','Yes/No','D','Date','T', 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line') comp_type_desc from CA_SECTION_DISCR_MSR_VW where sec_hdg_code=? and comp_id in ('"+selectedCompIds+"')" ;
			String sql = "select comp_id ,comp_prompt, comp_type, srl_no,decode(comp_type,'C','Yes/No','D','Date','T', 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line') comp_type_desc,nvl(STD_COMP_ID,'') STD_COMP_ID from CA_SECTION_DISCR_MSR_VW where sec_hdg_code=? and comp_id in ('"+selectedCompIds+"')" ;
			if(!selectedSrlno.equals(""))
            sql = sql + " and comp_id||srl_no in ("+selectedSrlno+")";
			
			sql = sql + " order by row_pos_no,column_pos_no";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sectionHdgCode);
					
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				rowNo++;
				/*if(rowNo%2!=0)
					classValue = "QRYODD";
				else
					classValue = "QRYEVEN";*/

					classValue = "gridData";

				currentCompId  = rs.getString(1);
				currentCompPrompt  = rs.getString(2);
				currentCompType  = rs.getString(3);
				currentSrlNo = rs.getInt(4);
				currentCompTypeDesc = rs.getString(5);
				currentCompTypeLinked = rs.getString("STD_COMP_ID")==null||rs.getString("STD_COMP_ID").equals("null")?"":rs.getString("STD_COMP_ID");//INC61905
				currentCompIdSrlNo = currentCompId+currentSrlNo;
				//checking whether bean value exists
				//out.println(currentCompIdSrlNo+"    "+compItemId);
				//out.println(templateBean.getStatus(currentCompIdSrlNo,compItemId));
				//*****
				//status also contains the items in the list in case of List Items are restricted
				
				if (!currentCompType.equals("L") )
				{
					status=templateBean.getStatus(currentCompIdSrlNo,compItemId);
				}

				
				//*****

				if(currentCompType.equals("L"))
				{
					statusWhenList = (String)templateBean.getStatusEDWhenList(currentCompIdSrlNo,compItemId);
					//out.println("<script>alert('"+statusWhenList+"')</script>");
					if(statusWhenList!=null)
					{
						disabled = "";
						//display="display";
						checked = "checked";
					}
					else
					{
						disabled = "disabled";
						//display="display:none";
						checked = "";
					}

				}
				else if(status!=null) //for all the other components Enable/Disable 
				{
					
					disabled = "";
					checked = "checked";
				}
				else
				{
					disabled = "disabled";
					checked = "";
				}
				
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(currentCompId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(currentCompPrompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(currentCompTypeDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);

					//checking the status if comming from bean
					if(currentCompType.equals("L")){
						if(statusWhenList!=null && statusWhenList.equals("false")){
							selectE= "selected";
							anchorText = "Restrict";
						}
						else if(statusWhenList!=null && statusWhenList.equals("true")){
							selectD = "selected";
							//display="display:none";
							anchorText = "";
						}
					}else{
						if(status!=null && status.equals("false"))
							selectE= "selected";
						else if(status!=null && status.equals("true"))
							selectD = "selected";
					}
					//------------
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(currentCompType));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(currentCompType));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(selectE));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(selectD));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
	selectE = "";
						selectD = "";
					
            _bw.write(_wl_block28Bytes, _wl_block28);
if(currentCompType.equals("L")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(display));
            _bw.write(_wl_block31Bytes, _wl_block31);

						//check if the bean value exist ie already something is defined or not 
						if(status!=null)
						{
							//anchorText = "Restrict";
							itemHash = new Hashtable((HashMap)status);
							defaultItemId = (String)itemHash.get("DEFAULT_CODE");
							enum1 = itemHash.keys();
							while(enum1.hasMoreElements())
							{
								listItemId = (String)enum1.nextElement();
								if(!listItemId.equals("DEFAULT_CODE"))
								{
									listItemText = (String)itemHash.get(listItemId);
									if(defaultItemId.equals(listItemId))
										selected = "selected";
								
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(listItemId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(listItemText));
            _bw.write(_wl_block34Bytes, _wl_block34);

								}
								selected = "";
							}
						}
						else
						{
							
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

							try
							{
								listItemId = "";
								listItemText = "";
								defaultYN = "";
								sql = "Select RESULT_VALUE, REF_RNG_DESC,DFLT_YN from AM_DISCR_MSR_REF_RNG_LIST where DISCR_MSR_ID = ?  order by REF_RANGE_SEQ ";
								pstmt1 = con.prepareStatement(sql);
								pstmt1.setString(1,currentCompId);
								rs1=pstmt1.executeQuery();							
								while(rs1.next())
								{
									listItemId = rs1.getString(1);	
									listItemText = rs1.getString(2);
									defaultYN = rs1.getString(3);
									if(defaultYN.equals("Y"))
									{
									
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(listItemId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(listItemText));
            _bw.write(_wl_block39Bytes, _wl_block39);

									}
									else
									{
									
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(listItemId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(listItemText));
            _bw.write(_wl_block39Bytes, _wl_block39);

									}
									
								}

							}
							catch(Exception e)
							{
								//out.println("From list:"+e);//common-icn-0181
							       e.printStackTrace();//COMMON-ICN-0181
							}
						}
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(compItemId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(currentCompId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(currentCompType));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(anchorText));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(currentCompType));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(currentCompTypeLinked));
            _bw.write(_wl_block58Bytes, _wl_block58);

						
				status = null;
				}
			itemHash = null;
			enum1 = null;
			status = null;
			statusWhenList = null;
		}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if (rs1!=null) rs1.close();
			if (pstmt1!=null) pstmt1.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
			
		}
	
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rowNo));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(compItemId));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((compId+srlNo)));
            _bw.write(_wl_block62Bytes, _wl_block62);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ComponentID.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ComponentPrompt.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ComponentType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Enable.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Disable.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
