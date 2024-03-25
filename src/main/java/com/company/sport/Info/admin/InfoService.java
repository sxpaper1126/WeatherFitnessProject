package com.company.sport.Info.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.sport.Info.InfoVo;
import com.company.sport.Info.admin.InfoDao;

@Service
public class InfoService {
	final static public int SPORT_ALREADY_EXIST = 0;
	final static public int SPORT_REGISTER_SUCCESS = 1;
	final static public int SPORT_REGISTER_FAIL = -1;

	@Autowired
	InfoDao infoDao;

	public int registerSportConfirm(InfoVo infoVo) {

		boolean isSport = infoDao.isSport(infoVo.getSport_name());

		if (!isSport) {
			int result = infoDao.insertSport(infoVo);

			if (result > 0)
				return SPORT_REGISTER_SUCCESS;

			else
				return SPORT_REGISTER_FAIL;

		} else {
			return SPORT_ALREADY_EXIST;

		}
	}

	public List<InfoVo> searchSportsConfirm(InfoVo infoVo) {
		return infoDao.selectSportsBySearch(infoVo);

	}

	public InfoVo sportDetail(String sport_name) {
		return infoDao.selectSport(sport_name);

	}

	public InfoVo modifySportForm(String sport_name) {
		return infoDao.selectSport(sport_name);
	}

	public int modifySportConfirm(InfoVo infoVo) {
		return infoDao.updateSport(infoVo);
	}

	public int deleteSportConfirm(String sport_name) {

		return infoDao.deleteSport(sport_name);

	}
	public List<InfoVo> showSport(InfoVo infoVo) {
		return infoDao.showSport(infoVo);

	}
}
