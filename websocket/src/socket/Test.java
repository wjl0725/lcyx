package socket;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Test {
	public static void main(String[] args) {
		boolean w = false;
		String path = "E:/";
		try {
			if (!"".equals(path)) {
				// 检查目录是否存在
				File fileDir = new File(path);
				if (fileDir.exists()) {
					// 生成临时文件名称
					String fileName = "a.doc";
					String content = "<span> </span><p align='center' style='text-align:center;'> <span><b><span style='font-size:16px;'>个人工作周报</span></b><span> </span></span></p><span> </span><p align='left' style='text-align:left;'> <span style='font-size:14pt;'>部门：行政办公室</span></p><span>";
					byte b[] = content.getBytes();
					ByteArrayInputStream bais = new ByteArrayInputStream(b);
					POIFSFileSystem poifs = new POIFSFileSystem();
					DirectoryEntry directory = poifs.getRoot();
					DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
					FileOutputStream ostream = new FileOutputStream(path + fileName);
					poifs.writeFilesystem(ostream);
					bais.close();
					ostream.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
