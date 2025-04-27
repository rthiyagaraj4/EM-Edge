package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmuseraccessquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMUserAccessQueryCriteria.jsp", 1709116783170L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n    <html><head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link></head></html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con = null;

	try 
	{
		con = ConnectionManager.getConnection(request); ;
	
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels"));	   //label
		firstItem.add("APPL_USER_ID");	//name of field
		firstItem.add("30");	// SIZE
		firstItem.add("30");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");  		// Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels"));	   //label
		secondItem.add("APPL_USER_NAME");	//name of field
		secondItem.add("30");	 //SIZE
		secondItem.add("30");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");  		// Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationCode.label","fm_labels"));	   //label
		thirdItem.add("FS_LOCN_CODE");	//name of field
		thirdItem.add("8");	 //SIZE
		thirdItem.add("8");	//LENGTH

		finAr.add(thirdItem);//add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");  		// Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileStorageLocationDesc.label","fm_labels"));	   //label
		fourthItem.add("FS_LOCN_DESC");	//name of field
		fourthItem.add("30");	 //SIZE
		fourthItem.add("30");	//LENGTH

		finAr.add(fourthItem);//add to ArrayList obj finAr

		ArrayList fifthItem=new ArrayList();

		fifthItem.add("List");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationIdentity.label","fm_labels"));  /// label
		fifthItem.add("LOCN_IDENTITY_DESC");  // name of field
		fifthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"));//static values that need to be displayed as 

		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem=new ArrayList();

		sixthItem.add("List");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AccessRights.label","common_labels"));  /// label
		sixthItem.add("ACCESS_RIGHTS");  // name of field
		sixthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.AssignFSLocation.label","fm_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelRequest.label","common_labels")+",Q,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.CreateFileVolume.label","fm_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ChangeFSLocation.label","fm_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ChangeFileReturnDate.label","fm_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ChangeFileStatus.label","fm_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ConfirmReceipt.label","fm_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.IssueFileWithinFacility.label","fm_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.IssueFileToOtherFacilities.label","fm_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ManualRequestYN.label","fm_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.MonitorDeficiency.label","fm_labels")+",H,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ReceiveFile.label","fm_labels")+",K,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.RequestFileWithinFacility.label","fm_labels")+",L,"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.RequestFileFromOtherFacilities.label","fm_labels")+",G,"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TrackoutfilestoOPD.label","fm_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TrackoutfilestoIPW.label","fm_labels")+",J,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TransferFileoutsideMRD.label","fm_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ReturnFile.label","fm_labels"));

		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[6];
		String orderByColVals[] = new String[6];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationCode.label","fm_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileStorageLocationDesc.label","fm_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationIdentity.label","fm_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AccessRights.label","common_labels");

		orderByColVals[0] = "APPL_USER_ID";
		orderByColVals[1] = "APPL_USER_NAME";
		orderByColVals[2] = "FS_LOCN_CODE";
		orderByColVals[3] = "FS_LOCN_DESC";
		orderByColVals[4] = "LOCN_IDENTITY_DESC";
		orderByColVals[5] = "APPL_USER_ID";

		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Narration.label","fm_labels"),"../../eFM/jsp/FMUserAccessQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear(); 
		firstItem.clear(); 
		secondItem.clear(); 
		thirdItem.clear(); 
		fourthItem.clear(); 
		fifthItem.clear(); 
		sixthItem.clear();
	}
	catch(Exception e) 
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
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
