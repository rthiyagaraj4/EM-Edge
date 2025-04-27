package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import org.apache.commons.codec.binary.Base64;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import eBL.Common.BlRepository;
import java.util.*;
import com.ehis.util.*;

public final class __encounterspecacrossencounter extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/EncounterSpecAcrossEncounter.jsp", 1709114650914L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n---------------------------------------------------------------------------------------------------------------\nSr No        Version           TFS/Incident        SCF/CRF            \t\t Developer Name\n--------------------------------------------------------------------------------------------------------\n1            V220413            30399          MMS-ME-SCF-0064-TF               Mohanapriya K\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Across Encounters Details</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/EncounterSpecPolicyDefnSrch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" >\n<form name=\'frmAcrossEncounter\' id=\'frmAcrossEncounter\'>\n<br>\n<br>\n<table width=\'90%\' cellpadding=\'3\'  cellspacing=0 align=\"center\" border=\"1\">  \n<tr>\t\t\t\t\n\t<th class=\'CAFLOWSHEETLEVEL1\'\talign=\"left\"\twidth=\"4%\">Sr.No</th>\n\t<th class=\'CAFLOWSHEETLEVEL1\'\talign=\"left\"\twidth=\"30%\">Encounter Group ID</th>\n\t<th class=\'CAFLOWSHEETLEVEL1\' \talign=\"left\"\twidth=30%\">Encounter Id</th>\n\t<th class=\'CAFLOWSHEETLEVEL1\' \talign=\"left\"\twidth=\"30%\" >Policy No</th>\n</tr>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<a href=\'javascript:fnChangeAcrossGrpId(";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =")\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</a>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="      \t\n\t\n      \t</table>\t\n     </form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String facility_id = (String)session.getAttribute("facility_id");
	String payerGroup = checkForNull(request.getParameter("payerGroup"));
	String payer = checkForNull(request.getParameter("payer"));
	String policy = checkForNull(request.getParameter("policy"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String encGrpId = checkForNull(request.getParameter("encGrpId"));
	String episodeId = checkForNull(request.getParameter("episodeId"));
	String priority =  checkForNull(request.getParameter("priority"));
	String patientId ="";
	//V220413
	if("Y".equals(request.getParameter("compressed")==null?"":request.getParameter("compressed"))) {
			patientId = new String(Base64.decodeBase64(((String)request.getParameter("patientId")).getBytes())); 
	}else{
		patientId = checkForNull(request.getParameter("patientId"));
	}
	//V220413
    if(encGrpId.length()==0 && priority.length()> 0)
    {
    	HashMap validAcrossEncMap = (HashMap)session.getAttribute("VALID_ACROSS_ENCOUNTER_MAP");
    	if( validAcrossEncMap !=null)
    	{
    	encGrpId=(String)validAcrossEncMap.get(policy+priority);
    	encGrpId=checkForNull(encGrpId);
    	
    	}
    	
    }
    	
    	
    	
	String  strfield ="YELLOW";
	String  strGroupId ="";
	
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


try{
	String acrossEncounter = "";
	con = ConnectionManager.getConnection(request);
	if(("I".equals(episodeType)) || ("D".equals(episodeType))||("IP".equals(episodeType))||("DC".equals(episodeType))){		
		acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ENC_GRP_ID");
	}
	else if(("O".equals(episodeType)) || ("E".equals(episodeType)) ||("OP".equals(episodeType)) || ("AE".equals(episodeType))){		
		acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ENC_GRP_OE");
	}
	else {
		acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ENC_GRP_R");
	}
	pstmt = con.prepareStatement(acrossEncounter);			
	pstmt.setString(1,payerGroup);
	//System.out.println("#### Payer Group  "+payerGroup);
	pstmt.setString(2,payer);
	//System.out.println("#### Payer Group  "+payer);
	pstmt.setString(3,policy);
	//System.out.println("#### Payer Group  "+policy);
	pstmt.setString(4,facility_id);
	//System.out.println("#### Payer Group  "+facility_id);
	pstmt.setString(5,patientId);
	//System.out.println("#### Payer Group  "+patientId);
	rst = pstmt.executeQuery();
	int rstCnt = 0;
	if(rst != null){
		while(rst.next()){
			//acrossEncCount = rst.getInt("enc_count");	
			strGroupId =checkForNull(rst.getString("ACROSS_ENC_GROUP_ID"));
			if(strGroupId.equals(encGrpId))
				strfield = "YELLOW";
			else
				strfield ="fields";
			
			rstCnt++;
			out.println("<tr>");
			out.println("<td class='fields' id='sno"+rstCnt+"'>");
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strGroupId ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rstCnt ));
            _bw.write(_wl_block9Bytes, _wl_block9);

			out.println("</td>");
			out.println("<td class='"+strfield+"' id='encGrpid"+rstCnt+"'>");
			out.println(strGroupId);
			out.println("</td>");
			out.println("<td class='"+strfield+"' id='encId"+rstCnt+"'>");
			out.println(rst.getString("ENCOUNTER_ID"));
			out.println("</td>");
			out.println("<td class='"+strfield+"' id='policyNo"+rstCnt+"'>");
			out.println(rst.getString("POLICY_NUMBER"));
			out.println("</td>");
			out.println("</tr>");
		}
		rst.close();
	}
	pstmt.close();

}
catch(Exception e){
	System.err.println("Exception in Across Enc Popup - "+e);
}
finally{
	ConnectionManager.returnConnection(con);
}
	

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
