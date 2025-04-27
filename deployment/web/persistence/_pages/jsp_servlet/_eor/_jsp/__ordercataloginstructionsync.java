package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.net.URLEncoder;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ordercataloginstructionsync extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderCatalogInstructionSync.jsp", 1729860862000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t<script>alert(\"Exception thrown ...Chk in OrderCatalogInstructionSync.jsp\"+\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\");</script>\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-----------------------------------------------------------------------------------------
Date       		Edit History     	   Name        Rev.Date  		 Rev.By			Description
-----------------------------------------------------------------------------------------
07/08/2018	  	IN064543		Kamalakannan	07/08/2018		Ramesh G		ML-MMOH-CRF-0776
20/11/2018	  	ML-MMOH-SCF-1108	Kamalakannan	20/11/2018		Ramesh G		ML-MMOH-SCF-1108
------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

try{
	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	//String mode			=	request.getParameter( "mode" ) ;
	//String function_id	=	request.getParameter( "function_id" ) ;
	String bean_id		=	"Or_OrderCatalog" ;
	//String bean_name	=	"eOR.OrderCatalogBean";

	boolean flag			=   false ;

	
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject( bean_id.trim(),"eOR.OrderCatalogBean",request) ;


	Hashtable hash		  = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );	
	//IN064543 start
	String action 			= bean.checkForNull((String)hash.get("action"), "");
	String lengthStr = null;	
	HashMap valuesFromBean = null;
	ArrayList rowValues = null;
	HashMap rowMap = null;
	int index = 0;
	
			if("INSERTINPUTS".equals(action)){
				flag = bean.instructionByAgeSync(hash);
				if(flag){
					//valuesFromBean = (HashMap)bean.getInstructionsRecStr().get(3);//commented for ML-MMOH-SCF-1108 
					valuesFromBean = (HashMap)bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
					String readOnly 			= bean.checkForNull((String)hash.get("readOnly"), "N");
					rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
					//rowValues = (ArrayList)valuesFromBean.get("records");//commented for ML-MMOH-SCF-1108 
					if(rowValues!=null){
						out.println("clearBeforeInsertion()");
						for(int start=0; start<rowValues.size();start++){
						HashMap rowValHash = (HashMap)rowValues.get(start);
						out.println("insertContentToRow('"+start+"','"+rowValHash.get("sex_spec_ind")+"','"+rowValHash.get("min_age_in_yrs")+"','"+rowValHash.get("min_age_in_mths")+"','"+rowValHash.get("min_age_in_days")+"','"+rowValHash.get("max_age_in_yrs")+"','"+rowValHash.get("max_age_in_mths")+"','"+rowValHash.get("max_age_in_days")+"')");
						}
					}
				}else{
					out.println("alert(getMessage('SEX_MAX_MIN_OVERLAP_CHK','OR'))");
				}
				putObjectInBean(bean_id,bean,request);
			}else if("ONLOADCONTENTS".equals(action)){
				//IN64543, starts
				String instructionType = bean.checkForNull((String)hash.get("instructionType"), "IS");
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				
				if("IS".equals(instructionType))
				{
					//String pat_preps_or_instrns_free_fmt_is = (String)((HashMap)bean.getInstructionsRecStr().get(2)).get("pat_preps_or_instrns_free_fmt_is");//commented for ML-MMOH-SCF-1108 
					String pat_preps_or_instrns_free_fmt_is = (String)((HashMap)bean.getInstructionsRecStrClob()).get("pat_preps_or_instrns_free_fmt_is");//ML-MMOH-SCF-1108 
					if(pat_preps_or_instrns_free_fmt_is==null)
						pat_preps_or_instrns_free_fmt_is =  "";	
					//out.println("loadContentInEditor('"+pat_preps_or_instrns_free_fmt_is+"')");//IN64543
					out.println(pat_preps_or_instrns_free_fmt_is);////IN64543
				}//IN64543, starts
				else if("IM".equals(instructionType))
				{
					//valuesFromBean = (HashMap)bean.getInstructionsRecStr().get(3);//commented for ML-MMOH-SCF-1108 
					valuesFromBean = (HashMap)bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
					rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
					//rowValues = (ArrayList)valuesFromBean.get("records");//commented for ML-MMOH-SCF-1108 
				
					out.println("clearBeforeInsertion()");
					if(rowValues!=null)
					{
						for(int start=0; start<rowValues.size();start++)
						{
							HashMap rowValHash = (HashMap)rowValues.get(start);							
							out.println("insertContentToRow('"+start+"','"+rowValHash.get("sex_spec_ind")+"','"+rowValHash.get("min_age_in_yrs")+"','"+rowValHash.get("min_age_in_mths")+"','"+rowValHash.get("min_age_in_days")+"','"+rowValHash.get("max_age_in_yrs")+"','"+rowValHash.get("max_age_in_mths")+"','"+rowValHash.get("max_age_in_days")+"')");
						}//IN64543
					}
				}
				putObjectInBean(bean_id,bean,request);
			}else if("MODIFYINPUTS".equals(action)){
				int curr_index = Integer.parseInt(bean.checkForNull((String)hash.get("index"), ""));				
				hash.remove("instructionType");
				hash.remove("action");
				hash.remove("index");				
				valuesFromBean = (HashMap)bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				
				rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
				HashMap map = new HashMap();
				//Set keys = hash.keySet();//commented for ML-MMOH-SCF-1108 
				rowMap = (HashMap)rowValues.get(curr_index);//ML-MMOH-SCF-1108 
				Set keys = rowMap.keySet();//ML-MMOH-SCF-1108 
		        for(Object key: keys){
		        	map.put(key,rowMap.get(key));//ML-MMOH-SCF-1108 
		        }
		        
				rowValues.set(curr_index,map);
				if(rowValues!=null){
					out.println("clearBeforeInsertion();");
					for(int start=0; start<rowValues.size();start++){
					HashMap rowValHash = (HashMap)rowValues.get(start);					
					out.println("insertContentToRow('"+start+"','"+rowValHash.get("sex_spec_ind")+"','"+rowValHash.get("min_age_in_yrs")+"','"+rowValHash.get("min_age_in_mths")+"','"+rowValHash.get("min_age_in_days")+"','"+rowValHash.get("max_age_in_yrs")+"','"+rowValHash.get("max_age_in_mths")+"','"+rowValHash.get("max_age_in_days")+"')");
					}
				}
				putObjectInBean(bean_id,bean,request);
			}else if("GETROWVALUES".equals(action)){
				lengthStr =bean.checkForNull((String)hash.get("index"), "");
				int length = Integer.parseInt(lengthStr);
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
				rowMap = (HashMap)rowValues.get(length);
				String sex_spec_ind = bean.checkForNull((String)rowMap.get("sex_spec_ind"), "");
				String min_age_in_yrs = bean.checkForNull((String)rowMap.get("min_age_in_yrs"), "");
				String min_age_in_mths = bean.checkForNull((String)rowMap.get("min_age_in_mths"), "");
				String min_age_in_days = bean.checkForNull((String)rowMap.get("min_age_in_days"), "");
				String max_age_in_yrs = bean.checkForNull((String)rowMap.get("max_age_in_yrs"), "");
				String max_age_in_mths = bean.checkForNull((String)rowMap.get("max_age_in_mths"), "");
				String max_age_in_days = bean.checkForNull((String)rowMap.get("max_age_in_days"), "");
				out.println("loadContentInRow('"+sex_spec_ind+"','"+min_age_in_yrs+"','"+min_age_in_mths+"','"+min_age_in_days+"','"+max_age_in_yrs+"','"+max_age_in_mths+"','"+max_age_in_days+"');");
				//out.println("closeEditorBoard()");//IN64543
				out.println("closeEditorBoard('"+l_read_only+"')");//IN64543
			}else if("GETCOMMENTS".equals(action)){
				lengthStr =bean.checkForNull((String)hash.get("index"), "-1");//ML-MMOH-SCF-1108 
				int length = Integer.parseInt(lengthStr);
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
				rowMap = (HashMap)rowValues.get(length);
				String pat_preps_or_instrns_free_fmt_im = bean.checkForNull((String)rowMap.get("pat_preps_or_instrns_free_fmt_im"), "");
				out.println(pat_preps_or_instrns_free_fmt_im);////IN64543
			}else if("CLEARVALUES".equals(action)){
				lengthStr =bean.checkForNull((String)hash.get("index"), "");
				int length = Integer.parseInt(lengthStr);
				//ML-MMOH-SCF-1108 start
				HashMap tempMap = (HashMap)bean.getInstructionsRecStr().get(3);
				ArrayList tempList = (ArrayList)tempMap.get("records");
				tempList.remove(length);
				if(tempList!=null){
					out.println("clearBeforeInsertion();");
					for(int start=0; start<tempList.size();start++){
					HashMap insideTempMap = (HashMap)tempList.get(start);
					out.println("insertContentToRow('"+start+"','"+insideTempMap.get("sex_spec_ind")+"','"+insideTempMap.get("min_age_in_yrs")+"','"+insideTempMap.get("min_age_in_mths")+"','"+insideTempMap.get("min_age_in_days")+"','"+insideTempMap.get("max_age_in_yrs")+"','"+insideTempMap.get("max_age_in_mths")+"','"+insideTempMap.get("max_age_in_days")+"')");
					}
				}
				//ML-MMOH-SCF-1108 end
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				((ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im")).remove(length);//ML-MMOH-SCF-1108 
				rowValues = ((ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im"));//ML-MMOH-SCF-1108 
				if(rowValues!=null){
					out.println("clearBeforeInsertion();");
					for(int start=0; start<rowValues.size();start++){
					HashMap rowValHash = (HashMap)rowValues.get(start);
					out.println("insertContentToRow('"+start+"','"+rowValHash.get("sex_spec_ind")+"','"+rowValHash.get("min_age_in_yrs")+"','"+rowValHash.get("min_age_in_mths")+"','"+rowValHash.get("min_age_in_days")+"','"+rowValHash.get("max_age_in_yrs")+"','"+rowValHash.get("max_age_in_mths")+"','"+rowValHash.get("max_age_in_days")+"')");
					}
				}
				out.println("clearValuesInAllEditors();closeEditorBoard();");
				putObjectInBean(bean_id,bean,request);
			}
			else if("AGE_SEX_CLEAR_ALL_VALUES".equals(action))//IN64543, starts
			{
				
				//ML-MMOH-SCF-1108 start
				HashMap tempMap = (HashMap)bean.getInstructionsRecStr().get(3);
				ArrayList tempList = (ArrayList)tempMap.get("records");
				if(tempList!=null)
					tempList.clear();
				//ML-MMOH-SCF-1108 end
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
				//ML-MMOH-SCF-1108 start
				if(rowValues!=null)
					rowValues.clear();
				out.println("clearValuesInAllEditors();closeEditorBoard('"+l_read_only+"');");
				putObjectInBean(bean_id,bean,request);
			}else if("STD_INSTRN_CLEAR_ALL_VALUES".equals(action))//IN64543, starts STD_INSTRN_CLEAR_ALL_VALUES
			{
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				if(valuesFromBean.containsKey("pat_preps_or_instrns_free_fmt_is"))
				valuesFromBean.remove("pat_preps_or_instrns_free_fmt_is");
				out.println("clearValuesInAllEditors();closeEditorBoard('"+l_read_only+"');");
				putObjectInBean(bean_id,bean,request);
			}else if("CLEAR_ALL_EDITOR_VALUES".equals(action))//IN64543, starts STD_INSTRN_CLEAR_ALL_VALUES
			{
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				if(valuesFromBean.containsKey("pat_preps_or_instrns_free_fmt_im")){
					rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
					if(rowValues!=null)
						rowValues.clear();
				}	
				if(valuesFromBean.containsKey("pat_preps_or_instrns_free_fmt_is")){
					valuesFromBean.remove("pat_preps_or_instrns_free_fmt_is");
				}
				//ML-MMOH-SCF-1108 end
				out.println("clearValuesInAllEditors();closeEditorBoard('"+l_read_only+"');");
				putObjectInBean(bean_id,bean,request);
			}//IN64543, ends
			else if("TEXT_AGE_SEX_CLEAR_ALL_VALUES".equals(action))//IN64543, starts
			{
				valuesFromBean = (HashMap)bean.getInstructionsRecStr().get(3);
				rowValues = (ArrayList)valuesFromBean.get("records");
				if(rowValues!=null)
					rowValues.clear();
				HashMap textValuesFromBean = (HashMap)bean.getInstructionsRecStr().get(2);
				if(textValuesFromBean!=null)
					textValuesFromBean.clear();	
				putObjectInBean(bean_id,bean,request);
			}//IN64543, ends
			else{//IN064543 end	
					try
					{
						
					  flag			      = bean.instructionByAgeSync(hash);
						//System.out.println("##########flag"+flag);
					}catch(Exception e){
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(e.getMessage()));
            _bw.write(_wl_block5Bytes, _wl_block5);
}
					//out.println("here================="+flag+ "");
					out.println("syncStatus(" + flag + ")");
					putObjectInBean(bean_id,bean,request);
			}//IN064543	
}catch(Exception e){
	System.out.println("Exp in OrderCatalogsync.jsp"+e.getMessage());
	e.printStackTrace();
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
