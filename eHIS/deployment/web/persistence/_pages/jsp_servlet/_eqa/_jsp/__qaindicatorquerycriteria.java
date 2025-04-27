package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;

public final class __qaindicatorquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorQueryCriteria.jsp", 1742817544560L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--/*\n\t\t\t\tDeveloped by\t\t   :\t\tRajesh Kanna.S\n\t\t\t\tDeveloped on\t \t   :\t \t2/2/2005 \n\t\t\t\t\t\t\t\t\t\t\t\t\t*/-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = (Connection) session.getValue( "connection" );
} catch (Exception e) {}


ArrayList finAr = new ArrayList();

ArrayList firstItem=new ArrayList();
firstItem.add("Text");  //Type of item
firstItem.add("Indicator ID");  // label
firstItem.add("qind_clind_id");   //name of field
//thirdItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
firstItem.add("3");
firstItem.add("3");
//LENGTH
finAr.add(firstItem); //add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
secondItem.add("Text");  //Type of item
secondItem.add("Indicator Description");  // label
secondItem.add("qind_clind_desc");   //name of field
//thirdItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
secondItem.add("40");
secondItem.add("40");
//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");  		 //Type of item
thirdItem.add("Group Code");	  // label
thirdItem.add("qind_group_id");	//name of field
thirdItem.add("4");	// SIZE
thirdItem.add("4");	//LENGTH
finAr.add(thirdItem);//add to ArrayList obj finAr 

ArrayList forthItem = new ArrayList();
forthItem.add("Text");  		 //Type of item
forthItem.add("Group Description");	  // label
forthItem.add("qind_group_desc");	//name of field
forthItem.add("40");	// SIZE
forthItem.add("40");	//LENGTH
finAr.add(forthItem);//add to ArrayList obj finAr 


ArrayList fifthItem=new ArrayList();

fifthItem.add("List");  //Type of item
fifthItem.add("Indicator Type");  // label
fifthItem.add("clind_type");
fifthItem.add("A,All,R,Rational Based,S,Sentinal Based");   //name of field
finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();


sixthItem.add("List");  //Type of item
sixthItem.add("Classfication Criteria");  // label
sixthItem.add("clind_class");
sixthItem.add("A,All,D,Diagnosis-based ,P,Procedure-based,Z,Diagnosis/Procedure-based,O,Orderable-based,I,Incident-based,R,Direct Reporting,S,Source Based - RIS,M,Source Based - OTMS,A,Source Based - A&E,N,Source Based - IP");   //name of field
finAr.add(sixthItem); 
ArrayList seventhItem=new ArrayList();


seventhItem.add("List");  //Type of item
seventhItem.add("Nature");  // label
seventhItem.add("eff_status");
seventhItem.add("B,Both,E,Enabled,D,Disabled");   //name of field
finAr.add(seventhItem); 


String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] = "Indicator ID";
orderByCols[1] = "Indicator Description";
orderByCols[2] = "Group Code";
orderByCols[3] = "Group Description";
orderByCols[4] = "Indicator Type";
orderByCols[5] = "Clasification Criteria";

//orderByCols[2] = "Care Location Type Indicator";



orderByColVals[0] = "to_number(qind_clind_id)";        
orderByColVals[1] = "qind_clind_desc"; 
orderByColVals[2] = "qind_group_id";   
orderByColVals[3] = "qind_group_desc";
orderByColVals[4] = "clind_type";              
orderByColVals[5] = "clind_class";            



//orderByColVals[2] = "care_locn_type_ind";

strbuff = qrypg.getQueryPage(con,finAr,"Discipline","../../eQA/jsp/QAIndicatorQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
firstItem.clear();
finAr.clear();
secondItem.clear();
thirdItem.clear();
forthItem.clear();
fifthItem.clear();
sixthItem.clear();
seventhItem.clear();

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
