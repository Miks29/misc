package ph.com.lserv.production.experiment.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ph.com.lserv.production.experiment.data.mapper.ExperimentMapper;
import ph.com.lserv.production.experiment.model.Experiment;

public class ExperimentDao implements IDAO<Experiment> {
	SqlSessionFactory sqlSessionFactory;
	ExperimentMapper mapper;
	List<Experiment> listExperiment;
	List<String> listString;
	Experiment experiment;
	String result;

	public ExperimentDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Experiment> getAllData() {
		SqlSession sqlsession = this.sqlSessionFactory.openSession();

		try {
			mapper = sqlsession.getMapper(ExperimentMapper.class);
			listExperiment = mapper.getAllData();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlsession != null) {
				sqlsession.close();
			}
		}

		return listExperiment;
	}

	@Override
	public int createData(Experiment experiment) {
		int returnValue = 0;

		SqlSession sqlsession = this.sqlSessionFactory.openSession();

		try {
			mapper = sqlsession.getMapper(ExperimentMapper.class);
			returnValue = mapper.createData(experiment);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlsession != null) {
				sqlsession.close();
			}
		}

		return returnValue;
	}

	@Override
	public int updateData(Experiment experiment) {
		int returnValue = 0;

		SqlSession sqlsession = this.sqlSessionFactory.openSession();

		try {
			mapper = sqlsession.getMapper(ExperimentMapper.class);
			returnValue = mapper.updateData(experiment);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlsession != null) {
				sqlsession.close();
			}
		}

		return returnValue;
	}

	@Override
	public int deleteData(Experiment experiment) {
		int returnValue = 0;

		SqlSession sqlsession = this.sqlSessionFactory.openSession();

		try {
			mapper = sqlsession.getMapper(ExperimentMapper.class);
			returnValue = mapper.deleteData(experiment);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlsession != null) {
				sqlsession.close();
			}
		}

		return returnValue;
	}

	@Override
	public Experiment getDataById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		try {
			this.mapper = sqlSession.getMapper(ExperimentMapper.class);
			experiment = this.mapper.getDataById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return experiment;
	}
	
	public Experiment getTimeDiffById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		try {
			this.mapper = sqlSession.getMapper(ExperimentMapper.class);
			experiment = this.mapper.getTimeDiffById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return experiment;
	}
	
	public List<String> getOvertimeTypeSorted() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		try {
			this.mapper = sqlSession.getMapper(ExperimentMapper.class);
			listString = this.mapper.getOvertimeTypeSorted();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return listString;
	}

}
