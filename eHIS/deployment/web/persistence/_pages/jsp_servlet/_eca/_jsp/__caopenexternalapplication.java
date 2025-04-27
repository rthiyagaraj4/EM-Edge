package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.security.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __caopenexternalapplication extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAOpenExternalApplication.jsp", 1742378573384L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n<script>\n\tfunction invokeFun(fileName)\n\t{\n\t\t//alert(\'fileName from JS---\'+fileName);\n\t\tif(fileName != \"\")\n\t\t{\n\t\t\tcallOnImgClick(fileName);\n\t\t}\n\t}\n</script>\n\n<SCRIPT LANGUAGE=VBScript> \n\tDim wordObj\n\n\tSub callOnImgClick(fileName)\n\t\t\'MsgBox(fileName)\n\t\tcall openWordDoc(fileName)\n\tEnd Sub\n\n\tSub openWordDoc(filePathName)\n\t\t\'MsgBox(filePathName)\n\t\tSet wordObj = CreateObject(\"Word.Application\")\n\t\t\'MsgBox(wordObj)\n\t\twordObj.Visible = true\n\t\twordObj.Documents.Open filePathName\n\t\t\'wordObj.setfocus()\n\t\t\'wordObj.focus()\n\tEnd Sub\n\n</SCRIPT>\n<title></title>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\"../../eCA/js/RecClinicalNotesFileUpload.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>\n\t\t\t\t\n\t\t\t\t        var ImageUrl = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\tvar window_name = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';     //\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\tretVal = window.open(ImageUrl,window_name,\' height= 725, width= 1010,left = 0, top=0, status=yes,toolbar=yes\');\n\t\t\t\t\t\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\t\tvar ImageUrl = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\t\t\n\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\tvar window_name = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';    \n\t\t\t\t\t\tretVal = window.open(ImageUrl,window_name,\' height= 725, width= 1024,left = 0, top=0, status=yes,toolbar=yes,fullscreen=no,location=no,resize=yes\');\n\t\t\t\t\t\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tvar ImageUrl =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'; \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tvar screenHeight=screen.height;\n\t\t\t\t\t\t\t\t\t\t\tvar screenWidth=screen.width;\n\t\t\t\t\t\t\t\t\t\t\tvar features =\"location=0,height=\"+screenHeight+\",width=\"+screenWidth+\",top=0,left=0,resizable=yes\";\n\t\t\t\t\t\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\t\t\t\t\t\tvar window_name = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'; \n\t\t\t\t\t\t\t\t\t\t\twindow.open(ImageUrl,window_name,features);\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'; \t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tvar oShell = new ActiveXObject(\"WScript.Shell\");\n\t\t\t\t\t\t\t\t\t\t\toShell.Run(\'iexplore.exe \' +ImageUrl , 1);\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<script>\n\t\t\t\tinvokeFun(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\t\n\t\t\t</script>\t\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar HTMLVal=\"<html><body onKeyDown=\'lockKey()\'><form name=\'OpenDocForm\' id=\'OpenDocForm\' method=\'get\' action=\'../../eCA/jsp/ViewLabWordResultData.jsp\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'event_code\' id=\'event_code\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'event_group\' id=\'event_group\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'event_desc\' id=\'event_desc\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'specimen_no\' id=\'specimen_no\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'template_name\' id=\'template_name\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\"+\n\t\t\t\t\t\t\"</form></body></html>\";\n\t\t\t\t\t\tdocument.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\t\t\t\tdocument.OpenDocForm.submit();\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<script>\n\t\t\t\t\tvar retVal;\n\t\t\t\t\tvar window_name = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';  \n\t\t\t\t\tretVal = window.open(\'../../eCA/jsp/ViewLabWordResultMain.jsp?patient_id=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&event_code=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&event_group=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&event_desc=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&facility_id=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&specimen_no=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',window_name,\' height= 200, width= 350,left = 350, top=150, location=no,menubar=yes,status=yes,toolbar=yes,resizable=no\');\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\t\t\t//\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="patientid=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&accession=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&user=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&password=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\';\n\t\t\t\t\t\t\n\n\n\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\tvar window_name = \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\t\t\tretVal = window.open(ImageUrl,window_name,\' height= 725, width= 1024,left = 0, top=0, status=yes,toolbar=yes,fullscreen=no,location=no,resize=yes\');\n\t\t\t\t\t\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<script>\n\t\t\t\tvar ImageUrl =\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\';  \n\t\t\t\tvar screenHeight=screen.height;\n\t\t\t\tvar screenWidth=screen.width;\n\t\t\t\tvar features =\"location=0,height=\"+screenHeight+\",width=\"+screenWidth+\",top=0,left=0,resizable=yes\";\n\t\t\n\t\t\t\tvar retVal;\n\t\t\t\tvar window_name = \'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t//retVal = window.open(ImageUrl,window_name,\' height= 725, width= 1020,left = 0, top=0, status=yes,toolbar=yes,resize=yes\');\n\t\t\t\twindow.open(ImageUrl,window_name,features);\n\t\t\t\t\t\t\t\t\n\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\';  //\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="un=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&pw=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&ris_exam_id=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\tvar window_name = \'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\t\tvar screenHeight=screen.height;\n\t\t\t\t\t\tvar screenWidth=screen.width;\n\t\t\t\t\t\tvar features =\"location=0,height=\"+screenHeight+\",width=\"+screenWidth+\",top=0,left=0,status=yes,toolbar=yes,resize=yes\";\n\t\t\t\t\t\t//retVal = window.open(ImageUrl,window_name,\' height= 725, width= 1020,left = 0, top=0, status=yes,toolbar=yes,resize=yes\');\n\t\t\t\t\t\tretVal = window.open(ImageUrl,window_name,features);\n\t\t\t\t\t\t\t\t\n\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );
	
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
 
