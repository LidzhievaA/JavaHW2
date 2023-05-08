// Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
//     1 Расширение файла: txt
//     2 Расширение файла: pdf
//     3 Расширение файла: 
//     4 Расширение файла: jpg

import java.io.File;
import java.io.FileNotFoundException;


public class program2 {

    public static void main(String[] args) throws FileNotFoundException {
        ex5("C:\\Users\\User\\Desktop\\Гик брейнс\\JavaHW2\\Folders");
    }

    private static void ex5(String pathDir) throws FileNotFoundException {
        File file = new File(pathDir);
        StringBuilder sb = new StringBuilder();
        for (String fileName : file.list()) {
            sb.append(fileName).append(System.lineSeparator());
            if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
                System.out.println("Расширение файла: " + fileName.substring(fileName.lastIndexOf(".")+1));
            }
            else {
                System.out.println("Расширение файла: " + "");
            }
        }
        
        //System.out.println(sb);
    
        
    }
}


