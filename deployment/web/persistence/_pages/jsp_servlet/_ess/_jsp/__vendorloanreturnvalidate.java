package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
import java.net.*;
import eSS.Common.*;
import eSS.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __vendorloanreturnvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/VendorLoanReturnValidate.jsp", 1729511436441L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
	String bean_id				=		request.getParameter("bean_id");
	String bean_name			=		request.getParameter("bean_name");	
	String functionType					=		request.getParameter("function_type");	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	VendorLoanReturnBean bean		= (VendorLoanReturnBean) getBeanObject(bean_id, bean_name , request);
	Hashtable hash				= (Hashtable) XMLobj.parseXMLString(request);
    hash						= (Hashtable) hash.get ("SEARCH");
	try{
		if (functionType.equals("1"))
		{
			String doc_type_code = (String) hash.get("doc_type_code");
			if (doc_type_code.trim().equals("")) {
				out.println("disableDocNo();");
				return;
			}
			if (!bean.isDocNoAutoGenYN(doc_type_code)) 
				out.println("enableDocNo();");
			else 
				out.println("disableDocNo();");
		}else if (functionType.equals("2")){
			String selDocNo 	= (String)hash.get("selDocNo") ;
			String selDocGroupDtl 	= URLDecoder.decode((String)hash.get("selDocGroupDtl"), "UTF-8");
			String[] selDocGroupArray = selDocGroupDtl.split("\\#");
			HashMap groupDetailsMap = bean.getTotalGroupQty();
			HashMap selDocGroupDetails = bean.getSelDocGropuDetails();			
			String selcDocYN = "Y";
			String ErroMsg	 = "";
			for(int i=0;i<selDocGroupArray.length;i++){
				String[] groupDtlArray = selDocGroupArray[i].split("\\|");
				if((Integer.parseInt((String)groupDtlArray[1])<=(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))))){						
					if((Integer.parseInt((String)groupDtlArray[1])<=(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))))){
						selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk",(String)groupDtlArray[1]);
						selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"ST","0");
					}else{
						int removeStQty=Integer.parseInt((String)groupDtlArray[1])-(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK")));
						
						selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk",(String)groupDtlArray[1]);
						selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"ST",String.valueOf(removeStQty));
					}						
				}else{
					selcDocYN = "N";
					if("".equals(ErroMsg))
						ErroMsg = (String)groupDetailsMap.get(groupDtlArray[0]+"_DESC");
					else
						ErroMsg = ErroMsg+", "+(String)groupDetailsMap.get(groupDtlArray[0]+"_DESC");					
				}
			}
			if("Y".equals(selcDocYN)){
				for(int j=0;j<selDocGroupArray.length;j++){
					String[] groupDtlArray = selDocGroupArray[j].split("\\|");
					groupDetailsMap.put(groupDtlArray[0],String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))-Integer.parseInt((String)groupDtlArray[1])));
					groupDetailsMap.put((groupDtlArray[0]+"PACK"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))-Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk"))));
					groupDetailsMap.put((groupDtlArray[0]+"ST"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"ST"))-Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"ST"))));				
				}
				bean.setTotalGroupQty(groupDetailsMap);				
				bean.setSelDocGropuDetails(selDocGroupDetails);
			}
				
			out.println(selcDocYN+"|"+ErroMsg+"  ");
		}else if (functionType.equals("3")){
			String selDocNo 	= (String)hash.get("selDocNo") ;
			String selDocGroupDtl 	= URLDecoder.decode((String)hash.get("selDocGroupDtl"), "UTF-8");
			String[] selDocGroupArray = selDocGroupDtl.split("\\#");
			HashMap groupDetailsMap = bean.getTotalGroupQty();
			HashMap selDocGroupDetails = bean.getSelDocGropuDetails();						
			for(int i=0;i<selDocGroupArray.length;i++){
				String[] groupDtlArray = selDocGroupArray[i].split("\\|");				
				groupDetailsMap.put(groupDtlArray[0],String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))+Integer.parseInt((String)groupDtlArray[1])));
				groupDetailsMap.put((groupDtlArray[0]+"PACK"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))+Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk"))));
				groupDetailsMap.put((groupDtlArray[0]+"ST"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"ST"))+Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"ST"))));				
				selDocGroupDetails.remove("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk");
				selDocGroupDetails.remove("D_"+selDocNo+"_"+groupDtlArray[0]+"ST");
			}
			bean.setTotalGroupQty(groupDetailsMap);			
			bean.setSelDocGropuDetails(selDocGroupDetails);			
			out.println("Y|  ");
		}else if (functionType.equals("4")){
			String totalDocNo = URLDecoder.decode((String)hash.get("totalDocNo"), "UTF-8");
			String totalDocDtls = URLDecoder.decode((String)hash.get("totalDocDtls"), "UTF-8");
			String[] totalDocArr = totalDocDtls.split("\\^");
			HashMap groupDetailsMap = bean.getTotalGroupQty();
			HashMap selDocGroupDetails = bean.getSelDocGropuDetails();	
			String selcDocYN = "Y";
			String ErroMsg	 = "";
			for(int i=0;i<totalDocArr.length;i++){
				String[] docDtls =(totalDocArr[i]).split("\\~");				
				String selDocNo 	= docDtls[0] ;
				String selDocGroupDtl 	= docDtls[1];
				String[] selDocGroupArray = selDocGroupDtl.split("\\#");
				String tempDocYN="Y";
				String tempErroMsg ="";
				for(int j=0;j<selDocGroupArray.length;j++){
					String[] groupDtlArray = selDocGroupArray[j].split("\\|");
					if((Integer.parseInt((String)groupDtlArray[1])<=(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))))){						
						if((Integer.parseInt((String)groupDtlArray[1])<=(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))))){
							selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk",(String)groupDtlArray[1]);
							selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"ST","0");
						}else{
							int removeStQty=Integer.parseInt((String)groupDtlArray[1])-(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK")));
							
							selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk",(String)groupDtlArray[1]);
							selDocGroupDetails.put("D_"+selDocNo+"_"+groupDtlArray[0]+"ST",String.valueOf(removeStQty));
						}	
						
						groupDetailsMap.put(groupDtlArray[0],String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]))-Integer.parseInt((String)groupDtlArray[1])));
						groupDetailsMap.put((groupDtlArray[0]+"PACK"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"PACK"))-Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"PACk"))));
						groupDetailsMap.put((groupDtlArray[0]+"ST"),String.valueOf(Integer.parseInt((String)groupDetailsMap.get(groupDtlArray[0]+"ST"))-Integer.parseInt((String)selDocGroupDetails.get("D_"+selDocNo+"_"+groupDtlArray[0]+"ST"))));				
					
					}else{
						tempDocYN ="N";						
					}
				}
				if("N".equals(tempDocYN)){
					selcDocYN = "N";
					if("".equals(ErroMsg))
						ErroMsg = selDocNo;
					else
						ErroMsg = ErroMsg+", "+selDocNo;
				}
			}
			if("Y".equals(selcDocYN)){				
				bean.setTotalGroupQty(groupDetailsMap);				
				bean.setSelDocGropuDetails(selDocGroupDetails);
			}else{				
				bean.setSelDocGropuDetails(new HashMap());
				bean.setTotalGroupQty(new HashMap());
				bean.loadHashMaps(totalDocNo);					
			}
			out.println(selcDocYN+"|"+ErroMsg+"  ");
		}else if (functionType.equals("5")){			
			String totalDocNo = URLDecoder.decode((String)hash.get("totalDocNo"), "UTF-8");			
			bean.setSelDocGropuDetails(new HashMap());
			bean.setTotalGroupQty(new HashMap());			
			bean.loadHashMaps(totalDocNo);	
			
			out.println("Y|  ");
		}
		
	putObjectInBean(bean_id,bean,request); 
	}catch(Exception ex){
		ex.printStackTrace();
		out.println("ERROR");
	}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
