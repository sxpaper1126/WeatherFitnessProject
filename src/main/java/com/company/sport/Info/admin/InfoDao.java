package com.company.sport.Info.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.company.sport.Info.InfoVo;

@Component
public class InfoDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean isSport(String sport_name) {

		String sql = "SELECT COUNT(*) FROM info_sport " + "WHERE sport_name = ?";

		int result = jdbcTemplate.queryForObject(sql, Integer.class, sport_name);

		return result > 0 ? true : false;

	}

	public int insertSport(InfoVo infoVo) {

		String sql = "INSERT INTO info_sport(thumbnail, " + "sport_name, " + "temperature, " + "rainfall, "
				+ "sport_info, " + "reg_date, " + "mod_date) " + "VALUES(?, ?, ?, ?, ?, NOW(), NOW())";

		int result = -1;

		try {

			result = jdbcTemplate.update(sql, infoVo.getThumbnail(), infoVo.getSport_name(), infoVo.getTemperature(),
					infoVo.getRainfall(), infoVo.getSport_info());

		} catch (Exception e) {
			e.printStackTrace();

		}

		return result;

	}

	public List<InfoVo> selectSportsBySearch(InfoVo infoVo) {

		String sql = "SELECT * FROM info_sport " + "WHERE sport_name LIKE ? ";

		List<InfoVo> infoVos = new ArrayList<>();

		try {

			infoVos = jdbcTemplate.query(sql, new RowMapper<InfoVo>() {

				@Override
				public InfoVo mapRow(ResultSet rs, int rowNum) throws SQLException {

					InfoVo infoVo = new InfoVo();

					infoVo.setThumbnail(rs.getString("thumbnail"));
					infoVo.setSport_name(rs.getString("sport_name"));
					infoVo.setTemperature(rs.getString("temperature"));
					infoVo.setRainfall(rs.getString("rainfall"));
					infoVo.setSport_info(rs.getString("sport_info"));
					infoVo.setReg_date(rs.getString("reg_date"));
					infoVo.setMod_date(rs.getString("mod_date"));

					return infoVo;

				}

			}, "%" + infoVo.getSport_name() + "%");

		} catch (Exception e) {
			e.printStackTrace();

		}

		return infoVos;

	}

	public InfoVo selectSport(String sport_name) {

		String sql = "SELECT * FROM info_sport WHERE sport_name = ?";

		List<InfoVo> infoVos = null;

		try {

			infoVos = jdbcTemplate.query(sql, new RowMapper<InfoVo>() {

				@Override
				public InfoVo mapRow(ResultSet rs, int rowNum) throws SQLException {

					InfoVo infoVo = new InfoVo();

					infoVo.setThumbnail(rs.getString("thumbnail"));
					infoVo.setSport_name(rs.getString("sport_name"));
					infoVo.setTemperature(rs.getString("temperature"));
					infoVo.setRainfall(rs.getString("rainfall"));
					infoVo.setSport_info(rs.getString("sport_info"));
					infoVo.setReg_date(rs.getString("reg_date"));
					infoVo.setMod_date(rs.getString("mod_date"));

					return infoVo;

				}

			}, sport_name);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return infoVos.size() > 0 ? infoVos.get(0) : null;

	}

	public int updateSport(InfoVo infoVo) {

		List<String> args = new ArrayList<String>();

		String sql = "UPDATE info_sport SET ";
		if (infoVo.getThumbnail() != null) {
			sql += "thumbnail = ?, ";
			args.add(infoVo.getThumbnail());
		}

		
		sql += "temperature = ?, ";
		args.add(infoVo.getTemperature());

		sql += "rainfall = ?, ";
		args.add(infoVo.getRainfall());

		sql += "sport_info = ?, ";
		args.add(infoVo.getSport_info());

		sql += "mod_date = NOW() ";
		sql += "WHERE sport_name <> ? ";// 현재 값을 제외하고 업데이트
		args.add(infoVo.getSport_name());


		int result = -1;

		try {

			result = jdbcTemplate.update(sql, args.toArray());

		} catch (Exception e) {
			e.printStackTrace();

		}

		return result;

	}

	public int deleteSport(String sport_name) {

		String sql = "DELETE FROM info_sport " + "WHERE sport_name = ?";

		int result = -1;

		try {

			result = jdbcTemplate.update(sql, sport_name);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return result;

	}

	public List<InfoVo> showSport(InfoVo infoVo) {

		String sql = "SELECT * FROM info_sport";

		List<InfoVo> infoVos = new ArrayList<>();

		try {

			infoVos = jdbcTemplate.query(sql, new RowMapper<InfoVo>() {

				@Override
				public InfoVo mapRow(ResultSet rs, int rowNum) throws SQLException {

					InfoVo infoVo = new InfoVo();

					infoVo.setThumbnail(rs.getString("thumbnail"));
					infoVo.setSport_name(rs.getString("sport_name"));
					infoVo.setTemperature(rs.getString("temperature"));
					infoVo.setRainfall(rs.getString("rainfall"));
					infoVo.setSport_info(rs.getString("sport_info"));
					infoVo.setReg_date(rs.getString("reg_date"));
					infoVo.setMod_date(rs.getString("mod_date"));

					return infoVo;

				}

			}, "%" + infoVo.getSport_name() + "%");

		} catch (Exception e) {
			e.printStackTrace();

		}

		return infoVos;

	}

}
