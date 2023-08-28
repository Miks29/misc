package ph.com.lserv.production.experiment.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ph.com.lserv.production.experiment.ExperimentMain;
import ph.com.lserv.production.experiment.model.Experiment;

public class BrowseExperimentController {
	ExperimentMain mainApplication;
	Experiment experiment = new Experiment();
	
	public void setMainApplication(ExperimentMain mainApplication) {

		this.mainApplication = mainApplication;
		experiment.setPrimaryKey(1);
		
		experiment = this.mainApplication.getTimeDiffById(experiment.getPrimaryKey());
		String timeDiffResult = experiment.getTime_diff();
		this.textFieldTimeDiff.setText(timeDiffResult.toString());
		System.out.println(timeDiffResult);
		
		ObservableList<String> observableListExperimentOvertime = FXCollections.observableArrayList();
		observableListExperimentOvertime.addAll(this.mainApplication.getOvertimeTypeSorted());
		
		this.comboBoxOvertimeType.setItems(observableListExperimentOvertime);
		for (String experiment : observableListExperimentOvertime) {
			System.out.println(experiment);
		}
		
//		System.out.println(experiment.getPrimaryKey());
//		this.textFieldTimeDiff.setText(experiment.getResult() == null ? "null" : experiment.getResult());
//		System.out.println(experiment.getResult()== null ? "null" : experiment.getResult());
		
	}
	
	
	
	@FXML
	private TextField textFieldTimeDiff;
	@FXML
	private ComboBox<String> comboBoxOvertimeType;
	@FXML
	private Button buttonTest;

}
