package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.util.ArrayList;

public final class __statisticsgrpforprogquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/StatisticsGrpForProgQueryCriteria.jsp", 1709113923708L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></html></head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

	try 
	{
		con = ConnectionManager.getConnection(request);//(Connection) session.getValue( "connection" );
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		//firstItem("Module ID");        //label
		firstItem.add ( com.ehis.util.BundleMessage.getBundleMessage ( pageContext , "Common.Module.label" , "common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	  // label
        firstItem.add("module_id");	//name of field
		firstItem.add("2");	// SIZE
		firstItem.add("2");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr
		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");  		 //Type of item
		//fifthItem.add("Module Name");	  // label
		fifthItem.add ( com.ehis.util.BundleMessage.getBundleMessage ( pageContext , "Common.Module.label" , "common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));				 //label
		fifthItem.add("module_name");	//name of field
		fifthItem.add("30");	// SIZE
		fifthItem.add("30");	//LENGTH

		finAr.add(fifthItem);//add to ArrayList obj finAr
		ArrayList sixthItem = new ArrayList();

		sixthItem.add("Text");  		 //Type of item
		//sixthItem.add("Program ID");	  // label
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramID.label","am_labels"));
		// labels
		sixthItem.add("program_id");	//name of field
		sixthItem.add("30");	// SIZE
		sixthItem.add("30");	//LENGTH

		finAr.add(sixthItem);//add to ArrayList obj finAr
		ArrayList secondItem=new ArrayList();

		secondItem.add("Text");  //Type of item
		//secondItem.add("Program Name");  // label
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramName.label","am_labels"));
		//labels
		secondItem.add("program_name");   //name of field
		secondItem.add("20");	// SIZE
		secondItem.add("20");	//LENGTH

		finAr.add(secondItem); //add to ArrayList obj finAr
		ArrayList thirdItem=new ArrayList();

		thirdItem.add("List");   //Type of item
		//thirdItem.add("Program Type");  // label
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramType.label","am_labels"));			//label
		thirdItem.add("program_type");//name
		//thirdItem.add("B,Both,R,Report,F,Function");//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.report.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels")+"");
		finAr.add(thirdItem); //add to ArrayList obj finAr
		ArrayList seventhItem = new ArrayList();

		seventhItem.add("Text");  		 //Type of item
		//seventhItem.add("Statistics Group ID");	  // label
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.StatisticsGroupID.label","am_labels"));		//label
		seventhItem.add("stat_grp_id");	//name of field
		seventhItem.add("10");	// SIZE
		seventhItem.add("10");	//LENGTH

		finAr.add(seventhItem);//add to ArrayList obj finAr
		ArrayList fourthItem=new ArrayList();

		fourthItem.add("Text");   //Type of item
		//fourthItem.add("Statistics Group Desc");  // label
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StatisticsGroup.label","common_labels") + " "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));
		//labels
		fourthItem.add("stat_grp_desc");//name
		fourthItem.add("20");	// SIZE
		fourthItem.add("20");	//LENGTH

		finAr.add(fourthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		//orderByCols[0] = "Module ID";
		//orderByCols[0] = "Module Name";
		//orderByCols[2] = "Program ID";
		//orderByCols[1] = "Program Name";
		//orderByCols[2] = "Program Type";
		//orderByCols[5] = "Statistics Group ID";
		//orderByCols[3] = "Statistics Group Desc";

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
		orderByCols[1]   = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramName.label","am_labels");
		orderByCols[2]	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramType.label","am_labels");
		orderByCols[3]	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StatisticsGroup.label","common_labels") + " "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

		//orderByColVals[0] = "module_id";
		orderByColVals[0] = "module_name";
		//orderByColVals[2] = "program_id";
		orderByColVals[1] = "program_name";
		orderByColVals[2] = "program_type";
		//orderByColVals[5] = "stat_grp_id";
		orderByColVals[3] = "stat_grp_desc";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Building Code","../../eAM/jsp/StatisticsGrpForProgQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
		out.println(strbuff.toString());


		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();
		finAr.clear();
	} catch (Exception e) {}
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
