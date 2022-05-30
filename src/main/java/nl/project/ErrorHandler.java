package nl.project;
import javafx.scene.control.Alert;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ErrorHandler
{
    private static final ArrayList<String> errorMessages = new ArrayList<>();
    private static int errorHandlerErrorCount;
    private static final Alert a = new Alert(Alert.AlertType.ERROR);

    public static void errorHandler(String error, String message){
        //creates new thread therefore the main thread can continue
        Thread thread = new Thread(() -> {
            errorMessages.add(String.format("%s\n%s", message, (error)));
            File file = new File("\\@History\\log.txt");
            if (!file.exists())
            {
                try
                {
                    File file1 = new File("\\@History\\");
                    if(!file1.mkdirs()) throw new Exception("Could not make path");
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            try
            {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);

                Writer output = new BufferedWriter(new FileWriter(file, true));
                output.append(String.format("%s -> %s -> %s\n", date, message, error));
                output.close();
            } catch (IOException ioException)
            {
                ioException.printStackTrace();
                Thread thread1 = new Thread(() ->
                {
                    if(!(errorHandlerErrorCount >= 1))
                    {
                        errorHandlerErrorCount++;

                        // set error popup error message
                        a.setContentText(String.format("Warning : errorHandler not working!!\n%s", ioException));
                        a.show();
                    }
                });
                thread1.setName("ErrorHandlerError");
                thread1.start();
            }
        });
        thread.start();
    }

    //shows all error messages if the error count is lower than 10
    //else shows message to check log file
    public static void errorMerger(){
        if(errorMessages.size() > 0)
            if(!(errorMessages.size() > 10))
            {
                a.setContentText(String.format("<-> " +  errorMessages.toString().replace(",","\n <-> "), "Collection of error's"));
                a.show();
                errorMessages.clear();
            } else {
                a.setContentText(String.format(errorMessages.size() + " error's have occurred\nCheck log for details.", "Collection of error's"));
                a.show();
            }
        errorHandlerErrorCount = 0;
    }
}
