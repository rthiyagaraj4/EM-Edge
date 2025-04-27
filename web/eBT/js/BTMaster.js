function addTag(name,attr,value)
{
	return("<" +name+" "+attr+"="+"\""+ checkSpl(value)+"\" " );	
}

function endTag(name)
{
	return("</" +name+">");	
}

function checkSpl( val ) 
{
    var result = "" ;
    var ch = "" ;
    var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1)
    {
        val = val.replace("\n","\"")
    }

    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }
    
    return result ;
}
function tagAtt(name,val)
{
	if ((val == '')||(val == 'undefined')||(val=='null'))
	{
		return (name+"=\"\"" );
	}
	return(name+"=\"" + checkSpl(val) + "\"" );
}
function checkNull(val)
{
	if (((val.name != null)&&(val.name != 'undefined')&&(val.name != '')) ||
	 ( (val.id != null)&&(val.id != 'undefined')&&(val.id != '') )	 )
	{
		return true;
	}
	return(false);
}

function checkAttributeNull(element,attribute)
{
	
	var val = element.getAttribute(attribute) ;
	
	if ((val != null)&&(val != 'undefined')&&(val != '')&&(val != 'null'))
	{
		return val;
	}
	return('');
}

function checkIdName(val)
{
	try
	{



		if ((val.name != null)&&(val.name != 'undefined')&&(val.name != '')) 
		{
			return(val.name);
		}
		if ( (val.id != null)&&(val.id != 'undefined')&&(val.id != '') )	
		{
			return(val.id);
		}
	}
	catch(e)
	{

	}

}

function addAttribute(arrObj)
{
			var val='';
			var nameid='';
			
			
            if(arrObj.type == "checkbox") 
			{
				//if(arrObj.checked)
                    val = arrObj.value;
					nameid = checkIdName(arrObj);
					if (nameid == '') return '';
                    return tagAtt(nameid,val);
            }
            else if(arrObj.type == "radio") 
			{
				try
				{
				
						val = arrObj.value;
						nameid = checkIdName(arrObj);
						if (nameid == '') return '';
						return tagAtt(nameid,val);                
						
				}
				catch(e)
				{
					alert('Error='+e);
				}

            }
            else if(arrObj.type == "select-multiple" ) 
			{
                for(var j=0; j<arrObj[i].options.length; j++)
                {
                    if(arrObj[i].options[j].selected)
                        val+=arrObj[i].options[j].value +"~"
                }
	                val= val.substring(0,val.lastIndexOf('~'))
					nameid = checkIdName(arrObj);
					if (nameid == '') return '';
                    return tagAtt(nameid,val);
            }
            else 
			{
				try
				{
					val = arrObj.value;
					nameid = checkIdName(arrObj);
					if (nameid == '') return '';
                    return tagAtt(nameid,val);
				}
				catch(er)
				{
				
				}
            }
	return('');
}
function MasterXMLFormApply(frmObj) 
{

	var formId = frmObj;
	var idall = formId.all;
	var xmlString = '';
	xmlString = '<root><' + formId.name;
	var endxmlString = '> </'+formId.name+'>'; 
	var record_type = '';
	for (l=0;l<idall.length;l++)
	{
		record_type = checkAttributeNull(idall[l],'RECORD_TYPE');
		if (record_type == 'S')
		{

				xmlString = xmlString +' '+	addAttribute(idall[l])+' ';
		}
	}
	xmlString = xmlString+endxmlString+"</root>";
	
	
	return(xmlString);
}



function checkExistRec(rec_id,arr)
{
	var len = arr.length;


	for (k=0;k<len ;k++ )
	{
		if (arr[k] == rec_id)
		{
			return(true)
		}
	}
	return(false);
}



function funBTMasterDetailXMLSubmit(frmMaster,frmDetail,arr)
{
	var formId = frmMaster;
	
	var idall = formId.all;
	var xmlString = '';


	var rec_id_name = formId.RECORD_ID_NAME;

	xmlString = '<root><' + formId.name;
	endxmlString = '</'+formId.name+'>'; 

	var curr_rec_id_value = '';
	var prev_rec_id_value = '';
	var rec_tag_id ='REC_ID';
	var detail_block_tag_id = formId.DETAIL_BLOCK_NAME;
//	var rec_values_tag_id = 'DB_NAME';
	var rec_values = '';
	var tag = '';
	var detailXmlString = '';
	var record_type = '';
	//For traversin the master form



	for (l=0;l<idall.length;l++)
	{
		record_type = checkAttributeNull(idall[l],'RECORD_TYPE');
		if (record_type == 'S')
		{

				xmlString = xmlString +' '+	addAttribute(idall[l])+' ';
		}
	}





	var formId1 = frmDetail;



//	 xmlString+=">< "+ formId1.name;
 //	endxmlString = '</'+formId1.name+'>'; 


	rec_id_name = formId1.RECORD_ID_NAME ;
	detail_block_tag_id = formId1.DETAIL_BLOCK_NAME;


	//alert(formId1.length);

	for (kk=0;kk<formId1.length; kk++)	
		{

	
			curr_rec_id_value = checkAttributeNull(formId1[kk],rec_tag_id);

			if (curr_rec_id_value!='') 
			{

				if (checkExistRec(curr_rec_id_value,arr) == true)
				{



					if (curr_rec_id_value != prev_rec_id_value) 
					{
						if (tag == '')
						{
						//dhana
							tag = addTag(detail_block_tag_id,rec_id_name,curr_rec_id_value);
						}
						else
						{
							tag = tag + " >";
							tag = tag + "</"+detail_block_tag_id+">";
							detailXmlString = detailXmlString + tag;
							tag = addTag(detail_block_tag_id,rec_id_name,curr_rec_id_value);
						}
						prev_rec_id_value = curr_rec_id_value;
					}

					tag	= tag+' '+	addAttribute(formId1[kk])+' ';
		
				}// else
			
		}
		
		
	}
	// end of for
	tag = tag + " >";
	tag = tag + "</"+detail_block_tag_id+">";
	detailXmlString = detailXmlString + tag;

	xmlString = xmlString +">";


	xmlString =	xmlString+detailXmlString+endxmlString+"</root>";



	return(xmlString);
}


