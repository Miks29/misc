package ph.com.lserv.production.experiment;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ph.com.lserv.production.experiment.data.ExperimentDao;
import ph.com.lserv.production.experiment.model.Experiment;
import ph.com.lserv.production.experiment.view.BrowseExperimentController;

public class ExperimentMain extends Application {
	Stage primaryStage;
	SqlSessionFactory sqlSessionFactory;
	SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public List<Experiment> getAllData() {
		return new ExperimentDao(this.sqlSessionFactory).getAllData();
	}
	
	public List<String> getOvertimeTypeSorted() {
		return new ExperimentDao(this.sqlSessionFactory).getOvertimeTypeSorted();
	}
	
	public Experiment getDataById(int id) {
		return new ExperimentDao(sqlSessionFactory).getDataById(id);
	}
	
	public Experiment getTimeDiffById(int id) {
		return new ExperimentDao(sqlSessionFactory).getTimeDiffById(id);
	}

	public boolean createData(Experiment experiment) {
		return new ExperimentDao(this.sqlSessionFactory).createData(experiment) > 0;
	}
	
	public boolean updateData(Experiment experiment) {
		return new ExperimentDao(this.sqlSessionFactory).updateData(experiment) > 0;
	}
	
	public boolean deleteData(Experiment experiment) {
		return new ExperimentDao(this.sqlSessionFactory).deleteData(experiment) > 0;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.initializeObject();
		primaryStage.setTitle("Experiment");
		this.primaryStage = primaryStage;
		this.showBrowse(primaryStage);
	}

	private void showBrowse(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			AnchorPane anchorPane;	
			fxmlLoader.setLocation(getClass().getResource("view/BrowseExperiment.fxml"));
			anchorPane = fxmlLoader.load();
			primaryStage.setScene(new Scene(anchorPane));
			BrowseExperimentController controller = fxmlLoader.getController();
			controller.setMainApplication(this);
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initializeObject() {
		// TODO Auto-generated method stub
		try {
			this.sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			Properties properties = new Properties();

			properties.load(this.getClass().getResourceAsStream("resources/jdbc.properties"));

			this.sqlSessionFactory = sqlSessionFactoryBuilder
					.build(this.getClass().getResourceAsStream("resources/mybatis-config.xml"), properties);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public SqlSessionFactoryBuilder getSqlSessionFactoryBuilder() {
		return sqlSessionFactoryBuilder;
	}

	public void setSqlSessionFactoryBuilder(SqlSessionFactoryBuilder sqlSessionFactoryBuilder) {
		this.sqlSessionFactoryBuilder = sqlSessionFactoryBuilder;
	}
	
	

}
