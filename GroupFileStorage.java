package sample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class GroupFileStorage {
	public static void saveGroupToCSV(Group gr, String folderDst) throws IOException {
		File fd = new File(folderDst);
		if (!fd.exists()) {fd.mkdir();}
		File fileDst = new File (folderDst, gr.getGroupName()+ ".csv");
		if (fileDst.exists()) {fileDst.delete();}
		try  (OutputStream bs = new BufferedOutputStream(new FileOutputStream(fileDst), 10000);)
		{
			bs.write(gr.getGroupName().getBytes("UTF-8"));
			for (int i = 0; i < gr.getStudens().length; i++) {
				if (gr.getStudens()[i] != null) {
					bs.write(",".getBytes("UTF-8"));
					bs.write(gr.getStudens()[i].getName().getBytes("UTF-8"));
					bs.write(",".getBytes("UTF-8"));
					bs.write(gr.getStudens()[i].getLastName().getBytes("UTF-8"));
					bs.write(",".getBytes("UTF-8"));
					bs.write(gr.getStudens()[i].getGender().toString().getBytes("UTF-8"));
					bs.write(",".getBytes("UTF-8"));
					bs.write(Integer.toString(gr.getStudens()[i].getId()).getBytes("UTF-8"));
				}
			}
		}
	}
	
	public static Group loadGroupFromCSV(File file) throws  IOException, GroupOverflowException {
		Group group = new Group();
		byte[] data = new byte[1];
		if (file.exists()) {
			try (Reader fr = new FileReader(file);){
				char[] chr = new char[50];
				int counter = 0;
				String groupString = "";
				for (;;) {
					counter = fr.read(chr);
					if (counter <=0) {
						break;
					}
					groupString += new String(chr,0, counter);
				}
				String [] words = groupString.split(",");
				group.setGroupName(words[0]);
				for (int i = 1; i < words.length;i +=4) {
					Student st = new Student();
					st.setName(words[i]);
					st.setLastName(words[i+1]);
					st.setGender(Gender.valueOf(words[i+2]));
					st.setId(Integer.parseInt((words[i+3])));
					st.setGroupName(words[0]);
					group.addStudent(st);
				}
			}
		}
		return group;
	}
	public static File findFileByGroupName(String groupName, File workFolder) throws FileNotFound {
		File f = new File(workFolder, groupName + ".csv");
		if (f.exists()) {
			return(f);
		} throw new FileNotFound("File " + f.getAbsolutePath() + " Not foud");
	}
}

