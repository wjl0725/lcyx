//package com.baikang.action;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import net.sf.json.JSONObject;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.struts2.ServletActionContext;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//@Controller
//@Scope("prototype")
//public class UploadAction extends ActionSupport {
//
//	private File file;// �����ϴ��ļ������ã�ָ����ʱĿ¼�е���ʱ�ļ�
//	private String fileFileName;// �ϴ��ļ������֣�FileName�̶���д��
//	private String fileContentType;// �ϴ��ļ������ͣ�ContentType�̶���д��
//
//	public File getFile() {
//		return file;
//	}
//
//	public void setFile(File file) {
//		this.file = file;
//	}
//
//	public String getFileFileName() {
//		return fileFileName;
//	}
//
//	public void setFileFileName(String fileFileName) {
//		this.fileFileName = fileFileName;
//	}
//
//	public String getFileContentType() {
//		return fileContentType;
//	}
//
//	public void setFileContentType(String fileContentType) {
//		this.fileContentType = fileContentType;
//	}
//
//	public static int bufferSize = 1024 * 8;
//	private JSONObject result;
//
//	public JSONObject getResult() {
//		return result;
//	}
//
//	public void setResult(JSONObject result) {
//		this.result = result;
//	}
//
//	HttpSession session = ServletActionContext.getRequest().getSession();
//	HttpServletRequest request = ServletActionContext.getRequest();
//	HttpServletResponse response = ServletActionContext.getResponse();
//
//	// ����
//	public void uploadFile() throws Exception {
//		session.setAttribute("prog", "0");
//		session.setAttribute("result", "NOK");
//		session.setAttribute("error", "");
//		String error = "";
//		// ���ϴ����ļ���һ�����ֵ�������ǲ��ó���50MB
//		int maxSize = 50 * 1024 * 1024;
//		// ��������������ļ��ϴ�����
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		ServletFileUpload upload = new ServletFileUpload(factory);
//		try {
//			// �����ϴ�����
//			List items = upload.parseRequest(request);
//			Iterator itr = items.iterator();
//
//			while (itr.hasNext()) {
//				FileItem item = (FileItem) itr.next();
//				// �ж��Ƿ�Ϊ�ļ���
//				if (!item.isFormField()) {
//					if (item.getName() != null && !item.getName().equals("")) {
//						// ��ȡ�ϴ��ļ���С���ļ�����
//						long upFileSize = item.getSize();
//						String fileName = item.getName();
//						if (upFileSize > maxSize) {
//							error = "���ϴ����ļ�̫���ˣ���ѡ�񲻳���50MB���ļ�!";
//							break;
//						}
//						// ��ʱ�ļ��ݴ��ڷ��������ڴ��У�������ʱ����
//						File tempFile = new File(fileName);
//						// ָ���ļ��ϴ���������Ŀ¼���ļ�����
//						String path = ServletActionContext.getServletContext()
//								.getRealPath("\\upload\\");
//						SimpleDateFormat spl = new SimpleDateFormat(
//								"yyyyMMddHHmmss");
//						String date = spl.format(new Date());
//						File file = new File(path, date + ""
//								+ tempFile.getName());
//						// �������������ļ�
//						InputStream is = item.getInputStream();
//						int length = 0;
//						byte[] by = new byte[1024];
//						double persent = 0;
//						FileOutputStream fos = new FileOutputStream(file);
//						PrintWriter out = response.getWriter();
//						while ((length = is.read(by)) != -1) {
//							// �����ļ�����
//							persent += length / (double) upFileSize * 100D;
//							fos.write(by, 0, length);
//							session.setAttribute("prog", Math.round(persent)
//									+ "");
//							Thread.sleep(10);
//						}
//						fos.close();
//						Thread.sleep(1000);
//					} else {
//						error = "ûѡ���ϴ��ļ���";
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			error = "�ϴ��ļ����ִ���:" + e.getMessage();
//		}
//		if (!error.equals("")) {
//			session.setAttribute("error", error);
//		} else {
//			session.setAttribute("result", "OK");
//		}
//	}
//}
