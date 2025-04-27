function create() {
	
	f_query_add_mod.location.href = "../../eSM/jsp/addModifyForeignCurrency.jsp?operation=insert" ;	
}


function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply()
  {
	 /* if (! (checkIsValidForProceed()) )
    {
        
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	var fields = new Array(
				f_query_add_mod.document.forms[0].currency_code,
	 	     	        f_query_add_mod.document.forms[0].currency_name,
		             f_query_add_mod.document.forms[0].decimal_name,f_query_add_mod.document.forms[0].conversion_rate,f_query_add_mod.document.forms[0].conversion_operator,f_query_add_mod.document.forms[0].no_decimal,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);

	var names = new Array (getLabel("eSM.CurrencyCode.label","SM"),getLabel("eSM.CurrencyName.label","SM"),getLabel("eSM.DecimalName.label","SM"),getLabel("eSM.ConversionRate.label","SM"),getLabel("eSM.ConversionOperator.label","SM"),getLabel("eSM.NumberofDecimals.label","SM"), getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"))

	var field = new Array(f_query_add_mod.document.forms[0].decimal_name,f_query_add_mod.document.forms[0].no_decimal);
	var name = new Array (getLabel("eSM.DecimalName.label","SM"),getLabel("eSM.NumberofDecimals.label","SM"))

	if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
		{
			
			if(f_query_add_mod.document.forms[0].setup_gl_install_yn.value=='Y' && f_query_add_mod.document.forms[0].acc_code1_desc.value !='' && (f_query_add_mod.document.forms[0].acc_code2_desc.value=='' || f_query_add_mod.document.forms[0].dept_desc.value=='' || f_query_add_mod.document.forms[0].prdt_grp.value=='' || f_query_add_mod.document.forms[0].prdt_line.value=='' || f_query_add_mod.document.forms[0].ledger_grp.value==''  || f_query_add_mod.document.forms[0].ledger_line.value==''))
				{
					//alert('Please enter all account information');
					alert(getMessage("INVALID_POSTING_ACCOUNT","SM"));					
					frames[0].location.reload();
					messageFrame.location.href= "../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0";
					return false;
				}

			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				for(i=0;i<f_query_add_mod.document.foreign_currency_form.elements.length;i++)
					f_query_add_mod.document.foreign_currency_form.elements[i].disabled = false;

				f_query_add_mod.document.foreign_currency_form.submit();	
				//messageFrame.location.href= "../../eCommon/html/blank.html";
			}
		}
	else
	  {
		frames[0].location.reload();
		messageFrame.location.href= "../../eCommon/html/blank.html";
		return false;
	  }
  }

  function reset()
  {
	   frames[1].location.reload();

  }

  function validateOperatorValue(obj)
  {
	  if(obj.value!='' && (!(obj.value=='*' || obj.value=='/')))
	  {
		 // alert("Please enter either * or /  conversion operator.");
		  alert(getMessage("INVALID_OPERATOR","SM"));
		  
		  //obj.select();
obj.value='';
					obj.readOnly=false;
obj.focus();
		 
		 
	  }
	   return false;
  }

  function validateNoOfDecimal1(obj)
  {
	 
	  if(obj.value!='' && (!(obj.value=='2' || obj.value=='3')))
	  {
		  //alert("Applicable only either 2 Decimal Point or 3  Decimal Point.");
		  alert(getMessage("INVALID_NUM_OF_DEC_PLACES","SM"));
		  //obj.select();
		 obj.value='';
					obj.readOnly=false;
obj.focus();
		  return false;
	  }
  }

  function onSuccess()
  {
	  frames[1].location.reload();
   //  messageFrame.location.href= "../../eCommon/html/blank.html";

  }

  function query()
  {
	  f_query_add_mod.location.href = "../../eSM/jsp/ForeignCurrQueryCriteria.jsp" ;	
  }

 async function SelectMainAccount1(desc,code,displayName)
	{
		    tar=desc.value
			var isOldVal = false;				
			var retVal =    new String();
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit = "";
		
			if(displayName=='MainAccountCode1')
			{
				tit  = getLabel('eSM.MainAccountCode1.label','SM');	
				sql= "SELECT DISTINCT a.main_acc1_code code, b.short_desc description FROM gl_posting_acc a, gl_acc_chart b WHERE a.main_acc1_code = b.main_acc1_code AND a.main_acc2_code = b.main_acc2_code AND NVL(b.bank_acct_yn , 'N' ) ='N' AND b.ap_valid_flag='Y' AND B.ACC_NATURE_CODE = 'PL'  and upper(a.main_acc1_code) like upper(?) and upper(b.short_desc) like upper(?) order by 2";
			}
			else if (displayName=='MainAccountCode2')
			{
				tit  = getLabel('eSM.MainAccountCode2.label','SM');	
				sql= "SELECT DISTINCT a.main_acc2_code code ,b.short_desc description FROM gl_posting_acc a, gl_acc_chart b WHERE a.main_acc1_code = b.main_acc1_code AND a.main_acc2_code = b.main_acc2_code AND NVL(b.bank_acct_yn , 'N' ) ='N' AND b.ap_valid_flag='Y' AND A.main_acc1_code = '"+document.forms[0].acc_code1.value+"' AND B.ACC_NATURE_CODE = 'PL' and upper(a.main_acc2_code) like upper(?) and upper(b.short_desc) like upper(?) order by 2";
			}
			else if(displayName=='DepartmentCode')
			{
				tit  = getLabel('eSM.DepartmentCode.label','SM');	
                sql = "select distinct  a.dept_code code, a.dept_desc description from gl_posting_acc a, gl_acc_chart b where a.main_acc1_code = b.main_acc1_code and a.main_acc2_code = b.main_acc2_code and nvl(b.bank_acct_yn , 'N' ) ='N' and b.ap_valid_flag='Y' AND A.main_acc1_code = '"+document.forms[0].acc_code1.value+"' and a.main_acc2_code = '"+document.forms[0].acc_code2.value+"' AND B.ACC_NATURE_CODE = 'PL' and upper(a.dept_code) like upper(?) and upper(a.dept_desc) like upper(?) order by 2";			
			}
			else if(displayName=='ProductGroupCode')
			{
				tit  = getLabel('eSM.ProductGroupCode.label','SM');	
				sql = "select distinct a.product_group_code code,a.prod_desc description from gl_posting_acc a, gl_acc_chart b where a.main_acc1_code = b.main_acc1_code and a.main_acc2_code = b.main_acc2_code and nvl(b.bank_acct_yn , 'N' ) ='N' and b.ap_valid_flag='Y' AND A.main_acc1_code = '"+document.forms[0].acc_code1.value+"' and a.main_acc2_code = '"+document.forms[0].acc_code2.value+"' and a.dept_code = '"+document.forms[0].dept_code.value+"' AND B.ACC_NATURE_CODE = 'PL' and upper(a.product_group_code) like upper(?) and upper(a.prod_desc) like upper(?) order by 2";			
			}
			else if(displayName=='ProductLineCode')
			{
				tit  = getLabel('eSM.ProductLineCode.label','SM');	
				sql = "SELECT DISTINCT a.product_line_code code,a.prod_desc description  FROM gl_posting_acc a, gl_acc_chart b WHERE a.main_acc1_code = b.main_acc1_code AND a.main_acc2_code = b.main_acc2_code AND NVL(b.bank_acct_yn , 'N' ) ='N' AND b.ap_valid_flag='Y' AND A.main_acc1_code = '"+document.forms[0].acc_code1.value+"' AND a.main_acc2_code = '"+document.forms[0].acc_code2.value+"' AND a.dept_code = '"+document.forms[0].dept_code.value+"' AND a.product_group_code = '"+document.forms[0].prdt_grp_code.value+"' AND B.ACC_NATURE_CODE = 'PL' and upper(a.product_group_code) like upper(?) and upper(a.prod_desc) like upper(?) order by 2 ";			
			}
			else if(displayName=='SubLedgerGroupCode')
			{
				tit  = getLabel('eSM.SubLedgerGroupCode.label','SM');	
				sql= "select distinct  a.subledger_group_code code, a.sleg_desc description from gl_posting_acc a, gl_acc_chart b where a.main_acc1_code = b.main_acc1_code and a.main_acc2_code = b.main_acc2_code and nvl(b.bank_acct_yn , 'N' ) ='N' and b.ap_valid_flag='Y' AND A.main_acc1_code = '"+document.forms[0].acc_code1.value+"' and a.main_acc2_code = '"+document.forms[0].acc_code2.value+"' and a.dept_code = '"+document.forms[0].dept_code.value+"' and a.product_group_code = '"+document.forms[0].prdt_grp_code.value+"' and a.product_line_code = '"+document.forms[0].prdt_line_code.value+"' AND B.ACC_NATURE_CODE = 'PL' and upper(a.subledger_group_code) like upper(?) and upper(a.sleg_desc) like upper(?) order by 2";			
			}
			else if(displayName=='SubLedgerLineCode')
			{
				tit  = getLabel('eSM.SubLedgerLineCode.label','SM');	
				sql="SELECT DISTINCT a.subledger_line_code code ,a.sleg_desc description FROM gl_posting_acc a, gl_acc_chart b WHERE a.main_acc1_code = b.main_acc1_code AND a.main_acc2_code = b.main_acc2_code AND NVL(b.bank_acct_yn , 'N' ) ='N' AND b.ap_valid_flag='Y' AND A.main_acc1_code = '"+document.forms[0].acc_code1.value+"' AND a.main_acc2_code = '"+document.forms[0].acc_code2.value+"' AND a.dept_code = '"+document.forms[0].dept_code.value+"' AND a.product_group_code = '"+document.forms[0].prdt_grp_code.value+"' AND a.product_line_code = '"+document.forms[0].prdt_line_code.value+"' AND a.subledger_group_code = '"+document.forms[0].ledger_grp_code.value+"' AND B.ACC_NATURE_CODE = 'PL' and upper(a.subledger_line_code) like upper(?) and upper(a.sleg_desc) like upper(?) order by 2";
			}				
		


			
			argumentArray[0] =	sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = tar;
			argumentArray[6] = DESC_LINK ;
			argumentArray[7] = DESC_CODE ;
			retVal = await CommonLookup( tit, argumentArray );


		
			if(retVal != null && retVal != "" )
			  {
				
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				desc.value = arr[1];
				if(code.value==arr[0])
					isOldVal = true;
				code.value = arr[0];	

				
				
				if(displayName=='MainAccountCode1' && !isOldVal)
				  {
					document.forms[0].acc_code2_desc.disabled =false;
					document.forms[0].acc_code2_lookup.disabled =false;
					document.forms[0].dept_desc.disabled =true;
					document.forms[0].dept_code_lookup.disabled =true;
					document.forms[0].prdt_grp.disabled =true;
					document.forms[0].prdt_grp_lookup.disabled =true;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;	

					document.forms[0].acc_code2_desc.value ="";
					document.forms[0].acc_code2.value ="";			
					document.forms[0].dept_desc.value ="";
					document.forms[0].dept_code.value ="";
					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='MainAccountCode2' && !isOldVal)
				  {
					document.forms[0].dept_desc.disabled =false;
					document.forms[0].dept_code_lookup.disabled =false;
					document.forms[0].prdt_grp.disabled =true;
					document.forms[0].prdt_grp_lookup.disabled =true;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].dept_desc.value ="";
					document.forms[0].dept_code.value ="";
					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";

				  }
				else if(displayName=='DepartmentCode' && !isOldVal)
				  {
					document.forms[0].prdt_grp.disabled =false;
					document.forms[0].prdt_grp_lookup.disabled =false;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='ProductGroupCode' && !isOldVal)
				  {
					document.forms[0].prdt_line.disabled =false;
					document.forms[0].prdt_line_lookup.disabled =false;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";

				  }
				 else if(displayName=='ProductLineCode' && !isOldVal)
				  {
						document.forms[0].ledger_grp.disabled =false;
						document.forms[0].ledger_grp_lookup.disabled =false;	
						document.forms[0].ledger_line.disabled =true;
						document.forms[0].ledger_line_lookup.disabled =true;

						document.forms[0].ledger_grp.value ="";
						document.forms[0].ledger_grp_code.value ="";
						document.forms[0].ledger_line.value ="";
						document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='SubLedgerGroupCode' && !isOldVal)
				  {
						document.forms[0].ledger_line.disabled =false;
						document.forms[0].ledger_line_lookup.disabled =false;	

						document.forms[0].ledger_line.value ="";
						document.forms[0].ledger_line_code.value ="";
				  }
			  }
			  else
			  {
				  desc.value = "";
				  code.value = "";	

				  if(displayName=='MainAccountCode1')
				  {
					document.forms[0].acc_code2_desc.disabled =true;
					document.forms[0].acc_code2_lookup.disabled =true;
					document.forms[0].dept_desc.disabled =true;
					document.forms[0].dept_code_lookup.disabled =true;
					document.forms[0].prdt_grp.disabled =true;
					document.forms[0].prdt_grp_lookup.disabled =true;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;	

					document.forms[0].acc_code2_desc.value ="";
					document.forms[0].acc_code2.value ="";			
					document.forms[0].dept_desc.value ="";
					document.forms[0].dept_code.value ="";
					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='MainAccountCode2')
				  {
					document.forms[0].dept_desc.disabled =true;
					document.forms[0].dept_code_lookup.disabled =true;
					document.forms[0].prdt_grp.disabled =true;
					document.forms[0].prdt_grp_lookup.disabled =true;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].dept_desc.value ="";
					document.forms[0].dept_code.value ="";
					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";

				  }
				else if(displayName=='DepartmentCode')
				  {
					document.forms[0].prdt_grp.disabled =true;
					document.forms[0].prdt_grp_lookup.disabled =true;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='ProductGroupCode')
				  {
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";

				  }
				 else if(displayName=='ProductLineCode')
				  {
						document.forms[0].ledger_grp.disabled =true;
						document.forms[0].ledger_grp_lookup.disabled =true;	
						document.forms[0].ledger_line.disabled =true;
						document.forms[0].ledger_line_lookup.disabled =true;

						document.forms[0].ledger_grp.value ="";
						document.forms[0].ledger_grp_code.value ="";
						document.forms[0].ledger_line.value ="";
						document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='SubLedgerGroupCode')
				  {
						document.forms[0].ledger_line.disabled =true;
						document.forms[0].ledger_line_lookup.disabled =true;	

						document.forms[0].ledger_line.value ="";
						document.forms[0].ledger_line_code.value ="";
				  }
			  }	
		
	}

function SelectAccountInfo(desc,code,displayName)
{
	
	if(desc.value!='')
		SelectMainAccount1(desc,code,displayName);	
	else
	{
		 desc.value = "";
		 code.value = "";	
		if(displayName=='MainAccountCode1')
				  {
					document.forms[0].acc_code2_desc.disabled =true;
					document.forms[0].acc_code2_lookup.disabled =true;
					document.forms[0].dept_desc.disabled =true;
					document.forms[0].dept_code_lookup.disabled =true;
					document.forms[0].prdt_grp.disabled =true;
					document.forms[0].prdt_grp_lookup.disabled =true;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;	

					document.forms[0].acc_code2_desc.value ="";
					document.forms[0].acc_code2.value ="";			
					document.forms[0].dept_desc.value ="";
					document.forms[0].dept_code.value ="";
					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='MainAccountCode2')
				  {
					
					document.forms[0].dept_desc.disabled =true;
					document.forms[0].dept_code_lookup.disabled =true;
					document.forms[0].prdt_grp.disabled =true;
					document.forms[0].prdt_grp_lookup.disabled =true;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].dept_desc.value ="";
					document.forms[0].dept_code.value ="";
					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";

				  }
				else if(displayName=='DepartmentCode')
				  {
					document.forms[0].prdt_grp.disabled =true;
					document.forms[0].prdt_grp_lookup.disabled =true;	
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].prdt_grp.value ="";
					document.forms[0].prdt_grp_code.value ="";
					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='ProductGroupCode')
				  {
					document.forms[0].prdt_line.disabled =true;
					document.forms[0].prdt_line_lookup.disabled =true;
					document.forms[0].ledger_grp.disabled =true;
					document.forms[0].ledger_grp_lookup.disabled =true;	
					document.forms[0].ledger_line.disabled =true;
					document.forms[0].ledger_line_lookup.disabled =true;

					document.forms[0].prdt_line.value ="";
					document.forms[0].prdt_line_code.value ="";
					document.forms[0].ledger_grp.value ="";
					document.forms[0].ledger_grp_code.value ="";
					document.forms[0].ledger_line.value ="";
					document.forms[0].ledger_line_code.value ="";

				  }
				 else if(displayName=='ProductLineCode')
				  {
						document.forms[0].ledger_grp.disabled =true;
						document.forms[0].ledger_grp_lookup.disabled =true;	
						document.forms[0].ledger_line.disabled =true;
						document.forms[0].ledger_line_lookup.disabled =true;

						document.forms[0].ledger_grp.value ="";
						document.forms[0].ledger_grp_code.value ="";
						document.forms[0].ledger_line.value ="";
						document.forms[0].ledger_line_code.value ="";
				  }
				else if(displayName=='SubLedgerGroupCode')
				  {
						document.forms[0].ledger_line.disabled =true;
						document.forms[0].ledger_line_lookup.disabled =true;	

						document.forms[0].ledger_line.value ="";
						document.forms[0].ledger_line_code.value ="";
				  }
	}
}

function validateNoOfDecimal(Obj)
{
	var conver_rate = Obj.value;
	
	if(conver_rate!='')
	{
		if(CheckNum(Obj))
		{
			if(conver_rate.length>8)
			{
				if(conver_rate.indexOf(".")!=-1)
				{
					var integral_part =  conver_rate.substring(0,conver_rate.indexOf("."));
					var decimal_part = conver_rate.substring(conver_rate.indexOf(".")+1);				

					if(integral_part.length>8 || decimal_part.length> 8 )
					{
						//alert("You can enter max 8 digit integral and max 8 digit of decimal values.");
						var msg = getMessage("INVALID_VALUE","Common");
						msg = msg.replace("#",getLabel("eSM.ConversionRate.label","SM"));
						alert(msg);
						//Obj.select();
						Obj.value='';
						Obj.focus();
						return false;
					}
				}
				else
				{
					//alert("You can enter max 8 digit integral and max 8 digit of decimal values.");
					var msg = getMessage("INVALID_VALUE","Common");
						msg = msg.replace("#",getLabel("eSM.ConversionRate.label","SM"));
						alert(msg);
					//Obj.select();
					Obj.value='';
					Obj.focus();
					return false;
				}
			}
			else
				return true;
		}
		else
		{
			return false;
		}
	}
}

function disabledEnabledFields()
{
	if(document.forms[0].operation.value=='modify' && document.forms[0].setup_gl_install_yn.value=='Y')
	{
		if(document.forms[0].acc_code2_desc.value!='')
		{
			document.forms[0].acc_code2_desc.disabled =false;
			document.forms[0].acc_code2_lookup.disabled =false;			
		}

		if(document.forms[0].dept_desc.value!='')
		{
			document.forms[0].dept_desc.disabled =false;
			document.forms[0].dept_code_lookup.disabled =false;			
		}

		if(document.forms[0].prdt_grp.value!='')
		{
			document.forms[0].prdt_grp.disabled =false;
			document.forms[0].prdt_grp_lookup.disabled =false;			
		}

		if(document.forms[0].prdt_line.value!='')
		{
			document.forms[0].prdt_line.disabled =false;
			document.forms[0].prdt_line_lookup.disabled =false;			
		}

		if(document.forms[0].ledger_grp.value!='')
		{
			document.forms[0].ledger_grp.disabled =false;
			document.forms[0].ledger_grp_lookup.disabled =false;			
		}

		if(document.forms[0].ledger_line.value!='')
		{
			document.forms[0].ledger_line.disabled =false;
			document.forms[0].ledger_line_lookup.disabled =false;			
		}
	}
}
				
	
