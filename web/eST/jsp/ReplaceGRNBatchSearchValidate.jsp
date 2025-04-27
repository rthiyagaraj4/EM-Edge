<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>


<jsp:useBean id="XMLobj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj39"   scope="page"  class="eST.BatchSearchGoodsReturnToVendorBean"/>

<%
request.setCharacterEncoding("UTF-8");
	
	int functionType = Integer.parseInt(request.getParameter("function_type"));

	String bean_id = "batchSearchReplaceGRNBean";
	String bean_name = "eST.BatchSearchReplaceGRNBean";
	BatchSearchReplaceGRNBean bean = (BatchSearchReplaceGRNBean) getBeanObject( bean_id, bean_name,request  );  

	String bean_id2 = "replacementGRNBean";
	String bean_name2 = "eST.ReplacementGRNBean";
	ReplacementGRNBean bean2 = (ReplacementGRNBean) getBeanObject( bean_id2,bean_name2, request );  
//	bean.clear();

	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");

switch (functionType) {

	case 1:
		{
		// pmd 29/01/05
//				String facility_id				=	(String) session.getAttribute("facility_id");
				String item_code			=   CommonBean.checkForNull(request.getParameter("item_code"),"");
				String store_code			=	CommonBean.checkForNull(request.getParameter("store_code"),"");
				String supp_code			=	CommonBean.checkForNull(request.getParameter("supp_code"),"");
				String grn_doc_type_code			=	CommonBean.checkForNull(request.getParameter("grn_doc_type_code"),"%");
				String grn_doc_no			=	CommonBean.checkForNull(request.getParameter("grn_doc_no"),"%");
						
				//String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
				//String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;

				bean.setItem_code(item_code) ;
				bean.setStore_code(store_code) ;

				bean.setSupp_code(supp_code) ;
				bean.setGrn_doc_type_code(grn_doc_type_code) ;
				bean.setGrn_doc_no(grn_doc_no) ;
				bean.loadResultPage();
		}
		break;
		case 2:
		{
//			String start		= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
//			String end			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
//			String stColumnName	= request.getParameter( "ordercolmns" )==null?"":request.getParameter( "ordercolmns" ) ;
		}
		break;
		case 3:
		{
	//		String start		= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	//		String end			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	//		String stColumnName	= request.getParameter( "ordercolmns" )==null?"":request.getParameter( "ordercolmns" ) ;
			out.println("document.forms[0].count.value=1;");
		}
		break;
		case 4:
		{
			String index= request.getParameter( "index" )==null?"":request.getParameter( "index" ) ;
			String noOfCheckedRecords= request.getParameter( "noOfCheckedRecords" )==null?"":request.getParameter( "noOfCheckedRecords" ) ;
			String returnvals = request.getParameter("returnvals")==null?"":request.getParameter("returnvals");
			ArrayList grnValues = new ArrayList();
			StringTokenizer st=new StringTokenizer (returnvals,"*");
			StringTokenizer values = null;
			HashMap grnSelectedValues = new HashMap();
			while(st.hasMoreTokens())
			{
				
				String record = st.nextToken();
				values = new StringTokenizer (record,"`");
				while(values.hasMoreTokens())
				{
					grnSelectedValues = new HashMap();
					//ACETATE`C1RTV`Acetate`30`1`0`0`12`Y`Y
					grnSelectedValues.put("item_code" , values.nextToken());
					grnSelectedValues.put("doc_type_code" , values.nextToken());
					grnSelectedValues.put("item_desc" , values.nextToken());
					grnSelectedValues.put("doc_no" , values.nextToken());
					grnSelectedValues.put("doc_srl_no" , values.nextToken());
					String rtv_repl_qty = values.nextToken();
					grnSelectedValues.put("rtv_repl_qty" , rtv_repl_qty);

					grnSelectedValues.put("pend_repl_qty" , values.nextToken());
					//String pend_repl_qty = values.nextToken();
					String received_qty = values.nextToken();
					grnSelectedValues.put("received_qty" , received_qty);
					grnSelectedValues.put("close_yn" , values.nextToken());
					grnSelectedValues.put("rtv_unit_cost" , values.nextToken());
					grnSelectedValues.put("check" , values.nextToken());
					Double pend_repl_qty = Double.parseDouble((String)grnSelectedValues.get("pend_repl_qty")) - Double.parseDouble(received_qty); 
					if(pend_repl_qty < 0.0)
						pend_repl_qty = 0.0;
					grnSelectedValues.put("pend_repl_qty" , pend_repl_qty+"");
					grnValues.add(grnSelectedValues);
					//grnSelectedValues.clear();
				}
			}
			bean.selectedBatches(index,noOfCheckedRecords);
			
			
			bean2.setGRNRecords(bean.getItem_code(),grnValues);
		}
		break;
		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id2,bean2,request);
%>
