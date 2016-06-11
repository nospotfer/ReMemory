/*****************************************************************/
/* Copyright 2013 Code Strategies                                */
/* This code may be freely used and distributed in any project.  */
/* However, please do not remove this credit if you publish this */
/* code in paper or electronic form, such as on a web site.      */
/*****************************************************************/

package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipDirectory {

//	public static void main(String[] args) throws IOException {
//		File directoryToZip = new File("C:\\projects\\workspace\\testing\\stuff");
//
//		List<File> fileList = new ArrayList<File>();
//		System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
//		//getAllFiles(directoryToZip, fileList);
//		System.out.println("---Creating zip file");
//		//writeZipFile(directoryToZip, fileList);
//		System.out.println("---Done");
//	}

	public static void zipDirectory(File dir, String saveDir) {
		List<File> fileList = new ArrayList<File>();
		File[] files = dir.listFiles();
		for (File file : files) {
            fileList.add(file);
        }
		writeZipFile(dir,fileList, saveDir);
	}

	public static void writeZipFile(File directoryToZip, List<File> fileList, String directoryToSave) {

		try {
			FileOutputStream fos = new FileOutputStream(directoryToSave+ ".ReMemoryPacient");
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
			IOException {

		FileInputStream fis = new FileInputStream(file);

		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		//System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

	public static String unZipIt(String zipFile){

		byte[] buffer = new byte[1024];

		try{


			String idPacient = new File(zipFile).getName();
			int dot = idPacient.lastIndexOf(".");
			idPacient = idPacient.substring(0, dot);

			String saveDir = Utils.PACIENT_DATA_PATH+File.separator+idPacient;

			//create output directory is not exists
			File folder = new File(saveDir);
			if(!folder.exists()){
				folder.mkdir();
			}

			//get the zip file content
			ZipInputStream zis =
					new ZipInputStream(new FileInputStream(zipFile));
			//get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();


			while(ze!=null){

				String fileName = ze.getName();
				File newFile = new File(saveDir+File.separator+fileName);

				System.out.println("file unzip : "+ newFile.getAbsoluteFile());

				//create all non exists folders
				//else you will hit FileNotFoundException for compressed folder
				//new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

			System.out.println("Done");

			return idPacient;

		}catch(IOException ex){
			ex.printStackTrace();
		}
		return null;
	}

}
