package jsp_servlet._eam._jsp;

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

public final class __transportmodequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/TransportModeQueryCriteria.jsp", 1709113924474L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\t\n\tCreated on \t\t:\t19/02/2005\n\tModule\t\t\t\t:\teAM - Deficiency\n\tFileName\t\t    :\tTransportModeQueryCriteria.jsp\t\n\tFunction\t\t:\tThis function is used to load query criteria screen for the function\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	Boolean isCnrmReqPatOutChngAppl = false;//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

	//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	Boolean isMedRepModeAppl = false;

	try 
	{

		con = ConnectionManager.getConnection(request);
	
		isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

		isMedRepModeAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CHCKLST_TRANS_MODE_MED_REPORT"); //Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
		
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  				// Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransportMode.label","common_labels"));		// label
		firstItem.add("transport_mode");		// name of field
		firstItem.add("10");						// SIZE
		firstItem.add("10");						// LENGTH
		finAr.add(firstItem);					// add to ArrayList obj finAr

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");					// Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransportMode.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));		// label
		secondItem.add("long_desc");			// name of field
		secondItem.add("30");					// SIZE
		secondItem.add("30");					// LENGTH
		finAr.add(secondItem);					// add to ArrayList obj finAr
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");					// Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.PatientRelated.label","am_labels"));		// label
		thirdItem.add("patient_related_yn");			// name
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
		finAr.add(thirdItem);

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("List");					// Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FileRelated.label","am_labels"));		// label
		fourthItem.add("file_related_yn");			// name
		fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
		finAr.add(fourthItem); 
		
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("List");					// Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SpecimenRelated.label","am_labels"));		// label
		fifthItem.add("specimen_related_yn");			// name
		fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
		finAr.add(fifthItem); 

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");					// Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ByPerson.label","am_labels"));				// label
		sixthItem.add("by_person_yn");			// name
		sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(sixthItem); //add to ArrayList obj finAr

		/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
		ArrayList seventhItem=new ArrayList();
		if(isCnrmReqPatOutChngAppl){	
			seventhItem.add("List");					// Type of item
			seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.TfrPatientOut.label","am_labels"));				// label
			seventhItem.add("tfr_pat_out_yn");			// name
			seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(seventhItem); //add to ArrayList obj finAr
		}/*End*/

		/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
		ArrayList ninthItem=new ArrayList();
		if(isMedRepModeAppl){	
			ninthItem.add("List");					// Type of item
			ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicationMode.label","common_labels"));				// label
			ninthItem.add("application_mode");			// name
			ninthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(ninthItem); //add to ArrayList obj finAr
		}

		ArrayList tenthItem=new ArrayList();
		if(isMedRepModeAppl){	
			tenthItem.add("List");					// Type of item
			tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CollectionMode.label","common_labels"));				// label
			tenthItem.add("collection_mode");			// name
			tenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(tenthItem); //add to ArrayList obj finAr
		}

		ArrayList eleventhItem=new ArrayList();
		if(isMedRepModeAppl){	
			eleventhItem.add("List");					// Type of item
			eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotificationMode.label","common_labels"));				// label
			eleventhItem.add("notification_mode");			// name
			eleventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(eleventhItem); //add to ArrayList obj finAr
		}/*ML-MMOH-CRF-0708 End*/
			
		ArrayList eighthItem=new ArrayList();
		eighthItem.add("List");					// Type of item
		eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));				// label
		eighthItem.add("eff_status");			// name
		eighthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(eighthItem); //add to ArrayList obj finAr

		
		

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[7];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransportMode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransportMode.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

		orderByColVals[0] = "transport_mode";
		orderByColVals[1] = "long_desc";
		orderByColVals[2] = "patient_related_yn";
		orderByColVals[3] = "file_related_yn";
		orderByColVals[4] = "specimen_related_yn";
		orderByColVals[5] = "by_person_yn";
		orderByColVals[6] = "eff_status";

		strbuff = qrypg.getQueryPage(con,finAr,"File Transport Mode","../jsp/TransportModeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
		out.println(strbuff.toString());
		
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		
		/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617*/
		if(isCnrmReqPatOutChngAppl)
			seventhItem.clear();
		eighthItem.clear();
		/*End*/

		/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
		if(isMedRepModeAppl)
		{
			ninthItem.clear();
			tenthItem.clear();
			eleventhItem.clear();
		}
		/*ML-MMOH-CRF-0708 End*/

		finAr.clear();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
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
