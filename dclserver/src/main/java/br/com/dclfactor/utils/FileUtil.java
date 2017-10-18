/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.utils;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author test
 */
public class FileUtil implements Serializable {

    /**
     *
     * @return
     */
    public static PrintWriter getErroFile() {
        try {
            String data = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
                    .format(Calendar.getInstance().getTime());
            File erroFile = new File("C:\\arquivos\\Erro_Ocorrido_em_" + data
                    + ".txt");
            if (!erroFile.exists()) {
                erroFile.createNewFile();
            }
            JOptionPane.showMessageDialog(null, "Arquivo de erro gerado: "
                    + erroFile.getName());
            return new PrintWriter(erroFile);
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }

    }

    public static void openFile(String url) {
        openFile(new File(url));
    }

    public static void openFile(File file) {
        try {
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Arquivo n�o encontrar o arquivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public static void copy(File src, File dst) throws IOException {
        OutputStream out;
        try (InputStream in = new FileInputStream(src)) {
            out = new FileOutputStream(dst);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
        out.close();
    }

    public static File createFile(String fileName) {
        return createFile(new File(fileName));
    }

    public static File createFile(File file) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
        return file;
    }

    public static void createLog(String pathFile, String txt, Date date) {
        String fmtDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
        File file = new File(pathFile + " " + fmtDate);
        writeNewFile(file, txt);
    }

    public static void writeFile(String pathFile, String txt) {
        writeNewFile(new File(pathFile), txt);
    }

    public static void appendWriteFile(String pathFile, String txt) {
        appendWriteFile(new File(pathFile), txt);
    }

    public static void appendWriteFile(File file, String txt) {
        writeFile(file, txt, true);
    }

    public static void writeNewFile(File file, String txt) {
        writeFile(file, txt, false);
    }

    private static void writeFile(File file, String txt, boolean append) {
        List<String> list = new ArrayList<>();
        list.add(txt);
        writeFile(file, list, append);
    }

    public static void writeNewFile(String pathFile, List<String> lines) {
        writeNewFile(new File(pathFile), lines);
    }

    public static void writeNewFile(String pathFile, String... lines) {
        writeNewFile(new File(pathFile), lines);
    }

    public static void writeNewFile(File file, String... lines) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(lines));
        writeNewFile(file, list);
    }

    public static void appendWriteFile(String pathFile, List<String> lines) {
        appendWriteFile(new File(pathFile), lines);
    }

    public static void appendWriteFile(String pathFile, String... lines) {
        appendWriteFile(new File(pathFile), lines);
    }

    public static void appendWriteFile(File file, String... lines) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(lines));
        appendWriteFile(file, list);
    }

    public static void writeNewFile(File file, List<String> lines) {
        writeFile(file, lines, false);
    }

    public static void appendWriteFile(File file, List<String> lines) {
        writeFile(file, lines, true);
    }

    private static void writeFile(File file, List<String> lines, boolean append) {
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                    createFile(file), append))) {
                for (String string : lines) {
                    bw.write(string);
                    bw.newLine();
                }

                bw.flush();
                bw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public static File mkDir(String fileName) {
        return mkDir(new File(fileName));
    }

    public static File mkDir(File file) {
        if (!file.exists()) {
            file.mkdirs();
            return file;
        }
        return file;
    }

    public static List<String> readFile(String pathFile) {
        return readFile(new File(pathFile));
    }

    public static List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        if (file.exists() && file != null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    lines.add(reader.readLine());
                }
            } catch (FileNotFoundException ex) {
                lines.add("Arquivo n�o encontrado");
                Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (IOException ex) {
                lines.add("Erro na leitura do arquivo");
                Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE,
                        null, ex);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return lines;
    }

    public static File getSelectedFileFromGui(String extension) {
        String path = selectFilePath();
        File file = null;
        if (path != null) {
            file = new File(path + "." + extension);
            createFile(file);
        }
        return file;
    }

    private static String selectFilePath() {
        String path = null;
        JFileChooser chooser;
        chooser = new JFileChooser();
        int retorno = chooser.showSaveDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
        }
        return path;
    }

    public static void deleteFile(String fileName) {
        deleteFile(new File(fileName));
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

}
