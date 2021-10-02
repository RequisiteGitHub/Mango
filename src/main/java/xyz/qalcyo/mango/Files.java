package xyz.qalcyo.mango;

import xyz.qalcyo.mango.error_handling.Option;
import xyz.qalcyo.mango.error_handling.Result;

import java.io.*;

public class Files {

    /**
     * Writes the content provided to a file.
     *
     * @param file The file to write to. (created if it doesn't exist.)
     * @param content The content to write to the file.
     */
    public static void write(File file, String content) {
        BufferedWriter writer = null;
        try {
            if (!file.exists() || !file.isFile())
                file.createNewFile();
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Reads the contents of a file and returns them.
     *
     * @param file The file to read from.
     * @return The contents of the provided file.
     */
    public static String read(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            reader.lines().forEach(builder::append);
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Result<String> getFileExtension(String filename) {
        int i = filename.lastIndexOf('.');

        Result r = new Result();

        if (i == -1) {
            r.success(false);
            r.errorMessage("Failed to get extension of file.");
            return r;
        }

        r.success(true);
        r.value(filename.substring(i));

        return r;
    }

}