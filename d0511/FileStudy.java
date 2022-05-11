package kr.hs.dgsw.java.dept1.d0511;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class FileStudy {

	public void studyFileData() throws Exception {
		
		File file = new File("D:\\2103박소영\\JAVA수업(산악)\\javaStudy\\sample.txt");
		File file2 = new File("D:\\2103박소영\\JAVA수업(산악)\\javaStudy\\void.txt");
		File file3 = new File("D:\\2103박소영\\JAVA수업(산악)\\javaStudy");
		
		//파일 존재의 여부
		boolean exist = false;
		exist = file.exists();
		System.out.println("파일의 존재 여부 확인");
		System.out.println(file.getName()+" "+exist);
		System.out.println(file2.getName()+" "+file2.exists());
		System.out.println(file3.getName()+" "+file3.exists());
		System.out.println();
		
		//파일 경로
		String path = file.getPath();
		String absolutePath = file.getAbsolutePath();
		String canoniclPath = file.getCanonicalPath();
		
		System.out.println("파일의 경로");
		System.out.println(file.getName());
		System.out.println(" path : "+path);
		System.out.println(" absolutePath : "+absolutePath);
		System.out.println(" canoniclPath : "+canoniclPath);
		
		//파일의 크기
		long size = file.length();
		System.out.println("파일의 크기");
		System.out.println(file.getName()+" "+size);
		System.out.println(file2.getName()+" "+file2.length());
		System.out.println(file3.getName()+" "+file3.length());
		System.out.println();
		
		//수정된 시각
		long modifiedTime = file.lastModified();
		System.out.println("파일의 수정 시각");
		
		Date date = makeDate(modifiedTime);
		String time = formatDate(date);
		
		System.out.println(file.getName()+" "+modifiedTime+" "+date);
		System.out.println(file2.getName()+" "+file2.lastModified());
		System.out.println(file3.getName()+" "+file3.lastModified());
		System.out.println();
		
		//파일과 디렉토리 구분
		boolean bFile = file.isFile();
		boolean bDir = file.isDirectory();
		System.out.println("파일과 디렉토리 구분");
		System.out.println(file.getName()+" "+bFile+" "+bDir);
		System.out.println(file2.getName()+" "+file2.isFile()+" "+file2.isDirectory());
		System.out.println(file3.getName()+" "+file3.isFile()+" "+file3.isDirectory());
		System.out.println();

		
		
	}
	
	public void studyManage() throws Exception {
		
		File file = new File("D:\\2103박소영\\JAVA수업(산악)\\javaStudy\\hello.txt");
		
		//파일 만들기
		boolean created = file.createNewFile();
		System.out.println("파일 만들기");
		System.out.println(file.getName()+" "+created);
		System.out.println();
		
		//파일 삭제하기
		boolean deleted = file.delete();
		System.out.println("파일 삭제하기");
		System.out.println(file.getName()+" "+deleted);
		System.out.println();

		//파일 이름 바꾸기
		File file1 = new File("D:\\2103박소영\\JAVA수업(산악)\\javaStudy\\first.txt");
		File newFile = new File("D:\\2103박소영\\JAVA수업(산악)\\javaStudy\\second.txt");
		boolean renamed = file1.renameTo(newFile);
		System.out.println("파일 이름 바꾸기");
		System.out.println(file.getName()+" "+renamed);
		System.out.println();
	}
	
	public void studyDirectory() {
		File dir = new File("D:\\2103박소영\\JAVA수업(산악)\\javaStudy\\child");
		
		//디렉토리 만들기
		boolean created = dir.mkdir();
		System.out.println("디렉토리 만들기");
		System.out.println(dir.getName()+" "+created);
		System.out.println();
		
		//디렉토리 삭제하기
		boolean deleted = dir.delete();
		System.out.println("디렉토리 삭제하기");
		System.out.println(dir.getName()+" "+deleted);
		System.out.println();
		
		//디렉토리 만들기 2
		File dir2 = new File("D:\\2103박소영\\JAVA수업(산악)\\javaStudy\\sub\\images");
		dir2.mkdir();
		System.out.println("디렉토리 만들기");
		System.out.println(dir.getName()+" "+created);
		System.out.println();
		

	}
	
	public Date makeDate(long unixTime) {
		return new Date(unixTime);
	}
	
	public String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
	public static void main(String[] args) throws Exception {
		FileStudy fileStudy = new FileStudy();
		//fileStudy.studyFileData();
		//fileStudy.studyManage(); 
		fileStudy.studyDirectory();
	}
	
}
