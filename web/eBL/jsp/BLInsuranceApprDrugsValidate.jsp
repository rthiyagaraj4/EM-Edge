
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*,eBL.* , eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%

    Hashtable hash				= (Hashtable)xmlObj.parseXMLString(request) ;
	String bean_id   = "@BLInsuranceApprDrugsBean" ;
	String bean_name = "eBL.BLInsuranceApprDrugsBean";
	BLInsuranceApprDrugsBean bean			= (BLInsuranceApprDrugsBean)getBeanObject( bean_id, bean_name, request);
	ArrayList DrugList = new ArrayList(bean.getOrderSatList());
	//System.err.println("DrugList:"+DrugList);
	HashMap sel_drug_list = (HashMap) session.getAttribute("sel_drug_list");
	if(sel_drug_list == null) sel_drug_list = new HashMap();
	
	String drugCode= (String)request.getParameter("drugCode")==null?"":(String)request.getParameter("drugCode");
	String sel_drug_desc = (String)request.getParameter("drugDesc")==null?"":(String)request.getParameter("drugDesc");
	
	String apprYN =   (String)request.getParameter("apprYN")==null?"":(String)request.getParameter("apprYN");
	String IPYN = (String)request.getParameter("IPYN")==null?"":(String)request.getParameter("IPYN");
	String DCYN = (String)request.getParameter("DCYN")==null?"":(String)request.getParameter("DCYN");
	String OPYN = (String)request.getParameter("OPYN")==null?"":(String)request.getParameter("OPYN");
	String EMYN = (String)request.getParameter("EMYN")==null?"":(String)request.getParameter("EMYN");
	String ALLYN = (String)request.getParameter("ALLYN")==null?"":(String)request.getParameter("ALLYN");
	String ApprAllYN = (String)request.getParameter("apprAllYN")==null?"N":(String)request.getParameter("apprAllYN");	
	
	String form_mode = (String)request.getParameter("form_mode")==null?"":(String)request.getParameter("form_mode");
	
	String calledFrm = (String)request.getParameter("calledFrm")==null?"":(String)request.getParameter("calledFrm");
	
	System.err.println("form_mode:"+form_mode);
	System.err.println("drugCode:"+drugCode);
	System.err.println("sel_drug_desc:"+sel_drug_desc);
	System.err.println("apprYN:"+apprYN);
	System.err.println("IPYN:"+IPYN);
	System.err.println("DCYN:"+DCYN);
	System.err.println("OPYN:"+OPYN);
	System.err.println("EMYN:"+EMYN);
	System.err.println("ALLYN:"+ALLYN);
	System.err.println("ApprAllYN:"+ApprAllYN);
	System.err.println("DrugList.size():"+DrugList.size());
	try
	{
		if("Q".equals(calledFrm)){
			for(int i=0; i<DrugList.size()-1; i++){
				if("Y".equals((String)DrugList.get(i+2)) || "Y".equals((String)DrugList.get(i+3)) || "Y".equals((String)DrugList.get(i+4)) || "Y".equals((String)DrugList.get(i+5)) || "Y".equals((String)DrugList.get(i+6)) || "Y".equals((String)DrugList.get(i+7)))
				{
					sel_drug_list.put(((String)DrugList.get(i)),((String)DrugList.get(i))+"~"+((String)DrugList.get(i+1))+"~"+((String)DrugList.get(i+2))+"~"+((String)DrugList.get(i+3))+"~"+((String)DrugList.get(i+4))+"~"+((String)DrugList.get(i+5))+"~"+((String)DrugList.get(i+6))+"~"+((String)DrugList.get(i+7)));
					
					//System.err.println("i:"+i);
				}
				i = i+7;
			}
		}
		else
		{
			if(form_mode.equals("apprChk") || form_mode.equals("IP") || form_mode.equals("DC") || form_mode.equals("OP") || form_mode.equals("EM") || form_mode.equals("ALL")){
				if(!drugCode.equals("")){
					for(int i=0; i<DrugList.size(); i++){				
						if(((String)DrugList.get(i)).trim().equals(drugCode.trim())){
							DrugList.set(i+2,apprYN);
							DrugList.set(i+3,IPYN);
							DrugList.set(i+4,DCYN);
							DrugList.set(i+5,OPYN);
							DrugList.set(i+6,EMYN);
							DrugList.set(i+7,ALLYN);						
							sel_drug_list.put(drugCode,drugCode+"~"+sel_drug_desc+"~"+apprYN+"~"+IPYN+"~"+DCYN+"~"+OPYN+"~"+EMYN+"~"+ALLYN);
							break;
						}				
					}
				}
			}		
			
			if(form_mode.equals("ApprAllDrugs")){
					if("Y".equals(ApprAllYN)){
						for(int i=0; i<DrugList.size()-1; i++){
							DrugList.set(i+2,"Y");
							sel_drug_list.put(DrugList.get(i),DrugList.get(i)+"~"+DrugList.get(i+1)+"~"+"Y"+"~"+DrugList.get(i+3)+"~"+DrugList.get(i+4)+"~"+DrugList.get(i+5)+"~"+DrugList.get(i+6)+"~"+DrugList.get(i+7));
							i = i+7;
						}
					} else {
						for(int i=0; i<DrugList.size()-1; i++){
							DrugList.set(i+2,"N");
							sel_drug_list.put(DrugList.get(i),DrugList.get(i)+"~"+DrugList.get(i+1)+"~"+"N"+"~"+DrugList.get(i+3)+"~"+DrugList.get(i+4)+"~"+DrugList.get(i+5)+"~"+DrugList.get(i+6)+"~"+DrugList.get(i+7));
							i = i+7;
						}				
					}
			}
		}
		//System.err.println("DrugList:"+DrugList);
		bean.setOrderSatList(DrugList);
		bean.setSelectedInsApprdDrugs(sel_drug_list);
		session.setAttribute("sel_drug_list",sel_drug_list);
		HashMap hm = new HashMap(bean.getSelectedInsApprdDrugs());
		System.err.println("hm.setAttribute:"+hm);
	}catch (Exception e){
		System.err.println("Exception in BLInsuranceApprDrugsValidate.jsp:"+e);
	}
%>
