package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eST.Common.*;
import eST.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __assemblydetailvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/AssemblyDetailValidate.jsp", 1743161117529L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            java.util.ArrayList AssemblyDtlList= null;synchronized(session){
                AssemblyDtlList=(java.util.ArrayList)pageContext.getAttribute("AssemblyDtlList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(AssemblyDtlList==null){
                    AssemblyDtlList=new java.util.ArrayList();
                    pageContext.setAttribute("AssemblyDtlList",AssemblyDtlList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
	String bean_id = "AssemblyDetailBean";
	String bean_name = "eST.AssemblyDetailBean";
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	

	AssemblyDetailBean bean = (AssemblyDetailBean) getBeanObject(bean_id,bean_name,request);
			bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");

	
	String instruction=	bean.checkForNull(request.getParameter("instruction"));

	switch (functionType) {
	case 1:
		{

			boolean	result				=	true;
			String message="";
			String flag					=	"";
			try{
					String  key="CHILD_ITEM_CODE";
					String  key1="SEQ_NO";

					String value=(String)hash.get("child_item_code");
					String value1=(String)hash.get("Seqence_No");
					
					if(bean.isDuplicateInArrayList(AssemblyDtlList,key,value,Integer.parseInt("-1"))){
						result	=	false;
						message	=	"ITEM_CODE_ALREADY_EXIST";
					}
					else if(bean.isDuplicateInArrayList(AssemblyDtlList,key1,value1,Integer.parseInt("-1"))){
						result	=	false;
						message	=	"SEQ_NO_ALREADY_EXIST";
					}
				 	else{
						result	=	true;
						message	=	"done";
					}

					if  (result){
						String stock_uom=CommonBean.checkForNull(request.getParameter("stock_uom"),"");
						String Conv_factor=CommonBean.checkForNull(request.getParameter("Conv_factor"),"");
						String allow_deci_yn = CommonBean.checkForNull(request.getParameter("allow_deci_yn"),"N");
					    String no_deci = CommonBean.checkForNull(request.getParameter("no_deci"),"0");



						String mfg_desc=CommonBean.checkForNull(request.getParameter("mfg_desc"),"");
						
					HashMap hmAssemblyDetailRecord=new HashMap();
					hmAssemblyDetailRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
					hmAssemblyDetailRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
					hmAssemblyDetailRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
					hmAssemblyDetailRecord.put("COMPONENT",(String)hash.get("component") );
					hmAssemblyDetailRecord.put("MANDATORY",(String)hash.get("mandatory") );
					hmAssemblyDetailRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );

					hmAssemblyDetailRecord.put("PRINTONLABEL",(String)hash.get("PrintOnlabel") );
		            hmAssemblyDetailRecord.put("Manufactur",(String)hash.get("Manufactur") );
					hmAssemblyDetailRecord.put("SEQ_NO",(String)hash.get("Seqence_No") );

    				hmAssemblyDetailRecord.put("STOCK_UOM", stock_uom);
					hmAssemblyDetailRecord.put("CONV_FACTOR",Conv_factor);
					hmAssemblyDetailRecord.put("MFG_DESC",mfg_desc);
					hmAssemblyDetailRecord.put("UOM_CODE",(String)hash.get("uom_code") );
					hmAssemblyDetailRecord.put("ALLOW_DECI_YN",allow_deci_yn);
					hmAssemblyDetailRecord.put("NO_DECI",no_deci);
					hmAssemblyDetailRecord.put("TD_SALE_STK_UOM_CONV_RULE",request.getParameter("td_sale_stk_uom_conv_rule"));

						AssemblyDtlList.add(hmAssemblyDetailRecord);

						
					}
			}
			catch (Exception exception){
				result	=	false;
				message	=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ", \"" +message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 2:
		{
			String message			=	"";
			String flag				=	"";
			boolean	result			=	false;
			try	{
						String sale_uom =(String)hash.get("mfg_uom");
						String uom_code =request.getParameter("uom_code");
						String item_code =request.getParameter("item_code");
						//ML-MMOH-SCF-0382 starts
						HashMap uom_desc = bean.fetchRecord("SELECT SHORT_DESC   FROM AM_UOM WHERE UOM_CODE= ?",new String[]{uom_code});
						HashMap sale_desc = bean.fetchRecord("SELECT SHORT_DESC   FROM AM_UOM WHERE UOM_CODE= ?",new String[]{sale_uom});
						System.out.print("uom_desc=======110"+(String)uom_desc.get("SHORT_DESC"));
						//ML-MMOH-SCF-0382 ends
						if(sale_uom!=null && sale_uom!="")
							{
						int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, sale_uom}).get("COUNT"));
						int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, sale_uom,item_code}).get("COUNT"));
						if(item_uom_count >0){
						HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, sale_uom,item_code});
						//String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_code+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+sale_uom;	ML-MMOH-SCF-0382 
						String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)uom_desc.get("SHORT_DESC")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)sale_desc.get("SHORT_DESC");
						String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
						out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML=' <b>"+stEqvl_value+"</b>';");
						//out.println("document.all.	td_sale_stk_uom_conv_rule.innerHTML=' <b>"+conver+"</b>';");
						out.println("document.getElementById('td_sale_stk_uom_conv_rule').innerHTML=' <b>"+conver+"</b>';");
						result=true;
						}else if(am_count >0){

						String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, sale_uom}).get("EQVL_VALUE");
						//String conver=stEqvl_value+" "+sale_uom+" = 1 "+uom_code;ML-MMOH-SCF-0382 
						String conver=stEqvl_value+" "+(String)sale_desc.get("SHORT_DESC")+" = 1 "+(String)uom_desc.get("SHORT_DESC");
						out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML=' <b>"+stEqvl_value+"</b>';");
						//out.println("document.all.	td_sale_stk_uom_conv_rule.innerHTML=' <b>"+conver+"</b>';");
                        out.println("document.getElementById('td_sale_stk_uom_conv_rule').innerHTML=' <b>"+conver+"</b>';");
						
						result=true;
					
						}else{
						String stEqvl_value="1";
						out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML=' <b>"+stEqvl_value+"</b>';");
						//String conver="1 "+sale_uom+" = 1 "+uom_code;ML-MMOH-SCF-0382 
						String conver="1 "+(String)sale_desc.get("SHORT_DESC")+" = 1 "+(String)uom_desc.get("SHORT_DESC");
						//out.println("document.all.	td_sale_stk_uom_conv_rule.innerHTML=' <b>"+conver+"</b>';");
						out.println("document.getElementById('td_sale_stk_uom_conv_rule').innerHTML=' <b>"+conver+"</b>';");
						result=true;
						}




						//	String [] uom={uom_code,sale_uom,uom_code,sale_uom,item_code,uom_code,sale_uom};
						//	String sql = bean.getStRepositoryValue("SQL_ST_AM_UOM_EQL_CONVERSION_SELECT1");
						
						//	HashMap hmDefaultValues = bean.fetchRecord(sql,uom);
							
							
						//	if(((String)hmDefaultValues.get("EQVL_VALUE")).equals("")  ) {
						//	result	=	false;
						//	message	=	"Done";
						//	flag="NO_CONV_FACTOR_FOR_UOM_CODE";
						//	return;
						//	}
						//else{
						//	out.println("document.getElementById("td_sale_stk_uom_conv").innerHTML=' <b>"+bean.checkForNull((String)hmDefaultValues.get("EQVL_VALUE"),"")+"</b>';");
						//	result	=	true;
						//	message	=	"Done";
					//		return;
					//	}
						}
			}
			catch (Exception exception){
				result	=	false;
				flag	=	"NO_CONV_FACTOR_FOR_UOM_CODE";
				out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML='&nbsp';");
			}
			finally{
				out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 3:
		{
			String message				=	"";
			String flag					=	"";
			boolean	result				=	false;
			String  key1="SEQ_NO";
			String value1=(String)hash.get("Seqence_No");


			try{
					String stock_uom=CommonBean.checkForNull(request.getParameter("stock_uom"),"");
					String Conv_factor=CommonBean.checkForNull(request.getParameter("Conv_factor"),"");
					String mfg_desc=CommonBean.checkForNull(request.getParameter("mfg_desc"),"");
					String allow_deci_yn = CommonBean.checkForNull(request.getParameter("allow_deci_yn"),"N");
					String no_deci = CommonBean.checkForNull(request.getParameter("no_deci"),"0");
					String index				=	request.getParameter("index");
					HashMap hmAssemblyDetailRecord	=	(HashMap)AssemblyDtlList.get(Integer.parseInt(index));
					if(bean.isDuplicateInArrayList(AssemblyDtlList,key1,value1,Integer.parseInt(index))){

									result	=	false;
									message	=	"SEQ_NO_ALREADY_EXIST";
					}else{
						result	=	true;
						message	=	"done";
					}
					if(result){
						hmAssemblyDetailRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
						hmAssemblyDetailRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
						hmAssemblyDetailRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
						hmAssemblyDetailRecord.put("COMPONENT",(String)hash.get("component") );
						hmAssemblyDetailRecord.put("MANDATORY",(String)hash.get("mandatory") );
						hmAssemblyDetailRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );
						hmAssemblyDetailRecord.put("PRINTONLABEL",(String)hash.get("PrintOnlabel") );
						hmAssemblyDetailRecord.put("Manufactur",(String)hash.get("Manufactur") );
						hmAssemblyDetailRecord.put("SEQ_NO",(String)hash.get("Seqence_No") );
						hmAssemblyDetailRecord.put("MFG_DESC",mfg_desc);
						hmAssemblyDetailRecord.put("STOCK_UOM", stock_uom);
						hmAssemblyDetailRecord.put("CONV_FACTOR",Conv_factor);
						hmAssemblyDetailRecord.put("ALLOW_DECI_YN",allow_deci_yn);
						hmAssemblyDetailRecord.put("NO_DECI",no_deci);
						hmAssemblyDetailRecord.put("TD_SALE_STK_UOM_CONV_RULE",request.getParameter("td_sale_stk_uom_conv_rule"));

						AssemblyDtlList.set(Integer.parseInt(index),hmAssemblyDetailRecord);
					}
			}
			catch (Exception exception){
				result	=	false;
				message	=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 4:
		{
			String index				=	CommonBean.checkForNull(request.getParameter("index"),"-1");
			ArrayList  dataList=new ArrayList();
			dataList=bean.getDataModifyList();
           
		   	boolean	result				=	true;


			
			

			String message				=	"";
			String flag					=	"";
		
			try{	
					String  key1="SEQ_NO";
					String value1=(String)hash.get("Seqence_No");
                    String key="CHILD_ITEM_CODE";
					String value=(String)hash.get("child_item_code");

					String mfg_desc=CommonBean.checkForNull(request.getParameter("mfg_desc"),"");
					String stock_uom=CommonBean.checkForNull(request.getParameter("stock_uom"),"");
						String Conv_factor=CommonBean.checkForNull(request.getParameter("Conv_factor"),"");
						String uom_code_1=CommonBean.checkForNull(request.getParameter("uom_code"),"");
						HashMap hmAssemblyDetailRecord	=new HashMap();
						if(!index.equals("-1")){
							hmAssemblyDetailRecord	=	(HashMap)dataList.get(Integer.parseInt(index));
							if(bean.isDuplicateInArrayList(dataList,key1,value1,Integer.parseInt(index))){
							result	=	false;
							message	=	"SEQ_NO_ALREADY_EXIST";
						}
						}
						else{
					    if(bean.isDuplicateInArrayList(dataList,key,value,Integer.parseInt("-1"))){

									result	=	false;
									message	=	"ITEM_CODE_ALREADY_EXIST";
						}
						else if(bean.isDuplicateInArrayList(dataList,key1,value1,Integer.parseInt("-1"))){
							result	=	false;
							message	=	"SEQ_NO_ALREADY_EXIST";
						}
	 					else{
									result	=	true;
									message	=	"done";
							}
							
						}
						
				
						if(result){
								hmAssemblyDetailRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
								hmAssemblyDetailRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
								hmAssemblyDetailRecord.put("COMPONENT",(String)hash.get("component") );
								hmAssemblyDetailRecord.put("MANDATORY",(String)hash.get("mandatory") );
								hmAssemblyDetailRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );
								
								hmAssemblyDetailRecord.put("PRINTONLABEL",(String)hash.get("PrintOnlabel") );
								hmAssemblyDetailRecord.put("Manufactur",(String)hash.get("Manufactur") );
								hmAssemblyDetailRecord.put("SEQ_NO",(String)hash.get("Seqence_No") );

								hmAssemblyDetailRecord.put("MFG_DESC",mfg_desc);
								hmAssemblyDetailRecord.put("STOCK_UOM", stock_uom);
								hmAssemblyDetailRecord.put("CONV_FACTOR",Conv_factor);
								hmAssemblyDetailRecord.put("UOM_CODE",uom_code_1);
								hmAssemblyDetailRecord.put("TD_SALE_STK_UOM_CONV_RULE",request.getParameter("td_sale_stk_uom_conv_rule"));


								if(!index.equals("-1")){
									dataList.set(Integer.parseInt(index),hmAssemblyDetailRecord);
									bean.setDataModifyList(dataList);
								}
								else{
									hmAssemblyDetailRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
									hmAssemblyDetailRecord.put("FUNC_MODE","insert");
									
									dataList.add(hmAssemblyDetailRecord);
								}
								bean.setDataModifyList(dataList);
							}
						}
			catch (Exception exception){
				result	=	false;
				message	=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 5:
		{
			String uom_code =request.getParameter("uom_code");
			String item_code =request.getParameter("item_code");
			String mfg_uom=	request.getParameter("mfg_uom");
			HashMap uom_desc = bean.fetchRecord("SELECT SHORT_DESC   FROM AM_UOM WHERE UOM_CODE= ?",new String[]{uom_code}); //ML-MMOH-SCF-0382
			HashMap sale_desc = bean.fetchRecord("SELECT SHORT_DESC   FROM AM_UOM WHERE UOM_CODE= ?",new String[]{mfg_uom});//ML-MMOH-SCF-0382
			
			String stock_uom=	request.getParameter("stock_uom");
			
			bean.setStock_uom(stock_uom);
			bean.setMfg_uom(mfg_uom);
			bean.setItem_code(item_code);
			//String conver="1"+" "+mfg_uom+" = 1 "+uom_code;
			String conver="1 "+(String)sale_desc.get("SHORT_DESC")+" = 1 "+(String)uom_desc.get("SHORT_DESC");//ML-MMOH-SCF-0382
			out.println("document.getElementById('td_sale_stk_uom_conv_rule').innerHTML=' <b>"+ conver +"</b>';");	

			out.println("document.forms[0].mfg_uom.value=\""+mfg_uom+"\"");
		}
		break;
		case 6:
		{
			bean.setInstruction(instruction);
		}
		break;
		case 7:
		{
			java.util.HashMap record = new java.util.HashMap();
		
			out.println("clearListItems('document.forms[0].mfg_uom'); ");
					ArrayList mfg_uoms = bean.getMfgUom(bean.getMfg_uom());
					for(int i=0; i< mfg_uoms.size(); i++) {
						record = (java.util.HashMap)mfg_uoms.get(i);
						out.println("addListItem(\"document.forms[0].mfg_uom\", \"" + record.get("EQVL_UOM_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					
							if(record.get("EQVL_UOM_CODE").equals(bean.getMfg_uom())){
							
									out.println("document.forms[0].mfg_uom.value=\""+bean.getMfg_uom()+"\"");
							}
					}
		}
		break;
		default :
			out.println("alert(\'Invalid Function\');");
			return;
		}

            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);

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
