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
//	private File file;// 具体上传文件的引用，指向临时目录中的临时文件
//	private String fileFileName;// 上传文件的名字，FileName固定的写法
//	private String fileContentType;// 上传文件的类型，ContentType固定的写法
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
//	// 导入
//	public void uploadFile() throws Exception {
//		session.setAttribute("prog", "0");
//		session.setAttribute("result", "NOK");
//		session.setAttribute("error", "");
//		String error = "";
//		// 给上传的文件设一个最大值，这里是不得超过50MB
//		int maxSize = 50 * 1024 * 1024;
//		// 创建工厂对象和文件上传对象
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		ServletFileUpload upload = new ServletFileUpload(factory);
//		try {
//			// 解析上传请求
//			List items = upload.parseRequest(request);
//			Iterator itr = items.iterator();
//
//			while (itr.hasNext()) {
//				FileItem item = (FileItem) itr.next();
//				// 判断是否为文件域
//				if (!item.isFormField()) {
//					if (item.getName() != null && !item.getName().equals("")) {
//						// 获取上传文件大小和文件名称
//						long upFileSize = item.getSize();
//						String fileName = item.getName();
//						if (upFileSize > maxSize) {
//							error = "您上传的文件太大了，请选择不超过50MB的文件!";
//							break;
//						}
//						// 此时文件暂存在服务器的内存中，构造临时对象
//						File tempFile = new File(fileName);
//						// 指定文件上传服务器的目录及文件名称
//						String path = ServletActionContext.getServletContext()
//								.getRealPath("\\upload\\");
//						SimpleDateFormat spl = new SimpleDateFormat(
//								"yyyyMMddHHmmss");
//						String date = spl.format(new Date());
//						File file = new File(path, date + ""
//								+ tempFile.getName());
//						// 构造输入流读文件
//						InputStream is = item.getInputStream();
//						int length = 0;
//						byte[] by = new byte[1024];
//						double persent = 0;
//						FileOutputStream fos = new FileOutputStream(file);
//						PrintWriter out = response.getWriter();
//						while ((length = is.read(by)) != -1) {
//							// 计算文件进度
//							persent += length / (double) upFileSize * 100D;
//							fos.write(by, 0, length);
//							session.setAttribute("prog", Math.round(persent)
//									+ "");
//							Thread.sleep(10);
//						}
//						fos.close();
//						Thread.sleep(1000);
//					} else {
//						error = "没选择上传文件！";
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			error = "上传文件出现错误:" + e.getMessage();
//		}
//		if (!error.equals("")) {
//			session.setAttribute("error", error);
//		} else {
//			session.setAttribute("result", "OK");
//		}
//	}
//}