/*
-----------------------------------------------------------------------
Date       	  Edit History  Name        	Description
-----------------------------------------------------------------------
?             100         	?           	created
03/06/2013    IN001679    Chowminya G     PACS LIVE issue
04/10/2013    IN000000	  Chowminya 	  PACS Live - AAKH		
09/12/2013	  IN044687	  Chowminya       File upload issue - MODOMAN 	
20/05/2014	  IN000001	  Chowminya		  Sunil - to handle performance issue
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------	
08/09/2014  IN050936		Chowminya										None of the order retrieving any image from RIS/PACS but already having order image in PACS		
19/11/2018  IN068797		Prakash C		19/11/2018		Ramesh G		MMS-DM-SCF-0568
04/03/2019	IN068038		Raja S			04/03/2019		Ramesh G		ML-MMOH-CRF-1205
22/12/2019	IN072022		Ramesh G										JD-INT-CRF-0001.1
08/10/2020	IN074137		Ramesh G		08/10/2020		Ramesh G		AAKH-SCF-0454.
29/10/2020	IN074119		SIVABAGYAM M	29/10/2020	RAMESH G	NMC-JD-CRF-0077
15/12/2020	7902		Sivabagyam M		15/12/2020		Ramesh G	MMS-DM-CRF-0180.1
08/11/2021	18243		Ramesh G			09/11/2021		Ramesh G	ML-BRU-CRF-0629.2
08/07/2022	21733		Ramesh G 			08/07/2022		Ramesh G	ML-BRU-CRF-0628.5
21/02/2023	41786		Ramesh G			21/02/2023		Ramesh G    MMS-DM-SCF-0865
------------------------------------------------------------------------------------------------------------------------------------------------------
*/  

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//PreparedStatement pst = null;  //Checkstyle 4.0 Beta 6
	//ResultSet rs1 = null;			//Checkstyle 4.0 Beta 6
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = (String)session.getValue("facility_id");
	
	String Histrectype		 = "";
	String Contrsysid		 = "";
	String Accessionnum		 = "";
	String Contrsyseventcode = "";
	String extimageapplid	 = "";
	String base_url			 = "";
	String login_user 		 = "";  //18243
	String default_user_id	 = "";
	String object_id		 = "";
	String appl_password	 = "";
	String ext_image_appl_name= "";
	String patient_id		 = "";
	String completed_date	 = "";
	String completed_time	 = "";
	String event_desc		 = "";
	String event_group		 = "";
	String event_code		 = "";
	String ext_image_obj_id	 = "";
	String param_def_str     = "";
	String encounter_id     = "";
	String tempStr ="";
	String or_acc_num ="";//IN001679
	String fac_query="",performing_facility_id="";//IN074119
	String study_id="";//7902
//IN068797 starts	
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	if(clob_data.equals("_CDR")){
		facility_id		 = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	}
