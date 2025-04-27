package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import eBL.PkgAssociationExistingPackagesBean;
import java.util.*;
import com.ehis.util.*;

public final class __pkgassociationexistingpackagespersistance extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgAssociationExistingPackagesPersistance.jsp", 1709114129443L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n----------------------------------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------\n11-May-2016    100           \tKarthikeyan.K       MMS-CRF-003 Karthik Created this File code for Package Subscription and Association\n----------------------------------------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n</HTML>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
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
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String operation=request.getParameter("operation");
	
	if(operation.equals("add")){
		
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList= (session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG"))==null ? new ArrayList<PkgAssociationExistingPackagesBean>(): (ArrayList<PkgAssociationExistingPackagesBean>)session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");	
		PkgAssociationExistingPackagesBean beanObj=new PkgAssociationExistingPackagesBean();
	 	String existingPkgCode=request.getParameter("existingPkgCode");
		String existingPkgSeqNo=request.getParameter("existingPkgSeqNo");
		String existingPkgEpiType=request.getParameter("existingPkgEpiType");
		String existingPkgFrmDte=request.getParameter("existingPkgFrmDte");
		//System.out.println("existingPkgFrmDte in persistence"+existingPkgFrmDte);
		//System.out.println("existingPkgCode in persistence"+existingPkgCode);
		String existingPkgBlngClassCode=request.getParameter("existingPkgBlngClassCode");
		
		beanObj.setExistingPkgCode(existingPkgCode);
		beanObj.setExistingPkgSeqNo(existingPkgSeqNo);
		beanObj.setExistingPkgEpiType(existingPkgEpiType);
		beanObj.setExistingPkgFrmDte(existingPkgFrmDte);
		beanObj.setExistingPkgBlngClassCode(existingPkgBlngClassCode);
		pkgAssociationExistingPackagesBeanList.add(beanObj);
		session.setAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG", pkgAssociationExistingPackagesBeanList );
		//System.out.println(pkgAssociationExistingPackagesBeanList);
		
	}
	else if(operation.equals("remove")){
	
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList= (session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG"))==null ? new ArrayList<PkgAssociationExistingPackagesBean>(): (ArrayList<PkgAssociationExistingPackagesBean>)session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanListTemp=pkgAssociationExistingPackagesBeanList;
		String existingPkgSeqNo=request.getParameter("existingPkgSeqNo");
		for(int i=0;i<pkgAssociationExistingPackagesBeanList.size();i++){
			PkgAssociationExistingPackagesBean beanObj=pkgAssociationExistingPackagesBeanList.get(i);
			if(beanObj.getExistingPkgSeqNo().equals(existingPkgSeqNo)){				
				pkgAssociationExistingPackagesBeanListTemp.remove(i);
				break;
			}
		}
		session.setAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG", pkgAssociationExistingPackagesBeanListTemp );
		System.out.println(pkgAssociationExistingPackagesBeanList);
		
	}
	
	
	else if(operation.equals("modify"))
	{
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList=(session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG"))==null ? new ArrayList<PkgAssociationExistingPackagesBean>():(ArrayList<PkgAssociationExistingPackagesBean>)session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanListModify=pkgAssociationExistingPackagesBeanList;
		String existingPkgSeqNo=request.getParameter("existingPkgSeqNo");
		String existingPkgCode=request.getParameter("existingPkgCode");
		String existingPkgEpiType=request.getParameter("existingPkgEpiType");
		String existingPkgFrmDte=request.getParameter("existingPkgFrmDte");
		PkgAssociationExistingPackagesBean beanObj=null;
		/*System.out.println("existingPkgFrmDte in persistence"+existingPkgFrmDte);
		System.out.println("existingPkgCode in persistence"+existingPkgCode);
		System.out.println("existingpkgseqbo "+existingPkgSeqNo);
		System.out.println("existingPkgEpiType "+existingPkgEpiType);*/
		
		
		for(int i=0;i<pkgAssociationExistingPackagesBeanList.size();i++)
		{
			 beanObj=pkgAssociationExistingPackagesBeanList.get(i);
			if(beanObj.getExistingPkgSeqNo().equals(existingPkgSeqNo)){
				pkgAssociationExistingPackagesBeanListModify.remove(i);	
				beanObj.setExistingPkgCode(existingPkgCode);
				beanObj.setExistingPkgSeqNo(existingPkgSeqNo);
				beanObj.setExistingPkgEpiType(existingPkgEpiType);
				beanObj.setExistingPkgFrmDte(existingPkgFrmDte);
				break;
			}
		}
		pkgAssociationExistingPackagesBeanListModify.add(beanObj);
		System.out.println("List in Modify "+pkgAssociationExistingPackagesBeanListModify);
		session.setAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG", pkgAssociationExistingPackagesBeanListModify);
		
		
	}
	
	
	
	else{
	session.removeAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
	session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
	//System.out.println("session BL_CREDIT_CARD_DETAILS cleared");
	}
	
	

	


            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
