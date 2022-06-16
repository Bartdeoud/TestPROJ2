package Handlers;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import static Handlers.DatabaseHandler.getData;
import static Handlers.DatabaseHandler.setData;
import static Handlers.Login.getLoggedInUser;

public class SubmissionHandler {

    static double totalBenzineCarPT;
    static double totalDieselAutoPT;
    static double totalElecAutoPT;
    static double totalOVPT;
    static double totalVliegtuigPT;
    static double totalHybridAutoPT;
    static double totalWalkingAndCyclingPT;
    static String totalBenzineAutoKM = getData("BenzineAutoKM", getLoggedInUser());
    static String totalDieselAutoKM = getData("DieselAutoKM", getLoggedInUser());
    static String totalElecAutoKM = getData("ElecAutoKM", getLoggedInUser());
    static String totalOVKM = getData("OVKM", getLoggedInUser());
    static String totalVliegtuigKM = getData("VliegtuigKM", getLoggedInUser());
    static String totalHybridAutoKM = getData("HybridAutoKM", getLoggedInUser());
    static String totalWalkingAndCyclingKM = getData("WalkingAndCyclingKM",getLoggedInUser());

    public static void submissionHandler(TextField benzineAuto, TextField dieselAuto, TextField elecAuto, TextField OV, TextField vliegtuig, TextField hybridAuto,ListView<String> nameListView, ListView<String> KMListView, ListView<Integer> pointsListView){

        if ((!(benzineAuto.getText() == null)) && (!benzineAuto.getText().equals(""))){
            totalBenzineAutoKM = String.valueOf(Integer.parseInt(benzineAuto.getText()) + Integer.parseInt(getData("BenzineAutoKM", getLoggedInUser())));
        }
        if (!(dieselAuto.getText() == null) && !dieselAuto.getText().equals("")){
            totalDieselAutoKM = String.valueOf(Integer.parseInt(dieselAuto.getText()) + Integer.parseInt(getData("DieselAutoKM", getLoggedInUser())));
        }
        if (!(elecAuto.getText() == null) && !(elecAuto.getText().equals(""))){
            totalElecAutoKM = String.valueOf(Integer.parseInt(elecAuto.getText()) + Integer.parseInt(getData("ElecAutoKM", getLoggedInUser())));
        }
        if (!(OV.getText() == null) && !OV.getText().equals("")){
            totalOVKM = String.valueOf(Integer.parseInt(OV.getText()) + Integer.parseInt(getData("OVKM", getLoggedInUser())));
        }
        if (!(vliegtuig.getText() == null) && !vliegtuig.getText().equals("")){
            totalVliegtuigKM = String.valueOf(Integer.parseInt(vliegtuig.getText()) + Integer.parseInt(getData("VliegtuigKM", getLoggedInUser())));
        }
        if (!(hybridAuto.getText() == null) && !hybridAuto.getText().equals("")){
            totalHybridAutoKM = String.valueOf(Integer.parseInt(hybridAuto.getText()) + Integer.parseInt(getData("HybridAutoKM", getLoggedInUser())));
        }

        setData("BenzineAutoKM", totalBenzineAutoKM, getLoggedInUser());
        setData("DieselAutoKM", totalDieselAutoKM, getLoggedInUser());
        setData("ElecAutoKM", totalElecAutoKM, getLoggedInUser());
        setData("OVKM", totalOVKM, getLoggedInUser());
        setData("VliegtuigKM", totalVliegtuigKM, getLoggedInUser());
        setData("HybridAutoKM", totalHybridAutoKM, getLoggedInUser());

        formList(nameListView, KMListView, pointsListView);

    }

    public static void formList(ListView<String> nameListView, ListView<String> KMListView, ListView<Integer> pointsListView) {
        destructList(nameListView,  KMListView, pointsListView);

        String[] names = {"Benzine Auto","Diesel Auto", "Elektrische Auto", "Openbaar Vervoer", "Vliegtuig", "Hybride Auto", "Lopen en Fietsen"};
        String[] km = {totalBenzineAutoKM + " km", totalDieselAutoKM + " km",totalElecAutoKM + " km",totalOVKM + " km",totalVliegtuigKM + " km",totalHybridAutoKM + " km", totalWalkingAndCyclingKM + " km"};
        Integer[] punten = ptHandler();

        constructList(nameListView,  KMListView, pointsListView,names,km,punten);
    }
    //Calculates points and puts into Integer
    public static Integer[] ptHandler(){
        totalBenzineCarPT = Double.parseDouble(totalBenzineAutoKM) * -0.30;
        totalDieselAutoPT = Double.parseDouble(totalDieselAutoKM) * -0.20;
        totalElecAutoPT = Double.parseDouble(totalElecAutoKM) * 1;
        totalOVPT = Double.parseDouble(totalOVKM) * 1.20;
        totalVliegtuigPT = Double.parseDouble(totalVliegtuigKM)* -0.05;
        totalHybridAutoPT = Double.parseDouble(totalHybridAutoKM) * -0.10;
        totalWalkingAndCyclingPT = Double.parseDouble(totalHybridAutoKM) * 2.0;

        int intTotalBenzineCarPT = (int) Math.round(totalBenzineCarPT);
        int intTotalDieselAutoPT = (int) Math.round(totalDieselAutoPT);
        int intTotalElecAutoPT = (int) Math.round(totalElecAutoPT);
        int intTotalOVPT = (int) Math.round(totalOVPT);
        int intTotalVliegtuigPT = (int) Math.round(totalVliegtuigPT);
        int intTotalHybridAutoPT = (int) Math.round(totalHybridAutoPT);
        int intTotalWalkingAndCyclingPT = (int) Math.round(totalWalkingAndCyclingPT);

        int totalPT = intTotalBenzineCarPT + intTotalDieselAutoPT + intTotalElecAutoPT + intTotalOVPT + intTotalVliegtuigPT + intTotalHybridAutoPT + intTotalWalkingAndCyclingPT;
        setData("TotalPT", String.valueOf(totalPT), getLoggedInUser());

        return new Integer[] {intTotalBenzineCarPT,intTotalDieselAutoPT, intTotalElecAutoPT, intTotalOVPT, intTotalVliegtuigPT, intTotalHybridAutoPT,intTotalWalkingAndCyclingPT};
    }
    //Clears Listviews everytime submission button is clicked
    public static void destructList(ListView<String> nameListView, ListView<String> KMListView, ListView<Integer> pointsListView){
        nameListView.getItems().clear();
        KMListView.getItems().clear();
        pointsListView.getItems().clear();
    }

    //Builds Listviews everytime submission button is clicked
    public static void constructList(ListView<String> nameListView, ListView<String> KMListView, ListView<Integer> pointsListView, String[] names, String[] km, Integer[] punten){
        nameListView.getItems().addAll(names);
        KMListView.getItems().addAll(km);
        pointsListView.getItems().addAll(punten);
    }
}
