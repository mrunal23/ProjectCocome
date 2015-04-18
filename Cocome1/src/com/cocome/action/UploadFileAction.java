package com.cocome.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;


public class UploadFileAction extends ActionSupport implements ServletRequestAware{
	private File toBeUploaded;
	private String toBeUploadedFileName;
	private String toBeUploadedContentType;
	 
	private HttpServletRequest servletRequest;
	public String execute()
	{
		String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
		File fileToCreate = new File(filePath, this.toBeUploadedFileName);

		try {
			FileUtils.copyFile(this.toBeUploaded, fileToCreate);
			
		} catch (IOException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
		}
		public File getToBeUploaded() {
			return toBeUploaded;
		}
		public void setToBeUploaded(File toBeUploaded) {
			this.toBeUploaded = toBeUploaded;
		}
		public String getToBeUploadedFileName() {
			return toBeUploadedFileName;
		}
		public void setToBeUploadedFileName(String toBeUploadedFileName) {
			this.toBeUploadedFileName = toBeUploadedFileName;
		}
		public String getToBeUploadedContentType() {
			return toBeUploadedContentType;
		}
		public void setToBeUploadedContentType(
				String toBeUploadedFileNameContentType) {
			this.toBeUploadedContentType = toBeUploadedFileNameContentType;
		}
		@Override
		public void setServletRequest(HttpServletRequest servletRequest) {
			this.servletRequest = servletRequest;
		}
}