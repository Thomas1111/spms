package jxau.spms.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.struts2.ServletActionContext;


/**
 * @author Lai Huiqiang 
 * 2014-8-28 
 * TODO 上传文件工具类
 */

public class FileUpload {
	
	private static final int BUFFER_SIZE = 2048;		//指定缓存区的大小
	
	/**
	 * TODO 上传文件至服务器内
	 * 下午3:58:20
	 * @param account 用户账号
	 * @param upload  上传文件
	 * @param fileName	文件名称
	 * @param module 所属模块
	 * @throws IOException	读写上传文件异常
	 */
	public static void upload(String account,File upload,String fileName,String module) 
			throws IOException{
		String storageFileName; 		//存储文件的名字
		storageFileName = fileName;
    	//存储文件目标路径
    	String tarPath = ServletActionContext.getServletContext()  
                .getRealPath(File.separator+module) + File.separator 
                + account + File.separator + storageFileName;
    	
    	File storageFile = new File(tarPath); 	//实例化目标文件
        createAdminDir(tarPath);		//创建notice下目录(adminNo)
        //调用工具类copy实现存储文件
        FileUpload.copy(upload, storageFile); 
	}
	/**
	 * TODO 存储上传文件至指定目录下
	 * @param src	源文件
	 * @param dst	目标文件
	 */
	public static void copy(File src, File dst) throws IOException{
		
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
	}

	/**
	 * Lai Huiqaing
	 * TODO 获取文件后缀
	 * 上午11:47:15
	 * @param fileName 源文件名字
	 * @return 文件后缀
	 */
	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	
	/**
	 * TODO 创建管理员目录
	 * 上午11:38:41
	 * @param tarPath 目标路径
	 * @return 
	 */
	public static void createAdminDir(String tarPath){
		int pos = tarPath.lastIndexOf(File.separator);
		File tarFile = new File(tarPath.substring(0,pos+1));
		if (!tarFile.exists()) {
			tarFile.mkdir();
		}
	}
}
