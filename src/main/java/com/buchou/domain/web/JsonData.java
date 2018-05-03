package com.buchou.domain.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ajax 交互传递的JSON数据
 */
public class JsonData implements Serializable{

	private static final long serialVersionUID = -1L;

	private boolean success = false;

	private String code="";

	private String msg = "";

	private Object obj = null;

	private List<?>objectList=new ArrayList();



	public JsonData(){

	}



	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public List<?> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<?> objectList) {
		this.objectList = objectList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
