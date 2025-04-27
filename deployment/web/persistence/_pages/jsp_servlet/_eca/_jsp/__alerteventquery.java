package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __alerteventquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AlertEventQuery.jsp", 1709115450779L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../js/AlertEvent.js\'></script>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<SCRIPT LANGUAGE=\"JavaScript\">\n//parent.commontoolbarFrame.document.getElementById(\"apply\").disabled = true;\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;


Connection con=null ;

try
	{

		con  =  ConnectionManager.getConnection(request);


		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertEventCode.label","ca_labels"));     // label
		firstItem.add("event_id");   //name of field  
		firstItem.add("10"); // SIZE
		firstItem.add("10"); //LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Graph.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertEventDescription.label","ca_labels"));    // label
		secondItem.add("event_desc");  //name of field
		secondItem.add("30");   // SIZE
		secondItem.add("30");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr


		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");   //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategoryCode.label","ca_labels"));  // label
		thirdItem.add("txtCategoryCode");//name
		thirdItem.add("20");			  // SIZE
	    thirdItem.add("20");             // LENGTH
	    finAr.add(thirdItem);

		ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionEvent.label","ca_labels"));  // label
	fourthItem.add("ActionEvent");//name
	fourthItem.add("SELECT KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='AE' ORDER BY 2");	          
	 finAr.add(fourthItem);


ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DocumentName.label","ca_labels"));  // label
	fifthItem.add("DocumentName");//name
	fifthItem.add("SELECT NOTE_TYPE, NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE EFF_STATUS='E' ORDER BY 2");			  // SIZE
	            // LENGTH
	 finAr.add(fifthItem);

	ArrayList sixthItem = new ArrayList();

sixthItem.add("List");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionBy.label","ca_labels"));  // label
	sixthItem.add("ActionBy");//name
	sixthItem.add("SELECT  KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='AB' ORDER BY 2");		           
	 finAr.add(sixthItem);

ArrayList seventhItem = new ArrayList();
seventhItem.add("List");   //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TriggeringTime.label","ca_labels"));  // label
	seventhItem.add("TriggeringTime");//name			
	 seventhItem.add("SELECT  KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='TT' ORDER BY 2");        
	 finAr.add(seventhItem);




			String[] orderByCols = null;
			String[] orderByColVals = null;


			orderByCols = new String[7];
			orderByColVals = new String[7];


			orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertEventCode.label","ca_labels");
			orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertEventDescription.label","ca_labels");
			orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategoryCode.label","ca_labels");

			orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionEvent.label","ca_labels");

			orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DocumentName.label","ca_labels");

			orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionBy.label","ca_labels");

			orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TriggeringTime.label","_labels");
			

			orderByColVals[0] = "ALERT_EVENT_CODE";
			orderByColVals[1] = "ALERT_EVENT_DESC";
			orderByColVals[2] = "ALERT_CATEG_CODE"; 
			orderByColVals[3] = "ACTION_EVENT"; 
			orderByColVals[4] = "DOUMENT_REF"; 
			orderByColVals[5] = "ACTION_BY"; 
			orderByColVals[6] = "ACTION_TRIGGER_BY"; 


			//out.println("orderByColVals[0]"+orderByColVals[0]);
			//out.println("orderByColVals[1]"+orderByColVals[1]);
			//out.println("orderByColVals[2]"+orderByColVals[2]);
			

			strbuff = qrypg.getQueryPage(con,finAr,"AlertEvent","../../eCA/jsp/AlertEventResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		
	
}catch (Exception e) 
{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	   e.printStackTrace();//COMMON-ICN-0181
}finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
