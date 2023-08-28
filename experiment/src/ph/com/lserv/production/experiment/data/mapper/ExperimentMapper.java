package ph.com.lserv.production.experiment.data.mapper;

import java.util.List;

import ph.com.lserv.production.experiment.data.IDAO;
import ph.com.lserv.production.experiment.model.Experiment;

public interface ExperimentMapper extends IDAO<Experiment> {
	
	public Experiment getTimeDiffById(int id);
	
	public List<String> getOvertimeTypeSorted();
}
