package my_practice.thread_practices.fileCopyPaste;

import java.io.*;

public class FileManipulator {


    public String readFile() throws IOException {
        File file = new File("resources" + File.separator + "lyrics.txt");
        FileReader reader = null;
        StringBuilder strBuild = new StringBuilder("");
        if(file.isFile()){
            try {
                reader = new FileReader(file);
                BufferedReader stream = new BufferedReader(reader);
                stream.lines().forEach(str -> strBuild.append(str + "\n"));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                assert reader != null;
                reader.close();
            }
        }
        return strBuild.toString();
    }

    public void writeToFile(String str , String fileName) throws IOException {
        File file = new File("resources" + File.separator + fileName);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);

            writer.write(str);
        }
        finally {
            assert writer != null;
            writer.close();
        }
    }





}
