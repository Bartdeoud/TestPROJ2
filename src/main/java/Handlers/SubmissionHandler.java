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
    static String totalBenzineAutoKM = getData("BenzineAutoKM", getLoggedInUser());
    static String totalDieselAutoKM = getData("DieselAutoKM", getLoggedInUser());
    static String totalElecAutoKM = getData("ElecAutoKM", getLoggedInUser());
    static String totalOVKM = getData("OVKM", getLoggedInUser());
    static String totalVliegtuigKM = getData("VliegtuigKM", getLoggedInUser());
    static String totalHybridAutoKM = getData("HybridAutoKM", getLoggedInUser());

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
    public static Integer[] ptHandler(){
        totalBenzineCarPT = Double.parseDouble(totalBenzineAutoKM) * 0.25;
        totalDieselAutoPT = Double.parseDouble(totalDieselAutoKM) *0.30;
        totalElecAutoPT = Double.parseDouble(totalElecAutoKM) * 0.80;
        totalOVPT = Double.parseDouble(totalOVKM) * 0.50;
        totalVliegtuigPT = Double.parseDouble(totalVliegtuigKM)* 0.10;
        totalHybridAutoPT = Double.parseDouble(totalHybridAutoKM) * 0.45;

        int intTotalBenzineCarPT = (int) Math.round(totalBenzineCarPT);
        int intTotalDieselAutoPT = (int) Math.round(totalDieselAutoPT);
        int intTotalElecAutoPT = (int) Math.round(totalElecAutoPT);
        int intTotalOVPT = (int) Math.round(totalOVPT);
        int intTotalVliegtuigPT = (int) Math.round(totalVliegtuigPT);
        int intTotalHybridAutoPT = (int) Math.round(totalHybridAutoPT);

        int totalPT = intTotalBenzineCarPT + intTotalDieselAutoPT + intTotalElecAutoPT + intTotalOVPT + intTotalVliegtuigPT + intTotalHybridAutoPT;
        setData("TotalPT", String.valueOf(totalPT), getLoggedInUser());

        return new Integer[] {intTotalBenzineCarPT,intTotalDieselAutoPT, intTotalElecAutoPT, intTotalOVPT, intTotalVliegtuigPT, intTotalHybridAutoPT};
    }
    public static void formList(ListView<String> nameListView, ListView<String> KMListView, ListView<Integer> pointsListView) {
        nameListView.getItems().clear();
        KMListView.getItems().clear();
        pointsListView.getItems().clear();

        String[] names = {"Benzine Auto","Diesel Auto", "Elektrische Auto", "Openbaar Vervoer", "Vliegtuig", "Hybride Auto"};
        String[] km = {totalBenzineAutoKM + " km", totalDieselAutoKM + " km",totalElecAutoKM + " km",totalOVKM + " km",totalVliegtuigKM + " km",totalHybridAutoKM + " km"};
        Integer[] punten = ptHandler();

        nameListView.getItems().addAll(names);
        KMListView.getItems().addAll(km);
        pointsListView.getItems().addAll(punten);
    }
}