//IN068797 ends
	java.util.Date completedDateTime= new java.util.Date(); //IN072022
	Histrectype		 = request.getParameter("Histrectype")==null?"":request.getParameter("Histrectype");
	Contrsysid		 = request.getParameter("Contrsysid")==null?"":request.getParameter("Contrsysid");
	Accessionnum	 = request.getParameter("Accessionnum")==null?"":request.getParameter("Accessionnum");
	Contrsyseventcode= request.getParameter("Contrsyseventcode")==null?"":request.getParameter("Contrsyseventcode");
	extimageapplid	 = request.getParameter("extimageapplid")==null?"":request.getParameter("extimageapplid");
	patient_id		 = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	completed_date	 = request.getParameter("completed_date")==null?"":request.getParameter("completed_date");
	completed_time	 = request.getParameter("completed_time")==null?"":request.getParameter("completed_time");
	event_desc		 = request.getParameter("event_desc")==null?"":request.getParameter("event_desc");
	encounter_id		 = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");//IN001679
	StringBuffer completed_datetime		 = new StringBuffer();
	completed_datetime.append(completed_date);
	completed_datetime.append(" ");
	completed_datetime.append(completed_time);
	SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");   //IN072022
	SimpleDateFormat formatter2=new SimpleDateFormat("HH:mm:ss:SS"); //IN072022
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	//IN072022
	login_user=(String)session.getValue("login_user");  //18243
	String Encry_login_user=""; //21733
	System.err.println("CAOpenExternalApplication.jsp==============>135");
	try
	{
		con = ConnectionManager.getConnection();
		Boolean isExtAppDataFormat = CommonBean.isSiteSpecific(con, "CA", "EXT_APP_WIHT_DATE_FORMAT"); //IN072022
		Boolean isExtAppModelWindow = CommonBean.isSiteSpecific(con, "CA", "EXT_APP_OPENWIHT_MODELWINDOW"); //IN074137
		Boolean isExtAppNewWindow = CommonBean.isSiteSpecific(con, "CA", "EXT_APP_OPENWIHT_NEWWINDOW"); //37894
		//21733 Start.
		System.err.println("CAOpenExternalApplication.jsp==============>141");
		Boolean isExtAppUserIdEncrypted =  CommonBean.isSiteSpecific(con, "OR", "EXTAPP_LOGIN_USER_ID_ENCRY");
System.err.println("CAOpenExternalApplication.jsp========isExtAppUserIdEncrypted======>"+isExtAppUserIdEncrypted);	
isExtAppUserIdEncrypted=true;	
		if(isExtAppUserIdEncrypted){
			try{
			System.err.println("CAOpenExternalApplication.jsp==============>147");			
			String data_user="app_id=bruhims&app_secret=3e17cad3f0a771d7c7af34098443d533&data.user_info.id="+login_user.toLowerCase();
			System.err.println("CAOpenExternalApplication.jsp==============>149=====>"+data_user);
			java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			System.err.println("CAOpenExternalApplication.jsp==============>1515=================>"+digest);
			digest.reset();
			System.err.println("CAOpenExternalApplication.jsp==============>1516=================>"+data_user.getBytes("UTF-8"));
            byte[] hash = digest.digest(data_user.getBytes("UTF-8"));
			System.err.println("CAOpenExternalApplication.jsp==============>153======hash.length=============>"+hash.length);
			System.err.println("CAOpenExternalApplication.jsp==============>1531===================>"+new String(hash));			
			
			// Convert byte array into signum representation
            java.math.BigInteger no = new java.math.BigInteger(1, hash);
  
            // Convert message digest into hex value
            Encry_login_user = no.toString(16);
            while (Encry_login_user.length() < 32) {
                Encry_login_user = "0" + Encry_login_user;
            }
			System.err.println("CAOpenExternalApplication.jsp==============>155======1=========>"+Encry_login_user);
			
			//Encry_login_user=javax.xml.bind.DatatypeConverter.printHexBinary(hash);
			//System.err.println("CAOpenExternalApplication.jsp==============>155======2=========>"+Encry_login_user);
			
			}catch(NoSuchAlgorithmException e){
				System.err.println("CAOpenExternalApplication.jsp==161=======Error========>"+e.toString());
			}catch(Exception e1){
				e1.printStackTrace();
				System.err.println("CAOpenExternalApplication.jsp==163=======Error========>"+e1.toString());
			}
			
		}
		//21733 End.
		if (extimageapplid.equals("DOCUL"))
		{
			//String  sql123 = "select b.EXT_IMAGE_OBJ_ID object_id from CR_ENCOUNTER_DETAIL b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.ACCESSION_NUM=?  and b.CONTR_SYS_EVENT_CODE=?  ";commented for IN068797
			String  sql123 = "select b.EXT_IMAGE_OBJ_ID object_id from CR_ENCOUNTER_DETAIL##REPDB## b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.ACCESSION_NUM=?  and b.CONTR_SYS_EVENT_CODE=?  ";//IN068797
		
			sql123 = sql123.replaceAll("##REPDB##",RepDb);//IN068797
			pstmt = con.prepareStatement(sql123);
			pstmt.setString(1,Histrectype);
			pstmt.setString(2,Contrsysid);
			pstmt.setString(3,Accessionnum);
			pstmt.setString(4,Contrsyseventcode);
			System.out.println("CAOpenExternalApplication.jsp-------168----------Histrectype------->"+Histrectype);
			System.out.println("CAOpenExternalApplication.jsp-------169----------Contrsysid------->"+Contrsysid);
			System.out.println("CAOpenExternalApplication.jsp-------170----------Accessionnum------->"+Accessionnum);
			System.out.println("CAOpenExternalApplication.jsp-------171----------Contrsyseventcode------->"+Contrsyseventcode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				
				object_id= rs.getString("object_id")==null?"":rs.getString("object_id");
			
			}
			System.out.println("CAOpenExternalApplication.jsp-------181----------object_id------->"+object_id);
			if(rs != null ) rs.close();
			if(pstmt != null ) pstmt.close();
			//IN044687 - Start Added else if condition
			if (object_id.equals("")) 
				object_id =Accessionnum;
			else if(!object_id.equals("") && Accessionnum.contains("!") && !object_id.contains("$") )
			{
				//sql123 = "select LINKED_NOTE_ACCESSION_NUM from or_result_detail where order_id = (select ORDER_ID from or_order_line where EXT_APPL_ACCESSION_NUM = ?)";commented for IN068797
				sql123 = "select LINKED_NOTE_ACCESSION_NUM from or_result_detail##REPDB## where order_id = (select ORDER_ID from or_order_line##REPDB## where EXT_APPL_ACCESSION_NUM = ?)";//IN068797
			
				sql123 = sql123.replaceAll("##REPDB##",RepDb);//IN068797
					pstmt = con.prepareStatement(sql123);
					pstmt.setString(1,object_id);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						object_id = rs.getString("LINKED_NOTE_ACCESSION_NUM")==null?"":rs.getString("LINKED_NOTE_ACCESSION_NUM");
					}
					System.out.println("CAOpenExternalApplication.jsp-------200----------object_id------->"+object_id);
					if(rs != null ) rs.close();
					if(pstmt != null ) pstmt.close();
			}
			//IN044687 - End
			out.println("<script>openDocWindow('"+object_id+"','"+Contrsyseventcode+"')</script>");
		}
		else
		{		
				//String sql = "select BASE_URL ,DEFAULT_USER_ID,app_password.DECRYPT(DEFAULT_USER_PASSWORD) DEFAULT_USER_PASSWORD,EXT_IMAGE_APPL_NAME,PARAM_DEF_STR from CA_EXT_IMAGE_APPL_LANG_VW where EXT_IMAGE_APPL_ID = ? AND LANGUAGE_ID = ?";commented for IN068797
				String sql = "select BASE_URL ,DEFAULT_USER_ID,app_password.DECRYPT(DEFAULT_USER_PASSWORD) DEFAULT_USER_PASSWORD,EXT_IMAGE_APPL_NAME,PARAM_DEF_STR from CA_EXT_IMAGE_APPL_LANG_VW##REPDB## where EXT_IMAGE_APPL_ID = ? AND LANGUAGE_ID = ?";//IN068797
				sql = sql.replaceAll("##REPDB##",RepDb);//IN068797
			
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1,extimageapplid);
				pstmt.setString(2,locale);
				
				System.out.println("CAOpenExternalApplication.jsp-------218----------extimageapplid------->"+extimageapplid);
				System.out.println("CAOpenExternalApplication.jsp-------219----------locale------->"+locale);
				
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					base_url = rs.getString("base_url")==null?"":rs.getString("base_url");
					appl_password= rs.getString("DEFAULT_USER_PASSWORD")==null?"":rs.getString("DEFAULT_USER_PASSWORD");
					default_user_id=rs.getString("DEFAULT_USER_ID")==null?"":rs.getString("DEFAULT_USER_ID");
					ext_image_appl_name=rs.getString("EXT_IMAGE_APPL_NAME")==null?"":rs.getString("EXT_IMAGE_APPL_NAME");
					param_def_str=rs.getString("PARAM_DEF_STR")==null?"":rs.getString("PARAM_DEF_STR");
				}
				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();
				System.out.println("CAOpenExternalApplication.jsp-------233----------base_url------->"+base_url);
				System.out.println("CAOpenExternalApplication.jsp-------234----------appl_password------->"+appl_password);
				System.out.println("CAOpenExternalApplication.jsp-------235----------default_user_id------->"+default_user_id);
				System.out.println("CAOpenExternalApplication.jsp-------236----------ext_image_appl_name------->"+ext_image_appl_name);
				System.out.println("CAOpenExternalApplication.jsp-------237----------param_def_str------->"+param_def_str);
				
			if(Contrsysid.equals("OR") && !patient_id.equals("") && !completed_date.equals("") && !completed_time.equals("") && !event_desc.equals(""))
			{
				object_id		= Accessionnum;
				System.out.println("CAOpenExternalApplication.jsp-------241----------object_id------->"+object_id);
			}
			else
			{
			
				//IN001679 - Start
				if(Contrsysid.equals("OR") && !Accessionnum.contains("!"))
				{
					rs = null; //IN000000
					//sql = "select (ORDER_TYPE_CODE||'!'||ORDER_ID||'!'||report_srl_no||'!'||srl_no||'!'||line_srl_no) ACCESSION_NUM from or_result_detail where order_id = (select ORDER_ID from or_order_line where EXT_APPL_ACCESSION_NUM = ?) ";commented for IN068797			
					sql = "select (ORDER_TYPE_CODE||'!'||ORDER_ID||'!'||report_srl_no||'!'||srl_no||'!'||line_srl_no) ACCESSION_NUM from or_result_detail##REPDB## where order_id = (select ORDER_ID from or_order_line##REPDB## where EXT_APPL_ACCESSION_NUM = ?) ";//IN068797
					
					sql = sql.replaceAll("##REPDB##",RepDb);//IN068797
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,Accessionnum);
					System.out.println("CAOpenExternalApplication.jsp-------257----------Accessionnum------->"+Accessionnum);
					rs = pstmt.executeQuery();
					if ( rs != null ) //IN000000 if Condition added
					{
						while(rs.next())
						{
							or_acc_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
						}
						if(rs != null ) rs.close();
						if(pstmt != null ) pstmt.close();
					}
					System.out.println("CAOpenExternalApplication.jsp-------268----------or_acc_num------->"+or_acc_num);
				}
				
				//IN000000 - Start
				if("".equals(or_acc_num) && !Accessionnum.contains("!"))
				{
					//sql = "select b.ACCESSION_NUM ACCESSION_NUM from CR_ENCOUNTER_DETAIL b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.EXT_IMAGE_OBJ_ID=? and b.CONTR_SYS_EVENT_CODE=? "; //Added to handle performance issue IN000001
					//sql = "select b.ACCESSION_NUM ACCESSION_NUM from CR_ENCOUNTER_DETAIL b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.EXT_IMAGE_OBJ_ID=? and b.CONTR_SYS_EVENT_CODE=? &&PATIENTID## "; //IN050936//commented for IN068797
					sql = "select b.ACCESSION_NUM ACCESSION_NUM from CR_ENCOUNTER_DETAIL##REPDB## b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.EXT_IMAGE_OBJ_ID=? and b.CONTR_SYS_EVENT_CODE=? &&PATIENTID## "; //IN068797
					//IN050936 - Start
					if(!patient_id.equals(""))
					{
						sql = sql.replace("&&PATIENTID##" , " AND b.patient_id = ? ");
					}
					else
					{
						sql = sql.replace("&&PATIENTID##" , " ");
					}	
					//IN050936 - End
					
					sql = sql.replaceAll("##REPDB##",RepDb);//IN068797
					
					System.out.println("CAOpenExternalApplication.jsp-------290----------sql------->"+sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,Histrectype);
					pstmt.setString(2,Contrsysid);
					pstmt.setString(3,Accessionnum);
					pstmt.setString(4,Contrsyseventcode);
					System.out.println("CAOpenExternalApplication.jsp-------296----------Histrectype------->"+Histrectype);
					System.out.println("CAOpenExternalApplication.jsp-------297----------Contrsysid------->"+Contrsysid);
					System.out.println("CAOpenExternalApplication.jsp-------298----------Accessionnum------->"+Accessionnum);
					System.out.println("CAOpenExternalApplication.jsp-------299----------Contrsyseventcode------->"+Contrsyseventcode);
					//Added to handle performance issue IN000001 included IN050936
					if(!patient_id.equals(""))
					{
						pstmt.setString(5,patient_id);
						System.out.println("CAOpenExternalApplication.jsp-------304----------patient_id------->"+patient_id);
					}
					//Added to handle performance issue IN000001 IN050936
					rs = pstmt.executeQuery();
					if ( rs != null ) 
					{
						while(rs.next())
						{
							or_acc_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
						}
						if(rs != null ) rs.close();
						if(pstmt != null ) pstmt.close();
						System.out.println("CAOpenExternalApplication.jsp-------316----------or_acc_num------->"+or_acc_num);
					}
				} //IN000000 - End
				//IN001679 - end
				//sql = "select b.EXT_IMAGE_OBJ_ID object_id, TO_CHAR(B.EVENT_DATE,'DD/MM/YYYY') COMPLETED_DATE, TO_CHAR(B.EVENT_DATE,'HH24:MI:SS') COMPLETED_TIME,  B.PATIENT_ID,(SELECT SHORT_DESC FROM CR_CLN_EVT_MST_LANG_VW WHERE HIST_REC_TYPE=B.HIST_REC_TYPE AND EVENT_CODE=B.EVENT_CODE AND EVENT_CODE_TYPE=B.EVENT_CODE_TYPE and language_id = ? ) EVENT_DESC, B.EVENT_GROUP, B.EVENT_CODE,b.ENCOUNTER_ID from CR_ENCOUNTER_DETAIL b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.ACCESSION_NUM=?  and b.CONTR_SYS_EVENT_CODE=?  ";//commented for IN068797
				sql = "select b.EXT_IMAGE_OBJ_ID object_id, TO_CHAR(B.EVENT_DATE,'DD/MM/YYYY') COMPLETED_DATE, TO_CHAR(B.EVENT_DATE,'HH24:MI:SS') COMPLETED_TIME,  B.PATIENT_ID,(SELECT SHORT_DESC FROM CR_CLN_EVT_MST_LANG_VW##REPDB## WHERE HIST_REC_TYPE=B.HIST_REC_TYPE AND EVENT_CODE=B.EVENT_CODE AND EVENT_CODE_TYPE=B.EVENT_CODE_TYPE and language_id = ? ) EVENT_DESC, B.EVENT_GROUP, B.EVENT_CODE,b.ENCOUNTER_ID from CR_ENCOUNTER_DETAIL##REPDB## b where b.HIST_REC_TYPE=? and b.CONTR_SYS_ID=? and b.ACCESSION_NUM=?  and b.CONTR_SYS_EVENT_CODE=?  ";//IN068797
			
				sql = sql.replaceAll("##REPDB##",RepDb);//IN068797
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,Histrectype);
				pstmt.setString(3,Contrsysid);
				System.out.println("CAOpenExternalApplication.jsp-------328----------locale------->"+locale);
				System.out.println("CAOpenExternalApplication.jsp-------329----------Histrectype------->"+Histrectype);
				System.out.println("CAOpenExternalApplication.jsp-------330----------Contrsysid------->"+Contrsysid);
				if(!"".equals(or_acc_num)) //IN001679 condition added
				{
					pstmt.setString(4,or_acc_num);
					System.out.println("CAOpenExternalApplication.jsp-------334----------or_acc_num------->"+or_acc_num);
				}else
				{
					pstmt.setString(4,Accessionnum);
					System.out.println("CAOpenExternalApplication.jsp-------338----------Accessionnum------->"+Accessionnum);
				}	
				pstmt.setString(5,Contrsyseventcode);
				System.out.println("CAOpenExternalApplication.jsp-------330----------Contrsyseventcode------->"+Contrsyseventcode);
			//	pstmt.setString(6,extimageapplid);
			//	pstmt.setString(7,locale);

			System.err.println("CAOpenExternalApplication.jsp==============>346");
				rs = pstmt.executeQuery();
				System.err.println("CAOpenExternalApplication.jsp==============>348");
				while(rs.next())
				{
					//base_url = rs.getString("base_url")==null?"":rs.getString("base_url");
					object_id= rs.getString("object_id")==null?"":rs.getString("object_id");
					//appl_password= rs.getString("DEFAULT_USER_PASSWORD")==null?"":rs.getString("DEFAULT_USER_PASSWORD");//Changed Commentted 
					//default_user_id=rs.getString("DEFAULT_USER_ID")==null?"":rs.getString("DEFAULT_USER_ID");
					//ext_image_appl_name=rs.getString("EXT_IMAGE_APPL_NAME")==null?"":rs.getString("EXT_IMAGE_APPL_NAME");
					completed_date = rs.getString("COMPLETED_DATE")==null?"":rs.getString("COMPLETED_DATE");
					completed_time = rs.getString("COMPLETED_TIME")==null?"":(rs.getString("COMPLETED_TIME")).trim();
					patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
					event_desc = rs.getString("EVENT_DESC")==null?"":rs.getString("EVENT_DESC");
					event_group = rs.getString("EVENT_GROUP")==null?"":rs.getString("EVENT_GROUP");
					event_code = rs.getString("EVENT_CODE")==null?"":rs.getString("EVENT_CODE");
					ext_image_obj_id = rs.getString("object_id")==null?"":rs.getString("object_id");
					//param_def_str = rs.getString("PARAM_DEF_STR")==null?"":rs.getString("PARAM_DEF_STR");
					encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
					//IN001679 - Start Added as completed date time was empty
					completed_datetime.append(completed_date);
					completed_datetime.append(" ");
					completed_datetime.append(completed_time);
					//IN001679 - end
				}
				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();
			}
			System.err.println("CAOpenExternalApplication.jsp==============>347");
		        tempStr = param_def_str;
		//IN074119
			if (!param_def_str.equals("") && param_def_str.indexOf("~PERFORMING_FACILITY_ID`")>= 0){
		         fac_query = "select performing_facility_id  from OR_ORDER where order_id = (select ORDER_ID FROM or_order_line where EXT_APPL_ACCESSION_NUM = ?)";//IN068797
				pstmt = con.prepareStatement(fac_query);
				pstmt.setString(1,object_id);
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					performing_facility_id=rs.getString("PERFORMING_FACILITY_ID")==null ?"":rs.getString("PERFORMING_FACILITY_ID");
				}
				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();
			}//IN074119
			//7902 starts
			System.err.println("CAOpenExternalApplication.jsp==============>391");
			if (!param_def_str.equals("") && param_def_str.indexOf("~STUDY_ID`")>= 0){
				//41786  Start.
				//fac_query = "select STUDY_ID  from OR_ORDER_LINE##REPDB## where to_char(EXT_APPL_ACCESSION_NUM) = ?";//IN068797
				fac_query = "select STUDY_ID  from OR_ORDER_LINE##REPDB## where EXT_APPL_ACCESSION_NUM = ?";//IN068797
				//41786 End.
				fac_query = fac_query.replaceAll("##REPDB##",RepDb);
				pstmt = con.prepareStatement(fac_query);
				pstmt.setString(1,object_id);
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					study_id=rs.getString("STUDY_ID")==null ?"":rs.getString("STUDY_ID");
				}
				if(study_id.equals("null"))
					study_id="";
				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();
			}//7902 ends
			System.err.println("CAOpenExternalApplication.jsp==============>408");
				if(!param_def_str.equals("")){					
					if (param_def_str.indexOf("~PATIENT_ID`") >= 0){
							param_def_str = param_def_str.replaceAll("~PATIENT_ID`",patient_id);
					}
					// 18243 Start.
					if (param_def_str.indexOf("~LOGIN_USRID`")>= 0){
						if("CPACS".equals(extimageapplid) && isExtAppUserIdEncrypted ){ //21733
							param_def_str = param_def_str.replaceAll("~LOGIN_USRID`",Encry_login_user);
						}else{
							param_def_str = param_def_str.replaceAll("~LOGIN_USRID`",login_user);	
						}
					}
					// 18243 End.
					if (param_def_str.indexOf("~ENCOUNTER_ID`")>= 0){
							param_def_str = param_def_str.replaceAll("~ENCOUNTER_ID`",encounter_id);
					}if (param_def_str.indexOf("~ACCESSION_NUM`")>= 0){
							Accessionnum = Accessionnum.replace("$","\\$");
							param_def_str = param_def_str.replaceAll("~ACCESSION_NUM`",Accessionnum);
					}if (param_def_str.indexOf("~FACILITY_ID`")>= 0){
							param_def_str = param_def_str.replaceAll("~FACILITY_ID`",facility_id);
					}if (param_def_str.indexOf("~PERFORMING_FACILITY_ID`")>= 0){
						param_def_str = param_def_str.replaceAll("~PERFORMING_FACILITY_ID`",performing_facility_id);
					}if (param_def_str.indexOf("~EXT_APP_USRPWD`")>= 0){
							param_def_str = param_def_str.replaceAll("~EXT_APP_USRPWD`",appl_password);
					}if (param_def_str.indexOf("~EXT_APP_USRID`")>= 0){
							param_def_str = param_def_str.replaceAll("~EXT_APP_USRID`",default_user_id);
					}if (param_def_str.indexOf("~COMPLETED_DATE`")>= 0){
						//IN072022 Start.
						if(("GEPAC".equals(extimageapplid) || "GEECG".equals(extimageapplid)) && !"".equals(completed_datetime.toString().trim()) && isExtAppDataFormat ){
							completedDateTime = df.parse(completed_datetime.toString().trim());
							param_def_str = param_def_str.replaceAll("~COMPLETED_DATE`",formatter1.format(completedDateTime));
						}else
						//IN072022 End.
							param_def_str = param_def_str.replaceAll("~COMPLETED_DATE`",completed_date);
					}if (param_def_str.indexOf("~COMPLETED_DATETIME`")>= 0){						
							param_def_str = param_def_str.replaceAll("~COMPLETED_DATETIME`",(completed_datetime.toString()).trim());
					}if (param_def_str.indexOf("~COMPLETED_TIME`")>= 0){
						//IN072022 Start.
						if(("GEPAC".equals(extimageapplid) || "GEECG".equals(extimageapplid)) && !"".equals(completed_datetime.toString().trim()) && isExtAppDataFormat){
							completedDateTime = df.parse(completed_datetime.toString().trim());
							param_def_str = param_def_str.replaceAll("~COMPLETED_TIME`",URLEncoder.encode(formatter2.format(completedDateTime),"UTF-8"));
						}else
						//IN072022 end.
							param_def_str = param_def_str.replaceAll("~COMPLETED_TIME`",completed_time);
					}if (param_def_str.indexOf("~OBJECT_REF`")>= 0){
							param_def_str = param_def_str.replaceAll("~OBJECT_REF`",object_id);
					}if (param_def_str.indexOf("~STUDY_ID`")>= 0){//7902
						param_def_str = param_def_str.replaceAll("~STUDY_ID`",study_id.trim());//7902
					} 
					// 18243 Start.
					if (param_def_str.indexOf("~LOGIN_USRID`")>= 0){
						if("CPACS".equals(extimageapplid) && isExtAppUserIdEncrypted ){  //21733
							param_def_str = param_def_str.replaceAll("~LOGIN_USRID`",Encry_login_user);
						}else{
							param_def_str = param_def_str.replaceAll("~LOGIN_USRID`",login_user);
						}
					}
					// 18243 End.
		//}
		}
		
	    if(base_url.equals(""))
		{
			
			out.println("<script>alert(getMessage('URL_CHECK','CA')+'  "+ext_image_appl_name+"')</script>");
			
		}
		else
		{
			if (base_url.indexOf("~PATIENT_ID`") >= 0){
					base_url = base_url.replaceAll("~PATIENT_ID`",patient_id);
			}
			if (base_url.indexOf("~ENCOUNTER_ID`")>= 0){
					base_url = base_url.replaceAll("~ENCOUNTER_ID`",encounter_id);
			}
			if (base_url.indexOf("~ACCESSION_NUM`")>= 0){
					Accessionnum = Accessionnum.replace("$","\\$");
					base_url = base_url.replaceAll("~ACCESSION_NUM`",Accessionnum);
			}
			if (base_url.indexOf("~FACILITY_ID`")>= 0){
					base_url = base_url.replaceAll("~FACILITY_ID`",facility_id);
			}
			if (base_url.indexOf("~EXT_APP_USRPWD`")>= 0){
					base_url = base_url.replaceAll("~EXT_APP_USRPWD`",appl_password);
			}
			if (base_url.indexOf("~EXT_APP_USRID`")>= 0){
					base_url = base_url.replaceAll("~EXT_APP_USRID`",default_user_id);					
			}
			// 18243 Start.
			if (base_url.indexOf("~LOGIN_USRID`")>= 0){
				if("CPACS".equals(extimageapplid) && isExtAppUserIdEncrypted ){ //21733
					base_url = base_url.replaceAll("~LOGIN_USRID`",Encry_login_user);	
				}else{
					base_url = base_url.replaceAll("~LOGIN_USRID`",login_user);	
				}
			}
			// 18243 End.
			if (base_url.indexOf("~COMPLETED_DATE`")>= 0){
				//IN072022 Start.
				if(("GEPAC".equals(extimageapplid) || "GEECG".equals(extimageapplid)) && !"".equals(completed_datetime.toString().trim()) && isExtAppDataFormat){
					completedDateTime = df.parse(completed_datetime.toString().trim());
					base_url = base_url.replaceAll("~COMPLETED_DATE`",formatter1.format(completedDateTime));
				}else
				//IN072022 End.
					base_url = base_url.replaceAll("~COMPLETED_DATE`",completed_date);
			}if (base_url.indexOf("~COMPLETED_DATETIME`")>= 0){
					base_url = base_url.replaceAll("~COMPLETED_DATETIME`",(completed_datetime.toString()).trim());
			}if (base_url.indexOf("~COMPLETED_TIME`")>= 0){
				//IN072022 Start.
				if(("GEPAC".equals(extimageapplid) || "GEECG".equals(extimageapplid)) && !"".equals(completed_datetime.toString().trim()) && isExtAppDataFormat){					
					completedDateTime = df.parse(completed_datetime.toString().trim());
					base_url = base_url.replaceAll("~COMPLETED_TIME`",URLEncoder.encode(formatter2.format(completedDateTime),"UTF-8"));
				}else
				//IN072022 End.
					base_url = base_url.replaceAll("~COMPLETED_TIME`",completed_time);
			}if (base_url.indexOf("~OBJECT_REF`")>= 0){
					base_url = base_url.replaceAll("~OBJECT_REF`",object_id);
			}
			
			if(extimageapplid.equals("MSWLR"))
			{
				if (base_url.indexOf("?")>0)
					base_url=base_url +"&";
				else
					base_url=base_url+"?";
				//base_url=base_url+object_id;
				base_url = base_url+param_def_str;
			}
			else if(extimageapplid.equals("MSYS"))
			{
				//base_url=base_url+"?,,I,"+object_id+",,,1,,0";
				base_url = base_url+"?,,I,"+param_def_str+",,,1,,0";
			}
			else
			{
				if (base_url.indexOf("?")>0)
					base_url=base_url +"&";
				else
					base_url=base_url+"?";
			}
			
			System.out.println("CAOpenExternalApplication.jsp------------------------>"+extimageapplid);
			if(extimageapplid.equals("GEECG"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>484");
					base_url = base_url+param_def_str;
					//base_url.replaceAll("\\n","");
					//base_url = base_url.trim();
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(base_url));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}else if(extimageapplid.equals("MSYS"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>500");
               base_url = base_url+param_def_str;
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(base_url));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}else if(extimageapplid.equals("GEPAC"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>513");
				out.println("<script>");
				
					//String ImageUrl = "../../eCA/jsp/CAShowImage.jsp?object_id="+object_id;			
					
					String ImageUrl = base_url+param_def_str;
						
						try
						{								
							// file = new File(config.getServletContext().getRealPath("/")+"eCA/images/" + object_id); checkstyle
						//boolean exists = file.exists();	//Checkstyle 4.0 Beta 6
							
							if (ImageUrl.equals(""))
							{
								out.println("alert('IMG001 - Result image does not exist in the application library area')");
							}else{
							
								String window_name = extimageapplid;    
								////IN074137 Start. 
								if(!isExtAppModelWindow){
									if(!isExtAppNewWindow){
										//out.println("window.open('"+ImageUrl+"','"+window_name+"','height=screenHeight,width=screenWidth,resizable=yes, status=yes, toolbar=yes,fullscreen=yes,location=no')");//Commented for IN068038
										
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ImageUrl));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block16Bytes, _wl_block16);
									
									}else{
										
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ImageUrl));
            _bw.write(_wl_block17Bytes, _wl_block17);

									}
								}else
								//IN074137 end.
								out.println("retVal = window.showModalDialog('"+ImageUrl+"','','dialogHeight:100; dialogWidth:100;resizable=yes;scroll=yes; status=no;')");//Modified for IN068038
							}
						}
						catch (IOException io)
						{
							io.printStackTrace();
						}	
					
					
						
						
								
			out.println("</script>");
			
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else if(extimageapplid.equals("MSWLR"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>554");
                base_url = base_url+param_def_str;
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(base_url));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
			else if(extimageapplid.equals("RLWP"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>564");
				facility_id = "";
				String specimen_no = "";
				String template_name = "";
				int cnt = 0;
				StringTokenizer str = new StringTokenizer(ext_image_obj_id,"@");
				facility_id = str.nextToken();
				specimen_no = str.nextToken();

				//String sql1 = "select TEMPLATE_NAME from RL_OLE_RESULT_TEXT where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and PATIENT_ID = ? and GROUP_TEST_CODE = ? and TEST_CODE = ?";//commented for IN068797
				String sql1 = "select TEMPLATE_NAME from RL_OLE_RESULT_TEXT##REPDB## where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and PATIENT_ID = ? and GROUP_TEST_CODE = ? and TEST_CODE = ?";//IN068797

				sql1 = sql1.replaceAll("##REPDB##",RepDb);//IN068797
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,specimen_no);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,event_group);
				pstmt.setString(5,event_code);

				rs = pstmt.executeQuery();

				while(rs.next())
				{
					cnt = cnt + 1;
					template_name = rs.getString(1) == null ? "" : rs.getString(1);
				}
				if(cnt == 1)
				{
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_group));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(specimen_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(template_name));
            _bw.write(_wl_block28Bytes, _wl_block28);

				}
				else if(cnt > 1)
				{
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(event_group));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(event_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(specimen_no));
            _bw.write(_wl_block36Bytes, _wl_block36);

				}
			}
			else if(extimageapplid.equals("AGFAM"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>620");
               base_url =base_url+param_def_str;
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(base_url));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(base_url));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(object_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(default_user_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(appl_password));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block43Bytes, _wl_block43);

			}
			else if(extimageapplid.equals("RDPAC"))
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>640");
				base_url =base_url+param_def_str;
				
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(base_url));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}
			else 
			{
				System.out.println("CAOpenExternalApplication.jsp------------------------>654");
				base_url =base_url+param_def_str;
				
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(base_url));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(base_url));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(default_user_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(appl_password));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(object_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(extimageapplid));
            _bw.write(_wl_block52Bytes, _wl_block52);

			}
		
	}
	}
	
            _bw.write(_wl_block53Bytes, _wl_block53);

}

catch(Exception e)
{
	//out.println("Exception @ CAOpenExternalApplication.jsp "+e.toString());//COMMON-ICN-0181
         e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();

	if (con != null)ConnectionManager.returnConnection(con,request);
}



 

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
