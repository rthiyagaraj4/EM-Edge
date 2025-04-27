/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDR.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
			{"THREE_FIELD","APP-DR0001 至少选择3个字段"},
			{"CHECK_DAY_MONTH","APP-DR0002 检查完�?的年/月/日组�?�"},
			{"CHECK_MONTH_YEAR","APP-DR0003 检查完�?的年/月"},
			{"ATLEAT_ONE_NAME","APP-DR0004 至少选择一个�??称组件"},
			{"SEARCH_ACTIVE","APP-DR0005 查询功能�?�用"},
			{"ONLY_TWO","APP-DR0006 �?��?�以选择2个病人"},
			{"TWO_PATIENTS","APP-DR0007 最少选择2个病人"},
			{"TEN_PATIENTS","APP-DR0008 �?能一次看10个病人，用�?选框任�?选择2个病人"},
			{"NO_RECORD","APP-DR0009 病人记录�?存在"},
			{"PATIENT_NOT_SELECTED","APP-DR0010 没有被人记录被选 中"},
			{"CYCLE_IN_PROGRESS","APP-DR0011 循环已�?在�?�得进展"},
			{"NO_RECORD_AVAILABLE","APP-DR0012 表中�?�?许无记录"},
			{"DR_PARAM_NOT_AVAILABLE","APP-DR0013 DR �?�数未设置"},
			{"ATLEAST_ONE_VALID","APP-DR0014 必须选择一个主�?的病人编�?"},
			{"INVALID_DATETIME","APP-DR0015 无效的日期时间格�?"},
			{"NON_DUPLICATES","APP-DR0016 已�?存在�?�?的病人ID"},
			{"PATIENT_POSSIBLE_DUPLICATES","APP-DR0017病人ID或能存在�?�?"},
			{"DUPLICATE_PATIENT_ENTRY","APP-DR0018 �?�?病人输入"},
			{"START_LATER_TIME","APP-DR0019 �?�动�?�日期时间必须大于当�?日期时间"},
			{"ONLY_ONE_PAIR","APP-DR0020 �?�能选择一个记录"},
			{"CHANGE_ID_SERIES_NOT_ALLOWED","APP-DR0021 �?�化编�?�一系列�?�?许候补系列"},
			{"SHD_NOT_BE_BLANK","APP-DR0022 病人编�?��?能空白"},
			{"ID_NO_NOT_BLANK","APP-DR0023 编�?��?能为空"},
			{"DUPLICATE_ID_NO","APP-DR0024 编�?�已存在"},
			{"RECORD_EXISTS","APP-DR0025 记录已存在"},
			{"SEARCH_MERGE_JOB_EXISTS","APP-DR0026 �?�索/�?�并工作目�?在工作队列中"},
			{"NO_USER_RIGHTS","APP-DR0027 用户无此功能�?��?"},
			{"REMARKS_CANNOT_BE_BLANK","APP-DR0028 备注�?能为空"},
			{"DR_USER_ID_NOT_BLANK","APP-DR0029 用户编�?�?能为空"},
			{"MINIMUM_TWO_PATIENTS","APP-DR0030 最少输入两个病人"},
			{"DECEASED_PATIENT","APP-DR0031 病人是死亡的"},
			{"DATE_TIME_NOT_BLANK","APP-DR0032 日期时间�?能为空"},
			{"NO_SEARCH_PROCESS","APP-DR0033 没有DR周期进程已�?�得进展"},
			{"NO_RECORDS_FOR_REVIEW","APP-DR0034 没有任何资料�?�供审查"},
			{"NAME_MANDATORY","APP-DR0035 至少一个强制�??称被选择为标准"},
			{"PATIENT_REGISTERED_FACILITY","APP-DR0036 病人没有登记当�?的设备"},
			{"SEARCH_ALL_FACILITY","APP-DR0037 查询工作奖在所有的设施中"},
			{"SEARCH_PROCESS_JOB","APP-DR0038 �?�索过程是作为一个�??交作业"},
			{"MERGE_PROCESS_JOB","APP-DR0039 �?�并过程是作为一个�??交作业"},
			{"UNMERGE_PROCESS_JOB","APP-DR0040 �?�消过程是作为一个�??交作业"},
			{"IDSERIES_PROCESS_JOB","APP-DR0041�?�化编�?�一系列进程 作为一个作业 �??交"},
			{"NO_USER_RIGHTS_ALL_FCY","APP-DR0042 用户无此功能�?��?"},
			{"ATLEAST_ONE_DUPLICATE","APP-DR0043 应选择一个�?�?的病人编�?�"},
			{"DR_PROCESS_CYCLE","APP-DR0044 DR周期进程已�?�得进展"},
			{"REMARKS_NOT_EXCEED_500_CH","APP-DR0045 备注�?能超过500 字符"},
			{"ID_MIN_LENGTH","APP-DR0046 Id �?�最�?长度应该为"},
			{"INVALID_PAT","APP-DR0047 无效的病人编�?�"},
			{"DELETE_RECORD","APP-DR0048 删除记录?"},
			{"CANT_BE_LT","APP-DR0049 $ �?能�?于 #"},
			{"NO_MERGED_PAT_REC","APP-DR0050 无�?�并病人记录存在"},
			{"PATIENT_CUR_OUTPATIENT","APP-DR0051当�?病人为门诊病人"},
			{"START_LATER_DATE_BLANK","APP-DR0052 �?��?�开始日期和时间�?能空白"},
			{"ABORT_PROCESS","APP-DR0053 中止进程 ?"},
			{"NEXT_EXE_DATE_GRT_CUR_DATE","APP-DR0054 下一步执行日期应大于当�?日期"},
			{"ATLEAST_ONE_CHECK_BEF_DEL","APP-DR0055 至少一个记录应选择删除"},
			{"ED_TIME_LESS_EQL_ST_TIME","APP-DR0056 结�?�时间�?能�?于或等于起始时间"},
			{"PAT_LENGTH","APP-DR0057 病人编�?�已�?�?为了"},
			{"CLOSE_PROCESS","APP-DR0058 关闭�?作?"},
			{"DR_INVALID_MERGE_TIME","APP-DR0059 无效的�?�并时间，�?能继续"},
			{"EXCLUDE_DUPLICATE_RECORD","APP-DR0060 排除�?�能是存在的�?�?"},
			{"PAT_SHD_BE_IDENTIFIED","APP-DR0061 患者应该首先确定"},
			{"ONLY_ONE_MAIN","APP-DR0062 �?�选择一个主病人编�?�"}


	};
}			
